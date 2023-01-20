package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public enum bf {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    SHOW_STANDARD_UNFIT(3040001, "容器大小不达标");
    

    /* renamed from: c  reason: collision with root package name */
    public static final String f1483c = "msg";

    /* renamed from: d  reason: collision with root package name */
    private int f1485d;

    /* renamed from: e  reason: collision with root package name */
    private String f1486e;

    bf(int i2, String str) {
        this.f1485d = i2;
        this.f1486e = str;
    }

    public int b() {
        return this.f1485d;
    }

    public String c() {
        return this.f1486e;
    }
}
