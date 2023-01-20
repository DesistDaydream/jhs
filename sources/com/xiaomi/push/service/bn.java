package com.xiaomi.push.service;

import com.xiaomi.push.fn;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class bn extends XMPushService.j {
    public final /* synthetic */ String a;
    public final /* synthetic */ byte[] b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ XMPushService f9133c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(XMPushService xMPushService, int i2, String str, byte[] bArr) {
        super(i2);
        this.f9133c = xMPushService;
        this.a = str;
        this.b = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        try {
            j.a(this.f9133c, this.a, this.b);
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.a(e2);
            this.f9133c.a(10, e2);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "send mi push message";
    }
}
