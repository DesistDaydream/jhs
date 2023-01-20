package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* loaded from: classes2.dex */
public class Service {
    private final Class<?> a;
    private final Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f3392c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3393d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3394e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3395f;

    /* loaded from: classes2.dex */
    public static class Builder {
        public Class<?> a;
        public Class<?> b;

        /* renamed from: c  reason: collision with root package name */
        public Object f3396c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3397d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3398e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3399f;

        public Service build() {
            Class<?> cls = this.a;
            if (cls != null) {
                Class<?> cls2 = this.b;
                if (cls2 == null) {
                    Object obj = this.f3396c;
                    if (obj != null) {
                        Service service = new Service(cls, obj);
                        service.f3393d = this.f3397d;
                        return service;
                    }
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                } else if (cls2.isInterface() || !Modifier.isPublic(this.b.getModifiers())) {
                    throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
                } else {
                    Service service2 = new Service((Class) this.a, (Class) this.b);
                    service2.f3393d = this.f3397d;
                    service2.f3394e = this.f3398e;
                    service2.f3395f = this.f3399f;
                    return service2;
                }
            }
            throw new IllegalArgumentException("the interface parameter cannot be NULL");
        }

        public Builder isAutoCreated(boolean z) {
            this.f3399f = z;
            return this;
        }

        public Builder isSharedInstance(boolean z) {
            this.f3398e = z;
            return this;
        }

        public Builder isSingleton(boolean z) {
            this.f3397d = z;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.f3396c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.a = cls;
        this.b = cls2;
        this.f3392c = null;
    }

    private Service(Class<?> cls, Object obj) {
        this.a = cls;
        this.b = null;
        this.f3392c = obj;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.f3392c;
    }

    public Class<?> getInterface() {
        return this.a;
    }

    public Class<?> getType() {
        return this.b;
    }

    public boolean isAutoCreated() {
        return this.f3395f;
    }

    public boolean isSharedInstance() {
        return this.f3394e;
    }

    public boolean isSingleton() {
        return this.f3393d;
    }
}
