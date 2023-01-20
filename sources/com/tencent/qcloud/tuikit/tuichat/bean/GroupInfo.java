package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.imsdk.v2.V2TIMGroupInfoResult;
import com.tencent.imsdk.v2.V2TIMManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupInfo extends ChatInfo {
    public static final String GROUP_TYPE_AVCHATROOM = "AVChatRoom";
    public static final String GROUP_TYPE_COMMUNITY = "Community";
    public static final String GROUP_TYPE_MEETING = "Meeting";
    public static final String GROUP_TYPE_PUBLIC = "Public";
    public static final String GROUP_TYPE_WORK = "Work";
    private String faceUrl;
    private String groupName;
    private String groupType;
    private int joinType;
    private int memberCount;
    private List<GroupMemberInfo> memberDetails = new ArrayList();
    private boolean messageReceiveOption;
    private String notice;
    private String owner;

    public GroupInfo() {
        setType(2);
    }

    public GroupInfo covertTIMGroupDetailInfo(V2TIMGroupInfoResult v2TIMGroupInfoResult) {
        if (v2TIMGroupInfoResult.getResultCode() != 0) {
            return this;
        }
        setChatName(v2TIMGroupInfoResult.getGroupInfo().getGroupName());
        setGroupName(v2TIMGroupInfoResult.getGroupInfo().getGroupName());
        setId(v2TIMGroupInfoResult.getGroupInfo().getGroupID());
        setNotice(v2TIMGroupInfoResult.getGroupInfo().getNotification());
        setMemberCount(v2TIMGroupInfoResult.getGroupInfo().getMemberCount());
        setGroupType(v2TIMGroupInfoResult.getGroupInfo().getGroupType());
        setOwner(v2TIMGroupInfoResult.getGroupInfo().getOwner());
        setJoinType(v2TIMGroupInfoResult.getGroupInfo().getGroupAddOpt());
        setMessageReceiveOption(v2TIMGroupInfoResult.getGroupInfo().getRecvOpt() == 2);
        return this;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getGroupName() {
        return this.groupName;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo
    public String getGroupType() {
        return this.groupType;
    }

    public int getJoinType() {
        return this.joinType;
    }

    public int getMemberCount() {
        List<GroupMemberInfo> list = this.memberDetails;
        if (list != null) {
            return list.size();
        }
        return this.memberCount;
    }

    public List<GroupMemberInfo> getMemberDetails() {
        return this.memberDetails;
    }

    public boolean getMessageReceiveOption() {
        return this.messageReceiveOption;
    }

    public String getNotice() {
        return this.notice;
    }

    public boolean isOwner() {
        return V2TIMManager.getInstance().getLoginUser().equals(this.owner);
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo
    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setJoinType(int i2) {
        this.joinType = i2;
    }

    public void setMemberCount(int i2) {
        this.memberCount = i2;
    }

    public void setMemberDetails(List<GroupMemberInfo> list) {
        this.memberDetails = list;
    }

    public void setMessageReceiveOption(boolean z) {
        this.messageReceiveOption = z;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public void setOwner(String str) {
        this.owner = str;
    }
}
