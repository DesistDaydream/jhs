package e.j.a.b.c.n.u;

import androidx.annotation.BinderThread;
import com.google.android.gms.signin.internal.zaj;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class r0 extends e.j.a.b.h.b.c {
    private final WeakReference<k0> b;

    public r0(k0 k0Var) {
        this.b = new WeakReference<>(k0Var);
    }

    @Override // e.j.a.b.h.b.c, e.j.a.b.h.b.d
    @BinderThread
    public final void e(zaj zajVar) {
        f1 f1Var;
        k0 k0Var = this.b.get();
        if (k0Var == null) {
            return;
        }
        f1Var = k0Var.a;
        f1Var.m(new s0(this, k0Var, k0Var, zajVar));
    }
}
