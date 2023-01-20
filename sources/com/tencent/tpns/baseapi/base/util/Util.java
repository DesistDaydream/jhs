package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.a;
import com.tencent.tpns.baseapi.core.c.c;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes3.dex */
public class Util {
    private static PowerManager.WakeLock a = null;
    private static long b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static String f6873c;

    public static boolean checkAccessId(long j2) {
        if (j2 < 1500000000 || j2 >= 1600000000) {
            if (j2 < 1800000000 || j2 >= 1900000000) {
                Logger.e("Util", "AccessId is Invalid!!, accessId: " + j2);
                return false;
            }
            return true;
        }
        return true;
    }

    public static boolean checkAccessKey(String str) {
        if (str != null && str.length() == 12) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (!Character.isUpperCase(str.charAt(i2)) && !Character.isDigit(str.charAt(i2))) {
                    Logger.e("Util", "AccessKey is Invalid!!, accessKey: " + str);
                    return false;
                }
            }
            return true;
        }
        Logger.e("Util", "AccessKey is Invalid!!, accessKey: " + str);
        return false;
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            Logger.i("Util", "checkPermission error:" + str, th);
            return false;
        }
    }

    public static String getCurAppVersion(Context context) {
        if (!isNullOrEmptyString(f6873c)) {
            return f6873c;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f6873c = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            Logger.e("Util", "get app version error", th);
        }
        return f6873c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        com.tencent.tpns.baseapi.base.util.TGlobalHelper.curProcessName = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getCurProcessName(android.content.Context r3) {
        /*
            java.lang.String r0 = com.tencent.tpns.baseapi.base.util.TGlobalHelper.curProcessName
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r3 = com.tencent.tpns.baseapi.base.util.TGlobalHelper.curProcessName
            return r3
        Lb:
            java.lang.String r0 = getCurProcessNameByProcFile(r3)
            boolean r1 = isNullOrEmptyString(r0)
            if (r1 != 0) goto L2a
            java.lang.String r1 = r3.getPackageName()
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L2a
            java.lang.String r1 = "SecurityException"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L2a
            com.tencent.tpns.baseapi.base.util.TGlobalHelper.curProcessName = r0
            return r0
        L2a:
            if (r3 == 0) goto L75
            java.lang.String r0 = "activity"
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch: java.lang.Throwable -> L57
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3     // Catch: java.lang.Throwable -> L57
            if (r3 == 0) goto L72
            int r0 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L57
            java.util.List r3 = r3.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L57
        L42:
            boolean r1 = r3.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L72
            java.lang.Object r1 = r3.next()     // Catch: java.lang.Throwable -> L57
            android.app.ActivityManager$RunningAppProcessInfo r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1     // Catch: java.lang.Throwable -> L57
            int r2 = r1.pid     // Catch: java.lang.Throwable -> L57
            if (r2 != r0) goto L42
            java.lang.String r3 = r1.processName     // Catch: java.lang.Throwable -> L57
            com.tencent.tpns.baseapi.base.util.TGlobalHelper.curProcessName = r3     // Catch: java.lang.Throwable -> L57
            goto L72
        L57:
            r3 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "#unexcepted - getCurProcessName failed:"
            r0.append(r1)
            java.lang.String r3 = r3.getMessage()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "Util"
            com.tencent.tpns.baseapi.base.util.Logger.w(r0, r3)
        L72:
            java.lang.String r3 = com.tencent.tpns.baseapi.base.util.TGlobalHelper.curProcessName
            return r3
        L75:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.base.util.Util.getCurProcessName(android.content.Context):java.lang.String");
    }

    public static String getCurProcessNameByProcFile(Context context) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (Throwable th) {
                    Logger.e("Util", "" + th);
                }
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    Logger.e("Util", "" + th);
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            Logger.e("Util", "" + th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static long getCurVersionCode(Context context) {
        long j2 = b;
        if (j2 > 0) {
            return j2;
        }
        try {
            b = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.e("Util", "getCurVersionCode error: PackageManager.NameNotFoundException", e2);
            b = -1L;
        }
        return b;
    }

    public static String getKey(String str) {
        return Md5.md5(str);
    }

    public static String getNotifiedMsgIds(Context context, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(PushMd5Pref.getString(context, "tpush_msgId_" + j2, true));
        String sb2 = sb.toString();
        if (sb2 != null && sb2.length() > 20480) {
            sb2 = sb2.substring(0, sb2.indexOf("@@", 5120));
        }
        return sb2 != null ? sb2 : "";
    }

    public static String getThrowableToString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void getWakeCpu(Context context) {
        if (context == null) {
            Logger.e("Util", "Util -> getWakeCpu error null context");
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (a == null) {
                a = powerManager.newWakeLock(536870913, "TPNS:VIP");
                c.a().a(a);
            }
            if (!c.a().b().isHeld()) {
                c.a().b().setReferenceCounted(false);
                c.a().b().acquire(a.q);
            }
            Logger.d("Util", "get Wake Cpu ");
        } catch (Throwable th) {
            Logger.e("Util", "get Wake cpu", th);
        }
    }

    public static boolean isMainProcess(Context context) {
        if (context == null) {
            return false;
        }
        String curProcessName = getCurProcessName(context);
        if (isNullOrEmptyString(curProcessName)) {
            return false;
        }
        return context.getPackageName().equals(curProcessName);
    }

    public static boolean isNullOrEmptyString(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static void stopWakeCpu() {
        try {
            PowerManager.WakeLock b2 = c.a().b();
            if (b2 != null) {
                if (b2.isHeld()) {
                    b2.release();
                }
                Logger.d("Util", "stop WakeLock CPU");
            }
        } catch (Throwable th) {
            Logger.e("Util", "stopWakeLock", th);
        }
    }
}
