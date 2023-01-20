package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class V2TIMUserInfo implements Serializable {
    public UserInfo userInfo = new UserInfo();
    public HashMap<String, Object> modifyParams = new HashMap<>();

    public long getBirthday() {
        return this.userInfo.getBirthday();
    }

    public String getFaceUrl() {
        return this.userInfo.getFaceUrl();
    }

    public HashMap<String, Object> getModifyParams() {
        return this.modifyParams;
    }

    public String getNickName() {
        return this.userInfo.getNickname();
    }

    public String getUserID() {
        return this.userInfo.getUserID();
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setBirthday(long j2) {
        this.userInfo.setBirthday(j2);
        this.modifyParams.put(UserInfo.USERINFO_KEY_BIRTHDAY, Long.valueOf(j2));
    }

    public void setFaceUrl(String str) {
        this.userInfo.setFaceUrl(str);
        this.modifyParams.put("Tag_Profile_IM_Image", str);
    }

    public void setNickName(String str) {
        this.userInfo.setNickname(str);
        this.modifyParams.put("Tag_Profile_IM_Nick", str);
    }

    public void setUserID(String str) {
        this.userInfo.setUserID(str);
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
