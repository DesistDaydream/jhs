package com.bytedance.msdk.api.v2.ad.draw;

import androidx.annotation.Nullable;
import com.bytedance.msdk.api.AdError;
import java.util.List;

/* loaded from: classes.dex */
public interface GMPrimeDrawAdLoadCallback extends GMDrawAdLoadCallback {
    void onSingleAdLoad(@Nullable List<GMDrawAd> list, @Nullable AdError adError);
}
