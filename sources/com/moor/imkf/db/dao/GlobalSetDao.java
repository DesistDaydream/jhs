package com.moor.imkf.db.dao;

import com.j256.ormlite.dao.Dao;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.db.DataBaseHelper;
import com.moor.imkf.model.entity.GlobalSet;

/* loaded from: classes2.dex */
public class GlobalSetDao {
    private static GlobalSetDao instance;
    private Dao<GlobalSet, Integer> globalDao;
    private DataBaseHelper helper;

    private GlobalSetDao() {
        this.globalDao = null;
        try {
            DataBaseHelper helper = DataBaseHelper.getHelper(IMChatManager.getInstance().getAppContext());
            this.helper = helper;
            this.globalDao = helper.getGlobalSetDao();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static GlobalSetDao getInstance() {
        if (instance == null) {
            instance = new GlobalSetDao();
        }
        return instance;
    }

    public void deleteGlobalSetToDao() {
        try {
            Dao<GlobalSet, Integer> dao = this.globalDao;
            dao.delete(dao.queryForAll());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public GlobalSet getGlobalSet() {
        try {
            if (this.globalDao.queryForAll() == null || this.globalDao.queryForAll().size() <= 0) {
                return null;
            }
            return this.globalDao.queryForAll().get(0);
        } catch (Exception unused) {
            return null;
        }
    }

    public void insertGlobalSetToDao(GlobalSet globalSet) {
        try {
            this.globalDao.create((Dao<GlobalSet, Integer>) globalSet);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
