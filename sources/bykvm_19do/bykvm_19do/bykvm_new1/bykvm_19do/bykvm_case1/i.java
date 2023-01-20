package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b;
import com.qiniu.android.utils.Constants;

/* loaded from: classes.dex */
public final class i {

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.EnumC0053b.values().length];
            a = iArr;
            try {
                iArr[b.EnumC0053b.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.EnumC0053b.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.EnumC0053b.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.EnumC0053b.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.EnumC0053b.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String a(Context context) {
        return a(b(context));
    }

    public static String a(b.EnumC0053b enumC0053b) {
        int i2;
        try {
            i2 = a.a[enumC0053b.ordinal()];
        } catch (Exception unused) {
        }
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "mobile" : Constants.NETWORK_CLASS_4_G : Constants.NETWORK_CLASS_3_G : "2g" : "wifi";
    }

    private static b.EnumC0053b b(Context context) {
        NetworkInfo activeNetworkInfo;
        b.EnumC0053b enumC0053b;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    enumC0053b = b.EnumC0053b.WIFI;
                } else {
                    if (type == 0) {
                        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                enumC0053b = b.EnumC0053b.MOBILE_3G;
                                break;
                            case 13:
                                enumC0053b = b.EnumC0053b.MOBILE_4G;
                                break;
                        }
                    }
                    enumC0053b = b.EnumC0053b.MOBILE;
                }
                return enumC0053b;
            }
            enumC0053b = b.EnumC0053b.NONE;
            return enumC0053b;
        } catch (Throwable unused) {
            return b.EnumC0053b.MOBILE;
        }
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception unused) {
            return false;
        }
    }
}
