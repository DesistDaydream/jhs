package h;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001yB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u000fJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ\u001b\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u001dJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010\u0005J\u0016\u0010-\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010\u0005J\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u000fJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u000bJ\u001b\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u001dJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0016J\u001b\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u001dJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0016J\u001b\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bG\u0010\u000fJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bH\u0010\u000bJ\u001b\u0010F\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u001dJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0016J\u001e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bM\u0010\u000bJ\u001e\u0010N\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u000fJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u001dJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bT\u0010\u0016J\u0010\u0010U\u001a\u00020VH\u0087\b¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020ZH\u0087\b¢\u0006\u0004\b[\u0010\\J\u0010\u0010]\u001a\u00020^H\u0087\b¢\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020dH\u0087\b¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\u0087\b¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0016\u0010o\u001a\u00020\rH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bp\u0010XJ\u0016\u0010q\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010\u0005J\u0016\u0010s\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bt\u0010fJ\u0016\u0010u\u001a\u00020\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bv\u0010jJ\u001b\u0010w\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bx\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006z"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@h.k2.e
@s0(version = "1.5")
@x1(markerClass = {p.class})
/* loaded from: classes3.dex */
public final class f1 implements Comparable<f1> {
    public static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f14861c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f14862d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f14863e = 32;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final a f14864f = new a(null);
    private final int a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", ExpandableTextView.P, "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    @p0
    private /* synthetic */ f1(int i2) {
        this.a = i2;
    }

    @h.g2.f
    private static final int A(int i2, int i3) {
        return i(i2 - i3);
    }

    @h.g2.f
    private static final int B(int i2, short s) {
        return i(i2 - i(s & 65535));
    }

    @h.g2.f
    private static final byte C(int i2, byte b2) {
        return b1.i((byte) v1.e(i2, i(b2 & 255)));
    }

    @h.g2.f
    private static final long D(int i2, long j2) {
        return v1.i(j1.i(i2 & 4294967295L), j2);
    }

    @h.g2.f
    private static final int E(int i2, int i3) {
        return v1.e(i2, i3);
    }

    @h.g2.f
    private static final short F(int i2, short s) {
        return p1.i((short) v1.e(i2, i(s & 65535)));
    }

    @h.g2.f
    private static final int G(int i2, int i3) {
        return i(i2 | i3);
    }

    @h.g2.f
    private static final int M(int i2, byte b2) {
        return i(i2 + i(b2 & 255));
    }

    @h.g2.f
    private static final long N(int i2, long j2) {
        return j1.i(j1.i(i2 & 4294967295L) + j2);
    }

    @h.g2.f
    private static final int O(int i2, int i3) {
        return i(i2 + i3);
    }

    @h.g2.f
    private static final int P(int i2, short s) {
        return i(i2 + i(s & 65535));
    }

    @h.g2.f
    private static final h.o2.t Q(int i2, int i3) {
        return new h.o2.t(i2, i3, null);
    }

    @h.g2.f
    private static final int R(int i2, byte b2) {
        return v1.e(i2, i(b2 & 255));
    }

    @h.g2.f
    private static final long S(int i2, long j2) {
        return v1.i(j1.i(i2 & 4294967295L), j2);
    }

    @h.g2.f
    private static final int T(int i2, int i3) {
        return v1.e(i2, i3);
    }

    @h.g2.f
    private static final int U(int i2, short s) {
        return v1.e(i2, i(s & 65535));
    }

    @h.g2.f
    private static final int V(int i2, int i3) {
        return i(i2 << i3);
    }

    @h.g2.f
    private static final int W(int i2, int i3) {
        return i(i2 >>> i3);
    }

    @h.g2.f
    private static final int X(int i2, byte b2) {
        return i(i2 * i(b2 & 255));
    }

    @h.g2.f
    private static final long Y(int i2, long j2) {
        return j1.i(j1.i(i2 & 4294967295L) * j2);
    }

    @h.g2.f
    private static final int Z(int i2, int i3) {
        return i(i2 * i3);
    }

    @h.g2.f
    private static final int a(int i2, int i3) {
        return i(i2 & i3);
    }

