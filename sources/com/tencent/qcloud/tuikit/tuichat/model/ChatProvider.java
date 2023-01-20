package com.tencent.qcloud.tuikit.tuichat.model;

import android.util.Log;
import android.util.Pair;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMCreateGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMFriendInfoResult;
import com.tencent.imsdk.v2.V2TIMGroupApplication;
import com.tencent.imsdk.v2.V2TIMGroupApplicationResult;
import com.tencent.imsdk.v2.V2TIMGroupChangeInfo;
import com.tencent.imsdk.v2.V2TIMGroupInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMGroupMessageReadMemberList;
import com.tencent.imsdk.v2.V2TIMGroupTipsElem;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMergerElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageListGetOption;
import com.tencent.imsdk.v2.V2TIMMessageReceipt;
import com.tencent.imsdk.v2.V2TIMOfflinePushInfo;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageContainerBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflinePushInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.OfflinePushInfoUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ChatProvider {
    public static final int ERR_REVOKE_TIME_LIMIT_EXCEED = 6223;
    private static final String TAG = "ChatProvider";

    public void addJoinGroupMessage(TUIMessageBean tUIMessageBean, IUIKitCallback<List<GroupMemberInfo>> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        V2TIMGroupTipsElem groupTipsElem = v2TIMMessage != null ? v2TIMMessage.getGroupTipsElem() : null;
        if (groupTipsElem == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, -1, "groupTips is null");
            return;
        }
        List<V2TIMGroupMemberInfo> memberList = groupTipsElem.getMemberList();
        ArrayList arrayList = new ArrayList();
        if (memberList.size() > 0) {
            for (V2TIMGroupMemberInfo v2TIMGroupMemberInfo : memberList) {
                GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                groupMemberInfo.covertTIMGroupMemberInfo(v2TIMGroupMemberInfo);
                arrayList.add(groupMemberInfo);
            }
        } else {
            GroupMemberInfo groupMemberInfo2 = new GroupMemberInfo();
            groupMemberInfo2.covertTIMGroupMemberInfo(groupTipsElem.getOpMember());
            arrayList.add(groupMemberInfo2);
        }
        TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
    }

    public void addLeaveGroupMessage(TUIMessageBean tUIMessageBean, IUIKitCallback<List<String>> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        V2TIMGroupTipsElem groupTipsElem = v2TIMMessage != null ? v2TIMMessage.getGroupTipsElem() : null;
        if (groupTipsElem == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, -1, "groupTips is null");
            return;
        }
        List<V2TIMGroupMemberInfo> memberList = groupTipsElem.getMemberList();
        ArrayList arrayList = new ArrayList();
        if (memberList.size() > 0) {
            for (V2TIMGroupMemberInfo v2TIMGroupMemberInfo : memberList) {
                arrayList.add(v2TIMGroupMemberInfo.getUserID());
            }
        } else {
            arrayList.add(groupTipsElem.getOpMember().getUserID());
        }
        TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
    }

    public void addModifyGroupMessage(TUIMessageBean tUIMessageBean, IUIKitCallback<Pair<Integer, String>> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        V2TIMGroupTipsElem groupTipsElem = v2TIMMessage != null ? v2TIMMessage.getGroupTipsElem() : null;
        if (groupTipsElem == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, -1, "groupTips is null");
            return;
        }
        List<V2TIMGroupChangeInfo> groupChangeInfoList = groupTipsElem.getGroupChangeInfoList();
        if (groupChangeInfoList.size() > 0) {
            V2TIMGroupChangeInfo v2TIMGroupChangeInfo = groupChangeInfoList.get(0);
            int type = v2TIMGroupChangeInfo.getType();
            if (type == 1) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, new Pair(Integer.valueOf((int) TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME), v2TIMGroupChangeInfo.getValue()));
            } else if (type == 3) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, new Pair(Integer.valueOf((int) TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NOTICE), v2TIMGroupChangeInfo.getValue()));
            }
        }
    }

    public void c2cReadReport(String str) {
        V2TIMManager.getMessageManager().markC2CMessageAsRead(str, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.4
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str2) {
                String str3 = ChatProvider.TAG;
                TUIChatLog.e(str3, "markC2CMessageAsRead setReadMessage failed, code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatLog.d(ChatProvider.TAG, "markC2CMessageAsRead setReadMessage success");
            }
        });
    }

    public boolean checkFailedMessageInfo(TUIMessageBean tUIMessageBean) {
        return tUIMessageBean == null || tUIMessageBean.getV2TIMMessage().getStatus() == 3;
    }

    public void createGroup(GroupInfo groupInfo, final IUIKitCallback<String> iUIKitCallback) {
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
        V2TIMManager.getGroupManager().createGroup(v2TIMGroupInfo, arrayList, new V2TIMValueCallback<String>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.13
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str) {
                String str2 = ChatProvider.TAG;
                TUIChatLog.e(str2, "createGroup failed, code: " + i3 + "|desc: " + ErrorMessageConverter.convertIMError(i3, str));
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i3, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(String str) {
            }
        });
    }

    public void deleteMessages(List<TUIMessageBean> list, final IUIKitCallback<Void> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().deleteMessages(arrayList, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.10
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i3, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i3, str);
                String str2 = ChatProvider.TAG;
                TUIChatLog.w(str2, "deleteMessages code:" + i3 + "|desc:" + ErrorMessageConverter.convertIMError(i3, str));
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatLog.i(ChatProvider.TAG, "deleteMessages success");
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void downloadMergerMessage(MergeMessageBean mergeMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMergerElem mergerElem = mergeMessageBean.getMergerElem();
        if (mergerElem != null) {
            mergerElem.downloadMergerMessage(new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.18
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, "MergeMessageElemBean", i2, str);
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<V2TIMMessage> list) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
                }
            });
        }
    }

    public void findMessage(List<String> list, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMManager.getMessageManager().findMessages(list, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.16
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list2) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list2));
            }
        });
    }

    public void getConversationLastMessage(String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMManager.getConversationManager().getConversation(str, new V2TIMValueCallback<V2TIMConversation>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.12
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                String str3 = ChatProvider.TAG;
                Log.e(str3, "getConversationLastMessage error:" + i2 + ", desc:" + ErrorMessageConverter.convertIMError(i2, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMConversation v2TIMConversation) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessage(v2TIMConversation.getLastMessage()));
            }
        });
    }

    public void getFriendName(String str, final IUIKitCallback<String[]> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        V2TIMManager.getFriendshipManager().getFriendsInfo(arrayList, new V2TIMValueCallback<List<V2TIMFriendInfoResult>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.15
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMFriendInfoResult> list) {
                V2TIMFriendInfoResult v2TIMFriendInfoResult = list.get(0);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, new String[]{v2TIMFriendInfoResult.getFriendInfo().getFriendRemark(), v2TIMFriendInfoResult.getFriendInfo().getUserProfile().getNickName()});
            }
        });
    }

    public void getGroupMessageBySeq(String str, long j2, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
        v2TIMMessageListGetOption.setCount(1);
        v2TIMMessageListGetOption.setGetType(1);
        v2TIMMessageListGetOption.setLastMsgSeq(j2);
        v2TIMMessageListGetOption.setGroupID(str);
        V2TIMManager.getMessageManager().getHistoryMessageList(v2TIMMessageListGetOption, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.17
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i2, str2);
                String str3 = ChatProvider.TAG;
                TUIChatLog.e(str3, "loadChatMessages getHistoryMessageList optionBackward failed, code = " + i2 + ", desc = " + str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void getGroupMessageReadMembers(TUIMessageBean tUIMessageBean, boolean z, int i2, long j2, final IUIKitCallback<GroupMessageReadMembersInfo> iUIKitCallback) {
        V2TIMManager.getMessageManager().getGroupMessageReadMemberList(tUIMessageBean.getV2TIMMessage(), !z ? 1 : 0, j2, i2, new V2TIMValueCallback<V2TIMGroupMessageReadMemberList>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.21
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i3, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMGroupMessageReadMemberList v2TIMGroupMessageReadMemberList) {
                GroupMessageReadMembersInfo groupMessageReadMembersInfo = new GroupMessageReadMembersInfo();
                groupMessageReadMembersInfo.setReadMembers(v2TIMGroupMessageReadMemberList);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, groupMessageReadMembersInfo);
            }
        });
    }

    public void getGroupReadReceipt(List<TUIMessageBean> list, final IUIKitCallback<List<GroupMessageReceiptInfo>> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean tUIMessageBean : list) {
            arrayList.add(tUIMessageBean.getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().getMessageReadReceipts(arrayList, new V2TIMValueCallback<List<V2TIMMessageReceipt>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.19
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessageReceipt> list2) {
                ArrayList arrayList2 = new ArrayList();
                for (V2TIMMessageReceipt v2TIMMessageReceipt : list2) {
                    GroupMessageReceiptInfo groupMessageReceiptInfo = new GroupMessageReceiptInfo();
                    groupMessageReceiptInfo.setMessageReceipt(v2TIMMessageReceipt);
                    arrayList2.add(groupMessageReceiptInfo);
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList2);
            }
        });
    }

    public void groupReadReport(String str) {
        V2TIMManager.getMessageManager().markGroupMessageAsRead(str, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.5
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str2) {
                String str3 = ChatProvider.TAG;
                TUIChatLog.e(str3, "markGroupMessageAsRead failed, code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatLog.d(ChatProvider.TAG, "markGroupMessageAsRead success");
            }
        });
    }

    public void loadApplyInfo(final IUIKitCallback<List<GroupApplyInfo>> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        V2TIMManager.getGroupManager().getGroupApplicationList(new V2TIMValueCallback<V2TIMGroupApplicationResult>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.6
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                String str2 = ChatProvider.TAG;
                TUIChatLog.e(str2, "getGroupPendencyList failed, code: " + i2 + "|desc: " + ErrorMessageConverter.convertIMError(i2, str));
                iUIKitCallback.onError(ChatProvider.TAG, i2, ErrorMessageConverter.convertIMError(i2, str));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMGroupApplicationResult v2TIMGroupApplicationResult) {
                List<V2TIMGroupApplication> groupApplicationList = v2TIMGroupApplicationResult.getGroupApplicationList();
                for (int i2 = 0; i2 < groupApplicationList.size(); i2++) {
                    GroupApplyInfo groupApplyInfo = new GroupApplyInfo(groupApplicationList.get(i2));
                    groupApplyInfo.setStatus(0);
                    arrayList.add(groupApplyInfo);
                }
                iUIKitCallback.onSuccess(arrayList);
            }
        });
    }

    public void loadC2CMessage(String str, int i2, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMManager.getMessageManager().getC2CHistoryMessageList(str, i2, tUIMessageBean != null ? tUIMessageBean.getV2TIMMessage() : null, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.1
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i3, str2);
                String str3 = ChatProvider.TAG;
                TUIChatLog.e(str3, "loadChatMessages getC2CHistoryMessageList failed, code = " + i3 + ", desc = " + ErrorMessageConverter.convertIMError(i3, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void loadGroupMessage(String str, int i2, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMManager.getMessageManager().getGroupHistoryMessageList(str, i2, tUIMessageBean != null ? tUIMessageBean.getV2TIMMessage() : null, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.2
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i3, str2);
                String str3 = ChatProvider.TAG;
                TUIChatLog.e(str3, "loadChatMessages getC2CHistoryMessageList failed, code = " + i3 + ", desc = " + ErrorMessageConverter.convertIMError(i3, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void loadHistoryMessageList(String str, boolean z, int i2, TUIMessageBean tUIMessageBean, int i3, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
        v2TIMMessageListGetOption.setCount(i2);
        if (i3 == 0) {
            v2TIMMessageListGetOption.setGetType(1);
        } else if (i3 == 1) {
            v2TIMMessageListGetOption.setGetType(2);
        }
        if (tUIMessageBean != null) {
            v2TIMMessageListGetOption.setLastMsg(tUIMessageBean.getV2TIMMessage());
        }
        if (z) {
            v2TIMMessageListGetOption.setGroupID(str);
        } else {
            v2TIMMessageListGetOption.setUserID(str);
        }
        V2TIMManager.getMessageManager().getHistoryMessageList(v2TIMMessageListGetOption, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.3
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i4, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i4, str2);
                String str3 = ChatProvider.TAG;
                TUIChatLog.e(str3, "loadChatMessages getHistoryMessageList optionBackward failed, code = " + i4 + ", desc = " + ErrorMessageConverter.convertIMError(i4, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void revokeMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getMessageManager().revokeMessage(tUIMessageBean.getV2TIMMessage(), new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.9
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void sendGroupMessageReadReceipt(List<TUIMessageBean> list, final IUIKitCallback<Void> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean tUIMessageBean : list) {
            arrayList.add(tUIMessageBean.getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().sendMessageReadReceipts(arrayList, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.20
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void sendGroupTipsMessage(String str, String str2, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMManager.getMessageManager().sendMessage(ChatMessageBuilder.buildGroupCustomMessage(str2), null, str, 0, false, null, new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.14
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i2, str3);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i2) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                TUIChatLog.i(ChatProvider.TAG, "sendTipsMessage onSuccess");
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessage(v2TIMMessage));
            }
        });
    }

    public String sendMessage(final TUIMessageBean tUIMessageBean, ChatInfo chatInfo, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        String str;
        boolean z;
        OfflineMessageContainerBean offlineMessageContainerBean = new OfflineMessageContainerBean();
        OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
        offlineMessageBean.content = tUIMessageBean.getExtra();
        offlineMessageBean.sender = tUIMessageBean.getSender();
        offlineMessageBean.nickname = chatInfo.getChatName();
        offlineMessageBean.faceUrl = TUIChatConfigs.getConfigs().getGeneralConfig().getUserFaceUrl();
        offlineMessageContainerBean.entity = offlineMessageBean;
        String str2 = "";
        if (chatInfo.getType() == 2) {
            str = chatInfo.getId();
            chatInfo.getGroupType();
            z = true;
            offlineMessageBean.chatType = 2;
            offlineMessageBean.sender = str;
        } else {
            str = "";
            z = false;
            str2 = chatInfo.getId();
        }
        V2TIMOfflinePushInfo v2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
        v2TIMOfflinePushInfo.setExt(new Gson().z(offlineMessageContainerBean).getBytes());
        v2TIMOfflinePushInfo.setAndroidOPPOChannelID("jihuanshe");
        if (TUIChatConfigs.getConfigs().getGeneralConfig().isAndroidPrivateRing()) {
            v2TIMOfflinePushInfo.setAndroidSound(OfflinePushInfoUtils.PRIVATE_RING_NAME);
        }
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        v2TIMMessage.setExcludedFromUnreadCount(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromUnreadCount());
        v2TIMMessage.setExcludedFromLastMessage(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromLastMessage());
        if (!z) {
            tUIMessageBean.setNeedReadReceipt(false);
        }
        return V2TIMManager.getMessageManager().sendMessage(v2TIMMessage, z ? null : str2, z ? str : null, 0, false, v2TIMOfflinePushInfo, new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.7
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i2, str3);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i2) {
                TUIChatUtils.callbackOnProgress(iUIKitCallback, Integer.valueOf(i2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage2) {
                String str3 = ChatProvider.TAG;
                TUIChatLog.v(str3, "sendMessage onSuccess:" + v2TIMMessage2.getMsgID());
                tUIMessageBean.setV2TIMMessage(v2TIMMessage2);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean);
            }
        });
    }

    public void setDraft(String str, final String str2) {
        V2TIMManager.getConversationManager().setConversationDraft(str, str2, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.11
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str3) {
                String str4 = ChatProvider.TAG;
                TUIChatLog.e(str4, "set drafts error : " + i2 + ExpandableTextView.N + ErrorMessageConverter.convertIMError(i2, str3));
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                String str3 = ChatProvider.TAG;
                TUIChatLog.i(str3, "set draft success " + str2);
            }
        });
    }

    public String sendMessage(TUIMessageBean tUIMessageBean, boolean z, String str, OfflinePushInfo offlinePushInfo, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        v2TIMMessage.setExcludedFromUnreadCount(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromUnreadCount());
        v2TIMMessage.setExcludedFromLastMessage(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromLastMessage());
        V2TIMOfflinePushInfo convertOfflinePushInfoToV2PushInfo = OfflinePushInfoUtils.convertOfflinePushInfoToV2PushInfo(offlinePushInfo);
        if (!z) {
            tUIMessageBean.setNeedReadReceipt(false);
        }
        return V2TIMManager.getMessageManager().sendMessage(v2TIMMessage, z ? null : str, z ? str : null, 0, false, convertOfflinePushInfoToV2PushInfo, new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.8
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i2, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i2) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage2) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessage(v2TIMMessage2));
            }
        });
    }
}
