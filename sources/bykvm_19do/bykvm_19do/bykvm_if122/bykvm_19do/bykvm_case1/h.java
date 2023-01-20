package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

/* loaded from: classes.dex */
public class h {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f767c;

    /* renamed from: d  reason: collision with root package name */
    private String f768d;

    /* renamed from: e  reason: collision with root package name */
    private String f769e;

    /* renamed from: f  reason: collision with root package name */
    private String f770f;

    /* renamed from: g  reason: collision with root package name */
    private String f771g;

    /* renamed from: h  reason: collision with root package name */
    private String f772h;

    /* renamed from: i  reason: collision with root package name */
    private Object f773i;

    /* renamed from: j  reason: collision with root package name */
    private int f774j;

    public String a() {
        return this.f772h;
    }

    public void a(int i2) {
    }

    public void a(Object obj) {
        this.f773i = obj;
    }

    public void a(String str) {
        this.f772h = str;
    }

    public String b() {
        return this.f768d;
    }

    public void b(int i2) {
        this.f774j = i2;
    }

    public void b(String str) {
        this.f768d = str;
    }

    public String c() {
        return this.f771g;
    }

    public void c(String str) {
    }

    public Object d() {
        return this.f773i;
    }

    public void d(String str) {
        this.f771g = str;
    }

    public String e() {
        return this.f767c;
    }

    public void e(String str) {
    }

    public String f() {
        return this.f770f;
    }

    public void f(String str) {
        this.f767c = str;
    }

    public String g() {
        return this.f769e;
    }

    public void g(String str) {
        this.f770f = str;
    }

    public int h() {
        int i2 = this.f774j;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return i2;
    }

    public void h(String str) {
        this.f769e = str;
    }

    public String i() {
        return this.a;
    }

    public void i(String str) {
        this.a = str;
    }

    public String j() {
        return this.b;
    }

    public void j(String str) {
        this.b = str;
    }
}
