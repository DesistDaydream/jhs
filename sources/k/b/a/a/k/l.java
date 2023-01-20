package k.b.a.a.k;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import k.b.a.a.k.j;

/* loaded from: classes4.dex */
public class l extends FilterOutputStream {
    private final boolean a;
    private final j b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16061c;

    /* renamed from: d  reason: collision with root package name */
    private final j.a f16062d;

    public l(OutputStream outputStream, j jVar, boolean z) {
        super(outputStream);
        this.f16061c = new byte[1];
        this.f16062d = new j.a();
        this.b = jVar;
        this.a = z;
    }

    private void k(boolean z) throws IOException {
        byte[] bArr;
        int x;
        int a = this.b.a(this.f16062d);
        if (a > 0 && (x = this.b.x((bArr = new byte[a]), 0, a, this.f16062d)) > 0) {
            ((FilterOutputStream) this).out.write(bArr, 0, x);
        }
        if (z) {
            ((FilterOutputStream) this).out.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j();
        flush();
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        k(true);
    }

    public void j() throws IOException {
        if (this.a) {
            this.b.i(this.f16061c, 0, -1, this.f16062d);
        } else {
            this.b.g(this.f16061c, 0, -1, this.f16062d);
        }
    }

    public boolean l() {
        return this.b.v();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Objects.requireNonNull(bArr, "array");
        if (i2 >= 0 && i3 >= 0) {
            if (i2 > bArr.length || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 > 0) {
                if (this.a) {
                    this.b.i(bArr, i2, i3, this.f16062d);
                } else {
                    this.b.g(bArr, i2, i3, this.f16062d);
                }
                k(false);
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.f16061c;
        bArr[0] = (byte) i2;
        write(bArr, 0, 1);
    }
}
