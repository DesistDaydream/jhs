package j;

import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.t1;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010\u0015J\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0003\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"Lj/o0;", "", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lj/o0;", "timeoutNanos", "()J", "", "hasDeadline", "()Z", "deadlineNanoTime", "(J)Lj/o0;", "duration", "deadline", "clearTimeout", "()Lj/o0;", "clearDeadline", "Lh/t1;", "throwIfReached", "()V", "monitor", "waitUntilNotified", "(Ljava/lang/Object;)V", "other", "Lkotlin/Function0;", ReportItem.LogTypeBlock, "intersectWith", "(Lj/o0;Lh/k2/u/a;)V", "Z", "J", "<init>", "Companion", "b", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class o0 {
    public static final b Companion = new b(null);
    @h.k2.d
    @k.e.a.d
    public static final o0 NONE = new a();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0003\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"j/o0$a", "Lj/o0;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lj/o0;", "deadlineNanoTime", "(J)Lj/o0;", "Lh/t1;", "throwIfReached", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a extends o0 {
        @Override // j.o0
        @k.e.a.d
        public o0 deadlineNanoTime(long j2) {
            return this;
        }

        @Override // j.o0
        public void throwIfReached() {
        }

        @Override // j.o0
        @k.e.a.d
        public o0 timeout(long j2, @k.e.a.d TimeUnit timeUnit) {
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"j/o0$b", "", "", "aNanos", "bNanos", am.av, "(JJ)J", "Lj/o0;", "NONE", "Lj/o0;", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b {
        private b() {
        }

        public final long a(long j2, long j3) {
            return (j2 != 0 && (j3 == 0 || j2 < j3)) ? j2 : j3;
        }

        public /* synthetic */ b(h.k2.v.u uVar) {
            this();
        }
    }

    @k.e.a.d
    public o0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    @k.e.a.d
    public o0 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    @k.e.a.d
    public final o0 deadline(long j2, @k.e.a.d TimeUnit timeUnit) {
        if (j2 > 0) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j2));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j2).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(@k.e.a.d o0 o0Var, @k.e.a.d h.k2.u.a<t1> aVar) {
        long timeoutNanos = timeoutNanos();
        long a2 = Companion.a(o0Var.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(a2, timeUnit);
        if (hasDeadline()) {
            long deadlineNanoTime = deadlineNanoTime();
            if (o0Var.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), o0Var.deadlineNanoTime()));
            }
            try {
                aVar.invoke();
                h.k2.v.c0.d(1);
                timeout(timeoutNanos, timeUnit);
                if (o0Var.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime);
                }
                h.k2.v.c0.c(1);
                return;
            } catch (Throwable th) {
                h.k2.v.c0.d(1);
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (o0Var.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime);
                }
                h.k2.v.c0.c(1);
                throw th;
            }
        }
        if (o0Var.hasDeadline()) {
            deadlineNanoTime(o0Var.deadlineNanoTime());
        }
        try {
            aVar.invoke();
            h.k2.v.c0.d(1);
            timeout(timeoutNanos, timeUnit);
            if (o0Var.hasDeadline()) {
                clearDeadline();
            }
            h.k2.v.c0.c(1);
        } catch (Throwable th2) {
            h.k2.v.c0.d(1);
            timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (o0Var.hasDeadline()) {
                clearDeadline();
            }
            h.k2.v.c0.c(1);
            throw th2;
        }
    }

    public void throwIfReached() throws IOException {
        if (!Thread.interrupted()) {
            if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    @k.e.a.d
    public o0 timeout(long j2, @k.e.a.d TimeUnit timeUnit) {
        if (j2 >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j2);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j2).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(@k.e.a.d Object obj) throws InterruptedIOException {
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            long j2 = 0;
            if (!hasDeadline && timeoutNanos == 0) {
                obj.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j3 = timeoutNanos / 1000000;
                Long.signum(j3);
                obj.wait(j3, (int) (timeoutNanos - (1000000 * j3)));
                j2 = System.nanoTime() - nanoTime;
            }
            if (j2 >= timeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    @k.e.a.d
    public o0 deadlineNanoTime(long j2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j2;
        return this;
    }
}
