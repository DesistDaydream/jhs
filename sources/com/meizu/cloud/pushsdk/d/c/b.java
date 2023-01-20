package com.meizu.cloud.pushsdk.d.c;

import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.d.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;

/* loaded from: classes2.dex */
public class b extends com.meizu.cloud.pushsdk.d.c.a {
    private final String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4834c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4835d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4836e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4837f;

    /* renamed from: g  reason: collision with root package name */
    private final String f4838g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4839h;

    /* renamed from: i  reason: collision with root package name */
    private final int f4840i;

    /* loaded from: classes2.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0159a<T> {
        private String a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f4841c;

        /* renamed from: d  reason: collision with root package name */
        private String f4842d;

        /* renamed from: e  reason: collision with root package name */
        private String f4843e;

        /* renamed from: f  reason: collision with root package name */
        private String f4844f;

        /* renamed from: g  reason: collision with root package name */
        private String f4845g;

        /* renamed from: h  reason: collision with root package name */
        private String f4846h;

        /* renamed from: i  reason: collision with root package name */
        private int f4847i = 0;

        public T a(int i2) {
            this.f4847i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f4841c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f4842d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f4843e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f4844f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f4845g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f4846h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0160b extends a<C0160b> {
        private C0160b() {
        }

        @Override // com.meizu.cloud.pushsdk.d.c.a.AbstractC0159a
        /* renamed from: c */
        public C0160b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.b = ((a) aVar).b;
        this.f4834c = ((a) aVar).f4841c;
        this.a = ((a) aVar).a;
        this.f4835d = ((a) aVar).f4842d;
        this.f4836e = ((a) aVar).f4843e;
        this.f4837f = ((a) aVar).f4844f;
        this.f4838g = ((a) aVar).f4845g;
        this.f4839h = ((a) aVar).f4846h;
        this.f4840i = ((a) aVar).f4847i;
    }

    public static a<?> d() {
        return new C0160b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.a);
        cVar.a("ti", this.b);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f4834c);
        cVar.a("pv", this.f4835d);
        cVar.a("pn", this.f4836e);
        cVar.a("si", this.f4837f);
        cVar.a("ms", this.f4838g);
        cVar.a("ect", this.f4839h);
        cVar.a(BrightRemindSetting.BRIGHT_REMIND, Integer.valueOf(this.f4840i));
        return a(cVar);
    }
}
