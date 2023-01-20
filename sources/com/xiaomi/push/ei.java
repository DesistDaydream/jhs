package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class ei extends XMPushService.j {
    public final /* synthetic */ eh a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei(eh ehVar, int i2) {
        super(i2);
        this.a = ehVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        this.a.c();
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "Handling bind stats";
    }
}
