package com.bytedance.msdk.api.v2.ad.splash;

import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: classes.dex */
public interface GMSplashAdListener extends ITTAdatperCallback {
    void onAdClicked();

    void onAdDismiss();

    void onAdShow();

    void onAdShowFail(@NonNull AdError adError);

    void onAdSkip();
}
