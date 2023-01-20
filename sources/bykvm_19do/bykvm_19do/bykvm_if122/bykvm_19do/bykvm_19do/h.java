package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f0;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.v2.ad.GMAdTokenCallback;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTBaseAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMPrimeNativeAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class h extends e {
    private GMNativeAdLoadCallback g0;
    private GMAdTokenCallback h0;

    /* loaded from: classes.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a.c
        public void a() {
            h.this.L = true;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a.c
        public void a(GMNativeAd gMNativeAd) {
            h.this.a(gMNativeAd, false);
            h.this.a(gMNativeAd);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.c {
        public b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a.c
        public void a() {
            h.this.L = true;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a.c
        public void a(GMNativeAd gMNativeAd) {
            h.this.a(gMNativeAd, false);
        }
    }

    public h(Context context, String str) {
        super(context, str);
    }

    private List<GMNativeAd> a(List<TTBaseAd> list, int i2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<TTBaseAd> it = list.iterator();
        while (it.hasNext() && arrayList2.size() < i2) {
            TTBaseAd next = it.next();
            arrayList.add(next);
            if (Logger.isDebug()) {
                Logger.e("TTMediationSDK", "");
                Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f896f, TTLogUtil.TAG_EVENT_SHOW) + "返回给开发者最终广告：slotId=" + next.getAdNetworkSlotId() + ",slotType:" + next.getAdNetworkSlotType() + ",cpm=" + next.getCpm() + ",广告类型：" + e.c.c.a.a.b(next.getAdNetworkPlatformId()) + ",ImageMode=" + next.getImageMode() + ",showSort=" + next.getShowSort() + ",isExpressAd=" + next.isExpressAd());
            }
            arrayList2.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a(next, this.f898h, new a()));
            it.remove();
        }
        a(arrayList);
        return arrayList2;
    }

    private void a(AdSlot adSlot, GMAdSlotNative gMAdSlotNative) {
        int i2;
        AdSlot adSlot2;
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_feed");
        }
        if (d0()) {
            AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            this.f898h = shallowCopy;
            if (shallowCopy != null) {
                shallowCopy.setAdType(5);
                if (this.f898h.getAdCount() <= 0) {
                    adSlot2 = this.f898h;
                    i2 = 1;
                } else {
                    i2 = 3;
                    if (this.f898h.getAdCount() > 3) {
                        adSlot2 = this.f898h;
                    }
                    TTVideoOptionUtil.setFeedTTVideoOptionIfNeed(this.f898h);
                }
                adSlot2.setAdCount(i2);
                TTVideoOptionUtil.setFeedTTVideoOptionIfNeed(this.f898h);
            }
            this.w = gMAdSlotNative;
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GMNativeAd gMNativeAd) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar;
        TTBaseAd tTBaseAd = gMNativeAd.getTTBaseAd();
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() == 7 || (tTBaseAd instanceof GMCustomTTBaseAd) || (cVar = this.f894d) == null || cVar.I()) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().b(this.H, this.f896f, e());
    }

    private void a(String str, List<TTBaseAd> list) {
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> a2;
        TTBaseAd tTBaseAd;
        if (b(str, list) || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str, this.f898h, false) != 3 || (a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str, this.f898h)) == null || a2.size() <= 0) {
            return;
        }
        for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar : a2) {
            if (eVar != null && (tTBaseAd = eVar.a) != null && !tTBaseAd.isHasShown() && eVar.a.isReady(this.f896f)) {
                list.add(eVar.a);
                c(eVar.a);
            }
        }
    }

    private boolean b(String str, List<TTBaseAd> list) {
        if (list != null && list.size() > 0) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null && TextUtils.equals(str, tTBaseAd.getAdNetworkSlotId())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void e0() {
        List<TTBaseAd> list;
        try {
            List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> K = K();
            if (K == null || K.size() <= 0) {
                return;
            }
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar : K) {
                if (jVar != null) {
                    String d2 = jVar.d();
                    if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, d2, e())) {
                        if (jVar.f() == 100) {
                            list = this.q;
                        } else if (jVar.f() == 0) {
                            list = this.o;
                        }
                        a(d2, list);
                    }
                }
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.q, (Comparator<TTBaseAd>) null);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.o, (Comparator<TTBaseAd>) null);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.p, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.c());
            Logger.d("TMe", "--==-- sorted ok");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void f(List<TTBaseAd> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<TTBaseAd> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        for (TTBaseAd tTBaseAd : arrayList) {
            if (tTBaseAd != null && !tTBaseAd.isHasShown() && tTBaseAd.isReady(l())) {
                list.add(tTBaseAd);
            }
        }
    }

    private List<GMNativeAd> f0() {
        AdSlot adSlot = this.f898h;
        if (adSlot == null) {
            return null;
        }
        int adCount = adSlot.getAdCount();
        f(this.q);
        f(this.p);
        f(this.o);
        e0();
        List<TTBaseAd> u = u();
        u.size();
        return a(u, adCount);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.g0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void O() {
        List<GMNativeAd> f0;
        if (this.g0 == null || (f0 = f0()) == null || f0.size() <= 0) {
            return;
        }
        if (Logger.isDebug()) {
            Logger.e("TTMediationSDK", "返回给外部开发者的广告数量：sumList.size=" + f0.size());
        }
        for (GMNativeAd gMNativeAd : f0) {
            if (gMNativeAd != null) {
                if (gMNativeAd instanceof bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a) {
                    ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a) gMNativeAd).a(true);
                }
                if (gMNativeAd.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, gMNativeAd.getAdNetworkRitId(), e())) {
                    a(gMNativeAd.getTTBaseAd(), gMNativeAd.getAdNetworkRitId());
                }
            }
        }
        this.g0.onAdLoaded(f0);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void P() {
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void a(AdError adError) {
        GMAdTokenCallback gMAdTokenCallback;
        super.a(adError);
        if (this.A != 0 || (gMAdTokenCallback = this.h0) == null) {
            return;
        }
        this.A = 2;
        gMAdTokenCallback.onAdTokenLoadedFail(adError);
    }

    public void a(AdSlot adSlot, GMAdSlotNative gMAdSlotNative, GMAdTokenCallback gMAdTokenCallback) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar != null && cVar.I()) {
            this.h0 = gMAdTokenCallback;
            a(adSlot, gMAdSlotNative);
        } else if (gMAdTokenCallback != null) {
            gMAdTokenCallback.onAdTokenLoadedFail(new AdError(10014, AdError.getMessage(10014)));
        }
    }

    public void a(AdSlot adSlot, GMAdSlotNative gMAdSlotNative, GMNativeAdLoadCallback gMNativeAdLoadCallback) {
        this.g0 = gMNativeAdLoadCallback;
        a(adSlot, gMAdSlotNative);
    }

    public void a(GMNativeAd gMNativeAd, boolean z) {
        TTBaseAd tTBaseAd = gMNativeAd.getTTBaseAd();
        if (tTBaseAd != null && tTBaseAd.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f896f, gMNativeAd.getAdNetworkRitId(), e())) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(gMNativeAd.getAdNetworkRitId(), this.f898h, this.r, z, this.S, this.v, this.H, this.w);
        }
    }

    public void a(String str, GMNativeAdLoadCallback gMNativeAdLoadCallback) {
        AdError adError;
        if (this.A != 1) {
            if (gMNativeAdLoadCallback == null) {
                return;
            }
            adError = new AdError(10015, AdError.getMessage(10015));
        } else if (this.z) {
            if (gMNativeAdLoadCallback == null) {
                return;
            }
            adError = new AdError(AdError.ERROR_CODE_LOADED, AdError.getMessage(AdError.ERROR_CODE_LOADED));
        } else if (this.M) {
            Logger.e("TTMediationSDK", "调用过销毁方法_destroy()！！！");
            if (gMNativeAdLoadCallback == null) {
                return;
            }
            adError = new AdError(AdError.ERROR_CODE_DESTROY, AdError.getMessage(AdError.ERROR_CODE_DESTROY));
        } else if (!this.s.g()) {
            this.z = true;
            this.g0 = gMNativeAdLoadCallback;
            c(str);
            return;
        } else if (gMNativeAdLoadCallback == null) {
            return;
        } else {
            adError = new AdError(10010, "Ad load timeout!");
        }
        gMNativeAdLoadCallback.onAdLoadedFail(adError);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void a(List<TTBaseAd> list, AdError adError) {
        ArrayList arrayList;
        super.a(list, adError);
        if (this.g0 instanceof GMPrimeNativeAdLoadCallback) {
            if (f0.a(list)) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (TTBaseAd tTBaseAd : list) {
                    arrayList.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a(tTBaseAd, this.f898h, new b()));
                }
            }
            ((GMPrimeNativeAdLoadCallback) this.g0).onSingleAdLoad(arrayList, adError);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void b(AdError adError) {
        GMAdTokenCallback gMAdTokenCallback;
        GMNativeAdLoadCallback gMNativeAdLoadCallback = this.g0;
        if (gMNativeAdLoadCallback != null) {
            gMNativeAdLoadCallback.onAdLoadedFail(adError);
        }
        if (this.A != 0 || this.z || (gMAdTokenCallback = this.h0) == null) {
            return;
        }
        this.A = 2;
        gMAdTokenCallback.onAdTokenLoadedFail(adError);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void b(String str) {
        GMAdTokenCallback gMAdTokenCallback;
        super.b(str);
        if (this.A != 0 || (gMAdTokenCallback = this.h0) == null) {
            return;
        }
        this.A = 1;
        gMAdTokenCallback.onAdTokenLoaded(str);
    }
}
