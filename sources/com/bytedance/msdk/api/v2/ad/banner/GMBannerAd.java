package com.bytedance.msdk.api.v2.ad.banner;

import android.app.Activity;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.i;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.base.TTLoadBase;
import com.bytedance.msdk.api.v2.ad.GMBaseAd;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GMBannerAd extends GMBaseAd implements TTLoadBase {
    private i b;

    public GMBannerAd(Activity activity, String str) {
        this.b = new i(activity, str);
    }

    public void destroy() {
        i iVar = this.b;
        if (iVar != null) {
            iVar.a();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        i iVar = this.b;
        return iVar != null ? iVar.b() : new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Deprecated
    public int getAdNetworkPlatformId() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.c();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    @Deprecated
    public String getAdNetworkRitId() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.d();
        }
        return null;
    }

    @Nullable
    public View getBannerView() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.e();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getBestEcpm() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.f();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getCacheList() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.g();
        }
        return null;
    }

    public Map<String, Object> getMediaExtraInfo() {
        i iVar = this.b;
        return iVar != null ? iVar.h() : new HashMap();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getMultiBiddingEcpm() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.i();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    @Deprecated
    public String getPreEcpm() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.j();
        }
        return null;
    }

    @VisibleForTesting
    public int getRefreshTime() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.k();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getShowEcpm() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.l();
        }
        return null;
    }

    @VisibleForTesting
    public boolean isAllSHowCloseBtn() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.n();
        }
        return false;
    }

    public boolean isReady() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.o();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMBaseAd
    public void loadAd(GMAdSlotBanner gMAdSlotBanner, GMBannerAdLoadCallback gMBannerAdLoadCallback) {
        AdError adError;
        super.loadAd(gMAdSlotBanner, gMBannerAdLoadCallback);
        if (this.b != null) {
            if (!a.f().a(this.b.m(), 1) && gMBannerAdLoadCallback != null) {
                adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            } else if (a.f().w()) {
                this.b.a(gMAdSlotBanner.isAllowShowCloseBtn());
                this.b.a(getAdSlot(), gMAdSlotBanner, gMBannerAdLoadCallback);
                return;
            } else if (gMBannerAdLoadCallback == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_CODE_BANNER_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_BANNER_MODULE_UNABLE));
            }
            gMBannerAdLoadCallback.onAdFailedToLoad(adError);
        }
    }

    public void onPause() {
        i iVar = this.b;
        if (iVar != null) {
            iVar.p();
        }
    }

    public void onResume() {
        i iVar = this.b;
        if (iVar != null) {
            iVar.q();
        }
    }

    public void setAdBannerListener(GMBannerAdListener gMBannerAdListener) {
        i iVar = this.b;
        if (iVar != null) {
            iVar.a(gMBannerAdListener);
        }
    }

    public void setNativeToBannerListener(GMNativeToBannerListener gMNativeToBannerListener) {
        i iVar = this.b;
        if (iVar != null) {
            iVar.a(gMNativeToBannerListener);
        }
    }
}
