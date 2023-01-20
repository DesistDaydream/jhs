package h.p2.b0.g.t.l.b.x;

import h.p2.b0.g.t.c.d1.f0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.w0;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class i extends AbstractTypeAliasDescriptor implements DeserializedMemberDescriptor {
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private final m f15546h;
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private final ProtoBuf.TypeAlias f15547i;
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    private final h.p2.b0.g.t.f.z.c f15548j;
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private final h.p2.b0.g.t.f.z.g f15549k;
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private final h.p2.b0.g.t.f.z.i f15550l;
    @k.e.a.e

    /* renamed from: m  reason: collision with root package name */
    private final e f15551m;
    private Collection<? extends f0> n;
    private h.p2.b0.g.t.n.f0 o;
    private h.p2.b0.g.t.n.f0 p;
    private List<? extends t0> q;
    private h.p2.b0.g.t.n.f0 r;
    @k.e.a.d
    private DeserializedMemberDescriptor.CoroutinesCompatibilityMode s;

    public i(@k.e.a.d m mVar, @k.e.a.d k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d s sVar, @k.e.a.d ProtoBuf.TypeAlias typeAlias, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar, @k.e.a.d h.p2.b0.g.t.f.z.i iVar, @k.e.a.e e eVar2) {
        super(kVar, eVar, fVar, o0.a, sVar);
        this.f15546h = mVar;
        this.f15547i = typeAlias;
        this.f15548j = cVar;
        this.f15549k = gVar;
        this.f15550l = iVar;
        this.f15551m = eVar2;
        this.s = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public List<h.p2.b0.g.t.f.z.h> E0() {
        return DeserializedMemberDescriptor.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.g F() {
        return this.f15549k;
    }

    @Override // h.p2.b0.g.t.c.s0
    @k.e.a.d
    public h.p2.b0.g.t.n.f0 H() {
        h.p2.b0.g.t.n.f0 f0Var = this.p;
        Objects.requireNonNull(f0Var);
        return f0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.i I() {
        return this.f15550l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    @k.e.a.d
    public List<t0> I0() {
        List list = this.q;
        Objects.requireNonNull(list);
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    public h.p2.b0.g.t.f.z.c J() {
        return this.f15548j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.e
    public e K() {
        return this.f15551m;
    }

    @k.e.a.d
    public DeserializedMemberDescriptor.CoroutinesCompatibilityMode K0() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    @k.e.a.d
    /* renamed from: L0 */
    public ProtoBuf.TypeAlias d0() {
        return this.f15547i;
    }

    public final void M0(@k.e.a.d List<? extends t0> list, @k.e.a.d h.p2.b0.g.t.n.f0 f0Var, @k.e.a.d h.p2.b0.g.t.n.f0 f0Var2, @k.e.a.d DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        J0(list);
        this.o = f0Var;
        this.p = f0Var2;
        this.q = TypeParameterUtilsKt.d(this);
        this.r = C0();
        this.n = H0();
        this.s = coroutinesCompatibilityMode;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    @k.e.a.d
    public m N() {
        return this.f15546h;
    }

    @Override // h.p2.b0.g.t.c.q0
    @k.e.a.d
    /* renamed from: N0 */
    public s0 c(@k.e.a.d TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor.k()) {
            return this;
        }
        i iVar = new i(N(), b(), getAnnotations(), getName(), getVisibility(), d0(), J(), F(), I(), K());
        List<t0> s = s();
        h.p2.b0.g.t.n.f0 r0 = r0();
        Variance variance = Variance.INVARIANT;
        iVar.M0(s, w0.a(typeSubstitutor.n(r0, variance)), w0.a(typeSubstitutor.n(H(), variance)), K0());
        return iVar;
    }

    @Override // h.p2.b0.g.t.c.f
    @k.e.a.d
    public h.p2.b0.g.t.n.f0 r() {
        h.p2.b0.g.t.n.f0 f0Var = this.r;
        Objects.requireNonNull(f0Var);
        return f0Var;
    }

    @Override // h.p2.b0.g.t.c.s0
    @k.e.a.d
    public h.p2.b0.g.t.n.f0 r0() {
        h.p2.b0.g.t.n.f0 f0Var = this.o;
        Objects.requireNonNull(f0Var);
        return f0Var;
    }

    @Override // h.p2.b0.g.t.c.s0
    @k.e.a.e
    public h.p2.b0.g.t.c.d u() {
        if (a0.a(H())) {
            return null;
        }
        h.p2.b0.g.t.c.f c2 = H().I0().c();
        if (c2 instanceof h.p2.b0.g.t.c.d) {
            return (h.p2.b0.g.t.c.d) c2;
        }
        return null;
    }
}
