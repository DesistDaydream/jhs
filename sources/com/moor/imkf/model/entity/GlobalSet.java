package com.moor.imkf.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "globalset")
/* loaded from: classes2.dex */
public class GlobalSet {
    @DatabaseField(id = true, unique = true)
    public String _id;
    @DatabaseField
    public String account;
    @DatabaseField
    public String badNum;
    @DatabaseField
    public String break_len;
    @DatabaseField
    public String break_tips;
    @DatabaseField
    public String break_tips_len;
    @DatabaseField
    public String chatCheck;
    @DatabaseField
    public String goodNum;
    @DatabaseField
    public String inviteLeavemsgTip;
    @DatabaseField
    public boolean isCustomerRead;
    @DatabaseField
    public String isLeaveMsg;
    @DatabaseField
    public String leavemsgTip;
    @DatabaseField
    public String mobileVideoChat;
    @DatabaseField
    public String mobileVideoChatIm;
    @DatabaseField
    public String msg;
    @DatabaseField
    public Boolean queueNumSwitch;
    @DatabaseField
    public String queueNumText;
    @DatabaseField
    public String replaceCustSwitch;
    @DatabaseField
    public String replaceCustomer;
    @DatabaseField
    public String robotType;
    @DatabaseField
    public String scheduleLeavemsgTip;
    @DatabaseField
    public boolean sdkTypeNoticeFlag;
    @DatabaseField
    public String setWarnMsg;
    @DatabaseField
    public String videoChatOn;
    @DatabaseField
    public String weixinMsg;
}
