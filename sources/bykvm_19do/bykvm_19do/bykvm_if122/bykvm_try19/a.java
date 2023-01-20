package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import android.util.Base64;
import com.qiniu.android.common.Constants;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class a {
    public static String a() {
        String b = l0.b();
        if (b == null || b.length() != 16) {
            return null;
        }
        return b;
    }

    public static String a(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return str.concat(str).substring(8, 24);
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] decode = Base64.decode(str, 0);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(2, secretKeySpec);
                return new String(cipher.doFinal(decode));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String b(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(Constants.UTF_8)), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
