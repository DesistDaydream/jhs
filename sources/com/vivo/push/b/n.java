package com.vivo.push.b;

/* loaded from: classes3.dex */
public final class n extends s {
    private String a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8096c;

    public n() {
        super(7);
        this.b = 0;
        this.f8096c = false;
    }

    public final void a(int i2) {
        this.b = i2;
    }

    public final void b(String str) {
        this.a = str;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.a);
        aVar.a("log_level", this.b);
        aVar.a("is_server_log", this.f8096c);
    }

    public final String d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        return this.f8096c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.f8096c = z;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.a("content");
        this.b = aVar.b("log_level", 0);
        this.f8096c = aVar.e("is_server_log");
    }
}
