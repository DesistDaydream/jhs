package i.b;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Li/b/e;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/a;", "", "state", "Lh/t1;", "U", "(Ljava/lang/Object;)V", "t1", "()Ljava/lang/Object;", "Li/b/i1;", com.huawei.hms.push.e.a, "Li/b/i1;", "eventLoop", "Ljava/lang/Thread;", e.j.a.b.c.f.f10128d, "Ljava/lang/Thread;", "blockedThread", "", "F0", "()Z", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Li/b/i1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class e<T> extends a<T> {

    /* renamed from: d  reason: collision with root package name */
    private final Thread f15735d;

    /* renamed from: e  reason: collision with root package name */
    private final i1 f15736e;

    public e(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Thread thread, @k.e.a.e i1 i1Var) {
        super(coroutineContext, true);
        this.f15735d = thread;
        this.f15736e = i1Var;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean F0() {
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void U(@k.e.a.e Object obj) {
        if (!h.k2.v.f0.g(Thread.currentThread(), this.f15735d)) {
            LockSupport.unpark(this.f15735d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T t1() {
        l3 b = m3.b();
        if (b != null) {
            b.h();
        }
        try {
            i1 i1Var = this.f15736e;
            if (i1Var != null) {
                i1.F0(i1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                i1 i1Var2 = this.f15736e;
                long J0 = i1Var2 != null ? i1Var2.J0() : Long.MAX_VALUE;
                if (l()) {
                    i1 i1Var3 = this.f15736e;
                    if (i1Var3 != null) {
                        i1.A0(i1Var3, false, 1, null);
                    }
                    T t = (T) i2.o(z0());
                    b0 b0Var = t instanceof b0 ? t : null;
                    if (b0Var == null) {
                        return t;
                    }
                    throw b0Var.a;
                }
                l3 b2 = m3.b();
                if (b2 != null) {
                    b2.d(this, J0);
                } else {
                    LockSupport.parkNanos(this, J0);
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            Z(interruptedException);
            throw interruptedException;
        } finally {
            l3 b3 = m3.b();
            if (b3 != null) {
                b3.e();
            }
        }
    }
}
