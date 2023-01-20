package com.tencent.imsdk.conversation;

/* loaded from: classes3.dex */
public class ConversationKey {
    public static final int TYPE_C2C = 1;
    public static final int TYPE_GROUP = 2;
    private String conversationID;
    private int conversationType;

    public String getConversationID() {
        return this.conversationID;
    }

    public int getConversationType() {
        return this.conversationType;
    }

    public void setConversationID(String str) {
        this.conversationID = str;
    }

    public void setConversationType(int i2) {
        this.conversationType = i2;
    }
}
