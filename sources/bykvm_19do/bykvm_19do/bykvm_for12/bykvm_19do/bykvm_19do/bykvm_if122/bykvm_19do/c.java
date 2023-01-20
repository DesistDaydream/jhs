package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.caverock.androidsvg.SVG;
import h.t2.y;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f276c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public o a;
    public long b;

    public int a(byte[] bArr, int i2, int i3) {
        u.a(bArr.length, i2, i3);
        o oVar = this.a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i3, oVar.f289c - oVar.b);
        System.arraycopy(oVar.a, oVar.b, bArr, i2, min);
        int i4 = oVar.b + min;
        oVar.b = i4;
        this.b -= min;
        if (i4 == oVar.f289c) {
            this.a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public long a(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j2, long j3) {
        o oVar;
        long j4 = 0;
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j2), Long.valueOf(j3)));
        }
        long j5 = this.b;
        long j6 = j3 > j5 ? j5 : j3;
        if (j2 == j6 || (oVar = this.a) == null) {
            return -1L;
        }
        if (j5 - j2 < j2) {
            while (j5 > j2) {
                oVar = oVar.f293g;
                j5 -= oVar.f289c - oVar.b;
            }
        } else {
            while (true) {
                long j7 = (oVar.f289c - oVar.b) + j4;
                if (j7 >= j2) {
                    break;
                }
                oVar = oVar.f292f;
                j4 = j7;
            }
            j5 = j4;
        }
        long j8 = j2;
        while (j5 < j6) {
            byte[] bArr = oVar.a;
            int min = (int) Math.min(oVar.f289c, (oVar.b + j6) - j5);
            for (int i2 = (int) ((oVar.b + j8) - j5); i2 < min; i2++) {
                if (bArr[i2] == b) {
                    return j5 + (i2 - oVar.b);
                }
            }
            j5 += oVar.f289c - oVar.b;
            oVar = oVar.f292f;
            j8 = j5;
        }
        return -1L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j2) {
        if (cVar != null) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            long j3 = this.b;
            if (j3 == 0) {
                return -1L;
            }
            if (j2 > j3) {
                j2 = j3;
            }
            cVar.b(this, j2);
            return j2;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long a = sVar.a(this, SVG.A);
            if (a == -1) {
                return j2;
            }
            j2 += a;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c a() {
        return this;
    }

    public final c a(c cVar, long j2, long j3) {
        if (cVar != null) {
            u.a(this.b, j2, j3);
            if (j3 != 0) {
                cVar.b += j3;
                o oVar = this.a;
                while (true) {
                    long j4 = oVar.f289c - oVar.b;
                    if (j2 < j4) {
                        break;
                    }
                    j2 -= j4;
                    oVar = oVar.f292f;
                }
                while (j3 > 0) {
                    o c2 = oVar.c();
                    int i2 = (int) (c2.b + j2);
                    c2.b = i2;
                    c2.f289c = Math.min(i2 + ((int) j3), c2.f289c);
                    o oVar2 = cVar.a;
                    if (oVar2 == null) {
                        c2.f293g = c2;
                        c2.f292f = c2;
                        cVar.a = c2;
                    } else {
                        oVar2.f293g.a(c2);
                    }
                    j3 -= c2.f289c - c2.b;
                    oVar = oVar.f292f;
                    j2 = 0;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public c a(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c a(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i2, int i3) {
        char charAt;
        int i4;
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i2);
            } else if (i3 < i2) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            } else if (i3 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
            } else {
                while (i2 < i3) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 128) {
                        o b = b(1);
                        byte[] bArr = b.a;
                        int i5 = b.f289c - i2;
                        int min = Math.min(i3, 8192 - i5);
                        bArr[i2 + i5] = (byte) charAt2;
                        i2++;
                        while (i2 < min) {
                            if (str.charAt(i2) >= 128) {
                                break;
                            }
                            bArr[i2 + i5] = (byte) charAt;
                            i2++;
                        }
                        int i6 = b.f289c;
                        int i7 = (i5 + i2) - i6;
                        b.f289c = i6 + i7;
                        this.b += i7;
                    } else {
                        if (charAt2 < 2048) {
                            i4 = (charAt2 >> 6) | 192;
                        } else if (charAt2 < 55296 || charAt2 > 57343) {
                            writeByte((charAt2 >> '\f') | 224);
                            i4 = ((charAt2 >> 6) & 63) | 128;
                        } else {
                            int i8 = i2 + 1;
                            char charAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                            if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                writeByte(63);
                                i2 = i8;
                            } else {
                                int i9 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i9 >> 18) | 240);
                                writeByte(((i9 >> 12) & 63) | 128);
                                writeByte(((i9 >> 6) & 63) | 128);
                                writeByte((i9 & 63) | 128);
                                i2 += 2;
                            }
                        }
                        writeByte(i4);
                        writeByte((charAt2 & k.b.a.a.o.e.a) | 128);
                        i2++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public c a(String str, int i2, int i3, Charset charset) {
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i2);
            } else if (i3 < i2) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            } else if (i3 <= str.length()) {
                if (charset != null) {
                    if (charset.equals(u.a)) {
                        return a(str, i2, i3);
                    }
                    byte[] bytes = str.substring(i2, i3).getBytes(charset);
                    return write(bytes, 0, bytes.length);
                }
                throw new IllegalArgumentException("charset == null");
            } else {
                throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public final f a(int i2) {
        return i2 == 0 ? f.f278e : new q(this, i2);
    }

    public String a(long j2, Charset charset) throws EOFException {
        u.a(this.b, 0L, j2);
        if (charset != null) {
            if (j2 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
            } else if (j2 == 0) {
                return "";
            } else {
                o oVar = this.a;
                int i2 = oVar.b;
                if (i2 + j2 > oVar.f289c) {
                    return new String(d(j2), charset);
                }
                String str = new String(oVar.a, i2, (int) j2, charset);
                int i3 = (int) (oVar.b + j2);
                oVar.b = i3;
                this.b -= j2;
                if (i3 == oVar.f289c) {
                    this.a = oVar.b();
                    p.a(oVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String a(Charset charset) {
        try {
            return a(this.b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void a(long j2) throws EOFException {
        if (this.b < j2) {
            throw new EOFException();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean a(long j2, f fVar) {
        return a(j2, fVar, 0, fVar.e());
    }

    public boolean a(long j2, f fVar, int i2, int i3) {
        if (j2 < 0 || i2 < 0 || i3 < 0 || this.b - j2 < i3 || fVar.e() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (f(i4 + j2) != fVar.a(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public f b(long j2) throws EOFException {
        return new f(d(j2));
    }

    public o b(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        o oVar = this.a;
        if (oVar != null) {
            o oVar2 = oVar.f293g;
            return (oVar2.f289c + i2 > 8192 || !oVar2.f291e) ? oVar2.a(p.a()) : oVar2;
        }
        o a = p.a();
        this.a = a;
        a.f293g = a;
        a.f292f = a;
        return a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t b() {
        return t.f296d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
    public void b(c cVar, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u.a(cVar.b, 0L, j2);
        while (j2 > 0) {
            o oVar = cVar.a;
            if (j2 < oVar.f289c - oVar.b) {
                o oVar2 = this.a;
                o oVar3 = oVar2 != null ? oVar2.f293g : null;
                if (oVar3 != null && oVar3.f291e) {
                    if ((oVar3.f289c + j2) - (oVar3.f290d ? 0 : oVar3.b) <= SVG.A) {
                        oVar.a(oVar3, (int) j2);
                        cVar.b -= j2;
                        this.b += j2;
                        return;
                    }
                }
                cVar.a = oVar.a((int) j2);
            }
            o oVar4 = cVar.a;
            long j3 = oVar4.f289c - oVar4.b;
            cVar.a = oVar4.b();
            o oVar5 = this.a;
            if (oVar5 == null) {
                this.a = oVar4;
                oVar4.f293g = oVar4;
                oVar4.f292f = oVar4;
            } else {
                oVar5.f293g.a(oVar4).a();
            }
            cVar.b -= j3;
            this.b += j3;
            j2 -= j3;
        }
    }

    public c c(int i2) {
        int i3;
        int i4;
        if (i2 >= 128) {
            if (i2 < 2048) {
                i4 = (i2 >> 6) | 192;
            } else {
                if (i2 < 65536) {
                    if (i2 >= 55296 && i2 <= 57343) {
                        writeByte(63);
                        return this;
                    }
                    i3 = (i2 >> 12) | 224;
                } else if (i2 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                } else {
                    writeByte((i2 >> 18) | 240);
                    i3 = ((i2 >> 12) & 63) | 128;
                }
                writeByte(i3);
                i4 = ((i2 >> 6) & 63) | 128;
            }
            writeByte(i4);
            i2 = (i2 & 63) | 128;
        }
        writeByte(i2);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String c(long j2) throws EOFException {
        if (j2 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j2);
        }
        long j3 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
        long a = a((byte) 10, 0L, j3);
        if (a != -1) {
            return h(a);
        }
        if (j3 < o() && f(j3 - 1) == 13 && f(j3) == 10) {
            return h(j3);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, o()));
        throw new EOFException("\\n not found: limit=" + Math.min(o(), j2) + " content=" + cVar.m().b() + y.E);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short c() {
        return u.a(readShort());
    }

    /* renamed from: clone */
    public c m10clone() {
        c cVar = new c();
        if (this.b != 0) {
            o c2 = this.a.c();
            cVar.a = c2;
            c2.f293g = c2;
            c2.f292f = c2;
            o oVar = this.a;
            while (true) {
                oVar = oVar.f292f;
                if (oVar == this.a) {
                    break;
                }
                cVar.a.f293g.a(oVar.c());
            }
            cVar.b = this.b;
        }
        return cVar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String d() throws EOFException {
        return c(Long.MAX_VALUE);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte[] d(long j2) throws EOFException {
        u.a(this.b, 0L, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[(int) j2];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int e() {
        return u.a(readInt());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c e(long j2) {
        if (j2 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        o b = b(numberOfTrailingZeros);
        byte[] bArr = b.a;
        int i2 = b.f289c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f276c[(int) (15 & j2)];
            j2 >>>= 4;
        }
        b.f289c += numberOfTrailingZeros;
        this.b = numberOfTrailingZeros + this.b;
        return this;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            long j2 = this.b;
            if (j2 != cVar.b) {
                return false;
            }
            long j3 = 0;
            if (j2 != 0) {
                o oVar = this.a;
                o oVar2 = cVar.a;
                int i2 = oVar.b;
                int i3 = oVar2.b;
                while (j3 < this.b) {
                    long min = Math.min(oVar.f289c - i2, oVar2.f289c - i3);
                    int i4 = 0;
                    while (i4 < min) {
                        if (oVar.a[i2] != oVar2.a[i3]) {
                            return false;
                        }
                        i4++;
                        i3++;
                        i2++;
                    }
                    if (i2 == oVar.f289c) {
                        oVar = oVar.f292f;
                        i2 = oVar.b;
                    }
                    if (i3 == oVar2.f289c) {
                        oVar2 = oVar2.f292f;
                        i3 = oVar2.b;
                    }
                    j3 += min;
                }
            }
        }
        return true;
    }

    public final byte f(long j2) {
        int i2;
        u.a(this.b, j2, 1L);
        long j3 = this.b;
        if (j3 - j2 <= j2) {
            long j4 = j2 - j3;
            try {
                o oVar = this.a;
                do {
                    oVar = oVar.f293g;
                    int i3 = oVar.f289c;
                    i2 = oVar.b;
                    j4 += i3 - i2;
                } while (j4 < 0);
                return oVar.a[i2 + ((int) j4)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
        o oVar2 = this.a;
        while (true) {
            int i4 = oVar2.f289c;
            int i5 = oVar2.b;
            long j5 = i4 - i5;
            if (j2 < j5) {
                return oVar2.a[((int) j2) + i5];
            }
            j2 -= j5;
            oVar2 = oVar2.f292f;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean f() {
        return this.b == 0;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
    public void flush() {
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5 A[EDGE_INSN: B:42:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long g() {
        /*
            r15 = this;
            long r0 = r15.b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r6 = r15.a
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.f289c
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            long r10 = (long) r11
            int r0 = r0 + 1
            int r8 = r8 + 1
            r12 = 4
            long r4 = r4 << r12
            long r4 = r4 | r10
            goto L13
        L4a:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c
            r0.<init>()
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r0.e(r4)
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.n()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r0 == 0) goto L76
            r1 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r7 = r6.b()
            r15.a = r7
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.p.a(r6)
            goto L9f
        L9d:
            r6.b = r8
        L9f:
            if (r1 != 0) goto La5
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r6 = r15.a
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.b = r1
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.g():long");
    }

    public String g(long j2) throws EOFException {
        return a(j2, u.a);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c h() {
        return this;
    }

    public String h(long j2) throws EOFException {
        String g2;
        long j3 = 1;
        if (j2 > 0) {
            long j4 = j2 - 1;
            if (f(j4) == 13) {
                g2 = g(j4);
                j3 = 2;
                skip(j3);
                return g2;
            }
        }
        g2 = g(j2);
        skip(j3);
        return g2;
    }

    public int hashCode() {
        o oVar = this.a;
        if (oVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = oVar.b;
            int i4 = oVar.f289c;
            while (i3 < i4) {
                byte b = oVar.a[i3];
                i3++;
                i2 = (i2 * 31) + b;
            }
            oVar = oVar.f292f;
        } while (oVar != this.a);
        return i2;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final void j() {
        try {
            skip(this.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final long k() {
        long j2 = this.b;
        if (j2 == 0) {
            return 0L;
        }
        o oVar = this.a.f293g;
        int i2 = oVar.f289c;
        return (i2 >= 8192 || !oVar.f291e) ? j2 : j2 - (i2 - oVar.b);
    }

    public byte[] l() throws EOFException {
        try {
            return d(this.b);
        } catch (EOFException e2) {
            throw e2;
        }
    }

    public f m() throws EOFException {
        return new f(l());
    }

    public String n() {
        try {
            return a(this.b, u.a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final long o() {
        return this.b;
    }

    public final f p() {
        long j2 = this.b;
        if (j2 <= 2147483647L) {
            return a((int) j2);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f289c - oVar.b);
        byteBuffer.put(oVar.a, oVar.b, min);
        int i2 = oVar.b + min;
        oVar.b = i2;
        this.b -= min;
        if (i2 == oVar.f289c) {
            this.a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte readByte() {
        long j2 = this.b;
        if (j2 != 0) {
            o oVar = this.a;
            int i2 = oVar.b;
            int i3 = oVar.f289c;
            int i4 = i2 + 1;
            byte b = oVar.a[i2];
            this.b = j2 - 1;
            if (i4 == i3) {
                this.a = oVar.b();
                p.a(oVar);
            } else {
                oVar.b = i4;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void readFully(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a = a(bArr, i2, bArr.length - i2);
            if (a == -1) {
                throw new EOFException();
            }
            i2 += a;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int readInt() {
        long j2 = this.b;
        if (j2 < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        o oVar = this.a;
        int i2 = oVar.b;
        int i3 = oVar.f289c;
        if (i3 - i2 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = oVar.a;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
        this.b = j2 - 4;
        if (i7 == i3) {
            this.a = oVar.b();
            p.a(oVar);
        } else {
            oVar.b = i7;
        }
        return i8;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short readShort() {
        int i2;
        int i3;
        long j2 = this.b;
        if (j2 < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        o oVar = this.a;
        int i4 = oVar.b;
        int i5 = oVar.f289c;
        if (i5 - i4 < 2) {
            i2 = (readByte() & 255) << 8;
            i3 = readByte() & 255;
        } else {
            byte[] bArr = oVar.a;
            int i6 = i4 + 1;
            byte b = bArr[i4];
            int i7 = i6 + 1;
            byte b2 = bArr[i6];
            this.b = j2 - 2;
            if (i7 == i5) {
                this.a = oVar.b();
                p.a(oVar);
            } else {
                oVar.b = i7;
            }
            i2 = (b & 255) << 8;
            i3 = b2 & 255;
        }
        return (short) (i2 | i3);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void skip(long j2) throws EOFException {
        o oVar;
        while (j2 > 0 && (oVar = this.a) != null) {
            int min = (int) Math.min(j2, oVar.f289c - oVar.b);
            long j3 = min;
            this.b -= j3;
            j2 -= j3;
            o oVar2 = this.a;
            int i2 = min + oVar2.b;
            oVar2.b = i2;
            if (i2 == oVar2.f289c) {
                this.a = oVar2.b();
                p.a(oVar2);
            }
        }
    }

    public String toString() {
        return p().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                o b = b(1);
                int min = Math.min(i2, 8192 - b.f289c);
                byteBuffer.get(b.a, b.f289c, min);
                i2 -= min;
                b.f289c = min + b.f289c;
            }
            this.b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = i3;
            u.a(bArr.length, i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                o b = b(1);
                int min = Math.min(i4 - i2, 8192 - b.f289c);
                System.arraycopy(bArr, i2, b.a, b.f289c, min);
                i2 += min;
                b.f289c = min + b.f289c;
            }
            this.b += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c writeByte(int i2) {
        o b = b(1);
        byte[] bArr = b.a;
        int i3 = b.f289c;
        b.f289c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.b++;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c writeInt(int i2) {
        o b = b(4);
        byte[] bArr = b.a;
        int i3 = b.f289c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        b.f289c = i6 + 1;
        this.b += 4;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c writeShort(int i2) {
        o b = b(2);
        byte[] bArr = b.a;
        int i3 = b.f289c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        b.f289c = i4 + 1;
        this.b += 2;
        return this;
    }
}
