package com.qiniu.android.utils;

import h.t2.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class StringUtils {
    public static String getAkAndScope(String str) {
        String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        String str2 = split[0];
        try {
            String str3 = new JSONObject(new String(UrlSafeBase64.decode(split[2]), com.qiniu.android.common.Constants.UTF_8)).getString("scope").split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[0];
            return str2 + str3;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getBucket(String str) {
        try {
            return new JSONObject(new String(UrlSafeBase64.decode(str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[2]), com.qiniu.android.common.Constants.UTF_8)).getString("scope").split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[0];
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().equals("");
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static String join(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        int length = strArr.length;
        StringBuilder sb = new StringBuilder(length == 0 ? 0 : ((strArr[0] == null ? 16 : strArr[0].length()) + ((str == null || str.equals("")) ? 0 : str.length())) * length);
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 > 0) {
                sb.append(str);
            }
            if (strArr[i2] != null) {
                sb.append(strArr[i2]);
            }
        }
        return sb.toString();
    }

    public static String jsonJoin(String[] strArr) {
        int length = strArr.length;
        if (strArr[0] == null) {
            strArr[0] = "";
        }
        StringBuilder sb = new StringBuilder((strArr[0].length() + 3) * length);
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 > 0) {
                sb.append(',');
            }
            sb.append(y.a);
            sb.append(strArr[i2]);
            sb.append(y.a);
        }
        return sb.toString();
    }

    public static String[] longToString(Long[] lArr) {
        int length = lArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                strArr[i2] = String.valueOf(lArr[i2]);
            } catch (NumberFormatException unused) {
                strArr[i2] = "null";
            }
        }
        return strArr;
    }

    public static String strip(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static byte[] toByteArray(Object obj) {
        byte[] bArr = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bArr;
    }

    public static String toNonnullString(Object obj) {
        if (obj == null) {
            return "";
        }
        return "" + obj;
    }

    public static Object toObject(byte[] bArr) {
        Object obj = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                obj = objectInputStream.readObject();
                objectInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            byteArrayInputStream.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return obj;
    }

    public static String upperCase(String str) {
        if (str.length() <= 0 || str == null) {
            return "";
        }
        char[] charArray = str.toCharArray();
        if (charArray[0] >= 'a' && charArray[0] <= 'z') {
            charArray[0] = (char) (charArray[0] - ' ');
        }
        return new String(charArray);
    }

    public static byte[] utf8Bytes(String str) {
        try {
            return str.getBytes(com.qiniu.android.common.Constants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static String jsonJoin(Long[] lArr) {
        return jsonJoin(longToString(lArr));
    }
}
