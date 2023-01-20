package e.b.a.p.j;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final int f9452c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f9453d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f9454e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f9455f;
    private final byte a;
    private int b;

    static {
        byte[] bArr = {-1, ExifInterface.MARKER_APP1, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f9453d = bArr;
        int length = bArr.length;
        f9454e = length;
        f9455f = length + 2;
    }

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 >= -1 && i2 <= 8) {
            this.a = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i2;
        int i3 = this.b;
        if (i3 < 2 || i3 > (i2 = f9455f)) {
            read = super.read();
        } else if (i3 == i2) {
            read = this.a;
        } else {
            read = f9453d[i3 - 2] & 255;
        }
        if (read != -1) {
            this.b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.b = (int) (this.b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.b;
        int i6 = f9455f;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.a;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f9453d, this.b - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.b += i4;
        }
        return i4;
    }
}
