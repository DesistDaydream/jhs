package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\b\u0000\u0018\u0000 0*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\u0017\u0013B\u0017\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0014¢\u0006\u0004\b.\u0010/J3\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010 \"\u0004\b\u0001\u0010\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0014¢\u0006\u0004\b#\u0010\u0016R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010$R\u0013\u0010'\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010\u0016R\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010(R\u0013\u0010,\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010$¨\u00061"}, d2 = {"Li/b/w3/v;", "", ExifInterface.LONGITUDE_EAST, "", "index", "element", "Lkotlinx/coroutines/internal/Core;", com.huawei.hms.push.e.a, "(ILjava/lang/Object;)Li/b/w3/v;", "oldHead", "newHead", "m", "(II)Li/b/w3/v;", "", "j", "()J", "state", "c", "(J)Li/b/w3/v;", "b", "", e.j.a.b.c.f.f10128d, "()Z", am.av, "(Ljava/lang/Object;)I", NotifyType.LIGHTS, "()Ljava/lang/Object;", "k", "()Li/b/w3/v;", "R", "Lkotlin/Function1;", "transform", "", "i", "(Lh/k2/u/l;)Ljava/util/List;", "g", ExpandableTextView.P, "capacity", "h", "isEmpty", "Z", "singleConsumer", "f", "()I", "size", "mask", "<init>", "(IZ)V", IAdInterListener.AdReqParam.WIDTH, "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class v<E> {

    /* renamed from: g  reason: collision with root package name */
    public static final int f15904g = 8;

    /* renamed from: h  reason: collision with root package name */
    public static final int f15905h = 30;

    /* renamed from: i  reason: collision with root package name */
    public static final int f15906i = 1073741823;

    /* renamed from: j  reason: collision with root package name */
    public static final int f15907j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final long f15908k = 1073741823;

    /* renamed from: l  reason: collision with root package name */
    public static final int f15909l = 30;

    /* renamed from: m  reason: collision with root package name */
    public static final long f15910m = 1152921503533105152L;
    public static final int n = 60;
    public static final long o = 1152921504606846976L;
    public static final int p = 61;
    public static final long q = 2305843009213693952L;
    public static final int r = 1024;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;
    private volatile Object _next = null;
    private volatile long _state = 0;
    private final int a;
    private AtomicReferenceArray b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15911c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15912d;
    public static final a w = new a(null);
    @h.k2.d
    @k.e.a.d
    public static final i0 s = new i0("REMOVE_FROZEN");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f15902e = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, "_next");

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f15903f = AtomicLongFieldUpdater.newUpdater(v.class, "_state");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010,J\u001c\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\tJR\u0010\u0013\u001a\u00028\u0001\"\u0004\b\u0001\u0010\f*\u00020\u000226\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00010\rH\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0006*\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0018R\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0016\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0018R\u0016\u0010$\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0016\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u0018R\u0016\u0010'\u001a\u00020&8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u001dR\u0016\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\u0018¨\u0006-"}, d2 = {"i/b/w3/v$a", "", "", "other", com.huawei.hms.push.e.a, "(JJ)J", "", "newHead", "b", "(JI)J", "newTail", "c", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lh/k0;", "name", "head", "tail", ReportItem.LogTypeBlock, e.j.a.b.c.f.f10128d, "(JLh/k2/u/p;)Ljava/lang/Object;", am.av, "(J)I", "ADD_CLOSED", ExpandableTextView.P, "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "J", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "Li/b/w3/i0;", "REMOVE_FROZEN", "Li/b/w3/i0;", "TAIL_MASK", "TAIL_SHIFT", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public final int a(long j2) {
            return (j2 & v.q) != 0 ? 2 : 1;
        }

        public final long b(long j2, int i2) {
            return e(j2, v.f15908k) | (i2 << 0);
        }

        public final long c(long j2, int i2) {
            return e(j2, v.f15910m) | (i2 << 30);
        }

        public final <T> T d(long j2, @k.e.a.d h.k2.u.p<? super Integer, ? super Integer, ? extends T> pVar) {
            return pVar.invoke(Integer.valueOf((int) ((v.f15908k & j2) >> 0)), Integer.valueOf((int) ((j2 & v.f15910m) >> 30)));
        }

        public final long e(long j2, long j3) {
            return j2 & (~j3);
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"i/b/w3/v$b", "", "", am.av, ExpandableTextView.P, "index", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b {
        @h.k2.d
        public final int a;

        public b(int i2) {
            this.a = i2;
        }
    }

    public v(int i2, boolean z) {
        this.f15911c = i2;
        this.f15912d = z;
        int i3 = i2 - 1;
        this.a = i3;
        this.b = new AtomicReferenceArray(i2);
        if (!(i3 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i2 & i3) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final v<E> b(long j2) {
        v<E> vVar = new v<>(this.f15911c * 2, this.f15912d);
        int i2 = (int) ((f15908k & j2) >> 0);
        int i3 = (int) ((f15910m & j2) >> 30);
        while (true) {
            int i4 = this.a;
            if ((i2 & i4) != (i3 & i4)) {
                Object obj = this.b.get(i4 & i2);
                if (obj == null) {
                    obj = new b(i2);
                }
                vVar.b.set(vVar.a & i2, obj);
                i2++;
            } else {
                vVar._state = w.e(j2, o);
                return vVar;
            }
        }
    }

    private final v<E> c(long j2) {
        while (true) {
            v<E> vVar = (v) this._next;
            if (vVar != null) {
                return vVar;
            }
            f15902e.compareAndSet(this, null, b(j2));
        }
    }

    private final v<E> e(int i2, E e2) {
        Object obj = this.b.get(this.a & i2);
        if ((obj instanceof b) && ((b) obj).a == i2) {
            this.b.set(i2 & this.a, e2);
            return this;
        }
        return null;
    }

    private final long j() {
        long j2;
        long j3;
        do {
            j2 = this._state;
            if ((j2 & o) != 0) {
                return j2;
            }
            j3 = j2 | o;
        } while (!f15903f.compareAndSet(this, j2, j3));
        return j3;
    }

    private final v<E> m(int i2, int i3) {
        long j2;
        a aVar;
        int i4;
        do {
            j2 = this._state;
            aVar = w;
            i4 = (int) ((f15908k & j2) >> 0);
            if (i.b.q0.b()) {
                if (!(i4 == i2)) {
                    throw new AssertionError();
                }
            }
            if ((o & j2) != 0) {
                return k();
            }
        } while (!f15903f.compareAndSet(this, j2, aVar.b(j2, i3)));
        this.b.set(this.a & i4, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(@k.e.a.d E r14) {
        /*
            r13 = this;
        L0:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            i.b.w3.v$a r14 = i.b.w3.v.w
            int r14 = r14.a(r2)
            return r14
        L12:
            i.b.w3.v$a r0 = i.b.w3.v.w
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r8 = 0
            long r4 = r4 >> r8
            int r1 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r9 = 30
            long r4 = r4 >> r9
            int r9 = (int) r4
            int r10 = r13.a
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r1 & r10
            r11 = 1
            if (r4 != r5) goto L30
            return r11
        L30:
            boolean r4 = r13.f15912d
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.b
            r12 = r9 & r10
            java.lang.Object r4 = r4.get(r12)
            if (r4 == 0) goto L4f
            int r0 = r13.f15911c
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4e:
            return r11
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = i.b.w3.v.f15903f
            long r11 = r0.c(r2, r1)
            r0 = r4
            r1 = r13
            r4 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.b
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
        L69:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L73
            goto L7e
        L73:
            i.b.w3.v r0 = r0.k()
            i.b.w3.v r0 = r0.e(r9, r14)
            if (r0 == 0) goto L7e
            goto L69
        L7e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.w3.v.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j2;
        do {
            j2 = this._state;
            if ((j2 & q) != 0) {
                return true;
            }
            if ((o & j2) != 0) {
                return false;
            }
        } while (!f15903f.compareAndSet(this, j2, j2 | q));
        return true;
    }

    public final int f() {
        long j2 = this._state;
        return 1073741823 & (((int) ((j2 & f15910m) >> 30)) - ((int) ((f15908k & j2) >> 0)));
    }

    public final boolean g() {
        return (this._state & q) != 0;
    }

    public final boolean h() {
        long j2 = this._state;
        return ((int) ((f15908k & j2) >> 0)) == ((int) ((j2 & f15910m) >> 30));
    }

    @k.e.a.d
    public final <R> List<R> i(@k.e.a.d h.k2.u.l<? super E, ? extends R> lVar) {
        ArrayList arrayList = new ArrayList(this.f15911c);
        long j2 = this._state;
        int i2 = (int) ((f15908k & j2) >> 0);
        int i3 = (int) ((j2 & f15910m) >> 30);
        while (true) {
            int i4 = this.a;
            if ((i2 & i4) == (i3 & i4)) {
                return arrayList;
            }
            Object obj = (Object) this.b.get(i4 & i2);
            if (obj != 0 && !(obj instanceof b)) {
                arrayList.add(lVar.invoke(obj));
            }
            i2++;
        }
    }

    @k.e.a.d
    public final v<E> k() {
        return c(j());
    }

    @k.e.a.e
    public final Object l() {
        while (true) {
            long j2 = this._state;
            if ((o & j2) != 0) {
                return s;
            }
            a aVar = w;
            int i2 = (int) ((f15908k & j2) >> 0);
            int i3 = (int) ((f15910m & j2) >> 30);
            int i4 = this.a;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            Object obj = this.b.get(i4 & i2);
            if (obj == null) {
                if (this.f15912d) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i5 = (i2 + 1) & f15906i;
                if (f15903f.compareAndSet(this, j2, aVar.b(j2, i5))) {
                    this.b.set(this.a & i2, null);
                    return obj;
                } else if (this.f15912d) {
                    v<E> vVar = this;
                    do {
                        vVar = vVar.m(i2, i5);
                    } while (vVar != null);
                    return obj;
                }
            }
        }
    }
}
