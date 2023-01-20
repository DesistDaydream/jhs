package com.tencent.qcloud.tim.tuiofflinepush.OEMPush;

import android.content.Context;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.tencent.qcloud.tim.tuiofflinepush.PushSetting;
import com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager;
import com.tencent.qcloud.tim.tuiofflinepush.utils.BrandUtil;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;

/* loaded from: classes3.dex */
public class HUAWEIHmsMessageService extends HmsMessageService {
    private static final String TAG = HUAWEIHmsMessageService.class.getSimpleName();

    public static void updateBadge(Context context, int i2) {
        if (BrandUtil.isBrandHuawei()) {
            String str = TAG;
            TUIOfflinePushLog.i(str, "huawei badge = " + i2);
            TUIOfflinePushManager.getInstance().updateBadge(context, i2);
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageDelivered(String str, Exception exc) {
        String str2 = TAG;
        TUIOfflinePushLog.i(str2, "onMessageDelivered msgId=" + str);
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str = TAG;
        TUIOfflinePushLog.i(str, "onMessageReceived message=" + remoteMessage);
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageSent(String str) {
        String str2 = TAG;
        TUIOfflinePushLog.i(str2, "onMessageSent msgId=" + str);
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        String str2 = TAG;
        TUIOfflinePushLog.i(str2, "onNewToken token=" + str);
        if (PushSetting.isTPNSChannel) {
            return;
        }
        TUIOfflinePushManager.getInstance().setPushTokenToTIM(str);
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onSendError(String str, Exception exc) {
        String str2 = TAG;
        TUIOfflinePushLog.i(str2, "onSendError msgId=" + str);
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onTokenError(Exception exc) {
        String str = TAG;
        TUIOfflinePushLog.i(str, "onTokenError exception=" + exc);
    }
}
