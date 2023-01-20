package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.q;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* loaded from: classes.dex */
public class j extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d implements ITTAdapterRewardedAdListener {
    private GMRewardedAdLoadCallback h0;
    private GMRewardedAdListener i0;
    private GMRewardedAdListener j0;
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a k0;
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a l0;
    public GMRewardedAdListener m0;

    /* loaded from: classes.dex */
    public class a implements GMRewardedAdListener {

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0032a implements a.i {

            /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0033a implements Runnable {
                public final /* synthetic */ RewardItem a;

                public RunnableC0033a(RewardItem rewardItem) {
                    this.a = rewardItem;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.j0 != null) {
                        j.this.j0.onRewardVerify(this.a);
                        j.this.a(this.a, 1);
                    }
                }
            }

            public C0032a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i
            public void onRewardVerify(RewardItem rewardItem) {
                ThreadHelper.runOnUiThread(new RunnableC0033a(rewardItem));
            }
        }

        public a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardClick() {
            String str;
            String str2;
            if (q.a()) {
                if (j.this.N != null && "pangle".equals(j.this.N.getAdNetWorkName())) {
                    if (!q.b(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 5, 1, 1, t.a(Thread.currentThread().getStackTrace()));
                        return;
                    } else if (q.d()) {
                        str2 = t.a(Thread.currentThread().getStackTrace());
                        if (!j.this.f0() && j.this.j0 != null) {
                            j.this.j0.onRewardClick();
                        }
                        str = str2;
                    }
                }
                str2 = null;
                if (!j.this.f0()) {
                    j.this.j0.onRewardClick();
                }
                str = str2;
            } else {
                if (j.this.j0 != null) {
                    j.this.j0.onRewardClick();
                }
                str = null;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 1, t.a(j.this.N) ? t.b(Thread.currentThread().getStackTrace()) : null, str, j.this.N.isClickListenRepeatPlayAgainOnce());
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardVerify(@NonNull RewardItem rewardItem) {
            if (!q.a()) {
                if (!j.this.l0.b()) {
                    if (j.this.j0 == null) {
                        return;
                    }
                    j.this.j0.onRewardVerify(rewardItem);
                    j.this.a((RewardItem) null, 1);
                    return;
                }
                j.this.l0.d();
            }
            if (j.this.N != null && "pangle".equals(j.this.N.getAdNetWorkName())) {
                if (!q.b(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 4, 1, 1, t.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 4, 0, 1, q.f() ? t.a(Thread.currentThread().getStackTrace()) : null);
            }
            if (j.this.f0()) {
                return;
            }
            if (!j.this.l0.b()) {
                if (j.this.j0 == null) {
                    return;
                }
                j.this.j0.onRewardVerify(rewardItem);
                j.this.a((RewardItem) null, 1);
                return;
            }
            j.this.l0.d();
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdClosed() {
            if (q.a()) {
                if (j.this.N != null && "pangle".equals(j.this.N.getAdNetWorkName())) {
                    if (!q.b(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 2, 1, 1, t.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 2, 0, 1, (String) null);
                }
                if (j.this.f0() || j.this.j0 == null) {
                    return;
                }
            } else if (j.this.j0 == null) {
                return;
            }
            j.this.j0.onRewardedAdClosed();
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0149  */
        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onRewardedAdShow() {
            /*
                Method dump skipped, instructions count: 360
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.a.onRewardedAdShow():void");
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdShowFail(@NonNull AdError adError) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, adError, 1, 1, t.a(j.this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
            j.this.e(adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onSkippedVideo() {
            if (j.this.l0.b()) {
                j.this.l0.c();
            }
            if (q.a()) {
                if (j.this.N != null && "pangle".equals(j.this.N.getAdNetWorkName())) {
                    if (!q.b(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 3, 1, 1, t.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 3, 0, 1, (String) null);
                }
                if (j.this.f0() || j.this.j0 == null) {
                    return;
                }
            } else if (j.this.j0 == null) {
                return;
            }
            j.this.j0.onSkippedVideo();
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoComplete() {
            if (j.this.l0.b()) {
                j.this.l0.e();
            }
            if (q.a()) {
                if (j.this.N != null && "pangle".equals(j.this.N.getAdNetWorkName())) {
                    if (!q.b(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 1, 1, 1, t.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, 1, 0, 1, (String) null);
                }
                if (j.this.f0() || j.this.j0 == null) {
                    return;
                }
            } else if (j.this.j0 == null) {
                return;
            }
            j.this.j0.onVideoComplete();
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoError() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(j.this.N, j.this.f898h, (AdError) null, 2, 1, t.a(j.this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
            if (j.this.j0 != null) {
                j.this.j0.onVideoError();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.c {
        public b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.c
        public void a() {
            j.this.d(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.i {

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ RewardItem a;

            public a(RewardItem rewardItem) {
                this.a = rewardItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.i0 != null) {
                    j.this.i0.onRewardVerify(this.a);
                    j.this.a(this.a, 0);
                }
            }
        }

        public c() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i
        public void onRewardVerify(RewardItem rewardItem) {
            ThreadHelper.runOnUiThread(new a(rewardItem));
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public final /* synthetic */ AdError a;

        public d(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.i0 != null) {
                j.this.i0.onRewardedAdShowFail(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public final /* synthetic */ AdError a;

        public e(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.j0 != null) {
                j.this.j0.onRewardedAdShowFail(this.a);
            }
        }
    }

    public j(Context context, String str) {
        super(context, str);
        this.k0 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a(this.f896f);
        this.l0 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a(this.f896f);
        this.m0 = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RewardItem rewardItem, int i2) {
        String str;
        int i3;
        int i4;
        Map<String, Object> customData;
        String b2 = t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null;
        if (rewardItem == null || (customData = rewardItem.getCustomData()) == null) {
            str = "";
            i3 = 0;
            i4 = 0;
        } else {
            Integer num = (Integer) customData.get(RewardItem.KEY_REASON);
            int intValue = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) customData.get(RewardItem.KEY_ERROR_CODE);
            int intValue2 = num2 != null ? num2.intValue() : 0;
            str = (String) customData.get(RewardItem.KEY_ERROR_MSG);
            i4 = intValue2;
            i3 = intValue;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, i2, b2, i3, i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AdError adError) {
        ThreadHelper.runOnUiThread(new d(adError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AdError adError) {
        ThreadHelper.runOnUiThread(new e(adError));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.k0.a();
        this.l0.a();
        this.h0 = null;
        this.i0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void O() {
        GMRewardedAdLoadCallback gMRewardedAdLoadCallback = this.h0;
        if (gMRewardedAdLoadCallback != null) {
            gMRewardedAdLoadCallback.onRewardVideoAdLoad();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void P() {
        GMRewardedAdLoadCallback gMRewardedAdLoadCallback = this.h0;
        if (gMRewardedAdLoadCallback != null) {
            gMRewardedAdLoadCallback.onRewardVideoCached();
        }
    }

    @MainThread
    public void a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        super.a(activity, map, new b());
        if (this.i0 == null) {
            Logger.d("TTMediationSDK", "注意：未设置GMRewardedAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
    }

    public void a(AdSlot adSlot, GMAdSlotRewardVideo gMAdSlotRewardVideo, @NonNull GMRewardedAdLoadCallback gMRewardedAdLoadCallback) {
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_reward");
        }
        if (d0()) {
            this.h0 = gMRewardedAdLoadCallback;
            AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            this.f898h = shallowCopy;
            if (shallowCopy != null) {
                shallowCopy.setAdType(7);
                this.f898h.setAdCount(1);
                TTVideoOptionUtil.setRewardTTVideoOptionIfNeed(this.f898h);
            }
            this.I = this;
            this.J = this.m0;
            this.w = gMAdSlotRewardVideo;
            S();
        }
    }

    public void a(GMRewardedAdListener gMRewardedAdListener) {
        this.i0 = gMRewardedAdListener;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void b(AdError adError) {
        GMRewardedAdLoadCallback gMRewardedAdLoadCallback = this.h0;
        if (gMRewardedAdLoadCallback != null) {
            gMRewardedAdLoadCallback.onRewardVideoLoadFail(adError);
        }
    }

    public void b(GMRewardedAdListener gMRewardedAdListener) {
        this.j0 = gMRewardedAdListener;
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onRewardClick() {
        String str;
        String str2;
        GMRewardedAdListener gMRewardedAdListener;
        if (q.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!q.b(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 5, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                    return;
                } else if (q.d()) {
                    str2 = t.a(Thread.currentThread().getStackTrace());
                    if (!f0() && (gMRewardedAdListener = this.i0) != null) {
                        gMRewardedAdListener.onRewardClick();
                    }
                    str = str2;
                }
            }
            str2 = null;
            if (!f0()) {
                gMRewardedAdListener.onRewardClick();
            }
            str = str2;
        } else {
            GMRewardedAdListener gMRewardedAdListener2 = this.i0;
            if (gMRewardedAdListener2 != null) {
                gMRewardedAdListener2.onRewardClick();
            }
            str = null;
        }
        String b2 = t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null;
        TTBaseAd tTBaseAd2 = this.N;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd2, this.f898h, 0, b2, str, tTBaseAd2.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onRewardVerify(RewardItem rewardItem) {
        GMRewardedAdListener gMRewardedAdListener;
        if (!q.a()) {
            if (!this.k0.b()) {
                gMRewardedAdListener = this.i0;
                if (gMRewardedAdListener == null) {
                    return;
                }
                gMRewardedAdListener.onRewardVerify(rewardItem);
                a((RewardItem) null, 0);
                return;
            }
            this.k0.d();
        }
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
            if (!q.b(Thread.currentThread().getStackTrace())) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 4, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 4, 0, 0, q.f() ? t.a(Thread.currentThread().getStackTrace()) : null);
        }
        if (f0()) {
            return;
        }
        if (!this.k0.b()) {
            gMRewardedAdListener = this.i0;
            if (gMRewardedAdListener == null) {
                return;
            }
            gMRewardedAdListener.onRewardVerify(rewardItem);
            a((RewardItem) null, 0);
            return;
        }
        this.k0.d();
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onRewardedAdClosed() {
        GMRewardedAdListener gMRewardedAdListener;
        if (q.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!q.b(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 2, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 2, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMRewardedAdListener = this.i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        } else {
            h0();
            gMRewardedAdListener = this.i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        }
        gMRewardedAdListener.onRewardedAdClosed();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fd  */
    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRewardedAdShow() {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.onRewardedAdShow():void");
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onRewardedAdShowFail(AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, adError, 1, 0, t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
        d(adError);
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onSkippedVideo() {
        GMRewardedAdListener gMRewardedAdListener;
        if (q.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!q.b(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 3, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 3, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            if (this.k0.b()) {
                this.k0.c();
            }
            gMRewardedAdListener = this.i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        } else {
            h0();
            if (this.k0.b()) {
                this.k0.c();
            }
            gMRewardedAdListener = this.i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        }
        gMRewardedAdListener.onSkippedVideo();
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onVideoComplete() {
        GMRewardedAdListener gMRewardedAdListener;
        if (this.k0.b()) {
            this.k0.e();
        }
        if (q.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!q.b(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 1, 1, 0, t.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, 1, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMRewardedAdListener = this.i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        } else {
            h0();
            gMRewardedAdListener = this.i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        }
        gMRewardedAdListener.onVideoComplete();
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onVideoError() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f898h, (AdError) null, 2, 0, t.a(this.N) ? t.b(Thread.currentThread().getStackTrace()) : null);
        GMRewardedAdListener gMRewardedAdListener = this.i0;
        if (gMRewardedAdListener != null) {
            gMRewardedAdListener.onVideoError();
        }
    }
}
