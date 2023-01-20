package cn.thinkingdata.android.aop.push;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import cn.thinkingdata.android.utils.TDLog;
import e.t.c;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TAPushTrackHelper {
    private static final String TAG = "ThinkingAnalytics";

    private static String getTAData(String str) {
        return str;
    }

    public static void onNewIntent(Object obj, Intent intent) {
        try {
            if (obj instanceof Activity) {
                TAPushProcess.getInstance().onNotificationClick((Activity) obj, intent);
            }
        } catch (Exception e2) {
            TDLog.e("ThinkingAnalytics", e2.getMessage());
        }
    }

    public static void trackGeTuiNotification(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            String str = (String) obj.getClass().getMethod("getMessageId", new Class[0]).invoke(obj, new Object[0]);
            String str2 = (String) obj.getClass().getMethod("getTitle", new Class[0]).invoke(obj, new Object[0]);
            String str3 = (String) obj.getClass().getMethod("getContent", new Class[0]).invoke(obj, new Object[0]);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return;
            }
            TAPushProcess.getInstance().trackGTDelayed(str, str2, str3);
        } catch (Exception e2) {
            TDLog.e("ThinkingAnalytics", e2.getMessage());
        }
    }

    public static void trackGeTuiNotificationClicked(String str, String str2, String str3, long j2) {
        trackNotificationClickedEvent(str3, str, str2, "GeTui", null, j2);
        TDLog.i("ThinkingAnalytics", String.format("GEITUI is called, title is %s, content is %s, extras is %s", str, str2, str3));
    }

    public static void trackGeTuiReceiveMessageData(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            byte[] bArr = (byte[]) obj.getClass().getMethod("getPayload", new Class[0]).invoke(obj, new Object[0]);
            String str = (String) obj.getClass().getMethod("getMessageId", new Class[0]).invoke(obj, new Object[0]);
            if (bArr == null || TextUtils.isEmpty(str)) {
                return;
            }
            TAPushProcess.getInstance().trackGeTuiReceiveMessageData(new String(bArr), str);
        } catch (Exception e2) {
            TDLog.e("ThinkingAnalytics", e2.getMessage());
        }
    }

    public static void trackJPushClickNotification(String str, String str2, String str3, String str4) {
        TDLog.i("ThinkingAnalytics", "extras:" + str);
        TDLog.i("ThinkingAnalytics", "title:" + str2);
        TDLog.i("ThinkingAnalytics", "content:" + str3);
        TDLog.i("ThinkingAnalytics", "appPushChannel:" + str4);
        trackNotificationClickedEvent(getTAData(str), str2, str3, "JPush", str4);
    }

    public static void trackJPushOpenActivity(Intent intent) {
        if (intent == null) {
            return;
        }
        JSONObject jSONObject = null;
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        TDLog.i("ThinkingAnalytics", "Intent data :" + uri);
        if (TextUtils.isEmpty(uri)) {
            return;
        }
        try {
            jSONObject = new JSONObject(uri);
        } catch (Exception unused) {
        }
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("n_title");
                String optString2 = jSONObject.optString("n_content");
                String optString3 = jSONObject.optString("n_extras");
                String jPushSource = TAPushUtils.getJPushSource(jSONObject.optInt("rom_type"));
                TDLog.i("ThinkingAnalytics", String.format("JPush is called, title is %s, content is %s, extras is %s, appPushChannel is %s", optString, optString2, optString3, jPushSource));
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(jPushSource)) {
                    trackNotificationClickedEvent(getTAData(optString3), optString, optString2, "JPush", jPushSource);
                }
            } catch (Exception e2) {
                TDLog.e("ThinkingAnalytics", e2.getMessage());
            }
        }
    }

    public static void trackMeizuNotification(String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        TDLog.i("ThinkingAnalytics", String.format("meizu is called, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s", str2, str3, str, c.b, str4));
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            try {
                if (jSONObject.has("JMessageExtra")) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("JMessageExtra");
                    if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("m_content")) != null) {
                        str = optJSONObject.optString("n_extras");
                    }
                    str4 = "JPush";
                }
            } catch (Exception unused2) {
            }
        }
        try {
            trackNotificationClickedEvent(getTAData(str), str2, str3, str4, c.b);
        } catch (Exception unused3) {
        }
    }

    public static void trackNotificationClickedEvent(String str, String str2, String str3, String str4, String str5) {
        trackNotificationClickedEvent(str, str2, str3, str4, str5, 0L);
    }

    private static void trackNotificationClickedEvent(String str, String str2, String str3, String str4, String str5, long j2) {
    }

    public static void trackUMengActivityNotification(Intent intent) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        if (intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("body");
            if (TextUtils.isEmpty(stringExtra) || (optJSONObject = (jSONObject = new JSONObject(stringExtra)).optJSONObject("body")) == null) {
                return;
            }
            String optString = jSONObject.optString("extra");
            String optString2 = optJSONObject.optString("title");
            String optString3 = optJSONObject.optString("text");
            String stringExtra2 = intent.getStringExtra("message_source");
            trackNotificationClickedEvent(getTAData(optString), optString2, optString3, "UMeng", stringExtra2);
            TDLog.i("ThinkingAnalytics", String.format("onUMengActivityMessage is called, title is %s, content is %s, extras is %ssource is %s", optString2, optString3, optString, stringExtra2));
        } catch (Exception e2) {
            TDLog.e("ThinkingAnalytics", e2.getMessage());
        }
    }

    public static void trackUmengClickNotification(Object obj) {
        JSONObject optJSONObject;
        if (obj == null) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) obj.getClass().getDeclaredMethod("getRaw", new Class[0]).invoke(obj, new Object[0]);
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("body")) == null) {
                return;
            }
            String optString = jSONObject.optString("extra");
            String optString2 = optJSONObject.optString("title");
            String optString3 = optJSONObject.optString("text");
            trackNotificationClickedEvent(getTAData(optString), optString2, optString3, "UMeng", null);
            TDLog.i("ThinkingAnalytics", String.format("UMengClick is called, title is %s, content is %s, extras is %s", optString2, optString3, optString));
        } catch (Exception e2) {
            TDLog.i("ThinkingAnalytics", e2.getMessage());
        }
    }
}
