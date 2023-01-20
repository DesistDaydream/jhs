package h.p2.b0.g.t.k;

import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.d1.a0;
import h.p2.b0.g.t.c.d1.b0;
import h.p2.b0.g.t.c.d1.c0;
import h.p2.b0.g.t.c.d1.d0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.n.z;
import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a extends h.p2.b0.g.t.c.d1.e {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d o0 o0Var, boolean z) {
            super(dVar, null, h.p2.b0.g.t.c.b1.e.w0.b(), true, CallableMemberDescriptor.Kind.DECLARATION, o0Var);
            if (dVar == null) {
                A(0);
            }
            if (o0Var == null) {
                A(1);
            }
            l1(Collections.emptyList(), c.k(dVar, z));
        }

        private static /* synthetic */ void A(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = MessageKey.MSG_SOURCE;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 12 || i2 == 23 || i2 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 12 || i2 == 23 || i2 == 25) ? 2 : 3];
        switch (i2) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = TUIConstants.TUIChat.OWNER;
                break;
        }
        if (i2 == 12) {
            objArr[1] = "createSetter";
        } else if (i2 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i2 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 12 && i2 != 23 && i2 != 25) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @k.e.a.d
    public static a0 b(@k.e.a.d j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        if (j0Var == null) {
            a(13);
        }
        if (eVar == null) {
            a(14);
        }
        return g(j0Var, eVar, true, false, false);
    }

    @k.e.a.d
    public static b0 c(@k.e.a.d j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar2) {
        if (j0Var == null) {
            a(0);
        }
        if (eVar == null) {
            a(1);
        }
        if (eVar2 == null) {
            a(2);
        }
        return k(j0Var, eVar, eVar2, true, false, false, j0Var.getSource());
    }

    @k.e.a.d
    public static n0 d(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (dVar == null) {
            a(24);
        }
        e.a aVar = h.p2.b0.g.t.c.b1.e.w0;
        d0 h1 = d0.h1(dVar, aVar.b(), h.p2.b0.g.t.b.g.f15025c, CallableMemberDescriptor.Kind.SYNTHESIZED, dVar.getSource());
        d0 N0 = h1.N0(null, null, Collections.emptyList(), Collections.singletonList(new ValueParameterDescriptorImpl(h1, null, 0, aVar.b(), h.p2.b0.g.t.g.f.f("value"), DescriptorUtilsKt.g(dVar).V(), false, false, false, null, dVar.getSource())), dVar.r(), Modality.FINAL, r.f15211e);
        if (N0 == null) {
            a(25);
        }
        return N0;
    }

    @k.e.a.d
    public static n0 e(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (dVar == null) {
            a(22);
        }
        d0 N0 = d0.h1(dVar, h.p2.b0.g.t.c.b1.e.w0.b(), h.p2.b0.g.t.b.g.b, CallableMemberDescriptor.Kind.SYNTHESIZED, dVar.getSource()).N0(null, null, Collections.emptyList(), Collections.emptyList(), DescriptorUtilsKt.g(dVar).l(Variance.INVARIANT, dVar.r()), Modality.FINAL, r.f15211e);
        if (N0 == null) {
            a(23);
        }
        return N0;
    }

    @k.e.a.e
    public static m0 f(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.e z zVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        if (aVar == null) {
            a(29);
        }
        if (eVar == null) {
            a(30);
        }
        if (zVar == null) {
            return null;
        }
        return new c0(aVar, new h.p2.b0.g.t.k.r.i.b(aVar, zVar, null), eVar);
    }

    @k.e.a.d
    public static a0 g(@k.e.a.d j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, boolean z2, boolean z3) {
        if (j0Var == null) {
            a(15);
        }
        if (eVar == null) {
            a(16);
        }
        return h(j0Var, eVar, z, z2, z3, j0Var.getSource());
    }

    @k.e.a.d
    public static a0 h(@k.e.a.d j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, boolean z2, boolean z3, @k.e.a.d o0 o0Var) {
        if (j0Var == null) {
            a(17);
        }
        if (eVar == null) {
            a(18);
        }
        if (o0Var == null) {
            a(19);
        }
        return new a0(j0Var, eVar, j0Var.t(), j0Var.getVisibility(), z, z2, z3, CallableMemberDescriptor.Kind.DECLARATION, null, o0Var);
    }

    @k.e.a.d
    public static h.p2.b0.g.t.c.d1.e i(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d o0 o0Var) {
        if (dVar == null) {
            a(20);
        }
        if (o0Var == null) {
            a(21);
        }
        return new a(dVar, o0Var, false);
    }

    @k.e.a.d
    public static b0 j(@k.e.a.d j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar2, boolean z, boolean z2, boolean z3, @k.e.a.d s sVar, @k.e.a.d o0 o0Var) {
        if (j0Var == null) {
            a(7);
        }
        if (eVar == null) {
            a(8);
        }
        if (eVar2 == null) {
            a(9);
        }
        if (sVar == null) {
            a(10);
        }
        if (o0Var == null) {
            a(11);
        }
        b0 b0Var = new b0(j0Var, eVar, j0Var.t(), sVar, z, z2, z3, CallableMemberDescriptor.Kind.DECLARATION, null, o0Var);
        b0Var.N0(b0.L0(b0Var, j0Var.getType(), eVar2));
        return b0Var;
    }

    @k.e.a.d
    public static b0 k(@k.e.a.d j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar2, boolean z, boolean z2, boolean z3, @k.e.a.d o0 o0Var) {
        if (j0Var == null) {
            a(3);
        }
        if (eVar == null) {
            a(4);
        }
        if (eVar2 == null) {
            a(5);
        }
        if (o0Var == null) {
            a(6);
        }
        return j(j0Var, eVar, eVar2, z, z2, z3, j0Var.getVisibility(), o0Var);
    }

    private static boolean l(@k.e.a.d v vVar) {
        if (vVar == null) {
            a(28);
        }
        return vVar.i() == CallableMemberDescriptor.Kind.SYNTHESIZED && c.A(vVar.b());
    }

    public static boolean m(@k.e.a.d v vVar) {
        if (vVar == null) {
            a(27);
        }
        return vVar.getName().equals(h.p2.b0.g.t.b.g.f15025c) && l(vVar);
    }

    public static boolean n(@k.e.a.d v vVar) {
        if (vVar == null) {
            a(26);
        }
        return vVar.getName().equals(h.p2.b0.g.t.b.g.b) && l(vVar);
    }
}
