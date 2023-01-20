package h.p2.b0.g.t.c.d1;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.l0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.v0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public class b0 extends y implements l0 {
    public static final /* synthetic */ boolean p = false;
    private v0 n;
    @k.e.a.d
    private final l0 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b0(@k.e.a.d j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar, boolean z, boolean z2, boolean z3, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.e l0 l0Var, @k.e.a.d o0 o0Var) {
        super(modality, sVar, j0Var, eVar, h.p2.b0.g.t.g.f.i("<set-" + j0Var.getName() + SimpleComparison.GREATER_THAN_OPERATION), z, z2, z3, kind, o0Var);
        b0 b0Var;
        b0 b0Var2;
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
        if (l0Var != 0) {
            b0Var2 = this;
            b0Var = l0Var;
        } else {
            b0Var = this;
            b0Var2 = b0Var;
        }
        b0Var2.o = b0Var;
    }

    private static /* synthetic */ void A(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i2) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i2) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static ValueParameterDescriptorImpl L0(@k.e.a.d l0 l0Var, @k.e.a.d h.p2.b0.g.t.n.z zVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        if (l0Var == null) {
            A(7);
        }
        if (zVar == null) {
            A(8);
        }
        if (eVar == null) {
            A(9);
        }
        return new ValueParameterDescriptorImpl(l0Var, null, 0, eVar, h.p2.b0.g.t.g.f.i("<set-?>"), zVar, false, false, false, null, o0.a);
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.e(this, d2);
    }

    @Override // h.p2.b0.g.t.c.d1.y, h.p2.b0.g.t.c.d1.j
    @k.e.a.d
    /* renamed from: M0 */
    public l0 h0() {
        l0 l0Var = this.o;
        if (l0Var == null) {
            A(13);
        }
        return l0Var;
    }

    public void N0(@k.e.a.d v0 v0Var) {
        if (v0Var == null) {
            A(6);
        }
        this.n = v0Var;
    }

    @Override // h.p2.b0.g.t.c.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, h.p2.b0.g.t.c.a
    @k.e.a.d
    public Collection<? extends l0> d() {
        Collection<h.p2.b0.g.t.c.i0> H0 = super.H0(false);
        if (H0 == null) {
            A(10);
        }
        return H0;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public h.p2.b0.g.t.n.z getReturnType() {
        h.p2.b0.g.t.n.f0 Y = DescriptorUtilsKt.g(this).Y();
        if (Y == null) {
            A(12);
        }
        return Y;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public List<v0> h() {
        v0 v0Var = this.n;
        if (v0Var != null) {
            List<v0> singletonList = Collections.singletonList(v0Var);
            if (singletonList == null) {
                A(11);
            }
            return singletonList;
        }
        throw new IllegalStateException();
    }
}
