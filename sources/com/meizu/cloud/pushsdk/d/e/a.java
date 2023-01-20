package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public abstract class a {
    private static final String n = "a";
    public com.meizu.cloud.pushsdk.d.b.a b;

    /* renamed from: c  reason: collision with root package name */
    public c f4854c;

    /* renamed from: d  reason: collision with root package name */
    public b f4855d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4856e;

    /* renamed from: f  reason: collision with root package name */
    public final String f4857f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4858g;

    /* renamed from: h  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.d.f.b f4859h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f4860i;

    /* renamed from: j  reason: collision with root package name */
    public final long f4861j;

    /* renamed from: k  reason: collision with root package name */
    public final int f4862k;

    /* renamed from: l  reason: collision with root package name */
    public final TimeUnit f4863l;
    public final String a = PushManager.TAG;

    /* renamed from: m  reason: collision with root package name */
    public final AtomicBoolean f4864m = new AtomicBoolean(true);

    /* renamed from: com.meizu.cloud.pushsdk.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0161a {
        public final com.meizu.cloud.pushsdk.d.b.a a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4865c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f4866d;

        /* renamed from: e  reason: collision with root package name */
        public c f4867e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4868f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.d.f.b f4869g = com.meizu.cloud.pushsdk.d.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f4870h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f4871i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f4872j = 300;

        /* renamed from: k  reason: collision with root package name */
        public long f4873k = 15;

        /* renamed from: l  reason: collision with root package name */
        public int f4874l = 10;

        /* renamed from: m  reason: collision with root package name */
        public TimeUnit f4875m = TimeUnit.SECONDS;

        public C0161a(com.meizu.cloud.pushsdk.d.b.a aVar, String str, String str2, Context context, Class<? extends a> cls) {
            this.a = aVar;
            this.b = str;
            this.f4865c = str2;
            this.f4866d = context;
        }

        public C0161a a(int i2) {
            this.f4874l = i2;
            return this;
        }

        public C0161a a(c cVar) {
            this.f4867e = cVar;
            return this;
        }

        public C0161a a(com.meizu.cloud.pushsdk.d.f.b bVar) {
            this.f4869g = bVar;
            return this;
        }

        public C0161a a(Boolean bool) {
            this.f4868f = bool.booleanValue();
            return this;
        }
    }

    public a(C0161a c0161a) {
        this.b = c0161a.a;
        this.f4857f = c0161a.f4865c;
        this.f4858g = c0161a.f4868f;
        this.f4856e = c0161a.b;
        this.f4854c = c0161a.f4867e;
        this.f4859h = c0161a.f4869g;
        boolean z = c0161a.f4870h;
        this.f4860i = z;
        this.f4861j = c0161a.f4873k;
        int i2 = c0161a.f4874l;
        this.f4862k = i2 < 2 ? 2 : i2;
        this.f4863l = c0161a.f4875m;
        if (z) {
            this.f4855d = new b(c0161a.f4871i, c0161a.f4872j, c0161a.f4875m, c0161a.f4866d);
        }
        com.meizu.cloud.pushsdk.d.f.c.a(c0161a.f4869g);
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.d.a.b a(List<com.meizu.cloud.pushsdk.d.a.b> list) {
        if (this.f4860i) {
            list.add(this.f4855d.a());
        }
        c cVar = this.f4854c;
        if (cVar != null) {
            if (!cVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b("geolocation", this.f4854c.a()));
            }
            if (!this.f4854c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b("mobileinfo", this.f4854c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.d.a.b bVar : list) {
            linkedList.add(bVar.a());
        }
        return new com.meizu.cloud.pushsdk.d.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.d.a.c cVar, List<com.meizu.cloud.pushsdk.d.a.b> list, boolean z) {
        if (this.f4854c != null) {
            cVar.a(new HashMap(this.f4854c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.b.a(cVar, z);
    }

    public void a() {
        if (this.f4864m.get()) {
            b().a();
        }
    }

    public void a(com.meizu.cloud.pushsdk.d.c.b bVar, boolean z) {
        if (this.f4864m.get()) {
            a(bVar.e(), bVar.a(), z);
        }
    }

    public void a(c cVar) {
        this.f4854c = cVar;
    }

    public com.meizu.cloud.pushsdk.d.b.a b() {
        return this.b;
    }
}
