package e.j.a.b.c.n.u;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class o0 extends g1 {
    private final /* synthetic */ ConnectionResult b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ n0 f10299c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(n0 n0Var, e1 e1Var, ConnectionResult connectionResult) {
        super(e1Var);
        this.f10299c = n0Var;
        this.b = connectionResult;
    }

    @Override // e.j.a.b.c.n.u.g1
    @GuardedBy("mLock")
    public final void a() {
        this.f10299c.f10287c.A(this.b);
    }
}
