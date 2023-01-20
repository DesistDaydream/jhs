package e.k.c.a.a.k;

import android.text.TextUtils;
import android.util.Log;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;

/* loaded from: classes2.dex */
public abstract class f {
    private static boolean a(String str) {
        String[] strArr = {"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"};
        for (int i2 = 0; i2 < 10; i2++) {
            if (str.contains(strArr[i2])) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(ExpandableTextView.N);
        }
        sb.append("Exception: ");
        sb.append(th.getClass().getName());
        sb.append('\n');
        if (!a(th.getClass().getCanonicalName())) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                sb.append("Stack trace is NULL!");
                sb.append('\n');
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public static void c(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        Log.w(str, b(str2, th));
    }
}
