package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.k;
import h.k2.v.u;
import h.p2.b0.g.t.c.d1.h0;
import h.p2.b0.g.t.c.m;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.x0;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.n.g;
import h.p2.b0.g.t.n.z;
import h.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes3.dex */
public class ValueParameterDescriptorImpl extends h0 implements v0 {
    @d

    /* renamed from: m  reason: collision with root package name */
    public static final a f16471m = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private final int f16472g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f16473h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f16474i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f16475j;
    @e

    /* renamed from: k  reason: collision with root package name */
    private final z f16476k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final v0 f16477l;

    /* loaded from: classes3.dex */
    public static final class WithDestructuringDeclaration extends ValueParameterDescriptorImpl {
        @d
        private final w n;

        public WithDestructuringDeclaration(@d h.p2.b0.g.t.c.a aVar, @e v0 v0Var, int i2, @d h.p2.b0.g.t.c.b1.e eVar, @d f fVar, @d z zVar, boolean z, boolean z2, boolean z3, @e z zVar2, @d o0 o0Var, @d h.k2.u.a<? extends List<? extends x0>> aVar2) {
            super(aVar, v0Var, i2, eVar, fVar, zVar, z, z2, z3, zVar2, o0Var);
            this.n = h.z.c(aVar2);
        }

        @d
        public final List<x0> K0() {
            return (List) this.n.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl, h.p2.b0.g.t.c.v0
        @d
        public v0 Y(@d h.p2.b0.g.t.c.a aVar, @d f fVar, int i2) {
            return new WithDestructuringDeclaration(aVar, null, i2, getAnnotations(), fVar, getType(), x0(), p0(), n0(), t0(), o0.a, new ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(this));
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        @d
        public final ValueParameterDescriptorImpl a(@d h.p2.b0.g.t.c.a aVar, @e v0 v0Var, int i2, @d h.p2.b0.g.t.c.b1.e eVar, @d f fVar, @d z zVar, boolean z, boolean z2, boolean z3, @e z zVar2, @d o0 o0Var, @e h.k2.u.a<? extends List<? extends x0>> aVar2) {
            if (aVar2 == null) {
                return new ValueParameterDescriptorImpl(aVar, v0Var, i2, eVar, fVar, zVar, z, z2, z3, zVar2, o0Var);
            }
            return new WithDestructuringDeclaration(aVar, v0Var, i2, eVar, fVar, zVar, z, z2, z3, zVar2, o0Var, aVar2);
        }
    }

    public ValueParameterDescriptorImpl(@d h.p2.b0.g.t.c.a aVar, @e v0 v0Var, int i2, @d h.p2.b0.g.t.c.b1.e eVar, @d f fVar, @d z zVar, boolean z, boolean z2, boolean z3, @e z zVar2, @d o0 o0Var) {
        super(aVar, eVar, fVar, zVar, o0Var);
        this.f16472g = i2;
        this.f16473h = z;
        this.f16474i = z2;
        this.f16475j = z3;
        this.f16476k = zVar2;
        this.f16477l = v0Var == null ? this : v0Var;
    }

    @k
    @d
    public static final ValueParameterDescriptorImpl H0(@d h.p2.b0.g.t.c.a aVar, @e v0 v0Var, int i2, @d h.p2.b0.g.t.c.b1.e eVar, @d f fVar, @d z zVar, boolean z, boolean z2, boolean z3, @e z zVar2, @d o0 o0Var, @e h.k2.u.a<? extends List<? extends x0>> aVar2) {
        return f16471m.a(aVar, v0Var, i2, eVar, fVar, zVar, z, z2, z3, zVar2, o0Var, aVar2);
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(@d m<R, D> mVar, D d2) {
        return mVar.f(this, d2);
    }

    @e
    public Void I0() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.q0
    @d
    /* renamed from: J0 */
    public v0 c(@d TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // h.p2.b0.g.t.c.x0
    public boolean O() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.v0
    @d
    public v0 Y(@d h.p2.b0.g.t.c.a aVar, @d f fVar, int i2) {
        return new ValueParameterDescriptorImpl(aVar, null, i2, getAnnotations(), fVar, getType(), x0(), p0(), n0(), t0(), o0.a);
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.a
    @d
    public Collection<v0> d() {
        Collection<? extends h.p2.b0.g.t.c.a> d2 = b().d();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(d2, 10));
        for (h.p2.b0.g.t.c.a aVar : d2) {
            arrayList.add(aVar.h().get(f()));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.c.v0
    public int f() {
        return this.f16472g;
    }

    @Override // h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @d
    public s getVisibility() {
        return r.f15212f;
    }

    @Override // h.p2.b0.g.t.c.x0
    public /* bridge */ /* synthetic */ g m0() {
        return (g) I0();
    }

    @Override // h.p2.b0.g.t.c.v0
    public boolean n0() {
        return this.f16475j;
    }

    @Override // h.p2.b0.g.t.c.v0
    public boolean p0() {
        return this.f16474i;
    }

    @Override // h.p2.b0.g.t.c.v0
    @e
    public z t0() {
        return this.f16476k;
    }

    @Override // h.p2.b0.g.t.c.x0
    public boolean v0() {
        return v0.a.a(this);
    }

    @Override // h.p2.b0.g.t.c.v0
    public boolean x0() {
        return this.f16473h && ((CallableMemberDescriptor) b()).i().isReal();
    }

    @Override // h.p2.b0.g.t.c.d1.j, h.p2.b0.g.t.c.k
    @d
    public h.p2.b0.g.t.c.a b() {
        return (h.p2.b0.g.t.c.a) super.b();
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.d1.j
    @d
    /* renamed from: a */
    public v0 h0() {
        v0 v0Var = this.f16477l;
        return v0Var == this ? this : v0Var.a();
    }
}
