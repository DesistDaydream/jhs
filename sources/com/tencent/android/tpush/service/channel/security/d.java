package com.tencent.android.tpush.service.channel.security;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes3.dex */
public class d {
    private static RSAPublicKey a;

    public static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static String a(byte[] bArr, RSAPublicKey rSAPublicKey) {
        Cipher cipher;
        byte[][] a2;
        try {
            Cipher.getInstance("RSA/ECB/PKCS1Padding").init(2, rSAPublicKey);
            int bitLength = rSAPublicKey.getModulus().bitLength() / 8;
            if (bitLength != 0) {
                String str = "";
                for (byte[] bArr2 : a(bArr, bitLength)) {
                    str = str + new String(cipher.doFinal(bArr2), "UTF-8");
                }
                return str;
            }
            throw new Exception("模长为0");
        } catch (InvalidKeyException unused) {
            throw new Exception("解密私钥非法,请检查");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此解密算法");
        } catch (BadPaddingException unused3) {
            throw new Exception("密文数据已损坏");
        } catch (IllegalBlockSizeException unused4) {
            throw new Exception("密文长度非法");
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[][] a(byte[] bArr, int i2) {
        int length = bArr.length / i2;
        int length2 = bArr.length % i2;
        int i3 = length + (length2 != 0 ? 1 : 0);
        byte[][] bArr2 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr3 = new byte[i2];
            if (i4 == i3 - 1 && length2 != 0) {
                System.arraycopy(bArr, i4 * i2, bArr3, 0, length2);
            } else {
                System.arraycopy(bArr, i4 * i2, bArr3, 0, i2);
            }
            bArr2[i4] = bArr3;
        }
        return bArr2;
    }
}
