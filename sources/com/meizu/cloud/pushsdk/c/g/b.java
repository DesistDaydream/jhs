package com.meizu.cloud.pushsdk.c.g;

import androidx.annotation.NonNull;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes2.dex */
public final class b implements c, d, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f4789c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public j a;
    public long b;

    public int a(byte[] bArr, int i2, int i3) {
        o.a(bArr.length, i2, i3);
        j jVar = this.a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i3, jVar.f4795c - jVar.b);
        System.arraycopy(jVar.a, jVar.b, bArr, i2, min);
        int i4 = jVar.b + min;
        jVar.b = i4;
        this.b -= min;
        if (i4 == jVar.f4795c) {
            this.a = jVar.a();
            k.a(jVar);
        }
        return min;
    }

    public long a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public long a(m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long b = mVar.b(this, 2048L);
            if (b == -1) {
                return j2;
            }
            j2 += b;
        }
    }

    public b a(int i2) {
        int i3;
        int i4;
        if (i2 >= 128) {
            if (i2 < 2048) {
                i4 = (i2 >> 6) | 192;
            } else {
                if (i2 < 65536) {
                    if (i2 >= 55296 && i2 <= 57343) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                    }
                    i3 = (i2 >> 12) | 224;
                } else if (i2 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                } else {
                    b((i2 >> 18) | 240);
                    i3 = ((i2 >> 12) & 63) | 128;
                }
                b(i3);
                i4 = ((i2 >> 6) & 63) | 128;
            }
            b(i4);
            i2 = (i2 & 63) | 128;
        }
        b(i2);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: a */
    public b b(e eVar) {
        if (eVar != null) {
            eVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: a */
    public b b(String str) {
        return a(str, 0, str.length());
    }

    public b a(String str, int i2, int i3) {
        int i4;
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i2);
            } else if (i3 < i2) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            } else if (i3 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
            } else {
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt < 128) {
                        j c2 = c(1);
                        byte[] bArr = c2.a;
                        int i5 = c2.f4795c - i2;
                        int min = Math.min(i3, 2048 - i5);
                        int i6 = i2 + 1;
                        bArr[i2 + i5] = (byte) charAt;
                        while (i6 < min) {
                            char charAt2 = str.charAt(i6);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i6 + i5] = (byte) charAt2;
                            i6++;
                        }
                        int i7 = c2.f4795c;
                        int i8 = (i5 + i6) - i7;
                        c2.f4795c = i7 + i8;
                        this.b += i8;
                        i2 = i6;
                    } else {
                        if (charAt < 2048) {
                            i4 = (charAt >> 6) | 192;
                        } else if (charAt < 55296 || charAt > 57343) {
                            b((charAt >> '\f') | 224);
                            i4 = ((charAt >> 6) & 63) | 128;
                        } else {
                            int i9 = i2 + 1;
                            char charAt3 = i9 < i3 ? str.charAt(i9) : (char) 0;
                            if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                b(63);
                                i2 = i9;
                            } else {
                                int i10 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                b((i10 >> 18) | 240);
                                b(((i10 >> 12) & 63) | 128);
                                b(((i10 >> 6) & 63) | 128);
                                b((i10 & 63) | 128);
                                i2 += 2;
                            }
                        }
                        b(i4);
                        b((charAt & k.b.a.a.o.e.a) | 128);
                        i2++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public String a(long j2, Charset charset) {
        o.a(this.b, 0L, j2);
        if (charset != null) {
            if (j2 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
            } else if (j2 == 0) {
                return "";
            } else {
                j jVar = this.a;
                if (jVar.b + j2 > jVar.f4795c) {
                    return new String(a(j2), charset);
                }
                String str = new String(jVar.a, jVar.b, (int) j2, charset);
                int i2 = (int) (jVar.b + j2);
                jVar.b = i2;
                this.b -= j2;
                if (i2 == jVar.f4795c) {
                    this.a = jVar.a();
                    k.a(jVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j2) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        o.a(bVar.b, 0L, j2);
        while (j2 > 0) {
            j jVar = bVar.a;
            if (j2 < jVar.f4795c - jVar.b) {
                j jVar2 = this.a;
                j jVar3 = jVar2 != null ? jVar2.f4799g : null;
                if (jVar3 != null && jVar3.f4797e) {
                    if ((jVar3.f4795c + j2) - (jVar3.f4796d ? 0 : jVar3.b) <= 2048) {
                        jVar.a(jVar3, (int) j2);
                        bVar.b -= j2;
                        this.b += j2;
                        return;
                    }
                }
                bVar.a = jVar.a((int) j2);
            }
            j jVar4 = bVar.a;
            long j3 = jVar4.f4795c - jVar4.b;
            bVar.a = jVar4.a();
            j jVar5 = this.a;
            if (jVar5 == null) {
                this.a = jVar4;
                jVar4.f4799g = jVar4;
                jVar4.f4798f = jVar4;
            } else {
                jVar5.f4799g.a(jVar4).b();
            }
            bVar.b -= j3;
            this.b += j3;
            j2 -= j3;
        }
    }

    public void a(byte[] bArr) {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a = a(bArr, i2, bArr.length - i2);
            if (a == -1) {
                throw new EOFException();
            }
            i2 += a;
        }
    }

    public byte[] a(long j2) {
        o.a(this.b, 0L, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[(int) j2];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m
    public long b(b bVar, long j2) {
        if (bVar != null) {
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
            bVar.a(this, j2);
            return j2;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public b b() {
        return this;
    }

    public b b(int i2) {
        j c2 = c(1);
        byte[] bArr = c2.a;
        int i3 = c2.f4795c;
        c2.f4795c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.b++;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: b */
    public b c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: b */
    public b c(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = i3;
            o.a(bArr.length, i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                j c2 = c(1);
                int min = Math.min(i4 - i2, 2048 - c2.f4795c);
                System.arraycopy(bArr, i2, c2.a, c2.f4795c, min);
                i2 += min;
                c2.f4795c += min;
            }
            this.b += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void b(long j2) {
        j jVar;
        while (j2 > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j2, jVar.f4795c - jVar.b);
            long j3 = min;
            this.b -= j3;
            j2 -= j3;
            j jVar2 = this.a;
            int i2 = jVar2.b + min;
            jVar2.b = i2;
            if (i2 == jVar2.f4795c) {
                this.a = jVar2.a();
                k.a(jVar2);
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: c */
    public b e(long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 == 0) {
            return b(48);
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i3 = j2 < 1000000000000L ? j2 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= com.heytap.mcssdk.constant.a.q) {
            i3 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i3 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        j c2 = c(i3);
        byte[] bArr = c2.a;
        int i4 = c2.f4795c + i3;
        while (j2 != 0) {
            i4--;
            bArr[i4] = f4789c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i4 - 1] = 45;
        }
        c2.f4795c += i3;
        this.b += i3;
        return this;
    }

    public j c(int i2) {
        if (i2 < 1 || i2 > 2048) {
            throw new IllegalArgumentException();
        }
        j jVar = this.a;
        if (jVar != null) {
            j jVar2 = jVar.f4799g;
            return (jVar2.f4795c + i2 > 2048 || !jVar2.f4797e) ? jVar2.a(k.a()) : jVar2;
        }
        j a = k.a();
        this.a = a;
        a.f4799g = a;
        a.f4798f = a;
        return a;
    }

    public boolean c() {
        return this.b == 0;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    public void close() {
    }

    public b d(long j2) {
        if (j2 == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        j c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.a;
        int i2 = c2.f4795c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f4789c[(int) (15 & j2)];
            j2 >>>= 4;
        }
        c2.f4795c += numberOfTrailingZeros;
        this.b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.c.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                b bVar = b.this;
                if (bVar.b > 0) {
                    return bVar.f() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(@NonNull byte[] bArr, int i2, int i3) {
                return b.this.a(bArr, i2, i3);
            }

            public String toString() {
                return b.this + ".inputStream()";
            }
        };
    }

    public long e() {
        long j2 = this.b;
        if (j2 == 0) {
            return 0L;
        }
        j jVar = this.a.f4799g;
        int i2 = jVar.f4795c;
        return (i2 >= 2048 || !jVar.f4797e) ? j2 : j2 - (i2 - jVar.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            long j2 = this.b;
            if (j2 != bVar.b) {
                return false;
            }
            long j3 = 0;
            if (j2 == 0) {
                return true;
            }
            j jVar = this.a;
            j jVar2 = bVar.a;
            int i2 = jVar.b;
            int i3 = jVar2.b;
            while (j3 < this.b) {
                long min = Math.min(jVar.f4795c - i2, jVar2.f4795c - i3);
                int i4 = 0;
                while (i4 < min) {
                    int i5 = i2 + 1;
                    int i6 = i3 + 1;
                    if (jVar.a[i2] != jVar2.a[i3]) {
                        return false;
                    }
                    i4++;
                    i2 = i5;
                    i3 = i6;
                }
                if (i2 == jVar.f4795c) {
                    jVar = jVar.f4798f;
                    i2 = jVar.b;
                }
                if (i3 == jVar2.f4795c) {
                    jVar2 = jVar2.f4798f;
                    i3 = jVar2.b;
                }
                j3 += min;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        long j2 = this.b;
        if (j2 != 0) {
            j jVar = this.a;
            int i2 = jVar.b;
            int i3 = jVar.f4795c;
            int i4 = i2 + 1;
            byte b = jVar.a[i2];
            this.b = j2 - 1;
            if (i4 == i3) {
                this.a = jVar.a();
                k.a(jVar);
            } else {
                jVar.b = i4;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() {
    }

    public e g() {
        return new e(i());
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public String h() {
        try {
            return a(this.b, o.a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int hashCode() {
        j jVar = this.a;
        if (jVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = jVar.f4795c;
            for (int i4 = jVar.b; i4 < i3; i4++) {
                i2 = (i2 * 31) + jVar.a[i4];
            }
            jVar = jVar.f4798f;
        } while (jVar != this.a);
        return i2;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public byte[] i() {
        try {
            return a(this.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void j() {
        try {
            b(this.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.b == 0) {
            return bVar;
        }
        j jVar = new j(this.a);
        bVar.a = jVar;
        jVar.f4799g = jVar;
        jVar.f4798f = jVar;
        j jVar2 = this.a;
        while (true) {
            jVar2 = jVar2.f4798f;
            if (jVar2 == this.a) {
                bVar.b = this.b;
                return bVar;
            }
            bVar.a.f4799g.a(new j(jVar2));
        }
    }

    public String toString() {
        long j2 = this.b;
        if (j2 == 0) {
            return "Buffer[size=0]";
        }
        if (j2 <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            j jVar = this.a;
            byte[] bArr = jVar.a;
            int i2 = jVar.b;
            messageDigest.update(bArr, i2, jVar.f4795c - i2);
            j jVar2 = this.a;
            while (true) {
                jVar2 = jVar2.f4798f;
                if (jVar2 == this.a) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.b), e.a(messageDigest.digest()).c());
                }
                byte[] bArr2 = jVar2.a;
                int i3 = jVar2.b;
                messageDigest.update(bArr2, i3, jVar2.f4795c - i3);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
