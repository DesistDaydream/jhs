package h.p2.b0.g.t.k.r;

import h.p2.b0.g.t.k.r.d;

/* loaded from: classes3.dex */
public abstract class c {

    /* loaded from: classes3.dex */
    public static final class a extends c {
        @k.e.a.d
        public static final a a = new a();
        private static final int b;

        static {
            d.a aVar = d.f15480c;
            b = (~(aVar.i() | aVar.d())) & aVar.b();
        }

        private a() {
        }

        @Override // h.p2.b0.g.t.k.r.c
        public int a() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends c {
        @k.e.a.d
        public static final b a = new b();

        private b() {
        }

        @Override // h.p2.b0.g.t.k.r.c
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
