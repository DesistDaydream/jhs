package e.k.c.a.a.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.util.LogsUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "HiPkgSignManager";

    private static PackageInfo a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageArchiveInfo(str, 64);
            }
            return null;
        } catch (Exception e2) {
            LogsUtil.q(a, "Exception : " + e2.getMessage(), true);
            return null;
        }
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < length; i2++) {
            if ((bArr[i2] & 255) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i2] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(bArr[i2] & 255));
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    private static List<String> c(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        if (signatureArr != null && signatureArr.length != 0) {
            for (Signature signature : signatureArr) {
                arrayList.add(d(signature.toByteArray()));
            }
        }
        return arrayList;
    }

    private static String d(byte[] bArr) {
        try {
            return b(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            LogsUtil.l(a, "NoSuchAlgorithmException" + e2.getMessage());
            return "";
        }
    }

    public static boolean e(Context context, String str, String str2, String str3) {
        PackageInfo a2;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null || TextUtils.isEmpty(str3) || (a2 = a(context, str2)) == null) {
            return false;
        }
        return str.equalsIgnoreCase(d(a2.signatures[0].toByteArray())) && str3.equals(a2.packageName);
    }

    public static boolean f(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return str.equalsIgnoreCase(i(context, str2));
    }

    public static boolean g(Context context, List<String> list, String str) {
        List<String> j2;
        if (TextUtils.isEmpty(str) || list == null || context == null || (j2 = j(context, str)) == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            arrayList.add(str2.toUpperCase(Locale.ENGLISH));
        }
        for (String str3 : j2) {
            if (!arrayList.contains(str3)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] h(Context context, String str) {
        PackageInfo packageInfo;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (PackageManager.NameNotFoundException e2) {
                LogsUtil.q(a, "PackageManager.NameNotFoundException : " + e2.getMessage(), true);
            } catch (Exception e3) {
                LogsUtil.q(a, "Exception : " + e3.getMessage(), true);
            }
            return new byte[0];
        }
        LogsUtil.l(a, "packageName is null or context is null");
        return new byte[0];
    }

    public static String i(Context context, String str) {
        byte[] h2 = h(context, str);
        return (h2 == null || h2.length <= 0) ? "" : d(h2);
    }

    public static List<String> j(Context context, String str) {
        PackageManager packageManager;
        Signature[] signatureArr;
        SigningInfo signingInfo;
        try {
            packageManager = context.getPackageManager();
        } catch (Throwable unused) {
        }
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
            if (packageInfo != null && (signingInfo = packageInfo.signingInfo) != null) {
                if (signingInfo.hasMultipleSigners()) {
                    return c(packageInfo.signingInfo.getApkContentsSigners());
                }
                return c(packageInfo.signingInfo.getSigningCertificateHistory());
            }
            return null;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
        if (packageInfo2 != null && (signatureArr = packageInfo2.signatures) != null && signatureArr.length != 0 && signatureArr[0] != null) {
            return c(signatureArr);
        }
        return null;
    }

    public static String k(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            PackageInfo a2 = a(context, str);
            return a2 != null ? a2.packageName : "";
        }
        LogsUtil.l(a, "archiveFilePath is null or context is null");
        return "";
    }

    public static byte[] l(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            PackageInfo a2 = a(context, str);
            if (a2 != null) {
                Signature signature = a2.signatures[0];
                if (signature != null) {
                    return signature.toByteArray();
                }
            } else {
                LogsUtil.l(a, "PackageInfo is null ");
            }
            return new byte[0];
        }
        LogsUtil.l(a, "archiveFilePath is null or context is null");
        return new byte[0];
    }

    public static String m(Context context, String str) {
        byte[] l2 = l(context, str);
        return (l2 == null || l2.length <= 0) ? "" : d(l2);
    }
}
