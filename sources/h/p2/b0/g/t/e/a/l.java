package h.p2.b0.g.t.e.a;

import h.p2.b0.g.t.c.a1;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.e1.a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class l {
    @k.e.a.d
    public static final h.p2.b0.g.t.c.s a;
    @k.e.a.d
    public static final h.p2.b0.g.t.c.s b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final h.p2.b0.g.t.c.s f15241c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final Map<a1, h.p2.b0.g.t.c.s> f15242d;

    /* loaded from: classes3.dex */
    public static class a extends h.p2.b0.g.t.c.p {
        public a(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d h.p2.b0.g.t.c.o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return l.d(oVar, kVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends h.p2.b0.g.t.c.p {
        public b(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d h.p2.b0.g.t.c.o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return l.e(eVar, oVar, kVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends h.p2.b0.g.t.c.p {
        public c(a1 a1Var) {
            super(a1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.c.s
        public boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d h.p2.b0.g.t.c.o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return l.e(eVar, oVar, kVar);
        }
    }

    static {
        a aVar = new a(a.C0440a.f15187c);
        a = aVar;
        b bVar = new b(a.c.f15189c);
        b = bVar;
        c cVar = new c(a.b.f15188c);
        f15241c = cVar;
        f15242d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 5 || i2 == 6) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i2 == 5 || i2 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i2 == 2 || i2 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i2 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i2 != 5 && i2 != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        if (i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.k kVar2) {
        if (kVar == null) {
            a(2);
        }
        if (kVar2 == null) {
            a(3);
        }
        b0 b0Var = (b0) h.p2.b0.g.t.k.c.r(kVar, b0.class, false);
        b0 b0Var2 = (b0) h.p2.b0.g.t.k.c.r(kVar2, b0.class, false);
        return (b0Var2 == null || b0Var == null || !b0Var.e().equals(b0Var2.e())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(@k.e.a.e h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d h.p2.b0.g.t.c.o oVar, @k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (oVar == null) {
            a(0);
        }
        if (kVar == null) {
            a(1);
        }
        if (d(h.p2.b0.g.t.k.c.M(oVar), kVar)) {
            return true;
        }
        return h.p2.b0.g.t.c.r.f15209c.e(eVar, oVar, kVar);
    }

    private static void f(h.p2.b0.g.t.c.s sVar) {
        f15242d.put(sVar.b(), sVar);
    }

    @k.e.a.d
    public static h.p2.b0.g.t.c.s g(@k.e.a.d a1 a1Var) {
        if (a1Var == null) {
            a(4);
        }
        h.p2.b0.g.t.c.s sVar = f15242d.get(a1Var);
        if (sVar != null) {
            if (sVar == null) {
                a(6);
            }
            return sVar;
        }
        h.p2.b0.g.t.c.s j2 = h.p2.b0.g.t.c.r.j(a1Var);
        if (j2 == null) {
            a(5);
        }
        return j2;
    }
}
