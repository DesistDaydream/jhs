package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class d {
    public static String a(Context context) {
        SharedPreferences a;
        if (context == null || (a = a.a(context)) == null) {
            return null;
        }
        return a.getString("aaid", null);
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences a;
        SharedPreferences.Editor edit;
        String b = b(str);
        if (context == null || b == null || TextUtils.isEmpty(b) || (a = a.a(context)) == null || (edit = a.edit()) == null) {
            return;
        }
        edit.putString("mac", b).commit();
    }

    public static String b(Context context) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName(DeviceConfig.LOG_TAG);
            if (cls != null && (declaredMethod = cls.getDeclaredMethod("getMac", Context.class)) != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void b(Context context, String str) {
        SharedPreferences a;
        SharedPreferences.Editor edit;
        String b = b(str);
        if (context == null || b == null || TextUtils.isEmpty(b) || (a = a.a(context)) == null || (edit = a.edit()) == null) {
            return;
        }
        edit.putString("oaid", b).commit();
    }

    public static String c(Context context) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName(DeviceConfig.LOG_TAG);
            if (cls != null && (declaredMethod = cls.getDeclaredMethod("getOaid", Context.class)) != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static void c(Context context, String str) {
        SharedPreferences a;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a = a.a(context)) == null || (edit = a.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(b(a(str)));
    }

    public static void d(Context context, String str) {
        SharedPreferences a;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a = a.a(context)) == null || (edit = a.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    public static boolean d(Context context) {
        NetworkInfo networkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(17)) != null) {
                    return networkInfo.isConnected();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void e(Context context, String str) {
        SharedPreferences a;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a = a.a(context)) == null || (edit = a.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    public static void f(Context context, String str) {
        SharedPreferences a;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a = a.a(context)) == null || (edit = a.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }
}
