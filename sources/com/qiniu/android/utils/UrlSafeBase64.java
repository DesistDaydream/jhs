package com.qiniu.android.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public final class UrlSafeBase64 {
    public static byte[] decode(String str) {
        try {
            return Base64.decode(str, 10);
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static String encodeToString(String str) {
        try {
            return encodeToString(str.getBytes(com.qiniu.android.common.Constants.UTF_8));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String encodeToString(byte[] bArr) {
        return Base64.encodeToString(bArr, 10);
    }
}
