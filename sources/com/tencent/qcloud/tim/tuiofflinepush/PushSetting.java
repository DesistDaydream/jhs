package com.tencent.qcloud.tim.tuiofflinepush;

import android.content.Context;
import com.tencent.qcloud.tim.tuiofflinepush.OEMPush.OEMPushSetting;
import com.tencent.qcloud.tim.tuiofflinepush.TPNSPush.TPNSPushSetting;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;

/* loaded from: classes3.dex */
public class PushSetting {
    public static boolean isTPNSChannel = true;

    public void bindUserID(String str) {
        if (isTPNSChannel) {
            new TPNSPushSetting().bindUserID(str);
        }
    }

    public void initPush(Context context) {
        isTPNSChannel = context.getSharedPreferences("TUIKIT_DEMO_SETTINGS", 0).getBoolean("isTPNSChannel", true);
        TUIOfflinePushLog.i("PushSetting", "initPush isTPNSChannel = " + isTPNSChannel);
        if (isTPNSChannel) {
            new TPNSPushSetting().init(context);
        } else {
            new OEMPushSetting().init(context);
        }
    }

    public void unBindUserID(Context context, String str) {
        if (isTPNSChannel) {
            new TPNSPushSetting().unBindUserID(context, str);
        }
    }

    public void unInitPush(Context context) {
        if (isTPNSChannel) {
            new TPNSPushSetting().unInit(context);
        }
    }
}
