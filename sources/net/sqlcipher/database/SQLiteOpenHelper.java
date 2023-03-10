package net.sqlcipher.database;

import android.content.Context;
import android.util.Log;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes4.dex */
public abstract class SQLiteOpenHelper {
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mDeferSetWriteAheadLoggingEnabled;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        this(context, str, cursorFactory, i2, null, new DefaultDatabaseErrorHandler());
    }

    public synchronized void close() {
        if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.close();
                this.mDatabase = null;
            }
        } else {
            throw new IllegalStateException("Closed during initialization");
        }
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public synchronized SQLiteDatabase getReadableDatabase(String str) {
        return getReadableDatabase(str == null ? null : str.toCharArray());
    }

    public synchronized SQLiteDatabase getWritableDatabase(String str) {
        return getWritableDatabase(str == null ? null : str.toCharArray());
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new SQLiteException("Can't downgrade database from version " + i2 + " to " + i3);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            if (this.mEnableWriteAheadLogging != z) {
                SQLiteDatabase sQLiteDatabase = this.mDatabase;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                    if (z) {
                        this.mDatabase.enableWriteAheadLogging();
                    } else {
                        this.mDatabase.disableWriteAheadLogging();
                    }
                    this.mEnableWriteAheadLogging = z;
                } else {
                    this.mDeferSetWriteAheadLoggingEnabled = z;
                }
            }
        }
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(context, str, cursorFactory, i2, sQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
    }

    public synchronized SQLiteDatabase getReadableDatabase(char[] cArr) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return this.mDatabase;
        } else if (!this.mIsInitializing) {
            try {
                return getWritableDatabase(cArr);
            } catch (SQLiteException e2) {
                if (this.mName != null) {
                    String str = TAG;
                    Log.e(str, "Couldn't open " + this.mName + " for writing (will try read-only):", e2);
                    this.mIsInitializing = true;
                    String path = this.mContext.getDatabasePath(this.mName).getPath();
                    File file = new File(path);
                    File file2 = new File(this.mContext.getDatabasePath(this.mName).getParent());
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.exists()) {
                        this.mIsInitializing = false;
                        SQLiteDatabase writableDatabase = getWritableDatabase(cArr);
                        this.mIsInitializing = true;
                        writableDatabase.close();
                    }
                    SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(path, cArr, this.mFactory, 1);
                    if (openDatabase.getVersion() == this.mNewVersion) {
                        onOpen(openDatabase);
                        Log.w(str, "Opened " + this.mName + " in read-only mode");
                        this.mDatabase = openDatabase;
                        this.mIsInitializing = false;
                        if (openDatabase != null && openDatabase != openDatabase) {
                            openDatabase.close();
                        }
                        return openDatabase;
                    }
                    throw new SQLiteException("Can't upgrade read-only database from version " + openDatabase.getVersion() + " to " + this.mNewVersion + ": " + path);
                }
                throw e2;
            }
        } else {
            throw new IllegalStateException("getReadableDatabase called recursively");
        }
    }

    public synchronized SQLiteDatabase getWritableDatabase(char[] cArr) {
        SQLiteDatabase openOrCreateDatabase;
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
            return this.mDatabase;
        } else if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.lock();
            }
            this.mIsInitializing = true;
            String str = this.mName;
            if (str == null) {
                openOrCreateDatabase = SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null, cArr);
            } else {
                String path = this.mContext.getDatabasePath(str).getPath();
                File file = new File(path);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(path, cArr, this.mFactory, this.mHook, this.mErrorHandler);
            }
            SQLiteDatabase sQLiteDatabase3 = openOrCreateDatabase;
            if (this.mDeferSetWriteAheadLoggingEnabled) {
                this.mEnableWriteAheadLogging = sQLiteDatabase3.enableWriteAheadLogging();
            }
            onConfigure(sQLiteDatabase3);
            int version = sQLiteDatabase3.getVersion();
            if (version != this.mNewVersion) {
                sQLiteDatabase3.beginTransaction();
                if (version == 0) {
                    onCreate(sQLiteDatabase3);
                } else {
                    int i2 = this.mNewVersion;
                    if (version > i2) {
                        onDowngrade(sQLiteDatabase3, version, i2);
                    } else {
                        onUpgrade(sQLiteDatabase3, version, i2);
                    }
                }
                sQLiteDatabase3.setVersion(this.mNewVersion);
                sQLiteDatabase3.setTransactionSuccessful();
                sQLiteDatabase3.endTransaction();
            }
            onOpen(sQLiteDatabase3);
            this.mIsInitializing = false;
            SQLiteDatabase sQLiteDatabase4 = this.mDatabase;
            if (sQLiteDatabase4 != null) {
                try {
                    sQLiteDatabase4.close();
                } catch (Exception unused) {
                }
                this.mDatabase.unlock();
            }
            this.mDatabase = sQLiteDatabase3;
            return sQLiteDatabase3;
        } else {
            throw new IllegalStateException("getWritableDatabase called recursively");
        }
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (i2 < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i2);
        } else if (databaseErrorHandler != null) {
            this.mContext = context;
            this.mName = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i2;
            this.mHook = sQLiteDatabaseHook;
            this.mErrorHandler = databaseErrorHandler;
        } else {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        }
    }
}
