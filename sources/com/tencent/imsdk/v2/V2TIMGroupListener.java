package com.tencent.imsdk.v2;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class V2TIMGroupListener {
    public void onApplicationProcessed(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, boolean z, String str2) {
    }

    public void onGrantAdministrator(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, List<V2TIMGroupMemberInfo> list) {
    }

    public void onGroupAttributeChanged(String str, Map<String, String> map) {
    }

    public void onGroupCreated(String str) {
    }

    public void onGroupDismissed(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo) {
    }

    public void onGroupInfoChanged(String str, List<V2TIMGroupChangeInfo> list) {
    }

    public void onGroupRecycled(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo) {
    }

    public void onMemberEnter(String str, List<V2TIMGroupMemberInfo> list) {
    }

    public void onMemberInfoChanged(String str, List<V2TIMGroupMemberChangeInfo> list) {
    }

    public void onMemberInvited(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, List<V2TIMGroupMemberInfo> list) {
    }

    public void onMemberKicked(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, List<V2TIMGroupMemberInfo> list) {
    }

    public void onMemberLeave(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo) {
    }

    public void onQuitFromGroup(String str) {
    }

    public void onReceiveJoinApplication(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, String str2) {
    }

    public void onReceiveRESTCustomData(String str, byte[] bArr) {
    }

    public void onRevokeAdministrator(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, List<V2TIMGroupMemberInfo> list) {
    }

    public void onTopicCreated(String str, String str2) {
    }

    public void onTopicDeleted(String str, List<String> list) {
    }

    public void onTopicInfoChanged(String str, V2TIMTopicInfo v2TIMTopicInfo) {
    }
}
