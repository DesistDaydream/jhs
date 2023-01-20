package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.SplashDismissController;
import com.bytedance.msdk.adapter.ad.GMSplashBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GdtSplashAdapter extends GMSplashBaseAdapter {
    private GDTSplashAd B;
    private SplashDismissController D;
    private boolean E;
    private Context z;
    private int A = 3000;
    public boolean C = false;

    /* loaded from: classes.dex */
    public class GDTSplashAd extends TTBaseAd {
        private SplashAD a;
        private RelativeLayout b;

        /* renamed from: c  reason: collision with root package name */
        private FrameLayout f1811c;

        /* renamed from: d  reason: collision with root package name */
        public SplashADZoomOutListener f1812d = new SplashADZoomOutListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.1
            public long millisUntilFinished;

            @Override // com.qq.e.ads.splash.SplashADZoomOutListener
            public boolean isSupportZoomOut() {
                Log.d("TTMediationSDK", "GDT-开屏广告--isSupportZoomOut");
                return true;
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            @JProtect
            public void onADClicked() {
                Log.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(GdtSplashAdapter.this.getAdapterRit(), GdtSplashAdapter.this.getAdSlotId()) + "GDT-开屏广告--onADClicked....");
                if (GDTSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    if (GdtSplashAdapter.this.D != null) {
                        GdtSplashAdapter.this.D.setClick(true);
                        GdtSplashAdapter.this.D.setCallBack(new SplashDismissController.CallBack() { // from class: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.1.1
                            @Override // com.bytedance.msdk.adapter.SplashDismissController.CallBack
                            public void onResume() {
                                if (GdtSplashAdapter.this.D == null || !GdtSplashAdapter.this.D.jumpToAdPage() || GdtSplashAdapter.this.D.isCallDismiss() || !(GDTSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener)) {
                                    return;
                                }
                                GDTSplashAd.this.a().onAdDismiss();
                            }
                        });
                    }
                    GDTSplashAd.this.a().onAdClicked();
                    for (char c2 = 16; c2 != 14; c2 = 14) {
                    }
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                if (GDTSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    if (GdtSplashAdapter.this.D == null || !GdtSplashAdapter.this.D.jumpToAdPage()) {
                        if (GdtSplashAdapter.this.D != null) {
                            GdtSplashAdapter.this.D.setCallDismiss(true);
                        }
                        GDTSplashAd.this.a().onAdDismiss();
                    }
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            @JProtect
            public void onADExposure() {
                if (GDTSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    GDTSplashAd.this.a().onAdShow();
                }
                Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(GdtSplashAdapter.this.getAdapterRit(), GdtSplashAdapter.this.getAdSlotId()) + "GDT-开屏广告_onADExposure......onADExposure.....");
                for (char c2 = 'R'; c2 != 'P' && c2 != 'Q'; c2 = 'P') {
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x00c5  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x00d6 A[SYNTHETIC] */
            @Override // com.qq.e.ads.splash.SplashADListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onADLoaded(long r4) {
                /*
                    r3 = this;
                    long r0 = android.os.SystemClock.elapsedRealtime()
                    long r4 = r4 - r0
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.qq.e.ads.splash.SplashAD r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.b(r0)
                    if (r0 == 0) goto Lc8
                    r0 = 1000(0x3e8, double:4.94E-321)
                    int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                    if (r2 <= 0) goto Lc8
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    boolean r4 = r4.isClientBidding()
                    java.lang.String r5 = "TTMediationSDK_ECMP"
                    if (r4 == 0) goto L6c
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.qq.e.ads.splash.SplashAD r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.b(r4)
                    int r0 = r0.getECPM()
                    r1 = -1
                    if (r0 == r1) goto L38
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.qq.e.ads.splash.SplashAD r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.b(r0)
                    int r0 = r0.getECPM()
                    double r0 = (double) r0
                    goto L3a
                L38:
                    r0 = 0
                L3a:
                    r4.setCpm(r0)
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    java.lang.String r0 = r0.getAdapterRit()
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    java.lang.String r1 = r1.getAdSlotId()
                    java.lang.String r0 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r0, r1)
                    r4.append(r0)
                    java.lang.String r0 = "GDT_clientBidding splash 返回的 cpm价格："
                    r4.append(r0)
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.qq.e.ads.splash.SplashAD r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.b(r0)
                    int r0 = r0.getECPM()
                    r4.append(r0)
                    goto Lb1
                L6c:
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    boolean r4 = r4.isMultiBidding()
                    if (r4 == 0) goto Lb8
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.qq.e.ads.splash.SplashAD r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.b(r4)
                    java.lang.String r0 = r0.getECPMLevel()
                    r4.setLevelTag(r0)
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    java.lang.String r0 = r0.getAdapterRit()
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    java.lang.String r1 = r1.getAdSlotId()
                    java.lang.String r0 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagThirdLevelById(r0, r1)
                    r4.append(r0)
                    java.lang.String r0 = "GDT_多阶底价 splash 返回的 价格标签："
                    r4.append(r0)
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.qq.e.ads.splash.SplashAD r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.b(r0)
                    java.lang.String r0 = r0.getECPMLevel()
                    r4.append(r0)
                Lb1:
                    java.lang.String r4 = r4.toString()
                    com.bytedance.msdk.adapter.util.Logger.d(r5, r4)
                Lb8:
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r5 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    r5.notifyAdLoaded(r4)
                Lbf:
                    r4 = 38
                Lc1:
                    switch(r4) {
                        case 38: goto Lc5;
                        case 39: goto Ld6;
                        case 40: goto Ld6;
                        default: goto Lc4;
                    }
                Lc4:
                    goto Lbf
                Lc5:
                    r4 = 39
                    goto Lc1
                Lc8:
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    com.bytedance.msdk.api.AdError r5 = new com.bytedance.msdk.api.AdError
                    java.lang.String r0 = "no error message"
                    r5.<init>(r0)
                    r4.notifyAdFailed(r5)
                Ld6:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.AnonymousClass1.onADLoaded(long):void");
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long j2) {
                this.millisUntilFinished = j2;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
                	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
                */
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0041 A[ORIG_RETURN, RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:6:0x0026 A[PHI: r0 r5 
              PHI: (r0v1 char) = (r0v0 char), (r0v2 char), (r0v2 char), (r0v4 char), (r0v3 char) binds: [B:5:0x0019, B:7:0x0028, B:16:0x003e, B:19:0x0026, B:21:0x0026] A[DONT_GENERATE, DONT_INLINE]
              PHI: (r5v4 char) = (r5v3 char), (r5v5 char), (r5v5 char), (r5v5 char), (r5v5 char) binds: [B:5:0x0019, B:7:0x0028, B:16:0x003e, B:19:0x0026, B:21:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0030 -> B:13:0x0034). Please submit an issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0026 -> B:7:0x0028). Please submit an issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002c -> B:13:0x0034). Please submit an issue!!! */
            @Override // com.qq.e.ads.splash.SplashADListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onNoAD(com.qq.e.comm.util.AdError r5) {
                /*
                    r4 = this;
                    r0 = 55
                    if (r5 == 0) goto L19
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    com.bytedance.msdk.api.AdError r2 = new com.bytedance.msdk.api.AdError
                    int r3 = r5.getErrorCode()
                    java.lang.String r5 = r5.getErrorMsg()
                    r2.<init>(r3, r5)
                    r1.notifyAdFailed(r2)
                    goto L34
                L19:
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter$GDTSplashAd r5 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.this
                    com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r5 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                    com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                    r1.<init>()
                    r5.notifyAdFailed(r1)
                    r5 = 0
                L26:
                    r1 = 72
                L28:
                    switch(r1) {
                        case 72: goto L41;
                        case 73: goto L3c;
                        case 74: goto L2c;
                        default: goto L2b;
                    }
                L2b:
                    goto L26
                L2c:
                    switch(r5) {
                        case 52: goto L26;
                        case 53: goto L30;
                        case 54: goto L34;
                        default: goto L2f;
                    }
                L2f:
                    goto L41
                L30:
                    switch(r0) {
                        case 29: goto L34;
                        case 30: goto L26;
                        case 31: goto L2c;
                        default: goto L33;
                    }
                L33:
                    goto L39
                L34:
                    r1 = 73
                    r5 = 16
                    goto L28
                L39:
                    r0 = 30
                    goto L30
                L3c:
                    r1 = 57
                    if (r5 > r1) goto L41
                    goto L26
                L41:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.AnonymousClass1.onNoAD(com.qq.e.comm.util.AdError):void");
            }

            @Override // com.qq.e.ads.splash.SplashADZoomOutListener
            public void onZoomOut() {
                Log.d("TTMediationSDK", "GDT-开屏广告--onZoomOut");
                if (GDTSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    GDTSplashAd.this.a().onMinWindowStart();
                }
            }

            @Override // com.qq.e.ads.splash.SplashADZoomOutListener
            public void onZoomOutPlayFinish() {
                Log.d("TTMediationSDK", "GDT-开屏广告--onZoomOutPlayFinish");
                if (GDTSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                    GDTSplashAd.this.a().onMinWindowPlayFinish();
                }
            }
        };

        @RequiresApi(api = 16)
        public GDTSplashAd() {
            RelativeLayout relativeLayout = new RelativeLayout(GdtSplashAdapter.this.z);
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            FrameLayout frameLayout = new FrameLayout(GdtSplashAdapter.this.z);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            relativeLayout.addView(frameLayout);
            this.f1811c = frameLayout;
            this.b = relativeLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener a() {
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
                com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener) r0
                return r0
            L19:
                r0 = 93
                r1 = 93
                goto L6
            L1e:
                r1 = 91
                goto L10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.a():com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener");
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
            SplashAD splashAD;
            if (isClientBiddingAd() && (splashAD = this.a) != null) {
                try {
                    splashAD.sendWinNotification((int) getCpm());
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Bitmap getSplashBitMap() {
            SplashAD splashAD = this.a;
            if (splashAD != null) {
                splashAD.getZoomOutBitmap();
                return null;
            }
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            SplashAD splashAD = this.a;
            return (splashAD == null || !splashAD.isValid() || GdtSplashAdapter.this.hasNotifyFail()) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
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
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void loadAd() {
            /*
                r5 = this;
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                android.content.Context r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.E(r0)
                boolean r0 = r0 instanceof android.app.Activity
                if (r0 == 0) goto L6f
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.H(r0)
                if (r0 >= 0) goto L1a
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                r1 = 3000(0xbb8, float:4.204E-42)
            L16:
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.D(r0, r1)
                goto L27
            L1a:
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                int r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.H(r0)
                r1 = 5000(0x1388, float:7.006E-42)
                if (r0 <= r1) goto L27
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r0 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                goto L16
            L27:
                com.qq.e.ads.splash.SplashAD r0 = new com.qq.e.ads.splash.SplashAD
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                android.content.Context r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.E(r1)
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r2 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                java.lang.String r2 = r2.getAdSlotId()
                com.qq.e.ads.splash.SplashADZoomOutListener r3 = r5.f1812d
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                int r4 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.H(r4)
                r0.<init>(r1, r2, r3, r4)
                r5.a = r0
                com.bytedance.msdk.adapter.gdt.GdtSplashAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.this
                boolean r1 = r1.C
                if (r1 == 0) goto L4b
                r0.preLoad()
            L4b:
                com.qq.e.ads.splash.SplashAD r0 = r5.a
                r0.fetchAdOnly()
                r0 = 15
            L52:
                r1 = 71
                r2 = 13
            L56:
                r3 = 12
                switch(r1) {
                    case 69: goto L61;
                    case 70: goto L5c;
                    case 71: goto L65;
                    default: goto L5b;
                }
            L5b:
                goto L52
            L5c:
                if (r0 == r3) goto L52
                if (r0 == r2) goto L6f
                goto L65
            L61:
                switch(r0) {
                    case 10: goto L52;
                    case 11: goto L6a;
                    case 12: goto L65;
                    default: goto L64;
                }
            L64:
                goto L6c
            L65:
                r1 = 70
                r0 = 13
                goto L56
            L6a:
                goto L6a
            L6c:
                r0 = 12
                goto L61
            L6f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtSplashAdapter.GDTSplashAd.loadAd():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.a = null;
            this.f1812d = null;
            this.mTTAdatperCallback = null;
            GdtSplashAdapter.this.z = null;
            GdtSplashAdapter.this.D = null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void showSplashAd(ViewGroup viewGroup) {
            if (this.a == null || viewGroup == null) {
                return;
            }
            viewGroup.removeAllViews();
            RelativeLayout relativeLayout = this.b;
            if (relativeLayout == null || this.f1811c == null) {
                return;
            }
            ViewParent parent = relativeLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.b);
            }
            viewGroup.addView(this.b, -1, -1);
            this.a.showAd(this.f1811c);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void splashMinWindowAnimationFinish() {
            SplashAD splashAD = this.a;
            if (splashAD != null) {
                splashAD.zoomOutAnimationFinish();
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

    @Override // com.bytedance.msdk.adapter.ad.GMSplashBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        this.z = context;
        GMAdSlotSplash gMAdSlotSplash = this.mGMAdSlotSplash;
        if (gMAdSlotSplash == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        boolean splashShakeButton = gMAdSlotSplash.getSplashShakeButton();
        this.E = splashShakeButton;
        if (!splashShakeButton) {
            HashMap hashMap = new HashMap();
            hashMap.put("shakable", "0");
            GlobalSetting.setExtraUserData(hashMap);
        }
        if (map != null) {
            this.A = map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT) != null ? ((Integer) map.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT)).intValue() : this.A;
            String str = (String) map.get("tt_ad_network_config_appid");
            Context context2 = this.z;
            if (context2 instanceof Activity) {
                this.D = new SplashDismissController((Activity) context2);
            }
            this.C = this.mGMAdSlotSplash.isSplashPreLoad();
            GDTSplashAd gDTSplashAd = new GDTSplashAd();
            this.B = gDTSplashAd;
            gDTSplashAd.loadAd();
        }
    }
}
