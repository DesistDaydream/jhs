package com.bytedance.msdk.adapter.ad;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GMRewardBaseAdapter extends TTAbsAdLoaderAdapter {
    public GMAdSlotRewardVideo mGMAdSlotRewardVideo;

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        GMAdSlotBase gMAdSlotBase = this.mGMAdSlotBase;
        if (gMAdSlotBase instanceof GMAdSlotRewardVideo) {
            this.mGMAdSlotRewardVideo = (GMAdSlotRewardVideo) gMAdSlotBase;
        } else {
            notifyAdFailed(new AdError("ClassCastException：load ad fail mGMAdSlotRewardVideo is not GMAdSlotRewardVideo"));
        }
    }

    public void notifyLoadFailBecauseGMAdSlotIsNull() {
        notifyAdFailed(new AdError("load ad fail mGMAdSlotRewardVideo is null"));
    }
}
