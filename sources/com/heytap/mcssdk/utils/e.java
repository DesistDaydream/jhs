package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.heytap.mcssdk.PushService;

/* loaded from: classes2.dex */
public class e {
    private static final String a = "shared_msg_sdk";
    private static final String b = "hasDefaultChannelCreated";

    /* renamed from: c  reason: collision with root package name */
    private static final String f3356c = "lastUpLoadInfoSDKVersionName";

    /* renamed from: d  reason: collision with root package name */
    private static final String f3357d = "lastUploadInfoUniqueID";

    /* renamed from: e  reason: collision with root package name */
    private static final String f3358e = "decryptTag";

    /* renamed from: f  reason: collision with root package name */
    private Context f3359f;

    /* renamed from: g  reason: collision with root package name */
    private SharedPreferences f3360g;

    /* renamed from: h  reason: collision with root package name */
    private Object f3361h;

    /* loaded from: classes2.dex */
    public static class a {
        public static e a = new e();

        private a() {
        }
    }

    private e() {
        this.f3361h = new Object();
        Context context = PushService.getInstance().getContext();
        if (context != null) {
            this.f3359f = a(context);
        }
        Context context2 = this.f3359f;
        if (context2 != null) {
            this.f3360g = context2.getSharedPreferences(a, 0);
        }
    }

    private Context a(Context context) {
        boolean a2 = com.heytap.mcssdk.utils.a.a();
        d.b("fbeVersion is " + a2);
        return (!a2 || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
    }

    public static e f() {
        return a.a;
    }

    private SharedPreferences g() {
        Context context;
        SharedPreferences sharedPreferences = this.f3360g;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.f3361h) {
            SharedPreferences sharedPreferences2 = this.f3360g;
            if (sharedPreferences2 != null || (context = this.f3359f) == null) {
                return sharedPreferences2;
            }
            SharedPreferences sharedPreferences3 = context.getSharedPreferences(a, 0);
            this.f3360g = sharedPreferences3;
            return sharedPreferences3;
        }
    }

    public int a(String str, int i2) {
        SharedPreferences g2 = g();
        return g2 != null ? g2.getInt(str, i2) : i2;
    }

    public long a(String str, long j2) {
        SharedPreferences g2 = g();
        return g2 != null ? g2.getLong(str, j2) : j2;
    }

    public void a(String str) {
        SharedPreferences g2 = g();
        if (g2 != null) {
            g2.edit().putString(f3357d, str).commit();
        }
    }

    public void a(boolean z) {
        SharedPreferences g2 = g();
        if (g2 != null) {
            g2.edit().putBoolean(b, z).commit();
        }
    }

    public boolean a() {
        SharedPreferences g2 = g();
        if (g2 != null) {
            return g2.getBoolean(b, false);
        }
        return false;
    }

    public void b() {
        SharedPreferences g2 = g();
        if (g2 != null) {
            g2.edit().putString(f3356c, "3.0.0").commit();
        }
    }

    public void b(String str) {
        SharedPreferences g2 = g();
        if (g2 != null) {
            g2.edit().putString(f3358e, str).commit();
        }
    }

    public void b(String str, int i2) {
        SharedPreferences g2 = g();
        if (g2 != null) {
            SharedPreferences.Editor edit = g2.edit();
            edit.putInt(str, i2);
            edit.apply();
        }
    }

    public void b(String str, long j2) {
        SharedPreferences g2 = g();
        if (g2 != null) {
            SharedPreferences.Editor edit = g2.edit();
            edit.putLong(str, j2);
            edit.apply();
        }
    }

    public int c(String str) {
        SharedPreferences g2 = g();
        if (g2 != null) {
            return g2.getInt(str, 0);
        }
        return 0;
    }

    public String c() {
        SharedPreferences g2 = g();
        return g2 != null ? g2.getString(f3357d, "") : "";
    }

    public long d(String str) {
        SharedPreferences g2 = g();
        return g2 != null ? g2.getLong(str, com.heytap.mcssdk.constant.a.b.longValue()) : com.heytap.mcssdk.constant.a.b.longValue();
    }

    public String d() {
        SharedPreferences g2 = g();
        return g2 != null ? g2.getString(f3356c, "") : "";
    }

    public String e() {
        SharedPreferences g2 = g();
        return g2 != null ? g2.getString(f3358e, "DES") : "DES";
    }
}
