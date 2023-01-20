package com.tencent.qcloud.tim.tuiofflinepush.TPNSPush;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.msp.push.HeytapPushManager;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.qcloud.tim.tuiofflinepush.PrivateConstants;
import com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface;
import com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager;
import com.tencent.qcloud.tim.tuiofflinepush.UploadPushTokenHelper;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class TPNSPushSetting implements PushSettingInterface {
    private static final String TAG = "TPNSPushSetting";
    private Context mContext;

    private void prepareTPNSRegister() {
        TUIOfflinePushLog.i(TAG, "prepareTPNSRegister()");
        final Context context = this.mContext;
        XGPushConfig.enableDebug(context, false);
        XGPushConfig.setMiPushAppId(context, PrivateConstants.XM_PUSH_APPID);
        XGPushConfig.setMiPushAppKey(context, PrivateConstants.XM_PUSH_APPKEY);
        XGPushConfig.setMzPushAppId(context, "");
        XGPushConfig.setMzPushAppKey(context, "");
        XGPushConfig.setOppoPushAppId(context, PrivateConstants.OPPO_PUSH_APPKEY);
        XGPushConfig.setOppoPushAppKey(context, PrivateConstants.OPPO_PUSH_APPSECRET);
        XGPushConfig.enableOtherPush(context, true);
        XGPushConfig.setUseFcmFirst(context, false);
        XGPushManager.registerPush(context, new XGIOperateCallback() { // from class: com.tencent.qcloud.tim.tuiofflinepush.TPNSPush.TPNSPushSetting.4
            {
                TPNSPushSetting.this = this;
            }

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onFail(Object obj, int i2, String str) {
                String str2 = TPNSPushSetting.TAG;
                TUIOfflinePushLog.w(str2, "tpush register failed errCode: " + i2 + ", errMsg: " + str);
            }

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onSuccess(Object obj, int i2) {
                String str = TPNSPushSetting.TAG;
                TUIOfflinePushLog.w(str, "tpush register success token: " + obj);
                String str2 = (String) obj;
                if (!TextUtils.isEmpty(str2)) {
                    UploadPushTokenHelper.getInstance().getUploader().upload(str2);
                }
                if (XGPushConfig.isUsedOtherPush(context)) {
                    String otherPushToken = XGPushConfig.getOtherPushToken(context);
                    TUIOfflinePushManager.getInstance().setPushTokenToTIM(otherPushToken);
                    String str3 = TPNSPushSetting.TAG;
                    TUIOfflinePushLog.w(str3, "otherPushToken token: " + otherPushToken);
                }
                HeytapPushManager.requestNotificationPermission();
            }
        });
    }

    @Override // com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface
    public void bindUserID(String str) {
        XGPushManager.upsertAccounts(this.mContext, Arrays.asList(new XGPushManager.AccountInfo(XGPushManager.AccountType.UNKNOWN.getValue(), str)), new XGIOperateCallback() { // from class: com.tencent.qcloud.tim.tuiofflinepush.TPNSPush.TPNSPushSetting.1
            {
                TPNSPushSetting.this = this;
            }

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onFail(Object obj, int i2, String str2) {
                TUIOfflinePushLog.w(TPNSPushSetting.TAG, "upsertAccounts failed");
            }

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onSuccess(Object obj, int i2) {
                TUIOfflinePushLog.w(TPNSPushSetting.TAG, "upsertAccounts success");
            }
        });
    }

    @Override // com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface
    public void init(Context context) {
        this.mContext = context;
        XGPushConfig.enablePullUpOtherApp(context, false);
        prepareTPNSRegister();
    }

    @Override // com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface
    public void unBindUserID(Context context, String str) {
        TUIOfflinePushLog.d(TAG, "tpns 解绑");
        XGIOperateCallback xGIOperateCallback = new XGIOperateCallback() { // from class: com.tencent.qcloud.tim.tuiofflinepush.TPNSPush.TPNSPushSetting.2
            {
                TPNSPushSetting.this = this;
            }

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onFail(Object obj, int i2, String str2) {
                String str3 = TPNSPushSetting.TAG;
                TUIOfflinePushLog.w(str3, "onFail, data:" + obj + ", code:" + i2 + ", msg:" + str2);
            }

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onSuccess(Object obj, int i2) {
                String str2 = TPNSPushSetting.TAG;
                TUIOfflinePushLog.i(str2, "onSuccess, data:" + obj + ", flag:" + i2);
            }
        };
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(XGPushManager.AccountType.CUSTOM.getValue()));
        hashSet.add(Integer.valueOf(XGPushManager.AccountType.IMEI.getValue()));
        XGPushManager.delAccounts(context, hashSet, xGIOperateCallback);
    }

    @Override // com.tencent.qcloud.tim.tuiofflinepush.PushSettingInterface
    public void unInit(Context context) {
        TUIOfflinePushLog.d(TAG, "tpns 反注册");
        XGPushManager.unregisterPush(context, new XGIOperateCallback() { // from class: com.tencent.qcloud.tim.tuiofflinepush.TPNSPush.TPNSPushSetting.3
            {
                TPNSPushSetting.this = this;
            }

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onFail(Object obj, int i2, String str) {
                String str2 = TPNSPushSetting.TAG;
                TUIOfflinePushLog.d(str2, "反注册失败，错误码：" + i2 + ",错误信息：" + str);
            }

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onSuccess(Object obj, int i2) {
                TUIOfflinePushLog.d(TPNSPushSetting.TAG, "反注册成功");
            }
        });
    }
}
