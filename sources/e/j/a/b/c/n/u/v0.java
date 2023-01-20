package e.j.a.b.c.n.u;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class v0 implements e1 {
    private final f1 a;

    public v0(f1 f1Var) {
        this.a = f1Var;
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void a(Bundle bundle) {
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void b(ConnectionResult connectionResult, e.j.a.b.c.n.a<?> aVar, boolean z) {
    }

    @Override // e.j.a.b.c.n.u.e1
    public final <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T c(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void connect() {
        this.a.n();
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void d() {
        for (a.f fVar : this.a.f10215f.values()) {
            fVar.disconnect();
        }
        this.a.n.t = Collections.emptySet();
    }

    @Override // e.j.a.b.c.n.u.e1
    public final boolean disconnect() {
        return true;
    }

    @Override // e.j.a.b.c.n.u.e1
    public final <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T e(T t) {
        this.a.n.f10338l.add(t);
        return t;
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void onConnectionSuspended(int i2) {
    }
}
