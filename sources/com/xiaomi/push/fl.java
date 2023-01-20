package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class fl extends XMPushService.j {
    public final /* synthetic */ int a;
    public final /* synthetic */ Exception b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ fj f8594c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fl(fj fjVar, int i2, int i3, Exception exc) {
        super(i2);
        this.f8594c = fjVar;
        this.a = i3;
        this.b = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        this.f8594c.r.a(this.a, this.b);
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "shutdown the connection. " + this.a + ", " + this.b;
    }
}
