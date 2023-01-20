package com.umeng.commonsdk.statistics.common;

import android.util.Base64;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class DataHelper {
    public static long ENVELOPE_ENTITY_RAW_LENGTH_MAX = 2097152;
    public static long ENVELOPE_EXTRA_LENGTH = 614400;
    public static long ENVELOPE_LENGTH_MAX = 204800;
    private static String UMENG_PLUS = "umeng+0123456789";

    public static String assembleStatelessURL(String str) {
        return "https://" + str;
    }

    public static String assembleURL(String str) {
        return "https://" + str;
    }

    public static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static String convertExceptionToString(Throwable th) {
        String str = null;
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            str = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(UMUtils.genIv()));
        return cipher.doFinal(bArr);
    }

    public static String decryptEx(String str) {
        try {
            return new String(decrypt(Base64.decode(str.getBytes(), 0), UMENG_PLUS.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(UMUtils.genIv()));
        return cipher.doFinal(bArr);
    }

    public static String encryptBySHA1(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(bytes);
            return bytes2Hex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encryptEx(String str) {
        try {
            return Base64.encodeToString(encrypt(str.getBytes(), UMENG_PLUS.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] hash(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean largeThanMaxSize(long j2, long j3) {
        return j2 > j3;
    }

    public static int random(int i2, String str) {
        if (new Random().nextFloat() < 0.001d) {
            int i3 = 0;
            if (str == null) {
                MLog.e("--->", "null signature..");
            }
            try {
                i3 = Integer.parseInt(str.substring(9, 11), 16);
            } catch (Exception unused) {
            }
            return (i3 | 128) * 1000;
        }
        int nextInt = new Random().nextInt(i2);
        if (nextInt > 255000 || nextInt < 128000) {
            return nextInt;
        }
        return 127000;
    }

    public static byte[] reverseHexString(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[length / 2];
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 2;
            bArr[i2 / 2] = (byte) Integer.valueOf(str.substring(i2, i3), 16).intValue();
            i2 = i3;
        }
        return bArr;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(bArr[i2])));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }
}
