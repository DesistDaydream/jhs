package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.m;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class bb extends m.a {
    public final /* synthetic */ az a;

    public bb(az azVar) {
        this.a = azVar;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "10054";
    }

    @Override // java.lang.Runnable
    public void run() {
        String d2;
        Context context;
        Context context2;
        com.xiaomi.a.a.a.c.c("exec== DbSizeControlJob");
        d2 = this.a.d();
        context = this.a.f8267f;
        bf bfVar = new bf(d2, new WeakReference(context));
        context2 = this.a.f8267f;
        bm.a(context2).a(bfVar);
        this.a.b("check_time");
    }
}
