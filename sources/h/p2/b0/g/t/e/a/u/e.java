package h.p2.b0.g.t.e.a.u;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.d1.a0;
import h.p2.b0.g.t.c.d1.b0;
import h.p2.b0.g.t.c.d1.z;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.l0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.e.a.y.o;
import h.p2.b0.g.t.m.i;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes3.dex */
public class e extends z implements a {
    private final boolean C;
    @k.e.a.e
    private final Pair<a.InterfaceC0434a<?>, ?> D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@k.e.a.d k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d Modality modality, @k.e.a.d s sVar, boolean z, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d o0 o0Var, @k.e.a.e j0 j0Var, @k.e.a.d CallableMemberDescriptor.Kind kind, boolean z2, @k.e.a.e Pair<a.InterfaceC0434a<?>, ?> pair) {
        super(kVar, j0Var, eVar, modality, sVar, z, fVar, kind, o0Var, false, false, false, false, false, false);
        if (kVar == null) {
            A(0);
        }
        if (eVar == null) {
            A(1);
        }
        if (modality == null) {
            A(2);
        }
        if (sVar == null) {
            A(3);
        }
        if (fVar == null) {
            A(4);
        }
        if (o0Var == null) {
            A(5);
        }
        if (kind == null) {
            A(6);
        }
        this.C = z2;
        this.D = pair;
    }

    private static /* synthetic */ void A(int i2) {
        String str = i2 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 21 ? 3 : 2];
        switch (i2) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        if (i2 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 == 21) {
            throw new IllegalStateException(format);
        }
    }

    @k.e.a.d
    public static e Y0(@k.e.a.d k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d Modality modality, @k.e.a.d s sVar, boolean z, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d o0 o0Var, boolean z2) {
        if (kVar == null) {
            A(7);
        }
        if (eVar == null) {
            A(8);
        }
        if (modality == null) {
            A(9);
        }
        if (sVar == null) {
            A(10);
        }
        if (fVar == null) {
            A(11);
        }
        if (o0Var == null) {
            A(12);
        }
        return new e(kVar, eVar, modality, sVar, z, fVar, o0Var, null, CallableMemberDescriptor.Kind.DECLARATION, z2, null);
    }

    @Override // h.p2.b0.g.t.c.d1.z
    @k.e.a.d
    public z L0(@k.e.a.d k kVar, @k.e.a.d Modality modality, @k.e.a.d s sVar, @k.e.a.e j0 j0Var, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d o0 o0Var) {
        if (kVar == null) {
            A(13);
        }
        if (modality == null) {
            A(14);
        }
        if (sVar == null) {
            A(15);
        }
        if (kind == null) {
            A(16);
        }
        if (fVar == null) {
            A(17);
        }
        if (o0Var == null) {
            A(18);
        }
        return new e(kVar, getAnnotations(), modality, sVar, O(), fVar, o0Var, j0Var, kind, this.C, this.D);
    }

    @Override // h.p2.b0.g.t.e.a.u.a
    @k.e.a.d
    public a Z(@k.e.a.e h.p2.b0.g.t.n.z zVar, @k.e.a.d List<h> list, @k.e.a.d h.p2.b0.g.t.n.z zVar2, @k.e.a.e Pair<a.InterfaceC0434a<?>, ?> pair) {
        a0 a0Var;
        b0 b0Var;
        if (list == null) {
            A(19);
        }
        if (zVar2 == null) {
            A(20);
        }
        j0 h0 = h0() == this ? null : h0();
        e eVar = new e(b(), getAnnotations(), t(), getVisibility(), O(), getName(), getSource(), h0, i(), this.C, pair);
        a0 getter = getGetter();
        if (getter != null) {
            a0Var = r15;
            a0 a0Var2 = new a0(eVar, getter.getAnnotations(), getter.t(), getter.getVisibility(), getter.G(), getter.isExternal(), getter.isInline(), i(), h0 == null ? null : h0.getGetter(), getter.getSource());
            a0Var.J0(getter.q0());
            a0Var.M0(zVar2);
        } else {
            a0Var = null;
        }
        l0 setter = getSetter();
        if (setter != null) {
            b0 b0Var2 = new b0(eVar, setter.getAnnotations(), setter.t(), setter.getVisibility(), setter.G(), setter.isExternal(), setter.isInline(), i(), h0 == null ? null : h0.getSetter(), setter.getSource());
            b0Var2.J0(b0Var2.q0());
            b0Var2.N0(setter.h().get(0));
            b0Var = b0Var2;
        } else {
            b0Var = null;
        }
        eVar.R0(a0Var, b0Var, u0(), R());
        eVar.V0(S0());
        i<h.p2.b0.g.t.k.n.g<?>> iVar = this.f15117h;
        if (iVar != null) {
            eVar.H0(iVar);
        }
        eVar.A0(d());
        eVar.W0(zVar2, getTypeParameters(), M(), zVar == null ? null : h.p2.b0.g.t.k.b.f(this, zVar, h.p2.b0.g.t.c.b1.e.w0.b()));
        return eVar;
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.a
    public boolean e0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d1.z, h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.x0
    public boolean isConst() {
        h.p2.b0.g.t.n.z type = getType();
        return this.C && h.p2.b0.g.t.c.h.a(type) && (!o.i(type) || h.p2.b0.g.t.b.f.s0(type));
    }

    @Override // h.p2.b0.g.t.c.d1.z, h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.a
    @k.e.a.e
    public <V> V s0(a.InterfaceC0434a<V> interfaceC0434a) {
        Pair<a.InterfaceC0434a<?>, ?> pair = this.D;
        if (pair == null || !pair.getFirst().equals(interfaceC0434a)) {
            return null;
        }
        return (V) this.D.getSecond();
    }
}
