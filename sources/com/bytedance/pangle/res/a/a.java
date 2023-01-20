package com.bytedance.pangle.res.a;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;
import org.conscrypt.NativeConstants;

/* loaded from: classes.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f2314f = Logger.getLogger(a.class.getName());
    private final byte[] a;
    private final h b;

    /* renamed from: c  reason: collision with root package name */
    private final g f2315c;

    /* renamed from: d  reason: collision with root package name */
    private final e f2316d;

    /* renamed from: e  reason: collision with root package name */
    private C0084a f2317e;

    /* renamed from: com.bytedance.pangle.res.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0084a {
        public final short a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2318c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2319d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2320e;

        private C0084a(short s, int i2, int i3, int i4) {
            this.a = s;
            this.b = i2;
            this.f2318c = i3;
            this.f2319d = i4;
            this.f2320e = i4 + i3;
        }

        public static C0084a a(g gVar, e eVar) {
            int a = eVar.a();
            try {
                return new C0084a(gVar.readShort(), gVar.readShort(), gVar.readInt(), a);
            } catch (EOFException unused) {
                return new C0084a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, h hVar) {
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.f2316d = eVar;
        this.f2315c = new g(new i(eVar));
        this.a = bArr;
        this.b = hVar;
    }

    private String a(int i2) {
        int i3;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i3 = i2 - 1;
            if (i2 == 0 || this.f2315c.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i2 = i3;
        }
        this.f2315c.skipBytes(i3);
        return sb.toString();
    }

    private void b() {
        b(NativeConstants.SSL_SIGN_ECDSA_SHA1);
        int readInt = this.f2315c.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f2315c.readInt();
            this.f2315c.skipBytes(256);
        }
        while (j().a == 513) {
            c();
        }
    }

    private void c() {
        d();
        short s = j().a;
        while (s == 514) {
            d();
            s = j().a;
        }
        while (s == 513) {
            e();
            if (this.f2316d.a() < this.f2317e.f2320e) {
                Logger logger = f2314f;
                logger.warning("Unknown data detected. Skipping: " + (this.f2317e.f2320e - this.f2316d.a()) + " byte(s)");
                e eVar = this.f2316d;
                eVar.skip((long) (this.f2317e.f2320e - eVar.a()));
            }
            s = j().a;
        }
    }

    private void d() {
        b(514);
        this.f2315c.readUnsignedByte();
        this.f2315c.skipBytes(3);
        this.f2315c.skipBytes(this.f2315c.readInt() * 4);
    }

    private void e() {
        b(513);
        this.f2315c.readUnsignedByte();
        this.f2315c.readByte();
        this.f2315c.skipBytes(2);
        int readInt = this.f2315c.readInt();
        int readInt2 = this.f2315c.readInt();
        i();
        int i2 = (this.f2317e.f2319d + readInt2) - (readInt * 4);
        if (i2 != this.f2316d.a()) {
            f2314f.warning("Invalid data detected. Skipping: " + (i2 - this.f2316d.a()) + " byte(s)");
            this.f2315c.skipBytes(i2 - this.f2316d.a());
        }
        int[] a = this.f2315c.a(readInt);
        HashSet hashSet = new HashSet();
        for (int i3 : a) {
            if (i3 != -1 && !hashSet.contains(Integer.valueOf(i3))) {
                f();
                hashSet.add(Integer.valueOf(i3));
            }
        }
    }

    private void f() {
        if (this.f2315c.readShort() >= 0) {
            short readShort = this.f2315c.readShort();
            this.f2315c.readInt();
            if ((readShort & 1) == 0) {
                h();
                return;
            } else {
                g();
                return;
            }
        }
        throw new RuntimeException("Entry size is under 0 bytes.");
    }

    private void g() {
        int a = k.a(this.f2315c);
        k.a(this.a, this.f2315c.readInt(), a, this.b);
        int readInt = this.f2315c.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            int a2 = k.a(this.f2315c);
            k.a(this.a, this.f2315c.readInt(), a2, this.b);
            h();
        }
    }

    private void h() {
        this.f2315c.a();
        this.f2315c.b();
        byte readByte = this.f2315c.readByte();
        int a = k.a(this.f2315c);
        int readInt = this.f2315c.readInt();
        if (readByte == 1) {
            k.a(this.a, readInt, a, this.b);
        }
        if (readByte == 2) {
            k.a(this.a, readInt, a, this.b);
        }
    }

    private void i() {
        int readInt = this.f2315c.readInt();
        int i2 = 28;
        if (readInt >= 28) {
            this.f2315c.readShort();
            this.f2315c.readShort();
            this.f2315c.readByte();
            this.f2315c.readByte();
            this.f2315c.readByte();
            this.f2315c.readByte();
            this.f2315c.readByte();
            this.f2315c.readByte();
            this.f2315c.readUnsignedShort();
            this.f2315c.readByte();
            this.f2315c.readByte();
            this.f2315c.readByte();
            this.f2315c.skipBytes(1);
            this.f2315c.readShort();
            this.f2315c.readShort();
            this.f2315c.readShort();
            this.f2315c.skipBytes(2);
            if (readInt >= 32) {
                this.f2315c.readByte();
                this.f2315c.readByte();
                this.f2315c.readShort();
                i2 = 32;
            }
            if (readInt >= 36) {
                this.f2315c.readShort();
                this.f2315c.readShort();
                i2 = 36;
            }
            if (readInt >= 48) {
                a(4).toCharArray();
                a(8).toCharArray();
                i2 = 48;
            }
            if (readInt >= 52) {
                this.f2315c.readByte();
                this.f2315c.readByte();
                this.f2315c.skipBytes(2);
                i2 = 52;
            }
            if (readInt >= 56) {
                this.f2315c.skipBytes(4);
                i2 = 56;
            }
            int i3 = readInt - 56;
            if (i3 > 0) {
                byte[] bArr = new byte[i3];
                i2 += i3;
                this.f2315c.readFully(bArr);
                BigInteger bigInteger = new BigInteger(1, bArr);
                if (bigInteger.equals(BigInteger.ZERO)) {
                    f2314f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
                } else {
                    f2314f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
                }
            }
            int i4 = readInt - i2;
            if (i4 > 0) {
                this.f2315c.skipBytes(i4);
                return;
            }
            return;
        }
        throw new RuntimeException("Config size < 28");
    }

    private C0084a j() {
        C0084a a = C0084a.a(this.f2315c, this.f2316d);
        this.f2317e = a;
        return a;
    }

    public final void a() {
        j();
        b(2);
        int readInt = this.f2315c.readInt();
        l.a(this.f2315c);
        j();
        for (int i2 = 0; i2 < readInt; i2++) {
            b(512);
            this.f2315c.readInt();
            this.f2315c.skipBytes(256);
            this.f2315c.skipBytes(4);
            this.f2315c.skipBytes(4);
            this.f2315c.skipBytes(4);
            this.f2315c.skipBytes(4);
            if (this.f2317e.b == 288 && this.f2315c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            l.a(this.f2315c);
            l.a(this.f2315c);
            j();
            boolean z = true;
            while (z) {
                short s = this.f2317e.a;
                if (s == 514) {
                    c();
                } else if (s != 515) {
                    z = false;
                } else {
                    b();
                }
            }
        }
    }

    private void b(int i2) {
        if (this.f2317e.a != i2) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i2), Short.valueOf(this.f2317e.a)));
        }
    }
}
