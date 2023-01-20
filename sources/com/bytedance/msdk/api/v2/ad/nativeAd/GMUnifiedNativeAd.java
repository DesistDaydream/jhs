package com.bytedance.msdk.api.v2.ad.nativeAd;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.h;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.ad.GMAdTokenCallback;
import com.bytedance.msdk.api.v2.ad.GMBaseAd;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GMUnifiedNativeAd extends GMBaseAd {
    private h b;

    public GMUnifiedNativeAd(Context context, String str) {
        this.b = new h(context, str);
    }

    public void destroy() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.B();
        }
    }

    public List<AdLoadInfo> getAdLoadInfoList() {
        h hVar = this.b;
        return hVar != null ? hVar.C() : new ArrayList();
    }

    public List<GMAdEcpmInfo> getCacheList() {
        h hVar = this.b;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    public List<GMAdEcpmInfo> getMultiBiddingEcpm() {
        h hVar = this.b;
        if (hVar != null) {
            return hVar.f();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMBaseAd
    public void loadAd(GMAdSlotNative gMAdSlotNative, GMNativeAdLoadCallback gMNativeAdLoadCallback) {
        AdError adError;
        super.loadAd(gMAdSlotNative, gMNativeAdLoadCallback);
        if (this.b != null) {
            if (a.f().a(this.b.l(), 5) || gMNativeAdLoadCallback == null) {
                if (gMAdSlotNative != null) {
                    if (gMAdSlotNative.getAdStyleType() == 1) {
                        if (!a.f().z()) {
                            if (gMNativeAdLoadCallback == null) {
                                return;
                            }
                            adError = new AdError(AdError.ERROR_CODE_FEED_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_FEED_MODULE_UNABLE));
                        }
                    } else if (gMAdSlotNative.getAdStyleType() == 2 && !a.f().D()) {
                        if (gMNativeAdLoadCallback == null) {
                            return;
                        }
                        adError = new AdError(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE));
                    }
                }
                this.b.a(getAdSlot(), gMAdSlotNative, gMNativeAdLoadCallback);
                return;
            }
            adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            gMNativeAdLoadCallback.onAdLoadedFail(adError);
        }
    }

    public void loadAdByAdm(String str, GMNativeAdLoadCallback gMNativeAdLoadCallback) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(str, gMNativeAdLoadCallback);
        }
    }

    public void loadToken(GMAdSlotNative gMAdSlotNative, GMAdTokenCallback gMAdTokenCallback) {
        AdError adError;
        super.loadAd(gMAdSlotNative, (GMNativeAdLoadCallback) null);
        if (this.b != null) {
            if (a.f().a(this.b.l(), 5) || gMAdTokenCallback == null) {
                if (gMAdSlotNative != null) {
                    if (gMAdSlotNative.getAdStyleType() == 1) {
                        if (!a.f().z()) {
                            if (gMAdTokenCallback == null) {
                                return;
                            }
                            adError = new AdError(AdError.ERROR_CODE_FEED_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_FEED_MODULE_UNABLE));
                        }
                    } else if (gMAdSlotNative.getAdStyleType() == 2 && !a.f().D()) {
                        if (gMAdTokenCallback == null) {
                            return;
                        }
                        adError = new AdError(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE));
                    }
                }
                this.b.a(getAdSlot(), gMAdSlotNative, gMAdTokenCallback);
                return;
            }
            adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            gMAdTokenCallback.onAdTokenLoadedFail(adError);
        }
    }
}
