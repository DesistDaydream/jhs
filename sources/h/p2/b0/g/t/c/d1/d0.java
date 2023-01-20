package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes3.dex */
public class d0 extends o implements n0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.e n0 n0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d o0 o0Var) {
        super(kVar, n0Var, eVar, fVar, kind, o0Var);
        if (kVar == null) {
            A(0);
        }
        if (eVar == null) {
            A(1);
        }
        if (fVar == null) {
            A(2);
        }
        if (kind == null) {
            A(3);
        }
        if (o0Var == null) {
            A(4);
        }
    }

    private static /* synthetic */ void A(int i2) {
        String str = (i2 == 13 || i2 == 17 || i2 == 18 || i2 == 23 || i2 == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 13 || i2 == 17 || i2 == 18 || i2 == 23 || i2 == 24) ? 2 : 3];
        switch (i2) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        if (i2 == 13 || i2 == 17) {
            objArr[1] = "initialize";
        } else if (i2 == 18) {
            objArr[1] = "getOriginal";
        } else if (i2 == 23) {
            objArr[1] = "copy";
        } else if (i2 != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 13 && i2 != 17 && i2 != 18 && i2 != 23 && i2 != 24) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @k.e.a.d
    public static d0 h1(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d o0 o0Var) {
        if (kVar == null) {
            A(5);
        }
        if (eVar == null) {
            A(6);
        }
        if (fVar == null) {
            A(7);
        }
        if (kind == null) {
            A(8);
        }
        if (o0Var == null) {
            A(9);
        }
        return new d0(kVar, null, eVar, fVar, kind, o0Var);
    }

    @Override // h.p2.b0.g.t.c.d1.o
    @k.e.a.d
    public o H0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.e h.p2.b0.g.t.c.v vVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.e h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d o0 o0Var) {
        if (kVar == null) {
            A(19);
        }
        if (kind == null) {
            A(20);
        }
        if (eVar == null) {
            A(21);
        }
        if (o0Var == null) {
            A(22);
        }
        n0 n0Var = (n0) vVar;
        if (fVar == null) {
            fVar = getName();
        }
        return new d0(kVar, n0Var, eVar, fVar, kind, o0Var);
    }

    @Override // h.p2.b0.g.t.c.d1.o, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @k.e.a.d
    /* renamed from: g1 */
    public n0 P(h.p2.b0.g.t.c.k kVar, Modality modality, h.p2.b0.g.t.c.s sVar, CallableMemberDescriptor.Kind kind, boolean z) {
        n0 n0Var = (n0) super.P(kVar, modality, sVar, kind, z);
        if (n0Var == null) {
            A(23);
        }
        return n0Var;
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.d1.j
    @k.e.a.d
    /* renamed from: i1 */
    public n0 h0() {
        n0 n0Var = (n0) super.h0();
        if (n0Var == null) {
            A(18);
        }
        return n0Var;
    }

    @Override // h.p2.b0.g.t.c.d1.o
    @k.e.a.d
    /* renamed from: j1 */
    public d0 N0(@k.e.a.e m0 m0Var, @k.e.a.e m0 m0Var2, @k.e.a.d List<? extends t0> list, @k.e.a.d List<v0> list2, @k.e.a.e h.p2.b0.g.t.n.z zVar, @k.e.a.e Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar) {
        if (list == null) {
            A(10);
        }
        if (list2 == null) {
            A(11);
        }
        if (sVar == null) {
            A(12);
        }
        d0 k1 = k1(m0Var, m0Var2, list, list2, zVar, modality, sVar, null);
        if (k1 == null) {
            A(13);
        }
        return k1;
    }

    @k.e.a.d
    public d0 k1(@k.e.a.e m0 m0Var, @k.e.a.e m0 m0Var2, @k.e.a.d List<? extends t0> list, @k.e.a.d List<v0> list2, @k.e.a.e h.p2.b0.g.t.n.z zVar, @k.e.a.e Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar, @k.e.a.e Map<? extends a.InterfaceC0434a<?>, ?> map) {
        if (list == null) {
            A(14);
        }
        if (list2 == null) {
            A(15);
        }
        if (sVar == null) {
            A(16);
        }
        super.N0(m0Var, m0Var2, list, list2, zVar, modality, sVar);
        if (map != null && !map.isEmpty()) {
            this.C = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.v, h.p2.b0.g.t.c.n0
    @k.e.a.d
    public v.a<? extends n0> x() {
        v.a x = super.x();
        if (x == null) {
            A(24);
        }
        return x;
    }
}
