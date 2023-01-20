package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupApplicationResult implements Serializable {
    private List<GroupApplication> groupApplicationList;
    private long unreadCount;

    public List<GroupApplication> getGroupApplicationList() {
        return this.groupApplicationList;
    }

    public long getUnreadCount() {
        return this.unreadCount;
    }

    public void setUnreadCount(long j2) {
        this.unreadCount = j2;
    }
}
