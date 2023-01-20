package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class GroupInfo implements Serializable {
    public static int GROUP_ADD_OPTION_ALLOW_ANY = 3;
    public static int GROUP_ADD_OPTION_FORBID_ANY = 1;
    public static int GROUP_ADD_OPTION_NEED_AUTHENTICATION = 2;
    public static long GROUP_INFO_MODIFY_FLAG_ADD_OPTION = 16;
    public static long GROUP_INFO_MODIFY_FLAG_CUSTOM_INFO = 512;
    public static long GROUP_INFO_MODIFY_FLAG_FACE_URL = 8;
    public static long GROUP_INFO_MODIFY_FLAG_GROUP_SEARCHABLE = 128;
    public static long GROUP_INFO_MODIFY_FLAG_INTRODUCTION = 4;
    public static long GROUP_INFO_MODIFY_FLAG_MAX_MEMBER_NUM = 32;
    public static long GROUP_INFO_MODIFY_FLAG_MEMBER_VISIBLE = 64;
    public static long GROUP_INFO_MODIFY_FLAG_NAME = 1;
    public static long GROUP_INFO_MODIFY_FLAG_NONE = 0;
    public static long GROUP_INFO_MODIFY_FLAG_NOTIFICATION = 2;
    public static long GROUP_INFO_MODIFY_FLAG_SHUTUP_ALL = 256;
    public static long TOPIC_INFO_MODIFY_FLAG_CUSTOM_STRING = 2048;
    private int addOption;
    private String communityID;
    private long createTime;
    private String customString;
    private String faceUrl;
    private String groupID;
    private long groupInfoTimestamp;
    private String groupName;
    private String groupType;
    private String introduction;
    private boolean isAllShutUp;
    private boolean isGroupMemberVisible;
    private boolean isGroupSearchable;
    private long lastMessageTimestamp;
    private long memberCount;
    private long memberMaxCount;
    private long memberOnlineCount;
    private String notification;
    private String ownerUserID;
    private boolean supportTopic;
    private Map<String, byte[]> customInfo = new HashMap();
    private GroupMemberInfo groupSelfInfo = new GroupMemberInfo();

    public int getAddOption() {
        return this.addOption;
    }

    public String getCommunityID() {
        return this.communityID;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.customInfo;
    }

    public String getCustomString() {
        return this.customString;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public long getGroupInfoTimestamp() {
        return this.groupInfoTimestamp;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public GroupMemberInfo getGroupSelfInfo() {
        return this.groupSelfInfo;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public long getLastMessageTimestamp() {
        return this.lastMessageTimestamp;
    }

    public long getMemberCount() {
        return this.memberCount;
    }

    public long getMemberMaxCount() {
        return this.memberMaxCount;
    }

    public long getMemberOnlineCount() {
        return this.memberOnlineCount;
    }

    public String getNotification() {
        return this.notification;
    }

    public String getOwnerUserID() {
        return this.ownerUserID;
    }

    public boolean isAllShutUp() {
        return this.isAllShutUp;
    }

    public boolean isGroupMemberVisible() {
        return this.isGroupMemberVisible;
    }

    public boolean isGroupSearchable() {
        return this.isGroupSearchable;
    }

    public boolean isSupportTopic() {
        return this.supportTopic;
    }

    public void setAddOption(int i2) {
        this.addOption = i2;
    }

    public void setAllShutUp(boolean z) {
        this.isAllShutUp = z;
    }

    public void setCommunityID(String str) {
        this.communityID = str;
    }

    public void setCreateTime(long j2) {
        this.createTime = j2;
    }

    public void setCustomInfo(Map<String, byte[]> map) {
        this.customInfo = map;
    }

    public void setCustomString(String str) {
        this.customString = str;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setGroupInfoTimestamp(long j2) {
        this.groupInfoTimestamp = j2;
    }

    public void setGroupMemberVisible(boolean z) {
        this.isGroupMemberVisible = z;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupSearchable(boolean z) {
        this.isGroupSearchable = z;
    }

    public void setGroupSelfInfo(GroupMemberInfo groupMemberInfo) {
        this.groupSelfInfo = groupMemberInfo;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setLastMessageTimestamp(long j2) {
        this.lastMessageTimestamp = j2;
    }

    public void setMemberCount(long j2) {
        this.memberCount = j2;
    }

    public void setMemberMaxCount(long j2) {
        this.memberMaxCount = j2;
    }

    public void setMemberOnlineCount(long j2) {
        this.memberOnlineCount = j2;
    }

    public void setNotification(String str) {
        this.notification = str;
    }

    public void setOwnerUserID(String str) {
        this.ownerUserID = str;
    }

    public void setSupportTopic(boolean z) {
        this.supportTopic = z;
    }
}
