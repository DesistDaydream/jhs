package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aj;

/* loaded from: classes3.dex */
public class am extends XMPushService.j {
    public final /* synthetic */ aj.b.c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(aj.b.c cVar, int i2) {
        super(i2);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        aj a = aj.a();
        aj.b bVar = this.a.a;
        if (a.b(bVar.f9080h, bVar.b).o == null) {
            XMPushService xMPushService = aj.b.this.t;
            aj.b bVar2 = this.a.a;
            xMPushService.a(bVar2.f9080h, bVar2.b, 2, null, null);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "check peer job";
    }
}
