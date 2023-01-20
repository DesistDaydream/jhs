package i.b;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b7\u0010\fJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0016\u0010\fJ\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00078@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \u0012\u0004\b!\u0010\fR\u0016\u0010#\u001a\u00020\u00078B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\tR\u0016\u0010%\u001a\u00020\u001a8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010'\u001a\u00020\u001a8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u001cR\u0016\u0010*\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020\u001a8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010\u001cR\u0016\u00100\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0006R\u0016\u00102\u001a\u00020\u001a8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010\u001cR\u0016\u00106\u001a\u0002038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"Li/b/s0;", "Li/b/j1;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Thread;", "d1", "()Ljava/lang/Thread;", "", "i1", "()Z", "Lh/t1;", "c1", "()V", "", "timeMillis", ReportItem.LogTypeBlock, "Lkotlin/coroutines/CoroutineContext;", "context", "Li/b/e1;", am.aI, "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Li/b/e1;", "run", "e1", "timeout", "j1", "(J)V", "", "debugStatus", ExpandableTextView.P, "h1", "isThreadPresent", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "g1", "isShutdownRequested", "k", "SHUTDOWN_REQ", NotifyType.LIGHTS, "SHUTDOWN_ACK", "g", "J", "DEFAULT_KEEP_ALIVE", "h", "KEEP_ALIVE_NANOS", "j", "ACTIVE", "M0", "thread", "i", "FRESH", "", "f", "Ljava/lang/String;", "THREAD_NAME", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class s0 extends j1 implements Runnable {
    private static volatile Thread _thread = null;
    private static volatile int debugStatus = 0;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final String f15789f = "kotlinx.coroutines.DefaultExecutor";

    /* renamed from: g  reason: collision with root package name */
    private static final long f15790g = 1000;

    /* renamed from: h  reason: collision with root package name */
    private static final long f15791h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f15792i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static final int f15793j = 1;

    /* renamed from: k  reason: collision with root package name */
    private static final int f15794k = 2;

    /* renamed from: l  reason: collision with root package name */
    private static final int f15795l = 3;

    /* renamed from: m  reason: collision with root package name */
    public static final s0 f15796m;

    static {
        Long l2;
        s0 s0Var = new s0();
        f15796m = s0Var;
        i1.F0(s0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f15791h = timeUnit.toNanos(l2.longValue());
    }

    private s0() {
    }

    private final synchronized void c1() {
        if (g1()) {
            debugStatus = 3;
            W0();
            notifyAll();
        }
    }

    private final synchronized Thread d1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, f15789f);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private static /* synthetic */ void f1() {
    }

    private final boolean g1() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized boolean i1() {
        if (g1()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // i.b.k1
    @k.e.a.d
    public Thread M0() {
        Thread thread = _thread;
        return thread != null ? thread : d1();
    }

    public final synchronized void e1() {
        boolean z = true;
        if (q0.b()) {
            if (!(_thread == null)) {
                throw new AssertionError();
            }
        }
        if (q0.b()) {
            if (debugStatus != 0 && debugStatus != 3) {
                z = false;
            }
            throw new AssertionError();
        }
        debugStatus = 0;
        d1();
        while (debugStatus == 0) {
            wait();
        }
    }

    public final boolean h1() {
        return _thread != null;
    }

    public final synchronized void j1(long j2) {
        long currentTimeMillis = System.currentTimeMillis() + j2;
        if (!g1()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            Thread thread = _thread;
            if (thread != null) {
                l3 b = m3.b();
                if (b != null) {
                    b.c(thread);
                } else {
                    LockSupport.unpark(thread);
                }
            }
            if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            }
            wait(j2);
        }
        debugStatus = 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean G0;
        h3.b.d(this);
        l3 b = m3.b();
        if (b != null) {
            b.h();
        }
        try {
            if (!i1()) {
                if (G0) {
                    return;
                }
                return;
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long J0 = J0();
                if (J0 == Long.MAX_VALUE) {
                    l3 b2 = m3.b();
                    long nanoTime = b2 != null ? b2.nanoTime() : System.nanoTime();
                    if (j2 == Long.MAX_VALUE) {
                        j2 = f15791h + nanoTime;
                    }
                    long j3 = j2 - nanoTime;
                    if (j3 <= 0) {
                        _thread = null;
                        c1();
                        l3 b3 = m3.b();
                        if (b3 != null) {
                            b3.e();
                        }
                        if (G0()) {
                            return;
                        }
                        M0();
                        return;
                    }
                    J0 = h.o2.q.v(J0, j3);
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (J0 > 0) {
                    if (g1()) {
                        _thread = null;
                        c1();
                        l3 b4 = m3.b();
                        if (b4 != null) {
                            b4.e();
                        }
                        if (G0()) {
                            return;
                        }
                        M0();
                        return;
                    }
                    l3 b5 = m3.b();
                    if (b5 != null) {
                        b5.d(this, J0);
                    } else {
                        LockSupport.parkNanos(this, J0);
                    }
                }
            }
        } finally {
            _thread = null;
            c1();
            l3 b6 = m3.b();
            if (b6 != null) {
                b6.e();
            }
            if (!G0()) {
                M0();
            }
        }
    }

    @Override // i.b.j1, i.b.v0
    @k.e.a.d
    public e1 t(long j2, @k.e.a.d Runnable runnable, @k.e.a.d CoroutineContext coroutineContext) {
        return Z0(j2, runnable);
    }
}
