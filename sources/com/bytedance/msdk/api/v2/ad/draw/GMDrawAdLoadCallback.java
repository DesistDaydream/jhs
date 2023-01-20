package com.bytedance.msdk.api.v2.ad.draw;

import com.bytedance.msdk.api.AdError;
import java.util.List;

/* loaded from: classes.dex */
public interface GMDrawAdLoadCallback {
    void onAdLoadFail(AdError adError);

    void onAdLoadSuccess(List<GMDrawAd> list);
}
