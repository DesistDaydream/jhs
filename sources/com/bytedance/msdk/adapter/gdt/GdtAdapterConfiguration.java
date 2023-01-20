package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.GMAppDialogClickListener;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GdtAdapterConfiguration extends TTBaseAdapterConfiguration {
    private GMPrivacyConfig b = new GMPrivacyConfig();

    private boolean b(Context context, String str) {
        Logger.i("TTMediationSDK_SDK_Init", "init GDT SDK start...... appId = " + str);
        if (context != null && str != null) {
            try {
                GDTAdSdk.init(context, str);
                GMPrivacyConfig gMPrivacyConfig = this.b;
                GlobalSetting.setPersonalizedState((gMPrivacyConfig == null || !gMPrivacyConfig.isLimitPersonalAds()) ? 0 : 1);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdNetworkName() {
        return "gdt";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdapterVersion() {
        return "4.484.1354.1";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public Map<String, Object> getBiddingTokenMap(Context context, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        String buyerId = GDTAdSdk.getGDTAdManger().getBuyerId(null);
        String sDKInfo = GDTAdSdk.getGDTAdManger().getSDKInfo((String) map.get("slot_id"));
        hashMap.put("buyerId", buyerId);
        hashMap.put("sdkInfo", sDKInfo);
        return hashMap;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getGroMoreSdkVersion() {
        return "3.7.0";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getNetworkSdkVersion() {
        try {
            return SDKStatus.getIntegrationSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.config.IGMInitAdn
    public void initAdn(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull IGMInitAdnResult iGMInitAdnResult) {
        synchronized (GdtAdapterConfiguration.class) {
            if (!isInitedSuccess() && map != null && !map.isEmpty()) {
                boolean b = b(context, (String) map.get("app_id"));
                if (iGMInitAdnResult != null) {
                    if (b) {
                        setInitedSuccess(true);
                        iGMInitAdnResult.success();
                    } else {
                        iGMInitAdnResult.fail(new AdError("gdt init fail"));
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
        GlobalSetting.setPersonalizedState((gMPrivacyConfig == null || !gMPrivacyConfig.isLimitPersonalAds()) ? 0 : 1);
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public int showOpenOrInstallAppDialog(final GMAppDialogClickListener gMAppDialogClickListener) {
        try {
            return GDTAdSdk.getGDTAdManger().showOpenOrInstallAppDialog(new GDTAppDialogClickListener(this) { // from class: com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration.1
                @Override // com.qq.e.ads.dfa.GDTAppDialogClickListener
                public void onButtonClick(int i2) {
                    GMAppDialogClickListener gMAppDialogClickListener2 = gMAppDialogClickListener;
                    if (gMAppDialogClickListener2 != null) {
                        gMAppDialogClickListener2.onButtonClick(i2);
                    }
                }
            });
        } catch (Exception unused) {
            return 0;
        }
    }
}
