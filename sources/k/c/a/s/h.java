package k.c.a.s;

/* loaded from: classes4.dex */
public class h implements g {
    public final Throwable a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private Object f16323c;

    public h(Throwable th) {
        this.a = th;
        this.b = false;
    }

    @Override // k.c.a.s.g
    public Object a() {
        return this.f16323c;
    }

    @Override // k.c.a.s.g
    public void b(Object obj) {
        this.f16323c = obj;
    }

    public Throwable c() {
        return this.a;
    }

    public boolean d() {
        return this.b;
    }

    public h(Throwable th, boolean z) {
        this.a = th;
        this.b = z;
    }
}
