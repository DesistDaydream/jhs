package com.moor.imkf.lib.basedb;

import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.moor.imkf.lib.MoorBaseLibManager;
import com.moor.imkf.lib.analytics.bean.MoorAnalyticsBean;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class MoorBaseLibDbHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "moor_baseLib.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<MoorAnalyticsBean, Integer> analyticsDao;

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final MoorBaseLibDbHelper sInstance = new MoorBaseLibDbHelper();

        private SingletonHolder() {
        }
    }

    public static MoorBaseLibDbHelper getInstance() {
        return SingletonHolder.sInstance;
    }

    public Dao<MoorAnalyticsBean, Integer> getAnalyticsDaoDao() throws SQLException {
        if (this.analyticsDao == null) {
            this.analyticsDao = getDao(MoorAnalyticsBean.class);
        }
        return this.analyticsDao;
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, MoorAnalyticsBean.class);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i2, int i3) {
        try {
            TableUtils.dropTable(connectionSource, MoorAnalyticsBean.class, true);
            onCreate(sQLiteDatabase, connectionSource);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    private MoorBaseLibDbHelper() {
        super(MoorBaseLibManager.getInstance().getApplication(), DATABASE_NAME, null, 1);
        this.analyticsDao = null;
    }
}
