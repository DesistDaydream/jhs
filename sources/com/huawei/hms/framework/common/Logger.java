package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class Logger {
    private static final boolean DEBUG = false;
    private static final int MAX_STACK_DEEP_LENGTH = 20;
    private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    private static final String SPLIT = "|";
    private static final String TAG = "NetworkKit_Logger";
    private static final String TAG_NETWORKKIT_PRE = "NetworkKit_";
    private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    private static ExtLogger extLogger = null;
    private static boolean kitPrint = true;

    /* loaded from: classes2.dex */
    public static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String message;
        private Throwable ownerThrowable;
        private Throwable thisCause;

        /* JADX INFO: Access modifiers changed from: private */
        public void setCause(Throwable th) {
            this.thisCause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th = this.thisCause;
            if (th == this) {
                return null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.ownerThrowable;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.message != null) {
                String str = name + ": ";
                if (this.message.startsWith(str)) {
                    return this.message;
                }
                return str + this.message;
            }
            return name;
        }

        private ThrowableWrapper(Throwable th) {
            this.ownerThrowable = th;
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i2 = ((th instanceof IOException) || (th instanceof JSONException)) ? 8 : 20;
            if (stackTrace.length > i2) {
                setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i2));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(StringUtils.anonymizeMessage(th.getMessage()));
        }
    }

    private static String complexAppTag(String str) {
        return TAG_NETWORK_SDK_PRE + str;
    }

    private static String complexMsg(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            return getCallMethodInfo(i2) + "|" + str;
        }
        return getCallMethodInfo(i2);
    }

    private static String complexTag(String str) {
        return TAG_NETWORKKIT_PRE + str;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    private static void extLogPrintln(int i2, String str, String str2) {
        if (i2 == 2) {
            extLogger.v(str, str2);
        } else if (i2 == 3) {
            extLogger.d(str, str2);
        } else if (i2 == 4) {
            extLogger.i(str, str2);
        } else if (i2 == 5) {
            extLogger.w(str, str2);
        } else if (i2 != 6) {
        } else {
            extLogger.e(str, str2);
        }
    }

    private static String getCallMethodInfo(int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > i2) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            return Thread.currentThread().getName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
        }
        return "";
    }

    private static Throwable getNewThrowable(Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        if (th == null) {
            return null;
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(th);
        Throwable cause = th.getCause();
        ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause);
            throwableWrapper2.setCause(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    private static boolean isAPPLoggable(int i2) {
        return extLogger != null && i2 >= 3;
    }

    private static boolean isKitLoggable(int i2) {
        return kitPrint && isLoggable(i2);
    }

    public static boolean isLoggable(int i2) {
        return Log.isLoggable(TAG_NETWORKKIT_PRE, i2);
    }

    private static int logPrintln(int i2, String str, String str2) {
        if (isAPPLoggable(i2)) {
            extLogPrintln(i2, complexAppTag(str), complexMsg(str2, 7));
        }
        if (isKitLoggable(i2)) {
            return Log.println(i2, complexTag(str), complexMsg(str2, 7));
        }
        return 1;
    }

    public static void println(int i2, String str, Object obj) {
        if (i2 < 3) {
            return;
        }
        logPrintln(i2, str, obj == null ? "null" : obj.toString());
    }

    public static void setExtLogger(ExtLogger extLogger2, boolean z) {
        extLogger = extLogger2;
        kitPrint = z;
        i(TAG, "logger = " + extLogger2 + z);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static void println(int i2, String str, String str2, Object... objArr) {
        if (i2 < 3) {
            return;
        }
        if (str2 == null) {
            Log.w(TAG, "format is null, not log");
            return;
        }
        try {
            logPrintln(i2, str, StringUtils.format(str2, objArr));
        } catch (IllegalFormatException e2) {
            w(TAG, "log format error" + str2, e2);
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }

    public static void e(String str, String str2, Throwable th) {
        if (isAPPLoggable(6)) {
            extLogger.e(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
        if (kitPrint) {
            Log.e(complexTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (isAPPLoggable(5)) {
            extLogger.w(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
        if (kitPrint) {
            Log.w(complexTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
    }
}
