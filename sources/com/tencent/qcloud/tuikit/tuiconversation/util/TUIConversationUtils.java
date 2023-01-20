package com.tencent.qcloud.tuikit.tuiconversation.util;

import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;

/* loaded from: classes3.dex */
public class TUIConversationUtils {
    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, String str, int i2, String str2) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(str, i2, ErrorMessageConverter.convertIMError(i2, str2));
        }
    }

    public static <T> void callbackOnSuccess(IUIKitCallback<T> iUIKitCallback, T t) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onSuccess(t);
        }
    }

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, int i2, String str) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(null, i2, ErrorMessageConverter.convertIMError(i2, str));
        }
    }
}
