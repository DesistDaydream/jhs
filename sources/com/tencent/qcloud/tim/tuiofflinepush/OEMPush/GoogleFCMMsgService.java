package com.tencent.qcloud.tim.tuiofflinepush.OEMPush;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.tencent.qcloud.tim.tuiofflinepush.PushSetting;
import com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;

/* loaded from: classes3.dex */
public class GoogleFCMMsgService extends FirebaseMessagingService {
    private final String TAG = GoogleFCMMsgService.class.getSimpleName();

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        String str2 = this.TAG;
        TUIOfflinePushLog.i(str2, "google fcm onNewToken : " + str);
        if (PushSetting.isTPNSChannel) {
            return;
        }
        TUIOfflinePushManager.getInstance().setPushTokenToTIM(str);
    }
}
