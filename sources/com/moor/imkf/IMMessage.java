package com.moor.imkf;

import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.db.dao.MsgInvesDao;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.Investigate;
import com.moor.imkf.model.entity.MsgInves;
import java.util.List;

/* loaded from: classes2.dex */
public class IMMessage {
    public static FromToMessage createAudioMessage(float f2, String str, String str2) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.msgType = "voice";
        fromToMessage.userType = "0";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        fromToMessage.recordTime = Float.valueOf(f2);
        fromToMessage.voiceSecond = Math.round(f2) + "";
        fromToMessage.filePath = str;
        fromToMessage.voiceText = str2;
        fromToMessage.sendState = "sending";
        return fromToMessage;
    }

    public static FromToMessage createBreakTipMessage(String str) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.message = str;
        fromToMessage.msgType = FromToMessage.MSG_TYPE_BREAK_TIP;
        fromToMessage.userType = "1";
        fromToMessage.showHtml = Boolean.TRUE;
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        return fromToMessage;
    }

    public static FromToMessage createFileMessage(String str, String str2, String str3, String str4) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.msgType = "file";
        fromToMessage.userType = "0";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        fromToMessage.filePath = str;
        fromToMessage.fileName = str2;
        fromToMessage.fileProgress = 0;
        fromToMessage.fileUpLoadStatus = str4;
        fromToMessage.fileSize = str3;
        return fromToMessage;
    }

    public static FromToMessage createImageMessage(String str) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.msgType = FromToMessage.MSG_TYPE_IMAGE;
        fromToMessage.userType = "0";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        fromToMessage.filePath = str;
        return fromToMessage;
    }

    public static FromToMessage createInvestigateCancelMessage(String str, String str2, String str3) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.message = "";
        fromToMessage.chatId = str;
        fromToMessage.msgType = FromToMessage.MSG_TYPE_INVESTIGATE_CANCEL;
        fromToMessage.userType = "1";
        fromToMessage.sendState = "true";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        fromToMessage.timeOut = str2;
        fromToMessage.timeStamp = str3;
        return fromToMessage;
    }

    public static void createInvestigateMessage(List<Investigate> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.msgType = "investigate";
        fromToMessage.userType = "0";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        fromToMessage.sendState = "true";
        MessageDao.getInstance().insertSendMsgsToDao(fromToMessage);
        for (int i2 = 0; i2 < list.size(); i2++) {
            MsgInves msgInves = new MsgInves();
            msgInves.name = list.get(i2).name;
            msgInves.value = list.get(i2).value;
            msgInves.msg = fromToMessage;
            MsgInvesDao.getInstance().insertOneMsgInvesToDao(msgInves);
        }
    }

    public static FromToMessage createInvestigateSuccessMessage(String str) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.message = str;
        fromToMessage.msgType = FromToMessage.MSG_TYPE_INVESTIGATE_SUCCESS;
        fromToMessage.userType = "0";
        fromToMessage.sendState = "true";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        return fromToMessage;
    }

    public static FromToMessage createLeaveTxtMessage(String str) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.message = str;
        fromToMessage.msgType = "text";
        fromToMessage.userType = "0";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        fromToMessage.sendState = "true";
        return fromToMessage;
    }

    public static FromToMessage createQuestionMessage(String str) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.message = str;
        fromToMessage.msgType = "text";
        fromToMessage.userType = "0";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        return fromToMessage;
    }

    public static FromToMessage createQuickMenuList(String str, long j2) {
        MessageDao.getInstance().deleteQuickMenuBtn();
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.message = str;
        fromToMessage.msgType = FromToMessage.QUICK_MENU_LIST;
        fromToMessage.userType = "1";
        fromToMessage.sendState = "true";
        if (j2 != 0) {
            fromToMessage.when = Long.valueOf(j2);
        } else {
            fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        }
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        return fromToMessage;
    }

    public static FromToMessage createTxtMessage(String str) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.message = str;
        fromToMessage.msgType = "text";
        fromToMessage.userType = "0";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        return fromToMessage;
    }

    public static FromToMessage createXbotFormMessage(String str) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.msgType = FromToMessage.MSG_TYPE_XBOT_FORM_SUBMIT;
        fromToMessage.userType = "0";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        fromToMessage.xbotFormSubmit = str;
        return fromToMessage;
    }

    public static FromToMessage createAudioMessage(float f2, String str) {
        FromToMessage fromToMessage = new FromToMessage();
        fromToMessage.msgType = "voice";
        fromToMessage.userType = "0";
        fromToMessage.when = Long.valueOf(System.currentTimeMillis());
        fromToMessage.sessionId = IMChat.getInstance().getSessionId();
        fromToMessage.tonotify = IMChat.getInstance().get_id();
        fromToMessage.type = "User";
        fromToMessage.from = IMChat.getInstance().get_id();
        fromToMessage.recordTime = Float.valueOf(f2);
        fromToMessage.voiceSecond = Math.round(f2) + "";
        fromToMessage.filePath = str;
        return fromToMessage;
    }
}
