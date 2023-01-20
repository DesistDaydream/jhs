package com.tencent.qcloud.tuikit.tuicontact.model;

import android.text.TextUtils;
import android.util.Pair;
import com.effective.android.panel.Constants;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMCreateGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMFriendAddApplication;
import com.tencent.imsdk.v2.V2TIMFriendApplication;
import com.tencent.imsdk.v2.V2TIMFriendApplicationResult;
import com.tencent.imsdk.v2.V2TIMFriendInfo;
import com.tencent.imsdk.v2.V2TIMFriendOperationResult;
import com.tencent.imsdk.v2.V2TIMGroupInfo;
import com.tencent.imsdk.v2.V2TIMGroupInfoResult;
import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfoResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMReceiveMessageOptInfo;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactGroupApplyInfo;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.FriendApplicationBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;
import com.tencent.qcloud.tuikit.tuicontact.util.TUIContactLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ContactProvider {
    private static final String TAG = "ContactProvider";
    private long mNextSeq = 0;

    private void acceptFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, int i2, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().acceptFriendApplication(v2TIMFriendApplication, i2, new V2TIMValueCallback<V2TIMFriendOperationResult>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.9
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.e(str2, "acceptFriend err code = " + i3 + ", desc = " + ErrorMessageConverter.convertIMError(i3, str));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMFriendOperationResult v2TIMFriendOperationResult) {
                TUIContactLog.i(ContactProvider.TAG, "acceptFriend success");
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void acceptJoinGroupApply(ContactGroupApplyInfo contactGroupApplyInfo, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getGroupManager().acceptGroupApplication(contactGroupApplyInfo.getTimGroupApplication(), contactGroupApplyInfo.getRequestMsg(), new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.23
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str) {
                ContactUtils.callbackOnError(iUIKitCallback, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void addFriend(String str, String str2, IUIKitCallback<Pair<Integer, String>> iUIKitCallback) {
        addFriend(str, str2, null, null, iUIKitCallback);
    }

    public void addToBlackList(List<String> list, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().addToBlackList(list, new V2TIMValueCallback<List<V2TIMFriendOperationResult>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.17
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.e(str2, "deleteBlackList err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMFriendOperationResult> list2) {
                TUIContactLog.i(ContactProvider.TAG, "deleteBlackList success");
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void createGroupChat(GroupInfo groupInfo, final IUIKitCallback<String> iUIKitCallback) {
        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
        v2TIMGroupInfo.setGroupType(groupInfo.getGroupType());
        v2TIMGroupInfo.setGroupName(groupInfo.getGroupName());
        v2TIMGroupInfo.setGroupAddOpt(groupInfo.getJoinType());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < groupInfo.getMemberDetails().size(); i2++) {
            V2TIMCreateGroupMemberInfo v2TIMCreateGroupMemberInfo = new V2TIMCreateGroupMemberInfo();
            v2TIMCreateGroupMemberInfo.setUserID(groupInfo.getMemberDetails().get(i2).getAccount());
            arrayList.add(v2TIMCreateGroupMemberInfo);
        }
        V2TIMManager.getGroupManager().createGroup(v2TIMGroupInfo, arrayList, new V2TIMValueCallback<String>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.21
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str) {
                ContactUtils.callbackOnError(iUIKitCallback, i3, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(String str) {
                ContactUtils.callbackOnSuccess(iUIKitCallback, str);
            }
        });
    }

    public void deleteFriend(List<String> list, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().deleteFromFriendList(list, 2, new V2TIMValueCallback<List<V2TIMFriendOperationResult>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.19
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.e(str2, "deleteFriends err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMFriendOperationResult> list2) {
                TUIContactLog.i(ContactProvider.TAG, "deleteFriends success");
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void deleteFromBlackList(List<String> list, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().deleteFromBlackList(list, new V2TIMValueCallback<List<V2TIMFriendOperationResult>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.16
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.e(str2, "deleteBlackList err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMFriendOperationResult> list2) {
                TUIContactLog.i(ContactProvider.TAG, "deleteBlackList success");
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void getC2CReceiveMessageOpt(List<String> list, final IUIKitCallback<Boolean> iUIKitCallback) {
        V2TIMManager.getMessageManager().getC2CReceiveMessageOpt(list, new V2TIMValueCallback<List<V2TIMReceiveMessageOptInfo>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.10
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.d(str2, "getC2CReceiveMessageOpt onError code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMReceiveMessageOptInfo> list2) {
                if (list2 == null || list2.isEmpty()) {
                    TUIContactLog.d(ContactProvider.TAG, "getC2CReceiveMessageOpt null");
                    ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, -1, "getC2CReceiveMessageOpt null");
                    return;
                }
                int c2CReceiveMessageOpt = list2.get(0).getC2CReceiveMessageOpt();
                String str = ContactProvider.TAG;
                TUIContactLog.d(str, "getC2CReceiveMessageOpt option = " + c2CReceiveMessageOpt);
                ContactUtils.callbackOnSuccess(iUIKitCallback, Boolean.valueOf(c2CReceiveMessageOpt == 2));
            }
        });
    }

    public void getFriendApplicationListUnreadCount(final IUIKitCallback<Integer> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().getFriendApplicationList(new V2TIMValueCallback<V2TIMFriendApplicationResult>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.8
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.e(str2, "getPendencyList err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMFriendApplicationResult v2TIMFriendApplicationResult) {
                ContactUtils.callbackOnSuccess(iUIKitCallback, Integer.valueOf(v2TIMFriendApplicationResult.getUnreadCount()));
            }
        });
    }

    public void getGroupInfo(List<String> list, final IUIKitCallback<List<GroupInfo>> iUIKitCallback) {
        V2TIMManager.getGroupManager().getGroupsInfo(list, new V2TIMValueCallback<List<V2TIMGroupInfoResult>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.12
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                ContactUtils.callbackOnError(iUIKitCallback, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMGroupInfoResult> list2) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMGroupInfoResult v2TIMGroupInfoResult : list2) {
                    if (v2TIMGroupInfoResult.getResultCode() != 0) {
                        ContactUtils.callbackOnError(iUIKitCallback, v2TIMGroupInfoResult.getResultCode(), v2TIMGroupInfoResult.getResultMessage());
                        return;
                    }
                    GroupInfo groupInfo = new GroupInfo();
                    groupInfo.setId(v2TIMGroupInfoResult.getGroupInfo().getGroupID());
                    groupInfo.setFaceUrl(v2TIMGroupInfoResult.getGroupInfo().getFaceUrl());
                    groupInfo.setGroupName(v2TIMGroupInfoResult.getGroupInfo().getGroupName());
                    groupInfo.setMemberCount(v2TIMGroupInfoResult.getGroupInfo().getMemberCount());
                    groupInfo.setGroupType(v2TIMGroupInfoResult.getGroupInfo().getGroupType());
                    arrayList.add(groupInfo);
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public long getNextSeq() {
        return this.mNextSeq;
    }

    public void getUserInfo(List<String> list, final IUIKitCallback<List<ContactItemBean>> iUIKitCallback) {
        V2TIMManager.getInstance().getUsersInfo(list, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.13
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.e(str2, "loadUserProfile err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMUserFullInfo> list2) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMUserFullInfo v2TIMUserFullInfo : list2) {
                    ContactItemBean contactItemBean = new ContactItemBean();
                    contactItemBean.setNickName(v2TIMUserFullInfo.getNickName());
                    contactItemBean.setId(v2TIMUserFullInfo.getUserID());
                    contactItemBean.setAvatarUrl(v2TIMUserFullInfo.getFaceUrl());
                    contactItemBean.setSignature(v2TIMUserFullInfo.getSelfSignature());
                    arrayList.add(contactItemBean);
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void isFriend(final String str, final ContactItemBean contactItemBean, final IUIKitCallback<Boolean> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().getFriendList(new V2TIMValueCallback<List<V2TIMFriendInfo>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.15
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                String str3 = ContactProvider.TAG;
                TUIContactLog.e(str3, "getFriendList err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str2));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMFriendInfo> list) {
                if (list != null && list.size() > 0) {
                    for (V2TIMFriendInfo v2TIMFriendInfo : list) {
                        if (TextUtils.equals(v2TIMFriendInfo.getUserID(), str)) {
                            contactItemBean.setFriend(true);
                            contactItemBean.setRemark(v2TIMFriendInfo.getFriendRemark());
                            contactItemBean.setAvatarUrl(v2TIMFriendInfo.getUserProfile().getFaceUrl());
                            ContactUtils.callbackOnSuccess(iUIKitCallback, Boolean.TRUE);
                            return;
                        }
                    }
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, Boolean.FALSE);
            }
        });
    }

    public void isInBlackList(final String str, final IUIKitCallback<Boolean> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().getBlackList(new V2TIMValueCallback<List<V2TIMFriendInfo>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.14
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                String str3 = ContactProvider.TAG;
                TUIContactLog.e(str3, "getBlackList err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str2));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMFriendInfo> list) {
                if (list != null && list.size() > 0) {
                    for (V2TIMFriendInfo v2TIMFriendInfo : list) {
                        if (TextUtils.equals(v2TIMFriendInfo.getUserID(), str)) {
                            ContactUtils.callbackOnSuccess(iUIKitCallback, Boolean.TRUE);
                            return;
                        }
                    }
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, Boolean.FALSE);
            }
        });
    }

    public void joinGroup(String str, String str2, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getInstance().joinGroup(str, str2, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.6
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str3) {
                String str4 = ContactProvider.TAG;
                TUIContactLog.e(str4, "addGroup err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str3));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str3);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIContactLog.i(ContactProvider.TAG, "addGroup success");
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void loadBlackListData(final IUIKitCallback<List<ContactItemBean>> iUIKitCallback) {
        TUIContactLog.i(TAG, "loadBlackListData");
        V2TIMManager.getFriendshipManager().getBlackList(new V2TIMValueCallback<List<V2TIMFriendInfo>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.2
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.e(str2, "getBlackList err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMFriendInfo> list) {
                String str = ContactProvider.TAG;
                TUIContactLog.i(str, "getBlackList success: " + list.size());
                if (list.size() == 0) {
                    TUIContactLog.i(ContactProvider.TAG, "getBlackList success but no data");
                }
                ArrayList arrayList = new ArrayList();
                for (V2TIMFriendInfo v2TIMFriendInfo : list) {
                    ContactItemBean contactItemBean = new ContactItemBean();
                    contactItemBean.covertTIMFriend(v2TIMFriendInfo).setBlackList(true);
                    arrayList.add(contactItemBean);
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void loadFriendApplicationList(final IUIKitCallback<List<FriendApplicationBean>> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().getFriendApplicationList(new V2TIMValueCallback<V2TIMFriendApplicationResult>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.7
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.e(str2, "getPendencyList err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMFriendApplicationResult v2TIMFriendApplicationResult) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMFriendApplication v2TIMFriendApplication : v2TIMFriendApplicationResult.getFriendApplicationList()) {
                    FriendApplicationBean friendApplicationBean = new FriendApplicationBean();
                    friendApplicationBean.convertFromTimFriendApplication(v2TIMFriendApplication);
                    arrayList.add(friendApplicationBean);
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void loadFriendListDataAsync(final IUIKitCallback<List<ContactItemBean>> iUIKitCallback) {
        TUIContactLog.i(TAG, "loadFriendListDataAsync");
        ThreadHelper.INST.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.1
            @Override // java.lang.Runnable
            public void run() {
                V2TIMManager.getFriendshipManager().getFriendList(new V2TIMValueCallback<List<V2TIMFriendInfo>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.1.1
                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onError(int i2, String str) {
                        String str2 = ContactProvider.TAG;
                        TUIContactLog.e(str2, "loadFriendListDataAsync err code:" + i2 + ", desc:" + ErrorMessageConverter.convertIMError(i2, str));
                        ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onSuccess(List<V2TIMFriendInfo> list) {
                        ArrayList arrayList = new ArrayList();
                        String str = ContactProvider.TAG;
                        TUIContactLog.i(str, "loadFriendListDataAsync->getFriendList:" + list.size());
                        for (V2TIMFriendInfo v2TIMFriendInfo : list) {
                            ContactItemBean contactItemBean = new ContactItemBean();
                            contactItemBean.setFriend(true);
                            contactItemBean.covertTIMFriend(v2TIMFriendInfo);
                            arrayList.add(contactItemBean);
                        }
                        ContactUtils.callbackOnSuccess(iUIKitCallback, arrayList);
                    }
                });
            }
        });
    }

    public void loadGroupListData(final IUIKitCallback<List<ContactItemBean>> iUIKitCallback) {
        TUIContactLog.i(TAG, "loadGroupListData");
        V2TIMManager.getGroupManager().getJoinedGroupList(new V2TIMValueCallback<List<V2TIMGroupInfo>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.3
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.e(str2, "getGroupList err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMGroupInfo> list) {
                String str = ContactProvider.TAG;
                TUIContactLog.i(str, "getGroupList success: " + list.size());
                if (list.size() == 0) {
                    TUIContactLog.i(ContactProvider.TAG, "getGroupList success but no data");
                }
                ArrayList arrayList = new ArrayList();
                for (V2TIMGroupInfo v2TIMGroupInfo : list) {
                    arrayList.add(new ContactItemBean().covertTIMGroupBaseInfo(v2TIMGroupInfo));
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void loadGroupMembers(String str, final IUIKitCallback<List<ContactItemBean>> iUIKitCallback) {
        V2TIMManager.getGroupManager().getGroupMemberList(str, 0, this.mNextSeq, new V2TIMValueCallback<V2TIMGroupMemberInfoResult>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.4
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str2);
                String str3 = ContactProvider.TAG;
                TUIContactLog.e(str3, "loadGroupMembers failed, code: " + i2 + "|desc: " + ErrorMessageConverter.convertIMError(i2, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult) {
                ArrayList<V2TIMGroupMemberFullInfo> arrayList = new ArrayList();
                for (int i2 = 0; i2 < v2TIMGroupMemberInfoResult.getMemberInfoList().size(); i2++) {
                    if (!v2TIMGroupMemberInfoResult.getMemberInfoList().get(i2).getUserID().equals(V2TIMManager.getInstance().getLoginUser())) {
                        arrayList.add(v2TIMGroupMemberInfoResult.getMemberInfoList().get(i2));
                    }
                }
                ContactProvider.this.mNextSeq = v2TIMGroupMemberInfoResult.getNextSeq();
                ArrayList arrayList2 = new ArrayList();
                for (V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo : arrayList) {
                    arrayList2.add(new ContactItemBean().covertTIMGroupMemberFullInfo(v2TIMGroupMemberFullInfo));
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, arrayList2);
            }
        });
    }

    public void modifyRemark(String str, final String str2, final IUIKitCallback<String> iUIKitCallback) {
        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
        v2TIMFriendInfo.setUserID(str);
        v2TIMFriendInfo.setFriendRemark(str2);
        V2TIMManager.getFriendshipManager().setFriendInfo(v2TIMFriendInfo, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.18
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str3) {
                String str4 = ContactProvider.TAG;
                TUIContactLog.e(str4, "modifyRemark err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str3));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str3);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                ContactUtils.callbackOnSuccess(iUIKitCallback, str2);
                TUIContactLog.i(ContactProvider.TAG, "modifyRemark success");
            }
        });
    }

    public void refuseFriendApplication(FriendApplicationBean friendApplicationBean, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMFriendApplication friendApplication = friendApplicationBean.getFriendApplication();
        if (friendApplication == null) {
            ContactUtils.callbackOnError(iUIKitCallback, "refuseFriendApplication", -1, "V2TIMFriendApplication is null");
        } else {
            V2TIMManager.getFriendshipManager().refuseFriendApplication(friendApplication, new V2TIMValueCallback<V2TIMFriendOperationResult>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.20
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    String str2 = ContactProvider.TAG;
                    TUIContactLog.e(str2, "accept err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                    ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
                    ToastUtil.toastShortMessage("Error code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(V2TIMFriendOperationResult v2TIMFriendOperationResult) {
                    TUIContactLog.i(ContactProvider.TAG, "refuse success");
                    ContactUtils.callbackOnSuccess(iUIKitCallback, null);
                }
            });
        }
    }

    public void refuseJoinGroupApply(ContactGroupApplyInfo contactGroupApplyInfo, String str, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getGroupManager().refuseGroupApplication(contactGroupApplyInfo.getTimGroupApplication(), str, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.24
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str2) {
                ContactUtils.callbackOnError(iUIKitCallback, i2, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void sendGroupTipsMessage(final String str, String str2, final IUIKitCallback<String> iUIKitCallback) {
        V2TIMManager.getMessageManager().sendMessage(V2TIMManager.getMessageManager().createCustomMessage(str2.getBytes()), null, str, 0, false, null, new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.22
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str3) {
                String str4 = ContactProvider.TAG;
                TUIContactLog.i(str4, "sendTipsMessage error , code : " + i2 + " desc : " + ErrorMessageConverter.convertIMError(i2, str3));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str3);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i2) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                TUIContactLog.i(ContactProvider.TAG, "sendTipsMessage onSuccess");
                ContactUtils.callbackOnSuccess(iUIKitCallback, str);
            }
        });
    }

    public void setC2CReceiveMessageOpt(List<String> list, boolean z, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getMessageManager().setC2CReceiveMessageOpt(list, z ? 2 : 0, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.11
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str) {
                String str2 = ContactProvider.TAG;
                TUIContactLog.d(str2, "setC2CReceiveMessageOpt onError code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIContactLog.d(ContactProvider.TAG, "setC2CReceiveMessageOpt onSuccess");
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void setGroupApplicationRead(final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getGroupManager().setGroupApplicationRead(new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.25
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str) {
                ContactUtils.callbackOnError(iUIKitCallback, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void setNextSeq(long j2) {
        this.mNextSeq = j2;
    }

    public void acceptFriendApplication(FriendApplicationBean friendApplicationBean, int i2, IUIKitCallback<Void> iUIKitCallback) {
        acceptFriendApplication(friendApplicationBean.getFriendApplication(), i2, iUIKitCallback);
    }

    public void addFriend(String str, String str2, String str3, String str4, final IUIKitCallback<Pair<Integer, String>> iUIKitCallback) {
        V2TIMFriendAddApplication v2TIMFriendAddApplication = new V2TIMFriendAddApplication(str);
        v2TIMFriendAddApplication.setAddWording(str2);
        v2TIMFriendAddApplication.setAddSource(Constants.ANDROID);
        v2TIMFriendAddApplication.setFriendGroup(str3);
        v2TIMFriendAddApplication.setFriendRemark(str4);
        V2TIMManager.getFriendshipManager().addFriend(v2TIMFriendAddApplication, new V2TIMValueCallback<V2TIMFriendOperationResult>() { // from class: com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider.5
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str5) {
                String str6 = ContactProvider.TAG;
                TUIContactLog.e(str6, "addFriend err code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str5));
                ContactUtils.callbackOnError(iUIKitCallback, ContactProvider.TAG, i2, str5);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMFriendOperationResult v2TIMFriendOperationResult) {
                TUIContactLog.i(ContactProvider.TAG, "addFriend success");
                ContactUtils.callbackOnSuccess(iUIKitCallback, new Pair(Integer.valueOf(v2TIMFriendOperationResult.getResultCode()), v2TIMFriendOperationResult.getResultInfo()));
            }
        });
    }
}
