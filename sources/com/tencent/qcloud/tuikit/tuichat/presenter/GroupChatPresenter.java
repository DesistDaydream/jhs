package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupChatPresenter extends ChatPresenter {
    private static final String TAG = "GroupChatPresenter";
    private List<GroupApplyInfo> currentApplies = new ArrayList();
    private List<GroupMemberInfo> currentGroupMembers = new ArrayList();
    private GroupChatEventListener groupChatEventListener;
    private GroupInfo groupInfo;

    public GroupChatPresenter() {
        TUIChatLog.i(TAG, "GroupChatPresenter Init");
    }

    private void addGroupMessage(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof TipsMessageBean) {
            TipsMessageBean tipsMessageBean = (TipsMessageBean) tUIMessageBean;
            if (tipsMessageBean.getTipType() == 259) {
                this.provider.addJoinGroupMessage(tipsMessageBean, new IUIKitCallback<List<GroupMemberInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.6
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        String str3 = GroupChatPresenter.TAG;
                        TUIChatLog.e(str3, "addJoinGroupMessage error : " + str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<GroupMemberInfo> list) {
                        GroupChatPresenter.this.currentGroupMembers.addAll(list);
                        GroupChatPresenter.this.groupInfo.setMemberDetails(GroupChatPresenter.this.currentGroupMembers);
                    }
                });
            } else if (tipsMessageBean.getTipType() != 260 && tipsMessageBean.getTipType() != 261) {
                if (tipsMessageBean.getTipType() == 262 || tipsMessageBean.getTipType() == 263) {
                    this.provider.addModifyGroupMessage(tipsMessageBean, new IUIKitCallback<Pair<Integer, String>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.8
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i2, String str2) {
                            String str3 = GroupChatPresenter.TAG;
                            TUIChatLog.e(str3, "addModifyGroupMessage error " + str2);
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(Pair<Integer, String> pair) {
                            if (((Integer) pair.first).intValue() == 262) {
                                GroupChatPresenter.this.groupInfo.setGroupName((String) pair.second);
                                ChatPresenter.ChatNotifyHandler chatNotifyHandler = GroupChatPresenter.this.chatNotifyHandler;
                                if (chatNotifyHandler != null) {
                                    chatNotifyHandler.onGroupNameChanged((String) pair.second);
                                }
                            }
                            if (((Integer) pair.first).intValue() == 263) {
                                GroupChatPresenter.this.groupInfo.setNotice((String) pair.second);
                            }
                        }
                    });
                }
            } else {
                this.provider.addLeaveGroupMessage(tipsMessageBean, new IUIKitCallback<List<String>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.7
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<String> list) {
                        for (String str : list) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= GroupChatPresenter.this.currentGroupMembers.size()) {
                                    break;
                                } else if (((GroupMemberInfo) GroupChatPresenter.this.currentGroupMembers.get(i2)).getAccount().equals(str)) {
                                    GroupChatPresenter.this.currentGroupMembers.remove(i2);
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                        GroupChatPresenter.this.groupInfo.setMemberDetails(GroupChatPresenter.this.currentGroupMembers);
                    }
                });
            }
        }
    }

    private void sendGroupTipsMessage(final String str, String str2, final IUIKitCallback<String> iUIKitCallback) {
        this.provider.sendGroupTipsMessage(str, str2, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.5
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str3, int i2, String str4) {
                TUIChatUtils.callbackOnError(iUIKitCallback, str3, i2, str4);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void addMessageInfo(TUIMessageBean tUIMessageBean) {
        super.addMessageInfo(tUIMessageBean);
        addGroupMessage(tUIMessageBean);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void assembleGroupMessage(TUIMessageBean tUIMessageBean) {
        tUIMessageBean.setGroup(true);
        String groupType = this.groupInfo.getGroupType();
        if (TextUtils.equals(groupType, "AVChatRoom") || TextUtils.equals(groupType, "Community")) {
            tUIMessageBean.setNeedReadReceipt(false);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public ChatInfo getChatInfo() {
        return this.groupInfo;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void getGroupMessageReadReceipt(List<TUIMessageBean> list, IUIKitCallback<List<GroupMessageReceiptInfo>> iUIKitCallback) {
        this.provider.getGroupReadReceipt(list, iUIKitCallback);
    }

    public void initListener() {
        this.groupChatEventListener = new GroupChatEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.1
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void clearGroupMessage(String str) {
                if (TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.clearMessage();
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void exitGroupChat(String str) {
                GroupChatPresenter.this.onExitChat(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void handleRevoke(String str) {
                GroupChatPresenter.this.handleRevoke(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onApplied(int i2) {
                GroupChatPresenter.this.onApplied(i2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onGroupForceExit(String str) {
                GroupChatPresenter.this.onGroupForceExit(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onGroupNameChanged(String str, String str2) {
                if (GroupChatPresenter.this.groupInfo == null || !TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    return;
                }
                GroupChatPresenter.this.onGroupNameChanged(str2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onReadReport(List<GroupMessageReceiptInfo> list) {
                GroupChatPresenter.this.onReadReport(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
                if (GroupChatPresenter.this.groupInfo == null || !TextUtils.equals(tUIMessageBean.getGroupId(), GroupChatPresenter.this.groupInfo.getId())) {
                    TUIChatLog.i(GroupChatPresenter.TAG, "receive a new message , not belong to current chat.");
                } else {
                    GroupChatPresenter.this.onRecvNewMessage(tUIMessageBean);
                }
            }
        };
        TUIChatService.getInstance().setGroupChatEventListener(this.groupChatEventListener);
        initMessageSender();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void loadMessage(final int i2, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        GroupInfo groupInfo = this.groupInfo;
        if (groupInfo == null || this.isLoading) {
            return;
        }
        this.isLoading = true;
        String id = groupInfo.getId();
        if (i2 == 0) {
            this.provider.loadGroupMessage(id, 20, tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.3
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i3, String str2) {
                    String str3 = GroupChatPresenter.TAG;
                    TUIChatLog.e(str3, "load group message failed " + i3 + "  " + str2);
                    TUIChatUtils.callbackOnError(iUIKitCallback, i3, str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<TUIMessageBean> list) {
                    String str = GroupChatPresenter.TAG;
                    TUIChatLog.i(str, "load group message success " + list.size());
                    if (tUIMessageBean == null) {
                        GroupChatPresenter.this.isHaveMoreNewMessage = false;
                    }
                    GroupChatPresenter.this.onMessageLoadCompleted(list, i2);
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                }
            });
        } else {
            loadHistoryMessageList(id, true, i2, 20, tUIMessageBean, iUIKitCallback);
        }
    }

    public void onApplied(int i2) {
        ChatPresenter.ChatNotifyHandler chatNotifyHandler = this.chatNotifyHandler;
        if (chatNotifyHandler != null) {
            chatNotifyHandler.onApplied(i2);
        }
    }

    public void onGroupForceExit(String str) {
        if (this.chatNotifyHandler == null || !TextUtils.equals(str, this.groupInfo.getId())) {
            return;
        }
        this.chatNotifyHandler.onGroupForceExit();
    }

    public void onGroupMessageReadReceiptUpdated(List<TUIMessageBean> list, List<GroupMessageReceiptInfo> list2) {
        for (GroupMessageReceiptInfo groupMessageReceiptInfo : list2) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i2);
                if (TextUtils.equals(tUIMessageBean.getId(), groupMessageReceiptInfo.getMsgID())) {
                    tUIMessageBean.setUnreadCount(groupMessageReceiptInfo.getUnreadCount());
                    tUIMessageBean.setReadCount(groupMessageReceiptInfo.getReadCount());
                    updateAdapter(4, i2);
                }
            }
        }
    }

    public void onGroupNameChanged(String str) {
        ChatPresenter.ChatNotifyHandler chatNotifyHandler = this.chatNotifyHandler;
        if (chatNotifyHandler != null) {
            chatNotifyHandler.onGroupNameChanged(str);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void onMessageLoadCompleted(final List<TUIMessageBean> list, final int i2) {
        groupReadReport(this.groupInfo.getId());
        getGroupMessageReadReceipt(list, new IUIKitCallback<List<GroupMessageReceiptInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.4
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i3, String str2) {
                GroupChatPresenter.this.processLoadedMessage(list, i2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<GroupMessageReceiptInfo> list2) {
                for (GroupMessageReceiptInfo groupMessageReceiptInfo : list2) {
                    for (TUIMessageBean tUIMessageBean : list) {
                        if (TextUtils.equals(tUIMessageBean.getId(), groupMessageReceiptInfo.getMsgID())) {
                            tUIMessageBean.setReadCount(groupMessageReceiptInfo.getReadCount());
                            tUIMessageBean.setUnreadCount(groupMessageReceiptInfo.getUnreadCount());
                        }
                    }
                }
                GroupChatPresenter.this.processLoadedMessage(list, i2);
            }
        });
    }

    public void onReadReport(List<GroupMessageReceiptInfo> list) {
        if (this.groupInfo != null) {
            ArrayList arrayList = new ArrayList();
            for (GroupMessageReceiptInfo groupMessageReceiptInfo : list) {
                if (TextUtils.equals(groupMessageReceiptInfo.getGroupID(), this.groupInfo.getId())) {
                    arrayList.add(groupMessageReceiptInfo);
                }
            }
            onGroupMessageReadReceiptUpdated(this.loadedMessageInfoList, arrayList);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void sendGroupMessageReadReceipt(List<TUIMessageBean> list, final IUIKitCallback<Void> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean tUIMessageBean : list) {
            if (tUIMessageBean.isNeedReadReceipt()) {
                arrayList.add(tUIMessageBean);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.provider.sendGroupMessageReadReceipt(arrayList, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.2
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                String str3 = GroupChatPresenter.TAG;
                TUIChatLog.e(str3, "sendGroupMessageReadReceipt failed, errCode " + i2 + " errMsg " + str2);
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                TUIChatLog.i(GroupChatPresenter.TAG, "sendGroupMessageReadReceipt success");
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }
}
