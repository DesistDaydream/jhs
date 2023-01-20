package h.p2.b0.g.t.i;

import h.p2.b0.g.t.i.n;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* loaded from: classes3.dex */
public final class e {
    private final byte[] a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f15429c;

    /* renamed from: d  reason: collision with root package name */
    private int f15430d;

    /* renamed from: e  reason: collision with root package name */
    private int f15431e;

    /* renamed from: f  reason: collision with root package name */
    private final InputStream f15432f;

    /* renamed from: g  reason: collision with root package name */
    private int f15433g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15434h;

    /* renamed from: i  reason: collision with root package name */
    private int f15435i;

    /* renamed from: j  reason: collision with root package name */
    private int f15436j;

    /* renamed from: k  reason: collision with root package name */
    private int f15437k;

    /* renamed from: l  reason: collision with root package name */
    private int f15438l;

    /* renamed from: m  reason: collision with root package name */
    private int f15439m;
    private a n;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    private e(InputStream inputStream) {
        this.f15434h = false;
        this.f15436j = Integer.MAX_VALUE;
        this.f15438l = 64;
        this.f15439m = 67108864;
        this.n = null;
        this.a = new byte[4096];
        this.f15429c = 0;
        this.f15431e = 0;
        this.f15435i = 0;
        this.f15432f = inputStream;
        this.b = false;
    }

