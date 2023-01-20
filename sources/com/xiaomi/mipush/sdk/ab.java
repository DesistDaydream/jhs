package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes3.dex */
public class ab implements Runnable {
    public final /* synthetic */ MiTinyDataClient.a.C0296a a;

    public ab(MiTinyDataClient.a.C0296a c0296a) {
        this.a = c0296a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f11a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f12a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f12a;
            scheduledFuture2.cancel(false);
            this.a.f12a = null;
        }
    }
}
