package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.Preconditions;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMLiveAuthCallback;
import com.bytedance.msdk.api.v2.GMLiveToken;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import com.bytedance.msdk.api.v2.IGMLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PangleAdapterConfiguration extends TTBaseAdapterConfiguration {
    public static final int ADN_INIT_ERROR_NO_APPID = 1;
    public static final String AD_PLACEMENT_ID_EXTRA_KEY = "ad_placement_id";
    public static final String APP_ID_EXTRA_KEY = "app_id";
    public static final int TT_THEME_STATUS_DAY = 0;
    public static final int TT_THEME_STATUS_NIGHT = 1;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1814c;

    /* renamed from: f  reason: collision with root package name */
    private IGMLiveTokenInjectionAuth f1817f;

    /* renamed from: d  reason: collision with root package name */
    private final List<InitCallback> f1815d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    private GMPrivacyConfig f1816e = new GMPrivacyConfig();

    /* renamed from: g  reason: collision with root package name */
    private final TTCustomController f1818g = new TTCustomController() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.3
        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            return PangleAdapterConfiguration.this.f1816e.appList();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            return PangleAdapterConfiguration.this.f1816e.getDevImei();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevOaid() {
            return PangleAdapterConfiguration.this.f1816e.getDevOaid();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getMacAddress() {
            return PangleAdapterConfiguration.this.f1816e.getMacAddress();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public LocationProvider getTTLocation() {
            if (PangleAdapterConfiguration.this.f1816e.getTTLocation() != null) {
                return new TTLocation(PangleAdapterConfiguration.this.f1816e.getTTLocation().getLatitude(), PangleAdapterConfiguration.this.f1816e.getTTLocation().getLongitude());
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseAndroidId() {
            Logger.d("TMe", "--==-- 穿山甲获取的isCanUseAndroidId: " + PangleAdapterConfiguration.this.f1816e.isCanUseAndroidId());
            return PangleAdapterConfiguration.this.f1816e.isCanUseAndroidId();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            return PangleAdapterConfiguration.this.f1816e.isCanUseLocation();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            return PangleAdapterConfiguration.this.f1816e.isCanUsePhoneState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            return PangleAdapterConfiguration.this.f1816e.isCanUseWifiState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWriteExternal() {
            return PangleAdapterConfiguration.this.f1816e.isCanUseWriteExternal();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private TTAdSdk.InitCallback f1819h = new TTAdSdk.InitCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.4
        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String str) {
            PangleAdapterConfiguration.this.f(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            PangleAdapterConfiguration.this.e();
        }
    };

    /* renamed from: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration$5  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GMAdConstant.ADULT_STATE.values().length];
            a = iArr;
            try {
                iArr[GMAdConstant.ADULT_STATE.AGE_15.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GMAdConstant.ADULT_STATE.AGE_18.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GMAdConstant.ADULT_STATE.AGE_ADULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface InitCallback {
        void fail(int i2, String str);

        void success();
    }

    private TTAdConfig c(Context context, String str, Map<String, Object> map) {
        Boolean bool = (Boolean) map.get(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_USE_TEXTURE_VIEW);
        boolean z = true;
        boolean z2 = bool != null && bool.booleanValue();
        String str2 = (String) map.get(TTBaseAdapterConfiguration.PANGLE_APP_NAME);
        Boolean bool2 = (Boolean) map.get(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_PAID);
        boolean z3 = bool2 != null && bool2.booleanValue();
        Integer num = (Integer) map.get(TTBaseAdapterConfiguration.PANGLE_TITLE_BAR_THEME);
        Boolean bool3 = (Boolean) map.get(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_ALLOW_SHOW_NOTIFY);
        boolean z4 = bool3 != null && bool3.booleanValue();
        Boolean bool4 = (Boolean) map.get(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_ALLOW_SHOW_PAGE_WHEN_SCREEN_LOCK);
        z = (bool4 == null || !bool4.booleanValue()) ? false : false;
        int[] iArr = (int[]) map.get(TTBaseAdapterConfiguration.PANGLE_DIRECT_DOWNLOAD_NETWORKTYPE);
        l(PangleAdapterUtils.getPangleData());
        String[] strArr = (String[]) map.get(TTBaseAdapterConfiguration.PANGLE_NEED_CLEAR_TASK_RESET);
        String str3 = (String) map.get(TTBaseAdapterConfiguration.PANGLE_KEYWORDS);
        Integer num2 = (Integer) map.get(TTBaseAdapterConfiguration.PANGLE_PLUGIN_UPDATE_CONFIG);
        TTAdConfig.Builder debug = new TTAdConfig.Builder().appId(str).useTextureView(z2).appName(str2).paid(z3).titleBarTheme(num == null ? 0 : num.intValue()).allowShowNotify(z4).allowShowPageWhenScreenLock(z).debug(Logger.isDebug());
        if (iArr == null) {
            iArr = new int[0];
        }
        TTAdConfig.Builder data = debug.directDownloadNetworkType(iArr).supportMultiProcess(false).data(PangleAdapterUtils.getPangleDataAndExtraData().toString());
        if (strArr == null) {
            strArr = new String[0];
        }
        TTAdConfig.Builder customController = data.needClearTaskReset(strArr).customController(this.f1818g);
        if (str3 == null) {
            str3 = "";
        }
        TTAdConfig.Builder ageGroup = customController.keywords(str3).setPluginUpdateConfig(num2 == null ? 2 : num2.intValue()).setAgeGroup(o());
        k(ageGroup);
        return ageGroup.build();
    }

    private String d(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONArray = new JSONArray();
                } else {
                    try {
                        jSONArray = new JSONArray(str);
                    } catch (JSONException unused) {
                        jSONArray = new JSONArray();
                    }
                }
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null && str2.equals(optJSONObject.getString("name"))) {
                            optJSONObject.put("value", str3);
                            z = true;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                if (!z) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", str2);
                    jSONObject.put("value", str3);
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        for (InitCallback initCallback : this.f1815d) {
            if (initCallback != null) {
                initCallback.success();
            }
        }
        this.f1815d.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2, String str) {
        for (InitCallback initCallback : this.f1815d) {
            if (initCallback != null) {
                initCallback.fail(i2, str);
            }
        }
        this.f1815d.clear();
        this.f1814c = true;
        this.b = false;
    }

    private void g(Context context, String str, Map<String, Object> map, InitCallback initCallback) {
        this.f1815d.add(initCallback);
        try {
            i(context, map, str);
        } catch (Throwable th) {
            synchronized (PangleAdapterConfiguration.class) {
                this.b = false;
                this.f1814c = false;
                th.printStackTrace();
            }
        }
    }

    private void h(Context context, Map<String, Object> map, final IGMInitAdnResult iGMInitAdnResult, String str) {
        q(context, str, map, new InitCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.1
            @Override // com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.InitCallback
            public void fail(int i2, String str2) {
                PangleAdapterConfiguration.this.setInitedSuccess(false);
                IGMInitAdnResult iGMInitAdnResult2 = iGMInitAdnResult;
                if (iGMInitAdnResult2 != null) {
                    iGMInitAdnResult2.fail(new AdError(i2, str2));
                }
            }

            @Override // com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.InitCallback
            public void success() {
                PangleAdapterConfiguration.this.setInitedSuccess(true);
                IGMInitAdnResult iGMInitAdnResult2 = iGMInitAdnResult;
                if (iGMInitAdnResult2 != null) {
                    iGMInitAdnResult2.success();
                }
            }
        });
    }

    private void i(Context context, Map<String, Object> map, String str) {
        synchronized (PangleAdapterConfiguration.class) {
            if (this.b) {
                if (TTAdSdk.isInitSuccess()) {
                    e();
                } else if (this.f1814c) {
                    f(30012, "pangle");
                }
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.b = true;
                TTAdSdk.init(context, c(context, str, map), this.f1819h);
            }
        }
    }

    private void k(TTAdConfig.Builder builder) {
        try {
            builder.injectionAuth(new ITTLiveTokenInjectionAuth() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.2
                @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
                public TTLiveToken getTokenInfo() {
                    GMLiveToken tokenInfo;
                    if (PangleAdapterConfiguration.this.f1817f == null || (tokenInfo = PangleAdapterConfiguration.this.f1817f.getTokenInfo()) == null) {
                        return null;
                    }
                    return new TTLiveToken(tokenInfo.name, tokenInfo.accessToken, tokenInfo.openId, tokenInfo.expireAt, tokenInfo.refreshToken);
                }

                @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
                public boolean isLogin() {
                    if (PangleAdapterConfiguration.this.f1817f != null) {
                        return PangleAdapterConfiguration.this.f1817f.isLogin();
                    }
                    return false;
                }

                @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
                public void onTokenInvalid(TTLiveToken tTLiveToken, final TTLiveAuthCallback tTLiveAuthCallback, Activity activity, Map<String, String> map) {
                    if (PangleAdapterConfiguration.this.f1817f != null) {
                        PangleAdapterConfiguration.this.f1817f.onTokenInvalid(tTLiveToken != null ? new GMLiveToken(tTLiveToken.name, tTLiveToken.accessToken, tTLiveToken.openId, tTLiveToken.expireAt, tTLiveToken.refreshToken) : null, tTLiveAuthCallback != null ? new GMLiveAuthCallback(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.2.1
                            @Override // com.bytedance.msdk.api.v2.GMLiveAuthCallback
                            public void onAuth(GMLiveToken gMLiveToken) {
                                if (gMLiveToken != null) {
                                    tTLiveAuthCallback.onAuth(new TTLiveToken(gMLiveToken.name, gMLiveToken.accessToken, gMLiveToken.openId, gMLiveToken.expireAt, gMLiveToken.refreshToken));
                                }
                            }

                            @Override // com.bytedance.msdk.api.v2.GMLiveAuthCallback
                            public void onFailed(Throwable th) {
                                tTLiveAuthCallback.onFailed(th);
                            }
                        } : null, activity, map);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void l(String str) {
        PangleAdapterUtils.setPangleData(d(str, "personal_ads_type", this.f1816e.isLimitPersonalAds() ? "0" : "1"));
    }

    private void m(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        PangleAdapterUtils.setPangleData(d(PangleAdapterUtils.getPangleData(), str, str2));
        TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(PangleAdapterUtils.getPangleDataAndExtraData().toString()).build());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int[] n(int i2, AdSlot adSlot) {
        switch (i2) {
            case 1:
                return new int[]{320, 50};
            case 2:
                return new int[]{320, 100};
            case 3:
                return new int[]{300, 250};
            case 4:
                return new int[]{468, 60};
            case 5:
                return new int[]{728, 90};
            case 6:
                if (adSlot.getImgAcceptedWidth() > 0 && adSlot.getImgAcceptedHeight() > 0) {
                    return new int[]{adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight()};
                }
                if (adSlot.getImgAcceptedWidth() > 0 && adSlot.getImgAcceptedHeight() < 0) {
                    return new int[]{adSlot.getImgAcceptedWidth(), 0};
                }
                break;
        }
        return new int[]{320, 50};
    }

    private int o() {
        GMPrivacyConfig gMPrivacyConfig = this.f1816e;
        if (gMPrivacyConfig != null) {
            int i2 = AnonymousClass5.a[gMPrivacyConfig.getAgeGroup().ordinal()];
            if (i2 == 1) {
                return 2;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return 0;
            }
        }
        return 0;
    }

    private void q(Context context, String str, Map<String, Object> map, InitCallback initCallback) {
        if (!TextUtils.isEmpty(str) && context != null) {
            g(context, str, map, initCallback);
        } else if (initCallback != null) {
            initCallback.fail(1, "Invalid Pangle app ID");
        }
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdNetworkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdapterVersion() {
        return "4.8.0.8.1";
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0157, code lost:
        if (r0.getImgAcceptedWidth() > 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0193, code lost:
        if (r0.getImgAcceptedHeight() > 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0195, code lost:
        r2 = r0.getImgAcceptedWidth();
        r3 = r0.getImgAcceptedHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0108, code lost:
        if (r0.getImgAcceptedHeight() > 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0116, code lost:
        if (r0.getImgAcceptedWidth() > 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0132, code lost:
        if (r0.getImgAcceptedHeight() > 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x013f, code lost:
        if (r0.getImgAcceptedWidth() > 0) goto L40;
     */
    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getBiddingToken(android.content.Context r14, java.util.Map<java.lang.String, java.lang.Object> r15) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.getBiddingToken(android.content.Context, java.util.Map):java.lang.String");
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
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return "";
        }
        try {
            return adManager.getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.config.IGMInitAdn
    public void initAdn(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull IGMInitAdnResult iGMInitAdnResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(iGMInitAdnResult);
        synchronized (PangleAdapterConfiguration.class) {
            if (isInitedSuccess() && iGMInitAdnResult != null) {
                iGMInitAdnResult.success();
                return;
            }
            if (!isInitedSuccess() && map != null && !map.isEmpty()) {
                try {
                    String str = (String) map.get("app_id");
                    Logger.i("TTMediationSDK_SDK_Init", "init Pangle SDK start......appId:" + str);
                    h(context, map, iGMInitAdnResult, str);
                } catch (Exception unused) {
                    if (iGMInitAdnResult != null) {
                        iGMInitAdnResult.fail(new AdError("configuration is empty"));
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
    public void setInjectionAuth(IGMLiveTokenInjectionAuth iGMLiveTokenInjectionAuth) {
        this.f1817f = iGMLiveTokenInjectionAuth;
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setPrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
        if (gMPrivacyConfig != null) {
            this.f1816e = gMPrivacyConfig;
            m("personal_ads_type", gMPrivacyConfig.isLimitPersonalAds() ? "0" : "1");
        }
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setThemeStatus(Map<String, Object> map) {
        super.setThemeStatus(map);
        if (map == null) {
            return;
        }
        Object obj = map.get(TTBaseAdapterConfiguration.TT_MSDK_THEME_STATUS);
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (intValue == 0 || intValue == 1) {
            TTAdSdk.getAdManager().setThemeStatus(intValue);
        }
    }
}