    public static int B(int i2, InputStream inputStream) throws IOException {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = i2 & 127;
        int i4 = 7;
        while (i4 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i3 |= (read & 127) << i4;
            if ((read & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        while (i4 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private void N() {
        int i2 = this.f15429c + this.f15430d;
        this.f15429c = i2;
        int i3 = this.f15435i + i2;
        int i4 = this.f15436j;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f15430d = i5;
            this.f15429c = i2 - i5;
            return;
        }
        this.f15430d = 0;
    }

    private void O(int i2) throws IOException {
        if (!T(i2)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void S(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f15435i;
            int i4 = this.f15431e;
            int i5 = i3 + i4 + i2;
            int i6 = this.f15436j;
            if (i5 <= i6) {
                int i7 = this.f15429c;
                int i8 = i7 - i4;
                this.f15431e = i7;
                O(1);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.f15429c;
                    if (i9 > i10) {
                        i8 += i10;
                        this.f15431e = i10;
                        O(1);
                    } else {
                        this.f15431e = i9;
                        return;
                    }
                }
            } else {
                R((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private boolean T(int i2) throws IOException {
        int i3 = this.f15431e;
        if (i3 + i2 > this.f15429c) {
            if (this.f15435i + i3 + i2 > this.f15436j) {
                return false;
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f15432f != null) {
                int i4 = this.f15431e;
                if (i4 > 0) {
                    int i5 = this.f15429c;
                    if (i5 > i4) {
                        byte[] bArr = this.a;
                        System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                    }
                    this.f15435i += i4;
                    this.f15429c -= i4;
                    this.f15431e = 0;
                }
                InputStream inputStream = this.f15432f;
                byte[] bArr2 = this.a;
                int i6 = this.f15429c;
                int read = inputStream.read(bArr2, i6, bArr2.length - i6);
                if (read == 0 || read < -1 || read > this.a.length) {
                    StringBuilder sb = new StringBuilder(102);
                    sb.append("InputStream#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read > 0) {
                    this.f15429c += read;
                    if ((this.f15435i + i2) - this.f15439m <= 0) {
                        N();
                        if (this.f15429c >= i2) {
                            return true;
                        }
                        return T(i2);
                    }
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
            }
            return false;
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i2);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private void d(int i2) throws IOException {
        if (this.f15429c - this.f15431e < i2) {
            O(i2);
        }
    }

    public static e g(InputStream inputStream) {
        return new e(inputStream);
    }

    public static e h(m mVar) {
        e eVar = new e(mVar);
        try {
            eVar.j(mVar.size());
            return eVar;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private byte[] x(int i2) throws IOException {
        if (i2 <= 0) {
            if (i2 == 0) {
                return h.a;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i3 = this.f15435i;
        int i4 = this.f15431e;
        int i5 = i3 + i4 + i2;
        int i6 = this.f15436j;
        if (i5 > i6) {
            R((i6 - i3) - i4);
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i2 < 4096) {
            byte[] bArr = new byte[i2];
            int i7 = this.f15429c - i4;
            System.arraycopy(this.a, i4, bArr, 0, i7);
            this.f15431e = this.f15429c;
            int i8 = i2 - i7;
            d(i8);
            System.arraycopy(this.a, 0, bArr, i7, i8);
            this.f15431e = i8;
            return bArr;
        } else {
            int i9 = this.f15429c;
            this.f15435i = i3 + i9;
            this.f15431e = 0;
            this.f15429c = 0;
            int i10 = i9 - i4;
            int i11 = i2 - i10;
            ArrayList<byte[]> arrayList = new ArrayList();
            while (i11 > 0) {
                int min = Math.min(i11, 4096);
                byte[] bArr2 = new byte[min];
                int i12 = 0;
                while (i12 < min) {
                    InputStream inputStream = this.f15432f;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i12, min - i12);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.f15435i += read;
                    i12 += read;
                }
                i11 -= min;
                arrayList.add(bArr2);
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(this.a, i4, bArr3, 0, i10);
            for (byte[] bArr4 : arrayList) {
                System.arraycopy(bArr4, 0, bArr3, i10, bArr4.length);
                i10 += bArr4.length;
            }
            return bArr3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
        if (r2[r3] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f15431e
            int r1 = r9.f15429c
            if (r1 != r0) goto L8
            goto L7c
        L8:
            byte[] r2 = r9.a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L13
            r9.f15431e = r3
            return r0
        L13:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L19
            goto L7c
        L19:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2d
            r5 = -128(0xffffffffffffff80, double:NaN)
        L29:
            long r2 = r3 ^ r5
            int r0 = (int) r2
            goto L82
        L2d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r7 = (long) r0
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 < 0) goto L3f
            r0 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r7
            int r0 = (int) r0
        L3d:
            r1 = r3
            goto L82
        L3f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            long r3 = (long) r0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L4f
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L29
        L4f:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L82
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L82
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L82
        L7c:
            long r0 = r9.D()
            int r1 = (int) r0
            return r1
        L82:
            r9.f15431e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.i.e.A():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (r2[r0] < 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long C() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.i.e.C():long");
    }

    public long D() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte w = w();
            j2 |= (w & h.k2.v.n.b) << i2;
            if ((w & h.k2.v.n.a) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int E() throws IOException {
        return y();
    }

    public long F() throws IOException {
        return z();
    }

    public int G() throws IOException {
        return b(A());
    }

    public long H() throws IOException {
        return c(C());
    }

    public String I() throws IOException {
        int A = A();
        if (A > this.f15429c - this.f15431e || A <= 0) {
            return A == 0 ? "" : new String(x(A), "UTF-8");
        }
        String str = new String(this.a, this.f15431e, A, "UTF-8");
        this.f15431e += A;
        return str;
    }

    public String J() throws IOException {
        byte[] x;
        int A = A();
        int i2 = this.f15431e;
        if (A <= this.f15429c - i2 && A > 0) {
            x = this.a;
            this.f15431e = i2 + A;
        } else if (A == 0) {
            return "";
        } else {
            x = x(A);
            i2 = 0;
        }
        if (u.f(x, i2, i2 + A)) {
            return new String(x, i2, A, "UTF-8");
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int K() throws IOException {
        if (f()) {
            this.f15433g = 0;
            return 0;
        }
        int A = A();
        this.f15433g = A;
        if (WireFormat.a(A) != 0) {
            return this.f15433g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int L() throws IOException {
        return A();
    }

    public long M() throws IOException {
        return C();
    }

    public boolean P(int i2, CodedOutputStream codedOutputStream) throws IOException {
        int b = WireFormat.b(i2);
        if (b == 0) {
            long t = t();
            codedOutputStream.o0(i2);
            codedOutputStream.z0(t);
            return true;
        } else if (b == 1) {
            long z = z();
            codedOutputStream.o0(i2);
            codedOutputStream.V(z);
            return true;
        } else if (b == 2) {
            d l2 = l();
            codedOutputStream.o0(i2);
            codedOutputStream.P(l2);
            return true;
        } else if (b == 3) {
            codedOutputStream.o0(i2);
            Q(codedOutputStream);
            int c2 = WireFormat.c(WireFormat.a(i2), 4);
            a(c2);
            codedOutputStream.o0(c2);
            return true;
        } else if (b != 4) {
            if (b == 5) {
                int y = y();
                codedOutputStream.o0(i2);
                codedOutputStream.U(y);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        } else {
            return false;
        }
    }

    public void Q(CodedOutputStream codedOutputStream) throws IOException {
        int K;
        do {
            K = K();
            if (K == 0) {
                return;
            }
        } while (P(K, codedOutputStream));
    }

    public void R(int i2) throws IOException {
        int i3 = this.f15429c;
        int i4 = this.f15431e;
        if (i2 <= i3 - i4 && i2 >= 0) {
            this.f15431e = i4 + i2;
        } else {
            S(i2);
        }
    }

    public void a(int i2) throws InvalidProtocolBufferException {
        if (this.f15433g != i2) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int e() {
        int i2 = this.f15436j;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.f15435i + this.f15431e);
    }

    public boolean f() throws IOException {
        return this.f15431e == this.f15429c && !T(1);
    }

    public void i(int i2) {
        this.f15436j = i2;
        N();
    }

    public int j(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = i2 + this.f15435i + this.f15431e;
            int i4 = this.f15436j;
            if (i3 <= i4) {
                this.f15436j = i3;
                N();
                return i4;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean k() throws IOException {
        return C() != 0;
    }

    public d l() throws IOException {
        int A = A();
        int i2 = this.f15429c;
        int i3 = this.f15431e;
        if (A > i2 - i3 || A <= 0) {
            if (A == 0) {
                return d.a;
            }
            return new m(x(A));
        }
        d cVar = (this.b && this.f15434h) ? new c(this.a, this.f15431e, A) : d.f(this.a, i3, A);
        this.f15431e += A;
        return cVar;
    }

    public double m() throws IOException {
        return Double.longBitsToDouble(z());
    }

    public int n() throws IOException {
        return A();
    }

    public int o() throws IOException {
        return y();
    }

    public long p() throws IOException {
        return z();
    }

    public float q() throws IOException {
        return Float.intBitsToFloat(y());
    }

    public void r(int i2, n.a aVar, f fVar) throws IOException {
        int i3 = this.f15437k;
        if (i3 < this.f15438l) {
            this.f15437k = i3 + 1;
            aVar.d(this, fVar);
            a(WireFormat.c(i2, 4));
            this.f15437k--;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int s() throws IOException {
        return A();
    }

    public long t() throws IOException {
        return C();
    }

    public <T extends n> T u(p<T> pVar, f fVar) throws IOException {
        int A = A();
        if (this.f15437k < this.f15438l) {
            int j2 = j(A);
            this.f15437k++;
            T c2 = pVar.c(this, fVar);
            a(0);
            this.f15437k--;
            i(j2);
            return c2;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void v(n.a aVar, f fVar) throws IOException {
        int A = A();
        if (this.f15437k < this.f15438l) {
            int j2 = j(A);
            this.f15437k++;
            aVar.d(this, fVar);
            a(0);
            this.f15437k--;
            i(j2);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte w() throws IOException {
        if (this.f15431e == this.f15429c) {
            O(1);
        }
        byte[] bArr = this.a;
        int i2 = this.f15431e;
        this.f15431e = i2 + 1;
        return bArr[i2];
    }

    public int y() throws IOException {
        int i2 = this.f15431e;
        if (this.f15429c - i2 < 4) {
            O(4);
            i2 = this.f15431e;
        }
        byte[] bArr = this.a;
        this.f15431e = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public long z() throws IOException {
        int i2 = this.f15431e;
        if (this.f15429c - i2 < 8) {
            O(8);
            i2 = this.f15431e;
        }
        byte[] bArr = this.a;
        this.f15431e = i2 + 8;
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    private e(m mVar) {
        this.f15434h = false;
        this.f15436j = Integer.MAX_VALUE;
        this.f15438l = 64;
        this.f15439m = 67108864;
        this.n = null;
        this.a = mVar.f15446c;
        int E = mVar.E();
        this.f15431e = E;
        this.f15429c = E + mVar.size();
        this.f15435i = -this.f15431e;
        this.f15432f = null;
        this.b = true;
    }
}
