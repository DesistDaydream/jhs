package com.xiaomi.b.b;

import com.xiaomi.push.m;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class g extends m.a {
    public final /* synthetic */ b a;

    public g(b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "100889";
    }

    @Override // java.lang.Runnable
    public void run() {
        int h2;
        ExecutorService executorService;
        h2 = this.a.h();
        if (h2 > 0) {
            executorService = this.a.f8210c;
            executorService.execute(new h(this));
        }
    }
}
