package com.bytedance.msdk.api.v2.ad;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotDraw;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;

/* loaded from: classes.dex */
public abstract class GMBaseAd {
    private final AdSlot.Builder a = new AdSlot.Builder();

    private void a(GMAdSlotBase gMAdSlotBase) {
        if (gMAdSlotBase != null) {
            this.a.setScenarioId(gMAdSlotBase.getScenarioId());
            this.a.setBidNotify(gMAdSlotBase.isBidNotify());
            this.a.setTestSlotId(gMAdSlotBase.getTestSlotId());
            if (gMAdSlotBase instanceof GMAdSlotSplash) {
                this.a.setTTVideoOption(gMAdSlotBase.createTTVideoOption(((GMAdSlotSplash) gMAdSlotBase).isSplashPreLoad()));
            } else {
                this.a.setTTVideoOption(gMAdSlotBase.createTTVideoOption(false));
            }
            this.a.setTTRequestExtraParams(gMAdSlotBase.getTTRequestExtraParams());
            this.a.setDownloadType(gMAdSlotBase.getDownloadType());
            this.a.setV2Request(true);
        }
    }

    public AdSlot getAdSlot() {
        return this.a.build();
    }

    public void loadAd(GMAdSlotBanner gMAdSlotBanner, GMBannerAdLoadCallback gMBannerAdLoadCallback) {
        if (gMAdSlotBanner != null) {
            a(gMAdSlotBanner);
            this.a.setImageAdSize(gMAdSlotBanner.getWidth(), gMAdSlotBanner.getHeight());
            this.a.setBannerSize(gMAdSlotBanner.getBannerSize());
        }
    }

    public void loadAd(GMAdSlotDraw gMAdSlotDraw, GMDrawAdLoadCallback gMDrawAdLoadCallback) {
        if (gMAdSlotDraw != null) {
            a(gMAdSlotDraw);
            this.a.setImageAdSize(gMAdSlotDraw.getWidth(), gMAdSlotDraw.getHeight());
            this.a.setAdCount(gMAdSlotDraw.getAdCount());
        }
    }

    public void loadAd(GMAdSlotFullVideo gMAdSlotFullVideo, GMFullVideoAdLoadCallback gMFullVideoAdLoadCallback) {
        if (gMAdSlotFullVideo != null) {
            a(gMAdSlotFullVideo);
            this.a.setUserID(gMAdSlotFullVideo.getUserID());
            this.a.setOrientation(gMAdSlotFullVideo.getOrientation());
            this.a.setRewardName(gMAdSlotFullVideo.getRewardName());
            this.a.setRewardAmount(gMAdSlotFullVideo.getRewardAmount());
            this.a.setCustomData(gMAdSlotFullVideo.getCustomData());
        }
    }

    public void loadAd(GMAdSlotInterstitial gMAdSlotInterstitial, GMInterstitialAdLoadCallback gMInterstitialAdLoadCallback) {
        if (gMAdSlotInterstitial != null) {
            a(gMAdSlotInterstitial);
            this.a.setImageAdSize(gMAdSlotInterstitial.getWidth(), gMAdSlotInterstitial.getHeight());
        }
    }

    public void loadAd(GMAdSlotInterstitialFull gMAdSlotInterstitialFull, GMInterstitialFullAdLoadCallback gMInterstitialFullAdLoadCallback) {
        if (gMAdSlotInterstitialFull != null) {
            a(gMAdSlotInterstitialFull);
            this.a.setImageAdSize(gMAdSlotInterstitialFull.getWidth(), gMAdSlotInterstitialFull.getHeight());
            this.a.setUserID(gMAdSlotInterstitialFull.getUserID());
            this.a.setOrientation(gMAdSlotInterstitialFull.getOrientation());
            this.a.setRewardName(gMAdSlotInterstitialFull.getRewardName());
            this.a.setRewardAmount(gMAdSlotInterstitialFull.getRewardAmount());
            this.a.setCustomData(gMAdSlotInterstitialFull.getCustomData());
        }
    }

    public void loadAd(GMAdSlotNative gMAdSlotNative, GMNativeAdLoadCallback gMNativeAdLoadCallback) {
        if (gMAdSlotNative != null) {
            a(gMAdSlotNative);
            this.a.setImageAdSize(gMAdSlotNative.getWidth(), gMAdSlotNative.getHeight());
            this.a.setAdCount(gMAdSlotNative.getAdCount());
            this.a.setAdStyleType(gMAdSlotNative.getAdStyleType());
            this.a.setAdmobNativeAdOptions(gMAdSlotNative.getAdmobNativeAdOptions());
            this.a.setUserID(gMAdSlotNative.getUserID());
            GMAdSlotGDTOption gMAdSlotGDTOption = gMAdSlotNative.getGMAdSlotGDTOption();
            if (gMAdSlotGDTOption != null) {
                this.a.setGdtNativeAdLogoParams(gMAdSlotGDTOption.getNativeAdLogoParams());
            }
        }
    }

    public void loadAd(GMAdSlotRewardVideo gMAdSlotRewardVideo, @NonNull GMRewardedAdLoadCallback gMRewardedAdLoadCallback) {
        if (gMAdSlotRewardVideo != null) {
            a(gMAdSlotRewardVideo);
            this.a.setRewardName(gMAdSlotRewardVideo.getRewardName());
            this.a.setRewardAmount(gMAdSlotRewardVideo.getRewardAmount());
            this.a.setCustomData(gMAdSlotRewardVideo.getCustomData());
            this.a.setUserID(gMAdSlotRewardVideo.getUserID());
            this.a.setOrientation(gMAdSlotRewardVideo.getOrientation());
        }
    }

    public void loadAd(GMAdSlotSplash gMAdSlotSplash, GMNetworkRequestInfo gMNetworkRequestInfo, GMSplashAdLoadCallback gMSplashAdLoadCallback) {
        if (gMAdSlotSplash != null) {
            a(gMAdSlotSplash);
            this.a.setImageAdSize(gMAdSlotSplash.getWidth(), gMAdSlotSplash.getHeight());
            this.a.setUserID(gMAdSlotSplash.getUserID());
            this.a.setSplashButtonType(gMAdSlotSplash.getSplashButtonType());
            this.a.setForceLoadBottom(gMAdSlotSplash.isForceLoadBottom());
            this.a.setSplashShakeButton(gMAdSlotSplash.getSplashShakeButton());
        }
    }
}
