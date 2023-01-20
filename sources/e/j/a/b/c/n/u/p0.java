package e.j.a.b.c.n.u;

import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.r.e;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class p0 extends g1 {
    private final /* synthetic */ e.c b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(n0 n0Var, e1 e1Var, e.c cVar) {
        super(e1Var);
        this.b = cVar;
    }

    @Override // e.j.a.b.c.n.u.g1
    @GuardedBy("mLock")
    public final void a() {
        this.b.a(new ConnectionResult(16, null));
    }
}
