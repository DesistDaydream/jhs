package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class d {
    private final boolean a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final int f554c;

    /* renamed from: d  reason: collision with root package name */
    private final int f555d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f556e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f557f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f558g;

    /* renamed from: h  reason: collision with root package name */
    private final int f559h;

    /* renamed from: i  reason: collision with root package name */
    private final int f560i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f561j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f562k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f563l;

    /* renamed from: m  reason: collision with root package name */
    public String f564m;

    /* loaded from: classes.dex */
    public static final class a {
        public boolean a;
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public int f565c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f566d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f567e = -1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f568f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f569g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f570h;

        public a a(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds(i2);
                this.f566d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public d a() {
            return new d(this);
        }

        public a b() {
            this.a = true;
            return this;
        }

        public a c() {
            this.f568f = true;
            return this;
        }
    }

    static {
        new a().b().a();
        new a().c().a(Integer.MAX_VALUE, TimeUnit.SECONDS).a();
    }

    public d(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f554c = aVar.f565c;
        this.f555d = -1;
        this.f556e = false;
        this.f557f = false;
        this.f558g = false;
        this.f559h = aVar.f566d;
        this.f560i = aVar.f567e;
        this.f561j = aVar.f568f;
        this.f562k = aVar.f569g;
        this.f563l = aVar.f570h;
    }

    private d(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.a = z;
        this.b = z2;
        this.f554c = i2;
        this.f555d = i3;
        this.f556e = z3;
        this.f557f = z4;
        this.f558g = z5;
        this.f559h = i4;
        this.f560i = i5;
        this.f561j = z6;
        this.f562k = z7;
        this.f563l = z8;
        this.f564m = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r9.equalsIgnoreCase("Pragma") == false) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r r24) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r):bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d");
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (this.a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.f554c != -1) {
            sb.append("max-age=");
            sb.append(this.f554c);
            sb.append(", ");
        }
        if (this.f555d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f555d);
            sb.append(", ");
        }
        if (this.f556e) {
            sb.append("private, ");
        }
        if (this.f557f) {
            sb.append("public, ");
        }
        if (this.f558g) {
            sb.append("must-revalidate, ");
        }
        if (this.f559h != -1) {
            sb.append("max-stale=");
            sb.append(this.f559h);
            sb.append(", ");
        }
        if (this.f560i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f560i);
            sb.append(", ");
        }
        if (this.f561j) {
            sb.append("only-if-cached, ");
        }
        if (this.f562k) {
            sb.append("no-transform, ");
        }
        if (this.f563l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f563l;
    }

    public boolean b() {
        return this.f556e;
    }

    public boolean c() {
        return this.f557f;
    }

    public int d() {
        return this.f554c;
    }

    public int e() {
        return this.f559h;
    }

    public int f() {
        return this.f560i;
    }

    public boolean g() {
        return this.f558g;
    }

    public boolean h() {
        return this.a;
    }

    public boolean i() {
        return this.b;
    }

    public boolean j() {
        return this.f561j;
    }

    public String toString() {
        String str = this.f564m;
        if (str != null) {
            return str;
        }
        String k2 = k();
        this.f564m = k2;
        return k2;
    }
}
