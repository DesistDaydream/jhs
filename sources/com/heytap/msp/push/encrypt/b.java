package com.heytap.msp.push.encrypt;

import k.b.a.a.k.p;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes2.dex */
public abstract class b implements k.b.a.a.a, k.b.a.a.b {
    private static final int a = 2;
    public static final int b = 76;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3363c = 64;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3364d = 255;

    /* renamed from: e  reason: collision with root package name */
    public static final byte f3365e = 61;

    /* renamed from: m  reason: collision with root package name */
    private static final int f3366m = 8192;

    /* renamed from: f  reason: collision with root package name */
    public final byte f3367f = 61;

    /* renamed from: g  reason: collision with root package name */
    public final int f3368g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f3369h;

    /* renamed from: i  reason: collision with root package name */
    public int f3370i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3371j;

    /* renamed from: k  reason: collision with root package name */
    public int f3372k;

    /* renamed from: l  reason: collision with root package name */
    public int f3373l;
    private final int n;
    private final int o;
    private final int p;
    private int q;

    public b(int i2, int i3, int i4, int i5) {
        this.n = i2;
        this.o = i3;
        this.f3368g = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.p = i5;
    }

    private void a() {
        byte[] bArr = this.f3369h;
        if (bArr == null) {
            this.f3369h = new byte[d()];
            this.f3370i = 0;
            this.q = 0;
            return;
        }
        byte[] bArr2 = new byte[bArr.length * 2];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f3369h = bArr2;
    }

    public static boolean c(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void e() {
        this.f3369h = null;
        this.f3370i = 0;
        this.q = 0;
        this.f3372k = 0;
        this.f3373l = 0;
        this.f3371j = false;
    }

    public void a(int i2) {
        byte[] bArr = this.f3369h;
        if (bArr == null || bArr.length < this.f3370i + i2) {
            a();
        }
    }

    public abstract void a(byte[] bArr, int i2, int i3);

    public abstract void b(byte[] bArr, int i2, int i3);

    public boolean b() {
        return this.f3369h != null;
    }

    public abstract boolean b(byte b2);

    public boolean b(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!b(bArr[i2]) && (!z || (bArr[i2] != 61 && !c(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    public int c() {
        if (this.f3369h != null) {
            return this.f3370i - this.q;
        }
        return 0;
    }

    public int c(byte[] bArr, int i2, int i3) {
        if (this.f3369h == null) {
            return this.f3371j ? -1 : 0;
        }
        int min = Math.min(c(), i3);
        System.arraycopy(this.f3369h, this.q, bArr, i2, min);
        int i4 = this.q + min;
        this.q = i4;
        if (i4 >= this.f3370i) {
            this.f3369h = null;
        }
        return min;
    }

    public byte[] c(String str) {
        return decode(p.k(str));
    }

    public int d() {
        return 8192;
    }

    public boolean d(String str) {
        return b(p.k(str), true);
    }

    @Override // k.b.a.a.e
    public Object decode(Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return c((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // k.b.a.a.a
    public byte[] decode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        int i2 = this.f3370i;
        byte[] bArr2 = new byte[i2];
        c(bArr2, 0, i2);
        return bArr2;
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // k.b.a.a.b
    public byte[] encode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        int i2 = this.f3370i - this.q;
        byte[] bArr2 = new byte[i2];
        c(bArr2, 0, i2);
        return bArr2;
    }

    public String j(byte[] bArr) {
        return p.t(encode(bArr));
    }

    public String k(byte[] bArr) {
        return p.t(encode(bArr));
    }

    public boolean l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || b(b2)) {
                return true;
            }
        }
        return false;
    }

    public long m(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.n;
        long j2 = (((length + i2) - 1) / i2) * this.o;
        int i3 = this.f3368g;
        return i3 > 0 ? j2 + ((((i3 + j2) - 1) / i3) * this.p) : j2;
    }
}
