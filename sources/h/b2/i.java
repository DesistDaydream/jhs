package h.b2;

import com.umeng.analytics.pro.am;
import h.k2.v.f0;
import h.p;
import h.s0;
import h.v1;
import h.x1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a&\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\bø\u0001\u0000¢\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", am.av, "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes3.dex */
public class i {
    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final short a(short s, short s2) {
        return f0.t(s & 65535, 65535 & s2) >= 0 ? s : s2;
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final int b(int i2, int i3) {
        return v1.c(i2, i3) >= 0 ? i2 : i3;
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final byte c(byte b, byte b2) {
        return f0.t(b & 255, b2 & 255) >= 0 ? b : b2;
    }

    @p
    @s0(version = "1.4")
    public static final int d(int i2, @k.e.a.d int... iArr) {
        for (int i3 : iArr) {
            i2 = b(i2, i3);
        }
        return i2;
    }

    @p
    @s0(version = "1.4")
    public static final long e(long j2, @k.e.a.d long... jArr) {
        for (long j3 : jArr) {
            j2 = j(j2, j3);
        }
        return j2;
    }

    @h.g2.f
    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    private static final short f(short s, short s2, short s3) {
        return a(s, a(s2, s3));
    }

    @h.g2.f
    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    private static final int g(int i2, int i3, int i4) {
        return b(i2, b(i3, i4));
    }

    @p
    @s0(version = "1.4")
    public static final byte h(byte b, @k.e.a.d byte... bArr) {
        for (byte b2 : bArr) {
            b = c(b, b2);
        }
        return b;
    }

    @h.g2.f
    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    private static final byte i(byte b, byte b2, byte b3) {
        return c(b, c(b2, b3));
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final long j(long j2, long j3) {
        return v1.g(j2, j3) >= 0 ? j2 : j3;
    }

    @h.g2.f
    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    private static final long k(long j2, long j3, long j4) {
        return j(j2, j(j3, j4));
    }

    @p
    @s0(version = "1.4")
    public static final short l(short s, @k.e.a.d short... sArr) {
        for (short s2 : sArr) {
            s = a(s, s2);
        }
        return s;
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final short m(short s, short s2) {
        return f0.t(s & 65535, 65535 & s2) <= 0 ? s : s2;
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final int n(int i2, int i3) {
        return v1.c(i2, i3) <= 0 ? i2 : i3;
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final byte o(byte b, byte b2) {
        return f0.t(b & 255, b2 & 255) <= 0 ? b : b2;
    }

    @p
    @s0(version = "1.4")
    public static final int p(int i2, @k.e.a.d int... iArr) {
        for (int i3 : iArr) {
            i2 = n(i2, i3);
        }
        return i2;
    }

    @p
    @s0(version = "1.4")
    public static final long q(long j2, @k.e.a.d long... jArr) {
        for (long j3 : jArr) {
            j2 = v(j2, j3);
        }
        return j2;
    }

    @h.g2.f
    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    private static final short r(short s, short s2, short s3) {
        return m(s, m(s2, s3));
    }

    @h.g2.f
    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    private static final int s(int i2, int i3, int i4) {
        return n(i2, n(i3, i4));
    }

    @p
    @s0(version = "1.4")
    public static final byte t(byte b, @k.e.a.d byte... bArr) {
        for (byte b2 : bArr) {
            b = o(b, b2);
        }
        return b;
    }

    @h.g2.f
    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    private static final byte u(byte b, byte b2, byte b3) {
        return o(b, o(b2, b3));
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final long v(long j2, long j3) {
        return v1.g(j2, j3) <= 0 ? j2 : j3;
    }

    @h.g2.f
    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    private static final long w(long j2, long j3, long j4) {
        return v(j2, v(j3, j4));
    }

    @p
    @s0(version = "1.4")
    public static final short x(short s, @k.e.a.d short... sArr) {
        for (short s2 : sArr) {
            s = m(s, s2);
        }
        return s;
    }
}
