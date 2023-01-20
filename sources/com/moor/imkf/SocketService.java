package com.moor.imkf;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import cn.thinkingdata.android.TDConfig;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.moor.imkf.db.dao.InfoDao;
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.db.dao.MsgUnReadCountDao;
import com.moor.imkf.event.KFSocketEvent;
import com.moor.imkf.event.LoginFailedEvent;
import com.moor.imkf.event.LoginKickedEvent;
import com.moor.imkf.event.LoginOffEvent;
import com.moor.imkf.event.LoginSuccessEvent;
import com.moor.imkf.event.MsgEvent;
import com.moor.imkf.event.ReLoginSuccessEvent;
import com.moor.imkf.event.ReSendMessage;
import com.moor.imkf.event.ServerErrorEvent;
import com.moor.imkf.event.TcpBreakEvent;
import com.moor.imkf.event.TcpConnectTimeoutEvent;
import com.moor.imkf.http.HttpManager;
import com.moor.imkf.lib.socket.websocket.SimpleListener;
import com.moor.imkf.lib.socket.websocket.SocketListener;
import com.moor.imkf.lib.socket.websocket.WebSocketHandler;
import com.moor.imkf.lib.socket.websocket.WebSocketSetting;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.listener.ChatListener;
import com.moor.imkf.listener.GetGlobleConfigListen;
import com.moor.imkf.listener.GetPeersListener;
import com.moor.imkf.listener.HttpResponseListener;
import com.moor.imkf.listener.OnSessionBeginListener;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.Peer;
import com.moor.imkf.model.entity.ScheduleConfig;
import com.moor.imkf.model.parser.HttpParser;
import com.moor.imkf.receiver.NetWorkReceiver;
import com.moor.imkf.requesturl.RequestUrl;
import com.moor.imkf.utils.MoorUtils;
import com.moor.imkf.utils.TimeUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import k.c.a.c;
import k.c.a.l;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SocketService extends Service {
    public static final int NOTICE_ID = 1001;
    public static boolean hasRelogin = false;
    private NotificationCompat.Builder builder;
    private NotificationChannel channel;
    private List<FromToMessage> fromToMessage;
    private WSHeartBeatManager heartBeatManager;
    private String largeMsgId;
    private Context mContext;
    public SocketListener socketListener = new SimpleListener() { // from class: com.moor.imkf.SocketService.1
        @Override // com.moor.imkf.lib.socket.websocket.SimpleListener, com.moor.imkf.lib.socket.websocket.SocketListener
        public void onConnectFailed(Throwable th) {
            c.f().q(new LoginFailedEvent());
        }

        @Override // com.moor.imkf.lib.socket.websocket.SimpleListener, com.moor.imkf.lib.socket.websocket.SocketListener
        public void onConnected() {
            Log.e("SocketService", "onConnected");
            SocketService.this.login();
        }

        @Override // com.moor.imkf.lib.socket.websocket.SimpleListener, com.moor.imkf.lib.socket.websocket.SocketListener
        public void onDisconnect() {
        }

        @Override // com.moor.imkf.lib.socket.websocket.SimpleListener, com.moor.imkf.lib.socket.websocket.SocketListener
        public <T> void onMessage(String str, T t) {
            Log.e("SocketService", "onMessagemessage" + str);
            try {
                SocketService socketService = SocketService.this;
                socketService.messageReceived(socketService, str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.moor.imkf.lib.socket.websocket.SimpleListener, com.moor.imkf.lib.socket.websocket.SocketListener
        public <T> void onMessage(ByteBuffer byteBuffer, T t) {
        }
    };
    private OnSessionBeginListener onSessionBeginListener = new OnSessionBeginListener() { // from class: com.moor.imkf.SocketService.6
        @Override // com.moor.imkf.listener.OnSessionBeginListener
        public void onFailed() {
        }

        @Override // com.moor.imkf.listener.OnSessionBeginListener
        public void onSuccess() {
            MoorLogUtils.aTag("SocketService,重连成功", new Object[0]);
        }
    };

    /* loaded from: classes2.dex */
    public class GetLargeMsgsResponseHandler implements HttpResponseListener {
        public GetLargeMsgsResponseHandler() {
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            String succeed = HttpParser.getSucceed(str);
            SocketService.this.largeMsgId = HttpParser.getLargeMsgId(str);
            boolean hasMoreMsgs = HttpParser.hasMoreMsgs(str);
            SocketService.this.fromToMessage.clear();
            if ("true".equals(succeed)) {
                SocketService.this.fromToMessage = HttpParser.getMsgs(str);
                MessageDao.getInstance().updateMsgsIdDao();
                MessageDao.getInstance().insertGetMsgsToDao(SocketService.this.fromToMessage);
                ArrayList<String> unReadDao = MessageDao.getInstance().getUnReadDao();
                String connectionId = InfoDao.getInstance().getConnectionId();
                SocketService socketService = SocketService.this;
                HttpManager.getMsg(connectionId, unReadDao, new getMsgAckResponseHandler(socketService));
                if (SocketService.this.fromToMessage.size() > 0) {
                    MessageDao.getInstance().updateMsgsIdDao();
                    Intent intent = new Intent(IMChatManager.NEW_MSG_ACTION);
                    intent.setComponent(new ComponentName(MoorUtils.getAppProcessName(), "com.m7.imkfsdk.receiver.NewMsgReceiver"));
                    intent.setPackage(SocketService.this.getPackageName());
                    SocketService.this.sendBroadcast(intent);
                }
                if (hasMoreMsgs) {
                    SocketService socketService2 = SocketService.this;
                    socketService2.getLargeMsgsFromNet(socketService2.largeMsgId);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class InnerService extends Service {
        public InnerService() {
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        @RequiresApi(api = 26)
        public void onCreate() {
            super.onCreate();
            if (SocketService.this.builder != null && SocketService.this.channel != null) {
                SocketService.this.builder.setAutoCancel(true).setOngoing(true);
                ((NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION)).createNotificationChannel(SocketService.this.channel);
                startForeground(1001, SocketService.this.builder.build());
            }
            stopSelf();
        }

        @Override // android.app.Service
        public void onDestroy() {
            super.onDestroy();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i2, int i3) {
            return 2;
        }
    }

    /* loaded from: classes2.dex */
    public class WSHeartBeatManager {
        private static final int MSG_UPDATE_INFO = 288;
        private Handler handler;
        private HandlerThread handlerThread;
        private int heartInterval = 30000;
        public boolean isConnected = false;

        public WSHeartBeatManager() {
            HandlerThread handlerThread = new HandlerThread("wsheart");
            this.handlerThread = handlerThread;
            handlerThread.start();
        }

        public void reset() {
            this.isConnected = false;
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeMessages(MSG_UPDATE_INFO);
            }
        }

        public void sendHeartBeatPacket() {
            try {
                if (WebSocketHandler.getDefault().isConnect()) {
                    WebSocketHandler.getDefault().send("3\n");
                }
            } catch (Exception unused) {
            }
        }

        public void setHeartInterval(int i2) {
            this.heartInterval = i2;
        }

        public void startHeartBeat() {
            this.isConnected = true;
            Handler handler = new Handler(this.handlerThread.getLooper()) { // from class: com.moor.imkf.SocketService.WSHeartBeatManager.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    WSHeartBeatManager wSHeartBeatManager = WSHeartBeatManager.this;
                    if (wSHeartBeatManager.isConnected) {
                        wSHeartBeatManager.sendHeartBeatPacket();
                        WSHeartBeatManager.this.handler.sendEmptyMessageDelayed(WSHeartBeatManager.MSG_UPDATE_INFO, WSHeartBeatManager.this.heartInterval);
                    }
                }
            };
            this.handler = handler;
            handler.sendEmptyMessage(MSG_UPDATE_INFO);
        }
    }

    /* loaded from: classes2.dex */
    public class getMsgAckResponseHandler implements HttpResponseListener {
        public Context context;

        public getMsgAckResponseHandler(Context context) {
            this.context = context;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class getMsgResponseHandler implements HttpResponseListener {
        public Context context;

        public getMsgResponseHandler(Context context) {
            this.context = context;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            String succeed = HttpParser.getSucceed(str);
            HttpParser.getMessage(str);
            boolean isLargeMsg = HttpParser.isLargeMsg(str);
            MoorLogUtils.aTag("receive", str);
            if ("true".equals(succeed)) {
                if (!isLargeMsg) {
                    SocketService.this.fromToMessage = HttpParser.getMsgs(str);
                    if (SocketService.this.fromToMessage == null || SocketService.this.fromToMessage.size() <= 0) {
                        return;
                    }
                    MsgUnReadCountDao.getInstance().setUnReadCount(IMChatManager.getInstance().getMsgUnReadType(), MsgUnReadCountDao.getInstance().getUnReadCount(IMChatManager.getInstance().getMsgUnReadType()) + SocketService.this.fromToMessage.size());
                    MessageDao.getInstance().updateMsgsIdDaoWithDraw();
                    MessageDao.getInstance().insertGetMsgsToDao(SocketService.this.fromToMessage);
                    HttpManager.getMsg(InfoDao.getInstance().getConnectionId(), MessageDao.getInstance().getUnReadDao(), new getMsgAckResponseHandler(this.context));
                    if (SocketService.this.fromToMessage.size() > 0) {
                        MessageDao.getInstance().updateMsgsIdDao();
                        Intent intent = new Intent(IMChatManager.NEW_MSG_ACTION);
                        intent.setComponent(new ComponentName(MoorUtils.getAppProcessName(), "com.m7.imkfsdk.receiver.NewMsgReceiver"));
                        intent.setPackage(this.context.getPackageName());
                        this.context.sendBroadcast(intent);
                        return;
                    }
                    return;
                }
                SocketService socketService = SocketService.this;
                socketService.getLargeMsgsFromNet(socketService.largeMsgId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginSession() {
        IMChatManager.getInstance().beginSession("", this.onSessionBeginListener);
        for (FromToMessage fromToMessage : MessageDao.getInstance().getSendingMessages()) {
            IMChat.getInstance().reSendMessage(fromToMessage, new ChatListener() { // from class: com.moor.imkf.SocketService.4
                @Override // com.moor.imkf.listener.ChatListener
                public void onFailed(String str) {
                    MoorLogUtils.eTag("SendMessage", str);
                    c.f().q(new ReSendMessage());
                }

                @Override // com.moor.imkf.listener.ChatListener
                public void onProgress(int i2) {
                    c.f().q(new ReSendMessage());
                }

                @Override // com.moor.imkf.listener.ChatListener
                public void onSuccess(String str) {
                    c.f().q(new ReSendMessage());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkScheduleChanged(ScheduleConfig scheduleConfig) {
        boolean z = scheduleConfig.getProcessId() != null && scheduleConfig.getProcessId().equals(IMChatManager.getInstance().processId);
        boolean z2 = scheduleConfig.getScheduleId() != null && scheduleConfig.getScheduleId().equals(IMChatManager.getInstance().scheduleId);
        return (scheduleConfig.getEntranceNode().get_id() != null && scheduleConfig.getEntranceNode().get_id().equals(IMChatManager.getInstance().entranceId)) && z && (scheduleConfig.getEntranceNode().getProcessTo() != null && scheduleConfig.getEntranceNode().getProcessTo().equals(IMChatManager.getInstance().currentNodeId)) && z2;
    }

    private void handlePeerChat() {
        IMChatManager.getInstance().getPeers(new GetPeersListener() { // from class: com.moor.imkf.SocketService.5
            @Override // com.moor.imkf.listener.GetPeersListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.GetPeersListener
            public void onSuccess(List<Peer> list) {
                for (Peer peer : list) {
                    if (peer.getId().equals(IMChatManager.getInstance().peerId)) {
                        MoorLogUtils.aTag("beginSession", "SocketService342行代码");
                        IMChatManager.getInstance().beginSession(peer.getId(), SocketService.this.onSessionBeginListener);
                        return;
                    }
                }
                SocketService.this.handleFinish();
            }
        });
    }

    private void handleScheduleChat() {
        IMChatManager.getInstance().getWebchatScheduleConfig(new GetGlobleConfigListen() { // from class: com.moor.imkf.SocketService.7
            @Override // com.moor.imkf.listener.GetGlobleConfigListen
            public void getPeers() {
            }

            @Override // com.moor.imkf.listener.GetGlobleConfigListen
            public void getSchedule(ScheduleConfig scheduleConfig) {
                if (SocketService.this.checkScheduleChanged(scheduleConfig)) {
                    IMChatManager.getInstance().beginScheduleSession(IMChatManager.getInstance().scheduleId, IMChatManager.getInstance().processId, IMChatManager.getInstance().currentNodeId, IMChatManager.getInstance().entranceId, SocketService.this.onSessionBeginListener);
                } else {
                    SocketService.this.handleFinish();
                }
            }
        });
    }

    private void initWebSocket() {
        if (WebSocketHandler.getDefault() != null) {
            WebSocketHandler.getDefault().disConnect();
        }
        WebSocketHandler.setNull();
        WebSocketSetting webSocketSetting = new WebSocketSetting();
        webSocketSetting.setConnectUrl(RequestUrl.BASE_SOCKET);
        webSocketSetting.setConnectTimeout(TDConfig.DEFAULT_FLUSH_INTERVAL);
        webSocketSetting.setReconnectFrequency(2);
        webSocketSetting.setReconnectWithNetworkChanged(false);
        WebSocketHandler.init(webSocketSetting).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        String str = IMChatManager.getInstance().get7moorLoginStr(this);
        MoorLogUtils.aTag("sendws:", str);
        WebSocketHandler.getDefault().send(str);
    }

    private void onNewMessageReceived() {
        HttpManager.getMsg(InfoDao.getInstance().getConnectionId(), MessageDao.getInstance().getUnReadDao(), new getMsgResponseHandler(this));
    }

    private synchronized void reLogin() {
        MoorLogUtils.eTag(TimeUtil.getCurrentTime() + "SocketService,执行重新登录方法, isRelogin is:isRelogin", new Object[0]);
        if (!WebSocketHandler.getDefault().isConnect()) {
            if (MoorUtils.isNetWorkConnected(IMChatManager.getInstance().getAppContext())) {
                hasRelogin = true;
                WebSocketHandler.getDefault().reconnect();
            } else {
                MoorLogUtils.eTag(TimeUtil.getCurrentTime() + "SocketService,执行重新登录方法, isRelogin is:isRelogin", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetWebSocket() {
        initWebSocket();
        initWSListener();
        this.heartBeatManager = new WSHeartBeatManager();
    }

    private void startInnerService() {
        startService(new Intent(this, InnerService.class));
    }

    public void changeSendingToFailed() {
        MessageDao.getInstance().updateSendMsgFail();
        c.f().q(new ReSendMessage());
    }

    public void getLargeMsgsFromNet(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        HttpManager.getLargeMsgs(InfoDao.getInstance().getConnectionId(), arrayList, new GetLargeMsgsResponseHandler());
    }

    public void handleFinish() {
        IMChatManager.getInstance().isFinishWhenReConnect = true;
        Intent intent = new Intent(IMChatManager.FINISH_ACTION);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    public void initWSListener() {
        WebSocketHandler.getDefault().addListener(this.socketListener);
    }

    public void loginOff() {
        WebSocketHandler.getDefault().send("quit\n");
        this.heartBeatManager.reset();
    }

    public void messageReceived(Context context, String str) throws Exception {
        YKFMsgManeger.getInstance(context).msgDispense(context, str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        if (IMChatManager.isUSE_ForegroundService() && Build.VERSION.SDK_INT >= 26) {
            setForegroundService();
        }
        if (!c.f().o(this)) {
            c.f().v(this);
        }
        NetWorkReceiver.registerReceiver(this.mContext);
        HttpManager.getSdkSocketServiceAddress(new HttpResponseListener() { // from class: com.moor.imkf.SocketService.2
            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                SocketService.this.resetWebSocket();
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                MoorLogUtils.aTag("ws:", str);
                try {
                    String optString = new JSONObject(str).optString("address", "");
                    if (!TextUtils.isEmpty(optString)) {
                        RequestUrl.BASE_SOCKET = "ws://" + optString + "/webSocket";
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                SocketService.this.resetWebSocket();
            }
        });
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        NetWorkReceiver.unRegisterReceiver(this);
        if (c.f().o(this)) {
            c.f().A(this);
        }
        try {
            WebSocketHandler.getDefault().removeListener(this.socketListener);
            WebSocketHandler.getDefault().disConnect();
        } catch (Exception unused) {
        }
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(LoginKickedEvent loginKickedEvent) {
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(LoginSuccessEvent loginSuccessEvent) {
        IMChatManager.getInstance().cancelInitTimer();
        MoorLogUtils.eTag(TimeUtil.getCurrentTime() + "SocketService,事件总线接收到loginSuccessEvent", new Object[0]);
        hasRelogin = false;
        this.heartBeatManager.startHeartBeat();
    }

    @TargetApi(26)
    public void setForegroundService() {
        NotificationChannel notificationChannel = new NotificationChannel("SocketService", "前台服务", 1);
        this.channel = notificationChannel;
        notificationChannel.setDescription("接受消息的服务");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "SocketService");
        this.builder = builder;
        builder.setAutoCancel(true).setOngoing(true);
        ((NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION)).createNotificationChannel(this.channel);
        startForeground(1001, this.builder.build());
        startInnerService();
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(LoginFailedEvent loginFailedEvent) {
        hasRelogin = false;
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(LoginOffEvent loginOffEvent) {
        loginOff();
        stopSelf();
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(ServerErrorEvent serverErrorEvent) {
        hasRelogin = false;
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(TcpConnectTimeoutEvent tcpConnectTimeoutEvent) {
        hasRelogin = false;
        reLogin();
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(TcpBreakEvent tcpBreakEvent) {
        MoorLogUtils.aTag("EventBus设置Break", new Object[0]);
        reLogin();
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(KFSocketEvent kFSocketEvent) {
        try {
            if (KFSocketEvent.NETWORK_OK.equals(kFSocketEvent)) {
                MoorLogUtils.eTag(TimeUtil.getCurrentTime() + "SocketService,事件总线接收到NetOkEvent", new Object[0]);
                MoorLogUtils.eTag("网络ok时Socket状态" + WebSocketHandler.getDefault().isConnect(), new Object[0]);
                if (WebSocketHandler.getDefault().isConnect()) {
                    MoorLogUtils.eTag("网络ok时Socket 不是closed状态", new Object[0]);
                } else {
                    reLogin();
                }
            } else if (KFSocketEvent.NETWORK_DOWN.equals(kFSocketEvent)) {
                MoorLogUtils.eTag("SocketService,net break", new Object[0]);
                hasRelogin = false;
            }
        } catch (Exception unused) {
        }
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(ReLoginSuccessEvent reLoginSuccessEvent) {
        MoorLogUtils.aTag("ReLoginSuccessEvent,执行重连了", new Object[0]);
        if (!IMChatManager.getInstance().isManual) {
            String str = IMChatManager.getInstance().chatType;
            if (str.equals("peer")) {
                handlePeerChat();
                return;
            } else if (str.equals(YKFConstants.TYPE_SCHEDULE)) {
                handleScheduleChat();
                return;
            } else {
                return;
            }
        }
        HttpManager.getChatSession(new HttpResponseListener() { // from class: com.moor.imkf.SocketService.3
            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str2) {
                if (HttpParser.getIsChatExist(str2)) {
                    SocketService.this.beginSession();
                    MoorLogUtils.aTag("beginSession", "SocketService318行代码");
                    return;
                }
                SocketService.this.handleFinish();
                SocketService.this.changeSendingToFailed();
            }
        });
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MsgEvent msgEvent) {
        onNewMessageReceived();
    }
}
