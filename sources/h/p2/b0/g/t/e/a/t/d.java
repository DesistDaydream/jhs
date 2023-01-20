package h.p2.b0.g.t.e.a.t;

import h.p2.b0.g.t.c.j;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.l;
import h.p2.b0.g.t.e.a.x.n;
import h.p2.b0.g.t.e.a.x.q;

/* loaded from: classes3.dex */
public interface d {
    public static final d a = new a();

    /* loaded from: classes3.dex */
    public static class a implements d {
        private static /* synthetic */ void f(int i2) {
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i2) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.e.a.t.d
        public void a(@k.e.a.d l lVar, @k.e.a.d j jVar) {
            if (lVar == null) {
                f(3);
            }
            if (jVar == null) {
                f(4);
            }
        }

        @Override // h.p2.b0.g.t.e.a.t.d
        public void b(@k.e.a.d n nVar, @k.e.a.d j0 j0Var) {
            if (nVar == null) {
                f(5);
            }
            if (j0Var == null) {
                f(6);
            }
        }

        @Override // h.p2.b0.g.t.e.a.t.d
        public void c(@k.e.a.d q qVar, @k.e.a.d n0 n0Var) {
            if (qVar == null) {
                f(1);
            }
            if (n0Var == null) {
                f(2);
            }
        }

        @Override // h.p2.b0.g.t.e.a.t.d
        @k.e.a.e
        public h.p2.b0.g.t.c.d d(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
            if (cVar == null) {
                f(0);
                return null;
            }
            return null;
        }

        @Override // h.p2.b0.g.t.e.a.t.d
        public void e(@k.e.a.d g gVar, @k.e.a.d h.p2.b0.g.t.c.d dVar) {
            if (gVar == null) {
                f(7);
            }
            if (dVar == null) {
                f(8);
            }
        }
    }

    void a(@k.e.a.d l lVar, @k.e.a.d j jVar);

    void b(@k.e.a.d n nVar, @k.e.a.d j0 j0Var);

    void c(@k.e.a.d q qVar, @k.e.a.d n0 n0Var);

    @k.e.a.e
    h.p2.b0.g.t.c.d d(@k.e.a.d h.p2.b0.g.t.g.c cVar);

    void e(@k.e.a.d g gVar, @k.e.a.d h.p2.b0.g.t.c.d dVar);
}
