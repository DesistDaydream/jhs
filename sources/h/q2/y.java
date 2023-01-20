package h.q2;

import h.b1;
import h.f1;
import h.j1;
import h.p1;
import h.s0;
import h.x1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/sequences/USequencesKt")
/* loaded from: classes4.dex */
public class y {
    @h.k2.g(name = "sumOfUByte")
    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final int a(@k.e.a.d m<b1> mVar) {
        int i2 = 0;
        for (b1 b1Var : mVar) {
            i2 = f1.i(i2 + f1.i(b1Var.k0() & 255));
        }
        return i2;
    }

    @h.k2.g(name = "sumOfUInt")
    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final int b(@k.e.a.d m<f1> mVar) {
        int i2 = 0;
        for (f1 f1Var : mVar) {
            i2 = f1.i(i2 + f1Var.m0());
        }
        return i2;
    }

    @h.k2.g(name = "sumOfULong")
    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final long c(@k.e.a.d m<j1> mVar) {
        long j2 = 0;
        for (j1 j1Var : mVar) {
            j2 = j1.i(j2 + j1Var.m0());
        }
        return j2;
    }

    @h.k2.g(name = "sumOfUShort")
    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final int d(@k.e.a.d m<p1> mVar) {
        int i2 = 0;
        for (p1 p1Var : mVar) {
            i2 = f1.i(i2 + f1.i(p1Var.k0() & 65535));
        }
        return i2;
    }
}
