package com.tencent.imsdk.v2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.XGServerInfo;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupListener;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.group.TopicInfo;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.manager.CustomServerInfo;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.manager.SDKListener;
import com.tencent.imsdk.message.C2CMessageReceipt;
import com.tencent.imsdk.message.GroupMessageReceipt;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class V2TIMManagerImpl extends V2TIMManager {
    private static final String TAG = "V2TIMManagerImpl";
    private GroupListener mGroupInternalListener;
    private V2TIMSDKListener mIMSDKListener;
    private MessageListener mMessageInternalListener;
    private V2TIMGroupListener mV2TIMGroupListener;
    private Object mLockObject = new Object();
    private final List<V2TIMSDKListener> mIMSDKListenerList = new ArrayList();
    private final List<V2TIMGroupListener> mGroupListenerList = new ArrayList();
    private List<V2TIMSimpleMsgListener> mV2TIMSimpleMsgListenerList = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public static class V2TIMManagerImplHolder {
        private static final V2TIMManagerImpl v2TIMManagerImpl = new V2TIMManagerImpl();

        private V2TIMManagerImplHolder() {
        }
    }

    public V2TIMManagerImpl() {
        initMessageListener();
        initGroupListener();
        V2TIMMessageManagerImpl.getInstance().initListener();
    }

    private void callbackOnError(V2TIMValueCallback<Object> v2TIMValueCallback, int i2, String str) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(i2, str);
        }
    }

    private void callbackOnSuccess(V2TIMValueCallback<Object> v2TIMValueCallback, Object obj) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onSuccess(obj);
        }
    }

    public static V2TIMManagerImpl getInstance() {
        return V2TIMManagerImplHolder.v2TIMManagerImpl;
    }

    private void initGroupListener() {
        this.mGroupInternalListener = new GroupListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.25
            {
                V2TIMManagerImpl.this = this;
            }

            public V2TIMGroupMemberInfo convertToV2GroupMemberInfo(GroupMemberInfo groupMemberInfo) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                if (groupMemberInfo != null) {
                    v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                }
                return v2TIMGroupMemberInfo;
            }

            public List<V2TIMGroupMemberInfo> convertToV2GroupMemberInfoList(List<GroupMemberInfo> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupMemberInfo groupMemberInfo : list) {
                    arrayList.add(convertToV2GroupMemberInfo(groupMemberInfo));
                }
                return arrayList;
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onApplicationProcessed(String str, GroupMemberInfo groupMemberInfo, boolean z, String str2) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onApplicationProcessed(str, convertToV2GroupMemberInfo(groupMemberInfo), z, str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGrantAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onGrantAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupAttributeChanged(String str, Map<String, String> map) {
                Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onGroupAttributeChanged(str, unmodifiableMap);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupCreated(String str) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onGroupCreated(str);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupDismissed(String str, GroupMemberInfo groupMemberInfo) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onGroupDismissed(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupInfoChanged(String str, List<GroupInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupInfoChangeItem groupInfoChangeItem : list) {
                    V2TIMGroupChangeInfo v2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
                    v2TIMGroupChangeInfo.setGroupInfoChangeItem(groupInfoChangeItem);
                    arrayList.add(v2TIMGroupChangeInfo);
                }
                List<V2TIMGroupChangeInfo> unmodifiableList = Collections.unmodifiableList(arrayList);
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onGroupInfoChanged(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupRecycled(String str, GroupMemberInfo groupMemberInfo) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onGroupRecycled(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberEnter(String str, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onMemberEnter(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberInfoChanged(String str, List<GroupMemberInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupMemberInfoChangeItem groupMemberInfoChangeItem : list) {
                    V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
                    v2TIMGroupMemberChangeInfo.setGroupMemberInfoChangeItem(groupMemberInfoChangeItem);
                    arrayList.add(v2TIMGroupMemberChangeInfo);
                }
                List<V2TIMGroupMemberChangeInfo> unmodifiableList = Collections.unmodifiableList(arrayList);
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onMemberInfoChanged(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberInvited(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onMemberInvited(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberKicked(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onMemberKicked(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberLeave(String str, GroupMemberInfo groupMemberInfo) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onMemberLeave(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onQuitFromGroup(String str) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onQuitFromGroup(str);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveJoinApplication(String str, GroupMemberInfo groupMemberInfo, String str2) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onReceiveJoinApplication(str, convertToV2GroupMemberInfo(groupMemberInfo), str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveRESTCustomData(String str, byte[] bArr) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onReceiveRESTCustomData(str, (byte[]) bArr.clone());
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onRevokeAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onRevokeAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onTopicCreated(String str, String str2) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onTopicCreated(str, str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onTopicDeleted(String str, List<String> list) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onTopicDeleted(str, list);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onTopicInfoChanged(String str, TopicInfo topicInfo) {
                V2TIMTopicInfo v2TIMTopicInfo = new V2TIMTopicInfo();
                v2TIMTopicInfo.setTopicInfo(topicInfo);
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    v2TIMGroupListener.onTopicInfoChanged(str, v2TIMTopicInfo);
                }
            }
        };
        GroupManager.getInstance().setGroupListener(this.mGroupInternalListener);
    }

    private void initLocalStorage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid userID");
        } else {
            BaseManager.getInstance().initLocalStorage(str, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.23
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        }
    }

    private void initMessageListener() {
        this.mMessageInternalListener = new MessageListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.24
            {
                V2TIMManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveC2CMessageReceipt(List<C2CMessageReceipt> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveGroupMessageReceipt(List<GroupMessageReceipt> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageModified(List<Message> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageRevoked(List<MessageKey> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveNewMessage(List<Message> list) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo;
                if (list == null || list.isEmpty()) {
                    return;
                }
                for (Message message : list) {
                    int messageType = message.getMessageType();
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    int elemType = v2TIMMessage.getElemType();
                    V2TIMUserInfo v2TIMUserInfo = null;
                    if (messageType == Message.MESSAGE_TYPE_C2C) {
                        V2TIMUserInfo v2TIMUserInfo2 = new V2TIMUserInfo();
                        v2TIMUserInfo2.setUserID(v2TIMMessage.getSender());
                        v2TIMUserInfo2.setNickName(v2TIMMessage.getNickName());
                        v2TIMUserInfo2.setFaceUrl(v2TIMMessage.getFaceUrl());
                        v2TIMUserInfo = v2TIMUserInfo2;
                        v2TIMGroupMemberInfo = null;
                    } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                        v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                        GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                        groupMemberInfo.setGroupID(message.getGroupID());
                        groupMemberInfo.setUserID(message.getSenderUserID());
                        groupMemberInfo.setNickname(message.getNickName());
                        groupMemberInfo.setNameCard(message.getNameCard());
                        groupMemberInfo.setFaceUrl(message.getFaceUrl());
                        groupMemberInfo.setFriendRemark(message.getFriendRemark());
                        v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                    } else {
                        v2TIMGroupMemberInfo = null;
                    }
                    if (elemType == 1) {
                        V2TIMTextElem textElem = v2TIMMessage.getTextElem();
                        synchronized (V2TIMManagerImpl.this.mLockObject) {
                            for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                if (messageType == Message.MESSAGE_TYPE_C2C) {
                                    v2TIMSimpleMsgListener.onRecvC2CTextMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, textElem.getText());
                                } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                    v2TIMSimpleMsgListener.onRecvGroupTextMessage(v2TIMMessage.getMsgID(), message.getGroupID(), v2TIMGroupMemberInfo, textElem.getText());
                                }
                            }
                        }
                    } else if (elemType == 2) {
                        V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
                        synchronized (V2TIMManagerImpl.this.mLockObject) {
                            for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener2 : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                if (messageType == Message.MESSAGE_TYPE_C2C) {
                                    v2TIMSimpleMsgListener2.onRecvC2CCustomMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, customElem.getData());
                                } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                    v2TIMSimpleMsgListener2.onRecvGroupCustomMessage(v2TIMMessage.getMsgID(), v2TIMMessage.getGroupID(), v2TIMGroupMemberInfo, customElem.getData());
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        };
        MessageCenter.getInstance().addMessageListener(this.mMessageInternalListener);
    }

    private void setBuildInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("buildBrand");
                String optString2 = jSONObject.optString("buildManufacturer");
                String optString3 = jSONObject.optString("buildModel");
                String optString4 = jSONObject.optString("buildVersionRelease");
                int optInt = jSONObject.optInt("buildVersionSDKInt");
                SystemUtil.setBuildBrand(optString);
                SystemUtil.setBuildManufacturer(optString2);
                SystemUtil.setBuildModel(optString3);
                SystemUtil.setBuildVersionRelease(optString4);
                SystemUtil.setBuildVersionSDKInt(optInt);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e2) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e2.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setCosSaveRegion(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("conversationID");
                String optString2 = jSONObject.optString("cosSaveRegion");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    ConversationManager.getInstance().setCosSaveRegionForConversation(V2TIMConversationManagerImpl.getInstance().getConversationKey(optString), optString2, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.22
                        {
                            V2TIMManagerImpl.this = this;
                        }

                        @Override // com.tencent.imsdk.common.IMCallback
                        public void fail(int i2, String str2) {
                            super.fail(i2, str2);
                        }

                        @Override // com.tencent.imsdk.common.IMCallback
                        public void success(Object obj2) {
                            super.success(obj2);
                        }
                    });
                    return;
                }
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setCustomServerInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            CustomServerInfo customServerInfo = new CustomServerInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("longconnectionAddressList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        CustomServerInfo.ServerAddress serverAddress = new CustomServerInfo.ServerAddress();
                        serverAddress.ip = jSONObject2.optString(XGServerInfo.TAG_IP);
                        serverAddress.port = jSONObject2.optInt("port");
                        serverAddress.isIPv6 = jSONObject2.has("isIPv6") ? jSONObject2.optBoolean("isIPv6") : false;
                        arrayList.add(serverAddress);
                    }
                    customServerInfo.longconnectionAddressList = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("shortconnectionAddressList");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                        CustomServerInfo.ServerAddress serverAddress2 = new CustomServerInfo.ServerAddress();
                        serverAddress2.ip = jSONObject3.optString(XGServerInfo.TAG_IP);
                        serverAddress2.port = jSONObject3.optInt("port");
                        serverAddress2.isIPv6 = jSONObject3.has("isIPv6") ? jSONObject3.optBoolean("isIPv6") : false;
                        arrayList2.add(serverAddress2);
                    }
                    customServerInfo.shortconnectionAddressList = arrayList2;
                }
                customServerInfo.serverPublicKey = jSONObject.optString("serverPublicKey");
                BaseManager.getInstance().setCustomServerInfo(customServerInfo);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e2) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e2.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setIPv6Prior(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().setIPv6Prior(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void setLibraryPath(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        if (BaseManager.getInstance().setLibraryPath((String) obj)) {
            callbackOnSuccess(v2TIMValueCallback, null);
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "system load so library failed");
        }
    }

    private void setProxyInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("proxyType") && jSONObject.has("proxyHost") && jSONObject.has("proxyPort")) {
                    SDKConfig.ProxyInfo proxyInfo = new SDKConfig.ProxyInfo();
                    proxyInfo.proxyType = jSONObject.optInt("proxyType");
                    proxyInfo.proxyHost = jSONObject.optString("proxyHost");
                    proxyInfo.proxyPort = jSONObject.optInt("proxyPort");
                    if (jSONObject.has("proxyUsername")) {
                        proxyInfo.proxyUsername = jSONObject.optString("proxyUsername");
                    }
                    if (jSONObject.has("proxyPassword")) {
                        proxyInfo.proxyPassword = jSONObject.optString("proxyPassword");
                    }
                    BaseManager.getInstance().setProxyInfo(proxyInfo);
                    callbackOnSuccess(v2TIMValueCallback, null);
                    return;
                }
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "proxyType, proxyHost and proxyPort must be set");
                return;
            } catch (JSONException e2) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e2.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.2
            {
                V2TIMManagerImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.remove(V2TIMManagerImpl.this.mIMSDKListener);
                }
                if (v2TIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
                }
                V2TIMManagerImpl.this.mIMSDKListener = v2TIMSDKListener;
            }
        });
    }

    private void setTestEnvironment(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().setTestEnvironment(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void setUIPlatform(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is null");
            return;
        }
        int i2 = 0;
        String str = "";
        if (obj instanceof String) {
            str = (String) obj;
        } else if (obj instanceof Integer) {
            i2 = ((Integer) obj).intValue();
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is invalid");
        }
        BaseManager.getInstance().setCustomUIPlatform(str, i2);
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.13
            {
                V2TIMManagerImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mGroupListenerList.contains(v2TIMGroupListener)) {
                    return;
                }
                V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.3
            {
                V2TIMManagerImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mIMSDKListenerList.contains(v2TIMSDKListener)) {
                    return;
                }
                V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            if (this.mV2TIMSimpleMsgListenerList.contains(v2TIMSimpleMsgListener)) {
                return;
            }
            this.mV2TIMSimpleMsgListenerList.add(v2TIMSimpleMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void callExperimentalAPI(String str, Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid api");
        } else if (str.equals("setCustomServerInfo")) {
            setCustomServerInfo(obj, v2TIMValueCallback);
        } else if (str.equals("setProxyInfo")) {
            setProxyInfo(obj, v2TIMValueCallback);
        } else if (str.equals("setLibraryPath")) {
            setLibraryPath(obj, v2TIMValueCallback);
        } else if (str.equals("initLocalStorage")) {
            initLocalStorage(obj, v2TIMValueCallback);
        } else if (str.equals("setTestEnvironment")) {
            setTestEnvironment(obj, v2TIMValueCallback);
        } else if (str.equals("setIPv6Prior")) {
            setIPv6Prior(obj, v2TIMValueCallback);
        } else if (str.equals("setCosSaveRegionForConversation")) {
            setCosSaveRegion(obj, v2TIMValueCallback);
        } else if (str.equals("setUIPlatform")) {
            setUIPlatform(obj, v2TIMValueCallback);
        } else if (str.equals("setBuildInfo")) {
            setBuildInfo(obj, v2TIMValueCallback);
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "unsupported api");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void createGroup(String str, String str2, String str3, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupType is empty");
            }
        } else if (TextUtils.isEmpty(str3)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupName is empty");
            }
        } else {
            if (!str.equalsIgnoreCase("Work")) {
                if (!str.equalsIgnoreCase("Meeting")) {
                    if (!str.equalsIgnoreCase("Private")) {
                        if (!str.equalsIgnoreCase("ChatRoom")) {
                            if (str.equalsIgnoreCase("Public")) {
                                str = "Public";
                            } else if (str.equalsIgnoreCase("AVChatRoom")) {
                                str = "AVChatRoom";
                            }
                            GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.15
                                {
                                    V2TIMManagerImpl.this = this;
                                }

                                @Override // com.tencent.imsdk.common.IMCallback
                                public void fail(int i2, String str4) {
                                    super.fail(i2, str4);
                                }

                                @Override // com.tencent.imsdk.common.IMCallback
                                public void success(String str4) {
                                    super.success((AnonymousClass15) str4);
                                }
                            });
                        }
                    }
                }
                str = "ChatRoom";
                GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.15
                    {
                        V2TIMManagerImpl.this = this;
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void fail(int i2, String str4) {
                        super.fail(i2, str4);
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void success(String str4) {
                        super.success((AnonymousClass15) str4);
                    }
                });
            }
            str = "Private";
            GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.15
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str4) {
                    super.fail(i2, str4);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(String str4) {
                    super.success((AnonymousClass15) str4);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void dismissGroup(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().dismissGroup(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.18
                {
                    V2TIMManagerImpl.this = this;
                }

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
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public int getLoginStatus() {
        return BaseManager.getInstance().getLoginStatus();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getLoginUser() {
        return BaseManager.getInstance().getLoginUser();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public long getServerTime() {
        return BaseManager.getInstance().getServerTime();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void getUsersInfo(List<String> list, final V2TIMValueCallback<List<V2TIMUserFullInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getUsersInfo(list, new IMCallback<List<UserInfo>>(new V2TIMValueCallback<List<UserInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.19
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<UserInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (UserInfo userInfo : list2) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            arrayList.add(v2TIMUserFullInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.20
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<UserInfo> list2) {
                    super.success((AnonymousClass20) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getVersion() {
        return BaseManager.getInstance().getVersion();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public boolean initSDK(Context context, int i2, V2TIMSDKConfig v2TIMSDKConfig) {
        return initSDK(context, i2, v2TIMSDKConfig, null);
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void joinGroup(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().joinGroup(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.16
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str3) {
                    super.fail(i2, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void login(String str, String str2, final V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            BaseManager.getInstance().login(str, str2, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.5
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str3) {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onError(i2, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onSuccess();
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.6
                {
                    V2TIMManagerImpl.this = this;
                }

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
        v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID or userSig is empty");
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void logout(V2TIMCallback v2TIMCallback) {
        BaseManager.getInstance().logout(new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.7
            {
                V2TIMManagerImpl.this = this;
            }

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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void quitGroup(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().quitGroup(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.17
                {
                    V2TIMManagerImpl.this = this;
                }

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
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.14
            {
                V2TIMManagerImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                V2TIMManagerImpl.this.mGroupListenerList.remove(v2TIMGroupListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.4
            {
                V2TIMManagerImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                V2TIMManagerImpl.this.mIMSDKListenerList.remove(v2TIMSDKListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            this.mV2TIMSimpleMsgListenerList.remove(v2TIMSimpleMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CCustomMessage(byte[] bArr, String str, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "customData is null");
            }
            return null;
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
            }
            return null;
        } else {
            V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
            V2TIMMessageManager.getInstance().sendMessage(createCustomMessage, str, null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.9
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMSendCallback
                public void onProgress(int i2) {
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(V2TIMMessage v2TIMMessage) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(v2TIMMessage);
                    }
                }
            });
            return createCustomMessage.getMsgID();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CTextMessage(String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "text is null");
            }
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
            }
            return null;
        } else {
            V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
            V2TIMMessageManager.getInstance().sendMessage(createTextMessage, str2, null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.8
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMSendCallback
                public void onProgress(int i2) {
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(V2TIMMessage v2TIMMessage) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(v2TIMMessage);
                    }
                }
            });
            return createTextMessage.getMsgID();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupCustomMessage(byte[] bArr, String str, int i2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "customData is null");
                return null;
            }
            return null;
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return "";
            }
            return "";
        } else {
            V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
            V2TIMMessageManager.getInstance().sendMessage(createCustomMessage, null, str, (i2 != 0 && (i2 == 1 || i2 == 3)) ? i2 : 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.11
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i3, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i3, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMSendCallback
                public void onProgress(int i3) {
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(V2TIMMessage v2TIMMessage) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(v2TIMMessage);
                    }
                }
            });
            return createCustomMessage.getMsgID();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupTextMessage(String str, String str2, int i2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "text is null");
                return null;
            }
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return "";
            }
            return "";
        } else {
            V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
            V2TIMMessageManager.getInstance().sendMessage(createTextMessage, null, str2, (i2 != 0 && (i2 == 1 || i2 == 3)) ? i2 : 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.10
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i3, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i3, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMSendCallback
                public void onProgress(int i3) {
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(V2TIMMessage v2TIMMessage) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(v2TIMMessage);
                    }
                }
            });
            return createTextMessage.getMsgID();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.12
            {
                V2TIMManagerImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.remove(V2TIMManagerImpl.this.mV2TIMGroupListener);
                }
                if (v2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
                }
                V2TIMManagerImpl.this.mV2TIMGroupListener = v2TIMGroupListener;
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setSelfInfo(V2TIMUserFullInfo v2TIMUserFullInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMUserFullInfo == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid params");
                return;
            }
            return;
        }
        HashMap<String, Object> modifyParams = v2TIMUserFullInfo.getModifyParams();
        if (modifyParams != null && !modifyParams.isEmpty()) {
            RelationshipManager.getInstance().setSelfInfo(v2TIMUserFullInfo.getModifyParams(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.21
                {
                    V2TIMManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "no changed info");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void unInitSDK() {
        this.mIMSDKListener = null;
        BaseManager.getInstance().unInitSDK();
        V2TIMSignalingManagerImpl.getInstance().unInit();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public boolean initSDK(Context context, int i2, V2TIMSDKConfig v2TIMSDKConfig, V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKConfig == null) {
            v2TIMSDKConfig = new V2TIMSDKConfig();
        }
        final V2TIMLogListener logListener = v2TIMSDKConfig.getLogListener();
        boolean z = logListener != null;
        SDKConfig sDKConfig = new SDKConfig();
        sDKConfig.sdkAppId = i2;
        sDKConfig.logSetting.logLevel = v2TIMSDKConfig.getLogLevel();
        setSDKListener(v2TIMSDKListener);
        return BaseManager.getInstance().initSDK(context, sDKConfig, z, new SDKListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1
            {
                V2TIMManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnectFailed(final int i3, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.3
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            v2TIMSDKListener2.onConnectFailed(i3, str);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnectSuccess() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.2
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            v2TIMSDKListener2.onConnectSuccess();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnecting() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.1
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            v2TIMSDKListener2.onConnecting();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onKickedOffline() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.4
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            v2TIMSDKListener2.onKickedOffline();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onLog(final int i3, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.7
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        V2TIMLogListener v2TIMLogListener = logListener;
                        if (v2TIMLogListener != null) {
                            v2TIMLogListener.onLog(i3, str);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onSelfInfoUpdated(final UserInfo userInfo) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.6
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            v2TIMSDKListener2.onSelfInfoUpdated(v2TIMUserFullInfo);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onUserSigExpired() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.5
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            v2TIMSDKListener2.onUserSigExpired();
                        }
                    }
                });
            }
        });
    }
}
