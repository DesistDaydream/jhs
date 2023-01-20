package com.xiaomi.push.service;

import com.xiaomi.push.service.ba;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class bb implements Runnable {
    public final /* synthetic */ ba a;

    public bb(ba baVar) {
        this.a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.a.f9125e;
            for (ba.a aVar : concurrentHashMap.values()) {
                aVar.run();
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("Sync job exception :" + e2.getMessage());
        }
        this.a.f9124d = false;
    }
}
