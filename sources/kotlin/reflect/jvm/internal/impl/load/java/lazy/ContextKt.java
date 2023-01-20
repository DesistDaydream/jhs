package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.e.a.n;
import h.p2.b0.g.t.e.a.v.b;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.v.h;
import h.p2.b0.g.t.e.a.x.z;
import h.p2.b0.g.t.e.a.y.g;
import h.w;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* loaded from: classes3.dex */
public final class ContextKt {
    private static final e a(e eVar, k kVar, z zVar, int i2, w<n> wVar) {
        b a = eVar.a();
        LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = zVar == null ? null : new LazyJavaTypeParameterResolver(eVar, kVar, zVar, i2);
        if (lazyJavaTypeParameterResolver == null) {
            lazyJavaTypeParameterResolver = eVar.f();
        }
        return new e(a, lazyJavaTypeParameterResolver, wVar);
    }

    @d
    public static final e b(@d e eVar, @d h hVar) {
        return new e(eVar.a(), hVar, eVar.c());
    }

    @d
    public static final e c(@d e eVar, @d h.p2.b0.g.t.c.e eVar2, @k.e.a.e z zVar, int i2) {
        return a(eVar, eVar2, zVar, i2, h.z.b(LazyThreadSafetyMode.NONE, new ContextKt$childForClassOrPackage$1(eVar, eVar2)));
    }

    public static /* synthetic */ e d(e eVar, h.p2.b0.g.t.c.e eVar2, z zVar, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            zVar = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return c(eVar, eVar2, zVar, i2);
    }

    @d
    public static final e e(@d e eVar, @d k kVar, @d z zVar, int i2) {
        return a(eVar, kVar, zVar, i2, eVar.c());
    }

    public static /* synthetic */ e f(e eVar, k kVar, z zVar, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return e(eVar, kVar, zVar, i2);
    }

    @k.e.a.e
    public static final n g(@d e eVar, @d h.p2.b0.g.t.c.b1.e eVar2) {
        EnumMap<AnnotationQualifierApplicabilityType, h.p2.b0.g.t.e.a.k> b;
        if (eVar.a().i().a()) {
            return eVar.b();
        }
        ArrayList<h.p2.b0.g.t.e.a.k> arrayList = new ArrayList();
        Iterator<c> it = eVar2.iterator();
        while (it.hasNext()) {
            h.p2.b0.g.t.e.a.k i2 = i(eVar, it.next());
            if (i2 != null) {
                arrayList.add(i2);
            }
        }
        if (arrayList.isEmpty()) {
            return eVar.b();
        }
        n b2 = eVar.b();
        EnumMap enumMap = null;
        if (b2 != null && (b = b2.b()) != null) {
            enumMap = new EnumMap((EnumMap) b);
        }
        if (enumMap == null) {
            enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
        }
        boolean z = false;
        for (h.p2.b0.g.t.e.a.k kVar : arrayList) {
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : kVar.f()) {
                enumMap.put((EnumMap) annotationQualifierApplicabilityType, (AnnotationQualifierApplicabilityType) kVar);
                z = true;
            }
        }
        return !z ? eVar.b() : new n(enumMap);
    }

    @d
    public static final e h(@d e eVar, @d h.p2.b0.g.t.c.b1.e eVar2) {
        return eVar2.isEmpty() ? eVar : new e(eVar.a(), eVar.f(), h.z.b(LazyThreadSafetyMode.NONE, new ContextKt$copyWithNewDefaultTypeQualifiers$1(eVar, eVar2)));
    }

    private static final h.p2.b0.g.t.e.a.k i(e eVar, c cVar) {
        AnnotationTypeQualifierResolver a = eVar.a().a();
        h.p2.b0.g.t.e.a.k l2 = a.l(cVar);
        if (l2 == null) {
            AnnotationTypeQualifierResolver.a n = a.n(cVar);
            if (n == null) {
                return null;
            }
            c a2 = n.a();
            List<AnnotationQualifierApplicabilityType> b = n.b();
            ReportLevel k2 = a.k(cVar);
            if (k2 == null) {
                k2 = a.j(a2);
            }
            if (k2.isIgnore()) {
                return null;
            }
            g h2 = eVar.a().r().h(a2, eVar.a().q().b(), false);
            g b2 = h2 == null ? null : g.b(h2, null, k2.isWarning(), 1, null);
            if (b2 == null) {
                return null;
            }
            return new h.p2.b0.g.t.e.a.k(b2, b, false, 4, null);
        }
        return l2;
    }

    @d
    public static final e j(@d e eVar, @d b bVar) {
        return new e(bVar, eVar.f(), eVar.c());
    }
}
