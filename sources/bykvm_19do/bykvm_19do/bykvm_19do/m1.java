package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class m1 implements a1 {
    private static Object a;
    private static Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f151c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
            f151c = b.getMethod("getOAID", Context.class);
        } catch (Exception unused) {
        }
    }

    private static String a(Context context, Method method) {
        Object obj = a;
        if (obj != null && method != null) {
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (String) invoke;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean a() {
        return (b == null || a == null || f151c == null) ? false : true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        return a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        try {
            a1.a aVar = new a1.a();
            aVar.a = a(context, f151c);
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
