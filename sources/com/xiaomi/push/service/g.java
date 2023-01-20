package com.xiaomi.push.service;

import android.content.Context;
import com.bytedance.msdk.api.reward.RewardItem;
import com.xiaomi.push.fn;
import com.xiaomi.push.hn;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public final class g extends XMPushService.j {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ hn b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9179c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f9180d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i2, XMPushService xMPushService, hn hnVar, String str, String str2) {
        super(i2);
        this.a = xMPushService;
        this.b = hnVar;
        this.f9179c = str;
        this.f9180d = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        try {
            hn a = cu.a((Context) this.a, this.b);
            a.f8861h.a(com.umeng.analytics.pro.d.O, this.f9179c);
            a.f8861h.a(RewardItem.KEY_REASON, this.f9180d);
            j.a(this.a, a);
        } catch (fn e2) {
            com.xiaomi.a.a.a.c.a(e2);
            this.a.a(10, e2);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "send wrong message ack for message.";
    }
}
