package com.bytedance.msdk.adapter.ad;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GMSplashBaseAdapter extends TTAbsAdLoaderAdapter {
    public GMAdSlotSplash mGMAdSlotSplash;

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        GMAdSlotBase gMAdSlotBase = this.mGMAdSlotBase;
        if (gMAdSlotBase instanceof GMAdSlotSplash) {
            this.mGMAdSlotSplash = (GMAdSlotSplash) gMAdSlotBase;
        } else {
            notifyAdFailed(new AdError("ClassCastException：load ad fail mGMAdSlotSplash is not GMAdSlotSplash"));
        }
    }

    public void notifyLoadFailBecauseGMAdSlotIsNull() {
        notifyAdFailed(new AdError("load ad fail mGMAdSlotSplash is null"));
    }
}
