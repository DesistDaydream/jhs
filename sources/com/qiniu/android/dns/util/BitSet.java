package com.qiniu.android.dns.util;

/* loaded from: classes3.dex */
public final class BitSet {
    private int set = 0;

    public boolean allIsSet(int i2) {
        return this.set + 1 == (1 << i2);
    }

    public BitSet clear() {
        this.set = 0;
        return this;
    }

    public boolean isSet(int i2) {
        return ((1 << i2) & this.set) != 0;
    }

    public int leadingZeros() {
        int i2 = 16;
        int i3 = this.set >> 16;
        if (i3 != 0) {
            this.set = i3;
        } else {
            i2 = 32;
        }
        int i4 = this.set >> 8;
        if (i4 != 0) {
            i2 -= 8;
            this.set = i4;
        }
        int i5 = this.set >> 4;
        if (i5 != 0) {
            i2 -= 4;
            this.set = i5;
        }
        int i6 = this.set >> 2;
        if (i6 != 0) {
            i2 -= 2;
            this.set = i6;
        }
        int i7 = this.set;
        return (i7 >> 1) != 0 ? i2 - 2 : i2 - i7;
    }

    public boolean noneIsSet(int i2) {
        return this.set == 0;
    }

    public BitSet set(int i2) {
        this.set = (1 << i2) | this.set;
        return this;
    }

    public int value() {
        return this.set;
    }
}
