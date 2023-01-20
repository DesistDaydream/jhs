package com.tencent.qcloud.tuikit.tuichat.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.imsdk.v2.V2TIMCustomElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSignalingInfo;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.CallModel;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageCustom;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageTyping;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.LocationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ChatMessageParser {
    private static final String TAG = "ChatMessageParser";

    private static TUIMessageBean getCallingMessage(V2TIMMessage v2TIMMessage) {
        String string;
        List<String> list;
        boolean z = !TextUtils.isEmpty(v2TIMMessage.getGroupID());
        CallModel convert2VideoCallData = CallModel.convert2VideoCallData(v2TIMMessage);
        if (convert2VideoCallData == null) {
            return null;
        }
        String displayName = getDisplayName(v2TIMMessage);
        Context appContext = TUIChatService.getAppContext();
        switch (convert2VideoCallData.action) {
            case 1:
                if (z) {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.start_group_call);
                    break;
                } else {
                    string = appContext.getString(R.string.start_call);
                    break;
                }
            case 2:
                string = appContext.getString(z ? R.string.cancle_group_call : R.string.cancle_call);
                break;
            case 3:
                if (z) {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.reject_group_calls);
                    break;
                } else {
                    string = appContext.getString(R.string.reject_calls);
                    break;
                }
            case 4:
                if (!z || (list = convert2VideoCallData.invitedList) == null || list.size() != 1 || !convert2VideoCallData.invitedList.get(0).equals(v2TIMMessage.getSender())) {
                    StringBuilder sb = new StringBuilder();
                    List<String> list2 = convert2VideoCallData.invitedList;
                    if (list2 != null && list2.size() > 0) {
                        for (String str : convert2VideoCallData.invitedList) {
                            sb.append(str);
                            sb.append("、");
                        }
                        if (sb.length() > 0) {
                            sb.delete(sb.length() - 1, sb.length());
                        }
                    }
                    if (z) {
                        string = "\"" + sb.toString() + "\"" + appContext.getString(R.string.no_response_call);
                        break;
                    } else {
                        string = appContext.getString(R.string.no_response_call);
                        break;
                    }
                } else {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.no_response_call);
                    break;
                }
                break;
            case 5:
                if (!z) {
                    string = appContext.getString(R.string.stop_call_tip) + DateTimeUtil.formatSecondsTo00(convert2VideoCallData.duration);
                    break;
                } else {
                    string = appContext.getString(R.string.stop_group_call);
                    break;
                }
            case 6:
                if (z) {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.line_busy);
                    break;
                } else {
                    string = appContext.getString(R.string.other_line_busy);
                    break;
                }
            case 7:
                if (z) {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.accept_call);
                    break;
                } else {
                    string = appContext.getString(R.string.accept_call);
                    break;
                }
            default:
                string = appContext.getString(R.string.invalid_command);
                break;
        }
        if (z) {
            TipsMessageBean tipsMessageBean = new TipsMessageBean();
            tipsMessageBean.setCommonAttribute(v2TIMMessage);
            tipsMessageBean.setText(string);
            tipsMessageBean.setExtra(string);
            return tipsMessageBean;
        }
        CallingMessageBean callingMessageBean = new CallingMessageBean();
        callingMessageBean.setCommonAttribute(v2TIMMessage);
        callingMessageBean.setText(string);
        callingMessageBean.setExtra(string);
        callingMessageBean.setCallType(convert2VideoCallData.callType);
        return callingMessageBean;
    }

    private static String getCustomBusinessId(V2TIMMessage v2TIMMessage) {
        HashMap hashMap;
        try {
            hashMap = (HashMap) new Gson().n(new String(v2TIMMessage.getCustomElem().getData()), HashMap.class);
        } catch (JsonSyntaxException unused) {
            TUIChatLog.e(TAG, " getCustomJsonMap error ");
            hashMap = null;
        }
        Object obj = hashMap != null ? hashMap.get("type") : null;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static String getDisplayName(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage == null) {
            return null;
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getNameCard())) {
            return v2TIMMessage.getNameCard();
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getFriendRemark())) {
            return v2TIMMessage.getFriendRemark();
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getNickName())) {
            return v2TIMMessage.getNickName();
        }
        return v2TIMMessage.getSender();
    }

    public static String getDisplayString(V2TIMMessage v2TIMMessage) {
        TUIMessageBean parseMessage;
        String onGetDisplayString;
        String nameCard;
        if (v2TIMMessage == null || (parseMessage = parseMessage(v2TIMMessage)) == null) {
            return null;
        }
        if (parseMessage.getStatus() == 275) {
            if (parseMessage.isSelf()) {
                onGetDisplayString = TUIChatService.getAppContext().getString(R.string.revoke_tips_you);
            } else if (parseMessage.isGroup()) {
                if (TextUtils.isEmpty(parseMessage.getNameCard())) {
                    nameCard = parseMessage.getSender();
                } else {
                    nameCard = parseMessage.getNameCard();
                }
                onGetDisplayString = TUIChatConstants.covert2HTMLString(nameCard) + TUIChatService.getAppContext().getString(R.string.revoke_tips);
            } else {
                onGetDisplayString = TUIChatService.getAppContext().getString(R.string.revoke_tips_other);
            }
        } else {
            onGetDisplayString = parseMessage.onGetDisplayString();
        }
        return FaceManager.emojiJudge(onGetDisplayString);
    }

    public static String getLocalImagePath(TUIMessageBean tUIMessageBean) {
        V2TIMMessage v2TIMMessage;
        V2TIMImageElem imageElem;
        if (tUIMessageBean == null || !tUIMessageBean.isSelf() || (v2TIMMessage = tUIMessageBean.getV2TIMMessage()) == null || v2TIMMessage.getElemType() != 3 || (imageElem = v2TIMMessage.getImageElem()) == null) {
            return null;
        }
        String path = imageElem.getPath();
        if (new File(path).exists()) {
            return path;
        }
        return null;
    }

    public static String getMsgTypeStr(int i2) {
        switch (i2) {
            case 3:
                return TUIChatService.getAppContext().getString(R.string.picture_extra);
            case 4:
                return TUIChatService.getAppContext().getString(R.string.audio_extra);
            case 5:
                return TUIChatService.getAppContext().getString(R.string.video_extra);
            case 6:
                return TUIChatService.getAppContext().getString(R.string.file_extra);
            case 7:
                return TUIChatService.getAppContext().getString(R.string.location_extra);
            case 8:
                return TUIChatService.getAppContext().getString(R.string.custom_emoji);
            default:
                return "";
        }
    }

    public static String getReplyMessageAbstract(TUIMessageBean tUIMessageBean) {
        String extra;
        if (tUIMessageBean != null) {
            if (tUIMessageBean instanceof TextMessageBean) {
                extra = ((TextMessageBean) tUIMessageBean).getText();
            } else if (tUIMessageBean instanceof MergeMessageBean) {
                extra = ((MergeMessageBean) tUIMessageBean).getTitle();
            } else if (tUIMessageBean instanceof FileMessageBean) {
                extra = ((FileMessageBean) tUIMessageBean).getFileName();
            } else if (tUIMessageBean instanceof CustomLinkMessageBean) {
                extra = ((CustomLinkMessageBean) tUIMessageBean).getText();
            } else {
                extra = ((tUIMessageBean instanceof SoundMessageBean) || (tUIMessageBean instanceof ImageMessageBean) || (tUIMessageBean instanceof VideoMessageBean) || (tUIMessageBean instanceof LocationMessageBean) || (tUIMessageBean instanceof FaceMessageBean)) ? "" : tUIMessageBean.getExtra();
            }
            return "" + extra;
        }
        return "";
    }

    public static boolean isFileType(int i2) {
        return i2 == 6;
    }

    public static boolean isTyping(byte[] bArr) {
        try {
            MessageTyping messageTyping = (MessageTyping) new Gson().n(new String(bArr, "UTF-8"), MessageTyping.class);
            if (messageTyping != null && messageTyping.userAction == 14) {
                if (TextUtils.equals(messageTyping.actionParam, MessageTyping.EDIT_START)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            TUIChatLog.e(TAG, "parse json error");
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7 */
    private static TUIMessageBean parseCallingMessage(V2TIMMessage v2TIMMessage) {
        HashMap hashMap;
        String str;
        V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
        if (customElem != null && customElem.getData() != null) {
            String str2 = new String(customElem.getData());
            Gson gson = new Gson();
            try {
                hashMap = (HashMap) gson.n(str2, HashMap.class);
            } catch (JsonSyntaxException unused) {
                TUIChatLog.e(TAG, " getCustomJsonMap error ");
                hashMap = null;
            }
            Double valueOf = Double.valueOf(0.0d);
            Object obj = hashMap != null ? hashMap.get("type") : null;
            if (obj instanceof String) {
                str = obj;
            } else {
                if (obj instanceof Double) {
                    valueOf = obj;
                }
                str = null;
            }
            V2TIMSignalingInfo signalingInfo = V2TIMManager.getSignalingManager().getSignalingInfo(v2TIMMessage);
            if (signalingInfo != null) {
                try {
                    HashMap hashMap2 = (HashMap) gson.n(signalingInfo.getData(), HashMap.class);
                    if (hashMap2 != null) {
                        obj = hashMap2.get("type");
                    }
                } catch (JsonSyntaxException unused2) {
                    TUIChatLog.e(TAG, " get signalingInfoCustomJsonMap error ");
                }
                if (obj instanceof String) {
                    str = obj;
                } else if (obj instanceof Double) {
                    valueOf = obj;
                }
                if (TextUtils.equals(str, TUIConstants.TUICalling.CUSTOM_MESSAGE_BUSINESS_ID) || Math.abs(valueOf.doubleValue() - TUIConstants.TUICalling.CALL_TIMEOUT_BUSINESS_ID.doubleValue()) < 1.0E-6d) {
                    return getCallingMessage(v2TIMMessage);
                }
                return null;
            }
        }
        return null;
    }

    private static TUIMessageBean parseCustomMessage(V2TIMMessage v2TIMMessage) {
        TUIMessageBean parseCallingMessage = parseCallingMessage(v2TIMMessage);
        if (parseCallingMessage == null) {
            parseCallingMessage = parseGroupCreateMessage(v2TIMMessage);
        }
        return parseCallingMessage == null ? parseCustomMessageFromMap(v2TIMMessage) : parseCallingMessage;
    }

    private static TUIMessageBean parseCustomMessageFromMap(V2TIMMessage v2TIMMessage) {
        Class<? extends TUIMessageBean> messageBeanClass = TUIChatService.getInstance().getMessageBeanClass(getCustomBusinessId(v2TIMMessage));
        if (messageBeanClass != null) {
            try {
                return messageBeanClass.newInstance();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static TUIMessageBean parseGroupCreateMessage(V2TIMMessage v2TIMMessage) {
        V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
        String str = new String(customElem.getData());
        Gson gson = new Gson();
        if (str.equals("group_create")) {
            TipsMessageBean tipsMessageBean = new TipsMessageBean();
            tipsMessageBean.setCommonAttribute(v2TIMMessage);
            tipsMessageBean.setTipType(257);
            String str2 = TUIChatConstants.covert2HTMLString(getDisplayName(v2TIMMessage)) + TUIChatService.getAppContext().getString(R.string.create_group);
            tipsMessageBean.setText(str2);
            tipsMessageBean.setExtra(str2);
            return tipsMessageBean;
        } else if (isTyping(customElem.getData())) {
            return null;
        } else {
            TUIChatLog.i(TAG, "custom data:" + str);
            try {
                MessageCustom messageCustom = (MessageCustom) gson.n(str, MessageCustom.class);
                if (!TextUtils.isEmpty(messageCustom.businessID) && messageCustom.businessID.equals("group_create")) {
                    TipsMessageBean tipsMessageBean2 = new TipsMessageBean();
                    tipsMessageBean2.setCommonAttribute(v2TIMMessage);
                    tipsMessageBean2.setTipType(257);
                    String str3 = TUIChatConstants.covert2HTMLString(getDisplayName(v2TIMMessage)) + messageCustom.content;
                    tipsMessageBean2.setText(str3);
                    tipsMessageBean2.setExtra(str3);
                    return tipsMessageBean2;
                }
            } catch (Exception e2) {
                TUIChatLog.e(TAG, "invalid json: " + str + ", exception:" + e2);
            }
            return null;
        }
    }

    public static TUIMessageBean parseMessage(V2TIMMessage v2TIMMessage) {
        return parseMessage(v2TIMMessage, false);
    }

    public static List<TUIMessageBean> parseMessageList(List<V2TIMMessage> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            TUIMessageBean parseMessage = parseMessage(list.get(i2));
            if (parseMessage != null) {
                arrayList.add(parseMessage);
            }
        }
        return arrayList;
    }

    private static TUIMessageBean parseReplyMessage(V2TIMMessage v2TIMMessage) {
        String cloudCustomData = v2TIMMessage.getCloudCustomData();
        if (TextUtils.isEmpty(cloudCustomData)) {
            return null;
        }
        try {
            Gson gson = new Gson();
            HashMap hashMap = (HashMap) gson.n(cloudCustomData, HashMap.class);
            if (hashMap != null) {
                Object obj = hashMap.get("messageReply");
                ReplyPreviewBean replyPreviewBean = obj instanceof Map ? (ReplyPreviewBean) gson.n(gson.z(obj), ReplyPreviewBean.class) : null;
                if (replyPreviewBean == null || replyPreviewBean.getVersion() > 1) {
                    return null;
                }
                return new ReplyMessageBean(replyPreviewBean);
            }
        } catch (JsonSyntaxException unused) {
            TUIChatLog.e(TAG, " getCustomJsonMap error ");
        }
        return null;
    }

    public static TUIMessageBean parseMessage(V2TIMMessage v2TIMMessage, boolean z) {
        if (v2TIMMessage == null) {
            return null;
        }
        if (v2TIMMessage.getStatus() != 4 && v2TIMMessage.getElemType() != 0) {
            r0 = z ? null : parseReplyMessage(v2TIMMessage);
            if (r0 == null) {
                switch (v2TIMMessage.getElemType()) {
                    case 1:
                        r0 = new TextMessageBean();
                        break;
                    case 2:
                        r0 = parseCustomMessage(v2TIMMessage);
                        break;
                    case 3:
                        r0 = new ImageMessageBean();
                        break;
                    case 4:
                        r0 = new SoundMessageBean();
                        break;
                    case 5:
                        r0 = new VideoMessageBean();
                        break;
                    case 6:
                        r0 = new FileMessageBean();
                        break;
                    case 7:
                        r0 = new LocationMessageBean();
                        break;
                    case 8:
                        r0 = new FaceMessageBean();
                        break;
                    case 9:
                        r0 = new TipsMessageBean();
                        break;
                    case 10:
                        r0 = new MergeMessageBean();
                        break;
                }
            }
            if (r0 != null) {
                r0.setCommonAttribute(v2TIMMessage);
                r0.onProcessMessage(v2TIMMessage);
            }
        }
        return r0;
    }
}
