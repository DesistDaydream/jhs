package com.bytedance.pangle.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public final class a {
    private static volatile a a;

    /* renamed from: com.bytedance.pangle.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0079a {
        UNKNOWN(-1),
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);
        

        /* renamed from: h  reason: collision with root package name */
        public final int f2239h;

        EnumC0079a(int i2) {
            this.f2239h = i2;
        }
    }

    public static EnumC0079a a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return EnumC0079a.WIFI;
                }
                return EnumC0079a.MOBILE;
            }
            return EnumC0079a.NONE;
        } catch (Throwable unused) {
            return EnumC0079a.MOBILE;
        }
    }
}
