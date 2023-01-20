package com.tencent.qcloud.tim.tuiofflinepush.OEMPush;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.tencent.qcloud.tim.tuiofflinepush.PushSetting;
import com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;

/* loaded from: classes3.dex */
public class OPPOPushImpl implements ICallBackResultService {
    private static final String TAG = "OPPOPushImpl";

    public void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("tuikit", "oppotest", 3);
            notificationChannel.setDescription("this is opptest");
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onError(int i2, String str) {
        String str2 = TAG;
        TUIOfflinePushLog.i(str2, "onError responseCode: " + i2 + " reason: " + str);
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetNotificationStatus(int i2, int i3) {
        String str = TAG;
        TUIOfflinePushLog.i(str, "onGetNotificationStatus responseCode: " + i2 + " status: " + i3);
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetPushStatus(int i2, int i3) {
        String str = TAG;
        TUIOfflinePushLog.i(str, "onGetPushStatus responseCode: " + i2 + " status: " + i3);
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onRegister(int i2, String str) {
        String str2 = TAG;
        TUIOfflinePushLog.i(str2, "onRegister responseCode: " + i2 + " registerID: " + str);
        if (PushSetting.isTPNSChannel) {
            return;
        }
        TUIOfflinePushManager.getInstance().setPushTokenToTIM(str);
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onSetPushTime(int i2, String str) {
        String str2 = TAG;
        TUIOfflinePushLog.i(str2, "onSetPushTime responseCode: " + i2 + " s: " + str);
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onUnRegister(int i2) {
        String str = TAG;
        TUIOfflinePushLog.i(str, "onUnRegister responseCode: " + i2);
    }
}
