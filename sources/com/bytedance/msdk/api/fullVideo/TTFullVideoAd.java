package com.bytedance.msdk.api.fullVideo;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.g;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.base.TTLoadBase;
import com.bytedance.msdk.api.v2.ad.AdUtils;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class TTFullVideoAd implements TTLoadBase {
    private g a;

    public TTFullVideoAd(Activity activity, String str) {
        this.a = new g(activity, str);
    }

    public void destroy() {
        g gVar = this.a;
        if (gVar != null) {
            gVar.B();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        g gVar = this.a;
        return gVar != null ? gVar.C() : new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.E();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    public String getAdNetworkRitId() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.F();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getBestEcpm() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.b();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getCacheList() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getMultiBiddingEcpm() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.f();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    public String getPreEcpm() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.H();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getShowEcpm() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.J();
        }
        return null;
    }

    public boolean isReady() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.g0();
        }
        return false;
    }

    public void loadFullAd(AdSlot adSlot, @NonNull TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback) {
        AdError adError;
        if (this.a != null) {
            if (!a.f().a(this.a.l(), 8) && tTFullVideoAdLoadCallback != null) {
                adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            } else if (a.f().A()) {
                this.a.a(adSlot, AdUtils.getAdSlotFullVideo(adSlot), tTFullVideoAdLoadCallback);
                return;
            } else if (tTFullVideoAdLoadCallback == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_CODE_FULL_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_FULL_MODULE_UNABLE));
            }
            tTFullVideoAdLoadCallback.onFullVideoLoadFail(adError);
        }
    }

    public void setFullVideoAdListener(GMFullVideoAdListener gMFullVideoAdListener) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(gMFullVideoAdListener);
        }
    }

    @MainThread
    public void showFullAd(Activity activity) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
        }
    }

    @MainThread
    @Deprecated
    public void showFullAd(Activity activity, TTFullVideoAdListener tTFullVideoAdListener) {
        showFullAd(activity, null, tTFullVideoAdListener);
    }

    @MainThread
    public void showFullAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(activity, map);
        }
    }

    @MainThread
    @Deprecated
    public void showFullAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, TTFullVideoAdListener tTFullVideoAdListener) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(tTFullVideoAdListener);
            this.a.a(activity, map);
        }
    }
}
