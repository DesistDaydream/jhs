package com.tencent.imsdk.v2;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class V2TIMSignalingInfo implements Cloneable, Serializable {
    public static final int SIGNALING_ACTION_TYPE_ACCEPT_INVITE = 3;
    public static final int SIGNALING_ACTION_TYPE_CANCEL_INVITE = 2;
    public static final int SIGNALING_ACTION_TYPE_INVITE = 1;
    public static final int SIGNALING_ACTION_TYPE_INVITE_TIMEOUT = 5;
    public static final int SIGNALING_ACTION_TYPE_REJECT_INVITE = 4;
    private int actionType;
    private String data;
    private String groupID;
    private String inviteID;
    private String inviter;
    private V2TIMOfflinePushInfo offlinePushInfo;
    private boolean onlineUserOnly;
    private int timeout;
    private int businessID = 0;
    private List<String> inviteeList = new ArrayList();

    public void addInvitee(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.inviteeList.add(str);
    }

    public int getActionType() {
        return this.actionType;
    }

    public int getBusinessID() {
        return this.businessID;
    }

    public String getData() {
        return this.data;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public String getInviteID() {
        return this.inviteID;
    }

    public List<String> getInviteeList() {
        return this.inviteeList;
    }

    public String getInviter() {
        return this.inviter;
    }

    public V2TIMOfflinePushInfo getOfflinePushInfo() {
        return this.offlinePushInfo;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public boolean isOnlineUserOnly() {
        return this.onlineUserOnly;
    }

    public void setActionType(int i2) {
        this.actionType = i2;
    }

    public void setBusinessID(int i2) {
        this.businessID = i2;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setInviteID(String str) {
        this.inviteID = str;
    }

    public void setInviteeList(List<String> list) {
        this.inviteeList = list;
    }

    public void setInviter(String str) {
        this.inviter = str;
    }

    public void setOfflinePushInfo(V2TIMOfflinePushInfo v2TIMOfflinePushInfo) {
        this.offlinePushInfo = v2TIMOfflinePushInfo;
    }

    public void setOnlineUserOnly(boolean z) {
        this.onlineUserOnly = z;
    }

    public void setTimeout(int i2) {
        this.timeout = i2;
    }

    /* renamed from: clone */
    public V2TIMSignalingInfo m40clone() {
        V2TIMSignalingInfo v2TIMSignalingInfo;
        try {
            v2TIMSignalingInfo = (V2TIMSignalingInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            v2TIMSignalingInfo = new V2TIMSignalingInfo();
            v2TIMSignalingInfo.setBusinessID(this.businessID);
            v2TIMSignalingInfo.setInviteID(this.inviteID);
            v2TIMSignalingInfo.setGroupID(this.groupID);
            v2TIMSignalingInfo.setInviter(this.inviter);
            v2TIMSignalingInfo.setData(this.data);
            v2TIMSignalingInfo.setTimeout(this.timeout);
            v2TIMSignalingInfo.setActionType(this.actionType);
            v2TIMSignalingInfo.setOnlineUserOnly(this.onlineUserOnly);
        }
        v2TIMSignalingInfo.inviteeList = new ArrayList(this.inviteeList);
        v2TIMSignalingInfo.setOfflinePushInfo(this.offlinePushInfo);
        return v2TIMSignalingInfo;
    }
}
