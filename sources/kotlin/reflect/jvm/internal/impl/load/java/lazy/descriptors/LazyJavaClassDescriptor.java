package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.a2.d1;
import h.a2.u;
import h.k2.v.f0;
import h.p2.b0.g.t.c.a1;
import h.p2.b0.g.t.c.d1.f;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.r0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.e.a.p;
import h.p2.b0.g.t.e.a.u.c;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.j;
import h.p2.b0.g.t.e.a.x.x;
import h.p2.b0.g.t.k.n.t;
import h.p2.b0.g.t.l.b.l;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.n.b;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.z;
import h.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class LazyJavaClassDescriptor extends f implements c {
    @d

    /* renamed from: j  reason: collision with root package name */
    private final e f16522j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final g f16523k;
    @k.e.a.e

    /* renamed from: l  reason: collision with root package name */
    private final h.p2.b0.g.t.c.d f16524l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final e f16525m;
    @d
    private final w n;
    @d
    private final ClassKind o;
    @d
    private final Modality p;
    @d
    private final a1 q;
    private final boolean r;
    @d
    private final LazyJavaClassTypeConstructor s;
    @d
    private final LazyJavaClassMemberScope t;
    @d
    private final ScopesHolderForClass<LazyJavaClassMemberScope> u;
    @d
    private final h.p2.b0.g.t.k.r.e v;
    @d
    private final LazyJavaStaticClassScope w;
    @d
    private final h.p2.b0.g.t.c.b1.e x;
    @d
    private final h<List<t0>> y;
    @d
    public static final a z = new a(null);
    @d
    private static final Set<String> A = d1.u("equals", TTDownloadField.TT_HASHCODE, "getClass", "wait", "notify", "notifyAll", "toString");

    /* loaded from: classes3.dex */
    public final class LazyJavaClassTypeConstructor extends b {
        @d

        /* renamed from: d  reason: collision with root package name */
        private final h<List<t0>> f16526d;

        public LazyJavaClassTypeConstructor() {
            super(LazyJavaClassDescriptor.this.f16525m.e());
            this.f16526d = LazyJavaClassDescriptor.this.f16525m.e().c(new LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(LazyJavaClassDescriptor.this));
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
            if ((!r0.d() && r0.i(h.p2.b0.g.t.b.g.f15035m)) != false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final h.p2.b0.g.t.n.z w() {
            /*
                r8 = this;
                h.p2.b0.g.t.g.c r0 = r8.x()
                r1 = 1
                r2 = 0
                if (r0 != 0) goto La
            L8:
                r0 = r2
                goto L1d
            La:
                boolean r3 = r0.d()
                if (r3 != 0) goto L1a
                h.p2.b0.g.t.g.f r3 = h.p2.b0.g.t.b.g.f15035m
                boolean r3 = r0.i(r3)
                if (r3 == 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 == 0) goto L8
            L1d:
                if (r0 != 0) goto L2e
                h.p2.b0.g.t.e.a.g r3 = h.p2.b0.g.t.e.a.g.a
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this
                h.p2.b0.g.t.g.c r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.i(r4)
                h.p2.b0.g.t.g.c r3 = r3.b(r4)
                if (r3 != 0) goto L2f
                return r2
            L2e:
                r3 = r0
            L2f:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this
                h.p2.b0.g.t.e.a.v.e r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.H0(r4)
                h.p2.b0.g.t.c.z r4 = r4.d()
                kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r5 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_JAVA_LOADER
                h.p2.b0.g.t.c.d r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.r(r4, r3, r5)
                if (r3 != 0) goto L42
                return r2
            L42:
                h.p2.b0.g.t.n.q0 r4 = r3.j()
                java.util.List r4 = r4.getParameters()
                int r4 = r4.size()
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r5 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.this
                h.p2.b0.g.t.n.q0 r5 = r5.j()
                java.util.List r5 = r5.getParameters()
                int r6 = r5.size()
                r7 = 10
                if (r6 != r4) goto L88
                java.util.ArrayList r0 = new java.util.ArrayList
                int r1 = h.a2.u.Y(r5, r7)
                r0.<init>(r1)
                java.util.Iterator r1 = r5.iterator()
            L6d:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto Lc2
                java.lang.Object r2 = r1.next()
                h.p2.b0.g.t.c.t0 r2 = (h.p2.b0.g.t.c.t0) r2
                h.p2.b0.g.t.n.u0 r4 = new h.p2.b0.g.t.n.u0
                kotlin.reflect.jvm.internal.impl.types.Variance r5 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                h.p2.b0.g.t.n.f0 r2 = r2.r()
                r4.<init>(r5, r2)
                r0.add(r4)
                goto L6d
            L88:
                if (r6 != r1) goto Lcf
                if (r4 <= r1) goto Lcf
                if (r0 != 0) goto Lcf
                h.p2.b0.g.t.n.u0 r0 = new h.p2.b0.g.t.n.u0
                kotlin.reflect.jvm.internal.impl.types.Variance r2 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.U4(r5)
                h.p2.b0.g.t.c.t0 r5 = (h.p2.b0.g.t.c.t0) r5
                h.p2.b0.g.t.n.f0 r5 = r5.r()
                r0.<init>(r2, r5)
                h.o2.k r2 = new h.o2.k
                r2.<init>(r1, r4)
                java.util.ArrayList r1 = new java.util.ArrayList
                int r4 = h.a2.u.Y(r2, r7)
                r1.<init>(r4)
                java.util.Iterator r2 = r2.iterator()
            Lb1:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto Lc1
                r4 = r2
                h.a2.l0 r4 = (h.a2.l0) r4
                r4.nextInt()
                r1.add(r0)
                goto Lb1
            Lc1:
                r0 = r1
            Lc2:
                kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.a
                h.p2.b0.g.t.c.b1.e$a r1 = h.p2.b0.g.t.c.b1.e.w0
                h.p2.b0.g.t.c.b1.e r1 = r1.b()
                h.p2.b0.g.t.n.f0 r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.g(r1, r3, r0)
                return r0
            Lcf:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.w():h.p2.b0.g.t.n.z");
        }

        private final h.p2.b0.g.t.g.c x() {
            h.p2.b0.g.t.c.b1.c c2 = LazyJavaClassDescriptor.this.getAnnotations().c(p.o);
            if (c2 == null) {
                return null;
            }
            Object V4 = CollectionsKt___CollectionsKt.V4(c2.a().values());
            t tVar = V4 instanceof t ? (t) V4 : null;
            String a = tVar == null ? null : tVar.a();
            if (a != null && h.p2.b0.g.t.g.e.c(a)) {
                return new h.p2.b0.g.t.g.c(a);
            }
            return null;
        }

        @Override // h.p2.b0.g.t.n.q0
        public boolean d() {
            return true;
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public List<t0> getParameters() {
            return this.f16526d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @d
        public Collection<z> h() {
            Collection<j> j2 = LazyJavaClassDescriptor.this.L0().j();
            ArrayList arrayList = new ArrayList(j2.size());
            ArrayList<x> arrayList2 = new ArrayList(0);
            z w = w();
            Iterator<j> it = j2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j next = it.next();
                z f2 = LazyJavaClassDescriptor.this.f16525m.a().r().f(LazyJavaClassDescriptor.this.f16525m.g().n(next, JavaTypeResolverKt.f(TypeUsage.SUPERTYPE, false, null, 3, null)), LazyJavaClassDescriptor.this.f16525m);
                if (f2.I0().c() instanceof NotFoundClasses.b) {
                    arrayList2.add(next);
                }
                if (!f0.g(f2.I0(), w != null ? w.I0() : null) && !h.p2.b0.g.t.b.f.a0(f2)) {
                    arrayList.add(f2);
                }
            }
            h.p2.b0.g.t.c.d dVar = LazyJavaClassDescriptor.this.f16524l;
            h.p2.b0.g.t.p.a.a(arrayList, dVar != null ? h.p2.b0.g.t.b.k.g.a(dVar, LazyJavaClassDescriptor.this).c().p(dVar.r(), Variance.INVARIANT) : null);
            h.p2.b0.g.t.p.a.a(arrayList, w);
            if (!arrayList2.isEmpty()) {
                l c2 = LazyJavaClassDescriptor.this.f16525m.a().c();
                h.p2.b0.g.t.c.d c3 = c();
                ArrayList arrayList3 = new ArrayList(u.Y(arrayList2, 10));
                for (x xVar : arrayList2) {
                    arrayList3.add(((j) xVar).E());
                }
                c2.b(c3, arrayList3);
            }
            return arrayList.isEmpty() ^ true ? CollectionsKt___CollectionsKt.I5(arrayList) : h.a2.t.k(LazyJavaClassDescriptor.this.f16525m.d().k().i());
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @d
        public r0 n() {
            return LazyJavaClassDescriptor.this.f16525m.a().v();
        }

        @d
        public String toString() {
            return LazyJavaClassDescriptor.this.getName().b();
        }

        @Override // h.p2.b0.g.t.n.b, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, h.p2.b0.g.t.n.q0
        @d
        /* renamed from: v */
        public h.p2.b0.g.t.c.d c() {
            return LazyJavaClassDescriptor.this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public /* synthetic */ LazyJavaClassDescriptor(e eVar, k kVar, g gVar, h.p2.b0.g.t.c.d dVar, int i2, h.k2.v.u uVar) {
        this(eVar, kVar, gVar, (i2 & 8) != 0 ? null : dVar);
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.e
    public h.p2.b0.g.t.c.c E() {
        return null;
    }

    @d
    public final LazyJavaClassDescriptor J0(@d h.p2.b0.g.t.e.a.t.d dVar, @k.e.a.e h.p2.b0.g.t.c.d dVar2) {
        e eVar = this.f16525m;
        return new LazyJavaClassDescriptor(ContextKt.j(eVar, eVar.a().x(dVar)), b(), this.f16523k, dVar2);
    }

    @Override // h.p2.b0.g.t.c.d
    @d
    /* renamed from: K0 */
    public List<h.p2.b0.g.t.c.c> g() {
        return this.t.x0().invoke();
    }

    @d
    public final g L0() {
        return this.f16523k;
    }

    @k.e.a.e
    public final List<h.p2.b0.g.t.e.a.x.a> M0() {
        return (List) this.n.getValue();
    }

    @d
    public final e N0() {
        return this.f16522j;
    }

    @Override // h.p2.b0.g.t.c.d1.a, h.p2.b0.g.t.c.d
    @d
    /* renamed from: O0 */
    public LazyJavaClassMemberScope W() {
        return (LazyJavaClassMemberScope) super.W();
    }

    @Override // h.p2.b0.g.t.c.d1.r
    @d
    /* renamed from: P0 */
    public LazyJavaClassMemberScope f0(@d h.p2.b0.g.t.n.e1.h hVar) {
        return this.u.c(hVar);
    }

    @Override // h.p2.b0.g.t.c.d1.a, h.p2.b0.g.t.c.d
    @d
    public MemberScope U() {
        return this.v;
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
    @d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return this.x;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @d
    public s getVisibility() {
        if (f0.g(this.q, r.a) && this.f16523k.f() == null) {
            return h.p2.b0.g.t.e.a.l.a;
        }
        return h.p2.b0.g.t.e.a.s.a(this.q);
    }

    @Override // h.p2.b0.g.t.c.d
    @d
    public ClassKind i() {
        return this.o;
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
    @d
    public q0 j() {
        return this.s;
    }

    @Override // h.p2.b0.g.t.c.d
    @d
    public MemberScope k0() {
        return this.w;
    }

    @Override // h.p2.b0.g.t.c.d
    @k.e.a.e
    public h.p2.b0.g.t.c.d l0() {
        return null;
    }

    @Override // h.p2.b0.g.t.c.d
    @d
    public Collection<h.p2.b0.g.t.c.d> m() {
        if (this.p == Modality.SEALED) {
            h.p2.b0.g.t.e.a.v.j.a f2 = JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null);
            Collection<j> C = this.f16523k.C();
            ArrayList arrayList = new ArrayList();
            for (j jVar : C) {
                h.p2.b0.g.t.c.f c2 = this.f16525m.g().n(jVar, f2).I0().c();
                h.p2.b0.g.t.c.d dVar = c2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) c2 : null;
                if (dVar != null) {
                    arrayList.add(dVar);
                }
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.c.g
    public boolean n() {
        return this.r;
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.g
    @d
    public List<t0> s() {
        return this.y.invoke();
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.w
    @d
    public Modality t() {
        return this.p;
    }

    @d
    public String toString() {
        return f0.C("Lazy Java class ", DescriptorUtilsKt.j(this));
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

    public LazyJavaClassDescriptor(@d e eVar, @d k kVar, @d g gVar, @k.e.a.e h.p2.b0.g.t.c.d dVar) {
        super(eVar.e(), kVar, gVar.getName(), eVar.a().t().a(gVar), false);
        ClassKind classKind;
        Modality modality;
        this.f16522j = eVar;
        this.f16523k = gVar;
        this.f16524l = dVar;
        e d2 = ContextKt.d(eVar, this, gVar, 0, 4, null);
        this.f16525m = d2;
        d2.a().h().e(gVar, this);
        gVar.L();
        this.n = h.z.c(new LazyJavaClassDescriptor$moduleAnnotations$2(this));
        if (gVar.m()) {
            classKind = ClassKind.ANNOTATION_CLASS;
        } else if (gVar.K()) {
            classKind = ClassKind.INTERFACE;
        } else {
            classKind = gVar.w() ? ClassKind.ENUM_CLASS : ClassKind.CLASS;
        }
        this.o = classKind;
        if (!gVar.m() && !gVar.w()) {
            modality = Modality.Companion.a(false, gVar.p() || gVar.isAbstract() || gVar.K(), !gVar.isFinal());
        } else {
            modality = Modality.FINAL;
        }
        this.p = modality;
        this.q = gVar.getVisibility();
        this.r = (gVar.f() == null || gVar.Q()) ? false : true;
        this.s = new LazyJavaClassTypeConstructor();
        LazyJavaClassMemberScope lazyJavaClassMemberScope = new LazyJavaClassMemberScope(d2, this, gVar, dVar != null, null, 16, null);
        this.t = lazyJavaClassMemberScope;
        this.u = ScopesHolderForClass.f16442e.a(this, d2.e(), d2.a().k().c(), new LazyJavaClassDescriptor$scopeHolder$1(this));
        this.v = new h.p2.b0.g.t.k.r.e(lazyJavaClassMemberScope);
        this.w = new LazyJavaStaticClassScope(d2, gVar, this);
        this.x = h.p2.b0.g.t.e.a.v.d.a(d2, gVar);
        this.y = d2.e().c(new LazyJavaClassDescriptor$declaredParameters$1(this));
    }
}
