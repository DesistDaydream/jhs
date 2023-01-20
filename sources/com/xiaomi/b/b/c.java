package com.xiaomi.b.b;

/* loaded from: classes3.dex */
public class c implements Runnable {
    public final /* synthetic */ com.xiaomi.b.a.b a;
    public final /* synthetic */ b b;

    public c(b bVar, com.xiaomi.b.a.b bVar2) {
        this.b = bVar;
        this.a = bVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.a);
    }
}
