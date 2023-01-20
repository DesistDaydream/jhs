package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.qiniu.android.collect.ReportItem;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b6\u0010\u001cJ&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0082\b¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00020\u00112\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\n\u0010\u0004\u001a\u00060\u0016j\u0002`\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0018H\u0000¢\u0006\u0004\b!\u0010\u001cJ\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0018H\u0016¢\u0006\u0004\b%\u0010\u001cR\u0018\u0010&\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010\u0010\u001a\u00020\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\rR\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\"8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00067"}, d2 = {"Li/b/w;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", ReportItem.LogTypeBlock, "A0", "(Lh/k2/u/a;)Ljava/lang/Object;", "Ljava/util/concurrent/ExecutorService;", "C0", "()Ljava/util/concurrent/ExecutorService;", "B0", "Ljava/util/concurrent/Executor;", "D0", "()Ljava/util/concurrent/Executor;", "Ljava/lang/Class;", "fjpClass", "executor", "", "F0", "(Ljava/lang/Class;Ljava/util/concurrent/ExecutorService;)Z", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lh/t1;", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "I0", "()V", "", "timeout", "H0", "(J)V", "G0", "", "toString", "()Ljava/lang/String;", "close", "pool", "Ljava/util/concurrent/Executor;", "", "E0", "()I", "parallelism", "z0", e.j.a.b.c.f.f10128d, "Z", "usePrivatePool", "b", "Ljava/lang/String;", "DEFAULT_PARALLELISM_PROPERTY_NAME", "c", ExpandableTextView.P, "requestedParallelism", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class w extends ExecutorCoroutineDispatcher {
    @k.e.a.d
    public static final String b = "kotlinx.coroutines.default.parallelism";

    /* renamed from: c  reason: collision with root package name */
    private static final int f15873c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f15874d;

    /* renamed from: e  reason: collision with root package name */
    public static final w f15875e = new w();
    private static volatile Executor pool;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "Ljava/lang/Thread;", "newThread", "(Ljava/lang/Runnable;)Ljava/lang/Thread;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements ThreadFactory {
        public final /* synthetic */ AtomicInteger a;

        public a(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lh/t1;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements Runnable {
        public static final b a = new b();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "execute", "(Ljava/lang/Runnable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c implements Executor {
        public static final c a = new c();

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            throw new RejectedExecutionException("CommonPool was shutdown");
        }
    }

    static {
        String str;
        int i2;
        try {
            str = System.getProperty(b);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            Integer X0 = h.t2.t.X0(str);
            if (X0 != null && X0.intValue() >= 1) {
                i2 = X0.intValue();
            } else {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + str).toString());
            }
        } else {
            i2 = -1;
        }
        f15873c = i2;
    }

    private w() {
    }

    private final <T> T A0(h.k2.u.a<? extends T> aVar) {
        try {
            return aVar.invoke();
        } catch (Throwable unused) {
            return null;
        }
    }

    private final ExecutorService B0() {
        return Executors.newFixedThreadPool(E0(), new a(new AtomicInteger()));
    }

    private final ExecutorService C0() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return B0();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            if (!f15874d && f15873c < 0) {
                try {
                    Method method = cls.getMethod("commonPool", new Class[0]);
                    Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                    if (!(invoke instanceof ExecutorService)) {
                        invoke = null;
                    }
                    executorService = (ExecutorService) invoke;
                } catch (Throwable unused2) {
                    executorService = null;
                }
                if (executorService != null) {
                    if (!f15875e.F0(cls, executorService)) {
                        executorService = null;
                    }
                    if (executorService != null) {
                        return executorService;
                    }
                }
            }
            try {
                Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f15875e.E0()));
                if (!(newInstance instanceof ExecutorService)) {
                    newInstance = null;
                }
                executorService2 = (ExecutorService) newInstance;
            } catch (Throwable unused3) {
            }
            return executorService2 != null ? executorService2 : B0();
        }
        return B0();
    }

    private final synchronized Executor D0() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = C0();
            pool = executor;
        }
        return executor;
    }

    private final int E0() {
        Integer valueOf = Integer.valueOf(f15873c);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.intValue() : h.o2.q.n(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    public final boolean F0(@k.e.a.d Class<?> cls, @k.e.a.d ExecutorService executorService) {
        executorService.submit(b.a);
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    public final synchronized void G0() {
        H0(0L);
        f15874d = false;
        pool = null;
    }

    public final synchronized void H0(long j2) {
        Executor executor = pool;
        if (!(executor instanceof ExecutorService)) {
            executor = null;
        }
        ExecutorService executorService = (ExecutorService) executor;
        if (executorService != null) {
            executorService.shutdown();
            if (j2 > 0) {
                executorService.awaitTermination(j2, TimeUnit.MILLISECONDS);
            }
            for (Runnable runnable : executorService.shutdownNow()) {
                s0.f15796m.T0(runnable);
            }
        }
        pool = c.a;
    }

    public final synchronized void I0() {
        H0(0L);
        f15874d = true;
        pool = null;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = D0();
            }
            l3 b2 = m3.b();
            if (b2 == null || (runnable2 = b2.g(runnable)) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
        } catch (RejectedExecutionException unused) {
            l3 b3 = m3.b();
            if (b3 != null) {
                b3.b();
            }
            s0.f15796m.T0(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @k.e.a.d
    public String toString() {
        return "CommonPool";
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @k.e.a.d
    public Executor z0() {
        Executor executor = pool;
        return executor != null ? executor : D0();
    }
}
