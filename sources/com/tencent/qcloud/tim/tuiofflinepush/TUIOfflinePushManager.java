package com.tencent.qcloud.tim.tuiofflinepush;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMOfflinePushConfig;
import com.tencent.qcloud.tim.tuiofflinepush.utils.BrandUtil;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;

/* loaded from: classes3.dex */
public class TUIOfflinePushManager {
    public static final String TAG = "TUIOfflinePushManager";
    private static TUIOfflinePushManager instance;
    private boolean isInternationalFlavor = false;
    private PushSetting pushSetting = new PushSetting();
    private String pushToken;

    public static TUIOfflinePushManager getInstance() {
        if (instance == null) {
            instance = new TUIOfflinePushManager();
        }
        return instance;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public void initPush(Context context, String str) {
        if (this.pushSetting == null) {
            this.pushSetting = new PushSetting();
        }
        this.pushSetting.initPush(context);
        this.pushSetting.bindUserID(str);
    }

    public void registerPush(Context context, String str) {
        initPush(context, str);
    }

    public void setInternationalFlavor(boolean z) {
        this.isInternationalFlavor = z;
    }

    public void setPushToken(String str) {
        this.pushToken = str;
    }

    public void setPushTokenToTIM(String str) {
        setPushToken(str);
        if (TextUtils.isEmpty(this.pushToken)) {
            TUIOfflinePushLog.i(TAG, "setPushTokenToTIM third token is empty");
            return;
        }
        long j2 = 0;
        if (this.isInternationalFlavor) {
            TUIOfflinePushLog.i(TAG, "flavor international");
            if (!BrandUtil.isBrandXiaoMi() && !BrandUtil.isBrandHuawei() && !BrandUtil.isBrandMeizu() && !BrandUtil.isBrandOppo() && !BrandUtil.isBrandVivo() && !BrandUtil.isGoogleServiceSupport()) {
                return;
            }
        } else {
            TUIOfflinePushLog.i(TAG, "flavor local");
            if (BrandUtil.isBrandXiaoMi()) {
                j2 = PrivateConstants.XM_PUSH_BUZID;
            } else if (BrandUtil.isBrandHuawei()) {
                j2 = PrivateConstants.HW_PUSH_BUZID;
            } else if (!BrandUtil.isBrandMeizu()) {
                if (BrandUtil.isBrandOppo()) {
                    j2 = PrivateConstants.OPPO_PUSH_BUZID;
                } else if (BrandUtil.isBrandVivo()) {
                    j2 = PrivateConstants.VIVO_PUSH_BUZID;
                } else if (!BrandUtil.isGoogleServiceSupport()) {
                    return;
                }
            }
        }
        V2TIMOfflinePushConfig v2TIMOfflinePushConfig = new V2TIMOfflinePushConfig(j2, this.pushToken, false);
        String str2 = TAG;
        TUIOfflinePushLog.d(str2, "setOfflinePushConfig businessID = " + j2 + " pushToken = " + this.pushToken);
        V2TIMManager.getOfflinePushManager().setOfflinePushConfig(v2TIMOfflinePushConfig, new V2TIMCallback() { // from class: com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager.1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str3) {
                String str4 = TUIOfflinePushManager.TAG;
                TUIOfflinePushLog.d(str4, "setOfflinePushToken err code = " + i2 + " desc = " + ErrorMessageConverter.convertIMError(i2, str3));
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIOfflinePushLog.d(TUIOfflinePushManager.TAG, "setOfflinePushToken success");
            }
        });
    }

    public void unInitPush(Context context, String str) {
        if (this.pushSetting == null) {
            this.pushSetting = new PushSetting();
        }
        this.pushSetting.unBindUserID(context, str);
        this.pushSetting.unInitPush(context);
    }

    public void unRegisterPush(Context context, String str) {
        unInitPush(context, str);
    }

    public void updateBadge(Context context, int i2) {
        if (BrandUtil.isBrandHuawei()) {
            String str = TAG;
            TUIOfflinePushLog.i(str, "huawei badge = " + i2);
            try {
                Bundle bundle = new Bundle();
                bundle.putString("package", context.getPackageName());
                bundle.putString("class", PrivateConstants.BADGE_CLASS_NAME);
                bundle.putInt("badgenumber", i2);
                context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
            } catch (Exception e2) {
                String str2 = TAG;
                TUIOfflinePushLog.w(str2, "huawei badge exception: " + e2.getLocalizedMessage());
            }
        }
    }
}
