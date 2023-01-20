package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageListGetOption;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class ImageVideoScanProvider {
    public static final int SCAN_MESSAGE_NUM = 10;
    public static final int SCAN_MESSAGE_REQUEST_NUM = 20;
    private static final String TAG = "ImageVideoScanProvider";

    public void MessageProvider() {
    }

    public void initMessageList(final String str, final boolean z, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        if (tUIMessageBean.getStatus() == 1) {
            return;
        }
        loadLocalMediaMessageList(str, z, 20, tUIMessageBean, 1, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanProvider.1
            {
                ImageVideoScanProvider.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ImageVideoScanProvider.TAG, i2, str3);
                String str4 = ImageVideoScanProvider.TAG;
                TUIChatLog.e(str4, "loadChatMessages getHistoryMessageList GET_MESSAGE_BACKWARD failed, code = " + i2 + ", desc = " + str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(final List<TUIMessageBean> list) {
                list.add(0, tUIMessageBean);
                ImageVideoScanProvider.this.loadLocalMediaMessageList(str, z, 20, tUIMessageBean, 0, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanProvider.1.1
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str2, int i2, String str3) {
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                        String str4 = ImageVideoScanProvider.TAG;
                        TUIChatLog.e(str4, "loadChatMessages getHistoryMessageList GET_MESSAGE_FORWARD failed, code = " + i2 + ", desc = " + str3);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list2) {
                        Collections.reverse(list2);
                        list2.addAll(list);
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, list2);
                    }
                });
            }
        });
    }

    public void loadLocalMediaMessageBackward(String str, boolean z, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        loadLocalMediaMessageList(str, z, 20, tUIMessageBean, 1, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanProvider.3
            {
                ImageVideoScanProvider.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ImageVideoScanProvider.TAG, i2, str3);
                String str4 = ImageVideoScanProvider.TAG;
                TUIChatLog.e(str4, "loadChatMessages loadLocalMediaMessageBackward failed, code = " + i2 + ", desc = " + str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
            }
        });
    }

    public void loadLocalMediaMessageForward(String str, boolean z, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        loadLocalMediaMessageList(str, z, 20, tUIMessageBean, 0, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanProvider.2
            {
                ImageVideoScanProvider.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ImageVideoScanProvider.TAG, i2, str3);
                String str4 = ImageVideoScanProvider.TAG;
                TUIChatLog.e(str4, "loadChatMessages loadLocalMediaMessageForward failed, code = " + i2 + ", desc = " + str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list) {
                Collections.reverse(list);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
            }
        });
    }

    public void loadLocalMediaMessageList(String str, boolean z, int i2, TUIMessageBean tUIMessageBean, final int i3, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
        v2TIMMessageListGetOption.setCount(i2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        arrayList.add(5);
        v2TIMMessageListGetOption.setMessageTypeList(arrayList);
        if (i3 == 0) {
            v2TIMMessageListGetOption.setGetType(3);
        } else if (i3 == 1) {
            v2TIMMessageListGetOption.setGetType(4);
        }
        if (tUIMessageBean != null) {
            v2TIMMessageListGetOption.setLastMsg(tUIMessageBean.getV2TIMMessage());
        }
        if (z) {
            v2TIMMessageListGetOption.setGroupID(str);
        } else {
            v2TIMMessageListGetOption.setUserID(str);
        }
        V2TIMManager.getMessageManager().getHistoryMessageList(v2TIMMessageListGetOption, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanProvider.4
            {
                ImageVideoScanProvider.this = this;
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i4, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ImageVideoScanProvider.TAG, i4, str2);
                String str3 = ImageVideoScanProvider.TAG;
                TUIChatLog.e(str3, "loadChatMessages getHistoryMessageList optionBackward failed, code = " + i4 + ", desc = " + str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list) {
                if (list.isEmpty()) {
                    TUIChatLog.d(ImageVideoScanProvider.TAG, "getHistoryMessageList is null");
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, new ArrayList());
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (V2TIMMessage v2TIMMessage : list) {
                    String str2 = ImageVideoScanProvider.TAG;
                    TUIChatLog.d(str2, "loadLocalMediaMessageList getType = " + i3 + "timMessage seq = " + v2TIMMessage.getSeq());
                    int status = v2TIMMessage.getStatus();
                    if (status != 4 && status != 6) {
                        arrayList2.add(v2TIMMessage);
                    }
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(arrayList2));
            }
        });
    }
}
