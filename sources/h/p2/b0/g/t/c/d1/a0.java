package h.p2.b0.g.t.c.d1;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.v0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes3.dex */
public class a0 extends y implements k0 {
    private h.p2.b0.g.t.n.z n;
    @k.e.a.d
    private final k0 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a0(@k.e.a.d j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar, boolean z, boolean z2, boolean z3, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.e k0 k0Var, @k.e.a.d o0 o0Var) {
        super(modality, sVar, j0Var, eVar, h.p2.b0.g.t.g.f.i("<get-" + j0Var.getName() + SimpleComparison.GREATER_THAN_OPERATION), z, z2, z3, kind, o0Var);
        a0 a0Var;
        a0 a0Var2;
        if (j0Var == null) {
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
        if (kind == null) {
            A(4);
        }
        if (o0Var == null) {
            A(5);
        }
        if (k0Var != 0) {
            a0Var2 = this;
            a0Var = k0Var;
        } else {
            a0Var = this;
            a0Var2 = a0Var;
        }
        a0Var2.o = a0Var;
    }

    private static /* synthetic */ void A(int i2) {
        String str = (i2 == 6 || i2 == 7 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 6 || i2 == 7 || i2 == 8) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i2 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i2 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i2 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i2 != 6 && i2 != 7 && i2 != 8) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 6 && i2 != 7 && i2 != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.g(this, d2);
    }

    @Override // h.p2.b0.g.t.c.d1.y, h.p2.b0.g.t.c.d1.j
    @k.e.a.d
    /* renamed from: L0 */
    public k0 h0() {
        k0 k0Var = this.o;
        if (k0Var == null) {
            A(8);
        }
        return k0Var;
    }

    public void M0(h.p2.b0.g.t.n.z zVar) {
        if (zVar == null) {
            zVar = V().getType();
        }
        this.n = zVar;
    }

    @Override // h.p2.b0.g.t.c.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, h.p2.b0.g.t.c.a
    @k.e.a.d
    public Collection<? extends k0> d() {
        Collection<h.p2.b0.g.t.c.i0> H0 = super.H0(true);
        if (H0 == null) {
            A(6);
        }
        return H0;
    }

    @Override // h.p2.b0.g.t.c.a
    public h.p2.b0.g.t.n.z getReturnType() {
        return this.n;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public List<v0> h() {
        List<v0> emptyList = Collections.emptyList();
        if (emptyList == null) {
            A(7);
        }
        return emptyList;
    }
}
