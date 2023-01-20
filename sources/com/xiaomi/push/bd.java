package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public class bd extends m.a {
    public final /* synthetic */ az a;

    public bd(az azVar) {
        this.a = azVar;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "10053";
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVar;
        bq bqVar2;
        Context context;
        bqVar = this.a.f8271j;
        if (bqVar != null) {
            bqVar2 = this.a.f8271j;
            context = this.a.f8267f;
            bqVar2.b(context);
            this.a.b("delete_time");
        }
    }
}
