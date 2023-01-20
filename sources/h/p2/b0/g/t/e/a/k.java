package h.p2.b0.g.t.e.a;

import h.k2.v.f0;
import h.k2.v.u;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: classes3.dex */
public final class k {
    @k.e.a.d
    private final h.p2.b0.g.t.e.a.y.g a;
    @k.e.a.d
    private final Collection<AnnotationQualifierApplicabilityType> b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15240c;

    /* JADX WARN: Multi-variable type inference failed */
    public k(@k.e.a.d h.p2.b0.g.t.e.a.y.g gVar, @k.e.a.d Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z) {
        this.a = gVar;
        this.b = collection;
        this.f15240c = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ k b(k kVar, h.p2.b0.g.t.e.a.y.g gVar, Collection collection, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            gVar = kVar.a;
        }
        if ((i2 & 2) != 0) {
            collection = kVar.b;
        }
        if ((i2 & 4) != 0) {
            z = kVar.f15240c;
        }
        return kVar.a(gVar, collection, z);
    }

    @k.e.a.d
    public final k a(@k.e.a.d h.p2.b0.g.t.e.a.y.g gVar, @k.e.a.d Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z) {
        return new k(gVar, collection, z);
    }

    public final boolean c() {
        return this.f15240c;
    }

    public final boolean d() {
        return this.a.c() == NullabilityQualifier.NOT_NULL && this.f15240c;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.e.a.y.g e() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return f0.g(this.a, kVar.a) && f0.g(this.b, kVar.b) && this.f15240c == kVar.f15240c;
        }
        return false;
    }

    @k.e.a.d
    public final Collection<AnnotationQualifierApplicabilityType> f() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.f15240c;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    @k.e.a.d
    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.a + ", qualifierApplicabilityTypes=" + this.b + ", affectsTypeParameterBasedTypes=" + this.f15240c + ')';
    }

    public /* synthetic */ k(h.p2.b0.g.t.e.a.y.g gVar, Collection collection, boolean z, int i2, u uVar) {
        this(gVar, collection, (i2 & 4) != 0 ? gVar.c() == NullabilityQualifier.NOT_NULL : z);
    }
}
