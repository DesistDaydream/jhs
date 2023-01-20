package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aj;

/* loaded from: classes3.dex */
public class al extends XMPushService.j {
    public final /* synthetic */ aj.b.c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(aj.b.c cVar, int i2) {
        super(i2);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        aj.b.c cVar = this.a;
        if (cVar.b == cVar.a.o) {
            com.xiaomi.a.a.a.c.b("clean peer, chid = " + this.a.a.f9080h);
            this.a.a.o = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "clear peer job";
    }
}
