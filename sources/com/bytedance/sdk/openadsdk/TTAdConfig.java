package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class TTAdConfig implements AdConfig {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2374c;

    /* renamed from: d  reason: collision with root package name */
    private String f2375d;

    /* renamed from: e  reason: collision with root package name */
    private String f2376e;

    /* renamed from: f  reason: collision with root package name */
    private int f2377f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2378g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2379h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2380i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f2381j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2382k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2383l;

    /* renamed from: m  reason: collision with root package name */
    private int f2384m;
    private Map<String, Object> n;
    private TTCustomController o;
    private int p;
    private ITTLiveTokenInjectionAuth q;

    /* loaded from: classes.dex */
    public static class Builder {
        private String a;
        private String b;

        /* renamed from: d  reason: collision with root package name */
        private String f2386d;

        /* renamed from: e  reason: collision with root package name */
        private String f2387e;

        /* renamed from: j  reason: collision with root package name */
        private int[] f2392j;

        /* renamed from: m  reason: collision with root package name */
        private String[] f2395m;
        private TTCustomController o;
        private int p;
        private ITTLiveTokenInjectionAuth s;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2385c = false;

        /* renamed from: f  reason: collision with root package name */
        private int f2388f = 0;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2389g = true;

        /* renamed from: h  reason: collision with root package name */
        private boolean f2390h = false;

        /* renamed from: i  reason: collision with root package name */
        private boolean f2391i = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2393k = true;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2394l = false;
        private boolean n = false;
        private int q = 2;
        private int r = 0;

        public Builder allowShowNotify(boolean z) {
            this.f2389g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f2391i = z;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder appName(String str) {
            this.b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setAppName(this.b);
            tTAdConfig.setPaid(this.f2385c);
            tTAdConfig.setKeywords(this.f2386d);
            tTAdConfig.setData(this.f2387e);
            tTAdConfig.setTitleBarTheme(this.f2388f);
            tTAdConfig.setAllowShowNotify(this.f2389g);
            tTAdConfig.setDebug(this.f2390h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f2391i);
            tTAdConfig.setDirectDownloadNetworkType(this.f2392j);
            tTAdConfig.setUseTextureView(this.f2393k);
            tTAdConfig.setSupportMultiProcess(this.f2394l);
            tTAdConfig.setNeedClearTaskReset(this.f2395m);
            tTAdConfig.setAsyncInit(this.n);
            tTAdConfig.setCustomController(this.o);
            tTAdConfig.setThemeStatus(this.p);
            tTAdConfig.setExtra("plugin_update_conf", Integer.valueOf(this.q));
            tTAdConfig.setExtra(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(this.r));
            tTAdConfig.setInjectionAuth(this.s);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.o = tTCustomController;
            return this;
        }

        public Builder data(String str) {
            this.f2387e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f2390h = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f2392j = iArr;
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.s = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.f2386d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.f2395m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f2385c = z;
            return this;
        }

        public Builder setAgeGroup(int i2) {
            this.r = i2;
            return this;
        }

        public Builder setPluginUpdateConfig(int i2) {
            this.q = i2;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.f2394l = z;
            return this;
        }

        public Builder themeStatus(int i2) {
            this.p = i2;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.f2388f = i2;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.f2393k = z;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f2376e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f2381j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.n.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f2375d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public String[] getNeedClearTaskReset() {
        return new String[0];
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public AdConfig.SdkInfo getSdkInfo() {
        return new AdConfig.SdkInfo() { // from class: com.bytedance.sdk.openadsdk.TTAdConfig.1
            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public boolean isPlugin() {
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String pluginName() {
                return "com.byted.pangle";
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public int sdkVersionCode() {
                return 4808;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String sdkVersionName() {
                return "4.8.0.8";
            }
        };
    }

    public int getThemeStatus() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f2377f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f2378g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.f2380i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public boolean isAsyncInit() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f2379h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f2374c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.f2383l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.f2382k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object removeExtra(String str) {
        return this.n.remove(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public void setAgeGroup(int i2) {
        this.n.put(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(i2));
    }

    public void setAllowShowNotify(boolean z) {
        this.f2378g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f2380i = z;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAppName(String str) {
        this.b = str;
    }

    @Deprecated
    public void setAsyncInit(boolean z) {
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.o = tTCustomController;
    }

    public void setData(String str) {
        this.f2376e = str;
    }

    public void setDebug(boolean z) {
        this.f2379h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f2381j = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.n.put(str, obj);
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.q = iTTLiveTokenInjectionAuth;
    }

    public void setKeywords(String str) {
        this.f2375d = str;
    }

    @Deprecated
    public void setNeedClearTaskReset(String... strArr) {
    }

    public void setPaid(boolean z) {
        this.f2374c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.f2383l = z;
    }

    public void setThemeStatus(int i2) {
        this.p = i2;
    }

    public void setTitleBarTheme(int i2) {
        this.f2377f = i2;
    }

    public void setUseTextureView(boolean z) {
        this.f2382k = z;
    }

    private TTAdConfig() {
        this.f2374c = false;
        this.f2377f = 0;
        this.f2378g = true;
        this.f2379h = false;
        this.f2380i = false;
        this.f2382k = true;
        this.f2383l = false;
        this.f2384m = 0;
        this.n = new HashMap();
    }
}
