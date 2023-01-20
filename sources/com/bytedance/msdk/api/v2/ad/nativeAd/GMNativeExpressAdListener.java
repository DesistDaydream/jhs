package com.bytedance.msdk.api.v2.ad.nativeAd;

import android.view.View;

/* loaded from: classes.dex */
public interface GMNativeExpressAdListener extends GMNativeAdListener {
    void onRenderFail(View view, String str, int i2);

    void onRenderSuccess(float f2, float f3);
}
