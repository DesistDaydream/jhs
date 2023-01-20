package h.p2.b0.g.t.c.c1;

import h.p2.b0.g.t.c.n0;

/* loaded from: classes3.dex */
public interface c {

    /* loaded from: classes3.dex */
    public static final class a implements c {
        @k.e.a.d
        public static final a a = new a();

        private a() {
        }

        @Override // h.p2.b0.g.t.c.c1.c
        public boolean b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d n0 n0Var) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements c {
        @k.e.a.d
        public static final b a = new b();

        private b() {
        }

        @Override // h.p2.b0.g.t.c.c1.c
        public boolean b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d n0 n0Var) {
            return !n0Var.getAnnotations().n(d.a());
        }
    }

    boolean b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d n0 n0Var);
}
