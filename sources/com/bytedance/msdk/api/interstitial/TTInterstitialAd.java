package com.bytedance.msdk.api.interstitial;

import android.app.Activity;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.c;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.base.TTLoadBase;
import com.bytedance.msdk.api.v2.ad.AdUtils;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class TTInterstitialAd implements TTLoadBase {
    private c a;

    public TTInterstitialAd(Activity activity, String str) {
        this.a = new c(activity, str);
    }

    public void destroy() {
        c cVar = this.a;
        if (cVar != null) {
            cVar.B();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        c cVar = this.a;
        return cVar != null ? cVar.C() : new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.E();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    public String getAdNetworkRitId() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.F();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getBestEcpm() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getCacheList() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getMultiBiddingEcpm() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    public String getPreEcpm() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.H();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getShowEcpm() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.J();
        }
        return null;
    }

    public boolean isReady() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.g0();
        }
        return false;
    }

    public void loadAd(AdSlot adSlot, TTInterstitialAdLoadCallback tTInterstitialAdLoadCallback) {
        AdError adError;
        if (this.a != null) {
            if (!a.f().a(this.a.l(), 2) && tTInterstitialAdLoadCallback != null) {
                adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            } else if (a.f().B()) {
                this.a.a(adSlot, AdUtils.getAdSlotInterstitial(adSlot), tTInterstitialAdLoadCallback);
                return;
            } else if (tTInterstitialAdLoadCallback == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_CODE_INTERACTION_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_INTERACTION_MODULE_UNABLE));
            }
            tTInterstitialAdLoadCallback.onInterstitialLoadFail(adError);
        }
    }

    public void setTTAdInterstitialListener(TTInterstitialAdListener tTInterstitialAdListener) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(tTInterstitialAdListener);
        }
    }

    public void showAd(Activity activity) {
        c cVar = this.a;
        if (cVar != null) {
            if (activity == null) {
                Logger.e("TTMediationSDK", "activity can not be null !");
            } else {
                cVar.a(activity);
            }
        }
    }
}
