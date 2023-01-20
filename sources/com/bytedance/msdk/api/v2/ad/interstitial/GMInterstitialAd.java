package com.bytedance.msdk.api.v2.ad.interstitial;

import android.app.Activity;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.c;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.base.TTLoadBase;
import com.bytedance.msdk.api.v2.ad.GMBaseAd;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GMInterstitialAd extends GMBaseAd implements TTLoadBase {
    private c b;

    public GMInterstitialAd(Activity activity, String str) {
        this.b = new c(activity, str);
    }

    public void destroy() {
        c cVar = this.b;
        if (cVar != null) {
            cVar.B();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        c cVar = this.b;
        return cVar != null ? cVar.C() : new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Deprecated
    public int getAdNetworkPlatformId() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.E();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    @Deprecated
    public String getAdNetworkRitId() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.F();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getBestEcpm() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getCacheList() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public Map<String, Object> getMediaExtraInfo() {
        c cVar = this.b;
        return cVar != null ? cVar.G() : new HashMap();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getMultiBiddingEcpm() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    @Deprecated
    public String getPreEcpm() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.H();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getShowEcpm() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.J();
        }
        return null;
    }

    public boolean isReady() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.g0();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMBaseAd
    public void loadAd(GMAdSlotInterstitial gMAdSlotInterstitial, GMInterstitialAdLoadCallback gMInterstitialAdLoadCallback) {
        AdError adError;
        super.loadAd(gMAdSlotInterstitial, gMInterstitialAdLoadCallback);
        if (this.b != null) {
            if (!a.f().a(this.b.l(), 2) && gMInterstitialAdLoadCallback != null) {
                adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            } else if (a.f().B()) {
                this.b.a(getAdSlot(), gMAdSlotInterstitial, gMInterstitialAdLoadCallback);
                return;
            } else if (gMInterstitialAdLoadCallback == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_CODE_INTERACTION_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_INTERACTION_MODULE_UNABLE));
            }
            gMInterstitialAdLoadCallback.onInterstitialLoadFail(adError);
        }
    }

    public void setAdInterstitialListener(GMInterstitialAdListener gMInterstitialAdListener) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(gMInterstitialAdListener);
        }
    }

    public void showAd(Activity activity) {
        c cVar = this.b;
        if (cVar != null) {
            if (activity == null) {
                Logger.e("TTMediationSDK", "activity can not be null !");
                return;
            }
            cVar.a(activity);
            this.b.b((TTBaseAd) null);
        }
    }
}
