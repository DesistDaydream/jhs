package com.moor.imkf.db;

import android.content.Context;
import com.j256.ormlite.cipher.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.GlobalSet;
import com.moor.imkf.model.entity.Info;
import com.moor.imkf.model.entity.MsgInves;
import com.moor.imkf.model.entity.MsgUnReadCount;
import java.sql.SQLException;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes2.dex */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {
    private static final int DATABASE_VERSION = 54;
    private static DataBaseHelper instance;
    private Dao<Info, Integer> InfoDao;
    private Dao<FromToMessage, Integer> fromToMessageDao;
    private Dao<GlobalSet, Integer> globalSetDao;
    private Dao<MsgInves, Integer> msgInvesDao;
    private Dao<MsgUnReadCount, Integer> msgUnReadCountDao;

    private DataBaseHelper(Context context) {
        super(context, YKFConstants.Moor_DATABASE, null, 54);
        this.fromToMessageDao = null;
        this.InfoDao = null;
        this.msgInvesDao = null;
        this.globalSetDao = null;
        this.msgUnReadCountDao = null;
        SQLiteDatabase.loadLibs(context);
    }

    public static synchronized DataBaseHelper getHelper(Context context) {
        DataBaseHelper dataBaseHelper;
        synchronized (DataBaseHelper.class) {
            if (instance == null) {
                synchronized (DataBaseHelper.class) {
                    if (instance == null) {
                        instance = new DataBaseHelper(context);
                    }
                }
            }
            dataBaseHelper = instance;
        }
        return dataBaseHelper;
    }

    @Override // com.j256.ormlite.cipher.android.apptools.OrmLiteSqliteOpenHelper, net.sqlcipher.database.SQLiteOpenHelper
    public void close() {
        super.close();
        this.fromToMessageDao = null;
        this.InfoDao = null;
        this.msgInvesDao = null;
        this.globalSetDao = null;
        this.msgUnReadCountDao = null;
    }

    public Dao<FromToMessage, Integer> getFromMessageDao() throws SQLException {
        if (this.fromToMessageDao == null) {
            this.fromToMessageDao = getDao(FromToMessage.class);
        }
        return this.fromToMessageDao;
    }

    public Dao<GlobalSet, Integer> getGlobalSetDao() throws SQLException {
        if (this.globalSetDao == null) {
            this.globalSetDao = getDao(GlobalSet.class);
        }
        return this.globalSetDao;
    }

    public Dao<Info, Integer> getInfoDao() throws SQLException {
        if (this.InfoDao == null) {
            this.InfoDao = getDao(Info.class);
        }
        return this.InfoDao;
    }

    public Dao<MsgInves, Integer> getMsgInvesDao() throws SQLException {
        if (this.msgInvesDao == null) {
            this.msgInvesDao = getDao(MsgInves.class);
        }
        return this.msgInvesDao;
    }

    public Dao<MsgUnReadCount, Integer> getMsgUnReadCountDao() throws SQLException {
        if (this.msgUnReadCountDao == null) {
            this.msgUnReadCountDao = getDao(MsgUnReadCount.class);
        }
        return this.msgUnReadCountDao;
    }

    @Override // com.j256.ormlite.cipher.android.apptools.OrmLiteSqliteOpenHelper
    public String getPassword() {
        return "kfsdk7moor";
    }

    @Override // com.j256.ormlite.cipher.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, FromToMessage.class);
            TableUtils.createTable(connectionSource, Info.class);
            TableUtils.createTable(connectionSource, MsgInves.class);
            TableUtils.createTable(connectionSource, GlobalSet.class);
            TableUtils.createTable(connectionSource, MsgUnReadCount.class);
            this.fromToMessageDao = getFromMessageDao();
            this.InfoDao = getInfoDao();
            this.msgInvesDao = getMsgInvesDao();
            this.globalSetDao = getGlobalSetDao();
            this.msgUnReadCountDao = getMsgUnReadCountDao();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.j256.ormlite.cipher.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i2, int i3) {
        try {
            TableUtils.dropTable(connectionSource, FromToMessage.class, true);
            TableUtils.dropTable(connectionSource, Info.class, true);
            TableUtils.dropTable(connectionSource, MsgInves.class, true);
            TableUtils.dropTable(connectionSource, GlobalSet.class, true);
            TableUtils.dropTable(connectionSource, MsgUnReadCount.class, true);
            onCreate(sQLiteDatabase, connectionSource);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
}
