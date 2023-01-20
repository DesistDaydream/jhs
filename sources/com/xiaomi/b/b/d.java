package com.xiaomi.b.b;

/* loaded from: classes3.dex */
public class d implements Runnable {
    public final /* synthetic */ com.xiaomi.b.a.c a;
    public final /* synthetic */ b b;

    public d(b bVar, com.xiaomi.b.a.c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.a);
    }
}
