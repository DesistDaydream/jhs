package d.a.a.o;

import cn.thinkingdata.android.utils.TDLog;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class g {
    public static String a = "ThinkingAnalytics.TAReflectUtils";

    public static Object a(Object obj, String str, Object[] objArr, Class<?>... clsArr) {
        Method c2 = c(obj, str, clsArr);
        if (c2 != null) {
            try {
                return c2.invoke(obj, objArr);
            } catch (Exception e2) {
                TDLog.e(a, e2.getMessage());
                return null;
            }
        }
        String str2 = a;
        TDLog.i(str2, "Could not find method [" + str + "] on target [" + obj + "]");
        return null;
    }

    public static Object b(String str) {
        try {
            try {
                return Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return null;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static Method c(Object obj, String str, Class<?>... clsArr) {
        if (obj == null) {
            TDLog.i(a, "obj is null!");
            return null;
        }
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        return null;
    }

    public static void d(String str, String str2, Object[] objArr, Class<?>... clsArr) {
        Class.forName(str).getDeclaredMethod(str2, clsArr).invoke(null, objArr);
    }
}
