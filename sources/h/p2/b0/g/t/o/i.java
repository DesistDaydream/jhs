package h.p2.b0.g.t.o;

import h.k2.v.u;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.o.b;

/* loaded from: classes3.dex */
public abstract class i implements h.p2.b0.g.t.o.b {
    @k.e.a.d
    private final String a;

    /* loaded from: classes3.dex */
    public static final class a extends i {
        private final int b;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(int r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "must have at least "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " value parameter"
                r0.append(r1)
                r1 = 1
                if (r3 <= r1) goto L18
                java.lang.String r1 = "s"
                goto L1a
            L18:
                java.lang.String r1 = ""
            L1a:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                r2.<init>(r0, r1)
                r2.b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.o.i.a.<init>(int):void");
        }

        @Override // h.p2.b0.g.t.o.b
        public boolean b(@k.e.a.d v vVar) {
            return vVar.h().size() >= this.b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends i {
        private final int b;

        public b(int i2) {
            super("must have exactly " + i2 + " value parameters", null);
            this.b = i2;
        }

        @Override // h.p2.b0.g.t.o.b
        public boolean b(@k.e.a.d v vVar) {
            return vVar.h().size() == this.b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends i {
        @k.e.a.d
        public static final c b = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override // h.p2.b0.g.t.o.b
        public boolean b(@k.e.a.d v vVar) {
            return vVar.h().isEmpty();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends i {
        @k.e.a.d
        public static final d b = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // h.p2.b0.g.t.o.b
        public boolean b(@k.e.a.d v vVar) {
            return vVar.h().size() == 1;
        }
    }

    private i(String str) {
        this.a = str;
    }

    public /* synthetic */ i(String str, u uVar) {
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
