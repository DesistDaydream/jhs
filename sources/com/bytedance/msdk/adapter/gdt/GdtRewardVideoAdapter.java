package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMRewardBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.Map;

/* loaded from: classes.dex */
public class GdtRewardVideoAdapter extends GMRewardBaseAdapter {
    private Context z;

    /* loaded from: classes.dex */
    public class GdtRewardVideo extends TTBaseAd {
        private RewardVideoAD a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        public RewardVideoADListener f1809c = new RewardVideoADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.1
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onADClick() {
                if (GdtRewardVideo.this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.e().onRewardClick();
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onADClose() {
                if (GdtRewardVideo.this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.e().onRewardedAdClosed();
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onADLoad() {
                StringBuilder sb;
                GdtRewardVideo.this.b = true;
                if (GdtRewardVideo.this.a == null) {
                    GdtRewardVideoAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                if (GdtRewardVideoAdapter.this.isClientBidding()) {
                    GdtRewardVideo gdtRewardVideo = GdtRewardVideo.this;
                    gdtRewardVideo.setCpm(gdtRewardVideo.a.getECPM() != -1 ? GdtRewardVideo.this.a.getECPM() : 0.0d);
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagThirdLevelById(GdtRewardVideoAdapter.this.getAdapterRit(), GdtRewardVideoAdapter.this.getAdSlotId()));
                    sb.append("GDT_clientBidding Reward 返回的 cpm价格：");
                    sb.append(GdtRewardVideo.this.a.getECPM());
                } else if (!GdtRewardVideoAdapter.this.isMultiBidding()) {
                    GdtRewardVideoAdapter.this.isServerBidding();
                    GdtRewardVideo gdtRewardVideo2 = GdtRewardVideo.this;
                    GdtRewardVideoAdapter.this.notifyAdLoaded(gdtRewardVideo2);
                    Logger.d("GdtRewardVideoAdapter", TTLogUtil.getTagThirdLevelById(GdtRewardVideoAdapter.this.getAdapterRit(), GdtRewardVideoAdapter.this.getAdSlotId()) + "eCPM = " + GdtRewardVideo.this.a.getECPM() + " , eCPMLevel = " + GdtRewardVideo.this.a.getECPMLevel());
                } else {
                    GdtRewardVideo gdtRewardVideo3 = GdtRewardVideo.this;
                    gdtRewardVideo3.setLevelTag(gdtRewardVideo3.a.getECPMLevel());
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagThirdLevelById(GdtRewardVideoAdapter.this.getAdapterRit(), GdtRewardVideoAdapter.this.getAdSlotId()));
                    sb.append("GDT_多阶底价 Reward 返回的 价格标签：");
                    sb.append(GdtRewardVideo.this.a.getECPMLevel());
                }
                Logger.d("TTMediationSDK_ECMP", sb.toString());
                GdtRewardVideo gdtRewardVideo22 = GdtRewardVideo.this;
                GdtRewardVideoAdapter.this.notifyAdLoaded(gdtRewardVideo22);
                Logger.d("GdtRewardVideoAdapter", TTLogUtil.getTagThirdLevelById(GdtRewardVideoAdapter.this.getAdapterRit(), GdtRewardVideoAdapter.this.getAdSlotId()) + "eCPM = " + GdtRewardVideo.this.a.getECPM() + " , eCPMLevel = " + GdtRewardVideo.this.a.getECPMLevel());
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onADShow() {
                if (GdtRewardVideo.this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.e().onRewardedAdShow();
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onError(com.qq.e.comm.util.AdError adError) {
                GdtRewardVideo.this.b = false;
                if (adError != null) {
                    GdtRewardVideoAdapter.this.notifyAdFailed(new AdError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    GdtRewardVideoAdapter.this.notifyAdFailed(new AdError());
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onReward(final Map<String, Object> map) {
                if (GdtRewardVideo.this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.e().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.1.1
                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public float getAmount() {
                            GMAdSlotRewardVideo gMAdSlotRewardVideo = GdtRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                            if (gMAdSlotRewardVideo != null) {
                                return gMAdSlotRewardVideo.getRewardAmount();
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
                            GMAdSlotRewardVideo gMAdSlotRewardVideo = GdtRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                            return gMAdSlotRewardVideo != null ? gMAdSlotRewardVideo.getRewardName() : "";
                        }

                        @Override // com.bytedance.msdk.api.reward.RewardItem
                        public boolean rewardVerify() {
                            return true;
                        }
                    });
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
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @com.bytedance.JProtect
            public void onVideoCached() {
                /*
                    r3 = this;
                    com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter$GdtRewardVideo r0 = com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.this
                    com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.this
                    r2 = 0
                    r1.notifyAdVideoCache(r0, r2)
                    r0 = 92
                La:
                    r1 = 14
                Lc:
                    switch(r1) {
                        case 13: goto L15;
                        case 14: goto L17;
                        case 15: goto L10;
                        default: goto Lf;
                    }
                Lf:
                    goto La
                L10:
                    switch(r0) {
                        case 94: goto L17;
                        case 95: goto L14;
                        case 96: goto L17;
                        default: goto L13;
                    }
                L13:
                    goto L17
                L14:
                    return
                L15:
                    r1 = 72
                L17:
                    r1 = 15
                    r0 = 95
                    goto Lc
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.AnonymousClass1.onVideoCached():void");
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onVideoComplete() {
                if (GdtRewardVideo.this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                    GdtRewardVideo.this.e().onVideoComplete();
                }
            }
        };

        public GdtRewardVideo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener e() {
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
                com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener) r0
                return r0
            L19:
                r0 = 93
                r1 = 93
                goto L6
            L1e:
                r1 = 91
                goto L10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.e():com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        @JProtect
        public void b() {
            String str;
            GMAdSlotRewardVideo gMAdSlotRewardVideo = GdtRewardVideoAdapter.this.mGMAdSlotRewardVideo;
            boolean z = (gMAdSlotRewardVideo == null || gMAdSlotRewardVideo.isMuted()) ? false : true;
            this.a = !TextUtils.isEmpty(GdtRewardVideoAdapter.this.getAdm()) ? new RewardVideoAD(GdtRewardVideoAdapter.this.z, GdtRewardVideoAdapter.this.getAdSlotId(), this.f1809c, z, GdtRewardVideoAdapter.this.getAdm()) : new RewardVideoAD(GdtRewardVideoAdapter.this.z, GdtRewardVideoAdapter.this.getAdSlotId(), this.f1809c, z);
            if (GdtRewardVideoAdapter.this.mGMAdSlotRewardVideo != null) {
                ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
                String userID = GdtRewardVideoAdapter.this.mGMAdSlotRewardVideo.getUserID();
                if (userID != null) {
                    builder.setUserId(userID);
                }
                Map<String, String> customData = GdtRewardVideoAdapter.this.mGMAdSlotRewardVideo.getCustomData();
                if (customData != null && (str = customData.get("gdt")) != null) {
                    builder.setCustomData(str);
                }
                if (userID != null || customData != null) {
                    this.a.setServerSideVerificationOptions(builder.build());
                }
            }
            this.a.loadAD();
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
            RewardVideoAD rewardVideoAD;
            if (isClientBiddingAd() && (rewardVideoAD = this.a) != null) {
                try {
                    rewardVideoAD.sendWinNotification((int) getCpm());
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
            RewardVideoAD rewardVideoAD = this.a;
            return (rewardVideoAD == null || !rewardVideoAD.isValid()) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            if (this.a != null) {
                this.a = null;
                this.mTTAdatperCallback = null;
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
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
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        @Override // com.bytedance.msdk.base.TTBaseAd
        @com.bytedance.JProtect
        public void showAd(android.app.Activity r2, java.util.Map<com.bytedance.msdk.api.TTAdConstant.GroMoreExtraKey, java.lang.Object> r3) {
            /*
                r1 = this;
                com.qq.e.ads.rewardvideo.RewardVideoAD r3 = r1.a
                if (r3 == 0) goto L32
                com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter r3 = com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.this
                boolean r3 = r3.isServerBidding()
                if (r3 == 0) goto L15
                com.qq.e.ads.rewardvideo.RewardVideoAD r3 = r1.a
                int r0 = r3.getECPM()
                r3.setBidECPM(r0)
            L15:
                com.qq.e.ads.rewardvideo.RewardVideoAD r3 = r1.a
                r3.showAD(r2)
                r2 = 55
                r3 = 0
            L1d:
                r0 = 72
            L1f:
                switch(r0) {
                    case 72: goto L2d;
                    case 73: goto L32;
                    case 74: goto L23;
                    default: goto L22;
                }
            L22:
                goto L1d
            L23:
                switch(r3) {
                    case 52: goto L1d;
                    case 53: goto L27;
                    case 54: goto L2d;
                    default: goto L26;
                }
            L26:
                goto L32
            L27:
                switch(r2) {
                    case 29: goto L32;
                    case 30: goto L1d;
                    case 31: goto L23;
                    default: goto L2a;
                }
            L2a:
                r2 = 30
                goto L27
            L2d:
                r0 = 73
                r3 = 16
                goto L1f
            L32:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtRewardVideoAdapter.GdtRewardVideo.showAd(android.app.Activity, java.util.Map):void");
        }
    }

    @JProtect
    private void E() {
        new GdtRewardVideo().b();
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
                        if (c3 <= 4) {
                            break;
                        } else {
                            return;
                        }
                }
            }
        }
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

    @Override // com.bytedance.msdk.adapter.ad.GMRewardBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        if (this.mGMAdSlotRewardVideo == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        this.z = context;
        if (map != null) {
            String str = (String) map.get("tt_ad_network_config_appid");
            E();
        }
    }
}
