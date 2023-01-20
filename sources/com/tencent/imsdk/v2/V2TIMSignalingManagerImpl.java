package com.tencent.imsdk.v2;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageUploadProgressCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class V2TIMSignalingManagerImpl extends V2TIMSignalingManager {
    private final String TAG;
    private final int TIMEOUT_DELAY;
    private List<V2TIMSignalingInfo> invitationList;
    private boolean mHasValidSignalingListener;
    private CopyOnWriteArrayList<V2TIMSignalingListener> mSignalingListenerList;
    private Handler mTimeoutHandler;

    /* loaded from: classes3.dex */
    public static class V2TIMSignalingManagerImplHolder {
        private static final V2TIMSignalingManagerImpl v2TIMSignalingManagerImpl = new V2TIMSignalingManagerImpl();

        private V2TIMSignalingManagerImplHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkInviteTimeout(final V2TIMSignalingInfo v2TIMSignalingInfo) {
        if (v2TIMSignalingInfo.getTimeout() <= 0) {
            IMLog.i("V2TIMSigMgrImpl", "signaling checkInviteTimeout timeout is <= 0, ignore to post delay task");
        } else {
            this.mTimeoutHandler.postDelayed(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    for (int i2 = 0; i2 < V2TIMSignalingManagerImpl.this.invitationList.size(); i2++) {
                        final V2TIMSignalingInfo v2TIMSignalingInfo2 = (V2TIMSignalingInfo) V2TIMSignalingManagerImpl.this.invitationList.get(i2);
                        if (v2TIMSignalingInfo2.getInviteID().equals(v2TIMSignalingInfo.getInviteID()) && v2TIMSignalingInfo2.getInviteeList().size() > 0) {
                            IMLog.i("V2TIMSigMgrImpl", "signaling invite local timeout inviteID:" + v2TIMSignalingInfo.getInviteID() + ", inviteeList:" + v2TIMSignalingInfo2.getInviteeList());
                            final int actionType = v2TIMSignalingInfo2.getActionType();
                            v2TIMSignalingInfo2.setActionType(5);
                            v2TIMSignalingInfo2.setOfflinePushInfo(null);
                            V2TIMSignalingManagerImpl.this.sendSignalMessage(v2TIMSignalingInfo2, new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.5.1
                                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                                public void onError(int i3, String str) {
                                    v2TIMSignalingInfo2.setActionType(actionType);
                                    synchronized (V2TIMSignalingManagerImpl.this) {
                                        Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                        while (it.hasNext()) {
                                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                            if (v2TIMSignalingListener != null) {
                                                v2TIMSignalingListener.onInvitationTimeout(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList());
                                            }
                                        }
                                    }
                                    V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo2);
                                    IMLog.e("V2TIMSigMgrImpl", "signaling send timeout msg failed, inviteID: " + v2TIMSignalingInfo.getInviteID() + ", code:" + i3 + ", desc:" + str);
                                }

                                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                                public void onSuccess(Message message) {
                                    synchronized (V2TIMSignalingManagerImpl.this) {
                                        Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                        while (it.hasNext()) {
                                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                            if (v2TIMSignalingListener != null) {
                                                v2TIMSignalingListener.onInvitationTimeout(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList());
                                            }
                                        }
                                    }
                                    V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo2);
                                    if (v2TIMSignalingInfo2.isOnlineUserOnly()) {
                                        return;
                                    }
                                    V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(message);
                                }
                            }, true);
                            return;
                        }
                    }
                }
            }, (v2TIMSignalingInfo.getTimeout() + 5) * 1000);
        }
    }

    private void checkSignalingListener() {
        BaseManager.getInstance().enableSignaling(this.mHasValidSignalingListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResponse(String str, String str2, final boolean z, final V2TIMCallback v2TIMCallback) {
        final String loginUser = V2TIMManager.getInstance().getLoginUser();
        if (TextUtils.isEmpty(loginUser)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "not login");
            }
            IMLog.e("V2TIMSigMgrImpl", "not login");
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.invitationList.size()) {
                break;
            }
            final V2TIMSignalingInfo v2TIMSignalingInfo = this.invitationList.get(i2);
            if (v2TIMSignalingInfo.getInviteID().equals(str) && v2TIMSignalingInfo.getInviteeList().contains(loginUser)) {
                final V2TIMSignalingInfo v2TIMSignalingInfo2 = new V2TIMSignalingInfo();
                v2TIMSignalingInfo2.setBusinessID(1);
                v2TIMSignalingInfo2.setInviteID(v2TIMSignalingInfo.getInviteID());
                v2TIMSignalingInfo2.setGroupID(v2TIMSignalingInfo.getGroupID());
                v2TIMSignalingInfo2.setInviter(v2TIMSignalingInfo.getInviter());
                v2TIMSignalingInfo2.addInvitee(loginUser);
                v2TIMSignalingInfo2.setData(str2);
                v2TIMSignalingInfo2.setOnlineUserOnly(v2TIMSignalingInfo.isOnlineUserOnly());
                if (z) {
                    v2TIMSignalingInfo2.setActionType(3);
                } else {
                    v2TIMSignalingInfo2.setActionType(4);
                }
                sendSignalMessage(v2TIMSignalingInfo2, new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.9
                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onError(int i3, String str3) {
                        V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                        if (v2TIMCallback2 != null) {
                            v2TIMCallback2.onError(i3, str3);
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onSuccess(Message message) {
                        synchronized (V2TIMSignalingManagerImpl.this) {
                            Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                            while (it.hasNext()) {
                                V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                if (v2TIMSignalingListener != null) {
                                    if (z) {
                                        v2TIMSignalingListener.onInviteeAccepted(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList().get(0), v2TIMSignalingInfo2.getData());
                                    } else {
                                        v2TIMSignalingListener.onInviteeRejected(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList().get(0), v2TIMSignalingInfo2.getData());
                                    }
                                }
                            }
                        }
                        v2TIMSignalingInfo.getInviteeList().remove(loginUser);
                        if (v2TIMSignalingInfo.getInviteeList().size() == 0) {
                            V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                        }
                        if (!v2TIMSignalingInfo2.isOnlineUserOnly()) {
                            V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(message);
                        }
                        V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                        if (v2TIMCallback2 != null) {
                            v2TIMCallback2.onSuccess();
                        }
                    }
                }, false);
                z2 = true;
            } else {
                i2++;
            }
        }
        if (z2) {
            return;
        }
        IMLog.e("V2TIMSigMgrImpl", "signaling doResponse failed, inviteID is invalid or invitation has been processed inviteID:" + str);
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_SDK_SIGNALING_INVALID_INVITE_ID, "inviteID is invalid or invitation has been processed");
        }
    }

    public static V2TIMSignalingManagerImpl getInstance() {
        return V2TIMSignalingManagerImplHolder.v2TIMSignalingManagerImpl;
    }

    private V2TIMSignalingInfo jsonStringToSignallingInfo(String str) {
        V2TIMSignalingInfo v2TIMSignalingInfo = new V2TIMSignalingInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            v2TIMSignalingInfo.setBusinessID(jSONObject.optInt("businessID"));
            v2TIMSignalingInfo.setInviteID(jSONObject.optString("inviteID"));
            v2TIMSignalingInfo.setGroupID(jSONObject.optString("groupID"));
            v2TIMSignalingInfo.setInviter(jSONObject.optString("inviter"));
            JSONArray optJSONArray = jSONObject.optJSONArray("inviteeList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(optJSONArray.optString(i2));
                }
                v2TIMSignalingInfo.setInviteeList(arrayList);
            }
            v2TIMSignalingInfo.setData(jSONObject.optString("data"));
            v2TIMSignalingInfo.setTimeout(jSONObject.optInt("timeout"));
            v2TIMSignalingInfo.setActionType(jSONObject.optInt("actionType"));
            v2TIMSignalingInfo.setOnlineUserOnly(jSONObject.optBoolean("onlineUserOnly"));
        } catch (JSONException unused) {
            IMLog.i("V2TIMSigMgrImpl", "custom data is not json format!");
        }
        return v2TIMSignalingInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnRecvMessage(Message message) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setMessage(message);
        V2TIMMessageManagerImpl.getInstance().onRecvNewMessage(v2TIMMessage);
    }

    private void reportSignalingAPICalls(String str, String str2) {
        String str3 = "signaling";
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("version") && jSONObject.has("businessID") && jSONObject.has("platform") && jSONObject.has("data")) {
                    String optString = jSONObject.optString("businessID");
                    if (!TextUtils.isEmpty(optString)) {
                        str3 = optString;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        BaseManager.getInstance().reportAPICall(str3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSignalMessage(V2TIMSignalingInfo v2TIMSignalingInfo, V2TIMValueCallback<Message> v2TIMValueCallback, boolean z) {
        byte[] bytes = signallingInfoToJsonString(v2TIMSignalingInfo).getBytes();
        CustomElement customElement = new CustomElement();
        customElement.setData(bytes);
        Message message = new Message();
        if (v2TIMSignalingInfo.isOnlineUserOnly()) {
            message.setLifeTime(0);
        }
        if (v2TIMSignalingInfo.getOfflinePushInfo() != null) {
            message.setOfflinePushInfo(v2TIMSignalingInfo.getOfflinePushInfo().getMessageOfflinePushInfo());
        }
        if (TextUtils.isEmpty(v2TIMSignalingInfo.getGroupID())) {
            message.setMessageType(Message.MESSAGE_TYPE_C2C);
            if (z) {
                message.setReceiverUserID(v2TIMSignalingInfo.getInviteeList().get(0));
            } else {
                message.setReceiverUserID(v2TIMSignalingInfo.getInviter());
            }
        } else {
            message.setMessageType(Message.MESSAGE_TYPE_GROUP);
            message.setGroupID(v2TIMSignalingInfo.getGroupID());
        }
        message.addElement(customElement);
        MessageCenter.getInstance().sendMessage(message, new MessageUploadProgressCallback() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.3
            @Override // com.tencent.imsdk.message.MessageUploadProgressCallback
            public void onUploadProgress(int i2, int i3, int i4) {
            }
        }, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.4
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

    private String signallingInfoToJsonString(V2TIMSignalingInfo v2TIMSignalingInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("businessID", v2TIMSignalingInfo.getBusinessID());
            jSONObject.put("inviteID", v2TIMSignalingInfo.getInviteID());
            jSONObject.put("groupID", v2TIMSignalingInfo.getGroupID());
            jSONObject.put("inviter", v2TIMSignalingInfo.getInviter());
            JSONArray jSONArray = new JSONArray();
            for (String str : v2TIMSignalingInfo.getInviteeList()) {
                jSONArray.put(str);
            }
            jSONObject.put("inviteeList", jSONArray);
            jSONObject.put("data", v2TIMSignalingInfo.getData());
            jSONObject.put("timeout", v2TIMSignalingInfo.getTimeout());
            jSONObject.put("actionType", v2TIMSignalingInfo.getActionType());
            jSONObject.put("onlineUserOnly", v2TIMSignalingInfo.isOnlineUserOnly());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void accept(final String str, final String str2, final V2TIMCallback v2TIMCallback) {
        IMLog.i("V2TIMSigMgrImpl", "signaling accept invite, inviteID:" + str);
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMSigMgrImpl", "signaling accept failed, inviteID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is null");
                return;
            }
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.7
            @Override // java.lang.Runnable
            public void run() {
                V2TIMSignalingManagerImpl.this.doResponse(str, str2, true, new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.7.1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i2, String str3) {
                        V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                        if (v2TIMCallback2 != null) {
                            v2TIMCallback2.onError(i2, str3);
                        }
                        IMLog.e("V2TIMSigMgrImpl", "signaling accept failed, inviteID:" + str + ", code:" + i2 + ", desc:" + str3);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                        if (v2TIMCallback2 != null) {
                            v2TIMCallback2.onSuccess();
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void addInvitedSignaling(final V2TIMSignalingInfo v2TIMSignalingInfo, final V2TIMCallback v2TIMCallback) {
        if (v2TIMSignalingInfo != null && !TextUtils.isEmpty(v2TIMSignalingInfo.getInviteID()) && !TextUtils.isEmpty(v2TIMSignalingInfo.getInviter()) && v2TIMSignalingInfo.getInviteeList() != null && !v2TIMSignalingInfo.getInviteeList().isEmpty()) {
            for (V2TIMSignalingInfo v2TIMSignalingInfo2 : this.invitationList) {
                if (TextUtils.equals(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo.getInviteID())) {
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(BaseConstants.ERR_SDK_SIGNALING_ALREADY_EXISTS, "inviteID " + v2TIMSignalingInfo.getInviteID() + " is exist");
                        return;
                    }
                    return;
                }
            }
            IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.11
                @Override // java.lang.Runnable
                public void run() {
                    V2TIMSignalingManagerImpl.this.invitationList.add(v2TIMSignalingInfo.m40clone());
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onSuccess();
                    }
                }
            });
            return;
        }
        IMLog.e("V2TIMSigMgrImpl", "addInvitedSignaling, info is invalid");
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "V2TIMSignalingInfo is invalid");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void addSignalingListener(V2TIMSignalingListener v2TIMSignalingListener) {
        synchronized (this) {
            if (this.mSignalingListenerList.contains(v2TIMSignalingListener)) {
                return;
            }
            this.mSignalingListenerList.add(v2TIMSignalingListener);
            this.mHasValidSignalingListener = true;
            checkSignalingListener();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void cancel(final String str, final String str2, final V2TIMCallback v2TIMCallback) {
        IMLog.i("V2TIMSigMgrImpl", "signaling cancel, inviteID:" + str);
        if (!TextUtils.isEmpty(str)) {
            IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    String loginUser = V2TIMManager.getInstance().getLoginUser();
                    if (TextUtils.isEmpty(loginUser)) {
                        V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                        if (v2TIMCallback2 != null) {
                            v2TIMCallback2.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "not login");
                        }
                        IMLog.e("V2TIMSigMgrImpl", "not login");
                        return;
                    }
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= V2TIMSignalingManagerImpl.this.invitationList.size()) {
                            break;
                        }
                        final V2TIMSignalingInfo v2TIMSignalingInfo = (V2TIMSignalingInfo) V2TIMSignalingManagerImpl.this.invitationList.get(i2);
                        if (v2TIMSignalingInfo.getInviteID().equals(str)) {
                            if (!v2TIMSignalingInfo.getInviter().equals(loginUser)) {
                                IMLog.e("V2TIMSigMgrImpl", "signaling cancel invite failed，the invitation is not initiated by yourself");
                                V2TIMCallback v2TIMCallback3 = v2TIMCallback;
                                if (v2TIMCallback3 != null) {
                                    v2TIMCallback3.onError(BaseConstants.ERR_SDK_SIGNALING_NO_PERMISSION, "the invitation is not initiated by yourself");
                                }
                            } else {
                                final V2TIMSignalingInfo v2TIMSignalingInfo2 = new V2TIMSignalingInfo();
                                v2TIMSignalingInfo2.setBusinessID(1);
                                v2TIMSignalingInfo2.setInviteID(v2TIMSignalingInfo.getInviteID());
                                v2TIMSignalingInfo2.setGroupID(v2TIMSignalingInfo.getGroupID());
                                v2TIMSignalingInfo2.setInviter(v2TIMSignalingInfo.getInviter());
                                v2TIMSignalingInfo2.setInviteeList(v2TIMSignalingInfo.getInviteeList());
                                v2TIMSignalingInfo2.setData(str2);
                                v2TIMSignalingInfo2.setOnlineUserOnly(v2TIMSignalingInfo.isOnlineUserOnly());
                                v2TIMSignalingInfo2.setActionType(2);
                                V2TIMSignalingManagerImpl.this.sendSignalMessage(v2TIMSignalingInfo2, new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.6.1
                                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                                    public void onError(int i3, String str3) {
                                        IMLog.e("V2TIMSigMgrImpl", "signaling cancel invite failed, inviteID: " + str + ", code:" + i3 + ", desc:" + str3);
                                        V2TIMCallback v2TIMCallback4 = v2TIMCallback;
                                        if (v2TIMCallback4 != null) {
                                            v2TIMCallback4.onError(i3, str3);
                                        }
                                    }

                                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                                    public void onSuccess(Message message) {
                                        synchronized (V2TIMSignalingManagerImpl.this) {
                                            Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                            while (it.hasNext()) {
                                                V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                                if (v2TIMSignalingListener != null) {
                                                    v2TIMSignalingListener.onInvitationCancelled(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviter(), v2TIMSignalingInfo2.getData());
                                                }
                                            }
                                        }
                                        V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                                        if (!v2TIMSignalingInfo2.isOnlineUserOnly()) {
                                            V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(message);
                                        }
                                        V2TIMCallback v2TIMCallback4 = v2TIMCallback;
                                        if (v2TIMCallback4 != null) {
                                            v2TIMCallback4.onSuccess();
                                        }
                                    }
                                }, true);
                            }
                            z = true;
                        } else {
                            i2++;
                        }
                    }
                    if (z || v2TIMCallback == null) {
                        return;
                    }
                    IMLog.e("V2TIMSigMgrImpl", "signaling cancel failed, inviteID is invalid or invitation has been processed inviteID:" + str);
                    v2TIMCallback.onError(BaseConstants.ERR_SDK_SIGNALING_INVALID_INVITE_ID, "inviteID is invalid or invitation has been processed");
                }
            });
        } else if (v2TIMCallback != null) {
            IMLog.e("V2TIMSigMgrImpl", "signaling cancel error, inviteID is empty");
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public V2TIMSignalingInfo getSignalingInfo(V2TIMMessage v2TIMMessage) {
        byte[] data;
        V2TIMSignalingInfo v2TIMSignalingInfo;
        if (v2TIMMessage == null || v2TIMMessage.getElemType() != 2) {
            return null;
        }
        Message message = v2TIMMessage.getMessage();
        for (int i2 = 0; i2 < message.getMessageBaseElements().size(); i2++) {
            MessageBaseElement messageBaseElement = message.getMessageBaseElements().get(i2);
            if ((messageBaseElement instanceof CustomElement) && (data = ((CustomElement) messageBaseElement).getData()) != null) {
                try {
                    v2TIMSignalingInfo = jsonStringToSignallingInfo(new String(data));
                } catch (Exception e2) {
                    IMLog.i("V2TIMSigMgrImpl", "getSignalingInfo exception:" + e2);
                    v2TIMSignalingInfo = null;
                }
                if (v2TIMSignalingInfo == null || v2TIMSignalingInfo.getBusinessID() != 1) {
                    return null;
                }
                return v2TIMSignalingInfo;
            }
        }
        return null;
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public String invite(String str, String str2, boolean z, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, int i2, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invitee is empty");
            }
            IMLog.e("V2TIMSigMgrImpl", "signaling invite error, invitee is empty");
            return null;
        }
        String loginUser = V2TIMManager.getInstance().getLoginUser();
        if (TextUtils.isEmpty(loginUser)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "not login");
            }
            IMLog.e("V2TIMSigMgrImpl", "not login");
            return null;
        }
        reportSignalingAPICalls("C2CSignaling", str2);
        final V2TIMSignalingInfo v2TIMSignalingInfo = new V2TIMSignalingInfo();
        v2TIMSignalingInfo.setBusinessID(1);
        v2TIMSignalingInfo.setInviter(loginUser);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        v2TIMSignalingInfo.setInviteeList(arrayList);
        v2TIMSignalingInfo.setData(str2);
        v2TIMSignalingInfo.setOnlineUserOnly(z);
        v2TIMSignalingInfo.setTimeout(i2);
        v2TIMSignalingInfo.setActionType(1);
        v2TIMSignalingInfo.setOfflinePushInfo(v2TIMOfflinePushInfo);
        v2TIMSignalingInfo.setInviteID(SystemUtil.md5(loginUser + System.currentTimeMillis() + new Random().nextInt(Integer.MAX_VALUE)));
        sendSignalMessage(v2TIMSignalingInfo, new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.1
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str3) {
                IMLog.e("V2TIMSigMgrImpl", "signaling sendSignalMessage failed code:" + i3 + ", desc:" + str3);
                V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onError(i3, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(Message message) {
                V2TIMSignalingManagerImpl.this.invitationList.add(v2TIMSignalingInfo);
                V2TIMSignalingManagerImpl.this.checkInviteTimeout(v2TIMSignalingInfo);
                if (!v2TIMSignalingInfo.isOnlineUserOnly()) {
                    V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(message);
                }
                V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onSuccess();
                }
            }
        }, true);
        IMLog.i("V2TIMSigMgrImpl", "signaling invite, inviteID:" + v2TIMSignalingInfo.getInviteID() + ", invitee:" + str + ", timeout:" + i2);
        return v2TIMSignalingInfo.getInviteID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public String inviteInGroup(String str, List<String> list, String str2, boolean z, int i2, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
            IMLog.e("V2TIMSigMgrImpl", "signaling invite error, groupID is empty");
            return null;
        } else if (list == null || list.size() == 0) {
            if (v2TIMCallback != null) {
                IMLog.e("V2TIMSigMgrImpl", "signaling invite error, inviteeList is empty");
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteeList is empty");
            }
            return null;
        } else {
            reportSignalingAPICalls("GroupSignaling", str2);
            String loginUser = V2TIMManager.getInstance().getLoginUser();
            if (TextUtils.isEmpty(loginUser)) {
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "not login");
                }
                IMLog.e("V2TIMSigMgrImpl", "not login");
                return null;
            }
            final V2TIMSignalingInfo v2TIMSignalingInfo = new V2TIMSignalingInfo();
            v2TIMSignalingInfo.setBusinessID(1);
            v2TIMSignalingInfo.setInviter(loginUser);
            v2TIMSignalingInfo.setGroupID(str);
            v2TIMSignalingInfo.setInviteeList(list);
            v2TIMSignalingInfo.setData(str2);
            v2TIMSignalingInfo.setOnlineUserOnly(z);
            v2TIMSignalingInfo.setTimeout(i2);
            v2TIMSignalingInfo.setActionType(1);
            v2TIMSignalingInfo.setInviteID(SystemUtil.md5(loginUser + System.currentTimeMillis() + new Random().nextInt(Integer.MAX_VALUE)));
            sendSignalMessage(v2TIMSignalingInfo, new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.2
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i3, String str3) {
                    IMLog.e("V2TIMSigMgrImpl", "signaling sendSignalMessage failed code:" + i3 + ", desc:" + str3);
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onError(i3, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(Message message) {
                    V2TIMSignalingManagerImpl.this.invitationList.add(v2TIMSignalingInfo);
                    V2TIMSignalingManagerImpl.this.checkInviteTimeout(v2TIMSignalingInfo);
                    if (!v2TIMSignalingInfo.isOnlineUserOnly()) {
                        V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(message);
                    }
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onSuccess();
                    }
                }
            }, true);
            IMLog.i("V2TIMSigMgrImpl", "signaling inviteInGroup, inviteID:" + v2TIMSignalingInfo.getInviteID() + ", groupID:" + str + ", inviteeList:" + list + ", timeout:" + i2);
            return v2TIMSignalingInfo.getInviteID();
        }
    }

    public V2TIMSignalingInfo processSignalingMessage(V2TIMMessage v2TIMMessage) {
        final V2TIMSignalingInfo signalingInfo;
        if (this.mHasValidSignalingListener && (signalingInfo = getSignalingInfo(v2TIMMessage)) != null) {
            int actionType = signalingInfo.getActionType();
            boolean z = true;
            if (actionType == 1) {
                int serverTime = (int) (V2TIMManager.getInstance().getServerTime() - v2TIMMessage.getTimestamp());
                if (signalingInfo.getTimeout() > 0 && serverTime > signalingInfo.getTimeout()) {
                    IMLog.d("V2TIMSigMgrImpl", "signaling receive invitation but ignore to callback because timeInterval:" + serverTime + " > timeout:" + signalingInfo.getTimeout());
                    return signalingInfo;
                }
                Iterator<V2TIMSignalingInfo> it = this.invitationList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (TextUtils.equals(it.next().getInviteID(), signalingInfo.getInviteID())) {
                        break;
                    }
                }
                if (!z) {
                    this.invitationList.add(signalingInfo);
                }
                final String loginUser = V2TIMManager.getInstance().getLoginUser();
                if (!TextUtils.isEmpty(loginUser) && signalingInfo.getInviteeList().contains(loginUser) && signalingInfo.getTimeout() > 0) {
                    this.mTimeoutHandler.postDelayed(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.10
                        @Override // java.lang.Runnable
                        public void run() {
                            for (int i2 = 0; i2 < V2TIMSignalingManagerImpl.this.invitationList.size(); i2++) {
                                final V2TIMSignalingInfo v2TIMSignalingInfo = (V2TIMSignalingInfo) V2TIMSignalingManagerImpl.this.invitationList.get(i2);
                                if (v2TIMSignalingInfo.getInviteID().equals(signalingInfo.getInviteID()) && v2TIMSignalingInfo.getInviteeList().contains(loginUser)) {
                                    IMLog.i("V2TIMSigMgrImpl", "signaling receive invite but local timeout, inviteID:" + signalingInfo.getInviteID());
                                    final V2TIMSignalingInfo v2TIMSignalingInfo2 = new V2TIMSignalingInfo();
                                    v2TIMSignalingInfo2.setBusinessID(1);
                                    v2TIMSignalingInfo2.setInviteID(signalingInfo.getInviteID());
                                    v2TIMSignalingInfo2.setGroupID(signalingInfo.getGroupID());
                                    v2TIMSignalingInfo2.setInviter(signalingInfo.getInviter());
                                    v2TIMSignalingInfo2.addInvitee(loginUser);
                                    v2TIMSignalingInfo2.setActionType(5);
                                    v2TIMSignalingInfo2.setOnlineUserOnly(signalingInfo.isOnlineUserOnly());
                                    v2TIMSignalingInfo2.setData(signalingInfo.getData());
                                    V2TIMSignalingManagerImpl.this.sendSignalMessage(v2TIMSignalingInfo2, new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.10.1
                                        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                                        public void onError(int i3, String str) {
                                            V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                                            synchronized (V2TIMSignalingManagerImpl.this) {
                                                Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                                while (it2.hasNext()) {
                                                    V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                                                    if (v2TIMSignalingListener != null) {
                                                        v2TIMSignalingListener.onInvitationTimeout(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList());
                                                    }
                                                }
                                            }
                                            IMLog.e("V2TIMSigMgrImpl", "signaling send timeout msg failed, inviteID:" + v2TIMSignalingInfo2.getInviteID() + ", code:" + i3 + ", desc:" + str);
                                        }

                                        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                                        public void onSuccess(Message message) {
                                            V2TIMSignalingManagerImpl.this.notifyOnRecvMessage(message);
                                            V2TIMSignalingManagerImpl.this.invitationList.remove(v2TIMSignalingInfo);
                                            synchronized (V2TIMSignalingManagerImpl.this) {
                                                Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                                                while (it2.hasNext()) {
                                                    V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                                                    if (v2TIMSignalingListener != null) {
                                                        v2TIMSignalingListener.onInvitationTimeout(v2TIMSignalingInfo2.getInviteID(), v2TIMSignalingInfo2.getInviteeList());
                                                    }
                                                }
                                            }
                                        }
                                    }, false);
                                    return;
                                }
                            }
                        }
                    }, signalingInfo.getTimeout() * 1000);
                }
                IMLog.i("V2TIMSigMgrImpl", "signaling receive invitation, inviteID:" + signalingInfo.getInviteID() + ", inviter:" + signalingInfo.getInviter() + ", groupID:" + signalingInfo.getGroupID() + ", inviteeList:" + signalingInfo.getInviteeList());
                synchronized (this) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(signalingInfo.getInviteeList());
                    Iterator<V2TIMSignalingListener> it2 = this.mSignalingListenerList.iterator();
                    while (it2.hasNext()) {
                        V2TIMSignalingListener next = it2.next();
                        if (next != null) {
                            next.onReceiveNewInvitation(signalingInfo.getInviteID(), signalingInfo.getInviter(), signalingInfo.getGroupID(), arrayList, signalingInfo.getData());
                        }
                    }
                }
            } else if (actionType == 2) {
                IMLog.i("V2TIMSigMgrImpl", "signaling receive cancel, inviteID:" + signalingInfo.getInviteID() + ", inviter:" + signalingInfo.getInviter());
                Iterator<V2TIMSignalingInfo> it3 = this.invitationList.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    V2TIMSignalingInfo next2 = it3.next();
                    if (next2.getInviteID().equals(signalingInfo.getInviteID())) {
                        this.invitationList.remove(next2);
                        break;
                    }
                }
                synchronized (this) {
                    Iterator<V2TIMSignalingListener> it4 = this.mSignalingListenerList.iterator();
                    while (it4.hasNext()) {
                        V2TIMSignalingListener next3 = it4.next();
                        if (next3 != null) {
                            next3.onInvitationCancelled(signalingInfo.getInviteID(), signalingInfo.getInviter(), signalingInfo.getData());
                        }
                    }
                }
            } else if (actionType != 3) {
                if (actionType != 4) {
                    if (actionType != 5) {
                        IMLog.e("V2TIMSigMgrImpl", "signaling unknown action type:" + signalingInfo.getActionType());
                    } else {
                        List<String> inviteeList = signalingInfo.getInviteeList();
                        if (inviteeList.size() == 0) {
                            IMLog.e("V2TIMSigMgrImpl", "signaling receive timeout but timeouters is empty");
                            return signalingInfo;
                        }
                        IMLog.i("V2TIMSigMgrImpl", "signaling receive timeout, inviteID:" + signalingInfo.getInviteID() + ", timeouters:" + inviteeList);
                        Iterator<V2TIMSignalingInfo> it5 = this.invitationList.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                break;
                            }
                            V2TIMSignalingInfo next4 = it5.next();
                            if (next4.getInviteID().equals(signalingInfo.getInviteID())) {
                                next4.getInviteeList().removeAll(inviteeList);
                                if (next4.getInviteeList().size() == 0) {
                                    this.invitationList.remove(next4);
                                }
                            }
                        }
                        synchronized (this) {
                            Iterator<V2TIMSignalingListener> it6 = this.mSignalingListenerList.iterator();
                            while (it6.hasNext()) {
                                V2TIMSignalingListener next5 = it6.next();
                                if (next5 != null) {
                                    next5.onInvitationTimeout(signalingInfo.getInviteID(), inviteeList);
                                }
                            }
                        }
                    }
                } else if (signalingInfo.getInviteeList().size() == 0) {
                    IMLog.e("V2TIMSigMgrImpl", "signaling receive reject but rejecter is empty");
                    return signalingInfo;
                } else {
                    String str = signalingInfo.getInviteeList().get(0);
                    IMLog.i("V2TIMSigMgrImpl", "signaling receive reject, inviteID:" + signalingInfo.getInviteID() + ", rejecter:" + str);
                    Iterator<V2TIMSignalingInfo> it7 = this.invitationList.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            break;
                        }
                        V2TIMSignalingInfo next6 = it7.next();
                        if (next6.getInviteID().equals(signalingInfo.getInviteID())) {
                            next6.getInviteeList().remove(str);
                            if (next6.getInviteeList().size() == 0) {
                                this.invitationList.remove(next6);
                            }
                        }
                    }
                    synchronized (this) {
                        Iterator<V2TIMSignalingListener> it8 = this.mSignalingListenerList.iterator();
                        while (it8.hasNext()) {
                            V2TIMSignalingListener next7 = it8.next();
                            if (next7 != null) {
                                next7.onInviteeRejected(signalingInfo.getInviteID(), str, signalingInfo.getData());
                            }
                        }
                    }
                }
            } else if (signalingInfo.getInviteeList().size() == 0) {
                IMLog.e("V2TIMSigMgrImpl", "signaling receive accept but accepter is empty");
                return signalingInfo;
            } else {
                String str2 = signalingInfo.getInviteeList().get(0);
                IMLog.i("V2TIMSigMgrImpl", "signaling receive accept, inviteID:" + signalingInfo.getInviteID() + ", accepter:" + str2);
                Iterator<V2TIMSignalingInfo> it9 = this.invitationList.iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        break;
                    }
                    V2TIMSignalingInfo next8 = it9.next();
                    if (next8.getInviteID().equals(signalingInfo.getInviteID())) {
                        next8.getInviteeList().remove(str2);
                        if (next8.getInviteeList().size() == 0) {
                            this.invitationList.remove(next8);
                        }
                    }
                }
                synchronized (this) {
                    Iterator<V2TIMSignalingListener> it10 = this.mSignalingListenerList.iterator();
                    while (it10.hasNext()) {
                        V2TIMSignalingListener next9 = it10.next();
                        if (next9 != null) {
                            next9.onInviteeAccepted(signalingInfo.getInviteID(), str2, signalingInfo.getData());
                        }
                    }
                }
            }
            return signalingInfo;
        }
        return null;
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void reject(final String str, final String str2, final V2TIMCallback v2TIMCallback) {
        IMLog.i("V2TIMSigMgrImpl", "signaling reject invite, inviteID:" + str);
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMSigMgrImpl", "signaling reject invite, inviteID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is null");
                return;
            }
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.8
            @Override // java.lang.Runnable
            public void run() {
                V2TIMSignalingManagerImpl.this.doResponse(str, str2, false, new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.8.1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i2, String str3) {
                        V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                        if (v2TIMCallback2 != null) {
                            v2TIMCallback2.onError(i2, str3);
                        }
                        IMLog.e("V2TIMSigMgrImpl", "signaling reject failed, inviteID:" + str + ", code:" + i2 + ", desc:" + str3);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                        if (v2TIMCallback2 != null) {
                            v2TIMCallback2.onSuccess();
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void removeSignalingListener(V2TIMSignalingListener v2TIMSignalingListener) {
        synchronized (this) {
            this.mSignalingListenerList.remove(v2TIMSignalingListener);
            if (this.mSignalingListenerList.size() == 0) {
                this.mHasValidSignalingListener = false;
            }
            checkSignalingListener();
        }
    }

    public void unInit() {
        synchronized (this) {
            this.mSignalingListenerList.clear();
            this.mHasValidSignalingListener = false;
        }
    }

    private V2TIMSignalingManagerImpl() {
        this.TAG = "V2TIMSigMgrImpl";
        this.TIMEOUT_DELAY = 5;
        this.mHasValidSignalingListener = false;
        this.invitationList = new ArrayList();
        this.mSignalingListenerList = new CopyOnWriteArrayList<>();
        this.mTimeoutHandler = new Handler(Looper.getMainLooper());
    }
}
