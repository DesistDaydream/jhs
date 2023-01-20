package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMBannerBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GdtBannerAdapter extends GMBannerBaseAdapter {
    private FrameLayout.LayoutParams A;
    private VideoOption B;
    private Context z;

    /* loaded from: classes.dex */
    public class GdtBanner extends TTBaseAd {
        private UnifiedBannerView a;
        private boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        private UnifiedBannerADListener f1774c = new UnifiedBannerADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtBanner.2
            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            @JProtect
            public void onADClicked() {
                if (GdtBanner.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.e().onAdClicked();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            @JProtect
            public void onADClosed() {
                if (GdtBanner.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.e().onAdClosed();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            @JProtect
            public void onADExposure() {
                if (GdtBanner.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.e().onAdShow();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            @JProtect
            public void onADLeftApplication() {
                if (GdtBanner.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    GdtBanner.this.e().onAdLeftApplication();
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            @JProtect
            public void onADReceive() {
                StringBuilder sb;
                if (GdtBanner.this.b) {
                    return;
                }
                if (GdtBanner.this.a != null) {
                    if (GdtBannerAdapter.this.isClientBidding()) {
                        int ecpm = GdtBanner.this.a.getECPM();
                        GdtBanner.this.setCpm(ecpm > 0 ? ecpm : 0.0d);
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagThirdLevelById(GdtBannerAdapter.this.getAdapterRit(), GdtBannerAdapter.this.getAdSlotId()));
                        sb.append("GDT_clientBidding 插屏 返回的 cpm价格：");
                        sb.append(ecpm);
                    } else if (GdtBannerAdapter.this.isMultiBidding()) {
                        String eCPMLevel = GdtBanner.this.a.getECPMLevel();
                        GdtBanner.this.setLevelTag(eCPMLevel);
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagThirdLevelById(GdtBannerAdapter.this.getAdapterRit(), GdtBannerAdapter.this.getAdSlotId()));
                        sb.append("GDT_多阶底价 插屏 返回的 价格标签：");
                        sb.append(eCPMLevel);
                    }
                    Logger.d("TTMediationSDK_ECMP", sb.toString());
                }
                GdtBanner gdtBanner = GdtBanner.this;
                GdtBannerAdapter.this.notifyAdLoaded(gdtBanner);
                GdtBanner.this.b = true;
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            @JProtect
            public void onNoAD(AdError adError) {
                if (GdtBanner.this.b) {
                    return;
                }
                GdtBanner.this.b = true;
                if (adError != null) {
                    GdtBannerAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtBannerAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError());
                }
            }
        };

        public GdtBanner() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JProtect
        public ITTAdapterBannerAdListener e() {
            while (true) {
                char c2 = ']';
                char c3 = ']';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                            }
                            c2 = '^';
                            c3 = 'K';
                            break;
                        case ']':
                            while (true) {
                                switch (c3) {
                                    default:
                                        c3 = '[';
                                    case '[':
                                    case '\\':
                                    case ']':
                                        break;
                                }
                            }
                            c2 = '^';
                            c3 = 'K';
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
        }

        @JProtect
        public void b() {
            if (GdtBannerAdapter.this.z instanceof Activity) {
                UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) GdtBannerAdapter.this.z, GdtBannerAdapter.this.getAdSlotId(), this.f1774c);
                this.a = unifiedBannerView;
                unifiedBannerView.setRefresh(0);
                this.a.loadAD();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void bidLoseNotify(Map<String, Object> map) {
            if (!isClientBiddingAd() || this.a == null || map == null) {
                return;
            }
            try {
                Object obj = map.get("bidding_lose_reason");
                if (obj instanceof GMAdConstant.BiddingLossReason) {
                    this.a.sendLossNotification(0, GDTAdapterUtils.getBiddingLossReason((GMAdConstant.BiddingLossReason) obj), null);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void bidWinNotify(Map<String, Object> map) {
            UnifiedBannerView unifiedBannerView;
            if (isClientBiddingAd() && (unifiedBannerView = this.a) != null) {
                try {
                    unifiedBannerView.sendWinNotification((int) getCpm());
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public View getAdView() {
            return this.a;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.mTTAdatperCallback == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            UnifiedBannerView unifiedBannerView = this.a;
            return (unifiedBannerView == null || !unifiedBannerView.isValid()) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtBanner.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GdtBanner.this.a != null) {
                        GdtBanner.this.a.destroy();
                    }
                }
            });
            this.mTTAdatperCallback = null;
            super.onDestroy();
        }
    }

    /* loaded from: classes.dex */
    public class GdtNativeAd extends TTBaseAd {
        public NativeUnifiedADData a;
        private volatile boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public NativeADMediaListener f1776c = new NativeADMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.4
            /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[FALL_THROUGH] */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC] */
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoClicked() {
                /*
                    r2 = this;
                    com.bytedance.msdk.adapter.gdt.GdtBannerAdapter$GdtNativeAd r0 = com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r0 = com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.q(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.gdt.GdtBannerAdapter$GdtNativeAd r0 = com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r0 = com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.r(r0)
                    r0.onAdClick()
                L11:
                    r0 = 74
                    r1 = 55
                L15:
                    switch(r0) {
                        case 72: goto L11;
                        case 73: goto L19;
                        case 74: goto L1c;
                        default: goto L18;
                    }
                L18:
                    goto L2d
                L19:
                    switch(r1) {
                        case 94: goto L28;
                        case 95: goto L20;
                        case 96: goto L20;
                        default: goto L1c;
                    }
                L1c:
                    switch(r1) {
                        case 55: goto L21;
                        case 56: goto L21;
                        case 57: goto L20;
                        default: goto L1f;
                    }
                L1f:
                    goto L28
                L20:
                    return
                L21:
                    java.lang.String r0 = "GdtBannerAdapter"
                    java.lang.String r1 = "onVideoClicked"
                    android.util.Log.d(r0, r1)
                L28:
                    r0 = 73
                    r1 = 96
                    goto L15
                L2d:
                    r0 = 72
                    goto L15
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.AnonymousClass4.onVideoClicked():void");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoCompleted() {
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoError(AdError adError) {
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoError(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                Log.d("GdtBannerAdapter", "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i2) {
                Log.d("GdtBannerAdapter", "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                Log.d("GdtBannerAdapter", "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoPause() {
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                Log.d("GdtBannerAdapter", "onVideoReady");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoResume() {
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoStart() {
                Log.d("GdtBannerAdapter", "onVideoStart");
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoStart();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                Log.d("GdtBannerAdapter", "onVideoStop");
            }
        };

        /* JADX WARN: Removed duplicated region for block: B:18:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0117  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x011b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public GdtNativeAd(com.qq.e.ads.nativ.NativeUnifiedADData r6) {
            /*
                Method dump skipped, instructions count: 287
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.<init>(com.bytedance.msdk.adapter.gdt.GdtBannerAdapter, com.qq.e.ads.nativ.NativeUnifiedADData):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JProtect
        public ITTAdapterBannerAdListener a() {
            while (true) {
                char c2 = ']';
                char c3 = ']';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                            }
                            c2 = '^';
                            c3 = 'K';
                            break;
                        case ']':
                            while (true) {
                                switch (c3) {
                                    default:
                                        c3 = '[';
                                    case '[':
                                    case '\\':
                                    case ']':
                                        break;
                                }
                            }
                            c2 = '^';
                            c3 = 'K';
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00f8 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00e5 -> B:41:0x00e7). Please submit an issue!!! */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void d(android.content.Context r13, @androidx.annotation.NonNull android.view.ViewGroup r14, java.util.List<android.view.View> r15, java.util.List<android.view.View> r16, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder r17) {
            /*
                Method dump skipped, instructions count: 260
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.d(android.content.Context, android.view.ViewGroup, java.util.List, java.util.List, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder):void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void bidLoseNotify(Map<String, Object> map) {
            if (!isClientBiddingAd() || this.a == null || map == null) {
                return;
            }
            try {
                Object obj = map.get("bidding_lose_reason");
                if (obj instanceof GMAdConstant.BiddingLossReason) {
                    this.a.sendLossNotification(0, GDTAdapterUtils.getBiddingLossReason((GMAdConstant.BiddingLossReason) obj), null);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void bidWinNotify(Map<String, Object> map) {
            NativeUnifiedADData nativeUnifiedADData;
            if (isClientBiddingAd() && (nativeUnifiedADData = this.a) != null) {
                try {
                    nativeUnifiedADData.sendWinNotification((int) getCpm());
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            NativeUnifiedADData nativeUnifiedADData = this.a;
            return (nativeUnifiedADData == null || !nativeUnifiedADData.isValid()) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.b = true;
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeUnifiedADData nativeUnifiedADData = GdtNativeAd.this.a;
                    if (nativeUnifiedADData != null) {
                        nativeUnifiedADData.destroy();
                    }
                }
            });
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onPause() {
            super.onPause();
            NativeUnifiedADData nativeUnifiedADData = this.a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.pauseVideo();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onResume() {
            super.onResume();
            NativeUnifiedADData nativeUnifiedADData = this.a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.resume();
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        @Override // com.bytedance.msdk.base.TTBaseAd
        @com.bytedance.JProtect
        public void registerViewForInteraction(@androidx.annotation.NonNull android.app.Activity r7, @androidx.annotation.NonNull android.view.ViewGroup r8, java.util.List<android.view.View> r9, java.util.List<android.view.View> r10, java.util.List<android.view.View> r11, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder r12) {
            /*
                r6 = this;
                if (r11 == 0) goto Lc
                if (r10 != 0) goto L9
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
            L9:
                r10.addAll(r11)
            Lc:
                r4 = r10
                super.registerViewForInteraction(r8, r9, r4, r12)
                r0 = r6
                r1 = r7
                r2 = r8
                r3 = r9
                r5 = r12
                r0.d(r1, r2, r3, r4, r5)
                r7 = 92
            L1a:
                r8 = 14
            L1c:
                switch(r8) {
                    case 13: goto L25;
                    case 14: goto L27;
                    case 15: goto L20;
                    default: goto L1f;
                }
            L1f:
                goto L1a
            L20:
                switch(r7) {
                    case 94: goto L27;
                    case 95: goto L24;
                    case 96: goto L27;
                    default: goto L23;
                }
            L23:
                goto L27
            L24:
                return
            L25:
                r8 = 72
            L27:
                r8 = 15
                r7 = 95
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.GdtNativeAd.registerViewForInteraction(android.app.Activity, android.view.ViewGroup, java.util.List, java.util.List, java.util.List, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder):void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
            super.registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
            d(GdtBannerAdapter.this.z, viewGroup, list, list2, gMViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void unregisterView() {
        }
    }

    /* loaded from: classes.dex */
    public class TTExpressAd extends TTBaseAd implements ITTAdapterBannerAdListener {
        public NativeExpressADView a;
        public GMDislikeCallback b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f1778c = false;

        /* renamed from: d  reason: collision with root package name */
        private final NativeExpressMediaListener f1779d;

        public TTExpressAd(GdtBannerAdapter gdtBannerAdapter, NativeExpressADView nativeExpressADView) {
            StringBuilder sb;
            NativeExpressMediaListener nativeExpressMediaListener = new NativeExpressMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.TTExpressAd.2
                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoCached(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtBannerAdapter", "onVideoCached");
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                @JProtect
                public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                    if (TTExpressAd.this.mTTVideoListener != null) {
                        TTExpressAd.this.mTTVideoListener.onVideoCompleted();
                    }
                }

                /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
                    	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                    	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                    	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                    	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
                    */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0043 A[ORIG_RETURN, RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[PHI: r0 r5 
                  PHI: (r0v6 char) = (r0v2 char), (r0v4 char), (r0v3 char), (r0v0 char) binds: [B:9:0x0035, B:21:0x0044, B:18:0x0044, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]
                  PHI: (r5v3 char) = (r5v2 char), (r5v2 char), (r5v2 char), (r5v6 char) binds: [B:9:0x0035, B:21:0x0044, B:18:0x0044, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0039 -> B:16:0x0044). Please submit an issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003d -> B:16:0x0044). Please submit an issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0031 -> B:9:0x0035). Please submit an issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0035 -> B:16:0x0044). Please submit an issue!!! */
                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                @com.bytedance.JProtect
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onVideoError(com.qq.e.ads.nativ.NativeExpressADView r4, com.qq.e.comm.util.AdError r5) {
                    /*
                        r3 = this;
                        com.bytedance.msdk.adapter.gdt.GdtBannerAdapter$TTExpressAd r4 = com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.TTExpressAd.this
                        com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r4 = com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.TTExpressAd.k(r4)
                        r0 = 55
                        if (r4 == 0) goto L31
                        com.bytedance.msdk.adapter.gdt.GdtBannerAdapter$TTExpressAd r4 = com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.TTExpressAd.this
                        if (r5 == 0) goto L25
                        com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r4 = com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.TTExpressAd.l(r4)
                        com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                        int r2 = r5.getErrorCode()
                        java.lang.String r5 = r5.getErrorMsg()
                        r1.<init>(r2, r5)
                        r4.onVideoError(r1)
                        r4 = 0
                        r5 = 0
                        goto L44
                    L25:
                        com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r4 = com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.TTExpressAd.m(r4)
                        com.bytedance.msdk.api.AdError r5 = new com.bytedance.msdk.api.AdError
                        r5.<init>()
                        r4.onVideoError(r5)
                    L31:
                        r4 = 73
                        r5 = 16
                    L35:
                        switch(r4) {
                            case 72: goto L31;
                            case 73: goto L43;
                            case 74: goto L39;
                            default: goto L38;
                        }
                    L38:
                        goto L44
                    L39:
                        switch(r5) {
                            case 52: goto L44;
                            case 53: goto L3d;
                            case 54: goto L31;
                            default: goto L3c;
                        }
                    L3c:
                        goto L43
                    L3d:
                        switch(r0) {
                            case 29: goto L31;
                            case 30: goto L44;
                            case 31: goto L39;
                            default: goto L40;
                        }
                    L40:
                        r0 = 30
                        goto L3d
                    L43:
                        return
                    L44:
                        r4 = 72
                        goto L35
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.TTExpressAd.AnonymousClass2.onVideoError(com.qq.e.ads.nativ.NativeExpressADView, com.qq.e.comm.util.AdError):void");
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoInit(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtBannerAdapter", "onVideoInit: " + TTExpressAd.this.e((AdData.VideoPlayer) nativeExpressADView2.getBoundData().getProperty(AdData.VideoPlayer.class)));
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtBannerAdapter", "onVideoLoading");
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                @JProtect
                public void onVideoPause(NativeExpressADView nativeExpressADView2) {
                    if (TTExpressAd.this.mTTVideoListener != null) {
                        TTExpressAd.this.mTTVideoListener.onVideoPause();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoReady(NativeExpressADView nativeExpressADView2, long j2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                @JProtect
                public void onVideoStart(NativeExpressADView nativeExpressADView2) {
                    if (TTExpressAd.this.mTTVideoListener != null) {
                        TTExpressAd.this.mTTVideoListener.onVideoStart();
                    }
                }
            };
            this.f1779d = nativeExpressMediaListener;
            this.a = nativeExpressADView;
            AdData boundData = nativeExpressADView.getBoundData();
            if (boundData.getAdPatternType() == 2) {
                nativeExpressADView.preloadVideo();
                nativeExpressADView.setMediaListener(nativeExpressMediaListener);
                setImageMode(5);
            } else if (boundData.getAdPatternType() == 4 || boundData.getAdPatternType() == 1 || boundData.getAdPatternType() != 3) {
                setImageMode(3);
            } else {
                setImageMode(4);
            }
            setExpressAd(true);
            setTitle(boundData.getTitle());
            setAdDescription(boundData.getDesc());
            setInteractionType(3);
            if (gdtBannerAdapter.isClientBidding()) {
                setCpm(boundData.getECPM() != -1 ? boundData.getECPM() : 0.0d);
                Logger.d("");
                sb = new StringBuilder();
                sb.append("GDT_clientBidding 模板Native 返回的 cpm价格：");
                sb.append(boundData.getECPM());
            } else if (!gdtBannerAdapter.isMultiBidding()) {
                return;
            } else {
                setLevelTag(boundData.getECPMLevel());
                Logger.d("");
                sb = new StringBuilder();
                sb.append("GDT_多阶底价 模板Native 返回的 价格标签：");
                sb.append(boundData.getECPMLevel());
            }
            Logger.d("TTMediationSDK_ECMP", sb.toString());
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener a() {
            /*
                r4 = this;
            L0:
                r0 = 94
                r1 = 75
                r2 = 93
            L6:
                r3 = 92
                if (r0 == r3) goto Ld
                if (r0 == r2) goto L10
                goto L19
            Ld:
                switch(r1) {
                    case 21: goto L19;
                    case 22: goto L14;
                    case 23: goto L14;
                    default: goto L10;
                }
            L10:
                switch(r1) {
                    case 91: goto L0;
                    case 92: goto L19;
                    case 93: goto L14;
                    default: goto L13;
                }
            L13:
                goto L1e
            L14:
                com.bytedance.msdk.adapter.listener.ITTAdatperCallback r0 = r4.mTTAdatperCallback
                com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener) r0
                return r0
            L19:
                r0 = 93
                r1 = 93
                goto L6
            L1e:
                r1 = 91
                goto L10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.TTExpressAd.a():com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String e(AdData.VideoPlayer videoPlayer) {
            if (videoPlayer != null) {
                return "{state:" + videoPlayer.getVideoState() + Constants.ACCEPT_TIME_SEPARATOR_SP + "duration:" + videoPlayer.getDuration() + Constants.ACCEPT_TIME_SEPARATOR_SP + "position:" + videoPlayer.getCurrentPosition() + "}";
            }
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void bidLoseNotify(Map<String, Object> map) {
            if (!isClientBiddingAd() || this.a == null || map == null) {
                return;
            }
            try {
                Object obj = map.get("bidding_lose_reason");
                if (obj instanceof GMAdConstant.BiddingLossReason) {
                    this.a.sendLossNotification(0, GDTAdapterUtils.getBiddingLossReason((GMAdConstant.BiddingLossReason) obj), null);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void bidWinNotify(Map<String, Object> map) {
            NativeExpressADView nativeExpressADView;
            if (isClientBiddingAd() && (nativeExpressADView = this.a) != null) {
                try {
                    nativeExpressADView.sendWinNotification((int) getCpm());
                } catch (Exception unused) {
                }
            }
        }

        public void closeAd() {
            GMDislikeCallback gMDislikeCallback = this.b;
            if (gMDislikeCallback != null) {
                gMDislikeCallback.onSelected(-1, "ad close !");
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public View getAdView() {
            return this.a;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f1778c;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            NativeExpressADView nativeExpressADView = this.a;
            return (nativeExpressADView == null || !nativeExpressADView.isValid()) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClicked() {
            if (this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                a().onAdClicked();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClosed() {
            if (this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                a().onAdClosed();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdLeftApplication() {
            if (this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                a().onAdLeftApplication();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdOpened() {
            if (this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                a().onAdOpened();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShow() {
            if (this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                a().onAdShow();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShowFail(@NonNull com.bytedance.msdk.api.AdError adError) {
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.TTExpressAd.1
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressADView nativeExpressADView = TTExpressAd.this.a;
                    if (nativeExpressADView != null) {
                        nativeExpressADView.destroy();
                    }
                }
            });
            this.f1778c = true;
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void render() {
            NativeExpressADView nativeExpressADView = this.a;
            if (nativeExpressADView == null) {
                return;
            }
            nativeExpressADView.render();
            while (true) {
                char c2 = 15;
                while (true) {
                    switch (c2) {
                        case '\r':
                            break;
                        case 14:
                            return;
                        case 15:
                        default:
                            c2 = 14;
                    }
                }
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, GMDislikeCallback gMDislikeCallback) {
            this.b = gMDislikeCallback;
        }
    }

    private ADSize E() {
        int[] bannerSize = getBannerSize(this.mGMAdSlotBanner.getBannerSize(), this.mGMAdSlotBanner);
        return new ADSize(bannerSize[0], bannerSize[1]);
    }

    private void G() {
        DownAPPConfirmPolicy downAPPConfirmPolicy;
        NativeExpressAD nativeExpressAD = new NativeExpressAD(this.z, E(), getAdSlotId(), new NativeExpressAD.NativeExpressADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.1
            public TTExpressAd a;

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(NativeExpressADView nativeExpressADView) {
                TTExpressAd tTExpressAd = this.a;
                if (tTExpressAd != null) {
                    tTExpressAd.onAdClicked();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(NativeExpressADView nativeExpressADView) {
                TTExpressAd tTExpressAd = this.a;
                if (tTExpressAd != null) {
                    tTExpressAd.onAdClosed();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(NativeExpressADView nativeExpressADView) {
                TTExpressAd tTExpressAd = this.a;
                if (tTExpressAd != null) {
                    tTExpressAd.onAdShow();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
                TTExpressAd tTExpressAd = this.a;
                if (tTExpressAd != null) {
                    tTExpressAd.onAdLeftApplication();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(List<NativeExpressADView> list) {
                if (list == null || list.size() == 0) {
                    GdtBannerAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError(com.bytedance.msdk.api.AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                for (NativeExpressADView nativeExpressADView : list) {
                    if (nativeExpressADView != null) {
                        TTExpressAd tTExpressAd = new TTExpressAd(GdtBannerAdapter.this, nativeExpressADView);
                        this.a = tTExpressAd;
                        tTExpressAd.render();
                        return;
                    }
                }
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                if (adError != null) {
                    GdtBannerAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtBannerAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError());
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                GdtBannerAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError(com.bytedance.msdk.api.AdError.ERROR_MEDIA_RENDER_MSG));
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                GdtBannerAdapter.this.notifyAdLoaded(this.a);
            }
        });
        GMAdSlotGDTOption gMAdSlotGDTOption = this.mGMAdSlotBanner.getGMAdSlotGDTOption();
        if (gMAdSlotGDTOption != null) {
            nativeExpressAD.setMinVideoDuration(gMAdSlotGDTOption.getGDTMinVideoDuration());
            nativeExpressAD.setMaxVideoDuration(gMAdSlotGDTOption.getGDTMaxVideoDuration());
            nativeExpressAD.setVideoOption(GDTAdapterUtils.getGMVideoOption(gMAdSlotGDTOption));
            if (gMAdSlotGDTOption.getDownAPPConfirmPolicy() == 0) {
                downAPPConfirmPolicy = DownAPPConfirmPolicy.Default;
            } else if (gMAdSlotGDTOption.getDownAPPConfirmPolicy() == 1) {
                downAPPConfirmPolicy = DownAPPConfirmPolicy.NOConfirm;
            }
            nativeExpressAD.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
        nativeExpressAD.loadAD(1);
    }

    private void I() {
        DownAPPConfirmPolicy downAPPConfirmPolicy;
        DownAPPConfirmPolicy downAPPConfirmPolicy2;
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(this.z, getAdSlotId(), new NativeADUnifiedListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.2
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                if (list == null || list.size() <= 0) {
                    GdtBannerAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError(com.bytedance.msdk.api.AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    if (nativeUnifiedADData != null) {
                        GdtBannerAdapter gdtBannerAdapter = GdtBannerAdapter.this;
                        gdtBannerAdapter.notifyAdLoaded(new GdtNativeAd(nativeUnifiedADData));
                        return;
                    }
                }
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                if (adError != null) {
                    GdtBannerAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtBannerAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError());
                }
            }
        });
        GMAdSlotGDTOption gMAdSlotGDTOption = this.mGMAdSlotBanner.getGMAdSlotGDTOption();
        if (gMAdSlotGDTOption != null) {
            this.A = gMAdSlotGDTOption.getNativeAdLogoParams();
            this.B = GDTAdapterUtils.getGMVideoOption(gMAdSlotGDTOption);
            int gDTMaxVideoDuration = gMAdSlotGDTOption.getGDTMaxVideoDuration();
            int gDTMinVideoDuration = gMAdSlotGDTOption.getGDTMinVideoDuration();
            if (gDTMinVideoDuration > 0) {
                nativeUnifiedAD.setMinVideoDuration(gDTMinVideoDuration);
            }
            if (gDTMaxVideoDuration > 0) {
                nativeUnifiedAD.setMaxVideoDuration(gDTMaxVideoDuration);
            }
            if (gMAdSlotGDTOption.getDownAPPConfirmPolicy() == 0) {
                downAPPConfirmPolicy2 = DownAPPConfirmPolicy.Default;
            } else if (gMAdSlotGDTOption.getDownAPPConfirmPolicy() == 1) {
                downAPPConfirmPolicy2 = DownAPPConfirmPolicy.NOConfirm;
            }
            nativeUnifiedAD.setDownAPPConfirmPolicy(downAPPConfirmPolicy2);
        }
        if (gMAdSlotGDTOption != null) {
            if (gMAdSlotGDTOption.getDownAPPConfirmPolicy() == 0) {
                downAPPConfirmPolicy = DownAPPConfirmPolicy.Default;
            } else if (gMAdSlotGDTOption.getDownAPPConfirmPolicy() == 1) {
                downAPPConfirmPolicy = DownAPPConfirmPolicy.NOConfirm;
            }
            nativeUnifiedAD.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
        nativeUnifiedAD.loadData(1);
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "gdt";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return SDKStatus.getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e A[PHI: r3 
      PHI: (r3v13 char) = (r3v12 char), (r3v14 char), (r3v14 char), (r3v14 char), (r3v14 char) binds: [B:18:0x004c, B:20:0x0052, B:40:0x004e, B:36:0x004e, B:22:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0052 -> B:19:0x004e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0056 -> B:19:0x004e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005c -> B:19:0x004e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0062 -> B:19:0x004e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0065 -> B:20:0x0052). Please submit an issue!!! */
    @Override // com.bytedance.msdk.adapter.ad.GMBannerBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r3, java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            r2 = this;
            super.loadAd(r3, r4)
            r2.z = r3
            com.bytedance.msdk.api.v2.slot.GMAdSlotBanner r3 = r2.mGMAdSlotBanner
            if (r3 == 0) goto L78
            if (r4 == 0) goto L7b
            java.lang.String r3 = "tt_ad_network_config_appid"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = "tt_ad_sub_type"
            java.lang.Object r3 = r4.get(r3)
            if (r3 == 0) goto L6f
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0 = 4
            if (r3 != r0) goto L6f
            java.lang.String r3 = "tt_ad_origin_type"
            java.lang.Object r3 = r4.get(r3)
            r4 = 95
            if (r3 == 0) goto L4c
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0 = 1
            if (r3 != r0) goto L3b
            r2.G()
            goto L4c
        L3b:
            r0 = 2
            if (r3 != r0) goto L42
            r2.I()
            goto L65
        L42:
            com.bytedance.msdk.api.AdError r3 = new com.bytedance.msdk.api.AdError
            java.lang.String r0 = "渲染类型错误"
            r3.<init>(r0)
            r2.notifyAdFailed(r3)
        L4c:
            r3 = 95
        L4e:
            r0 = 84
            r1 = 83
        L52:
            switch(r0) {
                case 84: goto L56;
                case 85: goto L5c;
                case 86: goto L7b;
                default: goto L55;
            }
        L55:
            goto L4e
        L56:
            switch(r1) {
                case 82: goto L4e;
                case 83: goto L7b;
                case 84: goto L5a;
                default: goto L59;
            }
        L59:
            goto L5c
        L5a:
            goto L5a
        L5c:
            switch(r1) {
                case 94: goto L4e;
                case 95: goto L65;
                case 96: goto L60;
                default: goto L5f;
            }
        L5f:
            goto L6c
        L60:
            r0 = 41
            if (r3 == r0) goto L60
            goto L4e
        L65:
            r0 = 85
            r1 = 96
            r3 = 40
            goto L52
        L6c:
            r1 = 95
            goto L5c
        L6f:
            com.bytedance.msdk.adapter.gdt.GdtBannerAdapter$GdtBanner r3 = new com.bytedance.msdk.adapter.gdt.GdtBannerAdapter$GdtBanner
            r3.<init>()
            r3.b()
            goto L7b
        L78:
            r2.notifyLoadFailBecauseGMAdSlotIsNull()
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtBannerAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
