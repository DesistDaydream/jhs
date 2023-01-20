package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMRewardBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* loaded from: classes.dex */
public class BaiduRewardVideoAdapter extends GMRewardBaseAdapter {
    private Context z;

    /* loaded from: classes.dex */
    public class BaiduRewardVideoAd extends TTBaseAd implements RewardVideoAd.RewardVideoAdListener {
        private RewardVideoAd a;

        public BaiduRewardVideoAd() {
        }

        @JProtect
        private ITTAdapterRewardedAdListener b() {
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
            return (ITTAdapterRewardedAdListener) this.mTTAdatperCallback;
        }

        @JProtect
        public void a() {
            String str;
            Context context = BaiduRewardVideoAdapter.this.z;
            String adSlotId = BaiduRewardVideoAdapter.this.getAdSlotId();
            GMAdSlotRewardVideo gMAdSlotRewardVideo = BaiduRewardVideoAdapter.this.mGMAdSlotRewardVideo;
            boolean z = true;
            this.a = new RewardVideoAd(context, adSlotId, this, gMAdSlotRewardVideo != null && gMAdSlotRewardVideo.isUseSurfaceView());
            GMAdSlotRewardVideo gMAdSlotRewardVideo2 = BaiduRewardVideoAdapter.this.mGMAdSlotRewardVideo;
            if (gMAdSlotRewardVideo2 != null) {
                GMAdSlotBaiduOption gMAdSlotBaiduOption = gMAdSlotRewardVideo2.getGMAdSlotBaiduOption();
                this.a.setDownloadAppConfirmPolicy((gMAdSlotBaiduOption == null || gMAdSlotBaiduOption.getDownloadAppConfirmPolicy() == 0) ? 3 : gMAdSlotBaiduOption.getDownloadAppConfirmPolicy());
                this.a.setShowDialogOnSkip(gMAdSlotBaiduOption != null && gMAdSlotBaiduOption.getShowDialogOnSkip());
                this.a.setUseRewardCountdown((gMAdSlotBaiduOption == null || !gMAdSlotBaiduOption.getUseRewardCountdown()) ? false : false);
                String appSid = gMAdSlotBaiduOption != null ? gMAdSlotBaiduOption.getAppSid() : null;
                if (!TextUtils.isEmpty(appSid)) {
                    this.a.setAppSid(appSid);
                }
                GMAdSlotRewardVideo gMAdSlotRewardVideo3 = BaiduRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                if (gMAdSlotRewardVideo3 != null) {
                    String userID = gMAdSlotRewardVideo3.getUserID();
                    if (userID != null) {
                        this.a.setUserId(userID);
                    }
                    Map<String, String> customData = BaiduRewardVideoAdapter.this.mGMAdSlotRewardVideo.getCustomData();
                    if (customData != null && (str = customData.get("baidu")) != null) {
                        this.a.setExtraInfo(str);
                    }
                }
            }
            this.a.load();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            RewardVideoAd rewardVideoAd = this.a;
            return (rewardVideoAd == null || !rewardVideoAd.isReady()) ? GMAdConstant.AdIsReadyStatus.AD_IS_EXPIRED : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClick() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduRewardVideoAdapter.this.getAdapterRit(), BaiduRewardVideoAdapter.this.getAdSlotId()) + "Baidu rewardVideo ad onAdClick ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                b().onRewardClick();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClose(float f2) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduRewardVideoAdapter.this.getAdapterRit(), BaiduRewardVideoAdapter.this.getAdSlotId()) + "Baidu rewardVideo ad onAdClose ...");
            if (!(this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener)) {
                return;
            }
            b().onRewardedAdClosed();
            char c2 = '_';
            char c3 = '^';
            while (true) {
                if (c3 == '`' && c2 != '*') {
                    return;
                }
                c2 = '(';
                c3 = '`';
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdFailed(String str) {
            BaiduRewardVideoAdapter.this.notifyAdFailed(new AdError(str));
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
            if (r1 > '=') goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
            com.bytedance.msdk.adapter.util.Logger.i("TTMediationSDK", com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r5.b.getAdapterRit(), r5.b.getAdSlotId()) + "Baidu rewardVideo ad video load success ...");
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
            if (r5.a == null) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
            if (r5.b.isClientBidding() == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
            r2 = 0.0d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
            r2 = java.lang.Double.valueOf(r5.a.getECPMLevel()).doubleValue();
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x008a, code lost:
            if (r5.b.isMultiBidding() == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
            setLevelTag(r5.a.getECPMLevel());
            r0 = new java.lang.StringBuilder();
            r0.append(com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r5.b.getAdapterRit(), r5.b.getAdSlotId()));
            r2 = "Baidu_多阶底价 reward 返回的 价格标签：";
         */
        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onAdLoaded() {
            /*
                r5 = this;
                r0 = 61
                r1 = 61
            L4:
                r2 = 85
                r3 = 93
            L8:
                r4 = 27
                switch(r2) {
                    case 84: goto L22;
                    case 85: goto L1c;
                    case 86: goto Lf;
                    default: goto Ld;
                }
            Ld:
                goto Lc8
            Lf:
                switch(r3) {
                    case 37: goto L13;
                    case 38: goto L1e;
                    case 39: goto L4;
                    default: goto L12;
                }
            L12:
                goto L19
            L13:
                switch(r1) {
                    case 25: goto L4;
                    case 26: goto L4;
                    case 27: goto Lc8;
                    default: goto L16;
                }
            L16:
                r1 = 27
                goto L13
            L19:
                r3 = 39
                goto Lf
            L1c:
                if (r3 >= r4) goto Lc8
            L1e:
                if (r1 <= r0) goto L22
            L20:
            L21:
                goto L20
            L22:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter r1 = com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.this
                java.lang.String r1 = r1.getAdapterRit()
                com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.this
                java.lang.String r2 = r2.getAdSlotId()
                java.lang.String r1 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r1, r2)
                r0.append(r1)
                java.lang.String r1 = "Baidu rewardVideo ad video load success ..."
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "TTMediationSDK"
                com.bytedance.msdk.adapter.util.Logger.i(r1, r0)
                com.baidu.mobads.sdk.api.RewardVideoAd r0 = r5.a
                if (r0 == 0) goto Lc2
                com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.this
                boolean r0 = r0.isClientBidding()
                java.lang.String r1 = "TTMediationSDK_ECMP"
                if (r0 == 0) goto L84
                r2 = 0
                com.baidu.mobads.sdk.api.RewardVideoAd r0 = r5.a     // Catch: java.lang.Exception -> L66
                java.lang.String r0 = r0.getECPMLevel()     // Catch: java.lang.Exception -> L66
                java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch: java.lang.Exception -> L66
                double r2 = r0.doubleValue()     // Catch: java.lang.Exception -> L66
            L66:
                r5.setCpm(r2)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.this
                java.lang.String r2 = r2.getAdapterRit()
                com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter r3 = com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.this
                java.lang.String r3 = r3.getAdSlotId()
                java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                r0.append(r2)
                java.lang.String r2 = "Baidu_cientBidding reward 返回的 cpm价格："
                goto Laf
            L84:
                com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.this
                boolean r0 = r0.isMultiBidding()
                if (r0 == 0) goto Lc2
                com.baidu.mobads.sdk.api.RewardVideoAd r0 = r5.a
                java.lang.String r0 = r0.getECPMLevel()
                r5.setLevelTag(r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.this
                java.lang.String r2 = r2.getAdapterRit()
                com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter r3 = com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.this
                java.lang.String r3 = r3.getAdSlotId()
                java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                r0.append(r2)
                java.lang.String r2 = "Baidu_多阶底价 reward 返回的 价格标签："
            Laf:
                r0.append(r2)
                com.baidu.mobads.sdk.api.RewardVideoAd r2 = r5.a
                java.lang.String r2 = r2.getECPMLevel()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
            Lc2:
                com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.this
                r0.notifyAdLoaded(r5)
                return
            Lc8:
                r2 = 84
                goto L8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.BaiduRewardVideoAd.onAdLoaded():void");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdShow() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduRewardVideoAdapter.this.getAdapterRit(), BaiduRewardVideoAdapter.this.getAdSlotId()) + "Baidu rewardVideo ad onAdShow ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                b().onRewardedAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdSkip(float f2) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduRewardVideoAdapter.this.getAdapterRit(), BaiduRewardVideoAdapter.this.getAdSlotId()) + "Baidu rewardVideo ad onAdSkip ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                b().onSkippedVideo();
                while (true) {
                    for (char c2 = '`'; c2 != '^'; c2 = '^') {
                        if (c2 != '`') {
                            break;
                        }
                    }
                    return;
                }
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.a = null;
            BaiduRewardVideoAdapter.this.z = null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onPause() {
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onResume() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        @JProtect
        public void onRewardVerify(final boolean z) {
            b().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.baidu.BaiduRewardVideoAdapter.BaiduRewardVideoAd.1
                @Override // com.bytedance.msdk.api.reward.RewardItem
                public float getAmount() {
                    GMAdSlotRewardVideo gMAdSlotRewardVideo = BaiduRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                    if (gMAdSlotRewardVideo != null) {
                        return gMAdSlotRewardVideo.getRewardAmount();
                    }
                    return 1.0f;
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public Map<String, Object> getCustomData() {
                    return null;
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public String getRewardName() {
                    GMAdSlotRewardVideo gMAdSlotRewardVideo = BaiduRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                    return gMAdSlotRewardVideo != null ? gMAdSlotRewardVideo.getRewardName() : "";
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public boolean rewardVerify() {
                    return z;
                }
            });
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduRewardVideoAdapter.this.getAdapterRit(), BaiduRewardVideoAdapter.this.getAdSlotId()) + "Baidu rewardVideo ad video  cache failed ...");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onVideoDownloadSuccess() {
            Logger.i("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduRewardVideoAdapter.this.getAdapterRit(), BaiduRewardVideoAdapter.this.getAdSlotId()) + "Baidu rewardVideo ad video cache success ...");
            BaiduRewardVideoAdapter.this.notifyAdVideoCache(this, (AdError) null);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void playCompletion() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduRewardVideoAdapter.this.getAdapterRit(), BaiduRewardVideoAdapter.this.getAdSlotId()) + "Baidu rewardVideo video complete and reward verify ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterRewardedAdListener) {
                b().onVideoComplete();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            RewardVideoAd rewardVideoAd = this.a;
            if (rewardVideoAd != null) {
                rewardVideoAd.show();
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "baidu";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return AdSettings.getSDKVersion();
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
            new BaiduRewardVideoAd().a();
        }
    }
}
