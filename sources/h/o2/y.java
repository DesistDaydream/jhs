package h.o2;

import h.b1;
import h.f1;
import h.j1;
import h.k2.v.f0;
import h.o2.r;
import h.o2.u;
import h.p1;
import h.s0;
import h.v1;
import h.x1;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.random.Random;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\nø\u0001\u0000¢\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\nø\u0001\u0000¢\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u0015\u0010C\u001a\u00020\u0005*\u00020%H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010D\u001a\u001c\u0010C\u001a\u00020\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010F\u001a\u0015\u0010C\u001a\u00020\b*\u00020/H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010G\u001a\u001c\u0010C\u001a\u00020\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0087\bø\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\b*\u00020/H\u0087\bø\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000\u001a\f\u0010J\u001a\u000208*\u000208H\u0007\u001a\f\u0010J\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010K\u001a\u000208*\u0002082\u0006\u0010K\u001a\u00020LH\u0087\u0004\u001a\u0015\u0010K\u001a\u00020>*\u00020>2\u0006\u0010K\u001a\u00020MH\u0087\u0004\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a\u001f\u0010N\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001f\u0010N\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006W"}, d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes3.dex */
public class y {
    @h.g2.f
    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    private static final int A(t tVar) {
        return B(tVar, Random.Default);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final int B(@k.e.a.d t tVar, @k.e.a.d Random random) {
        try {
            return h.n2.e.h(random, tVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @h.g2.f
    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    private static final long C(w wVar) {
        return D(wVar, Random.Default);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final long D(@k.e.a.d w wVar, @k.e.a.d Random random) {
        try {
            return h.n2.e.l(random, wVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @h.g2.f
    @x1(markerClass = {h.o.class, h.p.class})
    @s0(version = "1.5")
    private static final f1 E(t tVar) {
        return F(tVar, Random.Default);
    }

    @x1(markerClass = {h.o.class, h.p.class})
    @k.e.a.e
    @s0(version = "1.5")
    public static final f1 F(@k.e.a.d t tVar, @k.e.a.d Random random) {
        if (tVar.isEmpty()) {
            return null;
        }
        return f1.b(h.n2.e.h(random, tVar));
    }

    @h.g2.f
    @x1(markerClass = {h.o.class, h.p.class})
    @s0(version = "1.5")
    private static final j1 G(w wVar) {
        return H(wVar, Random.Default);
    }

    @x1(markerClass = {h.o.class, h.p.class})
    @k.e.a.e
    @s0(version = "1.5")
    public static final j1 H(@k.e.a.d w wVar, @k.e.a.d Random random) {
        if (wVar.isEmpty()) {
            return null;
        }
        return j1.b(h.n2.e.l(random, wVar));
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final r I(@k.e.a.d r rVar) {
        return r.f14977d.a(rVar.f(), rVar.d(), -rVar.g());
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final u J(@k.e.a.d u uVar) {
        return u.f14983d.a(uVar.f(), uVar.d(), -uVar.g());
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final r K(@k.e.a.d r rVar, int i2) {
        p.a(i2 > 0, Integer.valueOf(i2));
        r.a aVar = r.f14977d;
        int d2 = rVar.d();
        int f2 = rVar.f();
        if (rVar.g() <= 0) {
            i2 = -i2;
        }
        return aVar.a(d2, f2, i2);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final u L(@k.e.a.d u uVar, long j2) {
        p.a(j2 > 0, Long.valueOf(j2));
        u.a aVar = u.f14983d;
        long d2 = uVar.d();
        long f2 = uVar.f();
        if (uVar.g() <= 0) {
            j2 = -j2;
        }
        return aVar.a(d2, f2, j2);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final t M(short s, short s2) {
        int i2 = s2 & 65535;
        return f0.t(i2, 0) <= 0 ? t.f14982f.a() : new t(f1.i(s & 65535), f1.i(f1.i(i2) - 1), null);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final t N(int i2, int i3) {
        return v1.c(i3, 0) <= 0 ? t.f14982f.a() : new t(i2, f1.i(i3 - 1), null);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final t O(byte b, byte b2) {
        int i2 = b2 & 255;
        return f0.t(i2, 0) <= 0 ? t.f14982f.a() : new t(f1.i(b & 255), f1.i(f1.i(i2) - 1), null);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final w P(long j2, long j3) {
        return v1.g(j3, 0L) <= 0 ? w.f14988f.a() : new w(j2, j1.i(j3 - j1.i(1 & 4294967295L)), null);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final short a(short s, short s2) {
        return f0.t(s & 65535, 65535 & s2) < 0 ? s2 : s;
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final int b(int i2, int i3) {
        return v1.c(i2, i3) < 0 ? i3 : i2;
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final byte c(byte b, byte b2) {
        return f0.t(b & 255, b2 & 255) < 0 ? b2 : b;
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final long d(long j2, long j3) {
        return v1.g(j2, j3) < 0 ? j3 : j2;
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final short e(short s, short s2) {
        return f0.t(s & 65535, 65535 & s2) > 0 ? s2 : s;
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final int f(int i2, int i3) {
        return v1.c(i2, i3) > 0 ? i3 : i2;
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final byte g(byte b, byte b2) {
        return f0.t(b & 255, b2 & 255) > 0 ? b2 : b;
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final long h(long j2, long j3) {
        return v1.g(j2, j3) > 0 ? j3 : j2;
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final long i(long j2, @k.e.a.d g<j1> gVar) {
        if (gVar instanceof f) {
            return ((j1) q.G(j1.b(j2), (f) gVar)).m0();
        }
        if (!gVar.isEmpty()) {
            return v1.g(j2, gVar.getStart().m0()) < 0 ? gVar.getStart().m0() : v1.g(j2, gVar.getEndInclusive().m0()) > 0 ? gVar.getEndInclusive().m0() : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final short j(short s, short s2, short s3) {
        int i2 = s2 & 65535;
        int i3 = s3 & 65535;
        if (f0.t(i2, i3) <= 0) {
            int i4 = 65535 & s;
            return f0.t(i4, i2) < 0 ? s2 : f0.t(i4, i3) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + p1.f0(s3) + " is less than minimum " + p1.f0(s2) + '.');
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final int k(int i2, int i3, int i4) {
        if (v1.c(i3, i4) <= 0) {
            return v1.c(i2, i3) < 0 ? i3 : v1.c(i2, i4) > 0 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f1.h0(i4) + " is less than minimum " + f1.h0(i3) + '.');
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final byte l(byte b, byte b2, byte b3) {
        int i2 = b2 & 255;
        int i3 = b3 & 255;
        if (f0.t(i2, i3) <= 0) {
            int i4 = b & 255;
            return f0.t(i4, i2) < 0 ? b2 : f0.t(i4, i3) > 0 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + b1.f0(b3) + " is less than minimum " + b1.f0(b2) + '.');
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final long m(long j2, long j3, long j4) {
        if (v1.g(j3, j4) <= 0) {
            return v1.g(j2, j3) < 0 ? j3 : v1.g(j2, j4) > 0 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j1.h0(j4) + " is less than minimum " + j1.h0(j3) + '.');
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final int n(int i2, @k.e.a.d g<f1> gVar) {
        if (gVar instanceof f) {
            return ((f1) q.G(f1.b(i2), (f) gVar)).m0();
        }
        if (!gVar.isEmpty()) {
            return v1.c(i2, gVar.getStart().m0()) < 0 ? gVar.getStart().m0() : v1.c(i2, gVar.getEndInclusive().m0()) > 0 ? gVar.getEndInclusive().m0() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final boolean o(@k.e.a.d t tVar, byte b) {
        return tVar.i(f1.i(b & 255));
    }

    @h.g2.f
    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    private static final boolean p(w wVar, j1 j1Var) {
        return j1Var != null && wVar.i(j1Var.m0());
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final boolean q(@k.e.a.d w wVar, int i2) {
        return wVar.i(j1.i(i2 & 4294967295L));
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final boolean r(@k.e.a.d w wVar, byte b) {
        return wVar.i(j1.i(b & 255));
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final boolean s(@k.e.a.d t tVar, short s) {
        return tVar.i(f1.i(s & 65535));
    }

    @h.g2.f
    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    private static final boolean t(t tVar, f1 f1Var) {
        return f1Var != null && tVar.i(f1Var.m0());
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final boolean u(@k.e.a.d t tVar, long j2) {
        return j1.i(j2 >>> 32) == 0 && tVar.i(f1.i((int) j2));
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    public static final boolean v(@k.e.a.d w wVar, short s) {
        return wVar.i(j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final r w(short s, short s2) {
        return r.f14977d.a(f1.i(s & 65535), f1.i(s2 & 65535), -1);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final r x(int i2, int i3) {
        return r.f14977d.a(i2, i3, -1);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final r y(byte b, byte b2) {
        return r.f14977d.a(f1.i(b & 255), f1.i(b2 & 255), -1);
    }

    @x1(markerClass = {h.p.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final u z(long j2, long j3) {
        return u.f14983d.a(j2, j3, -1L);
    }
}
