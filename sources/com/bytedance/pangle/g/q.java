package com.bytedance.pangle.g;

/* loaded from: classes.dex */
public final class q extends Exception {
    public final int a;

    public q(int i2, String str) {
        super(str);
        this.a = i2;
    }

    public q(int i2, String str, Throwable th) {
        super(str, th);
        this.a = i2;
    }
}
