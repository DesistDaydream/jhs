package com.xiaomi.push;

/* loaded from: classes3.dex */
public enum gw {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: c  reason: collision with root package name */
    private final int f8727c;

    gw(int i2) {
        this.f8727c = i2;
    }

    public static gw a(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            return PLUGIN_CONFIG;
        }
        return MISC_CONFIG;
    }

    public int a() {
        return this.f8727c;
    }
}
