package com.huawei.secure.android.common.util;

import android.util.Base64;
import android.util.Log;

/* loaded from: classes2.dex */
public class SafeBase64 {
    private static final String a = "SafeBase64";

    private SafeBase64() {
    }

    public static byte[] decode(byte[] bArr, int i2) {
        try {
            return Base64.decode(bArr, i2);
        } catch (Exception e2) {
            String str = a;
            Log.e(str, e2.getClass().getSimpleName() + " , message0 : " + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i2) {
        try {
            return Base64.encode(bArr, i2);
        } catch (Exception e2) {
            String str = a;
            Log.e(str, e2.getClass().getSimpleName() + " , message3 : " + e2.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i2) {
        try {
            return Base64.encodeToString(bArr, i2);
        } catch (Exception e2) {
            String str = a;
            Log.e(str, e2.getClass().getSimpleName() + " , message5 : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) {
        try {
            return Base64.decode(bArr, i2, i3, i4);
        } catch (Exception e2) {
            String str = a;
            Log.e(str, e2.getClass().getSimpleName() + " , message1 : " + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i2, int i3, int i4) {
        try {
            return Base64.encode(bArr, i2, i3, i4);
        } catch (Exception e2) {
            String str = a;
            Log.e(str, e2.getClass().getSimpleName() + " , message4 : " + e2.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i2, int i3, int i4) {
        try {
            return Base64.encodeToString(bArr, i2, i3, i4);
        } catch (Exception e2) {
            String str = a;
            Log.e(str, e2.getClass().getSimpleName() + " , message6 : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] decode(String str, int i2) {
        try {
            return Base64.decode(str, i2);
        } catch (Exception e2) {
            String str2 = a;
            Log.e(str2, e2.getClass().getSimpleName() + " , message2 : " + e2.getMessage());
            return new byte[0];
        }
    }
}
