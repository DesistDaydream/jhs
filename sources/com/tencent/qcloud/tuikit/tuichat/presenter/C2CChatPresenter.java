package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.qcloud.tuicore.GlobalConfig;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.C2CMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.List;

/* loaded from: classes3.dex */
public class C2CChatPresenter extends ChatPresenter {
    private static final String TAG = "C2CChatPresenter";
    private C2CChatEventListener chatEventListener;
    private ChatInfo chatInfo;
    public GlobalConfig globalConfig;

    public C2CChatPresenter() {
        TUIChatLog.i(TAG, "C2CChatPresenter Init");
        String string = TUIConfig.getAppContext().getSharedPreferences(TUIConfig.COMMON_SP, 0).getString(TUIConfig.GLOBAL_CONFIG, "");
        Gson gson = new Gson();
        if (string.isEmpty()) {
            return;
        }
        this.globalConfig = (GlobalConfig) gson.n(string, GlobalConfig.class);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public void initListener() {
        this.chatEventListener = new C2CChatEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter.1
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void exitC2CChat(String str) {
                C2CChatPresenter.this.onExitChat(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void handleRevoke(String str) {
                C2CChatPresenter.this.handleRevoke(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onFriendNameChanged(String str, String str2) {
                if (C2CChatPresenter.this.chatInfo == null || !TextUtils.equals(str, C2CChatPresenter.this.chatInfo.getId())) {
                    return;
                }
                C2CChatPresenter.this.onFriendInfoChanged();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onReadReport(List<C2CMessageReceiptInfo> list) {
                C2CChatPresenter.this.onReadReport(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
                if (C2CChatPresenter.this.chatInfo == null || !TextUtils.equals(tUIMessageBean.getUserId(), C2CChatPresenter.this.chatInfo.getId())) {
                    TUIChatLog.i(C2CChatPresenter.TAG, "receive a new message , not belong to current chat.");
                } else {
                    C2CChatPresenter.this.onRecvNewMessage(tUIMessageBean);
                }
            }
        };
        TUIChatService.getInstance().setChatEventListener(this.chatEventListener);
        initMessageSender();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void loadMessage(final int i2, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        ChatInfo chatInfo = this.chatInfo;
        if (chatInfo == null || this.isLoading) {
            return;
        }
        this.isLoading = true;
        String id = chatInfo.getId();
        if (i2 == 0) {
            this.provider.loadC2CMessage(id, 20, tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter.2
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i3, String str2) {
                    String str3 = C2CChatPresenter.TAG;
                    TUIChatLog.e(str3, "load c2c message failed " + i3 + "  " + str2);
                    TUIChatUtils.callbackOnError(iUIKitCallback, i3, str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<TUIMessageBean> list) {
                    String str = C2CChatPresenter.TAG;
                    TUIChatLog.i(str, "load c2c message success " + list.size());
                    if (tUIMessageBean == null) {
                        C2CChatPresenter.this.isHaveMoreNewMessage = false;
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                    C2CChatPresenter.this.onMessageLoadCompleted(list, i2);
                }
            });
        } else {
            loadHistoryMessageList(id, false, i2, 20, tUIMessageBean, iUIKitCallback);
        }
    }

    public void onFriendInfoChanged() {
        this.provider.getFriendName(this.chatInfo.getId(), new IUIKitCallback<String[]>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(String[] strArr) {
                String id = C2CChatPresenter.this.chatInfo.getId();
                if (!TextUtils.isEmpty(strArr[0])) {
                    id = strArr[0];
                } else if (!TextUtils.isEmpty(strArr[1])) {
                    id = strArr[1];
                }
                C2CChatPresenter.this.onFriendNameChanged(id);
            }
        });
    }

    public void onFriendNameChanged(String str) {
        ChatPresenter.ChatNotifyHandler chatNotifyHandler = this.chatNotifyHandler;
        if (chatNotifyHandler != null) {
            chatNotifyHandler.onFriendNameChanged(str);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void onMessageLoadCompleted(List<TUIMessageBean> list, int i2) {
        c2cReadReport(this.chatInfo.getId());
        processLoadedMessage(list, i2);
    }

    public void onReadReport(List<C2CMessageReceiptInfo> list) {
        String str = TAG;
        TUIChatLog.i(str, "onReadReport:" + list.size());
        if (!safetyCall()) {
            TUIChatLog.w(str, "onReadReport unSafetyCall");
        } else if (list.size() != 0) {
            C2CMessageReceiptInfo c2CMessageReceiptInfo = list.get(0);
            for (C2CMessageReceiptInfo c2CMessageReceiptInfo2 : list) {
                if (TextUtils.equals(c2CMessageReceiptInfo2.getUserID(), getChatInfo().getId()) && c2CMessageReceiptInfo.getTimestamp() < c2CMessageReceiptInfo2.getTimestamp()) {
                    c2CMessageReceiptInfo = c2CMessageReceiptInfo2;
                }
            }
            for (int i2 = 0; i2 < this.loadedMessageInfoList.size(); i2++) {
                TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i2);
                if (TextUtils.equals(tUIMessageBean.getUserId(), c2CMessageReceiptInfo.getUserID())) {
                    if (tUIMessageBean.getMessageTime() > c2CMessageReceiptInfo.getTimestamp()) {
                        tUIMessageBean.setPeerRead(false);
                    } else if (!tUIMessageBean.isPeerRead()) {
                        tUIMessageBean.setPeerRead(true);
                        updateAdapter(4, i2);
                    }
                }
            }
        }
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }
}
