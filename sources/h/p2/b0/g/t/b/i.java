package h.p2.b0.g.t.b;

import h.a2.t0;
import h.k2.k;
import h.k2.v.f0;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import h.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedType;

/* loaded from: classes3.dex */
public final class i {
    @k.e.a.d
    public static final i a = new i();
    @k.e.a.d
    private static final Set<h.p2.b0.g.t.g.f> b;
    @k.e.a.d

    /* renamed from: c */
    private static final Set<h.p2.b0.g.t.g.f> f15047c;
    @k.e.a.d

    /* renamed from: d */
    private static final HashMap<h.p2.b0.g.t.g.b, h.p2.b0.g.t.g.b> f15048d;
    @k.e.a.d

    /* renamed from: e */
    private static final HashMap<h.p2.b0.g.t.g.b, h.p2.b0.g.t.g.b> f15049e;
    @k.e.a.d

    /* renamed from: f */
    private static final HashMap<UnsignedArrayType, h.p2.b0.g.t.g.f> f15050f;
    @k.e.a.d

    /* renamed from: g */
    private static final Set<h.p2.b0.g.t.g.f> f15051g;

    static {
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        int i2 = 0;
        for (UnsignedType unsignedType : values) {
            arrayList.add(unsignedType.getTypeName());
        }
        b = CollectionsKt___CollectionsKt.N5(arrayList);
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (UnsignedArrayType unsignedArrayType : values2) {
            arrayList2.add(unsignedArrayType.getTypeName());
        }
        f15047c = CollectionsKt___CollectionsKt.N5(arrayList2);
        f15048d = new HashMap<>();
        f15049e = new HashMap<>();
        f15050f = t0.M(z0.a(UnsignedArrayType.UBYTEARRAY, h.p2.b0.g.t.g.f.f("ubyteArrayOf")), z0.a(UnsignedArrayType.USHORTARRAY, h.p2.b0.g.t.g.f.f("ushortArrayOf")), z0.a(UnsignedArrayType.UINTARRAY, h.p2.b0.g.t.g.f.f("uintArrayOf")), z0.a(UnsignedArrayType.ULONGARRAY, h.p2.b0.g.t.g.f.f("ulongArrayOf")));
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : values3) {
            linkedHashSet.add(unsignedType2.getArrayClassId().j());
        }
        f15051g = linkedHashSet;
        UnsignedType[] values4 = UnsignedType.values();
        int length = values4.length;
        while (i2 < length) {
            UnsignedType unsignedType3 = values4[i2];
            i2++;
            f15048d.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            f15049e.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    private i() {
    }

    @k
    public static final boolean d(@k.e.a.d z zVar) {
        h.p2.b0.g.t.c.f c2;
        if (y0.v(zVar) || (c2 = zVar.I0().c()) == null) {
            return false;
        }
        return a.c(c2);
    }

    @k.e.a.e
    public final h.p2.b0.g.t.g.b a(@k.e.a.d h.p2.b0.g.t.g.b bVar) {
        return f15048d.get(bVar);
    }

    public final boolean b(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        return f15051g.contains(fVar);
    }

    public final boolean c(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        h.p2.b0.g.t.c.k b2 = kVar.b();
        return (b2 instanceof b0) && f0.g(((b0) b2).e(), g.n) && b.contains(kVar.getName());
    }
}
