package com.vivo.push.b;

/* loaded from: classes3.dex */
public final class b extends c {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f8088c;

    /* renamed from: d  reason: collision with root package name */
    private String f8089d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8090e;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, str);
        this.f8090e = false;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.a);
        aVar.a("sdk_version", 323L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.f8088c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.b);
        aVar.a("PUSH_REGID", this.f8089d);
    }

    public final void d() {
        this.f8088c = null;
    }

    public final void e() {
        this.b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.a("sdk_clients");
        this.f8088c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.f8089d = aVar.a("PUSH_REGID");
    }
}
