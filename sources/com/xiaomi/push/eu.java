package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* loaded from: classes3.dex */
public class eu {
    public static final byte[] a = {80, 85, 83, 72};
    private short b;

    /* renamed from: c  reason: collision with root package name */
    private byte f8555c;

    /* renamed from: d  reason: collision with root package name */
    private int f8556d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f8557e;

    /* loaded from: classes3.dex */
    public static class a {
        public static final c a = new c();
        public static final d b = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, b);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (eu.b(bArr)) {
                eu a2 = eu.a(bArr);
                return (a2.f8555c == 0 || a2.f8555c != bVar.a()) ? a2.f8557e : bVar.a(a2.f8557e, a2.f8556d);
            }
            return bArr;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i2);
    }

    /* loaded from: classes3.dex */
    public static final class c {
    }

    /* loaded from: classes3.dex */
    public static final class d implements b {
        @Override // com.xiaomi.push.eu.b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.eu.b
        public byte[] a(byte[] bArr, int i2) {
            GZIPInputStream gZIPInputStream;
            GZIPInputStream gZIPInputStream2 = null;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i2);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[i2];
                gZIPInputStream.read(bArr2);
                try {
                    gZIPInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            } catch (IOException unused3) {
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    public eu(byte b2, int i2, byte[] bArr) {
        this((short) 1, b2, i2, bArr);
    }

    public eu(short s, byte b2, int i2, byte[] bArr) {
        this.b = (short) 1;
        this.b = s;
        this.f8555c = b2;
        this.f8556d = i2;
        this.f8557e = bArr;
    }

    public static eu a(byte b2, int i2, byte[] bArr) {
        return new eu(b2, i2, bArr);
    }

    public static eu a(short s, byte b2, int i2, byte[] bArr) {
        return new eu(s, b2, i2, bArr);
    }

    public static eu a(byte[] bArr) {
        if (b(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b2 = order.get();
            int i2 = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return a(s, b2, i2, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i2) {
        if (bArr.length < i2 || bArr2.length < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(byte[] bArr) {
        byte[] bArr2 = a;
        return a(bArr2, bArr, bArr2.length);
    }
}
