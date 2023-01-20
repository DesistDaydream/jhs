package com.qq.e.comm.constants;

/* loaded from: classes3.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);
    
    private int a;

    LoginType(int i2) {
        this.a = i2;
        ordinal();
    }

    public int getValue() {
        return this.a;
    }
}
