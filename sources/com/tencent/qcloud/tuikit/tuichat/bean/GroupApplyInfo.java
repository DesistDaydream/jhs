package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.imsdk.v2.V2TIMGroupApplication;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class GroupApplyInfo implements Serializable {
    public static final int APPLIED = 1;
    public static final int REFUSED = -1;
    public static final int UNHANDLED = 0;
    private int status;
    private V2TIMGroupApplication timGroupApplication;

    public GroupApplyInfo(V2TIMGroupApplication v2TIMGroupApplication) {
        this.timGroupApplication = v2TIMGroupApplication;
    }

    public String getFromUser() {
        V2TIMGroupApplication v2TIMGroupApplication = this.timGroupApplication;
        return v2TIMGroupApplication != null ? v2TIMGroupApplication.getFromUser() : "";
    }

    public String getFromUserNickName() {
        V2TIMGroupApplication v2TIMGroupApplication = this.timGroupApplication;
        return v2TIMGroupApplication != null ? v2TIMGroupApplication.getFromUserNickName() : "";
    }

    public V2TIMGroupApplication getGroupApplication() {
        return this.timGroupApplication;
    }

    public String getRequestMsg() {
        V2TIMGroupApplication v2TIMGroupApplication = this.timGroupApplication;
        return v2TIMGroupApplication != null ? v2TIMGroupApplication.getRequestMsg() : "";
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isStatusHandled() {
        V2TIMGroupApplication v2TIMGroupApplication = this.timGroupApplication;
        return (v2TIMGroupApplication == null || v2TIMGroupApplication.getHandleStatus() == 0) ? false : true;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
