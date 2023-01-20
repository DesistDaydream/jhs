package h.p2.b0.g.t.o;

import h.k2.v.u;

/* loaded from: classes3.dex */
public abstract class c {
    private final boolean a;

    /* loaded from: classes3.dex */
    public static final class a extends c {
        @k.e.a.d
        public static final a b = new a();

        private a() {
            super(false, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends c {
        @k.e.a.d
        private final String b;

        public b(@k.e.a.d String str) {
            super(false, null);
            this.b = str;
        }
    }

    /* renamed from: h.p2.b0.g.t.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0471c extends c {
        @k.e.a.d
        public static final C0471c b = new C0471c();

        private C0471c() {
            super(true, null);
        }
    }

    private c(boolean z) {
        this.a = z;
    }

    public /* synthetic */ c(boolean z, u uVar) {
        this(z);
    }

    public final boolean a() {
        return this.a;
    }
}
