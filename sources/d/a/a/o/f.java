package d.a.a.o;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public class f {
    private static String a = "";
    public static List<ActivityManager.RunningAppProcessInfo> b;

    private static String a() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "";
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(a)) {
            String c2 = c();
            a = c2;
            if (TextUtils.isEmpty(c2)) {
                String a2 = a();
                a = a2;
                if (TextUtils.isEmpty(a2)) {
                    String d2 = d(context);
                    a = d2;
                    return d2;
                }
                return a;
            }
            return a;
        }
        return a;
    }

    private static String c() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    private static String d(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            if (b == null) {
                b = activityManager.getRunningAppProcesses();
            }
            List<ActivityManager.RunningAppProcessInfo> list = b;
            if (list != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "";
            }
            return "";
        }
        return "";
    }
}
