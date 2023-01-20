package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import e.j.c.a.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ListFuture<V> implements a<List<V>> {
    private final boolean mAllMustSucceed;
    @Nullable
    public List<? extends a<? extends V>> mFutures;
    @NonNull
    private final AtomicInteger mRemaining;
    @NonNull
    private final a<List<V>> mResult = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<List<V>>() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.1
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<List<V>> completer) {
            Preconditions.checkState(ListFuture.this.mResultNotifier == null, "The result can only set once!");
            ListFuture.this.mResultNotifier = completer;
            return "ListFuture[" + this + "]";
        }
    });
    public CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;
    @Nullable
    public List<V> mValues;

    public ListFuture(@NonNull List<? extends a<? extends V>> list, boolean z, @NonNull Executor executor) {
        this.mFutures = (List) Preconditions.checkNotNull(list);
        this.mValues = new ArrayList(list.size());
        this.mAllMustSucceed = z;
        this.mRemaining = new AtomicInteger(list.size());
        init(executor);
    }

    private void callAllGets() throws InterruptedException {
        List<? extends a<? extends V>> list = this.mFutures;
        if (list == null || isDone()) {
            return;
        }
        for (a<? extends V> aVar : list) {
            while (!aVar.isDone()) {
                try {
                    aVar.get();
                } catch (Error e2) {
                    throw e2;
                } catch (InterruptedException e3) {
                    throw e3;
                } catch (Throwable unused) {
                    if (this.mAllMustSucceed) {
                        return;
                    }
                }
            }
        }
    }

    private void init(@NonNull Executor executor) {
        addListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.2
            @Override // java.lang.Runnable
            public void run() {
                ListFuture listFuture = ListFuture.this;
                listFuture.mValues = null;
                listFuture.mFutures = null;
            }
        }, CameraXExecutors.directExecutor());
        if (this.mFutures.isEmpty()) {
            this.mResultNotifier.set(new ArrayList(this.mValues));
            return;
        }
        for (int i2 = 0; i2 < this.mFutures.size(); i2++) {
            this.mValues.add(null);
        }
        List<? extends a<? extends V>> list = this.mFutures;
        for (final int i3 = 0; i3 < list.size(); i3++) {
            final a<? extends V> aVar = list.get(i3);
            aVar.addListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.3
                @Override // java.lang.Runnable
                public void run() {
                    ListFuture.this.setOneValue(i3, aVar);
                }
            }, executor);
        }
    }

    @Override // e.j.c.a.a.a
    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        List<? extends a<? extends V>> list = this.mFutures;
        if (list != null) {
            for (a<? extends V> aVar : list) {
                aVar.cancel(z);
            }
        }
        return this.mResult.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mResult.isDone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOneValue(int i2, @NonNull Future<? extends V> future) {
        CallbackToFutureAdapter.Completer<List<V>> completer;
        ArrayList arrayList;
        int decrementAndGet;
        List<V> list = this.mValues;
        if (!isDone() && list != 0) {
            try {
                try {
                    try {
                        try {
                            Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                            list.set(i2, Futures.getUninterruptibly(future));
                            decrementAndGet = this.mRemaining.decrementAndGet();
                            Preconditions.checkState(decrementAndGet >= 0, "Less than 0 remaining futures");
                        } catch (Error e2) {
                            this.mResultNotifier.setException(e2);
                            int decrementAndGet2 = this.mRemaining.decrementAndGet();
                            Preconditions.checkState(decrementAndGet2 >= 0, "Less than 0 remaining futures");
                            if (decrementAndGet2 != 0) {
                                return;
                            }
                            List<V> list2 = this.mValues;
                            if (list2 != null) {
                                completer = this.mResultNotifier;
                                arrayList = new ArrayList(list2);
                            }
                        } catch (CancellationException unused) {
                            if (this.mAllMustSucceed) {
                                cancel(false);
                            }
                            int decrementAndGet3 = this.mRemaining.decrementAndGet();
                            Preconditions.checkState(decrementAndGet3 >= 0, "Less than 0 remaining futures");
                            if (decrementAndGet3 != 0) {
                                return;
                            }
                            List<V> list3 = this.mValues;
                            if (list3 != null) {
                                completer = this.mResultNotifier;
                                arrayList = new ArrayList(list3);
                            }
                        }
                    } catch (RuntimeException e3) {
                        if (this.mAllMustSucceed) {
                            this.mResultNotifier.setException(e3);
                        }
                        int decrementAndGet4 = this.mRemaining.decrementAndGet();
                        Preconditions.checkState(decrementAndGet4 >= 0, "Less than 0 remaining futures");
                        if (decrementAndGet4 != 0) {
                            return;
                        }
                        List<V> list4 = this.mValues;
                        if (list4 != null) {
                            completer = this.mResultNotifier;
                            arrayList = new ArrayList(list4);
                        }
                    }
                } catch (ExecutionException e4) {
                    if (this.mAllMustSucceed) {
                        this.mResultNotifier.setException(e4.getCause());
                    }
                    int decrementAndGet5 = this.mRemaining.decrementAndGet();
                    Preconditions.checkState(decrementAndGet5 >= 0, "Less than 0 remaining futures");
                    if (decrementAndGet5 != 0) {
                        return;
                    }
                    List<V> list5 = this.mValues;
                    if (list5 != null) {
                        completer = this.mResultNotifier;
                        arrayList = new ArrayList(list5);
                    }
                }
                if (decrementAndGet == 0) {
                    List<V> list6 = this.mValues;
                    if (list6 != null) {
                        completer = this.mResultNotifier;
                        arrayList = new ArrayList(list6);
                        completer.set(arrayList);
                        return;
                    }
                    Preconditions.checkState(isDone());
                    return;
                }
                return;
            } catch (Throwable th) {
                int decrementAndGet6 = this.mRemaining.decrementAndGet();
                Preconditions.checkState(decrementAndGet6 >= 0, "Less than 0 remaining futures");
                if (decrementAndGet6 == 0) {
                    List<V> list7 = this.mValues;
                    if (list7 != null) {
                        this.mResultNotifier.set(new ArrayList(list7));
                    } else {
                        Preconditions.checkState(isDone());
                    }
                }
                throw th;
            }
        }
        Preconditions.checkState(this.mAllMustSucceed, "Future was done before all dependencies completed");
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public List<V> get() throws InterruptedException, ExecutionException {
        callAllGets();
        return this.mResult.get();
    }

    @Override // java.util.concurrent.Future
    public List<V> get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mResult.get(j2, timeUnit);
    }
}
