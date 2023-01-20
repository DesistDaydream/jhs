package com.bytedance.msdk.api.v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.z;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class GMMediationAdSdk {
    private static final int a = 31;

    @Deprecated
    private static GMCustomAdapterConfiguration a(String str) {
        return a.a(str);
    }

    @Deprecated
    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().g(str);
    }

    @Deprecated
    private static void c() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(d.R().b("if_test"));
    }

    public static boolean configLoadSuccess() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().y();
    }

    @Deprecated
    private static void d(int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(i2);
    }

    public static String getAppId() {
        return b.I().b();
    }

    public static String getAppName() {
        return b.I().i();
    }

    public static Map<String, Object> getGMSDKExtraInfo() {
        return b.I().g();
    }

    public static String getPangleData() {
        return b.I().k();
    }

    public static Map<String, String> getPangleExtraData() {
        return b.I().d();
    }

    public static boolean getPanglePaid() {
        return b.I().C();
    }

    public static String getSdkVersion() {
        return "3.7.0.2";
    }

    public static String getValueFromPPeInfo(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() == null ? "" : c0.a("tt_mediation_ppe_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a(str, "");
    }

    public static String getZbh(Context context) {
        return z.a();
    }

    @Deprecated
    public static void initUnityForBanner(Activity activity) {
    }

    public static void initialize(@NonNull Context context, @NonNull GMAdConfig gMAdConfig) {
        String str;
        if (context == null) {
            str = "GMMediationAdSdk初始化失败，context不能是null";
        } else if (gMAdConfig != null) {
            b.I().a(gMAdConfig.getAppId());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().n();
            if (gMAdConfig.isDebug()) {
                Logger.openDebugMode();
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a.d();
            }
            l.a(context);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d.a(gMAdConfig, context.getApplicationContext());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().j();
            return;
        } else {
            str = "GMMediationAdSdk初始化失败，TTAdConfig不能是null";
        }
        Log.d("TTMediationSDK_SDK_Init", str);
    }

    public static boolean isAdapterVersionFit(String str, String str2) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.b.b(str, str2);
    }

    public static boolean isAdnVersionFit(String str, String str2) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.b.c(str, str2);
    }

    public static boolean isTestDemo() {
        return b.I().G();
    }

    public static void preload(final Activity activity, final List<GMPreloadRequestInfo> list, final int i2, final int i3) {
        registerConfigCallback(new GMSettingConfigCallback() { // from class: com.bytedance.msdk.api.v2.GMMediationAdSdk.1
            @Override // com.bytedance.msdk.api.v2.GMSettingConfigCallback
            public void configLoad() {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(activity, list, i2, i3);
            }
        });
    }

    public static void register(Object obj, Object obj2) {
        b.I().a(obj, obj2);
    }

    public static void registerConfigCallback(GMSettingConfigCallback gMSettingConfigCallback) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(gMSettingConfigCallback);
    }

    public static void requestPermissionIfNecessary(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        if (context != null) {
            c.a(context, intent, null);
        }
    }

    public static void requestPermissionIfNecessary(Context context, int[] iArr) {
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra(TTDelegateActivity.INTENT_PERMISSIONS, iArr);
        if (context != null) {
            c.a(context, intent, null);
        }
    }

    public static void setPangleData(String str) {
        b.I().d(str);
    }

    public static void setPulisherDid(String str) {
        Logger.d("TTMediationSDK", "app运行中setPulisherDid: " + str);
        b.I().f(str);
    }

    public static void setThemeStatus(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TTBaseAdapterConfiguration.TT_MSDK_THEME_STATUS, Integer.valueOf(i2));
        Map<String, ITTAdapterConfiguration> e2 = a.e();
        if (e2 == null || e2.size() == 0) {
            return;
        }
        for (ITTAdapterConfiguration iTTAdapterConfiguration : e2.values()) {
            if (iTTAdapterConfiguration != null) {
                iTTAdapterConfiguration.setThemeStatus(hashMap);
            }
        }
    }

    public static void setUserInfoForSegment(GMConfigUserInfoForSegment gMConfigUserInfoForSegment) {
        b.I().a(gMConfigUserInfoForSegment, false);
    }

    public static int showOpenOrInstallAppDialog(GMAppDialogClickListener gMAppDialogClickListener) {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        Map<String, ITTAdapterConfiguration> e2 = a.e();
        if (e2 == null || e2.size() == 0 || (iTTAdapterConfiguration = e2.get(DefaultAdapterClasses.getClassNameByAdnName("gdt"))) == null) {
            return 0;
        }
        return iTTAdapterConfiguration.showOpenOrInstallAppDialog(gMAppDialogClickListener);
    }

    public static void unregisterConfigCallback(GMSettingConfigCallback gMSettingConfigCallback) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().b(gMSettingConfigCallback);
    }

    public static void updatePangleConfig(GMAdConfig gMAdConfig) {
        if (gMAdConfig == null) {
            return;
        }
        if (!TextUtils.isEmpty(gMAdConfig.getGMPangleOption().getData())) {
            b.I().d(gMAdConfig.getGMPangleOption().getData());
        }
        if (!TextUtils.isEmpty(gMAdConfig.getGMPangleOption().getKeywords())) {
            b.I().e(gMAdConfig.getGMPangleOption().getKeywords());
        }
        b.I().e(gMAdConfig.getGMPangleOption().getExtraData());
    }

    public static void updatePanglePaid(boolean z) {
        b.I().f(z);
    }

    public static void updatePrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d.a(gMPrivacyConfig);
    }
}
