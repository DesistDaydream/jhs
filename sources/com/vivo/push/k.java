package com.vivo.push;

import com.vivo.push.e;

/* loaded from: classes3.dex */
public final class k implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ e b;

    public k(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a d2;
        d2 = this.b.d(this.a);
        if (d2 != null) {
            d2.a(1003, new Object[0]);
        }
    }
}
