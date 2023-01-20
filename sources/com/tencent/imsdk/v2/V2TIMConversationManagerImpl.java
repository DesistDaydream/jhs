package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.conversation.ConversationListener;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.conversation.ConversationResult;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.DraftMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class V2TIMConversationManagerImpl extends V2TIMConversationManager {
    private ConversationListener mConversationListener;
    private V2TIMConversationListener mV2TIMConversationListener;
    private final List<V2TIMConversationListener> mV2TIMConversationListenerList;

    /* loaded from: classes3.dex */
    public static class V2TIMConversationManagerImplHolder {
        private static final V2TIMConversationManagerImpl v2TIMConversationManagerImpl = new V2TIMConversationManagerImpl();

        private V2TIMConversationManagerImplHolder() {
        }
    }

    public static V2TIMConversationManagerImpl getInstance() {
        return V2TIMConversationManagerImplHolder.v2TIMConversationManagerImpl;
    }

    private void initListener() {
        if (this.mConversationListener == null) {
            this.mConversationListener = new ConversationListener() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.1
                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationChanged(List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List<V2TIMConversation> unmodifiableList = Collections.unmodifiableList(arrayList);
                    for (V2TIMConversationListener v2TIMConversationListener : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        v2TIMConversationListener.onConversationChanged(unmodifiableList);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onNewConversation(List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List<V2TIMConversation> unmodifiableList = Collections.unmodifiableList(arrayList);
                    for (V2TIMConversationListener v2TIMConversationListener : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        v2TIMConversationListener.onNewConversation(unmodifiableList);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFailed() {
                    for (V2TIMConversationListener v2TIMConversationListener : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        v2TIMConversationListener.onSyncServerFailed();
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFinish() {
                    for (V2TIMConversationListener v2TIMConversationListener : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        v2TIMConversationListener.onSyncServerFinish();
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerStart() {
                    for (V2TIMConversationListener v2TIMConversationListener : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        v2TIMConversationListener.onSyncServerStart();
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onTotalUnreadMessageCountChanged(long j2) {
                    for (V2TIMConversationListener v2TIMConversationListener : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        v2TIMConversationListener.onTotalUnreadMessageCountChanged(j2);
                    }
                }
            };
        }
        ConversationManager.getInstance().setConversationListener(this.mConversationListener);
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void addConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        if (v2TIMConversationListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.contains(v2TIMConversationListener)) {
                    return;
                }
                V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.add(v2TIMConversationListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void deleteConversation(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().deleteConversation(getConversationKey(str), true, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.11
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversation(String str, final V2TIMValueCallback<V2TIMConversation> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationID is empty");
                return;
            }
            return;
        }
        ConversationManager.getInstance().getConversationInfo(getConversationKey(str), new IMCallback<Conversation>(new V2TIMValueCallback<Conversation>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.9
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i2, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(Conversation conversation) {
                if (v2TIMValueCallback != null) {
                    V2TIMConversation v2TIMConversation = new V2TIMConversation();
                    v2TIMConversation.setConversation(conversation);
                    v2TIMValueCallback.onSuccess(v2TIMConversation);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.10
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str2) {
                super.fail(i2, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Conversation conversation) {
                super.success((AnonymousClass10) conversation);
            }
        });
    }

    public ConversationKey getConversationKey(String str) {
        ConversationKey conversationKey = new ConversationKey();
        if (str.indexOf("c2c_") == 0) {
            String substring = str.substring(4);
            conversationKey.setConversationType(1);
            conversationKey.setConversationID(substring);
        } else if (str.indexOf("group_") == 0) {
            String substring2 = str.substring(6);
            conversationKey.setConversationType(2);
            conversationKey.setConversationID(substring2);
        }
        return conversationKey;
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversationList(long j2, int i2, final V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback) {
        ConversationManager.getInstance().getConversationList(j2, i2, new IMCallback<ConversationResult>(new V2TIMValueCallback<ConversationResult>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.5
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i3, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(ConversationResult conversationResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMConversationResult v2TIMConversationResult = new V2TIMConversationResult();
                    v2TIMConversationResult.setConversationResult(conversationResult);
                    v2TIMValueCallback.onSuccess(v2TIMConversationResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.6
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str) {
                super.fail(i3, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(ConversationResult conversationResult) {
                super.success((AnonymousClass6) conversationResult);
            }
        });
        BaseManager.getInstance().checkTUIComponent(2);
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getTotalUnreadMessageCount(V2TIMValueCallback<Long> v2TIMValueCallback) {
        ConversationManager.getInstance().getTotalUnreadMessageCount(new IMCallback<Long>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.14
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Long l2) {
                super.success((AnonymousClass14) l2);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void pinConversation(String str, boolean z, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().pinConversation(getConversationKey(str), z, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.13
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void removeConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        if (v2TIMConversationListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.remove(v2TIMConversationListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void setConversationDraft(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationID is empty");
                return;
            }
            return;
        }
        ConversationKey conversationKey = getConversationKey(str);
        DraftMessage draftMessage = new DraftMessage();
        if (str2 != null) {
            draftMessage.setUserDefinedData(str2.getBytes());
        }
        ConversationManager.getInstance().setConversationDraft(conversationKey, draftMessage, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.12
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str3) {
                super.fail(i2, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void setConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.remove(V2TIMConversationManagerImpl.this.mV2TIMConversationListener);
                }
                if (v2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.add(v2TIMConversationListener);
                }
                V2TIMConversationManagerImpl.this.mV2TIMConversationListener = v2TIMConversationListener;
            }
        });
    }

    private V2TIMConversationManagerImpl() {
        this.mV2TIMConversationListenerList = new ArrayList();
        initListener();
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversationList(List<String> list, final V2TIMValueCallback<List<V2TIMConversation>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationIDList cannot be empty");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(getConversationKey(str));
        }
        ConversationManager.getInstance().getConversationList(arrayList, new IMCallback<List<Conversation>>(new V2TIMValueCallback<List<Conversation>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.7
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i2, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<Conversation> list2) {
                ArrayList arrayList2 = new ArrayList();
                for (Conversation conversation : list2) {
                    V2TIMConversation v2TIMConversation = new V2TIMConversation();
                    v2TIMConversation.setConversation(conversation);
                    arrayList2.add(v2TIMConversation);
                }
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(arrayList2);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.8
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str2) {
                super.fail(i2, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<Conversation> list2) {
                super.success((AnonymousClass8) list2);
            }
        });
    }
}
