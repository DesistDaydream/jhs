package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class n {

    /* loaded from: classes2.dex */
    public interface b extends d, f, g<Object> {
    }

    /* loaded from: classes2.dex */
    public static final class c implements b {
        private final Object a = new Object();
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final i0<Void> f10540c;
        @GuardedBy("mLock")

        /* renamed from: d  reason: collision with root package name */
        private int f10541d;
        @GuardedBy("mLock")

        /* renamed from: e  reason: collision with root package name */
        private int f10542e;
        @GuardedBy("mLock")

        /* renamed from: f  reason: collision with root package name */
        private int f10543f;
        @GuardedBy("mLock")

        /* renamed from: g  reason: collision with root package name */
        private Exception f10544g;
        @GuardedBy("mLock")

        /* renamed from: h  reason: collision with root package name */
        private boolean f10545h;

        public c(int i2, i0<Void> i0Var) {
            this.b = i2;
            this.f10540c = i0Var;
        }

        @GuardedBy("mLock")
        private final void b() {
            if (this.f10541d + this.f10542e + this.f10543f == this.b) {
                if (this.f10544g != null) {
                    i0<Void> i0Var = this.f10540c;
                    int i2 = this.f10542e;
                    int i3 = this.b;
                    StringBuilder sb = new StringBuilder(54);
                    sb.append(i2);
                    sb.append(" out of ");
                    sb.append(i3);
                    sb.append(" underlying tasks failed");
                    i0Var.y(new ExecutionException(sb.toString(), this.f10544g));
                } else if (this.f10545h) {
                    this.f10540c.B();
                } else {
                    this.f10540c.setResult(null);
                }
            }
        }

        @Override // e.j.a.b.j.d
        public final void a() {
            synchronized (this.a) {
                this.f10543f++;
                this.f10545h = true;
                b();
            }
        }

        @Override // e.j.a.b.j.f
        public final void onFailure(@NonNull Exception exc) {
            synchronized (this.a) {
                this.f10542e++;
                this.f10544g = exc;
                b();
            }
        }

        @Override // e.j.a.b.j.g
        public final void onSuccess(Object obj) {
            synchronized (this.a) {
                this.f10541d++;
                b();
            }
        }
    }

    private n() {
    }

    public static <TResult> TResult a(@NonNull k<TResult> kVar) throws ExecutionException, InterruptedException {
        e.j.a.b.c.r.a0.i();
        e.j.a.b.c.r.a0.l(kVar, "Task must not be null");
        if (kVar.u()) {
            return (TResult) m(kVar);
        }
        a aVar = new a(null);
        l(kVar, aVar);
        aVar.b();
        return (TResult) m(kVar);
    }

    public static <TResult> TResult b(@NonNull k<TResult> kVar, long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        e.j.a.b.c.r.a0.i();
        e.j.a.b.c.r.a0.l(kVar, "Task must not be null");
        e.j.a.b.c.r.a0.l(timeUnit, "TimeUnit must not be null");
        if (kVar.u()) {
            return (TResult) m(kVar);
        }
        a aVar = new a(null);
        l(kVar, aVar);
        if (aVar.c(j2, timeUnit)) {
            return (TResult) m(kVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static <TResult> k<TResult> c() {
        i0 i0Var = new i0();
        i0Var.B();
        return i0Var;
    }

    public static <TResult> k<TResult> call(@NonNull Callable<TResult> callable) {
        return call(m.a, callable);
    }

    public static <TResult> k<TResult> d(@NonNull Exception exc) {
        i0 i0Var = new i0();
        i0Var.y(exc);
        return i0Var;
    }

    public static <TResult> k<TResult> e(TResult tresult) {
        i0 i0Var = new i0();
        i0Var.setResult(tresult);
        return i0Var;
    }

    public static k<Void> f(Collection<? extends k<?>> collection) {
        if (collection.isEmpty()) {
            return e(null);
        }
        for (k<?> kVar : collection) {
            Objects.requireNonNull(kVar, "null tasks are not accepted");
        }
        i0 i0Var = new i0();
        c cVar = new c(collection.size(), i0Var);
        for (k<?> kVar2 : collection) {
            l(kVar2, cVar);
        }
        return i0Var;
    }

    public static k<Void> g(k<?>... kVarArr) {
        if (kVarArr.length == 0) {
            return e(null);
        }
        return f(Arrays.asList(kVarArr));
    }

    public static k<List<k<?>>> h(Collection<? extends k<?>> collection) {
        return f(collection).o(new l0(collection));
    }

    public static k<List<k<?>>> i(k<?>... kVarArr) {
        return h(Arrays.asList(kVarArr));
    }

    public static <TResult> k<List<TResult>> j(Collection<? extends k<?>> collection) {
        return (k<List<TResult>>) f(collection).m(new k0(collection));
    }

    public static <TResult> k<List<TResult>> k(k<?>... kVarArr) {
        return j(Arrays.asList(kVarArr));
    }

    private static void l(k<?> kVar, b bVar) {
        Executor executor = m.b;
        kVar.l(executor, bVar);
        kVar.i(executor, bVar);
        kVar.c(executor, bVar);
    }

    private static <TResult> TResult m(k<TResult> kVar) throws ExecutionException {
        if (kVar.v()) {
            return kVar.r();
        }
        if (kVar.t()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(kVar.q());
    }

    /* loaded from: classes2.dex */
    public static final class a implements b {
        private final CountDownLatch a;

        private a() {
            this.a = new CountDownLatch(1);
        }

        @Override // e.j.a.b.j.d
        public final void a() {
            this.a.countDown();
        }

        public final void b() throws InterruptedException {
            this.a.await();
        }

        public final boolean c(long j2, TimeUnit timeUnit) throws InterruptedException {
            return this.a.await(j2, timeUnit);
        }

        @Override // e.j.a.b.j.f
        public final void onFailure(@NonNull Exception exc) {
            this.a.countDown();
        }

        @Override // e.j.a.b.j.g
        public final void onSuccess(Object obj) {
            this.a.countDown();
        }

        public /* synthetic */ a(j0 j0Var) {
            this();
        }
    }

    public static <TResult> k<TResult> call(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        e.j.a.b.c.r.a0.l(executor, "Executor must not be null");
        e.j.a.b.c.r.a0.l(callable, "Callback must not be null");
        i0 i0Var = new i0();
        executor.execute(new j0(i0Var, callable));
        return i0Var;
    }
}
