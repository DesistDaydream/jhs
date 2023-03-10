package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class AutoCloser {
    public final long mAutoCloseTimeoutInMs;
    @Nullable
    @GuardedBy("mLock")
    public SupportSQLiteDatabase mDelegateDatabase;
    @NonNull
    public final Executor mExecutor;
    @Nullable
    private SupportSQLiteOpenHelper mDelegateOpenHelper = null;
    @NonNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    @Nullable
    public Runnable mOnAutoCloseCallback = null;
    @NonNull
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    public int mRefCount = 0;
    @GuardedBy("mLock")
    public long mLastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
    private boolean mManuallyClosed = false;
    private final Runnable mExecuteAutoCloser = new Runnable() { // from class: androidx.room.AutoCloser.1
        @Override // java.lang.Runnable
        public void run() {
            AutoCloser autoCloser = AutoCloser.this;
            autoCloser.mExecutor.execute(autoCloser.mAutoCloser);
        }
    };
    @NonNull
    public final Runnable mAutoCloser = new Runnable() { // from class: androidx.room.AutoCloser.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (AutoCloser.this.mLock) {
                long uptimeMillis = SystemClock.uptimeMillis();
                AutoCloser autoCloser = AutoCloser.this;
                if (uptimeMillis - autoCloser.mLastDecrementRefCountTimeStamp < autoCloser.mAutoCloseTimeoutInMs) {
                    return;
                }
                if (autoCloser.mRefCount != 0) {
                    return;
                }
                Runnable runnable = autoCloser.mOnAutoCloseCallback;
                if (runnable != null) {
                    runnable.run();
                    SupportSQLiteDatabase supportSQLiteDatabase = AutoCloser.this.mDelegateDatabase;
                    if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                        try {
                            AutoCloser.this.mDelegateDatabase.close();
                        } catch (IOException e2) {
                            SneakyThrow.reThrow(e2);
                        }
                        AutoCloser.this.mDelegateDatabase = null;
                    }
                    return;
                }
                throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            }
        }
    };

    public AutoCloser(long autoCloseTimeoutAmount, @NonNull TimeUnit autoCloseTimeUnit, @NonNull Executor autoCloseExecutor) {
        this.mAutoCloseTimeoutInMs = autoCloseTimeUnit.toMillis(autoCloseTimeoutAmount);
        this.mExecutor = autoCloseExecutor;
    }

    public void closeDatabaseIfOpen() throws IOException {
        synchronized (this.mLock) {
            this.mManuallyClosed = true;
            SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegateDatabase;
            if (supportSQLiteDatabase != null) {
                supportSQLiteDatabase.close();
            }
            this.mDelegateDatabase = null;
        }
    }

    public void decrementCountAndScheduleClose() {
        synchronized (this.mLock) {
            int i2 = this.mRefCount;
            if (i2 > 0) {
                int i3 = i2 - 1;
                this.mRefCount = i3;
                if (i3 == 0) {
                    if (this.mDelegateDatabase == null) {
                        return;
                    }
                    this.mHandler.postDelayed(this.mExecuteAutoCloser, this.mAutoCloseTimeoutInMs);
                }
                return;
            }
            throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
        }
    }

    @Nullable
    public <V> V executeRefCountingFunction(@NonNull Function<SupportSQLiteDatabase, V> function) {
        try {
            return function.apply(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    @Nullable
    public SupportSQLiteDatabase getDelegateDatabase() {
        SupportSQLiteDatabase supportSQLiteDatabase;
        synchronized (this.mLock) {
            supportSQLiteDatabase = this.mDelegateDatabase;
        }
        return supportSQLiteDatabase;
    }

    @VisibleForTesting
    public int getRefCountForTest() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mRefCount;
        }
        return i2;
    }

    @NonNull
    public SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.mLock) {
            this.mHandler.removeCallbacks(this.mExecuteAutoCloser);
            this.mRefCount++;
            if (!this.mManuallyClosed) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    return this.mDelegateDatabase;
                }
                SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.mDelegateOpenHelper;
                if (supportSQLiteOpenHelper != null) {
                    SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
                    this.mDelegateDatabase = writableDatabase;
                    return writableDatabase;
                }
                throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            }
            throw new IllegalStateException("Attempting to open already closed database.");
        }
    }

    public void init(@NonNull SupportSQLiteOpenHelper delegateOpenHelper) {
        if (this.mDelegateOpenHelper != null) {
            Log.e(Room.LOG_TAG, "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        } else {
            this.mDelegateOpenHelper = delegateOpenHelper;
        }
    }

    public boolean isActive() {
        return !this.mManuallyClosed;
    }

    public void setAutoCloseCallback(Runnable onAutoClose) {
        this.mOnAutoCloseCallback = onAutoClose;
    }
}
