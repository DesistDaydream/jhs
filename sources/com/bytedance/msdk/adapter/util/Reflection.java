package com.bytedance.msdk.adapter.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Reflection {

    /* loaded from: classes.dex */
    public static class MethodBuilder {
        @Nullable
        private final Object a;
        @NonNull
        private final String b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f1864c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private List<Class<?>> f1865d = new ArrayList();
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private List<Object> f1866e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        private boolean f1867f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1868g;

        public MethodBuilder(@Nullable Object obj, @NonNull String str) {
            this.a = obj;
            this.b = str;
            this.f1864c = obj != null ? obj.getClass() : null;
        }

        @NonNull
        public <T> MethodBuilder addParam(@NonNull Class<T> cls, @Nullable T t) {
            this.f1865d.add(cls);
            this.f1866e.add(t);
            return this;
        }

        @NonNull
        public MethodBuilder addParam(@NonNull String str, @Nullable Object obj) throws ClassNotFoundException {
            this.f1865d.add(Class.forName(str));
            this.f1866e.add(obj);
            return this;
        }

        @Nullable
        public Object execute() throws Exception {
            Method declaredMethodWithTraversal = Reflection.getDeclaredMethodWithTraversal(this.f1864c, this.b, (Class[]) this.f1865d.toArray(new Class[this.f1865d.size()]));
            if (this.f1867f) {
                declaredMethodWithTraversal.setAccessible(true);
            }
            return declaredMethodWithTraversal.invoke(this.f1868g ? null : this.a, this.f1866e.toArray());
        }

        @NonNull
        public MethodBuilder setAccessible() {
            this.f1867f = true;
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull Class<?> cls) {
            this.f1868g = true;
            this.f1864c = cls;
            return this;
        }

        @NonNull
        public MethodBuilder setStatic(@NonNull String str) throws ClassNotFoundException {
            this.f1868g = true;
            this.f1864c = Class.forName(str);
            return this;
        }
    }

    public static boolean classFound(@NonNull String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Nullable
    public static Method getDeclaredMethodWithTraversal(@Nullable Class<?> cls, @NonNull String str, @NonNull Class<?>... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static Field getPrivateField(@NonNull Class cls, @NonNull String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField;
    }

    @NonNull
    public static <T> T instantiateClassWithConstructor(@NonNull String str, @NonNull Class<? extends T> cls, @NonNull Class[] clsArr, @NonNull Object[] objArr) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(objArr);
    }

    @NonNull
    public static <T> T instantiateClassWithEmptyConstructor(@NonNull String str, @NonNull Class<? extends T> cls) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NullPointerException {
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(new Object[0]);
    }
}
