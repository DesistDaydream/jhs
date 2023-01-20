package h;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u001dJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000bJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bO\u0010\"J\u001e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010\u001fJ\u001e\u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bV\u0010\u001dJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bW\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bX\u0010\u000bJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bY\u0010\"J\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020_H\u0087\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\rH\u0087\b¢\u0006\u0004\bg\u0010/J\u0010\u0010h\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bi\u0010\u0005J\u0010\u0010j\u001a\u00020kH\u0087\b¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020oH\u0016¢\u0006\u0004\bp\u0010qJ\u0016\u0010r\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bs\u0010]J\u0016\u0010t\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010/J\u0016\u0010v\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010\u0005J\u0016\u0010x\u001a\u00020\u0016H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\by\u0010mJ\u001b\u0010z\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b{\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006}"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@h.k2.e
@s0(version = "1.5")
@x1(markerClass = {p.class})
/* loaded from: classes3.dex */
public final class j1 implements Comparable<j1> {
    public static final long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final long f14896c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f14897d = 8;

    /* renamed from: e  reason: collision with root package name */
    public static final int f14898e = 64;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final a f14899f = new a(null);
    private final long a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    @p0
    private /* synthetic */ j1(long j2) {
        this.a = j2;
    }

    @h.g2.f
    private static final long A(long j2, int i2) {
        return i(j2 - i(i2 & 4294967295L));
    }

