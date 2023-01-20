package com.tencent.imsdk.message;

import com.tencent.imsdk.group.GroupMemberInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupMessageReadMembers implements Serializable {
    private boolean isFinish;
    private long nextSeq;
    private List<GroupMemberInfo> readMembers = new ArrayList();
    private List<GroupMemberInfo> unreadMembers = new ArrayList();

    public long getNextSeq() {
        return this.nextSeq;
    }

    public List<GroupMemberInfo> getReadMembers() {
        return this.readMembers;
    }

    public List<GroupMemberInfo> getUnreadMembers() {
        return this.unreadMembers;
    }

    public boolean isFinish() {
        return this.isFinish;
    }
}
