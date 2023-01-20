package com.moor.imkf.http;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bc;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.moor.imkf.IMChat;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.db.dao.GlobalSetDao;
import com.moor.imkf.db.dao.InfoDao;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.moor.imkf.lib.utils.json.MoorJSONWriter;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.requesturl.YKFUrlConstants;
import com.moor.imkf.utils.MoorUtils;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.stat.ServiceStat;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class YKFHttpParams {

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final YKFHttpParams sInstance = new YKFHttpParams();

        private SingletonHolder() {
        }
    }

    private JSONObject createBeginNewChatJson(String str, boolean z, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_BEGIN_NEWCHAT_SESSION);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("IsNewVisitor", z);
            if (str2 != null && !"".equals(str2)) {
                jSONObject.put("ToPeer", str2);
            }
            jSONObject.put("sdkAndroidVersionCode", IMChatManager.getInstance().getsdkAndroidVersionCode());
            jSONObject.put("thirdPartyUserId", IMChatManager.userId);
            if (!"".equals(str3)) {
                jSONObject.put("otherParams", str3);
            }
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject createNewScheduleChatJson(String str, boolean z, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_BEGIN_NEWCHAT_SESSION);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("IsNewVisitor", z);
            jSONObject.put("scheduleId", str2);
            jSONObject.put("processId", str3);
            jSONObject.put("currentNodeId", str4);
            jSONObject.put("sdkAndroidVersionCode", IMChatManager.getInstance().getsdkAndroidVersionCode());
            jSONObject.put("thirdPartyUserId", IMChatManager.userId);
            jSONObject.put("entranceId", str5);
            if (!"".equals(str6)) {
                jSONObject.put("otherParams", str6);
            }
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject createPullQAJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_PULLQAMSG);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject createVideoOperationJson(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_HANDLER_CUSTVIDEO_OPERATION);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static YKFHttpParams getInstance() {
        return SingletonHolder.sInstance;
    }

    public String QiNiuGetUpToken(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_QINIU_GETUPTOKEN);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("fileName", str2);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String acceptVideo(String str) {
        JSONObject createVideoOperationJson = createVideoOperationJson(str);
        try {
            createVideoOperationJson.put("operation", "accept");
            createVideoOperationJson.put("originator", "agent");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return createVideoOperationJson.toString();
    }

    public String beginNewScheduleChatSession(String str, boolean z, String str2, String str3, String str4, String str5, String str6) {
        JSONObject createNewScheduleChatJson = createNewScheduleChatJson(str, z, str2, str3, str4, str5, str6);
        MoorLogUtils.aTag("beginNewScheduleChatSession", createNewScheduleChatJson.toString());
        return createNewScheduleChatJson.toString();
    }

    public String beginNewVipOfflineScheduleChatSession(String str, boolean z, String str2, String str3, String str4, String str5, String str6) {
        JSONObject createNewScheduleChatJson = createNewScheduleChatJson(str, z, str2, str3, str4, str5, str6);
        try {
            createNewScheduleChatJson.put("vipAcceptOtherPeer", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        MoorLogUtils.aTag("beginNewScheduleChatSession", createNewScheduleChatJson.toString());
        return createNewScheduleChatJson.toString();
    }

    public String beginNewVipOfflineSession(String str, boolean z, String str2, String str3) {
        JSONObject createBeginNewChatJson = createBeginNewChatJson(str, z, str2, str3);
        try {
            createBeginNewChatJson.put("vipAcceptOtherPeer", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        MoorLogUtils.aTag("beginNewVipOfflineSession", createBeginNewChatJson.toString());
        return createBeginNewChatJson.toString();
    }

    public String cancelVideo(String str) {
        JSONObject createVideoOperationJson = createVideoOperationJson(str);
        try {
            createVideoOperationJson.put("operation", "cancel");
            createVideoOperationJson.put("originator", "customer");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return createVideoOperationJson.toString();
    }

    public String clientAutoCloseSDK(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_CLIENT_AUTOCLOSE_SDK);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("accessId", InfoDao.getInstance().getAccessId());
            jSONObject.put("sid", IMChat.getInstance().getSessionId());
            jSONObject.put(Constants.FLAG_ACCOUNT, MoorNullUtil.checkNull(GlobalSetDao.getInstance().getGlobalSet().account));
            jSONObject.put("platform", bc.f1472g);
            jSONObject.put(IMChatManager.CONSTANT_SESSIONID, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getLargeMsg(String str, ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        hashMap.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_LARGE_MESSAGE);
        hashMap.put("ConnectionId", MoorUtils.replaceBlank(str));
        hashMap.put("LargeMsgId", arrayList);
        return new MoorJSONWriter().write(hashMap);
    }

    public String getSdkSocketServiceAddress() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_SDK_SOCKET_SERVICEADDRESS);
            jSONObject.put("Platform", "Android");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getTcpServiceAddress(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_TCPSERVICE_ADDRESS);
            jSONObject.put("UserName", str2);
            jSONObject.put("UserId", str3);
            jSONObject.put("AccessId", str);
            jSONObject.put("Platform", "Android");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getUnReadMsgCount(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            String encode = URLEncoder.encode(str2, com.qiniu.android.common.Constants.UTF_8);
            String encode2 = URLEncoder.encode(str3, com.qiniu.android.common.Constants.UTF_8);
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_UNDEAL_MSGCOUNT);
            jSONObject.put("UserName", encode);
            jSONObject.put("UserId", encode2);
            jSONObject.put("AccessId", str);
            jSONObject.put("Platform", com.effective.android.panel.Constants.ANDROID);
            jSONObject.put("DeviceId", MoorUtils.getDeviceId(MoorUtils.getApp()));
            jSONObject.put("NewVersion", "true");
            jSONObject.put("sdkAndroidVersionCode", IMChatManager.getInstance().getsdkAndroidVersionCode());
            jSONObject.put("hhDeviceId", IMChatManager.getInstance().getHhDeviceId());
            jSONObject.put("longtitude", IMChatManager.getInstance().getLongtitude());
            jSONObject.put("latitude", IMChatManager.getInstance().getLatitude());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String hungupVideo(String str, boolean z) {
        JSONObject createVideoOperationJson = createVideoOperationJson(str);
        try {
            createVideoOperationJson.put("operation", "hangup");
            if (z) {
                createVideoOperationJson.put("originator", "agent");
            } else {
                createVideoOperationJson.put("originator", "customer");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return createVideoOperationJson.toString();
    }

    public String newMsgToServer(String str, FromToMessage fromToMessage) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_NEW_MESSAGE);
            if ("text".equals(fromToMessage.msgType)) {
                jSONObject.put("ContentType", "text");
                jSONObject.put("Message", URLEncoder.encode(fromToMessage.message, com.qiniu.android.common.Constants.UTF_8));
            } else if (FromToMessage.MSG_TYPE_IMAGE.equals(fromToMessage.msgType)) {
                jSONObject.put("ContentType", FromToMessage.MSG_TYPE_IMAGE);
                jSONObject.put("Message", URLEncoder.encode(fromToMessage.message, com.qiniu.android.common.Constants.UTF_8));
            } else if ("voice".equals(fromToMessage.msgType)) {
                jSONObject.put("ContentType", "voice");
                jSONObject.put("Message", URLEncoder.encode(fromToMessage.message, com.qiniu.android.common.Constants.UTF_8));
                jSONObject.put("VoiceSecond", fromToMessage.voiceSecond);
                String str2 = fromToMessage.voiceText;
                if (str2 != null) {
                    jSONObject.put("VoiceText", str2);
                } else {
                    jSONObject.put("VoiceText", "");
                }
            } else if ("file".equals(fromToMessage.msgType)) {
                jSONObject.put("ContentType", "file");
                jSONObject.put("Message", URLEncoder.encode(fromToMessage.message + "?fileName=" + fromToMessage.fileName, com.qiniu.android.common.Constants.UTF_8));
            } else if (FromToMessage.MSG_TYPE_CARDINFO.equals(fromToMessage.msgType)) {
                jSONObject.put("ContentType", FromToMessage.MSG_TYPE_CARDINFO);
                jSONObject.put(FromToMessage.MSG_TYPE_CARDINFO, new JSONObject(fromToMessage.cardInfo));
                jSONObject.put("Message", "卡片消息");
            } else if (FromToMessage.MSG_TYPE_NEW_CARD_INFO.equals(fromToMessage.msgType)) {
                jSONObject.put("ContentType", FromToMessage.MSG_TYPE_NEW_CARD_INFO);
                jSONObject.put(FromToMessage.MSG_TYPE_NEW_CARD_INFO, URLEncoder.encode(new JSONObject(fromToMessage.newCardInfo).toString(), com.qiniu.android.common.Constants.UTF_8));
                jSONObject.put("Message", "新类型卡片消息");
            } else if (FromToMessage.MSG_TYPE_LOGISTICS_INFO_LIST.equals(fromToMessage.msgType)) {
                jSONObject.put("ContentType", FromToMessage.MSG_TYPE_LOGISTICS_INFO_LIST);
                jSONObject.put(FromToMessage.MSG_TYPE_LOGISTICS_INFO_LIST, URLEncoder.encode(new JSONObject(fromToMessage.msgTask).toString(), com.qiniu.android.common.Constants.UTF_8));
                if (!TextUtils.isEmpty(fromToMessage.newCardInfo)) {
                    jSONObject.put(FromToMessage.MSG_TYPE_NEW_CARD_INFO, URLEncoder.encode(new JSONObject(fromToMessage.newCardInfo).toString(), com.qiniu.android.common.Constants.UTF_8));
                }
                jSONObject.put("Message", URLEncoder.encode(fromToMessage.message, com.qiniu.android.common.Constants.UTF_8));
            } else if (FromToMessage.MSG_TYPE_XBOT_FORM_SUBMIT.equals(fromToMessage.msgType)) {
                jSONObject.put("ContentType", FromToMessage.MSG_TYPE_XBOT_FORM_SUBMIT);
                jSONObject.put(FromToMessage.MSG_TYPE_XBOT_FORM_SUBMIT, new JSONObject(fromToMessage.xbotFormSubmit).toString());
                jSONObject.put("Message", "提交成功!");
            }
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("thirdPartyUserId", IMChatManager.userId);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            MoorLogUtils.aTag("sendmsg", jSONObject.toString());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String refuseVideo(String str) {
        JSONObject createVideoOperationJson = createVideoOperationJson(str);
        try {
            createVideoOperationJson.put("operation", "refuse");
            createVideoOperationJson.put("originator", "agent");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return createVideoOperationJson.toString();
    }

    public String sdkAcceptOtherAgent(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_ACCEPT_OTHER_AGENT);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            if (str2 != null && !"".equals(str2)) {
                jSONObject.put("ToPeer", str2);
            }
            jSONObject.put("sdkAndroidVersionCode", 2);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkBeginNewChatSession(String str, boolean z, String str2, String str3) {
        JSONObject createBeginNewChatJson = createBeginNewChatJson(str, z, str2, str3);
        MoorLogUtils.aTag("sdkBeginNewChatSession", createBeginNewChatJson.toString());
        return createBeginNewChatJson.toString();
    }

    public String sdkCheckImCsrTimeout(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_CHECK_IMCSR_TIMEOUT);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("timestamp", str);
            jSONObject.put("timeout", str2);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkConvertManual(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_CONVERT_MANUAL);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("peerId", str);
            }
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str2));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            jSONObject.put("thirdPartyUserId", MoorNullUtil.checkNull(InfoDao.getInstance().getUserId()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkDealImMsg(List<String> list) {
        JSONArray jSONArray = new JSONArray((Collection) list);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_DEAL_IM_MSG);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            jSONObject.put("messageIdList", jSONArray);
            MoorLogUtils.aTag("消费坐席发送来的消息", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkDelXbotFormFile(List<String> list) {
        JSONArray jSONArray = new JSONArray((Collection) list);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_QINIU_DelXbotFormFile);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            jSONObject.put("keyList", jSONArray);
            MoorLogUtils.aTag("sdkDelXbotFormFile", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkGetChatSession() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_GET_CHATSESSION);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("sid", IMChat.getInstance().getSessionId());
            jSONObject.put(Constants.FLAG_ACCOUNT, MoorNullUtil.checkNull(GlobalSetDao.getInstance().getGlobalSet().account));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkGetImCsrInvestigate(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_IMCSR_INVESTIGATE);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            jSONObject.put("sdkAndroidVersionCode", IMChatManager.getInstance().getsdkAndroidVersionCode());
            jSONObject.put("SessionId", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkGetInvestigate(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_INVESTIGATE);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkGetMsg(String str, ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        hashMap.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_MESSAGE);
        hashMap.put("ConnectionId", MoorUtils.replaceBlank(str));
        hashMap.put("ReceivedMsgIds", arrayList);
        hashMap.put("AccessId", InfoDao.getInstance().getAccessId());
        if (GlobalSetDao.getInstance().getGlobalSet() != null) {
            hashMap.put(Constants.FLAG_ACCOUNT, MoorNullUtil.checkNull(GlobalSetDao.getInstance().getGlobalSet().account));
        } else {
            hashMap.put(Constants.FLAG_ACCOUNT, "");
        }
        return new MoorJSONWriter().write(hashMap);
    }

    public String sdkGetPeers(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_PEERS);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            MoorLogUtils.aTag("getPeers", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkGetServerTime() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_SERVERTIME);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkGetWebchatGlobleConfig(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_GET_WEBCHAT_GLOBLE_CONFIG);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            MoorLogUtils.aTag("getWebchatGlobleConfig", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkGetXbotMsgTaskInfo(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_SDKGET_XBOTMSG_TASKINFO);
                jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
                jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
                String str2 = null;
                try {
                    str2 = URLEncoder.encode(new JSONObject(str).toString(), com.qiniu.android.common.Constants.UTF_8);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                jSONObject.put(FromToMessage.MSG_TYPE_LOGISTICS_INFO_LIST, str2);
                jSONObject.put("Message", URLEncoder.encode("查看更多商品信息", com.qiniu.android.common.Constants.UTF_8));
                MoorLogUtils.aTag("查看更多==", jSONObject.toString());
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkM7AiRobotCSRInfo(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_M7_AIROBOT_CSRINFO);
            jSONObject.put("botId", str);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            jSONObject.put("whetherToSolve", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkMessageConfirm(String str, ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        hashMap.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_MESSAGE_CONFIRM);
        hashMap.put("ConnectionId", MoorUtils.replaceBlank(str));
        hashMap.put("ReceivedMsgIds", arrayList);
        return new MoorJSONWriter().write(hashMap);
    }

    public String sdkPullQAMsg() {
        JSONObject createPullQAJson = createPullQAJson();
        try {
            createPullQAJson.put("qaType", "queryCatalogListInf");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return createPullQAJson.toString();
    }

    public String sdkPushImVideoToAgent(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_PUSH_IM_VIDEO_TO_AGENT);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkRobotCSRInfo(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_ROBOT_CSRINFO);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            jSONObject.put("whetherToSolve", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkRobotInputSuggest(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_ROBOT_INPUT_SUGGEST);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("robotId", IMChat.getInstance().getRobotId());
            jSONObject.put("robotType", str2);
            jSONObject.put("keyword", str3);
            jSONObject.put("cateIds", IMChat.getInstance().getCateId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkSendRobotCsr(String str, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_SEND_ROBOT_CSR);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("questionId", str2);
            jSONObject.put("robotType", str3);
            jSONObject.put("robotId", str4);
            jSONObject.put("robotMsgId", str5);
            jSONObject.put("feedback", str6);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkSubmitInvestigate(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_SUBMIT_INVESTIGATE);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("Name", str2);
            jSONObject.put("Value", str3);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkSubmitInvestigateForDailog(String str, String str2, String str3, String str4, String str5, List<String> list, String str6) {
        String str7;
        StringBuffer stringBuffer = new StringBuffer();
        if (list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            String stringBuffer2 = stringBuffer.toString();
            str7 = stringBuffer2.substring(0, stringBuffer2.length() - 1);
        } else {
            str7 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_SUBMIT_INVESTIGATE);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str3));
            jSONObject.put("Name", str4);
            jSONObject.put("Value", str5);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            jSONObject.put("Proposal", str6);
            jSONObject.put("Label", str7);
            jSONObject.put("way", str2);
            jSONObject.put(IMChatManager.CONSTANT_SESSIONID, str);
            if (!TextUtils.isEmpty(IMChat.getInstance().getNewinvestigate())) {
                jSONObject.put("operationDetail", IMChat.getInstance().getNewinvestigate());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkSubmitLeaveMessage(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_SUBMIT_LEAVEMESSAGE);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("Message", str3);
            jSONObject.put("Phone", str4);
            jSONObject.put("Email", str5);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            if (str2 != null && !"".equals(str2)) {
                jSONObject.put("ToPeer", str2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkTypeNotice(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_TYPE_NOTICE);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("accessId", InfoDao.getInstance().getAccessId());
            jSONObject.put("content", str);
            MoorLogUtils.aTag("sendTypingStatus", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkUseNewConnection() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_USE_NEWCONNECTION);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
            MoorLogUtils.aTag("tcp or ws", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkVoiceToText(String str, String str2, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_VOICE_TO_TEXT);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(InfoDao.getInstance().getConnectionId()));
            jSONObject.put("sid", IMChat.getInstance().getSessionId());
            jSONObject.put("messageId", str);
            jSONObject.put("accountId", GlobalSetDao.getInstance().getGlobalSet().account);
            jSONObject.put("filePath", str2);
            jSONObject.put(RemoteMessageConst.Notification.WHEN, j2);
            jSONObject.put("platform", bc.f1472g);
            MoorLogUtils.aTag("语音转文本", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkXbotAnswerCsr(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_SEND_ROBOT_CSR);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("questionId", str2);
            jSONObject.put("robotType", str3);
            jSONObject.put("robotId", str4);
            jSONObject.put("sid", str6);
            jSONObject.put("confidence", str10);
            jSONObject.put("answer", str9);
            jSONObject.put("kf_icon_chat_question", str8);
            jSONObject.put("ori_question", str7);
            jSONObject.put("feedback", str5);
            jSONObject.put("xbotSessionId", str11);
            jSONObject.put("question", str12);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String userOffline(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_USER_OFFLINE);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private YKFHttpParams() {
    }

    public String sdkPullQAMsg(String str, int i2, int i3) {
        JSONObject createPullQAJson = createPullQAJson();
        try {
            createPullQAJson.put("qaType", "queryItemListInf");
            createPullQAJson.put("cid", str);
            createPullQAJson.put("page", i2);
            createPullQAJson.put("limit", i3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return createPullQAJson.toString();
    }

    public String sdkPushImVideoToAgent(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_PUSH_IM_VIDEO_TO_AGENT);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("newVideo", true);
            jSONObject.put("videoType", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkPullQAMsg(String str, String str2) {
        JSONObject createPullQAJson = createPullQAJson();
        try {
            createPullQAJson.put("qaType", "getKmDetailInf");
            createPullQAJson.put("qaItemInfoId", str);
            createPullQAJson.put("content", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return createPullQAJson.toString();
    }

    public String sdkSendRobotCsr(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_SEND_ROBOT_CSR);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("questionId", str2);
            jSONObject.put("robotType", str3);
            jSONObject.put("robotId", str4);
            jSONObject.put("feedback", str5);
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String sdkSubmitLeaveMessage(String str, String str2, String str3, HashMap<String, String> hashMap, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, YKFUrlConstants.SDK_SUBMIT_LEAVEMESSAGE);
            jSONObject.put("ConnectionId", MoorUtils.replaceBlank(str));
            jSONObject.put("Message", str3);
            for (String str4 : hashMap.keySet()) {
                jSONObject.put(str4, hashMap.get(str4));
            }
            jSONObject.put("leavemsgFields", jSONArray);
            if (str2 != null && !"".equals(str2)) {
                jSONObject.put("ToPeer", str2);
            }
            jSONObject.put("AccessId", InfoDao.getInstance().getAccessId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
