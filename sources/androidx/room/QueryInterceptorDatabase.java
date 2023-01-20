package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.QueryInterceptorDatabase;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    public QueryInterceptorDatabase(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, @NonNull RoomDatabase.QueryCallback queryCallback, @NonNull Executor queryCallbackExecutor) {
        this.mDelegate = supportSQLiteDatabase;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = queryCallbackExecutor;
    }

    /* renamed from: A0 */
    public /* synthetic */ void B0() {
        this.mQueryCallback.onQuery("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    /* renamed from: H */
    public /* synthetic */ void J(String str) {
        this.mQueryCallback.onQuery(str, new ArrayList(0));
    }

    /* renamed from: M */
    public /* synthetic */ void X(String str, List list) {
        this.mQueryCallback.onQuery(str, list);
    }

    /* renamed from: Y */
    public /* synthetic */ void c0(String str) {
        this.mQueryCallback.onQuery(str, Collections.emptyList());
    }

    /* renamed from: f0 */
    public /* synthetic */ void m0(String str, List list) {
        this.mQueryCallback.onQuery(str, list);
    }

    /* renamed from: j */
    public /* synthetic */ void k() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* renamed from: l */
    public /* synthetic */ void n() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    /* renamed from: o */
    public /* synthetic */ void q() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* renamed from: o0 */
    public /* synthetic */ void u0(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.mQueryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgs());
    }

    /* renamed from: r */
    public /* synthetic */ void s() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    /* renamed from: t */
    public /* synthetic */ void F() {
        this.mQueryCallback.onQuery("END TRANSACTION", Collections.emptyList());
    }

    /* renamed from: x0 */
    public /* synthetic */ void z0(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.mQueryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgs());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.h0
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.k();
            }
        });
        this.mDelegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.y
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.n();
            }
        });
        this.mDelegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(@NonNull SQLiteTransactionListener transactionListener) {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.i0
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.q();
            }
        });
        this.mDelegate.beginTransactionWithListener(transactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(@NonNull SQLiteTransactionListener transactionListener) {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.b0
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.s();
            }
        });
        this.mDelegate.beginTransactionWithListenerNonExclusive(transactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public SupportSQLiteStatement compileStatement(@NonNull String sql) {
        return new QueryInterceptorStatement(this.mDelegate.compileStatement(sql), this.mQueryCallback, sql, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(@NonNull String table, @NonNull String whereClause, @NonNull Object[] whereArgs) {
        return this.mDelegate.delete(table, whereClause, whereArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.x
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.F();
            }
        });
        this.mDelegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NonNull final String sql) throws SQLException {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.c0
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.J(sql);
            }
        });
        this.mDelegate.execSQL(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public List<Pair<String, String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public String getPath() {
        return this.mDelegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(@NonNull String table, int conflictAlgorithm, @NonNull ContentValues values) throws SQLException {
        return this.mDelegate.insert(table, conflictAlgorithm, values);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.mDelegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int newVersion) {
        return this.mDelegate.needUpgrade(newVersion);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor query(@NonNull final String query) {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.e0
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.c0(query);
            }
        });
        return this.mDelegate.query(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean enable) {
        this.mDelegate.setForeignKeyConstraintsEnabled(enable);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(@NonNull Locale locale) {
        this.mDelegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int cacheSize) {
        this.mDelegate.setMaxSqlCacheSize(cacheSize);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long numBytes) {
        return this.mDelegate.setMaximumSize(numBytes);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long numBytes) {
        this.mDelegate.setPageSize(numBytes);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.z
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.B0();
            }
        });
        this.mDelegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int version) {
        this.mDelegate.setVersion(version);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(@NonNull String table, int conflictAlgorithm, @NonNull ContentValues values, @NonNull String whereClause, @NonNull Object[] whereArgs) {
        return this.mDelegate.update(table, conflictAlgorithm, values, whereClause, whereArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        return this.mDelegate.yieldIfContendedSafely(sleepAfterYieldDelay);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NonNull final String sql, @NonNull Object[] bindArgs) throws SQLException {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(bindArgs));
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.a0
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.X(sql, arrayList);
            }
        });
        this.mDelegate.execSQL(sql, arrayList.toArray());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor query(@NonNull final String query, @NonNull Object[] bindArgs) {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(bindArgs));
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.f0
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.m0(query, arrayList);
            }
        });
        return this.mDelegate.query(query, bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor query(@NonNull final SupportSQLiteQuery query) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.d0
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.u0(query, queryInterceptorProgram);
            }
        });
        return this.mDelegate.query(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor query(@NonNull final SupportSQLiteQuery query, @NonNull CancellationSignal cancellationSignal) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.g0
            {
                QueryInterceptorDatabase.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.z0(query, queryInterceptorProgram);
            }
        });
        return this.mDelegate.query(query);
    }
}
