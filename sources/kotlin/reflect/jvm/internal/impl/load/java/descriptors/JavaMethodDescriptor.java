package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.d1.d0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.e.a.u.g;
import h.p2.b0.g.t.e.a.u.h;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.b;
import h.p2.b0.g.t.n.z;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;

/* loaded from: classes3.dex */
public class JavaMethodDescriptor extends d0 implements h.p2.b0.g.t.e.a.u.a {
    public static final a.InterfaceC0434a<v0> F = new a();
    public static final /* synthetic */ boolean G = false;
    private ParameterNamesStatus D;
    private final boolean E;

    /* loaded from: classes3.dex */
    public enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }

        ParameterNamesStatus(boolean z, boolean z2) {
            this.isStable = z;
            this.isSynthesized = z2;
        }

        @d
        public static ParameterNamesStatus get(boolean z, boolean z2) {
            ParameterNamesStatus parameterNamesStatus;
            if (z) {
                parameterNamesStatus = z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED;
            } else {
                parameterNamesStatus = z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            }
            if (parameterNamesStatus == null) {
                $$$reportNull$$$0(0);
            }
            return parameterNamesStatus;
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements a.InterfaceC0434a<v0> {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaMethodDescriptor(@d k kVar, @e n0 n0Var, @d h.p2.b0.g.t.c.b1.e eVar, @d f fVar, @d CallableMemberDescriptor.Kind kind, @d o0 o0Var, boolean z) {
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
        this.D = null;
        this.E = z;
    }

    private static /* synthetic */ void A(int i2) {
        String str = (i2 == 12 || i2 == 17 || i2 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 12 || i2 == 17 || i2 == 20) ? 2 : 3];
        switch (i2) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i2 == 12) {
            objArr[1] = "initialize";
        } else if (i2 == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i2 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 12 && i2 != 17 && i2 != 20) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @d
    public static JavaMethodDescriptor l1(@d k kVar, @d h.p2.b0.g.t.c.b1.e eVar, @d f fVar, @d o0 o0Var, boolean z) {
        if (kVar == null) {
            A(5);
        }
        if (eVar == null) {
            A(6);
        }
        if (fVar == null) {
            A(7);
        }
        if (o0Var == null) {
            A(8);
        }
        return new JavaMethodDescriptor(kVar, null, eVar, fVar, CallableMemberDescriptor.Kind.DECLARATION, o0Var, z);
    }

    @Override // h.p2.b0.g.t.c.d1.o
    public boolean M0() {
        return this.D.isStable;
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.a
    public boolean e0() {
        return this.D.isSynthesized;
    }

    @Override // h.p2.b0.g.t.c.d1.d0
    @d
    public d0 k1(@e m0 m0Var, @e m0 m0Var2, @d List<? extends t0> list, @d List<v0> list2, @e z zVar, @e Modality modality, @d s sVar, @e Map<? extends a.InterfaceC0434a<?>, ?> map) {
        if (list == null) {
            A(9);
        }
        if (list2 == null) {
            A(10);
        }
        if (sVar == null) {
            A(11);
        }
        d0 k1 = super.k1(m0Var, m0Var2, list, list2, zVar, modality, sVar, map);
        b1(OperatorChecks.a.a(k1).a());
        if (k1 == null) {
            A(12);
        }
        return k1;
    }

    @Override // h.p2.b0.g.t.c.d1.d0, h.p2.b0.g.t.c.d1.o
    @d
    /* renamed from: m1 */
    public JavaMethodDescriptor H0(@d k kVar, @e v vVar, @d CallableMemberDescriptor.Kind kind, @e f fVar, @d h.p2.b0.g.t.c.b1.e eVar, @d o0 o0Var) {
        if (kVar == null) {
            A(13);
        }
        if (kind == null) {
            A(14);
        }
        if (eVar == null) {
            A(15);
        }
        if (o0Var == null) {
            A(16);
        }
        n0 n0Var = (n0) vVar;
        if (fVar == null) {
            fVar = getName();
        }
        JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(kVar, n0Var, eVar, fVar, kind, o0Var, this.E);
        javaMethodDescriptor.o1(M0(), e0());
        return javaMethodDescriptor;
    }

    @Override // h.p2.b0.g.t.e.a.u.a
    @d
    /* renamed from: n1 */
    public JavaMethodDescriptor Z(@e z zVar, @d List<h> list, @d z zVar2, @e Pair<a.InterfaceC0434a<?>, ?> pair) {
        if (list == null) {
            A(18);
        }
        if (zVar2 == null) {
            A(19);
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) x().b(g.a(list, h(), this)).l(zVar2).e(zVar == null ? null : b.f(this, zVar, h.p2.b0.g.t.c.b1.e.w0.b())).a().k().build();
        if (pair != null) {
            javaMethodDescriptor.Q0(pair.getFirst(), pair.getSecond());
        }
        if (javaMethodDescriptor == null) {
            A(20);
        }
        return javaMethodDescriptor;
    }

    public void o1(boolean z, boolean z2) {
        this.D = ParameterNamesStatus.get(z, z2);
    }
}
