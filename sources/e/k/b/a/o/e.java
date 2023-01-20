package e.k.b.a.o;

import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public final class e<TResult> implements e.k.b.a.f, e.k.b.a.h, e.k.b.a.i<TResult> {
    private final Object a = new Object();
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final i<Void> f11799c;

    /* renamed from: d  reason: collision with root package name */
    private int f11800d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f11801e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11802f;

    public e(int i2, i<Void> iVar) {
        this.b = i2;
        this.f11799c = iVar;
    }

    private void b() {
        if (this.f11800d >= this.b) {
            if (this.f11801e != null) {
                this.f11799c.z(new ExecutionException("a task failed", this.f11801e));
            } else if (this.f11802f) {
                this.f11799c.B();
            } else {
                this.f11799c.A(null);
            }
        }
    }

    @Override // e.k.b.a.f
    public final void a() {
        synchronized (this.a) {
            this.f11800d++;
            this.f11802f = true;
            b();
        }
    }

    @Override // e.k.b.a.h
    public final void onFailure(Exception exc) {
        synchronized (this.a) {
            this.f11800d++;
            this.f11801e = exc;
            b();
        }
    }

    @Override // e.k.b.a.i
    public final void onSuccess(TResult tresult) {
        synchronized (this.a) {
            this.f11800d++;
            b();
        }
    }
}
