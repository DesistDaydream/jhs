package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.b1.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class CompositeAnnotations implements e {
    @d
    private final List<e> a;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(@d List<? extends e> list) {
        this.a = list;
    }

    @Override // h.p2.b0.g.t.c.b1.e
    @k.e.a.e
    public c c(@d h.p2.b0.g.t.g.c cVar) {
        return (c) SequencesKt___SequencesKt.y0(SequencesKt___SequencesKt.i1(CollectionsKt___CollectionsKt.n1(this.a), new CompositeAnnotations$findAnnotation$1(cVar)));
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean isEmpty() {
        List<e> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (e eVar : list) {
            if (!eVar.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    @d
    public Iterator<c> iterator() {
        return SequencesKt___SequencesKt.A0(CollectionsKt___CollectionsKt.n1(this.a), CompositeAnnotations$iterator$1.INSTANCE).iterator();
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean n(@d h.p2.b0.g.t.g.c cVar) {
        for (e eVar : CollectionsKt___CollectionsKt.n1(this.a)) {
            if (eVar.n(cVar)) {
                return true;
            }
        }
        return false;
    }

    public CompositeAnnotations(@d e... eVarArr) {
        this(ArraysKt___ArraysKt.ey(eVarArr));
    }
}
