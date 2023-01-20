package h.p2.b0.g.t.c.b1;

import h.k2.u.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class h implements e {
    @k.e.a.d
    private final e a;
    private final boolean b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final l<h.p2.b0.g.t.g.c, Boolean> f15084c;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@k.e.a.d e eVar, boolean z, @k.e.a.d l<? super h.p2.b0.g.t.g.c, Boolean> lVar) {
        this.a = eVar;
        this.b = z;
        this.f15084c = lVar;
    }

    private final boolean a(c cVar) {
        h.p2.b0.g.t.g.c e2 = cVar.e();
        return e2 != null && this.f15084c.invoke(e2).booleanValue();
    }

    @Override // h.p2.b0.g.t.c.b1.e
    @k.e.a.e
    public c c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        if (this.f15084c.invoke(cVar).booleanValue()) {
            return this.a.c(cVar);
        }
        return null;
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean isEmpty() {
        boolean z;
        e<c> eVar = this.a;
        if (!(eVar instanceof Collection) || !((Collection) eVar).isEmpty()) {
            for (c cVar : eVar) {
                if (a(cVar)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return this.b ? !z : z;
    }

    @Override // java.lang.Iterable
    @k.e.a.d
    public Iterator<c> iterator() {
        e eVar = this.a;
        ArrayList arrayList = new ArrayList();
        for (c cVar : eVar) {
            if (a(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean n(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        if (this.f15084c.invoke(cVar).booleanValue()) {
            return this.a.n(cVar);
        }
        return false;
    }

    public h(@k.e.a.d e eVar, @k.e.a.d l<? super h.p2.b0.g.t.g.c, Boolean> lVar) {
        this(eVar, false, lVar);
    }
}
