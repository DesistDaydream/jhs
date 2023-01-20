package com.tencent.qcloud.tim.tuiofflinepush.OEMPush;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.heytap.msp.push.HeytapPushManager;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.tencent.qcloud.tim.tuiofflinepush.PrivateConstants;
import com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface;
import com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager;
import com.tencent.qcloud.tim.tuiofflinepush.utils.BrandUtil;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import e.j.a.b.j.e;
import e.j.d.f.a;
import e.k.b.a.g;
import e.k.b.a.k;

/* loaded from: classes3.dex */
public class OEMPushSetting implements PushSettingInterface {
    private static final String TAG = "OEMPushSetting";

    @Override // com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface
    public void bindUserID(String str) {
    }

    @Override // com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface
    public void init(final Context context) {
        if (BrandUtil.isBrandXiaoMi()) {
            MiPushClient.registerPush(context, PrivateConstants.XM_PUSH_APPID, PrivateConstants.XM_PUSH_APPKEY);
        } else if (BrandUtil.isBrandHuawei()) {
            HmsMessaging.getInstance(context).turnOnPush().e(new g<Void>() { // from class: com.tencent.qcloud.tim.tuiofflinepush.OEMPush.OEMPushSetting.1
                {
                    OEMPushSetting.this = this;
                }

                @Override // e.k.b.a.g
                public void onComplete(k<Void> kVar) {
                    if (kVar.v()) {
                        TUIOfflinePushLog.i(OEMPushSetting.TAG, "huawei turnOnPush Complete");
                        return;
                    }
                    String str = OEMPushSetting.TAG;
                    TUIOfflinePushLog.e(str, "huawei turnOnPush failed: ret=" + kVar.q().getMessage());
                }
            });
            new Thread() { // from class: com.tencent.qcloud.tim.tuiofflinepush.OEMPush.OEMPushSetting.2
                {
                    OEMPushSetting.this = this;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        String token = HmsInstanceId.getInstance(context).getToken(AGConnectServicesConfig.fromContext(context).getString("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
                        String str = OEMPushSetting.TAG;
                        TUIOfflinePushLog.i(str, "huawei get token:" + token);
                        if (TextUtils.isEmpty(token)) {
                            return;
                        }
                        TUIOfflinePushManager.getInstance().setPushTokenToTIM(token);
                    } catch (ApiException e2) {
                        String str2 = OEMPushSetting.TAG;
                        TUIOfflinePushLog.e(str2, "huawei get token failed, " + e2);
                    }
                }
            }.start();
        } else if (MzSystemUtils.isBrandMeizu(context)) {
            PushManager.register(context, "", "");
        } else if (BrandUtil.isBrandVivo()) {
            PushClient.getInstance(context).initialize();
            String str = TAG;
            TUIOfflinePushLog.i(str, "vivo support push: " + PushClient.getInstance(context).isSupport());
            PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: com.tencent.qcloud.tim.tuiofflinepush.OEMPush.OEMPushSetting.3
                {
                    OEMPushSetting.this = this;
                }

                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i2) {
                    if (i2 == 0) {
                        String regId = PushClient.getInstance(context).getRegId();
                        String str2 = OEMPushSetting.TAG;
                        TUIOfflinePushLog.i(str2, "vivopush open vivo push success regId = " + regId);
                        TUIOfflinePushManager.getInstance().setPushTokenToTIM(regId);
                        return;
                    }
                    String str3 = OEMPushSetting.TAG;
                    TUIOfflinePushLog.i(str3, "vivopush open vivo push fail state = " + i2);
                }
            });
        } else if (BrandUtil.isBrandOppo()) {
            HeytapPushManager.init(context, false);
            if (HeytapPushManager.isSupportPush(context)) {
                OPPOPushImpl oPPOPushImpl = new OPPOPushImpl();
                oPPOPushImpl.createNotificationChannel(context);
                HeytapPushManager.register(context, PrivateConstants.OPPO_PUSH_APPKEY, PrivateConstants.OPPO_PUSH_APPSECRET, oPPOPushImpl);
                HeytapPushManager.requestNotificationPermission();
            }
        } else if (BrandUtil.isGoogleServiceSupport()) {
            FirebaseInstanceId.e().f().e(new e<a>() { // from class: com.tencent.qcloud.tim.tuiofflinepush.OEMPush.OEMPushSetting.4
                {
                    OEMPushSetting.this = this;
                }

                @Override // e.j.a.b.j.e
                public void onComplete(e.j.a.b.j.k<a> kVar) {
                    if (!kVar.v()) {
                        String str2 = OEMPushSetting.TAG;
                        TUIOfflinePushLog.w(str2, "getInstanceId failed exception = " + kVar.q());
                        return;
                    }
                    String token = kVar.r().getToken();
                    String str3 = OEMPushSetting.TAG;
                    TUIOfflinePushLog.i(str3, "google fcm getToken = " + token);
                    TUIOfflinePushManager.getInstance().setPushTokenToTIM(token);
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface
    public void unBindUserID(Context context, String str) {
    }

    @Override // com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface
    public void unInit(Context context) {
    }
}
