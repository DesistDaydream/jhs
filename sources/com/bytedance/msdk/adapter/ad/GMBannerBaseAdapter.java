package com.bytedance.msdk.adapter.ad;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GMBannerBaseAdapter extends TTAbsAdLoaderAdapter {
    public GMAdSlotBanner mGMAdSlotBanner;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int[] getBannerSize(int i2, GMAdSlotBanner gMAdSlotBanner) {
        switch (i2) {
            case 2:
                return new int[]{320, 100};
            case 3:
                return new int[]{300, 250};
            case 4:
                return new int[]{468, 60};
            case 5:
                return new int[]{728, 90};
            case 6:
                if (gMAdSlotBanner.getWidth() > 0 && gMAdSlotBanner.getHeight() > 0) {
                    return new int[]{gMAdSlotBanner.getWidth(), gMAdSlotBanner.getHeight()};
                }
                break;
        }
        return new int[]{320, 50};
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        GMAdSlotBase gMAdSlotBase = this.mGMAdSlotBase;
        if (gMAdSlotBase instanceof GMAdSlotBanner) {
            this.mGMAdSlotBanner = (GMAdSlotBanner) gMAdSlotBase;
        } else {
            notifyAdFailed(new AdError("ClassCastException：load ad fail mGMAdSlotBanner is not GMAdSlotBanner"));
        }
    }

    public void notifyLoadFailBecauseGMAdSlotIsNull() {
        notifyAdFailed(new AdError("load ad fail GMAdSlotBanner is null"));
    }
}
