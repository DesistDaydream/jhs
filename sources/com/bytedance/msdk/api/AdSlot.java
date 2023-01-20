package com.bytedance.msdk.api;

import android.widget.FrameLayout;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class AdSlot extends b {
    public static final int AUTO_HEIGHT = -2;
    @Deprecated
    public static final String CUSTOM_DATA_KEY_ADMOB = "admob";
    @Deprecated
    public static final String CUSTOM_DATA_KEY_BAIDU = "baidu";
    @Deprecated
    public static final String CUSTOM_DATA_KEY_GDT = "gdt";
    @Deprecated
    public static final String CUSTOM_DATA_KEY_KLEVIN = "klevin";
    @Deprecated
    public static final String CUSTOM_DATA_KEY_KS = "ks";
    @Deprecated
    public static final String CUSTOM_DATA_KEY_MINTEGRAL = "mintegral";
    @Deprecated
    public static final String CUSTOM_DATA_KEY_PANGLE = "pangle";
    @Deprecated
    public static final String CUSTOM_DATA_KEY_SIGMOB = "sigmob";
    @Deprecated
    public static final String CUSTOM_DATA_KEY_UNITY = "unity";
    public static final int FULL_WIDTH = -1;
    public static final int POSITION_BOTTOM = 2;
    public static final int POSITION_FEED = 3;
    public static final int POSITION_FULL_SCREEN = 5;
    public static final int POSITION_MIDDLE = 4;
    public static final int POSITION_TOP = 1;
    public static final int TYPE_BANNER = 1;
    @Deprecated
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_EXPRESS_AD = 1;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_INTERACTION_FULL = 10;
    public static final int TYPE_NATIVE_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    private int A;
    private int B;
    private int C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private String H;
    private int I;
    private String J;
    private String K;
    private Map<String, String> L;
    private int M;
    private TTVideoOption N;

    /* renamed from: j  reason: collision with root package name */
    private TTRequestExtraParams f1884j;

    /* renamed from: k  reason: collision with root package name */
    private AdmobNativeAdOptions f1885k;

    /* renamed from: l  reason: collision with root package name */
    private FrameLayout.LayoutParams f1886l;

    /* renamed from: m  reason: collision with root package name */
    private String f1887m;
    private boolean n;
    @Deprecated
    private int o;
    @Deprecated
    private int p;
    private boolean q;
    private boolean r;
    private double s;
    private int t;
    private int u;
    private boolean v;
    private String w;
    private String x;
    private long y;
    private String z;

    /* loaded from: classes.dex */
    public static class Builder {
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        private String f1890e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        private int f1891f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        private String f1892g;
        @Deprecated

        /* renamed from: h  reason: collision with root package name */
        private Map<String, String> f1893h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        private String f1894i;
        @Deprecated

        /* renamed from: j  reason: collision with root package name */
        private int f1895j;
        @Deprecated

        /* renamed from: k  reason: collision with root package name */
        private int f1896k;
        @Deprecated

        /* renamed from: l  reason: collision with root package name */
        private TTVideoOption f1897l;
        @Deprecated

        /* renamed from: m  reason: collision with root package name */
        private TTRequestExtraParams f1898m;
        @Deprecated
        private AdmobNativeAdOptions p;
        @Deprecated
        private FrameLayout.LayoutParams q;
        @Deprecated
        private String r;
        private boolean s;
        @Deprecated
        private boolean v;
        @Deprecated
        private boolean w;
        @Deprecated
        private boolean x;
        private String y;
        @Deprecated
        private int a = 640;
        @Deprecated
        private int b = 320;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        private boolean f1888c = true;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        private int f1889d = 1;
        @Deprecated
        private int n = 2;
        @Deprecated
        private int o = 3;
        @Deprecated
        private int t = 1;
        @Deprecated
        private int u = 0;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.C = this.f1889d;
            adSlot.D = this.f1888c;
            adSlot.A = this.a;
            adSlot.B = this.b;
            adSlot.H = this.f1890e;
            adSlot.I = this.f1891f;
            adSlot.J = this.f1892g;
            adSlot.L = this.f1893h;
            adSlot.K = this.f1894i;
            adSlot.M = this.f1895j;
            adSlot.E = this.f1896k;
            adSlot.F = this.n;
            adSlot.N = this.f1897l;
            adSlot.f1884j = this.f1898m;
            adSlot.f1885k = this.p;
            adSlot.G = this.o;
            adSlot.f1886l = this.q;
            adSlot.f1887m = this.r;
            adSlot.n = this.s;
            adSlot.o = this.t;
            adSlot.p = this.u;
            adSlot.q = this.v;
            adSlot.r = this.w;
            adSlot.v = this.x;
            adSlot.w = this.y;
            return adSlot;
        }

        @Deprecated
        public Builder setAdCount(int i2) {
            this.f1889d = i2;
            return this;
        }

        @Deprecated
        public Builder setAdStyleType(int i2) {
            this.n = i2;
            return this;
        }

        @Deprecated
        public Builder setAdType(int i2) {
            this.f1896k = i2;
            return this;
        }

        @Deprecated
        public Builder setAdmobNativeAdOptions(AdmobNativeAdOptions admobNativeAdOptions) {
            this.p = admobNativeAdOptions;
            return this;
        }

        @Deprecated
        public Builder setBannerSize(int i2) {
            this.o = i2;
            return this;
        }

        @Deprecated
        public Builder setBidNotify(boolean z) {
            this.v = z;
            return this;
        }

        @Deprecated
        public Builder setCustomData(Map<String, String> map) {
            this.f1893h = map;
            return this;
        }

        @Deprecated
        public Builder setDownloadType(int i2) {
            this.u = i2;
            return this;
        }

        @Deprecated
        public Builder setForceLoadBottom(boolean z) {
            this.w = z;
            return this;
        }

        public Builder setGdtNativeAdLogoParams(FrameLayout.LayoutParams layoutParams) {
            this.q = layoutParams;
            return this;
        }

        @Deprecated
        public Builder setImageAdSize(int i2, int i3) {
            this.a = i2;
            this.b = i3;
            return this;
        }

        @Deprecated
        public Builder setMediaExtra(String str) {
            this.f1892g = str;
            return this;
        }

        @Deprecated
        public Builder setOrientation(int i2) {
            this.f1895j = i2;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i2) {
            this.f1891f = i2;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.f1890e = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.y = str;
            return this;
        }

        @Deprecated
        public Builder setSplashButtonType(int i2) {
            this.t = i2;
            return this;
        }

        @Deprecated
        public Builder setSplashShakeButton(boolean z) {
            this.x = z;
            return this;
        }

        @Deprecated
        public Builder setSupportDeepLink(boolean z) {
            this.f1888c = z;
            return this;
        }

        @Deprecated
        public Builder setTTRequestExtraParams(TTRequestExtraParams tTRequestExtraParams) {
            this.f1898m = tTRequestExtraParams;
            return this;
        }

        @Deprecated
        public Builder setTTVideoOption(TTVideoOption tTVideoOption) {
            this.f1897l = tTVideoOption;
            return this;
        }

        @Deprecated
        public Builder setTestSlotId(String str) {
            this.r = str;
            return this;
        }

        @Deprecated
        public Builder setUserID(String str) {
            this.f1894i = str;
            return this;
        }

        public Builder setV2Request(boolean z) {
            this.s = z;
            return this;
        }
    }

    private AdSlot() {
        this.F = 2;
        this.G = 3;
    }

    public int getAdCount() {
        int netWorkNum = getNetWorkNum();
        if (netWorkNum > 3) {
            netWorkNum = 3;
        }
        return netWorkNum > 0 ? netWorkNum : this.C;
    }

    public int getAdStyleType() {
        return this.F;
    }

    public int getAdType() {
        return this.E;
    }

    public String getAdUnitId() {
        return this.x;
    }

    public AdmobNativeAdOptions getAdmobNativeAdOptions() {
        return this.f1885k;
    }

    public int getBannerSize() {
        return this.G;
    }

    @Deprecated
    public double getBidFloor() {
        return this.s;
    }

    public Map<String, String> getCustomData() {
        return this.L;
    }

    @Deprecated
    public int getDownloadType() {
        return this.p;
    }

    public FrameLayout.LayoutParams getGdtNativeAdLogoParams() {
        return this.f1886l;
    }

    public int getImgAcceptedHeight() {
        return this.B;
    }

    public int getImgAcceptedWidth() {
        return this.A;
    }

    @Deprecated
    public String getMediaExtra() {
        return this.J;
    }

    public int getOrientation() {
        return this.M;
    }

    public int getParalleType() {
        return this.t;
    }

    public int getReqParallelNum() {
        return this.u;
    }

    public TTRequestExtraParams getReuestParam() {
        if (this.f1884j == null) {
            this.f1884j = new TTRequestExtraParams();
        }
        return this.f1884j;
    }

    public int getRewardAmount() {
        return this.I;
    }

    public String getRewardName() {
        return this.H;
    }

    public String getScenarioId() {
        return this.w;
    }

    @Deprecated
    public int getSplashButtonType() {
        return this.o;
    }

    public boolean getSplashShakeButton() {
        return this.v;
    }

    public TTVideoOption getTTVideoOption() {
        return this.N;
    }

    @Deprecated
    public String getTestSlotId() {
        return this.f1887m;
    }

    public String getUserID() {
        return this.K;
    }

    @Deprecated
    public String getVersion() {
        return this.z;
    }

    @Deprecated
    public long getWaterfallId() {
        return this.y;
    }

    public boolean isBidNotify() {
        return this.q;
    }

    public boolean isForceLoadBottom() {
        return this.r;
    }

    public boolean isSupportDeepLink() {
        return this.D;
    }

    public boolean isV2Request() {
        return this.n;
    }

    public void setAdCount(int i2) {
        this.C = i2;
    }

    public void setAdType(int i2) {
        this.E = i2;
    }

    public void setAdUnitId(String str) {
        this.x = str;
    }

    @Deprecated
    public void setBidFloor(double d2) {
        this.s = d2;
    }

    public void setParalleType(int i2) {
        this.t = i2;
    }

    public void setReqParallelNum(int i2) {
        this.u = i2;
    }

    public void setScenarioId(String str) {
        this.w = str;
    }

    public void setSplashShakeButton(boolean z) {
        this.v = z;
    }

    public void setTTVideoOption(TTVideoOption tTVideoOption) {
        this.N = tTVideoOption;
    }

    @Deprecated
    public void setTestSlotId(String str) {
        this.f1887m = str;
    }

    @Deprecated
    public void setVersion(String str) {
        this.z = str;
    }

    @Deprecated
    public void setWaterfallId(long j2) {
        this.y = j2;
    }
}
