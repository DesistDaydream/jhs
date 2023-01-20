package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.content.pm.Signature;
import com.bytedance.msdk.adapter.util.Logger;
import com.xiaomi.mipush.sdk.Constants;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class i {
    private static HashMap<String, ArrayList<String>> a = new HashMap<>();

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(Constants.COLON_SEPARATOR);
                }
                return sb.substring(0, sb.length() - 1).toString();
            }
        } catch (Exception e2) {
            Logger.e(e2.toString());
        }
        return "error!";
    }

    public static ArrayList<String> a(Context context, String str) {
        String packageName;
        Signature[] b;
        if (context == null || str == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (a.get(str) != null) {
            return a.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : b(context, packageName)) {
                arrayList.add("MD5".equals(str) ? a(signature, "MD5") : "SHA1".equals(str) ? a(signature, "SHA1") : "SHA256".equals(str) ? a(signature, "SHA256") : "error!");
            }
        } catch (Exception e2) {
            Logger.e(e2.toString());
        }
        a.put(str, arrayList);
        return arrayList;
    }

    private static Signature[] b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e2) {
            Logger.e(e2.toString());
            return null;
        }
    }
}
