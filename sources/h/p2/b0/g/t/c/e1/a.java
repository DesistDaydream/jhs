package h.p2.b0.g.t.c.e1;

import h.k2.v.f0;
import h.p2.b0.g.t.c.a1;
import h.p2.b0.g.t.c.z0;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public final class a {
    @d
    public static final a a = new a();

    /* renamed from: h.p2.b0.g.t.c.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0440a extends a1 {
        @d

        /* renamed from: c  reason: collision with root package name */
        public static final C0440a f15187c = new C0440a();

        private C0440a() {
            super("package", false);
        }

        @Override // h.p2.b0.g.t.c.a1
        @e
        public Integer a(@d a1 a1Var) {
            if (this == a1Var) {
                return 0;
            }
            return z0.a.b(a1Var) ? 1 : -1;
        }

        @Override // h.p2.b0.g.t.c.a1
        @d
        public String b() {
            return "public/*package*/";
        }

        @Override // h.p2.b0.g.t.c.a1
        @d
        public a1 d() {
            return z0.g.f15227c;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends a1 {
        @d

        /* renamed from: c  reason: collision with root package name */
        public static final b f15188c = new b();

        private b() {
            super("protected_and_package", true);
        }

        @Override // h.p2.b0.g.t.c.a1
        @e
        public Integer a(@d a1 a1Var) {
            if (f0.g(this, a1Var)) {
                return 0;
            }
            if (a1Var == z0.b.f15222c) {
                return null;
            }
            return Integer.valueOf(z0.a.b(a1Var) ? 1 : -1);
        }

        @Override // h.p2.b0.g.t.c.a1
        @d
        public String b() {
            return "protected/*protected and package*/";
        }

        @Override // h.p2.b0.g.t.c.a1
        @d
        public a1 d() {
            return z0.g.f15227c;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends a1 {
        @d

        /* renamed from: c  reason: collision with root package name */
        public static final c f15189c = new c();

        private c() {
            super("protected_static", true);
        }

        @Override // h.p2.b0.g.t.c.a1
        @d
        public String b() {
            return "protected/*protected static*/";
        }

        @Override // h.p2.b0.g.t.c.a1
        @d
        public a1 d() {
            return z0.g.f15227c;
        }
    }

    private a() {
    }
}
