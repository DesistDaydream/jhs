package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.d;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK})
/* loaded from: classes3.dex */
public class XGPushReceiver extends BroadcastReceiver {
    private Context a;

    public void a(Context context, Intent intent) {
        TLogger.d("XGPushReceiver", "ping from alarmManager");
        Util.getWakeCpu(context);
        d.a(XGVipPushService.a()).b((OnMqttCallback) null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context != null && intent != null) {
            this.a = context;
            final String action = intent.getAction();
            if (action == null) {
                return;
            }
            com.tencent.android.tpush.service.b.b(context.getApplicationContext());
            if (XGPushConfig.enableDebug) {
                TLogger.d("XGPushReceiver", "PushReceiver received " + action + " @@ " + context.getPackageName());
            }
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.XGPushReceiver.1
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    if (!i.h(context)) {
                        Process.killProcess(Process.myPid());
                    } else if (Constants.ACTION_INTERNAL_PUSH_MESSAGE.equals(action)) {
                        a.b(com.tencent.android.tpush.service.b.e());
                    } else if (Constants.ACTION_SDK_INSTALL.equals(action)) {
                    } else {
                        if (Constants.XG_PUSH_SERVICE_PING_ACTION.equals(action)) {
                            XGPushReceiver.this.a(context, intent);
                            return;
                        }
                        TLogger.d("XGPushReceiver", "start XGService");
                        com.tencent.android.tpush.service.b.a(context.getApplicationContext(), 3500L);
                        a.b(context.getApplicationContext());
                    }
                }
            });
            return;
        }
        Process.killProcess(Process.myPid());
    }
}
