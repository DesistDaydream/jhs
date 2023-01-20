package com.tencent.qcloud.tuikit.tuiconversation;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener;
import com.tencent.qcloud.tuikit.tuiconversation.util.ConversationUtils;
import com.tencent.qcloud.tuikit.tuiconversation.util.TUIConversationLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TUIConversationService extends ServiceInitializer implements ITUIConversationService {
    public static final String TAG = TUIConversationService.class.getSimpleName();
    private static Context appContext;
    private static TUIConversationService instance;
    private WeakReference<ConversationEventListener> conversationEventListener;

    public static Context getAppContext() {
        return appContext;
    }

    public static TUIConversationService getInstance() {
        return instance;
    }

    private Object getOrDefault(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    private void initEvent() {
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_EXIT_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_MEMBER_KICKED_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_DISMISS, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_RECYCLE, this);
        TUICore.registerEvent(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED, TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_CLEAR_MESSAGE, this);
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, this);
    }

    private void initIMListener() {
        V2TIMManager.getConversationManager().addConversationListener(new V2TIMConversationListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.TUIConversationService.2
            {
                TUIConversationService.this = this;
            }

            @Override // com.tencent.imsdk.v2.V2TIMConversationListener
            public void onConversationChanged(List<V2TIMConversation> list) {
                ConversationEventListener conversationEventListener = TUIConversationService.getInstance().getConversationEventListener();
                if (conversationEventListener != null) {
                    conversationEventListener.onConversationChanged(ConversationUtils.convertV2TIMConversationList(list));
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMConversationListener
            public void onNewConversation(List<V2TIMConversation> list) {
                ConversationEventListener conversationEventListener = TUIConversationService.getInstance().getConversationEventListener();
                if (conversationEventListener != null) {
                    conversationEventListener.onNewConversation(ConversationUtils.convertV2TIMConversationList(list));
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMConversationListener
            public void onSyncServerFailed() {
            }

            @Override // com.tencent.imsdk.v2.V2TIMConversationListener
            public void onSyncServerFinish() {
            }

            @Override // com.tencent.imsdk.v2.V2TIMConversationListener
            public void onSyncServerStart() {
            }

            @Override // com.tencent.imsdk.v2.V2TIMConversationListener
            public void onTotalUnreadMessageCountChanged(long j2) {
                ConversationEventListener conversationEventListener = TUIConversationService.getInstance().getConversationEventListener();
                if (conversationEventListener != null) {
                    conversationEventListener.updateTotalUnreadMessageCount(j2);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TUIConstants.TUIConversation.TOTAL_UNREAD_COUNT, Long.valueOf(j2));
                TUICore.notifyEvent(TUIConstants.TUIConversation.EVENT_UNREAD, TUIConstants.TUIConversation.EVENT_SUB_KEY_UNREAD_CHANGED, hashMap);
            }
        });
    }

    private void initService() {
        TUICore.registerService("TUIConversationService", this);
    }

    public ConversationEventListener getConversationEventListener() {
        WeakReference<ConversationEventListener> weakReference = this.conversationEventListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public void init(Context context) {
        instance = this;
        appContext = context;
        initService();
        initEvent();
        initIMListener();
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ITUIConversationService, com.tencent.qcloud.tuicore.interfaces.ITUIService
    public Object onCall(String str, Map<String, Object> map) {
        Bundle bundle = new Bundle();
        ConversationEventListener conversationEventListener = getInstance().getConversationEventListener();
        if (conversationEventListener == null) {
            String str2 = TAG;
            TUIConversationLog.e(str2, "execute " + str + " failed , conversationEvent listener is null");
            return bundle;
        }
        if (TextUtils.equals(TUIConstants.TUIConversation.METHOD_IS_TOP_CONVERSATION, str)) {
            String str3 = (String) map.get("chatId");
            if (!TextUtils.isEmpty(str3)) {
                bundle.putBoolean(TUIConstants.TUIConversation.IS_TOP, conversationEventListener.isTopConversation(str3));
            }
        } else if (TextUtils.equals(TUIConstants.TUIConversation.METHOD_SET_TOP_CONVERSATION, str)) {
            String str4 = (String) map.get("chatId");
            boolean booleanValue = ((Boolean) map.get(TUIConstants.TUIConversation.IS_SET_TOP)).booleanValue();
            if (!TextUtils.isEmpty(str4)) {
                conversationEventListener.setConversationTop(str4, booleanValue, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.TUIConversationService.1
                    {
                        TUIConversationService.this = this;
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str5, int i2, String str6) {
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Void r1) {
                    }
                });
            }
        } else if (TextUtils.equals(TUIConstants.TUIConversation.METHOD_GET_TOTAL_UNREAD_COUNT, str)) {
            return Long.valueOf(conversationEventListener.getUnreadTotal());
        } else {
            if (TextUtils.equals(TUIConstants.TUIConversation.METHOD_UPDATE_TOTAL_UNREAD_COUNT, str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(TUIConstants.TUIConversation.TOTAL_UNREAD_COUNT, Long.valueOf(conversationEventListener.getUnreadTotal()));
                TUICore.notifyEvent(TUIConstants.TUIConversation.EVENT_UNREAD, TUIConstants.TUIConversation.EVENT_SUB_KEY_UNREAD_CHANGED, hashMap);
            } else if (TextUtils.equals(TUIConstants.TUIConversation.METHOD_DELETE_CONVERSATION, str)) {
                conversationEventListener.deleteConversation((String) map.get(TUIConstants.TUIConversation.CONVERSATION_ID));
            }
        }
        return bundle;
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ITUIConversationService, com.tencent.qcloud.tuicore.interfaces.ITUINotification
    public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
        ConversationEventListener conversationEventListener;
        if (TextUtils.equals(str, TUIConstants.TUIGroup.EVENT_GROUP)) {
            if (!TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_EXIT_GROUP) && !TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_DISMISS) && !TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_RECYCLE)) {
                if (!TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_MEMBER_KICKED_GROUP)) {
                    if (TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_CLEAR_MESSAGE)) {
                        String str3 = (String) getOrDefault(map.get("groupId"), "");
                        ConversationEventListener conversationEventListener2 = getConversationEventListener();
                        if (conversationEventListener2 != null) {
                            conversationEventListener2.clearConversationMessage(str3, true);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (map == null) {
                    return;
                } else {
                    String str4 = (String) getOrDefault(map.get("groupId"), "");
                    ArrayList arrayList = (ArrayList) map.get(TUIConstants.TUIGroup.GROUP_MEMBER_ID_LIST);
                    if (TextUtils.isEmpty(str4) || arrayList == null || arrayList.isEmpty()) {
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals((String) it.next(), TUILogin.getLoginUser())) {
                            ConversationEventListener conversationEventListener3 = getConversationEventListener();
                            if (conversationEventListener3 != null) {
                                conversationEventListener3.deleteConversation(str4, true);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
            }
            ConversationEventListener conversationEventListener4 = getConversationEventListener();
            String str5 = map != null ? (String) getOrDefault(map.get("groupId"), "") : null;
            if (conversationEventListener4 != null) {
                conversationEventListener4.deleteConversation(str5, true);
            }
        } else if (str.equals(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED)) {
            if (!str2.equals(TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED) || map == null || map.isEmpty() || (conversationEventListener = getInstance().getConversationEventListener()) == null) {
                return;
            }
            conversationEventListener.onFriendRemarkChanged((String) map.get(TUIConstants.TUIContact.FRIEND_ID), (String) map.get(TUIConstants.TUIContact.FRIEND_REMARK));
        } else if (TextUtils.equals(str, TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED)) {
            str2.equals(TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS);
        }
    }

    public void setConversationEventListener(ConversationEventListener conversationEventListener) {
        this.conversationEventListener = new WeakReference<>(conversationEventListener);
    }
}
