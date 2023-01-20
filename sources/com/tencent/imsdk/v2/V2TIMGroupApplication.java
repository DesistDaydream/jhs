package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupApplication;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class V2TIMGroupApplication implements Serializable {
    public static final int V2TIM_GROUP_APPLICATION_GET_TYPE_INVITE = 1;
    public static final int V2TIM_GROUP_APPLICATION_GET_TYPE_JOIN = 0;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_RESULT_AGREE = 1;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_RESULT_REFUSE = 0;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_HANDLED_BY_OTHER = 1;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_HANDLED_BY_SELF = 2;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_UNHANDLED = 0;
    private GroupApplication groupApplication = new GroupApplication();

    public long getAddTime() {
        return this.groupApplication.getRequestTime();
    }

    public String getFromUser() {
        return this.groupApplication.getFromUserID();
    }

    public String getFromUserFaceUrl() {
        return this.groupApplication.getFromUserFaceUrl();
    }

    public String getFromUserNickName() {
        return this.groupApplication.getFromUserNickName();
    }

    public GroupApplication getGroupApplication() {
        return this.groupApplication;
    }

    public String getGroupID() {
        return this.groupApplication.getGroupID();
    }

    public int getHandleResult() {
        int responseType = this.groupApplication.getResponseType();
        return (responseType != GroupApplication.RESPONSE_TYPE_AGREE && responseType == GroupApplication.RESPONSE_TYPE_REFUSE) ? 0 : 1;
    }

    public int getHandleStatus() {
        int responseStatus = this.groupApplication.getResponseStatus();
        if (responseStatus == GroupApplication.RESPONSE_STATUS_UNHANDLED) {
            return 0;
        }
        if (responseStatus == GroupApplication.RESPONSE_STATUS_HANDLED_BY_OTHER) {
            return 1;
        }
        return responseStatus == GroupApplication.RESPONSE_STATUS_HANDLED_BY_SELF ? 2 : 0;
    }

    public String getHandledMsg() {
        return this.groupApplication.getResponseMessage();
    }

    public String getRequestMsg() {
        return this.groupApplication.getRequestMessage();
    }

    public String getToUser() {
        return this.groupApplication.getToUserID();
    }

    public int getType() {
        int applicationType = this.groupApplication.getApplicationType();
        return (applicationType != GroupApplication.REQUEST_TYPE_INVITE && applicationType == GroupApplication.REQUEST_TYPE_JOIN) ? 1 : 0;
    }

    public void setGroupApplication(GroupApplication groupApplication) {
        this.groupApplication = groupApplication;
    }
}
