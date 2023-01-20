package com.xiaomi.push.service;

import com.xiaomi.push.gq;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import com.xiaomi.push.m;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class ac extends m.a {
    private hq a;
    private WeakReference<XMPushService> b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9071c;

    public ac(hq hqVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f9071c = false;
        this.a = hqVar;
        this.b = weakReference;
        this.f9071c = z;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.b;
        if (weakReference == null || this.a == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.a.a(ag.a());
        this.a.a(false);
        com.xiaomi.a.a.a.c.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.d());
        try {
            String m2 = this.a.m();
            xMPushService.a(m2, ib.a(j.a(m2, this.a.f(), this.a, gq.Notification)), this.f9071c);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.d("MoleInfo aw_ping : send help app ping error" + e2.toString());
        }
    }
}
