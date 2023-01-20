package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.v.n0;
import h.k2.v.u;
import h.p2.b0.g.t.c.c;
import h.p2.b0.g.t.c.d1.f0;
import h.p2.b0.g.t.c.d1.o;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.b;
import h.p2.b0.g.t.m.i;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.i0;
import h.p2.b0.g.t.n.x;
import h.p2.b0.g.t.n.z;
import h.p2.n;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class TypeAliasConstructorDescriptorImpl extends o implements f0 {
    @d
    private final m D;
    @d
    private final s0 E;
    @d
    private final i F;
    @d
    private c G;
    public static final /* synthetic */ n<Object>[] I = {n0.r(new PropertyReference1Impl(n0.d(TypeAliasConstructorDescriptorImpl.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    @d
    public static final a H = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TypeSubstitutor c(s0 s0Var) {
            if (s0Var.u() == null) {
                return null;
            }
            return TypeSubstitutor.f(s0Var.H());
        }

        @e
        public final f0 b(@d m mVar, @d s0 s0Var, @d c cVar) {
            c c2;
            TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl;
            List<v0> K0;
            TypeSubstitutor c3 = c(s0Var);
            if (c3 == null || (c2 = cVar.c(c3)) == null || (K0 = o.K0((typeAliasConstructorDescriptorImpl = new TypeAliasConstructorDescriptorImpl(mVar, s0Var, c2, null, cVar.getAnnotations(), cVar.i(), s0Var.getSource(), null)), cVar.h(), c3)) == null) {
                return null;
            }
            h.p2.b0.g.t.n.f0 j2 = i0.j(x.c(c2.getReturnType().L0()), s0Var.r());
            m0 M = cVar.M();
            typeAliasConstructorDescriptorImpl.N0(M != null ? b.f(typeAliasConstructorDescriptorImpl, c3.n(M.getType(), Variance.INVARIANT), h.p2.b0.g.t.c.b1.e.w0.b()) : null, null, s0Var.s(), K0, j2, Modality.FINAL, s0Var.getVisibility());
            return typeAliasConstructorDescriptorImpl;
        }
    }

    private TypeAliasConstructorDescriptorImpl(m mVar, s0 s0Var, c cVar, f0 f0Var, h.p2.b0.g.t.c.b1.e eVar, CallableMemberDescriptor.Kind kind, o0 o0Var) {
        super(s0Var, f0Var, eVar, f.i("<init>"), kind, o0Var);
        this.D = mVar;
        this.E = s0Var;
        R0(k1().X());
        this.F = mVar.e(new TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(this, cVar));
        this.G = cVar;
    }

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(m mVar, s0 s0Var, c cVar, f0 f0Var, h.p2.b0.g.t.c.b1.e eVar, CallableMemberDescriptor.Kind kind, o0 o0Var, u uVar) {
        this(mVar, s0Var, cVar, f0Var, eVar, kind, o0Var);
    }

    @d
    public final m N() {
        return this.D;
    }

    @Override // h.p2.b0.g.t.c.d1.f0
    @d
    public c T() {
        return this.G;
    }

    @Override // h.p2.b0.g.t.c.j
    public boolean b0() {
        return T().b0();
    }

    @Override // h.p2.b0.g.t.c.j
    @d
    public h.p2.b0.g.t.c.d c0() {
        return T().c0();
    }

    @Override // h.p2.b0.g.t.c.d1.o, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @d
    /* renamed from: g1 */
    public f0 P(@d k kVar, @d Modality modality, @d s sVar, @d CallableMemberDescriptor.Kind kind, boolean z) {
        v build = x().p(kVar).j(modality).g(sVar).q(kind).n(z).build();
        Objects.requireNonNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (f0) build;
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.a
    @d
    public z getReturnType() {
        return super.getReturnType();
    }

    @Override // h.p2.b0.g.t.c.d1.o
    @d
    /* renamed from: h1 */
    public TypeAliasConstructorDescriptorImpl H0(@d k kVar, @e v vVar, @d CallableMemberDescriptor.Kind kind, @e f fVar, @d h.p2.b0.g.t.c.b1.e eVar, @d o0 o0Var) {
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind != kind2) {
            CallableMemberDescriptor.Kind kind3 = CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return new TypeAliasConstructorDescriptorImpl(this.D, k1(), T(), this, eVar, kind2, o0Var);
    }

    @Override // h.p2.b0.g.t.c.d1.j, h.p2.b0.g.t.c.k
    @d
    /* renamed from: i1 */
    public s0 b() {
        return k1();
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.d1.j
    @d
    /* renamed from: j1 */
    public f0 h0() {
        return (f0) super.h0();
    }

    @d
    public s0 k1() {
        return this.E;
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.v, h.p2.b0.g.t.c.q0
    @e
    /* renamed from: l1 */
    public f0 c(@d TypeSubstitutor typeSubstitutor) {
        v c2 = super.c(typeSubstitutor);
        Objects.requireNonNull(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = (TypeAliasConstructorDescriptorImpl) c2;
        c c3 = T().a().c(TypeSubstitutor.f(typeAliasConstructorDescriptorImpl.getReturnType()));
        if (c3 == null) {
            return null;
        }
        typeAliasConstructorDescriptorImpl.G = c3;
        return typeAliasConstructorDescriptorImpl;
    }
}
