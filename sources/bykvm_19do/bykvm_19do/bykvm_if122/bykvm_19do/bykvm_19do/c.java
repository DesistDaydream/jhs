package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.base.TTBaseAd;

/* loaded from: classes.dex */
public class c extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d implements ITTAdapterInterstitialListener {
    private GMInterstitialAdLoadCallback h0;
    private GMInterstitialAdListener i0;

    /* loaded from: classes.dex */
    public class a implements d.c {
        public a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.c
        public void a() {
            c.this.d(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
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
            if (c.this.i0 != null) {
                c.this.i0.onInterstitialShowFail(this.a);
            }
        }
    }

    public c(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AdError adError) {
        ThreadHelper.runOnUiThread(new b(adError));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.i0 = null;
        this.h0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void O() {
        GMInterstitialAdLoadCallback gMInterstitialAdLoadCallback = this.h0;
        if (gMInterstitialAdLoadCallback != null) {
            gMInterstitialAdLoadCallback.onInterstitialLoad();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void P() {
    }

    public void a(Activity activity) {
        a(activity, new a());
    }

    public void a(AdSlot adSlot, GMAdSlotInterstitial gMAdSlotInterstitial, GMInterstitialAdLoadCallback gMInterstitialAdLoadCallback) {
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_interstitial");
        }
        if (d0()) {
            AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            this.f898h = shallowCopy;
            if (shallowCopy != null) {
                shallowCopy.setAdType(2);
                this.f898h.setAdCount(1);
            }
            this.h0 = gMInterstitialAdLoadCallback;
            this.I = this;
            this.w = gMAdSlotInterstitial;
            S();
        }
    }

    public void a(GMInterstitialAdListener gMInterstitialAdListener) {
        this.i0 = gMInterstitialAdListener;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void b(AdError adError) {
        GMInterstitialAdLoadCallback gMInterstitialAdLoadCallback = this.h0;
        if (gMInterstitialAdLoadCallback != null) {
            gMInterstitialAdLoadCallback.onInterstitialLoadFail(adError);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onAdLeftApplication() {
        GMInterstitialAdListener gMInterstitialAdListener = this.i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onAdLeftApplication();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onAdOpened() {
        GMInterstitialAdListener gMInterstitialAdListener = this.i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onAdOpened();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onInterstitialAdClick() {
        GMInterstitialAdListener gMInterstitialAdListener = this.i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onInterstitialAdClick();
        }
        String b2 = t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null;
        TTBaseAd tTBaseAd = this.N;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.f898h, 0, b2, tTBaseAd.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onInterstitialClosed() {
        GMInterstitialAdListener gMInterstitialAdListener = this.i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onInterstitialClosed();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onInterstitialShow() {
        GMInterstitialAdListener gMInterstitialAdListener = this.i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onInterstitialShow();
        }
        m b2 = m.b();
        b2.a(this.f896f + "");
        if (this.N != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f896f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.N.getAdNetworkSlotId() + "，广告类型：" + e.c.c.a.a.b(this.N.getAdNetworkPlatformId()));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k.b().a(this.f896f, this.N.getAdNetworkSlotId());
        }
        e0();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(this.N, this.f898h, 0, t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null, false);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().b(this.N.getAdType(), this.N.getCpm());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.b(this.f896f, this.N);
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onInterstitialShowFail(AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, adError, 1, 0, t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
        d(adError);
    }
}
