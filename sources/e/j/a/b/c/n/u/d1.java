package e.j.a.b.c.n.u;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class d1 extends r1 {
    private WeakReference<w0> a;

    public d1(w0 w0Var) {
        this.a = new WeakReference<>(w0Var);
    }

    @Override // e.j.a.b.c.n.u.r1
    public final void a() {
        w0 w0Var = this.a.get();
        if (w0Var == null) {
            return;
        }
        w0Var.J();
    }
}
