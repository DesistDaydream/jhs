package com.tencent.qcloud.tim.tuiofflinepush.OEMPush;

import android.content.Context;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;

/* loaded from: classes3.dex */
public class VIVOPushMessageReceiverImpl extends OpenClientPushMessageReceiver {
    private static final String TAG = VIVOPushMessageReceiverImpl.class.getSimpleName();
    private static String sExt = "";

    public static String getParams() {
        String str = sExt;
        sExt = "";
        return str;
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        String str = TAG;
        TUIOfflinePushLog.i(str, "onNotificationMessageClicked upsNotificationMessage " + uPSNotificationMessage.toString());
        sExt = uPSNotificationMessage.getParams().get("ext");
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
        String str2 = TAG;
        TUIOfflinePushLog.i(str2, "onReceiveRegId = " + str);
    }
}
