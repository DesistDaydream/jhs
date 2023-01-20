package e.c.a.b;

/* loaded from: classes.dex */
public class a {
    private final String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f9957c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9958d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9959e;

    /* loaded from: classes.dex */
    public static class b {
        private String a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String[] f9960c;

        /* renamed from: d  reason: collision with root package name */
        private String[] f9961d;

        /* renamed from: e  reason: collision with root package name */
        private String f9962e;

        /* renamed from: f  reason: collision with root package name */
        private String f9963f;

        /* renamed from: g  reason: collision with root package name */
        private String f9964g;

        /* renamed from: h  reason: collision with root package name */
        private String f9965h;

        public b a(String str) {
            this.a = str;
            return this;
        }

        public b b(String[] strArr) {
            this.f9960c = strArr;
            return this;
        }

        public a c() {
            return new a(this);
        }

        public b e(String str) {
            this.b = str;
            return this;
        }

        public b f(String[] strArr) {
            this.f9961d = strArr;
            return this;
        }

        public b h(String str) {
            this.f9962e = str;
            return this;
        }

        public b j(String str) {
            this.f9963f = str;
            return this;
        }

        public b l(String str) {
            this.f9965h = str;
            return this;
        }
    }

    private a(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.f9957c = bVar.f9960c;
        String[] unused = bVar.f9961d;
        this.f9958d = bVar.f9962e;
        this.f9959e = bVar.f9963f;
        String unused2 = bVar.f9964g;
        String unused3 = bVar.f9965h;
    }

    public String a() {
        return this.f9959e;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String[] d() {
        return this.f9957c;
    }

    public String e() {
        return this.f9958d;
    }
}
