package h.p2.b0.g.t.l.b.x;

import h.p2.b0.g.t.c.d1.a0;
import h.p2.b0.g.t.c.d1.z;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.l0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.u;
import h.p2.b0.g.t.l.b.x.c;
import h.t1;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;

/* loaded from: classes3.dex */
public final class g extends z implements c {
    @k.e.a.d
    private final ProtoBuf.Property C;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.c D;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.g E;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.i F;
    @k.e.a.e
    private final e G;
    @k.e.a.d
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode H;

    public g(@k.e.a.d k kVar, @k.e.a.e j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d Modality modality, @k.e.a.d s sVar, boolean z, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d CallableMemberDescriptor.Kind kind, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, @k.e.a.d ProtoBuf.Property property, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar, @k.e.a.d h.p2.b0.g.t.f.z.i iVar, @k.e.a.e e eVar2) {
        super(kVar, j0Var, eVar, modality, sVar, z, fVar, kind, o0.a, z2, z3, z6, false, z4, z5);
        this.C = property;
        this.D = cVar;
        this.E = gVar;
        this.F = iVar;
        this.G = eVar2;
        this.H = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public List<h.p2.b0.g.t.f.z.h> E0() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.g F() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.i I() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.c J() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.e
    public e K() {
        return this.G;
    }

    @Override // h.p2.b0.g.t.c.d1.z
    @k.e.a.d
    public z L0(@k.e.a.d k kVar, @k.e.a.d Modality modality, @k.e.a.d s sVar, @k.e.a.e j0 j0Var, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d o0 o0Var) {
        return new g(kVar, j0Var, getAnnotations(), modality, sVar, O(), fVar, kind, v0(), isConst(), isExternal(), C(), i0(), d0(), J(), F(), I(), K());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    /* renamed from: Y0 */
    public ProtoBuf.Property d0() {
        return this.C;
    }

    public final void Z0(@k.e.a.e a0 a0Var, @k.e.a.e l0 l0Var, @k.e.a.e u uVar, @k.e.a.e u uVar2, @k.e.a.d DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        super.R0(a0Var, l0Var, uVar, uVar2);
        t1 t1Var = t1.a;
        this.H = coroutinesCompatibilityMode;
    }

    @Override // h.p2.b0.g.t.c.d1.z, h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return h.p2.b0.g.t.f.z.b.D.d(d0().getFlags()).booleanValue();
    }
}
