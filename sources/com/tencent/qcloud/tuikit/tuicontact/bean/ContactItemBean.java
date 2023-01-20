package com.tencent.qcloud.tuikit.tuicontact.bean;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMFriendInfo;
import com.tencent.imsdk.v2.V2TIMGroupInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.bean.BaseIndexPinyinBean;

/* loaded from: classes3.dex */
public class ContactItemBean extends BaseIndexPinyinBean {
    public static final String INDEX_STRING_TOP = "↑";
    public static final int TYPE_C2C = 1;
    public static final int TYPE_GROUP = 2;
    public static final int TYPE_INVALID = 0;
    private String avatarUrl;
    private String groupType;
    private String id;
    private boolean isBlackList;
    private boolean isGroup;
    private boolean isSelected;
    private boolean isTop;
    private String nickName;
    private String remark;
    private String signature;
    private boolean isFriend = false;
    private boolean isEnable = true;

    public ContactItemBean() {
    }

    public ContactItemBean covertTIMFriend(V2TIMFriendInfo v2TIMFriendInfo) {
        if (v2TIMFriendInfo == null) {
            return this;
        }
        setId(v2TIMFriendInfo.getUserID());
        setNickName(v2TIMFriendInfo.getUserProfile().getNickName());
        setAvatarUrl(v2TIMFriendInfo.getUserProfile().getFaceUrl());
        setSignature(v2TIMFriendInfo.getUserProfile().getSelfSignature());
        setRemark(v2TIMFriendInfo.getFriendRemark());
        return this;
    }

    public ContactItemBean covertTIMGroupBaseInfo(V2TIMGroupInfo v2TIMGroupInfo) {
        if (v2TIMGroupInfo == null) {
            return this;
        }
        setId(v2TIMGroupInfo.getGroupID());
        setRemark(v2TIMGroupInfo.getGroupName());
        setAvatarUrl(v2TIMGroupInfo.getFaceUrl());
        setGroup(true);
        setGroupType(v2TIMGroupInfo.getGroupType());
        return this;
    }

    public ContactItemBean covertTIMGroupMemberFullInfo(V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo) {
        if (v2TIMGroupMemberFullInfo == null) {
            return this;
        }
        setId(v2TIMGroupMemberFullInfo.getUserID());
        if (TextUtils.isEmpty(v2TIMGroupMemberFullInfo.getNickName())) {
            setRemark(v2TIMGroupMemberFullInfo.getNameCard());
            setNickName(v2TIMGroupMemberFullInfo.getNameCard());
        } else {
            setRemark(v2TIMGroupMemberFullInfo.getNickName());
            setNickName(v2TIMGroupMemberFullInfo.getNickName());
        }
        setAvatarUrl(v2TIMGroupMemberFullInfo.getFaceUrl());
        setGroup(false);
        return this;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public String getId() {
        return this.id;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.bean.BaseIndexPinyinBean
    public String getTarget() {
        if (!TextUtils.isEmpty(this.remark)) {
            return this.remark;
        }
        if (!TextUtils.isEmpty(this.nickName)) {
            return this.nickName;
        }
        return this.id;
    }

    public boolean isBlackList() {
        return this.isBlackList;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public boolean isFriend() {
        return this.isFriend;
    }

    public boolean isGroup() {
        return this.isGroup;
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.bean.BaseIndexPinyinBean
    public boolean isNeedToPinyin() {
        return !this.isTop;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.bean.BaseIndexBean, com.tencent.qcloud.tuikit.tuicontact.component.indexlib.suspension.ISuspensionInterface
    public boolean isShowSuspension() {
        return !this.isTop;
    }

    public boolean isTop() {
        return this.isTop;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setBlackList(boolean z) {
        this.isBlackList = z;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void setFriend(boolean z) {
        this.isFriend = z;
    }

    public void setGroup(boolean z) {
        this.isGroup = z;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public ContactItemBean setId(String str) {
        this.id = str;
        return this;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public ContactItemBean setTop(boolean z) {
        this.isTop = z;
        return this;
    }

    public ContactItemBean(String str) {
        this.id = str;
    }
}
