package com.bytedance.msdk.api;

import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;

@Deprecated
/* loaded from: classes.dex */
public class BaiduExtraOptions {
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private boolean a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private BaiduNativeSmartOptStyleParams f1900c;

    /* renamed from: d  reason: collision with root package name */
    private BaiduRequestParameters f1901d;

    /* renamed from: e  reason: collision with root package name */
    private BaiduSplashParams f1902e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1903f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1904g;

    /* renamed from: h  reason: collision with root package name */
    private String f1905h;

    /* loaded from: classes.dex */
    public static final class Builder {
        @Deprecated
        private boolean a;
        @Deprecated
        private int b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        private BaiduNativeSmartOptStyleParams f1906c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        private BaiduRequestParameters f1907d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        private BaiduSplashParams f1908e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1909f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1910g;

        /* renamed from: h  reason: collision with root package name */
        private String f1911h;

        public final BaiduExtraOptions build() {
            return new BaiduExtraOptions(this);
        }

        public Builder setAppSid(String str) {
            this.f1911h = str;
            return this;
        }

        public Builder setBaiduNativeSmartOptStyleParams(BaiduNativeSmartOptStyleParams baiduNativeSmartOptStyleParams) {
            this.f1906c = baiduNativeSmartOptStyleParams;
            return this;
        }

        public Builder setBaiduRequestParameters(BaiduRequestParameters baiduRequestParameters) {
            this.f1907d = baiduRequestParameters;
            return this;
        }

        public Builder setBaiduSplashParams(BaiduSplashParams baiduSplashParams) {
            this.f1908e = baiduSplashParams;
            return this;
        }

        public Builder setCacheVideoOnlyWifi(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setGDTExtraOption(int i2) {
            this.b = i2;
            return this;
        }

        public Builder setShowDialogOnSkip(boolean z) {
            this.f1909f = z;
            return this;
        }

        public Builder setUseRewardCountdown(boolean z) {
            this.f1910g = z;
            return this;
        }
    }

    private BaiduExtraOptions(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f1900c = builder.f1906c;
        this.f1901d = builder.f1907d;
        this.f1902e = builder.f1908e;
        this.f1903f = builder.f1909f;
        this.f1904g = builder.f1910g;
        this.f1905h = builder.f1911h;
    }

    public String getAppSid() {
        return this.f1905h;
    }

    public BaiduNativeSmartOptStyleParams getBaiduNativeSmartOptStyleParams() {
        return this.f1900c;
    }

    public BaiduRequestParameters getBaiduRequestParameters() {
        return this.f1901d;
    }

    public BaiduSplashParams getBaiduSplashParams() {
        return this.f1902e;
    }

    public int getDownloadAppConfirmPolicy() {
        return this.b;
    }

    public GMAdSlotBaiduOption getGMBaiduExtra() {
        GMAdSlotBaiduOption.Builder builder = new GMAdSlotBaiduOption.Builder();
        builder.setCacheVideoOnlyWifi(isCacheVideoOnlyWifi());
        builder.setAppSid(getAppSid());
        builder.setBaiduNativeSmartOptStyleParams(getBaiduNativeSmartOptStyleParams());
        builder.setBaiduRequestParameters(getBaiduRequestParameters());
        builder.setBaiduSplashParams(getBaiduSplashParams());
        builder.setDownloadAppConfirmPolicy(getDownloadAppConfirmPolicy());
        builder.setShowDialogOnSkip(getShowDialogOnSkip());
        builder.setUseRewardCountdown(getUseRewardCountdown());
        return builder.build();
    }

    public boolean getShowDialogOnSkip() {
        return this.f1903f;
    }

    public boolean getUseRewardCountdown() {
        return this.f1904g;
    }

    public boolean isCacheVideoOnlyWifi() {
        return this.a;
    }
}
