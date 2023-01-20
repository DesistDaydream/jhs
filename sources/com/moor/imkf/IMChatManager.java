package com.moor.imkf;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.gson.Gson;
import com.moor.imkf.db.dao.GlobalSetDao;
import com.moor.imkf.db.dao.InfoDao;
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.db.dao.MsgUnReadCountDao;
import com.moor.imkf.event.LoginFailedEvent;
import com.moor.imkf.event.LoginOffEvent;
import com.moor.imkf.event.LoginSuccessEvent;
import com.moor.imkf.event.QuitVideoEvent;
import com.moor.imkf.http.HttpManager;
import com.moor.imkf.lib.MoorBaseLibManager;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.moor.imkf.lib.listener.MoorSocketReceivedListener;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.listener.AcceptOtherAgentListener;
import com.moor.imkf.listener.AcceptVideoListener;
import com.moor.imkf.listener.GetGlobleConfigListen;
import com.moor.imkf.listener.GetPeersListener;
import com.moor.imkf.listener.HttpResponseListener;
import com.moor.imkf.listener.InitListener;
import com.moor.imkf.listener.OfflineListener;
import com.moor.imkf.listener.OnConvertManualListener;
import com.moor.imkf.listener.OnLeaveMsgConfigListener;
import com.moor.imkf.listener.OnSessionBeginListener;
import com.moor.imkf.listener.OnSubmitOfflineMessageListener;
import com.moor.imkf.listener.PushVideoListener;
import com.moor.imkf.listener.RefuseVideoListener;
import com.moor.imkf.listener.SubmitInvestigateListener;
import com.moor.imkf.listener.onResponseListener;
import com.moor.imkf.model.entity.CardInfo;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.GlobalSet;
import com.moor.imkf.model.entity.Info;
import com.moor.imkf.model.entity.Investigate;
import com.moor.imkf.model.entity.LeaveMsgField;
import com.moor.imkf.model.entity.MsgUnReadCount;
import com.moor.imkf.model.entity.NewCardInfo;
import com.moor.imkf.model.entity.ScheduleConfig;
import com.moor.imkf.model.parser.HttpParser;
import com.moor.imkf.requesturl.RequestUrl;
import com.moor.imkf.utils.MoorUtils;
import com.qiniu.android.common.Constants;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuicore.TUIConstants;
import e.j.e.t.a;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k.c.a.c;
import k.c.a.l;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class IMChatManager {
    public static final String CANCEL_ROBOT_ACCESS_ACTION = "cancelRobotAccess";
    public static final String CLIAM_ACTION = "action_cliam";
    public static final String CONSTANT_EXTEN = "exten";
    public static final String CONSTANT_ID = "_id";
    public static final String CONSTANT_ROBOT_SWITCH = "robotSwitch";
    public static final String CONSTANT_SESSIONID = "sessionId";
    public static final String CONSTANT_TOPEER = "topeer";
    public static final String CONSTANT_TYPE = "type";
    public static final String CONSTANT_USERICON = "usericon";
    public static final String CONSTANT_USERNAME = "username";
    public static final String CONSTANT_VIDEO_PASSWORD = "video_password";
    public static final String CONSTANT_VIDEO_ROOMNAME = "video_roomname";
    public static final String CONSTANT_VIDEO_USERNAME = "video_username";
    public static final String CONSTANT_VIDEO_VIDEO_TYPE = "video_videoType";
    public static final String FINISH_ACTION = "action_finish";
    public static final String INVESTIGATE_ACTION = "action_investigate";
    public static final String LEAVEMSG_ACTION = "action_leavemsg";
    public static String M7BOTSATISFACTION_ACTION = "action_m7botsatisfaction";
    public static String NEW_MSG_ACTION = "NewMsgReceiver";
    public static final String OFFLINE_ACTION = "action_offline";
    public static final String ONLINE_ACTION = "action_online";
    public static final String QUEUENUM_ACTION = "action_queuenum";
    public static final String ROBOT_ACTION = "action_robot";
    public static final String ROBOT_SWITCH_ACTION = "robotSwitchAction";
    public static final String START_TIMER = "start_timer";
    public static final String STOP_TIMER = "stop_timer";
    public static final String TCPSTATUS = "tcpstatus";
    public static final String TCP_ACTION = "action_tcp";
    public static String UNASSIGN_ACTION = "action_unassign";
    public static final String USERINFO_ACTION = "action_userinfo";
    public static boolean USE_ForegroundService = true;
    public static final String VIDEO_ACCEPT_ACTION = "action_video_accept";
    public static final String VIDEO_INVITED_ACTION = "action_video_invited";
    public static final String VIDEO_PC_CANCEL_ACTION = "action_video_pc_cancel";
    public static final String VIDEO_PC_HANGUP_ACTION = "action_video_hangup";
    public static final String VIDEO_REFUSE_ACTION = "action_video_refuse";
    public static final String VIPASSIGNFAIL_ACTION = "vipAssignFail";
    public static final String WITHDEAW_ID = "withdrawid";
    public static final String WITHDRAW_ACTION = "action_withdraw";
    public static final String WRITING_ACTION = "action_writing";
    public static final String ZXMSG_ACTION = "action_zxmsg";
    public static final String ZXMSG_OLD_ACTION = "ZXMSG_OLD_ACTION";
    public static final String botOpen = "botOpen";
    public static int saveMsgType;
    public static String userId;
    private Context appContext;
    private CardInfo cardInfo;
    public String chatType;
    public String currentNodeId;
    private SharedPreferences.Editor editor;
    public String entranceId;
    private JSONArray flowList;
    private boolean hasBottomList;
    private String hhDeviceId;
    private InitListener initListener;
    public boolean isFinishWhenReConnect;
    public boolean isIniting;
    private boolean isInvestigateOn;
    public boolean isManual;
    private boolean isTrack;
    private String latitude;
    private String longtitude;
    private MoorSocketReceivedListener moorSocketReceivedListener;
    private NewCardInfo newCardInfo;
    public String peerId;
    public String processId;
    public String scheduleId;
    private String sdkAndroidVersionCode;
    private String sdkVersion;
    private SharedPreferences sharedPreferences;
    private boolean showTransferBtn;
    public CountDownTimer timer;
    private String userOtherParams;

    /* loaded from: classes2.dex */
    public class AcceptOtherAgentResponse implements HttpResponseListener {
        private AcceptOtherAgentListener listener;

        public AcceptOtherAgentResponse(AcceptOtherAgentListener acceptOtherAgentListener) {
            IMChatManager.this = r1;
            this.listener = acceptOtherAgentListener;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            try {
                new JSONObject().put("status", "failed");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            AcceptOtherAgentListener acceptOtherAgentListener = this.listener;
            if (acceptOtherAgentListener != null) {
                acceptOtherAgentListener.onFailed();
            }
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            String succeed = HttpParser.getSucceed(str);
            try {
                new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if ("true".equals(succeed)) {
                IMChatManager.userId = "";
                AcceptOtherAgentListener acceptOtherAgentListener = this.listener;
                if (acceptOtherAgentListener != null) {
                    acceptOtherAgentListener.onSuccess();
                    return;
                }
                return;
            }
            AcceptOtherAgentListener acceptOtherAgentListener2 = this.listener;
            if (acceptOtherAgentListener2 != null) {
                acceptOtherAgentListener2.onFailed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class BeginSessionResponse implements HttpResponseListener {
        public OnSessionBeginListener listener;

        public BeginSessionResponse(OnSessionBeginListener onSessionBeginListener) {
            IMChatManager.this = r1;
            this.listener = onSessionBeginListener;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            try {
                new JSONObject().put("status", "failed");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            OnSessionBeginListener onSessionBeginListener = this.listener;
            if (onSessionBeginListener != null) {
                onSessionBeginListener.onFailed();
            }
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            MoorLogUtils.aTag("开始会话", str);
            String succeed = HttpParser.getSucceed(str);
            try {
                new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if ("true".equals(succeed)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("Config");
                    IMChatManager.this.isInvestigateOn = jSONObject2.getBoolean("webchat_csr");
                    IMChatManager.this.showTransferBtn = jSONObject2.getBoolean("showTransferBtn");
                    MoorLogUtils.aTag("开始会话", "===" + IMChatManager.this.showTransferBtn + "==");
                    if (jSONObject.has("bottomList")) {
                        IMChatManager.this.hasBottomList = true;
                        IMChatManager.this.flowList = jSONObject.getJSONArray("bottomList");
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (this.listener != null) {
                    MoorLogUtils.aTag("开始会话", "===listener.onSuccess()==");
                    this.listener.onSuccess();
                }
            } else if (this.listener != null) {
                MoorLogUtils.aTag("开始会话", "===listener.onFailed()==");
                this.listener.onFailed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class ConvertManualResponse implements HttpResponseListener {
        public OnConvertManualListener listener;

        public ConvertManualResponse(OnConvertManualListener onConvertManualListener) {
            IMChatManager.this = r1;
            this.listener = onConvertManualListener;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            try {
                new JSONObject().put("status", "failed");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            OnConvertManualListener onConvertManualListener = this.listener;
            if (onConvertManualListener != null) {
                onConvertManualListener.offLine();
            }
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            String succeed = HttpParser.getSucceed(str);
            MoorLogUtils.aTag("IMChatManger", "ConvertManualResponse:" + str);
            try {
                new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if ("true".equals(succeed)) {
                OnConvertManualListener onConvertManualListener = this.listener;
                if (onConvertManualListener != null) {
                    onConvertManualListener.onLine();
                    return;
                }
                return;
            }
            OnConvertManualListener onConvertManualListener2 = this.listener;
            if (onConvertManualListener2 != null) {
                onConvertManualListener2.offLine();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class GetInvestigateResponseHandler implements HttpResponseListener {
        private GetInvestigateResponseHandler() {
            IMChatManager.this = r1;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            MoorLogUtils.aTag("获取评价信息==", str);
            if ("true".equals(HttpParser.getSucceed(str))) {
                IMChatManager.this.editor.putString("investigate", HttpParser.getInvestigates(str));
                IMChatManager.this.editor.putString(YKFConstants.SATISFYTHANK, HttpParser.getSatisfyThanks(str));
                IMChatManager.this.editor.putString(YKFConstants.SATISFYTITLE, HttpParser.getSatisfyTitle(str));
                IMChatManager.this.editor.putString(YKFConstants.TIMEOUT, HttpParser.getTimeOut(str));
                IMChatManager.this.editor.putBoolean(YKFConstants.CSRAGING, HttpParser.getCSRAging(str));
                IMChatManager.this.editor.putBoolean(YKFConstants.NOT_ALLOWCUSTOMER_PUSH_CSR, HttpParser.getNotAllowCustomerPushCsr(str));
                IMChatManager.this.editor.putBoolean(YKFConstants.NOT_ALLOW_CUSTOMERCLOSECSR, HttpParser.getNotAllowCustomerCloseCsr(str));
                IMChatManager.this.editor.commit();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class GetPeersResponse implements HttpResponseListener {
        private GetPeersListener listener;

        public GetPeersResponse(GetPeersListener getPeersListener) {
            IMChatManager.this = r1;
            this.listener = getPeersListener;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            GetPeersListener getPeersListener = this.listener;
            if (getPeersListener != null) {
                getPeersListener.onFailed();
            }
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            if ("true".equals(HttpParser.getSucceed(str))) {
                if (this.listener != null) {
                    this.listener.onSuccess(HttpParser.getPeers(str));
                    return;
                }
                return;
            }
            GetPeersListener getPeersListener = this.listener;
            if (getPeersListener != null) {
                getPeersListener.onFailed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class GetWebchatGlobleConfigHandler implements HttpResponseListener {
        private GetWebchatGlobleConfigHandler() {
            IMChatManager.this = r1;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            MoorLogUtils.aTag("GetWebchatGlobleConfig", str);
            if (HttpParser.getSuccess(str)) {
                GlobalSet globalSet = HttpParser.getGlobalSet(str);
                GlobalSetDao.getInstance().deleteGlobalSetToDao();
                GlobalSetDao.getInstance().insertGlobalSetToDao(globalSet);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class GlobleConfig implements HttpResponseListener {
        private GetGlobleConfigListen listener;

        public GlobleConfig(GetGlobleConfigListen getGlobleConfigListen) {
            IMChatManager.this = r1;
            this.listener = getGlobleConfigListen;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            MoorLogUtils.aTag("GlobleConfig", "scheduleConfig：" + str);
            if (!HttpParser.getSuccess(str)) {
                Toast.makeText(IMChatManager.this.appContext, "service failura", 0).show();
                return;
            }
            GlobalSet globalSet = HttpParser.getGlobalSet(str);
            GlobalSetDao.getInstance().deleteGlobalSetToDao();
            GlobalSetDao.getInstance().insertGlobalSetToDao(globalSet);
            ScheduleConfig scheduleConfig = (ScheduleConfig) new Gson().o(HttpParser.getScheduleConfig(str).toString(), new a<ScheduleConfig>() { // from class: com.moor.imkf.IMChatManager.GlobleConfig.1
                {
                    GlobleConfig.this = this;
                }
            }.getType());
            if (scheduleConfig != null && scheduleConfig.isScheduleEnable()) {
                this.listener.getSchedule(scheduleConfig);
                IMChatManager.this.chatType = YKFConstants.TYPE_SCHEDULE;
                return;
            }
            this.listener.getPeers();
            IMChatManager.this.chatType = "peer";
        }
    }

    /* loaded from: classes2.dex */
    public interface HttpUnReadListen {
        void getUnRead(int i2);
    }

    /* loaded from: classes2.dex */
    public static class IMChatManagerClassHolder {
        private static final IMChatManager instance = new IMChatManager();

        private IMChatManagerClassHolder() {
        }
    }

    /* loaded from: classes2.dex */
    public class SubmitOfflineMsgResponse implements HttpResponseListener {
        public OnSubmitOfflineMessageListener listener;

        public SubmitOfflineMsgResponse(OnSubmitOfflineMessageListener onSubmitOfflineMessageListener) {
            IMChatManager.this = r1;
            this.listener = onSubmitOfflineMessageListener;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            OnSubmitOfflineMessageListener onSubmitOfflineMessageListener = this.listener;
            if (onSubmitOfflineMessageListener != null) {
                onSubmitOfflineMessageListener.onFailed();
            }
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            if ("true".equals(HttpParser.getSucceed(str))) {
                OnSubmitOfflineMessageListener onSubmitOfflineMessageListener = this.listener;
                if (onSubmitOfflineMessageListener != null) {
                    onSubmitOfflineMessageListener.onSuccess();
                    return;
                }
                return;
            }
            OnSubmitOfflineMessageListener onSubmitOfflineMessageListener2 = this.listener;
            if (onSubmitOfflineMessageListener2 != null) {
                onSubmitOfflineMessageListener2.onFailed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SubmitResponse implements HttpResponseListener {
        private final SubmitInvestigateListener listener;

        public SubmitResponse(SubmitInvestigateListener submitInvestigateListener) {
            this.listener = submitInvestigateListener;
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onFailed() {
            SubmitInvestigateListener submitInvestigateListener = this.listener;
            if (submitInvestigateListener != null) {
                submitInvestigateListener.onFailed();
            }
        }

        @Override // com.moor.imkf.listener.HttpResponseListener
        public void onSuccess(String str) {
            if ("true".equals(HttpParser.getSucceed(str))) {
                SubmitInvestigateListener submitInvestigateListener = this.listener;
                if (submitInvestigateListener != null) {
                    submitInvestigateListener.onSuccess();
                    return;
                }
                return;
            }
            SubmitInvestigateListener submitInvestigateListener2 = this.listener;
            if (submitInvestigateListener2 != null) {
                submitInvestigateListener2.onFailed();
            }
        }
    }

    private void deleteOldDB() {
        try {
            String str = this.sdkVersion;
            if (Integer.parseInt(str.substring(1, str.length()).replace(".", "")) < 390 || this.sharedPreferences.getBoolean(YKFConstants.REMOVEDB, false)) {
                return;
            }
            File file = new File(this.appContext.getDatabasePath(YKFConstants.Moor_DATABASE).getPath());
            if (file.exists()) {
                file.delete();
            }
            this.editor.putBoolean(YKFConstants.REMOVEDB, true);
            this.editor.commit();
        } catch (Exception unused) {
        }
    }

    public static IMChatManager getInstance() {
        return IMChatManagerClassHolder.instance;
    }

    public static boolean isUSE_ForegroundService() {
        return USE_ForegroundService;
    }

    private void quit() {
        try {
            MessageDao.getInstance().updateSendMsgFail();
            IMChat.getInstance().setLianXiangOn(false);
            IMChat.getInstance().setHumanLianXiangOn(false);
            IMChat.getInstance().setBotsatisfaOn(false);
            c.f().q(new QuitVideoEvent());
            c.f().q(new LoginOffEvent());
            getInstance().isIniting = false;
            getInstance().initListener = null;
            unRegisterEventBus();
            cancelInitTimer();
            MoorBaseLibManager.getInstance().quitBaseLib();
        } catch (Exception unused) {
        }
    }

    private void resetDbStatus() {
        MessageDao.getInstance().updateAllisShowVT();
        MessageDao.getInstance().updateFlowAllChoose();
        MessageDao.getInstance().updateXbotForm("");
        MessageDao.getInstance().deleteQuickMenuBtn();
    }

    public static void setUSE_ForegroundService(boolean z) {
        USE_ForegroundService = z;
    }

    private void startInitTimer() {
        this.timer.start();
    }

    public void acceptOtherAgent(String str, AcceptOtherAgentListener acceptOtherAgentListener) {
        HttpManager.acceptOtherAgent(InfoDao.getInstance().getConnectionId(), str, new AcceptOtherAgentResponse(acceptOtherAgentListener));
    }

    public void acceptVideo(final AcceptVideoListener acceptVideoListener) {
        HttpManager.acceptVideo(InfoDao.getInstance().getConnectionId(), new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.10
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                AcceptVideoListener acceptVideoListener2 = acceptVideoListener;
                if (acceptVideoListener2 != null) {
                    acceptVideoListener2.onFailed();
                }
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                if ("true".equals(HttpParser.getSucceed(str))) {
                    AcceptVideoListener acceptVideoListener2 = acceptVideoListener;
                    if (acceptVideoListener2 != null) {
                        acceptVideoListener2.onSuccess();
                        return;
                    }
                    return;
                }
                AcceptVideoListener acceptVideoListener3 = acceptVideoListener;
                if (acceptVideoListener3 != null) {
                    acceptVideoListener3.onFailed();
                }
            }
        });
    }

    public void beginScheduleSession(String str, String str2, String str3, String str4, OnSessionBeginListener onSessionBeginListener) {
        if (this.appContext == null) {
            return;
        }
        this.scheduleId = str;
        this.processId = str2;
        this.currentNodeId = str3;
        this.entranceId = str4;
        userId = InfoDao.getInstance().getUserId();
        HttpManager.beginNewScheduleChatSession(InfoDao.getInstance().getConnectionId(), getIsNewVisitor(), str, str2, str3, str4, "", new BeginSessionResponse(onSessionBeginListener));
    }

    public void beginSession(String str, OnSessionBeginListener onSessionBeginListener) {
        if (this.appContext == null) {
            return;
        }
        this.peerId = str;
        userId = InfoDao.getInstance().getUserId();
        HttpManager.beginNewChatSession(InfoDao.getInstance().getConnectionId(), getIsNewVisitor(), str, "", new BeginSessionResponse(onSessionBeginListener));
    }

    public void cancelInitTimer() {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void cancerlVideo(final RefuseVideoListener refuseVideoListener) {
        HttpManager.cancelVideo(InfoDao.getInstance().getConnectionId(), new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.12
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                RefuseVideoListener refuseVideoListener2 = refuseVideoListener;
                if (refuseVideoListener2 != null) {
                    refuseVideoListener2.onFailed();
                }
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                if ("true".equals(HttpParser.getSucceed(str))) {
                    RefuseVideoListener refuseVideoListener2 = refuseVideoListener;
                    if (refuseVideoListener2 != null) {
                        refuseVideoListener2.onSuccess();
                        return;
                    }
                    return;
                }
                RefuseVideoListener refuseVideoListener3 = refuseVideoListener;
                if (refuseVideoListener3 != null) {
                    refuseVideoListener3.onFailed();
                }
            }
        });
    }

    public void checkImCsrTimeout(String str, String str2, final onResponseListener onresponselistener) {
        HttpManager.checkImCsrTimeout(str2, str, new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.3
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                onResponseListener onresponselistener2 = onresponselistener;
                if (onresponselistener2 != null) {
                    onresponselistener2.onFailed();
                }
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str3) {
                MoorLogUtils.aTag("获取评价是否过时", str3);
                if ("true".equals(HttpParser.getSucceed(str3))) {
                    onResponseListener onresponselistener2 = onresponselistener;
                    if (onresponselistener2 != null) {
                        onresponselistener2.onSuccess();
                        return;
                    }
                    return;
                }
                onResponseListener onresponselistener3 = onresponselistener;
                if (onresponselistener3 != null) {
                    onresponselistener3.onTimeOut();
                }
            }
        });
    }

    public void closeLog() {
        MoorLogUtils.getConfig().setLogSwitch(false);
    }

    public void convertManual(String str, OnConvertManualListener onConvertManualListener) {
        HttpManager.convertManual(str, InfoDao.getInstance().getConnectionId(), new ConvertManualResponse(onConvertManualListener));
    }

    public void deleteInvestigateMsg(FromToMessage fromToMessage) {
        MessageDao.getInstance().deleteMsg(fromToMessage);
    }

    public String get7moorLoginStr(Context context) {
        String loginName = InfoDao.getInstance().getLoginName();
        String userId2 = InfoDao.getInstance().getUserId();
        String accessId = InfoDao.getInstance().getAccessId();
        String replaceAll = userId2.trim().replaceAll(ExpandableTextView.N, "");
        JSONObject jSONObject = new JSONObject();
        try {
            String encode = URLEncoder.encode(loginName, Constants.UTF_8);
            String encode2 = URLEncoder.encode(replaceAll, Constants.UTF_8);
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, "sdkLogin");
            jSONObject.put("UserName", encode);
            jSONObject.put("UserId", encode2);
            jSONObject.put("AccessId", accessId);
            jSONObject.put("Platform", MoorUtils.getDeviceModel());
            jSONObject.put("DeviceId", MoorUtils.getDeviceId(context));
            jSONObject.put("NewVersion", "true");
            jSONObject.put("sdkAndroidVersionCode", getInstance().getsdkAndroidVersionCode());
            jSONObject.put("hhDeviceId", getInstance().getHhDeviceId());
            jSONObject.put("longtitude", getInstance().getLongtitude());
            jSONObject.put("latitude", getInstance().getLatitude());
            jSONObject.put("sdkVersionCode", getInstance().getSdkVersion());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return "1" + jSONObject.toString() + "\n";
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public JSONArray getBottomList() {
        return this.flowList;
    }

    public CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public String getHhDeviceId() {
        return this.hhDeviceId;
    }

    public List<Investigate> getInvestigate() {
        SharedPreferences sharedPreferences;
        ArrayList arrayList = new ArrayList();
        if (this.appContext == null || (sharedPreferences = this.sharedPreferences) == null) {
            return arrayList;
        }
        String string = sharedPreferences.getString("investigate", "");
        if (string.equals("")) {
            HttpManager.getInvestigateList(InfoDao.getInstance().getConnectionId(), new GetInvestigateResponseHandler());
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            return (List) new Gson().o(new JSONArray(string).toString(), new a<List<Investigate>>() { // from class: com.moor.imkf.IMChatManager.4
                {
                    IMChatManager.this = this;
                }
            }.getType());
        } catch (JSONException e2) {
            e2.printStackTrace();
            return arrayList2;
        }
    }

    public boolean getIsNewVisitor() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        boolean z = true;
        if (sharedPreferences == null) {
            Context context = this.appContext;
            if (context != null) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(YKFConstants.MOOR_SP, 0);
                this.sharedPreferences = sharedPreferences2;
                this.editor = sharedPreferences2.edit();
                z = this.sharedPreferences.getBoolean(YKFConstants.ISNEW, true);
            }
        } else {
            z = sharedPreferences.getBoolean(YKFConstants.ISNEW, true);
        }
        if (z) {
            this.editor.putBoolean(YKFConstants.ISNEW, false);
            this.editor.commit();
        }
        return z;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void getLeaveMsgConfig(final OnLeaveMsgConfigListener onLeaveMsgConfigListener) {
        HttpManager.getWebchatGlobleConfig(InfoDao.getInstance().getConnectionId(), new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.7
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                OnLeaveMsgConfigListener onLeaveMsgConfigListener2 = onLeaveMsgConfigListener;
                if (onLeaveMsgConfigListener2 != null) {
                    onLeaveMsgConfigListener2.onFailed();
                }
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                ArrayList arrayList = new ArrayList();
                if (HttpParser.getSuccess(str)) {
                    try {
                        JSONArray jSONArray = new JSONObject(str).getJSONObject("globalSet").getJSONArray("leavemsgFields");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            LeaveMsgField leaveMsgField = new LeaveMsgField();
                            String string = jSONArray.getJSONObject(i2).getString("_id");
                            String string2 = jSONArray.getJSONObject(i2).getString("name");
                            Boolean valueOf = Boolean.valueOf(jSONArray.getJSONObject(i2).getBoolean("enable"));
                            Boolean valueOf2 = Boolean.valueOf(jSONArray.getJSONObject(i2).getBoolean("required"));
                            leaveMsgField._id = string;
                            leaveMsgField.name = string2;
                            leaveMsgField.enable = valueOf;
                            leaveMsgField.required = valueOf2;
                            arrayList.add(leaveMsgField);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                onLeaveMsgConfigListener.onSuccess("", arrayList);
            }
        });
    }

    public String getLongtitude() {
        return this.longtitude;
    }

    public List<FromToMessage> getMessages(int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = saveMsgType;
        if (i3 != 0) {
            if (i3 != 1) {
                return i3 != 2 ? arrayList : MessageDao.getInstance().getMessagesFromAccessId(i2);
            }
            return MessageDao.getInstance().getMessagesFromPeedId(i2);
        }
        return MessageDao.getInstance().getMessagesFromUserId(i2);
    }

    public List<FromToMessage> getMessagesByAccessid(String str) {
        new ArrayList();
        return MessageDao.getInstance().getMessagesByAccessId(str);
    }

    public MoorSocketReceivedListener getMoorSocketReceivedListener() {
        return this.moorSocketReceivedListener;
    }

    public int getMsgUnReadCount() {
        if (getMsgUnReadType() == null || "".equals(getMsgUnReadType())) {
            return 0;
        }
        return MsgUnReadCountDao.getInstance().getUnReadCount(getMsgUnReadType());
    }

    public void getMsgUnReadCountFromService(String str, String str2, String str3, final HttpUnReadListen httpUnReadListen) {
        HttpManager.getUnReadMsgCount(str, str2, str3, new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.6
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                httpUnReadListen.getUnRead(0);
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str4) {
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    if (jSONObject.getBoolean("Succeed")) {
                        httpUnReadListen.getUnRead(jSONObject.getInt("count"));
                    } else {
                        httpUnReadListen.getUnRead(0);
                    }
                } catch (JSONException unused) {
                    httpUnReadListen.getUnRead(0);
                }
            }
        });
    }

    public String getMsgUnReadType() {
        int i2 = saveMsgType;
        if (i2 != 0) {
            if (i2 != 1) {
                return i2 != 2 ? "" : InfoDao.getInstance().getAccessId();
            }
            return InfoDao.getInstance().getPeedId();
        }
        return InfoDao.getInstance().getUserId();
    }

    public NewCardInfo getNewCardInfo() {
        return this.newCardInfo;
    }

    public void getPeers(GetPeersListener getPeersListener) {
        HttpManager.getPeers(InfoDao.getInstance().getConnectionId(), new GetPeersResponse(getPeersListener));
    }

    public void getScheduleLeaveMsgConfig(final EditText editText, final String str, final OnLeaveMsgConfigListener onLeaveMsgConfigListener) {
        HttpManager.getWebchatGlobleConfig(InfoDao.getInstance().getConnectionId(), new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.8
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                OnLeaveMsgConfigListener onLeaveMsgConfigListener2 = onLeaveMsgConfigListener;
                if (onLeaveMsgConfigListener2 != null) {
                    onLeaveMsgConfigListener2.onFailed();
                }
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str2) {
                MoorLogUtils.aTag("getScheduleLeaveMsgConfig", str2);
                ArrayList arrayList = new ArrayList();
                String str3 = "";
                if (HttpParser.getSuccess(str2)) {
                    try {
                        JSONArray jSONArray = new JSONObject(str2).getJSONObject("scheduleConfig").getJSONArray("leavemsgNodes");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject.getString("_id").equals(str)) {
                                str3 = jSONObject.optString("title");
                                JSONArray jSONArray2 = jSONObject.getJSONArray("leavemsgFields");
                                editText.setHint(jSONObject.getString("contentTip"));
                                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                    LeaveMsgField leaveMsgField = new LeaveMsgField();
                                    String string = jSONArray2.getJSONObject(i3).getString("_id");
                                    String string2 = jSONArray2.getJSONObject(i3).getString("name");
                                    Boolean valueOf = Boolean.valueOf(jSONArray2.getJSONObject(i3).getBoolean("enable"));
                                    Boolean valueOf2 = Boolean.valueOf(jSONArray2.getJSONObject(i3).getBoolean("required"));
                                    leaveMsgField._id = string;
                                    leaveMsgField.name = string2;
                                    leaveMsgField.enable = valueOf;
                                    leaveMsgField.required = valueOf2;
                                    arrayList.add(leaveMsgField);
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                onLeaveMsgConfigListener.onSuccess(str3, arrayList);
            }
        });
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void getServerTime(final onResponseListener onresponselistener) {
        HttpManager.getServerTime(new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.2
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                onResponseListener onresponselistener2 = onresponselistener;
                if (onresponselistener2 != null) {
                    onresponselistener2.onFailed();
                }
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                MoorLogUtils.dTag("timestamp==get==", str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getBoolean("Succeed")) {
                        String string = jSONObject.getString("message");
                        if (string != null) {
                            IMChatManager.this.editor.putString(YKFConstants.SERVERTIMESTAMP, string);
                            IMChatManager.this.editor.commit();
                        }
                        onResponseListener onresponselistener2 = onresponselistener;
                        if (onresponselistener2 != null) {
                            onresponselistener2.onSuccess();
                            return;
                        }
                        return;
                    }
                    onResponseListener onresponselistener3 = onresponselistener;
                    if (onresponselistener3 != null) {
                        onresponselistener3.onFailed();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public String getUserOtherParams() {
        return this.userOtherParams;
    }

    public void getWebchatScheduleConfig(GetGlobleConfigListen getGlobleConfigListen) {
        HttpManager.getWebchatGlobleConfig(InfoDao.getInstance().getConnectionId(), new GlobleConfig(getGlobleConfigListen));
    }

    public String getsdkAndroidVersionCode() {
        return this.sdkAndroidVersionCode;
    }

    public void init(Context context, String str, String str2, String str3, String str4) {
        InitListener initListener = this.initListener;
        if (initListener != null) {
            initListener.oninitStart();
        }
        if (!c.f().o(this)) {
            c.f().v(this);
        }
        if (this.isIniting) {
            InitListener initListener2 = this.initListener;
            if (initListener2 != null) {
                initListener2.onInitFailed(1010);
                return;
            }
            return;
        }
        this.isIniting = true;
        if (context == null) {
            MoorLogUtils.aTag("初始化失败", "appContext is null");
            return;
        }
        MoorBaseLibManager.getInstance().initBaseLib(context);
        if (TextUtils.isEmpty(RequestUrl.BASE_HTTP)) {
            MoorLogUtils.aTag("初始化失败", "初始化之前没有调用RequestUrl.setRequestUrl()或RequestUrl.setRequestUrl()");
            InitListener initListener3 = this.initListener;
            if (initListener3 != null) {
                initListener3.onInitFailed(1006);
                return;
            }
            return;
        }
        this.appContext = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(YKFConstants.MOOR_SP, 0);
        this.sharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
        deleteOldDB();
        if (str != null && !"".equals(str)) {
            NEW_MSG_ACTION = str;
        }
        Info info = new Info();
        if (str3 != null) {
            info.loginName = str3;
        }
        if (str4 != null) {
            info.userId = str4;
        }
        if (str2 != null) {
            info.accessId = str2;
        }
        InfoDao.getInstance().insertInfoToDao(info);
        resetDbStatus();
        startInitTimer();
        Intent intent = new Intent(context, SocketService.class);
        if (USE_ForegroundService) {
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        } else {
            context.startService(intent);
        }
        this.editor.putBoolean(YKFConstants.FIRST_INIT, true);
        this.editor.commit();
    }

    public boolean isInvestigateOn() {
        return this.isInvestigateOn;
    }

    public boolean isReachEndMessage(int i2) {
        int i3 = saveMsgType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return false;
                }
                return MessageDao.getInstance().isReachEndMessageFromAccessId(i2).booleanValue();
            }
            return MessageDao.getInstance().isReachEndMessageFromPeedId(i2).booleanValue();
        }
        return MessageDao.getInstance().isReachEndMessageFromUserId(i2).booleanValue();
    }

    public boolean isShowBottomList() {
        return this.hasBottomList;
    }

    public boolean isShowTransferBtn() {
        return this.showTransferBtn;
    }

    public void offline(final OfflineListener offlineListener) {
        HttpManager.offline(InfoDao.getInstance().getConnectionId(), new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.5
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                OfflineListener offlineListener2 = offlineListener;
                if (offlineListener2 != null) {
                    offlineListener2.onFailed();
                }
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                if ("true".equals(HttpParser.getSucceed(str))) {
                    OfflineListener offlineListener2 = offlineListener;
                    if (offlineListener2 != null) {
                        offlineListener2.onSuccess();
                        return;
                    }
                    return;
                }
                OfflineListener offlineListener3 = offlineListener;
                if (offlineListener3 != null) {
                    offlineListener3.onFailed();
                }
            }
        });
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(LoginSuccessEvent loginSuccessEvent) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        boolean z = true;
        if (sharedPreferences == null) {
            Context context = this.appContext;
            if (context != null) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(YKFConstants.MOOR_SP, 0);
                this.sharedPreferences = sharedPreferences2;
                this.editor = sharedPreferences2.edit();
                z = this.sharedPreferences.getBoolean(YKFConstants.FIRST_INIT, true);
            }
        } else {
            z = sharedPreferences.getBoolean(YKFConstants.FIRST_INIT, true);
        }
        if (z) {
            this.editor.putBoolean(YKFConstants.FIRST_INIT, false);
            this.editor.commit();
            HttpManager.getInvestigateList(InfoDao.getInstance().getConnectionId(), new GetInvestigateResponseHandler());
            HttpManager.getWebchatGlobleConfig(InfoDao.getInstance().getConnectionId(), new GetWebchatGlobleConfigHandler());
            MsgUnReadCount msgUnReadCount = new MsgUnReadCount();
            msgUnReadCount.sessionId = getMsgUnReadType();
            msgUnReadCount.msgUnReadCount = 0;
            MsgUnReadCountDao.getInstance().createMsgUnReadCount(msgUnReadCount);
            InitListener initListener = this.initListener;
            if (initListener != null) {
                initListener.oninitSuccess();
            }
        }
    }

    public void onLineQuitSDK() {
        getInstance().offline(new OfflineListener() { // from class: com.moor.imkf.IMChatManager.1
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.OfflineListener
            public void onFailed() {
                MoorLogUtils.aTag("imchat", "offline false");
            }

            @Override // com.moor.imkf.listener.OfflineListener
            public void onSuccess() {
                MoorLogUtils.aTag("imchat", "offline seceseed");
            }
        });
    }

    public void openLog() {
        MoorLogUtils.getConfig().setLogSwitch(true);
    }

    public void pushImVideoToAgent(String str, final PushVideoListener pushVideoListener) {
        HttpManager.pushImVideoToAgent(InfoDao.getInstance().getConnectionId(), str, new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.13
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                PushVideoListener pushVideoListener2 = pushVideoListener;
                if (pushVideoListener2 != null) {
                    pushVideoListener2.onFailed("发起视频失败");
                }
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str2) {
                if ("true".equals(HttpParser.getSucceed(str2))) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        String string = jSONObject.getString("password");
                        String string2 = jSONObject.getString(TUIConstants.TUILive.ROOM_ID);
                        PushVideoListener pushVideoListener2 = pushVideoListener;
                        if (pushVideoListener2 != null) {
                            pushVideoListener2.onSuccess(string, string2);
                            return;
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                String message = HttpParser.getMessage(str2);
                PushVideoListener pushVideoListener3 = pushVideoListener;
                if (pushVideoListener3 != null) {
                    pushVideoListener3.onFailed(message);
                }
            }
        });
    }

    public void quitSDk() {
        quit();
    }

    public void refuseVideo(final RefuseVideoListener refuseVideoListener) {
        HttpManager.refuseVideo(InfoDao.getInstance().getConnectionId(), new HttpResponseListener() { // from class: com.moor.imkf.IMChatManager.11
            {
                IMChatManager.this = this;
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
                RefuseVideoListener refuseVideoListener2 = refuseVideoListener;
                if (refuseVideoListener2 != null) {
                    refuseVideoListener2.onFailed();
                }
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                if ("true".equals(HttpParser.getSucceed(str))) {
                    RefuseVideoListener refuseVideoListener2 = refuseVideoListener;
                    if (refuseVideoListener2 != null) {
                        refuseVideoListener2.onSuccess();
                        return;
                    }
                    return;
                }
                RefuseVideoListener refuseVideoListener3 = refuseVideoListener;
                if (refuseVideoListener3 != null) {
                    refuseVideoListener3.onFailed();
                }
            }
        });
    }

    public void resetMsgUnReadCount() {
        if (getMsgUnReadType() == null || "".equals(getMsgUnReadType())) {
            return;
        }
        MsgUnReadCountDao.getInstance().updateUnReadCount(getMsgUnReadType());
    }

    public void sendRobotCsr(String str, String str2, String str3, String str4, String str5) {
        HttpManager.sendRobotCsr(InfoDao.getInstance().getConnectionId(), str, str2, str3, str4, str5, null);
    }

    public void setAppContext(Context context) {
        this.appContext = context;
    }

    public void setBottomList(JSONArray jSONArray) {
        this.flowList = jSONArray;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public void setHhDeviceId(String str) {
        this.hhDeviceId = str;
    }

    public void setIsInvestigateOn(boolean z) {
        this.isInvestigateOn = z;
    }

    public void setIsShowBottomList(boolean z) {
        this.hasBottomList = z;
    }

    public void setIsShowTransferBtn(boolean z) {
        this.showTransferBtn = z;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongtitude(String str) {
        this.longtitude = str;
    }

    public void setMoorSocketReceivedListener(MoorSocketReceivedListener moorSocketReceivedListener) {
        this.moorSocketReceivedListener = moorSocketReceivedListener;
    }

    public void setNewCardInfo(NewCardInfo newCardInfo) {
        this.newCardInfo = newCardInfo;
    }

    public void setOnInitListener(InitListener initListener) {
        this.initListener = initListener;
    }

    public void setQiNiuIp(String str) {
        if (str == null || "".equals(str)) {
            return;
        }
        RequestUrl.QINIU_HTTP = str;
    }

    public void setSaveMsgType(int i2) {
        saveMsgType = i2;
    }

    public void setUserOtherParams(String str, JSONObject jSONObject, boolean z, JSONObject jSONObject2) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (z && jSONObject2 != null) {
                if (jSONObject != null) {
                    jSONObject.put("user_labels", jSONObject2);
                } else {
                    jSONObject = new JSONObject();
                    jSONObject.put("user_labels", jSONObject2);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject3.put("agent", str);
            }
            if (jSONObject != null) {
                jSONObject3.put("customField", URLEncoder.encode(jSONObject.toString()));
                this.userOtherParams = jSONObject3.toString();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setsdkAndroidVersionCode(String str) {
        this.sdkAndroidVersionCode = str;
    }

    public void submitInvestigate(Investigate investigate, SubmitInvestigateListener submitInvestigateListener) {
        HttpManager.submitInvestigate(InfoDao.getInstance().getConnectionId(), investigate.name, investigate.value, new SubmitResponse(submitInvestigateListener));
    }

    public void submitOfflineMessage(String str, String str2, String str3, String str4, OnSubmitOfflineMessageListener onSubmitOfflineMessageListener) {
        String str5 = str2 == null ? "" : str2;
        String str6 = str3 == null ? "" : str3;
        String str7 = str4 == null ? "" : str4;
        if (this.appContext == null) {
            return;
        }
        HttpManager.submitOfflineMessage(InfoDao.getInstance().getConnectionId(), str, str5, str6, str7, new SubmitOfflineMsgResponse(onSubmitOfflineMessageListener));
    }

    public void unRegisterEventBus() {
        if (c.f().o(this)) {
            c.f().A(this);
        }
    }

    public void updateMessageToDB(FromToMessage fromToMessage) {
        MessageDao.getInstance().updateMsgToDao(fromToMessage);
    }

    public void updateOrderInfo(String str, String str2) {
        MessageDao.getInstance().updateOrderInfoToDao(str, str2);
    }

    private IMChatManager() {
        this.isTrack = false;
        this.hhDeviceId = "";
        this.sdkAndroidVersionCode = "3.2";
        this.sdkVersion = "v4.1.0";
        this.longtitude = "";
        this.latitude = "";
        this.chatType = "";
        this.peerId = "";
        this.entranceId = "";
        this.isManual = false;
        this.isFinishWhenReConnect = false;
        this.isInvestigateOn = true;
        this.showTransferBtn = false;
        this.hasBottomList = false;
        this.isIniting = false;
        this.userOtherParams = "";
        this.timer = new CountDownTimer(JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS, 1000L) { // from class: com.moor.imkf.IMChatManager.9
            {
                IMChatManager.this = this;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (IMChatManager.this.initListener != null) {
                    IMChatManager.this.initListener.onInitFailed(1001);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }
        };
        if (c.f().o(this)) {
            return;
        }
        c.f().v(this);
    }

    public void sendRobotCsr(String str, String str2, String str3, String str4) {
        HttpManager.sendRobotCsr(InfoDao.getInstance().getConnectionId(), str, str2, str3, str4, null);
    }

    public void submitInvestigate(String str, String str2, String str3, String str4, String str5, List<String> list, String str6, SubmitInvestigateListener submitInvestigateListener) {
        HttpManager.submitInvestigate(str, str3, str2, str4, str5, list, str6, new SubmitResponse(submitInvestigateListener));
    }

    public void sendRobotCsr(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        HttpManager.sendRobotCsr(InfoDao.getInstance().getConnectionId(), str, str3, str4, str5, str6, str7, str8, str9, str10, str11, str2, null);
    }

    public void submitOfflineMessage(String str, String str2, String str3, String str4, HashMap<String, String> hashMap, List<LeaveMsgField> list, OnSubmitOfflineMessageListener onSubmitOfflineMessageListener) {
        if (str4 == null) {
            str4 = "";
        }
        String str5 = str4;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str + "\n");
        stringBuffer.append(str2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str5 + "\n");
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("_id", list.get(i2)._id);
                    jSONObject.put("name", list.get(i2).name);
                    jSONObject.put("required", list.get(i2).required);
                    jSONObject.put("enable", list.get(i2).enable);
                    jSONArray.put(jSONObject);
                    if (!TextUtils.isEmpty(hashMap.get(list.get(i2)._id))) {
                        if (i2 == list.size() - 1) {
                            stringBuffer.append(list.get(i2).name + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + hashMap.get(list.get(i2)._id));
                        } else {
                            stringBuffer.append(list.get(i2).name + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + hashMap.get(list.get(i2)._id) + "\n");
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        MessageDao.getInstance().insertSendMsgsToDao(IMMessage.createLeaveTxtMessage(stringBuffer.toString()));
        HttpManager.submitOfflineMessage(InfoDao.getInstance().getConnectionId(), str3, str5, hashMap, jSONArray, new SubmitOfflineMsgResponse(onSubmitOfflineMessageListener));
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(LoginFailedEvent loginFailedEvent) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        boolean z = true;
        if (sharedPreferences == null) {
            Context context = this.appContext;
            if (context != null) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(YKFConstants.MOOR_SP, 0);
                this.sharedPreferences = sharedPreferences2;
                this.editor = sharedPreferences2.edit();
                z = this.sharedPreferences.getBoolean(YKFConstants.FIRST_INIT, true);
            }
        } else {
            z = sharedPreferences.getBoolean(YKFConstants.FIRST_INIT, true);
        }
        if (z) {
            this.editor.putBoolean(YKFConstants.FIRST_INIT, false);
            this.editor.commit();
        }
        InitListener initListener = this.initListener;
        if (initListener != null) {
            initListener.onInitFailed(1004);
        }
        quit();
    }
}
