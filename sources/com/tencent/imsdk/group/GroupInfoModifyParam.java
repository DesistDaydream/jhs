package com.tencent.imsdk.group;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class GroupInfoModifyParam implements Serializable {
    private GroupInfo groupInfo;
    private long modifyFlag;

    public GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public long getModifyFlag() {
        return this.modifyFlag;
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public void setModifyFlag(long j2) {
        this.modifyFlag = j2;
    }
}
