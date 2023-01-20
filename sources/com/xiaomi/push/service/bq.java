package com.xiaomi.push.service;

/* loaded from: classes3.dex */
public class bq implements Runnable {
    public final /* synthetic */ XMPushService a;

    public bq(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f9038c = true;
        try {
            com.xiaomi.a.a.a.c.a("try to trigger the wifi digest broadcast.");
            Object systemService = this.a.getApplicationContext().getSystemService("MiuiWifiService");
            if (systemService != null) {
                com.xiaomi.push.am.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }
}
