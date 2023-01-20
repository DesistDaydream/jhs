package h.p2.b0.g.t.c.d1;

import com.tencent.qcloud.tuicore.TUIConstants;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.c.l0;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public class z extends i0 implements j0 {
    private h.p2.b0.g.t.c.u A;
    private h.p2.b0.g.t.c.u B;

    /* renamed from: j  reason: collision with root package name */
    private final Modality f15172j;

    /* renamed from: k  reason: collision with root package name */
    private h.p2.b0.g.t.c.s f15173k;

    /* renamed from: l  reason: collision with root package name */
    private Collection<? extends j0> f15174l;

    /* renamed from: m  reason: collision with root package name */
    private final j0 f15175m;
    private final CallableMemberDescriptor.Kind n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final boolean t;
    private m0 u;
    private m0 v;
    private List<t0> w;
    private a0 x;
    private l0 y;
    private boolean z;

    /* loaded from: classes3.dex */
    public class a {
        private h.p2.b0.g.t.c.k a;
        private Modality b;

        /* renamed from: c  reason: collision with root package name */
        private h.p2.b0.g.t.c.s f15176c;

        /* renamed from: f  reason: collision with root package name */
        private CallableMemberDescriptor.Kind f15179f;

        /* renamed from: i  reason: collision with root package name */
        private m0 f15182i;

        /* renamed from: k  reason: collision with root package name */
        private h.p2.b0.g.t.g.f f15184k;

        /* renamed from: l  reason: collision with root package name */
        private h.p2.b0.g.t.n.z f15185l;

        /* renamed from: d  reason: collision with root package name */
        private j0 f15177d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f15178e = false;

        /* renamed from: g  reason: collision with root package name */
        private v0 f15180g = v0.b;

        /* renamed from: h  reason: collision with root package name */
        private boolean f15181h = true;

        /* renamed from: j  reason: collision with root package name */
        private List<t0> f15183j = null;

        public a() {
            this.a = z.this.b();
            this.b = z.this.t();
            this.f15176c = z.this.getVisibility();
            this.f15179f = z.this.i();
            this.f15182i = z.this.u;
            this.f15184k = z.this.getName();
            this.f15185l = z.this.getType();
        }

        private static /* synthetic */ void a(int i2) {
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? 2 : 3];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = TUIConstants.TUIChat.OWNER;
                    break;
            }
            if (i2 == 1) {
                objArr[1] = "setOwner";
            } else if (i2 == 2) {
                objArr[1] = "setOriginal";
            } else if (i2 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i2 == 5) {
                objArr[1] = "setReturnType";
            } else if (i2 == 7) {
                objArr[1] = "setModality";
            } else if (i2 == 9) {
                objArr[1] = "setVisibility";
            } else if (i2 == 11) {
                objArr[1] = "setKind";
            } else if (i2 == 19) {
                objArr[1] = "setName";
            } else if (i2 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i2 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i2 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i2 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 5 && i2 != 7 && i2 != 9 && i2 != 11 && i2 != 19 && i2 != 13 && i2 != 14 && i2 != 16 && i2 != 17) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @k.e.a.e
        public j0 n() {
            return z.this.M0(this);
        }

        public k0 o() {
            j0 j0Var = this.f15177d;
            if (j0Var == null) {
                return null;
            }
            return j0Var.getGetter();
        }

        public l0 p() {
            j0 j0Var = this.f15177d;
            if (j0Var == null) {
                return null;
            }
            return j0Var.getSetter();
        }

        @k.e.a.d
        public a q(boolean z) {
            this.f15181h = z;
            return this;
        }

        @k.e.a.d
        public a r(@k.e.a.d CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(10);
            }
            this.f15179f = kind;
            return this;
        }

        @k.e.a.d
        public a s(@k.e.a.d Modality modality) {
            if (modality == null) {
                a(6);
            }
            this.b = modality;
            return this;
        }

        @k.e.a.d
        public a t(@k.e.a.e CallableMemberDescriptor callableMemberDescriptor) {
            this.f15177d = (j0) callableMemberDescriptor;
            return this;
        }

        @k.e.a.d
        public a u(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (kVar == null) {
                a(0);
            }
            this.a = kVar;
            return this;
        }

        @k.e.a.d
        public a v(@k.e.a.d v0 v0Var) {
            if (v0Var == null) {
                a(15);
            }
            this.f15180g = v0Var;
            return this;
        }

        @k.e.a.d
        public a w(@k.e.a.d h.p2.b0.g.t.c.s sVar) {
            if (sVar == null) {
                a(8);
            }
            this.f15176c = sVar;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.e j0 j0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar, boolean z, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d o0 o0Var, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(kVar, eVar, fVar, null, z, o0Var);
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
        if (kind == null) {
            A(5);
        }
        if (o0Var == null) {
            A(6);
        }
        this.f15174l = null;
        this.f15172j = modality;
        this.f15173k = sVar;
        this.f15175m = j0Var == null ? this : j0Var;
        this.n = kind;
        this.o = z2;
        this.p = z3;
        this.q = z4;
        this.r = z5;
        this.s = z6;
        this.t = z7;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0108 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void A(int r11) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.c.d1.z.A(int):void");
    }

    @k.e.a.d
    public static z K0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar, boolean z, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d o0 o0Var, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
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
        if (kind == null) {
            A(12);
        }
        if (o0Var == null) {
            A(13);
        }
        return new z(kVar, null, eVar, modality, sVar, z, fVar, kind, o0Var, z2, z3, z4, z5, z6, z7);
    }

    @k.e.a.d
    private o0 O0(boolean z, @k.e.a.e j0 j0Var) {
        o0 o0Var;
        if (z) {
            if (j0Var == null) {
                j0Var = h0();
            }
            o0Var = j0Var.getSource();
        } else {
            o0Var = o0.a;
        }
        if (o0Var == null) {
            A(23);
        }
        return o0Var;
    }

    private static h.p2.b0.g.t.c.v P0(@k.e.a.d TypeSubstitutor typeSubstitutor, @k.e.a.d h.p2.b0.g.t.c.i0 i0Var) {
        if (typeSubstitutor == null) {
            A(25);
        }
        if (i0Var == null) {
            A(26);
        }
        if (i0Var.q0() != null) {
            return i0Var.q0().c(typeSubstitutor);
        }
        return null;
    }

    private static h.p2.b0.g.t.c.s U0(h.p2.b0.g.t.c.s sVar, CallableMemberDescriptor.Kind kind) {
        return (kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && h.p2.b0.g.t.c.r.g(sVar.f())) ? h.p2.b0.g.t.c.r.f15214h : sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void A0(@k.e.a.d Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            A(35);
        }
        this.f15174l = collection;
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.c(this, d2);
    }

    @Override // h.p2.b0.g.t.c.y0
    public boolean C() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @k.e.a.d
    /* renamed from: J0 */
    public j0 P(h.p2.b0.g.t.c.k kVar, Modality modality, h.p2.b0.g.t.c.s sVar, CallableMemberDescriptor.Kind kind, boolean z) {
        j0 n = T0().u(kVar).t(null).s(modality).w(sVar).r(kind).q(z).n();
        if (n == null) {
            A(37);
        }
        return n;
    }

    @k.e.a.d
    public z L0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar, @k.e.a.e j0 j0Var, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d o0 o0Var) {
        if (kVar == null) {
            A(27);
        }
        if (modality == null) {
            A(28);
        }
        if (sVar == null) {
            A(29);
        }
        if (kind == null) {
            A(30);
        }
        if (fVar == null) {
            A(31);
        }
        if (o0Var == null) {
            A(32);
        }
        return new z(kVar, j0Var, getAnnotations(), modality, sVar, O(), fVar, kind, o0Var, v0(), isConst(), i0(), X(), isExternal(), C());
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.a
    @k.e.a.e
    public m0 M() {
        return this.u;
    }

    @k.e.a.e
    public j0 M0(@k.e.a.d a aVar) {
        m0 m0Var;
        c0 c0Var;
        h.p2.b0.g.t.m.i<h.p2.b0.g.t.k.n.g<?>> iVar;
        if (aVar == null) {
            A(24);
        }
        z L0 = L0(aVar.a, aVar.b, aVar.f15176c, aVar.f15177d, aVar.f15179f, aVar.f15184k, O0(aVar.f15178e, aVar.f15177d));
        List<t0> typeParameters = aVar.f15183j == null ? getTypeParameters() : aVar.f15183j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor b = h.p2.b0.g.t.n.n.b(typeParameters, aVar.f15180g, L0, arrayList);
        h.p2.b0.g.t.n.z zVar = aVar.f15185l;
        Variance variance = Variance.OUT_VARIANCE;
        h.p2.b0.g.t.n.z p = b.p(zVar, variance);
        if (p == null) {
            return null;
        }
        m0 m0Var2 = aVar.f15182i;
        if (m0Var2 != null) {
            m0Var = m0Var2.c(b);
            if (m0Var == null) {
                return null;
            }
        } else {
            m0Var = null;
        }
        m0 m0Var3 = this.v;
        if (m0Var3 != null) {
            h.p2.b0.g.t.n.z p2 = b.p(m0Var3.getType(), Variance.IN_VARIANCE);
            if (p2 == null) {
                return null;
            }
            c0Var = new c0(L0, new h.p2.b0.g.t.k.r.i.b(L0, p2, this.v.getValue()), this.v.getAnnotations());
        } else {
            c0Var = null;
        }
        L0.W0(p, arrayList, m0Var, c0Var);
        a0 a0Var = this.x == null ? null : new a0(L0, this.x.getAnnotations(), aVar.b, U0(this.x.getVisibility(), aVar.f15179f), this.x.G(), this.x.isExternal(), this.x.isInline(), aVar.f15179f, aVar.o(), o0.a);
        if (a0Var != null) {
            h.p2.b0.g.t.n.z returnType = this.x.getReturnType();
            a0Var.J0(P0(b, this.x));
            a0Var.M0(returnType != null ? b.p(returnType, variance) : null);
        }
        b0 b0Var = this.y == null ? null : new b0(L0, this.y.getAnnotations(), aVar.b, U0(this.y.getVisibility(), aVar.f15179f), this.y.G(), this.y.isExternal(), this.y.isInline(), aVar.f15179f, aVar.p(), o0.a);
        if (b0Var != null) {
            List<h.p2.b0.g.t.c.v0> L02 = o.L0(b0Var, this.y.h(), b, false, false, null);
            if (L02 == null) {
                L0.V0(true);
                L02 = Collections.singletonList(b0.L0(b0Var, DescriptorUtilsKt.g(aVar.a).H(), this.y.h().get(0).getAnnotations()));
            }
            if (L02.size() == 1) {
                b0Var.J0(P0(b, this.y));
                b0Var.N0(L02.get(0));
            } else {
                throw new IllegalStateException();
            }
        }
        h.p2.b0.g.t.c.u uVar = this.A;
        n nVar = uVar == null ? null : new n(uVar.getAnnotations(), L0);
        h.p2.b0.g.t.c.u uVar2 = this.B;
        L0.R0(a0Var, b0Var, nVar, uVar2 != null ? new n(uVar2.getAnnotations(), L0) : null);
        if (aVar.f15181h) {
            h.p2.b0.g.t.p.e a2 = h.p2.b0.g.t.p.e.a();
            for (j0 j0Var : d()) {
                a2.add(j0Var.c(b));
            }
            L0.A0(a2);
        }
        if (isConst() && (iVar = this.f15117h) != null) {
            L0.H0(iVar);
        }
        return L0;
    }

    @Override // h.p2.b0.g.t.c.j0
    @k.e.a.e
    /* renamed from: N0 */
    public a0 getGetter() {
        return this.x;
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.a
    @k.e.a.e
    public m0 Q() {
        return this.v;
    }

    public void Q0(@k.e.a.e a0 a0Var, @k.e.a.e l0 l0Var) {
        R0(a0Var, l0Var, null, null);
    }

    @Override // h.p2.b0.g.t.c.j0
    @k.e.a.e
    public h.p2.b0.g.t.c.u R() {
        return this.B;
    }

    public void R0(@k.e.a.e a0 a0Var, @k.e.a.e l0 l0Var, @k.e.a.e h.p2.b0.g.t.c.u uVar, @k.e.a.e h.p2.b0.g.t.c.u uVar2) {
        this.x = a0Var;
        this.y = l0Var;
        this.A = uVar;
        this.B = uVar2;
    }

    public boolean S0() {
        return this.z;
    }

    @k.e.a.d
    public a T0() {
        return new a();
    }

    public void V0(boolean z) {
        this.z = z;
    }

    public void W0(@k.e.a.d h.p2.b0.g.t.n.z zVar, @k.e.a.d List<? extends t0> list, @k.e.a.e m0 m0Var, @k.e.a.e m0 m0Var2) {
        if (zVar == null) {
            A(14);
        }
        if (list == null) {
            A(15);
        }
        G0(zVar);
        this.w = new ArrayList(list);
        this.v = m0Var2;
        this.u = m0Var;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean X() {
        return this.r;
    }

    public void X0(@k.e.a.d h.p2.b0.g.t.c.s sVar) {
        if (sVar == null) {
            A(16);
        }
        this.f15173k = sVar;
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.a
    @k.e.a.d
    public Collection<? extends j0> d() {
        Collection<? extends j0> collection = this.f15174l;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            A(36);
        }
        return collection;
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.a
    @k.e.a.d
    public h.p2.b0.g.t.n.z getReturnType() {
        h.p2.b0.g.t.n.z type = getType();
        if (type == null) {
            A(18);
        }
        return type;
    }

    @Override // h.p2.b0.g.t.c.j0
    @k.e.a.e
    public l0 getSetter() {
        return this.y;
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.a
    @k.e.a.d
    public List<t0> getTypeParameters() {
        List<t0> list = this.w;
        if (list != null) {
            if (list == null) {
                A(17);
            }
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @k.e.a.d
    public h.p2.b0.g.t.c.s getVisibility() {
        h.p2.b0.g.t.c.s sVar = this.f15173k;
        if (sVar == null) {
            A(20);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @k.e.a.d
    public CallableMemberDescriptor.Kind i() {
        CallableMemberDescriptor.Kind kind = this.n;
        if (kind == null) {
            A(34);
        }
        return kind;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean i0() {
        return this.q;
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.x0
    public boolean isConst() {
        return this.p;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return this.s;
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.a
    @k.e.a.e
    public <V> V s0(a.InterfaceC0434a<V> interfaceC0434a) {
        return null;
    }

    @Override // h.p2.b0.g.t.c.w
    @k.e.a.d
    public Modality t() {
        Modality modality = this.f15172j;
        if (modality == null) {
            A(19);
        }
        return modality;
    }

    @Override // h.p2.b0.g.t.c.j0
    @k.e.a.e
    public h.p2.b0.g.t.c.u u0() {
        return this.A;
    }

    @Override // h.p2.b0.g.t.c.x0
    public boolean v0() {
        return this.o;
    }

    @Override // h.p2.b0.g.t.c.j0
    @k.e.a.d
    public List<h.p2.b0.g.t.c.i0> z() {
        ArrayList arrayList = new ArrayList(2);
        a0 a0Var = this.x;
        if (a0Var != null) {
            arrayList.add(a0Var);
        }
        l0 l0Var = this.y;
        if (l0Var != null) {
            arrayList.add(l0Var);
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.c.q0
    public j0 c(@k.e.a.d TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            A(22);
        }
        return typeSubstitutor.k() ? this : T0().v(typeSubstitutor.j()).t(h0()).n();
    }

    @Override // h.p2.b0.g.t.c.d1.h0, h.p2.b0.g.t.c.d1.j
    @k.e.a.d
    /* renamed from: a */
    public j0 h0() {
        j0 j0Var = this.f15175m;
        j0 a2 = j0Var == this ? this : j0Var.a();
        if (a2 == null) {
            A(33);
        }
        return a2;
    }
}
