package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.imsdk.v2.V2TIMMessageReceipt;

/* loaded from: classes3.dex */
public class MessageReceiptInfo {
    private V2TIMMessageReceipt messageReceipt;

    public V2TIMMessageReceipt getMessageReceipt() {
        return this.messageReceipt;
    }

    public long getTimestamp() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getTimestamp();
        }
        return 0L;
    }

    public String getUserID() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getUserID();
        }
        return null;
    }

    public void setMessageReceipt(V2TIMMessageReceipt v2TIMMessageReceipt) {
        this.messageReceipt = v2TIMMessageReceipt;
    }
}
