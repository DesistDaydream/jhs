package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public class cf {
    private static volatile cf a;

    private cf() {
    }

    public static cf a() {
        if (a == null) {
            synchronized (cf.class) {
                if (a == null) {
                    a = new cf();
                }
            }
        }
        return a;
    }

    private NetworkCapabilities c(Context context) {
        try {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Boolean a(Context context) {
        try {
            boolean z = false;
            if (bc.a(context).a() < 29) {
                NetworkInfo b = b(context);
                if (b != null && b.isConnected() && b.getType() == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            NetworkCapabilities c2 = c(context);
            if (c2 != null && c2.hasCapability(12) && c2.hasCapability(16) && c2.hasTransport(1)) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
