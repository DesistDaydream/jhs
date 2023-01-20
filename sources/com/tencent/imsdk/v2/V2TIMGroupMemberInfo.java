package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class V2TIMGroupMemberInfo implements Serializable {
    public GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
    public UserInfo userInfo;

    public String getFaceUrl() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getFaceUrl())) {
            return this.groupMemberInfo.getFaceUrl();
        }
        UserInfo userInfo = this.userInfo;
        return userInfo != null ? userInfo.getFaceUrl() : "";
    }

    public String getFriendRemark() {
        return this.groupMemberInfo.getFriendRemark();
    }

    public GroupMemberInfo getGroupMemberInfo() {
        return this.groupMemberInfo;
    }

    public String getNameCard() {
        return this.groupMemberInfo.getNameCard();
    }

    public String getNickName() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getNickname())) {
            return this.groupMemberInfo.getNickname();
        }
        UserInfo userInfo = this.userInfo;
        return userInfo != null ? userInfo.getNickname() : "";
    }

    public String getUserID() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getUserID())) {
            return this.groupMemberInfo.getUserID();
        }
        UserInfo userInfo = this.userInfo;
        return userInfo != null ? userInfo.getUserID() : "";
    }

    public void setGroupMemberInfo(GroupMemberInfo groupMemberInfo) {
        this.groupMemberInfo = groupMemberInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String toString() {
        return "V2TIMGroupMemberInfo--->userID:" + getUserID() + ", nickName:" + getNickName() + ", nameCard:" + getNameCard() + ", friendRemark:" + getFriendRemark() + ", faceUrl:" + getFaceUrl();
    }
}
