package com.meizu.cloud.pushsdk.b.b;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class c {
    private static final HashMap<String, Method> a = new HashMap<>();
    private final com.meizu.cloud.pushsdk.b.b.a b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4643c;

    /* renamed from: d  reason: collision with root package name */
    private Class<?>[] f4644d;

    /* loaded from: classes2.dex */
    public class a {
    }

    public c(com.meizu.cloud.pushsdk.b.b.a aVar, String str, Class<?>... clsArr) {
        this.b = aVar;
        this.f4643c = str;
        this.f4644d = clsArr;
    }

    private Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    private Method a() {
        Method[] methods;
        Method[] declaredMethods;
        Class<?> a2 = this.b.a();
        for (Method method : a2.getMethods()) {
            if (a(method, this.f4643c, this.f4644d)) {
                return method;
            }
        }
        for (Method method2 : a2.getDeclaredMethods()) {
            if (a(method2, this.f4643c, this.f4644d)) {
                return method2;
            }
        }
        throw new NoSuchMethodException("No similar method " + this.f4643c + " with params " + Arrays.toString(this.f4644d) + " could be found on type " + a2);
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i2 = 0; i2 < clsArr2.length; i2++) {
                if (clsArr2[i2] != a.class && !a(clsArr[i2]).isAssignableFrom(a(clsArr2[i2]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private String b() {
        StringBuilder sb = new StringBuilder(this.b.a().getName());
        sb.append(this.f4643c);
        for (Class<?> cls : this.f4644d) {
            sb.append(cls.getName());
        }
        return sb.toString();
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b = b();
            Method method = a.get(b);
            if (method == null) {
                if (this.f4644d.length == objArr.length) {
                    method = this.b.a().getMethod(this.f4643c, this.f4644d);
                } else {
                    if (objArr.length > 0) {
                        this.f4644d = new Class[objArr.length];
                        for (int i2 = 0; i2 < objArr.length; i2++) {
                            this.f4644d[i2] = objArr[i2].getClass();
                        }
                    }
                    method = a();
                }
                a.put(b, method);
            }
            method.setAccessible(true);
            dVar.b = (T) method.invoke(obj, objArr);
            dVar.a = true;
        } catch (Exception e2) {
            e.p.a.a.a.e("ReflectMethod", "invoke exception, " + e2.getMessage());
        }
        return dVar;
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.b.a(), objArr);
        } catch (ClassNotFoundException unused) {
            return new d<>();
        }
    }
}
