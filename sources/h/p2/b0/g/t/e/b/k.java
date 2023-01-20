package h.p2.b0.g.t.e.b;

/* loaded from: classes3.dex */
public interface k extends h.p2.b0.g.t.l.b.o {

    /* loaded from: classes3.dex */
    public static abstract class a {

        /* renamed from: h.p2.b0.g.t.e.b.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0450a extends a {
            @k.e.a.d
            private final byte[] a;

            @k.e.a.d
            public final byte[] b() {
                return this.a;
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends a {
            @k.e.a.d
            private final m a;
            @k.e.a.e
            private final byte[] b;

            public b(@k.e.a.d m mVar, @k.e.a.e byte[] bArr) {
                super(null);
                this.a = mVar;
                this.b = bArr;
            }

            @k.e.a.d
            public final m b() {
                return this.a;
            }

            public /* synthetic */ b(m mVar, byte[] bArr, int i2, h.k2.v.u uVar) {
                this(mVar, (i2 & 2) != 0 ? null : bArr);
            }
        }

        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        @k.e.a.e
        public final m a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.b();
        }
    }

    @k.e.a.e
    a a(@k.e.a.d h.p2.b0.g.t.e.a.x.g gVar);

    @k.e.a.e
    a c(@k.e.a.d h.p2.b0.g.t.g.b bVar);
}
