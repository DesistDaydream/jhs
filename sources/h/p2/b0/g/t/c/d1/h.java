package h.p2.b0.g.t.c.d1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class h implements h.p2.b0.g.t.c.e0 {
    @k.e.a.d
    private final List<h.p2.b0.g.t.c.c0> a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@k.e.a.d List<? extends h.p2.b0.g.t.c.c0> list) {
        this.a = list;
        list.size();
        CollectionsKt___CollectionsKt.N5(list).size();
    }

    @Override // h.p2.b0.g.t.c.c0
    @k.e.a.d
    public List<h.p2.b0.g.t.c.b0> a(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (h.p2.b0.g.t.c.c0 c0Var : this.a) {
            h.p2.b0.g.t.c.d0.a(c0Var, cVar, arrayList);
        }
        return CollectionsKt___CollectionsKt.I5(arrayList);
    }

    @Override // h.p2.b0.g.t.c.e0
    public void b(@k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d Collection<h.p2.b0.g.t.c.b0> collection) {
        for (h.p2.b0.g.t.c.c0 c0Var : this.a) {
            h.p2.b0.g.t.c.d0.a(c0Var, cVar, collection);
        }
    }

    @Override // h.p2.b0.g.t.c.e0
    public boolean c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        List<h.p2.b0.g.t.c.c0> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (h.p2.b0.g.t.c.c0 c0Var : list) {
            if (!h.p2.b0.g.t.c.d0.b(c0Var, cVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // h.p2.b0.g.t.c.c0
    @k.e.a.d
    public Collection<h.p2.b0.g.t.g.c> p(@k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        HashSet hashSet = new HashSet();
        for (h.p2.b0.g.t.c.c0 c0Var : this.a) {
            hashSet.addAll(c0Var.p(cVar, lVar));
        }
        return hashSet;
    }
}
