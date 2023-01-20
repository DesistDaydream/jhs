package com.moor.imkf.db.dao;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.db.DataBaseHelper;
import com.moor.imkf.model.entity.FromToMessage;
import com.tencent.bugly.Bugly;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public class MessageDao {
    private static MessageDao instance;
    private Dao<FromToMessage, Integer> fromToMessageDao;
    private DataBaseHelper helper;

    private MessageDao() {
        this.fromToMessageDao = null;
        try {
            DataBaseHelper helper = DataBaseHelper.getHelper(IMChatManager.getInstance().getAppContext());
            this.helper = helper;
            this.fromToMessageDao = helper.getFromMessageDao();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static MessageDao getInstance() {
        if (instance == null) {
            instance = new MessageDao();
        }
        return instance;
    }

    public void delecteCardMsgs() {
        try {
            this.fromToMessageDao.delete(this.fromToMessageDao.queryBuilder().where().eq("msgType", FromToMessage.MSG_TYPE_CARD).query());
        } catch (Exception unused) {
        }
    }

    public void delecteNewCardMsgs() {
        try {
            this.fromToMessageDao.delete(this.fromToMessageDao.queryBuilder().where().eq("msgType", FromToMessage.MSG_TYPE_NEW_CARD).query());
        } catch (Exception unused) {
        }
    }

    public void deleteAllMsgs() {
        try {
            Dao<FromToMessage, Integer> dao = this.fromToMessageDao;
            dao.delete(dao.queryForAll());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void deleteBreakTipMsgs() {
        try {
            this.fromToMessageDao.delete(this.fromToMessageDao.queryBuilder().where().eq("msgType", FromToMessage.MSG_TYPE_BREAK_TIP).query());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void deleteMsg(FromToMessage fromToMessage) {
        try {
            this.fromToMessageDao.delete((Dao<FromToMessage, Integer>) fromToMessage);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void deleteQuickMenuBtn() {
        try {
            this.fromToMessageDao.delete(this.fromToMessageDao.queryBuilder().where().eq("msgType", FromToMessage.QUICK_MENU_LIST).query());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public ArrayList<String> getAllMsgId() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            List<FromToMessage> queryForAll = this.fromToMessageDao.queryForAll();
            for (int i2 = 0; i2 < queryForAll.size(); i2++) {
                arrayList.add(queryForAll.get(i2)._id);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public List<FromToMessage> getFirstMessage(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            return this.fromToMessageDao.queryBuilder().orderBy("id", false).limit(1L).where().eq("from", str).query();
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public FromToMessage getMessageById(String str) {
        try {
            return this.fromToMessageDao.queryBuilder().where().eq("_id", str).query().get(0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<FromToMessage> getMessagesByAccessId(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            return this.fromToMessageDao.queryBuilder().orderBy(RemoteMessageConst.Notification.WHEN, false).where().eq("accessId", str).query();
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public List<FromToMessage> getMessagesFromAccessId(int i2) {
        ArrayList arrayList = new ArrayList();
        try {
            return this.fromToMessageDao.queryBuilder().orderBy(RemoteMessageConst.Notification.WHEN, false).limit(15L).offset(Long.valueOf((i2 - 1) * 15)).where().eq("accessId", InfoDao.getInstance().getAccessId()).query();
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public List<FromToMessage> getMessagesFromPeedId(int i2) {
        ArrayList arrayList = new ArrayList();
        try {
            return this.fromToMessageDao.queryBuilder().orderBy(RemoteMessageConst.Notification.WHEN, false).limit(15L).offset(Long.valueOf((i2 - 1) * 15)).where().eq(YKFConstants.TYPE_PEER, InfoDao.getInstance().getPeedId()).query();
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public List<FromToMessage> getMessagesFromUserId(int i2) {
        ArrayList arrayList = new ArrayList();
        try {
            return this.fromToMessageDao.queryBuilder().orderBy(RemoteMessageConst.Notification.WHEN, false).limit(15L).offset(Long.valueOf((i2 - 1) * 15)).where().eq(TUIConstants.TUILive.USER_ID, InfoDao.getInstance().getUserId()).query();
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public List<FromToMessage> getSendingMessages() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.fromToMessageDao.queryBuilder().where().eq("sendState", "sending").query();
        } catch (Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    public ArrayList<String> getUnReadDao() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            List<FromToMessage> query = this.fromToMessageDao.queryBuilder().where().eq("unread", "1").query();
            for (int i2 = 0; i2 < query.size(); i2++) {
                arrayList.add(query.get(i2)._id);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public FromToMessage getisFristXbotFormMessages() {
        List<FromToMessage> arrayList = new ArrayList<>();
        try {
            arrayList = this.fromToMessageDao.queryBuilder().where().eq("isFristXbotForm", Boolean.TRUE).query();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    public void insertGetMsgsToDao(List<FromToMessage> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                list.get(i2).unread = "1";
                list.get(i2).unread2 = "1";
                if (YKFConstants.INVESTIGATE_TYPE_OUT.equals(list.get(i2).msgLRType)) {
                    list.get(i2).userType = "1";
                } else {
                    list.get(i2).userType = "0";
                }
                list.get(i2).sendState = "true";
                list.get(i2).peedId = InfoDao.getInstance().getPeedId();
                this.fromToMessageDao.create((Dao<FromToMessage, Integer>) list.get(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void insertMsgToDao(FromToMessage fromToMessage) {
        if (fromToMessage != null) {
            fromToMessage.accessId = InfoDao.getInstance().getAccessId();
            fromToMessage.userId = InfoDao.getInstance().getUserId();
            fromToMessage.peedId = InfoDao.getInstance().getPeedId();
            try {
                this.fromToMessageDao.create((Dao<FromToMessage, Integer>) fromToMessage);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void insertSendMsgsToDao(FromToMessage fromToMessage) {
        try {
            if (TextUtils.isEmpty(fromToMessage._id)) {
                fromToMessage._id = UUID.randomUUID().toString();
                fromToMessage.accessId = InfoDao.getInstance().getAccessId();
                fromToMessage.userId = InfoDao.getInstance().getUserId();
                fromToMessage.peedId = InfoDao.getInstance().getPeedId();
                this.fromToMessageDao.create((Dao<FromToMessage, Integer>) fromToMessage);
            } else {
                List<FromToMessage> query = this.fromToMessageDao.queryBuilder().where().eq("_id", fromToMessage._id).query();
                if (query.size() == 0) {
                    fromToMessage._id = UUID.randomUUID().toString();
                    fromToMessage.accessId = InfoDao.getInstance().getAccessId();
                    fromToMessage.userId = InfoDao.getInstance().getUserId();
                    fromToMessage.peedId = InfoDao.getInstance().getPeedId();
                    this.fromToMessageDao.create((Dao<FromToMessage, Integer>) fromToMessage);
                } else {
                    query.get(0);
                    fromToMessage.accessId = InfoDao.getInstance().getAccessId();
                    fromToMessage.userId = InfoDao.getInstance().getUserId();
                    fromToMessage.peedId = InfoDao.getInstance().getPeedId();
                    this.fromToMessageDao.update((Dao<FromToMessage, Integer>) fromToMessage);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Boolean isReachEndMessageFromAccessId(int i2) {
        new ArrayList();
        Boolean bool = Boolean.FALSE;
        try {
            return i2 >= this.fromToMessageDao.queryBuilder().where().eq("accessId", InfoDao.getInstance().getAccessId()).query().size() ? Boolean.TRUE : bool;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bool;
        }
    }

    public Boolean isReachEndMessageFromPeedId(int i2) {
        new ArrayList();
        Boolean bool = Boolean.FALSE;
        try {
            return i2 >= this.fromToMessageDao.queryBuilder().where().eq(YKFConstants.TYPE_PEER, InfoDao.getInstance().getPeedId()).query().size() ? Boolean.TRUE : bool;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bool;
        }
    }

    public Boolean isReachEndMessageFromUserId(int i2) {
        new ArrayList();
        Boolean bool = Boolean.FALSE;
        try {
            return i2 >= this.fromToMessageDao.queryBuilder().where().eq(TUIConstants.TUILive.USER_ID, InfoDao.getInstance().getUserId()).query().size() ? Boolean.TRUE : bool;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bool;
        }
    }

    public void upFristXbotForm() {
        UpdateBuilder<FromToMessage, Integer> updateBuilder = this.fromToMessageDao.updateBuilder();
        try {
            updateBuilder.updateColumnValue("isFristXbotForm", Boolean.FALSE);
            updateBuilder.update();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public void updateAllisShowVT() {
        UpdateBuilder<FromToMessage, Integer> updateBuilder = this.fromToMessageDao.updateBuilder();
        try {
            Boolean bool = Boolean.FALSE;
            updateBuilder.updateColumnValue("isShowVtoT", bool);
            updateBuilder.updateColumnValue("isCacheShowVtoT", bool);
            updateBuilder.update();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public void updateFailedMsgToDao(FromToMessage fromToMessage) {
        try {
            FromToMessage fromToMessage2 = this.fromToMessageDao.queryBuilder().where().eq("_id", fromToMessage._id).query().get(0);
            fromToMessage2.sendState = Bugly.SDK_IS_DEV;
            this.fromToMessageDao.update((Dao<FromToMessage, Integer>) fromToMessage2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateFlowAllChoose() {
        UpdateBuilder<FromToMessage, Integer> updateBuilder = this.fromToMessageDao.updateBuilder();
        try {
            updateBuilder.updateColumnValue("isFlowSelect", Boolean.TRUE);
            updateBuilder.update();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public void updateFlowChoose(String str, boolean z) {
        this.fromToMessageDao.updateBuilder();
        try {
            FromToMessage fromToMessage = this.fromToMessageDao.queryBuilder().where().eq("_id", str).query().get(0);
            fromToMessage.isFlowSelect = z;
            this.fromToMessageDao.update((Dao<FromToMessage, Integer>) fromToMessage);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public void updateFlowList(String str, String str2) {
        this.fromToMessageDao.updateBuilder();
        try {
            FromToMessage fromToMessage = this.fromToMessageDao.queryBuilder().where().eq("_id", str).query().get(0);
            fromToMessage.flowList = str2;
            this.fromToMessageDao.update((Dao<FromToMessage, Integer>) fromToMessage);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public void updateHasEvaluatedByChatId(String str) {
        UpdateBuilder<FromToMessage, Integer> updateBuilder = this.fromToMessageDao.updateBuilder();
        try {
            updateBuilder.where().eq("chatId", str);
            updateBuilder.updateColumnValue("hasEvaluated", Boolean.TRUE);
            updateBuilder.update();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateMsgToDao(FromToMessage fromToMessage) {
        try {
            this.fromToMessageDao.queryBuilder().where().eq("_id", fromToMessage._id).query().get(0);
            this.fromToMessageDao.update((Dao<FromToMessage, Integer>) fromToMessage);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateMsgWithDrawStatus(String str) {
        try {
            FromToMessage fromToMessage = this.fromToMessageDao.queryBuilder().where().eq("_id", str).query().get(0);
            fromToMessage.withDrawStatus = true;
            this.fromToMessageDao.update((Dao<FromToMessage, Integer>) fromToMessage);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateMsgsIdDao() {
        new ArrayList();
        try {
            List<FromToMessage> query = this.fromToMessageDao.queryBuilder().where().eq("unread", "1").query();
            for (int i2 = 0; i2 < query.size(); i2++) {
                if (!query.get(i2).msgType.equals("2")) {
                    query.get(i2).unread = "0";
                    this.fromToMessageDao.update((Dao<FromToMessage, Integer>) query.get(i2));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateMsgsIdDaoWithDraw() {
        new ArrayList();
        try {
            List<FromToMessage> query = this.fromToMessageDao.queryBuilder().where().eq("unread", "1").query();
            for (int i2 = 0; i2 < query.size(); i2++) {
                if (!query.get(i2).withDrawStatus) {
                    query.get(i2).unread = "0";
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateOrderInfoToDao(String str, String str2) {
        try {
            UpdateBuilder<FromToMessage, Integer> updateBuilder = this.fromToMessageDao.updateBuilder();
            updateBuilder.where().eq("_id", str);
            updateBuilder.updateColumnValue("showOrderInfo", str2);
            updateBuilder.update();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateSendMsgFail() {
        UpdateBuilder<FromToMessage, Integer> updateBuilder = this.fromToMessageDao.updateBuilder();
        try {
            updateBuilder.where().eq("sendState", "sending");
            updateBuilder.updateColumnValue("sendState", Bugly.SDK_IS_DEV);
            updateBuilder.update();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateSendingMsgToDao(FromToMessage fromToMessage) {
        try {
            FromToMessage fromToMessage2 = this.fromToMessageDao.queryBuilder().where().eq("_id", fromToMessage._id).query().get(0);
            fromToMessage2.sendState = "sending";
            this.fromToMessageDao.update((Dao<FromToMessage, Integer>) fromToMessage2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateSucceedMsgToDao(FromToMessage fromToMessage, long j2, String str) {
        try {
            FromToMessage fromToMessage2 = this.fromToMessageDao.queryBuilder().where().eq("_id", fromToMessage._id).query().get(0);
            fromToMessage2.sendState = "true";
            if (j2 > 0) {
                fromToMessage2.when = Long.valueOf(j2);
            }
            if ("text".equals(fromToMessage2.msgType)) {
                fromToMessage2.message = str;
            }
            this.fromToMessageDao.update((Dao<FromToMessage, Integer>) fromToMessage2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateUnReadToRead() {
        UpdateBuilder<FromToMessage, Integer> updateBuilder = this.fromToMessageDao.updateBuilder();
        try {
            updateBuilder.updateColumnValue("dealUserMsg", "true");
            updateBuilder.where().eq("dealUserMsg", Bugly.SDK_IS_DEV).and().eq("sendState", "true");
            updateBuilder.update();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public void updateXbotForm(String str) {
        UpdateBuilder<FromToMessage, Integer> updateBuilder = this.fromToMessageDao.updateBuilder();
        try {
            if (!TextUtils.isEmpty(str)) {
                FromToMessage fromToMessage = this.fromToMessageDao.queryBuilder().where().eq("_id", str).query().get(0);
                fromToMessage.isSubmitXbotForm = true;
                this.fromToMessageDao.update((Dao<FromToMessage, Integer>) fromToMessage);
            } else {
                try {
                    updateBuilder.updateColumnValue("isSubmitXbotForm", Boolean.TRUE);
                    updateBuilder.update();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (SQLException e3) {
            e3.printStackTrace();
        }
    }
}
