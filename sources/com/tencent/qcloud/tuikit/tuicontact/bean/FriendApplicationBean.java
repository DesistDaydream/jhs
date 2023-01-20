package com.tencent.qcloud.tuikit.tuicontact.bean;

import com.tencent.imsdk.v2.V2TIMFriendApplication;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class FriendApplicationBean implements Serializable {
    public static final int ERR_SUCC = 0;
    public static final int ERR_SVR_FRIENDSHIP_ALLOW_TYPE_DENY_ANY = 30516;
    public static final int ERR_SVR_FRIENDSHIP_ALLOW_TYPE_NEED_CONFIRM = 30539;
    public static final int ERR_SVR_FRIENDSHIP_COUNT_LIMIT = 30010;
    public static final int ERR_SVR_FRIENDSHIP_INVALID_PARAMETERS = 30001;
    public static final int ERR_SVR_FRIENDSHIP_IN_PEER_BLACKLIST = 30525;
    public static final int ERR_SVR_FRIENDSHIP_IN_SELF_BLACKLIST = 30515;
    public static final int ERR_SVR_FRIENDSHIP_PEER_FRIEND_LIMIT = 30014;
    public static final int FRIEND_ACCEPT_AGREE = 0;
    public static final int FRIEND_ACCEPT_AGREE_AND_ADD = 1;
    public static final int FRIEND_APPLICATION_BOTH = 3;
    public static final int FRIEND_APPLICATION_COME_IN = 1;
    public static final int FRIEND_APPLICATION_SEND_OUT = 2;
    private int addType;
    private String addWording;
    private String faceUrl;
    private V2TIMFriendApplication friendApplication;
    private boolean isAccept = false;
    private String nickName;
    private String userId;

    public FriendApplicationBean convertFromTimFriendApplication(V2TIMFriendApplication v2TIMFriendApplication) {
        if (v2TIMFriendApplication == null) {
            return this;
        }
        setAddType(v2TIMFriendApplication.getType());
        setNickName(v2TIMFriendApplication.getNickname());
        setAddWording(v2TIMFriendApplication.getAddWording());
        setUserId(v2TIMFriendApplication.getUserID());
        setFriendApplication(v2TIMFriendApplication);
        setFaceUrl(v2TIMFriendApplication.getFaceUrl());
        return this;
    }

    public int getAddType() {
        return this.addType;
    }

    public String getAddWording() {
        return this.addWording;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public V2TIMFriendApplication getFriendApplication() {
        return this.friendApplication;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isAccept() {
        return this.isAccept;
    }

    public void setAccept(boolean z) {
        this.isAccept = z;
    }

    public void setAddType(int i2) {
        this.addType = i2;
    }

    public void setAddWording(String str) {
        this.addWording = str;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setFriendApplication(V2TIMFriendApplication v2TIMFriendApplication) {
        this.friendApplication = v2TIMFriendApplication;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
