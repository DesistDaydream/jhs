package com.bytedance.msdk.api.v2.ad.custom.base;

import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd;
import java.util.List;

/* loaded from: classes.dex */
public interface IGMCustomLoadNativeCall {
    void callLoadFail(GMCustomAdError gMCustomAdError);

    void callLoadSuccess(List<? extends GMCustomNativeAd> list);
}
