package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* loaded from: classes3.dex */
public final class b {
    private static b a = null;
    private static Context b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f7314c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String f7315d = "mobclick_agent_user_";

    /* loaded from: classes3.dex */
    public static final class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null && context != null) {
                b = context.getApplicationContext();
            }
            if (b != null) {
                f7314c = context.getPackageName();
            }
            bVar = a.a;
        }
        return bVar;
    }

    private SharedPreferences e() {
        Context context = b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(f7315d + f7314c, 0);
    }

    public void b() {
        SharedPreferences e2 = e();
        if (e2 != null) {
            e2.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public String c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public int d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public String[] a() {
        SharedPreferences e2 = e();
        if (e2 != null) {
            String string = e2.getString("au_p", null);
            String string2 = e2.getString("au_u", null);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return null;
            }
            return new String[]{string, string2};
        }
        return null;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(int i2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i2).commit();
        }
    }

    public static String a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null) ? "" : sharedPreferences.getString(str2, "");
    }

    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        edit.remove(AnalyticsConfig.DEBUG_KEY);
        edit.remove("period");
        edit.remove(AnalyticsConfig.RTD_START_TIME);
        edit.clear();
        edit.commit();
    }
}
