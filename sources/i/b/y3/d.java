package i.b.y3;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import h.k2.v.u;
import i.b.s0;
import i.b.x1;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B)\u0012\u0006\u00101\u001a\u00020\u0013\u0012\u0006\u0010,\u001a\u00020\u0013\u0012\u0006\u0010&\u001a\u00020\u001f\u0012\b\b\u0002\u0010)\u001a\u00020\u0010¢\u0006\u0004\b6\u00107B'\b\u0016\u0012\b\b\u0002\u00101\u001a\u00020\u0013\u0012\b\b\u0002\u0010,\u001a\u00020\u0013\u0012\b\b\u0002\u0010)\u001a\u00020\u0010¢\u0006\u0004\b6\u00108B\u001d\b\u0017\u0012\b\b\u0002\u00101\u001a\u00020\u0013\u0012\b\b\u0002\u0010,\u001a\u00020\u0013¢\u0006\u0004\b6\u00109J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0017J+\u0010\u001c\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001e\u0010\u000fJ\u0017\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\nH\u0000¢\u0006\u0004\b#\u0010\u000fR\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010+R\u0016\u00105\u001a\u0002028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006:"}, d2 = {"Li/b/y3/d;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "C0", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "Lh/t1;", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "close", "()V", "", "toString", "()Ljava/lang/String;", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "A0", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "E0", "Li/b/y3/j;", "", "tailDispatch", "D0", "(Ljava/lang/Runnable;Li/b/y3/j;Z)V", "H0", "", "timeout", "G0", "(J)V", "F0", com.huawei.hms.push.e.a, "J", "idleWorkerKeepAliveNs", "f", "Ljava/lang/String;", "schedulerName", e.j.a.b.c.f.f10128d, ExpandableTextView.P, "maxPoolSize", "b", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "coroutineScheduler", "c", "corePoolSize", "Ljava/util/concurrent/Executor;", "z0", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(IIJLjava/lang/String;)V", "(IILjava/lang/String;)V", "(II)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class d extends ExecutorCoroutineDispatcher {
    private CoroutineScheduler b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15918c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15919d;

    /* renamed from: e  reason: collision with root package name */
    private final long f15920e;

    /* renamed from: f  reason: collision with root package name */
    private final String f15921f;

    public /* synthetic */ d(int i2, int i3, long j2, String str, int i4, u uVar) {
        this(i2, i3, j2, (i4 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public static /* synthetic */ CoroutineDispatcher B0(d dVar, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i2 = l.f15929d;
            }
            return dVar.A0(i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    private final CoroutineScheduler C0() {
        return new CoroutineScheduler(this.f15918c, this.f15919d, this.f15920e, this.f15921f);
    }

    @k.e.a.d
    public final CoroutineDispatcher A0(int i2) {
        if (i2 > 0) {
            return new f(this, i2, null, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i2).toString());
    }

    public final void D0(@k.e.a.d Runnable runnable, @k.e.a.d j jVar, boolean z) {
        try {
            this.b.H(runnable, jVar, z);
        } catch (RejectedExecutionException unused) {
            s0.f15796m.T0(this.b.q(runnable, jVar));
        }
    }

    @k.e.a.d
    public final CoroutineDispatcher E0(int i2) {
        if (i2 > 0) {
            if (i2 <= this.f15918c) {
                return new f(this, i2, null, 0);
            }
            throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.f15918c + "), but have " + i2).toString());
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i2).toString());
    }

    public final void F0() {
        H0();
    }

    public final synchronized void G0(long j2) {
        this.b.A0(j2);
    }

    public final synchronized void H0() {
        this.b.A0(1000L);
        this.b = C0();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable) {
        try {
            CoroutineScheduler.J(this.b, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            s0.f15796m.dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable) {
        try {
            CoroutineScheduler.J(this.b, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            s0.f15796m.dispatchYield(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @k.e.a.d
    public String toString() {
        return super.toString() + "[scheduler = " + this.b + ']';
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @k.e.a.d
    public Executor z0() {
        return this.b;
    }

    public d(int i2, int i3, long j2, @k.e.a.d String str) {
        this.f15918c = i2;
        this.f15919d = i3;
        this.f15920e = j2;
        this.f15921f = str;
        this.b = C0();
    }

    public /* synthetic */ d(int i2, int i3, String str, int i4, u uVar) {
        this((i4 & 1) != 0 ? l.f15930e : i2, (i4 & 2) != 0 ? l.f15931f : i3, (i4 & 4) != 0 ? l.b : str);
    }

    public d(int i2, int i3, @k.e.a.d String str) {
        this(i2, i3, l.f15932g, str);
    }

    public /* synthetic */ d(int i2, int i3, int i4, u uVar) {
        this((i4 & 1) != 0 ? l.f15930e : i2, (i4 & 2) != 0 ? l.f15931f : i3);
    }

    @h.i(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ d(int i2, int i3) {
        this(i2, i3, l.f15932g, null, 8, null);
    }
}
