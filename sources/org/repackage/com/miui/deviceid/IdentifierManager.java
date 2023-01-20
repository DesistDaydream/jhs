package org.repackage.com.miui.deviceid;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class IdentifierManager {
    private static final String a = "IdentifierManager";
    private static Object b;

    /* renamed from: c */
    private static Class<?> f17131c;

    /* renamed from: d */
    private static Method f17132d;

    /* renamed from: e */
    private static Method f17133e;

    /* renamed from: f */
    private static Method f17134f;

    /* renamed from: g */
    private static Method f17135g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f17131c = cls;
            b = cls.newInstance();
            f17132d = f17131c.getMethod("getUDID", Context.class);
            f17133e = f17131c.getMethod("getOAID", Context.class);
            f17134f = f17131c.getMethod("getVAID", Context.class);
            f17135g = f17131c.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e(a, "reflect exception!", e2);
        }
    }

    public static boolean a() {
        return (f17131c == null || b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f17133e);
    }

    public static String c(Context context) {
        return a(context, f17134f);
    }

    public static String d(Context context) {
        return a(context, f17135g);
    }

    public static String a(Context context) {
        return a(context, f17132d);
    }

    private static String a(Context context, Method method) {
        Object obj = b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e(a, "invoke exception!", e2);
            return null;
        }
    }
}
