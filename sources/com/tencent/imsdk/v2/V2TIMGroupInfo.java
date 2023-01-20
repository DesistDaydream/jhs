package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupMemberInfo;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public class V2TIMGroupInfo implements Serializable {
    public static final String GROUP_TYPE_INTERNAL_CHATROOM = "ChatRoom";
    public static final String GROUP_TYPE_INTERNAL_PRIVATE = "Private";
    public static final int V2TIM_GROUP_ADD_ANY = 2;
    public static final int V2TIM_GROUP_ADD_AUTH = 1;
    public static final int V2TIM_GROUP_ADD_FORBID = 0;
    private final String TAG = "V2TIMGroupInfo";
    private GroupInfo groupInfo = new GroupInfo();
    private int modifyFlag = 0;

    public long getCreateTime() {
        return this.groupInfo.getCreateTime();
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.groupInfo.getCustomInfo();
    }

    public String getFaceUrl() {
        return this.groupInfo.getFaceUrl();
    }

    public int getGroupAddOpt() {
        long addOption = this.groupInfo.getAddOption();
        if (addOption == GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY) {
            return 2;
        }
        if (addOption == GroupInfo.GROUP_ADD_OPTION_FORBID_ANY) {
            return 0;
        }
        return addOption == ((long) GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION) ? 1 : 2;
    }

    public String getGroupID() {
        return this.groupInfo.getGroupID();
    }

    public GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public String getGroupName() {
        return this.groupInfo.getGroupName();
    }

    public String getGroupType() {
        String groupType = this.groupInfo.getGroupType();
        return groupType.equals("Private") ? "Work" : groupType.equals("ChatRoom") ? "Meeting" : groupType;
    }

    public String getIntroduction() {
        return this.groupInfo.getIntroduction();
    }

    public long getJoinTime() {
        return this.groupInfo.getGroupSelfInfo().getJoinTime();
    }

    public long getLastInfoTime() {
        return this.groupInfo.getGroupInfoTimestamp();
    }

    public long getLastMessageTime() {
        return this.groupInfo.getLastMessageTimestamp();
    }

    public int getMemberCount() {
        return (int) this.groupInfo.getMemberCount();
    }

    public long getMemberMaxCount() {
        return this.groupInfo.getMemberMaxCount();
    }

    public int getModifyFlag() {
        return this.modifyFlag;
    }

    public String getNotification() {
        return this.groupInfo.getNotification();
    }

    public int getOnlineCount() {
        return (int) this.groupInfo.getMemberOnlineCount();
    }

    public String getOwner() {
        return this.groupInfo.getOwnerUserID();
    }

    public int getRecvOpt() {
        int messageReceiveOption = this.groupInfo.getGroupSelfInfo().getMessageReceiveOption();
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE) {
            return 0;
        }
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE) {
            return 1;
        }
        return messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH ? 2 : 0;
    }

    public int getRole() {
        int role = this.groupInfo.getGroupSelfInfo().getRole();
        if (role == GroupMemberInfo.MEMBER_ROLE_MEMBER) {
            return 200;
        }
        if (role == GroupMemberInfo.MEMBER_ROLE_ADMINISTRATOR) {
            return 300;
        }
        return role == GroupMemberInfo.MEMBER_ROLE_OWNER ? 400 : 0;
    }

    public boolean isAllMuted() {
        return this.groupInfo.isAllShutUp();
    }

    public boolean isSupportTopic() {
        return this.groupInfo.isSupportTopic();
    }

    public void setAllMuted(boolean z) {
        this.groupInfo.setAllShutUp(z);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_SHUTUP_ALL);
    }

    public void setCustomInfo(Map<String, byte[]> map) {
        if (map == null) {
            return;
        }
        this.groupInfo.setCustomInfo(map);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_CUSTOM_INFO);
    }

    public void setFaceUrl(String str) {
        this.groupInfo.setFaceUrl(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_FACE_URL);
    }

    public void setGroupAddOpt(int i2) {
        if (2 == i2) {
            this.groupInfo.setAddOption(GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY);
        } else if (i2 == 0) {
            this.groupInfo.setAddOption(GroupInfo.GROUP_ADD_OPTION_FORBID_ANY);
        } else if (1 == i2) {
            this.groupInfo.setAddOption(GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION);
        }
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_ADD_OPTION);
    }

    public void setGroupID(String str) {
        this.groupInfo.setGroupID(str);
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public void setGroupName(String str) {
        this.groupInfo.setGroupName(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NAME);
    }

    public void setGroupType(String str) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMGroupInfo", "setGroupType error type is null");
            return;
        }
        if (!str.equalsIgnoreCase("Work")) {
            if (!str.equalsIgnoreCase("Meeting")) {
                if (!str.equalsIgnoreCase("Private")) {
                    if (!str.equalsIgnoreCase("ChatRoom")) {
                        if (str.equalsIgnoreCase("Public")) {
                            str = "Public";
                        } else if (str.equalsIgnoreCase("AVChatRoom")) {
                            str = "AVChatRoom";
                        }
                        this.groupInfo.setGroupType(str);
                    }
                }
            }
            str = "ChatRoom";
            this.groupInfo.setGroupType(str);
        }
        str = "Private";
        this.groupInfo.setGroupType(str);
    }

    public void setIntroduction(String str) {
        this.groupInfo.setIntroduction(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_INTRODUCTION);
    }

    public void setModifyFlag(int i2) {
        this.modifyFlag = i2;
    }

    public void setNotification(String str) {
        this.groupInfo.setNotification(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NOTIFICATION);
    }

    public void setSupportTopic(boolean z) {
        this.groupInfo.setSupportTopic(z);
    }
}
