package h.n2;

import h.c1;
import h.f1;
import h.j1;
import h.o2.t;
import h.o2.w;
import h.p;
import h.s0;
import h.v1;
import h.x1;
import kotlin.Metadata;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\b*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u001e\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class e {
    public static final void a(int i2, int i3) {
        if (!(v1.c(i3, i2) > 0)) {
            throw new IllegalArgumentException(d.c(f1.b(i2), f1.b(i3)).toString());
        }
    }

    public static final void b(long j2, long j3) {
        if (!(v1.g(j3, j2) > 0)) {
            throw new IllegalArgumentException(d.c(j1.b(j2), j1.b(j3)).toString());
        }
    }

    @p
    @s0(version = "1.3")
    @k.e.a.d
    public static final byte[] c(@k.e.a.d Random random, int i2) {
        return c1.g(random.nextBytes(i2));
    }

    @p
    @s0(version = "1.3")
    @k.e.a.d
    public static final byte[] d(@k.e.a.d Random random, @k.e.a.d byte[] bArr) {
        random.nextBytes(bArr);
        return bArr;
    }

    @p
    @s0(version = "1.3")
    @k.e.a.d
    public static final byte[] e(@k.e.a.d Random random, @k.e.a.d byte[] bArr, int i2, int i3) {
        random.nextBytes(bArr, i2, i3);
        return bArr;
    }

    public static /* synthetic */ byte[] f(Random random, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = c1.t(bArr);
        }
        return e(random, bArr, i2, i3);
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final int g(@k.e.a.d Random random) {
        return f1.i(random.nextInt());
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final int h(@k.e.a.d Random random, @k.e.a.d t tVar) {
        if (!tVar.isEmpty()) {
            return v1.c(tVar.f(), -1) < 0 ? i(random, tVar.d(), f1.i(tVar.f() + 1)) : v1.c(tVar.d(), 0) > 0 ? f1.i(i(random, f1.i(tVar.d() - 1), tVar.f()) + 1) : g(random);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + tVar);
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final int i(@k.e.a.d Random random, int i2, int i3) {
        a(i2, i3);
        return f1.i(random.nextInt(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final int j(@k.e.a.d Random random, int i2) {
        return i(random, 0, i2);
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final long k(@k.e.a.d Random random) {
        return j1.i(random.nextLong());
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final long l(@k.e.a.d Random random, @k.e.a.d w wVar) {
        if (!wVar.isEmpty()) {
            if (v1.g(wVar.f(), -1L) < 0) {
                return n(random, wVar.d(), j1.i(wVar.f() + j1.i(1 & 4294967295L)));
            }
            if (v1.g(wVar.d(), 0L) > 0) {
                long j2 = 1 & 4294967295L;
                return j1.i(n(random, j1.i(wVar.d() - j1.i(j2)), wVar.f()) + j1.i(j2));
            }
            return k(random);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + wVar);
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final long m(@k.e.a.d Random random, long j2) {
        return n(random, 0L, j2);
    }

    @x1(markerClass = {p.class})
    @s0(version = "1.5")
    public static final long n(@k.e.a.d Random random, long j2, long j3) {
        b(j2, j3);
        return j1.i(random.nextLong(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }
}
