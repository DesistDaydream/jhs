package h.p2.b0.g.t.e.b;

import h.k2.v.f0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;

/* loaded from: classes3.dex */
public final class d implements h.p2.b0.g.t.l.b.e {
    @k.e.a.d
    private final k a;
    @k.e.a.d
    private final DeserializedDescriptorResolver b;

    public d(@k.e.a.d k kVar, @k.e.a.d DeserializedDescriptorResolver deserializedDescriptorResolver) {
        this.a = kVar;
        this.b = deserializedDescriptorResolver;
    }

    @Override // h.p2.b0.g.t.l.b.e
    @k.e.a.e
    public h.p2.b0.g.t.l.b.d a(@k.e.a.d h.p2.b0.g.t.g.b bVar) {
        m b = l.b(this.a, bVar);
        if (b == null) {
            return null;
        }
        f0.g(b.b(), bVar);
        return this.b.j(b);
    }
}
