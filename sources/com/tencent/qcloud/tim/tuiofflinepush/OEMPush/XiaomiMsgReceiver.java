package com.tencent.qcloud.tim.tuiofflinepush.OEMPush;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qcloud.tim.tuiofflinepush.PushSetting;
import com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;

/* loaded from: classes3.dex */
public class XiaomiMsgReceiver extends PushMessageReceiver {
    private static final String TAG = XiaomiMsgReceiver.class.getSimpleName();
    private String mRegId;

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onCommandResult(context, miPushCommandMessage);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        TUIOfflinePushLog.d(TAG, "onNotificationMessageArrived is called. ");
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        String str = TAG;
        TUIOfflinePushLog.d(str, "onNotificationMessageClicked miPushMessage " + miPushMessage.toString());
        if (!PushSetting.isTPNSChannel && TextUtils.isEmpty(miPushMessage.getExtra().get("ext"))) {
            TUIOfflinePushLog.w(str, "onNotificationMessageClicked: no extra data found");
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        TUIOfflinePushLog.d(TAG, "onReceivePassThroughMessage is called. ");
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String str = TAG;
        TUIOfflinePushLog.d(str, "onReceiveRegisterResult is called. " + miPushCommandMessage.toString());
        String command = miPushCommandMessage.getCommand();
        List<String> commandArguments = miPushCommandMessage.getCommandArguments();
        String str2 = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        TUIOfflinePushLog.d(str, "cmd: " + command + " | arg: " + str2 + " | result: " + miPushCommandMessage.getResultCode() + " | reason: " + miPushCommandMessage.getReason());
        if (MiPushClient.COMMAND_REGISTER.equals(command) && miPushCommandMessage.getResultCode() == 0) {
            this.mRegId = str2;
        }
        TUIOfflinePushLog.d(str, "regId: " + this.mRegId);
        if (PushSetting.isTPNSChannel) {
            return;
        }
        TUIOfflinePushManager.getInstance().setPushTokenToTIM(this.mRegId);
    }
}
