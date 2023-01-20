package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.VideoPreloadListener;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GdtNativeLoader {
    private NativeUnifiedADData a;
    private NativeUnifiedAD b;

    /* renamed from: c  reason: collision with root package name */
    private String f1798c;

    /* renamed from: d  reason: collision with root package name */
    private int f1799d;

    /* renamed from: e  reason: collision with root package name */
    private int f1800e;

    /* renamed from: f  reason: collision with root package name */
    private int f1801f;

    /* renamed from: g  reason: collision with root package name */
    private Context f1802g;

    /* renamed from: h  reason: collision with root package name */
    private GMAdSlotGDTOption f1803h;

    /* renamed from: i  reason: collision with root package name */
    private VideoOption f1804i;

    /* renamed from: j  reason: collision with root package name */
    private FrameLayout.LayoutParams f1805j;

    /* renamed from: k  reason: collision with root package name */
    private TTAbsAdLoaderAdapter f1806k;

    /* loaded from: classes.dex */
    public class GdtNativeAd extends TTBaseAd {
        public NativeUnifiedADData a;
        private volatile boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public NativeADMediaListener f1807c = new NativeADMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.4
            /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[FALL_THROUGH] */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC] */
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoClicked() {
                /*
                    r2 = this;
                    com.bytedance.msdk.adapter.gdt.GdtNativeLoader$GdtNativeAd r0 = com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r0 = com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.k(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.gdt.GdtNativeLoader$GdtNativeAd r0 = com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r0 = com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.l(r0)
                    r0.onAdClick()
                L11:
                    r0 = 74
                    r1 = 55
                L15:
                    switch(r0) {
                        case 72: goto L11;
                        case 73: goto L19;
                        case 74: goto L1c;
                        default: goto L18;
                    }
                L18:
                    goto L2d
                L19:
                    switch(r1) {
                        case 94: goto L28;
                        case 95: goto L20;
                        case 96: goto L20;
                        default: goto L1c;
                    }
                L1c:
                    switch(r1) {
                        case 55: goto L21;
                        case 56: goto L21;
                        case 57: goto L20;
                        default: goto L1f;
                    }
                L1f:
                    goto L28
                L20:
                    return
                L21:
                    java.lang.String r0 = "GdtNativeLoader"
                    java.lang.String r1 = "onVideoClicked"
                    android.util.Log.d(r0, r1)
                L28:
                    r0 = 73
                    r1 = 96
                    goto L15
                L2d:
                    r0 = 72
                    goto L15
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.AnonymousClass4.onVideoClicked():void");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoCompleted() {
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoError(AdError adError) {
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoError(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                Log.d("GdtNativeLoader", "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i2) {
                Log.d("GdtNativeLoader", "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                Log.d("GdtNativeLoader", "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoPause() {
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                Log.d("GdtNativeLoader", "onVideoReady");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoResume() {
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoStart() {
                Log.d("GdtNativeLoader", "onVideoStart");
                if (GdtNativeAd.this.mTTVideoListener != null) {
                    GdtNativeAd.this.mTTVideoListener.onVideoStart();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                Log.d("GdtNativeLoader", "onVideoStop");
            }
        };

        public GdtNativeAd(NativeUnifiedADData nativeUnifiedADData) {
            StringBuilder sb;
            this.a = nativeUnifiedADData;
            NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
            if (appMiitInfo != null) {
                setAppName(appMiitInfo.getAppName());
                setAuthorName(appMiitInfo.getAuthorName());
                setPackageSizeBytes(appMiitInfo.getPackageSizeBytes());
                setPermissionsUrl(appMiitInfo.getPermissionsUrl());
                setPrivacyAgreement(appMiitInfo.getPrivacyAgreement());
                setVersionName(appMiitInfo.getVersionName());
            }
            setTitle(nativeUnifiedADData.getTitle());
            setAdDescription(nativeUnifiedADData.getDesc());
            setActionText(nativeUnifiedADData.getCTAText());
            setIconUrl(nativeUnifiedADData.getIconUrl());
            setImageUrl(nativeUnifiedADData.getImgUrl());
            setImageWidth(nativeUnifiedADData.getPictureWidth());
            setImageHeight(nativeUnifiedADData.getPictureHeight());
            setImages(nativeUnifiedADData.getImgList());
            setRating(nativeUnifiedADData.getAppScore());
            setSource(nativeUnifiedADData.getTitle());
            setIsAppDownload(nativeUnifiedADData.isAppAd());
            if (GdtNativeLoader.this.f1806k != null) {
                if (GdtNativeLoader.this.f1806k.isClientBidding()) {
                    setCpm(nativeUnifiedADData.getECPM() != -1 ? nativeUnifiedADData.getECPM() : 0.0d);
                    sb = new StringBuilder();
                    sb.append("GDT_clientBidding 原生Native 返回的 cpm价格：");
                    sb.append(nativeUnifiedADData.getECPM());
                } else if (GdtNativeLoader.this.f1806k.isMultiBidding()) {
                    setLevelTag(nativeUnifiedADData.getECPMLevel());
                    sb = new StringBuilder();
                    sb.append("GDT_多阶底价 原生Native 返回的 价格标签：");
                    sb.append(nativeUnifiedADData.getECPMLevel());
                }
                Logger.d("TTMediationSDK_ECMP", sb.toString());
            }
            if (nativeUnifiedADData.getAdPatternType() == 2) {
                setImageMode(5);
                nativeUnifiedADData.preloadVideo(new VideoPreloadListener(this, GdtNativeLoader.this) { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.1
                    @Override // com.qq.e.ads.nativ.VideoPreloadListener
                    public void onVideoCacheFailed(int i2, String str) {
                    }

                    @Override // com.qq.e.ads.nativ.VideoPreloadListener
                    public void onVideoCached() {
                    }
                });
            } else if (nativeUnifiedADData.getAdPatternType() == 4 || nativeUnifiedADData.getAdPatternType() == 1) {
                setImageMode(3);
            } else if (nativeUnifiedADData.getAdPatternType() == 3) {
                setImageMode(4);
            }
            if (nativeUnifiedADData.isAppAd()) {
                setInteractionType(4);
            } else {
                setInteractionType(3);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00f7 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00f5 A[ADDED_TO_REGION, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00e5 -> B:41:0x00e7). Please submit an issue!!! */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void b(android.content.Context r13, @androidx.annotation.NonNull android.view.ViewGroup r14, java.util.List<android.view.View> r15, java.util.List<android.view.View> r16, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder r17) {
            /*
                Method dump skipped, instructions count: 258
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.b(android.content.Context, android.view.ViewGroup, java.util.List, java.util.List, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder):void");
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
            NativeUnifiedADData nativeUnifiedADData;
            if (isClientBiddingAd() && (nativeUnifiedADData = this.a) != null) {
                try {
                    nativeUnifiedADData.sendWinNotification((int) getCpm());
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void dislikeClick(String str, Map<String, Object> map) {
            super.dislikeClick(str, map);
            if (this.a != null) {
                Log.e("TTMediationSDK", "__gdt_dislikeClick_回传dislike信息to Adn disLikeInfo:" + str);
                this.a.negativeFeedback();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getDownloadStatus() {
            NativeUnifiedADData nativeUnifiedADData = this.a;
            if (nativeUnifiedADData != null) {
                int appStatus = nativeUnifiedADData.getAppStatus();
                if (appStatus == 0) {
                    return 0;
                }
                if (appStatus == 1) {
                    return 6;
                }
                if (appStatus == 2) {
                    return 8;
                }
                if (appStatus == 4) {
                    return 2;
                }
                if (appStatus == 8) {
                    return 5;
                }
                if (appStatus == 16) {
                    return 4;
                }
                if (appStatus == 32) {
                    return 3;
                }
                if (appStatus == 64) {
                    return 7;
                }
            }
            return 1;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            NativeUnifiedADData nativeUnifiedADData = this.a;
            return (nativeUnifiedADData == null || !nativeUnifiedADData.isValid()) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.b = true;
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.GdtNativeAd.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeUnifiedADData nativeUnifiedADData = GdtNativeAd.this.a;
                    if (nativeUnifiedADData != null) {
                        nativeUnifiedADData.destroy();
                    }
                }
            });
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onPause() {
            super.onPause();
            NativeUnifiedADData nativeUnifiedADData = this.a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.pauseVideo();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onResume() {
            super.onResume();
            NativeUnifiedADData nativeUnifiedADData = this.a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.resume();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void pauseAppDownload() {
            NativeUnifiedADData nativeUnifiedADData = this.a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.pauseAppDownload();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, GMViewBinder gMViewBinder) {
            if (list3 != null) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.addAll(list3);
            }
            List<View> list4 = list2;
            super.registerViewForInteraction(viewGroup, list, list4, gMViewBinder);
            if (GdtNativeLoader.this.f1806k.isServerBidding()) {
                NativeUnifiedADData nativeUnifiedADData = this.a;
                nativeUnifiedADData.setBidECPM(nativeUnifiedADData.getECPM());
            }
            b(activity, viewGroup, list, list4, gMViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
            char c2;
            super.registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
            if (GdtNativeLoader.this.f1806k.isServerBidding()) {
                NativeUnifiedADData nativeUnifiedADData = this.a;
                nativeUnifiedADData.setBidECPM(nativeUnifiedADData.getECPM());
            }
            b(GdtNativeLoader.this.f1802g, viewGroup, list, list2, gMViewBinder);
            while (true) {
                while (c2 != 'H') {
                    c2 = c2 != 'J' ? 'H' : 'I';
                }
                return;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void resumeAppDownload() {
            NativeUnifiedADData nativeUnifiedADData = this.a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.resumeAppDownload();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void unregisterView() {
        }
    }

    public GdtNativeLoader b(int i2) {
        this.f1799d = i2;
        return this;
    }

    public GdtNativeLoader c(FrameLayout.LayoutParams layoutParams) {
        this.f1805j = layoutParams;
        return this;
    }

    public GdtNativeLoader d(GMAdSlotGDTOption gMAdSlotGDTOption) {
        this.f1803h = gMAdSlotGDTOption;
        return this;
    }

    public GdtNativeLoader e(String str) {
        this.f1798c = str;
        return this;
    }

    @JProtect
    public void loadAd(Context context, boolean z, final TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        char c2;
        NativeUnifiedAD nativeUnifiedAD;
        DownAPPConfirmPolicy downAPPConfirmPolicy;
        NativeUnifiedAD nativeUnifiedAD2;
        DownAPPConfirmPolicy downAPPConfirmPolicy2;
        this.f1802g = context;
        this.f1806k = tTAbsAdLoaderAdapter;
        NativeADUnifiedListener nativeADUnifiedListener = new NativeADUnifiedListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.1
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                if (list == null || list.size() <= 0) {
                    tTAbsAdLoaderAdapter.notifyAdFailed(new com.bytedance.msdk.api.AdError(com.bytedance.msdk.api.AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    arrayList.add(new GdtNativeAd(nativeUnifiedADData));
                }
                tTAbsAdLoaderAdapter.notifyAdLoaded(arrayList);
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                if (adError != null) {
                    tTAbsAdLoaderAdapter.notifyAdFailed(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                } else {
                    tTAbsAdLoaderAdapter.notifyAdFailed(new com.bytedance.msdk.api.AdError());
                }
            }
        };
        if (TextUtils.isEmpty(tTAbsAdLoaderAdapter.getAdm())) {
            this.b = new NativeUnifiedAD(context, this.f1798c, nativeADUnifiedListener);
        } else {
            this.b = new NativeUnifiedAD(context, this.f1798c, nativeADUnifiedListener, tTAbsAdLoaderAdapter.getAdm());
        }
        GMAdSlotGDTOption gMAdSlotGDTOption = this.f1803h;
        if (gMAdSlotGDTOption != null) {
            this.f1801f = gMAdSlotGDTOption.getGDTMaxVideoDuration();
            this.f1800e = this.f1803h.getGDTMinVideoDuration();
            this.f1804i = GDTAdapterUtils.getGMVideoOption(this.f1803h);
            if (this.f1803h.getDownAPPConfirmPolicy() == 0) {
                nativeUnifiedAD2 = this.b;
                downAPPConfirmPolicy2 = DownAPPConfirmPolicy.Default;
            } else if (this.f1803h.getDownAPPConfirmPolicy() == 1) {
                nativeUnifiedAD2 = this.b;
                downAPPConfirmPolicy2 = DownAPPConfirmPolicy.NOConfirm;
            }
            nativeUnifiedAD2.setDownAPPConfirmPolicy(downAPPConfirmPolicy2);
        }
        int i2 = this.f1800e;
        if (i2 > 0) {
            this.b.setMinVideoDuration(i2);
        }
        int i3 = this.f1801f;
        if (i3 > 0) {
            this.b.setMaxVideoDuration(i3);
        }
        GMAdSlotGDTOption gMAdSlotGDTOption2 = this.f1803h;
        if (gMAdSlotGDTOption2 != null) {
            if (gMAdSlotGDTOption2.getDownAPPConfirmPolicy() == 0) {
                nativeUnifiedAD = this.b;
                downAPPConfirmPolicy = DownAPPConfirmPolicy.Default;
            } else if (this.f1803h.getDownAPPConfirmPolicy() == 1) {
                nativeUnifiedAD = this.b;
                downAPPConfirmPolicy = DownAPPConfirmPolicy.NOConfirm;
            }
            nativeUnifiedAD.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
        NativeUnifiedADData nativeUnifiedADData = this.a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
            this.a = null;
        }
        NativeUnifiedAD nativeUnifiedAD3 = this.b;
        if (nativeUnifiedAD3 != null) {
            nativeUnifiedAD3.loadData(this.f1799d);
            do {
                c2 = ')';
                while (c2 == ')') {
                    c2 = '*';
                }
            } while (c2 != '*');
        }
    }
}
