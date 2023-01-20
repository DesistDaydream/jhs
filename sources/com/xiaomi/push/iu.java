package com.xiaomi.push;

import com.xiaomi.push.ik;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class iu extends ik {

    /* renamed from: f  reason: collision with root package name */
    private static int f9007f = 10000;

    /* renamed from: g  reason: collision with root package name */
    private static int f9008g = 10000;

    /* renamed from: h  reason: collision with root package name */
    private static int f9009h = 10000;

    /* renamed from: i  reason: collision with root package name */
    private static int f9010i = 10485760;

    /* renamed from: j  reason: collision with root package name */
    private static int f9011j = 104857600;

    /* loaded from: classes3.dex */
    public static class a extends ik.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i2) {
            super(z, z2, i2);
        }

        @Override // com.xiaomi.push.ik.a, com.xiaomi.push.iq
        public io a(iy iyVar) {
            iu iuVar = new iu(iyVar, this.a, this.b);
            int i2 = this.f9003c;
            if (i2 != 0) {
                iuVar.c(i2);
            }
            return iuVar;
        }
    }

    public iu(iy iyVar, boolean z, boolean z2) {
        super(iyVar, z, z2);
    }

    @Override // com.xiaomi.push.ik, com.xiaomi.push.io
    public in j() {
        byte q = q();
        byte q2 = q();
        int s = s();
        if (s <= f9007f) {
            return new in(q, q2, s);
        }
        throw new ip(3, "Thrift map size " + s + " out of range!");
    }

    @Override // com.xiaomi.push.ik, com.xiaomi.push.io
    public im l() {
        byte q = q();
        int s = s();
        if (s <= f9008g) {
            return new im(q, s);
        }
        throw new ip(3, "Thrift list size " + s + " out of range!");
    }

    @Override // com.xiaomi.push.ik, com.xiaomi.push.io
    public is n() {
        byte q = q();
        int s = s();
        if (s <= f9009h) {
            return new is(q, s);
        }
        throw new ip(3, "Thrift set size " + s + " out of range!");
    }

    @Override // com.xiaomi.push.ik, com.xiaomi.push.io
    public String v() {
        int s = s();
        if (s > f9010i) {
            throw new ip(3, "Thrift string size " + s + " out of range!");
        } else if (this.f9006e.c() >= s) {
            try {
                String str = new String(this.f9006e.a(), this.f9006e.b(), s, "UTF-8");
                this.f9006e.a(s);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new ih("JVM DOES NOT SUPPORT UTF-8");
            }
        } else {
            return b(s);
        }
    }

    @Override // com.xiaomi.push.ik, com.xiaomi.push.io
    public ByteBuffer w() {
        int s = s();
        if (s > f9011j) {
            throw new ip(3, "Thrift binary size " + s + " out of range!");
        }
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
