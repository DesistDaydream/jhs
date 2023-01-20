package com.bytedance.msdk.api.v2.ad.interstitial;

import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: classes.dex */
public interface GMInterstitialAdListener extends ITTAdatperCallback {
    void onAdLeftApplication();

    void onAdOpened();

    void onInterstitialAdClick();

    void onInterstitialClosed();

    void onInterstitialShow();

    void onInterstitialShowFail(@NonNull AdError adError);
}
