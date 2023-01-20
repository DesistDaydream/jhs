package com.bytedance.msdk.api.nativeAd;

import android.content.Context;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.h;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.ad.AdUtils;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeUtil;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class TTUnifiedNativeAd implements GMNativeAdLoadCallback {
    private h a;
    private TTNativeAdLoadCallback b;

    public TTUnifiedNativeAd(Context context, String str) {
        this.a = new h(context, str);
    }

    public void destroy() {
        h hVar = this.a;
        if (hVar != null) {
            hVar.B();
        }
    }

    public List<AdLoadInfo> getAdLoadInfoList() {
        h hVar = this.a;
        return hVar != null ? hVar.C() : new ArrayList();
    }

    public List<GMAdEcpmInfo> getCacheList() {
        h hVar = this.a;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    public List<GMAdEcpmInfo> getMultiBiddingEcpm() {
        h hVar = this.a;
        if (hVar != null) {
            return hVar.f();
        }
        return null;
    }

    public void loadAd(AdSlot adSlot, TTNativeAdLoadCallback tTNativeAdLoadCallback) {
        AdError adError;
        this.b = tTNativeAdLoadCallback;
        if (this.a != null) {
            if (a.f().a(this.a.l(), 5) || tTNativeAdLoadCallback == null) {
                if (adSlot != null) {
                    if (adSlot.getAdStyleType() == 1) {
                        if (!a.f().z()) {
                            if (tTNativeAdLoadCallback == null) {
                                return;
                            }
                            adError = new AdError(AdError.ERROR_CODE_FEED_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_FEED_MODULE_UNABLE));
                        }
                    } else if (adSlot.getAdStyleType() == 2 && !a.f().D()) {
                        if (tTNativeAdLoadCallback == null) {
                            return;
                        }
                        adError = new AdError(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE));
                    }
                }
                this.a.a(adSlot, AdUtils.getAdSlotNative(adSlot), this);
                return;
            }
            adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            tTNativeAdLoadCallback.onAdLoadedFial(adError);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback
    public void onAdLoaded(@NonNull List<GMNativeAd> list) {
        TTNativeAdLoadCallback tTNativeAdLoadCallback = this.b;
        if (tTNativeAdLoadCallback != null) {
            tTNativeAdLoadCallback.onAdLoaded(GMNativeUtil.GMsToTTs(list));
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback
    public void onAdLoadedFail(@NonNull AdError adError) {
        TTNativeAdLoadCallback tTNativeAdLoadCallback = this.b;
        if (tTNativeAdLoadCallback != null) {
            tTNativeAdLoadCallback.onAdLoadedFial(adError);
        }
    }
}
