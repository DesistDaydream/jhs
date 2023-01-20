package e.j.a.b.c.n.u;

import com.google.android.gms.common.data.DataHolder;
import e.j.a.b.c.n.u.l;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class e<L> implements l.b<L> {
    private final DataHolder a;

    @e.j.a.b.c.m.a
    public e(DataHolder dataHolder) {
        this.a = dataHolder;
    }

    @Override // e.j.a.b.c.n.u.l.b
    @e.j.a.b.c.m.a
    public final void a(L l2) {
        c(l2, this.a);
    }

    @Override // e.j.a.b.c.n.u.l.b
    @e.j.a.b.c.m.a
    public void b() {
        DataHolder dataHolder = this.a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @e.j.a.b.c.m.a
    public abstract void c(L l2, DataHolder dataHolder);
}
