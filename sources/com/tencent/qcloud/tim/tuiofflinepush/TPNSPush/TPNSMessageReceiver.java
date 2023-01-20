package com.tencent.qcloud.tim.tuiofflinepush.TPNSPush;

import android.content.Context;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;
import com.tencent.qcloud.tim.tuiofflinepush.PushSetting;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;

/* loaded from: classes3.dex */
public class TPNSMessageReceiver extends XGPushBaseReceiver {
    public static final String LogTag = "TPNSMessageReceiver";
    public static final String TEST_ACTION = "com.qq.xgdemo.activity.TEST_ACTION";
    public static final String UPDATE_LISTVIEW_ACTION = "com.qq.xgdemo.activity.UPDATE_LISTVIEW";

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onDeleteAccountResult(Context context, int i2, String str) {
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onDeleteAttributeResult(Context context, int i2, String str) {
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onDeleteTagResult(Context context, int i2, String str) {
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onNotificationClickedResult(Context context, XGPushClickedResult xGPushClickedResult) {
        if (context == null || xGPushClickedResult == null || !PushSetting.isTPNSChannel) {
            return;
        }
        if (xGPushClickedResult.getActionType() == NotificationAction.clicked.getType()) {
            TUIOfflinePushLog.d(LogTag, "通知被打开 :" + xGPushClickedResult);
        } else if (xGPushClickedResult.getActionType() == NotificationAction.delete.getType()) {
            TUIOfflinePushLog.d(LogTag, "通知被清除 :" + xGPushClickedResult);
        }
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onNotificationShowedResult(Context context, XGPushShowedResult xGPushShowedResult) {
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onQueryTagsResult(Context context, int i2, String str, String str2) {
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onRegisterResult(Context context, int i2, XGPushRegisterResult xGPushRegisterResult) {
        String str;
        if (context == null || xGPushRegisterResult == null || !PushSetting.isTPNSChannel) {
            return;
        }
        if (i2 == 0) {
            str = "注册成功1. token：" + xGPushRegisterResult.getToken();
        } else {
            str = xGPushRegisterResult + "注册失败，错误码：" + i2;
        }
        TUIOfflinePushLog.d(LogTag, str);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onSetAccountResult(Context context, int i2, String str) {
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onSetAttributeResult(Context context, int i2, String str) {
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onSetTagResult(Context context, int i2, String str) {
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onTextMessage(Context context, XGPushTextMessage xGPushTextMessage) {
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onUnregisterResult(Context context, int i2) {
        String str;
        if (context == null) {
            return;
        }
        if (i2 == 0) {
            str = "反注册成功";
        } else {
            str = "反注册失败" + i2;
        }
        TUIOfflinePushLog.d(LogTag, str);
    }
}
