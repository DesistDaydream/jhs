package com.tencent.imsdk.v2;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public class V2TIMCreateGroupMemberInfo implements Serializable {
    private Map<String, byte[]> customInfo;
    private int role = 0;
    private String userID;

    public int getRole() {
        return this.role;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setRole(int i2) {
        if (i2 == 200) {
            i2 = 0;
        }
        this.role = i2;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
