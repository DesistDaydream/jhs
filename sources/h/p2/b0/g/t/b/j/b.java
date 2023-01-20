package h.p2.b0.g.t.b.j;

import h.a2.l0;
import h.a2.t;
import h.k2.v.f0;
import h.k2.v.u;
import h.o2.k;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.d1.g0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.r0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.z;
import h.t1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class b extends h.p2.b0.g.t.c.d1.a {
    @k.e.a.d
    public static final a n = new a(null);
    @k.e.a.d
    private static final h.p2.b0.g.t.g.b o = new h.p2.b0.g.t.g.b(g.n, f.f("Function"));
    @k.e.a.d
    private static final h.p2.b0.g.t.g.b p = new h.p2.b0.g.t.g.b(g.f15033k, f.f("KFunction"));
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private final m f15052g;
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private final b0 f15053h;
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private final FunctionClassKind f15054i;

    /* renamed from: j  reason: collision with root package name */
    private final int f15055j;
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private final C0432b f15056k;
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private final c f15057l;
    @k.e.a.d

    /* renamed from: m  reason: collision with root package name */
    private final List<t0> f15058m;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* renamed from: h.p2.b0.g.t.b.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0432b extends h.p2.b0.g.t.n.b {

        /* renamed from: h.p2.b0.g.t.b.j.b$b$a */
        /* loaded from: classes3.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[FunctionClassKind.values().length];
                iArr[FunctionClassKind.Function.ordinal()] = 1;
                iArr[FunctionClassKind.KFunction.ordinal()] = 2;
                iArr[FunctionClassKind.SuspendFunction.ordinal()] = 3;
                iArr[FunctionClassKind.KSuspendFunction.ordinal()] = 4;
                a = iArr;
            }
        }

        public C0432b() {
            super(b.this.f15052g);
        }

        @Override // h.p2.b0.g.t.n.q0
        public boolean d() {
            return true;
        }

        @Override // h.p2.b0.g.t.n.q0
        @k.e.a.d
        public List<t0> getParameters() {
            return b.this.f15058m;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @k.e.a.d
        public Collection<z> h() {
            List<h.p2.b0.g.t.g.b> k2;
            int i2 = a.a[b.this.Q0().ordinal()];
            if (i2 == 1) {
                k2 = t.k(b.o);
            } else if (i2 == 2) {
                k2 = CollectionsKt__CollectionsKt.L(b.p, new h.p2.b0.g.t.g.b(g.n, FunctionClassKind.Function.numberedClassName(b.this.M0())));
            } else if (i2 == 3) {
                k2 = t.k(b.o);
            } else if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                k2 = CollectionsKt__CollectionsKt.L(b.p, new h.p2.b0.g.t.g.b(g.f15027e, FunctionClassKind.SuspendFunction.numberedClassName(b.this.M0())));
            }
            h.p2.b0.g.t.c.z b = b.this.f15053h.b();
            ArrayList arrayList = new ArrayList(h.a2.u.Y(k2, 10));
            for (h.p2.b0.g.t.g.b bVar : k2) {
                h.p2.b0.g.t.c.d a2 = FindClassInModuleKt.a(b, bVar);
                if (a2 == null) {
                    throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
                }
                List<t0> x5 = CollectionsKt___CollectionsKt.x5(getParameters(), a2.j().getParameters().size());
                ArrayList arrayList2 = new ArrayList(h.a2.u.Y(x5, 10));
                for (t0 t0Var : x5) {
                    arrayList2.add(new u0(t0Var.r()));
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                arrayList.add(KotlinTypeFactory.g(e.w0.b(), a2, arrayList2));
            }
            return CollectionsKt___CollectionsKt.I5(arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @k.e.a.d
        public r0 n() {
            return r0.a.a;
        }

        @k.e.a.d
        public String toString() {
            return v().toString();
        }

        @Override // h.p2.b0.g.t.n.b
        @k.e.a.d
        /* renamed from: w */
        public b v() {
            return b.this;
        }
    }

    public b(@k.e.a.d m mVar, @k.e.a.d b0 b0Var, @k.e.a.d FunctionClassKind functionClassKind, int i2) {
        super(mVar, functionClassKind.numberedClassName(i2));
        this.f15052g = mVar;
        this.f15053h = b0Var;
        this.f15054i = functionClassKind;
        this.f15055j = i2;
        this.f15056k = new C0432b();
        this.f15057l = new c(mVar, this);
        ArrayList arrayList = new ArrayList();
        k kVar = new k(1, i2);
        ArrayList arrayList2 = new ArrayList(h.a2.u.Y(kVar, 10));
        Iterator<Integer> it = kVar.iterator();
        while (it.hasNext()) {
            G0(arrayList, this, Variance.IN_VARIANCE, f0.C("P", Integer.valueOf(((l0) it).nextInt())));
            arrayList2.add(t1.a);
        }
        G0(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.f15058m = CollectionsKt___CollectionsKt.I5(arrayList);
    }

    private static final void G0(ArrayList<t0> arrayList, b bVar, Variance variance, String str) {
        arrayList.add(g0.N0(bVar, e.w0.b(), false, variance, f.f(str), arrayList.size(), bVar.f15052g));
    }

    @Override // h.p2.b0.g.t.c.d
    public /* bridge */ /* synthetic */ h.p2.b0.g.t.c.c E() {
        return (h.p2.b0.g.t.c.c) U0();
    }

    public final int M0() {
        return this.f15055j;
    }

    @k.e.a.e
    public Void N0() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    /* renamed from: O0 */
    public List<h.p2.b0.g.t.c.c> g() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.l, h.p2.b0.g.t.c.k
    @k.e.a.d
    /* renamed from: P0 */
    public b0 b() {
        return this.f15053h;
    }

    @k.e.a.d
    public final FunctionClassKind Q0() {
        return this.f15054i;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    /* renamed from: R0 */
    public List<h.p2.b0.g.t.c.d> m() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    /* renamed from: S0 */
    public MemberScope.b k0() {
        return MemberScope.b.b;
    }

    @Override // h.p2.b0.g.t.c.d1.r
    @k.e.a.d
    /* renamed from: T0 */
    public c f0(@k.e.a.d h hVar) {
        return this.f15057l;
    }

    @k.e.a.e
    public Void U0() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean X() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean a0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public e getAnnotations() {
        return e.w0.b();
    }

    @Override // h.p2.b0.g.t.c.n
    @k.e.a.d
    public o0 getSource() {
        return o0.a;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @k.e.a.d
    public s getVisibility() {
        return r.f15211e;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.d
    public ClassKind i() {
        return ClassKind.INTERFACE;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean i0() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d
    public boolean isInline() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.f
    @k.e.a.d
    public q0 j() {
        return this.f15056k;
    }

    @Override // h.p2.b0.g.t.c.d
    public /* bridge */ /* synthetic */ h.p2.b0.g.t.c.d l0() {
        return (h.p2.b0.g.t.c.d) N0();
    }

    @Override // h.p2.b0.g.t.c.g
    public boolean n() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.g
    @k.e.a.d
    public List<t0> s() {
        return this.f15058m;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.w
    @k.e.a.d
    public Modality t() {
        return Modality.ABSTRACT;
    }

    @k.e.a.d
    public String toString() {
        return getName().b();
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
