package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

/* loaded from: classes.dex */
public class e {
    private int a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private String f724c;

    /* renamed from: d  reason: collision with root package name */
    private long f725d;

    /* renamed from: e  reason: collision with root package name */
    private int f726e;

    public int a() {
        return this.f726e;
    }

    public void a(int i2) {
        this.f726e = i2;
    }

    public void a(long j2) {
        this.f725d = j2;
    }

    public void a(e eVar) {
        this.a = eVar.c();
        this.b = eVar.e();
        this.f724c = eVar.d();
        this.f725d = eVar.b();
        this.f726e = eVar.a();
    }

    public void a(String str) {
        this.f724c = str;
    }

    public long b() {
        return this.f725d;
    }

    public void b(int i2) {
        this.a = i2;
    }

    public void b(long j2) {
        this.b = j2;
    }

    public int c() {
        return this.a;
    }

    public String d() {
        return this.f724c;
    }

    public long e() {
        return this.b;
    }
}
