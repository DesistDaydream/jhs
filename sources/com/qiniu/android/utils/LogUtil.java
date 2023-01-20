package com.qiniu.android.utils;

import android.util.Log;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.imsdk.BaseConstants;
import java.util.Date;

/* loaded from: classes3.dex */
public class LogUtil {
    private static boolean enableDate = false;
    private static boolean enableFile = true;
    private static boolean enableFunction = false;
    private static boolean enableLog = false;
    private static int logLevel = 2;

    public static int d(String str) {
        return println(3, null, str, null);
    }

    public static int e(String str) {
        return println(6, null, str, null);
    }

    public static void enableDate(boolean z) {
        enableDate = z;
    }

    public static void enableFile(boolean z) {
        enableFile = z;
    }

    public static void enableFunction(boolean z) {
        enableFunction = z;
    }

    public static void enableLog(boolean z) {
        enableLog = z;
    }

    public static int i(String str) {
        return println(4, null, str, null);
    }

    private static int println(int i2, String str, String str2, Throwable th) {
        if (shouldLog(i2, str, str2, th)) {
            if (i2 == 2) {
                if (th == null) {
                    return Log.v(recreateLogTag(str), recreateLogMessage(str2));
                }
                return Log.v(recreateLogTag(str), recreateLogMessage(str2), th);
            } else if (i2 == 3) {
                if (th == null) {
                    return Log.d(recreateLogTag(str), recreateLogMessage(str2));
                }
                return Log.d(recreateLogTag(str), recreateLogMessage(str2), th);
            } else if (i2 == 4) {
                if (th == null) {
                    return Log.i(recreateLogTag(str), recreateLogMessage(str2));
                }
                return Log.i(recreateLogTag(str), recreateLogMessage(str2), th);
            } else if (i2 == 5) {
                if (th == null) {
                    return Log.w(recreateLogTag(str), recreateLogMessage(str2));
                }
                return Log.w(recreateLogTag(str), recreateLogMessage(str2), th);
            } else if (i2 != 6) {
                return BaseConstants.ERR_SVR_SSO_D2_EXPIRED;
            } else {
                if (th == null) {
                    return Log.e(recreateLogTag(str), recreateLogMessage(str2));
                }
                return Log.e(recreateLogTag(str), recreateLogMessage(str2), th);
            }
        }
        return BaseConstants.ERR_SVR_SSO_VCODE;
    }

    private static String recreateLogMessage(String str) {
        return str != null ? str : "";
    }

    private static String recreateLogTag(String str) {
        String str2;
        String str3;
        Thread currentThread;
        StackTraceElement stackTraceElement;
        String str4 = "";
        if (str != null) {
            str2 = str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
        } else {
            str2 = "";
        }
        if (enableDate) {
            str3 = "" + new Date();
        } else {
            str3 = "";
        }
        String str5 = StringUtils.toNonnullString(currentThread.getName()) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + StringUtils.toNonnullString(Long.valueOf(currentThread.getId())) + ExpandableTextView.N;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > 5 && stackTrace[5] != null) {
            String nonnullString = enableFile ? StringUtils.toNonnullString(stackTrace[5].getFileName()) : "";
            if (enableFunction) {
                str4 = "->" + StringUtils.toNonnullString(stackTraceElement.getMethodName());
            }
            return str3 + "[QiNiu:" + str5 + str2 + nonnullString + str4 + ("->" + stackTraceElement.getLineNumber()) + "]";
        }
        return str3 + "[QiNiu:" + str5 + str2 + "]";
    }

    public static void setLogLevel(int i2) {
        logLevel = i2;
    }

    private static boolean shouldLog(int i2, String str, String str2, Throwable th) {
        if (!enableLog || i2 < logLevel) {
            return false;
        }
        return ((str2 == null || str2.length() == 0) && th == null) ? false : true;
    }

    public static int v(String str) {
        return println(2, null, str, null);
    }

    public static int w(String str) {
        return println(5, null, str, null);
    }

    public static int d(String str, String str2) {
        return println(3, str, str2, null);
    }

    public static int e(String str, String str2) {
        return println(6, str, str2, null);
    }

    public static int i(String str, String str2) {
        return println(4, str, str2, null);
    }

    public static int v(String str, String str2) {
        return println(2, str, str2, null);
    }

    public static int w(String str, String str2) {
        return println(5, str, str2, null);
    }

    public static int d(String str, String str2, Throwable th) {
        return println(3, str, str2, th);
    }

    public static int e(String str, String str2, Throwable th) {
        return println(6, str, str2, th);
    }

    public static int i(String str, String str2, Throwable th) {
        return println(4, str, str2, th);
    }

    public static int v(String str, String str2, Throwable th) {
        return println(2, str, str2, th);
    }

    public static int w(String str, String str2, Throwable th) {
        return println(5, str, str2, th);
    }

    public static int w(String str, Throwable th) {
        return println(5, str, null, th);
    }
}
