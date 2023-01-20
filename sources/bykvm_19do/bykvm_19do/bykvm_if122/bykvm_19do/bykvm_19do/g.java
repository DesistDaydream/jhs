package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.q;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* loaded from: classes.dex */
public class g extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d implements ITTAdapterFullVideoAdListener {
    private GMFullVideoAdLoadCallback h0;
    private GMFullVideoAdListener i0;

    /* loaded from: classes.dex */
    public class a implements d.c {
        public a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.c
        public void a() {
            g.this.d(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
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
            if (g.this.i0 != null) {
                g.this.i0.onFullVideoAdShowFail(this.a);
            }
        }
    }

    public g(Context context, String str) {
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
        GMFullVideoAdLoadCallback gMFullVideoAdLoadCallback = this.h0;
        if (gMFullVideoAdLoadCallback != null) {
            gMFullVideoAdLoadCallback.onFullVideoAdLoad();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void P() {
        GMFullVideoAdLoadCallback gMFullVideoAdLoadCallback = this.h0;
        if (gMFullVideoAdLoadCallback != null) {
            gMFullVideoAdLoadCallback.onFullVideoCached();
        }
    }

    @MainThread
    public void a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        super.a(activity, map, new a());
        if (this.i0 == null) {
            Logger.d("TTMediationSDK", "注意：未设置GMFullVideoAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
    }

    public void a(AdSlot adSlot, GMAdSlotFullVideo gMAdSlotFullVideo, @NonNull GMFullVideoAdLoadCallback gMFullVideoAdLoadCallback) {
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_full_video");
        }
        if (d0()) {
            this.h0 = gMFullVideoAdLoadCallback;
            AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            this.f898h = shallowCopy;
            if (shallowCopy != null) {
                shallowCopy.setAdType(8);
                this.f898h.setAdCount(1);
                TTVideoOptionUtil.setFullTTVideoOptionIfNeed(this.f898h);
            }
            this.I = this;
            this.w = gMAdSlotFullVideo;
            S();
        }
    }

    public void a(GMFullVideoAdListener gMFullVideoAdListener) {
        this.i0 = gMFullVideoAdListener;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void b(AdError adError) {
        GMFullVideoAdLoadCallback gMFullVideoAdLoadCallback = this.h0;
        if (gMFullVideoAdLoadCallback != null) {
            gMFullVideoAdLoadCallback.onFullVideoLoadFail(adError);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onFullVideoAdClick() {
        String str;
        String str2;
        GMFullVideoAdListener gMFullVideoAdListener;
        if (q.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!q.a(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 5, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                    return;
                } else if (q.b()) {
                    str2 = t.a(Thread.currentThread().getStackTrace());
                    if (!f0() && (gMFullVideoAdListener = this.i0) != null) {
                        gMFullVideoAdListener.onFullVideoAdClick();
                    }
                    str = str2;
                }
            }
            str2 = null;
            if (!f0()) {
                gMFullVideoAdListener.onFullVideoAdClick();
            }
            str = str2;
        } else {
            GMFullVideoAdListener gMFullVideoAdListener2 = this.i0;
            if (gMFullVideoAdListener2 != null) {
                gMFullVideoAdListener2.onFullVideoAdClick();
            }
            str = null;
        }
        String b2 = t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null;
        TTBaseAd tTBaseAd2 = this.N;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd2, this.f898h, 0, b2, str, tTBaseAd2.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onFullVideoAdClosed() {
        GMFullVideoAdListener gMFullVideoAdListener;
        if (q.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!q.a(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 2, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 2, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMFullVideoAdListener = this.i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        } else {
            h0();
            gMFullVideoAdListener = this.i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        }
        gMFullVideoAdListener.onFullVideoAdClosed();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e2  */
    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onFullVideoAdShow() {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.g.onFullVideoAdShow():void");
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onFullVideoAdShowFail(AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, adError, 1, 0, t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
        d(adError);
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onRewardVerify(@NonNull RewardItem rewardItem) {
        GMFullVideoAdListener gMFullVideoAdListener = this.i0;
        if (gMFullVideoAdListener != null) {
            gMFullVideoAdListener.onRewardVerify(rewardItem);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onSkippedVideo() {
        GMFullVideoAdListener gMFullVideoAdListener;
        if (q.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!q.a(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 3, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 3, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMFullVideoAdListener = this.i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        } else {
            h0();
            gMFullVideoAdListener = this.i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        }
        gMFullVideoAdListener.onSkippedVideo();
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onVideoComplete() {
        GMFullVideoAdListener gMFullVideoAdListener;
        if (q.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!q.a(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 1, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 1, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMFullVideoAdListener = this.i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        } else {
            h0();
            gMFullVideoAdListener = this.i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        }
        gMFullVideoAdListener.onVideoComplete();
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onVideoError() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, (AdError) null, 2, 0, t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
        GMFullVideoAdListener gMFullVideoAdListener = this.i0;
        if (gMFullVideoAdListener != null) {
            gMFullVideoAdListener.onVideoError();
        }
    }
}
