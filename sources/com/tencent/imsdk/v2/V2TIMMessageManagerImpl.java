package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.C2CMessageReceipt;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.FaceElement;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.GroupMessageReadMembers;
import com.tencent.imsdk.message.GroupMessageReceipt;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.LocationElement;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListGetOption;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.message.MessageSearchResult;
import com.tencent.imsdk.message.MessageUploadProgressCallback;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.message.VideoElement;
import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;
import com.tencent.imsdk.relationship.RelationshipManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class V2TIMMessageManagerImpl extends V2TIMMessageManager {
    private final int MAX_ABSTRACT_COUNT;
    private final int MAX_ABSTRACT_LENGTH;
    private final int MAX_FORWARD_COUNT;
    private final String TAG;
    private Object mLockObject;
    private MessageListener mMessageListener;
    private List<V2TIMAdvancedMsgListener> mV2TIMMsgListenerList;

    /* loaded from: classes3.dex */
    public static class V2TIMMessageManagerImplHolder {
        private static final V2TIMMessageManagerImpl v2TIMMessageManagerImpl = new V2TIMMessageManagerImpl();

        private V2TIMMessageManagerImplHolder() {
        }
    }

    private void getC2CMessageReadReceipts(List<V2TIMMessage> list, final V2TIMValueCallback<List<V2TIMMessageReceipt>> v2TIMValueCallback) {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (V2TIMMessage v2TIMMessage : list) {
            if (v2TIMMessage != null && v2TIMMessage.getUserID() != null && !v2TIMMessage.getUserID().isEmpty() && v2TIMMessage.isSelf() && 2 == v2TIMMessage.getStatus() && v2TIMMessage.isNeedReadReceipt()) {
                arrayList.add(v2TIMMessage.getMsgID());
            }
        }
        if (arrayList.size() != 0) {
            findMessages(arrayList, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.38
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<V2TIMMessage> list2) {
                    for (V2TIMMessage v2TIMMessage2 : list2) {
                        Message message = v2TIMMessage2.getMessage();
                        C2CMessageReceipt c2CMessageReceipt = new C2CMessageReceipt();
                        c2CMessageReceipt.setUserID(message.getReceiverUserID());
                        c2CMessageReceipt.setMessageID(message.getMsgID());
                        c2CMessageReceipt.setPeerRead(message.isReceiptPeerRead());
                        V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                        v2TIMMessageReceipt.setC2CMessageReceipt(c2CMessageReceipt);
                        arrayList2.add(v2TIMMessageReceipt);
                    }
                    if (arrayList2.size() > 0) {
                        V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                        if (v2TIMValueCallback2 != null) {
                            v2TIMValueCallback2.onSuccess(arrayList2);
                            return;
                        }
                        return;
                    }
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message list");
                    }
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message list");
        }
    }

    private void getGroupMessageReadReceipts(final List<V2TIMMessage> list, final V2TIMValueCallback<List<V2TIMMessageReceipt>> v2TIMValueCallback) {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (V2TIMMessage v2TIMMessage : list) {
            if (v2TIMMessage != null && v2TIMMessage.getGroupID() != null && v2TIMMessage.getGroupID().length() != 0 && v2TIMMessage.isSelf() && 2 == v2TIMMessage.getStatus() && v2TIMMessage.isNeedReadReceipt()) {
                Message message = v2TIMMessage.getMessage();
                if (message.getReceiptUnreadCount() == 0) {
                    GroupMessageReceipt groupMessageReceipt = new GroupMessageReceipt();
                    groupMessageReceipt.setGroupID(message.getGroupID());
                    groupMessageReceipt.setMsgID(message.getMsgID());
                    groupMessageReceipt.setReadCount(message.getReceiptReadCount());
                    groupMessageReceipt.setUnreadCount(message.getReceiptUnreadCount());
                    V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                    v2TIMMessageReceipt.setGroupMessageReceipt(groupMessageReceipt);
                    arrayList2.add(v2TIMMessageReceipt);
                } else {
                    arrayList.add(message.getMessageKey());
                }
            }
        }
        if (arrayList.size() == 0) {
            if (arrayList2.size() > 0) {
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onSuccess(arrayList2);
                    return;
                }
                return;
            } else if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid messages");
                return;
            } else {
                return;
            }
        }
        MessageCenter.getInstance().getGroupMessageReceipts(arrayList, new IMCallback<List<GroupMessageReceipt>>(new V2TIMValueCallback<List<GroupMessageReceipt>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.39
            {
                V2TIMMessageManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                IMLog.e("V2TIMMessageManagerImpl", "get group message receipts from server failed, code:" + i2 + ", desc:" + str + ", return the local group message receipts");
                arrayList2.clear();
                for (V2TIMMessage v2TIMMessage2 : list) {
                    Message message2 = v2TIMMessage2.getMessage();
                    GroupMessageReceipt groupMessageReceipt2 = new GroupMessageReceipt();
                    groupMessageReceipt2.setGroupID(message2.getGroupID());
                    groupMessageReceipt2.setMsgID(message2.getMsgID());
                    groupMessageReceipt2.setReadCount(message2.getReceiptReadCount());
                    groupMessageReceipt2.setUnreadCount(message2.getReceiptUnreadCount());
                    V2TIMMessageReceipt v2TIMMessageReceipt2 = new V2TIMMessageReceipt();
                    v2TIMMessageReceipt2.setGroupMessageReceipt(groupMessageReceipt2);
                    arrayList2.add(v2TIMMessageReceipt2);
                }
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(arrayList2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<GroupMessageReceipt> list2) {
                for (GroupMessageReceipt groupMessageReceipt2 : list2) {
                    V2TIMMessageReceipt v2TIMMessageReceipt2 = new V2TIMMessageReceipt();
                    GroupMessageReceipt groupMessageReceipt3 = new GroupMessageReceipt();
                    groupMessageReceipt3.setGroupID(groupMessageReceipt2.getGroupID());
                    groupMessageReceipt3.setMsgID(groupMessageReceipt2.getMsgID());
                    groupMessageReceipt3.setReadCount(groupMessageReceipt2.getReadCount());
                    groupMessageReceipt3.setUnreadCount(groupMessageReceipt2.getUnreadCount());
                    v2TIMMessageReceipt2.setGroupMessageReceipt(groupMessageReceipt3);
                    arrayList2.add(v2TIMMessageReceipt2);
                }
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(arrayList2);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.40
            {
                V2TIMMessageManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<GroupMessageReceipt> list2) {
                super.success((AnonymousClass40) list2);
            }
        });
    }

    public static V2TIMMessageManagerImpl getInstance() {
        return V2TIMMessageManagerImplHolder.v2TIMMessageManagerImpl;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void addAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        if (v2TIMAdvancedMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            if (this.mV2TIMMsgListenerList.contains(v2TIMAdvancedMsgListener)) {
                return;
            }
            this.mV2TIMMsgListenerList.add(v2TIMAdvancedMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void clearC2CHistoryMessage(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            MessageCenter.getInstance().clearC2CHistoryMessage(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.26
                {
                    V2TIMMessageManagerImpl.this = this;
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
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void clearGroupHistoryMessage(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            MessageCenter.getInstance().clearGroupHistoryMessage(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.27
                {
                    V2TIMMessageManagerImpl.this = this;
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
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createCustomMessage(byte[] bArr) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        CustomElement customElement = new CustomElement();
        customElement.setData(bArr);
        message.addElement(customElement);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createFaceMessage(int i2, byte[] bArr) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        FaceElement faceElement = new FaceElement();
        faceElement.setFaceData(bArr);
        faceElement.setFaceIndex(i2);
        message.addElement(faceElement);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createFileMessage(String str, String str2) {
        if (new File(str).exists()) {
            V2TIMMessage v2TIMMessage = new V2TIMMessage();
            Message message = v2TIMMessage.getMessage();
            FileElement fileElement = new FileElement();
            fileElement.setFilePath(str);
            fileElement.setFileName(str2);
            message.addElement(fileElement);
            return v2TIMMessage;
        }
        return null;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createForwardMessage(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage == null) {
            IMLog.e("V2TIMMessageManagerImpl", "createForwardMessage, message cannot be null");
            return null;
        } else if (2 != v2TIMMessage.getStatus()) {
            IMLog.e("V2TIMMessageManagerImpl", "message status must be V2TIM_MSG_STATUS_SEND_SUCC");
            return null;
        } else if (9 == v2TIMMessage.getElemType()) {
            IMLog.e("V2TIMMessageManagerImpl", "group tips message is not support");
            return null;
        } else {
            V2TIMMessage v2TIMMessage2 = new V2TIMMessage();
            Message message = v2TIMMessage2.getMessage();
            message.setMessageBaseElements(v2TIMMessage.getMessage().getMessageBaseElements());
            message.setForward(true);
            return v2TIMMessage2;
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createImageMessage(String str) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        ImageElement imageElement = new ImageElement();
        imageElement.setOriginImageFilePath(str);
        message.addElement(imageElement);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createLocationMessage(String str, double d2, double d3) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        LocationElement locationElement = new LocationElement();
        locationElement.setLongitude(d2);
        locationElement.setLatitude(d3);
        locationElement.setDescription(str);
        message.addElement(locationElement);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createMergerMessage(List<V2TIMMessage> list, String str, List<String> list2, String str2) {
        if (list != null && list.size() != 0 && list.size() <= 300) {
            ArrayList arrayList = new ArrayList();
            if (list2 != null) {
                int size = list2.size();
                if (size >= 5) {
                    size = 5;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    String str3 = list2.get(i2);
                    if (str3 != null) {
                        if (str3.length() > 100) {
                            str3 = str3.substring(0, 100);
                        }
                        arrayList.add(str3);
                    }
                }
            }
            for (V2TIMMessage v2TIMMessage : list) {
                if (2 != v2TIMMessage.getStatus()) {
                    IMLog.e("V2TIMMessageManagerImpl", "message status must be V2TIM_MSG_STATUS_SEND_SUCC");
                    return null;
                } else if (9 == v2TIMMessage.getElemType()) {
                    IMLog.e("V2TIMMessageManagerImpl", "group tips message is not support");
                    return null;
                }
            }
            if (str2 == null) {
                IMLog.e("V2TIMMessageManagerImpl", "compatibleText invalid, compatibleText cannot be null");
                return null;
            }
            MergerElement mergerElement = new MergerElement();
            mergerElement.setTitle(str);
            mergerElement.setAbstractList(arrayList);
            mergerElement.setCompatibleText(str2);
            ArrayList arrayList2 = new ArrayList();
            for (V2TIMMessage v2TIMMessage2 : list) {
                arrayList2.add(v2TIMMessage2.getMessage());
            }
            mergerElement.setMessageList(arrayList2);
            V2TIMMessage v2TIMMessage3 = new V2TIMMessage();
            Message message = v2TIMMessage3.getMessage();
            message.addElement(mergerElement);
            message.setForward(true);
            return v2TIMMessage3;
        }
        IMLog.e("V2TIMMessageManagerImpl", "messageList invalid, the number of messageList must be between 1 and 300");
        return null;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createSoundMessage(String str, int i2) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        SoundElement soundElement = new SoundElement();
        if (i2 < 0) {
            i2 = 0;
        }
        soundElement.setSoundDuration(i2);
        soundElement.setSoundFilePath(str);
        message.addElement(soundElement);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createTargetedGroupMessage(V2TIMMessage v2TIMMessage, List<String> list) {
        if (v2TIMMessage == null) {
            IMLog.e("V2TIMMessageManagerImpl", "createTargetedGroupMessage, message cannot be null");
            return null;
        } else if (list != null && !list.isEmpty()) {
            List<String> groupAtUserList = v2TIMMessage.getGroupAtUserList();
            if (groupAtUserList != null && !groupAtUserList.isEmpty()) {
                IMLog.e("V2TIMMessageManagerImpl", "targeted group message does not support at message");
                return null;
            }
            v2TIMMessage.getMessage().setTargetGroupMemberList(list);
            return v2TIMMessage;
        } else {
            IMLog.e("V2TIMMessageManagerImpl", "receiverList cannot be empty");
            return null;
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createTextAtMessage(String str, List<String> list) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        TextElement textElement = new TextElement();
        textElement.setTextContent(str);
        message.addElement(textElement);
        v2TIMMessage.setGroupAtUserList(list);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createTextMessage(String str) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        TextElement textElement = new TextElement();
        textElement.setTextContent(str);
        message.addElement(textElement);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createVideoMessage(String str, String str2, int i2, String str3) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        VideoElement videoElement = new VideoElement();
        videoElement.setVideoFilePath(str);
        videoElement.setSnapshotFilePath(str3);
        if (i2 < 0) {
            i2 = 0;
        }
        videoElement.setVideoDuration(i2);
        videoElement.setVideoType(str2);
        message.addElement(videoElement);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void deleteMessageFromLocalStorage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback) {
        if (v2TIMMessage != null) {
            MessageCenter.getInstance().deleteLocalMessage(v2TIMMessage.getMessage().getMessageKey(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.24
                {
                    V2TIMMessageManagerImpl.this = this;
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
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "message is null");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void deleteMessages(List<V2TIMMessage> list, V2TIMCallback v2TIMCallback) {
        if (list == null || list.isEmpty()) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "messages is invalid");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (V2TIMMessage v2TIMMessage : list) {
            arrayList.add(v2TIMMessage.getMessage().getMessageKey());
        }
        MessageCenter.getInstance().deleteCloudMessageList(arrayList, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.25
            {
                V2TIMMessageManagerImpl.this = this;
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

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void findMessages(List<String> list, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (list != null && !list.isEmpty()) {
            MessageCenter.getInstance().findMessageByMessageId(list, new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.32
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<Message> list2) {
                    ArrayList arrayList = new ArrayList();
                    for (Message message : list2) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                        arrayList.add(v2TIMMessage);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.33
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<Message> list2) {
                    super.success((AnonymousClass33) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "messages is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getC2CHistoryMessageList(String str, int i2, V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str) || i2 == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty or count is 0");
                return;
            }
            return;
        }
        V2TIMValueCallback<List<Message>> v2TIMValueCallback2 = new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.9
            {
                V2TIMMessageManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onError(i3, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<Message> list) {
                ArrayList arrayList = new ArrayList();
                for (Message message : list) {
                    V2TIMMessage v2TIMMessage2 = new V2TIMMessage();
                    v2TIMMessage2.setMessage(message);
                    arrayList.add(v2TIMMessage2);
                }
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onSuccess(arrayList);
                }
            }
        };
        MessageKey messageKey = v2TIMMessage != null ? v2TIMMessage.getMessage().getMessageKey() : null;
        MessageListGetOption messageListGetOption = new MessageListGetOption();
        messageListGetOption.setCount(i2);
        messageListGetOption.setToOlderMessage(true);
        messageListGetOption.setGetCloudMessage(true);
        messageListGetOption.setMessageKey(messageKey);
        MessageCenter.getInstance().getC2CHistoryMessageList(str, messageListGetOption, new IMCallback<List<Message>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.10
            {
                V2TIMMessageManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<Message> list) {
                super.success((AnonymousClass10) list);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getC2CReceiveMessageOpt(List<String> list, final V2TIMValueCallback<List<V2TIMReceiveMessageOptInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getC2CReceiveMessageOpt(list, new IMCallback<List<ReceiveMessageOptInfo>>(new V2TIMValueCallback<List<ReceiveMessageOptInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.6
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<ReceiveMessageOptInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (ReceiveMessageOptInfo receiveMessageOptInfo : list2) {
                            V2TIMReceiveMessageOptInfo v2TIMReceiveMessageOptInfo = new V2TIMReceiveMessageOptInfo();
                            v2TIMReceiveMessageOptInfo.setUserID(receiveMessageOptInfo.getUserID());
                            v2TIMReceiveMessageOptInfo.setC2CReceiveMessageOpt(receiveMessageOptInfo.getC2CReceiveMessageOpt());
                            arrayList.add(v2TIMReceiveMessageOptInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.7
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<ReceiveMessageOptInfo> list2) {
                    super.success((AnonymousClass7) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getGroupHistoryMessageList(String str, int i2, V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str) || i2 <= 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty or count is 0");
                return;
            }
            return;
        }
        V2TIMValueCallback<List<Message>> v2TIMValueCallback2 = new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.11
            {
                V2TIMMessageManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onError(i3, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<Message> list) {
                ArrayList arrayList = new ArrayList();
                for (Message message : list) {
                    V2TIMMessage v2TIMMessage2 = new V2TIMMessage();
                    v2TIMMessage2.setMessage(message);
                    arrayList.add(v2TIMMessage2);
                }
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onSuccess(arrayList);
                }
            }
        };
        MessageKey messageKey = v2TIMMessage != null ? v2TIMMessage.getMessage().getMessageKey() : null;
        MessageListGetOption messageListGetOption = new MessageListGetOption();
        messageListGetOption.setCount(i2);
        messageListGetOption.setToOlderMessage(true);
        messageListGetOption.setGetCloudMessage(true);
        messageListGetOption.setMessageKey(messageKey);
        MessageCenter.getInstance().getGroupHistoryMessageList(str, messageListGetOption, new IMCallback<List<Message>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.12
            {
                V2TIMMessageManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<Message> list) {
                super.success((AnonymousClass12) list);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getGroupMessageReadMemberList(V2TIMMessage v2TIMMessage, final int i2, long j2, int i3, final V2TIMValueCallback<V2TIMGroupMessageReadMemberList> v2TIMValueCallback) {
        if (v2TIMMessage == null || v2TIMMessage.getGroupID() == null || v2TIMMessage.getGroupID().length() == 0 || !v2TIMMessage.isSelf() || 2 != v2TIMMessage.getStatus() || !v2TIMMessage.isNeedReadReceipt()) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message");
            }
        } else if (i3 > 100) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid count, maximum support 100");
            }
        } else {
            MessageCenter.getInstance().getGroupMessageReadMembers(v2TIMMessage.getMessage(), i2, j2, i3, new IMCallback<GroupMessageReadMembers>(new V2TIMValueCallback<GroupMessageReadMembers>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.41
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i4, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i4, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(GroupMessageReadMembers groupMessageReadMembers) {
                    if (v2TIMValueCallback != null) {
                        V2TIMGroupMessageReadMemberList v2TIMGroupMessageReadMemberList = new V2TIMGroupMessageReadMemberList();
                        v2TIMGroupMessageReadMemberList.setMessageReadMembers(groupMessageReadMembers, i2);
                        v2TIMValueCallback.onSuccess(v2TIMGroupMessageReadMemberList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.42
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i4, String str) {
                    super.fail(i4, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(GroupMessageReadMembers groupMessageReadMembers) {
                    super.success((AnonymousClass42) groupMessageReadMembers);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getHistoryMessageList(V2TIMMessageListGetOption v2TIMMessageListGetOption, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (v2TIMMessageListGetOption == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "option is null");
            }
        } else if (TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID()) && TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID())) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID and userID cannot be null at the same time");
            }
        } else if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID()) && !TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID())) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID and userID cannot set at the same time");
            }
        } else if (v2TIMMessageListGetOption.getCount() <= 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "count less than 0");
            }
        } else {
            MessageListGetOption messageListGetOption = new MessageListGetOption();
            messageListGetOption.setCount(v2TIMMessageListGetOption.getCount());
            messageListGetOption.setGetTimeBegin(v2TIMMessageListGetOption.getGetTimeBegin());
            messageListGetOption.setGetTimePeriod(v2TIMMessageListGetOption.getGetTimePeriod());
            int getType = v2TIMMessageListGetOption.getGetType();
            if (getType == 1) {
                messageListGetOption.setToOlderMessage(true);
                messageListGetOption.setGetCloudMessage(true);
            } else if (getType == 2) {
                messageListGetOption.setToOlderMessage(false);
                messageListGetOption.setGetCloudMessage(true);
            } else if (getType == 3) {
                messageListGetOption.setToOlderMessage(true);
                messageListGetOption.setGetCloudMessage(false);
                messageListGetOption.setMessageTypeList(v2TIMMessageListGetOption.getMessageTypeList());
            } else if (getType != 4) {
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "getType is invalid");
                    return;
                }
                return;
            } else {
                messageListGetOption.setToOlderMessage(false);
                messageListGetOption.setGetCloudMessage(false);
                messageListGetOption.setMessageTypeList(v2TIMMessageListGetOption.getMessageTypeList());
            }
            if (v2TIMMessageListGetOption.getLastMsg() != null) {
                messageListGetOption.setMessageKey(v2TIMMessageListGetOption.getLastMsg().getMessage().getMessageKey());
            } else if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID()) && v2TIMMessageListGetOption.getLastMsgSeq() > 0) {
                MessageKey messageKey = new MessageKey();
                messageKey.setSeq(v2TIMMessageListGetOption.getLastMsgSeq());
                messageListGetOption.setMessageKey(messageKey);
            }
            V2TIMValueCallback<List<Message>> v2TIMValueCallback2 = new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.13
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<Message> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Message message : list) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                        arrayList.add(v2TIMMessage);
                    }
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onSuccess(arrayList);
                    }
                }
            };
            if (v2TIMMessageListGetOption.getLastMsg() != null) {
                v2TIMMessageListGetOption.getLastMsg().getMessage().getMessageKey();
            }
            if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID())) {
                MessageCenter.getInstance().getC2CHistoryMessageList(v2TIMMessageListGetOption.getUserID(), messageListGetOption, new IMCallback<List<Message>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.14
                    {
                        V2TIMMessageManagerImpl.this = this;
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void fail(int i2, String str) {
                        super.fail(i2, str);
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void success(List<Message> list) {
                        super.success((AnonymousClass14) list);
                    }
                });
            } else {
                MessageCenter.getInstance().getGroupHistoryMessageList(v2TIMMessageListGetOption.getGroupID(), messageListGetOption, new IMCallback<List<Message>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.15
                    {
                        V2TIMMessageManagerImpl.this = this;
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void fail(int i2, String str) {
                        super.fail(i2, str);
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void success(List<Message> list) {
                        super.success((AnonymousClass15) list);
                    }
                });
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getMessageReadReceipts(List<V2TIMMessage> list, V2TIMValueCallback<List<V2TIMMessageReceipt>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message list");
                return;
            }
            return;
        }
        V2TIMMessage v2TIMMessage = list.get(0);
        if (v2TIMMessage.getUserID() != null && !v2TIMMessage.getUserID().isEmpty()) {
            getC2CMessageReadReceipts(list, v2TIMValueCallback);
        } else {
            getGroupMessageReadReceipts(list, v2TIMValueCallback);
        }
    }

    public void initListener() {
        this.mMessageListener = new MessageListener() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.1
            {
                V2TIMMessageManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveC2CMessageReceipt(List<C2CMessageReceipt> list) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    C2CMessageReceipt c2CMessageReceipt = list.get(i2);
                    V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                    v2TIMMessageReceipt.setC2CMessageReceipt(c2CMessageReceipt);
                    arrayList.add(v2TIMMessageReceipt);
                    if (i2 == 0) {
                        z = !TextUtils.isEmpty(c2CMessageReceipt.getMessageID());
                    }
                }
                synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                    for (V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                        if (z) {
                            v2TIMAdvancedMsgListener.onRecvMessageReadReceipts(arrayList);
                        } else {
                            v2TIMAdvancedMsgListener.onRecvC2CReadReceipt(arrayList);
                        }
                    }
                }
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveGroupMessageReceipt(List<GroupMessageReceipt> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupMessageReceipt groupMessageReceipt : list) {
                    V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                    v2TIMMessageReceipt.setGroupMessageReceipt(groupMessageReceipt);
                    arrayList.add(v2TIMMessageReceipt);
                }
                synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                    for (V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                        v2TIMAdvancedMsgListener.onRecvMessageReadReceipts(arrayList);
                    }
                }
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageModified(List<Message> list) {
                for (Message message : list) {
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                        for (V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                            v2TIMAdvancedMsgListener.onRecvMessageModified(v2TIMMessage);
                        }
                    }
                }
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageRevoked(List<MessageKey> list) {
                if (list == null || list.isEmpty()) {
                    return;
                }
                for (MessageKey messageKey : list) {
                    synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                        for (V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                            v2TIMAdvancedMsgListener.onRecvMessageRevoked(messageKey.getMessageID());
                        }
                    }
                }
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveNewMessage(List<Message> list) {
                if (list == null || list.isEmpty()) {
                    return;
                }
                for (Message message : list) {
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    V2TIMSignalingInfo processSignalingMessage = V2TIMSignalingManagerImpl.getInstance().processSignalingMessage(v2TIMMessage);
                    if (processSignalingMessage == null || !processSignalingMessage.isOnlineUserOnly()) {
                        V2TIMMessageManagerImpl.this.onRecvNewMessage(v2TIMMessage);
                    }
                }
            }
        };
        MessageCenter.getInstance().addMessageListener(this.mMessageListener);
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public String insertC2CMessageToLocalStorage(final V2TIMMessage v2TIMMessage, String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "message is null!");
            }
            return "";
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
            }
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "sender is empty");
            }
            return "";
        } else {
            Message message = v2TIMMessage.getMessage();
            message.setMessageType(Message.MESSAGE_TYPE_C2C);
            message.setSenderUserID(str2);
            message.setReceiverUserID(str);
            return MessageCenter.getInstance().insertLocalMessage(message, new IMCallback(new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.30
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(Message message2) {
                    if (v2TIMValueCallback != null) {
                        v2TIMMessage.setMessage(message2);
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.31
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str3) {
                    super.fail(i2, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    v2TIMMessage.getMessage().update((Message) obj);
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public String insertGroupMessageToLocalStorage(final V2TIMMessage v2TIMMessage, String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "message is null!");
            }
            return "";
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "sender is empty");
            }
            return "";
        } else {
            Message message = v2TIMMessage.getMessage();
            message.setMessageType(Message.MESSAGE_TYPE_GROUP);
            message.setSenderUserID(str2);
            message.setGroupID(str);
            return MessageCenter.getInstance().insertLocalMessage(message, new IMCallback(new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.28
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(Message message2) {
                    if (v2TIMValueCallback != null) {
                        v2TIMMessage.setMessage(message2);
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.29
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str3) {
                    super.fail(i2, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    v2TIMMessage.getMessage().update((Message) obj);
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void markAllMessageAsRead(V2TIMCallback v2TIMCallback) {
        ConversationManager.getInstance().clearUnreadMessage(true, true, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.23
            {
                V2TIMMessageManagerImpl.this = this;
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

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void markC2CMessageAsRead(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().clearUnreadMessage(true, false, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.19
                {
                    V2TIMMessageManagerImpl.this = this;
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
        } else {
            MessageCenter.getInstance().setC2CMessageRead(str, 0L, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.20
                {
                    V2TIMMessageManagerImpl.this = this;
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
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void markGroupMessageAsRead(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().clearUnreadMessage(false, true, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.21
                {
                    V2TIMMessageManagerImpl.this = this;
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
        } else {
            MessageCenter.getInstance().setGroupMessageRead(str, 0L, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.22
                {
                    V2TIMMessageManagerImpl.this = this;
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
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void modifyMessage(V2TIMMessage v2TIMMessage, final V2TIMCompleteCallback<V2TIMMessage> v2TIMCompleteCallback) {
        if (v2TIMMessage != null) {
            MessageCenter.getInstance().modifyMessage(v2TIMMessage.getMessage(), new IMCallback(new V2TIMCompleteCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.17
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMCompleteCallback
                public void onComplete(int i2, String str, Message message) {
                    V2TIMMessage v2TIMMessage2;
                    if (message != null) {
                        v2TIMMessage2 = new V2TIMMessage();
                        v2TIMMessage2.setMessage(message);
                    } else {
                        v2TIMMessage2 = null;
                    }
                    V2TIMCompleteCallback v2TIMCompleteCallback2 = v2TIMCompleteCallback;
                    if (v2TIMCompleteCallback2 != null) {
                        v2TIMCompleteCallback2.onComplete(i2, str, v2TIMMessage2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.18
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str, Object obj) {
                    super.fail(i2, str, obj);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCompleteCallback != null) {
            v2TIMCompleteCallback.onComplete(BaseConstants.ERR_INVALID_PARAMETERS, "msg is null", null);
        }
    }

    public void onRecvNewMessage(V2TIMMessage v2TIMMessage) {
        synchronized (this.mLockObject) {
            for (V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener : this.mV2TIMMsgListenerList) {
                v2TIMAdvancedMsgListener.onRecvNewMessage(v2TIMMessage);
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void removeAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        if (v2TIMAdvancedMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            this.mV2TIMMsgListenerList.remove(v2TIMAdvancedMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void revokeMessage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "msg is null");
            }
        } else if (v2TIMMessage.getStatus() == 2) {
            MessageCenter.getInstance().revokeMessage(v2TIMMessage.getMessage().getMessageKey(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.16
                {
                    V2TIMMessageManagerImpl.this = this;
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
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "msg status must be V2TIM_MSG_STATUS_SEND_SUCC");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void searchLocalMessages(V2TIMMessageSearchParam v2TIMMessageSearchParam, final V2TIMValueCallback<V2TIMMessageSearchResult> v2TIMValueCallback) {
        if (v2TIMMessageSearchParam.getSearchTimePosition() < 0 || v2TIMMessageSearchParam.getSearchTimePeriod() < 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "time < 0");
            }
        } else if (v2TIMMessageSearchParam.getPageIndex() < 0 || v2TIMMessageSearchParam.getPageSize() < 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "pageIndex or pageSize is invalid");
            }
        } else {
            MessageCenter.getInstance().findMessageBySearchKey(v2TIMMessageSearchParam.getMessageSearchParam(), new IMCallback<MessageSearchResult>(new V2TIMValueCallback<MessageSearchResult>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.34
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(MessageSearchResult messageSearchResult) {
                    V2TIMMessageSearchResult v2TIMMessageSearchResult = new V2TIMMessageSearchResult();
                    v2TIMMessageSearchResult.setMessageSearchResult(messageSearchResult);
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(v2TIMMessageSearchResult);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.35
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(MessageSearchResult messageSearchResult) {
                    super.success((AnonymousClass35) messageSearchResult);
                }
            });
            BaseManager.getInstance().checkTUIComponent(6);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public String sendMessage(final V2TIMMessage v2TIMMessage, String str, String str2, int i2, boolean z, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, final V2TIMSendCallback<V2TIMMessage> v2TIMSendCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "message is null");
            }
            return null;
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "receiver and groupID cannot be empty at the same time!");
            }
            return null;
        } else {
            Message message = v2TIMMessage.getMessage();
            if (!TextUtils.isEmpty(str2)) {
                message.setMessageType(Message.MESSAGE_TYPE_GROUP);
                message.setGroupID(str2);
                List<String> targetGroupMemberList = message.getTargetGroupMemberList();
                if (!TextUtils.isEmpty(str) && (targetGroupMemberList == null || message.getTargetGroupMemberList().isEmpty())) {
                    List<String> groupAtUserList = v2TIMMessage.getGroupAtUserList();
                    if (groupAtUserList != null && !groupAtUserList.isEmpty()) {
                        if (v2TIMSendCallback != null) {
                            v2TIMSendCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "targeted group message does not support group @ message");
                        }
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    message.setTargetGroupMemberList(arrayList);
                }
            } else {
                message.setMessageType(Message.MESSAGE_TYPE_C2C);
                message.setReceiverUserID(str);
            }
            message.setPriority(i2);
            if (z) {
                message.setLifeTime(0);
            }
            if (v2TIMOfflinePushInfo != null) {
                message.setOfflinePushInfo(v2TIMOfflinePushInfo.getMessageOfflinePushInfo());
            }
            message.setPlatform(Message.PLATFORM_ANDROID);
            String sendMessage = MessageCenter.getInstance().sendMessage(message, new MessageUploadProgressCallback() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.2
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.message.MessageUploadProgressCallback
                public void onUploadProgress(int i3, final int i4, final int i5) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.2.1
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            V2TIMSendCallback v2TIMSendCallback2 = v2TIMSendCallback;
                            if (v2TIMSendCallback2 != null) {
                                int i6 = i5;
                                v2TIMSendCallback2.onProgress(i6 > 0 ? (int) ((i4 / i6) * 100.0f) : 0);
                            }
                        }
                    });
                }
            }, new IMCallback(new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.3
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i3, String str3) {
                    V2TIMSendCallback v2TIMSendCallback2 = v2TIMSendCallback;
                    if (v2TIMSendCallback2 != null) {
                        v2TIMSendCallback2.onError(i3, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(Message message2) {
                    if (v2TIMSendCallback != null) {
                        v2TIMMessage.setMessage(message2);
                        v2TIMSendCallback.onSuccess(v2TIMMessage);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.4
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str3, Object obj) {
                    v2TIMMessage.getMessage().update((Message) obj);
                    super.fail(i3, str3, obj);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    v2TIMMessage.getMessage().update((Message) obj);
                    super.success(obj);
                }
            });
            BaseManager.getInstance().checkTUIComponent(3);
            return sendMessage;
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void sendMessageReadReceipts(final List<V2TIMMessage> list, final V2TIMCallback v2TIMCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid messageList");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (V2TIMMessage v2TIMMessage : list) {
            if (v2TIMMessage != null && true != v2TIMMessage.isSelf() && v2TIMMessage.isNeedReadReceipt()) {
                Message message = v2TIMMessage.getMessage();
                if (!message.isHasSentReceipt()) {
                    arrayList.add(message.getMessageKey());
                }
            }
        }
        if (arrayList.size() != 0) {
            MessageCenter.getInstance().sendMessageReceipts(arrayList, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.36
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str) {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onSuccess();
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.37
                {
                    V2TIMMessageManagerImpl.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    for (V2TIMMessage v2TIMMessage2 : list) {
                        v2TIMMessage2.getMessage().setHasSentReceipt(true);
                    }
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onSuccess();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void setC2CReceiveMessageOpt(List<String> list, int i2, V2TIMCallback v2TIMCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
                return;
            }
            return;
        }
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (i2 != 1) {
            if (i2 != 2) {
                IMLog.e("V2TIMMessageManagerImpl", "setC2CReceiveMessageOpt error opt = " + i2);
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "opt is error");
                    return;
                }
                return;
            }
            i3 = 3;
        }
        RelationshipManager.getInstance().setC2CReceiveMessageOpt(list, i3, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.5
            {
                V2TIMMessageManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i4, String str) {
                super.fail(i4, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void setGroupReceiveMessageOpt(String str, int i2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMMessageManagerImpl", "setReceiveMessageOpt err, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        int i3 = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE;
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE;
            } else if (i2 == 2) {
                i3 = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH;
            } else {
                IMLog.e("V2TIMMessageManagerImpl", "setReceiveMessageOpt error opt = " + i2);
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "opt is error");
                    return;
                }
                return;
            }
        }
        GroupManager.getInstance().setGroupReceiveMessageOpt(str, i3, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.8
            {
                V2TIMMessageManagerImpl.this = this;
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i4, String str2) {
                super.fail(i4, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    private V2TIMMessageManagerImpl() {
        this.TAG = "V2TIMMessageManagerImpl";
        this.MAX_FORWARD_COUNT = 300;
        this.MAX_ABSTRACT_COUNT = 5;
        this.MAX_ABSTRACT_LENGTH = 100;
        this.mLockObject = new Object();
        this.mV2TIMMsgListenerList = new CopyOnWriteArrayList();
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createCustomMessage(byte[] bArr, String str, byte[] bArr2) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        CustomElement customElement = new CustomElement();
        customElement.setData(bArr);
        customElement.setDescription(str);
        customElement.setExtension(bArr2);
        message.addElement(customElement);
        return v2TIMMessage;
    }
}
