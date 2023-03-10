package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.GMSettingConfigCallback;

/* loaded from: classes.dex */
public class b {
    private static final GMSettingConfigCallback a = new a();

    /* loaded from: classes.dex */
    public static final class a implements GMSettingConfigCallback {
        @Override // com.bytedance.msdk.api.v2.GMSettingConfigCallback
        public void configLoad() {
            try {
                b.d();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    private static int a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    str = str.substring(1);
                }
                if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    str2 = str2.substring(1);
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int min = Math.min(split.length, split2.length);
                for (int i2 = 0; i2 < min; i2++) {
                    if (split[i2].length() == split2[i2].length()) {
                        int compareTo = split[i2].compareTo(split2[i2]);
                        if (compareTo != 0) {
                            return compareTo;
                        }
                    } else if (split[i2].length() <= split2[i2].length()) {
                    }
                }
                if (split.length == split2.length) {
                    return 0;
                }
                if (split.length <= split2.length) {
                }
            }
            return 1;
        }
        return -1;
    }

    public static boolean b(String str, String str2) {
        String str3;
        StringBuilder sb;
        String str4;
        StringBuilder sb2;
        String str5;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!str.equals("pangle")) {
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1128782217:
                    if (str.equals("klevin")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -902468465:
                    if (str.equals("sigmob")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3432:
                    if (str.equals("ks")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 102199:
                    if (str.equals("gdt")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 92668925:
                    if (str.equals("admob")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 93498907:
                    if (str.equals("baidu")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 111433589:
                    if (str.equals("unity")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1126045977:
                    if (str.equals("mintegral")) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str3 = "2.9.1.5.2";
                    if (a(str2, "2.9.1.5.2") == 0) {
                        sb = new StringBuilder();
                        str4 = "klevinAdapter????????????, ??????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        Logger.d("TTMediationSDK_InitChecker", sb.toString());
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "klevinAdapter???????????????, ??????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        Logger.e("TTMediationSDK_InitChecker", sb2.toString());
                        return false;
                    }
                case 1:
                    str3 = "4.5.0.1";
                    if (a(str2, "4.5.0.1") == 0) {
                        sb = new StringBuilder();
                        str4 = "sigmobAdapter????????????, ??????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        Logger.d("TTMediationSDK_InitChecker", sb.toString());
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "sigmobAdapter???????????????, ??????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        Logger.e("TTMediationSDK_InitChecker", sb2.toString());
                        return false;
                    }
                case 2:
                    str3 = "3.3.28.3";
                    if (a(str2, "3.3.28.3") == 0) {
                        sb = new StringBuilder();
                        str4 = "??????Adapter????????????, ??????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        Logger.d("TTMediationSDK_InitChecker", sb.toString());
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "??????Adapter???????????????, ??????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        Logger.e("TTMediationSDK_InitChecker", sb2.toString());
                        return false;
                    }
                case 3:
                    str3 = "4.484.1354.1";
                    if (a(str2, "4.484.1354.1") == 0) {
                        sb = new StringBuilder();
                        str4 = "gdtAdapter???????????????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        Logger.d("TTMediationSDK_InitChecker", sb.toString());
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "gdtAdapter??????????????????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        Logger.e("TTMediationSDK_InitChecker", sb2.toString());
                        return false;
                    }
                case 4:
                    str3 = "17.2.0.33";
                    if (a(str2, "17.2.0.33") == 0) {
                        sb = new StringBuilder();
                        str4 = "admobAdapter?????????????????????<=";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        Logger.d("TTMediationSDK_InitChecker", sb.toString());
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "admobAdapter????????????????????????<=";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        Logger.e("TTMediationSDK_InitChecker", sb2.toString());
                        return false;
                    }
                case 5:
                    str3 = "9.24.1";
                    if (a(str2, "9.24.1") == 0) {
                        sb = new StringBuilder();
                        str4 = "??????Adapter???????????????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        Logger.d("TTMediationSDK_InitChecker", sb.toString());
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "??????Adapter??????????????????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        Logger.e("TTMediationSDK_InitChecker", sb2.toString());
                        return false;
                    }
                case 6:
                    str3 = "4.3.0.2";
                    if (a(str2, "4.3.0.2") == 0) {
                        sb = new StringBuilder();
                        str4 = "unityAdapter???????????????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        Logger.d("TTMediationSDK_InitChecker", sb.toString());
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "unityAdapter??????????????????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        Logger.e("TTMediationSDK_InitChecker", sb2.toString());
                        return false;
                    }
                case 7:
                    str3 = "16.2.27.2";
                    if (a(str2, "16.2.27.2") == 0) {
                        sb = new StringBuilder();
                        str4 = "MintegralAdapter????????????, ??????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        Logger.d("TTMediationSDK_InitChecker", sb.toString());
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "MintegralAdapter???????????????, ??????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        Logger.e("TTMediationSDK_InitChecker", sb2.toString());
                        return false;
                    }
                default:
                    return false;
            }
        }
        return true;
    }

    public static void c() {
        try {
            if (Logger.isDebug() && GMMediationAdSdk.configLoadSuccess()) {
                d();
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean c(String str, String str2) {
        String str3;
        StringBuilder sb;
        String str4;
        StringBuilder sb2;
        String str5;
        String sb3;
        String sb4;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!str.equals("baidu") && !str.equals("admob")) {
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1128782217:
                    if (str.equals("klevin")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -995541405:
                    if (str.equals("pangle")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -902468465:
                    if (str.equals("sigmob")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3432:
                    if (str.equals("ks")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 102199:
                    if (str.equals("gdt")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 111433589:
                    if (str.equals("unity")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1126045977:
                    if (str.equals("mintegral")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str3 = "2.9.1.5";
                    if (a(str2, "2.9.1.5") == 0) {
                        sb = new StringBuilder();
                        str4 = "klevin????????????, ??????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        sb3 = sb.toString();
                        Logger.d("TTMediationSDK_InitChecker", sb3);
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "klevin???????????????, ??????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        sb4 = sb2.toString();
                        Logger.e("TTMediationSDK_InitChecker", sb4);
                        return false;
                    }
                case 1:
                    str3 = "4.8.0.8";
                    if (a(str2, "4.8.0.8") == 0) {
                        sb = new StringBuilder();
                        str4 = "????????????????????????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        sb3 = sb.toString();
                        Logger.d("TTMediationSDK_InitChecker", sb3);
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "???????????????????????????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        sb4 = sb2.toString();
                        Logger.e("TTMediationSDK_InitChecker", sb4);
                        return false;
                    }
                case 2:
                    str3 = "4.5.0";
                    if (a(str2, "4.5.0") == 0) {
                        sb = new StringBuilder();
                        str4 = "sigmob????????????, ??????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        sb3 = sb.toString();
                        Logger.d("TTMediationSDK_InitChecker", sb3);
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "sigmob???????????????, ??????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        sb4 = sb2.toString();
                        Logger.e("TTMediationSDK_InitChecker", sb4);
                        return false;
                    }
                case 3:
                    str3 = "3.3.28";
                    if (a(str2, "3.3.28") == 0) {
                        sb = new StringBuilder();
                        str4 = "??????????????????, ??????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        sb3 = sb.toString();
                        Logger.d("TTMediationSDK_InitChecker", sb3);
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "?????????????????????, ??????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        sb4 = sb2.toString();
                        Logger.e("TTMediationSDK_InitChecker", sb4);
                        return false;
                    }
                case 4:
                    str3 = "4.484.1354";
                    if (a(str2, "4.484.1354") == 0) {
                        sb = new StringBuilder();
                        str4 = "gdt???????????????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        sb3 = sb.toString();
                        Logger.d("TTMediationSDK_InitChecker", sb3);
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "gdt??????????????????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        sb4 = sb2.toString();
                        Logger.e("TTMediationSDK_InitChecker", sb4);
                        return false;
                    }
                case 5:
                    str3 = "4.3.0";
                    if (a(str2, "4.3.0") == 0) {
                        sb = new StringBuilder();
                        str4 = "unity???????????????????????????";
                        sb.append(str4);
                        sb.append(str3);
                        sb.append("????????????");
                        sb.append(str2);
                        sb3 = sb.toString();
                        Logger.d("TTMediationSDK_InitChecker", sb3);
                        break;
                    } else {
                        sb2 = new StringBuilder();
                        str5 = "unity??????????????????????????????";
                        sb2.append(str5);
                        sb2.append(str3);
                        sb2.append("????????????");
                        sb2.append(str2);
                        sb4 = sb2.toString();
                        Logger.e("TTMediationSDK_InitChecker", sb4);
                        return false;
                    }
                case 6:
                    if (!TextUtils.isEmpty(str2) && str2.contains("16.2.27")) {
                        sb3 = "Mintegral????????????, ??????????????????16.2.27????????????" + str2;
                        Logger.d("TTMediationSDK_InitChecker", sb3);
                        break;
                    } else {
                        sb4 = "Mintegral???????????????, ??????????????????16.2.27????????????" + str2;
                        Logger.e("TTMediationSDK_InitChecker", sb4);
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        synchronized (b.class) {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() != null) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().d();
            }
        }
    }
}
