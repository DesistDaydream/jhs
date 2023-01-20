package net.sqlcipher.database;

import android.util.Log;

/* loaded from: classes4.dex */
public abstract class SQLiteProgram extends SQLiteClosable {
    private static final String TAG = "SQLiteProgram";
    public boolean mClosed = false;
    private SQLiteCompiledSql mCompiledSql;
    @Deprecated
    public SQLiteDatabase mDatabase;
    public final String mSql;
    @Deprecated
    public long nHandle;
    @Deprecated
    public long nStatement;

    public SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str) {
        this.nHandle = 0L;
        this.nStatement = 0L;
        this.mDatabase = sQLiteDatabase;
        String trim = str.trim();
        this.mSql = trim;
        sQLiteDatabase.acquireReference();
        sQLiteDatabase.addSQLiteClosable(this);
        this.nHandle = sQLiteDatabase.mNativeHandle;
        trim = trim.length() >= 6 ? trim.substring(0, 6) : trim;
        if (!trim.equalsIgnoreCase("INSERT") && !trim.equalsIgnoreCase("UPDATE") && !trim.equalsIgnoreCase("REPLAC") && !trim.equalsIgnoreCase("DELETE") && !trim.equalsIgnoreCase("SELECT")) {
            SQLiteCompiledSql sQLiteCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            this.mCompiledSql = sQLiteCompiledSql;
            this.nStatement = sQLiteCompiledSql.nStatement;
            return;
        }
        SQLiteCompiledSql compiledStatementForSql = sQLiteDatabase.getCompiledStatementForSql(str);
        this.mCompiledSql = compiledStatementForSql;
        if (compiledStatementForSql == null) {
            SQLiteCompiledSql sQLiteCompiledSql2 = new SQLiteCompiledSql(sQLiteDatabase, str);
            this.mCompiledSql = sQLiteCompiledSql2;
            sQLiteCompiledSql2.acquire();
            sQLiteDatabase.addToCompiledQueries(str, this.mCompiledSql);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v(TAG, "Created DbObj (id#" + this.mCompiledSql.nStatement + ") for sql: " + str);
            }
        } else if (!compiledStatementForSql.acquire()) {
            long j2 = this.mCompiledSql.nStatement;
            this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v(TAG, "** possible bug ** Created NEW DbObj (id#" + this.mCompiledSql.nStatement + ") because the previously created DbObj (id#" + j2 + ") was not released for sql:" + str);
            }
        }
        this.nStatement = this.mCompiledSql.nStatement;
    }

    private final native void native_clear_bindings();

    private void releaseCompiledSqlIfNotInCache() {
        if (this.mCompiledSql == null) {
            return;
        }
        synchronized (this.mDatabase.mCompiledQueries) {
            if (!this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql)) {
                this.mCompiledSql.releaseSqlStatement();
                this.mCompiledSql = null;
                this.nStatement = 0L;
            } else {
                this.mCompiledSql.release();
            }
        }
    }

    public void bindBlob(int i2, byte[] bArr) {
        if (bArr != null) {
            if (!this.mClosed) {
                if (this.mDatabase.isOpen()) {
                    acquireReference();
                    try {
                        native_bind_blob(i2, bArr);
                        return;
                    } finally {
                        releaseReference();
                    }
                }
                throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
            }
            throw new IllegalStateException("program already closed");
        }
        throw new IllegalArgumentException("the bind value at index " + i2 + " is null");
    }

    public void bindDouble(int i2, double d2) {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_bind_double(i2, d2);
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    public void bindLong(int i2, long j2) {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_bind_long(i2, j2);
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    public void bindNull(int i2) {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_bind_null(i2);
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    public void bindString(int i2, String str) {
        if (str != null) {
            if (!this.mClosed) {
                if (this.mDatabase.isOpen()) {
                    acquireReference();
                    try {
                        native_bind_string(i2, str);
                        return;
                    } finally {
                        releaseReference();
                    }
                }
                throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
            }
            throw new IllegalStateException("program already closed");
        }
        throw new IllegalArgumentException("the bind value at index " + i2 + " is null");
    }

    public void clearBindings() {
        if (!this.mClosed) {
            if (this.mDatabase.isOpen()) {
                acquireReference();
                try {
                    native_clear_bindings();
                    return;
                } finally {
                    releaseReference();
                }
            }
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        throw new IllegalStateException("program already closed");
    }

    public void close() {
        if (!this.mClosed && this.mDatabase.isOpen()) {
            this.mDatabase.lock();
            try {
                releaseReference();
                this.mDatabase.unlock();
                this.mClosed = true;
            } catch (Throwable th) {
                this.mDatabase.unlock();
                throw th;
            }
        }
    }

    @Deprecated
    public void compile(String str, boolean z) {
    }

    public String getSqlString() {
        return this.mSql;
    }

    public final long getUniqueId() {
        return this.nStatement;
    }

    public final native void native_bind_blob(int i2, byte[] bArr);

    public final native void native_bind_double(int i2, double d2);

    public final native void native_bind_long(int i2, long j2);

    public final native void native_bind_null(int i2);

    public final native void native_bind_string(int i2, String str);

    @Deprecated
    public final native void native_compile(String str);

    @Deprecated
    public final native void native_finalize();

    @Override // net.sqlcipher.database.SQLiteClosable
    public void onAllReferencesReleased() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
        this.mDatabase.removeSQLiteClosable(this);
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    public void onAllReferencesReleasedFromContainer() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
    }
}
