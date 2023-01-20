package com.bytedance.msdk.api.v2.ad.fullvideo;

import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.reward.RewardItem;

/* loaded from: classes.dex */
public interface GMFullVideoAdListener extends ITTAdatperCallback {
    void onFullVideoAdClick();

    void onFullVideoAdClosed();

    void onFullVideoAdShow();

    void onFullVideoAdShowFail(@NonNull AdError adError);

    void onRewardVerify(@NonNull RewardItem rewardItem);

    void onSkippedVideo();

    void onVideoComplete();

    void onVideoError();
}
