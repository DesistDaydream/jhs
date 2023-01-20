package kotlinx.coroutines.scheduling;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.d;
import h.k2.v.f0;
import h.k2.v.u;
import h.o2.q;
import h.t1;
import i.b.l3;
import i.b.m3;
import i.b.q0;
import i.b.r0;
import i.b.w3.i0;
import i.b.y3.h;
import i.b.y3.i;
import i.b.y3.j;
import i.b.y3.k;
import i.b.y3.l;
import i.b.y3.n;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.random.Random;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u0003\\QdB+\u0012\u0006\u0010X\u001a\u00020\f\u0012\u0006\u0010I\u001a\u00020\f\u0012\b\b\u0002\u0010[\u001a\u00020\u000f\u0012\b\b\u0002\u0010V\u001a\u00020B¢\u0006\u0004\ba\u0010bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\bR\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\fH\u0082\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\fH\u0082\b¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u0082\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000fH\u0082\b¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\u001dJ\u000f\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010\u0015J+\u0010'\u001a\u0004\u0018\u00010\u0003*\b\u0018\u00010\bR\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b)\u0010\nJ+\u0010,\u001a\u00020\u00192\n\u0010\u000b\u001a\u00060\bR\u00020\u00002\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0000¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\bR\u00020\u0000H\u0000¢\u0006\u0004\b.\u0010/J\u0018\u00100\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\b¢\u0006\u0004\b0\u0010\u0012J\u001b\u00104\u001a\u00020\u00192\n\u00103\u001a\u000601j\u0002`2H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0019H\u0016¢\u0006\u0004\b6\u0010\u001bJ\u0015\u00108\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u000f¢\u0006\u0004\b8\u00109J-\u0010=\u001a\u00020\u00192\n\u0010:\u001a\u000601j\u0002`22\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010&\u001a\u00020\u0005¢\u0006\u0004\b=\u0010>J#\u0010?\u001a\u00020\u00032\n\u0010:\u001a\u000601j\u0002`22\u0006\u0010<\u001a\u00020;H\u0000¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0019H\u0000¢\u0006\u0004\bA\u0010\u001bJ\u000f\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0017\u0010K\u001a\u00020\f8Â\u0002@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0015R\"\u0010O\u001a\u000e\u0012\n\u0012\b\u0018\u00010\bR\u00020\u00000L8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020B8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u0010HR\u0016\u0010[\u001a\u00020\u000f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020P8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\\\u0010RR\u0017\u0010_\u001a\u00020\f8Â\u0002@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\u0015R\u0013\u0010`\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b`\u0010\u001d¨\u0006e"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Li/b/y3/i;", "task", "", "k", "(Li/b/y3/i;)Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;", "m0", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;", "worker", "", "f0", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;)I", "", "state", "r", "(J)I", "n", "c0", "()I", "F", "Y", "()J", "Lh/t1;", am.aI, "()V", "E0", "()Z", "x0", "skipUnpark", "B0", "(Z)V", "F0", "(J)Z", "H0", "o", "tailDispatch", "D0", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;Li/b/y3/i;Z)Li/b/y3/i;", "s", "oldIndex", "newIndex", "u0", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;II)V", "o0", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$b;)Z", NotifyType.LIGHTS, "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", com.heytap.mcssdk.constant.b.y, "execute", "(Ljava/lang/Runnable;)V", "close", "timeout", "A0", "(J)V", ReportItem.LogTypeBlock, "Li/b/y3/j;", "taskContext", "H", "(Ljava/lang/Runnable;Li/b/y3/j;Z)V", "q", "(Ljava/lang/Runnable;Li/b/y3/j;)Li/b/y3/i;", "C0", "", "toString", "()Ljava/lang/String;", "z0", "(Li/b/y3/i;)V", e.a, ExpandableTextView.P, "maxPoolSize", "M", "availableCpuPermits", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "c", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Li/b/y3/e;", "b", "Li/b/y3/e;", "globalBlockingQueue", "g", "Ljava/lang/String;", "schedulerName", f.f10128d, "corePoolSize", "f", "J", "idleWorkerKeepAliveNs", am.av, "globalCpuQueue", "X", "createdWorkers", "isTerminated", "<init>", "(IIJLjava/lang/String;)V", "y", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: l  reason: collision with root package name */
    private static final int f16989l = -1;

    /* renamed from: m  reason: collision with root package name */
    private static final int f16990m = 0;
    private static final int n = 1;
    private static final int o = 21;
    private static final long p = 2097151;
    private static final long q = 4398044413952L;
    private static final int r = 42;
    private static final long s = 9223367638808264704L;
    public static final int t = 1;
    public static final int u = 2097150;
    private static final long v = 2097151;
    private static final long w = -2097152;
    private static final long x = 2097152;
    private volatile int _isTerminated;
    @d
    @k.e.a.d
    public final i.b.y3.e a;
    @d
    @k.e.a.d
    public final i.b.y3.e b;
    @d
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReferenceArray<b> f16991c;
    public volatile long controlState;
    @d

    /* renamed from: d  reason: collision with root package name */
    public final int f16992d;
    @d

    /* renamed from: e  reason: collision with root package name */
    public final int f16993e;
    @d

    /* renamed from: f  reason: collision with root package name */
    public final long f16994f;
    @d
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    public final String f16995g;
    private volatile long parkedWorkersStack;
    public static final a y = new a(null);
    @d
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    public static final i0 f16988k = new i0("NOT_IN_STACK");

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f16985h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f16986i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f16987j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00058\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00058\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"kotlinx/coroutines/scheduling/CoroutineScheduler$a", "", "", "BLOCKING_MASK", "J", "", "BLOCKING_SHIFT", ExpandableTextView.P, "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "Li/b/w3/i0;", "NOT_IN_STACK", "Li/b/w3/i0;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public CoroutineScheduler(int i2, int i3, long j2, @k.e.a.d String str) {
        this.f16992d = i2;
        this.f16993e = i3;
        this.f16994f = j2;
        this.f16995g = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 > 0) {
            this.a = new i.b.y3.e();
            this.b = new i.b.y3.e();
            this.parkedWorkersStack = 0L;
            this.f16991c = new AtomicReferenceArray<>(i3 + 1);
            this.controlState = i2 << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
    }

    private final void B0(boolean z) {
        long addAndGet = f16986i.addAndGet(this, 2097152L);
        if (z || H0() || F0(addAndGet)) {
            return;
        }
        H0();
    }

    private final i D0(b bVar, i iVar, boolean z) {
        if (bVar == null || bVar.b == WorkerState.TERMINATED) {
            return iVar;
        }
        if (iVar.b.f0() == 0 && bVar.b == WorkerState.BLOCKING) {
            return iVar;
        }
        bVar.f17000f = true;
        return bVar.a.a(iVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E0() {
        long j2;
        do {
            j2 = this.controlState;
            if (((int) ((s & j2) >> 42)) == 0) {
                return false;
            }
        } while (!f16986i.compareAndSet(this, j2, j2 - 4398046511104L));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int F() {
        return (int) (f16986i.getAndDecrement(this) & 2097151);
    }

    private final boolean F0(long j2) {
        if (q.n(((int) (2097151 & j2)) - ((int) ((j2 & q) >> 21)), 0) < this.f16992d) {
            int o2 = o();
            if (o2 == 1 && this.f16992d > 1) {
                o();
            }
            if (o2 > 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean G0(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.F0(j2);
    }

    private final boolean H0() {
        b m0;
        do {
            m0 = m0();
            if (m0 == null) {
                return false;
            }
        } while (!b.f16996h.compareAndSet(m0, -1, 0));
        LockSupport.unpark(m0);
        return true;
    }

    public static /* synthetic */ void J(CoroutineScheduler coroutineScheduler, Runnable runnable, j jVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            jVar = h.b;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.H(runnable, jVar, z);
    }

    private final int M() {
        return (int) ((this.controlState & s) >> 42);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int X() {
        return (int) (this.controlState & 2097151);
    }

    private final long Y() {
        return f16986i.addAndGet(this, 2097152L);
    }

    private final int c0() {
        return (int) (f16986i.incrementAndGet(this) & 2097151);
    }

    private final int f0(b bVar) {
        Object g2 = bVar.g();
        while (g2 != f16988k) {
            if (g2 == null) {
                return 0;
            }
            b bVar2 = (b) g2;
            int f2 = bVar2.f();
            if (f2 != 0) {
                return f2;
            }
            g2 = bVar2.g();
        }
        return -1;
    }

    private final boolean k(i iVar) {
        if (iVar.b.f0() == 1) {
            return this.b.a(iVar);
        }
        return this.a.a(iVar);
    }

    private final b m0() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            b bVar = this.f16991c.get((int) (2097151 & j2));
            if (bVar == null) {
                return null;
            }
            long j3 = (2097152 + j2) & w;
            int f0 = f0(bVar);
            if (f0 >= 0 && f16985h.compareAndSet(this, j2, f0 | j3)) {
                bVar.p(f16988k);
                return bVar;
            }
        }
    }

    private final int n(long j2) {
        return (int) ((j2 & q) >> 21);
    }

    private final int o() {
        synchronized (this.f16991c) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int n2 = q.n(i2 - ((int) ((j2 & q) >> 21)), 0);
            if (n2 >= this.f16992d) {
                return 0;
            }
            if (i2 >= this.f16993e) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 > 0 && this.f16991c.get(i3) == null) {
                b bVar = new b(this, i3);
                this.f16991c.set(i3, bVar);
                if (i3 == ((int) (2097151 & f16986i.incrementAndGet(this)))) {
                    bVar.start();
                    return n2 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int r(long j2) {
        return (int) (j2 & 2097151);
    }

    private final b s() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof b)) {
            currentThread = null;
        }
        b bVar = (b) currentThread;
        if (bVar == null || !f0.g(CoroutineScheduler.this, this)) {
            return null;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        f16986i.addAndGet(this, w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long x0() {
        return f16986i.addAndGet(this, 4398046511104L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        if (r9 != null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.f16987j
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r0 = r8.s()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r3 = r8.f16991c
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lb2
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L58
            r3 = 1
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r4 = r8.f16991c
            java.lang.Object r4 = r4.get(r3)
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.b) r4
            if (r4 == r0) goto L53
        L27:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L34
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r9)
            goto L27
        L34:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r4.b
            boolean r7 = i.b.q0.b()
            if (r7 == 0) goto L4c
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L42
            r6 = 1
            goto L43
        L42:
            r6 = 0
        L43:
            if (r6 == 0) goto L46
            goto L4c
        L46:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L4c:
            i.b.y3.n r4 = r4.a
            i.b.y3.e r6 = r8.b
            r4.g(r6)
        L53:
            if (r3 == r5) goto L58
            int r3 = r3 + 1
            goto L1d
        L58:
            i.b.y3.e r9 = r8.b
            r9.b()
            i.b.y3.e r9 = r8.a
            r9.b()
        L62:
            if (r0 == 0) goto L6b
            i.b.y3.i r9 = r0.e(r2)
            if (r9 == 0) goto L6b
            goto L73
        L6b:
            i.b.y3.e r9 = r8.a
            java.lang.Object r9 = r9.g()
            i.b.y3.i r9 = (i.b.y3.i) r9
        L73:
            if (r9 == 0) goto L76
            goto L7e
        L76:
            i.b.y3.e r9 = r8.b
            java.lang.Object r9 = r9.g()
            i.b.y3.i r9 = (i.b.y3.i) r9
        L7e:
            if (r9 == 0) goto L84
            r8.z0(r9)
            goto L62
        L84:
            if (r0 == 0) goto L8b
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.s(r9)
        L8b:
            boolean r9 = i.b.q0.b()
            if (r9 == 0) goto Lab
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r10 = (int) r9
            int r9 = r8.f16992d
            if (r10 != r9) goto La2
            r1 = 1
        La2:
            if (r1 == 0) goto La5
            goto Lab
        La5:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        Lab:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        Lb2:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.A0(long):void");
    }

    public final void C0() {
        if (H0() || G0(this, 0L, 1, null)) {
            return;
        }
        H0();
    }

    public final void H(@k.e.a.d Runnable runnable, @k.e.a.d j jVar, boolean z) {
        l3 b2 = m3.b();
        if (b2 != null) {
            b2.f();
        }
        i q2 = q(runnable, jVar);
        b s2 = s();
        i D0 = D0(s2, q2, z);
        if (D0 != null && !k(D0)) {
            throw new RejectedExecutionException(this.f16995g + " was terminated");
        }
        boolean z2 = z && s2 != null;
        if (q2.b.f0() != 0) {
            B0(z2);
        } else if (z2) {
        } else {
            C0();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        A0(com.heytap.mcssdk.constant.a.q);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@k.e.a.d Runnable runnable) {
        J(this, runnable, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final int l(long j2) {
        return (int) ((j2 & s) >> 42);
    }

    public final boolean o0(@k.e.a.d b bVar) {
        long j2;
        long j3;
        int f2;
        if (bVar.g() != f16988k) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (2097152 + j2) & w;
            f2 = bVar.f();
            if (q0.b()) {
                if (!(f2 != 0)) {
                    throw new AssertionError();
                }
            }
            bVar.p(this.f16991c.get(i2));
        } while (!f16985h.compareAndSet(this, j2, f2 | j3));
        return true;
    }

    @k.e.a.d
    public final i q(@k.e.a.d Runnable runnable, @k.e.a.d j jVar) {
        long a2 = l.f15933h.a();
        if (runnable instanceof i) {
            i iVar = (i) runnable;
            iVar.a = a2;
            iVar.b = jVar;
            return iVar;
        }
        return new k(runnable, a2, jVar);
    }

    @k.e.a.d
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.f16991c.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < length; i7++) {
            b bVar = this.f16991c.get(i7);
            if (bVar != null) {
                int f2 = bVar.a.f();
                int i8 = i.b.y3.a.a[bVar.b.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    arrayList.add(String.valueOf(f2) + "b");
                } else if (i8 == 3) {
                    i2++;
                    arrayList.add(String.valueOf(f2) + "c");
                } else if (i8 == 4) {
                    i5++;
                    if (f2 > 0) {
                        arrayList.add(String.valueOf(f2) + f.f10128d);
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return this.f16995g + '@' + r0.b(this) + "[Pool Size {core = " + this.f16992d + ", max = " + this.f16993e + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.a.c() + ", global blocking queue size = " + this.b.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((q & j2) >> 21)) + ", CPUs acquired = " + (this.f16992d - ((int) ((s & j2) >> 42))) + "}]";
    }

    public final void u0(@k.e.a.d b bVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & w;
            if (i4 == i2) {
                i4 = i3 == 0 ? f0(bVar) : i3;
            }
            if (i4 >= 0 && f16985h.compareAndSet(this, j2, j3 | i4)) {
                return;
            }
        }
    }

    public final void z0(@k.e.a.d i iVar) {
        try {
            iVar.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                l3 b2 = m3.b();
                if (b2 == null) {
                }
            } finally {
                l3 b3 = m3.b();
                if (b3 != null) {
                    b3.b();
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bD\u0010EB\u0011\b\u0016\u0012\u0006\u00104\u001a\u00020\u000e¢\u0006\u0004\bD\u0010FJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0007J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0019R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010/R\u0016\u00103\u001a\u0002018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u00102R*\u00105\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u0011R\u0016\u0010;\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010:R\u0016\u0010<\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010/R\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00106R\u0014\u0010A\u001a\u00020>8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b7\u0010B¨\u0006G"}, d2 = {"kotlinx/coroutines/scheduling/CoroutineScheduler$b", "Ljava/lang/Thread;", "", "q", "()Z", "Lh/t1;", "n", "()V", "r", "j", "Li/b/y3/i;", "task", "c", "(Li/b/y3/i;)V", "", "taskMode", "b", "(I)V", am.av, NotifyType.LIGHTS, am.aH, "mode", "i", "scanLocalQueue", f.f10128d, "(Z)Li/b/y3/i;", "m", "()Li/b/y3/i;", "blockingOnly", am.aI, "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "s", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "upperBound", "k", "(I)I", e.a, "", "nextParkedWorker", "Ljava/lang/Object;", "g", "()Ljava/lang/Object;", am.ax, "(Ljava/lang/Object;)V", "", "J", "minDelayUntilStealableTaskNs", "Li/b/y3/n;", "Li/b/y3/n;", "localQueue", "index", "indexInArray", ExpandableTextView.P, "f", "()I", "o", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "state", "terminationDeadline", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "h", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "Z", "mayHaveLocalTasks", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class b extends Thread {

        /* renamed from: h  reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f16996h = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
        @d
        @k.e.a.d
        public final n a;
        @d
        @k.e.a.d
        public WorkerState b;

        /* renamed from: c  reason: collision with root package name */
        private long f16997c;

        /* renamed from: d  reason: collision with root package name */
        private long f16998d;

        /* renamed from: e  reason: collision with root package name */
        private int f16999e;
        @d

        /* renamed from: f  reason: collision with root package name */
        public boolean f17000f;
        private volatile int indexInArray;
        @k.e.a.e
        private volatile Object nextParkedWorker;
        @k.e.a.d
        public volatile int workerCtl;

        private b() {
            setDaemon(true);
            this.a = new n();
            this.b = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f16988k;
            this.f16999e = Random.Default.nextInt();
        }

        private final void a(int i2) {
            if (i2 == 0) {
                return;
            }
            CoroutineScheduler.f16986i.addAndGet(CoroutineScheduler.this, CoroutineScheduler.w);
            WorkerState workerState = this.b;
            if (workerState != WorkerState.TERMINATED) {
                if (q0.b()) {
                    if (!(workerState == WorkerState.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.b = WorkerState.DORMANT;
            }
        }

        private final void b(int i2) {
            if (i2 != 0 && s(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.C0();
            }
        }

        private final void c(i iVar) {
            int f0 = iVar.b.f0();
            i(f0);
            b(f0);
            CoroutineScheduler.this.z0(iVar);
            a(f0);
        }

        private final i d(boolean z) {
            i m2;
            i m3;
            if (z) {
                boolean z2 = k(CoroutineScheduler.this.f16992d * 2) == 0;
                if (z2 && (m3 = m()) != null) {
                    return m3;
                }
                i h2 = this.a.h();
                if (h2 != null) {
                    return h2;
                }
                if (!z2 && (m2 = m()) != null) {
                    return m2;
                }
            } else {
                i m4 = m();
                if (m4 != null) {
                    return m4;
                }
            }
            return t(false);
        }

        private final void i(int i2) {
            this.f16997c = 0L;
            if (this.b == WorkerState.PARKING) {
                if (q0.b()) {
                    if (!(i2 == 1)) {
                        throw new AssertionError();
                    }
                }
                this.b = WorkerState.BLOCKING;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != CoroutineScheduler.f16988k;
        }

        private final void l() {
            if (this.f16997c == 0) {
                this.f16997c = System.nanoTime() + CoroutineScheduler.this.f16994f;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f16994f);
            if (System.nanoTime() - this.f16997c >= 0) {
                this.f16997c = 0L;
                u();
            }
        }

        private final i m() {
            if (k(2) == 0) {
                i g2 = CoroutineScheduler.this.a.g();
                return g2 != null ? g2 : CoroutineScheduler.this.b.g();
            }
            i g3 = CoroutineScheduler.this.b.g();
            return g3 != null ? g3 : CoroutineScheduler.this.a.g();
        }

        private final void n() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.b != WorkerState.TERMINATED) {
                    i e2 = e(this.f17000f);
                    if (e2 != null) {
                        this.f16998d = 0L;
                        c(e2);
                    } else {
                        this.f17000f = false;
                        if (this.f16998d == 0) {
                            r();
                        } else if (z) {
                            s(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f16998d);
                            this.f16998d = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            s(WorkerState.TERMINATED);
        }

        private final boolean q() {
            boolean z;
            if (this.b != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j2 = coroutineScheduler.controlState;
                    if (((int) ((CoroutineScheduler.s & j2) >> 42)) != 0) {
                        if (CoroutineScheduler.f16986i.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.b = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void r() {
            if (!j()) {
                CoroutineScheduler.this.o0(this);
                return;
            }
            if (q0.b()) {
                if (!(this.a.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (j() && !CoroutineScheduler.this.isTerminated() && this.b != WorkerState.TERMINATED) {
                s(WorkerState.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final i t(boolean z) {
            long l2;
            if (q0.b()) {
                if (!(this.a.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int X = CoroutineScheduler.this.X();
            if (X < 2) {
                return null;
            }
            int k2 = k(X);
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < X; i2++) {
                k2++;
                if (k2 > X) {
                    k2 = 1;
                }
                b bVar = CoroutineScheduler.this.f16991c.get(k2);
                if (bVar != null && bVar != this) {
                    if (q0.b()) {
                        if (!(this.a.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        l2 = this.a.k(bVar.a);
                    } else {
                        l2 = this.a.l(bVar.a);
                    }
                    if (l2 == -1) {
                        return this.a.h();
                    }
                    if (l2 > 0) {
                        j2 = Math.min(j2, l2);
                    }
                }
            }
            if (j2 == Long.MAX_VALUE) {
                j2 = 0;
            }
            this.f16998d = j2;
            return null;
        }

        private final void u() {
            synchronized (CoroutineScheduler.this.f16991c) {
                if (CoroutineScheduler.this.isTerminated()) {
                    return;
                }
                if (CoroutineScheduler.this.X() <= CoroutineScheduler.this.f16992d) {
                    return;
                }
                if (f16996h.compareAndSet(this, -1, 1)) {
                    int i2 = this.indexInArray;
                    o(0);
                    CoroutineScheduler.this.u0(this, i2, 0);
                    int andDecrement = (int) (CoroutineScheduler.f16986i.getAndDecrement(CoroutineScheduler.this) & 2097151);
                    if (andDecrement != i2) {
                        b bVar = CoroutineScheduler.this.f16991c.get(andDecrement);
                        CoroutineScheduler.this.f16991c.set(i2, bVar);
                        bVar.o(i2);
                        CoroutineScheduler.this.u0(bVar, andDecrement, i2);
                    }
                    CoroutineScheduler.this.f16991c.set(andDecrement, null);
                    t1 t1Var = t1.a;
                    this.b = WorkerState.TERMINATED;
                }
            }
        }

        @k.e.a.e
        public final i e(boolean z) {
            i g2;
            if (q()) {
                return d(z);
            }
            if (z) {
                g2 = this.a.h();
                if (g2 == null) {
                    g2 = CoroutineScheduler.this.b.g();
                }
            } else {
                g2 = CoroutineScheduler.this.b.g();
            }
            return g2 != null ? g2 : t(true);
        }

        public final int f() {
            return this.indexInArray;
        }

        @k.e.a.e
        public final Object g() {
            return this.nextParkedWorker;
        }

        @k.e.a.d
        public final CoroutineScheduler h() {
            return CoroutineScheduler.this;
        }

        public final int k(int i2) {
            int i3 = this.f16999e;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f16999e = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
        }

        public final void o(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f16995g);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void p(@k.e.a.e Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(@k.e.a.d WorkerState workerState) {
            WorkerState workerState2 = this.b;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.f16986i.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.b = workerState;
            }
            return z;
        }

        public b(CoroutineScheduler coroutineScheduler, int i2) {
            this();
            o(i2);
        }
    }

    public /* synthetic */ CoroutineScheduler(int i2, int i3, long j2, String str, int i4, u uVar) {
        this(i2, i3, (i4 & 4) != 0 ? l.f15932g : j2, (i4 & 8) != 0 ? l.b : str);
    }
}
