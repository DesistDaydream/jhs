package com.qiniu.android.utils;

import com.qiniu.android.dns.util.Hex;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class MD5 {
    public static String encrypt(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return Hex.encodeHexString(messageDigest.digest());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
