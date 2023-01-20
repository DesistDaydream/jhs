package com.xiaomi.push.service;

import com.xiaomi.push.em;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class at {

    /* renamed from: f  reason: collision with root package name */
    private static int f9107f = 300000;
    private XMPushService a;

    /* renamed from: d  reason: collision with root package name */
    private int f9109d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f9110e = 0;
    private int b = 500;

    /* renamed from: c  reason: collision with root package name */
    private long f9108c = 0;

    public at(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private int b() {
        if (this.f9109d > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i2 = this.f9109d;
        if (i2 > 4) {
            return (int) (random * 60000.0d);
        }
        if (i2 > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f9108c == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f9108c >= 310000) {
            this.b = 1000;
            this.f9110e = 0;
            return 0;
        }
        int i3 = this.b;
        int i4 = f9107f;
        if (i3 >= i4) {
            return i3;
        }
        int i5 = this.f9110e + 1;
        this.f9110e = i5;
        if (i5 >= 4) {
            return i4;
        }
        this.b = (int) (i3 * 1.5d);
        return i3;
    }

    public void a() {
        this.f9108c = System.currentTimeMillis();
        this.a.a(1);
        this.f9109d = 0;
    }

    public void a(boolean z) {
        if (!this.a.b()) {
            com.xiaomi.a.a.a.c.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.a.b(1)) {
                this.f9109d++;
            }
            this.a.a(1);
            XMPushService xMPushService = this.a;
            xMPushService.getClass();
            xMPushService.a(new XMPushService.e());
        } else if (this.a.b(1)) {
        } else {
            int b = b();
            this.f9109d++;
            com.xiaomi.a.a.a.c.a("schedule reconnect in " + b + "ms");
            XMPushService xMPushService2 = this.a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.e(), (long) b);
            if (this.f9109d == 2 && em.a().c()) {
                r.b();
            }
            if (this.f9109d == 3) {
                r.a();
            }
        }
    }
}
