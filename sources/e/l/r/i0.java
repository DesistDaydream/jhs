package e.l.r;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class i0 {
    @k.e.a.d
    public static final i0 a = new i0();
    @k.e.a.d
    public static final String b = "wifi";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final String f14284c = "eg";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final String f14285d = "2g";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final String f14286e = "wap";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final String f14287f = "unknown";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    public static final String f14288g = "disconnect";

    private i0() {
    }

    private final boolean c(Context context) {
        Object systemService = context.getSystemService("phone");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        switch (((TelephonyManager) systemService).getNetworkType()) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            default:
                return false;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
        }
    }

    public final int a(@k.e.a.d Context context) {
        Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    @k.e.a.d
    public final String b(@k.e.a.d Context context) {
        String str;
        Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (h.t2.u.K1("WIFI", typeName, true)) {
                str = "wifi";
            } else if (h.t2.u.K1("MOBILE", typeName, true)) {
                str = TextUtils.isEmpty(Proxy.getDefaultHost()) ? c(context) ? f14284c : "2g" : f14286e;
            } else {
                str = "unknown";
            }
            return str;
        }
        return f14288g;
    }

    public final boolean d(@k.e.a.e Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(0);
            if (networkInfo != null && networkInfo.isAvailable()) {
                return networkInfo.isConnected();
            }
        }
        return false;
    }

    public final boolean e(@k.e.a.d Context context) {
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean f(@k.e.a.e Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isAvailable()) {
                return false;
            }
            return networkInfo.isConnected();
        }
        return false;
    }
}
