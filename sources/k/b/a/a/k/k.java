package k.b.a.a.k;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import k.b.a.a.k.j;

/* loaded from: classes4.dex */
public class k extends FilterInputStream {
    private final j a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16059c;

    /* renamed from: d  reason: collision with root package name */
    private final j.a f16060d;

    public k(InputStream inputStream, j jVar, boolean z) {
        super(inputStream);
        this.f16059c = new byte[1];
        this.f16060d = new j.a();
        this.b = z;
        this.a = jVar;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return !this.f16060d.f16056f ? 1 : 0;
    }

    public boolean j() {
        return this.a.v();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = read(this.f16059c, 0, 1);
        while (read == 0) {
            read = read(this.f16059c, 0, 1);
        }
        if (read > 0) {
            byte b = this.f16059c[0];
            return b < 0 ? b + 256 : b;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        int read;
        if (j2 < 0) {
            throw new IllegalArgumentException("Negative skip length: " + j2);
        }
        byte[] bArr = new byte[512];
        long j3 = j2;
        while (j3 > 0 && (read = read(bArr, 0, (int) Math.min(512, j3))) != -1) {
            j3 -= read;
        }
        return j2 - j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        Objects.requireNonNull(bArr, "array");
        if (i2 >= 0 && i3 >= 0) {
            if (i2 > bArr.length || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            int i4 = 0;
            while (i4 == 0) {
                if (!this.a.r(this.f16060d)) {
                    byte[] bArr2 = new byte[this.b ? 4096 : 8192];
                    int read = ((FilterInputStream) this).in.read(bArr2);
                    if (this.b) {
                        this.a.i(bArr2, 0, read, this.f16060d);
                    } else {
                        this.a.g(bArr2, 0, read, this.f16060d);
                    }
                }
                i4 = this.a.x(bArr, i2, i3, this.f16060d);
            }
            return i4;
        }
        throw new IndexOutOfBoundsException();
    }
}
