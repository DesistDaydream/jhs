package com.bytedance.msdk.api.nativeAd;

import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;

@Deprecated
/* loaded from: classes.dex */
public interface TTNativeAd extends GMNativeAd {
    void setTTAdAppDownloadListener(GMAdAppDownloadListener gMAdAppDownloadListener);

    void setTTAdatperCallback(ITTAdatperCallback iTTAdatperCallback);

    void setTTNativeAdListener(GMNativeAdListener gMNativeAdListener);

    void setTTVideoListener(GMVideoListener gMVideoListener);
}
