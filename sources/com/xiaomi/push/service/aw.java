package com.xiaomi.push.service;

import com.xiaomi.push.eq;
import com.xiaomi.push.fn;
import com.xiaomi.push.gp;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class aw extends XMPushService.j {
    private XMPushService a;
    private eq b;

    public aw(XMPushService xMPushService, eq eqVar) {
        super(4);
        this.a = null;
        this.a = xMPushService;
        this.b = eqVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        try {
            eq eqVar = this.b;
            if (eqVar != null) {
                this.a.a(eqVar);
                if (this.b.f8538c == null || !gp.a(this.a, 1)) {
                    return;
                }
                this.b.f8538c.f9192h = System.currentTimeMillis();
                bc.a("category_coord_up", "coord_up", "com.xiaomi.xmsf", this.b.f8538c);
            }
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.a(e2);
            this.a.a(10, e2);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "send a message.";
    }
}
