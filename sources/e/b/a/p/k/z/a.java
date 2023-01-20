package e.b.a.p.k.z;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class a implements ExecutorService {
    private static final String b = "source";

    /* renamed from: c  reason: collision with root package name */
    private static final String f9664c = "disk-cache";

    /* renamed from: d  reason: collision with root package name */
    private static final int f9665d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final String f9666e = "GlideExecutor";

    /* renamed from: f  reason: collision with root package name */
    private static final String f9667f = "source-unlimited";

    /* renamed from: g  reason: collision with root package name */
    private static final String f9668g = "animation";

    /* renamed from: h  reason: collision with root package name */
    private static final long f9669h = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: i  reason: collision with root package name */
    private static final int f9670i = 4;

    /* renamed from: j  reason: collision with root package name */
    private static volatile int f9671j;
    private final ExecutorService a;

    /* renamed from: e.b.a.p.k.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0311a {

        /* renamed from: g  reason: collision with root package name */
        public static final long f9672g = 0;
        private final boolean a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f9673c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private c f9674d = c.f9681d;

        /* renamed from: e  reason: collision with root package name */
        private String f9675e;

        /* renamed from: f  reason: collision with root package name */
        private long f9676f;

        public C0311a(boolean z) {
            this.a = z;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f9675e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.f9673c, this.f9676f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f9675e, this.f9674d, this.a));
                if (this.f9676f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f9675e);
        }

        public C0311a b(String str) {
            this.f9675e = str;
            return this;
        }

        public C0311a c(@IntRange(from = 1) int i2) {
            this.b = i2;
            this.f9673c = i2;
            return this;
        }

        public C0311a d(long j2) {
            this.f9676f = j2;
            return this;
        }

        public C0311a e(@NonNull c cVar) {
            this.f9674d = cVar;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        private static final int f9677e = 9;
        private final String a;
        public final c b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f9678c;

        /* renamed from: d  reason: collision with root package name */
        private int f9679d;

        /* renamed from: e.b.a.p.k.z.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0312a extends Thread {
            public C0312a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (b.this.f9678c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.b.a(th);
                }
            }
        }

        public b(String str, c cVar, boolean z) {
            this.a = str;
            this.b = cVar;
            this.f9678c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0312a c0312a;
            c0312a = new C0312a(runnable, "glide-" + this.a + "-thread-" + this.f9679d);
            this.f9679d = this.f9679d + 1;
            return c0312a;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        public static final c a = new C0313a();
        public static final c b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f9680c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f9681d;

        /* renamed from: e.b.a.p.k.z.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0313a implements c {
            @Override // e.b.a.p.k.z.a.c
            public void a(Throwable th) {
            }
        }

        /* loaded from: classes.dex */
        public class b implements c {
            @Override // e.b.a.p.k.z.a.c
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable(a.f9666e, 6)) {
                    return;
                }
                Log.e(a.f9666e, "Request threw uncaught throwable", th);
            }
        }

        /* renamed from: e.b.a.p.k.z.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0314c implements c {
            @Override // e.b.a.p.k.z.a.c
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            b bVar = new b();
            b = bVar;
            f9680c = new C0314c();
            f9681d = bVar;
        }

        void a(Throwable th);
    }

    @VisibleForTesting
    public a(ExecutorService executorService) {
        this.a = executorService;
    }

    public static int a() {
        if (f9671j == 0) {
            f9671j = Math.min(4, e.b.a.p.k.z.b.a());
        }
        return f9671j;
    }

    public static C0311a b() {
        return new C0311a(true).c(a() >= 4 ? 2 : 1).b(f9668g);
    }

    public static a c() {
        return b().a();
    }

    @Deprecated
    public static a d(int i2, c cVar) {
        return b().c(i2).e(cVar).a();
    }

    public static C0311a e() {
        return new C0311a(true).c(1).b(f9664c);
    }

    public static a f() {
        return e().a();
    }

    @Deprecated
    public static a g(int i2, String str, c cVar) {
        return e().c(i2).b(str).e(cVar).a();
    }

    @Deprecated
    public static a h(c cVar) {
        return e().e(cVar).a();
    }

    public static C0311a i() {
        return new C0311a(false).c(a()).b("source");
    }

    public static a j() {
        return i().a();
    }

    @Deprecated
    public static a k(int i2, String str, c cVar) {
        return i().c(i2).b(str).e(cVar).a();
    }

    @Deprecated
    public static a l(c cVar) {
        return i().e(cVar).a();
    }

    public static a m() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f9669h, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b(f9667f, c.f9681d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.a.submit(runnable);
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.a.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.a.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.a.submit(callable);
    }
}
