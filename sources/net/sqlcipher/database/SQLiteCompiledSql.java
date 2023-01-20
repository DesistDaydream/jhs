package net.sqlcipher.database;

import android.util.Log;

/* loaded from: classes4.dex */
public class SQLiteCompiledSql {
    private static final String TAG = "SQLiteCompiledSql";
    public SQLiteDatabase mDatabase;
    private String mSqlStmt;
    private Throwable mStackTrace;
    public long nHandle;
    public long nStatement = 0;
    private boolean mInUse = false;

    public SQLiteCompiledSql(SQLiteDatabase sQLiteDatabase, String str) {
        this.nHandle = 0L;
        this.mSqlStmt = null;
        this.mStackTrace = null;
        if (sQLiteDatabase.isOpen()) {
            this.mDatabase = sQLiteDatabase;
            this.mSqlStmt = str;
            this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            this.nHandle = sQLiteDatabase.mNativeHandle;
            compile(str, true);
            return;
        }
        throw new IllegalStateException("database " + sQLiteDatabase.getPath() + " already closed");
    }

    private void compile(String str, boolean z) {
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        } else if (z) {
            this.mDatabase.lock();
            try {
                native_compile(str);
            } finally {
                this.mDatabase.unlock();
            }
        }
    }

    private final native void native_compile(String str);

    private final native void native_finalize();

    public synchronized boolean acquire() {
        if (this.mInUse) {
            return false;
        }
        this.mInUse = true;
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
            Log.v(TAG, "Acquired DbObj (id#" + this.nStatement + ") from DB cache");
        }
        return true;
    }

    public void finalize() throws Throwable {
        try {
            if (this.nStatement == 0) {
                return;
            }
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v(TAG, "** warning ** Finalized DbObj (id#" + this.nStatement + ")");
            }
            int length = this.mSqlStmt.length();
            StringBuilder sb = new StringBuilder();
            sb.append("Releasing statement in a finalizer. Please ensure that you explicitly call close() on your cursor: ");
            String str = this.mSqlStmt;
            if (length > 100) {
                length = 100;
            }
            sb.append(str.substring(0, length));
            Log.w(TAG, sb.toString(), this.mStackTrace);
            releaseSqlStatement();
        } finally {
            super.finalize();
        }
    }

    public synchronized void release() {
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
            Log.v(TAG, "Released DbObj (id#" + this.nStatement + ") back to DB cache");
        }
        this.mInUse = false;
    }

    public void releaseSqlStatement() {
        if (this.nStatement != 0) {
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                Log.v(TAG, "closed and deallocated DbObj (id#" + this.nStatement + ")");
            }
            try {
                this.mDatabase.lock();
                native_finalize();
                this.nStatement = 0L;
            } finally {
                this.mDatabase.unlock();
            }
        }
    }
}
