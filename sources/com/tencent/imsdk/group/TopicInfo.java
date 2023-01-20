package com.tencent.imsdk.group;

import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.message.DraftMessage;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TopicInfo implements Serializable {
    private Conversation conversation;
    private String draftText;
    private int errorCode;
    private String errorMessage;
    private GroupInfo groupInfo = new GroupInfo();

    public Conversation getConversation() {
        return this.conversation;
    }

    public String getDraftText() {
        DraftMessage draftMessage;
        byte[] userDefinedData;
        Conversation conversation = this.conversation;
        if (conversation == null || (draftMessage = conversation.getDraftMessage()) == null || (userDefinedData = draftMessage.getUserDefinedData()) == null) {
            return null;
        }
        return new String(userDefinedData);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public String getTempDraft() {
        return this.draftText;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public void setTempDraft(String str) {
        this.draftText = str;
    }
}
