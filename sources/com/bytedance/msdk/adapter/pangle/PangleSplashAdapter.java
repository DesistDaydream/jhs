package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMSplashBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.UIUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ISplashCardListener;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PangleSplashAdapter extends GMSplashBaseAdapter {
    public static final String VERSION_00 = "0.0";
    public static final String VERSION_4712 = "4.7.1.2";
    private int A = 3000;
    private PangleSplashAd B;
    private Context z;

    /* loaded from: classes.dex */
    public class PangleSplashAd extends TTBaseAd {
        private TTSplashAd a;
        private CSJSplashAd b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1861c;

        public PangleSplashAd() {
        }

        private void f(TTAdNative tTAdNative, AdSlot adSlot) {
            tTAdNative.loadSplashAd(adSlot, new TTAdNative.CSJSplashAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                @MainThread
                @JProtect
                public void onSplashLoadFail(CSJAdError cSJAdError) {
                    Logger.e("TTMediationSDK", "new api onSplashLoadFail");
                    if (cSJAdError != null) {
                        PangleSplashAdapter.this.notifyAdFailed(new AdError(cSJAdError.getCode(), cSJAdError.getMsg()));
                    } else {
                        PangleSplashAdapter.this.notifyAdFailed(new AdError("csjAdError is null"));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                @MainThread
                @JProtect
                public void onSplashLoadSuccess() {
                    while (true) {
                        char c2 = '^';
                        char c3 = 'K';
                        while (true) {
                            switch (c2) {
                                case '\\':
                                    switch (c3) {
                                        case 21:
                                            Logger.e("TTMediationSDK", "new api onSplashLoadSuccess");
                                            c2 = ']';
                                            c3 = ']';
                                        case 22:
                                        case 23:
                                            return;
                                    }
                                    break;
                                case ']':
                                    break;
                                case '^':
                                    if (c3 <= 4) {
                                        c2 = ']';
                                        c3 = ']';
                                    }
                                    Logger.e("TTMediationSDK", "new api onSplashLoadSuccess");
                                    c2 = ']';
                                    c3 = ']';
                                default:
                                    c2 = ']';
                                    c3 = ']';
                            }
                            while (true) {
                                switch (c3) {
                                    case '[':
                                        break;
                                    case '\\':
                                        break;
                                    case ']':
                                        return;
                                    default:
                                        c3 = '[';
                                }
                            }
                            Logger.e("TTMediationSDK", "new api onSplashLoadSuccess");
                            c2 = ']';
                            c3 = ']';
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                @MainThread
                @JProtect
                public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                    Logger.e("TTMediationSDK", "new api onSplashRenderFail");
                    PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
                    if (cSJAdError != null) {
                        pangleSplashAdapter.notifyAdFailed(new AdError(cSJAdError.getCode(), cSJAdError.getMsg()));
                    } else {
                        pangleSplashAdapter.notifyAdFailed(new AdError("csjAdError is null"));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                @MainThread
                @JProtect
                public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                    Map<String, Object> mediaExtraInfo;
                    Logger.e("TTMediationSDK", "new api onSplashRenderSuccess");
                    if (cSJSplashAd != null) {
                        PangleSplashAd.this.b = cSJSplashAd;
                        PangleSplashAd.this.setExpressAd(true);
                        PangleSplashAd pangleSplashAd = PangleSplashAd.this;
                        pangleSplashAd.setInteractionType(pangleSplashAd.b.getInteractionType());
                        if (PangleSplashAdapter.this.isClientBidding() && (mediaExtraInfo = PangleSplashAd.this.b.getMediaExtraInfo()) != null) {
                            double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                            Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleSplashAdapter.this.getAdapterRit(), PangleSplashAdapter.this.getAdSlotId()) + "pangle Splash 返回的 cpm价格：" + value);
                            PangleSplashAd pangleSplashAd2 = PangleSplashAd.this;
                            if (value <= 0.0d) {
                                value = 0.0d;
                            }
                            pangleSplashAd2.setCpm(value);
                        }
                        PangleSplashAd.this.b.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.1.1
                            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                            public void onSplashAdClick(CSJSplashAd cSJSplashAd2) {
                                Logger.e("TTMediationSDK", "new api onSplashAdClick");
                                if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                    PangleSplashAd.this.g().onAdClicked();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                            public void onSplashAdClose(CSJSplashAd cSJSplashAd2, int i2) {
                                Logger.e("TTMediationSDK", "new api onSplashAdClose closeType = " + i2);
                                if (i2 == 1 || i2 == 3) {
                                    if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                        PangleSplashAd.this.g().onAdSkip();
                                    }
                                } else if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                    PangleSplashAd.this.g().onAdDismiss();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                            public void onSplashAdShow(CSJSplashAd cSJSplashAd2) {
                                Logger.e("TTMediationSDK", "new api onSplashAdShow");
                                if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                    PangleSplashAd.this.g().onAdShow();
                                }
                            }
                        });
                        PangleSplashAd.this.b.setSplashCardListener(new CSJSplashAd.SplashCardListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.1.2
                            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                            public void onSplashCardClick() {
                                Logger.e("TTMediationSDK", "new api onSplashCardClick");
                                try {
                                    if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                        PangleSplashAd.this.g().onSplashCardClick();
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                            public void onSplashCardClose() {
                                Logger.e("TTMediationSDK", "new api onSplashCardClose");
                                if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                    PangleSplashAd.this.g().onSplashClickEyeClose();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                            public void onSplashCardReadyToShow(CSJSplashAd cSJSplashAd2) {
                                Logger.e("TTMediationSDK", "new api onSplashCardReadyToShow");
                                Logger.e("TTMediationSDK", "new api onSplashCardReadyToShow csjSplashAd.getSplashCardView()" + cSJSplashAd2.getSplashCardView());
                                if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                    PangleSplashAd.this.g().setSupportSplashClickEye(true);
                                }
                                if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                    PangleSplashAd.this.g().onSplashEyeReady();
                                }
                            }
                        });
                        PangleSplashAd.this.b.setSplashClickEyeListener(new CSJSplashAd.SplashClickEyeListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.1.3
                            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                            public void onSplashClickEyeClick() {
                                Logger.e("TTMediationSDK", "new api onSplashClickEyeClick");
                                if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                    PangleSplashAd.this.g().onSplashClickEyeClick();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                            public void onSplashClickEyeClose() {
                                Logger.e("TTMediationSDK", "new api onSplashClickEyeClose");
                                if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                    PangleSplashAd.this.g().onMinWindowPlayFinish();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                            public void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd2) {
                                Logger.e("TTMediationSDK", "new api onSplashClickEyeReadyToShow");
                                PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                                pangleSplashAd3.f1861c = true;
                                if (pangleSplashAd3.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                    PangleSplashAd.this.g().onMinWindowStart();
                                }
                            }
                        });
                        PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                        PangleSplashAdapter.this.notifyAdLoaded(pangleSplashAd3);
                        return;
                    }
                    PangleSplashAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    while (true) {
                        char c2 = 11;
                        while (true) {
                            switch (c2) {
                                case '\n':
                                    return;
                                case 11:
                                    c2 = '\n';
                                case '\f':
                                    break;
                                default:
                                    c2 = '\f';
                            }
                        }
                    }
                }
            }, PangleSplashAdapter.this.A);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JProtect
        public ITTAdapterSplashAdListener g() {
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
            return (ITTAdapterSplashAdListener) this.mTTAdatperCallback;
        }

        private void i(TTAdNative tTAdNative, AdSlot adSlot) {
            tTAdNative.loadSplashAd(adSlot, new TTAdNative.SplashAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.2
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
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                @androidx.annotation.MainThread
                @com.bytedance.JProtect
                public void onError(int r3, java.lang.String r4) {
                    /*
                        r2 = this;
                        com.bytedance.msdk.adapter.pangle.PangleSplashAdapter$PangleSplashAd r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.this
                        com.bytedance.msdk.adapter.pangle.PangleSplashAdapter r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.this
                        com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                        r1.<init>(r3, r4)
                        r0.notifyAdFailed(r1)
                        r3 = 92
                    Le:
                        r4 = 14
                    L10:
                        switch(r4) {
                            case 13: goto L19;
                            case 14: goto L1b;
                            case 15: goto L14;
                            default: goto L13;
                        }
                    L13:
                        goto Le
                    L14:
                        switch(r3) {
                            case 94: goto L1b;
                            case 95: goto L18;
                            case 96: goto L1b;
                            default: goto L17;
                        }
                    L17:
                        goto L1b
                    L18:
                        return
                    L19:
                        r4 = 72
                    L1b:
                        r4 = 15
                        r3 = 95
                        goto L10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.AnonymousClass2.onError(int, java.lang.String):void");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
                @MainThread
                @JProtect
                public void onSplashAdLoad(TTSplashAd tTSplashAd) {
                    Map<String, Object> mediaExtraInfo;
                    if (tTSplashAd == null) {
                        PangleSplashAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                        return;
                    }
                    PangleSplashAd.this.a = tTSplashAd;
                    PangleSplashAd.this.setExpressAd(true);
                    PangleSplashAd pangleSplashAd = PangleSplashAd.this;
                    pangleSplashAd.setInteractionType(pangleSplashAd.a.getInteractionType());
                    if (PangleSplashAdapter.this.isClientBidding() && (mediaExtraInfo = PangleSplashAd.this.a.getMediaExtraInfo()) != null) {
                        double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                        Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleSplashAdapter.this.getAdapterRit(), PangleSplashAdapter.this.getAdSlotId()) + "pangle Splash 返回的 cpm价格：" + value);
                        PangleSplashAd pangleSplashAd2 = PangleSplashAd.this;
                        if (value <= 0.0d) {
                            value = 0.0d;
                        }
                        pangleSplashAd2.setCpm(value);
                    }
                    PangleSplashAd.this.a.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.2.1
                        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                        public void onAdClicked(View view, int i2) {
                            if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.g().onAdClicked();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                        public void onAdShow(View view, int i2) {
                            if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.g().onAdShow();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                        public void onAdSkip() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onAdSkip");
                            if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.g().onAdSkip();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                        public void onAdTimeOver() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onAdTimeOver");
                            if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.g().onAdDismiss();
                            }
                        }
                    });
                    PangleSplashAd.this.a.setSplashClickEyeListener(new ISplashClickEyeListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.2.2
                        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
                        public boolean isSupportSplashClickEye(boolean z) {
                            Logger.e("TTMediationSDK", "穿山甲_splash_isSupportSplashClickEye:" + z);
                            PangleSplashAd.this.f1861c = z;
                            return false;
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
                        public void onSplashClickEyeAnimationFinish() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onSplashClickEyeAnimationFinish");
                            if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.g().onMinWindowPlayFinish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
                        public void onSplashClickEyeAnimationStart() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onSplashClickEyeAnimationStart");
                            PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                            if (pangleSplashAd3.f1861c && (pangleSplashAd3.mTTAdatperCallback instanceof ITTAdapterSplashAdListener)) {
                                PangleSplashAd.this.g().onMinWindowStart();
                            }
                        }
                    });
                    PangleSplashAd.this.a.setSplashCardListener(new ISplashCardListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.2.3
                        @Override // com.bytedance.sdk.openadsdk.ISplashCardListener
                        public Activity getActivity() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_getActivity");
                            if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                return PangleSplashAd.this.g().getActivity();
                            }
                            return null;
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashCardListener
                        public void onSplashClickEyeClose() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onSplashClickEyeClose");
                            if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.g().onSplashClickEyeClose();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashCardListener
                        public void onSplashEyeReady() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onSplashEyeReady");
                            if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.g().onSplashEyeReady();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashCardListener
                        public void setSupportSplashClickEye(boolean z) {
                            Logger.e("TTMediationSDK", "穿山甲_splash_setSupportSplashClickEye");
                            if (PangleSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.g().setSupportSplashClickEye(z);
                            }
                        }
                    });
                    PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                    PangleSplashAdapter.this.notifyAdLoaded(pangleSplashAd3);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
                @MainThread
                @JProtect
                public void onTimeout() {
                    PangleSplashAdapter.this.notifyAdFailed(new AdError("splash ad load timeout !"));
                }
            }, PangleSplashAdapter.this.A);
        }

        @JProtect
        public void e() {
            TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(PangleSplashAdapter.this.z);
            com.bytedance.msdk.api.AdSlot adSlot = PangleSplashAdapter.this.mAdSlot;
            PangleSplashAdapter pangleSplashAdapter = PangleSplashAdapter.this;
            AdSlot.Builder buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(adSlot, pangleSplashAdapter.mGMAdSlotSplash, pangleSplashAdapter.getAdSlotId(), PangleSplashAdapter.this.mWaterfallAbTestParam, PangleSplashAdapter.this.getClientReqId(), PangleSplashAdapter.this.getAdm(), false);
            buildPangleAdSlot.setImageAcceptedSize(PangleSplashAdapter.this.mGMAdSlotSplash.getWidth(), PangleSplashAdapter.this.mGMAdSlotSplash.getHeight()).setExpressViewAcceptedSize(UIUtils.px2dip(PangleSplashAdapter.this.z, PangleSplashAdapter.this.mGMAdSlotSplash.getWidth()), UIUtils.px2dip(PangleSplashAdapter.this.z, PangleSplashAdapter.this.mGMAdSlotSplash.getHeight()));
            AdSlot build = buildPangleAdSlot.build();
            if (PangleSplashAdapter.this.n()) {
                Logger.e("TTMediationSDK", "use old api load splash ad");
                i(createAdNative, build);
                return;
            }
            Logger.e("TTMediationSDK", "use new api load splash ad");
            f(createAdNative, build);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            Map<String, Object> mediaExtraInfo;
            if (PangleSplashAdapter.this.n()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null) {
                    mediaExtraInfo = tTSplashAd.getMediaExtraInfo();
                    return PangleAdapterUtils.getAdId(mediaExtraInfo);
                }
                return super.getAdId();
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                mediaExtraInfo = cSJSplashAd.getMediaExtraInfo();
                return PangleAdapterUtils.getAdId(mediaExtraInfo);
            }
            return super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            Map<String, Object> mediaExtraInfo;
            if (PangleSplashAdapter.this.n()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null) {
                    mediaExtraInfo = tTSplashAd.getMediaExtraInfo();
                    return PangleAdapterUtils.getCreativeId(mediaExtraInfo);
                }
                return super.getCreativeId();
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                mediaExtraInfo = cSJSplashAd.getMediaExtraInfo();
                return PangleAdapterUtils.getCreativeId(mediaExtraInfo);
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            HashMap hashMap;
            if (PangleSplashAdapter.this.n()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null && (mediaExtraInfo = tTSplashAd.getMediaExtraInfo()) != null) {
                    hashMap = new HashMap();
                    hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
                    hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
                    hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
                    return hashMap;
                }
                return super.getMediaExtraInfo();
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null && (mediaExtraInfo = cSJSplashAd.getMediaExtraInfo()) != null) {
                hashMap = new HashMap();
                hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
                hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
                hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
                return hashMap;
            }
            return super.getMediaExtraInfo();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int[] getMinWindowSize() {
            if (PangleSplashAdapter.this.n()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null) {
                    return tTSplashAd.getSplashClickEyeSizeToDp();
                }
                return null;
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                return cSJSplashAd.getSplashClickEyeSizeToDp();
            }
            return null;
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
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        @Override // com.bytedance.msdk.base.TTBaseAd
        @com.bytedance.JProtect
        public java.lang.String getReqId() {
            /*
                r3 = this;
                r0 = 55
                r1 = 0
            L3:
                r2 = 72
            L5:
                switch(r2) {
                    case 72: goto L36;
                    case 73: goto L13;
                    case 74: goto L9;
                    default: goto L8;
                }
            L8:
                goto L3
            L9:
                switch(r1) {
                    case 52: goto L3;
                    case 53: goto Ld;
                    case 54: goto L36;
                    default: goto Lc;
                }
            Lc:
                goto L13
            Ld:
                switch(r0) {
                    case 29: goto L3;
                    case 30: goto L3;
                    case 31: goto L9;
                    default: goto L10;
                }
            L10:
                r0 = 30
                goto Ld
            L13:
                com.bytedance.msdk.adapter.pangle.PangleSplashAdapter r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.this
                boolean r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.H(r0)
                if (r0 == 0) goto L28
                com.bytedance.sdk.openadsdk.TTSplashAd r0 = r3.a
                if (r0 == 0) goto L31
                java.util.Map r0 = r0.getMediaExtraInfo()
            L23:
                java.lang.String r0 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.getReqId(r0)
                return r0
            L28:
                com.bytedance.sdk.openadsdk.CSJSplashAd r0 = r3.b
                if (r0 == 0) goto L31
                java.util.Map r0 = r0.getMediaExtraInfo()
                goto L23
            L31:
                java.lang.String r0 = super.getReqId()
                return r0
            L36:
                r2 = 73
                r1 = 16
                goto L5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.getReqId():java.lang.String");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return PangleSplashAdapter.this.n() ? this.a == null : this.b == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            if (PangleSplashAdapter.this.n()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null) {
                    tTSplashAd.setSplashInteractionListener(null);
                    this.a.setDownloadListener(null);
                    this.a.renderExpressAd(null);
                    this.a = null;
                    return;
                }
                return;
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                cSJSplashAd.setSplashAdListener(null);
                this.b.setDownloadListener(null);
                this.b.setSplashCardListener(null);
                this.b.setSplashClickEyeListener(null);
                this.b = null;
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:33:0x003c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0052 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0040 A[LOOP:0: B:21:0x0040->B:36:0x0040, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x003c -> B:21:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0040 -> B:30:0x0052). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0044 -> B:30:0x0052). Please submit an issue!!! */
        @Override // com.bytedance.msdk.base.TTBaseAd
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void showSplashAd(android.view.ViewGroup r4) {
            /*
                r3 = this;
                com.bytedance.msdk.adapter.pangle.PangleSplashAdapter r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.this
                boolean r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.H(r0)
                if (r0 == 0) goto L2c
                com.bytedance.sdk.openadsdk.TTSplashAd r0 = r3.a
                if (r0 == 0) goto L55
                if (r4 == 0) goto L55
                android.view.View r0 = r0.getSplashView()
                if (r0 == 0) goto L55
                android.view.ViewParent r1 = r0.getParent()
                boolean r2 = r1 instanceof android.view.ViewGroup
                if (r2 == 0) goto L21
                android.view.ViewGroup r1 = (android.view.ViewGroup) r1
                r1.removeView(r0)
            L21:
                r4.removeAllViews()
                r4.addView(r0)
                r4 = 30
                r0 = 30
                goto L52
            L2c:
                com.bytedance.sdk.openadsdk.CSJSplashAd r0 = r3.b
                if (r0 == 0) goto L36
                if (r4 == 0) goto L55
                r0.showSplashView(r4)
                goto L55
            L36:
                r4 = 96
            L38:
                switch(r4) {
                    case 94: goto L55;
                    case 95: goto L3c;
                    case 96: goto L55;
                    default: goto L3b;
                }
            L3b:
                goto L56
            L3c:
                r4 = 82
                r0 = 80
            L40:
                switch(r4) {
                    case 82: goto L44;
                    case 83: goto L40;
                    case 84: goto L3c;
                    default: goto L43;
                }
            L43:
                goto L52
            L44:
                switch(r0) {
                    case 80: goto L55;
                    case 81: goto L52;
                    case 82: goto L48;
                    default: goto L47;
                }
            L47:
                goto L4f
            L48:
                r1 = 59
                if (r4 == r1) goto L4d
                goto L55
            L4d:
                r4 = r0
                goto L38
            L4f:
                r0 = 81
                goto L44
            L52:
                r4 = 84
                goto L40
            L55:
                return
            L56:
                r4 = 95
                goto L38
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.showSplashAd(android.view.ViewGroup):void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                cSJSplashAd.showSplashCardView(viewGroup, activity);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showSplashClickEyeView(ViewGroup viewGroup) {
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                cSJSplashAd.showSplashClickEyeView(viewGroup);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void splashMinWindowAnimationFinish() {
            TTSplashAd tTSplashAd = this.a;
            if (tTSplashAd != null) {
                tTSplashAd.splashClickEyeAnimationFinish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        return !"0.0".equals(getSdkVersion()) && VERSION_4712.compareTo(getSdkVersion()) > 0;
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return TTAdSdk.getAdManager().getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.ad.GMSplashBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        this.z = context;
        if (this.mGMAdSlotSplash == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
        } else if (map != null) {
            this.A = map.containsKey(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT) ? ((Integer) map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT)).intValue() : this.A;
            PangleSplashAd pangleSplashAd = new PangleSplashAd();
            this.B = pangleSplashAd;
            pangleSplashAd.e();
        }
    }
}
