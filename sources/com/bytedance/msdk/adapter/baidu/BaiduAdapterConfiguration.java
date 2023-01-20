package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import java.util.Map;

/* loaded from: classes.dex */
public class BaiduAdapterConfiguration extends TTBaseAdapterConfiguration {
    private GMPrivacyConfig b;

    private void b() {
        GMPrivacyConfig gMPrivacyConfig = this.b;
        boolean z = false;
        MobadsPermissionSettings.setPermissionReadDeviceID(gMPrivacyConfig == null || gMPrivacyConfig.isCanUsePhoneState());
        GMPrivacyConfig gMPrivacyConfig2 = this.b;
        MobadsPermissionSettings.setPermissionLocation(gMPrivacyConfig2 == null || gMPrivacyConfig2.isCanUseLocation());
        GMPrivacyConfig gMPrivacyConfig3 = this.b;
        MobadsPermissionSettings.setPermissionStorage(gMPrivacyConfig3 == null || gMPrivacyConfig3.isCanUseWriteExternal());
        GMPrivacyConfig gMPrivacyConfig4 = this.b;
        MobadsPermissionSettings.setPermissionAppList(gMPrivacyConfig4 == null || gMPrivacyConfig4.appList());
        GMPrivacyConfig gMPrivacyConfig5 = this.b;
        if (gMPrivacyConfig5 != null && gMPrivacyConfig5.isLimitPersonalAds()) {
            z = true;
        }
        MobadsPermissionSettings.setLimitPersonalAds(z);
    }

    private boolean c(Context context, String str, boolean z) {
        if (context != null && str != null) {
            try {
                Logger.i("TTMediationSDK_SDK_Init", "init Baidu SDK start...... appId = " + str + " hettps = " + z);
                new BDAdConfig.Builder().setAppsid(str).setHttps(z).build(context).init();
                b();
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdNetworkName() {
        return "baidu";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdapterVersion() {
        return "9.24.1";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public Map<String, Object> getBiddingTokenMap(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getGroMoreSdkVersion() {
        return "3.7.0";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getNetworkSdkVersion() {
        try {
            return AdSettings.getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.config.IGMInitAdn
    public void initAdn(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull IGMInitAdnResult iGMInitAdnResult) {
        synchronized (BaiduAdapterConfiguration.class) {
            if (!isInitedSuccess() && map != null && !map.isEmpty()) {
                String str = (String) map.get("app_id");
                Boolean bool = (Boolean) map.get(TTBaseAdapterConfiguration.BAIDU_HTTPS);
                boolean c2 = c(context, str, bool != null ? bool.booleanValue() : false);
                if (iGMInitAdnResult != null) {
                    if (c2) {
                        setInitedSuccess(true);
                        iGMInitAdnResult.success();
                    } else {
                        iGMInitAdnResult.fail(new AdError("baidu init fail"));
                    }
                }
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public boolean isNewInitFunction() {
        return true;
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setPrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
        this.b = gMPrivacyConfig;
        b();
    }
}
