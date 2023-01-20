package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class i0 {
    private static String a(Context context) {
        int myPid = Process.myPid();
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str;
    }

    public static boolean b(Context context) {
        try {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                if (packageName.equalsIgnoreCase(a(context))) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
