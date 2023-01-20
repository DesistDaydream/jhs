package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMInterstitialBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* loaded from: classes.dex */
public class BaiduInterstitialAdapter extends GMInterstitialBaseAdapter {
    private static final String A = "BaiduInterstitialAdapter";
    private Context z;

    /* loaded from: classes.dex */
    public class BaiduExpressInterstitialAd extends TTBaseAd implements ExpressInterstitialListener {
        private ExpressInterstitialAd a;

        public BaiduExpressInterstitialAd() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener b() {
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
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.BaiduExpressInterstitialAd.b():com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener");
        }

        @JProtect
        public void a() {
            ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(BaiduInterstitialAdapter.this.z.getApplicationContext(), BaiduInterstitialAdapter.this.getAdSlotId());
            this.a = expressInterstitialAd;
            expressInterstitialAd.setLoadListener(this);
            this.a.load();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
            if (r2 != '8') goto L11;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x001f -> B:14:0x0022). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:5:0x0010 -> B:6:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0014 -> B:14:0x0022). Please submit an issue!!! */
        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onADExposed() {
            /*
                r3 = this;
                com.bytedance.msdk.adapter.listener.ITTAdatperCallback r0 = r3.mTTAdatperCallback
                boolean r0 = r0 instanceof com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener
                r1 = 95
                if (r0 == 0) goto L10
                com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener r0 = r3.b()
                r0.onInterstitialShow()
                goto L22
            L10:
                r0 = 95
                r2 = 95
            L14:
                switch(r0) {
                    case 94: goto L10;
                    case 95: goto L18;
                    case 96: goto L1d;
                    default: goto L17;
                }
            L17:
                goto L22
            L18:
                switch(r2) {
                    case 94: goto L10;
                    case 95: goto L1c;
                    case 96: goto L10;
                    default: goto L1b;
                }
            L1b:
                goto L1d
            L1c:
                return
            L1d:
                r0 = 56
                if (r2 == r0) goto L22
                goto L10
            L22:
                r0 = 94
                r2 = 125(0x7d, float:1.75E-43)
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.BaiduExpressInterstitialAd.onADExposed():void");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onADExposureFailed() {
            if (this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                b().onInterstitialShowFail(new AdError("广告展示失败"));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
            if (r1 < 27) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
            if (r2 <= '=') goto L11;
         */
        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onADLoaded() {
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
                    case 84: goto Lcc;
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
                    case 39: goto Lcc;
                    default: goto L11;
                }
            L11:
                goto L18
            L12:
                switch(r2) {
                    case 25: goto L21;
                    case 26: goto Lcc;
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
                com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter r1 = com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.this
                java.lang.String r1 = r1.getAdapterRit()
                com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.this
                java.lang.String r2 = r2.getAdSlotId()
                java.lang.String r1 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r1, r2)
                r0.append(r1)
                java.lang.String r1 = "Baidu ExpressInterstitial load success"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "TTMediationSDK"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                com.baidu.mobads.sdk.api.ExpressInterstitialAd r0 = r5.a
                if (r0 == 0) goto Lc6
                com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.this
                boolean r0 = r0.isClientBidding()
                java.lang.String r1 = "TTMediationSDK_ECMP"
                if (r0 == 0) goto L88
                r2 = 0
                com.baidu.mobads.sdk.api.ExpressInterstitialAd r0 = r5.a     // Catch: java.lang.Exception -> L66
                java.lang.String r0 = r0.getECPMLevel()     // Catch: java.lang.Exception -> L66
                java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch: java.lang.Exception -> L66
                double r2 = r0.doubleValue()     // Catch: java.lang.Exception -> L66
                goto L6a
            L66:
                r0 = move-exception
                r0.printStackTrace()
            L6a:
                r5.setCpm(r2)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.this
                java.lang.String r2 = r2.getAdapterRit()
                com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter r3 = com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.this
                java.lang.String r3 = r3.getAdSlotId()
                java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                r0.append(r2)
                java.lang.String r2 = "Baidu_cientBidding full 返回的 cpm价格："
                goto Lb3
            L88:
                com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.this
                boolean r0 = r0.isMultiBidding()
                if (r0 == 0) goto Lc6
                com.baidu.mobads.sdk.api.ExpressInterstitialAd r0 = r5.a
                java.lang.String r0 = r0.getECPMLevel()
                r5.setLevelTag(r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.this
                java.lang.String r2 = r2.getAdapterRit()
                com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter r3 = com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.this
                java.lang.String r3 = r3.getAdSlotId()
                java.lang.String r2 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r2, r3)
                r0.append(r2)
                java.lang.String r2 = "Baidu_多阶底价 full 返回的 价格标签："
            Lb3:
                r0.append(r2)
                com.baidu.mobads.sdk.api.ExpressInterstitialAd r2 = r5.a
                java.lang.String r2 = r2.getECPMLevel()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
            Lc6:
                com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.this
                r0.notifyAdLoaded(r5)
                return
            Lcc:
                r3 = 85
                r1 = 93
                goto L8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.BaiduExpressInterstitialAd.onADLoaded():void");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdCacheFailed() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu ExpressInterstitialAd cache fail");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdCacheSuccess() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu ExpressInterstitialAd cache success");
            BaiduInterstitialAdapter.this.notifyAdVideoCache(this, (AdError) null);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdClick() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu ExpressInterstitial ad  onAdClick ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                b().onInterstitialAdClick();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdClose() {
            if (this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                b().onInterstitialClosed();
            }
            Logger.e(BaiduInterstitialAdapter.A, "onAdClose");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdFailed(int i2, String str) {
            Logger.d("TTMediationSDK", "Baidu ExpressInterstitial onAdFailed " + str);
            BaiduInterstitialAdapter.this.notifyAdFailed(new AdError(i2, str));
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            if (this.a != null) {
                this.a = null;
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0021 -> B:13:0x0023). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:5:0x0010 -> B:6:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0018 -> B:13:0x0023). Please submit an issue!!! */
        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onLpClosed() {
            /*
                r3 = this;
                com.bytedance.msdk.adapter.listener.ITTAdatperCallback r0 = r3.mTTAdatperCallback
                boolean r0 = r0 instanceof com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener
                r1 = 95
                if (r0 == 0) goto L10
                com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener r0 = r3.b()
                r0.onAdLeftApplication()
                goto L23
            L10:
                r0 = 94
                r2 = 125(0x7d, float:1.75E-43)
            L14:
                switch(r0) {
                    case 94: goto L1f;
                    case 95: goto L18;
                    case 96: goto L1b;
                    default: goto L17;
                }
            L17:
                goto L10
            L18:
                switch(r2) {
                    case 94: goto L23;
                    case 95: goto L10;
                    case 96: goto L23;
                    default: goto L1b;
                }
            L1b:
                switch(r2) {
                    case 55: goto L10;
                    case 56: goto L10;
                    case 57: goto L10;
                    default: goto L1e;
                }
            L1e:
                goto L28
            L1f:
                r0 = 39
                if (r2 != r0) goto L28
            L23:
                r0 = 95
                r2 = 95
                goto L14
            L28:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.BaiduExpressInterstitialAd.onLpClosed():void");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onNoAd(int i2, String str) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu onNoAd ExpressInterstitial message=" + str + "，errorCode=" + i2);
            BaiduInterstitialAdapter.this.notifyAdFailed(new AdError(i2, str));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        @Deprecated
        public void onVideoDownloadFailed() {
            while (true) {
                char c2 = '^';
                char c3 = 'K';
                while (true) {
                    if (c2 == '\\') {
                        switch (c3) {
                            case 21:
                                return;
                            case 22:
                            case 23:
                                c2 = ']';
                                c3 = ']';
                        }
                    } else if (c2 != ']') {
                        c2 = ']';
                        c3 = ']';
                    }
                }
                while (true) {
                    switch (c3) {
                        case '[':
                            break;
                        case '\\':
                        case ']':
                            return;
                        default:
                            c3 = '[';
                    }
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        @Deprecated
        public void onVideoDownloadSuccess() {
            while (true) {
                char c2 = ']';
                char c3 = ']';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    return;
                            }
                            c2 = '^';
                            c3 = 'K';
                            break;
                        case ']':
                            while (true) {
                                switch (c3) {
                                    case '[':
                                    case ']':
                                        break;
                                    case '\\':
                                        return;
                                    default:
                                        c3 = '[';
                                }
                            }
                            c2 = '^';
                            c3 = 'K';
                            break;
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

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            ExpressInterstitialAd expressInterstitialAd = this.a;
            if (expressInterstitialAd != null) {
                expressInterstitialAd.show(activity);
            }
        }
    }

    /* loaded from: classes.dex */
    public class BaiduInterstitialAd extends TTBaseAd implements InterstitialAdListener {
        private InterstitialAd a;

        public BaiduInterstitialAd() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener b() {
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
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.BaiduInterstitialAd.b():com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener");
        }

        @JProtect
        public void a() {
            this.a = new InterstitialAd(BaiduInterstitialAdapter.this.z, BaiduInterstitialAdapter.this.getAdSlotId());
            GMAdSlotInterstitial gMAdSlotInterstitial = BaiduInterstitialAdapter.this.mGMAdSlotInterstitial;
            if (gMAdSlotInterstitial != null) {
                GMAdSlotBaiduOption gMAdSlotBaiduOption = gMAdSlotInterstitial.getGMAdSlotBaiduOption();
                String appSid = gMAdSlotBaiduOption != null ? gMAdSlotBaiduOption.getAppSid() : null;
                if (!TextUtils.isEmpty(appSid)) {
                    this.a.setAppSid(appSid);
                }
            }
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu interstitial ad load 1 ...");
            this.a.setListener(this);
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu interstitial ad load 2 ...");
            this.a.loadAd();
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu interstitial ad load 3 ...");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdClick(InterstitialAd interstitialAd) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu interstitial ad  onAdClick ...");
            if (!(this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener)) {
                return;
            }
            b().onInterstitialAdClick();
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

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdDismissed() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu interstitial ad  close ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                b().onInterstitialClosed();
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdFailed(String str) {
            Logger.d("TTMediationSDK", "Baidu Interstitial onAdFailed " + str);
            BaiduInterstitialAdapter.this.notifyAdFailed(new AdError(str));
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdPresent() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduInterstitialAdapter.this.getAdapterRit(), BaiduInterstitialAdapter.this.getAdSlotId()) + "Baidu interstitial ad onAdPresent --> show ...");
            if (this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                b().onInterstitialShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdReady() {
            Logger.d("TTMediationSDK", "Baidu Interstitial onAdReady --> load success");
            BaiduInterstitialAdapter.this.notifyAdLoaded(this);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            InterstitialAd interstitialAd = this.a;
            if (interstitialAd != null) {
                interstitialAd.destroy();
                this.a = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            InterstitialAd interstitialAd = this.a;
            if (interstitialAd != null) {
                interstitialAd.showAd();
            }
        }
    }

    @JProtect
    private void F() {
        new BaiduExpressInterstitialAd().a();
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

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c A[SYNTHETIC] */
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void G() {
        /*
            r4 = this;
            com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter$BaiduInterstitialAd r0 = new com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter$BaiduInterstitialAd
            r0.<init>()
            r0.a()
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.G():void");
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x003f A[LOOP:0: B:23:0x003f->B:28:0x003f, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x003b -> B:25:0x0042). Please submit an issue!!! */
    @Override // com.bytedance.msdk.adapter.ad.GMInterstitialBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r2, java.util.Map<java.lang.String, java.lang.Object> r3) {
        /*
            r1 = this;
            super.loadAd(r2, r3)
            com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial r0 = r1.mGMAdSlotInterstitial
            if (r0 == 0) goto L45
            r1.z = r2
            if (r3 == 0) goto L39
            java.lang.String r2 = "tt_ad_origin_type"
            java.lang.Object r2 = r3.get(r2)
            if (r2 == 0) goto L35
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = 1
            if (r2 != r3) goto L20
            r1.F()
            return
        L20:
            r3 = 2
            if (r2 != r3) goto L27
            r1.G()
            goto L42
        L27:
            r3 = 3
            if (r2 != r3) goto L35
            com.bytedance.msdk.api.AdError r2 = new com.bytedance.msdk.api.AdError
            java.lang.String r3 = "渲染类型错误"
            r2.<init>(r3)
            r1.notifyAdFailed(r2)
            return
        L35:
            r1.G()
            goto L48
        L39:
            r2 = 58
        L3b:
            switch(r2) {
                case 57: goto L41;
                case 58: goto L48;
                case 59: goto L3f;
                default: goto L3e;
            }
        L3e:
            goto L42
        L3f:
            goto L3f
        L41:
            return
        L42:
            r2 = 57
            goto L3b
        L45:
            r1.notifyLoadFailBecauseGMAdSlotIsNull()
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduInterstitialAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
