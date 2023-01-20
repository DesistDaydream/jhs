package com.moor.imkf.http;

import android.text.TextUtils;
import com.moor.imkf.lib.http.callback.MoorStringCallback;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.listener.HttpResponseListener;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.requesturl.RequestUrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.Call;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class HttpManager {
    public static void acceptOtherAgent(String str, String str2, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkAcceptOtherAgent(str, str2), httpResponseListener);
    }

    public static void acceptVideo(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().acceptVideo(str), httpResponseListener);
    }

    public static void beginNewChatSession(String str, boolean z, String str2, String str3, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkBeginNewChatSession(str, z, str2, str3), httpResponseListener);
    }

    public static void beginNewScheduleChatSession(String str, boolean z, String str2, String str3, String str4, String str5, String str6, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().beginNewScheduleChatSession(str, z, str2, str3, str4, str5, str6), httpResponseListener);
    }

    public static void beginNewVipOfflineScheduleChatSession(String str, boolean z, String str2, String str3, String str4, String str5, String str6, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().beginNewVipOfflineScheduleChatSession(str, z, str2, str3, str4, str5, str6), httpResponseListener);
    }

    public static void beginNewVipOfflineSession(String str, boolean z, String str2, String str3, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().beginNewVipOfflineSession(str, z, str2, str3), httpResponseListener);
    }

    public static void cancelRequest() {
        MoorHttpUtils.getInstance().cancelAll();
    }

    public static void cancelVideo(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().cancelVideo(str), httpResponseListener);
    }

    public static void checkImCsrTimeout(String str, String str2, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkCheckImCsrTimeout(str, str2), httpResponseListener);
    }

    public static void checkIsAppraised(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkGetImCsrInvestigate(str), httpResponseListener);
    }

    public static void convertManual(String str, String str2, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkConvertManual(str, str2), httpResponseListener);
    }

    public static void delXbotFormFile(List<String> list, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkDelXbotFormFile(list), httpResponseListener);
    }

    public static void getChatSession(HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkGetChatSession(), httpResponseListener);
    }

    public static void getChatclientAutoClose(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().clientAutoCloseSDK(str), httpResponseListener);
    }

    public static void getDetailQuestions(String str, int i2, int i3, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkPullQAMsg(str, i2, i3), httpResponseListener);
    }

    public static void getInvestigateList(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkGetInvestigate(str), httpResponseListener);
    }

    public static void getLargeMsgs(String str, ArrayList arrayList, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().getLargeMsg(str, arrayList), httpResponseListener);
    }

    public static void getMoreOrderInfo(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkGetXbotMsgTaskInfo(str), httpResponseListener);
    }

    public static void getMsg(String str, ArrayList arrayList, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkGetMsg(str, arrayList), httpResponseListener);
    }

    public static void getMsgACK(String str, ArrayList arrayList, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkMessageConfirm(str, arrayList), httpResponseListener);
    }

    public static void getPeers(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkGetPeers(str), httpResponseListener);
    }

    public static void getQiNiuToken(String str, String str2, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().QiNiuGetUpToken(str, str2), httpResponseListener);
    }

    public static void getRobotCsrInfo(String str, String str2, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkM7AiRobotCSRInfo(str, str2), httpResponseListener);
    }

    public static void getSdkSocketServiceAddress(HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().getSdkSocketServiceAddress(), httpResponseListener);
    }

    public static void getServerTime(HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkGetServerTime(), httpResponseListener);
    }

    public static void getTCPorWS(HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkUseNewConnection(), httpResponseListener);
    }

    public static void getTabCommonQuestions(HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkPullQAMsg(), httpResponseListener);
    }

    public static void getTcpServiceAddress(String str, String str2, String str3, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().getTcpServiceAddress(str, str2, str3), httpResponseListener);
    }

    public static void getUnReadMsgCount(String str, String str2, String str3, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().getUnReadMsgCount(str, str2, str3), httpResponseListener);
    }

    public static void getWebchatGlobleConfig(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkGetWebchatGlobleConfig(str), httpResponseListener);
    }

    public static void hungupVideo(String str, boolean z, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().hungupVideo(str, z), httpResponseListener);
    }

    public static void newMsgToServer(String str, FromToMessage fromToMessage, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().newMsgToServer(str, fromToMessage), httpResponseListener);
    }

    public static void offline(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().userOffline(str), httpResponseListener);
    }

    private static void post(String str, final HttpResponseListener httpResponseListener) {
        if (TextUtils.isEmpty(RequestUrl.BASE_HTTP)) {
            MoorLogUtils.eTag("请求失败", "检查初始化之前有没有调用RequestUrl.setRequestUrl()或RequestUrl.setRequestUrl()");
        } else {
            MoorHttpUtils.post().url(RequestUrl.BASE_HTTP).addParams("data", str).build().execute(new MoorStringCallback() { // from class: com.moor.imkf.http.HttpManager.1
                @Override // com.moor.imkf.lib.http.callback.MoorCallback
                public void onError(Call call, Exception exc, int i2) {
                    HttpResponseListener httpResponseListener2 = HttpResponseListener.this;
                    if (httpResponseListener2 != null) {
                        httpResponseListener2.onFailed();
                    }
                }

                @Override // com.moor.imkf.lib.http.callback.MoorCallback
                public void onResponse(String str2, int i2) {
                    HttpResponseListener httpResponseListener2 = HttpResponseListener.this;
                    if (httpResponseListener2 != null) {
                        httpResponseListener2.onSuccess(str2);
                    }
                }
            });
        }
    }

    public static void pushImVideoToAgent(String str, String str2, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkPushImVideoToAgent(str, str2), httpResponseListener);
    }

    public static void queryLianXiangData(String str, String str2, String str3, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkRobotInputSuggest(str, str2, str3), httpResponseListener);
    }

    public static void refuseVideo(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().refuseVideo(str), httpResponseListener);
    }

    public static void sdkDealImMsg(List<String> list, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkDealImMsg(list), httpResponseListener);
    }

    public static void sendQuestionMsg(String str, String str2, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkPullQAMsg(str, str2), httpResponseListener);
    }

    public static void sendRobotCsr(String str, String str2, String str3, String str4, String str5, String str6, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkSendRobotCsr(str, str2, str3, str4, str5, str6), httpResponseListener);
    }

    public static void sendTypingStatus(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkTypeNotice(str), httpResponseListener);
    }

    public static void sendVoiceToText(String str, String str2, long j2, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkVoiceToText(str, str2, j2), httpResponseListener);
    }

    public static void submitInvestigate(String str, String str2, String str3, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkSubmitInvestigate(str, str2, str3), httpResponseListener);
    }

    public static void submitOfflineMessage(String str, String str2, String str3, String str4, String str5, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkSubmitLeaveMessage(str, str2, str3, str4, str5), httpResponseListener);
    }

    public static void getRobotCsrInfo(String str, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkRobotCSRInfo(str), httpResponseListener);
    }

    public static void sendRobotCsr(String str, String str2, String str3, String str4, String str5, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkSendRobotCsr(str, str2, str3, str4, str5), httpResponseListener);
    }

    public static void submitInvestigate(String str, String str2, String str3, String str4, String str5, List<String> list, String str6, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkSubmitInvestigateForDailog(str, str2, str3, str4, str5, list, str6), httpResponseListener);
    }

    public static void submitOfflineMessage(String str, String str2, String str3, HashMap<String, String> hashMap, JSONArray jSONArray, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkSubmitLeaveMessage(str, str2, str3, hashMap, jSONArray), httpResponseListener);
    }

    public static void sendRobotCsr(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, HttpResponseListener httpResponseListener) {
        post(YKFHttpParams.getInstance().sdkXbotAnswerCsr(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12), httpResponseListener);
    }
}
