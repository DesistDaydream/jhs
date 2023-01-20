package e.k.b.a;

import e.k.b.a.o.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class n {
    private static e.k.b.a.o.j a = new e.k.b.a.o.j();

    public static k<List<k<?>>> a(Collection<? extends k<?>> collection) {
        return e.k.b.a.o.j.b(collection);
    }

    public static k<List<k<?>>> b(k<?>... kVarArr) {
        return e.k.b.a.o.j.b(Arrays.asList(kVarArr));
    }

    public static <TResult> TResult c(k<TResult> kVar) throws ExecutionException, InterruptedException {
        e.k.b.a.o.j.e("await must not be called on the UI thread");
        if (kVar.u()) {
            return (TResult) e.k.b.a.o.j.d(kVar);
        }
        j.d dVar = new j.d();
        kVar.k(dVar).h(dVar);
        dVar.a.await();
        return (TResult) e.k.b.a.o.j.d(kVar);
    }

    public static <TResult> k<TResult> call(Callable<TResult> callable) {
        return a.c(m.b(), callable);
    }

    public static <TResult> TResult d(k<TResult> kVar, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        e.k.b.a.o.j.e("await must not be called on the UI thread");
        if (!kVar.u()) {
            j.d dVar = new j.d();
            kVar.k(dVar).h(dVar);
            if (!dVar.a.await(j2, timeUnit)) {
                throw new TimeoutException("Timed out waiting for Task");
            }
        }
        return (TResult) e.k.b.a.o.j.d(kVar);
    }

    public static <TResult> k<TResult> e(Callable<TResult> callable) {
        return a.c(m.a(), callable);
    }

    public static <TResult> k<TResult> f(Executor executor, Callable<TResult> callable) {
        return a.c(executor, callable);
    }

    public static <TResult> k<TResult> g() {
        e.k.b.a.o.i iVar = new e.k.b.a.o.i();
        iVar.B();
        return iVar;
    }

    public static <TResult> k<TResult> h(Exception exc) {
        l lVar = new l();
        lVar.c(exc);
        return lVar.b();
    }

    public static <TResult> k<TResult> i(TResult tresult) {
        return e.k.b.a.o.j.a(tresult);
    }

    public static k<Void> j(Collection<? extends k<?>> collection) {
        return e.k.b.a.o.j.g(collection);
    }

    public static k<Void> k(k<?>... kVarArr) {
        return e.k.b.a.o.j.g(Arrays.asList(kVarArr));
    }

    public static <TResult> k<List<TResult>> l(Collection<? extends k<TResult>> collection) {
        return e.k.b.a.o.j.f(collection);
    }

    public static <TResult> k<List<TResult>> m(k<?>... kVarArr) {
        return e.k.b.a.o.j.f(Arrays.asList(kVarArr));
    }
}
