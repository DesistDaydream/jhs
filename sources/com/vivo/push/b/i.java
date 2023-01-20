package com.vivo.push.b;

/* loaded from: classes3.dex */
public final class i extends s {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f8095c;

    public i(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("app_id", this.a);
        aVar.a("client_id", this.b);
        aVar.a("client_token", this.f8095c);
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.f8095c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.a("app_id");
        this.b = aVar.a("client_id");
        this.f8095c = aVar.a("client_token");
    }
}
