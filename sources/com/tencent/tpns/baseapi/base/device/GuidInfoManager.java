package com.tencent.tpns.baseapi.base.device;

import android.content.Context;
import com.tencent.tpns.baseapi.core.b.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GuidInfoManager {
    public static void clearGuidInfo(Context context) {
        a.p(context);
    }

    public static void clearTokenCache() {
        a.a();
    }

    public static void forceExpired(Context context) {
        a.o(context);
    }

    public static int getEncryptLevel(Context context) {
        return a.s(context);
    }

    public static long getExpiredSeconds(Context context) {
        return a.j(context);
    }

    public static GUIDInfo getFinalGuidInfo(Context context, boolean z, String str) {
        return a.a(context, z, str);
    }

    public static long getGuid(Context context) {
        return a.d(context);
    }

    public static long getLastRefreshTime(Context context) {
        return a.k(context);
    }

    public static synchronized String getLastResolvedGuidServerIP(Context context) {
        String f2;
        synchronized (GuidInfoManager.class) {
            f2 = a.f(context);
        }
        return f2;
    }

    public static String getMqttPassword(Context context) {
        return a.i(context);
    }

    public static String getMqttServer(Context context) {
        return a.e(context);
    }

    public static synchronized String getMqttServerIP(Context context) {
        String g2;
        synchronized (GuidInfoManager.class) {
            g2 = a.g(context);
        }
        return g2;
    }

    public static synchronized long getMqttServerRefreshTime(Context context) {
        long m2;
        synchronized (GuidInfoManager.class) {
            m2 = a.m(context);
        }
        return m2;
    }

    public static String getMqttUserName(Context context) {
        return a.h(context);
    }

    public static int getRefuseRate(Context context) {
        return a.r(context);
    }

    public static String getServerIPAddress(Context context, String str) {
        return a.a(context, str);
    }

    public static String getToken(Context context) {
        return a.b(context);
    }

    public static String getTokenList(Context context) {
        return a.c(context);
    }

    public static boolean isExpired(Context context) {
        return a.l(context);
    }

    public static boolean isMqttServerExpired(Context context) {
        return a.n(context);
    }

    public static boolean isServerDestroy(Context context) {
        return a.q(context);
    }

    public static synchronized GUIDInfo refreshConnectInfoSynchronized(Context context, int i2, RefreshCallback refreshCallback) {
        GUIDInfo a;
        synchronized (GuidInfoManager.class) {
            a = a.a(context, i2, (JSONObject) null);
        }
        return a;
    }

    public static synchronized void setLastResolvedGuidServerIP(Context context, String str) {
        synchronized (GuidInfoManager.class) {
            a.b(context, str);
        }
    }

    public static synchronized void setMqttServerIP(Context context, String str) {
        synchronized (GuidInfoManager.class) {
            a.c(context, str);
        }
    }

    public static synchronized void setMqttServerRefreshTime(Context context, long j2) {
        synchronized (GuidInfoManager.class) {
            a.a(context, j2);
        }
    }

    public static void wrtieDebugInfo(Context context, String str, String str2) {
        a.a(context, str, str2);
    }
}
