package h.p2.b0.g.t.c.f1.b;

import h.k2.v.f0;
import h.p2.b0.g.t.e.a.x.b0;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public final class x extends u implements b0 {
    @k.e.a.d
    private final WildcardType b;
    @k.e.a.d

    /* renamed from: c */
    private final Collection<h.p2.b0.g.t.e.a.x.a> f15206c = CollectionsKt__CollectionsKt.E();

    /* renamed from: d */
    private final boolean f15207d;

    public x(@k.e.a.d WildcardType wildcardType) {
        this.b = wildcardType;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    public boolean D() {
        return this.f15207d;
    }

    @Override // h.p2.b0.g.t.e.a.x.b0
    public boolean M() {
        return !f0.g(ArraysKt___ArraysKt.Kb(R().getUpperBounds()), Object.class);
    }

    @Override // h.p2.b0.g.t.e.a.x.b0
    @k.e.a.e
    /* renamed from: S */
    public u x() {
        Type[] upperBounds = R().getUpperBounds();
        Type[] lowerBounds = R().getLowerBounds();
        if (upperBounds.length <= 1 && lowerBounds.length <= 1) {
            if (lowerBounds.length == 1) {
                return u.a.a((Type) ArraysKt___ArraysKt.Cs(lowerBounds));
            }
            if (upperBounds.length == 1) {
                Type type = (Type) ArraysKt___ArraysKt.Cs(upperBounds);
                if (f0.g(type, Object.class)) {
                    return null;
                }
                return u.a.a(type);
            }
            return null;
        }
        throw new UnsupportedOperationException(f0.C("Wildcard types with many bounds are not yet supported: ", R()));
    }

    @Override // h.p2.b0.g.t.c.f1.b.u
    @k.e.a.d
    /* renamed from: T */
    public WildcardType R() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.e.a.x.a> getAnnotations() {
        return this.f15206c;
    }
}
