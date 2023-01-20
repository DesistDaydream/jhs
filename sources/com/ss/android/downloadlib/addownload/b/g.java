package com.ss.android.downloadlib.addownload.b;

/* loaded from: classes3.dex */
public class g {
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f5261c;

    public g(int i2) {
        this(i2, 0, null);
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.f5261c;
    }

    public int getType() {
        return this.a;
    }

    public g(int i2, int i3) {
        this(i2, i3, null);
    }

    public g(int i2, String str) {
        this(i2, 0, str);
    }

    public g(int i2, int i3, String str) {
        this.a = i2;
        this.b = i3;
        this.f5261c = str;
    }
}
