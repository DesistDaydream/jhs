package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.q0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public class g extends f {
    public static final /* synthetic */ boolean p = false;

    /* renamed from: j  reason: collision with root package name */
    private final Modality f15106j;

    /* renamed from: k  reason: collision with root package name */
    private final ClassKind f15107k;

    /* renamed from: l  reason: collision with root package name */
    private final q0 f15108l;

    /* renamed from: m  reason: collision with root package name */
    private MemberScope f15109m;
    private Set<h.p2.b0.g.t.c.c> n;
    private h.p2.b0.g.t.c.c o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d Modality modality, @k.e.a.d ClassKind classKind, @k.e.a.d Collection<h.p2.b0.g.t.n.z> collection, @k.e.a.d o0 o0Var, boolean z, @k.e.a.d h.p2.b0.g.t.m.m mVar) {
        super(mVar, kVar, fVar, o0Var, z);
        if (kVar == null) {
            h0(0);
        }
        if (fVar == null) {
            h0(1);
        }
        if (modality == null) {
            h0(2);
        }
        if (classKind == null) {
            h0(3);
        }
        if (collection == null) {
            h0(4);
        }
        if (o0Var == null) {
            h0(5);
        }
        if (mVar == null) {
            h0(6);
        }
        this.f15106j = modality;
        this.f15107k = classKind;
        this.f15108l = new h.p2.b0.g.t.n.h(this, Collections.emptyList(), collection, mVar);
    }

    private static /* synthetic */ void h0(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i3 = 2;
                break;
            case 12:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // h.p2.b0.g.t.c.d
    public h.p2.b0.g.t.c.c E() {
        return this.o;
    }

    public final void G0(@k.e.a.d MemberScope memberScope, @k.e.a.d Set<h.p2.b0.g.t.c.c> set, @k.e.a.e h.p2.b0.g.t.c.c cVar) {
        if (memberScope == null) {
            h0(7);
        }
        if (set == null) {
            h0(8);
        }
        this.f15109m = memberScope;
        this.n = set;
        this.o = cVar;
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
            h0(12);
        }
        MemberScope memberScope = this.f15109m;
        if (memberScope == null) {
            h0(13);
        }
        return memberScope;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.c> g() {
        Set<h.p2.b0.g.t.c.c> set = this.n;
        if (set == null) {
            h0(11);
        }
        return set;
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        h.p2.b0.g.t.c.b1.e b = h.p2.b0.g.t.c.b1.e.w0.b();
        if (b == null) {
            h0(9);
        }
        return b;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @k.e.a.d
    public h.p2.b0.g.t.c.s getVisibility() {
        h.p2.b0.g.t.c.s sVar = h.p2.b0.g.t.c.r.f15211e;
        if (sVar == null) {
            h0(17);
        }
        return sVar;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public ClassKind i() {
        ClassKind classKind = this.f15107k;
        if (classKind == null) {
            h0(15);
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
        q0 q0Var = this.f15108l;
        if (q0Var == null) {
            h0(10);
        }
        return q0Var;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope k0() {
        MemberScope.b bVar = MemberScope.b.b;
        if (bVar == null) {
            h0(14);
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
        return false;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.g
    @k.e.a.d
    public List<t0> s() {
        List<t0> emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(18);
        }
        return emptyList;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.w
    @k.e.a.d
    public Modality t() {
        Modality modality = this.f15106j;
        if (modality == null) {
            h0(16);
        }
        return modality;
    }

    public String toString() {
        return "class " + getName();
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
