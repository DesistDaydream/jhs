package com.bytedance.msdk.api.v2.ad.custom.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomServiceConfig;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GMCustomSplashAdapter extends GMCustomBaseAdapter implements IGMCustomSplashEvent, IGMCustomLoadAdCall {

    /* renamed from: h */
    private volatile boolean f2091h = false;

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public final void callLoadFail(GMCustomAdError gMCustomAdError) {
        if (isCallLoadFailCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_CODE_CUSTOM_SPLASH_LOAD_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_SPLASH_LOAD_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
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
        GMCustomSplashAd gMCustomSplashAd = new GMCustomSplashAd();
        this.f2057d = gMCustomSplashAd;
        gMCustomSplashAd.setMediaExtraInfo(this.f2060g);
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

    @Override // com.bytedance.msdk.api.v2.ad.custom.splash.IGMCustomSplashEvent
    public final void callSplashAdClicked() {
        if (this.f2091h && this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.1
                {
                    GMCustomSplashAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomSplashAdapter.this.checkClick(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMSplashAdListener gMSplashAdListener = (GMSplashAdListener) GMCustomSplashAdapter.this.f2057d.getTTAdapterCallback();
                            if (gMSplashAdListener != null) {
                                gMSplashAdListener.onAdClicked();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.splash.IGMCustomSplashEvent
    public final void callSplashAdDismiss() {
        if (this.f2091h && this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.4
                {
                    GMCustomSplashAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMSplashAdListener gMSplashAdListener = (GMSplashAdListener) GMCustomSplashAdapter.this.f2057d.getTTAdapterCallback();
                    if (gMSplashAdListener != null) {
                        gMSplashAdListener.onAdDismiss();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.splash.IGMCustomSplashEvent
    public final void callSplashAdShow() {
        if (this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.2
                {
                    GMCustomSplashAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomSplashAdapter.this.checkShow(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.2.1
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMSplashAdListener gMSplashAdListener = (GMSplashAdListener) GMCustomSplashAdapter.this.f2057d.getTTAdapterCallback();
                            if (gMSplashAdListener != null) {
                                GMCustomSplashAdapter.this.f2091h = true;
                                gMSplashAdListener.onAdShow();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.splash.IGMCustomSplashEvent
    public final void callSplashAdSkip() {
        if (this.f2091h && this.f2057d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.3
                {
                    GMCustomSplashAdapter.this = this;
                }

                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMSplashAdListener gMSplashAdListener = (GMSplashAdListener) GMCustomSplashAdapter.this.f2057d.getTTAdapterCallback();
                    if (gMSplashAdListener != null) {
                        gMSplashAdListener.onAdSkip();
                    }
                }
            });
        }
    }

    public abstract void load(Context context, GMAdSlotSplash gMAdSlotSplash, GMCustomServiceConfig gMCustomServiceConfig);

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig) {
        if (gMAdSlotBase instanceof GMAdSlotSplash) {
            load(context, (GMAdSlotSplash) gMAdSlotBase, gMCustomServiceConfig);
        } else {
            callLoadFail(new GMCustomAdError(AdError.ERROR_ADN_NO_ERROR_CODE, "ClassCastException：load ad fail adSlot is not GMAdSlotSplash"));
        }
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            this.f2060g = hashMap;
            hashMap.putAll(map);
        }
    }

    public abstract void showAd(ViewGroup viewGroup);

    public final void showAdInner(ViewGroup viewGroup) {
        try {
            this.a = true;
            showAd(viewGroup);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
