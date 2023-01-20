package com.tencent.android.tpns.mqtt;

import com.jihuanshe.base.ext.BinderKt;
import com.moor.imkf.event.VoiceToTextEvent;
import com.moor.imkf.lib.socket.java_websocket.WebSocketImpl;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.internal.ConnectActionListener;
import com.tencent.android.tpns.mqtt.internal.DisconnectedMessageBuffer;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import com.tencent.android.tpns.mqtt.internal.NetworkModule;
import com.tencent.android.tpns.mqtt.internal.SSLNetworkModule;
import com.tencent.android.tpns.mqtt.internal.TCPNetworkModule;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import com.tencent.android.tpns.mqtt.internal.websocket.WebSocketNetworkModule;
import com.tencent.android.tpns.mqtt.internal.websocket.WebSocketSecureNetworkModule;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingReq;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubscribe;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.android.tpns.mqtt.persist.MemoryPersistence;
import com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence;
import com.tencent.android.tpns.mqtt.util.Debug;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import e.l.r.i0;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class MqttAsyncClient implements IMqttAsyncClient {
    private static final String CLASS_NAME = "MqttAsyncClient";
    private static final String CLIENT_ID_PREFIX = "paho";
    private static final long DISCONNECT_TIMEOUT = 10000;
    private static final char MAX_HIGH_SURROGATE = 56319;
    private static final char MIN_HIGH_SURROGATE = 55296;
    private static final long QUIESCE_TIMEOUT = 30000;
    private static final String TAG = "MqttAsyncClient";
    private String clientId;
    public ClientComms comms;
    private MqttConnectOptions connOpts;
    private ScheduledExecutorService executorService;
    private MqttCallback mqttCallback;
    private MqttClientPersistence persistence;
    private Timer reconnectTimer;
    private boolean reconnecting;
    private String serverURI;
    private Hashtable topics;
    private Object userContext;
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, "MqttAsyncClient");
    private static int reconnectDelay = 1000;
    private static Object clientLock = new Object();

    /* loaded from: classes3.dex */
    public class MqttReconnectActionListener implements IMqttActionListener {
        public final String methodName;

        public MqttReconnectActionListener(String str) {
            this.methodName = str;
        }

        private void rescheduleReconnectCycle(int i2) {
            MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName + ":rescheduleReconnectCycle", "505", new Object[]{MqttAsyncClient.this.clientId, String.valueOf(MqttAsyncClient.reconnectDelay)});
            synchronized (MqttAsyncClient.clientLock) {
                if (MqttAsyncClient.this.connOpts.isAutomaticReconnect()) {
                    if (MqttAsyncClient.this.reconnectTimer != null) {
                        MqttAsyncClient.this.reconnectTimer.schedule(new ReconnectTask(), i2);
                    } else {
                        int unused = MqttAsyncClient.reconnectDelay = i2;
                        MqttAsyncClient.this.startReconnectCycle();
                    }
                }
            }
        }

        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
        public void onFailure(IMqttToken iMqttToken, Throwable th) {
            MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName, "502", new Object[]{iMqttToken.getClient().getClientId()});
            if (MqttAsyncClient.reconnectDelay < 128000) {
                MqttAsyncClient.reconnectDelay *= 2;
            }
            rescheduleReconnectCycle(MqttAsyncClient.reconnectDelay);
        }

        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
        public void onSuccess(IMqttToken iMqttToken) {
            MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName, "501", new Object[]{iMqttToken.getClient().getClientId()});
            MqttAsyncClient.this.comms.setRestingState(false);
            MqttAsyncClient.this.stopReconnectCycle();
        }
    }

    /* loaded from: classes3.dex */
    public class MqttReconnectCallback implements MqttCallbackExtended {
        public final boolean automaticReconnect;

        public MqttReconnectCallback(boolean z) {
            this.automaticReconnect = z;
        }

        @Override // com.tencent.android.tpns.mqtt.MqttCallbackExtended
        public void connectComplete(boolean z, String str) {
        }

        @Override // com.tencent.android.tpns.mqtt.MqttCallback
        public void connectionLost(Throwable th) {
            if (this.automaticReconnect) {
                MqttAsyncClient.this.comms.setRestingState(true);
                MqttAsyncClient.this.reconnecting = true;
                MqttAsyncClient.this.startReconnectCycle();
            }
        }

        @Override // com.tencent.android.tpns.mqtt.MqttCallback
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        }

        @Override // com.tencent.android.tpns.mqtt.MqttCallback
        public void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
        }
    }

    /* loaded from: classes3.dex */
    public class ReconnectTask extends TimerTask {
        private static final String methodName = "ReconnectTask.run";

        private ReconnectTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MqttAsyncClient.log.fine("MqttAsyncClient", methodName, "506");
            MqttAsyncClient.this.attemptReconnect();
        }
    }

    public MqttAsyncClient(String str, String str2) throws MqttException {
        this(str, str2, new MqttDefaultFilePersistence());
    }

    public static boolean Character_isHighSurrogate(char c2) {
        return c2 >= 55296 && c2 <= 56319;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attemptReconnect() {
        log.fine("MqttAsyncClient", "attemptReconnect", VoiceToTextEvent.STATUS_FAIL, new Object[]{this.clientId});
        try {
            connect(this.connOpts, this.userContext, new MqttReconnectActionListener("attemptReconnect"));
        } catch (MqttSecurityException e2) {
            log.fine("MqttAsyncClient", "attemptReconnect", "804", null, e2);
        } catch (MqttException e3) {
            TBaseLogger.e("MqttAsyncClient", "attemptReconnect", e3);
        }
    }

    private NetworkModule createNetworkModule(String str, MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        SSLSocketFactoryFactory sSLSocketFactoryFactory;
        String[] enabledCipherSuites;
        SSLSocketFactoryFactory sSLSocketFactoryFactory2;
        String[] enabledCipherSuites2;
        Logger logger = log;
        logger.fine("MqttAsyncClient", "createNetworkModule", "115", new Object[]{str});
        SocketFactory socketFactory = mqttConnectOptions.getSocketFactory();
        int validateURI = MqttConnectOptions.validateURI(str);
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null && str.contains("_")) {
                try {
                    Field declaredField = URI.class.getDeclaredField(ReportItem.RequestKeyHost);
                    declaredField.setAccessible(true);
                    declaredField.set(uri, getHostName(str.substring(uri.getScheme().length() + 3)));
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e2) {
                    throw ExceptionHelper.createMqttException(e2.getCause());
                }
            }
            String host = uri.getHost();
            int port = uri.getPort();
            if (validateURI == 0) {
                if (port == -1) {
                    port = 1883;
                }
                if (socketFactory == null) {
                    socketFactory = SocketFactory.getDefault();
                } else if (socketFactory instanceof SSLSocketFactory) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                TCPNetworkModule tCPNetworkModule = new TCPNetworkModule(socketFactory, host, port, this.clientId);
                tCPNetworkModule.setConnectTimeout(mqttConnectOptions.getConnectionTimeout());
                return tCPNetworkModule;
            } else if (validateURI == 1) {
                if (port == -1) {
                    port = 8883;
                }
                if (socketFactory == null) {
                    sSLSocketFactoryFactory = new SSLSocketFactoryFactory();
                    Properties sSLProperties = mqttConnectOptions.getSSLProperties();
                    if (sSLProperties != null) {
                        sSLSocketFactoryFactory.initialize(sSLProperties, null);
                    }
                    socketFactory = sSLSocketFactoryFactory.createSocketFactory(null);
                } else if (!(socketFactory instanceof SSLSocketFactory)) {
                    throw ExceptionHelper.createMqttException(32105);
                } else {
                    sSLSocketFactoryFactory = null;
                }
                SSLNetworkModule sSLNetworkModule = new SSLNetworkModule((SSLSocketFactory) socketFactory, host, port, this.clientId);
                sSLNetworkModule.setSSLhandshakeTimeout(mqttConnectOptions.getConnectionTimeout());
                sSLNetworkModule.setSSLHostnameVerifier(mqttConnectOptions.getSSLHostnameVerifier());
                if (sSLSocketFactoryFactory != null && (enabledCipherSuites = sSLSocketFactoryFactory.getEnabledCipherSuites(null)) != null) {
                    sSLNetworkModule.setEnabledCiphers(enabledCipherSuites);
                }
                return sSLNetworkModule;
            } else if (validateURI == 3) {
                int i2 = port == -1 ? 80 : port;
                if (socketFactory == null) {
                    socketFactory = SocketFactory.getDefault();
                } else if (socketFactory instanceof SSLSocketFactory) {
                    throw ExceptionHelper.createMqttException(32105);
                }
                WebSocketNetworkModule webSocketNetworkModule = new WebSocketNetworkModule(socketFactory, str, host, i2, this.clientId);
                webSocketNetworkModule.setConnectTimeout(mqttConnectOptions.getConnectionTimeout());
                return webSocketNetworkModule;
            } else if (validateURI != 4) {
                logger.fine("MqttAsyncClient", "createNetworkModule", "119", new Object[]{str});
                return null;
            } else {
                int i3 = port == -1 ? WebSocketImpl.DEFAULT_WSS_PORT : port;
                if (socketFactory == null) {
                    SSLSocketFactoryFactory sSLSocketFactoryFactory3 = new SSLSocketFactoryFactory();
                    Properties sSLProperties2 = mqttConnectOptions.getSSLProperties();
                    if (sSLProperties2 != null) {
                        sSLSocketFactoryFactory3.initialize(sSLProperties2, null);
                    }
                    socketFactory = sSLSocketFactoryFactory3.createSocketFactory(null);
                    sSLSocketFactoryFactory2 = sSLSocketFactoryFactory3;
                } else if (!(socketFactory instanceof SSLSocketFactory)) {
                    throw ExceptionHelper.createMqttException(32105);
                } else {
                    sSLSocketFactoryFactory2 = null;
                }
                WebSocketSecureNetworkModule webSocketSecureNetworkModule = new WebSocketSecureNetworkModule((SSLSocketFactory) socketFactory, str, host, i3, this.clientId);
                webSocketSecureNetworkModule.setSSLhandshakeTimeout(mqttConnectOptions.getConnectionTimeout());
                if (sSLSocketFactoryFactory2 != null && (enabledCipherSuites2 = sSLSocketFactoryFactory2.getEnabledCipherSuites(null)) != null) {
                    webSocketSecureNetworkModule.setEnabledCiphers(enabledCipherSuites2);
                }
                return webSocketSecureNetworkModule;
            }
        } catch (URISyntaxException e3) {
            throw new IllegalArgumentException("Malformed URI: " + str + ", " + e3.getMessage());
        }
    }

    public static String generateClientId() {
        return CLIENT_ID_PREFIX + System.nanoTime();
    }

    private String getHostName(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            indexOf = str.indexOf(47);
        }
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReconnectCycle() {
        log.fine("MqttAsyncClient", "startReconnectCycle", "503", new Object[]{this.clientId, new Long(reconnectDelay)});
        Timer timer = new Timer("MQTT Reconnect: " + this.clientId);
        this.reconnectTimer = timer;
        timer.schedule(new ReconnectTask(), (long) reconnectDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopReconnectCycle() {
        log.fine("MqttAsyncClient", "stopReconnectCycle", "504", new Object[]{this.clientId});
        synchronized (clientLock) {
            if (this.connOpts.isAutomaticReconnect()) {
                Timer timer = this.reconnectTimer;
                if (timer != null) {
                    timer.cancel();
                    this.reconnectTimer = null;
                }
                reconnectDelay = 1000;
            }
        }
    }

    public IMqttToken checkPing(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        log.fine("MqttAsyncClient", "ping", "117");
        return null;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void close() throws MqttException {
        close(false);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken connect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException {
        return connect(new MqttConnectOptions(), obj, iMqttActionListener);
    }

    public NetworkModule[] createNetworkModules(String str, MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        log.fine("MqttAsyncClient", "createNetworkModules", "116", new Object[]{str});
        String[] serverURIs = mqttConnectOptions.getServerURIs();
        if (serverURIs == null) {
            serverURIs = new String[]{str};
        } else if (serverURIs.length == 0) {
            serverURIs = new String[]{str};
        }
        NetworkModule[] networkModuleArr = new NetworkModule[serverURIs.length];
        for (int i2 = 0; i2 < serverURIs.length; i2++) {
            networkModuleArr[i2] = createNetworkModule(serverURIs[i2], mqttConnectOptions);
        }
        log.fine("MqttAsyncClient", "createNetworkModules", "108");
        return networkModuleArr;
    }

    public void deleteBufferedMessage(int i2) {
        this.comms.deleteBufferedMessage(i2);
    }

    public void destroy() throws MqttException {
        close(true);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken disconnect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return disconnect(30000L, obj, iMqttActionListener);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void disconnectForcibly() throws MqttException {
        disconnectForcibly(30000L, 10000L);
    }

    public MqttMessage getBufferedMessage(int i2) {
        return this.comms.getBufferedMessage(i2);
    }

    public int getBufferedMessageCount() {
        return this.comms.getBufferedMessageCount();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public String getClientId() {
        return this.clientId;
    }

    public String getCurrentServerURI() {
        return this.comms.getNetworkModules()[this.comms.getNetworkModuleIndex()].getServerURI();
    }

    public Debug getDebug() {
        return new Debug(this.clientId, this.comms);
    }

    public int getInFlightMessageCount() {
        return this.comms.getActualInFlight();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.comms.getPendingDeliveryTokens();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public String getServerURI() {
        return this.serverURI;
    }

    public MqttTopic getTopic(String str) {
        MqttTopic.validate(str, false);
        MqttTopic mqttTopic = (MqttTopic) this.topics.get(str);
        if (mqttTopic == null) {
            MqttTopic mqttTopic2 = new MqttTopic(str, this.comms);
            this.topics.put(str, mqttTopic2);
            return mqttTopic2;
        }
        return mqttTopic;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public boolean isConnected() {
        return this.comms.isConnected();
    }

    public boolean isConnecting() {
        return this.comms.isConnecting();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void messageArrivedComplete(int i2, int i3) throws MqttException {
        this.comms.messageArrivedComplete(i2, i3);
    }

    public MqttToken ping(IMqttActionListener iMqttActionListener) throws MqttException {
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        this.comms.sendNoWait(new MqttPingReq(), mqttToken);
        return mqttToken;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken publish(String str, byte[] bArr, int i2, boolean z, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i2);
        mqttMessage.setRetained(z);
        return publish(str, mqttMessage, obj, iMqttActionListener);
    }

    public void reconnect() throws MqttException {
        log.fine("MqttAsyncClient", "reconnect", VoiceToTextEvent.STATUS_FAIL, new Object[]{this.clientId});
        if (!this.comms.isConnected()) {
            if (!this.comms.isConnecting()) {
                if (!this.comms.isDisconnecting()) {
                    if (!this.comms.isClosed()) {
                        stopReconnectCycle();
                        attemptReconnect();
                        return;
                    }
                    throw new MqttException(32111);
                }
                throw new MqttException(32102);
            }
            throw new MqttException(32110);
        }
        throw ExceptionHelper.createMqttException(32100);
    }

    public void setBufferOpts(DisconnectedBufferOptions disconnectedBufferOptions) {
        this.comms.setDisconnectedMessageBuffer(new DisconnectedMessageBuffer(disconnectedBufferOptions));
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void setCallback(MqttCallback mqttCallback) {
        this.mqttCallback = mqttCallback;
        this.comms.setCallback(mqttCallback);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void setManualAcks(boolean z) {
        this.comms.setManualAcks(z);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String str, int i2, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i2}, obj, iMqttActionListener);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken unsubscribe(String str, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        return unsubscribe(new String[]{str}, obj, iMqttActionListener);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence) throws MqttException {
        this(str, str2, mqttClientPersistence, new TimerPingSender());
    }

    public void close(boolean z) throws MqttException {
        Logger logger = log;
        logger.fine("MqttAsyncClient", "close", "113");
        this.comms.close(z);
        logger.fine("MqttAsyncClient", "close", "114");
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken connect() throws MqttException, MqttSecurityException {
        return connect(null, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken disconnect() throws MqttException {
        return disconnect(null, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void disconnectForcibly(long j2) throws MqttException {
        disconnectForcibly(30000L, j2);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String str, int i2) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i2}, (Object) null, (IMqttActionListener) null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken unsubscribe(String str) throws MqttException {
        return unsubscribe(new String[]{str}, (Object) null, (IMqttActionListener) null);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender) throws MqttException {
        this(str, str2, mqttClientPersistence, mqttPingSender, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken connect(MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException {
        return connect(mqttConnectOptions, null, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken disconnect(long j2) throws MqttException {
        return disconnect(j2, null, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public void disconnectForcibly(long j2, long j3) throws MqttException {
        this.comms.disconnectForcibly(j2, j3);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String[] strArr, int[] iArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken unsubscribe(String[] strArr) throws MqttException {
        return unsubscribe(strArr, (Object) null, (IMqttActionListener) null);
    }

    public MqttAsyncClient(String str, String str2, MqttClientPersistence mqttClientPersistence, MqttPingSender mqttPingSender, ScheduledExecutorService scheduledExecutorService) throws MqttException {
        this.reconnecting = false;
        TBaseLogger.d("MqttAsyncClient", "init MqttAsyncClient");
        log.setResourceName(str2);
        if (str2 != null) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < str2.length() - 1) {
                if (Character_isHighSurrogate(str2.charAt(i2))) {
                    i2++;
                }
                i3++;
                i2++;
            }
            if (i3 <= 65535) {
                MqttConnectOptions.validateURI(str);
                this.serverURI = str;
                this.clientId = str2;
                this.persistence = mqttClientPersistence;
                if (mqttClientPersistence == null) {
                    this.persistence = new MemoryPersistence();
                }
                this.executorService = scheduledExecutorService;
                if (scheduledExecutorService == null) {
                    this.executorService = Executors.newScheduledThreadPool(10);
                }
                log.fine("MqttAsyncClient", "MqttAsyncClient", "101", new Object[]{str2, str, mqttClientPersistence});
                this.persistence.open(str2, str);
                this.comms = new ClientComms(this, this.persistence, mqttPingSender, this.executorService);
                this.persistence.close();
                this.topics = new Hashtable();
                return;
            }
            throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        throw new IllegalArgumentException("Null clientId");
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken connect(MqttConnectOptions mqttConnectOptions, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException {
        if (!this.comms.isConnected()) {
            if (!this.comms.isConnecting()) {
                if (!this.comms.isDisconnecting()) {
                    if (!this.comms.isClosed()) {
                        if (mqttConnectOptions == null) {
                            mqttConnectOptions = new MqttConnectOptions();
                        }
                        MqttConnectOptions mqttConnectOptions2 = mqttConnectOptions;
                        this.connOpts = mqttConnectOptions2;
                        this.userContext = obj;
                        boolean isAutomaticReconnect = mqttConnectOptions2.isAutomaticReconnect();
                        Logger logger = log;
                        Object[] objArr = new Object[8];
                        objArr[0] = Boolean.valueOf(mqttConnectOptions2.isCleanSession());
                        objArr[1] = new Integer(mqttConnectOptions2.getConnectionTimeout());
                        objArr[2] = new Integer(mqttConnectOptions2.getKeepAliveInterval());
                        objArr[3] = mqttConnectOptions2.getUserName();
                        objArr[4] = mqttConnectOptions2.getPassword() == null ? "[null]" : "[notnull]";
                        objArr[5] = mqttConnectOptions2.getWillMessage() != null ? "[notnull]" : "[null]";
                        objArr[6] = obj;
                        objArr[7] = iMqttActionListener;
                        logger.fine("MqttAsyncClient", "connect", "103", objArr);
                        this.comms.setNetworkModules(createNetworkModules(this.serverURI, mqttConnectOptions2));
                        this.comms.setReconnectCallback(new MqttReconnectCallback(isAutomaticReconnect));
                        MqttToken mqttToken = new MqttToken(getClientId());
                        ConnectActionListener connectActionListener = new ConnectActionListener(this, this.persistence, this.comms, mqttConnectOptions2, mqttToken, obj, iMqttActionListener, this.reconnecting);
                        mqttToken.setActionCallback(connectActionListener);
                        mqttToken.setUserContext(this);
                        MqttCallback mqttCallback = this.mqttCallback;
                        if (mqttCallback instanceof MqttCallbackExtended) {
                            connectActionListener.setMqttCallbackExtended((MqttCallbackExtended) mqttCallback);
                        }
                        this.comms.setNetworkModuleIndex(0);
                        connectActionListener.connect();
                        return mqttToken;
                    }
                    throw new MqttException(32111);
                }
                throw new MqttException(32102);
            }
            throw new MqttException(32110);
        }
        throw ExceptionHelper.createMqttException(32100);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken disconnect(long j2, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        mqttToken.setUserContext(obj);
        this.comms.disconnect(new MqttDisconnect(), j2, mqttToken);
        log.fine("MqttAsyncClient", i0.f14288g, "108");
        return mqttToken;
    }

    public void disconnectForcibly(long j2, long j3, boolean z) throws MqttException {
        this.comms.disconnectForcibly(j2, j3, z);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        TBaseLogger.d("MqttAsyncClient", "action - subscribe");
        if (strArr.length == iArr.length) {
            for (String str : strArr) {
                this.comms.removeMessageListener(str);
            }
            if (log.isLoggable(5)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (i2 > 0) {
                        stringBuffer.append(", ");
                    }
                    stringBuffer.append("topic=");
                    stringBuffer.append(strArr[i2]);
                    stringBuffer.append(" qos=");
                    stringBuffer.append(iArr[i2]);
                    MqttTopic.validate(strArr[i2], true);
                }
                log.fine("MqttAsyncClient", "subscribe", "106", new Object[]{stringBuffer.toString(), obj, iMqttActionListener});
            }
            MqttToken mqttToken = new MqttToken(getClientId());
            mqttToken.setActionCallback(iMqttActionListener);
            mqttToken.setUserContext(obj);
            mqttToken.internalTok.setTopics(strArr);
            this.comms.sendNoWait(new MqttSubscribe(strArr, iArr), mqttToken);
            log.fine("MqttAsyncClient", "subscribe", "109");
            return mqttToken;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken unsubscribe(String[] strArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException {
        if (log.isLoggable(5)) {
            String str = "";
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 > 0) {
                    str = str + ", ";
                }
                str = str + strArr[i2];
            }
            log.fine("MqttAsyncClient", "unsubscribe", "107", new Object[]{str, obj, iMqttActionListener});
        }
        for (String str2 : strArr) {
            MqttTopic.validate(str2, true);
        }
        for (String str3 : strArr) {
            this.comms.removeMessageListener(str3);
        }
        MqttToken mqttToken = new MqttToken(getClientId());
        mqttToken.setActionCallback(iMqttActionListener);
        mqttToken.setUserContext(obj);
        mqttToken.internalTok.setTopics(strArr);
        this.comms.sendNoWait(new MqttUnsubscribe(strArr), mqttToken);
        log.fine("MqttAsyncClient", "unsubscribe", "110");
        return mqttToken;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken publish(String str, byte[] bArr, int i2, boolean z) throws MqttException, MqttPersistenceException {
        return publish(str, bArr, i2, z, null, null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage) throws MqttException, MqttPersistenceException {
        return publish(str, mqttMessage, (Object) null, (IMqttActionListener) null);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttDeliveryToken publish(String str, MqttMessage mqttMessage, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException {
        Logger logger = log;
        logger.fine("MqttAsyncClient", "publish", "111", new Object[]{str, obj, iMqttActionListener});
        MqttTopic.validate(str, false);
        MqttDeliveryToken mqttDeliveryToken = new MqttDeliveryToken(getClientId());
        mqttDeliveryToken.setActionCallback(iMqttActionListener);
        mqttDeliveryToken.setUserContext(obj);
        mqttDeliveryToken.setMessage(mqttMessage);
        mqttDeliveryToken.internalTok.setTopics(new String[]{str});
        MqttPublish mqttPublish = new MqttPublish(str, mqttMessage);
        TBaseLogger.d("MqttAsyncClient", "action - publish, message is MqttPublish");
        this.comms.sendNoWait(mqttPublish, mqttDeliveryToken);
        logger.fine("MqttAsyncClient", "publish", BinderKt.b);
        return mqttDeliveryToken;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String str, int i2, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i2}, obj, iMqttActionListener, new IMqttMessageListener[]{iMqttMessageListener});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String str, int i2, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribe(new String[]{str}, new int[]{i2}, (Object) null, (IMqttActionListener) null, new IMqttMessageListener[]{iMqttMessageListener});
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        return subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null, iMqttMessageListenerArr);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttAsyncClient
    public IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        if (iMqttMessageListenerArr.length == iArr.length && iArr.length == strArr.length) {
            IMqttToken subscribe = subscribe(strArr, iArr, obj, iMqttActionListener);
            for (int i2 = 0; i2 < strArr.length; i2++) {
                this.comms.setMessageListener(strArr[i2], iMqttMessageListenerArr[i2]);
            }
            return subscribe;
        }
        throw new IllegalArgumentException();
    }
}
