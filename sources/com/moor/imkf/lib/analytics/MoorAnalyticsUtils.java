package com.moor.imkf.lib.analytics;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.moor.imkf.lib.MoorBaseLibManager;
import com.moor.imkf.lib.analytics.bean.MoorAnalyticsBean;
import com.moor.imkf.lib.analytics.bean.MoorAnalyticsResult;
import com.moor.imkf.lib.analytics.http.MoorAnalyticsHttpUtils;
import com.moor.imkf.lib.constants.MoorBaseConstants;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.lib.utils.sharedpreferences.MoorSPUtils;
import com.umeng.analytics.pro.am;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MoorAnalyticsUtils {
    private static final String ANALYTICSURL = "https://u.zhugeapi.com/open/v2/event_statis_srv/upload_event";
    public static String AppBase64 = "";
    public static String Appid = "";

    public static void addRecordAnalytics(String str, String str2, Long l2, String str3, HashMap<String, String> hashMap) {
        String createAnalyticsBean = createAnalyticsBean(str, str2, l2, str3, hashMap);
        if (TextUtils.isEmpty(createAnalyticsBean)) {
            return;
        }
        MoorAnalyticsBean moorAnalyticsBean = new MoorAnalyticsBean();
        moorAnalyticsBean.setAnalyticsStr(createAnalyticsBean);
        MoorRecordAnalyticsThread.getInstance().postAddRecord(moorAnalyticsBean);
    }

    public static String createAnalyticsBean(String str, String str2, Long l2, String str3, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(Appid) || TextUtils.isEmpty(AppBase64)) {
            Appid = MoorSPUtils.getInstance().getString(MoorBaseConstants.ANALYTICS_APP_ID, Appid);
            AppBase64 = MoorSPUtils.getInstance().getString(MoorBaseConstants.ANALYTICS_APP_BASE64, Appid);
        }
        if (!TextUtils.isEmpty(Appid) && !TextUtils.isEmpty(AppBase64) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str2.length() > 120) {
                str2 = str2.substring(0, 120);
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.put("ak", Appid);
                jSONObject.put("dt", "evt");
                jSONObject.put(am.az, "and");
                if (MoorBaseLibManager.getInstance().isDebug()) {
                    jSONObject.put("debug", 1);
                }
                jSONObject2.put("$ct", System.currentTimeMillis());
                jSONObject2.put("$eid", str);
                jSONObject2.put("$cuid", str2);
                jSONObject2.put("$sid", l2);
                jSONObject2.put("$vn", str3);
                if (hashMap != null) {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject3.put("did", str2);
                jSONObject2.put("usr", jSONObject3);
                jSONObject.put(am.ay, jSONObject2);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static String getAppBase64() {
        if (TextUtils.isEmpty(Appid) || TextUtils.isEmpty(AppBase64)) {
            Appid = MoorSPUtils.getInstance().getString(MoorBaseConstants.ANALYTICS_APP_ID, Appid);
            AppBase64 = MoorSPUtils.getInstance().getString(MoorBaseConstants.ANALYTICS_APP_BASE64, Appid);
        }
        return AppBase64;
    }

    public static void send(String str, MoorAnalyticsSendListener moorAnalyticsSendListener) {
        OkHttpClient okHttpClient;
        MoorAnalyticsResult moorAnalyticsResult;
        if (TextUtils.isEmpty(str) || moorAnalyticsSendListener == null || (okHttpClient = MoorAnalyticsHttpUtils.getInstance().getOkHttpClient()) == null) {
            return;
        }
        try {
            String string = okHttpClient.newCall(new Request.Builder().addHeader("Authorization", getAppBase64()).url(ANALYTICSURL).post(RequestBody.create(MediaType.parse("application/json"), str)).build()).execute().body().string();
            if (!TextUtils.isEmpty(string) && (moorAnalyticsResult = (MoorAnalyticsResult) new Gson().n(string, MoorAnalyticsResult.class)) != null && moorAnalyticsResult.getReturn_code() == 0 && moorAnalyticsSendListener != null) {
                MoorLogUtils.e("AnalyticsSend", "ok");
                moorAnalyticsSendListener.onSuccess();
            } else if (moorAnalyticsSendListener != null) {
                MoorLogUtils.e("AnalyticsSend", string);
                moorAnalyticsSendListener.onFail();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (moorAnalyticsSendListener != null) {
                MoorLogUtils.e("AnalyticsSend", e2.toString());
                moorAnalyticsSendListener.onFail();
            }
        }
    }

    public static void setAnalyticsKeys(String str, String str2) {
        Appid = str;
        AppBase64 = str2;
        MoorSPUtils.getInstance().put(MoorBaseConstants.ANALYTICS_APP_ID, Appid, true);
        MoorSPUtils.getInstance().put(MoorBaseConstants.ANALYTICS_APP_BASE64, AppBase64, true);
    }
}
