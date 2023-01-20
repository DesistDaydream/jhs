package com.tencent.android.tpush.message;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Md5;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class a {
    public String b;
    public JSONObject a = null;

    /* renamed from: c  reason: collision with root package name */
    public String f6145c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f6146d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f6147e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f6148f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f6149g = null;

    public a(String str) {
        this.b = null;
        this.b = str;
    }

    public void a() {
        String optString;
        try {
            this.a = new JSONObject(this.b);
        } catch (Throwable unused) {
            try {
                try {
                    try {
                        try {
                            String str = this.b;
                            this.a = new JSONObject(str.substring(str.indexOf("{"), this.b.lastIndexOf("}") + 1));
                        } catch (Throwable unused2) {
                            this.a = new JSONObject(this.b.substring(1));
                        }
                    } catch (Throwable unused3) {
                        this.a = new JSONObject(this.b.substring(2));
                    }
                } catch (Throwable unused4) {
                    this.a = new JSONObject(this.b.substring(3));
                }
            } catch (Throwable unused5) {
                TLogger.d("BaseMessageHolder", "unexpected for decode");
            }
        }
        try {
            if (!this.a.isNull("title")) {
                this.f6146d = this.a.getString("title");
            }
            if (!this.a.isNull("content")) {
                this.f6147e = this.a.getString("content");
            }
            if (!this.a.isNull("custom_content") && (optString = this.a.optString("custom_content", "")) != null && !optString.trim().equals("{}")) {
                this.f6148f = optString;
            }
            if (!this.a.isNull("accept_time")) {
                this.f6149g = this.a.optString("accept_time", "");
            }
        } catch (Throwable unused6) {
            TLogger.d("BaseMessageHolder", "unexpected for decode");
        }
        c();
        this.f6145c = Md5.md5(this.b).toUpperCase();
    }

    public abstract int b();

    public abstract void c();

    public String d() {
        return this.f6146d;
    }

    public String e() {
        return this.f6147e;
    }

    public String f() {
        return this.f6148f;
    }

    public String toString() {
        return "BaseMessageHolder [msgJson=" + this.a + ", msgJsonStr=" + this.b + ", title=" + this.f6146d + ", content=" + this.f6147e + ", customContent=" + this.f6148f + ", acceptTime=" + this.f6149g + "]";
    }
}
