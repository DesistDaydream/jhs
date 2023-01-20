package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class bo extends bu {

    /* renamed from: d  reason: collision with root package name */
    private static final bz f7082d = new bz("");

    /* renamed from: e  reason: collision with root package name */
    private static final bp f7083e = new bp("", (byte) 0, 0);

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f7084f;

    /* renamed from: h  reason: collision with root package name */
    private static final byte f7085h = -126;

    /* renamed from: i  reason: collision with root package name */
    private static final byte f7086i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final byte f7087j = 31;

    /* renamed from: k  reason: collision with root package name */
    private static final byte f7088k = -32;

    /* renamed from: l  reason: collision with root package name */
    private static final int f7089l = 5;
    public byte[] a;
    public byte[] b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f7090c;

    /* renamed from: m  reason: collision with root package name */
    private at f7091m;
    private short n;
    private bp o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* loaded from: classes3.dex */
    public static class b {
        public static final byte a = 1;
        public static final byte b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final byte f7092c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final byte f7093d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final byte f7094e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final byte f7095f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final byte f7096g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final byte f7097h = 8;

        /* renamed from: i  reason: collision with root package name */
        public static final byte f7098i = 9;

        /* renamed from: j  reason: collision with root package name */
        public static final byte f7099j = 10;

        /* renamed from: k  reason: collision with root package name */
        public static final byte f7100k = 11;

        /* renamed from: l  reason: collision with root package name */
        public static final byte f7101l = 12;

        private b() {
        }
    }

    static {
        f7084f = r0;
        byte[] bArr = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    }

    public bo(ci ciVar, long j2) {
        super(ciVar);
        this.f7091m = new at(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.f7090c = new byte[1];
        this.q = j2;
    }

    private int E() throws bb {
        int i2 = 0;
        if (this.f7107g.h() >= 5) {
            byte[] f2 = this.f7107g.f();
            int g2 = this.f7107g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = f2[g2 + i2];
                i3 |= (b2 & h.k2.v.n.b) << i4;
                if ((b2 & h.k2.v.n.a) != 128) {
                    this.f7107g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte u = u();
                i2 |= (u & h.k2.v.n.b) << i5;
                if ((u & h.k2.v.n.a) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws bb {
        byte u;
        byte b2;
        int i2 = 0;
        long j2 = 0;
        if (this.f7107g.h() >= 10) {
            byte[] f2 = this.f7107g.f();
            int g2 = this.f7107g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                j3 |= (b2 & h.k2.v.n.b) << i3;
                if ((f2[g2 + i2] & h.k2.v.n.a) != 128) {
                    this.f7107g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                j2 |= (u & h.k2.v.n.b) << i2;
                if ((u() & h.k2.v.n.a) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & cb.f7124m;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private byte[] e(int i2) throws bb {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.f7107g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws bv {
        if (i2 >= 0) {
            long j2 = this.q;
            if (j2 == -1 || i2 <= j2) {
                return;
            }
            throw new bv("Length exceeded max allowed: " + i2);
        }
        throw new bv("Negative length: " + i2);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public ByteBuffer A() throws bb {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.f7107g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bu
    public void B() {
        this.f7091m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bu
    public void a() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bs bsVar) throws bb {
        b(f7085h);
        d(((bsVar.b << 5) & (-32)) | 1);
        b(bsVar.f7104c);
        a(bsVar.a);
    }

    @Override // com.umeng.analytics.pro.bu
    public void b() throws bb {
        this.n = this.f7091m.a();
    }

    @Override // com.umeng.analytics.pro.bu
    public void c() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void d() throws bb {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void e() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void f() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void g() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public bs h() throws bb {
        byte u = u();
        if (u == -126) {
            byte u2 = u();
            byte b2 = (byte) (u2 & f7087j);
            if (b2 == 1) {
                int E = E();
                return new bs(z(), (byte) ((u2 >> 5) & 3), E);
            }
            throw new bv("Expected version 1 but got " + ((int) b2));
        }
        throw new bv("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
    }

    @Override // com.umeng.analytics.pro.bu
    public void i() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public bz j() throws bb {
        this.f7091m.a(this.n);
        this.n = (short) 0;
        return f7082d;
    }

    @Override // com.umeng.analytics.pro.bu
    public void k() throws bb {
        this.n = this.f7091m.a();
    }

    @Override // com.umeng.analytics.pro.bu
    public bp l() throws bb {
        short s;
        byte u = u();
        if (u == 0) {
            return f7083e;
        }
        short s2 = (short) ((u & 240) >> 4);
        if (s2 == 0) {
            s = v();
        } else {
            s = (short) (this.n + s2);
        }
        byte b2 = (byte) (u & cb.f7124m);
        bp bpVar = new bp("", d(b2), s);
        if (c(u)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = bpVar.f7102c;
        return bpVar;
    }

    @Override // com.umeng.analytics.pro.bu
    public void m() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public br n() throws bb {
        int E = E();
        byte u = E == 0 ? (byte) 0 : u();
        return new br(d((byte) (u >> 4)), d((byte) (u & cb.f7124m)), E);
    }

    @Override // com.umeng.analytics.pro.bu
    public void o() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public bq p() throws bb {
        byte u = u();
        int i2 = (u >> 4) & 15;
        if (i2 == 15) {
            i2 = E();
        }
        return new bq(d(u), i2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void q() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public by r() throws bb {
        return new by(p());
    }

    @Override // com.umeng.analytics.pro.bu
    public void s() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public boolean t() throws bb {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.bu
    public byte u() throws bb {
        if (this.f7107g.h() > 0) {
            byte b2 = this.f7107g.f()[this.f7107g.g()];
            this.f7107g.a(1);
            return b2;
        }
        this.f7107g.d(this.f7090c, 0, 1);
        return this.f7090c[0];
    }

    @Override // com.umeng.analytics.pro.bu
    public short v() throws bb {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.bu
    public int w() throws bb {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.bu
    public long x() throws bb {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.bu
    public double y() throws bb {
        byte[] bArr = new byte[8];
        this.f7107g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.bu
    public String z() throws bb {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.f7107g.h() >= E) {
                String str = new String(this.f7107g.f(), this.f7107g.g(), E, "UTF-8");
                this.f7107g.a(E);
                return str;
            }
            return new String(e(E), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bb("UTF-8 not supported!");
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements bw {
        private final long a;

        public a() {
            this.a = -1L;
        }

        @Override // com.umeng.analytics.pro.bw
        public bu a(ci ciVar) {
            return new bo(ciVar, this.a);
        }

        public a(int i2) {
            this.a = i2;
        }
    }

    private void b(int i2) throws bb {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i2;
        this.f7107g.b(bArr, 0, i3 + 1);
    }

    private void d(int i2) throws bb {
        b((byte) i2);
    }

    private byte d(byte b2) throws bv {
        byte b3 = (byte) (b2 & cb.f7124m);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return cb.f7124m;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new bv("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f7084f[b2];
    }

    private void b(long j2) throws bb {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.b;
        bArr[i2] = (byte) j2;
        this.f7107g.b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bz bzVar) throws bb {
        this.f7091m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bp bpVar) throws bb {
        if (bpVar.b == 2) {
            this.o = bpVar;
        } else {
            a(bpVar, (byte) -1);
        }
    }

    private void b(byte b2) throws bb {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.f7107g.b(bArr);
    }

    private void a(bp bpVar, byte b2) throws bb {
        if (b2 == -1) {
            b2 = e(bpVar.b);
        }
        short s = bpVar.f7102c;
        short s2 = this.n;
        if (s > s2 && s - s2 <= 15) {
            d(b2 | ((s - s2) << 4));
        } else {
            b(b2);
            a(bpVar.f7102c);
        }
        this.n = bpVar.f7102c;
    }

    public bo(ci ciVar) {
        this(ciVar, -1L);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(br brVar) throws bb {
        int i2 = brVar.f7103c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(brVar.b) | (e(brVar.a) << 4));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bq bqVar) throws bb {
        a(bqVar.a, bqVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(by byVar) throws bb {
        a(byVar.a, byVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(boolean z) throws bb {
        bp bpVar = this.o;
        if (bpVar != null) {
            a(bpVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
            return;
        }
        b(z ? (byte) 1 : (byte) 2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(byte b2) throws bb {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(short s) throws bb {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(int i2) throws bb {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(long j2) throws bb {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(double d2) throws bb {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.f7107g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(String str) throws bb {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(ByteBuffer byteBuffer) throws bb {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bb {
        b(i3);
        this.f7107g.b(bArr, i2, i3);
    }

    public void a(byte b2, int i2) throws bb {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
            return;
        }
        d(e(b2) | 240);
        b(i2);
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
