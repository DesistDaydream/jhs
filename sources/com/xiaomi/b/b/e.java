package com.xiaomi.b.b;

import com.xiaomi.push.m;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class e extends m.a {
    public final /* synthetic */ b a;

    public e(b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "100888";
    }

    @Override // java.lang.Runnable
    public void run() {
        int g2;
        ExecutorService executorService;
        g2 = this.a.g();
        if (g2 > 0) {
            executorService = this.a.f8210c;
            executorService.execute(new f(this));
        }
    }
}
