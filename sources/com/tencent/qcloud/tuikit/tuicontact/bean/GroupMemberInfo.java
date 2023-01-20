package com.tencent.qcloud.tuikit.tuicontact.bean;

import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class GroupMemberInfo implements Serializable {
    private String account;
    private String birthday;
    private String iconUrl;
    private boolean isFriend;
    private boolean isTopChat;
    private long joinTime;
    private String location;
    private int memberType;
    private String nameCard;
    private String nickName;
    private String signature;
    private long tinyId;

    public GroupMemberInfo covertTIMGroupMemberInfo(V2TIMGroupMemberInfo v2TIMGroupMemberInfo) {
        if (v2TIMGroupMemberInfo instanceof V2TIMGroupMemberFullInfo) {
            V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = (V2TIMGroupMemberFullInfo) v2TIMGroupMemberInfo;
            setJoinTime(v2TIMGroupMemberFullInfo.getJoinTime());
            setMemberType(v2TIMGroupMemberFullInfo.getRole());
        }
        setAccount(v2TIMGroupMemberInfo.getUserID());
        setNameCard(v2TIMGroupMemberInfo.getNameCard());
        setIconUrl(v2TIMGroupMemberInfo.getFaceUrl());
        setNickName(v2TIMGroupMemberInfo.getNickName());
        return this;
    }

    public String getAccount() {
        return this.account;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public String getLocation() {
        return this.location;
    }

    public int getMemberType() {
        return this.memberType;
    }

    public String getNameCard() {
        return this.nameCard;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getSignature() {
        return this.signature;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public boolean isFriend() {
        return this.isFriend;
    }

    public boolean isTopChat() {
        return this.isTopChat;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setFriend(boolean z) {
        this.isFriend = z;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setJoinTime(long j2) {
        this.joinTime = j2;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setMemberType(int i2) {
        this.memberType = i2;
    }

    public void setNameCard(String str) {
        this.nameCard = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setTinyId(long j2) {
        this.tinyId = j2;
    }

    public void setTopChat(boolean z) {
        this.isTopChat = z;
    }
}
