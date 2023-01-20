package i.b;

import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0081\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u0000H\u0081\b¢\u0006\u0004\b\u0003\u0010\u0002\u001a \u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0081\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u0010\u0010\n\u001a\u00020\tH\u0081\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\tH\u0081\b¢\u0006\u0004\b\f\u0010\u000b\u001a\u0010\u0010\r\u001a\u00020\tH\u0081\b¢\u0006\u0004\b\r\u0010\u000b\u001a\u0010\u0010\u000e\u001a\u00020\tH\u0081\b¢\u0006\u0004\b\u000e\u0010\u000b\u001a \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0000H\u0081\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0081\b¢\u0006\u0004\b\u0016\u0010\u0017\"$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0001\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"", am.av, "()J", "c", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "k", "(Ljava/lang/Runnable;)Ljava/lang/Runnable;", "Lh/t1;", "g", "()V", "h", com.huawei.hms.push.e.a, "j", "", "blocker", "nanos", e.j.a.b.c.f.f10128d, "(Ljava/lang/Object;J)V", "Ljava/lang/Thread;", "thread", "i", "(Ljava/lang/Thread;)V", "Li/b/l3;", "Li/b/l3;", "b", "()Li/b/l3;", "f", "(Li/b/l3;)V", "timeSource", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class m3 {
    @k.e.a.e
    private static l3 a;

    @h.g2.f
    private static final long a() {
        l3 b = b();
        return b != null ? b.a() : System.currentTimeMillis();
    }

    @k.e.a.e
    public static final l3 b() {
        return a;
    }

    @h.g2.f
    private static final long c() {
        l3 b = b();
        return b != null ? b.nanoTime() : System.nanoTime();
    }

    @h.g2.f
    private static final void d(Object obj, long j2) {
        l3 b = b();
        if (b != null) {
            b.d(obj, j2);
        } else {
            LockSupport.parkNanos(obj, j2);
        }
    }

    @h.g2.f
    private static final void e() {
        l3 b = b();
        if (b != null) {
            b.h();
        }
    }

    public static final void f(@k.e.a.e l3 l3Var) {
        a = l3Var;
    }

    @h.g2.f
    private static final void g() {
        l3 b = b();
        if (b != null) {
            b.f();
        }
    }

    @h.g2.f
    private static final void h() {
        l3 b = b();
        if (b != null) {
            b.b();
        }
    }

    @h.g2.f
    private static final void i(Thread thread) {
        l3 b = b();
        if (b != null) {
            b.c(thread);
        } else {
            LockSupport.unpark(thread);
        }
    }

    @h.g2.f
    private static final void j() {
        l3 b = b();
        if (b != null) {
            b.e();
        }
    }

    @h.g2.f
    private static final Runnable k(Runnable runnable) {
        Runnable g2;
        l3 b = b();
        return (b == null || (g2 = b.g(runnable)) == null) ? runnable : g2;
    }
}
