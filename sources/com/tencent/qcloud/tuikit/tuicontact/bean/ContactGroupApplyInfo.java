package com.tencent.qcloud.tuikit.tuicontact.bean;

import com.tencent.imsdk.v2.V2TIMGroupApplication;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ContactGroupApplyInfo implements Serializable {
    private String fromUser;
    private String fromUserNickName;
    private String requestMsg;
    private V2TIMGroupApplication timGroupApplication;

    public String getFromUser() {
        return this.fromUser;
    }

    public String getFromUserNickName() {
        return this.fromUserNickName;
    }

    public String getRequestMsg() {
        return this.requestMsg;
    }

    public V2TIMGroupApplication getTimGroupApplication() {
        return this.timGroupApplication;
    }

    public void setFromUser(String str) {
        this.fromUser = str;
    }

    public void setFromUserNickName(String str) {
        this.fromUserNickName = str;
    }

    public void setRequestMsg(String str) {
        this.requestMsg = str;
    }

    public void setTimGroupApplication(V2TIMGroupApplication v2TIMGroupApplication) {
        this.timGroupApplication = v2TIMGroupApplication;
    }
}
