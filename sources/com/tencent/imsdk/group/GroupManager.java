package com.tencent.imsdk.group;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class GroupManager {
    private GroupListener mGroupInternalListener;
    private GroupListener mGroupListener;

    /* loaded from: classes3.dex */
    public static class GroupManagerHolder {
        private static final GroupManager groupManager = new GroupManager();

        private GroupManagerHolder() {
        }
    }

    public static GroupManager getInstance() {
        return GroupManagerHolder.groupManager;
    }

    private void initGroupListener() {
        if (this.mGroupInternalListener == null) {
            this.mGroupInternalListener = new GroupListener() { // from class: com.tencent.imsdk.group.GroupManager.1
                {
                    GroupManager.this = this;
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onApplicationProcessed(final String str, final GroupMemberInfo groupMemberInfo, final boolean z, final String str2) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.11
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onApplicationProcessed(str, groupMemberInfo, z, str2);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGrantAdministrator(final String str, final GroupMemberInfo groupMemberInfo, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.12
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGrantAdministrator(str, groupMemberInfo, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupAttributeChanged(final String str, final Map<String, String> map) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.16
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupAttributeChanged(str, map);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupCreated(final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.6
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupCreated(str);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupDismissed(final String str, final GroupMemberInfo groupMemberInfo) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.7
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupDismissed(str, groupMemberInfo);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupInfoChanged(final String str, final List<GroupInfoChangeItem> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.9
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupInfoChanged(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupRecycled(final String str, final GroupMemberInfo groupMemberInfo) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.8
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupRecycled(str, groupMemberInfo);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberEnter(final String str, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberEnter(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberInfoChanged(final String str, final List<GroupMemberInfoChangeItem> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.5
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberInfoChanged(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberInvited(final String str, final GroupMemberInfo groupMemberInfo, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.3
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberInvited(str, groupMemberInfo, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberKicked(final String str, final GroupMemberInfo groupMemberInfo, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.4
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberKicked(str, groupMemberInfo, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberLeave(final String str, final GroupMemberInfo groupMemberInfo) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.2
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberLeave(str, groupMemberInfo);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onQuitFromGroup(final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.14
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onQuitFromGroup(str);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onReceiveJoinApplication(final String str, final GroupMemberInfo groupMemberInfo, final String str2) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.10
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onReceiveJoinApplication(str, groupMemberInfo, str2);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onReceiveRESTCustomData(final String str, final byte[] bArr) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.15
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onReceiveRESTCustomData(str, bArr);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onRevokeAdministrator(final String str, final GroupMemberInfo groupMemberInfo, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.13
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onRevokeAdministrator(str, groupMemberInfo, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onTopicCreated(final String str, final String str2) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.17
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onTopicCreated(str, str2);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onTopicDeleted(final String str, final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.18
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onTopicDeleted(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onTopicInfoChanged(final String str, final TopicInfo topicInfo) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.19
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onTopicInfoChanged(str, topicInfo);
                            }
                        }
                    });
                }
            };
        }
        nativeSetGroupListener(this.mGroupInternalListener);
    }

    public void acceptGroupApplication(GroupApplication groupApplication, String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            groupApplication.setResponseType(GroupApplication.RESPONSE_TYPE_AGREE);
            groupApplication.setResponseMessage(str);
            nativeResponseGroupApplication(groupApplication, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void createGroup(String str, String str2, String str3, IMCallback<String> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setGroupID(str2);
        groupInfo.setGroupType(str);
        groupInfo.setGroupName(str3);
        nativeCreateGroup(groupInfo, null, iMCallback);
    }

    public void createTopic(GroupInfo groupInfo, IMCallback<String> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeCreateTopic(groupInfo, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteGroupAttributes(String str, List<String> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteGroupAttributes(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteTopic(String str, List<String> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteTopic(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void dismissGroup(String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDismissGroup(str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getGroupApplicationList(IMCallback<GroupApplicationResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetGroupApplicationList(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getGroupAttributes(String str, List<String> list, IMCallback<Map<String, String>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetGroupAttributes(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getGroupMemberList(String str, int i2, long j2, IMCallback<GroupMemberInfoResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetGroupMemberList(str, i2, j2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getGroupMembersInfo(String str, List<String> list, IMCallback<List<GroupMemberInfo>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetGroupMembersInfo(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getGroupOnlineMemberCount(String str, IMCallback<Integer> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetGroupOnlineMemberCount(str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getGroupsInfo(List<String> list, IMCallback<List<GroupInfoGetResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetGroupsInfo(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getJoinedCommunityList(IMCallback<List<GroupInfo>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetJoinedCommunityList(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getJoinedGroupList(IMCallback<List<GroupInfo>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetJoinedGroupList(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getTopicList(String str, List<String> list, IMCallback<List<TopicInfo>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetTopicList(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void init() {
        initGroupListener();
    }

    public void initGroupAttributes(String str, HashMap<String, String> hashMap, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeInitGroupAttributes(str, hashMap, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void inviteUserToGroup(String str, List<String> list, IMCallback<List<GroupMemberOperationResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeInviteGroupMembers(str, list, "", iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void joinGroup(String str, String str2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeJoinGroup(str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void kickGroupMember(String str, List<String> list, String str2, IMCallback<List<GroupMemberOperationResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteGroupMembers(str, list, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void muteGroupMember(String str, String str2, int i2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeMuteGroupMember(str, str2, i2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public native void nativeCreateGroup(GroupInfo groupInfo, List<GroupMemberInfo> list, IMCallback<String> iMCallback);

    public native void nativeCreateTopic(GroupInfo groupInfo, IMCallback iMCallback);

    public native void nativeDeleteGroupAttributes(String str, List<String> list, IMCallback iMCallback);

    public native void nativeDeleteGroupMembers(String str, List<String> list, String str2, IMCallback iMCallback);

    public native void nativeDeleteTopic(String str, List<String> list, IMCallback iMCallback);

    public native void nativeDismissGroup(String str, IMCallback iMCallback);

    public native void nativeGetGroupApplicationList(IMCallback iMCallback);

    public native void nativeGetGroupAttributes(String str, List<String> list, IMCallback iMCallback);

    public native void nativeGetGroupMemberList(String str, int i2, long j2, IMCallback iMCallback);

    public native void nativeGetGroupMembersInfo(String str, List<String> list, IMCallback iMCallback);

    public native void nativeGetGroupOnlineMemberCount(String str, IMCallback iMCallback);

    public native void nativeGetGroupsInfo(List<String> list, IMCallback iMCallback);

    public native void nativeGetJoinedCommunityList(IMCallback iMCallback);

    public native void nativeGetJoinedGroupList(IMCallback iMCallback);

    public native void nativeGetTopicList(String str, List<String> list, IMCallback iMCallback);

    public native void nativeInitGroupAttributes(String str, Map<String, String> map, IMCallback iMCallback);

    public native void nativeInviteGroupMembers(String str, List<String> list, String str2, IMCallback iMCallback);

    public native void nativeJoinGroup(String str, String str2, IMCallback iMCallback);

    public native void nativeMuteGroupMember(String str, String str2, int i2, IMCallback iMCallback);

    public native void nativeQuitGroup(String str, IMCallback iMCallback);

    public native void nativeResponseGroupApplication(GroupApplication groupApplication, IMCallback iMCallback);

    public native void nativeSearchGroupMembersInfo(GroupMemberSearchParam groupMemberSearchParam, IMCallback iMCallback);

    public native void nativeSearchGroups(GroupSearchParam groupSearchParam, IMCallback iMCallback);

    public native void nativeSetGroupApplicationListRead(IMCallback iMCallback);

    public native void nativeSetGroupInfo(GroupInfoModifyParam groupInfoModifyParam, IMCallback iMCallback);

    public native void nativeSetGroupListener(GroupListener groupListener);

    public native void nativeSetGroupMemberInfo(GroupMemberInfoModifyParam groupMemberInfoModifyParam, IMCallback iMCallback);

    public native void nativeSetGroupMemberRole(String str, String str2, int i2, IMCallback iMCallback);

    public native void nativeSetGroupMessageReceiveOption(String str, int i2, IMCallback iMCallback);

    public native void nativeSetGroupOwner(String str, String str2, IMCallback iMCallback);

    public native void nativeSetTopicInfo(GroupInfoModifyParam groupInfoModifyParam, IMCallback iMCallback);

    public native void nativeUpdateGroupAttributes(String str, Map<String, String> map, IMCallback iMCallback);

    public void quitGroup(String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeQuitGroup(str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void refuseGroupApplication(GroupApplication groupApplication, String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            groupApplication.setResponseType(GroupApplication.RESPONSE_TYPE_REFUSE);
            groupApplication.setResponseMessage(str);
            nativeResponseGroupApplication(groupApplication, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void searchGroupMembersInfo(GroupMemberSearchParam groupMemberSearchParam, IMCallback<HashMap<String, List<GroupMemberInfo>>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSearchGroupMembersInfo(groupMemberSearchParam, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void searchGroups(GroupSearchParam groupSearchParam, IMCallback<List<GroupInfo>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSearchGroups(groupSearchParam, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setGroupApplicationRead(IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetGroupApplicationListRead(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setGroupAttributes(String str, HashMap<String, String> hashMap, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeUpdateGroupAttributes(str, hashMap, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setGroupInfo(GroupInfoModifyParam groupInfoModifyParam, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetGroupInfo(groupInfoModifyParam, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setGroupListener(GroupListener groupListener) {
        this.mGroupListener = groupListener;
    }

    public void setGroupMemberInfo(GroupMemberInfoModifyParam groupMemberInfoModifyParam, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetGroupMemberInfo(groupMemberInfoModifyParam, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setGroupMemberRole(String str, String str2, int i2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetGroupMemberRole(str, str2, i2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setGroupReceiveMessageOpt(String str, int i2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetGroupMessageReceiveOption(str, i2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setTopicInfo(GroupInfoModifyParam groupInfoModifyParam, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetTopicInfo(groupInfoModifyParam, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void transferGroupOwner(String str, String str2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetGroupOwner(str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void createGroup(GroupInfo groupInfo, List<GroupMemberInfo> list, IMCallback<String> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeCreateGroup(groupInfo, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }
}
