package e.j.a.b.c.n.u;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.CancellationException;

/* loaded from: classes2.dex */
public class u1 extends c3 {

    /* renamed from: f  reason: collision with root package name */
    private e.j.a.b.j.l<Void> f10327f;

    private u1(k kVar) {
        super(kVar);
        this.f10327f = new e.j.a.b.j.l<>();
        this.a.a("GmsAvailabilityHelper", this);
    }

    public static u1 r(Activity activity) {
        k b = LifecycleCallback.b(activity);
        u1 u1Var = (u1) b.e("GmsAvailabilityHelper", u1.class);
        if (u1Var != null) {
            if (u1Var.f10327f.a().u()) {
                u1Var.f10327f = new e.j.a.b.j.l<>();
            }
            return u1Var;
        }
        return new u1(b);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void g() {
        super.g();
        this.f10327f.c(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    @Override // e.j.a.b.c.n.u.c3
    public final void m(ConnectionResult connectionResult, int i2) {
        this.f10327f.b(e.j.a.b.c.r.c.a(new Status(connectionResult.getErrorCode(), connectionResult.getErrorMessage(), connectionResult.getResolution())));
    }

    @Override // e.j.a.b.c.n.u.c3
    public final void o() {
        int j2 = this.f10209e.j(this.a.n());
        if (j2 == 0) {
            this.f10327f.setResult(null);
        } else if (this.f10327f.a().u()) {
        } else {
            n(new ConnectionResult(j2, null), 0);
        }
    }

    public final e.j.a.b.j.k<Void> q() {
        return this.f10327f.a();
    }
}
