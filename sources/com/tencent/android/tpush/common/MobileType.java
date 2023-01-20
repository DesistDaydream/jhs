package com.tencent.android.tpush.common;

/* loaded from: classes3.dex */
public enum MobileType {
    UNKNOWN((byte) 0, "未知运营商"),
    TELCOM((byte) 1, "中国电信"),
    UNICOM((byte) 2, "中国联通"),
    CHINAMOBILE((byte) 3, "中国移动");
    
    private String str;
    private byte type;

    MobileType(byte b, String str) {
        this.type = b;
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }

    public byte getType() {
        return this.type;
    }
}
