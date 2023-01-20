package e.j.a.b.c.n.u;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.g;

/* loaded from: classes2.dex */
public final class x2<ResultT> extends a2 {
    private final w<a.b, ResultT> b;

    /* renamed from: c  reason: collision with root package name */
    private final e.j.a.b.j.l<ResultT> f10342c;

    /* renamed from: d  reason: collision with root package name */
    private final u f10343d;

    public x2(int i2, w<a.b, ResultT> wVar, e.j.a.b.j.l<ResultT> lVar, u uVar) {
        super(i2);
        this.f10342c = lVar;
        this.b = wVar;
        this.f10343d = uVar;
    }

    @Override // e.j.a.b.c.n.u.a1
    public final void b(@NonNull Status status) {
        this.f10342c.c(this.f10343d.getException(status));
    }

    @Override // e.j.a.b.c.n.u.a1
    public final void c(g.a<?> aVar) throws DeadObjectException {
        Status a;
        try {
            this.b.b(aVar.o(), this.f10342c);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            a = a1.a(e3);
            b(a);
        } catch (RuntimeException e4) {
            e(e4);
        }
    }

    @Override // e.j.a.b.c.n.u.a1
    public final void d(@NonNull b0 b0Var, boolean z) {
        b0Var.c(this.f10342c, z);
    }

    @Override // e.j.a.b.c.n.u.a1
    public final void e(@NonNull RuntimeException runtimeException) {
        this.f10342c.c(runtimeException);
    }

    @Override // e.j.a.b.c.n.u.a2
    @Nullable
    public final Feature[] g(g.a<?> aVar) {
        return this.b.d();
    }

    @Override // e.j.a.b.c.n.u.a2
    public final boolean h(g.a<?> aVar) {
        return this.b.c();
    }
}
