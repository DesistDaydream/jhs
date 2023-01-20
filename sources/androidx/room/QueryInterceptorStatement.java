package androidx.room;

import androidx.annotation.NonNull;
import androidx.room.QueryInterceptorStatement;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> mBindArgsCache = new ArrayList();
    private final SupportSQLiteStatement mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;
    private final String mSqlStatement;

    public QueryInterceptorStatement(@NonNull SupportSQLiteStatement compileStatement, @NonNull RoomDatabase.QueryCallback queryCallback, String sqlStatement, @NonNull Executor queryCallbackExecutor) {
        this.mDelegate = compileStatement;
        this.mQueryCallback = queryCallback;
        this.mSqlStatement = sqlStatement;
        this.mQueryCallbackExecutor = queryCallbackExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void n() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void q() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    private void saveArgsToCache(int bindIndex, Object value) {
        int i2 = bindIndex - 1;
        if (i2 >= this.mBindArgsCache.size()) {
            for (int size = this.mBindArgsCache.size(); size <= i2; size++) {
                this.mBindArgsCache.add(null);
            }
        }
        this.mBindArgsCache.set(i2, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void F() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        saveArgsToCache(index, value);
        this.mDelegate.bindBlob(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        saveArgsToCache(index, Double.valueOf(value));
        this.mDelegate.bindDouble(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        saveArgsToCache(index, Long.valueOf(value));
        this.mDelegate.bindLong(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int index) {
        saveArgsToCache(index, this.mBindArgsCache.toArray());
        this.mDelegate.bindNull(index);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        saveArgsToCache(index, value);
        this.mDelegate.bindString(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mBindArgsCache.clear();
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.k0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.k();
            }
        });
        this.mDelegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.l0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.n();
            }
        });
        return this.mDelegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.m0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.q();
            }
        });
        return this.mDelegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.n0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.s();
            }
        });
        return this.mDelegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: c.g.j0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.F();
            }
        });
        return this.mDelegate.simpleQueryForString();
    }
}
