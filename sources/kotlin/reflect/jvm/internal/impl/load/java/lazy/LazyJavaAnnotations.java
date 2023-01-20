package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import h.k2.v.u;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.e.a.t.b;
import h.p2.b0.g.t.e.a.x.a;
import h.p2.b0.g.t.m.g;
import java.util.Iterator;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class LazyJavaAnnotations implements e {
    @d
    private final h.p2.b0.g.t.e.a.v.e a;
    @d
    private final h.p2.b0.g.t.e.a.x.d b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16502c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final g<a, c> f16503d;

    public LazyJavaAnnotations(@d h.p2.b0.g.t.e.a.v.e eVar, @d h.p2.b0.g.t.e.a.x.d dVar, boolean z) {
        this.a = eVar;
        this.b = dVar;
        this.f16502c = z;
        this.f16503d = eVar.a().u().g(new LazyJavaAnnotations$annotationDescriptors$1(this));
    }

    @Override // h.p2.b0.g.t.c.b1.e
    @k.e.a.e
    public c c(@d h.p2.b0.g.t.g.c cVar) {
        a c2 = this.b.c(cVar);
        c invoke = c2 == null ? null : this.f16503d.invoke(c2);
        return invoke == null ? b.a.a(cVar, this.b, this.a) : invoke;
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean isEmpty() {
        return this.b.getAnnotations().isEmpty() && !this.b.D();
    }

    @Override // java.lang.Iterable
    @d
    public Iterator<c> iterator() {
        return SequencesKt___SequencesKt.o0(SequencesKt___SequencesKt.g2(SequencesKt___SequencesKt.d1(CollectionsKt___CollectionsKt.n1(this.b.getAnnotations()), this.f16503d), b.a.a(g.a.y, this.b, this.a))).iterator();
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean n(@d h.p2.b0.g.t.g.c cVar) {
        return e.b.b(this, cVar);
    }

    public /* synthetic */ LazyJavaAnnotations(h.p2.b0.g.t.e.a.v.e eVar, h.p2.b0.g.t.e.a.x.d dVar, boolean z, int i2, u uVar) {
        this(eVar, dVar, (i2 & 4) != 0 ? false : z);
    }
}
