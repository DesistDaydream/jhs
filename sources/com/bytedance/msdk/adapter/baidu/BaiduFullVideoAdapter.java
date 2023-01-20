package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMFullVideoBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* loaded from: classes.dex */
public class BaiduFullVideoAdapter extends GMFullVideoBaseAdapter {
    private Context z;

    /* loaded from: classes.dex */
    public class BaiduFullVideoAd extends TTBaseAd implements FullScreenVideoAd.FullScreenVideoAdListener {
        private FullScreenVideoAd a;

        public BaiduFullVideoAd() {
        }

        @JProtect
        private ITTAdapterFullVideoAdListener b() {
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
            return (ITTAdapterFullVideoAdListener) this.mTTAdatperCallback;
        }

        @JProtect
        public void a() {
            this.a = new FullScreenVideoAd(BaiduFullVideoAdapter.this.z, BaiduFullVideoAdapter.this.getAdSlotId(), this);
            GMAdSlotFullVideo gMAdSlotFullVideo = BaiduFullVideoAdapter.this.mGMAdSlotFullVideo;
            if (gMAdSlotFullVideo != null) {
                GMAdSlotBaiduOption gMAdSlotBaiduOption = gMAdSlotFullVideo.getGMAdSlotBaiduOption();
                String appSid = gMAdSlotBaiduOption != null ? gMAdSlotBaiduOption.getAppSid() : null;
                if (!TextUtils.isEmpty(appSid)) {
                    this.a.setAppSid(appSid);
                }
            }
            this.a.load();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClick() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduFullVideoAdapter.this.getAdapterRit(), BaiduFullVideoAdapter.this.getAdSlotId()) + "Baidu fullVideo ad onAdClick ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                b().onFullVideoAdClick();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClose(float f2) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduFullVideoAdapter.this.getAdapterRit(), BaiduFullVideoAdapter.this.getAdSlotId()) + "Baidu fullVideo ad onAdClose ...");
            if (!(this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener)) {
                return;
            }
            b().onFullVideoAdClosed();
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

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdFailed(String str) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduFullVideoAdapter.this.getAdapterRit(), BaiduFullVideoAdapter.this.getAdSlotId()) + "Baidu fullVideo load fail: " + str);
            BaiduFullVideoAdapter.this.notifyAdFailed(new AdError(str));
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
            if (r1 < 27) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
            if (r2 > '=') goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
            com.bytedance.msdk.adapter.util.Logger.d("TTMediationSDK", com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r5.b.getAdapterRit(), r5.b.getAdSlotId()) + "Baidu fullVideo load success");
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r5.a == null) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
            if (r5.b.isClientBidding() == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
            r2 = 0.0d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
            r2 = java.lang.Double.valueOf(r5.a.getECPMLevel()).doubleValue();
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0089, code lost:
            if (r5.b.isMultiBidding() == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008b, code lost:
            setLevelTag(r5.a.getECPMLevel());
            r0 = new java.lang.StringBuilder();
            r0.append(com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r5.b.getAdapterRit(), r5.b.getAdSlotId()));
            r2 = "Baidu_多阶底价 full 返回的 价格标签：";
         */
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onAdLoaded() {
            /*
                r5 = this;
                r0 = 61
                r1 = 29
                r2 = 61
            L6:
                r3 = 84
            L8:
                r4 = 27
                switch(r3) {
                    case 84: goto Lc7;
                    case 85: goto L1b;
                    case 86: goto Le;
                    default: goto Ld;
                }
            Ld:
                goto L6
            Le:
                switch(r1) {
                    case 37: goto L12;
                    case 38: goto L1d;
                    case 39: goto Lc7;
                    default: goto L11;
                }
            L11:
                goto L18
            L12:
                switch(r2) {
                    case 25: goto L6;
                    case 26: goto Lc7;
                    case 27: goto L6;
                    default: goto L15;
                }
            L15:
                r2 = 27
                goto L12
            L18:
                r1 = 39
                goto Le
            L1b:
                if (r1 >= r4) goto L21
            L1d:
                if (r2 <= r0) goto L21
            L1f:
            L20:
                goto L1f
            L21:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter r1 = com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.this
                java.lang.String r1 = r1.getAdapterRit()
                com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.this
                java.lang.String r2 = r2.getAdSlotId()
                java.lang.String r1 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r1, r2)
                r0.append(r1)
                java.lang.String r1 = "Baidu fullVideo load success"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "TTMediationSDK"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                com.baidu.mobads.sdk.api.FullScreenVideoAd r0 = r5.a
                if (r0 == 0) goto Lc1
                com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.this
                boolean r0 = r0.isClientBidding()
                java.lang.String r1 = "TTMediationSDK_ECMP"
                if (r0 == 0) goto L83
                r2 = 0
                com.baidu.mobads.sdk.api.FullScreenVideoAd r0 = r5.a     // Catch: java.lang.Exception -> L65
                java.lang.String r0 = r0.getECPMLevel()     // Catch: java.lang.Exception -> L65
                java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch: java.lang.Exception -> L65
                double r2 = r0.doubleValue()     // Catch: java.lang.Exception -> L65
            L65:
                r5.setCpm(r2)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.this
                java.lang.String r2 = r2.getAdapterRit()
                com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter r3 = com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.this
                java.lang.String r3 = r3.getAdSlotId()
                java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                r0.append(r2)
                java.lang.String r2 = "Baidu_cientBidding full 返回的 cpm价格："
                goto Lae
            L83:
                com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.this
                boolean r0 = r0.isMultiBidding()
                if (r0 == 0) goto Lc1
                com.baidu.mobads.sdk.api.FullScreenVideoAd r0 = r5.a
                java.lang.String r0 = r0.getECPMLevel()
                r5.setLevelTag(r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.this
                java.lang.String r2 = r2.getAdapterRit()
                com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter r3 = com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.this
                java.lang.String r3 = r3.getAdSlotId()
                java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                r0.append(r2)
                java.lang.String r2 = "Baidu_多阶底价 full 返回的 价格标签："
            Lae:
                r0.append(r2)
                com.baidu.mobads.sdk.api.FullScreenVideoAd r2 = r5.a
                java.lang.String r2 = r2.getECPMLevel()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
            Lc1:
                com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.this
                r0.notifyAdLoaded(r5)
                return
            Lc7:
                r3 = 85
                r1 = 93
                goto L8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduFullVideoAdapter.BaiduFullVideoAd.onAdLoaded():void");
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdShow() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduFullVideoAdapter.this.getAdapterRit(), BaiduFullVideoAdapter.this.getAdSlotId()) + "Baidu fullVideo ad onAdShow ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                b().onFullVideoAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdSkip(float f2) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduFullVideoAdapter.this.getAdapterRit(), BaiduFullVideoAdapter.this.getAdSlotId()) + "Baidu fullVideo ad onAdSkip ...");
            if (!(this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener)) {
                return;
            }
            b().onSkippedVideo();
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

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduFullVideoAdapter.this.getAdapterRit(), BaiduFullVideoAdapter.this.getAdSlotId()) + "Baidu fullVideo cache fail");
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onVideoDownloadSuccess() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduFullVideoAdapter.this.getAdapterRit(), BaiduFullVideoAdapter.this.getAdSlotId()) + "Baidu fullVideo cache success");
            BaiduFullVideoAdapter.this.notifyAdVideoCache(this, (AdError) null);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void playCompletion() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduFullVideoAdapter.this.getAdapterRit(), BaiduFullVideoAdapter.this.getAdSlotId()) + "Baidu fullVideo play complete ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                b().onVideoComplete();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            FullScreenVideoAd fullScreenVideoAd = this.a;
            if (fullScreenVideoAd != null) {
                fullScreenVideoAd.show();
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

    @Override // com.bytedance.msdk.adapter.ad.GMFullVideoBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        if (this.mGMAdSlotFullVideo == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        this.z = context;
        if (map != null) {
            new BaiduFullVideoAd().a();
        }
    }
}
