package com.bytedance.pangle.res.a;

import java.io.IOException;

/* loaded from: classes.dex */
public final class g extends f {
    public g(i iVar) {
        super(iVar);
    }

    public final int[] a(int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = readInt();
        }
        return iArr;
    }

    public final void b() {
        byte readByte = readByte();
        if (readByte != 0) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (byte) 0, Byte.valueOf(readByte)));
        }
    }

    @Override // com.bytedance.pangle.res.a.f, java.io.DataInput
    public final int skipBytes(int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int skipBytes = super.skipBytes(i2 - i3);
            if (skipBytes <= 0) {
                break;
            }
            i3 += skipBytes;
        }
        return i3;
    }

    public final void a() {
        short readShort = readShort();
        if (readShort != 8) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (short) 8, Short.valueOf(readShort)));
        }
    }

    public final void b(int i2) {
        int readInt;
        while (true) {
            readInt = readInt();
            if (readInt != i2 && readInt >= 1835009) {
                break;
            }
            i2 = -1;
        }
        if (readInt != 1835009) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", 1835009, Integer.valueOf(readInt)));
        }
    }
}
