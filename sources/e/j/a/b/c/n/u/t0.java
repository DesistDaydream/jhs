package e.j.a.b.c.n.u;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.i;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public final class t0 implements i.b, i.c {
    private final /* synthetic */ k0 a;

    private t0(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // e.j.a.b.c.n.i.b
    public final void a(Bundle bundle) {
        e.j.a.b.c.r.f fVar;
        e.j.a.b.h.f fVar2;
        Lock lock;
        Lock lock2;
        e.j.a.b.h.f fVar3;
        e.j.a.b.h.f fVar4;
        fVar = this.a.r;
        if (fVar.o()) {
            lock = this.a.b;
            lock.lock();
            try {
                fVar3 = this.a.f10281k;
                if (fVar3 == null) {
                    return;
                }
                fVar4 = this.a.f10281k;
                fVar4.t(new r0(this.a));
                return;
            } finally {
                lock2 = this.a.b;
                lock2.unlock();
            }
        }
        fVar2 = this.a.f10281k;
        fVar2.t(new r0(this.a));
    }

    @Override // e.j.a.b.c.n.i.c
    public final void c(@NonNull ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        boolean z;
        lock = this.a.b;
        lock.lock();
        try {
            z = this.a.z(connectionResult);
            if (z) {
                this.a.o();
                this.a.m();
            } else {
                this.a.A(connectionResult);
            }
        } finally {
            lock2 = this.a.b;
            lock2.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i.b
    public final void onConnectionSuspended(int i2) {
    }

    public /* synthetic */ t0(k0 k0Var, l0 l0Var) {
        this(k0Var);
    }
}
