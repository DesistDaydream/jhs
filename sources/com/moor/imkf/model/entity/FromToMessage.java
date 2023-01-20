package com.moor.imkf.model.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "fromToMessage")
/* loaded from: classes2.dex */
public class FromToMessage {
    public static final String MSG_TYPE_AUDIO = "voice";
    public static final String MSG_TYPE_BREAK_TIP = "breaktips";
    public static final String MSG_TYPE_CARD = "card";
    public static final String MSG_TYPE_CARDINFO = "cardInfo";
    public static final String MSG_TYPE_FILE = "file";
    public static final String MSG_TYPE_IFRAME = "iframe";
    public static final String MSG_TYPE_IMAGE = "image";
    public static final String MSG_TYPE_INVESTIGATE = "investigate";
    public static final String MSG_TYPE_INVESTIGATE_CANCEL = "investigateCancel";
    public static final String MSG_TYPE_INVESTIGATE_SUCCESS = "investigateSuccess";
    public static final String MSG_TYPE_LOGISTICS_INFO_LIST = "msgTask";
    public static final String MSG_TYPE_NEW_CARD = "newCard";
    public static final String MSG_TYPE_NEW_CARD_INFO = "newCardInfo";
    public static final String MSG_TYPE_RICHTEXT = "richText";
    public static final String MSG_TYPE_TAB_QUESTION = "NewPushQues";
    public static final String MSG_TYPE_TEXT = "text";
    public static final String MSG_TYPE_TRIP = "trip_query";
    public static final String MSG_TYPE_UNKNOWN = "UnknownMsg";
    public static final String MSG_TYPE_VIDEO = "video";
    public static final String MSG_TYPE_XBOT_FORM_DATA = "xbotForm";
    public static final String MSG_TYPE_XBOT_FORM_SUBMIT = "xbotFormSubmit";
    public static final String QUICK_MENU_LIST = "QuickMenuList";
    @DatabaseField(id = true, unique = true)
    public String _id;
    @DatabaseField
    public String accessId;
    @DatabaseField
    public String cardInfo;
    @DatabaseField
    public String chatId;
    @DatabaseField
    public String common_questions_group;
    @DatabaseField
    public String common_questions_img;
    @DatabaseField
    public String confidence;
    @DatabaseField
    public boolean dealMsg;
    @DatabaseField
    public String dealUserMsg;
    @DatabaseField
    public String deviceInfo;
    @DatabaseField
    public String displayName;
    @DatabaseField
    public String exten;
    @DatabaseField
    public String fileDownLoadStatus;
    @DatabaseField
    public String fileName;
    @DatabaseField
    public String filePath;
    @DatabaseField
    public Integer fileProgress;
    @DatabaseField
    public String fileSize;
    @DatabaseField
    public String fileUpLoadStatus;
    @DatabaseField
    public String fingerDown;
    @DatabaseField
    public String fingerUp;
    @DatabaseField
    public String flowList;
    @DatabaseField
    public boolean flowMultiSelect;
    @DatabaseField
    public String flowStyle;
    @DatabaseField
    public String flowTip;
    @DatabaseField
    public String flowType;
    @DatabaseField
    public String from;
    @DatabaseField
    public boolean hasEvaluated;
    @DatabaseField
    public Integer iframeHeight;
    @DatabaseField
    public Integer iframeWidth;
    @DatabaseField
    public String im_icon;
    @ForeignCollectionField(eager = true)
    public ForeignCollection<MsgInves> investigates;
    @DatabaseField
    public boolean isCacheShowVtoT = false;
    @DatabaseField
    public boolean isFlowSelect;
    @DatabaseField
    public boolean isFristXbotForm;
    @DatabaseField
    public boolean isRobot;
    @DatabaseField
    public boolean isShowVtoT;
    @DatabaseField
    public boolean isSubmitXbotForm;
    @DatabaseField
    public String message;
    @DatabaseField
    public String msgLRType;
    @DatabaseField
    public String msgTask;
    @DatabaseField
    public String msgType;
    @DatabaseField
    public String newCardInfo;
    @DatabaseField
    public String ori_question;
    @DatabaseField
    public String peedId;
    @DatabaseField
    public String questionId;
    @DatabaseField
    public Float recordTime;
    @DatabaseField
    public String richTextDescription;
    @DatabaseField
    public String richTextPicUrl;
    @DatabaseField
    public String richTextTitle;
    @DatabaseField
    public String richTextUrl;
    @DatabaseField
    public String robotId;
    @DatabaseField
    public String robotMsgId;
    @DatabaseField
    public String robotPingjia;
    @DatabaseField
    public String robotStatus;
    @DatabaseField
    public String robotType;
    @DatabaseField
    public String sendState;
    @DatabaseField
    public String sessionId;
    @DatabaseField
    public Boolean showHtml;
    @DatabaseField
    public String showOrderInfo;
    @DatabaseField
    public String sid;
    @DatabaseField
    public String std_question;
    @DatabaseField
    public String timeOut;
    @DatabaseField
    public String timeStamp;
    @DatabaseField
    public String tonotify;
    @DatabaseField
    public String type;
    @DatabaseField
    public String unread;
    @DatabaseField
    public String unread2;
    @DatabaseField
    public String user;
    @DatabaseField
    public String userId;
    @DatabaseField
    public String userType;
    @DatabaseField
    public String videoStatus;
    @DatabaseField
    public String voiceSecond;
    @DatabaseField
    public String voiceText;
    @DatabaseField
    public String voiceToText;
    @DatabaseField
    public Long when;
    @DatabaseField
    public boolean withDrawStatus;
    @DatabaseField
    public String xbotForm;
    @DatabaseField
    public String xbotFormSubmit;
}
