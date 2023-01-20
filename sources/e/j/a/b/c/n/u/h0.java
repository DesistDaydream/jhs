package e.j.a.b.c.n.u;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;

/* loaded from: classes2.dex */
public final class h0 implements e1 {
    private final f1 a;
    private boolean b = false;

    public h0(f1 f1Var) {
        this.a = f1Var;
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void a(Bundle bundle) {
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void b(ConnectionResult connectionResult, e.j.a.b.c.n.a<?> aVar, boolean z) {
    }

    @Override // e.j.a.b.c.n.u.e1
    public final <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T c(T t) {
        try {
            this.a.n.B.b(t);
            w0 w0Var = this.a.n;
            a.f fVar = w0Var.s.get(t.x());
            e.j.a.b.c.r.a0.l(fVar, "Appropriate Api was not requested.");
            if (!fVar.isConnected() && this.a.f10216g.containsKey(t.x())) {
                t.a(new Status(17));
            } else {
                boolean z = fVar instanceof e.j.a.b.c.r.e0;
                a.h hVar = fVar;
                if (z) {
                    hVar = ((e.j.a.b.c.r.e0) fVar).o0();
                }
                t.z(hVar);
            }
        } catch (DeadObjectException unused) {
            this.a.m(new i0(this, this));
        }
        return t;
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void connect() {
        if (this.b) {
            this.b = false;
            this.a.m(new j0(this, this));
        }
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void d() {
    }

    @Override // e.j.a.b.c.n.u.e1
    public final boolean disconnect() {
        if (this.b) {
            return false;
        }
        if (this.a.n.R()) {
            this.b = true;
            for (n2 n2Var : this.a.n.A) {
                n2Var.i();
            }
            return false;
        }
        this.a.r(null);
        return true;
    }

    @Override // e.j.a.b.c.n.u.e1
    public final <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T e(T t) {
        return (T) c(t);
    }

    public final void g() {
        if (this.b) {
            this.b = false;
            this.a.n.B.a();
            disconnect();
        }
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void onConnectionSuspended(int i2) {
        this.a.r(null);
        this.a.o.c(i2, this.b);
    }
}
