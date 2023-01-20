package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.UserInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class V2TIMUserFullInfo extends V2TIMUserInfo {
    public static final String PROFILE_TYPE_KEY_ALLOWTYPE = "Tag_Profile_IM_AllowType";
    public static final String PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_Profile_Custom_";
    public static final String PROFILE_TYPE_KEY_FACEURL = "Tag_Profile_IM_Image";
    public static final String PROFILE_TYPE_KEY_GENDER = "Tag_Profile_IM_Gender";
    public static final String PROFILE_TYPE_KEY_NICK = "Tag_Profile_IM_Nick";
    public static final String PROFILE_TYPE_KEY_SELF_SIGNATURE = "Tag_Profile_IM_SelfSignature";
    public static final int V2TIM_FRIEND_ALLOW_ANY = 0;
    public static final int V2TIM_FRIEND_DENY_ANY = 2;
    public static final int V2TIM_FRIEND_NEED_CONFIRM = 1;
    public static final int V2TIM_GENDER_FEMALE = 2;
    public static final int V2TIM_GENDER_MALE = 1;
    public static final int V2TIM_GENDER_UNKNOWN = 0;

    public int getAllowType() {
        int allowType = this.userInfo.getAllowType();
        if (allowType == 2) {
            return 2;
        }
        return (allowType != 1 && allowType == 0) ? 0 : 1;
    }

    public HashMap<String, byte[]> getCustomInfo() {
        return this.userInfo.getCustomUserInfoString();
    }

    public int getGender() {
        int gender = this.userInfo.getGender();
        if (gender == 1) {
            return 1;
        }
        return gender == 2 ? 2 : 0;
    }

    public int getLevel() {
        return this.userInfo.getLevel();
    }

    public int getRole() {
        return this.userInfo.getRole();
    }

    public String getSelfSignature() {
        return this.userInfo.getSignature();
    }

    public void setAllowType(int i2) {
        if (i2 == 0) {
            this.userInfo.setAllowType(0);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_ALLOWANY);
        } else if (2 == i2) {
            this.userInfo.setAllowType(2);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_DENYANY);
        } else if (1 == i2) {
            this.userInfo.setAllowType(1);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_NEEDCONFIRM);
        } else {
            this.userInfo.setAllowType(1);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_NEEDCONFIRM);
        }
    }

    public void setCustomInfo(HashMap<String, byte[]> hashMap) {
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
            if (entry.getKey().contains("Tag_Profile_Custom_")) {
                this.modifyParams.put(entry.getKey(), entry.getValue());
            } else {
                HashMap<String, Object> hashMap2 = this.modifyParams;
                hashMap2.put("Tag_Profile_Custom_" + entry.getKey(), new String(entry.getValue()));
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMUserInfo
    public void setFaceUrl(String str) {
        super.setFaceUrl(str);
    }

    public void setGender(int i2) {
        if (1 == i2) {
            this.userInfo.setGender(1);
            this.modifyParams.put("Tag_Profile_IM_Gender", UserInfo.USERINFO_GENDER_TYPE_MALE);
        } else if (2 == i2) {
            this.userInfo.setGender(2);
            this.modifyParams.put("Tag_Profile_IM_Gender", UserInfo.USERINFO_GENDER_TYPE_FEMALE);
        } else {
            this.userInfo.setGender(0);
            this.modifyParams.put("Tag_Profile_IM_Gender", UserInfo.USERINFO_GENDER_TYPE_UNKNOWN);
        }
    }

    public void setLevel(int i2) {
        this.userInfo.setLevel(i2);
        this.modifyParams.put(UserInfo.USERINFO_KEY_LEVEL, Integer.valueOf(i2));
    }

    public void setNickname(String str) {
        super.setNickName(str);
    }

    public void setRole(int i2) {
        this.userInfo.setRole(i2);
        this.modifyParams.put(UserInfo.USERINFO_KEY_ROLE, Integer.valueOf(i2));
    }

    public void setSelfSignature(String str) {
        this.userInfo.setSignature(str);
        this.modifyParams.put("Tag_Profile_IM_SelfSignature", str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V2TIMUserFullInfo--->");
        HashMap<String, byte[]> customInfo = getCustomInfo();
        StringBuilder sb2 = new StringBuilder();
        if (customInfo != null) {
            sb2.append("\n");
            for (Map.Entry<String, byte[]> entry : customInfo.entrySet()) {
                sb2.append(" |key:" + entry.getKey() + ", value:" + new String(entry.getValue()));
                sb2.append("\n");
            }
        }
        sb.append("userID:");
        sb.append(getUserID());
        sb.append(", nickName:");
        sb.append(getNickName());
        sb.append(", gender:");
        sb.append(getGender());
        sb.append(", faceUrl:");
        sb.append(getFaceUrl());
        sb.append(", selfSignature:");
        sb.append(getSelfSignature());
        sb.append(", allowType:");
        sb.append(getAllowType());
        sb.append(", customInfo:");
        sb.append(sb2.toString());
        return sb.toString();
    }
}
