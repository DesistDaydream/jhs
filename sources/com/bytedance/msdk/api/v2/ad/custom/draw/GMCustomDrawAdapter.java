package com.bytedance.msdk.api.v2.ad.custom.draw;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadDrawCall;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomServiceConfig;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotDraw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class GMCustomDrawAdapter extends GMCustomBaseAdapter implements IGMCustomLoadDrawCall {

    /* renamed from: h */
    private GMCustomServiceConfig f2075h;

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadDrawCall
    public final void callLoadFail(GMCustomAdError gMCustomAdError) {
        if (isCallLoadFailCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_CODE_CUSTOM_DRAW_LOAD_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_DRAW_LOAD_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadDrawCall
    public final void callLoadSuccess(List<? extends GMCustomDrawAd> list) {
        if (list != null) {
            if (isCallLoadSuccessCall()) {
                Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
                return;
            }
            Logger.e("TTMediationSDK", "自定义Adapter callLoadSuccess");
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                GMCustomDrawAd gMCustomDrawAd = list.get(i2);
                gMCustomDrawAd.setGMCustomBaseAdapter(this);
                gMCustomDrawAd.setAdType(this.b.t());
                gMCustomDrawAd.setExpressAd(this.b.s() != 2);
                arrayList.add(gMCustomDrawAd);
            }
            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
            if (tTAbsAdLoaderAdapter != null) {
                tTAbsAdLoaderAdapter.notifyAdLoadedCustom(arrayList);
            }
        }
    }

    public final boolean isExpressRender() {
        GMCustomServiceConfig gMCustomServiceConfig = this.f2075h;
        return gMCustomServiceConfig != null && gMCustomServiceConfig.getAdStyleType() == 1;
    }

    public final boolean isNativeAd() {
        GMCustomServiceConfig gMCustomServiceConfig = this.f2075h;
        return gMCustomServiceConfig != null && gMCustomServiceConfig.getAdStyleType() == 2;
    }

    public abstract void load(Context context, GMAdSlotDraw gMAdSlotDraw, GMCustomServiceConfig gMCustomServiceConfig);

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public final void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig) {
        this.f2075h = gMCustomServiceConfig;
        load(context, (GMAdSlotDraw) gMAdSlotBase, gMCustomServiceConfig);
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
