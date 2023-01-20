package i.b;

import i.b.j1;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Li/b/k1;", "Li/b/i1;", "Lh/t1;", "O0", "()V", "", "now", "Li/b/j1$c;", "delayedTask", "N0", "(JLi/b/j1$c;)V", "Ljava/lang/Thread;", "M0", "()Ljava/lang/Thread;", "thread", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class k1 extends i1 {
    @k.e.a.d
    public abstract Thread M0();

    public final void N0(long j2, @k.e.a.d j1.c cVar) {
        if (q0.b()) {
            if (!(this != s0.f15796m)) {
                throw new AssertionError();
            }
        }
        s0.f15796m.X0(j2, cVar);
    }

    public final void O0() {
        Thread M0 = M0();
        if (Thread.currentThread() != M0) {
            l3 b = m3.b();
            if (b != null) {
                b.c(M0);
            } else {
                LockSupport.unpark(M0);
            }
        }
    }
}
