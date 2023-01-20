package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.q0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public class v extends f {
    public static final /* synthetic */ boolean r = false;

    /* renamed from: j  reason: collision with root package name */
    private final ClassKind f15158j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f15159k;

    /* renamed from: l  reason: collision with root package name */
    private Modality f15160l;

    /* renamed from: m  reason: collision with root package name */
    private h.p2.b0.g.t.c.s f15161m;
    private q0 n;
    private List<t0> o;
    private final Collection<h.p2.b0.g.t.n.z> p;
    private final h.p2.b0.g.t.m.m q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d ClassKind classKind, boolean z, boolean z2, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d o0 o0Var, @k.e.a.d h.p2.b0.g.t.m.m mVar) {
        super(mVar, kVar, fVar, o0Var, z2);
        if (kVar == null) {
            h0(0);
        }
        if (classKind == null) {
            h0(1);
        }
        if (fVar == null) {
            h0(2);
        }
        if (o0Var == null) {
            h0(3);
        }
        if (mVar == null) {
            h0(4);
        }
        this.p = new ArrayList();
        this.q = mVar;
        this.f15158j = classKind;
        this.f15159k = z;
    }

    private static /* synthetic */ void h0(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i3 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(format);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.e
    public h.p2.b0.g.t.c.c E() {
        return null;
    }

    public void G0() {
        this.n = new h.p2.b0.g.t.n.h(this, this.o, this.p, this.q);
        Iterator<h.p2.b0.g.t.c.c> it = g().iterator();
        while (it.hasNext()) {
            ((e) it.next()).c1(r());
        }
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    /* renamed from: H0 */
    public Set<h.p2.b0.g.t.c.c> g() {
        Set<h.p2.b0.g.t.c.c> emptySet = Collections.emptySet();
        if (emptySet == null) {
            h0(13);
        }
        return emptySet;
    }

    public void I0(@k.e.a.d Modality modality) {
        if (modality == null) {
            h0(6);
        }
        this.f15160l = modality;
    }

    public void J0(@k.e.a.d List<t0> list) {
        if (list == null) {
            h0(14);
        }
        if (this.o == null) {
            this.o = new ArrayList(list);
            return;
        }
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    public void K0(@k.e.a.d h.p2.b0.g.t.c.s sVar) {
        if (sVar == null) {
            h0(9);
        }
        this.f15161m = sVar;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean X() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean a0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d1.r
    @k.e.a.d
    public MemberScope f0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        if (hVar == null) {
            h0(16);
        }
        MemberScope.b bVar = MemberScope.b.b;
        if (bVar == null) {
            h0(17);
        }
        return bVar;
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        h.p2.b0.g.t.c.b1.e b = h.p2.b0.g.t.c.b1.e.w0.b();
        if (b == null) {
            h0(5);
        }
        return b;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @k.e.a.d
    public h.p2.b0.g.t.c.s getVisibility() {
        h.p2.b0.g.t.c.s sVar = this.f15161m;
        if (sVar == null) {
            h0(10);
        }
        return sVar;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public ClassKind i() {
        ClassKind classKind = this.f15158j;
        if (classKind == null) {
            h0(8);
        }
        return classKind;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean i0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean isInline() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.f
    @k.e.a.d
    public q0 j() {
        q0 q0Var = this.n;
        if (q0Var == null) {
            h0(11);
        }
        return q0Var;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope k0() {
        MemberScope.b bVar = MemberScope.b.b;
        if (bVar == null) {
            h0(18);
        }
        return bVar;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.e
    public h.p2.b0.g.t.c.d l0() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.d> m() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(19);
        }
        return emptyList;
    }

    @Override // h.p2.b0.g.t.c.g
    public boolean n() {
        return this.f15159k;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.g
    @k.e.a.d
    public List<t0> s() {
        List<t0> list = this.o;
        if (list == null) {
            h0(15);
        }
        return list;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.w
    @k.e.a.d
    public Modality t() {
        Modality modality = this.f15160l;
        if (modality == null) {
            h0(7);
        }
        return modality;
    }

    public String toString() {
        return i.f0(this);
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean v() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean w() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean y() {
        return false;
    }
}
