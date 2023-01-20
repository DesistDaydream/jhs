package h.p2.b0.g.t.p;

import h.k2.u.l;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a extends AbstractC0472b<N, Boolean> {
        public final /* synthetic */ l a;
        public final /* synthetic */ boolean[] b;

        public a(l lVar, boolean[] zArr) {
            this.a = lVar;
            this.b = zArr;
        }

        @Override // h.p2.b0.g.t.p.b.AbstractC0472b, h.p2.b0.g.t.p.b.e
        public boolean c(N n) {
            if (((Boolean) this.a.invoke(n)).booleanValue()) {
                this.b[0] = true;
            }
            return !this.b[0];
        }

        @Override // h.p2.b0.g.t.p.b.e
        /* renamed from: d */
        public Boolean a() {
            return Boolean.valueOf(this.b[0]);
        }
    }

    /* renamed from: h.p2.b0.g.t.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0472b<N, R> implements e<N, R> {
        @Override // h.p2.b0.g.t.p.b.e
        public void b(N n) {
        }

        @Override // h.p2.b0.g.t.p.b.e
        public boolean c(N n) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c<N, R, C extends Iterable<R>> extends AbstractC0472b<N, C> {
        @k.e.a.d
        public final C a;

        public c(@k.e.a.d C c2) {
            if (c2 == null) {
                d(0);
            }
            this.a = c2;
        }

        private static /* synthetic */ void d(int i2) {
            String str = i2 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 1 ? 3 : 2];
            if (i2 != 1) {
                objArr[0] = "result";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            }
            if (i2 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            } else {
                objArr[1] = "result";
            }
            if (i2 != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @Override // h.p2.b0.g.t.p.b.e
        @k.e.a.d
        /* renamed from: e */
        public C a() {
            C c2 = this.a;
            if (c2 == null) {
                d(1);
            }
            return c2;
        }
    }

    /* loaded from: classes3.dex */
    public interface d<N> {
        @k.e.a.d
        Iterable<? extends N> a(N n);
    }

    /* loaded from: classes3.dex */
    public interface e<N, R> {
        R a();

        void b(N n);

        boolean c(N n);
    }

    /* loaded from: classes3.dex */
    public static abstract class f<N, R> extends c<N, R, LinkedList<R>> {
        public f() {
            super(new LinkedList());
        }
    }

    /* loaded from: classes3.dex */
    public interface g<N> {
        boolean a(N n);
    }

    /* loaded from: classes3.dex */
    public static class h<N> implements g<N> {
        private final Set<N> a;

        public h() {
            this(new HashSet());
        }

        private static /* synthetic */ void b(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        @Override // h.p2.b0.g.t.p.b.g
        public boolean a(N n) {
            return this.a.add(n);
        }

        public h(@k.e.a.d Set<N> set) {
            if (set == null) {
                b(0);
            }
            this.a = set;
        }
    }

    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i2) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <N, R> R b(@k.e.a.d Collection<N> collection, @k.e.a.d d<N> dVar, @k.e.a.d e<N, R> eVar) {
        if (collection == null) {
            a(4);
        }
        if (dVar == null) {
            a(5);
        }
        if (eVar == null) {
            a(6);
        }
        return (R) c(collection, dVar, new h(), eVar);
    }

    public static <N, R> R c(@k.e.a.d Collection<N> collection, @k.e.a.d d<N> dVar, @k.e.a.d g<N> gVar, @k.e.a.d e<N, R> eVar) {
        if (collection == null) {
            a(0);
        }
        if (dVar == null) {
            a(1);
        }
        if (gVar == null) {
            a(2);
        }
        if (eVar == null) {
            a(3);
        }
        for (N n : collection) {
            d(n, dVar, gVar, eVar);
        }
        return eVar.a();
    }

    public static <N> void d(@k.e.a.d N n, @k.e.a.d d<N> dVar, @k.e.a.d g<N> gVar, @k.e.a.d e<N, ?> eVar) {
        if (n == null) {
            a(22);
        }
        if (dVar == null) {
            a(23);
        }
        if (gVar == null) {
            a(24);
        }
        if (eVar == null) {
            a(25);
        }
        if (gVar.a(n) && eVar.c(n)) {
            for (N n2 : dVar.a(n)) {
                d(n2, dVar, gVar, eVar);
            }
            eVar.b(n);
        }
    }

    public static <N> Boolean e(@k.e.a.d Collection<N> collection, @k.e.a.d d<N> dVar, @k.e.a.d l<N, Boolean> lVar) {
        if (collection == null) {
            a(7);
        }
        if (dVar == null) {
            a(8);
        }
        if (lVar == null) {
            a(9);
        }
        return (Boolean) b(collection, dVar, new a(lVar, new boolean[1]));
    }
}
