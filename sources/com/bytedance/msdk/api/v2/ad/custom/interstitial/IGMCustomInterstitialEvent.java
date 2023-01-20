package com.bytedance.msdk.api.v2.ad.custom.interstitial;

/* loaded from: classes.dex */
public interface IGMCustomInterstitialEvent {
    void callInterstitialAdClick();

    void callInterstitialAdLeftApplication();

    void callInterstitialAdOpened();

    void callInterstitialClosed();

    void callInterstitialShow();
}
