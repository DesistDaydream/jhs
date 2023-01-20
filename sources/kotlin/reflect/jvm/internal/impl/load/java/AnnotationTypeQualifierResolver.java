package kotlin.reflect.jvm.internal.impl.load.java;

import h.a2.u;
import h.a2.y;
import h.k2.u.p;
import h.k2.v.f0;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.e.a.k;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.n.b;
import h.p2.b0.g.t.k.n.i;
import h.p2.b0.g.t.m.g;
import h.p2.b0.g.t.m.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver {
    @d
    private final JavaTypeEnhancementState a;
    @d
    private final g<h.p2.b0.g.t.c.d, c> b;

    /* loaded from: classes3.dex */
    public static final class a {
        @d
        private final c a;
        private final int b;

        public a(@d c cVar, int i2) {
            this.a = cVar;
            this.b = i2;
        }

        private final boolean c(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            return ((1 << annotationQualifierApplicabilityType.ordinal()) & this.b) != 0;
        }

        private final boolean d(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            if (c(annotationQualifierApplicabilityType)) {
                return true;
            }
            return c(AnnotationQualifierApplicabilityType.TYPE_USE) && annotationQualifierApplicabilityType != AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        }

        @d
        public final c a() {
            return this.a;
        }

        @d
        public final List<AnnotationQualifierApplicabilityType> b() {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            ArrayList arrayList = new ArrayList();
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : values) {
                if (d(annotationQualifierApplicabilityType)) {
                    arrayList.add(annotationQualifierApplicabilityType);
                }
            }
            return arrayList;
        }
    }

    public AnnotationTypeQualifierResolver(@d m mVar, @d JavaTypeEnhancementState javaTypeEnhancementState) {
        this.a = javaTypeEnhancementState;
        this.b = mVar.g(new AnnotationTypeQualifierResolver$resolvedNicknames$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c c(h.p2.b0.g.t.c.d dVar) {
        if (dVar.getAnnotations().n(h.p2.b0.g.t.e.a.a.g())) {
            for (c cVar : dVar.getAnnotations()) {
                c m2 = m(cVar);
                if (m2 != null) {
                    return m2;
                }
            }
            return null;
        }
        return null;
    }

    private final List<AnnotationQualifierApplicabilityType> d(h.p2.b0.g.t.k.n.g<?> gVar, p<? super i, ? super AnnotationQualifierApplicabilityType, Boolean> pVar) {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        if (gVar instanceof b) {
            ArrayList arrayList = new ArrayList();
            for (h.p2.b0.g.t.k.n.g<?> gVar2 : ((b) gVar).a()) {
                y.q0(arrayList, d(gVar2, pVar));
            }
            return arrayList;
        } else if (gVar instanceof i) {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    annotationQualifierApplicabilityType = null;
                    break;
                }
                annotationQualifierApplicabilityType = values[i2];
                if (pVar.invoke(gVar, annotationQualifierApplicabilityType).booleanValue()) {
                    break;
                }
                i2++;
            }
            return CollectionsKt__CollectionsKt.M(annotationQualifierApplicabilityType);
        } else {
            return CollectionsKt__CollectionsKt.E();
        }
    }

    private final List<AnnotationQualifierApplicabilityType> e(h.p2.b0.g.t.k.n.g<?> gVar) {
        return d(gVar, AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1.INSTANCE);
    }

    private final List<AnnotationQualifierApplicabilityType> f(h.p2.b0.g.t.k.n.g<?> gVar) {
        return d(gVar, new AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1(this));
    }

    private final ReportLevel g(h.p2.b0.g.t.c.d dVar) {
        c c2 = dVar.getAnnotations().c(h.p2.b0.g.t.e.a.a.d());
        h.p2.b0.g.t.k.n.g<?> b = c2 == null ? null : DescriptorUtilsKt.b(c2);
        i iVar = b instanceof i ? (i) b : null;
        if (iVar == null) {
            return null;
        }
        ReportLevel f2 = this.a.f();
        if (f2 == null) {
            String b2 = iVar.b().b();
            int hashCode = b2.hashCode();
            if (hashCode == -2137067054) {
                if (b2.equals("IGNORE")) {
                    return ReportLevel.IGNORE;
                }
                return null;
            } else if (hashCode == -1838656823) {
                if (b2.equals("STRICT")) {
                    return ReportLevel.STRICT;
                }
                return null;
            } else if (hashCode == 2656902 && b2.equals("WARN")) {
                return ReportLevel.WARN;
            } else {
                return null;
            }
        }
        return f2;
    }

    private final ReportLevel i(c cVar) {
        if (h.p2.b0.g.t.e.a.a.c().containsKey(cVar.e())) {
            return this.a.e();
        }
        return j(cVar);
    }

    private final c o(h.p2.b0.g.t.c.d dVar) {
        if (dVar.i() != ClassKind.ANNOTATION_CLASS) {
            return null;
        }
        return this.b.invoke(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> p(String str) {
        Set<KotlinTarget> b = JavaAnnotationTargetMapper.a.b(str);
        ArrayList arrayList = new ArrayList(u.Y(b, 10));
        for (KotlinTarget kotlinTarget : b) {
            arrayList.add(kotlinTarget.name());
        }
        return arrayList;
    }

    @e
    public final a h(@d c cVar) {
        c c2;
        h.p2.b0.g.t.c.d f2 = DescriptorUtilsKt.f(cVar);
        if (f2 == null || (c2 = f2.getAnnotations().c(h.p2.b0.g.t.e.a.p.f15245d)) == null) {
            return null;
        }
        Map<f, h.p2.b0.g.t.k.n.g<?>> a2 = c2.a();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<f, h.p2.b0.g.t.k.n.g<?>> entry : a2.entrySet()) {
            y.q0(arrayList, f(entry.getValue()));
        }
        int i2 = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i2 |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        return new a(cVar, i2);
    }

    @d
    public final ReportLevel j(@d c cVar) {
        ReportLevel k2 = k(cVar);
        return k2 == null ? this.a.d() : k2;
    }

    @e
    public final ReportLevel k(@d c cVar) {
        Map<String, ReportLevel> g2 = this.a.g();
        h.p2.b0.g.t.g.c e2 = cVar.e();
        ReportLevel reportLevel = g2.get(e2 == null ? null : e2.b());
        if (reportLevel == null) {
            h.p2.b0.g.t.c.d f2 = DescriptorUtilsKt.f(cVar);
            if (f2 == null) {
                return null;
            }
            return g(f2);
        }
        return reportLevel;
    }

    @e
    public final k l(@d c cVar) {
        k kVar;
        if (this.a.a() || (kVar = h.p2.b0.g.t.e.a.a.a().get(cVar.e())) == null) {
            return null;
        }
        ReportLevel i2 = i(cVar);
        if (!(i2 != ReportLevel.IGNORE)) {
            i2 = null;
        }
        if (i2 == null) {
            return null;
        }
        return k.b(kVar, h.p2.b0.g.t.e.a.y.g.b(kVar.e(), null, i2.isWarning(), 1, null), null, false, 6, null);
    }

    @e
    public final c m(@d c cVar) {
        h.p2.b0.g.t.c.d f2;
        if (this.a.b() || (f2 = DescriptorUtilsKt.f(cVar)) == null) {
            return null;
        }
        return h.p2.b0.g.t.e.a.b.a(f2) ? cVar : o(f2);
    }

    @e
    public final a n(@d c cVar) {
        c cVar2;
        boolean z;
        List<AnnotationQualifierApplicabilityType> E;
        if (this.a.b()) {
            return null;
        }
        h.p2.b0.g.t.c.d f2 = DescriptorUtilsKt.f(cVar);
        if (f2 == null || !f2.getAnnotations().n(h.p2.b0.g.t.e.a.a.e())) {
            f2 = null;
        }
        if (f2 == null) {
            return null;
        }
        Map<f, h.p2.b0.g.t.k.n.g<?>> a2 = DescriptorUtilsKt.f(cVar).getAnnotations().c(h.p2.b0.g.t.e.a.a.e()).a();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<f, h.p2.b0.g.t.k.n.g<?>> entry : a2.entrySet()) {
            h.p2.b0.g.t.k.n.g<?> value = entry.getValue();
            if (f0.g(entry.getKey(), h.p2.b0.g.t.e.a.p.f15244c)) {
                E = e(value);
            } else {
                E = CollectionsKt__CollectionsKt.E();
            }
            y.q0(arrayList, E);
        }
        int i2 = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i2 |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        Iterator<c> it = f2.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                cVar2 = null;
                break;
            }
            cVar2 = it.next();
            if (m(cVar2) != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        c cVar3 = cVar2;
        if (cVar3 == null) {
            return null;
        }
        return new a(cVar3, i2);
    }
}
