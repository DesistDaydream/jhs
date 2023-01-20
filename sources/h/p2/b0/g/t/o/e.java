package h.p2.b0.g.t.o;

import h.k2.v.u;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.o.b;

/* loaded from: classes3.dex */
public abstract class e implements h.p2.b0.g.t.o.b {
    @k.e.a.d
    private final String a;

    /* loaded from: classes3.dex */
    public static final class a extends e {
        @k.e.a.d
        public static final a b = new a();

        private a() {
            super("must be a member function", null);
        }

        @Override // h.p2.b0.g.t.o.b
        public boolean b(@k.e.a.d v vVar) {
            return vVar.M() != null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends e {
        @k.e.a.d
        public static final b b = new b();

        private b() {
            super("must be a member or an extension function", null);
        }

        @Override // h.p2.b0.g.t.o.b
        public boolean b(@k.e.a.d v vVar) {
            return (vVar.M() == null && vVar.Q() == null) ? false : true;
        }
    }

    private e(String str) {
        this.a = str;
    }

    public /* synthetic */ e(String str, u uVar) {
        this(str);
    }

    @Override // h.p2.b0.g.t.o.b
    @k.e.a.e
    public String a(@k.e.a.d v vVar) {
        return b.a.a(this, vVar);
    }

    @Override // h.p2.b0.g.t.o.b
    @k.e.a.d
    public String getDescription() {
        return this.a;
    }
}
