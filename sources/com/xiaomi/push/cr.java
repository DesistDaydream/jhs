package com.xiaomi.push;

/* loaded from: classes3.dex */
public class cr {
    private static volatile cr b;
    private cq a;

    public static cr a() {
        if (b == null) {
            synchronized (cr.class) {
                if (b == null) {
                    b = new cr();
                }
            }
        }
        return b;
    }

    public void a(cq cqVar) {
        this.a = cqVar;
    }

    public cq b() {
        return this.a;
    }
}
