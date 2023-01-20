package e.j.a.b.c.n.u;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.i;

/* loaded from: classes2.dex */
public final class h3 implements i.b, i.c {
    public final e.j.a.b.c.n.a<?> a;
    private final boolean b;

    /* renamed from: c */
    private i3 f10261c;

    public h3(e.j.a.b.c.n.a<?> aVar, boolean z) {
        this.a = aVar;
        this.b = z;
    }

    private final void e() {
        e.j.a.b.c.r.a0.l(this.f10261c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    @Override // e.j.a.b.c.n.i.b
    public final void a(@Nullable Bundle bundle) {
        e();
        this.f10261c.a(bundle);
    }

    @Override // e.j.a.b.c.n.i.c
    public final void c(@NonNull ConnectionResult connectionResult) {
        e();
        this.f10261c.b(connectionResult, this.a, this.b);
    }

    public final void d(i3 i3Var) {
        this.f10261c = i3Var;
    }

    @Override // e.j.a.b.c.n.i.b
    public final void onConnectionSuspended(int i2) {
        e();
        this.f10261c.onConnectionSuspended(i2);
    }
}
