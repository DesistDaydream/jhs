package h;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0010J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0013J\u001b\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0010J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0013J\u001b\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u0013J\u001b\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010\u001fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0010J\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0013J\u001b\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u0010J\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0013J\u001b\u0010H\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0010J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u0013J\u001b\u0010M\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\be\u0010\u0005J\u000f\u0010f\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bk\u0010UJ\u0016\u0010l\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bo\u0010cJ\u0016\u0010p\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bq\u0010\u0005J\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006u"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@h.k2.e
@s0(version = "1.5")
@x1(markerClass = {p.class})
/* loaded from: classes3.dex */
public final class p1 implements Comparable<p1> {
    public static final short b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final short f14989c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f14990d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f14991e = 16;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final a f14992f = new a(null);
    private final short a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", ExifInterface.LATITUDE_SOUTH, "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    @p0
    private /* synthetic */ p1(short s) {
        this.a = s;
    }

    @h.g2.f
    private static final int A(short s, int i2) {
        return f1.i(f1.i(s & 65535) - i2);
    }

    @h.g2.f
    private static final int B(short s, short s2) {
        return f1.i(f1.i(s & 65535) - f1.i(s2 & 65535));
    }

    @h.g2.f
    private static final byte C(short s, byte b2) {
        return b1.i((byte) v1.e(f1.i(s & 65535), f1.i(b2 & 255)));
    }

    @h.g2.f
    private static final long D(short s, long j2) {
        return v1.i(j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j2);
    }

    @h.g2.f
    private static final int E(short s, int i2) {
        return v1.e(f1.i(s & 65535), i2);
    }

    @h.g2.f
    private static final short F(short s, short s2) {
        return i((short) v1.e(f1.i(s & 65535), f1.i(s2 & 65535)));
    }

    @h.g2.f
    private static final short G(short s, short s2) {
        return i((short) (s | s2));
    }

    @h.g2.f
    private static final int M(short s, byte b2) {
        return f1.i(f1.i(s & 65535) + f1.i(b2 & 255));
    }

    @h.g2.f
    private static final long N(short s, long j2) {
        return j1.i(j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j2);
    }

    @h.g2.f
    private static final int O(short s, int i2) {
        return f1.i(f1.i(s & 65535) + i2);
    }

    @h.g2.f
    private static final int P(short s, short s2) {
        return f1.i(f1.i(s & 65535) + f1.i(s2 & 65535));
    }

    @h.g2.f
    private static final h.o2.t Q(short s, short s2) {
        return new h.o2.t(f1.i(s & 65535), f1.i(s2 & 65535), null);
    }

    @h.g2.f
    private static final int R(short s, byte b2) {
        return v1.e(f1.i(s & 65535), f1.i(b2 & 255));
    }

    @h.g2.f
    private static final long S(short s, long j2) {
        return v1.i(j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j2);
    }

    @h.g2.f
    private static final int T(short s, int i2) {
        return v1.e(f1.i(s & 65535), i2);
    }

    @h.g2.f
    private static final int U(short s, short s2) {
        return v1.e(f1.i(s & 65535), f1.i(s2 & 65535));
    }

    @h.g2.f
    private static final int V(short s, byte b2) {
        return f1.i(f1.i(s & 65535) * f1.i(b2 & 255));
    }

    @h.g2.f
    private static final long W(short s, long j2) {
        return j1.i(j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j2);
    }

    @h.g2.f
    private static final int X(short s, int i2) {
        return f1.i(f1.i(s & 65535) * i2);
    }

    @h.g2.f
    private static final int Y(short s, short s2) {
        return f1.i(f1.i(s & 65535) * f1.i(s2 & 65535));
    }

    @h.g2.f
    private static final byte Z(short s) {
        return (byte) s;
    }

    @h.g2.f
    private static final short a(short s, short s2) {
        return i((short) (s & s2));
    }

