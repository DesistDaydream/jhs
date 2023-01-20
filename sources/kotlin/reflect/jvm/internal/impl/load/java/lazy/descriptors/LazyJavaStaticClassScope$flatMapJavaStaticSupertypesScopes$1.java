package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.n.z;
import h.p2.b0.g.t.p.b;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<N> implements b.d<d> {
    public static final LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<N> a = new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<>();

    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements l<z, d> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        @e
        public final d invoke(z zVar) {
            f c2 = zVar.I0().c();
            if (c2 instanceof d) {
                return (d) c2;
            }
            return null;
        }
    }

    @Override // h.p2.b0.g.t.p.b.d
    @k.e.a.d
    /* renamed from: b */
    public final Iterable<d> a(d dVar) {
        return SequencesKt___SequencesKt.G(SequencesKt___SequencesKt.i1(CollectionsKt___CollectionsKt.n1(dVar.j().j()), AnonymousClass1.INSTANCE));
    }
}
