package com.xiaomi.push;

/* loaded from: classes3.dex */
public enum gx {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);
    

    /* renamed from: e  reason: collision with root package name */
    private final int f8731e;

    gx(int i2) {
        this.f8731e = i2;
    }

    public static gx a(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return BOOLEAN;
                }
                return STRING;
            }
            return LONG;
        }
        return INT;
    }
}
