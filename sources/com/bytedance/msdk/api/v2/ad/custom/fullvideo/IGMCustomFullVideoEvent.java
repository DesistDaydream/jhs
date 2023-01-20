package com.bytedance.msdk.api.v2.ad.custom.fullvideo;

import com.bytedance.msdk.api.reward.RewardItem;

/* loaded from: classes.dex */
public interface IGMCustomFullVideoEvent {
    void callFullVideoAdClick();

    void callFullVideoAdClosed();

    void callFullVideoAdShow();

    void callFullVideoComplete();

    void callFullVideoError();

    void callFullVideoRewardVerify(RewardItem rewardItem);

    void callFullVideoSkippedVideo();
}
