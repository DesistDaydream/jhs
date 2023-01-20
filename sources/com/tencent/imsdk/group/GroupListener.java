package com.tencent.imsdk.group;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class GroupListener {
    public void onApplicationProcessed(String str, GroupMemberInfo groupMemberInfo, boolean z, String str2) {
    }

    public void onGrantAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
    }

    public void onGroupAttributeChanged(String str, Map<String, String> map) {
    }

    public void onGroupCreated(String str) {
    }

    public void onGroupDismissed(String str, GroupMemberInfo groupMemberInfo) {
    }

    public void onGroupInfoChanged(String str, List<GroupInfoChangeItem> list) {
    }

    public void onGroupRecycled(String str, GroupMemberInfo groupMemberInfo) {
    }

    public void onMemberEnter(String str, List<GroupMemberInfo> list) {
    }

    public void onMemberInfoChanged(String str, List<GroupMemberInfoChangeItem> list) {
    }

    public void onMemberInvited(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
    }

    public void onMemberKicked(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
    }

    public void onMemberLeave(String str, GroupMemberInfo groupMemberInfo) {
    }

    public void onQuitFromGroup(String str) {
    }

    public void onReceiveJoinApplication(String str, GroupMemberInfo groupMemberInfo, String str2) {
    }

    public void onReceiveRESTCustomData(String str, byte[] bArr) {
    }

    public void onRevokeAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
    }

    public void onTopicCreated(String str, String str2) {
    }

    public void onTopicDeleted(String str, List<String> list) {
    }

    public void onTopicInfoChanged(String str, TopicInfo topicInfo) {
    }
}
