package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.common.CommonListener;
import java.util.List;

/* loaded from: classes.dex */
public interface TTAdNative {

    /* loaded from: classes.dex */
    public interface BannerAdListener extends CommonListener {
        void onBannerAdLoad(TTBannerAd tTBannerAd);

        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i2, String str);
    }

    /* loaded from: classes.dex */
    public interface CSJSplashAdListener {
        void onSplashLoadFail(CSJAdError cSJAdError);

        void onSplashLoadSuccess();

        void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError);

        void onSplashRenderSuccess(CSJSplashAd cSJSplashAd);
    }

    /* loaded from: classes.dex */
    public interface DrawFeedAdListener extends CommonListener {
        void onDrawFeedAdLoad(List<TTDrawFeedAd> list);

        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i2, String str);
    }

    /* loaded from: classes.dex */
    public interface FeedAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i2, String str);

        void onFeedAdLoad(List<TTFeedAd> list);
    }

    /* loaded from: classes.dex */
    public interface FullScreenVideoAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i2, String str);

        void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd);

        @Deprecated
        void onFullScreenVideoCached();

        void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd);
    }

    /* loaded from: classes.dex */
    public interface InteractionAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i2, String str);

        void onInteractionAdLoad(TTInteractionAd tTInteractionAd);
    }

    /* loaded from: classes.dex */
    public interface NativeAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i2, String str);

        void onNativeAdLoad(List<TTNativeAd> list);
    }

    /* loaded from: classes.dex */
    public interface NativeExpressAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i2, String str);

        void onNativeExpressAdLoad(List<TTNativeExpressAd> list);
    }

    /* loaded from: classes.dex */
    public interface RewardVideoAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i2, String str);

        void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd);

        @Deprecated
        void onRewardVideoCached();

        void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd);
    }

    /* loaded from: classes.dex */
    public interface SplashAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i2, String str);

        void onSplashAdLoad(TTSplashAd tTSplashAd);

        void onTimeout();
    }

    void loadBannerAd(AdSlot adSlot, BannerAdListener bannerAdListener);

    void loadBannerExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadDrawFeedAd(AdSlot adSlot, DrawFeedAdListener drawFeedAdListener);

    void loadExpressDrawFeedAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadFeedAd(AdSlot adSlot, FeedAdListener feedAdListener);

    void loadFullScreenVideoAd(AdSlot adSlot, FullScreenVideoAdListener fullScreenVideoAdListener);

    @Deprecated
    void loadInteractionAd(AdSlot adSlot, InteractionAdListener interactionAdListener);

    @Deprecated
    void loadInteractionExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadNativeAd(AdSlot adSlot, NativeAdListener nativeAdListener);

    void loadNativeExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadRewardVideoAd(AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(AdSlot adSlot, CSJSplashAdListener cSJSplashAdListener, int i2);

    void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener);

    @Deprecated
    void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener, int i2);

    void loadStream(AdSlot adSlot, FeedAdListener feedAdListener);
}
