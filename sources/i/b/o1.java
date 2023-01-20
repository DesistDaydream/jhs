package i.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import i.b.v0;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b,\u0010\u0013J1\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Li/b/o1;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Li/b/v0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeMillis", "Ljava/util/concurrent/ScheduledFuture;", "C0", "(Ljava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;J)Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "Lh/t1;", "A0", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/RejectedExecutionException;)V", "B0", "()V", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "Li/b/n;", "continuation", "c", "(JLi/b/n;)V", "Li/b/e1;", am.aI, "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Li/b/e1;", "close", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "b", "Z", "removesFutureOnCancellation", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class o1 extends ExecutorCoroutineDispatcher implements v0 {
    private boolean b;

    private final void A0(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        e2.g(coroutineContext, n1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> C0(Runnable runnable, CoroutineContext coroutineContext, long j2) {
        try {
            Executor z0 = z0();
            if (!(z0 instanceof ScheduledExecutorService)) {
                z0 = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) z0;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            }
            return null;
        } catch (RejectedExecutionException e2) {
            A0(coroutineContext, e2);
            return null;
        }
    }

    public final void B0() {
        this.b = i.b.w3.e.c(z0());
    }

    @Override // i.b.v0
    public void c(long j2, @k.e.a.d n<? super h.t1> nVar) {
        ScheduledFuture<?> C0 = this.b ? C0(new w2(this, nVar), nVar.getContext(), j2) : null;
        if (C0 != null) {
            e2.x(nVar, C0);
        } else {
            s0.f15796m.c(j2, nVar);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor z0 = z0();
        if (!(z0 instanceof ExecutorService)) {
            z0 = null;
        }
        ExecutorService executorService = (ExecutorService) z0;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable) {
        Runnable runnable2;
        try {
            Executor z0 = z0();
            l3 b = m3.b();
            if (b == null || (runnable2 = b.g(runnable)) == null) {
                runnable2 = runnable;
            }
            z0.execute(runnable2);
        } catch (RejectedExecutionException e2) {
            l3 b2 = m3.b();
            if (b2 != null) {
                b2.b();
            }
            A0(coroutineContext, e2);
            b1.c().dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof o1) && ((o1) obj).z0() == z0();
    }

    public int hashCode() {
        return System.identityHashCode(z0());
    }

    @Override // i.b.v0
    @k.e.a.e
    public Object m0(long j2, @k.e.a.d h.e2.c<? super h.t1> cVar) {
        return v0.a.a(this, j2, cVar);
    }

    @Override // i.b.v0
    @k.e.a.d
    public e1 t(long j2, @k.e.a.d Runnable runnable, @k.e.a.d CoroutineContext coroutineContext) {
        ScheduledFuture<?> C0 = this.b ? C0(runnable, coroutineContext, j2) : null;
        if (C0 != null) {
            return new d1(C0);
        }
        return s0.f15796m.t(j2, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @k.e.a.d
    public String toString() {
        return z0().toString();
    }
}
