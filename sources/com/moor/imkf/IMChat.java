package com.moor.imkf;

import android.text.TextUtils;
import android.util.Log;
import com.moor.imkf.db.dao.InfoDao;
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.http.HttpManager;
import com.moor.imkf.lib.socket.websocket.WebSocketHandler;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.moor.imkf.listener.ChatListener;
import com.moor.imkf.listener.HttpResponseListener;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.parser.HttpParser;
import com.moor.imkf.requesturl.RequestUrl;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.Recorder;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.bugly.Bugly;
import com.vector.util.IntentAction;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class IMChat {
    private static IMChat instance = new IMChat();
    public String connectionId = "";
    private String sessionId = "";
    private String botId = "";
    private String cateIds = "";
    private String robotId = "";
    private String robotType = "";
    private boolean isBotsatisfaOn = false;
    private boolean isLianXiangOn = false;
    private boolean isHumanLianXiangOn = false;
    private String Newinvestigate = "";
    private boolean isCancel = false;
    private Recorder recorder = null;

    /* loaded from: classes2.dex */
    public static class NewMessageResponseHandler implements HttpResponseListener {
        public ChatListener chatListener;
        public FromToMessage fromToMessage;

        public NewMessageResponseHandler(FromToMessage fromToMessage, ChatListener chatListener) {
            this.fromToMessage = fromToMessage;
            this.chatListener = chatListener;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            MessageDao.getInstance().updateFailedMsgToDao(this.fromToMessage);
            ChatListener chatListener = this.chatListener;
            if (chatListener != null) {
                chatListener.onFailed("1005");
            }
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            String succeed = HttpParser.getSucceed(str);
            String httpMsg = HttpParser.getHttpMsg(str);
            if (TextUtils.isEmpty(httpMsg)) {
                httpMsg = "";
            }
            MoorLogUtils.aTag("消息发送返回：", str);
            if ("true".equals(succeed)) {
                long when = HttpParser.getWhen(str);
                String content = HttpParser.getContent(str);
                if (!WebSocketHandler.getDefault().isConnect()) {
                    MessageDao.getInstance().updateSendingMsgToDao(this.fromToMessage);
                    return;
                }
                MessageDao.getInstance().updateSucceedMsgToDao(this.fromToMessage, when, MoorNullUtil.checkNull(content));
                ChatListener chatListener = this.chatListener;
                if (chatListener != null) {
                    chatListener.onSuccess(httpMsg);
                    return;
                }
                return;
            }
            MessageDao.getInstance().updateFailedMsgToDao(this.fromToMessage);
            ChatListener chatListener2 = this.chatListener;
            if (chatListener2 != null) {
                chatListener2.onFailed(httpMsg);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class UploadFileResponseHandler implements HttpResponseListener {
        public ChatListener chatListener;
        public String fileType;
        public FromToMessage fromToMessage;

        public UploadFileResponseHandler(String str, FromToMessage fromToMessage, ChatListener chatListener) {
            this.fileType = "";
            this.fileType = str;
            this.fromToMessage = fromToMessage;
            this.chatListener = chatListener;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            MessageDao.getInstance().updateFailedMsgToDao(this.fromToMessage);
            ChatListener chatListener = this.chatListener;
            if (chatListener != null) {
                chatListener.onFailed("1005");
            }
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            final String str2;
            String str3;
            String[] strArr;
            if ("true".equals(HttpParser.getSucceed(str))) {
                String upToken = HttpParser.getUpToken(str);
                Configuration.Builder putThreshold = new Configuration.Builder().putThreshold(209715200);
                if (!TextUtils.isEmpty(RequestUrl.QINIU_HTTP) && (strArr = RequestUrl.FILE_DOMAINS) != null && strArr.length > 0) {
                    putThreshold.zone(new FixedZone(RequestUrl.FILE_DOMAINS));
                    putThreshold.useHttps(RequestUrl.IS_FILE_HTTPS);
                }
                UploadManager uploadManager = new UploadManager(putThreshold.build());
                String format = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss").format(new Date());
                if (IntentAction.o.f7891j.equals(this.fileType)) {
                    str3 = "kefu/image/" + format + MqttTopic.TOPIC_LEVEL_SEPARATOR + System.currentTimeMillis() + MqttTopic.TOPIC_LEVEL_SEPARATOR + UUID.randomUUID().toString();
                } else if ("ly".equals(this.fileType)) {
                    str3 = "kefu/sound/" + format + MqttTopic.TOPIC_LEVEL_SEPARATOR + System.currentTimeMillis() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "";
                } else if (!"file".equals(this.fileType)) {
                    str2 = "";
                    IMChat.this.isCancel = false;
                    uploadManager.put(this.fromToMessage.filePath, str2, upToken, new UpCompletionHandler() { // from class: com.moor.imkf.IMChat.UploadFileResponseHandler.1
                        @Override // com.qiniu.android.storage.UpCompletionHandler
                        public void complete(String str4, ResponseInfo responseInfo, JSONObject jSONObject) {
                            if (responseInfo.isOK()) {
                                if ("file".equals(UploadFileResponseHandler.this.fileType)) {
                                    FromToMessage fromToMessage = UploadFileResponseHandler.this.fromToMessage;
                                    fromToMessage.message = RequestUrl.QINIU_HTTP + str2 + "?fileName=" + UploadFileResponseHandler.this.fromToMessage.fileName + "?fileSize=" + UploadFileResponseHandler.this.fromToMessage.fileSize;
                                } else {
                                    FromToMessage fromToMessage2 = UploadFileResponseHandler.this.fromToMessage;
                                    fromToMessage2.message = RequestUrl.QINIU_HTTP + str2;
                                }
                                if ("ly".equals(UploadFileResponseHandler.this.fileType) && UploadFileResponseHandler.this.fromToMessage.isRobot) {
                                    MessageDao.getInstance().updateMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                                    UploadFileResponseHandler.this.chatListener.onSuccess(responseInfo.error);
                                    return;
                                }
                                MessageDao.getInstance().updateMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                                String connectionId = InfoDao.getInstance().getConnectionId();
                                UploadFileResponseHandler uploadFileResponseHandler = UploadFileResponseHandler.this;
                                FromToMessage fromToMessage3 = uploadFileResponseHandler.fromToMessage;
                                HttpManager.newMsgToServer(connectionId, fromToMessage3, new NewMessageResponseHandler(fromToMessage3, uploadFileResponseHandler.chatListener));
                                return;
                            }
                            MessageDao.getInstance().updateFailedMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                            ChatListener chatListener = UploadFileResponseHandler.this.chatListener;
                            if (chatListener != null) {
                                chatListener.onFailed(responseInfo.error);
                            }
                        }
                    }, new UploadOptions(null, null, false, new UpProgressHandler() { // from class: com.moor.imkf.IMChat.UploadFileResponseHandler.2
                        @Override // com.qiniu.android.storage.UpProgressHandler
                        public void progress(String str4, double d2) {
                            int i2 = (int) (d2 * 100.0d);
                            if ("file".equals(UploadFileResponseHandler.this.fileType) && i2 % 5 == 0) {
                                UploadFileResponseHandler.this.fromToMessage.fileProgress = Integer.valueOf(i2);
                                MessageDao.getInstance().updateMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                            }
                            UploadFileResponseHandler.this.chatListener.onProgress(i2);
                        }
                    }, new UpCancellationSignal() { // from class: com.moor.imkf.IMChat.UploadFileResponseHandler.3
                        @Override // com.qiniu.android.http.CancellationHandler
                        public boolean isCancelled() {
                            if (IMChat.this.isCancel) {
                                MessageDao.getInstance().updateFailedMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                            }
                            return IMChat.this.isCancel;
                        }
                    }));
                    return;
                } else {
                    str3 = "kefu/file/" + format + MqttTopic.TOPIC_LEVEL_SEPARATOR + System.currentTimeMillis() + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.fromToMessage.fileName;
                }
                str2 = str3;
                IMChat.this.isCancel = false;
                uploadManager.put(this.fromToMessage.filePath, str2, upToken, new UpCompletionHandler() { // from class: com.moor.imkf.IMChat.UploadFileResponseHandler.1
                    @Override // com.qiniu.android.storage.UpCompletionHandler
                    public void complete(String str4, ResponseInfo responseInfo, JSONObject jSONObject) {
                        if (responseInfo.isOK()) {
                            if ("file".equals(UploadFileResponseHandler.this.fileType)) {
                                FromToMessage fromToMessage = UploadFileResponseHandler.this.fromToMessage;
                                fromToMessage.message = RequestUrl.QINIU_HTTP + str2 + "?fileName=" + UploadFileResponseHandler.this.fromToMessage.fileName + "?fileSize=" + UploadFileResponseHandler.this.fromToMessage.fileSize;
                            } else {
                                FromToMessage fromToMessage2 = UploadFileResponseHandler.this.fromToMessage;
                                fromToMessage2.message = RequestUrl.QINIU_HTTP + str2;
                            }
                            if ("ly".equals(UploadFileResponseHandler.this.fileType) && UploadFileResponseHandler.this.fromToMessage.isRobot) {
                                MessageDao.getInstance().updateMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                                UploadFileResponseHandler.this.chatListener.onSuccess(responseInfo.error);
                                return;
                            }
                            MessageDao.getInstance().updateMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                            String connectionId = InfoDao.getInstance().getConnectionId();
                            UploadFileResponseHandler uploadFileResponseHandler = UploadFileResponseHandler.this;
                            FromToMessage fromToMessage3 = uploadFileResponseHandler.fromToMessage;
                            HttpManager.newMsgToServer(connectionId, fromToMessage3, new NewMessageResponseHandler(fromToMessage3, uploadFileResponseHandler.chatListener));
                            return;
                        }
                        MessageDao.getInstance().updateFailedMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                        ChatListener chatListener = UploadFileResponseHandler.this.chatListener;
                        if (chatListener != null) {
                            chatListener.onFailed(responseInfo.error);
                        }
                    }
                }, new UploadOptions(null, null, false, new UpProgressHandler() { // from class: com.moor.imkf.IMChat.UploadFileResponseHandler.2
                    @Override // com.qiniu.android.storage.UpProgressHandler
                    public void progress(String str4, double d2) {
                        int i2 = (int) (d2 * 100.0d);
                        if ("file".equals(UploadFileResponseHandler.this.fileType) && i2 % 5 == 0) {
                            UploadFileResponseHandler.this.fromToMessage.fileProgress = Integer.valueOf(i2);
                            MessageDao.getInstance().updateMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                        }
                        UploadFileResponseHandler.this.chatListener.onProgress(i2);
                    }
                }, new UpCancellationSignal() { // from class: com.moor.imkf.IMChat.UploadFileResponseHandler.3
                    @Override // com.qiniu.android.http.CancellationHandler
                    public boolean isCancelled() {
                        if (IMChat.this.isCancel) {
                            MessageDao.getInstance().updateFailedMsgToDao(UploadFileResponseHandler.this.fromToMessage);
                        }
                        return IMChat.this.isCancel;
                    }
                }));
                return;
            }
            MessageDao.getInstance().updateFailedMsgToDao(this.fromToMessage);
            ChatListener chatListener = this.chatListener;
            if (chatListener != null) {
                chatListener.onFailed("1005");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class UploadOnlyXbotFormFileResponseHandler implements HttpResponseListener {
        private String filePath;
        private String fileSize;
        private onXbotFormUpFileListener onXbotFormUpFileListener;

        public UploadOnlyXbotFormFileResponseHandler(String str, String str2, onXbotFormUpFileListener onxbotformupfilelistener) {
            this.filePath = str;
            this.fileSize = str2;
            this.onXbotFormUpFileListener = onxbotformupfilelistener;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            onXbotFormUpFileListener onxbotformupfilelistener = this.onXbotFormUpFileListener;
            if (onxbotformupfilelistener != null) {
                onxbotformupfilelistener.onFailed(this.filePath);
            }
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            String[] strArr;
            if ("true".equals(HttpParser.getSucceed(str))) {
                String upToken = HttpParser.getUpToken(str);
                Configuration.Builder putThreshold = new Configuration.Builder().putThreshold(209715200);
                if (!TextUtils.isEmpty(RequestUrl.QINIU_HTTP) && (strArr = RequestUrl.FILE_DOMAINS) != null && strArr.length > 0) {
                    putThreshold.zone(new FixedZone(RequestUrl.FILE_DOMAINS));
                    putThreshold.useHttps(RequestUrl.IS_FILE_HTTPS);
                }
                UploadManager uploadManager = new UploadManager(putThreshold.build());
                IMChat.this.isCancel = false;
                String str2 = this.filePath;
                final String str3 = "xbotForm/file/" + new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss").format(new Date()) + MqttTopic.TOPIC_LEVEL_SEPARATOR + System.currentTimeMillis() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2;
                uploadManager.put(this.filePath, str3, upToken, new UpCompletionHandler() { // from class: com.moor.imkf.IMChat.UploadOnlyXbotFormFileResponseHandler.1
                    @Override // com.qiniu.android.storage.UpCompletionHandler
                    public void complete(String str4, ResponseInfo responseInfo, JSONObject jSONObject) {
                        if (!responseInfo.isOK()) {
                            if (UploadOnlyXbotFormFileResponseHandler.this.onXbotFormUpFileListener != null) {
                                onXbotFormUpFileListener onxbotformupfilelistener = UploadOnlyXbotFormFileResponseHandler.this.onXbotFormUpFileListener;
                                onxbotformupfilelistener.onFailed(UploadOnlyXbotFormFileResponseHandler.this.filePath + responseInfo.error);
                                return;
                            }
                            return;
                        }
                        UploadOnlyXbotFormFileResponseHandler.this.onXbotFormUpFileListener.onisOK(RequestUrl.QINIU_HTTP + str3);
                    }
                }, new UploadOptions(null, null, false, new UpProgressHandler() { // from class: com.moor.imkf.IMChat.UploadOnlyXbotFormFileResponseHandler.2
                    @Override // com.qiniu.android.storage.UpProgressHandler
                    public void progress(String str4, double d2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append(": ");
                        int i2 = (int) (d2 * 100.0d);
                        sb.append(i2);
                        Log.i("qiniu", sb.toString());
                        if (i2 % 2 == 0) {
                            UploadOnlyXbotFormFileResponseHandler.this.onXbotFormUpFileListener.onUpLoading(i2);
                        }
                    }
                }, new UpCancellationSignal() { // from class: com.moor.imkf.IMChat.UploadOnlyXbotFormFileResponseHandler.3
                    @Override // com.qiniu.android.http.CancellationHandler
                    public boolean isCancelled() {
                        if (IMChat.this.isCancel) {
                            UploadOnlyXbotFormFileResponseHandler.this.onXbotFormUpFileListener.onFailed("setCancel");
                        }
                        return IMChat.this.isCancel;
                    }
                }));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface onXbotFormUpFileListener {
        void onFailed(String str);

        void onUpLoading(int i2);

        void onisOK(String str);
    }

    private IMChat() {
    }

    public static IMChat getInstance() {
        return instance;
    }

    public void createBreakTipMsg(String str) {
        if (str == null || "".equals(str.trim())) {
            return;
        }
        MessageDao.getInstance().insertMsgToDao(IMMessage.createBreakTipMessage(str));
    }

    public String getBotId() {
        return this.botId;
    }

    public boolean getBotsatisfaOn() {
        return this.isBotsatisfaOn;
    }

    public String getCateId() {
        return this.cateIds;
    }

    public boolean getLianXiangOn() {
        return this.isLianXiangOn;
    }

    public String getNewinvestigate() {
        return this.Newinvestigate;
    }

    public String getRobotId() {
        return this.robotId;
    }

    public String getRobotType() {
        return this.robotType;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String get_id() {
        return InfoDao.getInstance().getImServiceNo();
    }

    public boolean isHumanLianXiangOn() {
        return this.isHumanLianXiangOn;
    }

    public void reSendMessage(FromToMessage fromToMessage, ChatListener chatListener) {
        this.connectionId = InfoDao.getInstance().getConnectionId();
        if (!fromToMessage.msgType.equals("text") && !fromToMessage.msgType.equals(FromToMessage.MSG_TYPE_CARDINFO) && !fromToMessage.msgType.equals(FromToMessage.MSG_TYPE_NEW_CARD_INFO)) {
            if (fromToMessage.msgType.equals("voice")) {
                fromToMessage.sendState = "sending";
                MessageDao.getInstance().updateMsgToDao(fromToMessage);
                HttpManager.getQiNiuToken(InfoDao.getInstance().getConnectionId(), fromToMessage.filePath, new UploadFileResponseHandler("ly", fromToMessage, chatListener));
                return;
            } else if (fromToMessage.msgType.equals(FromToMessage.MSG_TYPE_IMAGE)) {
                fromToMessage.sendState = "sending";
                MessageDao.getInstance().updateMsgToDao(fromToMessage);
                HttpManager.getQiNiuToken(InfoDao.getInstance().getConnectionId(), fromToMessage.filePath, new UploadFileResponseHandler(IntentAction.o.f7891j, fromToMessage, chatListener));
                return;
            } else if (fromToMessage.msgType.equals("file")) {
                fromToMessage.sendState = "sending";
                MessageDao.getInstance().updateMsgToDao(fromToMessage);
                HttpManager.getQiNiuToken(InfoDao.getInstance().getConnectionId(), fromToMessage.filePath, new UploadFileResponseHandler("file", fromToMessage, chatListener));
                return;
            } else {
                return;
            }
        }
        fromToMessage.sendState = "sending";
        MessageDao.getInstance().updateMsgToDao(fromToMessage);
        HttpManager.newMsgToServer(this.connectionId, fromToMessage, new NewMessageResponseHandler(fromToMessage, chatListener));
    }

    public void sendMessage(FromToMessage fromToMessage, ChatListener chatListener) {
        fromToMessage.dealUserMsg = Bugly.SDK_IS_DEV;
        this.connectionId = InfoDao.getInstance().getConnectionId();
        if (!fromToMessage.msgType.equals("text") && !fromToMessage.msgType.equals(FromToMessage.MSG_TYPE_CARDINFO) && !fromToMessage.msgType.equals(FromToMessage.MSG_TYPE_NEW_CARD_INFO) && !fromToMessage.msgType.equals(FromToMessage.MSG_TYPE_LOGISTICS_INFO_LIST) && !fromToMessage.msgType.equals(FromToMessage.MSG_TYPE_XBOT_FORM_SUBMIT)) {
            if (fromToMessage.msgType.equals("voice")) {
                fromToMessage.sendState = "sending";
                MessageDao.getInstance().insertSendMsgsToDao(fromToMessage);
                MoorLogUtils.aTag("sendmsg", "send 001");
                HttpManager.getQiNiuToken(this.connectionId, fromToMessage.filePath, new UploadFileResponseHandler("ly", fromToMessage, chatListener));
                return;
            } else if (fromToMessage.msgType.equals(FromToMessage.MSG_TYPE_IMAGE)) {
                fromToMessage.sendState = "sending";
                MessageDao.getInstance().insertSendMsgsToDao(fromToMessage);
                HttpManager.getQiNiuToken(this.connectionId, fromToMessage.filePath, new UploadFileResponseHandler(IntentAction.o.f7891j, fromToMessage, chatListener));
                return;
            } else if (fromToMessage.msgType.equals("file")) {
                fromToMessage.sendState = "sending";
                MessageDao.getInstance().insertSendMsgsToDao(fromToMessage);
                HttpManager.getQiNiuToken(this.connectionId, fromToMessage.filePath, new UploadFileResponseHandler("file", fromToMessage, chatListener));
                return;
            } else {
                return;
            }
        }
        fromToMessage.sendState = "sending";
        MessageDao.getInstance().insertSendMsgsToDao(fromToMessage);
        HttpManager.newMsgToServer(this.connectionId, fromToMessage, new NewMessageResponseHandler(fromToMessage, chatListener));
    }

    public void sendQuestionMsg(String str, String str2, FromToMessage fromToMessage, ChatListener chatListener) {
        this.connectionId = InfoDao.getInstance().getConnectionId();
        if (fromToMessage.msgType.equals("text")) {
            fromToMessage.sendState = "sending";
            fromToMessage.dealUserMsg = Bugly.SDK_IS_DEV;
            MessageDao.getInstance().insertSendMsgsToDao(fromToMessage);
            HttpManager.sendQuestionMsg(str, str2, new NewMessageResponseHandler(fromToMessage, chatListener));
        }
    }

    public void setBotId(String str) {
        this.botId = str;
    }

    public void setBotsatisfaOn(boolean z) {
        this.isBotsatisfaOn = z;
    }

    public void setCancel(boolean z) {
        this.isCancel = z;
    }

    public void setCateId(String str) {
        this.cateIds = str;
    }

    public void setHumanLianXiangOn(boolean z) {
        this.isHumanLianXiangOn = z;
    }

    public void setLianXiangOn(boolean z) {
        this.isLianXiangOn = z;
    }

    public void setNewinvestigate(String str) {
        this.Newinvestigate = str;
    }

    public void setRobotId(String str) {
        this.robotId = str;
    }

    public void setRobotType(String str) {
        this.robotType = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void upLoadXbotFromFile(String str, String str2, onXbotFormUpFileListener onxbotformupfilelistener) {
        String connectionId = InfoDao.getInstance().getConnectionId();
        this.connectionId = connectionId;
        HttpManager.getQiNiuToken(connectionId, str, new UploadOnlyXbotFormFileResponseHandler(str, str2, onxbotformupfilelistener));
    }
}
