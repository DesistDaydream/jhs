package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import e.j.b.a.c;
import e.j.c.a.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class StateObservable<T> implements Observable<T> {
    private static final int INITIAL_VERSION = 0;
    private final AtomicReference<Object> mState;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private int mVersion = 0;
    @GuardedBy("mLock")
    private boolean mUpdating = false;
    @GuardedBy("mLock")
    private final Map<Observable.Observer<? super T>, ObserverWrapper<T>> mWrapperMap = new HashMap();
    @GuardedBy("mLock")
    private final CopyOnWriteArraySet<ObserverWrapper<T>> mNotifySet = new CopyOnWriteArraySet<>();

    @c
    /* loaded from: classes.dex */
    public static abstract class ErrorWrapper {
        @NonNull
        public static ErrorWrapper wrap(@NonNull Throwable th) {
            return new AutoValue_StateObservable_ErrorWrapper(th);
        }

        @NonNull
        public abstract Throwable getError();
    }

    /* loaded from: classes.dex */
    public static final class ObserverWrapper<T> implements Runnable {
        private static final Object NOT_SET = new Object();
        private static final int NO_VERSION = -1;
        private final Executor mExecutor;
        private final Observable.Observer<? super T> mObserver;
        private final AtomicReference<Object> mStateRef;
        private final AtomicBoolean mActive = new AtomicBoolean(true);
        private Object mLastState = NOT_SET;
        @GuardedBy("this")
        private int mLatestSignalledVersion = -1;
        @GuardedBy("this")
        private boolean mWrapperUpdating = false;

        public ObserverWrapper(@NonNull AtomicReference<Object> atomicReference, @NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
            this.mStateRef = atomicReference;
            this.mExecutor = executor;
            this.mObserver = observer;
        }

        public void close() {
            this.mActive.set(false);
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (!this.mActive.get()) {
                    this.mWrapperUpdating = false;
                    return;
                }
                Object obj = this.mStateRef.get();
                int i2 = this.mLatestSignalledVersion;
                while (true) {
                    if (!Objects.equals(this.mLastState, obj)) {
                        this.mLastState = obj;
                        if (obj instanceof ErrorWrapper) {
                            this.mObserver.onError(((ErrorWrapper) obj).getError());
                        } else {
                            this.mObserver.onNewData(obj);
                        }
                    }
                    synchronized (this) {
                        if (i2 == this.mLatestSignalledVersion || !this.mActive.get()) {
                            break;
                        }
                        obj = this.mStateRef.get();
                        i2 = this.mLatestSignalledVersion;
                    }
                }
                this.mWrapperUpdating = false;
            }
        }

        public void update(int i2) {
            synchronized (this) {
                if (!this.mActive.get()) {
                    return;
                }
                if (i2 <= this.mLatestSignalledVersion) {
                    return;
                }
                this.mLatestSignalledVersion = i2;
                if (this.mWrapperUpdating) {
                    return;
                }
                this.mWrapperUpdating = true;
                try {
                    this.mExecutor.execute(this);
                } finally {
                    synchronized (this) {
                    }
                }
            }
        }
    }

    public StateObservable(@Nullable Object obj, boolean z) {
        if (z) {
            Preconditions.checkArgument(obj instanceof Throwable, "Initial errors must be Throwable");
            this.mState = new AtomicReference<>(ErrorWrapper.wrap((Throwable) obj));
            return;
        }
        this.mState = new AtomicReference<>(obj);
    }

    @GuardedBy("mLock")
    private void removeObserverLocked(@NonNull Observable.Observer<? super T> observer) {
        ObserverWrapper<T> remove = this.mWrapperMap.remove(observer);
        if (remove != null) {
            remove.close();
            this.mNotifySet.remove(remove);
        }
    }

    private void updateStateInternal(@Nullable Object obj) {
        Iterator<ObserverWrapper<T>> it;
        int i2;
        synchronized (this.mLock) {
            if (Objects.equals(this.mState.getAndSet(obj), obj)) {
                return;
            }
            int i3 = this.mVersion + 1;
            this.mVersion = i3;
            if (this.mUpdating) {
                return;
            }
            this.mUpdating = true;
            Iterator<ObserverWrapper<T>> it2 = this.mNotifySet.iterator();
            while (true) {
                if (it2.hasNext()) {
                    it2.next().update(i3);
                } else {
                    synchronized (this.mLock) {
                        if (this.mVersion == i3) {
                            this.mUpdating = false;
                            return;
                        } else {
                            it = this.mNotifySet.iterator();
                            i2 = this.mVersion;
                        }
                    }
                    it2 = it;
                    i3 = i2;
                }
            }
        }
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
        ObserverWrapper<T> observerWrapper;
        synchronized (this.mLock) {
            removeObserverLocked(observer);
            observerWrapper = new ObserverWrapper<>(this.mState, executor, observer);
            this.mWrapperMap.put(observer, observerWrapper);
            this.mNotifySet.add(observerWrapper);
        }
        observerWrapper.update(0);
    }

    @Override // androidx.camera.core.impl.Observable
    @NonNull
    public a<T> fetchData() {
        Object obj = this.mState.get();
        if (obj instanceof ErrorWrapper) {
            return Futures.immediateFailedFuture(((ErrorWrapper) obj).getError());
        }
        return Futures.immediateFuture(obj);
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(@NonNull Observable.Observer<? super T> observer) {
        synchronized (this.mLock) {
            removeObserverLocked(observer);
        }
    }

    public void updateState(@Nullable T t) {
        updateStateInternal(t);
    }

    public void updateStateAsError(@NonNull Throwable th) {
        updateStateInternal(ErrorWrapper.wrap(th));
    }
}
