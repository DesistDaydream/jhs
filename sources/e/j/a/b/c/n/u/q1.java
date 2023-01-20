package e.j.a.b.c.n.u;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.a.d;
import e.j.a.b.c.n.u.d;

/* loaded from: classes2.dex */
public final class q1<O extends a.d> extends g0 {

    /* renamed from: f */
    private final e.j.a.b.c.n.h<O> f10316f;

    public q1(e.j.a.b.c.n.h<O> hVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f10316f = hVar;
    }

    @Override // e.j.a.b.c.n.i
    public final void G(n2 n2Var) {
    }

    @Override // e.j.a.b.c.n.i
    public final void H(n2 n2Var) {
    }

    @Override // e.j.a.b.c.n.i
    public final Context getContext() {
        return this.f10316f.o();
    }

    @Override // e.j.a.b.c.n.i
    public final <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T l(@NonNull T t) {
        return (T) this.f10316f.f(t);
    }

    @Override // e.j.a.b.c.n.i
    public final <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T m(@NonNull T t) {
        return (T) this.f10316f.k(t);
    }

    @Override // e.j.a.b.c.n.i
    public final Looper q() {
        return this.f10316f.q();
    }
}
