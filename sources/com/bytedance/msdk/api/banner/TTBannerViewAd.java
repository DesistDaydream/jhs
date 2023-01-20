package com.bytedance.msdk.api.banner;

import android.app.Activity;
import android.view.View;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.i;
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
public class TTBannerViewAd implements TTLoadBase {
    private i a;

    public TTBannerViewAd(Activity activity, String str) {
        this.a = new i(activity, str);
    }

    public void destroy() {
        i iVar = this.a;
        if (iVar != null) {
            iVar.a();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        i iVar = this.a;
        return iVar != null ? iVar.b() : new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.c();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    public String getAdNetworkRitId() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.d();
        }
        return null;
    }

    @Nullable
    public View getBannerView() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.e();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getBestEcpm() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.f();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getCacheList() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.g();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<GMAdEcpmInfo> getMultiBiddingEcpm() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.i();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    @Nullable
    public String getPreEcpm() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.j();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public GMAdEcpmInfo getShowEcpm() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.l();
        }
        return null;
    }

    public void loadAd(AdSlot adSlot, TTAdBannerLoadCallBack tTAdBannerLoadCallBack) {
        AdError adError;
        if (this.a != null) {
            if (!a.f().a(this.a.m(), 1) && tTAdBannerLoadCallBack != null) {
                adError = new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME));
            } else if (a.f().w()) {
                this.a.a(adSlot, AdUtils.getAdSlotBanner(adSlot), tTAdBannerLoadCallBack);
                return;
            } else if (tTAdBannerLoadCallBack == null) {
                return;
            } else {
                adError = new AdError(AdError.ERROR_CODE_BANNER_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_BANNER_MODULE_UNABLE));
            }
            tTAdBannerLoadCallBack.onAdFailedToLoad(adError);
        }
    }

    public void setAllowShowCloseBtn(boolean z) {
        i iVar = this.a;
        if (iVar != null) {
            iVar.a(z);
        }
    }

    @Deprecated
    public void setRefreshTime(int i2) {
    }

    public void setTTAdBannerListener(TTAdBannerListener tTAdBannerListener) {
        i iVar = this.a;
        if (iVar != null) {
            iVar.a(tTAdBannerListener);
        }
    }
}
