package h.p2.b0.g.t.k.n;

import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.z;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;

/* loaded from: classes3.dex */
public final class x extends y<Short> {
    public x(short s) {
        super(Short.valueOf(s));
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public z getType(@k.e.a.d h.p2.b0.g.t.c.z zVar) {
        h.p2.b0.g.t.c.d a = FindClassInModuleKt.a(zVar, g.a.u0);
        f0 r = a == null ? null : a.r();
        return r == null ? h.p2.b0.g.t.n.s.j("Unsigned type UShort not found") : r;
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public String toString() {
        return a().intValue() + ".toUShort()";
    }
}