    @h.g2.f
    private static final long B(long j2, short s) {
        return i(j2 - i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @h.g2.f
    private static final byte C(long j2, byte b2) {
        return b1.i((byte) v1.i(j2, i(b2 & 255)));
    }

    @h.g2.f
    private static final long D(long j2, long j3) {
        return v1.i(j2, j3);
    }

    @h.g2.f
    private static final int E(long j2, int i2) {
        return f1.i((int) v1.i(j2, i(i2 & 4294967295L)));
    }

    @h.g2.f
    private static final short F(long j2, short s) {
        return p1.i((short) v1.i(j2, i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    @h.g2.f
    private static final long G(long j2, long j3) {
        return i(j2 | j3);
    }

    @h.g2.f
    private static final long M(long j2, byte b2) {
        return i(j2 + i(b2 & 255));
    }

    @h.g2.f
    private static final long N(long j2, long j3) {
        return i(j2 + j3);
    }

    @h.g2.f
    private static final long O(long j2, int i2) {
        return i(j2 + i(i2 & 4294967295L));
    }

    @h.g2.f
    private static final long P(long j2, short s) {
        return i(j2 + i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @h.g2.f
    private static final h.o2.w Q(long j2, long j3) {
        return new h.o2.w(j2, j3, null);
    }

    @h.g2.f
    private static final long R(long j2, byte b2) {
        return v1.i(j2, i(b2 & 255));
    }

    @h.g2.f
    private static final long S(long j2, long j3) {
        return v1.i(j2, j3);
    }

    @h.g2.f
    private static final long T(long j2, int i2) {
        return v1.i(j2, i(i2 & 4294967295L));
    }

    @h.g2.f
    private static final long U(long j2, short s) {
        return v1.i(j2, i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @h.g2.f
    private static final long V(long j2, int i2) {
        return i(j2 << i2);
    }

    @h.g2.f
    private static final long W(long j2, int i2) {
        return i(j2 >>> i2);
    }

    @h.g2.f
    private static final long X(long j2, byte b2) {
        return i(j2 * i(b2 & 255));
    }

    @h.g2.f
    private static final long Y(long j2, long j3) {
        return i(j2 * j3);
    }

    @h.g2.f
    private static final long Z(long j2, int i2) {
        return i(j2 * i(i2 & 4294967295L));
    }

    @h.g2.f
    private static final long a(long j2, long j3) {
        return i(j2 & j3);
    }

    @h.g2.f
    private static final long a0(long j2, short s) {
        return i(j2 * i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    public static final /* synthetic */ j1 b(long j2) {
        return new j1(j2);
    }

    @h.g2.f
    private static final byte b0(long j2) {
        return (byte) j2;
    }

    @h.g2.f
    private static final double c0(long j2) {
        return v1.j(j2);
    }

    @h.g2.f
    private static final int d(long j2, byte b2) {
        return v1.g(j2, i(b2 & 255));
    }

    @h.g2.f
    private static final float d0(long j2) {
        return (float) v1.j(j2);
    }

    @h.g2.f
    private int e(long j2) {
        return f(this.a, j2);
    }

    @h.g2.f
    private static final int e0(long j2) {
        return (int) j2;
    }

    @h.g2.f
    private static int f(long j2, long j3) {
        return v1.g(j2, j3);
    }

    @h.g2.f
    private static final long f0(long j2) {
        return j2;
    }

    @h.g2.f
    private static final int g(long j2, int i2) {
        return v1.g(j2, i(i2 & 4294967295L));
    }

    @h.g2.f
    private static final short g0(long j2) {
        return (short) j2;
    }

    @h.g2.f
    private static final int h(long j2, short s) {
        return v1.g(j2, i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @k.e.a.d
    public static String h0(long j2) {
        return v1.k(j2);
    }

    @p0
    public static long i(long j2) {
        return j2;
    }

    @h.g2.f
    private static final byte i0(long j2) {
        return b1.i((byte) j2);
    }

    @h.g2.f
    private static final long j(long j2) {
        return i(j2 - 1);
    }

    @h.g2.f
    private static final int j0(long j2) {
        return f1.i((int) j2);
    }

    @h.g2.f
    private static final long k(long j2, byte b2) {
        return v1.h(j2, i(b2 & 255));
    }

    @h.g2.f
    private static final long k0(long j2) {
        return j2;
    }

    @h.g2.f
    private static final long l(long j2, long j3) {
        return v1.h(j2, j3);
    }

    @h.g2.f
    private static final short l0(long j2) {
        return p1.i((short) j2);
    }

    @h.g2.f
    private static final long m(long j2, int i2) {
        return v1.h(j2, i(i2 & 4294967295L));
    }

    @h.g2.f
    private static final long n(long j2, short s) {
        return v1.h(j2, i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @h.g2.f
    private static final long n0(long j2, long j3) {
        return i(j2 ^ j3);
    }

    public static boolean o(long j2, Object obj) {
        return (obj instanceof j1) && j2 == ((j1) obj).m0();
    }

    public static final boolean p(long j2, long j3) {
        return j2 == j3;
    }

    @h.g2.f
    private static final long q(long j2, byte b2) {
        return v1.h(j2, i(b2 & 255));
    }

    @h.g2.f
    private static final long r(long j2, long j3) {
        return v1.h(j2, j3);
    }

    @h.g2.f
    private static final long s(long j2, int i2) {
        return v1.h(j2, i(i2 & 4294967295L));
    }

    @h.g2.f
    private static final long t(long j2, short s) {
        return v1.h(j2, i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @p0
    public static /* synthetic */ void u() {
    }

    public static int v(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    @h.g2.f
    private static final long w(long j2) {
        return i(j2 + 1);
    }

    @h.g2.f
    private static final long x(long j2) {
        return i(~j2);
    }

    @h.g2.f
    private static final long y(long j2, byte b2) {
        return i(j2 - i(b2 & 255));
    }

    @h.g2.f
    private static final long z(long j2, long j3) {
        return i(j2 - j3);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(j1 j1Var) {
        return e(j1Var.m0());
    }

    public boolean equals(Object obj) {
        return o(this.a, obj);
    }

    public int hashCode() {
        return v(this.a);
    }

    public final /* synthetic */ long m0() {
        return this.a;
    }

    @k.e.a.d
    public String toString() {
        return h0(this.a);
    }
}
