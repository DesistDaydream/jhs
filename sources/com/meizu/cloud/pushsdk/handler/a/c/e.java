package com.meizu.cloud.pushsdk.handler.a.c;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e {
    private int a;
    private String b = String.valueOf(-1);

    /* renamed from: c  reason: collision with root package name */
    private String f4903c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f4904d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f4905e = -1;

    /* renamed from: f  reason: collision with root package name */
    private String f4906f = "";

    /* loaded from: classes2.dex */
    public static class a {
        public String a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f4907c;

        public a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("code")) {
                    a(jSONObject.getString("code"));
                }
                if (!jSONObject.isNull("message")) {
                    b(jSONObject.getString("message"));
                }
                if (jSONObject.isNull("value")) {
                    return;
                }
                c(jSONObject.getString("value"));
            } catch (JSONException e2) {
                e.p.a.a.a.f("SecurityMessage", "covert json error " + e2.getMessage());
            }
        }

        public String a() {
            return this.f4907c;
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.f4907c = str;
        }

        public String toString() {
            return "PublicKeyStatus{code='" + this.a + "', message='" + this.b + "', publicKey='" + this.f4907c + "'}";
        }
    }

    public static String a(MessageV3 messageV3) {
        JSONObject jSONObject;
        String notificationMessage = messageV3.getNotificationMessage();
        String str = null;
        try {
            try {
                if (!TextUtils.isEmpty(notificationMessage)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(notificationMessage).getJSONObject("data");
                        if (!jSONObject2.isNull("extra")) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("extra");
                            if (!jSONObject3.isNull("se")) {
                                str = jSONObject3.getString("se");
                            }
                        }
                    } catch (JSONException e2) {
                        e.p.a.a.a.f("SecurityMessage", "parse notification message error " + e2.getMessage());
                        if (TextUtils.isEmpty(null)) {
                            jSONObject = new JSONObject(notificationMessage);
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        jSONObject = new JSONObject(notificationMessage);
                        jSONObject.getString("se");
                    }
                }
            } catch (Exception unused) {
            }
            e.p.a.a.a.c("SecurityMessage", "encrypt message " + str);
            return str;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(null)) {
                try {
                    new JSONObject(notificationMessage).getString("se");
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean a(String str, MessageV3 messageV3) {
        String str2;
        e e2 = e(str);
        e.p.a.a.a.f("SecurityMessage", "securityMessage " + e2);
        if (System.currentTimeMillis() / 1000 > e2.a()) {
            str2 = "message expire";
        } else if (!messageV3.getTitle().contains(e2.c())) {
            str2 = "invalid title";
        } else if (!messageV3.getContent().contains(e2.d())) {
            str2 = "invalid content";
        } else if (!String.valueOf(-1).equals(e2.b()) && !e2.b().equals(messageV3.getTaskId())) {
            str2 = "invalid taskId";
        } else if (e2.e() != -1) {
            int e3 = e2.e();
            if (e3 == 1) {
                if (!messageV3.getActivity().contains(e2.f())) {
                    str2 = "invalid click activity";
                }
                return true;
            } else if (e3 == 2) {
                if (!messageV3.getWebUrl().contains(e2.f())) {
                    str2 = "invalid web url";
                }
                return true;
            } else {
                if (e3 == 3 && !MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString().contains(e2.f())) {
                    str2 = "invalid self define";
                }
                return true;
            }
        } else {
            str2 = "invalid click type";
        }
        e.p.a.a.a.f("SecurityMessage", str2);
        return false;
    }

    private static e e(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)) {
                eVar.a(jSONObject.getInt(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP));
            }
            if (!jSONObject.isNull("ti")) {
                eVar.a(jSONObject.getString("ti"));
            }
            if (!jSONObject.isNull("tl")) {
                eVar.b(jSONObject.getString("tl"));
            }
            if (!jSONObject.isNull("cont")) {
                eVar.c(jSONObject.getString("cont"));
            }
            if (!jSONObject.isNull("ct")) {
                eVar.b(jSONObject.getInt("ct"));
            }
            if (!jSONObject.isNull("pm")) {
                eVar.d(jSONObject.getString("pm"));
            }
        } catch (Exception e2) {
            e.p.a.a.a.f("SecurityMessage", "parse decryptSign error " + e2.getMessage());
        }
        return eVar;
    }

    public int a() {
        return this.a;
    }

    public void a(int i2) {
        this.a = i2;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(int i2) {
        this.f4905e = i2;
    }

    public void b(String str) {
        this.f4903c = str;
    }

    public String c() {
        return this.f4903c;
    }

    public void c(String str) {
        this.f4904d = str;
    }

    public String d() {
        return this.f4904d;
    }

    public void d(String str) {
        this.f4906f = str;
    }

    public int e() {
        return this.f4905e;
    }

    public String f() {
        return this.f4906f;
    }

    public String toString() {
        return "SecurityMessage{timestamp=" + this.a + ", taskId='" + this.b + "', title='" + this.f4903c + "', content='" + this.f4904d + "', clickType=" + this.f4905e + ", params='" + this.f4906f + "'}";
    }
}
