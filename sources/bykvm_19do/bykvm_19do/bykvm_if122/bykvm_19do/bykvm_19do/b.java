package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.q;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* loaded from: classes.dex */
public class b extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d {
    private GMInterstitialFullAdLoadCallback h0;
    private GMInterstitialFullAdListener i0;
    public ITTAdapterFullVideoAdListener j0;
    public ITTAdapterInterstitialListener k0;

    /* loaded from: classes.dex */
    public class a implements d.c {
        public a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.c
        public void a() {
            b.this.d(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0030b implements Runnable {
        public final /* synthetic */ AdError a;

        public RunnableC0030b(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.i0 != null) {
                b.this.i0.onInterstitialFullShowFail(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements ITTAdapterFullVideoAdListener {
        public c() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onFullVideoAdClick() {
            String str;
            String str2;
            if (q.a()) {
                if (b.this.N != null && "pangle".equals(b.this.N.getAdNetWorkName())) {
                    if (!q.a(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, 5, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                        return;
                    } else if (q.b()) {
                        str2 = t.a(Thread.currentThread().getStackTrace());
                        if (!b.this.f0() && b.this.i0 != null) {
                            b.this.i0.onInterstitialFullClick();
                        }
                        str = str2;
                    }
                }
                str2 = null;
                if (!b.this.f0()) {
                    b.this.i0.onInterstitialFullClick();
                }
                str = str2;
            } else {
                if (b.this.i0 != null) {
                    b.this.i0.onInterstitialFullClick();
                }
                str = null;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, 0, t.a(b.this.N) ? t.b(Thread.currentThread().getStackTrace()) : null, str, b.this.N.isClickListenRepeatOnce());
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onFullVideoAdClosed() {
            if (q.a()) {
                if (b.this.N != null && "pangle".equals(b.this.N.getAdNetWorkName())) {
                    if (!q.a(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, 2, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, 2, 0, 0, (String) null);
                }
                if (b.this.f0()) {
                    return;
                }
                b.this.h0();
                if (b.this.i0 == null) {
                    return;
                }
            } else {
                b.this.h0();
                if (b.this.i0 == null) {
                    return;
                }
            }
            b.this.i0.onInterstitialFullClosed();
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0128  */
        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFullVideoAdShow() {
            /*
                Method dump skipped, instructions count: 369
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.c.onFullVideoAdShow():void");
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onFullVideoAdShowFail(@NonNull AdError adError) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, adError, 1, 0, t.a(b.this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
            b.this.d(adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onRewardVerify(@NonNull RewardItem rewardItem) {
            if (b.this.i0 != null) {
                b.this.i0.onRewardVerify(rewardItem);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onSkippedVideo() {
            if (q.a()) {
                if (b.this.N != null && "pangle".equals(b.this.N.getAdNetWorkName())) {
                    if (!q.a(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, 3, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, 3, 0, 0, (String) null);
                }
                if (b.this.f0()) {
                    return;
                }
                b.this.h0();
                if (b.this.i0 == null) {
                    return;
                }
            } else {
                b.this.h0();
                if (b.this.i0 == null) {
                    return;
                }
            }
            b.this.i0.onSkippedVideo();
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onVideoComplete() {
            if (q.a()) {
                if (b.this.N != null && "pangle".equals(b.this.N.getAdNetWorkName())) {
                    if (!q.a(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, 1, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, 1, 0, 0, (String) null);
                }
                if (b.this.f0()) {
                    return;
                }
                b.this.h0();
                if (b.this.i0 == null) {
                    return;
                }
            } else {
                b.this.h0();
                if (b.this.i0 == null) {
                    return;
                }
            }
            b.this.i0.onVideoComplete();
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onVideoError() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, (AdError) null, 2, 0, t.a(b.this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
            if (b.this.i0 != null) {
                b.this.i0.onVideoError();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements ITTAdapterInterstitialListener {
        public d() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onAdLeftApplication() {
            if (b.this.i0 != null) {
                b.this.i0.onAdLeftApplication();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onAdOpened() {
            if (b.this.i0 != null) {
                b.this.i0.onAdOpened();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialAdClick() {
            if (b.this.i0 != null) {
                b.this.i0.onInterstitialFullClick();
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, 0, t.a(b.this.N) ? t.b(Thread.currentThread().getStackTrace()) : null, b.this.N.isClickListenRepeatOnce());
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialClosed() {
            b.this.h0();
            if (b.this.i0 != null) {
                b.this.i0.onInterstitialFullClosed();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialShow() {
            if (b.this.i0 != null) {
                b.this.i0.onInterstitialFullShow();
            }
            m b = m.b();
            b.a(b.this.f896f + "");
            if (b.this.N != null) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(b.this.f896f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + b.this.N.getAdNetworkSlotId() + "，广告类型：" + e.c.c.a.a.b(b.this.N.getAdNetworkPlatformId()));
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k.b().a(b.this.f896f, b.this.N.getAdNetworkSlotId());
            }
            b.this.e0();
            b bVar = b.this;
            bVar.d(bVar.N);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(b.this.N, b.this.f898h, 0, t.a(b.this.N) ? t.b(Thread.currentThread().getStackTrace()) : null, false);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.b(b.this.f896f, b.this.N);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialShowFail(@NonNull AdError adError) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(b.this.N, b.this.f898h, adError, 1, 0, t.a(b.this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
            b.this.d(adError);
        }
    }

    public b(Context context, String str) {
        super(context, str);
        this.j0 = new c();
        this.k0 = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AdError adError) {
        ThreadHelper.runOnUiThread(new RunnableC0030b(adError));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.i0 = null;
        this.h0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void O() {
        GMInterstitialFullAdLoadCallback gMInterstitialFullAdLoadCallback = this.h0;
        if (gMInterstitialFullAdLoadCallback != null) {
            gMInterstitialFullAdLoadCallback.onInterstitialFullAdLoad();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void P() {
        GMInterstitialFullAdLoadCallback gMInterstitialFullAdLoadCallback = this.h0;
        if (gMInterstitialFullAdLoadCallback != null) {
            gMInterstitialFullAdLoadCallback.onInterstitialFullCached();
        }
    }

    public void a(Activity activity) {
        super.b(activity, null, new a());
    }

    public void a(AdSlot adSlot, GMAdSlotInterstitialFull gMAdSlotInterstitialFull, GMInterstitialFullAdLoadCallback gMInterstitialFullAdLoadCallback) {
        if (d0()) {
            AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            this.f898h = shallowCopy;
            if (shallowCopy != null) {
                shallowCopy.setAdType(10);
                this.f898h.setAdCount(1);
            }
            this.h0 = gMInterstitialFullAdLoadCallback;
            this.I = this.j0;
            this.w = gMAdSlotInterstitialFull;
            S();
        }
    }

    public void a(GMInterstitialFullAdListener gMInterstitialFullAdListener) {
        this.i0 = gMInterstitialFullAdListener;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d
    public void a(TTBaseAd tTBaseAd, Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        ITTAdatperCallback iTTAdatperCallback;
        if (tTBaseAd != null) {
            if (tTBaseAd.getSubAdType() == 1) {
                iTTAdatperCallback = this.k0;
            } else if (tTBaseAd.getSubAdType() == 2) {
                iTTAdatperCallback = this.j0;
            }
            this.I = iTTAdatperCallback;
        }
        super.a(tTBaseAd, activity, map);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void b(AdError adError) {
        GMInterstitialFullAdLoadCallback gMInterstitialFullAdLoadCallback = this.h0;
        if (gMInterstitialFullAdLoadCallback != null) {
            gMInterstitialFullAdLoadCallback.onInterstitialFullLoadFail(adError);
        }
    }
}
