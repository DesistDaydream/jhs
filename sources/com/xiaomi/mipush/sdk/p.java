package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gq;
import com.xiaomi.push.hd;
import com.xiaomi.push.hq;
import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public final class p extends m.a {
    public final /* synthetic */ Context a;

    /* renamed from: a */
    public final /* synthetic */ hq f54a;

    public p(hq hqVar, Context context) {
        this.f54a = hqVar;
        this.a = context;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        hq hqVar = this.f54a;
        if (hqVar != null) {
            hqVar.a(com.xiaomi.push.service.ag.a());
            ao.a(this.a.getApplicationContext()).a((ao) this.f54a, gq.Notification, true, (hd) null, true);
        }
    }
}
