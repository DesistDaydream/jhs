package h.p2.b0.g.t.l.b.x;

import h.k2.v.u;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.l.b.x.c;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;

/* loaded from: classes3.dex */
public final class d extends h.p2.b0.g.t.c.d1.e implements c {
    @k.e.a.d
    private final ProtoBuf.Constructor G;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.c H;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.g I;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.i J;
    @k.e.a.e
    private final e K;
    @k.e.a.d
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode L;

    public /* synthetic */ d(h.p2.b0.g.t.c.d dVar, h.p2.b0.g.t.c.j jVar, h.p2.b0.g.t.c.b1.e eVar, boolean z, CallableMemberDescriptor.Kind kind, ProtoBuf.Constructor constructor, h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar, h.p2.b0.g.t.f.z.i iVar, e eVar2, o0 o0Var, int i2, u uVar) {
        this(dVar, jVar, eVar, z, kind, constructor, cVar, gVar, iVar, eVar2, (i2 & 1024) != 0 ? null : o0Var);
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.v
    public boolean D() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public List<h.p2.b0.g.t.f.z.h> E0() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.g F() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.i I() {
        return this.J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.c J() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.e
    public e K() {
        return this.K;
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.v
    public boolean isInline() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.v
    public boolean isSuspend() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d1.e
    @k.e.a.d
    /* renamed from: n1 */
    public d j1(@k.e.a.d k kVar, @k.e.a.e v vVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.e h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d o0 o0Var) {
        d dVar = new d((h.p2.b0.g.t.c.d) kVar, (h.p2.b0.g.t.c.j) vVar, eVar, this.D, kind, d0(), J(), F(), I(), K(), o0Var);
        dVar.U0(M0());
        dVar.q1(o1());
        return dVar;
    }

    @k.e.a.d
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode o1() {
        return this.L;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    /* renamed from: p1 */
    public ProtoBuf.Constructor d0() {
        return this.G;
    }

    public void q1(@k.e.a.d DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        this.L = coroutinesCompatibilityMode;
    }

    public d(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.e h.p2.b0.g.t.c.j jVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d ProtoBuf.Constructor constructor, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar, @k.e.a.d h.p2.b0.g.t.f.z.i iVar, @k.e.a.e e eVar2, @k.e.a.e o0 o0Var) {
        super(dVar, jVar, eVar, z, kind, o0Var == null ? o0.a : o0Var);
        this.G = constructor;
        this.H = cVar;
        this.I = gVar;
        this.J = iVar;
        this.K = eVar2;
        this.L = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }
}
