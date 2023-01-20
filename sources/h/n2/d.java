package h.n2;

import h.o2.k;
import h.o2.n;
import h.s0;
import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.random.XorWowRandom;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, d2 = {"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class d {
    @s0(version = "1.3")
    @k.e.a.d
    public static final Random a(int i2) {
        return new XorWowRandom(i2, i2 >> 31);
    }

    @s0(version = "1.3")
    @k.e.a.d
    public static final Random b(long j2) {
        return new XorWowRandom((int) j2, (int) (j2 >> 32));
    }

    @k.e.a.d
    public static final String c(@k.e.a.d Object obj, @k.e.a.d Object obj2) {
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void d(double d2, double d3) {
        if (!(d3 > d2)) {
            throw new IllegalArgumentException(c(Double.valueOf(d2), Double.valueOf(d3)).toString());
        }
    }

    public static final void e(int i2, int i3) {
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(c(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    public static final void f(long j2, long j3) {
        if (!(j3 > j2)) {
            throw new IllegalArgumentException(c(Long.valueOf(j2), Long.valueOf(j3)).toString());
        }
    }

    public static final int g(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    @s0(version = "1.3")
    public static final int h(@k.e.a.d Random random, @k.e.a.d k kVar) {
        if (!kVar.isEmpty()) {
            return kVar.f() < Integer.MAX_VALUE ? random.nextInt(kVar.d(), kVar.f() + 1) : kVar.d() > Integer.MIN_VALUE ? random.nextInt(kVar.d() - 1, kVar.f()) + 1 : random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + kVar);
    }

    @s0(version = "1.3")
    public static final long i(@k.e.a.d Random random, @k.e.a.d n nVar) {
        if (!nVar.isEmpty()) {
            return nVar.f() < Long.MAX_VALUE ? random.nextLong(nVar.d(), nVar.f() + 1) : nVar.d() > Long.MIN_VALUE ? random.nextLong(nVar.d() - 1, nVar.f()) + 1 : random.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + nVar);
    }

    public static final int j(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }
}
