package com.bytedance.msdk.api.v2.ad.custom.interstitial;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomVideoAdapter;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomServiceConfig;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GMCustomInterstitialAdapter extends GMCustomVideoAdapter implements IGMCustomInterstitialEvent {

    /* renamed from: h */
    private volatile boolean f2077h = false;

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialAdClick() {
        if (this.f2077h && this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.2
                {
                    GMCustomInterstitialAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomInterstitialAdapter.this.checkClick(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.2.1
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) GMCustomInterstitialAdapter.this.f2057d.getTTAdapterCallback();
                            if (gMInterstitialAdListener != null) {
                                gMInterstitialAdListener.onInterstitialAdClick();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialAdLeftApplication() {
        if (this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.5
                {
                    GMCustomInterstitialAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) GMCustomInterstitialAdapter.this.f2057d.getTTAdapterCallback();
                    if (gMInterstitialAdListener != null) {
                        gMInterstitialAdListener.onAdLeftApplication();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialAdOpened() {
        if (this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.4
                {
                    GMCustomInterstitialAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) GMCustomInterstitialAdapter.this.f2057d.getTTAdapterCallback();
                    if (gMInterstitialAdListener != null) {
                        gMInterstitialAdListener.onAdOpened();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialClosed() {
        if (this.f2077h && this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.3
                {
                    GMCustomInterstitialAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) GMCustomInterstitialAdapter.this.f2057d.getTTAdapterCallback();
                    if (gMInterstitialAdListener != null) {
                        gMInterstitialAdListener.onInterstitialClosed();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialShow() {
        if (this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.1
                {
                    GMCustomInterstitialAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomInterstitialAdapter.this.checkShow(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) GMCustomInterstitialAdapter.this.f2057d.getTTAdapterCallback();
                            if (gMInterstitialAdListener != null) {
                                GMCustomInterstitialAdapter.this.f2077h = true;
                                gMInterstitialAdListener.onInterstitialShow();
                            }
                        }
                    });
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
            tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_CODE_CUSTOM_INTERSTITIAL_LOAD_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_INTERSTITIAL_LOAD_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
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
        GMCustomInterstitialAd gMCustomInterstitialAd = new GMCustomInterstitialAd();
        this.f2057d = gMCustomInterstitialAd;
        gMCustomInterstitialAd.setMediaExtraInfo(this.f2060g);
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

    public abstract void load(Context context, GMAdSlotInterstitial gMAdSlotInterstitial, GMCustomServiceConfig gMCustomServiceConfig);

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig) {
        GMAdSlotInterstitial gMAdSlotInterstitial;
        if (gMAdSlotBase instanceof GMAdSlotInterstitialFull) {
            gMAdSlotInterstitial = ((GMAdSlotInterstitialFull) gMAdSlotBase).getGMAdSlotInterstitial();
        } else if (!(gMAdSlotBase instanceof GMAdSlotInterstitial)) {
            callLoadFail(new GMCustomAdError(AdError.ERROR_ADN_NO_ERROR_CODE, "ClassCastException：load ad fail adSlot is not GMAdSlotInterstitialFull or GMAdSlotInterstitial"));
            return;
        } else {
            gMAdSlotInterstitial = (GMAdSlotInterstitial) gMAdSlotBase;
        }
        load(context, gMAdSlotInterstitial, gMCustomServiceConfig);
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            this.f2060g = hashMap;
            hashMap.putAll(map);
        }
    }
}
