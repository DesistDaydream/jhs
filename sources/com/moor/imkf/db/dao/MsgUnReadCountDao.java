package com.moor.imkf.db.dao;

import com.j256.ormlite.dao.Dao;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.db.DataBaseHelper;
import com.moor.imkf.model.entity.MsgUnReadCount;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MsgUnReadCountDao {
    private static MsgUnReadCountDao instance;
    private DataBaseHelper helper;
    private Dao<MsgUnReadCount, Integer> msgUnReadDao;

    private MsgUnReadCountDao() {
        this.msgUnReadDao = null;
        try {
            DataBaseHelper helper = DataBaseHelper.getHelper(IMChatManager.getInstance().getAppContext());
            this.helper = helper;
            this.msgUnReadDao = helper.getMsgUnReadCountDao();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static MsgUnReadCountDao getInstance() {
        if (instance == null) {
            instance = new MsgUnReadCountDao();
        }
        return instance;
    }

    public void createMsgUnReadCount(MsgUnReadCount msgUnReadCount) {
        try {
            this.msgUnReadDao.createIfNotExists(msgUnReadCount);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void deleteAll() {
        try {
            Dao<MsgUnReadCount, Integer> dao = this.msgUnReadDao;
            dao.delete(dao.queryForAll());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int getUnReadCount(String str) {
        new ArrayList();
        int i2 = 0;
        try {
            List<MsgUnReadCount> query = this.msgUnReadDao.queryBuilder().where().eq(IMChatManager.CONSTANT_SESSIONID, str).query();
            int i3 = 0;
            while (i2 < query.size()) {
                try {
                    i3 = query.get(i2).msgUnReadCount;
                    i2++;
                } catch (Exception e2) {
                    e = e2;
                    i2 = i3;
                    e.printStackTrace();
                    return i2;
                }
            }
            return i3;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void setUnReadCount(String str, int i2) {
        new ArrayList();
        try {
            List<MsgUnReadCount> query = this.msgUnReadDao.queryBuilder().where().eq(IMChatManager.CONSTANT_SESSIONID, str).query();
            for (int i3 = 0; i3 < query.size(); i3++) {
                query.get(i3).msgUnReadCount = i2;
                this.msgUnReadDao.update((Dao<MsgUnReadCount, Integer>) query.get(i3));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateUnReadCount(String str) {
        new ArrayList();
        try {
            List<MsgUnReadCount> query = this.msgUnReadDao.queryBuilder().where().eq(IMChatManager.CONSTANT_SESSIONID, str).query();
            for (int i2 = 0; i2 < query.size(); i2++) {
                query.get(i2).msgUnReadCount = 0;
                this.msgUnReadDao.update((Dao<MsgUnReadCount, Integer>) query.get(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
