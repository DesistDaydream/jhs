package com.heytap.msp.push.encrypt;

import com.heytap.mcssdk.utils.d;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class AESEncrypt {
    private static final String ALGORITHM = "AES";
    private static final String IV_CONNECT = "%IV1%";
    private static final int KEY_BYTE_SIZE = 256;
    public static final String SDK_APP_SECRET = "isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=";
    private static final String TRANSFORMATION = "AES/CTR/NoPadding";

    public static String decrypt(String str, String str2) {
        String[] split = str2.split(IV_CONNECT);
        byte[] b = a.b(split[0]);
        byte[] b2 = a.b(split[1]);
        SecretKeySpec secretKeySpec = new SecretKeySpec(a.b(str), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKeySpec, new IvParameterSpec(b2));
        return new String(cipher.doFinal(b));
    }

    public static String encrypt(String str) {
        try {
            return encrypt(SDK_APP_SECRET, str);
        } catch (Exception e2) {
            d.b(e2.getLocalizedMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(a.b(str), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, secretKeySpec);
        String d2 = a.d(cipher.getIV());
        String d3 = a.d(cipher.doFinal(str2.getBytes()));
        return d3 + IV_CONNECT + d2;
    }

    public static String genKey() {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(256);
        return a.d(keyGenerator.generateKey().getEncoded());
    }
}
