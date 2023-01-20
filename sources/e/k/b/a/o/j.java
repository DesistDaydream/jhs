package e.k.b.a.o;

import android.os.Looper;
import e.k.b.a.k;
import e.k.b.a.l;
import e.k.b.a.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class j {

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ l a;
        public final /* synthetic */ Callable b;

        public a(l lVar, Callable callable) {
            this.a = lVar;
            this.b = callable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.a.setResult(this.b.call());
            } catch (Exception e2) {
                this.a.c(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements e.k.b.a.d<Void, List<k<?>>> {
        public final /* synthetic */ Collection a;

        public b(Collection collection) {
            this.a = collection;
        }

        @Override // e.k.b.a.d
        public final /* synthetic */ List<k<?>> a(k<Void> kVar) throws Exception {
            ArrayList arrayList = new ArrayList(this.a.size());
            arrayList.addAll(this.a);
            return arrayList;
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements e.k.b.a.d<Void, List<TResult>> {
        public final /* synthetic */ Collection a;

        public c(Collection collection) {
            this.a = collection;
        }

        @Override // e.k.b.a.d
        public final /* synthetic */ Object a(k<Void> kVar) throws Exception {
            ArrayList arrayList = new ArrayList();
            for (k kVar2 : this.a) {
                arrayList.add(kVar2.r());
            }
            return arrayList;
        }
    }

    /* loaded from: classes2.dex */
    public static class d<TResult> implements e.k.b.a.f, e.k.b.a.h, e.k.b.a.i<TResult> {
        public final CountDownLatch a = new CountDownLatch(1);

        @Override // e.k.b.a.f
        public final void a() {
            this.a.countDown();
        }

        @Override // e.k.b.a.h
        public final void onFailure(Exception exc) {
            this.a.countDown();
        }

        @Override // e.k.b.a.i
        public final void onSuccess(TResult tresult) {
            this.a.countDown();
        }
    }

    public static <TResult> k<TResult> a(TResult tresult) {
        l lVar = new l();
        lVar.setResult(tresult);
        return lVar.b();
    }

    public static k<List<k<?>>> b(Collection<? extends k<?>> collection) {
        return g(collection).m(new b(collection));
    }

    public static <TResult> TResult d(k<TResult> kVar) throws ExecutionException {
        if (kVar.v()) {
            return kVar.r();
        }
        throw new ExecutionException(kVar.q());
    }

    public static void e(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <TResult> k<List<TResult>> f(Collection<? extends k<?>> collection) {
        return (k<List<TResult>>) g(collection).m(new c(collection));
    }

    public static k<Void> g(Collection<? extends k<?>> collection) {
        if (collection.isEmpty()) {
            return a(null);
        }
        for (k<?> kVar : collection) {
            Objects.requireNonNull(kVar, "task can not is null");
        }
        i iVar = new i();
        e eVar = new e(collection.size(), iVar);
        for (k<?> kVar2 : collection) {
            kVar2.l(m.b(), eVar);
            kVar2.i(m.b(), eVar);
            kVar2.c(m.b(), eVar);
        }
        return iVar;
    }

    public final <TResult> k<TResult> c(Executor executor, Callable<TResult> callable) {
        l lVar = new l();
        try {
            executor.execute(new a(lVar, callable));
        } catch (Exception e2) {
            lVar.c(e2);
        }
        return lVar.b();
    }
}
