package e.j.a.b.c.n.u;

import android.os.Bundle;
import e.j.a.b.c.n.i;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class y0 implements i.b {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ v b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ w0 f10344c;

    public y0(w0 w0Var, AtomicReference atomicReference, v vVar) {
        this.f10344c = w0Var;
        this.a = atomicReference;
        this.b = vVar;
    }

    @Override // e.j.a.b.c.n.i.b
    public final void a(Bundle bundle) {
        this.f10344c.L((e.j.a.b.c.n.i) this.a.get(), this.b, true);
    }

    @Override // e.j.a.b.c.n.i.b
    public final void onConnectionSuspended(int i2) {
    }
}
