package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMInterstitialBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTGlobalConfig;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: classes.dex */
public class GdtInterstitialAdapter extends GMInterstitialBaseAdapter {
    private GMAdSlotGDTOption A;
    private int B;
    private int C;
    private Context z;

    /* loaded from: classes.dex */
    public class GdtIntersitialAd extends TTBaseAd {
        private UnifiedInterstitialAD a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        public UnifiedInterstitialADListener f1786c = new UnifiedInterstitialADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADClicked() {
                if (GdtIntersitialAd.this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.e().onInterstitialAdClick();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADClosed() {
                if (GdtIntersitialAd.this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.e().onInterstitialClosed();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADExposure() {
                if (GdtIntersitialAd.this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.e().onInterstitialShow();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADLeftApplication() {
                if (GdtIntersitialAd.this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.e().onAdLeftApplication();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADOpened() {
                if (GdtIntersitialAd.this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    GdtIntersitialAd.this.e().onAdOpened();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x00bc  */
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onADReceive() {
                /*
                    r4 = this;
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    r1 = 1
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.d(r0, r1)
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                    boolean r0 = r0.isClientBidding()
                    java.lang.String r1 = "TTMediationSDK_ECMP"
                    if (r0 == 0) goto L5f
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.g(r0)
                    int r2 = r2.getECPM()
                    r3 = -1
                    if (r2 == r3) goto L2b
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.g(r2)
                    int r2 = r2.getECPM()
                    double r2 = (double) r2
                    goto L2d
                L2b:
                    r2 = 0
                L2d:
                    r0.setCpm(r2)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                    java.lang.String r2 = r2.getAdapterRit()
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r3 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r3 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                    java.lang.String r3 = r3.getAdSlotId()
                    java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                    r0.append(r2)
                    java.lang.String r2 = "GDT_clientBidding 插屏 返回的 cpm价格："
                    r0.append(r2)
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.g(r2)
                    int r2 = r2.getECPM()
                    r0.append(r2)
                    goto La4
                L5f:
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                    boolean r0 = r0.isMultiBidding()
                    if (r0 == 0) goto Lab
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.g(r0)
                    java.lang.String r2 = r2.getECPMLevel()
                    r0.setLevelTag(r2)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                    java.lang.String r2 = r2.getAdapterRit()
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r3 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r3 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                    java.lang.String r3 = r3.getAdSlotId()
                    java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                    r0.append(r2)
                    java.lang.String r2 = "GDT_多阶底价 插屏 返回的价格标签："
                    r0.append(r2)
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.g(r2)
                    java.lang.String r2 = r2.getECPMLevel()
                    r0.append(r2)
                La4:
                    java.lang.String r0 = r0.toString()
                    com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                Lab:
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.g(r0)
                    int r0 = r0.getAdPatternType()
                    r1 = 2
                    if (r0 != r1) goto Lbc
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    r1 = 5
                    goto Lbf
                Lbc:
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    r1 = 3
                Lbf:
                    r0.setImageMode(r1)
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.this
                    com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                    r1.notifyAdLoaded(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.AnonymousClass1.onADReceive():void");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onNoAD(AdError adError) {
                GdtIntersitialAd.this.b = false;
                if (adError != null) {
                    GdtInterstitialAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtInterstitialAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError());
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
            }
        };

        public GdtIntersitialAd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener e() {
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
                com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener) r0
                return r0
            L19:
                r0 = 93
                r1 = 93
                goto L6
            L1e:
                r1 = 91
                goto L10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.e():com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x009a, code lost:
            if (r2 != '.') goto L12;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x008b -> B:13:0x008f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x008f -> B:21:0x009e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x009a -> B:21:0x009e). Please submit an issue!!! */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b() {
            /*
                r5 = this;
                java.lang.String r0 = "TTMediationSDK"
                java.lang.String r1 = "GdtIntersitialAd load"
                com.bytedance.msdk.adapter.util.Logger.d(r0, r1)
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                android.content.Context r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.D(r0)
                boolean r0 = r0 instanceof android.app.Activity
                r1 = 45
                if (r0 == 0) goto L65
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                android.content.Context r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.D(r2)
                android.app.Activity r2 = (android.app.Activity) r2
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r3 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                java.lang.String r3 = r3.getAdSlotId()
                com.qq.e.ads.interstitial2.UnifiedInterstitialADListener r4 = r5.f1786c
                r0.<init>(r2, r3, r4)
                r5.a = r0
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.F(r0)
                com.qq.e.ads.cfg.VideoOption r0 = com.bytedance.msdk.adapter.gdt.GDTAdapterUtils.getGMVideoOption(r0)
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = r5.a
                r2.setVideoOption(r0)
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.G(r0)
                if (r0 <= 0) goto L4c
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = r5.a
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                int r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.G(r2)
                r0.setMaxVideoDuration(r2)
            L4c:
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.H(r0)
                if (r0 <= 0) goto L5f
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = r5.a
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                int r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.H(r2)
                r0.setMinVideoDuration(r2)
            L5f:
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = r5.a
                r0.loadAD()
                goto L9e
            L65:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                java.lang.String r2 = r2.getAdapterRit()
                com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter r3 = com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.this
                java.lang.String r3 = r3.getAdSlotId()
                java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                r0.append(r2)
                java.lang.String r2 = "GDT--插屏-传入mContext 不是 Activity 请求中断"
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.lang.String r2 = "TTMediationSDK_interisitial"
                com.bytedance.msdk.adapter.util.Logger.d(r2, r0)
            L8b:
                r0 = 19
                r2 = 45
            L8f:
                switch(r0) {
                    case 18: goto L93;
                    case 19: goto L96;
                    case 20: goto L8b;
                    default: goto L92;
                }
            L92:
                goto L9e
            L93:
                switch(r2) {
                    case 8: goto L9d;
                    case 9: goto L9d;
                    case 10: goto L9d;
                    default: goto L96;
                }
            L96:
                if (r2 == r1) goto L9d
                r0 = 46
                if (r2 == r0) goto L9e
                goto L8b
            L9d:
                return
            L9e:
                r0 = 18
                r2 = 8
                goto L8f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.GdtIntersitialAd.b():void");
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
            UnifiedInterstitialAD unifiedInterstitialAD;
            if (isClientBiddingAd() && (unifiedInterstitialAD = this.a) != null) {
                try {
                    unifiedInterstitialAD.sendWinNotification((int) getCpm());
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.a;
            return (unifiedInterstitialAD == null || !unifiedInterstitialAD.isValid()) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            UnifiedInterstitialAD unifiedInterstitialAD = this.a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.destroy();
                this.a = null;
            }
            this.mTTAdatperCallback = null;
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (this.a == null || activity == null || activity.isFinishing()) {
                return;
            }
            this.a.show(activity);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c A[SYNTHETIC] */
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void E() {
        /*
            r4 = this;
            com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd r0 = new com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter$GdtIntersitialAd
            r0.<init>()
            r0.b()
        L8:
            r0 = 94
            r1 = 75
            r2 = 93
        Le:
            r3 = 92
            if (r0 == r3) goto L15
            if (r0 == r2) goto L18
            goto L1d
        L15:
            switch(r1) {
                case 21: goto L1d;
                case 22: goto L1d;
                case 23: goto L1d;
                default: goto L18;
            }
        L18:
            switch(r1) {
                case 91: goto L8;
                case 92: goto L1d;
                case 93: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L22
        L1c:
            return
        L1d:
            r0 = 93
            r1 = 93
            goto Le
        L22:
            r1 = 91
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtInterstitialAdapter.E():void");
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

    @Override // com.bytedance.msdk.adapter.ad.GMInterstitialBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        if (this.mGMAdSlotInterstitial == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        this.z = context;
        if (map == null) {
            return;
        }
        this.B = map.get(TTGlobalConfig.MIN_VIDEO_DURATION) != null ? ((Integer) map.get(TTGlobalConfig.MIN_VIDEO_DURATION)).intValue() : 0;
        this.C = map.get(TTGlobalConfig.MAX_VIDEO_DURATION) != null ? ((Integer) map.get(TTGlobalConfig.MAX_VIDEO_DURATION)).intValue() : 0;
        this.A = this.mGMAdSlotInterstitial.getGMAdSlotGDTOption();
        E();
        for (char c2 = '\\'; c2 != 'Z'; c2 = '[') {
            if (c2 == '[') {
                return;
            }
        }
        while (true) {
        }
    }
}
