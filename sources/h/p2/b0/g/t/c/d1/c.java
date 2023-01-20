package h.p2.b0.g.t.c.d1;

import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public abstract class c extends i implements m0 {

    /* renamed from: c  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.f f15089c = h.p2.b0.g.t.g.f.i("<this>");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        super(eVar, f15089c);
        if (eVar == null) {
            A(0);
        }
    }

    private static /* synthetic */ void A(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i2) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.l(this, d2);
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public m0 M() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public m0 Q() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public Collection<? extends h.p2.b0.g.t.c.a> d() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            A(5);
        }
        return emptySet;
    }

    @Override // h.p2.b0.g.t.c.a
    public boolean e0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public h.p2.b0.g.t.n.z getReturnType() {
        return getType();
    }

    @Override // h.p2.b0.g.t.c.n
    @k.e.a.d
    public o0 getSource() {
        o0 o0Var = o0.a;
        if (o0Var == null) {
            A(8);
        }
        return o0Var;
    }

    @Override // h.p2.b0.g.t.c.u0
    @k.e.a.d
    public h.p2.b0.g.t.n.z getType() {
        h.p2.b0.g.t.n.z type = getValue().getType();
        if (type == null) {
            A(3);
        }
        return type;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public List<t0> getTypeParameters() {
        List<t0> emptyList = Collections.emptyList();
        if (emptyList == null) {
            A(2);
        }
        return emptyList;
    }

    @Override // h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @k.e.a.d
    public h.p2.b0.g.t.c.s getVisibility() {
        h.p2.b0.g.t.c.s sVar = h.p2.b0.g.t.c.r.f15212f;
        if (sVar == null) {
            A(6);
        }
        return sVar;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public List<v0> h() {
        List<v0> emptyList = Collections.emptyList();
        if (emptyList == null) {
            A(4);
        }
        return emptyList;
    }

    @Override // h.p2.b0.g.t.c.d1.i, h.p2.b0.g.t.c.k
    @k.e.a.d
    /* renamed from: h0 */
    public h.p2.b0.g.t.c.g0 a() {
        return this;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public <V> V s0(a.InterfaceC0434a<V> interfaceC0434a) {
        return null;
    }

    @Override // h.p2.b0.g.t.c.m0, h.p2.b0.g.t.c.q0
    @k.e.a.e
    public m0 c(@k.e.a.d TypeSubstitutor typeSubstitutor) {
        h.p2.b0.g.t.n.z p;
        if (typeSubstitutor == null) {
            A(1);
        }
        if (typeSubstitutor.k()) {
            return this;
        }
        if (b() instanceof h.p2.b0.g.t.c.d) {
            p = typeSubstitutor.p(getType(), Variance.OUT_VARIANCE);
        } else {
            p = typeSubstitutor.p(getType(), Variance.INVARIANT);
        }
        if (p == null) {
            return null;
        }
        return p == getType() ? this : new c0(b(), new h.p2.b0.g.t.k.r.i.h(p), getAnnotations());
    }
}
