package com.tencent.qcloud.tuikit.tuichat;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMFriendInfo;
import com.tencent.imsdk.v2.V2TIMFriendshipListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageReceipt;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.tuichat.bean.C2CMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.LocationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.OrderMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextAtMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextWarnMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IBaseMessageSender;
import com.tencent.qcloud.tuikit.tuichat.interfaces.NetworkConnectionListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.CallingMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.CustomLinkMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.FaceMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.FileMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ImageMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.LocationMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MergeMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.OrderViewHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.ReplyMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.SoundMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.TextMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.TextWarnMessageViewHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.TipsMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.VideoMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TUIChatService extends ServiceInitializer implements ITUIChatService {
    public static final String TAG = TUIChatService.class.getSimpleName();
    private static Context appContext;
    private static TUIChatConfigs chatConfig;
    private static TUIChatService instance;
    private WeakReference<C2CChatEventListener> c2CChatEventListener;
    private WeakReference<GroupChatEventListener> groupChatEventListener;
    private WeakReference<IBaseMessageSender> messageSender;
    private WeakReference<TotalUnreadCountListener> unreadCountListener;
    private final Map<String, Class<? extends TUIMessageBean>> messageBusinessIdMap = new HashMap();
    private final Map<Class<? extends TUIMessageBean>, Integer> messageViewTypeMap = new HashMap();
    private final Map<Integer, Class<? extends MessageBaseHolder>> messageViewHolderMap = new HashMap();
    private final List<WeakReference<NetworkConnectionListener>> connectListenerList = new ArrayList();
    private int viewType = 0;

    private void addCustomMessageType(String str, Class<? extends TUIMessageBean> cls, Class<? extends MessageBaseHolder> cls2) {
        this.viewType++;
        this.messageBusinessIdMap.put(str, cls);
        this.messageViewTypeMap.put(cls, Integer.valueOf(this.viewType));
        this.messageViewHolderMap.put(Integer.valueOf(this.viewType), cls2);
    }

    private void addDefaultMessageType(Class<? extends TUIMessageBean> cls, Class<? extends MessageBaseHolder> cls2) {
        int i2 = this.viewType + 1;
        this.viewType = i2;
        this.messageViewTypeMap.put(cls, Integer.valueOf(i2));
        this.messageViewHolderMap.put(Integer.valueOf(this.viewType), cls2);
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static TUIChatConfigs getChatConfig() {
        if (chatConfig == null) {
            chatConfig = TUIChatConfigs.getConfigs();
        }
        return chatConfig;
    }

    public static TUIChatService getInstance() {
        return instance;
    }

    private Object getOrDefault(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    private void initDefaultMessageType() {
        addDefaultMessageType(FaceMessageBean.class, FaceMessageHolder.class);
        addDefaultMessageType(FileMessageBean.class, FileMessageHolder.class);
        addDefaultMessageType(ImageMessageBean.class, ImageMessageHolder.class);
        addDefaultMessageType(LocationMessageBean.class, LocationMessageHolder.class);
        addDefaultMessageType(MergeMessageBean.class, MergeMessageHolder.class);
        addDefaultMessageType(SoundMessageBean.class, SoundMessageHolder.class);
        addDefaultMessageType(TextAtMessageBean.class, TextMessageHolder.class);
        addDefaultMessageType(TextMessageBean.class, TextMessageHolder.class);
        addDefaultMessageType(TipsMessageBean.class, TipsMessageHolder.class);
        addDefaultMessageType(VideoMessageBean.class, VideoMessageHolder.class);
        addDefaultMessageType(ReplyMessageBean.class, ReplyMessageHolder.class);
        addDefaultMessageType(CallingMessageBean.class, CallingMessageHolder.class);
    }

    private void initEvent() {
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_INFO_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_EXIT_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_MEMBER_KICKED_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_DISMISS, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_JOIN_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_INVITED_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_RECYCLE, this);
        TUICore.registerEvent(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED, TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_CLEAR_MESSAGE, this);
        TUICore.registerEvent(TUIConstants.TUIConversation.EVENT_UNREAD, TUIConstants.TUIConversation.EVENT_SUB_KEY_UNREAD_CHANGED, this);
    }

    private void initIMListener() {
        V2TIMManager.getMessageManager().addAdvancedMsgListener(new V2TIMAdvancedMsgListener() { // from class: com.tencent.qcloud.tuikit.tuichat.TUIChatService.1
            {
                TUIChatService.this = this;
            }

            @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
            public void onRecvC2CReadReceipt(List<V2TIMMessageReceipt> list) {
                C2CChatEventListener c2CChatEventListener = TUIChatService.getInstance().getC2CChatEventListener();
                if (c2CChatEventListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (V2TIMMessageReceipt v2TIMMessageReceipt : list) {
                        C2CMessageReceiptInfo c2CMessageReceiptInfo = new C2CMessageReceiptInfo();
                        c2CMessageReceiptInfo.setMessageReceipt(v2TIMMessageReceipt);
                        arrayList.add(c2CMessageReceiptInfo);
                    }
                    c2CChatEventListener.onReadReport(arrayList);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
            public void onRecvMessageModified(V2TIMMessage v2TIMMessage) {
                String str = TUIChatService.TAG;
                TUIChatLog.i(str, "onRecvMessageModified msgID:" + v2TIMMessage.getMsgID());
            }

            @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
            public void onRecvMessageReadReceipts(List<V2TIMMessageReceipt> list) {
                GroupChatEventListener groupChatEventListener = TUIChatService.getInstance().getGroupChatEventListener();
                if (groupChatEventListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (V2TIMMessageReceipt v2TIMMessageReceipt : list) {
                        GroupMessageReceiptInfo groupMessageReceiptInfo = new GroupMessageReceiptInfo();
                        groupMessageReceiptInfo.setMessageReceipt(v2TIMMessageReceipt);
                        arrayList.add(groupMessageReceiptInfo);
                    }
                    groupChatEventListener.onReadReport(arrayList);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
            public void onRecvMessageRevoked(String str) {
                C2CChatEventListener c2CChatEventListener = TUIChatService.getInstance().getC2CChatEventListener();
                if (c2CChatEventListener != null) {
                    c2CChatEventListener.handleRevoke(str);
                }
                GroupChatEventListener groupChatEventListener = TUIChatService.getInstance().getGroupChatEventListener();
                if (groupChatEventListener != null) {
                    groupChatEventListener.handleRevoke(str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
            public void onRecvNewMessage(V2TIMMessage v2TIMMessage) {
                TUIMessageBean parseMessage = ChatMessageParser.parseMessage(v2TIMMessage);
                if (parseMessage == null) {
                    return;
                }
                if (TextUtils.isEmpty(v2TIMMessage.getGroupID())) {
                    C2CChatEventListener c2CChatEventListener = TUIChatService.getInstance().getC2CChatEventListener();
                    if (c2CChatEventListener != null) {
                        c2CChatEventListener.onRecvNewMessage(parseMessage);
                        return;
                    }
                    return;
                }
                GroupChatEventListener groupChatEventListener = TUIChatService.getInstance().getGroupChatEventListener();
                if (groupChatEventListener != null) {
                    groupChatEventListener.onRecvNewMessage(parseMessage);
                }
            }
        });
        V2TIMManager.getFriendshipManager().addFriendListener(new V2TIMFriendshipListener() { // from class: com.tencent.qcloud.tuikit.tuichat.TUIChatService.2
            {
                TUIChatService.this = this;
            }

            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onFriendInfoChanged(List<V2TIMFriendInfo> list) {
                C2CChatEventListener c2CChatEventListener = TUIChatService.getInstance().getC2CChatEventListener();
                if (c2CChatEventListener != null) {
                    for (V2TIMFriendInfo v2TIMFriendInfo : list) {
                        if (TextUtils.isEmpty(v2TIMFriendInfo.getFriendRemark())) {
                            String nickName = v2TIMFriendInfo.getUserProfile().getNickName();
                            if (TextUtils.isEmpty(nickName)) {
                                c2CChatEventListener.onFriendNameChanged(v2TIMFriendInfo.getUserID(), v2TIMFriendInfo.getUserID());
                            } else {
                                c2CChatEventListener.onFriendNameChanged(v2TIMFriendInfo.getUserID(), nickName);
                            }
                        } else {
                            c2CChatEventListener.onFriendNameChanged(v2TIMFriendInfo.getUserID(), v2TIMFriendInfo.getFriendRemark());
                        }
                    }
                }
            }
        });
        V2TIMManager.getInstance().addIMSDKListener(new V2TIMSDKListener() { // from class: com.tencent.qcloud.tuikit.tuichat.TUIChatService.3
            {
                TUIChatService.this = this;
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectSuccess() {
                for (WeakReference weakReference : TUIChatService.this.connectListenerList) {
                    NetworkConnectionListener networkConnectionListener = (NetworkConnectionListener) weakReference.get();
                    if (networkConnectionListener != null) {
                        networkConnectionListener.onConnected();
                    }
                }
            }
        });
    }

    private void initMessageType() {
        addCustomMessageType(TUIChatConstants.BUSINESS_ID_CUSTOM_HELLO, CustomLinkMessageBean.class, CustomLinkMessageHolder.class);
        addCustomMessageType("order", OrderMessageBean.class, OrderViewHolder.class);
        addCustomMessageType("warning", TextWarnMessageBean.class, TextWarnMessageViewHolder.class);
    }

    private void initService() {
        TUICore.registerService("TUIChatService", this);
    }

    public C2CChatEventListener getC2CChatEventListener() {
        WeakReference<C2CChatEventListener> weakReference = this.c2CChatEventListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public GroupChatEventListener getGroupChatEventListener() {
        WeakReference<GroupChatEventListener> weakReference = this.groupChatEventListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public int getLightThemeResId() {
        return R.style.TUIChatLightTheme;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public int getLivelyThemeResId() {
        return R.style.TUIChatLivelyTheme;
    }

    public Class<? extends TUIMessageBean> getMessageBeanClass(String str) {
        return this.messageBusinessIdMap.get(str);
    }

    public IBaseMessageSender getMessageSender() {
        WeakReference<IBaseMessageSender> weakReference = this.messageSender;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Class<? extends MessageBaseHolder> getMessageViewHolderClass(int i2) {
        return this.messageViewHolderMap.get(Integer.valueOf(i2));
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public int getSeriousThemeResId() {
        return R.style.TUIChatSeriousTheme;
    }

    public TotalUnreadCountListener getUnreadCountListener() {
        WeakReference<TotalUnreadCountListener> weakReference = this.unreadCountListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getViewType(Class<? extends TUIMessageBean> cls) {
        Integer num = this.messageViewTypeMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public void init(Context context) {
        instance = this;
        appContext = context;
        initDefaultMessageType();
        initMessageType();
        initService();
        initEvent();
        initIMListener();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ITUIChatService, com.tencent.qcloud.tuicore.interfaces.ITUIService
    public Object onCall(String str, Map<String, Object> map) {
        V2TIMMessage v2TIMMessage;
        if (TextUtils.equals(TUIConstants.TUIChat.METHOD_SEND_MESSAGE, str)) {
            String str2 = (String) map.get("chatId");
            int intValue = ((Integer) getOrDefault(map.get(TUIConstants.TUIChat.CHAT_TYPE), 0)).intValue();
            String str3 = (String) getOrDefault(map.get(TUIConstants.TUIChat.MESSAGE_CONTENT), "");
            String str4 = (String) getOrDefault(map.get(TUIConstants.TUIChat.MESSAGE_DESCRIPTION), "");
            String str5 = (String) getOrDefault(map.get(TUIConstants.TUIChat.MESSAGE_EXTENSION), "");
            IBaseMessageSender messageSender = getMessageSender();
            if (messageSender != null) {
                messageSender.sendMessage(ChatMessageBuilder.buildCustomMessage(str3, str4, str5.getBytes()), str2, TUIChatUtils.isGroupChat(intValue));
                return null;
            }
            return null;
        } else if (TextUtils.equals(TUIConstants.TUIChat.METHOD_EXIT_CHAT, str)) {
            String str6 = (String) map.get("chatId");
            if (((Boolean) map.get(TUIConstants.TUIChat.IS_GROUP_CHAT)).booleanValue()) {
                GroupChatEventListener groupChatEventListener = getGroupChatEventListener();
                if (groupChatEventListener != null) {
                    groupChatEventListener.exitGroupChat(str6);
                    return null;
                }
                return null;
            }
            C2CChatEventListener c2CChatEventListener = getC2CChatEventListener();
            if (c2CChatEventListener != null) {
                c2CChatEventListener.exitC2CChat(str6);
                return null;
            }
            return null;
        } else if (!TextUtils.equals(TUIConstants.TUIChat.METHOD_GET_DISPLAY_STRING, str) || map == null || (v2TIMMessage = (V2TIMMessage) map.get(TUIConstants.TUIChat.V2TIMMESSAGE)) == null) {
            return null;
        } else {
            return ChatMessageParser.getDisplayString(v2TIMMessage);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ITUIChatService, com.tencent.qcloud.tuicore.interfaces.ITUINotification
    public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
        GroupChatEventListener groupChatEventListener;
        GroupChatEventListener groupChatEventListener2;
        if (TextUtils.equals(str, TUIConstants.TUIGroup.EVENT_GROUP)) {
            if (!TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_EXIT_GROUP) && !TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_DISMISS) && !TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_RECYCLE)) {
                if (TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_INFO_CHANGED)) {
                    if (map == null) {
                        return;
                    }
                    String str3 = (String) getOrDefault(map.get("groupName"), null);
                    String str4 = (String) getOrDefault(map.get("groupId"), "");
                    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || (groupChatEventListener2 = getGroupChatEventListener()) == null) {
                        return;
                    }
                    groupChatEventListener2.onGroupNameChanged(str4, str3);
                    return;
                } else if (!TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_MEMBER_KICKED_GROUP)) {
                    if (TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_CLEAR_MESSAGE)) {
                        String str5 = (String) getOrDefault(map.get("groupId"), "");
                        GroupChatEventListener groupChatEventListener3 = getGroupChatEventListener();
                        if (groupChatEventListener3 != null) {
                            groupChatEventListener3.clearGroupMessage(str5);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (map == null) {
                    return;
                } else {
                    String str6 = (String) getOrDefault(map.get("groupId"), "");
                    ArrayList arrayList = (ArrayList) map.get(TUIConstants.TUIGroup.GROUP_MEMBER_ID_LIST);
                    if (TextUtils.isEmpty(str6) || arrayList == null || arrayList.isEmpty() || !arrayList.contains(TUILogin.getLoginUser()) || (groupChatEventListener = getGroupChatEventListener()) == null) {
                        return;
                    }
                    groupChatEventListener.onGroupForceExit(str6);
                    return;
                }
            }
            GroupChatEventListener groupChatEventListener4 = getGroupChatEventListener();
            String str7 = map != null ? (String) getOrDefault(map.get("groupId"), "") : null;
            if (groupChatEventListener4 != null) {
                groupChatEventListener4.onGroupForceExit(str7);
            }
        } else if (str.equals(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED)) {
            if (!str2.equals(TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED) || map == null || map.isEmpty()) {
                return;
            }
            String str8 = (String) map.get(TUIConstants.TUIContact.FRIEND_ID);
            String str9 = (String) map.get(TUIConstants.TUIContact.FRIEND_REMARK);
            C2CChatEventListener c2CChatEventListener = getC2CChatEventListener();
            if (c2CChatEventListener != null) {
                c2CChatEventListener.onFriendNameChanged(str8, str9);
            }
        } else if (str.equals(TUIConstants.TUIConversation.EVENT_UNREAD) && str2.equals(TUIConstants.TUIConversation.EVENT_SUB_KEY_UNREAD_CHANGED)) {
            long longValue = ((Long) map.get(TUIConstants.TUIConversation.TOTAL_UNREAD_COUNT)).longValue();
            TotalUnreadCountListener unreadCountListener = getUnreadCountListener();
            if (unreadCountListener != null) {
                unreadCountListener.onTotalUnreadCountChanged(longValue);
            }
        }
    }

    public void registerNetworkListener(NetworkConnectionListener networkConnectionListener) {
        if (networkConnectionListener == null) {
            return;
        }
        for (WeakReference<NetworkConnectionListener> weakReference : this.connectListenerList) {
            if (weakReference.get() == networkConnectionListener) {
                return;
            }
        }
        this.connectListenerList.add(new WeakReference<>(networkConnectionListener));
    }

    public void setChatEventListener(C2CChatEventListener c2CChatEventListener) {
        this.c2CChatEventListener = new WeakReference<>(c2CChatEventListener);
    }

    public void setGroupChatEventListener(GroupChatEventListener groupChatEventListener) {
        this.groupChatEventListener = new WeakReference<>(groupChatEventListener);
    }

    public void setMessageSender(IBaseMessageSender iBaseMessageSender) {
        this.messageSender = new WeakReference<>(iBaseMessageSender);
    }

    public void setUnreadCountListener(TotalUnreadCountListener totalUnreadCountListener) {
        this.unreadCountListener = new WeakReference<>(totalUnreadCountListener);
    }
}
