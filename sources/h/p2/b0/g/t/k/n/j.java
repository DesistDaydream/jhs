package h.p2.b0.g.t.k.n;

import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.n.f0;
import h.t1;

/* loaded from: classes3.dex */
public abstract class j extends g<t1> {
    @k.e.a.d
    public static final a b = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        @k.e.a.d
        public final j a(@k.e.a.d String str) {
            return new b(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends j {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        private final String f15476c;

        public b(@k.e.a.d String str) {
            this.f15476c = str;
        }

        @Override // h.p2.b0.g.t.k.n.g
        @k.e.a.d
        public String toString() {
            return this.f15476c;
        }

        @Override // h.p2.b0.g.t.k.n.g
        @k.e.a.d
        public f0 getType(@k.e.a.d z zVar) {
            return h.p2.b0.g.t.n.s.j(this.f15476c);
        }
    }

    public j() {
        super(t1.a);
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    /* renamed from: b */
    public t1 a() {
        throw new UnsupportedOperationException();
    }
}
