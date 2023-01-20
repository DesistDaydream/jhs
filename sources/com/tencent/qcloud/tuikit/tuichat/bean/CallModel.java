package com.tencent.qcloud.tuikit.tuichat.bean;

import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSignalingInfo;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import e.j.e.r.c;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class CallModel implements Cloneable, Serializable {
    public static final int VIDEO_CALL_ACTION_ACCEPT = 7;
    public static final int VIDEO_CALL_ACTION_DIALING = 1;
    public static final int VIDEO_CALL_ACTION_ERROR = -1;
    public static final int VIDEO_CALL_ACTION_HANGUP = 5;
    public static final int VIDEO_CALL_ACTION_LINE_BUSY = 6;
    public static final int VIDEO_CALL_ACTION_REJECT = 3;
    public static final int VIDEO_CALL_ACTION_SPONSOR_CANCEL = 2;
    public static final int VIDEO_CALL_ACTION_SPONSOR_TIMEOUT = 4;
    public static final int VIDEO_CALL_ACTION_UNKNOWN = 0;
    @c("businessID")
    public String bussinessID;
    @c("call_id")
    public String callId;
    public String data;
    @c("invited_list")
    public List<String> invitedList;
    public String sender;
    public int timeout;
    public long timestamp;
    private static final String TAG = CallModel.class.getSimpleName();
    public static String SIGNALING_EXTRA_VALUE_BUSINESS_ID = TUIConstants.TUICalling.CUSTOM_MESSAGE_BUSINESS_ID;
    public static String SIGNALING_EXTRA_KEY_BUSINESS_ID = "businessID";
    public static String SIGNALING_EXTRA_KEY_CALL_TYPE = TUIConstants.Message.CALLING_TYPE_KEY;
    public static String SIGNALING_EXTRA_KEY_ROOM_ID = TTLiveConstants.ROOMID_KEY;
    public static String SIGNALING_EXTRA_KEY_LINE_BUSY = "line_busy";
    public static String SIGNALING_EXTRA_KEY_CALL_END = "call_end";
    public static String SIGNALING_EXTRA_KEY_VERSION = "version";
    @c("version")
    public int version = 0;
    @c(TTLiveConstants.ROOMID_KEY)
    public int roomId = 0;
    @c("group_id")
    public String groupId = "";
    @c("action")
    public int action = 0;
    @c(TUIConstants.Message.CALLING_TYPE_KEY)
    public int callType = 0;
    @c("duration")
    public int duration = 0;
    @c("code")
    public int code = 0;

    public static CallModel convert2VideoCallData(V2TIMMessage v2TIMMessage) {
        Map map;
        V2TIMSignalingInfo signalingInfo = V2TIMManager.getSignalingManager().getSignalingInfo(v2TIMMessage);
        if (signalingInfo == null) {
            return null;
        }
        CallModel callModel = new CallModel();
        try {
            map = (Map) new Gson().n(signalingInfo.getData(), Map.class);
        } catch (Exception e2) {
            String str = TAG;
            TUIChatLog.e(str, "convert2VideoCallData exception:" + e2);
        }
        if (map != null && map.containsKey(SIGNALING_EXTRA_KEY_VERSION) && ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue() > TUIChatConstants.version) {
            callModel.action = 0;
            return callModel;
        }
        callModel.data = signalingInfo.getData();
        if (map != null) {
            callModel.bussinessID = (String) map.get(SIGNALING_EXTRA_KEY_BUSINESS_ID);
        }
        if (signalingInfo.getActionType() == 1 && map != null) {
            callModel.groupId = signalingInfo.getGroupID();
            callModel.timestamp = v2TIMMessage.getTimestamp();
            callModel.version = ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue();
            if (map.containsKey(SIGNALING_EXTRA_KEY_CALL_END)) {
                callModel.action = 5;
                callModel.duration = ((Double) map.get(SIGNALING_EXTRA_KEY_CALL_END)).intValue();
            } else {
                callModel.action = 1;
                callModel.callId = signalingInfo.getInviteID();
                callModel.sender = signalingInfo.getInviter();
                callModel.invitedList = signalingInfo.getInviteeList();
                callModel.callType = ((Double) map.get(SIGNALING_EXTRA_KEY_CALL_TYPE)).intValue();
                callModel.roomId = ((Double) map.get(SIGNALING_EXTRA_KEY_ROOM_ID)).intValue();
            }
        } else if (signalingInfo.getActionType() == 2) {
            callModel.action = 2;
            callModel.groupId = signalingInfo.getGroupID();
            callModel.callId = signalingInfo.getInviteID();
            callModel.version = ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue();
        } else if (signalingInfo.getActionType() == 4 && map != null) {
            callModel.groupId = signalingInfo.getGroupID();
            callModel.callId = signalingInfo.getInviteID();
            callModel.invitedList = signalingInfo.getInviteeList();
            callModel.version = ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue();
            if (map.containsKey(SIGNALING_EXTRA_KEY_LINE_BUSY)) {
                callModel.action = 6;
            } else {
                callModel.action = 3;
            }
        } else if (signalingInfo.getActionType() == 5) {
            callModel.action = 4;
            callModel.groupId = signalingInfo.getGroupID();
            callModel.callId = signalingInfo.getInviteID();
            callModel.invitedList = signalingInfo.getInviteeList();
        } else if (signalingInfo.getActionType() == 3) {
            callModel.action = 7;
            callModel.groupId = signalingInfo.getGroupID();
            callModel.callId = signalingInfo.getInviteID();
            callModel.invitedList = signalingInfo.getInviteeList();
            callModel.version = ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue();
        }
        if (map != null) {
            callModel.callType = ((Double) map.get(TUIConstants.Message.CALLING_TYPE_KEY)).intValue();
        }
        return callModel;
    }
}
