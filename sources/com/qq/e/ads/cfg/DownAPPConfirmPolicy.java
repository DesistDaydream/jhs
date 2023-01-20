package com.qq.e.ads.cfg;

/* loaded from: classes3.dex */
public enum DownAPPConfirmPolicy {
    Default(0),
    NOConfirm(2);
    
    private final int a;

    DownAPPConfirmPolicy(int i2) {
        this.a = i2;
    }

    public int value() {
        return this.a;
    }
}
