package h.p2.b0.g.t.f.a0.f;

import h.k2.v.f0;
import h.k2.v.u;

/* loaded from: classes3.dex */
public abstract class d {

    /* loaded from: classes3.dex */
    public static final class a extends d {
        @k.e.a.d
        private final String a;
        @k.e.a.d
        private final String b;

        public a(@k.e.a.d String str, @k.e.a.d String str2) {
            super(null);
            this.a = str;
            this.b = str2;
        }

        @Override // h.p2.b0.g.t.f.a0.f.d
        @k.e.a.d
        public String a() {
            return c() + ':' + b();
        }

        @Override // h.p2.b0.g.t.f.a0.f.d
        @k.e.a.d
        public String b() {
            return this.b;
        }

        @Override // h.p2.b0.g.t.f.a0.f.d
        @k.e.a.d
        public String c() {
            return this.a;
        }

        @k.e.a.d
        public final String d() {
            return c();
        }

        @k.e.a.d
        public final String e() {
            return b();
        }

        public boolean equals(@k.e.a.e Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(c(), aVar.c()) && f0.g(b(), aVar.b());
            }
            return false;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends d {
        @k.e.a.d
        private final String a;
        @k.e.a.d
        private final String b;

        public b(@k.e.a.d String str, @k.e.a.d String str2) {
            super(null);
            this.a = str;
            this.b = str2;
        }

        @Override // h.p2.b0.g.t.f.a0.f.d
        @k.e.a.d
        public String a() {
            return f0.C(c(), b());
        }

        @Override // h.p2.b0.g.t.f.a0.f.d
        @k.e.a.d
        public String b() {
            return this.b;
        }

        @Override // h.p2.b0.g.t.f.a0.f.d
        @k.e.a.d
        public String c() {
            return this.a;
        }

        public boolean equals(@k.e.a.e Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f0.g(c(), bVar.c()) && f0.g(b(), bVar.b());
            }
            return false;
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    private d() {
    }

    public /* synthetic */ d(u uVar) {
        this();
    }

    @k.e.a.d
    public abstract String a();

    @k.e.a.d
    public abstract String b();

    @k.e.a.d
    public abstract String c();

    @k.e.a.d
    public final String toString() {
        return a();
    }
}
