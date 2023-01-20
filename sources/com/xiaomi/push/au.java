package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes3.dex */
public class au implements Runnable {
    private com.xiaomi.b.c.e a;
    private Context b;

    public void a(Context context) {
        this.b = context;
    }

    public void a(com.xiaomi.b.c.e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ay a;
        String str;
        long currentTimeMillis;
        try {
            com.xiaomi.b.c.e eVar = this.a;
            if (eVar != null) {
                eVar.a();
            }
            com.xiaomi.a.a.a.c.c("begin read and send perf / event");
            com.xiaomi.b.c.e eVar2 = this.a;
            if (eVar2 instanceof com.xiaomi.b.c.a) {
                a = ay.a(this.b);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else if (!(eVar2 instanceof com.xiaomi.b.c.b)) {
                return;
            } else {
                a = ay.a(this.b);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            }
            a.a("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }
}
