package e.k.c.a.a.k;

import android.app.Activity;
import android.view.Window;
import com.huawei.secure.android.common.util.LogsUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes2.dex */
public class i {
    private static final String a = "ScreenUtil";
    private static final int b = 524288;

    /* loaded from: classes2.dex */
    public static class a implements PrivilegedAction {
        public Method a;

        public a(Method method) {
            this.a = method;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            Method method = this.a;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }
    }

    private static void a(Activity activity, int i2) {
        if (activity != null && !activity.isFinishing()) {
            activity.getWindow().addFlags(i2);
        } else {
            LogsUtil.l("", "activity is null");
        }
    }

    private static void b(Activity activity, int i2) {
        if (activity != null && !activity.isFinishing()) {
            activity.getWindow().clearFlags(i2);
        } else {
            LogsUtil.l("", "activity is null");
        }
    }

    public static void c(Activity activity) {
        a(activity, 8192);
    }

    public static void d(Activity activity) {
        b(activity, 8192);
    }

    public static void e(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            Window window = activity.getWindow();
            Method declaredMethod = Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", Integer.TYPE);
            AccessController.doPrivileged(new a(declaredMethod));
            declaredMethod.invoke(window, 524288);
        } catch (ClassNotFoundException unused) {
            LogsUtil.l(a, "hideOverlayWindows ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            LogsUtil.l(a, "hideOverlayWindows IllegalAccessException");
        } catch (NoSuchMethodException unused3) {
            LogsUtil.l(a, "hideOverlayWindows NoSuchMethodException");
        } catch (InvocationTargetException unused4) {
            LogsUtil.l(a, "hideOverlayWindows InvocationTargetException");
        }
    }
}
