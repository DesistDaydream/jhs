package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTCodeGroupRit;
import com.bytedance.sdk.openadsdk.api.a;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import java.util.Map;

/* loaded from: classes.dex */
public final class TTAdSdk {
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    private static final TTInitializer a = new g();

    /* loaded from: classes.dex */
    public interface InitCallback {
        void fail(int i2, String str);

        void success();
    }

    private static void a(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            a.a();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            a.a("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        a(context, "Context is null, please check.");
        a(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
        tTAdConfig.setExtra(TTAdConstant.PANGLE_INIT_START_TIME, Long.valueOf(SystemClock.elapsedRealtime()));
        tTAdConfig.setExtra(TTAdConstant.KEY_S_C, "main");
        tTAdConfig.setExtra(TTAdConstant.KEY_L_S, Boolean.FALSE);
    }

    public static TTAdManager getAdManager() {
        TTInitializer tTInitializer = a;
        if (tTInitializer != null) {
            return tTInitializer.getAdManager();
        }
        return null;
    }

    public static void getCodeGroupRit(final long j2, final TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener) {
        TTInitializer tTInitializer = a;
        if (tTInitializer != null) {
            tTInitializer.getAdManager().register(new CodeGroupRitObject() { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.1
                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public long getCodeGroupId() {
                    return j2;
                }

                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public TTCodeGroupRit.TTCodeGroupRitListener getListener() {
                    return tTCodeGroupRitListener;
                }
            });
        } else if (tTCodeGroupRitListener != null) {
            tTCodeGroupRitListener.onFail(4100, "please init sdk first!");
        }
    }

    public static void init(Context context, TTAdConfig tTAdConfig, InitCallback initCallback) {
        a(context, tTAdConfig);
        Context applicationContext = context.getApplicationContext();
        TTInitializer tTInitializer = a;
        if (tTInitializer == null) {
            initCallback.fail(4100, "Load initializer failed");
        } else {
            tTInitializer.init(applicationContext, tTAdConfig, initCallback);
        }
    }

    public static boolean isInitSuccess() {
        TTInitializer tTInitializer = a;
        if (tTInitializer != null) {
            return tTInitializer.isInitSuccess();
        }
        return false;
    }

    public static boolean isOnePointFiveAdType(TTNativeExpressAd tTNativeExpressAd) {
        Map<String, Object> mediaExtraInfo;
        if (tTNativeExpressAd == null) {
            mediaExtraInfo = null;
        } else {
            try {
                mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mediaExtraInfo == null || !mediaExtraInfo.containsKey("_tt_ad_type_onepointfive")) {
            return false;
        }
        return ((Boolean) mediaExtraInfo.get("_tt_ad_type_onepointfive")).booleanValue();
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        TTAdManager adManager;
        if (tTAdConfig == null || (adManager = a.getAdManager()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (bundle.keySet().isEmpty()) {
            return;
        }
        adManager.getExtra(AdConfig.class, bundle);
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        com.bytedance.sdk.openadsdk.live.a a2;
        if (tTAdConfig == null || (a2 = com.bytedance.sdk.openadsdk.live.a.a()) == null) {
            return;
        }
        a2.a(tTAdConfig.getInjectionAuth());
    }

    public static void updatePaid(boolean z) {
        TTAdManager adManager = a.getAdManager();
        if (adManager == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        adManager.getExtra(AdConfig.class, bundle);
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
