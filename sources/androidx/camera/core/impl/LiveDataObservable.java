package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import e.j.c.a.a.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class LiveDataObservable<T> implements Observable<T> {
    public final MutableLiveData<Result<T>> mLiveData = new MutableLiveData<>();
    @GuardedBy("mObservers")
    private final Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> mObservers = new HashMap();

    /* loaded from: classes.dex */
    public static final class LiveDataObserverAdapter<T> implements Observer<Result<T>> {
        public final AtomicBoolean mActive = new AtomicBoolean(true);
        public final Executor mExecutor;
        public final Observable.Observer<? super T> mObserver;

        public LiveDataObserverAdapter(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
            this.mExecutor = executor;
            this.mObserver = observer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(Result result) {
            if (this.mActive.get()) {
                if (result.completedSuccessfully()) {
                    this.mObserver.onNewData((Object) result.getValue());
                    return;
                }
                Preconditions.checkNotNull(result.getError());
                this.mObserver.onError(result.getError());
            }
        }

        public void disable() {
            this.mActive.set(false);
        }

        @Override // androidx.lifecycle.Observer
        public /* bridge */ /* synthetic */ void onChanged(@NonNull Object obj) {
            onChanged((Result) ((Result) obj));
        }

        public void onChanged(@NonNull final Result<T> result) {
            this.mExecutor.execute(new Runnable() { // from class: c.b.b.b2.o
                @Override // java.lang.Runnable
                public final void run() {
                    LiveDataObservable.LiveDataObserverAdapter.this.b(result);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static final class Result<T> {
        @Nullable
        private final Throwable mError;
        @Nullable
        private final T mValue;

        private Result(@Nullable T t, @Nullable Throwable th) {
            this.mValue = t;
            this.mError = th;
        }

        public static <T> Result<T> fromError(@NonNull Throwable th) {
            return new Result<>(null, (Throwable) Preconditions.checkNotNull(th));
        }

        public static <T> Result<T> fromValue(@Nullable T t) {
            return new Result<>(t, null);
        }

        public boolean completedSuccessfully() {
            return this.mError == null;
        }

        @Nullable
        public Throwable getError() {
            return this.mError;
        }

        @Nullable
        public T getValue() {
            if (completedSuccessfully()) {
                return this.mValue;
            }
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[Result: <");
            if (completedSuccessfully()) {
                str = "Value: " + this.mValue;
            } else {
                str = "Error: " + this.mError;
            }
            sb.append(str);
            sb.append(">]");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObserverAdapter liveDataObserverAdapter2) {
        if (liveDataObserverAdapter != null) {
            this.mLiveData.removeObserver(liveDataObserverAdapter);
        }
        this.mLiveData.observeForever(liveDataObserverAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(CallbackToFutureAdapter.Completer completer) {
        Result<T> value = this.mLiveData.getValue();
        if (value == null) {
            completer.setException(new IllegalStateException("Observable has not yet been initialized with a value."));
        } else if (value.completedSuccessfully()) {
            completer.set(value.getValue());
        } else {
            Preconditions.checkNotNull(value.getError());
            completer.setException(value.getError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ Object f(final CallbackToFutureAdapter.Completer completer) throws Exception {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: c.b.b.b2.q
            @Override // java.lang.Runnable
            public final void run() {
                LiveDataObservable.this.d(completer);
            }
        });
        return this + " [fetch@" + SystemClock.uptimeMillis() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(LiveDataObserverAdapter liveDataObserverAdapter) {
        this.mLiveData.removeObserver(liveDataObserverAdapter);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
        synchronized (this.mObservers) {
            final LiveDataObserverAdapter<T> liveDataObserverAdapter = this.mObservers.get(observer);
            if (liveDataObserverAdapter != null) {
                liveDataObserverAdapter.disable();
            }
            final LiveDataObserverAdapter<T> liveDataObserverAdapter2 = new LiveDataObserverAdapter<>(executor, observer);
            this.mObservers.put(observer, liveDataObserverAdapter2);
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: c.b.b.b2.p
                @Override // java.lang.Runnable
                public final void run() {
                    LiveDataObservable.this.b(liveDataObserverAdapter, liveDataObserverAdapter2);
                }
            });
        }
    }

    @Override // androidx.camera.core.impl.Observable
    @NonNull
    public a<T> fetchData() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: c.b.b.b2.r
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return LiveDataObservable.this.f(completer);
            }
        });
    }

    @NonNull
    public LiveData<Result<T>> getLiveData() {
        return this.mLiveData;
    }

    public void postError(@NonNull Throwable th) {
        this.mLiveData.postValue(Result.fromError(th));
    }

    public void postValue(@Nullable T t) {
        this.mLiveData.postValue(Result.fromValue(t));
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(@NonNull Observable.Observer<? super T> observer) {
        synchronized (this.mObservers) {
            final LiveDataObserverAdapter<T> remove = this.mObservers.remove(observer);
            if (remove != null) {
                remove.disable();
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: c.b.b.b2.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveDataObservable.this.h(remove);
                    }
                });
            }
        }
    }
}
