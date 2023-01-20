package com.xiaomi.push;

/* loaded from: classes3.dex */
public class fm implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ fj b;

    public fm(fj fjVar, String str) {
        this.b = fjVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        by.a().a(this.a, true);
    }
}
