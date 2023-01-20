package com.tencent.qcloud.tuikit.tuichat.util;

import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextAtMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class ChatMessageBuilder {
    public static TUIMessageBean buildAtReplyMessage(String str, List<String> list, ReplyPreviewBean replyPreviewBean) {
        V2TIMMessage createTextAtMessage = V2TIMManager.getMessageManager().createTextAtMessage(str, list);
        createTextAtMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        return buildReplyMessage(createTextAtMessage, replyPreviewBean);
    }

    public static TUIMessageBean buildAudioMessage(String str, int i2) {
        V2TIMMessage createSoundMessage = V2TIMManager.getMessageManager().createSoundMessage(str, Math.round((i2 * 1.0f) / 1000.0f));
        createSoundMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        SoundMessageBean soundMessageBean = new SoundMessageBean();
        soundMessageBean.setCommonAttribute(createSoundMessage);
        soundMessageBean.onProcessMessage(createSoundMessage);
        soundMessageBean.setDataPath(str);
        return soundMessageBean;
    }

    public static TUIMessageBean buildCustomMessage(String str, String str2, byte[] bArr) {
        V2TIMMessage createCustomMessage = V2TIMManager.getMessageManager().createCustomMessage(str.getBytes(), str2, bArr);
        createCustomMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        TUIMessageBean parseMessage = ChatMessageParser.parseMessage(createCustomMessage);
        if (parseMessage.getExtra() == null) {
            parseMessage.setExtra(TUIChatService.getAppContext().getString(R.string.custom_msg));
        }
        return parseMessage;
    }

    public static TUIMessageBean buildFaceMessage(int i2, String str) {
        V2TIMMessage createFaceMessage = V2TIMManager.getMessageManager().createFaceMessage(i2, str.getBytes());
        createFaceMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        FaceMessageBean faceMessageBean = new FaceMessageBean();
        faceMessageBean.setCommonAttribute(createFaceMessage);
        faceMessageBean.onProcessMessage(createFaceMessage);
        return faceMessageBean;
    }

    public static TUIMessageBean buildFileMessage(Uri uri) {
        String pathFromUri = com.tencent.qcloud.tuicore.util.FileUtil.getPathFromUri(uri);
        File file = new File(pathFromUri);
        if (file.exists()) {
            V2TIMMessage createFileMessage = V2TIMManager.getMessageManager().createFileMessage(pathFromUri, file.getName());
            createFileMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
            FileMessageBean fileMessageBean = new FileMessageBean();
            fileMessageBean.setCommonAttribute(createFileMessage);
            fileMessageBean.onProcessMessage(createFileMessage);
            fileMessageBean.setDataPath(pathFromUri);
            return fileMessageBean;
        }
        return null;
    }

    public static TUIMessageBean buildForwardMessage(V2TIMMessage v2TIMMessage) {
        V2TIMMessage createForwardMessage = V2TIMManager.getMessageManager().createForwardMessage(v2TIMMessage);
        createForwardMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        return buildMessage(createForwardMessage);
    }

    public static V2TIMMessage buildGroupCustomMessage(String str) {
        return V2TIMManager.getMessageManager().createCustomMessage(str.getBytes());
    }

    public static TUIMessageBean buildImageMessage(Uri uri) {
        String imagePathAfterRotate = ImageUtil.getImagePathAfterRotate(uri);
        V2TIMMessage createImageMessage = V2TIMManager.getMessageManager().createImageMessage(imagePathAfterRotate);
        createImageMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        ImageMessageBean imageMessageBean = new ImageMessageBean();
        imageMessageBean.setCommonAttribute(createImageMessage);
        imageMessageBean.onProcessMessage(createImageMessage);
        imageMessageBean.setDataUri(uri);
        int[] imageSize = ImageUtil.getImageSize(imagePathAfterRotate);
        imageMessageBean.setDataPath(imagePathAfterRotate);
        imageMessageBean.setImgWidth(imageSize[0]);
        imageMessageBean.setImgHeight(imageSize[1]);
        return imageMessageBean;
    }

    public static TUIMessageBean buildMergeMessage(List<TUIMessageBean> list, String str, List<String> list2, String str2) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).getV2TIMMessage());
        }
        V2TIMMessage createMergerMessage = V2TIMManager.getMessageManager().createMergerMessage(arrayList, str, list2, str2);
        createMergerMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        MergeMessageBean mergeMessageBean = new MergeMessageBean();
        mergeMessageBean.setCommonAttribute(createMergerMessage);
        mergeMessageBean.onProcessMessage(createMergerMessage);
        return mergeMessageBean;
    }

    public static TUIMessageBean buildMessage(V2TIMMessage v2TIMMessage) {
        return ChatMessageParser.parseMessage(v2TIMMessage);
    }

    public static TUIMessageBean buildReplyMessage(String str, ReplyPreviewBean replyPreviewBean) {
        V2TIMMessage createTextMessage = V2TIMManager.getMessageManager().createTextMessage(str);
        createTextMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        return buildReplyMessage(createTextMessage, replyPreviewBean);
    }

    public static ReplyPreviewBean buildReplyPreviewBean(TUIMessageBean tUIMessageBean) {
        String replyMessageAbstract = ChatMessageParser.getReplyMessageAbstract(tUIMessageBean);
        String nickName = tUIMessageBean.getNickName();
        if (TextUtils.isEmpty(nickName)) {
            nickName = tUIMessageBean.getSender();
        }
        ReplyPreviewBean replyPreviewBean = new ReplyPreviewBean();
        replyPreviewBean.setOriginalMessageBean(tUIMessageBean);
        replyPreviewBean.setMessageID(tUIMessageBean.getId());
        replyPreviewBean.setMessageAbstract(replyMessageAbstract);
        replyPreviewBean.setMessageSender(nickName);
        replyPreviewBean.setMessageTime(tUIMessageBean.getMessageTime());
        replyPreviewBean.setMessageSequence(tUIMessageBean.getMsgSeq());
        replyPreviewBean.setMessageType(tUIMessageBean.getMsgType());
        return replyPreviewBean;
    }

    public static TextAtMessageBean buildTextAtMessage(List<String> list, String str) {
        V2TIMMessage createTextAtMessage = V2TIMManager.getMessageManager().createTextAtMessage(str, list);
        createTextAtMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        TextAtMessageBean textAtMessageBean = new TextAtMessageBean();
        textAtMessageBean.setCommonAttribute(createTextAtMessage);
        textAtMessageBean.onProcessMessage(createTextAtMessage);
        return textAtMessageBean;
    }

    public static TextMessageBean buildTextMessage(String str) {
        V2TIMMessage createTextMessage = V2TIMManager.getMessageManager().createTextMessage(str);
        createTextMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        TextMessageBean textMessageBean = new TextMessageBean();
        textMessageBean.setCommonAttribute(createTextMessage);
        textMessageBean.onProcessMessage(createTextMessage);
        return textMessageBean;
    }

    public static TUIMessageBean buildVideoMessage(String str, String str2, int i2, int i3, long j2) {
        V2TIMMessage createVideoMessage = V2TIMManager.getMessageManager().createVideoMessage(str2, "mp4", Math.round((((float) j2) * 1.0f) / 1000.0f), str);
        createVideoMessage.setNeedReadReceipt(TUIChatConfigs.getConfigs().getGeneralConfig().isNeedReadReceipt());
        VideoMessageBean videoMessageBean = new VideoMessageBean();
        videoMessageBean.setCommonAttribute(createVideoMessage);
        videoMessageBean.onProcessMessage(createVideoMessage);
        Uri fromFile = Uri.fromFile(new File(str2));
        videoMessageBean.setImgWidth(i2);
        videoMessageBean.setImgHeight(i3);
        videoMessageBean.setDataPath(str);
        videoMessageBean.setDataUri(fromFile);
        return videoMessageBean;
    }

    private static TUIMessageBean buildReplyMessage(V2TIMMessage v2TIMMessage, ReplyPreviewBean replyPreviewBean) {
        HashMap hashMap = new HashMap();
        Gson gson = new Gson();
        hashMap.put("messageReply", replyPreviewBean);
        v2TIMMessage.setCloudCustomData(gson.z(hashMap));
        ReplyMessageBean replyMessageBean = new ReplyMessageBean(replyPreviewBean);
        replyMessageBean.setCommonAttribute(v2TIMMessage);
        replyMessageBean.onProcessMessage(v2TIMMessage);
        return replyMessageBean;
    }
}
