package com.xiaomi.push;

/* loaded from: classes3.dex */
public enum he {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: d  reason: collision with root package name */
    private final int f8790d;

    he(int i2) {
        this.f8790d = i2;
    }

    public static he a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return Init;
            }
            return PackageUnregistered;
        }
        return RegIdExpired;
    }

    public int a() {
        return this.f8790d;
    }
}
