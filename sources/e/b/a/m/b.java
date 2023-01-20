package e.b.a.m;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class b implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    private static final byte f9389f = 13;

    /* renamed from: g  reason: collision with root package name */
    private static final byte f9390g = 10;
    private final InputStream a;
    private final Charset b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f9391c;

    /* renamed from: d  reason: collision with root package name */
    private int f9392d;

    /* renamed from: e  reason: collision with root package name */
    private int f9393e;

    /* loaded from: classes.dex */
    public class a extends ByteArrayOutputStream {
        public a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0 && ((ByteArrayOutputStream) this).buf[i2 - 1] == 13) {
                i2--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, b.this.b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void j() throws IOException {
        InputStream inputStream = this.a;
        byte[] bArr = this.f9391c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f9392d = 0;
            this.f9393e = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.a) {
            if (this.f9391c != null) {
                this.f9391c = null;
                this.a.close();
            }
        }
    }

    public boolean k() {
        return this.f9393e == -1;
    }

    public String l() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.a) {
            if (this.f9391c != null) {
                if (this.f9392d >= this.f9393e) {
                    j();
                }
                for (int i4 = this.f9392d; i4 != this.f9393e; i4++) {
                    byte[] bArr2 = this.f9391c;
                    if (bArr2[i4] == 10) {
                        if (i4 != this.f9392d) {
                            i3 = i4 - 1;
                            if (bArr2[i3] == 13) {
                                byte[] bArr3 = this.f9391c;
                                int i5 = this.f9392d;
                                String str = new String(bArr3, i5, i3 - i5, this.b.name());
                                this.f9392d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        byte[] bArr32 = this.f9391c;
                        int i52 = this.f9392d;
                        String str2 = new String(bArr32, i52, i3 - i52, this.b.name());
                        this.f9392d = i4 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f9393e - this.f9392d) + 80);
                loop1: while (true) {
                    byte[] bArr4 = this.f9391c;
                    int i6 = this.f9392d;
                    aVar.write(bArr4, i6, this.f9393e - i6);
                    this.f9393e = -1;
                    j();
                    i2 = this.f9392d;
                    while (i2 != this.f9393e) {
                        bArr = this.f9391c;
                        if (bArr[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                int i7 = this.f9392d;
                if (i2 != i7) {
                    aVar.write(bArr, i7, i2 - i7);
                }
                this.f9392d = i2 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 >= 0) {
            if (charset.equals(c.a)) {
                this.a = inputStream;
                this.b = charset;
                this.f9391c = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
