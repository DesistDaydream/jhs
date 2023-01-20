package com.tencent.imsdk.relationship;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class FriendResponse implements Serializable {
    public static final int RESPONSE_AGREE = 1;
    public static final int RESPONSE_AGREE_AND_ADD = 2;
    public static final int RESPONSE_REJECT = 3;
    private String remark;
    private int responseType;
    private String userID;

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setResponseType(int i2) {
        this.responseType = i2;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
