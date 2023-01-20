package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupApplicationResult;
import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupInfoGetResult;
import com.tencent.imsdk.group.GroupInfoModifyParam;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoModifyParam;
import com.tencent.imsdk.group.GroupMemberInfoResult;
import com.tencent.imsdk.group.GroupMemberOperationResult;
import com.tencent.imsdk.group.TopicInfo;
import com.tencent.imsdk.group.TopicOperationResult;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.DraftMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class V2TIMGroupManagerImpl extends V2TIMGroupManager {
    private final String TAG;

    /* loaded from: classes3.dex */
    public static class V2TIMGroupManagerImplHolder {
        private static final V2TIMGroupManagerImpl v2TIMGroupManagerImpl = new V2TIMGroupManagerImpl();

        private V2TIMGroupManagerImplHolder() {
        }
    }

    public static V2TIMGroupManagerImpl getInstance() {
        return V2TIMGroupManagerImplHolder.v2TIMGroupManagerImpl;
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void acceptGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupApplication == null) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "acceptGroupApplication err, v2TIMGroupApplication is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMGroupApplication is null");
                return;
            }
            return;
        }
        GroupManager.getInstance().acceptGroupApplication(v2TIMGroupApplication.getGroupApplication(), str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.32
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str2) {
                super.fail(i2, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void createGroup(V2TIMGroupInfo v2TIMGroupInfo, List<V2TIMCreateGroupMemberInfo> list, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMGroupInfo == null) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "createGroup, null info");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "info is null");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (V2TIMCreateGroupMemberInfo v2TIMCreateGroupMemberInfo : list) {
                GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                groupMemberInfo.setUserID(v2TIMCreateGroupMemberInfo.getUserID());
                groupMemberInfo.setRole(v2TIMCreateGroupMemberInfo.getRole());
                arrayList.add(groupMemberInfo);
            }
        }
        GroupManager.getInstance().createGroup(v2TIMGroupInfo.getGroupInfo(), arrayList, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.1
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(String str) {
                super.success((AnonymousClass1) str);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void createTopicInCommunity(String str, V2TIMTopicInfo v2TIMTopicInfo, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
            }
        } else if (v2TIMTopicInfo == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "topicInfo is null");
            }
        } else {
            GroupInfo groupInfo = v2TIMTopicInfo.getGroupInfo();
            groupInfo.setCommunityID(str);
            GroupManager.getInstance().createTopic(groupInfo, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.35
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(String str2) {
                    super.success((AnonymousClass35) str2);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void deleteGroupAttributes(String str, List<String> list, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "deleteGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().deleteGroupAttributes(str, list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.9
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str2) {
                super.fail(i2, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void deleteTopicFromCommunity(String str, List<String> list, final V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            GroupManager.getInstance().deleteTopic(str, list, new IMCallback(new V2TIMValueCallback<List<TopicOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.36
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<TopicOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TopicOperationResult topicOperationResult : list2) {
                            V2TIMTopicOperationResult v2TIMTopicOperationResult = new V2TIMTopicOperationResult();
                            v2TIMTopicOperationResult.setTopicOperationResult(topicOperationResult);
                            arrayList.add(v2TIMTopicOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.37
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID or topicIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupApplicationList(final V2TIMValueCallback<V2TIMGroupApplicationResult> v2TIMValueCallback) {
        GroupManager.getInstance().getGroupApplicationList(new IMCallback<GroupApplicationResult>(new V2TIMValueCallback<GroupApplicationResult>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.30
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i2, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(GroupApplicationResult groupApplicationResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMGroupApplicationResult v2TIMGroupApplicationResult = new V2TIMGroupApplicationResult();
                    v2TIMGroupApplicationResult.setGroupApplicationResult(groupApplicationResult);
                    v2TIMValueCallback.onSuccess(v2TIMGroupApplicationResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.31
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(GroupApplicationResult groupApplicationResult) {
                super.success((AnonymousClass31) groupApplicationResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupAttributes(String str, List<String> list, V2TIMValueCallback<Map<String, String>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupAttributes error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().getGroupAttributes(str, list, new IMCallback<Map<String, String>>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.10
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str2) {
                super.fail(i2, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Map<String, String> map) {
                super.success((AnonymousClass10) map);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupMemberList(String str, int i2, long j2, final V2TIMValueCallback<V2TIMGroupMemberInfoResult> v2TIMValueCallback) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupMemberList error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        int i4 = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_ALL;
        if (i2 != 0) {
            if (i2 == 1) {
                i2 = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_OWNER;
            } else if (i2 == 2) {
                i2 = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_ADMINISTRATOR;
            } else if (i2 == 4) {
                i2 = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_MEMBER;
            }
            i3 = i2;
        } else {
            i3 = i4;
        }
        GroupManager.getInstance().getGroupMemberList(str, i3, j2, new IMCallback<GroupMemberInfoResult>(new V2TIMValueCallback<GroupMemberInfoResult>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.12
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i5, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i5, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(GroupMemberInfoResult groupMemberInfoResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult = new V2TIMGroupMemberInfoResult();
                    v2TIMGroupMemberInfoResult.setGroupMemberInfoResult(groupMemberInfoResult);
                    v2TIMValueCallback.onSuccess(v2TIMGroupMemberInfoResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.13
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i5, String str2) {
                super.fail(i5, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(GroupMemberInfoResult groupMemberInfoResult) {
                super.success((AnonymousClass13) groupMemberInfoResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupMembersInfo(String str, List<String> list, final V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            GroupManager.getInstance().getGroupMembersInfo(str, list, new IMCallback<List<GroupMemberInfo>>(new V2TIMValueCallback<List<GroupMemberInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.14
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupMemberInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberInfo groupMemberInfo : list2) {
                            V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                            v2TIMGroupMemberFullInfo.setGroupMemberInfo(groupMemberInfo);
                            arrayList.add(v2TIMGroupMemberFullInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.15
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupMemberInfo> list2) {
                    super.success((AnonymousClass15) list2);
                }
            });
            return;
        }
        IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupMembersInfo fail, memberList is empty");
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "memberList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupOnlineMemberCount(String str, V2TIMValueCallback<Integer> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().getGroupOnlineMemberCount(str, new IMCallback<Integer>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.11
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Integer num) {
                    super.success((AnonymousClass11) num);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupsInfo(List<String> list, final V2TIMValueCallback<List<V2TIMGroupInfoResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            GroupManager.getInstance().getGroupsInfo(list, new IMCallback<List<GroupInfoGetResult>>(new V2TIMValueCallback<List<GroupInfoGetResult>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.2
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupInfoGetResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupInfoGetResult groupInfoGetResult : list2) {
                            V2TIMGroupInfoResult v2TIMGroupInfoResult = new V2TIMGroupInfoResult();
                            v2TIMGroupInfoResult.setGroupInfoGetResult(groupInfoGetResult);
                            arrayList.add(v2TIMGroupInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.3
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupInfoGetResult> list2) {
                    super.success((AnonymousClass3) list2);
                }
            });
            return;
        }
        IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupsInfo error, empty groupIDList");
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "empty groupIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getJoinedCommunityList(final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        GroupManager.getInstance().getJoinedCommunityList(new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.28
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i2, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<GroupInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfo groupInfo : list) {
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setGroupInfo(groupInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.29
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<GroupInfo> list) {
                super.success((AnonymousClass29) list);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getJoinedGroupList(final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        GroupManager.getInstance().getJoinedGroupList(new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.26
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i2, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<GroupInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfo groupInfo : list) {
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setGroupInfo(groupInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.27
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<GroupInfo> list) {
                super.success((AnonymousClass27) list);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getTopicInfoList(String str, List<String> list, final V2TIMValueCallback<List<V2TIMTopicInfoResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().getTopicList(str, list, new IMCallback<List<TopicInfo>>(new V2TIMValueCallback<List<TopicInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.41
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<TopicInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TopicInfo topicInfo : list2) {
                            V2TIMTopicInfoResult v2TIMTopicInfoResult = new V2TIMTopicInfoResult();
                            v2TIMTopicInfoResult.setTopicInfo(topicInfo);
                            arrayList.add(v2TIMTopicInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.42
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<TopicInfo> list2) {
                    super.success((AnonymousClass42) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void initGroupAttributes(String str, HashMap<String, String> hashMap, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "initGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().initGroupAttributes(str, hashMap, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.7
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str2) {
                super.fail(i2, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void inviteUserToGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            GroupManager.getInstance().inviteUserToGroup(str, list, new IMCallback<List<GroupMemberOperationResult>>(new V2TIMValueCallback<List<GroupMemberOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.20
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupMemberOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberOperationResult groupMemberOperationResult : list2) {
                            V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                            v2TIMGroupMemberOperationResult.setGroupMemberOperationResult(groupMemberOperationResult);
                            arrayList.add(v2TIMGroupMemberOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.21
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupMemberOperationResult> list2) {
                    super.success((AnonymousClass21) list2);
                }
            });
            return;
        }
        IMLog.e("V2TIMAdvGroupMgrImpl", "inviteUserToGroup error, groupID or userList is empty");
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void kickGroupMember(String str, List<String> list, String str2, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            GroupManager.getInstance().kickGroupMember(str, list, str2, new IMCallback<List<GroupMemberOperationResult>>(new V2TIMValueCallback<List<GroupMemberOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.22
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupMemberOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberOperationResult groupMemberOperationResult : list2) {
                            V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                            v2TIMGroupMemberOperationResult.setGroupMemberOperationResult(groupMemberOperationResult);
                            arrayList.add(v2TIMGroupMemberOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.23
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str3) {
                    super.fail(i2, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupMemberOperationResult> list2) {
                    super.success((AnonymousClass23) list2);
                }
            });
            return;
        }
        IMLog.e("V2TIMAdvGroupMgrImpl", "kickGroupMember error, groupID or memberList is empty");
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or memberList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void muteGroupMember(String str, String str2, int i2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            GroupManager.getInstance().muteGroupMember(str, str2, i2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.19
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str3) {
                    super.fail(i3, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void refuseGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupApplication == null) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "acceptGroupApplication err, v2TIMGroupApplication is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMGroupApplication is null");
                return;
            }
            return;
        }
        GroupManager.getInstance().refuseGroupApplication(v2TIMGroupApplication.getGroupApplication(), str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.33
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str2) {
                super.fail(i2, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void searchGroupMembers(V2TIMGroupMemberSearchParam v2TIMGroupMemberSearchParam, final V2TIMValueCallback<HashMap<String, List<V2TIMGroupMemberFullInfo>>> v2TIMValueCallback) {
        if (v2TIMGroupMemberSearchParam == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "searchParam is null");
            }
        } else if (v2TIMGroupMemberSearchParam.getKeywordList() == null || v2TIMGroupMemberSearchParam.getKeywordList().isEmpty()) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "keywordList cannot be empty");
            }
        } else {
            GroupManager.getInstance().searchGroupMembersInfo(v2TIMGroupMemberSearchParam.getGroupMemberSearchParam(), new IMCallback<HashMap<String, List<GroupMemberInfo>>>(new V2TIMValueCallback<HashMap<String, List<GroupMemberInfo>>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.16
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(HashMap<String, List<GroupMemberInfo>> hashMap) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry<String, List<GroupMemberInfo>> entry : hashMap.entrySet()) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberInfo groupMemberInfo : entry.getValue()) {
                            V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                            v2TIMGroupMemberFullInfo.setGroupMemberInfo(groupMemberInfo);
                            arrayList.add(v2TIMGroupMemberFullInfo);
                        }
                        hashMap2.put(entry.getKey(), arrayList);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(hashMap2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.17
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(HashMap<String, List<GroupMemberInfo>> hashMap) {
                    super.success((AnonymousClass17) hashMap);
                }
            });
            BaseManager.getInstance().checkTUIComponent(6);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void searchGroups(V2TIMGroupSearchParam v2TIMGroupSearchParam, final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        if (v2TIMGroupSearchParam == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "searchParam is null");
            }
        } else if (v2TIMGroupSearchParam.getKeywordList() == null || v2TIMGroupSearchParam.getKeywordList().size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "empty keywordList");
            }
        } else {
            GroupManager.getInstance().searchGroups(v2TIMGroupSearchParam.getGroupSearchParam(), new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.4
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupInfo> list) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfo groupInfo : list) {
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setGroupInfo(groupInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.5
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupInfo> list) {
                    super.success((AnonymousClass5) list);
                }
            });
            BaseManager.getInstance().checkTUIComponent(6);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupApplicationRead(V2TIMCallback v2TIMCallback) {
        GroupManager.getInstance().setGroupApplicationRead(new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.34
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupAttributes(String str, HashMap<String, String> hashMap, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
        } else if (hashMap != null && hashMap.size() != 0) {
            GroupManager.getInstance().setGroupAttributes(str, hashMap, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.8
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupAttributes error, attributes is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "attributes is empty");
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupInfo(V2TIMGroupInfo v2TIMGroupInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupInfo == null) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupInfo error, null info");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "null info");
                return;
            }
            return;
        }
        GroupInfo groupInfo = v2TIMGroupInfo.getGroupInfo();
        GroupInfoModifyParam groupInfoModifyParam = new GroupInfoModifyParam();
        groupInfoModifyParam.setGroupInfo(groupInfo);
        groupInfoModifyParam.setModifyFlag(v2TIMGroupInfo.getModifyFlag());
        GroupManager.getInstance().setGroupInfo(groupInfoModifyParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.6
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupMemberInfo(String str, V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && v2TIMGroupMemberFullInfo != null) {
            GroupMemberInfoModifyParam groupMemberInfoModifyParam = new GroupMemberInfoModifyParam();
            groupMemberInfoModifyParam.setModifyFlag(v2TIMGroupMemberFullInfo.getModifyFlag());
            groupMemberInfoModifyParam.setMemberInfo(v2TIMGroupMemberFullInfo.getGroupMemberInfo());
            groupMemberInfoModifyParam.getMemberInfo().setGroupID(str);
            GroupManager.getInstance().setGroupMemberInfo(groupMemberInfoModifyParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.18
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupMemberInfo error, groupID is empty or profile is null");
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty or profile is null");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupMemberRole(String str, String str2, int i2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int i3 = GroupMemberInfo.MEMBER_ROLE_MEMBER;
            if (400 == i2) {
                i2 = GroupMemberInfo.MEMBER_ROLE_OWNER;
            } else if (300 == i2) {
                i2 = GroupMemberInfo.MEMBER_ROLE_ADMINISTRATOR;
            }
            GroupManager.getInstance().setGroupMemberRole(str, str2, i2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.24
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i4, String str3) {
                    super.fail(i4, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupMemberRole error, groupID or userID is empty");
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setTopicInfo(V2TIMTopicInfo v2TIMTopicInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMTopicInfo == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid topicInfo");
                return;
            }
            return;
        }
        GroupInfo groupInfo = v2TIMTopicInfo.getGroupInfo();
        GroupInfoModifyParam groupInfoModifyParam = new GroupInfoModifyParam();
        groupInfoModifyParam.setGroupInfo(groupInfo);
        groupInfoModifyParam.setModifyFlag(v2TIMTopicInfo.getModifyFlag());
        GroupManager.getInstance().setTopicInfo(groupInfoModifyParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.38
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
        if (v2TIMTopicInfo.isNeedModifyDraft()) {
            ConversationKey conversationKey = new ConversationKey();
            conversationKey.setConversationID(v2TIMTopicInfo.getTopicID());
            conversationKey.setConversationType(2);
            DraftMessage draftMessage = new DraftMessage();
            String tempDraft = v2TIMTopicInfo.getTopicInfo().getTempDraft();
            if (tempDraft != null) {
                draftMessage.setUserDefinedData(tempDraft.getBytes());
            }
            ConversationManager.getInstance().setConversationDraft(conversationKey, draftMessage, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.39
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str) {
                    IMLog.i("V2TIMAdvGroupMgrImpl", "setTopicDraft failed, code:" + i2 + ", desc:" + str);
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    IMLog.i("V2TIMAdvGroupMgrImpl", "setTopicDraft success");
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.40
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void transferGroupOwner(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            GroupManager.getInstance().transferGroupOwner(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.25
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str3) {
                    super.fail(i2, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        IMLog.e("V2TIMAdvGroupMgrImpl", "transferGroupOwner error, groupID or userID is empty");
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userID is empty");
        }
    }

    private V2TIMGroupManagerImpl() {
        this.TAG = "V2TIMAdvGroupMgrImpl";
    }
}
