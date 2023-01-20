package com.tencent.qcloud.tuikit.tuicontact.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;

/* loaded from: classes3.dex */
public class ContactUtils {
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

    public static String getLoginUser() {
        return V2TIMManager.getInstance().getLoginUser();
    }

    public static boolean isC2CChat(int i2) {
        return i2 == 1;
    }

    public static boolean isGroupChat(int i2) {
        return i2 == 2;
    }

    public static void startChatActivity(String str, int i2, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("chatId", str);
        bundle.putString(TUIConstants.TUIChat.CHAT_NAME, str2);
        bundle.putInt(TUIConstants.TUIChat.CHAT_TYPE, i2);
        if (isC2CChat(i2)) {
            TUICore.startActivity(TUIConstants.TUIChat.C2C_CHAT_ACTIVITY_NAME, bundle);
        } else if (isGroupChat(i2)) {
            bundle.putString(TUIConstants.TUIChat.GROUP_TYPE, str3);
            TUICore.startActivity(TUIConstants.TUIChat.GROUP_CHAT_ACTIVITY_NAME, bundle);
        }
    }

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, int i2, String str) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(null, i2, ErrorMessageConverter.convertIMError(i2, str));
        }
    }
}
