package androidx.room;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class RoomTrackingLiveData<T> extends LiveData<T> {
    public final Callable<T> mComputeFunction;
    private final InvalidationLiveDataContainer mContainer;
    public final RoomDatabase mDatabase;
    public final boolean mInTransaction;
    public final InvalidationTracker.Observer mObserver;
    public final AtomicBoolean mInvalid = new AtomicBoolean(true);
    public final AtomicBoolean mComputing = new AtomicBoolean(false);
    public final AtomicBoolean mRegisteredObserver = new AtomicBoolean(false);
    public final Runnable mRefreshRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.1
        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            boolean z;
            if (RoomTrackingLiveData.this.mRegisteredObserver.compareAndSet(false, true)) {
                RoomTrackingLiveData.this.mDatabase.getInvalidationTracker().addWeakObserver(RoomTrackingLiveData.this.mObserver);
            }
            do {
                if (RoomTrackingLiveData.this.mComputing.compareAndSet(false, true)) {
                    T t = null;
                    z = false;
                    while (RoomTrackingLiveData.this.mInvalid.compareAndSet(true, false)) {
                        try {
                            try {
                                t = RoomTrackingLiveData.this.mComputeFunction.call();
                                z = true;
                            } catch (Exception e2) {
                                throw new RuntimeException("Exception while computing database live data.", e2);
                            }
                        } finally {
                            RoomTrackingLiveData.this.mComputing.set(false);
                        }
                    }
                    if (z) {
                        RoomTrackingLiveData.this.postValue(t);
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
            } while (RoomTrackingLiveData.this.mInvalid.get());
        }
    };
    public final Runnable mInvalidationRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.2
        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            boolean hasActiveObservers = RoomTrackingLiveData.this.hasActiveObservers();
            if (RoomTrackingLiveData.this.mInvalid.compareAndSet(false, true) && hasActiveObservers) {
                RoomTrackingLiveData.this.getQueryExecutor().execute(RoomTrackingLiveData.this.mRefreshRunnable);
            }
        }
    };

    @SuppressLint({"RestrictedApi"})
    public RoomTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, boolean inTransaction, Callable<T> computeFunction, String[] tableNames) {
        this.mDatabase = database;
        this.mInTransaction = inTransaction;
        this.mComputeFunction = computeFunction;
        this.mContainer = container;
        this.mObserver = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RoomTrackingLiveData.3
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NonNull Set<String> tables) {
                ArchTaskExecutor.getInstance().executeOnMainThread(RoomTrackingLiveData.this.mInvalidationRunnable);
            }
        };
    }

    public Executor getQueryExecutor() {
        if (this.mInTransaction) {
            return this.mDatabase.getTransactionExecutor();
        }
        return this.mDatabase.getQueryExecutor();
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }
}
