package h.p2.b0.g.t.b;

import androidx.exifinterface.media.ExifInterface;
import h.a2.t;
import h.a2.u;
import h.k2.v.f0;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.d1.g0;
import h.p2.b0.g.t.c.d1.l;
import h.p2.b0.g.t.c.d1.v;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class h {
    @k.e.a.d
    private static final v a;
    @k.e.a.d
    private static final v b;

    static {
        l lVar = new l(s.q(), g.f15028f);
        ClassKind classKind = ClassKind.INTERFACE;
        h.p2.b0.g.t.g.f g2 = g.f15030h.g();
        o0 o0Var = o0.a;
        m mVar = LockBasedStorageManager.f16850e;
        v vVar = new v(lVar, classKind, false, false, g2, o0Var, mVar);
        Modality modality = Modality.ABSTRACT;
        vVar.I0(modality);
        h.p2.b0.g.t.c.s sVar = r.f15211e;
        vVar.K0(sVar);
        e.a aVar = h.p2.b0.g.t.c.b1.e.w0;
        h.p2.b0.g.t.c.b1.e b2 = aVar.b();
        Variance variance = Variance.IN_VARIANCE;
        vVar.J0(t.k(g0.N0(vVar, b2, false, variance, h.p2.b0.g.t.g.f.f(ExifInterface.GPS_DIRECTION_TRUE), 0, mVar)));
        vVar.G0();
        a = vVar;
        v vVar2 = new v(new l(s.q(), g.f15027e), classKind, false, false, g.f15031i.g(), o0Var, mVar);
        vVar2.I0(modality);
        vVar2.K0(sVar);
        vVar2.J0(t.k(g0.N0(vVar2, aVar.b(), false, variance, h.p2.b0.g.t.g.f.f(ExifInterface.GPS_DIRECTION_TRUE), 0, mVar)));
        vVar2.G0();
        b = vVar2;
    }

    public static final boolean a(@k.e.a.e h.p2.b0.g.t.g.c cVar, boolean z) {
        if (z) {
            return f0.g(cVar, g.f15031i);
        }
        return f0.g(cVar, g.f15030h);
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.n.f0 b(@k.e.a.d z zVar, boolean z) {
        q0 j2;
        h.p2.b0.g.t.n.f0 a2;
        e.o(zVar);
        f h2 = TypeUtilsKt.h(zVar);
        h.p2.b0.g.t.c.b1.e annotations = zVar.getAnnotations();
        z h3 = e.h(zVar);
        List<s0> j3 = e.j(zVar);
        ArrayList arrayList = new ArrayList(u.Y(j3, 10));
        for (s0 s0Var : j3) {
            arrayList.add(s0Var.getType());
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        h.p2.b0.g.t.c.b1.e b2 = h.p2.b0.g.t.c.b1.e.w0.b();
        if (z) {
            j2 = b.j();
        } else {
            j2 = a.j();
        }
        a2 = e.a(h2, annotations, h3, CollectionsKt___CollectionsKt.r4(arrayList, KotlinTypeFactory.i(b2, j2, t.k(TypeUtilsKt.a(e.i(zVar))), false, null, 16, null)), null, TypeUtilsKt.h(zVar).I(), (r14 & 64) != 0 ? false : false);
        return a2.P0(zVar.J0());
    }
}
