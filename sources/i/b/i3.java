package i.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Li/b/i3;", "Li/b/o1;", "Lh/t1;", "close", "()V", "", "toString", "()Ljava/lang/String;", "", com.huawei.hms.push.e.a, ExpandableTextView.P, "nThreads", "Ljava/util/concurrent/Executor;", e.j.a.b.c.f.f10128d, "Ljava/util/concurrent/Executor;", "z0", "()Ljava/util/concurrent/Executor;", "executor", "f", "Ljava/lang/String;", "name", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNo", "<init>", "(ILjava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class i3 extends o1 {

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f15751c = new AtomicInteger();
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final Executor f15752d;

    /* renamed from: e  reason: collision with root package name */
    private final int f15753e;

    /* renamed from: f  reason: collision with root package name */
    private final String f15754f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", TypedValues.Attributes.S_TARGET, "Ljava/lang/Thread;", "newThread", "(Ljava/lang/Runnable;)Ljava/lang/Thread;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            String str;
            i3 i3Var = i3.this;
            if (i3Var.f15753e == 1) {
                str = i3.this.f15754f;
            } else {
                str = i3.this.f15754f + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i3.this.f15751c.incrementAndGet();
            }
            return new s2(i3Var, runnable, str);
        }
    }

    public i3(int i2, @k.e.a.d String str) {
        this.f15753e = i2;
        this.f15754f = str;
        this.f15752d = Executors.newScheduledThreadPool(i2, new a());
        B0();
    }

    @Override // i.b.o1, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor z0 = z0();
        Objects.requireNonNull(z0, "null cannot be cast to non-null type java.util.concurrent.ExecutorService");
        ((ExecutorService) z0).shutdown();
    }

    @Override // i.b.o1, kotlinx.coroutines.CoroutineDispatcher
    @k.e.a.d
    public String toString() {
        return "ThreadPoolDispatcher[" + this.f15753e + ", " + this.f15754f + ']';
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @k.e.a.d
    public Executor z0() {
        return this.f15752d;
    }
}
