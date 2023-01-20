package com.xiaomi.push.service;

import com.xiaomi.push.fn;
import com.xiaomi.push.hn;
import com.xiaomi.push.jc;
import com.xiaomi.push.service.XMPushService;
import java.util.Map;

/* loaded from: classes3.dex */
public final class c extends XMPushService.j {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ hn b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, XMPushService xMPushService, hn hnVar) {
        super(i2);
        this.a = xMPushService;
        this.b = hnVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        Map<String, String> map = null;
        try {
            if (jc.a(this.a)) {
                try {
                    map = i.b(this.a, this.b);
                } catch (Throwable unused) {
                }
            }
            j.a(this.a, cu.a(this.a, this.b, map));
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.a(e2);
            this.a.a(10, e2);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "send ack message for message.";
    }
}
