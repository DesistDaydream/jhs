package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    @VisibleForTesting
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";
    @VisibleForTesting
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    @Nullable
    public AutoCloser mAutoCloser;
    public volatile SupportSQLiteStatement mCleanupStatement;
    public final RoomDatabase mDatabase;
    private volatile boolean mInitialized;
    private final InvalidationLiveDataContainer mInvalidationLiveDataContainer;
    private MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
    private ObservedTableTracker mObservedTableTracker;
    @SuppressLint({"RestrictedApi"})
    @VisibleForTesting
    public final SafeIterableMap<Observer, ObserverWrapper> mObserverMap;
    public AtomicBoolean mPendingRefresh;
    @VisibleForTesting
    public Runnable mRefreshRunnable;
    @NonNull
    public final HashMap<String, Integer> mTableIdLookup;
    public final String[] mTableNames;
    @NonNull
    private Map<String, Set<String>> mViewTables;

    /* loaded from: classes.dex */
    public static class ObservedTableTracker {
        public static final int ADD = 1;
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        public boolean mNeedsSync;
        public boolean mPendingSync;
        public final long[] mTableObservers;
        public final int[] mTriggerStateChanges;
        public final boolean[] mTriggerStates;

        public ObservedTableTracker(int tableCount) {
            long[] jArr = new long[tableCount];
            this.mTableObservers = jArr;
            boolean[] zArr = new boolean[tableCount];
            this.mTriggerStates = zArr;
            this.mTriggerStateChanges = new int[tableCount];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        @Nullable
        public int[] getTablesToSync() {
            synchronized (this) {
                if (this.mNeedsSync && !this.mPendingSync) {
                    int length = this.mTableObservers.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = 1;
                        if (i2 < length) {
                            boolean z = this.mTableObservers[i2] > 0;
                            boolean[] zArr = this.mTriggerStates;
                            if (z != zArr[i2]) {
                                int[] iArr = this.mTriggerStateChanges;
                                if (!z) {
                                    i3 = 2;
                                }
                                iArr[i2] = i3;
                            } else {
                                this.mTriggerStateChanges[i2] = 0;
                            }
                            zArr[i2] = z;
                            i2++;
                        } else {
                            this.mPendingSync = true;
                            this.mNeedsSync = false;
                            return this.mTriggerStateChanges;
                        }
                    }
                }
                return null;
            }
        }

        public boolean onAdded(int... tableIds) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i2 : tableIds) {
                    long[] jArr = this.mTableObservers;
                    long j2 = jArr[i2];
                    jArr[i2] = 1 + j2;
                    if (j2 == 0) {
                        this.mNeedsSync = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        public boolean onRemoved(int... tableIds) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i2 : tableIds) {
                    long[] jArr = this.mTableObservers;
                    long j2 = jArr[i2];
                    jArr[i2] = j2 - 1;
                    if (j2 == 1) {
                        this.mNeedsSync = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        public void onSyncCompleted() {
            synchronized (this) {
                this.mPendingSync = false;
            }
        }

        public void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.mTriggerStates, false);
                this.mNeedsSync = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ObserverWrapper {
        public final Observer mObserver;
        private final Set<String> mSingleTableSet;
        public final int[] mTableIds;
        private final String[] mTableNames;

        public ObserverWrapper(Observer observer, int[] tableIds, String[] tableNames) {
            this.mObserver = observer;
            this.mTableIds = tableIds;
            this.mTableNames = tableNames;
            if (tableIds.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(tableNames[0]);
                this.mSingleTableSet = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.mSingleTableSet = null;
        }

        public void notifyByTableInvalidStatus(Set<Integer> invalidatedTablesIds) {
            int length = this.mTableIds.length;
            Set<String> set = null;
            for (int i2 = 0; i2 < length; i2++) {
                if (invalidatedTablesIds.contains(Integer.valueOf(this.mTableIds[i2]))) {
                    if (length == 1) {
                        set = this.mSingleTableSet;
                    } else {
                        if (set == null) {
                            set = new HashSet<>(length);
                        }
                        set.add(this.mTableNames[i2]);
                    }
                }
            }
            if (set != null) {
                this.mObserver.onInvalidated(set);
            }
        }

        public void notifyByTableNames(String[] tables) {
            Set<String> set = null;
            if (this.mTableNames.length == 1) {
                int length = tables.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (tables[i2].equalsIgnoreCase(this.mTableNames[0])) {
                        set = this.mSingleTableSet;
                        break;
                    } else {
                        i2++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : tables) {
                    String[] strArr = this.mTableNames;
                    int length2 = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length2) {
                            String str2 = strArr[i3];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i3++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.mObserver.onInvalidated(set);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class WeakObserver extends Observer {
        public final WeakReference<Observer> mDelegateRef;
        public final InvalidationTracker mTracker;

        public WeakObserver(InvalidationTracker tracker, Observer delegate) {
            super(delegate.mTables);
            this.mTracker = tracker;
            this.mDelegateRef = new WeakReference<>(delegate);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> tables) {
            Observer observer = this.mDelegateRef.get();
            if (observer == null) {
                this.mTracker.removeObserver(this);
            } else {
                observer.onInvalidated(tables);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase database, String... tableNames) {
        this(database, new HashMap(), Collections.emptyMap(), tableNames);
    }

    private static void appendTriggerName(StringBuilder builder, String tableName, String triggerType) {
        builder.append("`");
        builder.append("room_table_modification_trigger_");
        builder.append(tableName);
        builder.append("_");
        builder.append(triggerType);
        builder.append("`");
    }

    private static void beginTransactionInternal(SupportSQLiteDatabase database) {
        if (Build.VERSION.SDK_INT >= 16 && database.isWriteAheadLoggingEnabled()) {
            database.beginTransactionNonExclusive();
        } else {
            database.beginTransaction();
        }
    }

    private String[] resolveViews(String[] names) {
        HashSet hashSet = new HashSet();
        for (String str : names) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.mViewTables.containsKey(lowerCase)) {
                hashSet.addAll(this.mViewTables.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void startTrackingTable(SupportSQLiteDatabase writableDb, int tableId) {
        String[] strArr;
        writableDb.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + tableId + ", 0)");
        String str = this.mTableNames[tableId];
        StringBuilder sb = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            appendTriggerName(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append(UPDATE_TABLE_NAME);
            sb.append(" SET ");
            sb.append(INVALIDATED_COLUMN_NAME);
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append(TABLE_ID_COLUMN_NAME);
            sb.append(" = ");
            sb.append(tableId);
            sb.append(" AND ");
            sb.append(INVALIDATED_COLUMN_NAME);
            sb.append(" = 0");
            sb.append("; END");
            writableDb.execSQL(sb.toString());
        }
    }

    private void stopTrackingTable(SupportSQLiteDatabase writableDb, int tableId) {
        String[] strArr;
        String str = this.mTableNames[tableId];
        StringBuilder sb = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            appendTriggerName(sb, str, str2);
            writableDb.execSQL(sb.toString());
        }
    }

    private String[] validateAndResolveTableNames(String[] tableNames) {
        String[] resolveViews = resolveViews(tableNames);
        for (String str : resolveViews) {
            if (!this.mTableIdLookup.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return resolveViews;
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void addObserver(@NonNull Observer observer) {
        ObserverWrapper putIfAbsent;
        String[] resolveViews = resolveViews(observer.mTables);
        int[] iArr = new int[resolveViews.length];
        int length = resolveViews.length;
        for (int i2 = 0; i2 < length; i2++) {
            Integer num = this.mTableIdLookup.get(resolveViews[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
            } else {
                throw new IllegalArgumentException("There is no table with name " + resolveViews[i2]);
            }
        }
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, resolveViews);
        synchronized (this.mObserverMap) {
            putIfAbsent = this.mObserverMap.putIfAbsent(observer, observerWrapper);
        }
        if (putIfAbsent == null && this.mObservedTableTracker.onAdded(iArr)) {
            syncTriggers();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer observer) {
        addObserver(new WeakObserver(this, observer));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T> LiveData<T> createLiveData(String[] tableNames, Callable<T> computeFunction) {
        return createLiveData(tableNames, false, computeFunction);
    }

    public boolean ensureInitialization() {
        if (this.mDatabase.isOpen()) {
            if (!this.mInitialized) {
                this.mDatabase.getOpenHelper().getWritableDatabase();
            }
            if (this.mInitialized) {
                return true;
            }
            Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
            return false;
        }
        return false;
    }

    public void internalInit(SupportSQLiteDatabase database) {
        synchronized (this) {
            if (this.mInitialized) {
                Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers(database);
            this.mCleanupStatement = database.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.mInitialized = true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting(otherwise = 3)
    public void notifyObserversByTableNames(String... tables) {
        synchronized (this.mObserverMap) {
            Iterator<Map.Entry<Observer, ObserverWrapper>> it = this.mObserverMap.iterator();
            while (it.hasNext()) {
                Map.Entry<Observer, ObserverWrapper> next = it.next();
                if (!next.getKey().isRemote()) {
                    next.getValue().notifyByTableNames(tables);
                }
            }
        }
    }

    public void onAutoCloseCallback() {
        synchronized (this) {
            this.mInitialized = false;
            this.mObservedTableTracker.resetTriggerState();
        }
    }

    public void refreshVersionsAsync() {
        if (this.mPendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.mAutoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers();
        this.mRefreshRunnable.run();
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void removeObserver(@NonNull final Observer observer) {
        ObserverWrapper remove;
        synchronized (this.mObserverMap) {
            remove = this.mObserverMap.remove(observer);
        }
        if (remove == null || !this.mObservedTableTracker.onRemoved(remove.mTableIds)) {
            return;
        }
        syncTriggers();
    }

    public void setAutoCloser(AutoCloser autoCloser) {
        this.mAutoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new Runnable() { // from class: c.g.w0
            @Override // java.lang.Runnable
            public final void run() {
                InvalidationTracker.this.onAutoCloseCallback();
            }
        });
    }

    public void startMultiInstanceInvalidation(Context context, String name) {
        this.mMultiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, this, this.mDatabase.getQueryExecutor());
    }

    public void stopMultiInstanceInvalidation() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.mMultiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
            this.mMultiInstanceInvalidationClient = null;
        }
    }

    public void syncTriggers(SupportSQLiteDatabase database) {
        if (database.inTransaction()) {
            return;
        }
        while (true) {
            try {
                Lock closeLock = this.mDatabase.getCloseLock();
                closeLock.lock();
                try {
                    int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    int length = tablesToSync.length;
                    beginTransactionInternal(database);
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = tablesToSync[i2];
                        if (i3 == 1) {
                            startTrackingTable(database, i2);
                        } else if (i3 == 2) {
                            stopTrackingTable(database, i2);
                        }
                    }
                    database.setTransactionSuccessful();
                    database.endTransaction();
                    this.mObservedTableTracker.onSyncCompleted();
                } finally {
                    closeLock.unlock();
                }
            } catch (SQLiteException | IllegalStateException e2) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e2);
                return;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        this.mAutoCloser = null;
        this.mPendingRefresh = new AtomicBoolean(false);
        this.mInitialized = false;
        this.mObserverMap = new SafeIterableMap<>();
        this.mRefreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker.1
            private Set<Integer> checkUpdatedTable() {
                HashSet hashSet = new HashSet();
                Cursor query = InvalidationTracker.this.mDatabase.query(new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL));
                while (query.moveToNext()) {
                    try {
                        hashSet.add(Integer.valueOf(query.getInt(0)));
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                query.close();
                if (!hashSet.isEmpty()) {
                    InvalidationTracker.this.mCleanupStatement.executeUpdateDelete();
                }
                return hashSet;
            }

            /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
                if (r0 != null) goto L33;
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
                r0.decrementCountAndScheduleClose();
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
                if (r0 == null) goto L34;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x009b, code lost:
                if (r1 == null) goto L53;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x00a1, code lost:
                if (r1.isEmpty() != false) goto L52;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00a3, code lost:
                r0 = r5.this$0.mObserverMap;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00a7, code lost:
                monitor-enter(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
                r2 = r5.this$0.mObserverMap.iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x00b4, code lost:
                if (r2.hasNext() == false) goto L44;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x00b6, code lost:
                r2.next().getValue().notifyByTableInvalidStatus(r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x00c6, code lost:
                monitor-exit(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x00cb, code lost:
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r5 = this;
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.RoomDatabase r0 = r0.mDatabase
                    java.util.concurrent.locks.Lock r0 = r0.getCloseLock()
                    r0.lock()
                    r1 = 0
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    boolean r2 = r2.ensureInitialization()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    if (r2 != 0) goto L21
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.mAutoCloser
                    if (r0 == 0) goto L20
                    r0.decrementCountAndScheduleClose()
                L20:
                    return
                L21:
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    java.util.concurrent.atomic.AtomicBoolean r2 = r2.mPendingRefresh     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    r3 = 1
                    r4 = 0
                    boolean r2 = r2.compareAndSet(r3, r4)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    if (r2 != 0) goto L3a
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.mAutoCloser
                    if (r0 == 0) goto L39
                    r0.decrementCountAndScheduleClose()
                L39:
                    return
                L3a:
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    androidx.room.RoomDatabase r2 = r2.mDatabase     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    boolean r2 = r2.inTransaction()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    if (r2 == 0) goto L51
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.mAutoCloser
                    if (r0 == 0) goto L50
                    r0.decrementCountAndScheduleClose()
                L50:
                    return
                L51:
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    androidx.room.RoomDatabase r2 = r2.mDatabase     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    boolean r3 = r2.mWriteAheadLoggingEnabled     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    if (r3 == 0) goto L74
                    androidx.sqlite.db.SupportSQLiteOpenHelper r2 = r2.getOpenHelper()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    androidx.sqlite.db.SupportSQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    r2.beginTransactionNonExclusive()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    java.util.Set r1 = r5.checkUpdatedTable()     // Catch: java.lang.Throwable -> L6f
                    r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6f
                    r2.endTransaction()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    goto L78
                L6f:
                    r3 = move-exception
                    r2.endTransaction()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                    throw r3     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                L74:
                    java.util.Set r1 = r5.checkUpdatedTable()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87 java.lang.IllegalStateException -> L89
                L78:
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.mAutoCloser
                    if (r0 == 0) goto L9b
                L81:
                    r0.decrementCountAndScheduleClose()
                    goto L9b
                L85:
                    r1 = move-exception
                    goto Lcc
                L87:
                    r2 = move-exception
                    goto L8a
                L89:
                    r2 = move-exception
                L8a:
                    java.lang.String r3 = "ROOM"
                    java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
                    android.util.Log.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L85
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.mAutoCloser
                    if (r0 == 0) goto L9b
                    goto L81
                L9b:
                    if (r1 == 0) goto Lcb
                    boolean r0 = r1.isEmpty()
                    if (r0 != 0) goto Lcb
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r0 = r0.mObserverMap
                    monitor-enter(r0)
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> Lc8
                    androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r2 = r2.mObserverMap     // Catch: java.lang.Throwable -> Lc8
                    java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> Lc8
                Lb0:
                    boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> Lc8
                    if (r3 == 0) goto Lc6
                    java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> Lc8
                    java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> Lc8
                    java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> Lc8
                    androidx.room.InvalidationTracker$ObserverWrapper r3 = (androidx.room.InvalidationTracker.ObserverWrapper) r3     // Catch: java.lang.Throwable -> Lc8
                    r3.notifyByTableInvalidStatus(r1)     // Catch: java.lang.Throwable -> Lc8
                    goto Lb0
                Lc6:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc8
                    goto Lcb
                Lc8:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc8
                    throw r1
                Lcb:
                    return
                Lcc:
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.mAutoCloser
                    if (r0 == 0) goto Ld8
                    r0.decrementCountAndScheduleClose()
                Ld8:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.AnonymousClass1.run():void");
            }
        };
        this.mDatabase = database;
        this.mObservedTableTracker = new ObservedTableTracker(tableNames.length);
        this.mTableIdLookup = new HashMap<>();
        this.mViewTables = viewTables;
        this.mInvalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        int length = tableNames.length;
        this.mTableNames = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = tableNames[i2];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(i2));
            String str2 = shadowTablesMap.get(tableNames[i2]);
            if (str2 != null) {
                this.mTableNames[i2] = str2.toLowerCase(locale);
            } else {
                this.mTableNames[i2] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : shadowTablesMap.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = entry.getValue().toLowerCase(locale2);
            if (this.mTableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.mTableIdLookup;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] tableNames, boolean inTransaction, Callable<T> computeFunction) {
        return this.mInvalidationLiveDataContainer.create(validateAndResolveTableNames(tableNames), inTransaction, computeFunction);
    }

    /* loaded from: classes.dex */
    public static abstract class Observer {
        public final String[] mTables;

        public Observer(@NonNull String firstTable, String... rest) {
            String[] strArr = (String[]) Arrays.copyOf(rest, rest.length + 1);
            this.mTables = strArr;
            strArr[rest.length] = firstTable;
        }

        public boolean isRemote() {
            return false;
        }

        public abstract void onInvalidated(@NonNull Set<String> tables);

        public Observer(@NonNull String[] tables) {
            this.mTables = (String[]) Arrays.copyOf(tables, tables.length);
        }
    }

    public void syncTriggers() {
        if (this.mDatabase.isOpen()) {
            syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
        }
    }
}
