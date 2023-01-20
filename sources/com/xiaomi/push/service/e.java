package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fn;
import com.xiaomi.push.hn;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public final class e extends XMPushService.j {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ hn b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i2, XMPushService xMPushService, hn hnVar) {
        super(i2);
        this.a = xMPushService;
        this.b = hnVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        try {
            hn a = cu.a((Context) this.a, this.b);
            a.m().a("miui_message_unrecognized", "1");
            j.a(this.a, a);
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.a(e2);
            this.a.a(10, e2);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "send ack message for unrecognized new miui message.";
    }
}
