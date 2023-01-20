package h.p2.b0.g.t.e.a.t;

import h.a2.t0;
import h.k2.v.f0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.e.a.p;
import h.p2.b0.g.t.g.f;
import h.z0;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;

/* loaded from: classes3.dex */
public final class b {
    @k.e.a.d
    public static final b a = new b();
    @k.e.a.d
    private static final f b = f.f("message");
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final f f15267c = f.f("allowedTargets");
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final f f15268d = f.f("value");
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final Map<h.p2.b0.g.t.g.c, h.p2.b0.g.t.g.c> f15269e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final Map<h.p2.b0.g.t.g.c, h.p2.b0.g.t.g.c> f15270f;

    static {
        h.p2.b0.g.t.g.c cVar = g.a.F;
        h.p2.b0.g.t.g.c cVar2 = p.f15245d;
        h.p2.b0.g.t.g.c cVar3 = g.a.I;
        h.p2.b0.g.t.g.c cVar4 = p.f15246e;
        h.p2.b0.g.t.g.c cVar5 = g.a.J;
        h.p2.b0.g.t.g.c cVar6 = p.f15249h;
        h.p2.b0.g.t.g.c cVar7 = g.a.K;
        h.p2.b0.g.t.g.c cVar8 = p.f15248g;
        f15269e = t0.W(z0.a(cVar, cVar2), z0.a(cVar3, cVar4), z0.a(cVar5, cVar6), z0.a(cVar7, cVar8));
        f15270f = t0.W(z0.a(cVar2, cVar), z0.a(cVar4, cVar3), z0.a(p.f15247f, g.a.y), z0.a(cVar6, cVar5), z0.a(cVar8, cVar7));
    }

    private b() {
    }

    public static /* synthetic */ h.p2.b0.g.t.c.b1.c f(b bVar, h.p2.b0.g.t.e.a.x.a aVar, h.p2.b0.g.t.e.a.v.e eVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return bVar.e(aVar, eVar, z);
    }

    @k.e.a.e
    public final h.p2.b0.g.t.c.b1.c a(@k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d h.p2.b0.g.t.e.a.x.d dVar, @k.e.a.d h.p2.b0.g.t.e.a.v.e eVar) {
        h.p2.b0.g.t.e.a.x.a c2;
        h.p2.b0.g.t.e.a.x.a c3;
        if (f0.g(cVar, g.a.y) && ((c3 = dVar.c(p.f15247f)) != null || dVar.D())) {
            return new JavaDeprecatedAnnotationDescriptor(c3, eVar);
        }
        h.p2.b0.g.t.g.c cVar2 = f15269e.get(cVar);
        if (cVar2 == null || (c2 = dVar.c(cVar2)) == null) {
            return null;
        }
        return f(a, c2, eVar, false, 4, null);
    }

    @k.e.a.d
    public final f b() {
        return b;
    }

    @k.e.a.d
    public final f c() {
        return f15268d;
    }

    @k.e.a.d
    public final f d() {
        return f15267c;
    }

    @k.e.a.e
    public final h.p2.b0.g.t.c.b1.c e(@k.e.a.d h.p2.b0.g.t.e.a.x.a aVar, @k.e.a.d h.p2.b0.g.t.e.a.v.e eVar, boolean z) {
        h.p2.b0.g.t.g.b b2 = aVar.b();
        if (f0.g(b2, h.p2.b0.g.t.g.b.m(p.f15245d))) {
            return new JavaTargetAnnotationDescriptor(aVar, eVar);
        }
        if (f0.g(b2, h.p2.b0.g.t.g.b.m(p.f15246e))) {
            return new JavaRetentionAnnotationDescriptor(aVar, eVar);
        }
        if (f0.g(b2, h.p2.b0.g.t.g.b.m(p.f15249h))) {
            return new JavaAnnotationDescriptor(eVar, aVar, g.a.J);
        }
        if (f0.g(b2, h.p2.b0.g.t.g.b.m(p.f15248g))) {
            return new JavaAnnotationDescriptor(eVar, aVar, g.a.K);
        }
        if (f0.g(b2, h.p2.b0.g.t.g.b.m(p.f15247f))) {
            return null;
        }
        return new LazyJavaAnnotationDescriptor(eVar, aVar, z);
    }
}
