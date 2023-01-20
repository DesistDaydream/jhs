package h.a2;

import h.p1;
import h.q1;
import h.x1;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u001a\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes3.dex */
public class k1 {
    @h.k2.g(name = "sumOfUByte")
    @x1(markerClass = {h.p.class})
    @h.s0(version = "1.5")
    public static final int a(@k.e.a.d Iterable<h.b1> iterable) {
        int i2 = 0;
        for (h.b1 b1Var : iterable) {
            i2 = h.f1.i(i2 + h.f1.i(b1Var.k0() & 255));
        }
        return i2;
    }

    @h.k2.g(name = "sumOfUInt")
    @x1(markerClass = {h.p.class})
    @h.s0(version = "1.5")
    public static final int b(@k.e.a.d Iterable<h.f1> iterable) {
        int i2 = 0;
        for (h.f1 f1Var : iterable) {
            i2 = h.f1.i(i2 + f1Var.m0());
        }
        return i2;
    }

    @h.k2.g(name = "sumOfULong")
    @x1(markerClass = {h.p.class})
    @h.s0(version = "1.5")
    public static final long c(@k.e.a.d Iterable<h.j1> iterable) {
        long j2 = 0;
        for (h.j1 j1Var : iterable) {
            j2 = h.j1.i(j2 + j1Var.m0());
        }
        return j2;
    }

    @h.k2.g(name = "sumOfUShort")
    @x1(markerClass = {h.p.class})
    @h.s0(version = "1.5")
    public static final int d(@k.e.a.d Iterable<p1> iterable) {
        int i2 = 0;
        for (p1 p1Var : iterable) {
            i2 = h.f1.i(i2 + h.f1.i(p1Var.k0() & 65535));
        }
        return i2;
    }

    @h.p
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final byte[] e(@k.e.a.d Collection<h.b1> collection) {
        byte[] f2 = h.c1.f(collection.size());
        int i2 = 0;
        for (h.b1 b1Var : collection) {
            h.c1.y(f2, i2, b1Var.k0());
            i2++;
        }
        return f2;
    }

    @h.p
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final int[] f(@k.e.a.d Collection<h.f1> collection) {
        int[] f2 = h.g1.f(collection.size());
        int i2 = 0;
        for (h.f1 f1Var : collection) {
            h.g1.y(f2, i2, f1Var.m0());
            i2++;
        }
        return f2;
    }

    @h.p
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final long[] g(@k.e.a.d Collection<h.j1> collection) {
        long[] f2 = h.k1.f(collection.size());
        int i2 = 0;
        for (h.j1 j1Var : collection) {
            h.k1.y(f2, i2, j1Var.m0());
            i2++;
        }
        return f2;
    }

    @h.p
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final short[] h(@k.e.a.d Collection<p1> collection) {
        short[] f2 = q1.f(collection.size());
        int i2 = 0;
        for (p1 p1Var : collection) {
            q1.y(f2, i2, p1Var.k0());
            i2++;
        }
        return f2;
    }
}
