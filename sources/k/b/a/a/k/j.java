package k.b.a.a.k;

import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public abstract class j implements k.b.a.a.b, k.b.a.a.a {

    /* renamed from: h  reason: collision with root package name */
    public static final int f16042h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f16043i = 76;

    /* renamed from: j  reason: collision with root package name */
    public static final int f16044j = 64;

    /* renamed from: k  reason: collision with root package name */
    private static final int f16045k = 2;

    /* renamed from: l  reason: collision with root package name */
    private static final int f16046l = 8192;

    /* renamed from: m  reason: collision with root package name */
    private static final int f16047m = 2147483639;
    public static final int n = 255;
    public static final byte o = 61;
    public static final CodecPolicy p = CodecPolicy.LENIENT;
    public static final byte[] q = {13, 10};
    @Deprecated
    public final byte a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16048c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16049d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16050e;

    /* renamed from: f  reason: collision with root package name */
    private final int f16051f;

    /* renamed from: g  reason: collision with root package name */
    private final CodecPolicy f16052g;

    /* loaded from: classes4.dex */
    public static class a {
        public int a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f16053c;

        /* renamed from: d  reason: collision with root package name */
        public int f16054d;

        /* renamed from: e  reason: collision with root package name */
        public int f16055e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f16056f;

        /* renamed from: g  reason: collision with root package name */
        public int f16057g;

        /* renamed from: h  reason: collision with root package name */
        public int f16058h;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.f16053c), Integer.valueOf(this.f16057g), Boolean.valueOf(this.f16056f), Integer.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.f16058h), Integer.valueOf(this.f16054d), Integer.valueOf(this.f16055e));
        }
    }

    public j(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, (byte) 61);
    }

    private static int b(int i2, int i3) {
        return Integer.compare(i2 - 2147483648, i3 - 2147483648);
    }

    private static int d(int i2) {
        if (i2 >= 0) {
            return i2 > f16047m ? i2 : f16047m;
        }
        throw new OutOfMemoryError("Unable to allocate array size: " + (i2 & 4294967295L));
    }

    public static byte[] n() {
        return (byte[]) q.clone();
    }

    public static boolean w(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    private static byte[] y(a aVar, int i2) {
        int length = aVar.f16053c.length * 2;
        if (b(length, i2) < 0) {
            length = i2;
        }
        if (b(length, f16047m) > 0) {
            length = d(i2);
        }
        byte[] bArr = new byte[length];
        byte[] bArr2 = aVar.f16053c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        aVar.f16053c = bArr;
        return bArr;
    }

    public int a(a aVar) {
        if (aVar.f16053c != null) {
            return aVar.f16054d - aVar.f16055e;
        }
        return 0;
    }

    public boolean c(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (this.b == b || s(b)) {
                return true;
            }
        }
        return false;
    }

    @Override // k.b.a.a.a
    public byte[] decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        g(bArr, 0, bArr.length, aVar);
        g(bArr, 0, -1, aVar);
        int i2 = aVar.f16054d;
        byte[] bArr2 = new byte[i2];
        x(bArr2, 0, i2, aVar);
        return bArr2;
    }

    @Override // k.b.a.a.b
    public byte[] encode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : j(bArr, 0, bArr.length);
    }

    public abstract void g(byte[] bArr, int i2, int i3, a aVar);

    public byte[] h(String str) {
        return decode(p.k(str));
    }

    public abstract void i(byte[] bArr, int i2, int i3, a aVar);

    public byte[] j(byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        i(bArr, i2, i3, aVar);
        i(bArr, i2, -1, aVar);
        int i4 = aVar.f16054d - aVar.f16055e;
        byte[] bArr2 = new byte[i4];
        x(bArr2, 0, i4, aVar);
        return bArr2;
    }

    public String k(byte[] bArr) {
        return p.t(encode(bArr));
    }

    public String l(byte[] bArr) {
        return p.t(encode(bArr));
    }

    public byte[] m(int i2, a aVar) {
        byte[] bArr = aVar.f16053c;
        if (bArr == null) {
            aVar.f16053c = new byte[Math.max(i2, p())];
            aVar.f16054d = 0;
            aVar.f16055e = 0;
        } else {
            int i3 = aVar.f16054d;
            if ((i3 + i2) - bArr.length > 0) {
                return y(aVar, i3 + i2);
            }
        }
        return aVar.f16053c;
    }

    public CodecPolicy o() {
        return this.f16052g;
    }

    public int p() {
        return 8192;
    }

    public long q(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f16048c;
        long j2 = (((length + i2) - 1) / i2) * this.f16049d;
        int i3 = this.f16050e;
        return i3 > 0 ? j2 + ((((i3 + j2) - 1) / i3) * this.f16051f) : j2;
    }

    public boolean r(a aVar) {
        return aVar.f16053c != null;
    }

    public abstract boolean s(byte b);

    public boolean t(String str) {
        return u(p.k(str), true);
    }

    public boolean u(byte[] bArr, boolean z) {
        for (byte b : bArr) {
            if (!s(b) && (!z || (b != this.b && !w(b)))) {
                return false;
            }
        }
        return true;
    }

    public boolean v() {
        return this.f16052g == CodecPolicy.STRICT;
    }

    public int x(byte[] bArr, int i2, int i3, a aVar) {
        if (aVar.f16053c == null) {
            return aVar.f16056f ? -1 : 0;
        }
        int min = Math.min(a(aVar), i3);
        System.arraycopy(aVar.f16053c, aVar.f16055e, bArr, i2, min);
        int i4 = aVar.f16055e + min;
        aVar.f16055e = i4;
        if (i4 >= aVar.f16054d) {
            aVar.f16053c = null;
        }
        return min;
    }

    public j(int i2, int i3, int i4, int i5, byte b) {
        this(i2, i3, i4, i5, b, p);
    }

    public j(int i2, int i3, int i4, int i5, byte b, CodecPolicy codecPolicy) {
        this.a = (byte) 61;
        this.f16048c = i2;
        this.f16049d = i3;
        this.f16050e = i4 > 0 && i5 > 0 ? (i4 / i3) * i3 : 0;
        this.f16051f = i5;
        this.b = b;
        Objects.requireNonNull(codecPolicy, "codecPolicy");
        this.f16052g = codecPolicy;
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // k.b.a.a.e
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return h((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }
}
