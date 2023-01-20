package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.caverock.androidsvg.SVG;
import h.t2.y;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes.dex */
public final class n implements e {
    public final c a = new c();
    public final s b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f288c;

    public n(s sVar) {
        Objects.requireNonNull(sVar, "source == null");
        this.b = sVar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public long a(byte b) throws IOException {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j2, long j3) throws IOException {
        if (this.f288c) {
            throw new IllegalStateException("closed");
        }
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j2), Long.valueOf(j3)));
        }
        while (j2 < j3) {
            long a = this.a.a(b, j2, j3);
            if (a != -1) {
                return a;
            }
            c cVar = this.a;
            long j4 = cVar.b;
            if (j4 >= j3 || this.b.a(cVar, SVG.A) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, j4);
        }
        return -1L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j2) throws IOException {
        if (cVar != null) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.f288c) {
                throw new IllegalStateException("closed");
            } else {
                c cVar2 = this.a;
                if (cVar2.b == 0 && this.b.a(cVar2, SVG.A) == -1) {
                    return -1L;
                }
                return this.a.a(cVar, Math.min(j2, this.a.b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c a() {
        return this.a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.a.a(this.b);
            return this.a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void a(long j2) throws IOException {
        if (!e(j2)) {
            throw new EOFException();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean a(long j2, f fVar) throws IOException {
        return a(j2, fVar, 0, fVar.e());
    }

    public boolean a(long j2, f fVar, int i2, int i3) throws IOException {
        if (this.f288c) {
            throw new IllegalStateException("closed");
        }
        if (j2 < 0 || i2 < 0 || i3 < 0 || fVar.e() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            long j3 = i4 + j2;
            if (!e(1 + j3) || this.a.f(j3) != fVar.a(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public f b(long j2) throws IOException {
        a(j2);
        return this.a.b(j2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t b() {
        return this.b.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String c(long j2) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j2);
        }
        long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
        long a = a((byte) 10, 0L, j3);
        if (a != -1) {
            return this.a.h(a);
        }
        if (j3 < Long.MAX_VALUE && e(j3) && this.a.f(j3 - 1) == 13 && e(1 + j3) && this.a.f(j3) == 10) {
            return this.a.h(j3);
        }
        c cVar = new c();
        c cVar2 = this.a;
        cVar2.a(cVar, 0L, Math.min(32L, cVar2.o()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.a.o(), j2) + " content=" + cVar.m().b() + y.E);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short c() throws IOException {
        a(2L);
        return this.a.c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f288c) {
            return;
        }
        this.f288c = true;
        this.b.close();
        this.a.j();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String d() throws IOException {
        return c(Long.MAX_VALUE);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte[] d(long j2) throws IOException {
        a(j2);
        return this.a.d(j2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int e() throws IOException {
        a(4L);
        return this.a.e();
    }

    public boolean e(long j2) throws IOException {
        c cVar;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (this.f288c) {
            throw new IllegalStateException("closed");
        } else {
            do {
                cVar = this.a;
                if (cVar.b >= j2) {
                    return true;
                }
            } while (this.b.a(cVar, SVG.A) != -1);
            return false;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean f() throws IOException {
        if (this.f288c) {
            throw new IllegalStateException("closed");
        }
        return this.a.f() && this.b.a(this.a, SVG.A) == -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long g() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.a(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.e(r3)
            if (r3 == 0) goto L4a
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r3 = r6.a
            long r4 = (long) r1
            byte r3 = r3.f(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r6.a
            long r0 = r0.g()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.n.g():long");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f288c;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.a;
        if (cVar.b == 0 && this.b.a(cVar, SVG.A) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte readByte() throws IOException {
        a(1L);
        return this.a.readByte();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void readFully(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                c cVar = this.a;
                long j2 = cVar.b;
                if (j2 <= 0) {
                    throw e2;
                }
                int a = cVar.a(bArr, i2, (int) j2);
                if (a == -1) {
                    throw new AssertionError();
                }
                i2 += a;
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int readInt() throws IOException {
        a(4L);
        return this.a.readInt();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short readShort() throws IOException {
        a(2L);
        return this.a.readShort();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void skip(long j2) throws IOException {
        if (this.f288c) {
            throw new IllegalStateException("closed");
        }
        while (j2 > 0) {
            c cVar = this.a;
            if (cVar.b == 0 && this.b.a(cVar, SVG.A) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j2, this.a.o());
            this.a.skip(min);
            j2 -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
