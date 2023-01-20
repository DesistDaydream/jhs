package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.imsdk.v2.V2TIMMessageReceipt;

/* loaded from: classes3.dex */
public class GroupMessageReceiptInfo {
    private V2TIMMessageReceipt messageReceipt;

    public String getGroupID() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getGroupID();
        }
        return null;
    }

    public String getMsgID() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getMsgID();
        }
        return null;
    }

    public long getReadCount() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getReadCount();
        }
        return 0L;
    }

    public long getUnreadCount() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getUnreadCount();
        }
        return 0L;
    }

    public void setMessageReceipt(V2TIMMessageReceipt v2TIMMessageReceipt) {
        this.messageReceipt = v2TIMMessageReceipt;
    }
}
