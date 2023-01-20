package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationAtInfo;
import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.TopicInfo;
import com.tencent.imsdk.message.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class V2TIMTopicInfo implements Serializable {
    private boolean needModifyDraft = false;
    private TopicInfo topicInfo = new TopicInfo();
    private int modifyFlag = 0;

    public String getCustomString() {
        return this.topicInfo.getGroupInfo().getCustomString();
    }

    public String getDraftText() {
        return this.topicInfo.getDraftText();
    }

    public List<V2TIMGroupAtInfo> getGroupAtInfoList() {
        if (this.topicInfo.getConversation() == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (ConversationAtInfo conversationAtInfo : this.topicInfo.getConversation().getConversationAtInfoList()) {
            V2TIMGroupAtInfo v2TIMGroupAtInfo = new V2TIMGroupAtInfo();
            v2TIMGroupAtInfo.setConversationGroupAtInfo(conversationAtInfo);
            arrayList.add(v2TIMGroupAtInfo);
        }
        return arrayList;
    }

    public GroupInfo getGroupInfo() {
        return this.topicInfo.getGroupInfo();
    }

    public String getIntroduction() {
        return this.topicInfo.getGroupInfo().getIntroduction();
    }

    public V2TIMMessage getLastMessage() {
        Message lastMessage;
        Conversation conversation = this.topicInfo.getConversation();
        if (conversation == null || (lastMessage = conversation.getLastMessage()) == null) {
            return null;
        }
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setMessage(lastMessage);
        return v2TIMMessage;
    }

    public int getModifyFlag() {
        return this.modifyFlag;
    }

    public String getNotification() {
        return this.topicInfo.getGroupInfo().getNotification();
    }

    public int getRecvOpt() {
        int messageReceiveOption = this.topicInfo.getGroupInfo().getGroupSelfInfo().getMessageReceiveOption();
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE) {
            return 0;
        }
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE) {
            return 1;
        }
        return messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH ? 2 : 0;
    }

    public long getSelfMuteTime() {
        return this.topicInfo.getGroupInfo().getGroupSelfInfo().getShutUpTime();
    }

    public String getTopicFaceUrl() {
        return this.topicInfo.getGroupInfo().getFaceUrl();
    }

    public String getTopicID() {
        return this.topicInfo.getGroupInfo().getGroupID();
    }

    public TopicInfo getTopicInfo() {
        return this.topicInfo;
    }

    public String getTopicName() {
        return this.topicInfo.getGroupInfo().getGroupName();
    }

    public long getUnreadCount() {
        Conversation conversation = this.topicInfo.getConversation();
        if (conversation == null) {
            return 0L;
        }
        return conversation.getUnreadMessageCount();
    }

    public boolean isAllMute() {
        return this.topicInfo.getGroupInfo().isAllShutUp();
    }

    public boolean isNeedModifyDraft() {
        return this.needModifyDraft;
    }

    public void setAllMute(boolean z) {
        this.topicInfo.getGroupInfo().setAllShutUp(z);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_SHUTUP_ALL);
    }

    public void setCustomString(String str) {
        this.topicInfo.getGroupInfo().setCustomString(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.TOPIC_INFO_MODIFY_FLAG_CUSTOM_STRING);
    }

    public void setDraft(String str) {
        this.needModifyDraft = true;
        this.topicInfo.setTempDraft(str);
    }

    public void setIntroduction(String str) {
        this.topicInfo.getGroupInfo().setIntroduction(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_INTRODUCTION);
    }

    public void setNotification(String str) {
        this.topicInfo.getGroupInfo().setNotification(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NOTIFICATION);
    }

    public void setTopicFaceUrl(String str) {
        this.topicInfo.getGroupInfo().setFaceUrl(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_FACE_URL);
    }

    public void setTopicID(String str) {
        this.topicInfo.getGroupInfo().setGroupID(str);
    }

    public void setTopicInfo(TopicInfo topicInfo) {
        if (topicInfo == null) {
            return;
        }
        this.topicInfo = topicInfo;
    }

    public void setTopicName(String str) {
        this.topicInfo.getGroupInfo().setGroupName(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NAME);
    }
}
