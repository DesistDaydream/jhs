package com.xiaomi.b.b;

import com.xiaomi.push.at;

/* loaded from: classes3.dex */
public class j implements Runnable {
    public final /* synthetic */ at a;
    public final /* synthetic */ b b;

    public j(b bVar, at atVar) {
        this.b = bVar;
        this.a = atVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
    }
}
