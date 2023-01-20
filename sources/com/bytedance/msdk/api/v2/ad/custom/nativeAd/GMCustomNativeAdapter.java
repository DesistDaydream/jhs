package com.bytedance.msdk.api.v2.ad.custom.nativeAd;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadNativeCall;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomServiceConfig;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class GMCustomNativeAdapter extends GMCustomBaseAdapter implements IGMCustomLoadNativeCall {

    /* renamed from: h */
    private GMCustomServiceConfig f2089h;

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadNativeCall
    public final void callLoadFail(GMCustomAdError gMCustomAdError) {
        if (isCallLoadFailCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_CODE_CUSTOM_NATIVE_LOAD_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_NATIVE_LOAD_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadNativeCall
    public final void callLoadSuccess(List<? extends GMCustomNativeAd> list) {
        if (list != null) {
            if (isCallLoadSuccessCall()) {
                Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
                return;
            }
            Logger.e("TTMediationSDK", "自定义Adapter callLoadSuccess");
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                GMCustomNativeAd gMCustomNativeAd = list.get(i2);
                gMCustomNativeAd.setGMCustomBaseAdapter(this);
                gMCustomNativeAd.setAdType(this.b.t());
                gMCustomNativeAd.setExpressAd(this.b.s() != 2);
                arrayList.add(gMCustomNativeAd);
            }
            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
            if (tTAbsAdLoaderAdapter != null) {
                tTAbsAdLoaderAdapter.notifyAdLoadedCustom(arrayList);
            }
        }
    }

    public final boolean isExpressRender() {
        GMCustomServiceConfig gMCustomServiceConfig = this.f2089h;
        return gMCustomServiceConfig != null && gMCustomServiceConfig.getAdStyleType() == 1;
    }

    public final boolean isNativeAd() {
        GMCustomServiceConfig gMCustomServiceConfig = this.f2089h;
        return gMCustomServiceConfig != null && gMCustomServiceConfig.getAdStyleType() == 2;
    }

    public abstract void load(Context context, GMAdSlotNative gMAdSlotNative, GMCustomServiceConfig gMCustomServiceConfig);

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public final void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig) {
        this.f2089h = gMCustomServiceConfig;
        if (gMAdSlotBase instanceof GMAdSlotNative) {
            load(context, (GMAdSlotNative) gMAdSlotBase, gMCustomServiceConfig);
        } else {
            callLoadFail(new GMCustomAdError(AdError.ERROR_ADN_NO_ERROR_CODE, "ClassCastException：load ad fail adSlot is not GMAdSlotNative"));
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public final void onDestroy() {
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public final void onPause() {
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public final void onResume() {
    }
}
