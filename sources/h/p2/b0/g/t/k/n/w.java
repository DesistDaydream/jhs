package h.p2.b0.g.t.k.n;

import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.z;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;

/* loaded from: classes3.dex */
public final class w extends y<Long> {
    public w(long j2) {
        super(Long.valueOf(j2));
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public z getType(@k.e.a.d h.p2.b0.g.t.c.z zVar) {
        h.p2.b0.g.t.c.d a = FindClassInModuleKt.a(zVar, g.a.w0);
        f0 r = a == null ? null : a.r();
        return r == null ? h.p2.b0.g.t.n.s.j("Unsigned type ULong not found") : r;
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public String toString() {
        return a().longValue() + ".toULong()";
    }
}
