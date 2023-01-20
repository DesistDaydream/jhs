package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.d;
import com.heytap.mcssdk.utils.f;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;

/* loaded from: classes2.dex */
public class a implements c {
    public void a(com.heytap.mcssdk.c.b bVar, PushService pushService) {
        String str;
        if (bVar == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (pushService == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else if (pushService.getPushCallback() != null) {
            int e2 = bVar.e();
            if (e2 == 12287) {
                ICallBackResultService pushCallback = pushService.getPushCallback();
                if (pushCallback != null) {
                    pushCallback.onError(bVar.g(), bVar.f());
                    return;
                }
                return;
            } else if (e2 == 12298) {
                pushService.getPushCallback().onSetPushTime(bVar.g(), bVar.f());
                return;
            } else if (e2 == 12306) {
                pushService.getPushCallback().onGetPushStatus(bVar.g(), Utils.parseInt(bVar.f()));
                return;
            } else if (e2 == 12309) {
                pushService.getPushCallback().onGetNotificationStatus(bVar.g(), Utils.parseInt(bVar.f()));
                return;
            } else if (e2 == 12289) {
                if (bVar.g() == 0) {
                    pushService.setRegisterID(bVar.f());
                }
                pushService.getPushCallback().onRegister(bVar.g(), bVar.f());
                return;
            } else if (e2 == 12290) {
                pushService.getPushCallback().onUnRegister(bVar.g());
                return;
            } else {
                switch (e2) {
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                        ISetAppNotificationCallBackService pushSetAppNotificationCallBack = pushService.getPushSetAppNotificationCallBack();
                        if (pushSetAppNotificationCallBack != null) {
                            pushSetAppNotificationCallBack.onSetAppNotificationSwitch(bVar.g());
                            return;
                        }
                        return;
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                        int i2 = 0;
                        try {
                            i2 = Integer.parseInt(bVar.f());
                        } catch (Exception unused) {
                        }
                        IGetAppNotificationCallBackService pushGetAppNotificationCallBack = pushService.getPushGetAppNotificationCallBack();
                        if (pushGetAppNotificationCallBack != null) {
                            pushGetAppNotificationCallBack.onGetAppNotificationSwitch(bVar.g(), i2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } else {
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        }
        d.e(str);
    }

    @Override // com.heytap.mcssdk.e.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            final com.heytap.mcssdk.c.b bVar = (com.heytap.mcssdk.c.b) baseMode;
            d.b("mcssdk-CallBackResultProcessor:" + bVar.toString());
            f.b(new Runnable() { // from class: com.heytap.mcssdk.e.a.1
                {
                    a.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(bVar, PushService.getInstance());
                }
            });
        }
    }
}
