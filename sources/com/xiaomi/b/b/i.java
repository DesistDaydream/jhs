package com.xiaomi.b.b;

import com.xiaomi.push.as;

/* loaded from: classes3.dex */
public class i implements Runnable {
    public final /* synthetic */ as a;
    public final /* synthetic */ b b;

    public i(b bVar, as asVar) {
        this.b = bVar;
        this.a = asVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
    }
}
