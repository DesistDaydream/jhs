package j;

import com.umeng.analytics.pro.am;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lj/s;", "Lj/o0;", "delegate", "b", "(Lj/o0;)Lj/s;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lj/o0;", "timeoutNanos", "()J", "", "hasDeadline", "()Z", "deadlineNanoTime", "(J)Lj/o0;", "clearTimeout", "()Lj/o0;", "clearDeadline", "Lh/t1;", "throwIfReached", "()V", am.av, "Lj/o0;", "c", "(Lj/o0;)V", "<init>", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class s extends o0 {
    @k.e.a.d
    private o0 a;

    public s(@k.e.a.d o0 o0Var) {
        this.a = o0Var;
    }

    @h.k2.g(name = "delegate")
    @k.e.a.d
    public final o0 a() {
        return this.a;
    }

    @k.e.a.d
    public final s b(@k.e.a.d o0 o0Var) {
        this.a = o0Var;
        return this;
    }

    public final /* synthetic */ void c(@k.e.a.d o0 o0Var) {
        this.a = o0Var;
    }

    @Override // j.o0
    @k.e.a.d
    public o0 clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // j.o0
    @k.e.a.d
    public o0 clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // j.o0
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // j.o0
    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // j.o0
    public void throwIfReached() throws IOException {
        this.a.throwIfReached();
    }

    @Override // j.o0
    @k.e.a.d
    public o0 timeout(long j2, @k.e.a.d TimeUnit timeUnit) {
        return this.a.timeout(j2, timeUnit);
    }

    @Override // j.o0
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // j.o0
    @k.e.a.d
    public o0 deadlineNanoTime(long j2) {
        return this.a.deadlineNanoTime(j2);
    }
}
