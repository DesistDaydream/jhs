package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public abstract class OrmLiteSqliteOpenHelper extends SQLiteOpenHelper {
    public static Logger logger = LoggerFactory.getLogger(OrmLiteSqliteOpenHelper.class);
    public boolean cancelQueriesEnabled;
    public AndroidConnectionSource connectionSource;
    private volatile boolean isOpen;

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.connectionSource = new AndroidConnectionSource(this);
        this.isOpen = true;
        logger.trace("{}: constructed connectionSource {}", this, this.connectionSource);
    }

    private static InputStream openFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e2) {
            throw new IllegalArgumentException("Could not open config file " + file, e2);
        }
    }

    private static InputStream openFileId(Context context, int i2) {
        InputStream openRawResource = context.getResources().openRawResource(i2);
        if (openRawResource != null) {
            return openRawResource;
        }
        throw new IllegalStateException("Could not find object config file with id " + i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.connectionSource.close();
        this.isOpen = false;
    }

    public ConnectionSource getConnectionSource() {
        if (!this.isOpen) {
            logger.warn(new IllegalStateException(), "Getting connectionSource was called after closed");
        }
        return this.connectionSource;
    }

    public <D extends Dao<T, ?>, T> D getDao(Class<T> cls) throws SQLException {
        return (D) DaoManager.createDao(getConnectionSource(), cls);
    }

    public <D extends RuntimeExceptionDao<T, ?>, T> D getRuntimeExceptionDao(Class<T> cls) {
        try {
            return (D) new RuntimeExceptionDao(getDao(cls));
        } catch (SQLException e2) {
            throw new RuntimeException("Could not create RuntimeExcepitionDao for class " + cls, e2);
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ConnectionSource connectionSource = getConnectionSource();
        DatabaseConnection specialConnection = connectionSource.getSpecialConnection(null);
        boolean z = true;
        if (specialConnection == null) {
            specialConnection = new AndroidDatabaseConnection(sQLiteDatabase, true, this.cancelQueriesEnabled);
            try {
                connectionSource.saveSpecialConnection(specialConnection);
            } catch (SQLException e2) {
                throw new IllegalStateException("Could not save special connection", e2);
            }
        } else {
            z = false;
        }
        try {
            onCreate(sQLiteDatabase, connectionSource);
        } finally {
            if (z) {
                connectionSource.clearSpecialConnection(specialConnection);
            }
        }
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource);

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        ConnectionSource connectionSource = getConnectionSource();
        DatabaseConnection specialConnection = connectionSource.getSpecialConnection(null);
        boolean z = true;
        if (specialConnection == null) {
            specialConnection = new AndroidDatabaseConnection(sQLiteDatabase, true, this.cancelQueriesEnabled);
            try {
                connectionSource.saveSpecialConnection(specialConnection);
            } catch (SQLException e2) {
                throw new IllegalStateException("Could not save special connection", e2);
            }
        } else {
            z = false;
        }
        try {
            onUpgrade(sQLiteDatabase, connectionSource, i2, i3);
        } finally {
            if (z) {
                connectionSource.clearSpecialConnection(specialConnection);
            }
        }
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i2, int i3);

    public String toString() {
        return getClass().getSimpleName() + TIMMentionEditText.TIM_MENTION_TAG + Integer.toHexString(super.hashCode());
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, int i3) {
        this(context, str, cursorFactory, i2, openFileId(context, i3));
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, File file) {
        this(context, str, cursorFactory, i2, openFile(file));
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, InputStream inputStream) {
        super(context, str, cursorFactory, i2);
        this.connectionSource = new AndroidConnectionSource(this);
        this.isOpen = true;
        if (inputStream == null) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream), 4096);
                try {
                    DaoManager.addCachedDatabaseConfigs(DatabaseTableConfigLoader.loadDatabaseConfigFromReader(bufferedReader2));
                    IOUtils.closeQuietly(bufferedReader2);
                    IOUtils.closeQuietly(null);
                } catch (SQLException e2) {
                    e = e2;
                    throw new IllegalStateException("Could not load object config file", e);
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                    bufferedReader = bufferedReader2;
                    IOUtils.closeQuietly(bufferedReader);
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (SQLException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
