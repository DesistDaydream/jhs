package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;

/* loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ k b;

    public l(k kVar, List list) {
        this.b = kVar;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j2;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j3;
        int i2;
        r.a aVar;
        insideNotificationItem = this.b.b;
        if (insideNotificationItem != null) {
            w b = w.b();
            j2 = this.b.f8169c;
            b.a("com.vivo.push.notify_key", j2);
            context = this.b.a;
            List list = this.a;
            insideNotificationItem2 = this.b.b;
            j3 = this.b.f8169c;
            i2 = this.b.f8171e;
            aVar = this.b.f8172f;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j3, i2, aVar);
        }
    }
}
