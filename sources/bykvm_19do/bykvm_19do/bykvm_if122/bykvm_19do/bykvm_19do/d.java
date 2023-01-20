package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.o;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeToBannerListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d extends e implements ITTAdapterBannerAdListener {
    private GMBannerAdListener g0;
    private GMBannerAdLoadCallback h0;
    private boolean i0;
    private GMNativeToBannerListener j0;

    /* loaded from: classes.dex */
    public class a implements GMDislikeCallback {
        public final /* synthetic */ View a;

        public a(d dVar, View view) {
            this.a = view;
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onCancel() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onRefuse() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onSelected(int i2, String str) {
            View view = this.a;
            if (view != null) {
                View view2 = (View) view.getParent();
                if (view2 instanceof ViewGroup) {
                    ((ViewGroup) view2).removeViewInLayout(this.a);
                }
            }
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onShow() {
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ AdError a;

        public b(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.g0 != null) {
                d.this.g0.onAdShowFail(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements GMNativeAdInfo {
        public final /* synthetic */ TTBaseAd a;

        public c(d dVar, TTBaseAd tTBaseAd) {
            this.a = tTBaseAd;
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getActionText() {
            return this.a.getActionText();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public int getAdImageMode() {
            return this.a.getImageMode();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getDescription() {
            return this.a.getAdDescription();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public GMAdDislike getDislikeDialog(Activity activity) {
            return getDislikeDialog(activity, null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
            return this.a.getDislikeDialog(activity, map);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getIconUrl() {
            return this.a.getIconUrl();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public List<String> getImageList() {
            return this.a.getImages();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getImageUrl() {
            return this.a.getImageUrl();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public int getInteractionType() {
            return this.a.getInteractionType();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public GMNativeAdAppInfo getNativeAdAppInfo() {
            if (this.a.hasAppInfo()) {
                GMNativeAdAppInfo gMNativeAdAppInfo = new GMNativeAdAppInfo();
                gMNativeAdAppInfo.setAppName(this.a.getAppName());
                gMNativeAdAppInfo.setAuthorName(this.a.getAuthorName());
                gMNativeAdAppInfo.setPackageSizeBytes(this.a.getPackageSizeBytes());
                gMNativeAdAppInfo.setPermissionsUrl(this.a.getPermissionsUrl());
                gMNativeAdAppInfo.setPrivacyAgreement(this.a.getPrivacyAgreement());
                gMNativeAdAppInfo.setVersionName(this.a.getVersionName());
                gMNativeAdAppInfo.setPermissionsMap(this.a.getPermissionsMap());
                gMNativeAdAppInfo.setAppInfoExtra(this.a.getAppInfoExtra());
                return gMNativeAdAppInfo;
            }
            return null;
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getSource() {
            return this.a.getSource();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public double getStarRating() {
            return this.a.getStarRating();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getTitle() {
            return this.a.getAdTitle();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public boolean hasDislike() {
            return this.a.hasDislike();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder) {
            this.a.registerViewForInteraction(activity, viewGroup, list, list2, null, gMViewBinder);
        }
    }

    public d(Context context, String str) {
        super(context, str);
        this.i0 = false;
    }

    private void b(boolean z) {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null && tTBaseAd.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, this.N.getAdNetworkSlotId(), e())) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.N.getAdNetworkSlotId(), this.f898h, this.r, z, this.S, this.v, this.H, this.w);
        }
    }

    private GMNativeAdInfo d(TTBaseAd tTBaseAd) {
        return new c(this, tTBaseAd);
    }

    private void d(AdError adError) {
        ThreadHelper.runOnUiThread(new b(adError));
    }

    private View e(TTBaseAd tTBaseAd) {
        GMNativeToBannerListener gMNativeToBannerListener;
        this.N = tTBaseAd;
        tTBaseAd.setHasShown(true);
        this.N.setTTAdatperCallback(this.I);
        if (this.N.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, this.N.getAdNetworkSlotId(), e())) {
            TTBaseAd tTBaseAd2 = this.N;
            a(tTBaseAd2, tTBaseAd2.getAdNetworkSlotId());
        }
        b(false);
        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f896f, TTLogUtil.TAG_EVENT_SHOW) + "展示的广告类型：" + e.c.c.a.a.b(this.N.getAdNetworkPlatformId()) + ",slotId：" + this.N.getAdNetworkSlotId() + ",slotType:" + this.N.getAdNetworkSlotType());
        View adView = this.N.getAdView();
        if (!this.N.isCustomAd() && this.N.getSubAdType() == 4 && this.N.getOriginType() == 2 && (gMNativeToBannerListener = this.j0) != null) {
            try {
                adView = gMNativeToBannerListener.getGMBannerViewFromNativeAd(d(this.N));
                if (adView == null) {
                    Logger.d("TTMediationSDK", "--==-- getGMBannerViewFromNativeAd()返回null");
                }
            } catch (Throwable th) {
                Logger.d("TTMediationSDK", "--==-- getGMBannerViewFromNativeAd()发生异常，信息如下：");
                th.printStackTrace();
            }
        }
        if (this.N.hasDislike()) {
            this.N.setDislikeCallback((Activity) this.H, new a(this, adView));
        }
        return adView;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.g0 = null;
        this.h0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public String H() {
        if (this.i0) {
            return super.H();
        }
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public GMAdEcpmInfo J() {
        if (this.i0) {
            return super.J();
        }
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void O() {
        GMBannerAdLoadCallback gMBannerAdLoadCallback = this.h0;
        if (gMBannerAdLoadCallback != null) {
            gMBannerAdLoadCallback.onAdLoaded();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void P() {
    }

    public void a(AdSlot adSlot, GMAdSlotBase gMAdSlotBase, GMBannerAdLoadCallback gMBannerAdLoadCallback) {
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_banner");
        }
        if (d0()) {
            AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            this.f898h = shallowCopy;
            if (shallowCopy != null) {
                shallowCopy.setAdType(1);
                this.f898h.setAdCount(1);
            }
            this.h0 = gMBannerAdLoadCallback;
            this.I = this;
            this.w = gMAdSlotBase;
            S();
        }
    }

    public void a(GMBannerAdListener gMBannerAdListener) {
        this.g0 = gMBannerAdListener;
    }

    public void a(GMNativeToBannerListener gMNativeToBannerListener) {
        this.j0 = gMNativeToBannerListener;
    }

    public void a(boolean z) {
        this.r.put(TTRequestExtraParams.PARAM_BANNER_ALLOW_SHOW_CLOSE_BTN, Boolean.valueOf(z));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void b(AdError adError) {
        GMBannerAdLoadCallback gMBannerAdLoadCallback = this.h0;
        if (gMBannerAdLoadCallback != null) {
            gMBannerAdLoadCallback.onAdFailedToLoad(adError);
        }
    }

    public View e0() {
        View view;
        AdError adError;
        View view2;
        TTBaseAd tTBaseAd;
        TTBaseAd next;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> a2;
        TTBaseAd tTBaseAd2;
        synchronized (this) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
            view = null;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(this.f898h, cVar != null ? cVar.C() : null);
            if (!this.L && !this.b.get()) {
                List<TTBaseAd> u = u();
                List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> K = K();
                if (K != null && K.size() > 0) {
                    HashMap<String, TTBaseAd> d2 = d(u);
                    view2 = null;
                    for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar : K) {
                        if (jVar != null) {
                            String d3 = jVar.d();
                            TTBaseAd tTBaseAd3 = d2.get(d3);
                            if (tTBaseAd3 != null && tTBaseAd3.isReady(this.f896f) && !tTBaseAd3.isHasShown() && (view2 = e(tTBaseAd3)) != null) {
                                break;
                            } else if (jVar.a() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, d3, e()) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(d3, this.f898h, false) == 3 && (a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(d3, this.f898h)) != null && a2.size() > 0 && (tTBaseAd2 = a2.get(0).a) != null && tTBaseAd2.isReady(this.f896f) && !tTBaseAd2.isHasShown()) {
                                c(tTBaseAd2);
                                view2 = e(tTBaseAd2);
                                if (view2 != null) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    view2 = null;
                }
                if (view2 == null && u != null && u.size() > 0) {
                    Iterator<TTBaseAd> it = u.iterator();
                    while (it.hasNext() && ((next = it.next()) == null || !next.isReady(this.f896f) || next.isHasShown() || (view2 = e(next)) == null)) {
                    }
                }
                if (view2 != null) {
                    this.L = true;
                    if (this.N != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.N);
                        a(arrayList);
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, false);
                    if (this.g0 != null && (tTBaseAd = this.N) != null && tTBaseAd.getAdNetworkPlatformId() == 2) {
                        Logger.d("ADMOB_EVENT", TTLogUtil.getTagThirdLevelById(this.f896f, this.N.getAdNetworkSlotId()) + "mTTAdBannerListener-->Admob--->onAdShow......");
                        m.b().a(this.f896f + "");
                        m.b().j(this.f896f + "");
                        this.g0.onAdShow();
                        if (this.N != null) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f896f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.N.getAdNetworkSlotId() + "，广告类型：" + e.c.c.a.a.b(this.N.getAdNetworkPlatformId()));
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k.b().a(this.f896f, this.N.getAdNetworkSlotId());
                            l.b().e(this.f896f, this.N.getAdNetworkSlotId());
                        }
                        b(true);
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(this.N, this.f898h, 0, null, false);
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.b(this.f896f, this.N);
                    }
                    view = view2;
                } else {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(u, this.f898h);
                    adError = new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD));
                    d(adError);
                }
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a((List<TTBaseAd>) null, this.f898h);
            adError = new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD));
            d(adError);
        }
        return view;
    }

    @VisibleForTesting
    public boolean f0() {
        return ((Boolean) this.r.get(TTRequestExtraParams.PARAM_BANNER_ALLOW_SHOW_CLOSE_BTN)).booleanValue();
    }

    public boolean g0() {
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list;
        try {
            list = K();
        } catch (Throwable th) {
            th.printStackTrace();
            list = null;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        return o.a(this.q, this.p, this.o, this.f898h, this.L, this.b, l(), e(), list, cVar != null ? cVar.C() : null);
    }

    public void h0() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            tTBaseAd.onPause();
        }
    }

    public void i0() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            tTBaseAd.onResume();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdClicked() {
        GMBannerAdListener gMBannerAdListener = this.g0;
        if (gMBannerAdListener != null) {
            gMBannerAdListener.onAdClicked();
        }
        String b2 = t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null;
        TTBaseAd tTBaseAd = this.N;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.f898h, 0, b2, tTBaseAd.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdClosed() {
        GMBannerAdListener gMBannerAdListener = this.g0;
        if (gMBannerAdListener != null) {
            gMBannerAdListener.onAdClosed();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdLeftApplication() {
        GMBannerAdListener gMBannerAdListener = this.g0;
        if (gMBannerAdListener != null) {
            gMBannerAdListener.onAdLeftApplication();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdOpened() {
        GMBannerAdListener gMBannerAdListener = this.g0;
        if (gMBannerAdListener != null) {
            gMBannerAdListener.onAdOpened();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdShow() {
        this.i0 = true;
        if (this.g0 != null) {
            m b2 = m.b();
            b2.a(this.f896f + "");
            m b3 = m.b();
            b3.j(this.f896f + "");
            this.g0.onAdShow();
        }
        if (this.N != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f896f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.N.getAdNetworkSlotId() + "，广告类型：" + e.c.c.a.a.b(this.N.getAdNetworkPlatformId()));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k.b().a(this.f896f, this.N.getAdNetworkSlotId());
            l.b().e(this.f896f, this.N.getAdNetworkSlotId());
        }
        b(true);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(this.N, this.f898h, 0, t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null, false);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().b(this.N.getAdType(), this.N.getCpm());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.b(this.f896f, this.N);
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdShowFail(AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, adError, 1, 0, t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
        d(adError);
    }
}
