package com.bytedance.msdk.api.v2.ad.banner;

import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: classes.dex */
public interface GMBannerAdListener extends ITTAdatperCallback {
    void onAdClicked();

    void onAdClosed();

    void onAdLeftApplication();

    void onAdOpened();

    void onAdShow();

    void onAdShowFail(@NonNull AdError adError);
}
