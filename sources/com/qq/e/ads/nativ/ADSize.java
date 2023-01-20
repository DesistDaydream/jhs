package com.qq.e.ads.nativ;

/* loaded from: classes3.dex */
public class ADSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private int a;
    private int b;

    public ADSize(int i2, int i3) {
        this.b = i3;
        this.a = i2;
    }

    public int getHeight() {
        return this.b;
    }

    public int getWidth() {
        return this.a;
    }
}
