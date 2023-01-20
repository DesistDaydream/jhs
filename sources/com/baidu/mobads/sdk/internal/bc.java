package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class bc {
    public static final String a = "mobads_builds";
    public static final String b = "brand_period";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1468c = "version_period";

    /* renamed from: d  reason: collision with root package name */
    public static final long f1469d = 604800000;

    /* renamed from: e  reason: collision with root package name */
    public static final long f1470e = 172800000;

    /* renamed from: f  reason: collision with root package name */
    public static final String f1471f = "sdk_int";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1472g = "sdk";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1473h = "release";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1474i = "model";

    /* renamed from: j  reason: collision with root package name */
    public static final String f1475j = "brand";

    /* renamed from: k  reason: collision with root package name */
    public static final String f1476k = "netopera";

    /* renamed from: l  reason: collision with root package name */
    public static final String f1477l = "tags";

    /* renamed from: m  reason: collision with root package name */
    private int f1478m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private Context t;
    private SharedPreferences u;

    /* loaded from: classes.dex */
    public static class a {
        private static final bc a = new bc();

        private a() {
        }
    }

    public static bc a(Context context) {
        a.a.b(context);
        return a.a;
    }

    private void h() {
        i();
        j();
    }

    private void i() {
        try {
            if (System.currentTimeMillis() > b(b).longValue()) {
                this.p = Build.MODEL;
                this.q = Build.BRAND;
                this.r = ((TelephonyManager) this.t.getSystemService("phone")).getNetworkOperator();
                this.s = Build.TAGS;
                a(f1474i, this.p);
                a("brand", this.q);
                a(f1476k, this.r);
                a(f1477l, this.s);
                a(b, Long.valueOf(System.currentTimeMillis() + f1469d));
            } else {
                this.p = a(f1474i);
                this.q = a("brand");
                this.r = a(f1476k);
                this.s = a(f1477l);
            }
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
        }
    }

    private void j() {
        try {
            if (System.currentTimeMillis() > b(f1468c).longValue()) {
                int i2 = Build.VERSION.SDK_INT;
                this.f1478m = i2;
                this.n = Build.VERSION.SDK;
                this.o = Build.VERSION.RELEASE;
                a(f1471f, i2);
                a(f1472g, this.n);
                a("release", this.o);
                a(f1468c, Long.valueOf(System.currentTimeMillis() + f1470e));
            } else {
                this.f1478m = c(f1471f);
                this.n = a(f1472g);
                this.o = a("release");
            }
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
        }
    }

    private SharedPreferences.Editor k() {
        return this.u.edit();
    }

    public void b(Context context) {
        if (this.t != null || context == null) {
            if (a.a == null) {
                ar.a(context);
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.t = applicationContext;
        try {
            if (this.u == null) {
                this.u = applicationContext.getSharedPreferences(a, 0);
                h();
            }
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
        }
    }

    public String c() {
        return this.o;
    }

    public String d() {
        return this.p;
    }

    public String e() {
        return this.q;
    }

    public String f() {
        return this.r;
    }

    public String g() {
        return this.s;
    }

    private bc() {
        this.f1478m = 0;
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
    }

    private int c(String str) {
        try {
            return this.u.getInt(str, 0);
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
            return 0;
        }
    }

    public int a() {
        if (this.f1478m == 0) {
            this.f1478m = Build.VERSION.SDK_INT;
        }
        return this.f1478m;
    }

    private String a(String str) {
        try {
            return this.u.getString(str, "");
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
            return "";
        }
    }

    @TargetApi(9)
    private void a(String str, String str2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putString(str, str2);
            k2.apply();
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.n)) {
            this.n = Build.VERSION.SDK;
        }
        return this.n;
    }

    @TargetApi(9)
    private void a(String str, Long l2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putLong(str, l2.longValue());
            k2.apply();
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
        }
    }

    private Long b(String str) {
        try {
            return Long.valueOf(this.u.getLong(str, 0L));
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
            return 0L;
        }
    }

    @TargetApi(9)
    private void a(String str, int i2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putInt(str, i2);
            k2.apply();
        } catch (Throwable th) {
            bj.a().c(th.getMessage());
        }
    }
}
