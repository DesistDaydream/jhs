package com.huawei.hms.framework.network.grs.h;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class b {
    private static final String a = "b";
    private static final Pattern b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    public static String a(String str) {
        return a(str, "SHA-256");
    }

    private static String a(String str, String str2) {
        String str3;
        String str4;
        try {
        } catch (UnsupportedEncodingException unused) {
            str3 = a;
            str4 = "encrypt UnsupportedEncodingException";
        }
        try {
            return a(MessageDigest.getInstance(str2).digest(str.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException unused2) {
            str3 = a;
            str4 = "encrypt NoSuchAlgorithmException";
            Logger.w(str3, str4);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i2 = 1;
        if (str.length() == 1) {
            return "*";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < str.length(); i3++) {
            String str2 = str.charAt(i3) + "";
            if (b.matcher(str2).matches()) {
                if (i2 % 2 == 0) {
                    str2 = "*";
                }
                i2++;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }
}
