package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;

/* loaded from: classes.dex */
public class j implements f {

    /* renamed from: j  reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a f1136j;

    /* renamed from: k  reason: collision with root package name */
    private static j f1137k;
    private volatile Context a;
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a b;

    /* renamed from: c  reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1138c;

    /* renamed from: d  reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1139d;

    /* renamed from: e  reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1140e;

    /* renamed from: f  reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e f1141f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f1142g;

    /* renamed from: h  reason: collision with root package name */
    private volatile g f1143h;

    /* renamed from: i  reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c f1144i;

    private j() {
    }

    public static j l() {
        j jVar;
        synchronized (j.class) {
            if (f1137k == null) {
                f1137k = new j();
            }
            jVar = f1137k;
        }
        return jVar;
    }

    public static bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a m() {
        if (f1136j == null) {
            synchronized (j.class) {
                if (f1136j == null) {
                    f1136j = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b();
                }
            }
        }
        return f1136j;
    }

    public void a() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.b();
    }

    public void a(Context context) {
        this.a = context;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e eVar) {
        this.f1141f = eVar;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c cVar) {
        this.f1144i = cVar;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.c(System.currentTimeMillis());
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.a(aVar, aVar.b());
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        this.f1139d = aVar;
    }

    public void a(g gVar) {
        this.f1143h = gVar;
    }

    public void a(boolean z) {
        this.f1142g = z;
    }

    public g b() {
        return this.f1143h;
    }

    public void b(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        this.b = aVar;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a c() {
        return this.f1139d;
    }

    public void c(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        this.f1138c = aVar;
    }

    public Context d() {
        return this.a;
    }

    public void d(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        this.f1140e = aVar;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e e() {
        return this.f1141f;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f() {
        return this.b;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a g() {
        return this.f1138c;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a h() {
        return this.f1140e;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c i() {
        return this.f1144i;
    }

    public boolean j() {
        return this.f1142g;
    }

    public void k() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.d();
    }
}
