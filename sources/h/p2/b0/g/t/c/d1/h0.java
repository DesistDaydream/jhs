package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.x0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class h0 extends j implements x0 {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f15113f = false;

    /* renamed from: e  reason: collision with root package name */
    public h.p2.b0.g.t.n.z f15114e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.e h.p2.b0.g.t.n.z zVar, @k.e.a.d o0 o0Var) {
        super(kVar, eVar, fVar, o0Var);
        if (kVar == null) {
            A(0);
        }
        if (eVar == null) {
            A(1);
        }
        if (fVar == null) {
            A(2);
        }
        if (o0Var == null) {
            A(3);
        }
        this.f15114e = zVar;
    }

    private static /* synthetic */ void A(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // h.p2.b0.g.t.c.d1.j
    @k.e.a.d
    /* renamed from: C0 */
    public x0 h0() {
        x0 x0Var = (x0) super.a();
        if (x0Var == null) {
            A(5);
        }
        return x0Var;
    }

    public void G0(h.p2.b0.g.t.n.z zVar) {
        this.f15114e = zVar;
    }

    @Override // h.p2.b0.g.t.c.a
    public m0 M() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.a
    public m0 Q() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public Collection<? extends h.p2.b0.g.t.c.a> d() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            A(7);
        }
        return emptySet;
    }

    @Override // h.p2.b0.g.t.c.a
    public boolean e0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public h.p2.b0.g.t.n.z getReturnType() {
        h.p2.b0.g.t.n.z type = getType();
        if (type == null) {
            A(9);
        }
        return type;
    }

    @Override // h.p2.b0.g.t.c.u0
    @k.e.a.d
    public h.p2.b0.g.t.n.z getType() {
        h.p2.b0.g.t.n.z zVar = this.f15114e;
        if (zVar == null) {
            A(4);
        }
        return zVar;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public List<t0> getTypeParameters() {
        List<t0> emptyList = Collections.emptyList();
        if (emptyList == null) {
            A(8);
        }
        return emptyList;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public List<v0> h() {
        List<v0> emptyList = Collections.emptyList();
        if (emptyList == null) {
            A(6);
        }
        return emptyList;
    }

    @Override // h.p2.b0.g.t.c.x0
    public boolean isConst() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public <V> V s0(a.InterfaceC0434a<V> interfaceC0434a) {
        return null;
    }
}
