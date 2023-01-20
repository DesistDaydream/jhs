package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes.dex */
public class f {
    private static String a;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
        if (r1 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L46
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L46
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
            r4.<init>()     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L46
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L46
            r4.append(r5)     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = "/cmdline"
            r4.append(r5)     // Catch: java.lang.Throwable -> L46
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L46
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L46
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L46
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            r2.<init>()     // Catch: java.lang.Throwable -> L44
        L31:
            int r3 = r1.read()     // Catch: java.lang.Throwable -> L44
            if (r3 <= 0) goto L3c
            char r3 = (char) r3     // Catch: java.lang.Throwable -> L44
            r2.append(r3)     // Catch: java.lang.Throwable -> L44
            goto L31
        L3c:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L44
        L40:
            r1.close()     // Catch: java.lang.Exception -> L4a
            goto L4a
        L44:
            goto L47
        L46:
            r1 = r0
        L47:
            if (r1 == 0) goto L4a
            goto L40
        L4a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f.a():java.lang.String");
    }

    public static String a(Context context) {
        String str = a;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String str2 = runningAppProcessInfo.processName;
                        a = str2;
                        return str2;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String a2 = a();
            a = a2;
            return a2;
        }
        return str;
    }

    public static boolean b(Context context) {
        String a2 = a(context);
        return (a2 == null || !a2.contains(Constants.COLON_SEPARATOR)) && a2 != null && a2.equals(context.getPackageName());
    }

    public static boolean c(Context context) {
        String a2 = a(context);
        return a2 != null && (a2.endsWith(":push") || a2.endsWith(":pushservice"));
    }
}
