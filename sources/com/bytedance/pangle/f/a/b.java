package com.bytedance.pangle.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class b {
    public InputStream a;
    private int b;

    public b(InputStream inputStream) {
        a(inputStream);
    }

    public final void a(InputStream inputStream) {
        this.a = inputStream;
        this.b = 0;
    }

    public final void b() {
        long skip = this.a.skip(4L);
        this.b = (int) (this.b + skip);
        if (skip != 4) {
            throw new EOFException();
        }
    }

    public final int a() {
        int i2 = 0;
        for (int i3 = 0; i3 != 32; i3 += 8) {
            int read = this.a.read();
            if (read == -1) {
                throw new EOFException();
            }
            this.b++;
            i2 |= read << i3;
        }
        return i2;
    }

    public final void b(int i2) {
        int a = a();
        if (a != i2) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i2), Integer.valueOf(a)));
        }
    }

    public final int[] a(int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i2 > 0) {
            iArr[i3] = a();
            i2--;
            i3++;
        }
        return iArr;
    }
}
