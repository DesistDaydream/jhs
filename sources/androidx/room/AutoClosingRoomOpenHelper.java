package androidx.room;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import c.g.a;
import c.g.b;
import c.g.c;
import c.g.d;
import c.g.e;
import c.g.o0;
import c.g.p;
import c.g.r;
import c.g.r0;
import c.g.s0;
import c.g.t;
import c.g.t0;
import c.g.u0;
import c.g.v;
import c.g.v0;
import c.g.w;
import c.g.x0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    @NonNull
    private final AutoCloser mAutoCloser;
    @NonNull
    private final AutoClosingSupportSQLiteDatabase mAutoClosingDb;
    @NonNull
    private final SupportSQLiteOpenHelper mDelegateOpenHelper;

    /* loaded from: classes.dex */
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        @NonNull
        private final AutoCloser mAutoCloser;

        public AutoClosingSupportSQLiteDatabase(@NonNull AutoCloser autoCloser) {
            this.mAutoCloser = autoCloser;
        }

        public static /* synthetic */ Boolean i(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 16) {
                return Boolean.valueOf(supportSQLiteDatabase.isWriteAheadLoggingEnabled());
            }
            return Boolean.FALSE;
        }

        public static /* synthetic */ Object k(SupportSQLiteDatabase supportSQLiteDatabase) {
            return null;
        }

        public static /* synthetic */ Object l(boolean z, SupportSQLiteDatabase supportSQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 16) {
                supportSQLiteDatabase.setForeignKeyConstraintsEnabled(z);
                return null;
            }
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(transactionListener);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener transactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(transactionListener);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mAutoCloser.closeDatabaseIfOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public SupportSQLiteStatement compileStatement(String sql) {
            return new AutoClosingSupportSqliteStatement(sql, this.mAutoCloser);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(final String table, final String whereClause, final Object[] whereArgs) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.j
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Integer valueOf;
                    valueOf = Integer.valueOf(((SupportSQLiteDatabase) obj).delete(table, whereClause, whereArgs));
                    return valueOf;
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void endTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() != null) {
                try {
                    this.mAutoCloser.getDelegateDatabase().endTransaction();
                    return;
                } finally {
                    this.mAutoCloser.decrementCountAndScheduleClose();
                }
            }
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String sql) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.l
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).execSQL(sql);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.mAutoCloser.executeRefCountingFunction(v0.a);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(d.a)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(r0.a)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String getPath() {
            return (String) this.mAutoCloser.executeRefCountingFunction(e.a);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(s0.a)).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(v.a)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(final String table, final int conflictAlgorithm, final ContentValues values) throws SQLException {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.o
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Long valueOf;
                    valueOf = Long.valueOf(((SupportSQLiteDatabase) obj).insert(table, conflictAlgorithm, values));
                    return valueOf;
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(c.a)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(a.a)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase == null) {
                return false;
            }
            return delegateDatabase.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(b.a)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        @SuppressLint({"UnsafeNewApiCall"})
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(p.a)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(final int newVersion) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.n
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean valueOf;
                    valueOf = Boolean.valueOf(((SupportSQLiteDatabase) obj).needUpgrade(newVersion));
                    return valueOf;
                }
            })).booleanValue();
        }

        public void pokeOpen() {
            this.mAutoCloser.executeRefCountingFunction(r.a);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String query) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        @SuppressLint({"UnsafeNewApiCall"})
        public void setForeignKeyConstraintsEnabled(final boolean enable) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.g
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.l(enable, (SupportSQLiteDatabase) obj);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(final Locale locale) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.h
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).setLocale(locale);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(final int cacheSize) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.q
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).setMaxSqlCacheSize(cacheSize);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(final long numBytes) {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.m
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Long valueOf;
                    valueOf = Long.valueOf(((SupportSQLiteDatabase) obj).setMaximumSize(numBytes));
                    return valueOf;
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(final long numBytes) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.k
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).setPageSize(numBytes);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase != null) {
                delegateDatabase.setTransactionSuccessful();
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(final int version) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.s
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).setVersion(version);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(final String table, final int conflictAlgorithm, final ContentValues values, final String whereClause, final Object[] whereArgs) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.i
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Integer valueOf;
                    valueOf = Integer.valueOf(((SupportSQLiteDatabase) obj).update(table, conflictAlgorithm, values, whereClause, whereArgs));
                    return valueOf;
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(u0.a)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String sql, final Object[] bindArgs) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.f
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).execSQL(sql, bindArgs);
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(u0.a)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String query, Object[] bindArgs) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(query, bindArgs), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery query) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 24)
        public Cursor query(SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(query, cancellationSignal), this.mAutoCloser);
            } catch (Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser mAutoCloser;
        private final ArrayList<Object> mBinds = new ArrayList<>();
        private final String mSql;

        public AutoClosingSupportSqliteStatement(String sql, AutoCloser autoCloser) {
            this.mSql = sql;
            this.mAutoCloser = autoCloser;
        }

        /* renamed from: b */
        public /* synthetic */ Object c(Function function, SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteStatement compileStatement = supportSQLiteDatabase.compileStatement(this.mSql);
            doBinds(compileStatement);
            return function.apply(compileStatement);
        }

        private void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
            int i2 = 0;
            while (i2 < this.mBinds.size()) {
                int i3 = i2 + 1;
                Object obj = this.mBinds.get(i2);
                if (obj == null) {
                    supportSQLiteStatement.bindNull(i3);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.bindLong(i3, ((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.bindDouble(i3, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.bindString(i3, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(i3, (byte[]) obj);
                }
                i2 = i3;
            }
        }

        private <T> T executeSqliteStatementWithRefCount(final Function<SupportSQLiteStatement, T> func) {
            return (T) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: c.g.u
                {
                    AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.this = this;
                }

                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.this.c(func, (SupportSQLiteDatabase) obj);
                }
            });
        }

        private void saveBinds(int bindIndex, Object value) {
            int i2 = bindIndex - 1;
            if (i2 >= this.mBinds.size()) {
                for (int size = this.mBinds.size(); size <= i2; size++) {
                    this.mBinds.add(null);
                }
            }
            this.mBinds.set(i2, value);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int index, byte[] value) {
            saveBinds(index, value);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int index, double value) {
            saveBinds(index, Double.valueOf(value));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int index, long value) {
            saveBinds(index, Long.valueOf(value));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int index) {
            saveBinds(index, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int index, String value) {
            saveBinds(index, value);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.mBinds.clear();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            executeSqliteStatementWithRefCount(t.a);
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Long) executeSqliteStatementWithRefCount(t0.a)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Integer) executeSqliteStatementWithRefCount(x0.a)).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Long) executeSqliteStatementWithRefCount(o0.a)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(w.a);
        }
    }

    /* loaded from: classes.dex */
    public static final class KeepAliveCursor implements Cursor {
        private final AutoCloser mAutoCloser;
        private final Cursor mDelegate;

        public KeepAliveCursor(Cursor delegate, AutoCloser autoCloser) {
            this.mDelegate = delegate;
            this.mAutoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mDelegate.close();
            this.mAutoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
            this.mDelegate.copyStringToBuffer(columnIndex, buffer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.mDelegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int columnIndex) {
            return this.mDelegate.getBlob(columnIndex);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.mDelegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String columnName) {
            return this.mDelegate.getColumnIndex(columnName);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
            return this.mDelegate.getColumnIndexOrThrow(columnName);
        }

        @Override // android.database.Cursor
        public String getColumnName(int columnIndex) {
            return this.mDelegate.getColumnName(columnIndex);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.mDelegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.mDelegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int columnIndex) {
            return this.mDelegate.getDouble(columnIndex);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.mDelegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int columnIndex) {
            return this.mDelegate.getFloat(columnIndex);
        }

        @Override // android.database.Cursor
        public int getInt(int columnIndex) {
            return this.mDelegate.getInt(columnIndex);
        }

        @Override // android.database.Cursor
        public long getLong(int columnIndex) {
            return this.mDelegate.getLong(columnIndex);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 19)
        @SuppressLint({"UnsafeNewApiCall"})
        public Uri getNotificationUri() {
            return this.mDelegate.getNotificationUri();
        }

        @Override // android.database.Cursor
        @Nullable
        @RequiresApi(api = 29)
        @SuppressLint({"UnsafeNewApiCall"})
        public List<Uri> getNotificationUris() {
            return this.mDelegate.getNotificationUris();
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.mDelegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int columnIndex) {
            return this.mDelegate.getShort(columnIndex);
        }

        @Override // android.database.Cursor
        public String getString(int columnIndex) {
            return this.mDelegate.getString(columnIndex);
        }

        @Override // android.database.Cursor
        public int getType(int columnIndex) {
            return this.mDelegate.getType(columnIndex);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.mDelegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.mDelegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.mDelegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.mDelegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.mDelegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.mDelegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int columnIndex) {
            return this.mDelegate.isNull(columnIndex);
        }

        @Override // android.database.Cursor
        public boolean move(int offset) {
            return this.mDelegate.move(offset);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.mDelegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.mDelegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.mDelegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int position) {
            return this.mDelegate.moveToPosition(position);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.mDelegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver observer) {
            this.mDelegate.registerContentObserver(observer);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver observer) {
            this.mDelegate.registerDataSetObserver(observer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.mDelegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle extras) {
            return this.mDelegate.respond(extras);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 23)
        @SuppressLint({"UnsafeNewApiCall"})
        public void setExtras(Bundle extras) {
            this.mDelegate.setExtras(extras);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver cr, Uri uri) {
            this.mDelegate.setNotificationUri(cr, uri);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 29)
        @SuppressLint({"UnsafeNewApiCall"})
        public void setNotificationUris(@NonNull ContentResolver cr, @NonNull List<Uri> uris) {
            this.mDelegate.setNotificationUris(cr, uris);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver observer) {
            this.mDelegate.unregisterContentObserver(observer);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver observer) {
            this.mDelegate.unregisterDataSetObserver(observer);
        }
    }

    public AutoClosingRoomOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, @NonNull AutoCloser autoCloser) {
        this.mDelegateOpenHelper = supportSQLiteOpenHelper;
        this.mAutoCloser = autoCloser;
        autoCloser.init(supportSQLiteOpenHelper);
        this.mAutoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.mAutoClosingDb.close();
        } catch (IOException e2) {
            SneakyThrow.reThrow(e2);
        }
    }

    @NonNull
    public AutoCloser getAutoCloser() {
        return this.mAutoCloser;
    }

    @NonNull
    public SupportSQLiteDatabase getAutoClosingDb() {
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.mDelegateOpenHelper.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegateOpenHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getReadableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getWritableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        this.mDelegateOpenHelper.setWriteAheadLoggingEnabled(enabled);
    }
}
