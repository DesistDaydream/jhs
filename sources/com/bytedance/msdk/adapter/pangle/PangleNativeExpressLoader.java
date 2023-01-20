package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PangleNativeExpressLoader {
    private boolean a;
    private TTAbsAdLoaderAdapter b;

    /* loaded from: classes.dex */
    public class PangleNativeExpressAd extends TTBaseAd {
        public TTNativeExpressAd a;
        private volatile boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public TTNativeExpressAd.ExpressAdInteractionListener f1842c = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdClicked(View view, int i2) {
                if (PangleNativeExpressAd.this.mTTNativeAdListener != null) {
                    PangleNativeExpressAd.this.mTTNativeAdListener.onAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdShow(View view, int i2) {
                if (PangleNativeExpressAd.this.mTTNativeAdListener != null) {
                    PangleNativeExpressAd.this.mTTNativeAdListener.onAdShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onRenderFail(View view, String str, int i2) {
                if (PangleNativeExpressAd.this.mTTNativeAdListener instanceof GMNativeExpressAdListener) {
                    ((GMNativeExpressAdListener) PangleNativeExpressAd.this.mTTNativeAdListener).onRenderFail(view, str, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onRenderSuccess(View view, float f2, float f3) {
                if (PangleNativeExpressAd.this.mTTNativeAdListener instanceof GMNativeExpressAdListener) {
                    ((GMNativeExpressAdListener) PangleNativeExpressAd.this.mTTNativeAdListener).onRenderSuccess(f2, f3);
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public TTNativeExpressAd.ExpressVideoAdListener f1843d = new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.4
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onClickRetry() {
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

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onProgressUpdate(long j2, long j3) {
                if (PangleNativeExpressAd.this.mTTVideoListener != null) {
                    PangleNativeExpressAd.this.mTTVideoListener.onProgressUpdate(j2, j3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onVideoAdComplete() {
                if (PangleNativeExpressAd.this.mTTVideoListener != null) {
                    PangleNativeExpressAd.this.mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onVideoAdContinuePlay() {
                if (PangleNativeExpressAd.this.mTTVideoListener != null) {
                    PangleNativeExpressAd.this.mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onVideoAdPaused() {
                if (PangleNativeExpressAd.this.mTTVideoListener != null) {
                    PangleNativeExpressAd.this.mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onVideoAdStartPlay() {
                if (PangleNativeExpressAd.this.mTTVideoListener != null) {
                    PangleNativeExpressAd.this.mTTVideoListener.onVideoStart();
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:
                continue;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
                continue;
             */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoError(int r5, int r6) {
                /*
                    r4 = this;
                    com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.a(r0)
                    if (r0 == 0) goto L49
                    com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.b(r0)
                    com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "MediaPlayer inter error code:"
                    r2.append(r3)
                    r2.append(r6)
                    java.lang.String r6 = r2.toString()
                    r1.<init>(r5, r6)
                    r0.onVideoError(r1)
                    r5 = 55
                    r6 = 0
                L2a:
                    r0 = 72
                L2c:
                    switch(r0) {
                        case 72: goto L44;
                        case 73: goto L3f;
                        case 74: goto L30;
                        default: goto L2f;
                    }
                L2f:
                    goto L2a
                L30:
                    r0 = 52
                    if (r6 == r0) goto L2a
                    r0 = 53
                    if (r6 == r0) goto L39
                    goto L44
                L39:
                    switch(r5) {
                        case 29: goto L49;
                        case 30: goto L2a;
                        case 31: goto L30;
                        default: goto L3c;
                    }
                L3c:
                    r5 = 30
                    goto L39
                L3f:
                    r0 = 57
                    if (r6 > r0) goto L44
                    goto L49
                L44:
                    r0 = 73
                    r6 = 16
                    goto L2c
                L49:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.AnonymousClass4.onVideoError(int, int):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
            }
        };

        public PangleNativeExpressAd(TTNativeExpressAd tTNativeExpressAd) {
            Map<String, Object> mediaExtraInfo;
            this.a = tTNativeExpressAd;
            setImageMode(tTNativeExpressAd.getImageMode());
            setInteractionType(this.a.getInteractionType());
            setExpressAd(true);
            this.a.setExpressInteractionListener(this.f1842c);
            this.a.setVideoAdListener(this.f1843d);
            if (PangleNativeExpressLoader.this.a && (mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo()) != null) {
                double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                Logger.d("TTMediationSDK_ECMP", "pangle 模板native 返回的 cpm价格：" + value);
                setCpm(value <= 0.0d ? 0.0d : value);
            }
            putExtraMsg(GMAdConstant.EXTRA_ADID, Long.valueOf(getAdId()));
            putExtraMsg(GMAdConstant.EXTRA_CID, Long.valueOf(getCreativeId()));
            Map<String, Object> mediaExtraInfo2 = this.a.getMediaExtraInfo();
            if (mediaExtraInfo2 != null) {
                putExtraMsg("log_extra", mediaExtraInfo2.toString());
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo()) : super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public View getAdView() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                return tTNativeExpressAd.getExpressAdView();
            }
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getCreativeId(tTNativeExpressAd.getMediaExtraInfo()) : super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd == null || (mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo()) == null) {
                return super.getMediaExtraInfo();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            return hashMap;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public String getReqId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getReqId(tTNativeExpressAd.getMediaExtraInfo()) : super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.b = true;
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.1
                @Override // java.lang.Runnable
                public void run() {
                    TTNativeExpressAd tTNativeExpressAd = PangleNativeExpressAd.this.a;
                    if (tTNativeExpressAd != null) {
                        tTNativeExpressAd.destroy();
                    }
                }
            });
            super.onDestroy();
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
        @Override // com.bytedance.msdk.base.TTBaseAd
        @com.bytedance.JProtect
        public void render() {
            /*
                r2 = this;
                com.bytedance.sdk.openadsdk.TTNativeExpressAd r0 = r2.a
                if (r0 == 0) goto L1a
                r0.render()
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
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.render():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, final GMDislikeCallback gMDislikeCallback) {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.PangleNativeExpressAd.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        GMDislikeCallback gMDislikeCallback2 = gMDislikeCallback;
                        if (gMDislikeCallback2 != null) {
                            gMDislikeCallback2.onCancel();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i2, String str, boolean z) {
                        if (gMDislikeCallback != null) {
                            if (PangleNativeExpressLoader.this.b != null) {
                                PangleNativeExpressLoader.this.b.nativeDislikeClick(PangleNativeExpressAd.this, str, null);
                            }
                            gMDislikeCallback.onSelected(i2, str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                        GMDislikeCallback gMDislikeCallback2 = gMDislikeCallback;
                        if (gMDislikeCallback2 != null) {
                            gMDislikeCallback2.onShow();
                        }
                    }
                });
            }
        }
    }

    @JProtect
    public void loadAd(Context context, boolean z, TTAdNative tTAdNative, AdSlot adSlot, final TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        if (tTAdNative == null || tTAbsAdLoaderAdapter == null) {
            return;
        }
        this.b = tTAbsAdLoaderAdapter;
        this.a = z;
        tTAdNative.loadNativeExpressAd(adSlot, new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeExpressLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i2, String str) {
                tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                if (list == null || list.size() == 0) {
                    tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    if (tTNativeExpressAd != null) {
                        arrayList.add(new PangleNativeExpressAd(tTNativeExpressAd));
                    }
                }
                tTAbsAdLoaderAdapter.notifyAdLoaded(arrayList);
            }
        });
    }
}
