package com.bytedance.msdk.api.v2.slot.paltform;

import com.bytedance.msdk.api.BaiduExtraOptions;
import com.bytedance.msdk.api.BaiduNativeSmartOptStyleParams;
import com.bytedance.msdk.api.BaiduRequestParameters;
import com.bytedance.msdk.api.BaiduSplashParams;

/* loaded from: classes.dex */
public class GMAdSlotBaiduOption {
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private boolean a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private BaiduNativeSmartOptStyleParams f2161c;

    /* renamed from: d  reason: collision with root package name */
    private BaiduRequestParameters f2162d;

    /* renamed from: e  reason: collision with root package name */
    private BaiduSplashParams f2163e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2164f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2165g;

    /* renamed from: h  reason: collision with root package name */
    private String f2166h;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private BaiduNativeSmartOptStyleParams f2167c;

        /* renamed from: d  reason: collision with root package name */
        private BaiduRequestParameters f2168d;

        /* renamed from: e  reason: collision with root package name */
        private BaiduSplashParams f2169e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2170f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2171g;

        /* renamed from: h  reason: collision with root package name */
        private String f2172h;

        public final GMAdSlotBaiduOption build() {
            return new GMAdSlotBaiduOption(this);
        }

        public Builder setAppSid(String str) {
            this.f2172h = str;
            return this;
        }

        public Builder setBaiduNativeSmartOptStyleParams(BaiduNativeSmartOptStyleParams baiduNativeSmartOptStyleParams) {
            this.f2167c = baiduNativeSmartOptStyleParams;
            return this;
        }

        public Builder setBaiduRequestParameters(BaiduRequestParameters baiduRequestParameters) {
            this.f2168d = baiduRequestParameters;
            return this;
        }

        public Builder setBaiduSplashParams(BaiduSplashParams baiduSplashParams) {
            this.f2169e = baiduSplashParams;
            return this;
        }

        public Builder setCacheVideoOnlyWifi(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setDownloadAppConfirmPolicy(int i2) {
            this.b = i2;
            return this;
        }

        public Builder setShowDialogOnSkip(boolean z) {
            this.f2170f = z;
            return this;
        }

        public Builder setUseRewardCountdown(boolean z) {
            this.f2171g = z;
            return this;
        }
    }

    private GMAdSlotBaiduOption(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f2161c = builder.f2167c;
        this.f2162d = builder.f2168d;
        this.f2163e = builder.f2169e;
        this.f2164f = builder.f2170f;
        this.f2165g = builder.f2171g;
        this.f2166h = builder.f2172h;
    }

    public String getAppSid() {
        return this.f2166h;
    }

    public BaiduExtraOptions getBaiduExtra() {
        BaiduExtraOptions.Builder builder = new BaiduExtraOptions.Builder();
        builder.setCacheVideoOnlyWifi(isCacheVideoOnlyWifi());
        builder.setAppSid(getAppSid());
        builder.setBaiduNativeSmartOptStyleParams(getBaiduNativeSmartOptStyleParams());
        builder.setBaiduRequestParameters(getBaiduRequestParameters());
        builder.setBaiduSplashParams(getBaiduSplashParams());
        builder.setGDTExtraOption(getDownloadAppConfirmPolicy());
        builder.setShowDialogOnSkip(getShowDialogOnSkip());
        builder.setUseRewardCountdown(getUseRewardCountdown());
        return builder.build();
    }

    public BaiduNativeSmartOptStyleParams getBaiduNativeSmartOptStyleParams() {
        return this.f2161c;
    }

    public BaiduRequestParameters getBaiduRequestParameters() {
        return this.f2162d;
    }

    public BaiduSplashParams getBaiduSplashParams() {
        return this.f2163e;
    }

    public int getDownloadAppConfirmPolicy() {
        return this.b;
    }

    public boolean getShowDialogOnSkip() {
        return this.f2164f;
    }

    public boolean getUseRewardCountdown() {
        return this.f2165g;
    }

    public boolean isCacheVideoOnlyWifi() {
        return this.a;
    }
}
