package com.moor.imkf.db.dao;

import com.j256.ormlite.dao.Dao;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.db.DataBaseHelper;
import com.moor.imkf.model.entity.MsgInves;

/* loaded from: classes2.dex */
public class MsgInvesDao {
    private static MsgInvesDao instance;
    private DataBaseHelper helper;
    private Dao<MsgInves, Integer> investigateDao;

    private MsgInvesDao() {
        this.investigateDao = null;
        try {
            DataBaseHelper helper = DataBaseHelper.getHelper(IMChatManager.getInstance().getAppContext());
            this.helper = helper;
            this.investigateDao = helper.getMsgInvesDao();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static MsgInvesDao getInstance() {
        if (instance == null) {
            instance = new MsgInvesDao();
        }
        return instance;
    }

    public void insertOneMsgInvesToDao(MsgInves msgInves) {
        try {
            this.investigateDao.create((Dao<MsgInves, Integer>) msgInves);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
