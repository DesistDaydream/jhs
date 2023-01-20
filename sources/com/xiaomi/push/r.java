package com.xiaomi.push;

import com.xiaomi.push.p;

/* loaded from: classes3.dex */
public class r implements Runnable {
    public final /* synthetic */ p.b a;
    public final /* synthetic */ p b;

    public r(p pVar, p.b bVar) {
        this.b = pVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a);
    }
}
