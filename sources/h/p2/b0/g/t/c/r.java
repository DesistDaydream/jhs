package h.p2.b0.g.t.c;

import h.a2.d1;
import h.p2.b0.g.t.c.z0;
import h.p2.b0.g.t.o.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public class r {
    @k.e.a.d
    public static final s a;
    @k.e.a.d
    public static final s b;
    @k.e.a.d

    /* renamed from: c */
    public static final s f15209c;
    @k.e.a.d

    /* renamed from: d */
    public static final s f15210d;
    @k.e.a.d

    /* renamed from: e */
    public static final s f15211e;
    @k.e.a.d

    /* renamed from: f */
    public static final s f15212f;
    @k.e.a.d

    /* renamed from: g */
    public static final s f15213g;
    @k.e.a.d

    /* renamed from: h */
    public static final s f15214h;
    @k.e.a.d

    /* renamed from: i */
    public static final s f15215i;

    /* renamed from: j */
    public static final Set<s> f15216j;

    /* renamed from: k */
    private static final Map<s, Integer> f15217k;

    /* renamed from: l */
    public static final s f15218l;

    /* renamed from: m */
    private static final h.p2.b0.g.t.k.r.i.e f15219m;
    public static final h.p2.b0.g.t.k.r.i.e n;
    @Deprecated
    public static final h.p2.b0.g.t.k.r.i.e o;
    @k.e.a.d
    private static final h.p2.b0.g.t.o.f p;
    @k.e.a.d
    private static final Map<a1, s> q;

    /* loaded from: classes3.dex */
    public static class a implements h.p2.b0.g.t.k.r.i.e {
        @Override // h.p2.b0.g.t.k.r.i.e
        @k.e.a.d
        public h.p2.b0.g.t.n.z getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements h.p2.b0.g.t.k.r.i.e {
        @Override // h.p2.b0.g.t.k.r.i.e
        @k.e.a.d
        public h.p2.b0.g.t.n.z getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements h.p2.b0.g.t.k.r.i.e {
        @Override // h.p2.b0.g.t.k.r.i.e
        @k.e.a.d
        public h.p2.b0.g.t.n.z getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends p {
        public d(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "what";
            } else if (i2 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i2 == 1 || i2 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (kVar == null) {
                g(0);
            }
            return h.p2.b0.g.t.k.c.j(kVar) != p0.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.k] */
        /* JADX WARN: Type inference failed for: r5v1, types: [h.p2.b0.g.t.c.k] */
        /* JADX WARN: Type inference failed for: r5v2, types: [h.p2.b0.g.t.c.k] */
        /* JADX WARN: Type inference failed for: r5v4, types: [h.p2.b0.g.t.c.k] */
        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == 0) {
                g(1);
            }
            if (kVar == null) {
                g(2);
            }
            if (h.p2.b0.g.t.k.c.J(oVar) && h(kVar)) {
                return r.f(oVar, kVar);
            }
            if (oVar instanceof h.p2.b0.g.t.c.j) {
                h.p2.b0.g.t.c.g b = ((h.p2.b0.g.t.c.j) oVar).b();
                if (h.p2.b0.g.t.k.c.G(b) && h.p2.b0.g.t.k.c.J(b) && (kVar instanceof h.p2.b0.g.t.c.j) && h.p2.b0.g.t.k.c.J(kVar.b()) && r.f(oVar, kVar)) {
                    return true;
                }
            }
            while (oVar != 0) {
                oVar = oVar.b();
                if (oVar instanceof h.p2.b0.g.t.c.d) {
                    if (!h.p2.b0.g.t.k.c.x(oVar)) {
                        break;
                    }
                }
                if (oVar instanceof b0) {
                    break;
                }
            }
            if (oVar == 0) {
                return false;
            }
            while (kVar != null) {
                if (oVar == kVar) {
                    return true;
                }
                if (kVar instanceof b0) {
                    return (oVar instanceof b0) && oVar.e().equals(((b0) kVar).e()) && h.p2.b0.g.t.k.c.b(kVar, oVar);
                }
                kVar = kVar.b();
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends p {
        public e(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            h.p2.b0.g.t.c.k q;
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            if (r.a.e(eVar, oVar, kVar)) {
                if (eVar == r.n) {
                    return true;
                }
                if (eVar != r.f15219m && (q = h.p2.b0.g.t.k.c.q(oVar, h.p2.b0.g.t.c.d.class)) != null && (eVar instanceof h.p2.b0.g.t.k.r.i.g)) {
                    return ((h.p2.b0.g.t.k.r.i.g) eVar).u().a().equals(q.a());
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends p {
        public f(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "from";
            } else if (i2 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i2 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i2 == 2 || i2 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.d dVar) {
            if (oVar == null) {
                g(2);
            }
            if (dVar == null) {
                g(3);
            }
            if (eVar == r.o) {
                return false;
            }
            if (!(oVar instanceof CallableMemberDescriptor) || (oVar instanceof h.p2.b0.g.t.c.j) || eVar == r.n) {
                return true;
            }
            if (eVar == r.f15219m || eVar == null) {
                return false;
            }
            h.p2.b0.g.t.n.z a = eVar instanceof h.p2.b0.g.t.k.r.i.f ? ((h.p2.b0.g.t.k.r.i.f) eVar).a() : eVar.getType();
            return h.p2.b0.g.t.k.c.I(a, dVar) || h.p2.b0.g.t.n.q.a(a);
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            h.p2.b0.g.t.c.d dVar;
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            h.p2.b0.g.t.c.d dVar2 = (h.p2.b0.g.t.c.d) h.p2.b0.g.t.k.c.q(oVar, h.p2.b0.g.t.c.d.class);
            h.p2.b0.g.t.c.d dVar3 = (h.p2.b0.g.t.c.d) h.p2.b0.g.t.k.c.r(kVar, h.p2.b0.g.t.c.d.class, false);
            if (dVar3 == null) {
                return false;
            }
            if (dVar2 == null || !h.p2.b0.g.t.k.c.x(dVar2) || (dVar = (h.p2.b0.g.t.c.d) h.p2.b0.g.t.k.c.q(dVar2, h.p2.b0.g.t.c.d.class)) == null || !h.p2.b0.g.t.k.c.H(dVar3, dVar)) {
                o M = h.p2.b0.g.t.k.c.M(oVar);
                h.p2.b0.g.t.c.d dVar4 = (h.p2.b0.g.t.c.d) h.p2.b0.g.t.k.c.q(M, h.p2.b0.g.t.c.d.class);
                if (dVar4 == null) {
                    return false;
                }
                if (h.p2.b0.g.t.k.c.H(dVar3, dVar4) && h(eVar, M, dVar3)) {
                    return true;
                }
                return e(eVar, oVar, dVar3.b());
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends p {
        public g(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            if (h.p2.b0.g.t.k.c.g(kVar).L(h.p2.b0.g.t.k.c.g(oVar))) {
                return r.p.a(oVar, kVar);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends p {
        public h(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends p {
        public i(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends p {
        public j(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends p {
        public k(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class l extends p {
        public l(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        d dVar = new d(z0.e.f15225c);
        a = dVar;
        e eVar = new e(z0.f.f15226c);
        b = eVar;
        f fVar = new f(z0.g.f15227c);
        f15209c = fVar;
        g gVar = new g(z0.b.f15222c);
        f15210d = gVar;
        h hVar = new h(z0.h.f15228c);
        f15211e = hVar;
        i iVar = new i(z0.d.f15224c);
        f15212f = iVar;
        j jVar = new j(z0.a.f15221c);
        f15213g = jVar;
        k kVar = new k(z0.c.f15223c);
        f15214h = kVar;
        l lVar = new l(z0.i.f15229c);
        f15215i = lVar;
        f15216j = Collections.unmodifiableSet(d1.u(dVar, eVar, gVar, iVar));
        HashMap e2 = h.p2.b0.g.t.p.a.e(4);
        e2.put(eVar, 0);
        e2.put(dVar, 0);
        e2.put(gVar, 1);
        e2.put(fVar, 1);
        e2.put(hVar, 2);
        f15217k = Collections.unmodifiableMap(e2);
        f15218l = hVar;
        f15219m = new a();
        n = new b();
        o = new c();
        Iterator it = ServiceLoader.load(h.p2.b0.g.t.o.f.class, h.p2.b0.g.t.o.f.class.getClassLoader()).iterator();
        p = it.hasNext() ? (h.p2.b0.g.t.o.f) it.next() : f.a.a;
        q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = 3
            goto L10
        Lf:
            r4 = 2
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.c.r.a(int):void");
    }

    @k.e.a.e
    public static Integer d(@k.e.a.d s sVar, @k.e.a.d s sVar2) {
        if (sVar == null) {
            a(12);
        }
        if (sVar2 == null) {
            a(13);
        }
        Integer a2 = sVar.a(sVar2);
        if (a2 != null) {
            return a2;
        }
        Integer a3 = sVar2.a(sVar);
        if (a3 != null) {
            return Integer.valueOf(-a3.intValue());
        }
        return null;
    }

    @k.e.a.e
    public static o e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
        o e2;
        if (oVar == null) {
            a(8);
        }
        if (kVar == null) {
            a(9);
        }
        for (o oVar2 = (o) oVar.a(); oVar2 != null && oVar2.getVisibility() != f15212f; oVar2 = (o) h.p2.b0.g.t.k.c.q(oVar2, o.class)) {
            if (!oVar2.getVisibility().e(eVar, oVar2, kVar)) {
                return oVar2;
            }
        }
        if (!(oVar instanceof h.p2.b0.g.t.c.d1.f0) || (e2 = e(eVar, ((h.p2.b0.g.t.c.d1.f0) oVar).T(), kVar)) == null) {
            return null;
        }
        return e2;
    }

    public static boolean f(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.k kVar2) {
        if (kVar == null) {
            a(6);
        }
        if (kVar2 == null) {
            a(7);
        }
        p0 j2 = h.p2.b0.g.t.k.c.j(kVar2);
        if (j2 != p0.a) {
            return j2.equals(h.p2.b0.g.t.k.c.j(kVar));
        }
        return false;
    }

    public static boolean g(@k.e.a.d s sVar) {
        if (sVar == null) {
            a(14);
        }
        return sVar == a || sVar == b;
    }

    public static boolean h(@k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (oVar == null) {
            a(2);
        }
        if (kVar == null) {
            a(3);
        }
        return e(n, oVar, kVar) == null;
    }

    private static void i(s sVar) {
        q.put(sVar.b(), sVar);
    }

    @k.e.a.d
    public static s j(@k.e.a.d a1 a1Var) {
        if (a1Var == null) {
            a(15);
        }
        s sVar = q.get(a1Var);
        if (sVar != null) {
            if (sVar == null) {
                a(16);
            }
            return sVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + a1Var);
    }
}
