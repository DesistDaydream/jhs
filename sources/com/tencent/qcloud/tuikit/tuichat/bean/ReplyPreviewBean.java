package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;

/* loaded from: classes3.dex */
public class ReplyPreviewBean {
    public static final int VERSION = 1;
    private String messageAbstract;
    private String messageID;
    private String messageSender;
    private long messageSequence;
    private long messageTime;
    private int messageType;
    private transient TUIMessageBean originalMessageBean;
    private int version = 1;

    public String getMessageAbstract() {
        return this.messageAbstract;
    }

    public String getMessageID() {
        return this.messageID;
    }

    public String getMessageSender() {
        return this.messageSender;
    }

    public long getMessageSequence() {
        return this.messageSequence;
    }

    public long getMessageTime() {
        return this.messageTime;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public TUIMessageBean getOriginalMessageBean() {
        return this.originalMessageBean;
    }

    public int getVersion() {
        return this.version;
    }

    public void setMessageAbstract(String str) {
        this.messageAbstract = str;
    }

    public void setMessageID(String str) {
        this.messageID = str;
    }

    public void setMessageSender(String str) {
        this.messageSender = str;
    }

    public void setMessageSequence(long j2) {
        this.messageSequence = j2;
    }

    public void setMessageTime(long j2) {
        this.messageTime = j2;
    }

    public void setMessageType(int i2) {
        this.messageType = i2;
    }

    public void setOriginalMessageBean(TUIMessageBean tUIMessageBean) {
        this.originalMessageBean = tUIMessageBean;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }
}
