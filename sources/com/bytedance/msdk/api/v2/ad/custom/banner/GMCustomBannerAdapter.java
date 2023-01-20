package com.bytedance.msdk.api.v2.ad.custom.banner;

import android.content.Context;
import android.view.View;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomServiceConfig;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GMCustomBannerAdapter extends GMCustomBaseAdapter implements IGMCustomBannerEvent, IGMCustomLoadAdCall {

    /* renamed from: h */
    private volatile boolean f2055h = false;

    @Override // com.bytedance.msdk.api.v2.ad.custom.banner.IGMCustomBannerEvent
    public final void callBannerAdClicked() {
        if (this.f2055h && this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.banner.GMCustomBannerAdapter.2
                {
                    GMCustomBannerAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomBannerAdapter.this.checkClick(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.banner.GMCustomBannerAdapter.2.1
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMBannerAdListener gMBannerAdListener = (GMBannerAdListener) GMCustomBannerAdapter.this.f2057d.getTTAdapterCallback();
                            if (gMBannerAdListener != null) {
                                gMBannerAdListener.onAdClicked();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.banner.IGMCustomBannerEvent
    public final void callBannerAdClosed() {
        if (this.f2055h && this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.banner.GMCustomBannerAdapter.3
                {
                    GMCustomBannerAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMBannerAdListener gMBannerAdListener = (GMBannerAdListener) GMCustomBannerAdapter.this.f2057d.getTTAdapterCallback();
                    if (gMBannerAdListener != null) {
                        gMBannerAdListener.onAdClosed();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.banner.IGMCustomBannerEvent
    public final void callBannerAdLeftApplication() {
        if (this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.banner.GMCustomBannerAdapter.5
                {
                    GMCustomBannerAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMBannerAdListener gMBannerAdListener = (GMBannerAdListener) GMCustomBannerAdapter.this.f2057d.getTTAdapterCallback();
                    if (gMBannerAdListener != null) {
                        gMBannerAdListener.onAdLeftApplication();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.banner.IGMCustomBannerEvent
    public final void callBannerAdOpened() {
        if (this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.banner.GMCustomBannerAdapter.4
                {
                    GMCustomBannerAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMBannerAdListener gMBannerAdListener = (GMBannerAdListener) GMCustomBannerAdapter.this.f2057d.getTTAdapterCallback();
                    if (gMBannerAdListener != null) {
                        gMBannerAdListener.onAdOpened();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.banner.IGMCustomBannerEvent
    public final void callBannerAdShow() {
        if (this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.banner.GMCustomBannerAdapter.1
                {
                    GMCustomBannerAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMBannerAdListener gMBannerAdListener = (GMBannerAdListener) GMCustomBannerAdapter.this.f2057d.getTTAdapterCallback();
                    if (gMBannerAdListener != null) {
                        GMCustomBannerAdapter.this.f2055h = true;
                        gMBannerAdListener.onAdShow();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public final void callLoadFail(GMCustomAdError gMCustomAdError) {
        if (isCallLoadFailCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_CODE_CUSTOM_BANNER_LOAD_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_BANNER_LOAD_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public final void callLoadSuccess() {
        callLoadSuccess(0.0d, null);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public final void callLoadSuccess(double d2) {
        callLoadSuccess(d2, null);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public void callLoadSuccess(double d2, Map<String, Object> map) {
        if (isCallLoadSuccessCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        Logger.e("TTMediationSDK", "自定义Adapter callLoadSuccess");
        GMCustomBannerAd gMCustomBannerAd = new GMCustomBannerAd();
        this.f2057d = gMCustomBannerAd;
        gMCustomBannerAd.setMediaExtraInfo(this.f2060g);
        this.f2057d.setAdType(this.b.t());
        if (d2 > 0.0d && getBiddingType() == 1) {
            this.f2057d.setCpm(d2);
        }
        this.f2057d.putExtraMsg(map);
        this.f2057d.setGMCustomBaseAdapter(this);
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.notifyAdLoaded(this.f2057d);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public void callLoadSuccess(Map<String, Object> map) {
        callLoadSuccess(0.0d, map);
    }

    public abstract View getAdView();

    public final View getAdViewInner() {
        try {
            return getAdView();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public abstract void load(Context context, GMAdSlotBanner gMAdSlotBanner, GMCustomServiceConfig gMCustomServiceConfig);

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig) {
        if (gMAdSlotBase instanceof GMAdSlotBanner) {
            load(context, (GMAdSlotBanner) gMAdSlotBase, gMCustomServiceConfig);
        } else {
            callLoadFail(new GMCustomAdError(AdError.ERROR_ADN_NO_ERROR_CODE, "ClassCastException：load ad fail adSlot is not GMAdSlotBanner"));
        }
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            this.f2060g = hashMap;
            hashMap.putAll(map);
        }
    }
}
