package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes3.dex */
public abstract class y extends j implements h.p2.b0.g.t.c.i0 {

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ boolean f15163m = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15164e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15165f;

    /* renamed from: g  reason: collision with root package name */
    private final Modality f15166g;

    /* renamed from: h  reason: collision with root package name */
    private final j0 f15167h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f15168i;

    /* renamed from: j  reason: collision with root package name */
    private final CallableMemberDescriptor.Kind f15169j;

    /* renamed from: k  reason: collision with root package name */
    private h.p2.b0.g.t.c.s f15170k;
    @k.e.a.e

    /* renamed from: l  reason: collision with root package name */
    private h.p2.b0.g.t.c.v f15171l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@k.e.a.d Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar, @k.e.a.d j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, boolean z, boolean z2, boolean z3, CallableMemberDescriptor.Kind kind, @k.e.a.d o0 o0Var) {
        super(j0Var.b(), eVar, fVar, o0Var);
        if (modality == null) {
            A(0);
        }
        if (sVar == null) {
            A(1);
        }
        if (j0Var == null) {
            A(2);
        }
        if (eVar == null) {
            A(3);
        }
        if (fVar == null) {
            A(4);
        }
        if (o0Var == null) {
            A(5);
        }
        this.f15171l = null;
        this.f15166g = modality;
        this.f15170k = sVar;
        this.f15167h = j0Var;
        this.f15164e = z;
        this.f15165f = z2;
        this.f15168i = z3;
        this.f15169j = kind;
    }

    private static /* synthetic */ void A(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i3 = 2;
                break;
            case 7:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i2) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            case 7:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void A0(@k.e.a.d Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            A(14);
        }
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean B0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @k.e.a.d
    /* renamed from: C0 */
    public h.p2.b0.g.t.c.i0 P(h.p2.b0.g.t.c.k kVar, Modality modality, h.p2.b0.g.t.c.s sVar, CallableMemberDescriptor.Kind kind, boolean z) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean D() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.i0
    public boolean G() {
        return this.f15164e;
    }

    @Override // h.p2.b0.g.t.c.d1.j
    @k.e.a.d
    /* renamed from: G0 */
    public abstract h.p2.b0.g.t.c.i0 h0();

    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.i0> H0(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (j0 j0Var : V().d()) {
            h.p2.b0.g.t.c.a0 getter = z ? j0Var.getGetter() : j0Var.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    public void I0(boolean z) {
        this.f15164e = z;
    }

    public void J0(@k.e.a.e h.p2.b0.g.t.c.v vVar) {
        this.f15171l = vVar;
    }

    public void K0(h.p2.b0.g.t.c.s sVar) {
        this.f15170k = sVar;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public m0 M() {
        return V().M();
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public m0 Q() {
        return V().Q();
    }

    @Override // h.p2.b0.g.t.c.i0
    @k.e.a.d
    public j0 V() {
        j0 j0Var = this.f15167h;
        if (j0Var == null) {
            A(12);
        }
        return j0Var;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean X() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.a
    public boolean e0() {
        return false;
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

    @Override // h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @k.e.a.d
    public h.p2.b0.g.t.c.s getVisibility() {
        h.p2.b0.g.t.c.s sVar = this.f15170k;
        if (sVar == null) {
            A(10);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @k.e.a.d
    public CallableMemberDescriptor.Kind i() {
        CallableMemberDescriptor.Kind kind = this.f15169j;
        if (kind == null) {
            A(6);
        }
        return kind;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean i0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return this.f15165f;
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean isInfix() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean isInline() {
        return this.f15168i;
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean isOperator() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean isSuspend() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.v
    @k.e.a.e
    public h.p2.b0.g.t.c.v q0() {
        return this.f15171l;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public <V> V s0(a.InterfaceC0434a<V> interfaceC0434a) {
        return null;
    }

    @Override // h.p2.b0.g.t.c.w
    @k.e.a.d
    public Modality t() {
        Modality modality = this.f15166g;
        if (modality == null) {
            A(9);
        }
        return modality;
    }

    @Override // h.p2.b0.g.t.c.v, h.p2.b0.g.t.c.n0
    @k.e.a.d
    public v.a<? extends h.p2.b0.g.t.c.v> x() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean z0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.v, h.p2.b0.g.t.c.q0
    @k.e.a.d
    public h.p2.b0.g.t.c.v c(@k.e.a.d TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            A(7);
        }
        throw new UnsupportedOperationException();
    }
}
