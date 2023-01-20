package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ik extends io {

    /* renamed from: f  reason: collision with root package name */
    private static final it f8993f = new it();
    public boolean a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public int f8994c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8995d;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f8996g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f8997h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f8998i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f8999j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f9000k;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f9001l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f9002m;
    private byte[] n;

    /* loaded from: classes3.dex */
    public static class a implements iq {
        public boolean a;
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public int f9003c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i2) {
            this.a = false;
            this.b = true;
            this.a = z;
            this.b = z2;
            this.f9003c = i2;
        }

        @Override // com.xiaomi.push.iq
        public io a(iy iyVar) {
            ik ikVar = new ik(iyVar, this.a, this.b);
            int i2 = this.f9003c;
            if (i2 != 0) {
                ikVar.c(i2);
            }
            return ikVar;
        }
    }

    public ik(iy iyVar, boolean z, boolean z2) {
        super(iyVar);
        this.a = false;
        this.b = true;
        this.f8995d = false;
        this.f8996g = new byte[1];
        this.f8997h = new byte[2];
        this.f8998i = new byte[4];
        this.f8999j = new byte[8];
        this.f9000k = new byte[1];
        this.f9001l = new byte[2];
        this.f9002m = new byte[4];
        this.n = new byte[8];
        this.a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i2, int i3) {
        d(i3);
        return this.f9006e.d(bArr, i2, i3);
    }

    @Override // com.xiaomi.push.io
    public void a() {
    }

    @Override // com.xiaomi.push.io
    public void a(byte b) {
        byte[] bArr = this.f8996g;
        bArr[0] = b;
        this.f9006e.b(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.io
    public void a(int i2) {
        byte[] bArr = this.f8998i;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        this.f9006e.b(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.io
    public void a(long j2) {
        byte[] bArr = this.f8999j;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        this.f9006e.b(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.io
    public void a(il ilVar) {
        a(ilVar.b);
        a(ilVar.f9004c);
    }

    @Override // com.xiaomi.push.io
    public void a(im imVar) {
        a(imVar.a);
        a(imVar.b);
    }

    @Override // com.xiaomi.push.io
    public void a(in inVar) {
        a(inVar.a);
        a(inVar.b);
        a(inVar.f9005c);
    }

    @Override // com.xiaomi.push.io
    public void a(it itVar) {
    }

    @Override // com.xiaomi.push.io
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f9006e.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new ih("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.io
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        a(limit);
        this.f9006e.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.io
    public void a(short s) {
        byte[] bArr = this.f8997h;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f9006e.b(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.io
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    public String b(int i2) {
        try {
            d(i2);
            byte[] bArr = new byte[i2];
            this.f9006e.d(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new ih("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.io
    public void b() {
    }

    @Override // com.xiaomi.push.io
    public void c() {
        a((byte) 0);
    }

    public void c(int i2) {
        this.f8994c = i2;
        this.f8995d = true;
    }

    @Override // com.xiaomi.push.io
    public void d() {
    }

    public void d(int i2) {
        if (i2 < 0) {
            throw new ih("Negative length: " + i2);
        } else if (this.f8995d) {
            int i3 = this.f8994c - i2;
            this.f8994c = i3;
            if (i3 >= 0) {
                return;
            }
            throw new ih("Message length exceeded: " + i2);
        }
    }

    @Override // com.xiaomi.push.io
    public void e() {
    }

    @Override // com.xiaomi.push.io
    public it f() {
        return f8993f;
    }

    @Override // com.xiaomi.push.io
    public void g() {
    }

    @Override // com.xiaomi.push.io
    public il h() {
        byte q = q();
        return new il("", q, q == 0 ? (short) 0 : r());
    }

    @Override // com.xiaomi.push.io
    public void i() {
    }

    @Override // com.xiaomi.push.io
    public in j() {
        return new in(q(), q(), s());
    }

    @Override // com.xiaomi.push.io
    public void k() {
    }

    @Override // com.xiaomi.push.io
    public im l() {
        return new im(q(), s());
    }

    @Override // com.xiaomi.push.io
    public void m() {
    }

    @Override // com.xiaomi.push.io
    public is n() {
        return new is(q(), s());
    }

    @Override // com.xiaomi.push.io
    public void o() {
    }

    @Override // com.xiaomi.push.io
    public boolean p() {
        return q() == 1;
    }

    @Override // com.xiaomi.push.io
    public byte q() {
        if (this.f9006e.c() < 1) {
            a(this.f9000k, 0, 1);
            return this.f9000k[0];
        }
        byte b = this.f9006e.a()[this.f9006e.b()];
        this.f9006e.a(1);
        return b;
    }

    @Override // com.xiaomi.push.io
    public short r() {
        byte[] bArr = this.f9001l;
        int i2 = 0;
        if (this.f9006e.c() >= 2) {
            bArr = this.f9006e.a();
            i2 = this.f9006e.b();
            this.f9006e.a(2);
        } else {
            a(this.f9001l, 0, 2);
        }
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    @Override // com.xiaomi.push.io
    public int s() {
        byte[] bArr = this.f9002m;
        int i2 = 0;
        if (this.f9006e.c() >= 4) {
            bArr = this.f9006e.a();
            i2 = this.f9006e.b();
            this.f9006e.a(4);
        } else {
            a(this.f9002m, 0, 4);
        }
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.io
    public long t() {
        byte[] bArr = this.n;
        int i2 = 0;
        if (this.f9006e.c() >= 8) {
            bArr = this.f9006e.a();
            i2 = this.f9006e.b();
            this.f9006e.a(8);
        } else {
            a(this.n, 0, 8);
        }
        return (bArr[i2 + 7] & 255) | ((bArr[i2] & 255) << 56) | ((bArr[i2 + 1] & 255) << 48) | ((bArr[i2 + 2] & 255) << 40) | ((bArr[i2 + 3] & 255) << 32) | ((bArr[i2 + 4] & 255) << 24) | ((bArr[i2 + 5] & 255) << 16) | ((bArr[i2 + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.io
    public double u() {
        return Double.longBitsToDouble(t());
    }

    @Override // com.xiaomi.push.io
    public String v() {
        int s = s();
        if (this.f9006e.c() >= s) {
            try {
                String str = new String(this.f9006e.a(), this.f9006e.b(), s, "UTF-8");
                this.f9006e.a(s);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new ih("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return b(s);
    }

    @Override // com.xiaomi.push.io
    public ByteBuffer w() {
        int s = s();
        d(s);
        if (this.f9006e.c() >= s) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f9006e.a(), this.f9006e.b(), s);
            this.f9006e.a(s);
            return wrap;
        }
        byte[] bArr = new byte[s];
        this.f9006e.d(bArr, 0, s);
        return ByteBuffer.wrap(bArr);
    }
}
