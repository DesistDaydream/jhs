package com.moor.imkf.lib.utils.aes;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class MoorAesUtils {
    private static final String AES = "AES";
    private static final String CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    private static final String TAG = "AESCBCUtils";

    public static String decrypt(String str, String str2, String str3) throws Exception {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("ASCII"), AES);
            Cipher cipher = Cipher.getInstance(CBC_PKCS5_PADDING);
            cipher.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes()));
            return new String(cipher.doFinal(Base64.decode(str2, 0)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String encrypt_AES(String str, String str2, String str3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), AES);
            Cipher cipher = Cipher.getInstance(CBC_PKCS5_PADDING);
            cipher.init(1, secretKeySpec, new IvParameterSpec(str3.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str2.getBytes()), 0).replaceAll(System.getProperty("line.separator"), "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
