package h;

import kotlin.Metadata;

@h.k2.g(name = "UnsignedKt")
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class v1 {
    @p0
    public static final int a(double d2) {
        if (!Double.isNaN(d2) && d2 > f(0)) {
            if (d2 >= f(-1)) {
                return -1;
            }
            double d3 = Integer.MAX_VALUE;
            if (d2 <= d3) {
                return f1.i((int) d2);
            }
            return f1.i(f1.i((int) (d2 - d3)) + f1.i(Integer.MAX_VALUE));
        }
        return 0;
    }

    @p0
    public static final long b(double d2) {
        if (!Double.isNaN(d2) && d2 > j(0L)) {
            if (d2 >= j(-1L)) {
                return -1L;
            }
            if (d2 < Long.MAX_VALUE) {
                return j1.i((long) d2);
            }
            return j1.i(j1.i((long) (d2 - 9.223372036854776E18d)) - Long.MIN_VALUE);
        }
        return 0L;
    }

    @p0
    public static final int c(int i2, int i3) {
        return h.k2.v.f0.t(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    @p0
    public static final int d(int i2, int i3) {
        return f1.i((int) ((i2 & 4294967295L) / (i3 & 4294967295L)));
    }

    @p0
    public static final int e(int i2, int i3) {
        return f1.i((int) ((i2 & 4294967295L) % (i3 & 4294967295L)));
    }

    @p0
    public static final double f(int i2) {
        return (Integer.MAX_VALUE & i2) + (((i2 >>> 31) << 30) * 2);
    }

    @p0
    public static final int g(long j2, long j3) {
        return ((j2 ^ Long.MIN_VALUE) > (j3 ^ Long.MIN_VALUE) ? 1 : ((j2 ^ Long.MIN_VALUE) == (j3 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    @p0
    public static final long h(long j2, long j3) {
        if (j3 < 0) {
            return g(j2, j3) < 0 ? j1.i(0L) : j1.i(1L);
        } else if (j2 >= 0) {
            return j1.i(j2 / j3);
        } else {
            long j4 = ((j2 >>> 1) / j3) << 1;
            return j1.i(j4 + (g(j1.i(j2 - (j4 * j3)), j1.i(j3)) < 0 ? 0 : 1));
        }
    }

    @p0
    public static final long i(long j2, long j3) {
        if (j3 < 0) {
            return g(j2, j3) < 0 ? j2 : j1.i(j2 - j3);
        } else if (j2 >= 0) {
            return j1.i(j2 % j3);
        } else {
            long j4 = j2 - ((((j2 >>> 1) / j3) << 1) * j3);
            if (g(j1.i(j4), j1.i(j3)) < 0) {
                j3 = 0;
            }
            return j1.i(j4 - j3);
        }
    }

    @p0
    public static final double j(long j2) {
        return ((j2 >>> 11) * 2048) + (j2 & 2047);
    }

    @k.e.a.d
    public static final String k(long j2) {
        return l(j2, 10);
    }

    @k.e.a.d
    public static final String l(long j2, int i2) {
        if (j2 >= 0) {
            return Long.toString(j2, h.t2.b.a(i2));
        }
        long j3 = i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        return Long.toString(j4, h.t2.b.a(i2)) + Long.toString(j5, h.t2.b.a(i2));
    }
}
