package i.b.y3;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010(\u001a\u00020\u001a¢\u0006\u0004\b0\u00101J#\u0010\n\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010$\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010(\u001a\u00020\u001a8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Li/b/y3/f;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Li/b/y3/j;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "", "tailDispatch", "Lh/t1;", "A0", "(Ljava/lang/Runnable;Z)V", com.heytap.mcssdk.constant.b.y, "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "", "toString", "()Ljava/lang/String;", "c0", "", e.j.a.b.c.f.f10128d, ExpandableTextView.P, "parallelism", com.huawei.hms.push.e.a, "Ljava/lang/String;", "name", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "b", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "f", "f0", "()I", "taskMode", "z0", "()Ljava/util/concurrent/Executor;", "executor", "Li/b/y3/d;", "c", "Li/b/y3/d;", "dispatcher", "<init>", "(Li/b/y3/d;ILjava/lang/String;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class f extends ExecutorCoroutineDispatcher implements j, Executor {

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f15922g = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");

    /* renamed from: c  reason: collision with root package name */
    private final d f15923c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15924d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15925e;

    /* renamed from: f  reason: collision with root package name */
    private final int f15926f;
    private final ConcurrentLinkedQueue<Runnable> b = new ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    public f(@k.e.a.d d dVar, int i2, @k.e.a.e String str, int i3) {
        this.f15923c = dVar;
        this.f15924d = i2;
        this.f15925e = str;
        this.f15926f = i3;
    }

    private final void A0(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15922g;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f15924d) {
                this.f15923c.D0(runnable, this, z);
                return;
            }
            this.b.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f15924d) {
                return;
            }
            runnable = this.b.poll();
        } while (runnable != null);
    }

    @Override // i.b.y3.j
    public void c0() {
        Runnable poll = this.b.poll();
        if (poll != null) {
            this.f15923c.D0(poll, this, true);
            return;
        }
        f15922g.decrementAndGet(this);
        Runnable poll2 = this.b.poll();
        if (poll2 != null) {
            A0(poll2, true);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable) {
        A0(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable) {
        A0(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@k.e.a.d Runnable runnable) {
        A0(runnable, false);
    }

    @Override // i.b.y3.j
    public int f0() {
        return this.f15926f;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @k.e.a.d
    public String toString() {
        String str = this.f15925e;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f15923c + ']';
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @k.e.a.d
    public Executor z0() {
        return this;
    }
}
