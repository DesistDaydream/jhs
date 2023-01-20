package com.bytedance.msdk.api.v2.ad.reward;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.base.TTLoadBase;
import com.bytedance.msdk.api.v2.ad.GMBaseAd;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GMRewardAd extends GMBaseAd implements TTLoadBase {
    private j b;

    public GMRewardAd(Activity activity, String str) {
        this.b = new j(activity, str);
    }

    public void destroy() {
        j jVar = this.b;
        if (jVar != null) {
            jVar.B();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        j jVar = this.b;
        return jVar != null ? jVar.C() : new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Deprecated
    public int getAdNetworkPlatformId() {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.E();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    @Deprecated
    public String getAdNetworkRitId() {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.F();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getBestEcpm() {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getCacheList() {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.c();
        }
        return null;
    }

    public Map<String, Object> getMediaExtraInfo() {
        j jVar = this.b;
        return jVar != null ? jVar.G() : new HashMap();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getMultiBiddingEcpm() {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.f();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    @Deprecated
    public String getPreEcpm() {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.H();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getShowEcpm() {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.J();
        }
        return null;
    }

    public boolean isReady() {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.g0();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMBaseAd
    public void loadAd(GMAdSlotRewardVideo gMAdSlotRewardVideo, @NonNull GMRewardedAdLoadCallback gMRewardedAdLoadCallback) {
        AdError adError;
        super.loadAd(gMAdSlotRewardVideo, gMRewardedAdLoadCallback);
        if (this.b != null) {
            if (!a.f().a(this.b.l(), 7) && gMRewardedAdLoadCallback != null) {
                adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            } else if (a.f().F()) {
                this.b.a(getAdSlot(), gMAdSlotRewardVideo, gMRewardedAdLoadCallback);
                return;
            } else if (gMRewardedAdLoadCallback == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_CODE_REWARD_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_REWARD_MODULE_UNABLE));
            }
            gMRewardedAdLoadCallback.onRewardVideoLoadFail(adError);
        }
    }

    public void setRewardAdListener(GMRewardedAdListener gMRewardedAdListener) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.a(gMRewardedAdListener);
        }
    }

    public void setRewardPlayAgainListener(GMRewardedAdListener gMRewardedAdListener) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.b(gMRewardedAdListener);
        }
    }

    @MainThread
    public void showRewardAd(Activity activity) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.a(activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
            this.b.b((TTBaseAd) null);
        }
    }

    @MainThread
    public void showRewardAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        j jVar = this.b;
        if (jVar != null) {
            jVar.a(activity, map);
        }
    }
}
