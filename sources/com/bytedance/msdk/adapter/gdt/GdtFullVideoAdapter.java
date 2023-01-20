package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMFullVideoBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.interstitial2.ADRewardListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: classes.dex */
public class GdtFullVideoAdapter extends GMFullVideoBaseAdapter {
    private GMAdSlotGDTOption A;
    private int B;
    private int C;
    private Context z;

    /* loaded from: classes.dex */
    public class GdtFullVideoAd extends TTBaseAd {
        private UnifiedInterstitialAD a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        public UnifiedInterstitialADListener f1782c = new UnifiedInterstitialADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADClicked() {
                if (GdtFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.e().onFullVideoAdClick();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADClosed() {
                if (GdtFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.e().onFullVideoAdClosed();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADExposure() {
                if (GdtFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.e().onFullVideoAdShow();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x00e4 A[EDGE_INSN: B:19:0x00e4->B:26:0x00e0 ?: BREAK  ] */
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onADReceive() {
                /*
                    r4 = this;
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    r1 = 1
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.d(r0, r1)
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                    boolean r0 = r0.isClientBidding()
                    java.lang.String r1 = "TTMediationSDK_ECMP"
                    if (r0 == 0) goto L5f
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.h(r0)
                    int r2 = r2.getECPM()
                    r3 = -1
                    if (r2 == r3) goto L2b
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.h(r2)
                    int r2 = r2.getECPM()
                    double r2 = (double) r2
                    goto L2d
                L2b:
                    r2 = 0
                L2d:
                    r0.setCpm(r2)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                    java.lang.String r2 = r2.getAdapterRit()
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r3 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r3 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                    java.lang.String r3 = r3.getAdSlotId()
                    java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                    r0.append(r2)
                    java.lang.String r2 = "GDT_clientBidding FullVideo 返回的 cpm价格："
                    r0.append(r2)
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.h(r2)
                    int r2 = r2.getECPM()
                    r0.append(r2)
                    goto La4
                L5f:
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                    boolean r0 = r0.isMultiBidding()
                    if (r0 == 0) goto Lab
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.h(r0)
                    java.lang.String r2 = r2.getECPMLevel()
                    r0.setLevelTag(r2)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                    java.lang.String r2 = r2.getAdapterRit()
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r3 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r3 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                    java.lang.String r3 = r3.getAdSlotId()
                    java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                    r0.append(r2)
                    java.lang.String r2 = "GDT_多阶底价 FullVideo 返回的价格标签："
                    r0.append(r2)
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.h(r2)
                    java.lang.String r2 = r2.getECPMLevel()
                    r0.append(r2)
                La4:
                    java.lang.String r0 = r0.toString()
                    com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                Lab:
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.h(r0)
                    int r0 = r0.getAdPatternType()
                    r1 = 2
                    if (r0 != r1) goto Ld8
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    r2 = 5
                    r0.setImageMode(r2)
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.h(r0)
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener r2 = r2.f1783d
                    r0.setMediaListener(r2)
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.h(r0)
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.qq.e.ads.interstitial2.ADRewardListener r2 = r2.f1784e
                    r0.setRewardListener(r2)
                Ld8:
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.this
                    com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                    r2.notifyAdLoaded(r0)
                    r0 = 7
                Le0:
                    r2 = 3
                    r3 = 3
                Le2:
                    if (r3 == r1) goto Leb
                    if (r3 == r2) goto Le7
                    goto Le0
                Le7:
                    r0 = 122(0x7a, float:1.71E-43)
                    r3 = 2
                    goto Le2
                Leb:
                    r1 = 94
                    if (r0 == r1) goto Leb
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.AnonymousClass1.onADReceive():void");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onNoAD(AdError adError) {
                GdtFullVideoAd.this.b = false;
                if (adError != null) {
                    GdtFullVideoAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtFullVideoAdapter.this.notifyAdFailed(new com.bytedance.msdk.api.AdError());
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onVideoCached() {
                GdtFullVideoAd gdtFullVideoAd = GdtFullVideoAd.this;
                GdtFullVideoAdapter.this.notifyAdVideoCache(gdtFullVideoAd, (com.bytedance.msdk.api.AdError) null);
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
        };

        /* renamed from: d  reason: collision with root package name */
        public UnifiedInterstitialMediaListener f1783d = new UnifiedInterstitialMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.2
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            @JProtect
            public void onVideoComplete() {
                if (GdtFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.e().onVideoComplete();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            @JProtect
            public void onVideoError(AdError adError) {
                if (GdtFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.e().onVideoError();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long j2) {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
            }
        };

        /* renamed from: e  reason: collision with root package name */
        public ADRewardListener f1784e = new ADRewardListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.3
            @Override // com.qq.e.comm.listeners.ADRewardListener
            public void onReward(final Map<String, Object> map) {
                if (GdtFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                    GdtFullVideoAd.this.e().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.3.1
                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public float getAmount() {
                            GMAdSlotFullVideo gMAdSlotFullVideo = GdtFullVideoAdapter.this.mGMAdSlotFullVideo;
                            if (gMAdSlotFullVideo != null) {
                                return gMAdSlotFullVideo.getRewardAmount();
                            }
                            return 0.0f;
                        }

                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public Map<String, Object> getCustomData() {
                            Map map2 = map;
                            if (map2 == null || map2.isEmpty()) {
                                return null;
                            }
                            map.put(RewardItem.KEY_ADN_NAME, "gdt");
                            return map;
                        }

                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public String getRewardName() {
                            GMAdSlotFullVideo gMAdSlotFullVideo = GdtFullVideoAdapter.this.mGMAdSlotFullVideo;
                            return gMAdSlotFullVideo != null ? gMAdSlotFullVideo.getRewardName() : "";
                        }

                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public boolean rewardVerify() {
                            return true;
                        }
                    });
                }
            }
        };

        public GdtFullVideoAd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener e() {
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
                com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener) r0
                return r0
            L19:
                r0 = 93
                r1 = 93
                goto L6
            L1e:
                r1 = 91
                goto L10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.e():com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0098 -> B:25:0x009a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009a -> B:28:0x009f). Please submit an issue!!! */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b() {
            /*
                r4 = this;
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                android.content.Context r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.D(r0)
                boolean r0 = r0 instanceof android.app.Activity
                if (r0 == 0) goto L98
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = new com.qq.e.ads.interstitial2.UnifiedInterstitialAD
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                android.content.Context r1 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.D(r1)
                android.app.Activity r1 = (android.app.Activity) r1
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                java.lang.String r2 = r2.getAdSlotId()
                com.qq.e.ads.interstitial2.UnifiedInterstitialADListener r3 = r4.f1782c
                r0.<init>(r1, r2, r3)
                r4.a = r0
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.F(r0)
                com.qq.e.ads.cfg.VideoOption r0 = com.bytedance.msdk.adapter.gdt.GDTAdapterUtils.getGMVideoOption(r0)
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r1 = r4.a
                r1.setVideoOption(r0)
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.G(r0)
                if (r0 <= 0) goto L43
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = r4.a
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                int r1 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.G(r1)
                r0.setMaxVideoDuration(r1)
            L43:
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.H(r0)
                if (r0 <= 0) goto L56
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = r4.a
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                int r1 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.H(r1)
                r0.setMinVideoDuration(r1)
            L56:
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo r0 = r0.mGMAdSlotFullVideo
                if (r0 == 0) goto L92
                com.qq.e.ads.rewardvideo.ServerSideVerificationOptions$Builder r0 = new com.qq.e.ads.rewardvideo.ServerSideVerificationOptions$Builder
                r0.<init>()
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo r1 = r1.mGMAdSlotFullVideo
                java.lang.String r1 = r1.getUserID()
                if (r1 == 0) goto L6e
                r0.setUserId(r1)
            L6e:
                com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo r2 = r2.mGMAdSlotFullVideo
                java.util.Map r2 = r2.getCustomData()
                if (r2 == 0) goto L85
                java.lang.String r3 = "gdt"
                java.lang.Object r3 = r2.get(r3)
                java.lang.String r3 = (java.lang.String) r3
                if (r3 == 0) goto L85
                r0.setCustomData(r3)
            L85:
                if (r1 != 0) goto L89
                if (r2 == 0) goto L92
            L89:
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r1 = r4.a
                com.qq.e.ads.rewardvideo.ServerSideVerificationOptions r0 = r0.build()
                r1.setServerSideVerificationOptions(r0)
            L92:
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = r4.a
                r0.loadFullScreenAD()
                goto L9f
            L98:
                r0 = 39
            L9a:
                switch(r0) {
                    case 39: goto L9f;
                    case 40: goto L9e;
                    case 41: goto L9e;
                    default: goto L9d;
                }
            L9d:
                goto L98
            L9e:
                return
            L9f:
                r0 = 40
                goto L9a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.GdtFullVideoAd.b():void");
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
            UnifiedInterstitialAD unifiedInterstitialAD = this.a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.showFullScreenAD(activity);
            }
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
            com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd r0 = new com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter$GdtFullVideoAd
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtFullVideoAdapter.E():void");
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

    @Override // com.bytedance.msdk.adapter.ad.GMFullVideoBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        GMAdSlotFullVideo gMAdSlotFullVideo = this.mGMAdSlotFullVideo;
        if (gMAdSlotFullVideo == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        this.z = context;
        if (map != null) {
            GMAdSlotGDTOption gMAdSlotGDTOption = gMAdSlotFullVideo.getGMAdSlotGDTOption();
            this.A = gMAdSlotGDTOption;
            if (gMAdSlotGDTOption != null) {
                this.B = gMAdSlotGDTOption.getGDTMinVideoDuration();
                this.C = this.A.getGDTMaxVideoDuration();
            }
            E();
        }
    }
}
