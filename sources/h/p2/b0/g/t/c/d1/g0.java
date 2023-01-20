package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r0;
import h.p2.b0.g.t.c.t0;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public class g0 extends d {
    @k.e.a.e

    /* renamed from: k  reason: collision with root package name */
    private final h.k2.u.l<h.p2.b0.g.t.n.z, Void> f15110k;

    /* renamed from: l  reason: collision with root package name */
    private final List<h.p2.b0.g.t.n.z> f15111l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f15112m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private g0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, @k.e.a.d Variance variance, @k.e.a.d h.p2.b0.g.t.g.f fVar, int i2, @k.e.a.d o0 o0Var, @k.e.a.e h.k2.u.l<h.p2.b0.g.t.n.z, Void> lVar, @k.e.a.d r0 r0Var, @k.e.a.d h.p2.b0.g.t.m.m mVar) {
        super(mVar, kVar, eVar, fVar, variance, z, i2, o0Var, r0Var);
        if (kVar == null) {
            A(19);
        }
        if (eVar == null) {
            A(20);
        }
        if (variance == null) {
            A(21);
        }
        if (fVar == null) {
            A(22);
        }
        if (o0Var == null) {
            A(23);
        }
        if (r0Var == null) {
            A(24);
        }
        if (mVar == null) {
            A(25);
        }
        this.f15111l = new ArrayList(1);
        this.f15112m = false;
        this.f15110k = lVar;
    }

    private static /* synthetic */ void A(int i2) {
        String str = (i2 == 5 || i2 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 5 || i2 == 28) ? 2 : 3];
        switch (i2) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i2 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i2 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i2) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 5 && i2 != 28) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    private void J0() {
        if (this.f15112m) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + P0());
    }

    private void K0() {
        if (this.f15112m) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + P0());
        }
    }

    public static g0 L0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, @k.e.a.d Variance variance, @k.e.a.d h.p2.b0.g.t.g.f fVar, int i2, @k.e.a.d o0 o0Var, @k.e.a.e h.k2.u.l<h.p2.b0.g.t.n.z, Void> lVar, @k.e.a.d r0 r0Var, @k.e.a.d h.p2.b0.g.t.m.m mVar) {
        if (kVar == null) {
            A(12);
        }
        if (eVar == null) {
            A(13);
        }
        if (variance == null) {
            A(14);
        }
        if (fVar == null) {
            A(15);
        }
        if (o0Var == null) {
            A(16);
        }
        if (r0Var == null) {
            A(17);
        }
        if (mVar == null) {
            A(18);
        }
        return new g0(kVar, eVar, z, variance, fVar, i2, o0Var, lVar, r0Var, mVar);
    }

    public static g0 M0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, @k.e.a.d Variance variance, @k.e.a.d h.p2.b0.g.t.g.f fVar, int i2, @k.e.a.d o0 o0Var, @k.e.a.d h.p2.b0.g.t.m.m mVar) {
        if (kVar == null) {
            A(6);
        }
        if (eVar == null) {
            A(7);
        }
        if (variance == null) {
            A(8);
        }
        if (fVar == null) {
            A(9);
        }
        if (o0Var == null) {
            A(10);
        }
        if (mVar == null) {
            A(11);
        }
        return L0(kVar, eVar, z, variance, fVar, i2, o0Var, null, r0.a.a, mVar);
    }

    @k.e.a.d
    public static t0 N0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, @k.e.a.d Variance variance, @k.e.a.d h.p2.b0.g.t.g.f fVar, int i2, @k.e.a.d h.p2.b0.g.t.m.m mVar) {
        if (kVar == null) {
            A(0);
        }
        if (eVar == null) {
            A(1);
        }
        if (variance == null) {
            A(2);
        }
        if (fVar == null) {
            A(3);
        }
        if (mVar == null) {
            A(4);
        }
        g0 M0 = M0(kVar, eVar, z, variance, fVar, i2, o0.a, mVar);
        M0.I0(DescriptorUtilsKt.g(kVar).y());
        M0.Q0();
        if (M0 == null) {
            A(5);
        }
        return M0;
    }

    private void O0(h.p2.b0.g.t.n.z zVar) {
        if (h.p2.b0.g.t.n.a0.a(zVar)) {
            return;
        }
        this.f15111l.add(zVar);
    }

    private String P0() {
        return getName() + " declared in " + h.p2.b0.g.t.k.c.m(b());
    }

    @Override // h.p2.b0.g.t.c.d1.d
    public void G0(@k.e.a.d h.p2.b0.g.t.n.z zVar) {
        if (zVar == null) {
            A(27);
        }
        h.k2.u.l<h.p2.b0.g.t.n.z, Void> lVar = this.f15110k;
        if (lVar == null) {
            return;
        }
        lVar.invoke(zVar);
    }

    @Override // h.p2.b0.g.t.c.d1.d
    @k.e.a.d
    public List<h.p2.b0.g.t.n.z> H0() {
        J0();
        List<h.p2.b0.g.t.n.z> list = this.f15111l;
        if (list == null) {
            A(28);
        }
        return list;
    }

    public void I0(@k.e.a.d h.p2.b0.g.t.n.z zVar) {
        if (zVar == null) {
            A(26);
        }
        K0();
        O0(zVar);
    }

    public void Q0() {
        K0();
        this.f15112m = true;
    }
}
