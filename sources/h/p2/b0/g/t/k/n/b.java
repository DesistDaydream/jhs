package h.p2.b0.g.t.k.n;

import h.p2.b0.g.t.c.z;
import java.util.List;

/* loaded from: classes3.dex */
public final class b extends g<List<? extends g<?>>> {
    @k.e.a.d
    private final h.k2.u.l<z, h.p2.b0.g.t.n.z> b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@k.e.a.d List<? extends g<?>> list, @k.e.a.d h.k2.u.l<? super z, ? extends h.p2.b0.g.t.n.z> lVar) {
        super(list);
        this.b = lVar;
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public h.p2.b0.g.t.n.z getType(@k.e.a.d z zVar) {
        h.p2.b0.g.t.n.z invoke = this.b.invoke(zVar);
        if (!h.p2.b0.g.t.b.f.b0(invoke) && !h.p2.b0.g.t.b.f.n0(invoke)) {
            h.p2.b0.g.t.b.f.A0(invoke);
        }
        return invoke;
    }
}
