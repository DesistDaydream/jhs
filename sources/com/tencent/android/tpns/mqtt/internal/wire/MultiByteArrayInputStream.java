package com.tencent.android.tpns.mqtt.internal.wire;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class MultiByteArrayInputStream extends InputStream {
    private byte[] bytesA;
    private byte[] bytesB;
    private int lengthA;
    private int lengthB;
    private int offsetA;
    private int offsetB;
    private int pos = 0;

    public MultiByteArrayInputStream(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        this.bytesA = bArr;
        this.bytesB = bArr2;
        this.offsetA = i2;
        this.offsetB = i4;
        this.lengthA = i3;
        this.lengthB = i5;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i2;
        int i3 = this.pos;
        int i4 = this.lengthA;
        if (i3 < i4) {
            i2 = this.bytesA[this.offsetA + i3];
        } else if (i3 >= this.lengthB + i4) {
            return -1;
        } else {
            i2 = this.bytesB[(this.offsetB + i3) - i4];
        }
        if (i2 < 0) {
            i2 += 256;
        }
        this.pos = i3 + 1;
        return i2;
    }
}
