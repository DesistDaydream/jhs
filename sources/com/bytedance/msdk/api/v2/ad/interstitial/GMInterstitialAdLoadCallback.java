package com.bytedance.msdk.api.v2.ad.interstitial;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* loaded from: classes.dex */
public interface GMInterstitialAdLoadCallback {
    void onInterstitialLoad();

    void onInterstitialLoadFail(@NonNull AdError adError);
}
