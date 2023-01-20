package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.room.FtsOptions;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import k.b.a.a.o.e;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDebug;

/* loaded from: classes4.dex */
public class SQLiteDatabase extends SQLiteClosable {
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    public static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final String KEY_ENCODING = "UTF-8";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "4.0.1";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private int mCacheFullWarnings;
    public Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    public long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    public int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static int sQueryLogTimeInMillis = 0;

    /* loaded from: classes4.dex */
    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    /* loaded from: classes4.dex */
    public interface LibraryLoader {
        void loadLibraries(String... strArr);
    }

    /* loaded from: classes4.dex */
    public enum SQLiteDatabaseTransactionType {
        Deferred,
        Immediate,
        Exclusive
    }

    /* loaded from: classes4.dex */
    public static class SyncUpdateInfo {
        public String deletedTable;
        public String foreignKey;
        public String masterTable;

        public SyncUpdateInfo(String str, String str2, String str3) {
            this.masterTable = str;
            this.deletedTable = str2;
            this.foreignKey = str3;
        }
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i2) {
        this(str, cursorFactory, i2, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, null);
    }

    private void beginTransactionWithListenerInternal(SQLiteTransactionListener sQLiteTransactionListener, SQLiteDatabaseTransactionType sQLiteDatabaseTransactionType) {
        lockForced();
        if (isOpen()) {
            try {
                if (this.mLock.getHoldCount() > 1) {
                    if (this.mInnerTransactionIsSuccessful) {
                        IllegalStateException illegalStateException = new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                        Log.e(TAG, "beginTransaction() failed", illegalStateException);
                        throw illegalStateException;
                    }
                    return;
                }
                if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Exclusive) {
                    execSQL("BEGIN EXCLUSIVE;");
                } else if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Immediate) {
                    execSQL("BEGIN IMMEDIATE;");
                } else if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Deferred) {
                    execSQL("BEGIN DEFERRED;");
                } else {
                    throw new IllegalArgumentException(String.format("%s is an unsupported transaction type", sQLiteDatabaseTransactionType));
                }
                this.mTransactionListener = sQLiteTransactionListener;
                this.mTransactionIsSuccessful = true;
                this.mInnerTransactionIsSuccessful = false;
                if (sQLiteTransactionListener != null) {
                    try {
                        sQLiteTransactionListener.onBegin();
                        return;
                    } catch (RuntimeException e2) {
                        execSQL("ROLLBACK;");
                        throw e2;
                    }
                }
                return;
            } catch (Throwable th) {
                unlockForced();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    private void checkLockHoldTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime - this.mLockAcquiredWallTime;
        int i2 = (j2 > 2000L ? 1 : (j2 == 2000L ? 0 : -1));
        if ((i2 >= 0 || Log.isLoggable(TAG, 2) || elapsedRealtime - this.mLastLockMessageTime >= 20000) && j2 > 300) {
            int threadCpuTimeNanos = (int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000);
            if (threadCpuTimeNanos > 100 || i2 > 0) {
                this.mLastLockMessageTime = elapsedRealtime;
                String str = "lock held on " + this.mPath + " for " + j2 + "ms. Thread time was " + threadCpuTimeNanos + "ms";
                if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE) {
                    Log.d(TAG, str, new Exception());
                } else {
                    Log.d(TAG, str);
                }
            }
        }
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        for (Map.Entry<SQLiteClosable, Object> entry : this.mPrograms.entrySet()) {
            SQLiteClosable key = entry.getKey();
            if (key != null) {
                key.onAllReferencesReleasedFromContainer();
            }
        }
    }

    private boolean containsNull(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, String str) {
        return openDatabase(MEMORY, str == null ? null : str.toCharArray(), cursorFactory, 268435456);
    }

    private native void dbclose();

    private native void dbopen(String str, int i2);

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            for (SQLiteCompiledSql sQLiteCompiledSql : this.mCompiledQueries.values()) {
                sQLiteCompiledSql.releaseSqlStatement();
            }
            this.mCompiledQueries.clear();
        }
    }

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    public static String findEditTable(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(32);
            int indexOf2 = str.indexOf(44);
            if (indexOf <= 0 || (indexOf >= indexOf2 && indexOf2 >= 0)) {
                return indexOf2 > 0 ? (indexOf2 < indexOf || indexOf < 0) ? str.substring(0, indexOf2) : str : str;
            }
            return str.substring(0, indexOf);
        }
        throw new IllegalStateException("Invalid tables");
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> arrayList = new ArrayList<>();
        synchronized (sActiveDatabases) {
            arrayList.addAll(sActiveDatabases.keySet());
        }
        return arrayList;
    }

    private byte[] getBytes(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        ByteBuffer encode = Charset.forName("UTF-8").encode(CharBuffer.wrap(cArr));
        byte[] bArr = new byte[encode.limit()];
        encode.get(bArr);
        return bArr;
    }

    public static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        String str;
        ArrayList<SQLiteDebug.DbStats> arrayList = new ArrayList<>();
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            SQLiteDatabase next = it.next();
            if (next != null && next.isOpen()) {
                int native_getDbLookaside = next.native_getDbLookaside();
                String path = next.getPath();
                int lastIndexOf = path.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                String substring = path.substring(lastIndexOf != -1 ? lastIndexOf + 1 : 0);
                ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(next);
                if (attachedDbs != null) {
                    for (int i2 = 0; i2 < attachedDbs.size(); i2++) {
                        Pair<String, String> pair = attachedDbs.get(i2);
                        long pragmaVal = getPragmaVal(next, ((String) pair.first) + ".page_count;");
                        if (i2 == 0) {
                            str = substring;
                        } else {
                            String str2 = "  (attached) " + ((String) pair.first);
                            if (((String) pair.second).trim().length() > 0) {
                                int lastIndexOf2 = ((String) pair.second).lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                sb.append(" : ");
                                sb.append(((String) pair.second).substring(lastIndexOf2 != -1 ? lastIndexOf2 + 1 : 0));
                                str2 = sb.toString();
                            }
                            str = str2;
                            native_getDbLookaside = 0;
                        }
                        if (pragmaVal > 0) {
                            arrayList.add(new SQLiteDebug.DbStats(str, pragmaVal, next.getPageSize(), native_getDbLookaside));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private String getPathForLogs() {
        String str = this.mPathForLogs;
        if (str != null) {
            return str;
        }
        String str2 = this.mPath;
        if (str2 == null) {
            return null;
        }
        if (str2.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
        } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }

    private static long getPragmaVal(SQLiteDatabase sQLiteDatabase, String str) {
        SQLiteStatement sQLiteStatement;
        if (sQLiteDatabase.isOpen()) {
            SQLiteStatement sQLiteStatement2 = null;
            try {
                sQLiteStatement = new SQLiteStatement(sQLiteDatabase, "PRAGMA " + str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                return simpleQueryForLong;
            } catch (Throwable th2) {
                th = th2;
                sQLiteStatement2 = sQLiteStatement;
                if (sQLiteStatement2 != null) {
                    sQLiteStatement2.close();
                }
                throw th;
            }
        }
        return 0L;
    }

    private Pair<Boolean, String> getResultFromPragma(String str) {
        Cursor rawQuery = rawQuery(str, new Object[0]);
        if (rawQuery == null) {
            return new Pair<>(Boolean.FALSE, "");
        }
        rawQuery.moveToFirst();
        String string = rawQuery.getString(0);
        rawQuery.close();
        return new Pair<>(Boolean.TRUE, string);
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void key(byte[] bArr) throws SQLException;

    private void keyDatabase(SQLiteDatabaseHook sQLiteDatabaseHook, Runnable runnable) {
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.preKey(this);
        }
        if (runnable != null) {
            runnable.run();
        }
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = getTime();
        }
        try {
            Cursor rawQuery = rawQuery("select count(*) from sqlite_master;", new String[0]);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                rawQuery.getInt(0);
                rawQuery.close();
            }
        } catch (RuntimeException e2) {
            Log.e(TAG, e2.getMessage(), e2);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void key_mutf8(char[] cArr) throws SQLException;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3 */
    private static void loadICUData(Context context, File file) {
        OutputStream outputStream;
        ZipInputStream zipInputStream;
        OutputStream outputStream2;
        File file2 = new File(file, FtsOptions.TOKENIZER_ICU);
        File file3 = new File(file2, "icudt46l.dat");
        ZipInputStream zipInputStream2 = null;
        try {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (file3.exists()) {
                outputStream2 = null;
            } else {
                zipInputStream = new ZipInputStream(context.getAssets().open("icudt46l.zip"));
                try {
                    try {
                        zipInputStream.getNextEntry();
                        OutputStream fileOutputStream = new FileOutputStream(file3);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = zipInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            zipInputStream2 = zipInputStream;
                            outputStream2 = fileOutputStream;
                        } catch (Exception e2) {
                            zipInputStream2 = fileOutputStream;
                            e = e2;
                            Log.e(TAG, "Error copying icu dat file", e);
                            if (file3.exists()) {
                                file3.delete();
                            }
                            throw new RuntimeException(e);
                        } catch (Throwable th) {
                            zipInputStream2 = zipInputStream;
                            outputStream = fileOutputStream;
                            th = th;
                            if (zipInputStream2 != null) {
                                try {
                                    zipInputStream2.close();
                                } catch (IOException e3) {
                                    Log.e(TAG, "Error in closing streams IO streams after expanding ICU dat file", e3);
                                    throw new RuntimeException(e3);
                                }
                            }
                            if (outputStream != null) {
                                outputStream.flush();
                                outputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = zipInputStream2;
                        zipInputStream2 = zipInputStream;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            }
            if (zipInputStream2 != null) {
                try {
                    zipInputStream2.close();
                } catch (IOException e5) {
                    Log.e(TAG, "Error in closing streams IO streams after expanding ICU dat file", e5);
                    throw new RuntimeException(e5);
                }
            }
            if (outputStream2 != null) {
                outputStream2.flush();
                outputStream2.close();
            }
        } catch (Exception e6) {
            e = e6;
            zipInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public static synchronized void loadLibs(Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }

    private native int native_getDbLookaside();

    private native void native_key(char[] cArr) throws SQLException;

    private native void native_rawExecSQL(String str);

    private native void native_rekey(String str) throws SQLException;

    private native int native_status(int i2, boolean z);

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i2) {
        return openDatabase(str, str2, cursorFactory, i2, (SQLiteDatabaseHook) null);
    }

    private void openDatabaseInternal(final char[] cArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        final byte[] bytes = getBytes(cArr);
        dbopen(this.mPath, this.mFlags);
        try {
            try {
                keyDatabase(sQLiteDatabaseHook, new Runnable() { // from class: net.sqlcipher.database.SQLiteDatabase.2
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] bArr = bytes;
                        if (bArr == null || bArr.length <= 0) {
                            return;
                        }
                        SQLiteDatabase.this.key(bArr);
                    }
                });
                if (bytes == null || bytes.length <= 0) {
                    return;
                }
            } catch (RuntimeException e2) {
                if (containsNull(cArr)) {
                    keyDatabase(sQLiteDatabaseHook, new Runnable() { // from class: net.sqlcipher.database.SQLiteDatabase.3
                        @Override // java.lang.Runnable
                        public void run() {
                            char[] cArr2 = cArr;
                            if (cArr2 != null) {
                                SQLiteDatabase.this.key_mutf8(cArr2);
                            }
                        }
                    });
                    if (bytes != null && bytes.length > 0) {
                        rekey(bytes);
                    }
                    if (bytes == null || bytes.length <= 0) {
                        return;
                    }
                } else {
                    throw e2;
                }
            }
            Arrays.fill(bytes, (byte) 0);
        } catch (Throwable th) {
            dbclose();
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            if (bytes != null && bytes.length > 0) {
                Arrays.fill(bytes, (byte) 0);
            }
            throw th;
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openOrCreateDatabase(file, str, cursorFactory, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    private native void rekey(byte[] bArr) throws SQLException;

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            checkLockHoldTime();
        }
        this.mLock.unlock();
    }

    private boolean yieldIfContendedHelper(boolean z, long j2) {
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
        endTransaction();
        if (z && isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
        }
        if (j2 > 0) {
            while (j2 > 0) {
                try {
                    Thread.sleep(j2 < 1000 ? j2 : 1000L);
                } catch (InterruptedException unused) {
                    Thread.interrupted();
                }
                j2 -= 1000;
                if (this.mLock.getQueueLength() == 0) {
                    break;
                }
            }
        }
        beginTransactionWithListener(sQLiteTransactionListener);
        return true;
    }

    public void addSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.put(sQLiteClosable, null);
        } finally {
            unlock();
        }
    }

    public void addToCompiledQueries(String str, SQLiteCompiledSql sQLiteCompiledSql) {
        if (this.mMaxSqlCacheSize == 0) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                Log.v(TAG, "|NOT adding_sql_to_cache|" + getPath() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str);
                return;
            }
            return;
        }
        synchronized (this.mCompiledQueries) {
            if (this.mCompiledQueries.get(str) != null) {
                return;
            }
            if (this.mCompiledQueries.size() == this.mMaxSqlCacheSize) {
                int i2 = this.mCacheFullWarnings + 1;
                this.mCacheFullWarnings = i2;
                if (i2 == 1) {
                    Log.w(TAG, "Reached MAX size for compiled-sql statement cache for database " + getPath() + "; i.e., NO space for this sql statement in cache: " + str + ". Please change your sql statements to use '?' for bindargs, instead of using actual values");
                }
            } else {
                this.mCompiledQueries.put(str, sQLiteCompiledSql);
                if (SQLiteDebug.DEBUG_SQL_CACHE) {
                    Log.v(TAG, "|adding_sql_to_cache|" + getPath() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.mCompiledQueries.size() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str);
                }
            }
        }
    }

    public void beginTransaction() {
        beginTransactionWithListener(null);
    }

    public void beginTransactionNonExclusive() {
        beginTransactionWithListenerInternal(null, SQLiteDatabaseTransactionType.Immediate);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Exclusive);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Immediate);
    }

    public void changePassword(String str) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (str != null) {
            byte[] bytes = getBytes(str.toCharArray());
            rekey(bytes);
            Arrays.fill(bytes, (byte) 0);
        }
    }

    public void close() {
        if (isOpen()) {
            lock();
            try {
                closeClosable();
                onAllReferencesReleased();
            } finally {
                unlock();
            }
        }
    }

    public SQLiteStatement compileStatement(String str) throws SQLException {
        lock();
        if (isOpen()) {
            try {
                return new SQLiteStatement(this, str);
            } finally {
                unlock();
            }
        }
        throw new IllegalStateException("database not open");
    }

    public int delete(String str, String str2, String[] strArr) {
        String str3;
        lock();
        if (isOpen()) {
            SQLiteStatement sQLiteStatement = null;
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DELETE FROM ");
                    sb.append(str);
                    if (TextUtils.isEmpty(str2)) {
                        str3 = "";
                    } else {
                        str3 = " WHERE " + str2;
                    }
                    sb.append(str3);
                    sQLiteStatement = compileStatement(sb.toString());
                    if (strArr != null) {
                        int length = strArr.length;
                        int i2 = 0;
                        while (i2 < length) {
                            int i3 = i2 + 1;
                            DatabaseUtils.bindObjectToProgram(sQLiteStatement, i3, strArr[i2]);
                            i2 = i3;
                        }
                    }
                    sQLiteStatement.execute();
                    return lastChangeCount();
                } catch (SQLiteDatabaseCorruptException e2) {
                    onCorruption();
                    throw e2;
                }
            } finally {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
            }
        }
        throw new IllegalStateException("database not open");
    }

    public void disableWriteAheadLogging() {
        if (!inTransaction()) {
            rawExecSQL("PRAGMA journal_mode = DELETE;");
            return;
        }
        throw new IllegalStateException("Write Ahead Logging cannot be disabled while in a transaction");
    }

    public boolean enableWriteAheadLogging() {
        if (!inTransaction()) {
            ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(this);
            if ((attachedDbs != null && attachedDbs.size() > 1) || isReadOnly() || getPath().equals(MEMORY)) {
                return false;
            }
            rawExecSQL("PRAGMA journal_mode = WAL;");
            return true;
        }
        throw new IllegalStateException("Write Ahead Logging cannot be enabled while in a transaction");
    }

    public void endTransaction() {
        if (isOpen()) {
            if (this.mLock.isHeldByCurrentThread()) {
                try {
                    if (this.mInnerTransactionIsSuccessful) {
                        this.mInnerTransactionIsSuccessful = false;
                    } else {
                        this.mTransactionIsSuccessful = false;
                    }
                    if (this.mLock.getHoldCount() != 1) {
                        return;
                    }
                    SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
                    if (sQLiteTransactionListener != null) {
                        try {
                            if (this.mTransactionIsSuccessful) {
                                sQLiteTransactionListener.onCommit();
                            } else {
                                sQLiteTransactionListener.onRollback();
                            }
                        } catch (RuntimeException e2) {
                            e = e2;
                            this.mTransactionIsSuccessful = false;
                        }
                    }
                    e = null;
                    if (this.mTransactionIsSuccessful) {
                        execSQL(COMMIT_SQL);
                    } else {
                        try {
                            execSQL("ROLLBACK;");
                            if (e != null) {
                                throw e;
                            }
                        } catch (SQLException unused) {
                            Log.d(TAG, "exception during rollback, maybe the DB previously performed an auto-rollback");
                        }
                    }
                    return;
                } finally {
                    this.mTransactionListener = null;
                    unlockForced();
                }
            }
            throw new IllegalStateException("no transaction pending");
        }
        throw new IllegalStateException("database not open");
    }

    public void execSQL(String str) throws SQLException {
        SystemClock.uptimeMillis();
        lock();
        try {
            if (isOpen()) {
                try {
                    native_execSQL(str);
                    return;
                } catch (SQLiteDatabaseCorruptException e2) {
                    onCorruption();
                    throw e2;
                }
            }
            throw new IllegalStateException("database not open");
        } finally {
            unlock();
        }
    }

    public void finalize() {
        if (isOpen()) {
            Log.e(TAG, "close() was never explicitly called on database '" + this.mPath + "' ", this.mStackTrace);
            closeClosable();
            onAllReferencesReleased();
        }
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return getAttachedDbs(this);
    }

    public SQLiteCompiledSql getCompiledStatementForSql(String str) {
        synchronized (this.mCompiledQueries) {
            if (this.mMaxSqlCacheSize == 0) {
                if (SQLiteDebug.DEBUG_SQL_CACHE) {
                    Log.v(TAG, "|cache NOT found|" + getPath());
                }
                return null;
            }
            SQLiteCompiledSql sQLiteCompiledSql = this.mCompiledQueries.get(str);
            boolean z = sQLiteCompiledSql != null;
            if (z) {
                this.mNumCacheHits++;
            } else {
                this.mNumCacheMisses++;
            }
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                Log.v(TAG, "|cache_stats|" + getPath() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.mCompiledQueries.size() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.mNumCacheHits + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.mNumCacheMisses + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + z + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.mTimeOpened + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.mTimeClosed + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str);
            }
            return sQLiteCompiledSql;
        }
    }

    public synchronized int getMaxSqlCacheSize() {
        return this.mMaxSqlCacheSize;
    }

    public long getMaximumSize() {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        if (isOpen()) {
            try {
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA max_page_count;");
            } catch (Throwable th2) {
                sQLiteStatement = null;
                th = th2;
            }
            try {
                long simpleQueryForLong = sQLiteStatement.simpleQueryForLong() * getPageSize();
                sQLiteStatement.close();
                unlock();
                return simpleQueryForLong;
            } catch (Throwable th3) {
                th = th3;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    public long getPageSize() {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        if (isOpen()) {
            try {
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA page_size;");
            } catch (Throwable th2) {
                sQLiteStatement = null;
                th = th2;
            }
            try {
                long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                unlock();
                return simpleQueryForLong;
            } catch (Throwable th3) {
                th = th3;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    public final String getPath() {
        return this.mPath;
    }

    public SQLiteQueryStats getQueryStats(String str, Object[] objArr) {
        try {
            execSQL(String.format("CREATE TABLE tempstat AS %s", str), objArr);
            Cursor rawQuery = rawQuery("SELECT sum(payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (rawQuery == null) {
                return new SQLiteQueryStats(0L, 0L);
            }
            rawQuery.moveToFirst();
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            Cursor rawQuery2 = rawQuery("SELECT max(mx_payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (rawQuery2 == null) {
                return new SQLiteQueryStats(j2, 0L);
            }
            rawQuery2.moveToFirst();
            long j3 = rawQuery2.getLong(0);
            rawQuery2.close();
            execSQL("DROP TABLE tempstat;");
            return new SQLiteQueryStats(j2, j3);
        } catch (SQLiteException e2) {
            execSQL("DROP TABLE IF EXISTS tempstat;");
            throw e2;
        }
    }

    public Map<String, String> getSyncedTables() {
        HashMap hashMap;
        synchronized (this.mSyncUpdateInfo) {
            hashMap = new HashMap();
            for (String str : this.mSyncUpdateInfo.keySet()) {
                String str2 = this.mSyncUpdateInfo.get(str).deletedTable;
                if (str2 != null) {
                    hashMap.put(str, str2);
                }
            }
        }
        return hashMap;
    }

    public int getVersion() {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        if (isOpen()) {
            try {
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA user_version;");
            } catch (Throwable th2) {
                sQLiteStatement = null;
                th = th2;
            }
            try {
                int simpleQueryForLong = (int) sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                unlock();
                return simpleQueryForLong;
            } catch (Throwable th3) {
                th = th3;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException e2) {
            Log.e(TAG, "Error inserting <redacted values> into " + str, e2);
            return -1L;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i2) {
        Set<Map.Entry<String, Object>> set;
        if (isOpen()) {
            StringBuilder sb = new StringBuilder(152);
            sb.append("INSERT");
            sb.append(CONFLICT_VALUES[i2]);
            sb.append(" INTO ");
            sb.append(str);
            StringBuilder sb2 = new StringBuilder(40);
            int i3 = 0;
            SQLiteProgram sQLiteProgram = null;
            if (contentValues != null && contentValues.size() > 0) {
                set = contentValues.valueSet();
                sb.append('(');
                boolean z = false;
                for (Map.Entry<String, Object> entry : set) {
                    if (z) {
                        sb.append(", ");
                        sb2.append(", ");
                    }
                    sb.append(entry.getKey());
                    sb2.append(e.a);
                    z = true;
                }
                sb.append(')');
            } else {
                sb.append("(" + str2 + ") ");
                sb2.append("NULL");
                set = null;
            }
            sb.append(" VALUES(");
            sb.append((CharSequence) sb2);
            sb.append(");");
            lock();
            try {
                try {
                    SQLiteStatement compileStatement = compileStatement(sb.toString());
                    if (set != null) {
                        int size = set.size();
                        Iterator<Map.Entry<String, Object>> it = set.iterator();
                        while (i3 < size) {
                            i3++;
                            DatabaseUtils.bindObjectToProgram(compileStatement, i3, it.next().getValue());
                        }
                    }
                    compileStatement.execute();
                    long lastInsertRow = lastChangeCount() > 0 ? lastInsertRow() : -1L;
                    if (lastInsertRow == -1) {
                        Log.e(TAG, "Error inserting <redacted values> using <redacted sql> into " + str);
                    } else if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Inserting row " + lastInsertRow + " from <redacted values> using <redacted sql> into " + str);
                    }
                    if (compileStatement != null) {
                        compileStatement.close();
                    }
                    unlock();
                    return lastInsertRow;
                } catch (SQLiteDatabaseCorruptException e2) {
                    onCorruption();
                    throw e2;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    sQLiteProgram.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    public boolean isDatabaseIntegrityOk() {
        Pair<Boolean, String> resultFromPragma = getResultFromPragma("PRAGMA integrity_check;");
        return ((Boolean) resultFromPragma.first).booleanValue() ? ((String) resultFromPragma.second).equals("ok") : ((Boolean) resultFromPragma.first).booleanValue();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }

    public boolean isInCompiledSqlCache(String str) {
        boolean containsKey;
        synchronized (this.mCompiledQueries) {
            containsKey = this.mCompiledQueries.containsKey(str);
        }
        return containsKey;
    }

    public boolean isOpen() {
        return this.mNativeHandle != 0;
    }

    public boolean isReadOnly() {
        return (this.mFlags & 1) == 1;
    }

    public boolean isWriteAheadLoggingEnabled() {
        Pair<Boolean, String> resultFromPragma = getResultFromPragma("PRAGMA journal_mode;");
        return ((Boolean) resultFromPragma.first).booleanValue() ? ((String) resultFromPragma.second).equals("wal") : ((Boolean) resultFromPragma.first).booleanValue();
    }

    public native int lastChangeCount();

    public native long lastInsertRow();

    public void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }

    public void markTableSyncable(String str, String str2) {
        if (isOpen()) {
            markTableSyncable(str, "_id", str, str2);
            return;
        }
        throw new SQLiteException("database not open");
    }

    public native void native_execSQL(String str) throws SQLException;

    public native void native_setLocale(String str, int i2);

    public boolean needUpgrade(int i2) {
        return i2 > getVersion();
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    public void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    public void onCorruption() {
        Log.e(TAG, "Calling error handler for corrupt database (detected) " + this.mPath);
        this.mErrorHandler.onCorruption(this);
    }

    public void purgeFromCompiledSqlCache(String str) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(str);
        }
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (isOpen()) {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str));
        }
        throw new IllegalStateException("database not open");
    }

    public void rawExecSQL(String str) {
        SystemClock.uptimeMillis();
        lock();
        try {
            if (isOpen()) {
                try {
                    native_rawExecSQL(str);
                    return;
                } catch (SQLiteDatabaseCorruptException e2) {
                    onCorruption();
                    throw e2;
                }
            }
            throw new IllegalStateException("database not open");
        } finally {
            unlock();
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory(null, str, strArr, null);
    }

    /* JADX WARN: Finally extract failed */
    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        if (isOpen()) {
            long currentTimeMillis = this.mSlowQueryThreshold != -1 ? System.currentTimeMillis() : 0L;
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2);
            if (cursorFactory == null) {
                try {
                    cursorFactory = this.mFactory;
                } catch (Throwable th) {
                    if (this.mSlowQueryThreshold != -1) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 >= this.mSlowQueryThreshold) {
                            Log.v(TAG, "query (" + currentTimeMillis2 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is -1");
                        }
                    }
                    throw th;
                }
            }
            Cursor query = sQLiteDirectCursorDriver.query(cursorFactory, strArr);
            if (this.mSlowQueryThreshold != -1) {
                int count = query != null ? query.getCount() : -1;
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis3 >= this.mSlowQueryThreshold) {
                    Log.v(TAG, "query (" + currentTimeMillis3 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is " + count);
                }
            }
            return new CrossProcessCursorWrapper(query);
        }
        throw new IllegalStateException("database not open");
    }

    public void removeSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.remove(sQLiteClosable);
        } finally {
            unlock();
        }
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLException e2) {
            Log.e(TAG, "Error inserting <redacted values> into " + str, e2);
            return -1L;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }

    public void rowUpdated(String str, long j2) {
        SyncUpdateInfo syncUpdateInfo;
        synchronized (this.mSyncUpdateInfo) {
            syncUpdateInfo = this.mSyncUpdateInfo.get(str);
        }
        if (syncUpdateInfo != null) {
            execSQL("UPDATE " + syncUpdateInfo.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + syncUpdateInfo.foreignKey + " FROM " + str + " WHERE _id=" + j2 + ")");
        }
    }

    public void setForeignKeyConstraintsEnabled(boolean z) {
        if (!inTransaction()) {
            Object[] objArr = new Object[1];
            objArr[0] = z ? "ON" : "OFF";
            execSQL(String.format("PRAGMA foreign_keys = %s;", objArr));
            return;
        }
        throw new IllegalStateException("Foreign key constraints may not be changed while in a transaction");
    }

    public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
        } finally {
            unlock();
        }
    }

    public void setLockingEnabled(boolean z) {
        this.mLockingEnabled = z;
    }

    public synchronized void setMaxSqlCacheSize(int i2) {
        if (i2 <= 250 && i2 >= 0) {
            if (i2 >= this.mMaxSqlCacheSize) {
                this.mMaxSqlCacheSize = i2;
            } else {
                throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
            }
        } else {
            throw new IllegalStateException("expected value between 0 and 250");
        }
    }

    public long setMaximumSize(long j2) {
        lock();
        if (isOpen()) {
            SQLiteStatement sQLiteStatement = null;
            try {
                long pageSize = getPageSize();
                long j3 = j2 / pageSize;
                if (j2 % pageSize != 0) {
                    j3++;
                }
                SQLiteStatement sQLiteStatement2 = new SQLiteStatement(this, "PRAGMA max_page_count = " + j3);
                try {
                    long simpleQueryForLong = sQLiteStatement2.simpleQueryForLong() * pageSize;
                    sQLiteStatement2.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement = sQLiteStatement2;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void setPageSize(long j2) {
        execSQL("PRAGMA page_size = " + j2);
    }

    public void setTransactionSuccessful() {
        if (isOpen()) {
            if (this.mLock.isHeldByCurrentThread()) {
                if (!this.mInnerTransactionIsSuccessful) {
                    this.mInnerTransactionIsSuccessful = true;
                    return;
                }
                throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
            }
            throw new IllegalStateException("no transaction pending");
        }
        throw new IllegalStateException("database not open");
    }

    public void setVersion(int i2) {
        execSQL("PRAGMA user_version = " + i2);
    }

    public int status(int i2, boolean z) {
        return native_status(i2, z);
    }

    public void unlock() {
        if (this.mLockingEnabled) {
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
            this.mLock.unlock();
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i2) {
        if (contentValues != null && contentValues.size() != 0) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("UPDATE ");
            sb.append(CONFLICT_VALUES[i2]);
            sb.append(str);
            sb.append(" SET ");
            Set<Map.Entry<String, Object>> valueSet = contentValues.valueSet();
            Iterator<Map.Entry<String, Object>> it = valueSet.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getKey());
                sb.append(e.f16243c);
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            lock();
            if (isOpen()) {
                SQLiteStatement sQLiteStatement = null;
                try {
                    try {
                        sQLiteStatement = compileStatement(sb.toString());
                        int size = valueSet.size();
                        Iterator<Map.Entry<String, Object>> it2 = valueSet.iterator();
                        int i3 = 1;
                        for (int i4 = 0; i4 < size; i4++) {
                            DatabaseUtils.bindObjectToProgram(sQLiteStatement, i3, it2.next().getValue());
                            i3++;
                        }
                        if (strArr != null) {
                            for (String str3 : strArr) {
                                sQLiteStatement.bindString(i3, str3);
                                i3++;
                            }
                        }
                        sQLiteStatement.execute();
                        int lastChangeCount = lastChangeCount();
                        if (Log.isLoggable(TAG, 2)) {
                            Log.v(TAG, "Updated " + lastChangeCount + " rows using <redacted values> and <redacted sql> for " + str);
                        }
                        return lastChangeCount;
                    } catch (SQLiteDatabaseCorruptException e2) {
                        onCorruption();
                        throw e2;
                    } catch (SQLException e3) {
                        Log.e(TAG, "Error updating <redacted values> using <redacted sql> for " + str);
                        throw e3;
                    }
                } finally {
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                }
            }
            throw new IllegalStateException("database not open");
        }
        throw new IllegalArgumentException("Empty values");
    }

    @Deprecated
    public boolean yieldIfContended() {
        if (isOpen()) {
            return yieldIfContendedHelper(false, -1L);
        }
        return false;
    }

    public boolean yieldIfContendedSafely() {
        if (isOpen()) {
            return yieldIfContendedHelper(true, -1L);
        }
        return false;
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, char[] cArr) {
        return openDatabase(MEMORY, cArr, cursorFactory, 268435456);
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase.isOpen()) {
            ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
            Cursor rawQuery = sQLiteDatabase.rawQuery("pragma database_list;", (String[]) null);
            while (rawQuery.moveToNext()) {
                arrayList.add(new Pair<>(rawQuery.getString(1), rawQuery.getString(2)));
            }
            rawQuery.close();
            return arrayList;
        }
        return null;
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i2) {
        return openDatabase(str, cArr, cursorFactory, i2, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, 268435456, sQLiteDatabaseHook);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
    }

    /* JADX WARN: Finally extract failed */
    public Cursor rawQuery(String str, Object[] objArr) {
        if (isOpen()) {
            long currentTimeMillis = this.mSlowQueryThreshold != -1 ? System.currentTimeMillis() : 0L;
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, null);
            try {
                Cursor query = sQLiteDirectCursorDriver.query(this.mFactory, objArr);
                if (this.mSlowQueryThreshold != -1) {
                    int count = query != null ? query.getCount() : -1;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 >= this.mSlowQueryThreshold) {
                        Log.v(TAG, "query (" + currentTimeMillis2 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is " + count);
                    }
                }
                return new CrossProcessCursorWrapper(query);
            } catch (Throwable th) {
                if (this.mSlowQueryThreshold != -1) {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis3 >= this.mSlowQueryThreshold) {
                        Log.v(TAG, "query (" + currentTimeMillis3 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is -1");
                    }
                }
                throw th;
            }
        }
        throw new IllegalStateException("database not open");
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i2, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i2, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, sQLiteDatabaseHook);
    }

    public static synchronized void loadLibs(Context context, File file) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, file, new LibraryLoader() { // from class: net.sqlcipher.database.SQLiteDatabase.1
                @Override // net.sqlcipher.database.SQLiteDatabase.LibraryLoader
                public void loadLibraries(String... strArr) {
                    for (String str : strArr) {
                        System.loadLibrary(str);
                    }
                }
            });
        }
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i2, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, i2, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(file == null ? null : file.getPath(), str, cursorFactory, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public boolean yieldIfContendedSafely(long j2) {
        if (isOpen()) {
            return yieldIfContendedHelper(true, j2);
        }
        return false;
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i2, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, i2, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public void markTableSyncable(String str, String str2, String str3) {
        if (isOpen()) {
            markTableSyncable(str, str2, str3, null);
            return;
        }
        throw new SQLiteException("database not open");
    }

    private SQLiteDatabase(String str, CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0L;
        this.mLockAcquiredThreadTime = 0L;
        this.mLastLockMessageTime = 0L;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0L;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = 250;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (str != null) {
            this.mFlags = i2;
            this.mPath = str;
            this.mSlowQueryThreshold = -1;
            this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            this.mFactory = cursorFactory;
            this.mPrograms = new WeakHashMap<>();
            this.mErrorHandler = databaseErrorHandler;
            return;
        }
        throw new IllegalArgumentException("path should not be null");
    }

    public static synchronized void loadLibs(Context context, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir(), libraryLoader);
        }
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i2, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, i2, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, 268435456, sQLiteDatabaseHook);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static net.sqlcipher.database.SQLiteDatabase openDatabase(java.lang.String r6, char[] r7, net.sqlcipher.database.SQLiteDatabase.CursorFactory r8, int r9, net.sqlcipher.database.SQLiteDatabaseHook r10, net.sqlcipher.DatabaseErrorHandler r11) {
        /*
            if (r11 == 0) goto L3
            goto L8
        L3:
            net.sqlcipher.DefaultDatabaseErrorHandler r11 = new net.sqlcipher.DefaultDatabaseErrorHandler
            r11.<init>()
        L8:
            r0 = 0
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L14
            r1.<init>(r6, r8, r9, r11)     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L14
            r1.openDatabaseInternal(r7, r10)     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L12
            goto L37
        L12:
            r2 = move-exception
            goto L16
        L14:
            r2 = move-exception
            r1 = r0
        L16:
            java.lang.String r3 = "Database"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Calling error handler for corrupt database "
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4, r2)
            r11.onCorruption(r1)
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase
            r1.<init>(r6, r8, r9, r11)
            r1.openDatabaseInternal(r7, r10)
        L37:
            boolean r7 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_STATEMENTS
            if (r7 == 0) goto L3e
            r1.enableSqlTracing(r6)
        L3e:
            boolean r7 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_TIME
            if (r7 == 0) goto L45
            r1.enableSqlProfiling(r6)
        L45:
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r6 = net.sqlcipher.database.SQLiteDatabase.sActiveDatabases
            monitor-enter(r6)
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r7 = net.sqlcipher.database.SQLiteDatabase.sActiveDatabases     // Catch: java.lang.Throwable -> L4f
            r7.put(r1, r0)     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L4f
            return r1
        L4f:
            r7 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L4f
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.openDatabase(java.lang.String, char[], net.sqlcipher.database.SQLiteDatabase$CursorFactory, int, net.sqlcipher.database.SQLiteDatabaseHook, net.sqlcipher.DatabaseErrorHandler):net.sqlcipher.database.SQLiteDatabase");
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cArr, cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public void changePassword(char[] cArr) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (cArr != null) {
            byte[] bytes = getBytes(cArr);
            rekey(bytes);
            Arrays.fill(bytes, (byte) 0);
        }
    }

    public static synchronized void loadLibs(Context context, File file, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            libraryLoader.loadLibraries("sqlcipher");
        }
    }

    private void markTableSyncable(String str, String str2, String str3, String str4) {
        lock();
        try {
            native_execSQL("SELECT _sync_dirty FROM " + str3 + " LIMIT 0");
            native_execSQL("SELECT " + str2 + " FROM " + str + " LIMIT 0");
            unlock();
            SyncUpdateInfo syncUpdateInfo = new SyncUpdateInfo(str3, str4, str2);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(str, syncUpdateInfo);
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file, str, cursorFactory, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory) {
        return openDatabase(str, str2, cursorFactory, 268435456, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory) {
        return openDatabase(str, cArr, cursorFactory, 268435456, (SQLiteDatabaseHook) null);
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr != null) {
            SystemClock.uptimeMillis();
            lock();
            if (isOpen()) {
                SQLiteStatement sQLiteStatement = null;
                try {
                    try {
                        sQLiteStatement = compileStatement(str);
                        if (objArr != null) {
                            int length = objArr.length;
                            int i2 = 0;
                            while (i2 < length) {
                                int i3 = i2 + 1;
                                DatabaseUtils.bindObjectToProgram(sQLiteStatement, i3, objArr[i2]);
                                i2 = i3;
                            }
                        }
                        sQLiteStatement.execute();
                        return;
                    } catch (SQLiteDatabaseCorruptException e2) {
                        onCorruption();
                        throw e2;
                    }
                } finally {
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                }
            }
            throw new IllegalStateException("database not open");
        }
        throw new IllegalArgumentException("Empty bindArgs");
    }

    public Cursor rawQuery(String str, String[] strArr, int i2, int i3) {
        CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory(null, str, strArr, null);
        ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(i2, i3);
        return cursorWrapper;
    }
}
