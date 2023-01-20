package com.tencent.qcloud.tuikit.tuichat.util;

import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class TUIChatUtils {
    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, String str, int i2, String str2) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(str, i2, ErrorMessageConverter.convertIMError(i2, str2));
        }
    }

    public static void callbackOnProgress(IUIKitCallback iUIKitCallback, Object obj) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onProgress(obj);
        }
    }

    public static <T> void callbackOnSuccess(IUIKitCallback<T> iUIKitCallback, T t) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onSuccess(t);
        }
    }

    public static String getConversationIdByUserId(String str, boolean z) {
        String str2 = z ? "group_" : "c2c_";
        return str2 + str;
    }

    public static String getOriginImagePath(TUIMessageBean tUIMessageBean) {
        V2TIMMessage v2TIMMessage;
        V2TIMImageElem imageElem;
        String str = null;
        if (tUIMessageBean == null || (v2TIMMessage = tUIMessageBean.getV2TIMMessage()) == null || (imageElem = v2TIMMessage.getImageElem()) == null) {
            return null;
        }
        String localImagePath = ChatMessageParser.getLocalImagePath(tUIMessageBean);
        if (localImagePath == null) {
            Iterator<V2TIMImageElem.V2TIMImage> it = imageElem.getImageList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                V2TIMImageElem.V2TIMImage next = it.next();
                if (next.getType() == 0) {
                    str = next.getUUID();
                    break;
                }
            }
            String generateImagePath = ImageUtil.generateImagePath(str, 0);
            return new File(generateImagePath).exists() ? generateImagePath : localImagePath;
        }
        return localImagePath;
    }

    public static boolean isC2CChat(int i2) {
        return i2 == 1;
    }

    public static boolean isGroupChat(int i2) {
        return i2 == 2;
    }

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, int i2, String str) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(null, i2, ErrorMessageConverter.convertIMError(i2, str));
        }
    }
}
