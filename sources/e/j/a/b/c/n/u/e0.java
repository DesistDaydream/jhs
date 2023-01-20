package e.j.a.b.c.n.u;

import android.app.Activity;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* loaded from: classes2.dex */
public class e0 extends c3 {

    /* renamed from: f */
    private final ArraySet<z2<?>> f10210f;

    /* renamed from: g */
    private g f10211g;

    private e0(k kVar) {
        super(kVar);
        this.f10210f = new ArraySet<>();
        this.a.a("ConnectionlessLifecycleHelper", this);
    }

    public static void q(Activity activity, g gVar, z2<?> z2Var) {
        k b = LifecycleCallback.b(activity);
        e0 e0Var = (e0) b.e("ConnectionlessLifecycleHelper", e0.class);
        if (e0Var == null) {
            e0Var = new e0(b);
        }
        e0Var.f10211g = gVar;
        e.j.a.b.c.r.a0.l(z2Var, "ApiKey cannot be null");
        e0Var.f10210f.add(z2Var);
        gVar.l(e0Var);
    }

    private final void s() {
        if (this.f10210f.isEmpty()) {
            return;
        }
        this.f10211g.l(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void h() {
        super.h();
        s();
    }

    @Override // e.j.a.b.c.n.u.c3, com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        s();
    }

    @Override // e.j.a.b.c.n.u.c3, com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.f10211g.p(this);
    }

    @Override // e.j.a.b.c.n.u.c3
    public final void m(ConnectionResult connectionResult, int i2) {
        this.f10211g.h(connectionResult, i2);
    }

    @Override // e.j.a.b.c.n.u.c3
    public final void o() {
        this.f10211g.E();
    }

    public final ArraySet<z2<?>> r() {
        return this.f10210f;
    }
}
