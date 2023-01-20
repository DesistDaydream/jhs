package e.l.q.a.k0;

import android.view.View;

/* loaded from: classes2.dex */
public abstract class k {
    @k.e.a.d
    private View a;
    private long b = 200;

    public k(@k.e.a.d View view) {
        this.a = view;
    }

    public abstract void a();

    public abstract void b();

    public final long c() {
        return this.b;
    }

    @k.e.a.d
    public final View d() {
        return this.a;
    }

    public abstract void e();

    public final void f(long j2) {
        this.b = j2;
    }

    public final void g(long j2) {
        this.b = j2;
    }

    public final void h(@k.e.a.d View view) {
        this.a = view;
    }
}
