package com.xiaomi.push.service;

import com.xiaomi.push.fc;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class by extends XMPushService.j {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ byte[] f9135c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ XMPushService f9136d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(XMPushService xMPushService, int i2, int i3, String str, byte[] bArr) {
        super(i2);
        this.f9136d = xMPushService;
        this.a = i3;
        this.b = str;
        this.f9135c = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        fc fcVar;
        cq.b(this.f9136d);
        aj.a().a("5");
        com.xiaomi.push.f.a(this.a);
        fcVar = this.f9136d.f9039d;
        fcVar.c(fc.a());
        com.xiaomi.a.a.a.c.a("clear account and start registration. " + this.b);
        this.f9136d.a(this.f9135c, this.b);
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "clear account cache.";
    }
}
