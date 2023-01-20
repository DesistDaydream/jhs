package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GdtNativeExpressLoader {

    /* renamed from: i  reason: collision with root package name */
    private static Map<NativeExpressADView, ITTAdapterNativeExpressAdListener> f1788i = new HashMap();
    private String a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Context f1789c;

    /* renamed from: d  reason: collision with root package name */
    private GMAdSlotGDTOption f1790d;

    /* renamed from: e  reason: collision with root package name */
    private NativeExpressAD f1791e;

    /* renamed from: f  reason: collision with root package name */
    private TTAbsAdLoaderAdapter f1792f;

    /* renamed from: g  reason: collision with root package name */
    private int f1793g;

    /* renamed from: h  reason: collision with root package name */
    private final NativeExpressAD.NativeExpressADListener f1794h = new NativeExpressAD.NativeExpressADListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.1
        /* JADX WARN: Removed duplicated region for block: B:16:0x002c A[SYNTHETIC] */
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onADClicked(com.qq.e.ads.nativ.NativeExpressADView r2) {
            /*
                r1 = this;
                java.util.Map r0 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.g()
                if (r0 == 0) goto L2c
                java.util.Map r0 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.g()
                java.lang.Object r2 = r0.get(r2)
                com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener r2 = (com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener) r2
                if (r2 == 0) goto L2c
                r2.onAdClick()
            L15:
                r2 = 74
                r0 = 55
            L19:
                switch(r2) {
                    case 72: goto L15;
                    case 73: goto L1d;
                    case 74: goto L20;
                    default: goto L1c;
                }
            L1c:
                goto L29
            L1d:
                switch(r0) {
                    case 94: goto L24;
                    case 95: goto L2c;
                    case 96: goto L2c;
                    default: goto L20;
                }
            L20:
                r2 = 57
                if (r0 == r2) goto L2c
            L24:
                r2 = 73
                r0 = 96
                goto L19
            L29:
                r2 = 72
                goto L19
            L2c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.AnonymousClass1.onADClicked(com.qq.e.ads.nativ.NativeExpressADView):void");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        @JProtect
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            if (GdtNativeExpressLoader.f1788i != null) {
                ITTAdapterNativeExpressAdListener iTTAdapterNativeExpressAdListener = (ITTAdapterNativeExpressAdListener) GdtNativeExpressLoader.f1788i.get(nativeExpressADView);
                if (iTTAdapterNativeExpressAdListener instanceof TTExpressAd) {
                    ((TTExpressAd) iTTAdapterNativeExpressAdListener).closeAd();
                }
                GdtNativeExpressLoader.f1788i.remove(nativeExpressADView);
            }
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x002c A[SYNTHETIC] */
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onADExposure(com.qq.e.ads.nativ.NativeExpressADView r2) {
            /*
                r1 = this;
                java.util.Map r0 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.g()
                if (r0 == 0) goto L2c
                java.util.Map r0 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.g()
                java.lang.Object r2 = r0.get(r2)
                com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener r2 = (com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener) r2
                if (r2 == 0) goto L2c
                r2.onAdShow()
            L15:
                r2 = 74
                r0 = 55
            L19:
                switch(r2) {
                    case 72: goto L15;
                    case 73: goto L1d;
                    case 74: goto L20;
                    default: goto L1c;
                }
            L1c:
                goto L29
            L1d:
                switch(r0) {
                    case 94: goto L24;
                    case 95: goto L2c;
                    case 96: goto L2c;
                    default: goto L20;
                }
            L20:
                r2 = 57
                if (r0 == r2) goto L2c
            L24:
                r2 = 73
                r0 = 96
                goto L19
            L29:
                r2 = 72
                goto L19
            L2c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.AnonymousClass1.onADExposure(com.qq.e.ads.nativ.NativeExpressADView):void");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0067 -> B:21:0x0069). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:24:0x006e). Please submit an issue!!! */
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onADLoaded(java.util.List<com.qq.e.ads.nativ.NativeExpressADView> r6) {
            /*
                r5 = this;
                java.lang.String r0 = "请求成功，但无广告可用"
                if (r6 == 0) goto L59
                int r1 = r6.size()
                if (r1 != 0) goto Lb
                goto L59
            Lb:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Iterator r6 = r6.iterator()
            L14:
                boolean r2 = r6.hasNext()
                if (r2 == 0) goto L3a
                java.lang.Object r2 = r6.next()
                com.qq.e.ads.nativ.NativeExpressADView r2 = (com.qq.e.ads.nativ.NativeExpressADView) r2
                if (r2 == 0) goto L14
                com.qq.e.comm.pi.AdData r3 = r2.getBoundData()
                if (r3 == 0) goto L14
                com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader$TTExpressAd r3 = new com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader$TTExpressAd
                com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader r4 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.this
                r3.<init>(r2)
                java.util.Map r4 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.g()
                r4.put(r2, r3)
                r1.add(r3)
                goto L14
            L3a:
                int r6 = r1.size()
                if (r6 <= 0) goto L4a
                com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader r6 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.this
                com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r6 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.a(r6)
                r6.notifyAdLoaded(r1)
                goto L6e
            L4a:
                com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader r6 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.this
                com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r6 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.a(r6)
                com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                r1.<init>(r0)
                r6.notifyAdFailed(r1)
                goto L6d
            L59:
                com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader r6 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.this
                com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r6 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.a(r6)
                com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                r1.<init>(r0)
                r6.notifyAdFailed(r1)
            L67:
                r6 = 38
            L69:
                switch(r6) {
                    case 37: goto L6e;
                    case 38: goto L6d;
                    case 39: goto L6d;
                    default: goto L6c;
                }
            L6c:
                goto L67
            L6d:
                return
            L6e:
                r6 = 39
                goto L69
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.AnonymousClass1.onADLoaded(java.util.List):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0045 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x002a A[PHI: r0 r5 
          PHI: (r0v1 char) = (r0v0 char), (r0v2 char), (r0v2 char), (r0v4 char), (r0v3 char) binds: [B:5:0x001b, B:7:0x002c, B:16:0x0042, B:22:0x002a, B:19:0x002a] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r5v4 char) = (r5v3 char), (r5v5 char), (r5v5 char), (r5v5 char), (r5v5 char) binds: [B:5:0x001b, B:7:0x002c, B:16:0x0042, B:22:0x002a, B:19:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0034 -> B:13:0x0038). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x002a -> B:7:0x002c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0030 -> B:13:0x0038). Please submit an issue!!! */
        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onNoAD(com.qq.e.comm.util.AdError r5) {
            /*
                r4 = this;
                r0 = 55
                if (r5 == 0) goto L1b
                com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader r1 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.this
                com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r1 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.a(r1)
                com.bytedance.msdk.api.AdError r2 = new com.bytedance.msdk.api.AdError
                int r3 = r5.getErrorCode()
                java.lang.String r5 = r5.getErrorMsg()
                r2.<init>(r3, r5)
                r1.notifyAdFailed(r2)
                goto L38
            L1b:
                com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader r5 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.this
                com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r5 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.a(r5)
                com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                r1.<init>()
                r5.notifyAdFailed(r1)
                r5 = 0
            L2a:
                r1 = 72
            L2c:
                switch(r1) {
                    case 72: goto L45;
                    case 73: goto L40;
                    case 74: goto L30;
                    default: goto L2f;
                }
            L2f:
                goto L2a
            L30:
                switch(r5) {
                    case 52: goto L2a;
                    case 53: goto L34;
                    case 54: goto L38;
                    default: goto L33;
                }
            L33:
                goto L45
            L34:
                switch(r0) {
                    case 29: goto L38;
                    case 30: goto L2a;
                    case 31: goto L30;
                    default: goto L37;
                }
            L37:
                goto L3d
            L38:
                r1 = 73
                r5 = 16
                goto L2c
            L3d:
                r0 = 30
                goto L34
            L40:
                r1 = 57
                if (r5 > r1) goto L45
                goto L2a
            L45:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.AnonymousClass1.onNoAD(com.qq.e.comm.util.AdError):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x001a, code lost:
            continue;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onRenderFail(com.qq.e.ads.nativ.NativeExpressADView r4) {
            /*
                r3 = this;
                java.util.Map r0 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.g()
                if (r0 == 0) goto L31
                java.util.Map r0 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.g()
                java.lang.Object r0 = r0.get(r4)
                com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener) r0
                if (r0 == 0) goto L31
                r1 = -99999(0xfffffffffffe7961, float:NaN)
                java.lang.String r2 = "渲染失败"
                r0.onRenderFail(r4, r2, r1)
            L1a:
                r4 = 73
                r0 = 96
            L1e:
                switch(r4) {
                    case 72: goto L29;
                    case 73: goto L22;
                    case 74: goto L25;
                    default: goto L21;
                }
            L21:
                goto L2e
            L22:
                switch(r0) {
                    case 94: goto L1a;
                    case 95: goto L29;
                    case 96: goto L29;
                    default: goto L25;
                }
            L25:
                switch(r0) {
                    case 55: goto L31;
                    case 56: goto L29;
                    case 57: goto L29;
                    default: goto L28;
                }
            L28:
                goto L1a
            L29:
                r4 = 74
                r0 = 55
                goto L1e
            L2e:
                r4 = 72
                goto L1e
            L31:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.AnonymousClass1.onRenderFail(com.qq.e.ads.nativ.NativeExpressADView):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0019, code lost:
            continue;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onRenderSuccess(com.qq.e.ads.nativ.NativeExpressADView r3) {
            /*
                r2 = this;
                java.util.Map r0 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.g()
                if (r0 == 0) goto L30
                java.util.Map r0 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.g()
                java.lang.Object r3 = r0.get(r3)
                com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener r3 = (com.bytedance.msdk.adapter.listener.ITTAdapterNativeExpressAdListener) r3
                if (r3 == 0) goto L30
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                r1 = -1073741824(0xffffffffc0000000, float:-2.0)
                r3.onRenderSuccess(r0, r1)
            L19:
                r3 = 73
                r0 = 96
            L1d:
                switch(r3) {
                    case 72: goto L28;
                    case 73: goto L21;
                    case 74: goto L24;
                    default: goto L20;
                }
            L20:
                goto L2d
            L21:
                switch(r0) {
                    case 94: goto L19;
                    case 95: goto L28;
                    case 96: goto L28;
                    default: goto L24;
                }
            L24:
                switch(r0) {
                    case 55: goto L30;
                    case 56: goto L28;
                    case 57: goto L28;
                    default: goto L27;
                }
            L27:
                goto L19
            L28:
                r3 = 74
                r0 = 55
                goto L1d
            L2d:
                r3 = 72
                goto L1d
            L30:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.AnonymousClass1.onRenderSuccess(com.qq.e.ads.nativ.NativeExpressADView):void");
        }
    };

    /* loaded from: classes.dex */
    public class TTExpressAd extends TTBaseAd implements ITTAdapterNativeExpressAdListener {
        public NativeExpressADView a;
        public GMDislikeCallback b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f1795c = false;

        /* renamed from: d  reason: collision with root package name */
        private final NativeExpressMediaListener f1796d;

        public TTExpressAd(NativeExpressADView nativeExpressADView) {
            StringBuilder sb;
            NativeExpressMediaListener nativeExpressMediaListener = new NativeExpressMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.2
                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoCached(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtNativeExpressLoader", "onVideoCached");
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
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
                /* JADX WARN: Removed duplicated region for block: B:20:0x004a A[ORIG_RETURN, RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:9:0x0030 A[PHI: r0 r4 
                  PHI: (r0v1 char) = (r0v0 char), (r0v2 char), (r0v2 char), (r0v4 char), (r0v3 char) binds: [B:8:0x002f, B:10:0x0032, B:18:0x0047, B:24:0x0030, B:21:0x0030] A[DONT_GENERATE, DONT_INLINE]
                  PHI: (r4v4 char) = (r4v3 char), (r4v5 char), (r4v5 char), (r4v5 char), (r4v5 char) binds: [B:8:0x002f, B:10:0x0032, B:18:0x0047, B:24:0x0030, B:21:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0036 -> B:14:0x003a). Please submit an issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0030 -> B:10:0x0032). Please submit an issue!!! */
                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                @com.bytedance.JProtect
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onVideoError(com.qq.e.ads.nativ.NativeExpressADView r4, com.qq.e.comm.util.AdError r5) {
                    /*
                        r3 = this;
                        com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader$TTExpressAd r4 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.this
                        com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r4 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.j(r4)
                        r0 = 55
                        if (r4 == 0) goto L2f
                        com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader$TTExpressAd r4 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.this
                        if (r5 == 0) goto L23
                        com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r4 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.a(r4)
                        com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                        int r2 = r5.getErrorCode()
                        java.lang.String r5 = r5.getErrorMsg()
                        r1.<init>(r2, r5)
                        r4.onVideoError(r1)
                        goto L3a
                    L23:
                        com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r4 = com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.b(r4)
                        com.bytedance.msdk.api.AdError r5 = new com.bytedance.msdk.api.AdError
                        r5.<init>()
                        r4.onVideoError(r5)
                    L2f:
                        r4 = 0
                    L30:
                        r5 = 72
                    L32:
                        switch(r5) {
                            case 72: goto L4a;
                            case 73: goto L45;
                            case 74: goto L36;
                            default: goto L35;
                        }
                    L35:
                        goto L30
                    L36:
                        switch(r4) {
                            case 52: goto L30;
                            case 53: goto L3f;
                            case 54: goto L3a;
                            default: goto L39;
                        }
                    L39:
                        goto L4a
                    L3a:
                        r5 = 73
                        r4 = 16
                        goto L32
                    L3f:
                        switch(r0) {
                            case 29: goto L30;
                            case 30: goto L30;
                            case 31: goto L36;
                            default: goto L42;
                        }
                    L42:
                        r0 = 30
                        goto L3f
                    L45:
                        r5 = 57
                        if (r4 > r5) goto L4a
                        goto L30
                    L4a:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.AnonymousClass2.onVideoError(com.qq.e.ads.nativ.NativeExpressADView, com.qq.e.comm.util.AdError):void");
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoInit(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtNativeExpressLoader", "onVideoInit: " + GdtNativeExpressLoader.this.f((AdData.VideoPlayer) nativeExpressADView2.getBoundData().getProperty(AdData.VideoPlayer.class)));
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
                    Log.i("GdtNativeExpressLoader", "onVideoLoading");
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
            this.f1796d = nativeExpressMediaListener;
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
            if (GdtNativeExpressLoader.this.f1792f != null) {
                if (GdtNativeExpressLoader.this.f1792f.isClientBidding()) {
                    setCpm(boundData.getECPM() != -1 ? boundData.getECPM() : 0.0d);
                    Logger.d("");
                    sb = new StringBuilder();
                    sb.append("GDT_clientBidding 模板Native 返回的 cpm价格：");
                    sb.append(boundData.getECPM());
                } else if (!GdtNativeExpressLoader.this.f1792f.isMultiBidding()) {
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
            if (this.b != null) {
                if (GdtNativeExpressLoader.this.f1792f != null) {
                    GdtNativeExpressLoader.this.f1792f.nativeDislikeClick(this, "gdt信息流模板dislike接口无关闭原因", null);
                }
                this.b.onSelected(-1, "gdt信息流模板dislike接口无关闭原因");
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public View getAdView() {
            if (GdtNativeExpressLoader.this.f1792f.isServerBidding()) {
                NativeExpressADView nativeExpressADView = this.a;
                nativeExpressADView.setBidECPM(nativeExpressADView.getECPM());
            }
            return this.a;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f1795c;
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
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        @com.bytedance.JProtect
        public void onAdClick() {
            /*
                r2 = this;
                com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r0 = r2.mTTNativeAdListener
                if (r0 == 0) goto L1a
                r0.onAdClick()
                r0 = 92
            L9:
                r1 = 14
            Lb:
                switch(r1) {
                    case 13: goto L13;
                    case 14: goto L15;
                    case 15: goto Lf;
                    default: goto Le;
                }
            Le:
                goto L9
            Lf:
                switch(r0) {
                    case 94: goto L15;
                    case 95: goto L1a;
                    case 96: goto L15;
                    default: goto L12;
                }
            L12:
                goto L15
            L13:
                r1 = 72
            L15:
                r1 = 15
                r0 = 95
                goto Lb
            L1a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.onAdClick():void");
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
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        @com.bytedance.JProtect
        public void onAdShow() {
            /*
                r2 = this;
                com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r0 = r2.mTTNativeAdListener
                if (r0 == 0) goto L1a
                r0.onAdShow()
                r0 = 92
            L9:
                r1 = 14
            Lb:
                switch(r1) {
                    case 13: goto L13;
                    case 14: goto L15;
                    case 15: goto Lf;
                    default: goto Le;
                }
            Le:
                goto L9
            Lf:
                switch(r0) {
                    case 94: goto L15;
                    case 95: goto L1a;
                    case 96: goto L15;
                    default: goto L12;
                }
            L12:
                goto L15
            L13:
                r1 = 72
            L15:
                r1 = 15
                r0 = 95
                goto Lb
            L1a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.onAdShow():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.f1795c = true;
            if (GdtNativeExpressLoader.f1788i != null) {
                GdtNativeExpressLoader.f1788i.remove(this.a);
            }
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeExpressLoader.TTExpressAd.1
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressADView nativeExpressADView = TTExpressAd.this.a;
                    if (nativeExpressADView != null) {
                        nativeExpressADView.destroy();
                    }
                }
            });
            this.b = null;
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
        @JProtect
        public void onRenderFail(View view, String str, int i2) {
            GMNativeAdListener gMNativeAdListener = this.mTTNativeAdListener;
            if (gMNativeAdListener instanceof GMNativeExpressAdListener) {
                ((GMNativeExpressAdListener) gMNativeAdListener).onRenderFail(view, str, i2);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
        @JProtect
        public void onRenderSuccess(float f2, float f3) {
            GMNativeAdListener gMNativeAdListener = this.mTTNativeAdListener;
            if (gMNativeAdListener instanceof GMNativeExpressAdListener) {
                ((GMNativeExpressAdListener) gMNativeAdListener).onRenderSuccess(f2, f3);
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public String f(AdData.VideoPlayer videoPlayer) {
        if (videoPlayer != null) {
            return "{state:" + videoPlayer.getVideoState() + Constants.ACCEPT_TIME_SEPARATOR_SP + "duration:" + videoPlayer.getDuration() + Constants.ACCEPT_TIME_SEPARATOR_SP + "position:" + videoPlayer.getCurrentPosition() + "}";
        }
        return null;
    }

    private ADSize i() {
        ADSize aDSize = new ADSize(-1, -2);
        int i2 = this.f1793g;
        return i2 > 0 ? new ADSize(i2, -2) : aDSize;
    }

    public GdtNativeExpressLoader b(int i2) {
        this.b = i2;
        return this;
    }

    public GdtNativeExpressLoader c(GMAdSlotGDTOption gMAdSlotGDTOption) {
        this.f1790d = gMAdSlotGDTOption;
        return this;
    }

    public GdtNativeExpressLoader d(String str) {
        this.a = str;
        return this;
    }

    public GdtNativeExpressLoader h(int i2) {
        return this;
    }

    public GdtNativeExpressLoader j(int i2) {
        this.f1793g = i2;
        return this;
    }

    @JProtect
    public void loadAd(Context context, boolean z, TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        NativeExpressAD nativeExpressAD;
        DownAPPConfirmPolicy downAPPConfirmPolicy;
        if (context == null || tTAbsAdLoaderAdapter == null) {
            return;
        }
        this.f1789c = context;
        this.f1792f = tTAbsAdLoaderAdapter;
        this.f1791e = !TextUtils.isEmpty(tTAbsAdLoaderAdapter.getAdm()) ? new NativeExpressAD(this.f1789c, i(), this.a, this.f1794h, this.f1792f.getAdm()) : new NativeExpressAD(this.f1789c, i(), this.a, this.f1794h);
        GMAdSlotGDTOption gMAdSlotGDTOption = this.f1790d;
        if (gMAdSlotGDTOption != null) {
            this.f1791e.setMinVideoDuration(gMAdSlotGDTOption.getGDTMinVideoDuration());
            this.f1791e.setMaxVideoDuration(this.f1790d.getGDTMaxVideoDuration());
            this.f1791e.setVideoOption(GDTAdapterUtils.getGMVideoOption(this.f1790d));
            if (this.f1790d.getDownAPPConfirmPolicy() == 0) {
                nativeExpressAD = this.f1791e;
                downAPPConfirmPolicy = DownAPPConfirmPolicy.Default;
            } else if (this.f1790d.getDownAPPConfirmPolicy() == 1) {
                nativeExpressAD = this.f1791e;
                downAPPConfirmPolicy = DownAPPConfirmPolicy.NOConfirm;
            }
            nativeExpressAD.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
        this.f1791e.loadAD(this.b);
    }
}
