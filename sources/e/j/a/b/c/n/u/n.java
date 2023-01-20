package e.j.a.b.c.n.u;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.BasePendingResult;
import e.j.a.b.c.n.k;
import e.j.a.b.c.n.p;
import java.util.concurrent.TimeUnit;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class n<R extends e.j.a.b.c.n.p> extends e.j.a.b.c.n.j<R> {
    private final BasePendingResult<R> a;

    public n(e.j.a.b.c.n.k<R> kVar) {
        this.a = (BasePendingResult) kVar;
    }

    @Override // e.j.a.b.c.n.k
    public final void b(k.a aVar) {
        this.a.b(aVar);
    }

    @Override // e.j.a.b.c.n.k
    public final R c() {
        return this.a.c();
    }

    @Override // e.j.a.b.c.n.k
    public final R d(long j2, TimeUnit timeUnit) {
        return this.a.d(j2, timeUnit);
    }

    @Override // e.j.a.b.c.n.k
    public final void e() {
        this.a.e();
    }

    @Override // e.j.a.b.c.n.k
    public final boolean f() {
        return this.a.f();
    }

    @Override // e.j.a.b.c.n.k
    public final void g(e.j.a.b.c.n.q<? super R> qVar) {
        this.a.g(qVar);
    }

    @Override // e.j.a.b.c.n.k
    public final void h(e.j.a.b.c.n.q<? super R> qVar, long j2, TimeUnit timeUnit) {
        this.a.h(qVar, j2, timeUnit);
    }

    @Override // e.j.a.b.c.n.k
    @NonNull
    public final <S extends e.j.a.b.c.n.p> e.j.a.b.c.n.t<S> i(@NonNull e.j.a.b.c.n.s<? super R, ? extends S> sVar) {
        return this.a.i(sVar);
    }

    @Override // e.j.a.b.c.n.k
    public final Integer j() {
        return this.a.j();
    }

    @Override // e.j.a.b.c.n.j
    public final R k() {
        if (l()) {
            return d(0L, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    @Override // e.j.a.b.c.n.j
    public final boolean l() {
        return this.a.m();
    }
}
