package h.p2.b0.g.t.f.a0.f;

import h.k2.v.u;

/* loaded from: classes3.dex */
public final class e extends h.p2.b0.g.t.f.z.a {
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    public static final a f15359h = new a(null);
    @h.k2.d
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    public static final e f15360i = new e(1, 5, 1);
    @h.k2.d
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    public static final e f15361j = new e(new int[0]);

    /* renamed from: g  reason: collision with root package name */
    private final boolean f15362g;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e(@k.e.a.d int[] r4, boolean r5) {
        /*
            r3 = this;
            int r0 = r4.length
            int[] r0 = new int[r0]
            int r1 = r4.length
            r2 = 0
            java.lang.System.arraycopy(r4, r2, r0, r2, r1)
            r3.<init>(r0)
            r3.f15362g = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.f.a0.f.e.<init>(int[], boolean):void");
    }

    public boolean h() {
        boolean z;
        if (a() == 1 && b() == 0) {
            return false;
        }
        if (this.f15362g) {
            z = f(f15360i);
        } else {
            int a2 = a();
            e eVar = f15360i;
            z = a2 == eVar.a() && b() <= eVar.b() + 1;
        }
        return z;
    }

    public e(@k.e.a.d int... iArr) {
        this(iArr, false);
    }
}
