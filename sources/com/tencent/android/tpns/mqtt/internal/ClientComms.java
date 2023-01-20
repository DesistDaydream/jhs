package com.tencent.android.tpns.mqtt.internal;

import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.tencent.android.tpns.mqtt.BufferedMessage;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.IMqttMessageListener;
import com.tencent.android.tpns.mqtt.MqttCallback;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttConnectOptions;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.MqttPingSender;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.TTask;
import e.l.r.i0;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ClientComms {
    public static String BUILD_LEVEL = "L${build.level}";
    private static final String CLASS_NAME = "ClientComms";
    private static final byte CLOSED = 4;
    private static final byte CONNECTED = 0;
    private static final byte CONNECTING = 1;
    private static final byte DISCONNECTED = 3;
    private static final byte DISCONNECTING = 2;
    private static final String TAG = "ClientComms";
    public static String VERSION = "${project.version}";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, "ClientComms");
    private CommsCallback callback;
    private IMqttAsyncClient client;
    private ClientState clientState;
    private MqttConnectOptions conOptions;
    private byte conState;
    private DisconnectedMessageBuffer disconnectedMessageBuffer;
    private ExecutorService executorService;
    private int networkModuleIndex;
    private NetworkModule[] networkModules;
    private MqttClientPersistence persistence;
    private MqttPingSender pingSender;
    private CommsReceiver receiver;
    private CommsSender sender;
    private CommsTokenStore tokenStore;
    private boolean stoppingComms = false;
    private Object conLock = new Object();
    private boolean closePending = false;
    private boolean resting = false;

    /* loaded from: classes3.dex */
    public class ConnectBG extends TTask {
        public ClientComms clientComms;
        public MqttConnect conPacket;
        public MqttToken conToken;
        private String threadName;

        public ConnectBG(ClientComms clientComms, MqttToken mqttToken, MqttConnect mqttConnect, ExecutorService executorService) {
            ClientComms.this = r1;
            this.clientComms = null;
            this.clientComms = clientComms;
            this.conToken = mqttToken;
            this.conPacket = mqttConnect;
            this.threadName = "MQTT Con: " + r1.getClient().getClientId();
        }

        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            TBaseLogger.dd("ClientComms", "ConnectBG mqtt thread");
            Thread.currentThread().setName(this.threadName);
            ClientComms.log.fine("ClientComms", "connectBG:run", "220");
            MqttException e2 = null;
            try {
                for (MqttDeliveryToken mqttDeliveryToken : ClientComms.this.tokenStore.getOutstandingDelTokens()) {
                    mqttDeliveryToken.internalTok.setException(null);
                }
                ClientComms.this.tokenStore.saveToken(this.conToken, this.conPacket);
                NetworkModule networkModule = ClientComms.this.networkModules[ClientComms.this.networkModuleIndex];
                networkModule.start();
                ClientComms.this.receiver = new CommsReceiver(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getInputStream());
                ClientComms.this.receiver.start("MQTT Rec: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.sender = new CommsSender(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getOutputStream());
                ClientComms.this.sender.start("MQTT Snd: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.callback.start("MQTT Call: " + ClientComms.this.getClient().getClientId(), ClientComms.this.executorService);
                ClientComms.this.internalSend(this.conPacket, this.conToken);
            } catch (MqttException e3) {
                e2 = e3;
                ClientComms.log.fine("ClientComms", "connectBG:run", "212", null, e2);
            } catch (Throwable th) {
                ClientComms.log.fine("ClientComms", "connectBG:run", "209", null, th);
                e2 = ExceptionHelper.createMqttException(th);
            }
            if (e2 != null) {
                ClientComms.this.shutdownConnection(this.conToken, e2);
            }
        }

        public void start() {
            ClientComms.this.executorService.execute(this);
        }
    }

    /* loaded from: classes3.dex */
    public class DisconnectBG extends TTask {
        public MqttDisconnect disconnect;
        public long quiesceTimeout;
        private String threadName;
        public MqttToken token;

        public DisconnectBG(MqttDisconnect mqttDisconnect, long j2, MqttToken mqttToken, ExecutorService executorService) {
            ClientComms.this = r1;
            this.disconnect = mqttDisconnect;
            this.quiesceTimeout = j2;
            this.token = mqttToken;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.android.tpns.mqtt.MqttException, com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage] */
        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            Thread.currentThread().setName(this.threadName);
            ClientComms.log.fine("ClientComms", "disconnectBG:run", "221");
            TBaseLogger.i("disconnectBG:run", "disconnectBG:run");
            ClientComms.this.clientState.quiesce(this.quiesceTimeout);
            try {
                ClientComms.this.internalSend(this.disconnect, this.token);
                this.token.internalTok.waitUntilSent();
            } finally {
                try {
                } finally {
                }
            }
        }

        public void start() {
            this.threadName = "MQTT Disc: " + ClientComms.this.getClient().getClientId();
            ClientComms.this.executorService.execute(this);
        }
    }

    /* loaded from: classes3.dex */
    public class ReconnectDisconnectedBufferCallback implements IDisconnectedBufferCallback {
        public final String methodName;

        public ReconnectDisconnectedBufferCallback(String str) {
            ClientComms.this = r1;
            this.methodName = str;
        }

        @Override // com.tencent.android.tpns.mqtt.internal.IDisconnectedBufferCallback
        public void publishBufferedMessage(BufferedMessage bufferedMessage) throws MqttException {
            if (ClientComms.this.isConnected()) {
                while (ClientComms.this.clientState.getActualInFlight() >= ClientComms.this.clientState.getMaxInFlight() - 1) {
                    Thread.yield();
                }
                ClientComms.log.fine("ClientComms", this.methodName, "510", new Object[]{bufferedMessage.getMessage().getKey()});
                ClientComms.this.internalSend(bufferedMessage.getMessage(), bufferedMessage.getToken());
                ClientComms.this.clientState.unPersistBufferedMessage(bufferedMessage.getMessage());
                return;
            }
            ClientComms.log.fine("ClientComms", this.methodName, "208");
            throw ExceptionHelper.createMqttException(32104);
        }
    }

    public ClientComms(IMqttAsyncClient iMqttAsyncClient, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender, ExecutorService executorService) throws MqttException {
        this.conState = (byte) 3;
        TBaseLogger.d("ClientComms", "init ClientComms");
        this.conState = (byte) 3;
        this.client = iMqttAsyncClient;
        this.persistence = mqttClientPersistence;
        this.pingSender = mqttPingSender;
        if (mqttPingSender != null) {
            mqttPingSender.init(this);
        }
        this.executorService = executorService;
        this.tokenStore = new CommsTokenStore(getClient().getClientId());
        this.callback = new CommsCallback(this);
        ClientState clientState = new ClientState(mqttClientPersistence, this.tokenStore, this.callback, this, mqttPingSender);
        this.clientState = clientState;
        this.callback.setClientState(clientState);
        log.setResourceName(getClient().getClientId());
    }

    private MqttToken handleOldTokens(MqttToken mqttToken, MqttException mqttException) {
        log.fine("ClientComms", "handleOldTokens", "222");
        MqttToken mqttToken2 = null;
        if (mqttToken != null) {
            try {
                if (this.tokenStore.getToken(mqttToken.internalTok.getKey()) == null) {
                    this.tokenStore.saveToken(mqttToken, mqttToken.internalTok.getKey());
                }
            } catch (Exception unused) {
            }
        }
        Enumeration elements = this.clientState.resolveOldTokens(mqttException).elements();
        while (elements.hasMoreElements()) {
            MqttToken mqttToken3 = (MqttToken) elements.nextElement();
            if (!mqttToken3.internalTok.getKey().equals(MqttDisconnect.KEY) && !mqttToken3.internalTok.getKey().equals("Con")) {
                CommsCallback commsCallback = this.callback;
                if (commsCallback != null) {
                    commsCallback.asyncOperationComplete(mqttToken3);
                }
            }
            mqttToken2 = mqttToken3;
        }
        return mqttToken2;
    }

    private void handleRunException(Exception exc) {
        MqttException mqttException;
        log.fine("ClientComms", "handleRunException", "804", null, exc);
        if (!(exc instanceof MqttException)) {
            mqttException = new MqttException(32109, exc);
        } else {
            mqttException = (MqttException) exc;
        }
        shutdownConnection(null, mqttException);
    }

    private void shutdownExecutorService() {
        this.executorService.shutdown();
        try {
            ExecutorService executorService = this.executorService;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (executorService.awaitTermination(1L, timeUnit)) {
                return;
            }
            this.executorService.shutdownNow();
            if (this.executorService.awaitTermination(1L, timeUnit)) {
                return;
            }
            log.fine("ClientComms", "shutdownExecutorService", "executorService did not terminate");
        } catch (InterruptedException unused) {
            this.executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public MqttToken checkForActivity() {
        return checkForActivity(null);
    }

    public void close(boolean z) throws MqttException {
        synchronized (this.conLock) {
            if (!isClosed()) {
                if (!isDisconnected() || z) {
                    log.fine("ClientComms", "close", "224");
                    if (isConnecting()) {
                        TBaseLogger.e("ClientComms", "close when is isConnecting");
                    } else if (isConnected()) {
                        TBaseLogger.e("ClientComms", "close when is isConnected");
                    } else if (isDisconnecting()) {
                        this.closePending = true;
                    }
                }
                this.conState = (byte) 4;
                shutdownExecutorService();
                this.clientState.close();
                this.clientState = null;
                this.callback = null;
                this.persistence = null;
                this.sender = null;
                this.pingSender = null;
                this.receiver = null;
                this.networkModules = null;
                this.conOptions = null;
                this.tokenStore = null;
            }
        }
    }

    public void connect(MqttConnectOptions mqttConnectOptions, MqttToken mqttToken) throws MqttException {
        synchronized (this.conLock) {
            if (isDisconnected() && !this.closePending) {
                log.fine("ClientComms", "connect", "214");
                this.conState = (byte) 1;
                this.conOptions = mqttConnectOptions;
                MqttConnect mqttConnect = new MqttConnect(this.client.getClientId(), this.conOptions.getMqttVersion(), this.conOptions.isCleanSession(), this.conOptions.getKeepAliveInterval(), this.conOptions.getUserName(), this.conOptions.getPassword(), this.conOptions.getWillMessage(), this.conOptions.getWillDestination());
                this.clientState.setKeepAliveSecs(this.conOptions.getKeepAliveInterval());
                this.clientState.setCleanSession(this.conOptions.isCleanSession());
                this.clientState.setMaxInflight(this.conOptions.getMaxInflight());
                this.tokenStore.open();
                new ConnectBG(this, mqttToken, mqttConnect, this.executorService).start();
            } else {
                log.fine("ClientComms", "connect", "207", new Object[]{new Byte(this.conState)});
                if (!isClosed() && !this.closePending) {
                    if (!isConnecting()) {
                        if (isDisconnecting()) {
                            throw new MqttException(32102);
                        }
                        throw ExceptionHelper.createMqttException(32100);
                    }
                    throw new MqttException(32110);
                }
                throw new MqttException(32111);
            }
        }
    }

    public void connectComplete(MqttConnack mqttConnack, MqttException mqttException) throws MqttException {
        int returnCode = mqttConnack.getReturnCode();
        synchronized (this.conLock) {
            if (returnCode == 0) {
                log.fine("ClientComms", "connectComplete", "215");
                this.conState = (byte) 0;
                return;
            }
            log.fine("ClientComms", "connectComplete", "204", new Object[]{new Integer(returnCode)});
            if (mqttException != null) {
                throw mqttException;
            }
        }
    }

    public void deleteBufferedMessage(int i2) {
        this.disconnectedMessageBuffer.deleteMessage(i2);
    }

    public void deliveryComplete(MqttPublish mqttPublish) throws MqttPersistenceException {
        this.clientState.deliveryComplete(mqttPublish);
    }

    public void disconnect(MqttDisconnect mqttDisconnect, long j2, MqttToken mqttToken) throws MqttException {
        synchronized (this.conLock) {
            if (!isClosed()) {
                if (!isDisconnected()) {
                    if (!isDisconnecting()) {
                        if (Thread.currentThread() == this.callback.getThread()) {
                            log.fine("ClientComms", i0.f14288g, "210");
                        }
                        log.fine("ClientComms", i0.f14288g, "218");
                        this.conState = (byte) 2;
                        new DisconnectBG(mqttDisconnect, j2, mqttToken, this.executorService).start();
                    } else {
                        log.fine("ClientComms", i0.f14288g, "219");
                        throw ExceptionHelper.createMqttException(32102);
                    }
                } else {
                    log.fine("ClientComms", i0.f14288g, "211");
                    throw ExceptionHelper.createMqttException(32101);
                }
            } else {
                log.fine("ClientComms", i0.f14288g, "223");
                throw ExceptionHelper.createMqttException(32111);
            }
        }
    }

    public void disconnectForcibly(long j2, long j3) throws MqttException {
        disconnectForcibly(j2, j3, true);
    }

    public int getActualInFlight() {
        return this.clientState.getActualInFlight();
    }

    public MqttMessage getBufferedMessage(int i2) {
        return ((MqttPublish) this.disconnectedMessageBuffer.getMessage(i2).getMessage()).getMessage();
    }

    public int getBufferedMessageCount() {
        return this.disconnectedMessageBuffer.getMessageCount();
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    public ClientState getClientState() {
        return this.clientState;
    }

    public MqttConnectOptions getConOptions() {
        return this.conOptions;
    }

    public Properties getDebug() {
        Properties properties = new Properties();
        properties.put("conState", new Integer(this.conState));
        properties.put("serverURI", getClient().getServerURI());
        properties.put("callback", this.callback);
        properties.put("stoppingComms", new Boolean(this.stoppingComms));
        return properties;
    }

    public long getKeepAlive() {
        return this.clientState.getKeepAlive();
    }

    public int getNetworkModuleIndex() {
        return this.networkModuleIndex;
    }

    public NetworkModule[] getNetworkModules() {
        return this.networkModules;
    }

    public MqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.tokenStore.getOutstandingDelTokens();
    }

    public CommsReceiver getReceiver() {
        return this.receiver;
    }

    public MqttTopic getTopic(String str) {
        return new MqttTopic(str, this);
    }

    public void internalSend(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        TBaseLogger.d("ClientComms", "action - internalSend");
        Logger logger = log;
        logger.fine("ClientComms", "internalSend", BasicPushStatus.SUCCESS_CODE, new Object[]{mqttWireMessage.getKey(), mqttWireMessage, mqttToken});
        if (mqttToken.getClient() == null) {
            mqttToken.internalTok.setClient(getClient());
            ClientState clientState = this.clientState;
            if (clientState != null) {
                try {
                    clientState.send(mqttWireMessage, mqttToken);
                    return;
                } catch (MqttException e2) {
                    if (mqttWireMessage instanceof MqttPublish) {
                        this.clientState.undo((MqttPublish) mqttWireMessage);
                    }
                    throw e2;
                }
            }
            return;
        }
        logger.fine("ClientComms", "internalSend", "213", new Object[]{mqttWireMessage.getKey(), mqttWireMessage, mqttToken});
        throw new MqttException(32201);
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 4;
        }
        return z;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 0;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.conLock) {
            z = true;
            if (this.conState != 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean isDisconnected() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 3;
        }
        return z;
    }

    public boolean isDisconnecting() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 2;
        }
        return z;
    }

    public boolean isResting() {
        boolean z;
        synchronized (this.conLock) {
            z = this.resting;
        }
        return z;
    }

    public void messageArrivedComplete(int i2, int i3) throws MqttException {
        this.callback.messageArrivedComplete(i2, i3);
    }

    public void notifyConnect() {
        if (this.disconnectedMessageBuffer != null) {
            log.fine("ClientComms", "notifyConnect", "509");
            this.disconnectedMessageBuffer.setPublishCallback(new ReconnectDisconnectedBufferCallback("notifyConnect"));
            this.executorService.execute(this.disconnectedMessageBuffer);
        }
    }

    public void removeMessageListener(String str) {
        this.callback.removeMessageListener(str);
    }

    public void sendNoWait(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        if (!isConnected() && ((isConnected() || !(mqttWireMessage instanceof MqttConnect)) && (!isDisconnecting() || !(mqttWireMessage instanceof MqttDisconnect)))) {
            if (this.disconnectedMessageBuffer != null) {
                log.fine("ClientComms", "sendNoWait", "508", new Object[]{mqttWireMessage.getKey()});
                if (this.disconnectedMessageBuffer.isPersistBuffer()) {
                    this.clientState.persistBufferedMessage(mqttWireMessage);
                }
                this.disconnectedMessageBuffer.putMessage(mqttWireMessage, mqttToken);
                return;
            }
            log.fine("ClientComms", "sendNoWait", "208");
            throw ExceptionHelper.createMqttException(32104);
        }
        DisconnectedMessageBuffer disconnectedMessageBuffer = this.disconnectedMessageBuffer;
        if (disconnectedMessageBuffer != null && disconnectedMessageBuffer.getMessageCount() != 0) {
            log.fine("ClientComms", "sendNoWait", "507", new Object[]{mqttWireMessage.getKey()});
            if (this.disconnectedMessageBuffer.isPersistBuffer()) {
                this.clientState.persistBufferedMessage(mqttWireMessage);
            }
            this.disconnectedMessageBuffer.putMessage(mqttWireMessage, mqttToken);
            return;
        }
        internalSend(mqttWireMessage, mqttToken);
    }

    public void setCallback(MqttCallback mqttCallback) {
        CommsCallback commsCallback = this.callback;
        if (commsCallback != null) {
            commsCallback.setCallback(mqttCallback);
        }
    }

    public void setDisconnectedMessageBuffer(DisconnectedMessageBuffer disconnectedMessageBuffer) {
        this.disconnectedMessageBuffer = disconnectedMessageBuffer;
    }

    public void setManualAcks(boolean z) {
        this.callback.setManualAcks(z);
    }

    public void setMessageListener(String str, IMqttMessageListener iMqttMessageListener) {
        this.callback.setMessageListener(str, iMqttMessageListener);
    }

    public void setNetworkModuleIndex(int i2) {
        this.networkModuleIndex = i2;
    }

    public void setNetworkModules(NetworkModule[] networkModuleArr) {
        this.networkModules = networkModuleArr;
    }

    public void setReconnectCallback(MqttCallbackExtended mqttCallbackExtended) {
        this.callback.setReconnectCallback(mqttCallbackExtended);
    }

    public void setRestingState(boolean z) {
        this.resting = z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:11|(33:16|17|18|(1:22)|23|(1:25)|26|(1:28)|29|30|(1:34)|36|37|38|(1:42)|44|(1:46)|47|(1:49)|50|51|(1:55)|57|a1|(1:63)(1:90)|64|(1:66)|67|(1:69)|(1:73)|74|ce|80)|98|17|18|(2:20|22)|23|(0)|26|(0)|29|30|(2:32|34)|36|37|38|(2:40|42)|44|(0)|47|(0)|50|51|(2:53|55)|57|a1) */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void shutdownConnection(com.tencent.android.tpns.mqtt.MqttToken r9, com.tencent.android.tpns.mqtt.MqttException r10) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.ClientComms.shutdownConnection(com.tencent.android.tpns.mqtt.MqttToken, com.tencent.android.tpns.mqtt.MqttException):void");
    }

    public MqttToken checkForActivity(IMqttActionListener iMqttActionListener) {
        try {
            return this.clientState.checkForActivity(iMqttActionListener);
        } catch (MqttException e2) {
            handleRunException(e2);
            return null;
        } catch (Exception e3) {
            handleRunException(e3);
            return null;
        }
    }

    public void deliveryComplete(int i2) throws MqttPersistenceException {
        this.clientState.deliveryComplete(i2);
    }

    public void disconnectForcibly(long j2, long j3, boolean z) throws MqttException {
        ClientState clientState = this.clientState;
        if (clientState != null) {
            clientState.quiesce(j2);
        }
        MqttToken mqttToken = new MqttToken(this.client.getClientId());
        if (z) {
            try {
                internalSend(new MqttDisconnect(), mqttToken);
                mqttToken.waitForCompletion(j3);
            } catch (Throwable unused) {
            }
        }
        mqttToken.internalTok.markComplete(null, null);
        shutdownConnection(mqttToken, null);
    }
}
