package com.tencent.android.tpush.message;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d extends com.tencent.android.tpush.message.a {
    private int A;
    private int B;

    /* renamed from: d */
    private int f6158d;

    /* renamed from: e */
    private int f6159e;

    /* renamed from: f */
    private int f6160f;

    /* renamed from: g */
    private int f6161g;

    /* renamed from: h */
    private int f6162h;

    /* renamed from: i */
    private int f6163i;

    /* renamed from: j */
    private String f6164j;

    /* renamed from: k */
    private int f6165k;

    /* renamed from: l */
    private String f6166l;

    /* renamed from: m */
    private String f6167m;
    private int n;
    private int o;
    private String p;
    private String q;
    private String r;
    private int s;
    private String t;
    private a u;
    private int v;
    private String w;
    private String x;
    private int y;
    private String z;

    /* loaded from: classes3.dex */
    public static class a {
        public int a = NotificationAction.activity.getType();
        public String b = "";

        /* renamed from: c */
        public C0222a f6168c = new C0222a();

        /* renamed from: d */
        public String f6169d = "";

        /* renamed from: e */
        public String f6170e = "";

        /* renamed from: f */
        public String f6171f = "";

        /* renamed from: g */
        public int f6172g = 0;

        /* renamed from: h */
        public String f6173h = "";

        /* renamed from: i */
        public String f6174i = "";

        /* renamed from: j */
        public String f6175j = "";

        /* renamed from: com.tencent.android.tpush.message.d$a$a */
        /* loaded from: classes3.dex */
        public static class C0222a {
            public int a = 0;
            public int b = 0;
        }

        public void a(String str) {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(Constants.FLAG_ACTION_TYPE)) {
                this.a = jSONObject.getInt(Constants.FLAG_ACTION_TYPE);
            }
            if (!jSONObject.isNull("activity")) {
                this.b = jSONObject.getString("activity");
            }
            if (!jSONObject.isNull("aty_attr")) {
                String optString = jSONObject.optString("aty_attr");
                if (!i.b(optString)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        this.f6168c.a = jSONObject2.optInt("if");
                        this.f6168c.b = jSONObject2.optInt("pf");
                    } catch (Throwable th) {
                        TLogger.e("PushMessageAction", "decode activityAttribute error", th);
                    }
                }
            }
            if (!jSONObject.isNull(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
                this.f6169d = jSONObject.getString(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            }
            if (!jSONObject.isNull("browser")) {
                this.f6170e = jSONObject.getString("browser");
                JSONObject jSONObject3 = new JSONObject(this.f6170e);
                if (!jSONObject3.isNull("url")) {
                    this.f6171f = jSONObject3.getString("url");
                }
                if (!jSONObject3.isNull("confirm")) {
                    this.f6172g = jSONObject3.getInt("confirm");
                }
            }
            if (jSONObject.isNull("package_name")) {
                return;
            }
            this.f6174i = jSONObject.getString("package_name");
            JSONObject jSONObject4 = new JSONObject(this.f6174i);
            if (!jSONObject4.isNull(Constants.FLAG_PACKAGE_DOWNLOAD_URL)) {
                this.f6175j = jSONObject4.getString(Constants.FLAG_PACKAGE_DOWNLOAD_URL);
            }
            if (!jSONObject4.isNull(Constants.FLAG_PACKAGE_NAME)) {
                this.f6173h = jSONObject4.getString(Constants.FLAG_PACKAGE_NAME);
            }
            if (jSONObject4.isNull("confirm")) {
                return;
            }
            this.f6172g = jSONObject4.getInt("confirm");
        }
    }

    public d(String str) {
        super(str);
        this.f6158d = 0;
        this.f6159e = 1;
        this.f6160f = 1;
        this.f6161g = 1;
        this.f6162h = 0;
        this.f6163i = 0;
        this.f6164j = "";
        this.f6165k = 1;
        this.f6166l = "";
        this.f6167m = "";
        this.n = 0;
        this.o = 0;
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = 2;
        this.t = "";
        this.u = new a();
        this.v = -1;
        this.w = "";
        this.x = "";
        this.y = 0;
        this.z = "";
        this.A = 0;
        this.B = 0;
    }

    public String A() {
        return this.x;
    }

    public int B() {
        return this.y;
    }

    public String C() {
        return this.z;
    }

    public int D() {
        return this.A;
    }

    public int E() {
        return this.B;
    }

    @Override // com.tencent.android.tpush.message.a
    public int b() {
        return 1;
    }

    @Override // com.tencent.android.tpush.message.a
    public void c() {
        this.f6158d = this.a.optInt(MessageKey.MSG_BUILDER_ID);
        this.f6159e = this.a.optInt(MessageKey.MSG_RING, 1);
        this.f6166l = this.a.optString(MessageKey.MSG_RING_RAW);
        this.f6164j = this.a.optString(MessageKey.MSG_ICON_RES);
        this.f6167m = this.a.optString(MessageKey.MSG_SMALL_ICON);
        this.f6165k = this.a.optInt(MessageKey.MSG_LIGHTS, 1);
        this.f6160f = this.a.optInt(MessageKey.MSG_VIBRATE, 1);
        this.f6163i = this.a.optInt("icon");
        this.n = this.a.optInt(MessageKey.MSG_ICON_TYPE, 0);
        this.f6162h = this.a.optInt(MessageKey.MSG_NOTIFY_ID);
        this.o = this.a.optInt(MessageKey.MSG_STYLE_ID, 0);
        this.r = this.a.optString(MessageKey.MSG_RICH_URL, null);
        this.t = this.a.optString(MessageKey.MSG_AUDIO_URL, null);
        this.p = this.a.optString(MessageKey.MSG_NOTIFACTION_ID_CHANNEL_ID);
        this.q = this.a.optString(MessageKey.MSG_NOTIFACTION_ID_CHANNEL_NAME);
        this.s = this.a.optInt(MessageKey.NOTIFICATION_DISPLAY_MODEL, 2);
        this.y = this.a.optInt("color", 0);
        if (!this.a.isNull(MessageKey.MSG_CLEARABLE)) {
            this.f6161g = this.a.optInt(MessageKey.MSG_CLEARABLE);
        } else {
            this.f6161g = 1;
        }
        if (!this.a.isNull("action")) {
            this.u.a(this.a.getString("action"));
        }
        this.v = this.a.optInt(MessageKey.MSG_BADGE_TYPE, -1);
        this.w = this.a.optString("thread_id");
        this.x = this.a.optString(MessageKey.MSG_THREAD_SUMTEXT);
        String optString = this.a.optString(MessageKey.CUSTOM_LAYOUT_JSON_STR);
        this.z = optString;
        try {
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.z);
            this.A = jSONObject.optInt(MessageKey.CUSTOM_LAYOUT_LAYOUT_TYPE, 0);
            this.B = jSONObject.optInt(MessageKey.CUSTOM_LAYOUT_USE_STD_STYLE, 0);
        } catch (Throwable th) {
            TLogger.w("NotificationMessageHolder", "parse customLayoutJsonStr error: " + th.toString());
        }
    }

    public int g() {
        return this.f6158d;
    }

    public int h() {
        return this.f6159e;
    }

    public int i() {
        return this.f6160f;
    }

    public int j() {
        return this.f6161g;
    }

    public int k() {
        return this.f6162h;
    }

    public a l() {
        return this.u;
    }

    public int m() {
        return this.f6163i;
    }

    public String n() {
        return this.r;
    }

    public String o() {
        return this.t;
    }

    public int p() {
        return this.f6165k;
    }

    public String q() {
        return this.f6166l;
    }

    public String r() {
        return this.f6164j;
    }

    public String s() {
        return this.f6167m;
    }

    public int t() {
        return this.n;
    }

    public int u() {
        return this.o;
    }

    public String v() {
        return this.p;
    }

    public String w() {
        return this.q;
    }

    public int x() {
        return this.s;
    }

    public int y() {
        return this.v;
    }

    public String z() {
        return this.w;
    }
}
