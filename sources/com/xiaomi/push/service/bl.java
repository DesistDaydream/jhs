package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gq;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;

/* loaded from: classes3.dex */
public final class bl implements Runnable {
    public final /* synthetic */ hq a;

    public bl(hq hqVar) {
        this.a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        byte[] a = ib.a(j.a(this.a.m(), this.a.f(), this.a, gq.Notification));
        context = bk.f9132c;
        if (!(context instanceof XMPushService)) {
            com.xiaomi.a.a.a.c.a("UNDatas UploadNotificationDatas failed because not xmsf");
            return;
        }
        context2 = bk.f9132c;
        ((XMPushService) context2).a(this.a.m(), a, true);
    }
}
