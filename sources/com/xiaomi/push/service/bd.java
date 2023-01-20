package com.xiaomi.push.service;

import com.xiaomi.push.eq;
import com.xiaomi.push.fn;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class bd extends XMPushService.j {
    private XMPushService a;
    private eq[] b;

    public bd(XMPushService xMPushService, eq[] eqVarArr) {
        super(4);
        this.a = null;
        this.a = xMPushService;
        this.b = eqVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        try {
            eq[] eqVarArr = this.b;
            if (eqVarArr != null) {
                this.a.a(eqVarArr);
            }
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.a(e2);
            this.a.a(10, e2);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "batch send message.";
    }
}
