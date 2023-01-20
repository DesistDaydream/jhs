package e.j.a.b.c.n.u;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public final class l3 implements t1 {
    private final /* synthetic */ j3 a;

    private l3(j3 j3Var) {
        this.a = j3Var;
    }

    @Override // e.j.a.b.c.n.u.t1
    public final void a(@Nullable Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.a.f10272m;
        lock.lock();
        try {
            this.a.n(bundle);
            this.a.f10269j = ConnectionResult.RESULT_SUCCESS;
            this.a.B();
        } finally {
            lock2 = this.a.f10272m;
            lock2.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.t1
    public final void b(@NonNull ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.a.f10272m;
        lock.lock();
        try {
            this.a.f10269j = connectionResult;
            this.a.B();
        } finally {
            lock2 = this.a.f10272m;
            lock2.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.t1
    public final void c(int i2, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        f1 f1Var;
        lock = this.a.f10272m;
        lock.lock();
        try {
            z2 = this.a.f10271l;
            if (!z2) {
                connectionResult = this.a.f10270k;
                if (connectionResult != null) {
                    connectionResult2 = this.a.f10270k;
                    if (connectionResult2.isSuccess()) {
                        this.a.f10271l = true;
                        f1Var = this.a.f10264e;
                        f1Var.onConnectionSuspended(i2);
                        return;
                    }
                }
            }
            this.a.f10271l = false;
            this.a.m(i2, z);
        } finally {
            lock2 = this.a.f10272m;
            lock2.unlock();
        }
    }

    public /* synthetic */ l3(j3 j3Var, k3 k3Var) {
        this(j3Var);
    }
}