    @h.g2.f
    private static final double a0(short s) {
        return s & 65535;
    }

    public static final /* synthetic */ p1 b(short s) {
        return new p1(s);
    }

    @h.g2.f
    private static final float b0(short s) {
        return s & 65535;
    }

    @h.g2.f
    private static final int c0(short s) {
        return s & 65535;
    }

    @h.g2.f
    private static final int d(short s, byte b2) {
        return h.k2.v.f0.t(s & 65535, b2 & 255);
    }

    @h.g2.f
    private static final long d0(short s) {
        return s & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    @h.g2.f
    private static final int e(short s, long j2) {
        return v1.g(j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j2);
    }

    @h.g2.f
    private static final short e0(short s) {
        return s;
    }

    @h.g2.f
    private static final int f(short s, int i2) {
        return v1.c(f1.i(s & 65535), i2);
    }

    @k.e.a.d
    public static String f0(short s) {
        return String.valueOf(s & 65535);
    }

    @h.g2.f
    private int g(short s) {
        return h(this.a, s);
    }

    @h.g2.f
    private static final byte g0(short s) {
        return b1.i((byte) s);
    }

    @h.g2.f
    private static int h(short s, short s2) {
        return h.k2.v.f0.t(s & 65535, s2 & 65535);
    }

    @h.g2.f
    private static final int h0(short s) {
        return f1.i(s & 65535);
    }

    @p0
    public static short i(short s) {
        return s;
    }

    @h.g2.f
    private static final long i0(short s) {
        return j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    @h.g2.f
    private static final short j(short s) {
        return i((short) (s - 1));
    }

    @h.g2.f
    private static final short j0(short s) {
        return s;
    }

    @h.g2.f
    private static final int k(short s, byte b2) {
        return v1.d(f1.i(s & 65535), f1.i(b2 & 255));
    }

    @h.g2.f
    private static final long l(short s, long j2) {
        return v1.h(j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j2);
    }

    @h.g2.f
    private static final short l0(short s, short s2) {
        return i((short) (s ^ s2));
    }

    @h.g2.f
    private static final int m(short s, int i2) {
        return v1.d(f1.i(s & 65535), i2);
    }

    @h.g2.f
    private static final int n(short s, short s2) {
        return v1.d(f1.i(s & 65535), f1.i(s2 & 65535));
    }

    public static boolean o(short s, Object obj) {
        return (obj instanceof p1) && s == ((p1) obj).k0();
    }

    public static final boolean p(short s, short s2) {
        return s == s2;
    }

    @h.g2.f
    private static final int q(short s, byte b2) {
        return v1.d(f1.i(s & 65535), f1.i(b2 & 255));
    }

    @h.g2.f
    private static final long r(short s, long j2) {
        return v1.h(j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j2);
    }

    @h.g2.f
    private static final int s(short s, int i2) {
        return v1.d(f1.i(s & 65535), i2);
    }

    @h.g2.f
    private static final int t(short s, short s2) {
        return v1.d(f1.i(s & 65535), f1.i(s2 & 65535));
    }

    @p0
    public static /* synthetic */ void u() {
    }

    public static int v(short s) {
        return s;
    }

    @h.g2.f
    private static final short w(short s) {
        return i((short) (s + 1));
    }

    @h.g2.f
    private static final short x(short s) {
        return i((short) (~s));
    }

    @h.g2.f
    private static final int y(short s, byte b2) {
        return f1.i(f1.i(s & 65535) - f1.i(b2 & 255));
    }

    @h.g2.f
    private static final long z(short s, long j2) {
        return j1.i(j1.i(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(p1 p1Var) {
        return g(p1Var.k0());
    }

    public boolean equals(Object obj) {
        return o(this.a, obj);
    }

    public int hashCode() {
        return v(this.a);
    }

    public final /* synthetic */ short k0() {
        return this.a;
    }

    @k.e.a.d
    public String toString() {
        return f0(this.a);
    }
}