    @h.g2.f
    private static final int a0(int i2, short s) {
        return i(i2 * i(s & 65535));
    }

    public static final /* synthetic */ f1 b(int i2) {
        return new f1(i2);
    }

    @h.g2.f
    private static final byte b0(int i2) {
        return (byte) i2;
    }

    @h.g2.f
    private static final double c0(int i2) {
        return v1.f(i2);
    }

    @h.g2.f
    private static final int d(int i2, byte b2) {
        return v1.c(i2, i(b2 & 255));
    }

    @h.g2.f
    private static final float d0(int i2) {
        return (float) v1.f(i2);
    }

    @h.g2.f
    private static final int e(int i2, long j2) {
        return v1.g(j1.i(i2 & 4294967295L), j2);
    }

    @h.g2.f
    private static final int e0(int i2) {
        return i2;
    }

    @h.g2.f
    private int f(int i2) {
        return g(this.a, i2);
    }

    @h.g2.f
    private static final long f0(int i2) {
        return i2 & 4294967295L;
    }

    @h.g2.f
    private static int g(int i2, int i3) {
        return v1.c(i2, i3);
    }

    @h.g2.f
    private static final short g0(int i2) {
        return (short) i2;
    }

    @h.g2.f
    private static final int h(int i2, short s) {
        return v1.c(i2, i(s & 65535));
    }

    @k.e.a.d
    public static String h0(int i2) {
        return String.valueOf(i2 & 4294967295L);
    }

    @p0
    public static int i(int i2) {
        return i2;
    }

    @h.g2.f
    private static final byte i0(int i2) {
        return b1.i((byte) i2);
    }

    @h.g2.f
    private static final int j(int i2) {
        return i(i2 - 1);
    }

    @h.g2.f
    private static final int j0(int i2) {
        return i2;
    }

    @h.g2.f
    private static final int k(int i2, byte b2) {
        return v1.d(i2, i(b2 & 255));
    }

    @h.g2.f
    private static final long k0(int i2) {
        return j1.i(i2 & 4294967295L);
    }

    @h.g2.f
    private static final long l(int i2, long j2) {
        return v1.h(j1.i(i2 & 4294967295L), j2);
    }

    @h.g2.f
    private static final short l0(int i2) {
        return p1.i((short) i2);
    }

    @h.g2.f
    private static final int m(int i2, int i3) {
        return v1.d(i2, i3);
    }

    @h.g2.f
    private static final int n(int i2, short s) {
        return v1.d(i2, i(s & 65535));
    }

    @h.g2.f
    private static final int n0(int i2, int i3) {
        return i(i2 ^ i3);
    }

    public static boolean o(int i2, Object obj) {
        return (obj instanceof f1) && i2 == ((f1) obj).m0();
    }

    public static final boolean p(int i2, int i3) {
        return i2 == i3;
    }

    @h.g2.f
    private static final int q(int i2, byte b2) {
        return v1.d(i2, i(b2 & 255));
    }

    @h.g2.f
    private static final long r(int i2, long j2) {
        return v1.h(j1.i(i2 & 4294967295L), j2);
    }

    @h.g2.f
    private static final int s(int i2, int i3) {
        return v1.d(i2, i3);
    }

    @h.g2.f
    private static final int t(int i2, short s) {
        return v1.d(i2, i(s & 65535));
    }

    @p0
    public static /* synthetic */ void u() {
    }

    public static int v(int i2) {
        return i2;
    }

    @h.g2.f
    private static final int w(int i2) {
        return i(i2 + 1);
    }

    @h.g2.f
    private static final int x(int i2) {
        return i(~i2);
    }

    @h.g2.f
    private static final int y(int i2, byte b2) {
        return i(i2 - i(b2 & 255));
    }

    @h.g2.f
    private static final long z(int i2, long j2) {
        return j1.i(j1.i(i2 & 4294967295L) - j2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(f1 f1Var) {
        return f(f1Var.m0());
    }

    public boolean equals(Object obj) {
        return o(this.a, obj);
    }

    public int hashCode() {
        return v(this.a);
    }

    public final /* synthetic */ int m0() {
        return this.a;
    }

    @k.e.a.d
    public String toString() {
        return h0(this.a);
    }
}
