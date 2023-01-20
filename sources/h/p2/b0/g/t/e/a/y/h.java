package h.p2.b0.g.t.e.a.y;

import h.k2.v.u;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public final class h {
    @k.e.a.e
    private final n a;
    @k.e.a.d
    private final List<n> b;

    public h() {
        this(null, null, 3, null);
    }

    public h(@k.e.a.e n nVar, @k.e.a.d List<n> list) {
        this.a = nVar;
        this.b = list;
    }

    @k.e.a.d
    public final List<n> a() {
        return this.b;
    }

    @k.e.a.e
    public final n b() {
        return this.a;
    }

    public /* synthetic */ h(n nVar, List list, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : nVar, (i2 & 2) != 0 ? CollectionsKt__CollectionsKt.E() : list);
    }
}
