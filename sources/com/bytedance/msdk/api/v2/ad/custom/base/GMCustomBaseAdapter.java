package com.bytedance.msdk.api.v2.ad.custom.base;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomServiceConfig;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GMCustomBaseAdapter {
    public static final int CLICK_TIMES = 60;
    public static final int SHOW_TIMES = 2;
    public j b;

    /* renamed from: c  reason: collision with root package name */
    public TTAbsAdLoaderAdapter f2056c;

    /* renamed from: d  reason: collision with root package name */
    public GMCustomAd f2057d;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f2060g;
    public boolean a = false;

    /* renamed from: e  reason: collision with root package name */
    public int f2058e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f2059f = 0;

    /* loaded from: classes.dex */
    public interface CheckCallback {
        void callback();
    }

    public final void checkClick(CheckCallback checkCallback) {
        int i2 = this.f2059f;
        if (i2 >= 60) {
            Logger.e("TTMediationSDK", "自定义Adapter click方法回调次数需要小于60次");
            return;
        }
        this.f2059f = i2 + 1;
        if (checkCallback != null) {
            checkCallback.callback();
        }
    }

    public final void checkLoadSuccess(CheckCallback checkCallback) {
        if (!isCallLoadSuccessCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 调用错误需要在load成功之后才可以调用");
        } else if (checkCallback != null) {
            checkCallback.callback();
        }
    }

    public final void checkShow(CheckCallback checkCallback) {
        String str;
        if (this.a) {
            int i2 = this.f2058e;
            if (i2 < 2) {
                this.f2058e = i2 + 1;
                if (checkCallback != null) {
                    checkCallback.callback();
                    return;
                }
                return;
            }
            str = "自定义Adapter show方法回调次数需要小于2次";
        } else {
            str = "自定义Adapter show方法回调必须由GroMore触发show时才会生效";
        }
        Logger.e("TTMediationSDK", str);
    }

    public final String getAdm() {
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        return tTAbsAdLoaderAdapter == null ? "" : tTAbsAdLoaderAdapter.getAdm();
    }

    public final int getBiddingType() {
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter == null) {
            return 0;
        }
        return tTAbsAdLoaderAdapter.getReqBiddingType();
    }

    public final String getCustomADNName() {
        j jVar = this.b;
        return jVar == null ? "" : jVar.e();
    }

    public final Object getExtraDataNoParse() {
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter == null) {
            return null;
        }
        return tTAbsAdLoaderAdapter.getExtraDataNoParse();
    }

    public final boolean isCallLoadFailCall() {
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter != null) {
            return tTAbsAdLoaderAdapter.hasNotifyFail();
        }
        return false;
    }

    public final boolean isCallLoadSuccessCall() {
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter != null) {
            return tTAbsAdLoaderAdapter.hasNotifySuccess();
        }
        return false;
    }

    public GMAdConstant.AdIsReadyStatus isReadyStatus() {
        return GMAdConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public final GMAdConstant.AdIsReadyStatus isReadyStatusInner() {
        try {
            return isReadyStatus();
        } catch (Exception e2) {
            e2.printStackTrace();
            return GMAdConstant.AdIsReadyStatus.ADN_NO_READY_API;
        }
    }

    public abstract void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig);

    public final void loadInner(Context context, AdSlot adSlot, final GMAdSlotBase gMAdSlotBase, final j jVar, Map<String, Object> map, i iVar, int i2, TTAbsAdLoaderAdapter.AdapterLoaderListener adapterLoaderListener) {
        Logger.e("TTMediationSDK_SDK_Init", "自定义ADN 开始加载广告对象 ----------   adSlot = " + jVar.d());
        this.b = jVar;
        map.put("const_is_custom", Boolean.TRUE);
        GMCustomTTAbsAdLoaderAdapter gMCustomTTAbsAdLoaderAdapter = new GMCustomTTAbsAdLoaderAdapter() { // from class: com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.1
            @Override // com.bytedance.msdk.api.v2.ad.custom.GMCustomTTAbsAdLoaderAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
            public String getAdNetWorkName() {
                j jVar2 = jVar;
                return jVar2 != null ? jVar2.e() : super.getAdNetWorkName();
            }

            @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
            public void loadAd(final Context context2, Map<String, Object> map2) {
                final GMCustomServiceConfig gMCustomServiceConfig = new GMCustomServiceConfig(GMCustomBaseAdapter.this.getCustomADNName(), jVar.d(), jVar.s(), jVar.z(), jVar.g());
                GMCustomAdapterConfiguration a = a.a(jVar.e());
                this.z = a != null ? a.getNetworkSdkVersion() : "";
                ThreadHelper.runOnThreadPool(new Runnable() { // from class: com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        GMCustomBaseAdapter.this.loadCustom(context2, gMAdSlotBase, gMCustomServiceConfig);
                    }
                });
            }
        };
        this.f2056c = gMCustomTTAbsAdLoaderAdapter;
        gMCustomTTAbsAdLoaderAdapter.setAdapterListener(adapterLoaderListener);
        this.f2056c.loadAdInter(context, jVar, map, adSlot, iVar, i2, gMAdSlotBase);
    }

    public final void nativeDislikeClick(TTBaseAd tTBaseAd, String str) {
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f2056c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.nativeDislikeClick(tTBaseAd, str, null);
        }
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void receiveBidResult(boolean z, double d2, int i2, Map<String, Object> map) {
    }
}
