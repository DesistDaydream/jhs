package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import e.b.a.p.k.x.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f1720c;

    /* renamed from: d  reason: collision with root package name */
    private int f1721d;

    /* renamed from: e  reason: collision with root package name */
    private int f1722e;

    /* renamed from: f  reason: collision with root package name */
    private final b f1723f;

    /* loaded from: classes.dex */
    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f1721d;
        if (i2 != -1) {
            int i3 = this.f1722e - i2;
            int i4 = this.f1720c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f1723f.c(i4, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.a = bArr2;
                    this.f1723f.e(bArr);
                    bArr = bArr2;
                } else if (i2 > 0) {
                    System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
                }
                int i5 = this.f1722e - this.f1721d;
                this.f1722e = i5;
                this.f1721d = 0;
                this.b = 0;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.f1722e;
                if (read > 0) {
                    i6 += read;
                }
                this.b = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f1721d = -1;
            this.f1722e = 0;
            this.b = read2;
        }
        return read2;
    }

    private static IOException l() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.a != null && inputStream != null) {
        } else {
            throw l();
        }
        return (this.b - this.f1722e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.a != null) {
            this.f1723f.e(this.a);
            this.a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void j() {
        this.f1720c = this.a.length;
    }

    public synchronized void k() {
        if (this.a != null) {
            this.f1723f.e(this.a);
            this.a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f1720c = Math.max(this.f1720c, i2);
        this.f1721d = this.f1722e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f1722e < this.b || a(inputStream, bArr) != -1) {
                if (bArr != this.a && (bArr = this.a) == null) {
                    throw l();
                }
                int i2 = this.b;
                int i3 = this.f1722e;
                if (i2 - i3 > 0) {
                    this.f1722e = i3 + 1;
                    return bArr[i3] & 255;
                }
                return -1;
            }
            return -1;
        }
        throw l();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.a != null) {
            int i2 = this.f1721d;
            if (-1 != i2) {
                this.f1722e = i2;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f1722e + " markLimit: " + this.f1720c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i2 = this.b;
                int i3 = this.f1722e;
                if (i2 - i3 >= j2) {
                    this.f1722e = (int) (i3 + j2);
                    return j2;
                }
                long j3 = i2 - i3;
                this.f1722e = i2;
                if (this.f1721d != -1 && j2 <= this.f1720c) {
                    if (a(inputStream, bArr) == -1) {
                        return j3;
                    }
                    int i4 = this.b;
                    int i5 = this.f1722e;
                    if (i4 - i5 >= j2 - j3) {
                        this.f1722e = (int) ((i5 + j2) - j3);
                        return j2;
                    }
                    long j4 = (j3 + i4) - i5;
                    this.f1722e = i4;
                    return j4;
                }
                long skip = inputStream.skip(j2 - j3);
                if (skip > 0) {
                    this.f1721d = -1;
                }
                return j3 + skip;
            }
            throw l();
        }
        throw l();
    }

    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull b bVar, int i2) {
        super(inputStream);
        this.f1721d = -1;
        this.f1723f = bVar;
        this.a = (byte[]) bVar.c(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            throw l();
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i6 = this.f1722e;
            int i7 = this.b;
            if (i6 < i7) {
                int i8 = i7 - i6 >= i3 ? i3 : i7 - i6;
                System.arraycopy(bArr2, i6, bArr, i2, i8);
                this.f1722e += i8;
                if (i8 == i3 || inputStream.available() == 0) {
                    return i8;
                }
                i2 += i8;
                i4 = i3 - i8;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f1721d == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else if (a(inputStream, bArr2) == -1) {
                    return i4 != i3 ? i3 - i4 : -1;
                } else {
                    if (bArr2 != this.a && (bArr2 = this.a) == null) {
                        throw l();
                    }
                    int i9 = this.b;
                    int i10 = this.f1722e;
                    i5 = i9 - i10 >= i4 ? i4 : i9 - i10;
                    System.arraycopy(bArr2, i10, bArr, i2, i5);
                    this.f1722e += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            throw l();
        }
    }
}
