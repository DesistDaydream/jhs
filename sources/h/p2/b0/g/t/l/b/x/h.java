package h.p2.b0.g.t.l.b.x;

import h.k2.v.u;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.d1.d0;
import h.p2.b0.g.t.c.d1.o;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.l.b.x.c;
import h.p2.b0.g.t.n.z;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;

/* loaded from: classes3.dex */
public final class h extends d0 implements c {
    @k.e.a.d
    private final ProtoBuf.Function D;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.c E;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.g F;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.i G;
    @k.e.a.e
    private final e H;
    @k.e.a.d
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode I;

    public /* synthetic */ h(k kVar, n0 n0Var, h.p2.b0.g.t.c.b1.e eVar, h.p2.b0.g.t.g.f fVar, CallableMemberDescriptor.Kind kind, ProtoBuf.Function function, h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar, h.p2.b0.g.t.f.z.i iVar, e eVar2, o0 o0Var, int i2, u uVar) {
        this(kVar, n0Var, eVar, fVar, kind, function, cVar, gVar, iVar, eVar2, (i2 & 1024) != 0 ? null : o0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public List<h.p2.b0.g.t.f.z.h> E0() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.g F() {
        return this.F;
    }

    @Override // h.p2.b0.g.t.c.d1.d0, h.p2.b0.g.t.c.d1.o
    @k.e.a.d
    public o H0(@k.e.a.d k kVar, @k.e.a.e v vVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.e h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d o0 o0Var) {
        h hVar = new h(kVar, (n0) vVar, eVar, fVar == null ? getName() : fVar, kind, d0(), J(), F(), I(), K(), o0Var);
        hVar.U0(M0());
        hVar.I = l1();
        return hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.i I() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.c J() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.e
    public e K() {
        return this.H;
    }

    @k.e.a.d
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode l1() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    /* renamed from: m1 */
    public ProtoBuf.Function d0() {
        return this.D;
    }

    @k.e.a.d
    public final d0 n1(@k.e.a.e m0 m0Var, @k.e.a.e m0 m0Var2, @k.e.a.d List<? extends t0> list, @k.e.a.d List<? extends v0> list2, @k.e.a.e z zVar, @k.e.a.e Modality modality, @k.e.a.d s sVar, @k.e.a.d Map<? extends a.InterfaceC0434a<?>, ?> map, @k.e.a.d DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        d0 k1 = super.k1(m0Var, m0Var2, list, list2, zVar, modality, sVar, map);
        this.I = coroutinesCompatibilityMode;
        return k1;
    }

    public h(@k.e.a.d k kVar, @k.e.a.e n0 n0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d ProtoBuf.Function function, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar, @k.e.a.d h.p2.b0.g.t.f.z.i iVar, @k.e.a.e e eVar2, @k.e.a.e o0 o0Var) {
        super(kVar, n0Var, eVar, fVar, kind, o0Var == null ? o0.a : o0Var);
        this.D = function;
        this.E = cVar;
        this.F = gVar;
        this.G = iVar;
        this.H = eVar2;
        this.I = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }
}
