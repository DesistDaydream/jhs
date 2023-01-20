package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.e0;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.g.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class PackageFragmentProviderImpl implements e0 {
    @d
    private final Collection<b0> a;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(@d Collection<? extends b0> collection) {
        this.a = collection;
    }

    @Override // h.p2.b0.g.t.c.c0
    @d
    public List<b0> a(@d c cVar) {
        Collection<b0> collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (f0.g(((b0) obj).e(), cVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.p2.b0.g.t.c.e0
    public void b(@d c cVar, @d Collection<b0> collection) {
        for (Object obj : this.a) {
            if (f0.g(((b0) obj).e(), cVar)) {
                collection.add(obj);
            }
        }
    }

    @Override // h.p2.b0.g.t.c.e0
    public boolean c(@d c cVar) {
        Collection<b0> collection = this.a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        for (b0 b0Var : collection) {
            if (f0.g(b0Var.e(), cVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // h.p2.b0.g.t.c.c0
    @d
    public Collection<c> p(@d c cVar, @d l<? super f, Boolean> lVar) {
        return SequencesKt___SequencesKt.V2(SequencesKt___SequencesKt.i0(SequencesKt___SequencesKt.d1(CollectionsKt___CollectionsKt.n1(this.a), PackageFragmentProviderImpl$getSubPackagesOf$1.INSTANCE), new PackageFragmentProviderImpl$getSubPackagesOf$2(cVar)));
    }
}
