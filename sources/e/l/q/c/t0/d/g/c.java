package e.l.q.c.t0.d.g;

import android.content.Context;
import android.widget.Scroller;

/* loaded from: classes2.dex */
public class c extends d {
    private final Scroller a;

    public c(Context context) {
        this.a = new Scroller(context);
    }

    @Override // e.l.q.c.t0.d.g.d
    public boolean a() {
        return this.a.computeScrollOffset();
    }

    @Override // e.l.q.c.t0.d.g.d
    public void b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.a.fling(i2, i3, i4, i5, i6, i7, i8, i9);
    }

    @Override // e.l.q.c.t0.d.g.d
    public void c(boolean z) {
        this.a.forceFinished(z);
    }

    @Override // e.l.q.c.t0.d.g.d
    public int d() {
        return this.a.getCurrX();
    }

    @Override // e.l.q.c.t0.d.g.d
    public int e() {
        return this.a.getCurrY();
    }

    @Override // e.l.q.c.t0.d.g.d
    public boolean g() {
        return this.a.isFinished();
    }
}
