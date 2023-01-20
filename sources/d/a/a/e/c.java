package d.a.a.e;

import android.text.TextUtils;
import cn.thinkingdata.android.utils.TDLog;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    public static String a(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            TDLog.i("ThinkingAnalytics.TAEncryptUtils", "PublicKey is null.");
            return null;
        }
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b.a(str)));
            Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
            cipher.init(1, generatePublic);
            return new String(d.a.a.o.a.a(cipher.doFinal(bArr)));
        } catch (Exception e2) {
            TDLog.d("ThinkingAnalytics.TAEncryptUtils", "AES加密失败:" + e2.getMessage());
            return null;
        }
    }

    public static String b(byte[] bArr, String str) {
        if (bArr != null && str != null) {
            byte[] bytes = str.getBytes();
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
                cipher.init(1, secretKeySpec);
                return new String(d.a.a.o.a.a(cipher.doFinal(bytes)));
            } catch (Exception e2) {
                TDLog.d("ThinkingAnalytics.TAEncryptUtils", "RSA加密失败:" + e2.getMessage());
            }
        }
        return null;
    }

    public static boolean c(JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                if (d(jSONArray.getJSONObject(i2))) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean d(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() == 3 && jSONObject.has("ekey") && jSONObject.has("pkv") && jSONObject.has("payload");
    }

    public static byte[] e() {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey().getEncoded();
    }
}
