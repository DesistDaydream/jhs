package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fn;
import com.xiaomi.push.hn;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public final class f extends XMPushService.j {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ hn b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9178c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i2, XMPushService xMPushService, hn hnVar, String str) {
        super(i2);
        this.a = xMPushService;
        this.b = hnVar;
        this.f9178c = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        try {
            hn a = cu.a((Context) this.a, this.b);
            a.m().a("absent_target_package", this.f9178c);
            j.a(this.a, a);
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.a(e2);
            this.a.a(10, e2);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "send app absent ack message for message.";
    }
}
