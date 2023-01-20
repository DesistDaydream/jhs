package e.j.a.b.c.n.u;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.r.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public final class m0 implements e.c {
    private final WeakReference<k0> a;
    private final e.j.a.b.c.n.a<?> b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10286c;

    public m0(k0 k0Var, e.j.a.b.c.n.a<?> aVar, boolean z) {
        this.a = new WeakReference<>(k0Var);
        this.b = aVar;
        this.f10286c = z;
    }

    @Override // e.j.a.b.c.r.e.c
    public final void a(@NonNull ConnectionResult connectionResult) {
        f1 f1Var;
        Lock lock;
        Lock lock2;
        boolean w;
        boolean l2;
        k0 k0Var = this.a.get();
        if (k0Var == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        f1Var = k0Var.a;
        e.j.a.b.c.r.a0.r(myLooper == f1Var.n.q(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = k0Var.b;
        lock.lock();
        try {
            w = k0Var.w(0);
            if (w) {
                if (!connectionResult.isSuccess()) {
                    k0Var.s(connectionResult, this.b, this.f10286c);
                }
                l2 = k0Var.l();
                if (l2) {
                    k0Var.m();
                }
            }
        } finally {
            lock2 = k0Var.b;
            lock2.unlock();
        }
    }
}
