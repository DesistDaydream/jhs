package h.p2.b0.g.t.e.a.y;

import h.p2.b0.g.t.e.a.p;
import h.p2.b0.g.t.n.e1.q;
import h.p2.b0.g.t.n.z;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;

/* loaded from: classes3.dex */
public final class o {
    @k.e.a.d
    private static final b a = new b(p.q);
    @k.e.a.d
    private static final b b = new b(p.r);

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[MutabilityQualifier.values().length];
            iArr[MutabilityQualifier.READ_ONLY.ordinal()] = 1;
            iArr[MutabilityQualifier.MUTABLE.ordinal()] = 2;
            a = iArr;
            int[] iArr2 = new int[NullabilityQualifier.values().length];
            iArr2[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            iArr2[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h.p2.b0.g.t.c.b1.e d(List<? extends h.p2.b0.g.t.c.b1.e> list) {
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                return new CompositeAnnotations(CollectionsKt___CollectionsKt.I5(list));
            }
            return (h.p2.b0.g.t.c.b1.e) CollectionsKt___CollectionsKt.U4(list);
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c<h.p2.b0.g.t.c.f> e(h.p2.b0.g.t.c.f fVar, e eVar, TypeComponentPosition typeComponentPosition) {
        if (l.a(typeComponentPosition) && (fVar instanceof h.p2.b0.g.t.c.d)) {
            h.p2.b0.g.t.b.k.d dVar = h.p2.b0.g.t.b.k.d.a;
            MutabilityQualifier b2 = eVar.b();
            int i2 = b2 == null ? -1 : a.a[b2.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                    h.p2.b0.g.t.c.d dVar2 = (h.p2.b0.g.t.c.d) fVar;
                    if (dVar.e(dVar2)) {
                        return f(dVar.b(dVar2));
                    }
                }
            } else if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
                h.p2.b0.g.t.c.d dVar3 = (h.p2.b0.g.t.c.d) fVar;
                if (dVar.c(dVar3)) {
                    return f(dVar.a(dVar3));
                }
            }
            return j(fVar);
        }
        return j(fVar);
    }

    private static final <T> c<T> f(T t) {
        return new c<>(t, b);
    }

    private static final <T> c<T> g(T t) {
        return new c<>(t, a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c<Boolean> h(z zVar, e eVar, TypeComponentPosition typeComponentPosition) {
        if (l.a(typeComponentPosition)) {
            NullabilityQualifier c2 = eVar.c();
            int i2 = c2 == null ? -1 : a.b[c2.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return j(Boolean.valueOf(zVar.J0()));
                }
                return g(Boolean.FALSE);
            }
            return g(Boolean.TRUE);
        }
        return j(Boolean.valueOf(zVar.J0()));
    }

    public static final boolean i(@k.e.a.d z zVar) {
        return m.b(q.a, zVar);
    }

    private static final <T> c<T> j(T t) {
        return new c<>(t, null);
    }
}
