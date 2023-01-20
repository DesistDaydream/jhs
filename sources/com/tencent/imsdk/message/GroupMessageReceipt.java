package com.tencent.imsdk.message;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class GroupMessageReceipt implements Serializable {
    private String groupID;
    private String msgID;
    private long readCount;
    private long unreadCount;

    public String getGroupID() {
        return this.groupID;
    }

    public String getMsgID() {
        return this.msgID;
    }

    public long getReadCount() {
        return this.readCount;
    }

    public long getUnreadCount() {
        return this.unreadCount;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setMsgID(String str) {
        this.msgID = str;
    }

    public void setReadCount(long j2) {
        this.readCount = j2;
    }

    public void setUnreadCount(long j2) {
        this.unreadCount = j2;
    }
}
