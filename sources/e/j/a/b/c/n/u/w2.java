package e.j.a.b.c.n.u;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.g;

/* loaded from: classes2.dex */
public final class w2 extends u2<Void> {

    /* renamed from: c  reason: collision with root package name */
    private final p<a.b, ?> f10340c;

    /* renamed from: d  reason: collision with root package name */
    private final y<a.b, ?> f10341d;

    public w2(w1 w1Var, e.j.a.b.j.l<Void> lVar) {
        super(3, lVar);
        this.f10340c = w1Var.a;
        this.f10341d = w1Var.b;
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
        return this.f10340c.c();
    }

    @Override // e.j.a.b.c.n.u.a2
    public final boolean h(g.a<?> aVar) {
        return this.f10340c.e();
    }

    @Override // e.j.a.b.c.n.u.u2
    public final void i(g.a<?> aVar) throws RemoteException {
        this.f10340c.d(aVar.o(), this.b);
        if (this.f10340c.b() != null) {
            aVar.x().put(this.f10340c.b(), new w1(this.f10340c, this.f10341d));
        }
    }
}
