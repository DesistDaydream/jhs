package h.p2.b0.g.t.e.b;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class v {
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    public static final a f15337k = new a(null);
    @h.k2.d
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    public static final v f15338l;
    @h.k2.d
    @k.e.a.d

    /* renamed from: m  reason: collision with root package name */
    public static final v f15339m;
    @h.k2.d
    @k.e.a.d
    public static final v n;
    @h.k2.d
    @k.e.a.d
    public static final v o;
    @h.k2.d
    @k.e.a.d
    public static final v p;
    @h.k2.d
    @k.e.a.d
    public static final v q;
    @h.k2.d
    @k.e.a.d
    public static final v r;
    @h.k2.d
    @k.e.a.d
    public static final v s;
    @h.k2.d
    @k.e.a.d
    public static final v t;
    private final boolean a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15340c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15341d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15342e;
    @k.e.a.e

    /* renamed from: f  reason: collision with root package name */
    private final v f15343f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f15344g;
    @k.e.a.e

    /* renamed from: h  reason: collision with root package name */
    private final v f15345h;
    @k.e.a.e

    /* renamed from: i  reason: collision with root package name */
    private final v f15346i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f15347j;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            iArr[Variance.INVARIANT.ordinal()] = 2;
            a = iArr;
        }
    }

    static {
        v vVar = new v(false, false, false, false, false, null, false, null, null, false, 1023, null);
        f15338l = vVar;
        v vVar2 = new v(false, false, false, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION, null);
        f15339m = vVar2;
        n = new v(false, true, false, false, false, null, false, null, null, false, PointerIconCompat.TYPE_GRABBING, null);
        o = new v(false, false, false, false, false, vVar, false, null, null, false, 988, null);
        p = new v(false, false, false, false, false, vVar2, false, null, null, true, 476, null);
        q = new v(false, true, false, false, false, vVar, false, null, null, false, 988, null);
        r = new v(false, false, false, true, false, vVar, false, null, null, false, 983, null);
        s = new v(false, false, false, true, false, vVar, false, null, null, false, 919, null);
        t = new v(false, false, true, false, false, vVar, false, null, null, false, 984, null);
    }

    public v() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    public v(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @k.e.a.e v vVar, boolean z6, @k.e.a.e v vVar2, @k.e.a.e v vVar3, boolean z7) {
        this.a = z;
        this.b = z2;
        this.f15340c = z3;
        this.f15341d = z4;
        this.f15342e = z5;
        this.f15343f = vVar;
        this.f15344g = z6;
        this.f15345h = vVar2;
        this.f15346i = vVar3;
        this.f15347j = z7;
    }

    public final boolean a() {
        return this.f15344g;
    }

    public final boolean b() {
        return this.f15347j;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.f15340c;
    }

    @k.e.a.d
    public final v f(@k.e.a.d Variance variance, boolean z) {
        if (!z || !this.f15340c) {
            int i2 = b.a[variance.ordinal()];
            if (i2 == 1) {
                v vVar = this.f15345h;
                if (vVar != null) {
                    return vVar;
                }
            } else if (i2 != 2) {
                v vVar2 = this.f15343f;
                if (vVar2 != null) {
                    return vVar2;
                }
            } else {
                v vVar3 = this.f15346i;
                if (vVar3 != null) {
                    return vVar3;
                }
            }
        }
        return this;
    }

    @k.e.a.d
    public final v g() {
        return new v(this.a, true, this.f15340c, this.f15341d, this.f15342e, this.f15343f, this.f15344g, this.f15345h, this.f15346i, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ v(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, h.p2.b0.g.t.e.b.v r17, boolean r18, h.p2.b0.g.t.e.b.v r19, h.p2.b0.g.t.e.b.v r20, boolean r21, int r22, h.k2.v.u r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 1
            if (r1 == 0) goto L9
            r1 = 1
            goto La
        L9:
            r1 = r12
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = r13
        L11:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L18
            r4 = 0
            goto L19
        L18:
            r4 = r14
        L19:
            r6 = r0 & 8
            if (r6 == 0) goto L1f
            r6 = 0
            goto L20
        L1f:
            r6 = r15
        L20:
            r7 = r0 & 16
            if (r7 == 0) goto L26
            r7 = 0
            goto L28
        L26:
            r7 = r16
        L28:
            r8 = r0 & 32
            if (r8 == 0) goto L2e
            r8 = 0
            goto L30
        L2e:
            r8 = r17
        L30:
            r9 = r0 & 64
            if (r9 == 0) goto L35
            goto L37
        L35:
            r2 = r18
        L37:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L3d
            r9 = r8
            goto L3f
        L3d:
            r9 = r19
        L3f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L45
            r10 = r8
            goto L47
        L45:
            r10 = r20
        L47:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L4c
            goto L4e
        L4c:
            r5 = r21
        L4e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r2
            r20 = r9
            r21 = r10
            r22 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.e.b.v.<init>(boolean, boolean, boolean, boolean, boolean, h.p2.b0.g.t.e.b.v, boolean, h.p2.b0.g.t.e.b.v, h.p2.b0.g.t.e.b.v, boolean, int, h.k2.v.u):void");
    }
}
