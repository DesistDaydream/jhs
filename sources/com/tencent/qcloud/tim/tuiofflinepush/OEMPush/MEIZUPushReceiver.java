package com.tencent.qcloud.tim.tuiofflinepush.OEMPush;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.tencent.qcloud.tim.tuiofflinepush.PushSetting;
import com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;

/* loaded from: classes3.dex */
public class MEIZUPushReceiver extends MzPushMessageReceiver {
    private static final String TAG = MEIZUPushReceiver.class.getSimpleName();

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onMessage(Context context, String str) {
        String str2 = TAG;
        TUIOfflinePushLog.i(str2, "onMessage method1 msg = " + str);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
        super.onNotificationArrived(context, mzPushMessage);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
        String str = TAG;
        TUIOfflinePushLog.i(str, "onNotificationClicked mzPushMessage " + mzPushMessage.toString());
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationDeleted(Context context, MzPushMessage mzPushMessage) {
        super.onNotificationDeleted(context, mzPushMessage);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotifyMessageArrived(Context context, String str) {
        super.onNotifyMessageArrived(context, str);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onRegister(Context context, String str) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        String str = TAG;
        TUIOfflinePushLog.i(str, "onRegisterStatus token = " + registerStatus.getPushId());
        if (PushSetting.isTPNSChannel) {
            return;
        }
        TUIOfflinePushManager.getInstance().setPushTokenToTIM(registerStatus.getPushId());
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUnRegister(Context context, boolean z) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        super.onUpdateNotificationBuilder(pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onMessage(Context context, String str, String str2) {
        String str3 = TAG;
        TUIOfflinePushLog.i(str3, "onMessage method2 msg = " + str + ", platformExtra = " + str2);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onMessage(Context context, Intent intent) {
        String bundle = intent.getExtras().toString();
        String str = TAG;
        TUIOfflinePushLog.i(str, "flyme3 onMessage = " + bundle);
    }
}
