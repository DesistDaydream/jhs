package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public final class y implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Intent f59a;

    public y(Context context, Intent intent) {
        this.a = context;
        this.f59a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f59a);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2.getMessage());
        }
    }
}
