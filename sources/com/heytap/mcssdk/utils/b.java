package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import com.heytap.msp.push.encrypt.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class b {
    public static String a = null;
    public static final String b = "Y29tLm5lYXJtZS5tY3M=";

    /* renamed from: c  reason: collision with root package name */
    public static String f3348c = "";

    private static String a() {
        if (TextUtils.isEmpty(f3348c)) {
            f3348c = new String(com.heytap.mcssdk.a.a.b(b));
        }
        byte[] a2 = a(a(f3348c));
        return a2 != null ? new String(a2, Charset.forName("UTF-8")) : "";
    }

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i2 = 0; i2 < length; i2 += 2) {
            byte b2 = bArr[i2];
            int i3 = i2 + 1;
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
        return bArr;
    }

    public static String b(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = c.a(str, a());
            d.b("sdkDecrypt desDecrypt des data " + str2);
            z = true;
        } catch (Exception e2) {
            d.b("sdkDecrypt DES excepiton " + e2.toString());
            z = false;
        }
        if (TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            a = "AES";
            e.f().b(a);
            d.b("sdkDecrypt desDecrypt aes data " + str2);
            return str2;
        } catch (Exception e3) {
            d.b("sdkDecrypt AES excepiton " + e3.toString());
            return str2;
        }
    }

    public static String c(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            d.b("sdkDecrypt aesDecrypt aes data " + str2);
            z = true;
        } catch (Exception e2) {
            d.b("sdkDecrypt AES excepiton " + e2.toString());
            z = false;
        }
        if (TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = c.a(str, a());
            a = "DES";
            e.f().b(a);
            d.b("sdkDecrypt aesDecrypt des data " + str2);
            return str2;
        } catch (Exception e3) {
            d.b("sdkDecrypt DES excepiton " + e3.toString());
            return str2;
        }
    }

    public static String d(String str) {
        d.b("sdkDecrypt start data " + str);
        if (TextUtils.isEmpty(a)) {
            a = e.f().e();
        }
        if ("DES".equals(a)) {
            d.b("sdkDecrypt start DES");
            return b(str);
        }
        d.b("sdkDecrypt start AES");
        return c(str);
    }
}
