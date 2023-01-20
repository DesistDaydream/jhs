package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageContainerBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflinePushInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IBaseMessageSender;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.OfflinePushInfoUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public abstract class ChatPresenter {
    private static final int FORWARD_C2C_INTERVAL = 50;
    private static final int FORWARD_GROUP_INTERVAL = 90;
    public static final int MSG_PAGE_COUNT = 20;
    private static final int READ_REPORT_INTERVAL = 1000;
    private static final String TAG = "ChatPresenter";
    private IBaseMessageSender baseMessageSender;
    public ChatNotifyHandler chatNotifyHandler;
    private TUIMessageBean locateMessage;
    public IMessageAdapter messageListAdapter;
    private MessageRecyclerView messageRecyclerView;
    public final ChatProvider provider;
    public List<TUIMessageBean> loadedMessageInfoList = new ArrayList();
    private int currentChatUnreadCount = 0;
    private TUIMessageBean mCacheNewMessage = null;
    private long lastReadReportTime = 0;
    private boolean canReadReport = true;
    private final MessageReadReportHandler readReportHandler = new MessageReadReportHandler();
    private boolean isChatFragmentShow = false;
    public boolean isHaveMoreNewMessage = false;
    public boolean isLoading = false;

    /* loaded from: classes3.dex */
    public interface ChatNotifyHandler {
        void onApplied(int i2);

        void onExitChat(String str);

        void onFriendNameChanged(String str);

        void onGroupForceExit();

        void onGroupNameChanged(String str);
    }

    /* loaded from: classes3.dex */
    public static class MessageReadReportHandler extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* loaded from: classes3.dex */
    public interface TypingListener {
        void onTyping();
    }

    public ChatPresenter() {
        TUIChatLog.i(TAG, "ChatPresenter Init");
        this.provider = new ChatProvider();
    }

    public void addMessageAfterPreProcess(TUIMessageBean tUIMessageBean) {
        String userId;
        String str;
        boolean z;
        if (tUIMessageBean != null) {
            if (!TextUtils.isEmpty(tUIMessageBean.getGroupId())) {
                str = tUIMessageBean.getGroupId();
                userId = null;
                z = true;
            } else if (TextUtils.isEmpty(tUIMessageBean.getUserId())) {
                return;
            } else {
                userId = tUIMessageBean.getUserId();
                str = null;
                z = false;
            }
            addMessageInfo(tUIMessageBean);
            if (isChatFragmentShow()) {
                MessageRecyclerView messageRecyclerView = this.messageRecyclerView;
                if (messageRecyclerView != null && messageRecyclerView.isDisplayJumpMessageLayout()) {
                    if (tUIMessageBean.getStatus() != 275) {
                        this.currentChatUnreadCount++;
                        if (this.mCacheNewMessage == null) {
                            this.mCacheNewMessage = tUIMessageBean;
                        }
                        this.messageRecyclerView.displayBackToNewMessage(true, this.mCacheNewMessage.getId(), this.currentChatUnreadCount);
                        return;
                    } else if (tUIMessageBean.getStatus() == 275) {
                        int i2 = this.currentChatUnreadCount - 1;
                        this.currentChatUnreadCount = i2;
                        if (i2 == 0) {
                            this.messageRecyclerView.displayBackToNewMessage(false, "", 0);
                            this.mCacheNewMessage = null;
                            return;
                        }
                        this.messageRecyclerView.displayBackToNewMessage(true, this.mCacheNewMessage.getId(), this.currentChatUnreadCount);
                        return;
                    } else {
                        return;
                    }
                }
                this.mCacheNewMessage = null;
                this.currentChatUnreadCount = 0;
                if (z) {
                    limitReadReport(str, true);
                } else {
                    limitReadReport(userId, false);
                }
            }
        }
    }

    private void limitReadReport(final String str, final boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.lastReadReportTime;
        if (j2 >= 1000) {
            readReport(str, z);
            this.lastReadReportTime = currentTimeMillis;
        } else if (!this.canReadReport) {
            TUIChatLog.d(TAG, "limitReadReport : Reporting , please wait.");
        } else {
            long j3 = 1000 - j2;
            String str2 = TAG;
            TUIChatLog.d(str2, "limitReadReport : Please retry after " + j3 + " ms.");
            this.canReadReport = false;
            this.readReportHandler.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.15
                {
                    ChatPresenter.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ChatPresenter.this.readReport(str, z);
                    ChatPresenter.this.lastReadReportTime = System.currentTimeMillis();
                    ChatPresenter.this.canReadReport = true;
                }
            }, j3);
        }
    }

    private void loadToWayMessageAsync(final String str, final boolean z, final int i2, final int i3, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        arrayList.add(tUIMessageBean);
        this.locateMessage = tUIMessageBean;
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final boolean[] zArr = {false};
        Runnable runnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.4
            {
                ChatPresenter.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatPresenter.this.provider.loadHistoryMessageList(str, z, i3 / 2, tUIMessageBean, 1, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.4.1
                    {
                        AnonymousClass4.this = this;
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str2, int i4, String str3) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, i4, str3);
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        zArr[0] = true;
                        countDownLatch.countDown();
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list) {
                        arrayList.addAll(list);
                        countDownLatch.countDown();
                    }
                });
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.5
            {
                ChatPresenter.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatPresenter.this.provider.loadHistoryMessageList(str, z, i3 / 2, tUIMessageBean, 0, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.5.1
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str2, int i4, String str3) {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        zArr[0] = true;
                        countDownLatch.countDown();
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list) {
                        arrayList2.addAll(list);
                        countDownLatch.countDown();
                    }
                });
            }
        };
        Runnable runnable3 = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.6
            {
                ChatPresenter.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (zArr[0]) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "load failed");
                    return;
                }
                Collections.reverse(arrayList);
                arrayList2.addAll(0, arrayList);
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.6.1
                    {
                        AnonymousClass6.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        ChatPresenter.this.onMessageLoadCompleted(arrayList2, i2);
                    }
                });
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList2);
            }
        };
        ThreadHelper threadHelper = ThreadHelper.INST;
        threadHelper.execute(runnable);
        threadHelper.execute(runnable2);
        threadHelper.execute(runnable3);
    }

    private void notifyTyping() {
        if (safetyCall()) {
            return;
        }
        TUIChatLog.w(TAG, "notifyTyping unSafetyCall");
    }

    public void onLoadedMessageProcessed(List<TUIMessageBean> list, int i2) {
        boolean z = i2 == 0;
        boolean z2 = i2 == 2;
        boolean z3 = i2 == 3;
        if (z || z2 || z3) {
            Collections.reverse(list);
        }
        if (!z && !z2 && !z3) {
            this.loadedMessageInfoList.addAll(list);
            updateAdapter(3, list.size());
        } else {
            this.loadedMessageInfoList.addAll(0, list);
            if (z) {
                if (this.loadedMessageInfoList.size() == list.size()) {
                    updateAdapter(1, list.size());
                } else {
                    updateAdapter(2, list.size());
                }
            } else if (z2) {
                updateAdapter(7, this.locateMessage);
            } else {
                updateAdapter(10, this.locateMessage);
            }
        }
        this.isLoading = false;
    }

    private void preProcessReplyMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        preProcessReplyMessage(arrayList, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.9
            {
                ChatPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, "preProcessReplyMessage failed");
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list) {
                if (list != null && list.size() == 1) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list.get(0));
                } else {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "preProcessReplyMessage failed");
                }
            }
        });
    }

    public void readReport(String str, boolean z) {
        if (!z) {
            String str2 = TAG;
            TUIChatLog.i(str2, "C2C message ReadReport userId is " + str);
            c2cReadReport(str);
            return;
        }
        String str3 = TAG;
        TUIChatLog.i(str3, "Group message ReadReport groupId is " + str);
        groupReadReport(str);
    }

    private void resendMessageInfo(TUIMessageBean tUIMessageBean) {
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.loadedMessageInfoList.size()) {
                break;
            } else if (TextUtils.equals(this.loadedMessageInfoList.get(i2).getId(), tUIMessageBean.getId())) {
                this.loadedMessageInfoList.remove(i2);
                updateAdapter(5, i2);
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            addMessageInfo(tUIMessageBean);
        }
    }

    public void updateMessageInfo(TUIMessageBean tUIMessageBean) {
        for (int i2 = 0; i2 < this.loadedMessageInfoList.size(); i2++) {
            if (TextUtils.equals(this.loadedMessageInfoList.get(i2).getId(), tUIMessageBean.getId())) {
                this.loadedMessageInfoList.set(i2, tUIMessageBean);
                updateAdapter(4, i2);
                return;
            }
        }
    }

    public void addMessage(final TUIMessageBean tUIMessageBean) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "addMessage unSafetyCall");
        } else {
            preProcessReplyMessage(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.12
                {
                    ChatPresenter.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i2, String str2) {
                    ChatPresenter.this.addMessageAfterPreProcess(tUIMessageBean);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(TUIMessageBean tUIMessageBean2) {
                    ChatPresenter.this.addMessageAfterPreProcess(tUIMessageBean2);
                }
            });
        }
    }

    public void addMessageInfo(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean == null || checkExist(tUIMessageBean)) {
            return;
        }
        this.loadedMessageInfoList.add(tUIMessageBean);
        updateAdapter(8, 1);
    }

    public void assembleGroupMessage(TUIMessageBean tUIMessageBean) {
    }

    public void c2cReadReport(String str) {
        this.provider.c2cReadReport(str);
    }

    public boolean checkExist(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean != null) {
            String id = tUIMessageBean.getId();
            for (int size = this.loadedMessageInfoList.size() - 1; size >= 0; size--) {
                if (TextUtils.equals(this.loadedMessageInfoList.get(size).getId(), id)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean checkFailedMessageInfos(List<TUIMessageBean> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (this.provider.checkFailedMessageInfo(list.get(i2))) {
                    return true;
                }
            }
            return false;
        }
        TUIChatLog.w(TAG, "checkFailedMessagesById unSafetyCall");
        return false;
    }

    public boolean checkFailedMessages(List<Integer> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (this.provider.checkFailedMessageInfo(this.loadedMessageInfoList.get(list.get(i2).intValue()))) {
                    return true;
                }
            }
            return false;
        }
        TUIChatLog.w(TAG, "checkFailedMessages unSafetyCall");
        return false;
    }

    public void clearMessage() {
        this.loadedMessageInfoList.clear();
        this.messageListAdapter.onViewNeedRefresh(0, 0);
    }

    public void clearMessageAndReLoad() {
        if (!this.isHaveMoreNewMessage) {
            this.messageListAdapter.onScrollToEnd();
            return;
        }
        this.loadedMessageInfoList.clear();
        this.messageListAdapter.onViewNeedRefresh(0, 0);
        loadMessage(0, null);
    }

    public void deleteMessage(final TUIMessageBean tUIMessageBean) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "deleteMessage unSafetyCall");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        this.provider.deleteMessages(arrayList, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.14
            {
                ChatPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r3) {
                int indexOf = ChatPresenter.this.loadedMessageInfoList.indexOf(tUIMessageBean);
                ChatPresenter.this.loadedMessageInfoList.remove(tUIMessageBean);
                ChatPresenter.this.updateAdapter(5, indexOf);
            }
        });
    }

    public void deleteMessageInfos(final List<TUIMessageBean> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            this.provider.deleteMessages(list, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.16
                {
                    ChatPresenter.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i2, String str2) {
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r4) {
                    for (int size = ChatPresenter.this.loadedMessageInfoList.size() - 1; size >= 0; size--) {
                        int size2 = list.size() - 1;
                        while (true) {
                            if (size2 < 0) {
                                break;
                            } else if (TextUtils.equals(ChatPresenter.this.loadedMessageInfoList.get(size).getId(), ((TUIMessageBean) list.get(size2)).getId())) {
                                ChatPresenter.this.loadedMessageInfoList.remove(size);
                                ChatPresenter.this.updateAdapter(5, size);
                                break;
                            } else {
                                size2--;
                            }
                        }
                    }
                }
            });
        } else {
            TUIChatLog.w(TAG, "deleteMessages unSafetyCall");
        }
    }

    public void deleteMessages(final List<Integer> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(this.loadedMessageInfoList.get(list.get(i2).intValue()));
            }
            this.provider.deleteMessages(arrayList, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.17
                {
                    ChatPresenter.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i3, String str2) {
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r3) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        ChatPresenter.this.loadedMessageInfoList.remove(list.get(size));
                        ChatPresenter.this.updateAdapter(5, size);
                    }
                }
            });
            return;
        }
        TUIChatLog.w(TAG, "deleteMessages unSafetyCall");
    }

    public void findMessage(String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.provider.findMessage(arrayList, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.22
            {
                ChatPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list) {
                if (list != null && !list.isEmpty()) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list.get(0));
                } else {
                    TUIChatUtils.callbackOnError(iUIKitCallback, 0, "");
                }
            }
        });
    }

    public void forwardMessage(List<TUIMessageBean> list, boolean z, String str, String str2, int i2, boolean z2, IUIKitCallback iUIKitCallback) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "sendMessage unSafetyCall");
            return;
        }
        for (TUIMessageBean tUIMessageBean : list) {
            if (tUIMessageBean instanceof TextMessageBean) {
                String str3 = TAG;
                TUIChatLog.d(str3, "chatprensetor forwardMessage onTextSelected selectedText = " + ((TextMessageBean) tUIMessageBean).getSelectText());
            }
        }
        if (i2 == 0) {
            forwardMessageOneByOne(list, z, str, str2, z2, iUIKitCallback);
        } else if (i2 == 1) {
            forwardMessageMerge(list, z, str, str2, z2, iUIKitCallback);
        } else {
            TUIChatLog.d(TAG, "invalid forwardMode");
        }
    }

    public void forwardMessageInternal(final TUIMessageBean tUIMessageBean, boolean z, String str, OfflinePushInfo offlinePushInfo, final IUIKitCallback iUIKitCallback) {
        if (tUIMessageBean == null) {
            TUIChatLog.e(TAG, "forwardMessageInternal null message!");
            return;
        }
        String sendMessage = this.provider.sendMessage(tUIMessageBean, z, str, offlinePushInfo, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.20
            {
                ChatPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                String str4 = ChatPresenter.TAG;
                TUIChatLog.v(str4, "sendMessage fail:" + i2 + "=" + str3);
                if (!ChatPresenter.this.safetyCall()) {
                    TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                    return;
                }
                IUIKitCallback iUIKitCallback2 = iUIKitCallback;
                if (iUIKitCallback2 != null) {
                    iUIKitCallback2.onError(ChatPresenter.TAG, i2, str3);
                }
                tUIMessageBean.setStatus(3);
                ChatPresenter.this.updateMessageInfo(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                if (!ChatPresenter.this.safetyCall()) {
                    TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                    return;
                }
                IUIKitCallback iUIKitCallback2 = iUIKitCallback;
                if (iUIKitCallback2 != null) {
                    iUIKitCallback2.onSuccess(tUIMessageBean2);
                }
                tUIMessageBean.setStatus(2);
                ChatPresenter.this.updateMessageInfo(tUIMessageBean);
            }
        });
        String str2 = TAG;
        TUIChatLog.i(str2, "sendMessage msgID:" + sendMessage);
        tUIMessageBean.setId(sendMessage);
        tUIMessageBean.setStatus(1);
    }

    public void forwardMessageMerge(List<TUIMessageBean> list, boolean z, String str, String str2, boolean z2, IUIKitCallback iUIKitCallback) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Context appContext = TUIChatService.getAppContext();
        if (appContext == null) {
            TUIChatLog.d(TAG, "context == null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size() && i2 < 3; i2++) {
            TUIMessageBean tUIMessageBean = list.get(i2);
            String displayName = ChatMessageParser.getDisplayName(tUIMessageBean.getV2TIMMessage());
            if (!(tUIMessageBean instanceof TipsMessageBean)) {
                if (tUIMessageBean instanceof TextMessageBean) {
                    arrayList.add(displayName + Constants.COLON_SEPARATOR + tUIMessageBean.getExtra());
                } else if (tUIMessageBean instanceof FaceMessageBean) {
                    arrayList.add(displayName + Constants.COLON_SEPARATOR + appContext.getString(R.string.custom_emoji));
                } else if (tUIMessageBean instanceof SoundMessageBean) {
                    arrayList.add(displayName + Constants.COLON_SEPARATOR + appContext.getString(R.string.audio_extra));
                } else if (tUIMessageBean instanceof ImageMessageBean) {
                    arrayList.add(displayName + Constants.COLON_SEPARATOR + appContext.getString(R.string.picture_extra));
                } else if (tUIMessageBean instanceof VideoMessageBean) {
                    arrayList.add(displayName + Constants.COLON_SEPARATOR + appContext.getString(R.string.video_extra));
                } else if (tUIMessageBean instanceof FileMessageBean) {
                    arrayList.add(displayName + Constants.COLON_SEPARATOR + appContext.getString(R.string.file_extra));
                } else if (tUIMessageBean instanceof MergeMessageBean) {
                    arrayList.add(displayName + Constants.COLON_SEPARATOR + appContext.getString(R.string.forward_extra));
                } else {
                    arrayList.add(displayName + Constants.COLON_SEPARATOR + tUIMessageBean.getExtra());
                }
            }
        }
        TUIMessageBean buildMergeMessage = ChatMessageBuilder.buildMergeMessage(list, str2, arrayList, TUIChatService.getAppContext().getString(R.string.forward_compatible_text));
        if (z2) {
            sendMessage(buildMergeMessage, false, iUIKitCallback);
            return;
        }
        assembleGroupMessage(buildMergeMessage);
        OfflineMessageContainerBean offlineMessageContainerBean = new OfflineMessageContainerBean();
        OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
        offlineMessageBean.content = buildMergeMessage.getExtra().toString();
        offlineMessageBean.sender = buildMergeMessage.getSender();
        offlineMessageBean.nickname = TUIChatConfigs.getConfigs().getGeneralConfig().getUserNickname();
        offlineMessageBean.faceUrl = TUIChatConfigs.getConfigs().getGeneralConfig().getUserFaceUrl();
        offlineMessageContainerBean.entity = offlineMessageBean;
        if (z) {
            offlineMessageBean.chatType = 2;
            offlineMessageBean.sender = str;
        }
        OfflinePushInfo offlinePushInfo = new OfflinePushInfo();
        offlinePushInfo.setExtension(new Gson().z(offlineMessageContainerBean).getBytes());
        offlinePushInfo.setDescription(str2);
        offlinePushInfo.setAndroidOPPOChannelID("jihuanshe");
        if (TUIChatConfigs.getConfigs().getGeneralConfig().isAndroidPrivateRing()) {
            offlinePushInfo.setAndroidSound(OfflinePushInfoUtils.PRIVATE_RING_NAME);
        }
        forwardMessageInternal(buildMergeMessage, z, str, offlinePushInfo, iUIKitCallback);
    }

    public void forwardMessageOneByOne(final List<TUIMessageBean> list, final boolean z, final String str, final String str2, final boolean z2, final IUIKitCallback iUIKitCallback) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.19
            {
                ChatPresenter.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = z ? 90 : 50;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    TUIMessageBean buildForwardMessage = ChatMessageBuilder.buildForwardMessage(((TUIMessageBean) list.get(i3)).getV2TIMMessage());
                    if (z2) {
                        ChatPresenter.this.sendMessage(buildForwardMessage, false, iUIKitCallback);
                        try {
                            Thread.sleep(i2);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    } else if (buildForwardMessage != null && buildForwardMessage.getStatus() != 1) {
                        ChatPresenter.this.assembleGroupMessage(buildForwardMessage);
                        OfflineMessageContainerBean offlineMessageContainerBean = new OfflineMessageContainerBean();
                        OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
                        offlineMessageBean.content = buildForwardMessage.getExtra().toString();
                        offlineMessageBean.sender = buildForwardMessage.getSender();
                        offlineMessageBean.nickname = TUIChatConfigs.getConfigs().getGeneralConfig().getUserNickname();
                        offlineMessageBean.faceUrl = TUIChatConfigs.getConfigs().getGeneralConfig().getUserFaceUrl();
                        offlineMessageContainerBean.entity = offlineMessageBean;
                        if (z) {
                            offlineMessageBean.chatType = 2;
                            offlineMessageBean.sender = str;
                        }
                        OfflinePushInfo offlinePushInfo = new OfflinePushInfo();
                        offlinePushInfo.setExtension(new Gson().z(offlineMessageContainerBean).getBytes());
                        offlinePushInfo.setDescription(str2);
                        offlinePushInfo.setAndroidOPPOChannelID("jihuanshe");
                        if (TUIChatConfigs.getConfigs().getGeneralConfig().isAndroidPrivateRing()) {
                            offlinePushInfo.setAndroidSound(OfflinePushInfoUtils.PRIVATE_RING_NAME);
                        }
                        ChatPresenter.this.forwardMessageInternal(buildForwardMessage, z, str, offlinePushInfo, iUIKitCallback);
                        try {
                            Thread.sleep(i2);
                        } catch (InterruptedException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        });
        thread.setName("ForwardMessageThread");
        ThreadHelper.INST.execute(thread);
    }

    public List<TUIMessageBean> forwardTextMessageForSelected(List<TUIMessageBean> list) {
        if (list == null || list.size() <= 1) {
            ArrayList arrayList = new ArrayList();
            TUIMessageBean tUIMessageBean = list.get(0);
            if (tUIMessageBean instanceof TextMessageBean) {
                TextMessageBean textMessageBean = (TextMessageBean) tUIMessageBean;
                if (TextUtils.equals(textMessageBean.getText(), textMessageBean.getSelectText())) {
                    return list;
                }
                arrayList.add(ChatMessageBuilder.buildTextMessage(textMessageBean.getSelectText()));
                return arrayList;
            }
            return list;
        }
        return list;
    }

    public ChatInfo getChatInfo() {
        return null;
    }

    public void getConversationLastMessage(String str, IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        this.provider.getConversationLastMessage(str, iUIKitCallback);
    }

    public void getGroupMessageReadReceipt(List<TUIMessageBean> list, IUIKitCallback<List<GroupMessageReceiptInfo>> iUIKitCallback) {
    }

    public List<TUIMessageBean> getSelectPositionMessage(List<Integer> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).intValue() < this.loadedMessageInfoList.size()) {
                    arrayList.add(this.loadedMessageInfoList.get(list.get(i2).intValue()));
                } else {
                    TUIChatLog.d(TAG, "mCurrentProvider not include SelectPosition ");
                }
            }
            return arrayList;
        }
        TUIChatLog.w(TAG, "getSelectPositionMessage unSafetyCall");
        return null;
    }

    public List<TUIMessageBean> getSelectPositionMessageById(List<String> list) {
        ArrayList arrayList = null;
        if (safetyCall() && list != null && !list.isEmpty()) {
            List<TUIMessageBean> list2 = this.loadedMessageInfoList;
            if (list2 != null && list2.size() > 0) {
                arrayList = new ArrayList();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list2.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i2), list2.get(i3).getId())) {
                            arrayList.add(list2.get(i3));
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            return arrayList;
        }
        TUIChatLog.w(TAG, "getSelectPositionMessageById unSafetyCall");
        return null;
    }

    public void groupReadReport(String str) {
        this.provider.groupReadReport(str);
    }

    public void handleRevoke(String str) {
        MessageRecyclerView messageRecyclerView;
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "handleInvoke unSafetyCall");
            return;
        }
        String str2 = TAG;
        TUIChatLog.i(str2, "handleInvoke msgID = " + str);
        for (int i2 = 0; i2 < this.loadedMessageInfoList.size(); i2++) {
            TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i2);
            if (TextUtils.equals(tUIMessageBean.getId(), str)) {
                tUIMessageBean.setStatus(TUIMessageBean.MSG_STATUS_REVOKE);
                updateAdapter(4, i2);
                if (isChatFragmentShow() && (messageRecyclerView = this.messageRecyclerView) != null && messageRecyclerView.isDisplayJumpMessageLayout() && tUIMessageBean.getStatus() == 275) {
                    int i3 = this.currentChatUnreadCount - 1;
                    this.currentChatUnreadCount = i3;
                    if (i3 <= 0) {
                        this.messageRecyclerView.displayBackToNewMessage(false, "", 0);
                        this.mCacheNewMessage = null;
                    } else {
                        ChatInfo chatInfo = getChatInfo();
                        if (!(chatInfo != null && (chatInfo.getType() != 2 ? tUIMessageBean.getV2TIMMessage().getTimestamp() <= this.mCacheNewMessage.getV2TIMMessage().getTimestamp() : tUIMessageBean.getV2TIMMessage().getSeq() <= this.mCacheNewMessage.getV2TIMMessage().getSeq()))) {
                            this.messageRecyclerView.displayBackToNewMessage(true, this.mCacheNewMessage.getId(), this.currentChatUnreadCount);
                            return;
                        }
                        int i4 = i2 + 1;
                        if (i4 < this.loadedMessageInfoList.size()) {
                            TUIMessageBean tUIMessageBean2 = this.loadedMessageInfoList.get(i4);
                            this.mCacheNewMessage = tUIMessageBean2;
                            this.messageRecyclerView.displayBackToNewMessage(true, tUIMessageBean2.getId(), this.currentChatUnreadCount);
                        } else {
                            this.messageRecyclerView.displayBackToNewMessage(false, "", 0);
                            this.mCacheNewMessage = null;
                        }
                    }
                }
            }
        }
    }

    public void initMessageSender() {
        this.baseMessageSender = new IBaseMessageSender() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.1
            {
                ChatPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IBaseMessageSender
            public void sendMessage(TUIMessageBean tUIMessageBean, String str, boolean z) {
                ChatPresenter.this.sendMessage(tUIMessageBean, str, z);
            }
        };
        TUIChatService.getInstance().setMessageSender(this.baseMessageSender);
    }

    public boolean isChatFragmentShow() {
        return this.isChatFragmentShow;
    }

    public void loadApplyList(final IUIKitCallback<List<GroupApplyInfo>> iUIKitCallback) {
        this.provider.loadApplyInfo(new IUIKitCallback<List<GroupApplyInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.21
            {
                ChatPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, str, i2, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<GroupApplyInfo> list) {
                if (ChatPresenter.this.getChatInfo() instanceof GroupInfo) {
                    String id = ChatPresenter.this.getChatInfo().getId();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        GroupApplyInfo groupApplyInfo = list.get(i2);
                        if (TextUtils.equals(id, groupApplyInfo.getGroupApplication().getGroupID()) && !groupApplyInfo.isStatusHandled()) {
                            arrayList.add(groupApplyInfo);
                        }
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
                }
            }
        });
    }

    public void loadHistoryMessageList(String str, boolean z, final int i2, final int i3, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        if (i2 != 2 && i2 != 3) {
            this.provider.loadHistoryMessageList(str, z, i3, tUIMessageBean, i2, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.7
                {
                    ChatPresenter.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str2, int i4, String str3) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i4, str3);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<TUIMessageBean> list) {
                    if (i2 == 1) {
                        if (list.size() >= i3) {
                            ChatPresenter.this.isHaveMoreNewMessage = true;
                        } else {
                            ChatPresenter.this.isHaveMoreNewMessage = false;
                        }
                    }
                    ChatPresenter.this.onMessageLoadCompleted(list, i2);
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                }
            });
        } else {
            loadToWayMessageAsync(str, z, i2, i3, tUIMessageBean, iUIKitCallback);
        }
    }

    public void loadMessage(int i2, TUIMessageBean tUIMessageBean) {
        loadMessage(i2, tUIMessageBean, null);
    }

    public void loadMessage(int i2, TUIMessageBean tUIMessageBean, IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
    }

    public void locateMessage(String str, final IUIKitCallback<Void> iUIKitCallback) {
        for (TUIMessageBean tUIMessageBean : this.loadedMessageInfoList) {
            if (TextUtils.equals(str, tUIMessageBean.getId())) {
                if (tUIMessageBean.getStatus() == 275) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "origin msg is revoked");
                    return;
                } else {
                    updateAdapter(9, tUIMessageBean);
                    return;
                }
            }
        }
        findMessage(str, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.3
            {
                ChatPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                if (tUIMessageBean2.getStatus() == 275) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "origin msg is revoked");
                    return;
                }
                ChatPresenter.this.loadedMessageInfoList.clear();
                ChatPresenter.this.loadMessage(3, tUIMessageBean2, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.3.1
                    {
                        AnonymousClass3.this = this;
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str2, int i2, String str3) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, i2, str3);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list) {
                    }
                });
            }
        });
    }

    public void locateMessageBySeq(String str, long j2, final IUIKitCallback<Void> iUIKitCallback) {
        if (j2 < 0) {
            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "invalid param");
        } else {
            this.provider.getGroupMessageBySeq(str, j2, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.2
                {
                    ChatPresenter.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str2, int i2, String str3) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i2, str3);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<TUIMessageBean> list) {
                    if (list != null && list.size() != 0) {
                        TUIMessageBean tUIMessageBean = list.get(0);
                        if (tUIMessageBean.getStatus() == 275) {
                            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "origin msg is revoked");
                            return;
                        } else {
                            ChatPresenter.this.locateMessage(tUIMessageBean.getId(), new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.2.1
                                {
                                    AnonymousClass2.this = this;
                                }

                                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                                public void onError(String str2, int i2, String str3) {
                                    TUIChatUtils.callbackOnError(iUIKitCallback, i2, str3);
                                }

                                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                                public void onSuccess(Void r1) {
                                }
                            });
                            return;
                        }
                    }
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "null message");
                }
            });
        }
    }

    public void markMessageAsRead(ChatInfo chatInfo) {
        if (chatInfo == null) {
            TUIChatLog.i(TAG, "markMessageAsRead() chatInfo is null");
            return;
        }
        boolean z = chatInfo.getType() != 1;
        String id = chatInfo.getId();
        if (z) {
            groupReadReport(id);
        } else {
            c2cReadReport(id);
        }
    }

    public void onExitChat(String str) {
        ChatNotifyHandler chatNotifyHandler = this.chatNotifyHandler;
        if (chatNotifyHandler != null) {
            chatNotifyHandler.onExitChat(str);
        }
    }

    public void onMessageLoadCompleted(List<TUIMessageBean> list, int i2) {
    }

    public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
        String str = TAG;
        TUIChatLog.i(str, "onRecvNewMessage msgID:" + tUIMessageBean.getId());
        if (this.isHaveMoreNewMessage) {
            return;
        }
        addMessage(tUIMessageBean);
    }

    public void processLoadedMessage(final List<TUIMessageBean> list, final int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            TUIMessageBean tUIMessageBean = list.get(i3);
            if (!checkExist(tUIMessageBean)) {
                arrayList.add(tUIMessageBean);
            }
        }
        preProcessReplyMessage(arrayList, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.8
            {
                ChatPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i4, String str2) {
                ChatPresenter.this.onLoadedMessageProcessed(list, i2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list2) {
                ChatPresenter.this.onLoadedMessageProcessed(list2, i2);
            }
        });
    }

    public void resetCurrentChatUnreadCount() {
        this.currentChatUnreadCount = 0;
        this.mCacheNewMessage = null;
    }

    public void revokeMessage(final TUIMessageBean tUIMessageBean) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "revokeMessage unSafetyCall");
        } else {
            this.provider.revokeMessage(tUIMessageBean, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.18
                {
                    ChatPresenter.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i2, String str2) {
                    if (i2 == 6223) {
                        ToastUtil.toastLongMessage(TUIChatService.getAppContext().getString(R.string.send_two_mins));
                        return;
                    }
                    ToastUtil.toastLongMessage(TUIChatService.getAppContext().getString(R.string.revoke_fail) + i2 + "=" + str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r2) {
                    if (!ChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(ChatPresenter.TAG, "revokeMessage unSafetyCall");
                    } else {
                        ChatPresenter.this.updateMessageRevoked(tUIMessageBean.getId());
                    }
                }
            });
        }
    }

    public boolean safetyCall() {
        return getChatInfo() != null;
    }

    public void sendGroupMessageReadReceipt(List<TUIMessageBean> list, IUIKitCallback<Void> iUIKitCallback) {
    }

    public void sendMessage(TUIMessageBean tUIMessageBean, String str, boolean z) {
        if (TextUtils.isEmpty(str) || (TextUtils.equals(getChatInfo().getId(), str) && z == TUIChatUtils.isGroupChat(getChatInfo().getType()))) {
            sendMessage(tUIMessageBean, false, (IUIKitCallback) null);
        }
    }

    public void setChatFragmentShow(boolean z) {
        this.isChatFragmentShow = z;
    }

    public void setChatNotifyHandler(ChatNotifyHandler chatNotifyHandler) {
        this.chatNotifyHandler = chatNotifyHandler;
    }

    public void setDraft(String str) {
        ChatInfo chatInfo = getChatInfo();
        if (chatInfo == null) {
            return;
        }
        this.provider.setDraft(TUIChatUtils.getConversationIdByUserId(chatInfo.getId(), TUIChatUtils.isGroupChat(chatInfo.getType())), str);
    }

    public void setMessageListAdapter(IMessageAdapter iMessageAdapter) {
        this.messageListAdapter = iMessageAdapter;
    }

    public void setMessageRecycleView(MessageRecyclerView messageRecyclerView) {
        this.messageRecyclerView = messageRecyclerView;
        this.currentChatUnreadCount = 0;
        this.mCacheNewMessage = null;
    }

    public void updateAdapter(int i2, int i3) {
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onDataSourceChanged(this.loadedMessageInfoList);
            this.messageListAdapter.onViewNeedRefresh(i2, i3);
        }
    }

    public boolean updateMessageRevoked(String str) {
        for (int i2 = 0; i2 < this.loadedMessageInfoList.size(); i2++) {
            TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i2);
            if (TextUtils.equals(tUIMessageBean.getId(), str)) {
                tUIMessageBean.setStatus(TUIMessageBean.MSG_STATUS_REVOKE);
                updateAdapter(4, i2);
            }
        }
        return false;
    }

    public void findMessage(List<String> list, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        this.provider.findMessage(list, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.23
            {
                ChatPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list2) {
                if (list2 != null && !list2.isEmpty()) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list2);
                } else {
                    TUIChatUtils.callbackOnError(iUIKitCallback, 0, "");
                }
            }
        });
    }

    public void preProcessReplyMessage(final List<TUIMessageBean> list, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        for (TUIMessageBean tUIMessageBean : list) {
            if (tUIMessageBean instanceof ReplyMessageBean) {
                arrayList.add(((ReplyMessageBean) tUIMessageBean).getOriginMsgId());
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.10
            {
                ChatPresenter.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatPresenter.this.findMessage(arrayList, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.10.1
                    {
                        AnonymousClass10.this = this;
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        countDownLatch.countDown();
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list2) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            TUIMessageBean tUIMessageBean2 = list2.get(i2);
                            if (tUIMessageBean2 != null) {
                                for (TUIMessageBean tUIMessageBean3 : list) {
                                    if (tUIMessageBean3 instanceof ReplyMessageBean) {
                                        ReplyMessageBean replyMessageBean = (ReplyMessageBean) tUIMessageBean3;
                                        if (TextUtils.equals(replyMessageBean.getOriginMsgId(), tUIMessageBean2.getId())) {
                                            replyMessageBean.setOriginMessageBean(tUIMessageBean2);
                                        }
                                    }
                                }
                            }
                        }
                        countDownLatch.countDown();
                    }
                });
            }
        };
        ThreadHelper threadHelper = ThreadHelper.INST;
        threadHelper.execute(runnable);
        threadHelper.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.11
            {
                ChatPresenter.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "mergeRunnable error");
                    e2.printStackTrace();
                }
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.11.1
                    {
                        AnonymousClass11.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                    }
                });
            }
        });
    }

    public void sendMessage(final TUIMessageBean tUIMessageBean, boolean z, final IUIKitCallback iUIKitCallback) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "sendMessage unSafetyCall");
        } else if (tUIMessageBean == null || tUIMessageBean.getStatus() == 1) {
        } else {
            assembleGroupMessage(tUIMessageBean);
            String sendMessage = this.provider.sendMessage(tUIMessageBean, getChatInfo(), new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.13
                {
                    ChatPresenter.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i2, String str2) {
                    String str3 = ChatPresenter.TAG;
                    TUIChatLog.v(str3, "sendMessage fail:" + i2 + "=" + str2);
                    if (!ChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                        return;
                    }
                    TUIChatUtils.callbackOnError(iUIKitCallback, ChatPresenter.TAG, i2, str2);
                    tUIMessageBean.setStatus(3);
                    ChatPresenter.this.updateMessageInfo(tUIMessageBean);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onProgress(Object obj) {
                    TUIChatUtils.callbackOnProgress(iUIKitCallback, obj);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(TUIMessageBean tUIMessageBean2) {
                    String str = ChatPresenter.TAG;
                    TUIChatLog.v(str, "sendMessage onSuccess:" + tUIMessageBean2.getId());
                    if (!ChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                        return;
                    }
                    tUIMessageBean.setStatus(2);
                    TUIMessageBean tUIMessageBean3 = tUIMessageBean;
                    if (tUIMessageBean3 instanceof FileMessageBean) {
                        tUIMessageBean3.setDownloadStatus(6);
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean2);
                    ChatPresenter.this.updateMessageInfo(tUIMessageBean);
                }
            });
            String str = TAG;
            TUIChatLog.i(str, "sendMessage msgID:" + sendMessage);
            tUIMessageBean.setId(sendMessage);
            tUIMessageBean.setStatus(1);
            if (z) {
                resendMessageInfo(tUIMessageBean);
            } else {
                addMessageInfo(tUIMessageBean);
            }
        }
    }

    public void updateAdapter(int i2, TUIMessageBean tUIMessageBean) {
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onDataSourceChanged(this.loadedMessageInfoList);
            this.messageListAdapter.onViewNeedRefresh(i2, tUIMessageBean);
        }
    }
}
