package h.p2.b0.g.t.l.b;

import h.p2.b0.g.t.c.d1.w;
import h.p2.b0.g.t.c.z;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public abstract class k extends w {
    @k.e.a.d

    /* renamed from: f */
    private final h.p2.b0.g.t.m.m f15524f;

    public k(@k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d h.p2.b0.g.t.m.m mVar, @k.e.a.d z zVar) {
        super(zVar, cVar);
        this.f15524f = mVar;
    }

    @k.e.a.d
    public abstract e C0();

    public boolean G0(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        MemberScope q = q();
        return (q instanceof DeserializedMemberScope) && ((DeserializedMemberScope) q).s().contains(fVar);
    }

    public abstract void H0(@k.e.a.d g gVar);
}
