package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes2.dex */
public class a {
    public static NetworkInfo a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean b(Context context) {
        NetworkInfo a = a(context);
        return a != null && a.isConnected() && a.getType() == 1;
    }
}
