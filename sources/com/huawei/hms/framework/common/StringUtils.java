package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.secure.android.common.util.SafeString;
import com.qiniu.android.common.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Locale;

/* loaded from: classes2.dex */
public class StringUtils {
    private static final int INIT_CAPACITY = 1024;
    private static boolean IS_AEGIS_STRING_LIBRARY_LOADED = false;
    private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
    private static final String TAG = "StringUtils";

    public static String anonymizeMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (i2 % 2 != 0) {
                charArray[i2] = '*';
            }
        }
        return new String(charArray);
    }

    public static String byte2Str(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", anonymizeMessage(e2.getMessage()));
            return "";
        }
    }

    private static boolean checkCompatible(String str) {
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (StringUtils.class) {
                IS_AEGIS_STRING_LIBRARY_LOADED = true;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static String collection2String(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : collection) {
            sb.append(str);
            sb.append(";");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    public static byte[] getBytes(long j2) {
        return getBytes(String.valueOf(j2));
    }

    public static String getTraceInfo(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder(1024);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("at ");
            sb.append(stackTraceElement.toString());
            sb.append(";");
        }
        return sb.toString();
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.replace(str, charSequence, charSequence2);
            } catch (Throwable unused) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(charSequence)) {
            return str;
        }
        try {
            return str.replace(charSequence, charSequence2);
        } catch (Exception unused2) {
            return str;
        }
    }

    public static byte[] str2Byte(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", anonymizeMessage(e2.getMessage()));
            return new byte[0];
        }
    }

    public static boolean strEquals(String str, String str2) {
        return str == str2 || (str != null && str.equals(str2));
    }

    public static boolean stringToBoolean(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        try {
            return Boolean.valueOf(str).booleanValue();
        } catch (NumberFormatException e2) {
            Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e2.getMessage()));
            return z;
        }
    }

    public static int stringToInteger(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e2.getMessage()));
            return i2;
        }
    }

    public static long stringToLong(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return j2;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            Logger.w(TAG, "String to Long catch NumberFormatException." + anonymizeMessage(e2.getMessage()));
            return j2;
        }
    }

    public static String substring(String str, int i2) {
        if (checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.substring(str, i2);
            } catch (Throwable unused) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (!TextUtils.isEmpty(str) && str.length() >= i2 && i2 >= 0) {
            try {
                return str.substring(i2);
            } catch (Exception unused2) {
            }
        }
        return "";
    }

    public static String toLowerCase(String str) {
        return str == null ? "" : str.toLowerCase(Locale.ROOT);
    }

    public static byte[] getBytes(String str) {
        byte[] bArr = new byte[0];
        if (str == null) {
            return bArr;
        }
        try {
            return str.getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            Logger.w(TAG, "the content has error while it is converted to bytes");
            return bArr;
        }
    }

    public static String substring(String str, int i2, int i3) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.substring(str, i2, i3);
            } catch (Throwable unused) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (!TextUtils.isEmpty(str) && i2 >= 0 && i3 <= str.length() && i3 >= i2) {
            try {
                return str.substring(i2, i3);
            } catch (Exception unused2) {
            }
        }
        return "";
    }
}
