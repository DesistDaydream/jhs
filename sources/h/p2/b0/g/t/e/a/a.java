package h.p2.b0.g.t.e.a;

import h.a2.d1;
import h.a2.s0;
import h.a2.t;
import h.a2.t0;
import h.z0;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: classes3.dex */
public final class a {
    @k.e.a.d
    private static final h.p2.b0.g.t.g.c a = new h.p2.b0.g.t.g.c("javax.annotation.meta.TypeQualifierNickname");
    @k.e.a.d
    private static final h.p2.b0.g.t.g.c b = new h.p2.b0.g.t.g.c("javax.annotation.meta.TypeQualifier");
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.c f15230c = new h.p2.b0.g.t.g.c("javax.annotation.meta.TypeQualifierDefault");
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.c f15231d = new h.p2.b0.g.t.g.c("kotlin.annotations.jvm.UnderMigration");
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final List<AnnotationQualifierApplicabilityType> f15232e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final Map<h.p2.b0.g.t.g.c, k> f15233f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final Map<h.p2.b0.g.t.g.c, k> f15234g;
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final Set<h.p2.b0.g.t.g.c> f15235h;

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        List<AnnotationQualifierApplicabilityType> L = CollectionsKt__CollectionsKt.L(AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);
        f15232e = L;
        h.p2.b0.g.t.g.c g2 = q.g();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        Map<h.p2.b0.g.t.g.c, k> k2 = s0.k(z0.a(g2, new k(new h.p2.b0.g.t.e.a.y.g(nullabilityQualifier, false, 2, null), L, false)));
        f15233f = k2;
        f15234g = t0.n0(t0.W(z0.a(new h.p2.b0.g.t.g.c("javax.annotation.ParametersAreNullableByDefault"), new k(new h.p2.b0.g.t.e.a.y.g(NullabilityQualifier.NULLABLE, false, 2, null), t.k(annotationQualifierApplicabilityType), false, 4, null)), z0.a(new h.p2.b0.g.t.g.c("javax.annotation.ParametersAreNonnullByDefault"), new k(new h.p2.b0.g.t.e.a.y.g(nullabilityQualifier, false, 2, null), t.k(annotationQualifierApplicabilityType), false, 4, null))), k2);
        f15235h = d1.u(q.f(), q.e());
    }

    @k.e.a.d
    public static final Map<h.p2.b0.g.t.g.c, k> a() {
        return f15234g;
    }

    @k.e.a.d
    public static final Set<h.p2.b0.g.t.g.c> b() {
        return f15235h;
    }

    @k.e.a.d
    public static final Map<h.p2.b0.g.t.g.c, k> c() {
        return f15233f;
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.g.c d() {
        return f15231d;
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.g.c e() {
        return f15230c;
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.g.c f() {
        return b;
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.g.c g() {
        return a;
    }
}
