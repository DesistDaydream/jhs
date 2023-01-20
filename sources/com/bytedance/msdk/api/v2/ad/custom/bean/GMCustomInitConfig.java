package com.bytedance.msdk.api.v2.ad.custom.bean;

import android.text.TextUtils;
import com.bytedance.msdk.api.v2.ad.custom.banner.GMCustomBannerAdapter;
import com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAdapter;
import com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter;
import com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAdapter;
import com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter;
import com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter;

/* loaded from: classes.dex */
public class GMCustomInitConfig {
    public static final String CUSTOM_TYPE = "1";
    private final String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2062c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2063d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2064e;

    /* renamed from: f  reason: collision with root package name */
    private final String f2065f;

    /* renamed from: g  reason: collision with root package name */
    private final String f2066g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2067h;

    /* renamed from: i  reason: collision with root package name */
    private final String f2068i;

    /* renamed from: j  reason: collision with root package name */
    private final String f2069j;

    /* renamed from: k  reason: collision with root package name */
    private final String f2070k;

    /* renamed from: l  reason: collision with root package name */
    private final String f2071l;

    public GMCustomInitConfig() {
        this.f2062c = "";
        this.a = "";
        this.b = "";
        this.f2063d = "";
        this.f2064e = "";
        this.f2065f = "";
        this.f2066g = "";
        this.f2067h = "";
        this.f2068i = "";
        this.f2069j = "";
        this.f2070k = "";
        this.f2071l = "";
    }

    public GMCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f2062c = str;
        this.a = str2;
        this.b = str3;
        this.f2063d = str4;
        this.f2064e = str5;
        this.f2065f = str6;
        this.f2066g = str7;
        this.f2067h = str8;
        this.f2068i = str9;
        this.f2069j = str10;
        this.f2070k = str11;
        this.f2071l = str12;
    }

    public String getADNName() {
        return this.f2062c;
    }

    public String getAdnInitClassName() {
        return this.f2063d;
    }

    public String getAppId() {
        return this.a;
    }

    public String getAppKey() {
        return this.b;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public GMCustomAdConfig getClassName(int i2, int i3) {
        switch (i2) {
            case 1:
                return new GMCustomAdConfig(this.f2064e, GMCustomBannerAdapter.class);
            case 2:
                return new GMCustomAdConfig(this.f2065f, GMCustomInterstitialAdapter.class);
            case 3:
                return new GMCustomAdConfig(this.f2068i, GMCustomSplashAdapter.class);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                return new GMCustomAdConfig(this.f2069j, GMCustomNativeAdapter.class);
            case 7:
                return new GMCustomAdConfig(this.f2066g, GMCustomRewardAdapter.class);
            case 8:
                return new GMCustomAdConfig(this.f2067h, GMCustomFullVideoAdapter.class);
            case 9:
                break;
            case 10:
                if (i3 == 1) {
                    return new GMCustomAdConfig(this.f2065f, GMCustomInterstitialAdapter.class);
                }
                if (i3 == 2) {
                    return new GMCustomAdConfig(this.f2067h, GMCustomFullVideoAdapter.class);
                }
                break;
        }
        return new GMCustomAdConfig(this.f2070k, GMCustomDrawAdapter.class);
    }

    public boolean isCustom() {
        return TextUtils.equals(this.f2071l, "1");
    }

    public String toString() {
        return "GMCustomInitConfig{mAppId='" + this.a + "', mAppKey='" + this.b + "', mADNName='" + this.f2062c + "', mAdnInitClassName='" + this.f2063d + "', mBannerClassName='" + this.f2064e + "', mInterstitialClassName='" + this.f2065f + "', mRewardClassName='" + this.f2066g + "', mFullVideoClassName='" + this.f2067h + "', mSplashClassName='" + this.f2068i + "', mDrawClassName='" + this.f2070k + "', mFeedClassName='" + this.f2069j + "'}";
    }
}
