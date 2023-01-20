package com.tencent.imsdk.relationship;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class ReceiveMessageOptInfo implements Serializable {
    private String userID;
    private int userReceiveMessageOpt;

    public int getC2CReceiveMessageOpt() {
        return this.userReceiveMessageOpt;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setC2CReceiveMessageOpt(int i2) {
        this.userReceiveMessageOpt = i2;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
