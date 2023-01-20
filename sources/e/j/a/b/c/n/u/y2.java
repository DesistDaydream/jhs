package e.j.a.b.c.n.u;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.u.g;
import e.j.a.b.c.n.u.l;

/* loaded from: classes2.dex */
public final class y2 extends u2<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    private final l.a<?> f10345c;

    public y2(l.a<?> aVar, e.j.a.b.j.l<Boolean> lVar) {
        super(4, lVar);
        this.f10345c = aVar;
    }

    @Override // e.j.a.b.c.n.u.u2, e.j.a.b.c.n.u.a1
    public final /* bridge */ /* synthetic */ void b(@NonNull Status status) {
        super.b(status);
    }

    @Override // e.j.a.b.c.n.u.u2, e.j.a.b.c.n.u.a1
    public final /* bridge */ /* synthetic */ void d(@NonNull b0 b0Var, boolean z) {
    }

    @Override // e.j.a.b.c.n.u.u2, e.j.a.b.c.n.u.a1
    public final /* bridge */ /* synthetic */ void e(@NonNull RuntimeException runtimeException) {
        super.e(runtimeException);
    }

    @Override // e.j.a.b.c.n.u.a2
    @Nullable
    public final Feature[] g(g.a<?> aVar) {
        w1 w1Var = aVar.x().get(this.f10345c);
        if (w1Var == null) {
            return null;
        }
        return w1Var.a.c();
    }

    @Override // e.j.a.b.c.n.u.a2
    public final boolean h(g.a<?> aVar) {
        w1 w1Var = aVar.x().get(this.f10345c);
        return w1Var != null && w1Var.a.e();
    }

    @Override // e.j.a.b.c.n.u.u2
    public final void i(g.a<?> aVar) throws RemoteException {
        w1 remove = aVar.x().remove(this.f10345c);
        if (remove != null) {
            remove.b.b(aVar.o(), this.b);
            remove.a.a();
            return;
        }
        this.b.d(Boolean.FALSE);
    }
}
