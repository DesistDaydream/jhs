package com.tencent.android.tpns.mqtt.internal.wire;

/* loaded from: classes3.dex */
public class MultiByteInteger {
    private int length;
    private long value;

    public MultiByteInteger(long j2) {
        this(j2, -1);
    }

    public int getEncodedLength() {
        return this.length;
    }

    public long getValue() {
        return this.value;
    }

    public MultiByteInteger(long j2, int i2) {
        this.value = j2;
        this.length = i2;
    }
}
