package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;

/* loaded from: classes.dex */
public class d0 {
    private static boolean a = false;
    private static String b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f1013c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f1014d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f1015e = true;

    public static String a() {
        if (!a) {
            d();
        }
        return b;
    }

    public static String b() {
        try {
            if (!a) {
                d();
            }
            Configuration configuration = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getResources().getConfiguration();
            int i2 = configuration.mcc;
            String valueOf = i2 != 0 ? String.valueOf(i2) : f1013c;
            Logger.e("MCC", "config=" + configuration.mcc + ",sMCC=" + f1013c);
            if (f1015e) {
                return valueOf;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getMCC");
            sb.append(f1015e ? "有SIM卡" : "无SIM卡,MCC返回null");
            Logger.e("MCC", sb.toString());
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c() {
        if (!a) {
            d();
        }
        return f1014d;
    }

    private static void d() {
        String str;
        String str2;
        String str3;
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() == null || a) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getSystemService("phone");
            int simState = telephonyManager.getSimState();
            if (simState == 0 || simState == 1) {
                f1015e = false;
            }
            Logger.e("MCC", f1015e ? "有SIM卡" : "无SIM卡");
            String str4 = null;
            try {
                str = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                str = null;
            }
            try {
                str2 = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                str2 = null;
            }
            if (str2 == null || str2.length() < 5) {
                try {
                    str2 = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
                str3 = null;
            } else {
                str4 = str2.substring(0, 3);
                str3 = str2.substring(3);
            }
            if (!TextUtils.isEmpty(str)) {
                b = str;
            }
            if (!TextUtils.isEmpty(str4)) {
                f1013c = str4;
            }
            if (!TextUtils.isEmpty(str3)) {
                f1014d = str3;
            }
        } catch (Throwable unused4) {
        }
        a = true;
    }
}
