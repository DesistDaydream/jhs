package com.moor.imkf.db.dao;

import com.j256.ormlite.dao.Dao;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.db.DataBaseHelper;
import com.moor.imkf.model.entity.Info;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class InfoDao {
    private static InfoDao instance;
    private DataBaseHelper helper;
    private Dao<Info, Integer> infoDao;

    private InfoDao() {
        this.infoDao = null;
        try {
            DataBaseHelper helper = DataBaseHelper.getHelper(IMChatManager.getInstance().getAppContext());
            this.helper = helper;
            this.infoDao = helper.getInfoDao();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static InfoDao getInstance() {
        if (instance == null) {
            instance = new InfoDao();
        }
        return instance;
    }

    public void deleteAll() {
        Dao<Info, Integer> dao = this.infoDao;
        if (dao == null) {
            return;
        }
        try {
            dao.delete(dao.queryForAll());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String getAccessId() {
        Dao<Info, Integer> dao = this.infoDao;
        if (dao == null) {
            return "";
        }
        try {
            Info info = dao.queryForAll().get(0);
            if (info != null) {
                return info.accessId;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public String getConnectionId() {
        Dao<Info, Integer> dao = this.infoDao;
        if (dao == null) {
            return "";
        }
        try {
            Info info = dao.queryForAll().get(0);
            if (info != null) {
                return info.connectionId;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public String getImServiceNo() {
        Dao<Info, Integer> dao = this.infoDao;
        if (dao == null) {
            return "";
        }
        try {
            Info info = dao.queryForAll().get(0);
            if (info != null) {
                return info.imServiceNo;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public String getLoginName() {
        Dao<Info, Integer> dao = this.infoDao;
        if (dao == null) {
            return "";
        }
        try {
            Info info = dao.queryForAll().get(0);
            if (info != null) {
                return info.loginName;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public String getPeedId() {
        Dao<Info, Integer> dao = this.infoDao;
        if (dao == null) {
            return "";
        }
        try {
            Info info = dao.queryForAll().get(0);
            if (info != null) {
                return info.peedId;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public String getUserId() {
        Dao<Info, Integer> dao = this.infoDao;
        if (dao == null) {
            return "";
        }
        try {
            Info info = dao.queryForAll().get(0);
            if (info != null) {
                return info.userId;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public void insertInfoToDao(Info info) {
        Dao<Info, Integer> dao = this.infoDao;
        if (dao == null) {
            return;
        }
        try {
            dao.delete(dao.queryForAll());
            this.infoDao.create((Dao<Info, Integer>) info);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void saveConnectionId(String str) {
        Dao<Info, Integer> dao = this.infoDao;
        if (dao == null) {
            return;
        }
        try {
            Info info = dao.queryForAll().get(0);
            if (info != null) {
                info.connectionId = str;
                this.infoDao.update((Dao<Info, Integer>) info);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updataPeedID(String str) {
        try {
            Info info = this.infoDao.queryForAll().get(0);
            if (info != null) {
                info.peedId = str;
            }
            this.infoDao.update((Dao<Info, Integer>) info);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
}
