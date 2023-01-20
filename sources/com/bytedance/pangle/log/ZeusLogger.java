package com.bytedance.pangle.log;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import java.util.Arrays;

@Keep
/* loaded from: classes.dex */
public class ZeusLogger {
    public static final String TAG = "Zeus";
    public static final String TAG_ACTIVITY = "Zeus/activity";
    public static final String TAG_DOWNLOAD = "Zeus/download";
    public static final String TAG_INIT = "Zeus/init";
    public static final String TAG_INSTALL = "Zeus/install";
    public static final String TAG_LOAD = "Zeus/load";
    public static final String TAG_PAM = "Zeus/pam";
    public static final String TAG_PPM = "Zeus/ppm";
    public static final String TAG_PROVIDER = "Zeus/provider";
    public static final String TAG_RECEIVER = "Zeus/receiver";
    public static final String TAG_REPORTER = "Zeus/reporter";
    public static final String TAG_RESOURCES = "Zeus/resources";
    public static final String TAG_SERVER = "Zeus/server";
    public static final String TAG_SERVICE = "Zeus/service";
    public static final String TAG_SO = "Zeus/so";
    private static boolean sDebug = true;
    private static boolean sEnableTrace = false;

    /* JADX WARN: Removed duplicated region for block: B:17:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String ZeusLogger1663646904212dc(java.lang.String r2) {
        /*
        L0:
            r0 = 74
            r1 = 55
        L4:
            switch(r0) {
                case 72: goto L0;
                case 73: goto L8;
                case 74: goto Lb;
                default: goto L7;
            }
        L7:
            goto L2b
        L8:
            switch(r1) {
                case 94: goto L26;
                case 95: goto Lf;
                case 96: goto Lf;
                default: goto Lb;
            }
        Lb:
            switch(r1) {
                case 55: goto L26;
                case 56: goto L26;
                case 57: goto Lf;
                default: goto Le;
            }
        Le:
            goto L26
        Lf:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L14:
            int r1 = r2.length
            if (r0 >= r1) goto L20
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L14
        L20:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L26:
            r0 = 73
            r1 = 96
            goto L4
        L2b:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.log.ZeusLogger.ZeusLogger1663646904212dc(java.lang.String):java.lang.String");
    }

    public static void d(String str) {
        d(null, str);
    }

    public static void d(String str, String str2) {
        i(str, str2);
    }

    public static void errReport(String str, String str2) {
        RuntimeException runtimeException = new RuntimeException();
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, 1, stackTrace.length - 1));
        errReport(str, str2, runtimeException, false);
    }

    public static void errReport(String str, String str2, @NonNull Throwable th) {
        errReport(str, str2, th, true);
    }

    private static void errReport(String str, String str2, @NonNull Throwable th, boolean z) {
        if (sDebug) {
            if (!z) {
                th = null;
            }
            Log.e(str, str2, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            IZeusLogger logger = GlobalParam.getInstance().getLogger();
            if (!z) {
                th = null;
            }
            logger.e(str, str2, th);
        }
    }

    private static String getTraceInfo() {
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StackTraceElement stackTraceElement = null;
            int i2 = 1;
            while (true) {
                if (i2 >= stackTrace.length) {
                    break;
                } else if (!TextUtils.equals(stackTrace[i2].getClassName(), ZeusLogger.class.getName())) {
                    stackTraceElement = stackTrace[i2];
                    break;
                } else {
                    i2++;
                }
            }
            if (stackTraceElement != null) {
                return "\t\t[" + stackTraceElement.toString() + "]";
            }
            return "\t\t[No Trace Info]";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "\t\t[No Trace Info]";
        }
    }

    public static void i(String str) {
        i(null, str);
    }

    public static void i(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.i(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().i(str, prefixTraceInfo);
        }
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isEnableTrace() {
        return sEnableTrace;
    }

    private static String prefixTraceInfo(String str) {
        if (sEnableTrace) {
            return str + getTraceInfo();
        }
        return str;
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void setEnableTrace(boolean z) {
        sEnableTrace = z;
    }

    public static void v(String str) {
        v(null, str);
    }

    public static void v(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.v(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().v(str, prefixTraceInfo);
        }
    }

    public static void w(String str) {
        w(null, str);
    }

    public static void w(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, prefixTraceInfo, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo, th);
        }
    }
}
