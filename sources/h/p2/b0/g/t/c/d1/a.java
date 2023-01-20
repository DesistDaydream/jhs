package h.p2.b0.g.t.c.d1;

import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.n.v0;
import h.p2.b0.g.t.n.y0;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes3.dex */
public abstract class a extends r {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f15085f = false;
    private final h.p2.b0.g.t.g.f b;

    /* renamed from: c  reason: collision with root package name */
    public final h.p2.b0.g.t.m.h<h.p2.b0.g.t.n.f0> f15086c;

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.m.h<MemberScope> f15087d;

    /* renamed from: e  reason: collision with root package name */
    private final h.p2.b0.g.t.m.h<m0> f15088e;

    /* renamed from: h.p2.b0.g.t.c.d1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0437a implements h.k2.u.a<h.p2.b0.g.t.n.f0> {

        /* renamed from: h.p2.b0.g.t.c.d1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0438a implements h.k2.u.l<h.p2.b0.g.t.n.e1.h, h.p2.b0.g.t.n.f0> {
            public C0438a() {
            }

            @Override // h.k2.u.l
            /* renamed from: a */
            public h.p2.b0.g.t.n.f0 invoke(h.p2.b0.g.t.n.e1.h hVar) {
                h.p2.b0.g.t.c.f e2 = hVar.e(a.this);
                if (e2 == null) {
                    return a.this.f15086c.invoke();
                }
                if (e2 instanceof s0) {
                    return KotlinTypeFactory.b((s0) e2, y0.g(e2.j().getParameters()));
                }
                if (e2 instanceof r) {
                    return y0.u(e2.j().a(hVar), ((r) e2).f0(hVar), this);
                }
                return e2.r();
            }
        }

        public C0437a() {
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public h.p2.b0.g.t.n.f0 invoke() {
            a aVar = a.this;
            return y0.t(aVar, aVar.W(), new C0438a());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.k2.u.a<MemberScope> {
        public b() {
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public MemberScope invoke() {
            return new h.p2.b0.g.t.k.r.e(a.this.W());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements h.k2.u.a<m0> {
        public c() {
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public m0 invoke() {
            return new p(a.this);
        }
    }

    public a(@k.e.a.d h.p2.b0.g.t.m.m mVar, @k.e.a.d h.p2.b0.g.t.g.f fVar) {
        if (mVar == null) {
            h0(0);
        }
        if (fVar == null) {
            h0(1);
        }
        this.b = fVar;
        this.f15086c = mVar.c(new C0437a());
        this.f15087d = mVar.c(new b());
        this.f15088e = mVar.c(new c());
    }

    private static /* synthetic */ void h0(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8 || i2 == 11 || i2 == 13 || i2 == 15 || i2 == 16 || i2 == 18 || i2 == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8 || i2 == 11 || i2 == 13 || i2 == 15 || i2 == 16 || i2 == 18 || i2 == 19) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i2 == 2) {
            objArr[1] = "getName";
        } else if (i2 == 3) {
            objArr[1] = "getOriginal";
        } else if (i2 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i2 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i2 == 8 || i2 == 11 || i2 == 13 || i2 == 15) {
            objArr[1] = "getMemberScope";
        } else if (i2 == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i2 == 18) {
            objArr[1] = "substitute";
        } else if (i2 != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 8 && i2 != 11 && i2 != 13 && i2 != 15 && i2 != 16 && i2 != 18 && i2 != 19) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // h.p2.b0.g.t.c.d1.r
    @k.e.a.d
    public MemberScope A(@k.e.a.d v0 v0Var, @k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        if (v0Var == null) {
            h0(9);
        }
        if (hVar == null) {
            h0(10);
        }
        if (!v0Var.f()) {
            return new SubstitutingScope(f0(hVar), TypeSubstitutor.g(v0Var));
        }
        MemberScope f0 = f0(hVar);
        if (f0 == null) {
            h0(11);
        }
        return f0;
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.a(this, d2);
    }

    @Override // h.p2.b0.g.t.c.q0
    @k.e.a.d
    /* renamed from: C0 */
    public h.p2.b0.g.t.c.d c(@k.e.a.d TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            h0(17);
        }
        return typeSubstitutor.k() ? this : new q(this, typeSubstitutor);
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public m0 F0() {
        m0 invoke = this.f15088e.invoke();
        if (invoke == null) {
            h0(5);
        }
        return invoke;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope U() {
        MemberScope invoke = this.f15087d.invoke();
        if (invoke == null) {
            h0(4);
        }
        return invoke;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope W() {
        MemberScope f0 = f0(DescriptorUtilsKt.k(h.p2.b0.g.t.k.c.g(this)));
        if (f0 == null) {
            h0(16);
        }
        return f0;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.k
    @k.e.a.d
    public h.p2.b0.g.t.c.d a() {
        return this;
    }

    @Override // h.p2.b0.g.t.c.a0
    @k.e.a.d
    public h.p2.b0.g.t.g.f getName() {
        h.p2.b0.g.t.g.f fVar = this.b;
        if (fVar == null) {
            h0(2);
        }
        return fVar;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public MemberScope o0(@k.e.a.d v0 v0Var) {
        if (v0Var == null) {
            h0(14);
        }
        MemberScope A = A(v0Var, DescriptorUtilsKt.k(h.p2.b0.g.t.k.c.g(this)));
        if (A == null) {
            h0(15);
        }
        return A;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.f
    @k.e.a.d
    public h.p2.b0.g.t.n.f0 r() {
        h.p2.b0.g.t.n.f0 invoke = this.f15086c.invoke();
        if (invoke == null) {
            h0(19);
        }
        return invoke;
    }
}
