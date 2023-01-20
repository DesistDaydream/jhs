package e.b.a.p.j;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class c extends OutputStream {
    @NonNull
    private final OutputStream a;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private e.b.a.p.k.x.b f9450c;

    /* renamed from: d  reason: collision with root package name */
    private int f9451d;

    public c(@NonNull OutputStream outputStream, @NonNull e.b.a.p.k.x.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void j() throws IOException {
        int i2 = this.f9451d;
        if (i2 > 0) {
            this.a.write(this.b, 0, i2);
            this.f9451d = 0;
        }
    }

    private void k() throws IOException {
        if (this.f9451d == this.b.length) {
            j();
        }
    }

    private void l() {
        byte[] bArr = this.b;
        if (bArr != null) {
            this.f9450c.e(bArr);
            this.b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.a.close();
            l();
        } catch (Throwable th) {
            this.a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        j();
        this.a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.b;
        int i3 = this.f9451d;
        this.f9451d = i3 + 1;
        bArr[i3] = (byte) i2;
        k();
    }

    @VisibleForTesting
    public c(@NonNull OutputStream outputStream, e.b.a.p.k.x.b bVar, int i2) {
        this.a = outputStream;
        this.f9450c = bVar;
        this.b = (byte[]) bVar.c(i2, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            int i7 = this.f9451d;
            if (i7 == 0 && i5 >= this.b.length) {
                this.a.write(bArr, i6, i5);
                return;
            }
            int min = Math.min(i5, this.b.length - i7);
            System.arraycopy(bArr, i6, this.b, this.f9451d, min);
            this.f9451d += min;
            i4 += min;
            k();
        } while (i4 < i3);
    }
}
