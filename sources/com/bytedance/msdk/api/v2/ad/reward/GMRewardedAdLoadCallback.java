package com.bytedance.msdk.api.v2.ad.reward;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* loaded from: classes.dex */
public interface GMRewardedAdLoadCallback {
    void onRewardVideoAdLoad();

    void onRewardVideoCached();

    void onRewardVideoLoadFail(@NonNull AdError adError);
}
