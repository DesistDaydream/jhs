package com.bytedance.msdk.api.reward;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.base.TTLoadBase;
import com.bytedance.msdk.api.v2.ad.AdUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class TTRewardAd implements TTLoadBase {
    private j a;

    public TTRewardAd(Activity activity, String str) {
        this.a = new j(activity, str);
    }

    public void destroy() {
        j jVar = this.a;
        if (jVar != null) {
            jVar.B();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        j jVar = this.a;
        return jVar != null ? jVar.C() : new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        j jVar = this.a;
        if (jVar != null) {
            return jVar.E();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    public String getAdNetworkRitId() {
        j jVar = this.a;
        if (jVar != null) {
            return jVar.F();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getBestEcpm() {
        j jVar = this.a;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getCacheList() {
        j jVar = this.a;
        if (jVar != null) {
            return jVar.c();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getMultiBiddingEcpm() {
        j jVar = this.a;
        if (jVar != null) {
            return jVar.f();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    public String getPreEcpm() {
        j jVar = this.a;
        if (jVar != null) {
            return jVar.H();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getShowEcpm() {
        j jVar = this.a;
        if (jVar != null) {
            return jVar.J();
        }
        return null;
    }

    public boolean isReady() {
        j jVar = this.a;
        if (jVar != null) {
            return jVar.g0();
        }
        return false;
    }

    public void loadRewardAd(AdSlot adSlot, @NonNull TTRewardedAdLoadCallback tTRewardedAdLoadCallback) {
        AdError adError;
        if (this.a != null) {
            if (!a.f().a(this.a.l(), 7) && tTRewardedAdLoadCallback != null) {
                adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            } else if (a.f().F()) {
                this.a.a(adSlot, AdUtils.getAdSlotRewardVideo(adSlot), tTRewardedAdLoadCallback);
                return;
            } else if (tTRewardedAdLoadCallback == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_CODE_REWARD_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_REWARD_MODULE_UNABLE));
            }
            tTRewardedAdLoadCallback.onRewardVideoLoadFail(adError);
        }
    }

    public void setRewardAdListener(TTRewardedAdListener tTRewardedAdListener) {
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(tTRewardedAdListener);
        }
    }

    public void setRewardPlayAgainListener(TTRewardedAdListener tTRewardedAdListener) {
        j jVar = this.a;
        if (jVar != null) {
            jVar.b(tTRewardedAdListener);
        }
    }

    @MainThread
    public void showRewardAd(Activity activity) {
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
        }
    }

    @MainThread
    @Deprecated
    public void showRewardAd(Activity activity, TTRewardedAdListener tTRewardedAdListener) {
        showRewardAd(activity, null, tTRewardedAdListener);
    }

    @MainThread
    public void showRewardAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(activity, map);
        }
    }

    @MainThread
    @Deprecated
    public void showRewardAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, TTRewardedAdListener tTRewardedAdListener) {
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(tTRewardedAdListener);
            this.a.a(activity, map);
        }
    }
}
