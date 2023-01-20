package com.meizu.cloud.pushsdk.b.b;

import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
public class b {
    private final a a;
    private final Class<?>[] b;

    public b(a aVar, Class<?>... clsArr) {
        this.a = aVar;
        this.b = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.a.a().getDeclaredConstructor(this.b);
            declaredConstructor.setAccessible(true);
            dVar.b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e2) {
            e.p.a.a.a.d("ReflectConstructor", "newInstance", e2);
        }
        return dVar;
    }
}
