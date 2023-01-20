package com.vivo.push;

/* loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ com.vivo.push.b.b a;
    public final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f8138c;

    public j(e eVar, com.vivo.push.b.b bVar, String str) {
        this.f8138c = eVar;
        this.a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8138c.a(this.a);
        this.f8138c.e(this.b);
    }
}
