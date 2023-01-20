package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public final class bc {
    private final byte[] a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f8275c;

    /* renamed from: d  reason: collision with root package name */
    private final OutputStream f8276d;

    /* loaded from: classes3.dex */
    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private bc(OutputStream outputStream, byte[] bArr) {
        this.f8276d = outputStream;
        this.a = bArr;
        this.f8275c = 0;
        this.b = bArr.length;
    }

    private bc(byte[] bArr, int i2, int i3) {
        this.f8276d = null;
        this.a = bArr;
        this.f8275c = i2;
        this.b = i2 + i3;
    }

    public static bc a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static bc a(OutputStream outputStream, int i2) {
        return new bc(outputStream, new byte[i2]);
    }

    public static bc a(byte[] bArr, int i2, int i3) {
        return new bc(bArr, i2, i3);
    }

    public static int b(int i2, com.xiaomi.push.a aVar) {
        return f(i2) + b(aVar);
    }

    public static int b(int i2, de deVar) {
        return f(i2) + b(deVar);
    }

    public static int b(int i2, String str) {
        return f(i2) + b(str);
    }

    public static int b(int i2, boolean z) {
        return f(i2) + b(z);
    }

    public static int b(com.xiaomi.push.a aVar) {
        return h(aVar.a()) + aVar.a();
    }

    public static int b(de deVar) {
        int l2 = deVar.l();
        return h(l2) + l2;
    }

    public static int b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return h(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int c(int i2) {
        if (i2 >= 0) {
            return h(i2);
        }
        return 10;
    }

    public static int c(int i2, int i3) {
        return f(i2) + c(i3);
    }

    public static int c(int i2, long j2) {
        return f(i2) + c(j2);
    }

    public static int c(long j2) {
        return f(j2);
    }

    public static int d(int i2) {
        return h(i2);
    }

    public static int d(int i2, int i3) {
        return f(i2) + d(i3);
    }

    public static int d(int i2, long j2) {
        return f(i2) + d(j2);
    }

    public static int d(long j2) {
        return f(j2);
    }

    private void d() {
        OutputStream outputStream = this.f8276d;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.a, 0, this.f8275c);
        this.f8275c = 0;
    }

    public static int f(int i2) {
        return h(ee.a(i2, 0));
    }

    public static int f(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int h(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public void a() {
        if (this.f8276d != null) {
            d();
        }
    }

    public void a(byte b) {
        if (this.f8275c == this.b) {
            d();
        }
        byte[] bArr = this.a;
        int i2 = this.f8275c;
        this.f8275c = i2 + 1;
        bArr[i2] = b;
    }

    public void a(int i2) {
        if (i2 >= 0) {
            g(i2);
        } else {
            e(i2);
        }
    }

    public void a(int i2, int i3) {
        e(i2, 0);
        a(i3);
    }

    public void a(int i2, long j2) {
        e(i2, 0);
        a(j2);
    }

    public void a(int i2, com.xiaomi.push.a aVar) {
        e(i2, 2);
        a(aVar);
    }

    public void a(int i2, de deVar) {
        e(i2, 2);
        a(deVar);
    }

    public void a(int i2, String str) {
        e(i2, 2);
        a(str);
    }

    public void a(int i2, boolean z) {
        e(i2, 0);
        a(z);
    }

    public void a(long j2) {
        e(j2);
    }

    public void a(com.xiaomi.push.a aVar) {
        byte[] b = aVar.b();
        g(b.length);
        a(b);
    }

    public void a(de deVar) {
        g(deVar.k());
        deVar.a(this);
    }

    public void a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        g(bytes.length);
        a(bytes);
    }

    public void a(boolean z) {
        e(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public int b() {
        if (this.f8276d == null) {
            return this.b - this.f8275c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void b(int i2) {
        g(i2);
    }

    public void b(int i2, int i3) {
        e(i2, 0);
        b(i3);
    }

    public void b(int i2, long j2) {
        e(i2, 0);
        b(j2);
    }

    public void b(long j2) {
        e(j2);
    }

    public void b(byte[] bArr, int i2, int i3) {
        int i4 = this.b;
        int i5 = this.f8275c;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.a, i5, i3);
            this.f8275c += i3;
            return;
        }
        int i6 = i4 - i5;
        System.arraycopy(bArr, i2, this.a, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f8275c = this.b;
        d();
        if (i8 > this.b) {
            this.f8276d.write(bArr, i7, i8);
            return;
        }
        System.arraycopy(bArr, i7, this.a, 0, i8);
        this.f8275c = i8;
    }

    public void c() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void e(int i2) {
        a((byte) i2);
    }

    public void e(int i2, int i3) {
        g(ee.a(i2, i3));
    }

    public void e(long j2) {
        while (((-128) & j2) != 0) {
            e((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        e((int) j2);
    }

    public void g(int i2) {
        while ((i2 & (-128)) != 0) {
            e((i2 & 127) | 128);
            i2 >>>= 7;
        }
        e(i2);
    }
}
