package com.meizu.cloud.pushsdk.b.b;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class a {
    private static final HashMap<String, Class<?>> a = new HashMap<>();
    private Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private String f4639c;

    /* renamed from: d  reason: collision with root package name */
    private Object f4640d;

    private a(Object obj) {
        this.f4640d = obj;
    }

    private a(String str) {
        this.f4639c = str;
    }

    public static a a(Object obj) {
        return new a(obj);
    }

    public static a a(String str) {
        return new a(str);
    }

    public b a(Class<?>... clsArr) {
        return new b(this, clsArr);
    }

    public c a(String str, Class<?>... clsArr) {
        return new c(this, str, clsArr);
    }

    public Class<?> a() {
        Class<?> cls = this.b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f4640d;
        if (obj != null) {
            return obj.getClass();
        }
        HashMap<String, Class<?>> hashMap = a;
        Class<?> cls2 = hashMap.get(this.f4639c);
        if (cls2 == null) {
            cls2 = Class.forName(this.f4639c);
            hashMap.put(this.f4639c, cls2);
        }
        return cls2;
    }
}
