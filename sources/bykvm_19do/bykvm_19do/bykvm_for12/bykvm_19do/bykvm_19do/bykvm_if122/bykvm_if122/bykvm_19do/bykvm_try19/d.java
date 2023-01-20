package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class d<T> {
    private final Class<?> a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final Class[] f541c;

    public d(Class<?> cls, String str, Class... clsArr) {
        this.a = cls;
        this.b = str;
        this.f541c = clsArr;
    }

    private Method a(Class<?> cls) {
        Method a;
        Class<?> cls2;
        String str = this.b;
        if (str == null || !((a = a(cls, str, this.f541c)) == null || (cls2 = this.a) == null || cls2.isAssignableFrom(a.getReturnType()))) {
            return null;
        }
        return a;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
        }
        try {
            if ((method.getModifiers() & 1) == 0) {
                return null;
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return method;
        }
    }

    public Object a(T t, Object... objArr) throws InvocationTargetException {
        Method a = a(t.getClass());
        if (a == null) {
            throw new AssertionError("Method " + this.b + " not supported for object " + t);
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException e2) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
            assertionError.initCause(e2);
            throw assertionError;
        }
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object b(T t, Object... objArr) throws InvocationTargetException {
        Method a = a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }
        return null;
    }

    public Object c(T t, Object... objArr) {
        try {
            return b(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
