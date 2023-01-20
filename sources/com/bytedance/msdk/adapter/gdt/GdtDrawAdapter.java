package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMDrawBaseAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.VideoPreloadListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GdtDrawAdapter extends GMDrawBaseAdapter {
    public static final String TAG = "GdtDrawAdapter";
    private VideoOption A;

    /* loaded from: classes.dex */
    public static class GMGdtDrawAd extends TTBaseAd {
        private NativeUnifiedADData a;
        private VideoOption b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f1780c = false;

        /* renamed from: d  reason: collision with root package name */
        public NativeADMediaListener f1781d = new NativeADMediaListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.GMGdtDrawAd.3
            /* JADX WARN: Removed duplicated region for block: B:12:0x0028 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[LOOP:0: B:7:0x001d->B:14:0x002e, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0019 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0021 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0024 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:13:0x0029). Please submit an issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0019 -> B:7:0x001d). Please submit an issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0021 -> B:13:0x0029). Please submit an issue!!! */
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoClicked() {
                /*
                    r2 = this;
                    com.bytedance.msdk.adapter.gdt.GdtDrawAdapter$GMGdtDrawAd r0 = com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.GMGdtDrawAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r0 = com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.GMGdtDrawAd.i(r0)
                    if (r0 == 0) goto L12
                    com.bytedance.msdk.adapter.gdt.GdtDrawAdapter$GMGdtDrawAd r0 = com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.GMGdtDrawAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r0 = com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.GMGdtDrawAd.j(r0)
                    r0.onAdClick()
                    goto L29
                L12:
                    java.lang.String r0 = com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.TAG
                    java.lang.String r1 = "onVideoClicked"
                    android.util.Log.d(r0, r1)
                L19:
                    r0 = 74
                    r1 = 55
                L1d:
                    switch(r0) {
                        case 72: goto L19;
                        case 73: goto L21;
                        case 74: goto L24;
                        default: goto L20;
                    }
                L20:
                    goto L2e
                L21:
                    switch(r1) {
                        case 94: goto L29;
                        case 95: goto L12;
                        case 96: goto L12;
                        default: goto L24;
                    }
                L24:
                    switch(r1) {
                        case 55: goto L28;
                        case 56: goto L28;
                        case 57: goto L12;
                        default: goto L27;
                    }
                L27:
                    goto L29
                L28:
                    return
                L29:
                    r0 = 73
                    r1 = 96
                    goto L1d
                L2e:
                    r0 = 72
                    goto L1d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.GMGdtDrawAd.AnonymousClass3.onVideoClicked():void");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoCompleted() {
                if (GMGdtDrawAd.this.mTTVideoListener != null) {
                    GMGdtDrawAd.this.mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoError(AdError adError) {
                if (GMGdtDrawAd.this.mTTVideoListener != null) {
                    GMGdtDrawAd.this.mTTVideoListener.onVideoError(new com.bytedance.msdk.api.AdError(adError.getErrorCode(), adError.getErrorMsg()));
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                Log.d(GdtDrawAdapter.TAG, "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i2) {
                Log.d(GdtDrawAdapter.TAG, "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                Log.d(GdtDrawAdapter.TAG, "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoPause() {
                if (GMGdtDrawAd.this.mTTVideoListener != null) {
                    GMGdtDrawAd.this.mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                Log.d(GdtDrawAdapter.TAG, "onVideoReady");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoResume() {
                if (GMGdtDrawAd.this.mTTVideoListener != null) {
                    GMGdtDrawAd.this.mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoStart() {
                Log.d(GdtDrawAdapter.TAG, "onVideoStart");
                if (GMGdtDrawAd.this.mTTVideoListener != null) {
                    GMGdtDrawAd.this.mTTVideoListener.onVideoStart();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                Log.d(GdtDrawAdapter.TAG, "onVideoStop");
            }
        };

        public GMGdtDrawAd(NativeUnifiedADData nativeUnifiedADData, GdtDrawAdapter gdtDrawAdapter, VideoOption videoOption) {
            StringBuilder sb;
            this.a = nativeUnifiedADData;
            this.b = videoOption;
            NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
            if (appMiitInfo != null) {
                setAppName(appMiitInfo.getAppName());
                setAuthorName(appMiitInfo.getAuthorName());
                setPackageSizeBytes(appMiitInfo.getPackageSizeBytes());
                setPermissionsUrl(appMiitInfo.getPermissionsUrl());
                setPrivacyAgreement(appMiitInfo.getPrivacyAgreement());
                setVersionName(appMiitInfo.getVersionName());
            }
            setTitle(this.a.getTitle());
            setAdDescription(this.a.getDesc());
            setActionText(this.a.getCTAText());
            setIconUrl(this.a.getIconUrl());
            setImageUrl(this.a.getImgUrl());
            setImageWidth(this.a.getPictureWidth());
            setImageHeight(this.a.getPictureHeight());
            setImages(this.a.getImgList());
            setRating(this.a.getAppScore());
            setSource(this.a.getTitle());
            setIsAppDownload(this.a.isAppAd());
            setExpressAd(false);
            if (gdtDrawAdapter != null) {
                if (gdtDrawAdapter.isClientBidding()) {
                    setCpm(this.a.getECPM() != -1 ? this.a.getECPM() : 0.0d);
                    sb = new StringBuilder();
                    sb.append("GDT_clientBidding draw 返回的 cpm价格：");
                    sb.append(this.a.getECPM());
                } else if (gdtDrawAdapter.isMultiBidding()) {
                    setLevelTag(this.a.getECPMLevel());
                    sb = new StringBuilder();
                    sb.append("GDT_多阶底价 draw 返回的 价格标签：");
                    sb.append(this.a.getECPMLevel());
                }
                Logger.d("TTMediationSDK_ECMP", sb.toString());
            }
            if (this.a.getAdPatternType() == 2) {
                setImageMode(5);
                this.a.preloadVideo(new VideoPreloadListener(this) { // from class: com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.GMGdtDrawAd.1
                    @Override // com.qq.e.ads.nativ.VideoPreloadListener
                    public void onVideoCacheFailed(int i2, String str) {
                    }

                    @Override // com.qq.e.ads.nativ.VideoPreloadListener
                    public void onVideoCached() {
                    }
                });
            } else if (this.a.getAdPatternType() == 4 || this.a.getAdPatternType() == 1) {
                setImageMode(3);
            } else if (this.a.getAdPatternType() == 3) {
                setImageMode(4);
            }
            if (this.a.isAppAd()) {
                setInteractionType(4);
            } else {
                setInteractionType(3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00d9 -> B:40:0x00db). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00db -> B:42:0x00df). Please submit an issue!!! */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void b(android.content.Context r13, @androidx.annotation.NonNull android.view.ViewGroup r14, java.util.List<android.view.View> r15, java.util.List<android.view.View> r16, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder r17) {
            /*
                r12 = this;
                r0 = r12
                r7 = r13
                r1 = r14
                r8 = r17
                com.qq.e.ads.nativ.NativeUnifiedADData r2 = r0.a
                if (r2 == 0) goto Ld9
                boolean r2 = r1 instanceof com.bytedance.msdk.api.format.TTNativeAdView
                if (r2 == 0) goto Le2
                r9 = r1
                com.bytedance.msdk.api.format.TTNativeAdView r9 = (com.bytedance.msdk.api.format.TTNativeAdView) r9
                r1 = 0
                android.view.View r2 = r9.getChildAt(r1)
                boolean r2 = r2 instanceof com.qq.e.ads.nativ.widget.NativeAdContainer
                java.lang.String r3 = "tt_gdt_developer_view"
                r10 = -1
                if (r2 == 0) goto L4c
                android.view.View r2 = r9.getChildAt(r1)
                com.qq.e.ads.nativ.widget.NativeAdContainer r2 = (com.qq.e.ads.nativ.widget.NativeAdContainer) r2
            L22:
                int r4 = r2.getChildCount()
                if (r1 >= r4) goto L4a
                android.view.View r4 = r2.getChildAt(r1)
                if (r4 == 0) goto L47
                int r5 = com.bytedance.msdk.adapter.gdt.R.id.tt_mediation_gdt_developer_view_tag_key
                java.lang.Object r5 = r4.getTag(r5)
                if (r5 == 0) goto L43
                boolean r6 = r5 instanceof java.lang.String
                if (r6 == 0) goto L43
                java.lang.String r5 = (java.lang.String) r5
                boolean r5 = r5.equals(r3)
                if (r5 == 0) goto L43
                goto L47
            L43:
                r2.removeView(r4)
                goto L22
            L47:
                int r1 = r1 + 1
                goto L22
            L4a:
                r3 = r2
                goto L7f
            L4c:
                com.qq.e.ads.nativ.widget.NativeAdContainer r2 = new com.qq.e.ads.nativ.widget.NativeAdContainer
                r2.<init>(r13)
                int r4 = com.bytedance.msdk.adapter.gdt.R.id.tt_mediation_gdt_developer_view_root_tag_key
                java.lang.String r5 = "tt_gdt_developer_view_root"
                r2.setTag(r4, r5)
            L58:
                int r4 = r9.getChildCount()
                if (r4 <= 0) goto L78
                android.view.View r4 = r9.getChildAt(r1)
                int r5 = com.bytedance.msdk.adapter.gdt.R.id.tt_mediation_gdt_developer_view_tag_key
                r4.setTag(r5, r3)
                int r5 = r9.indexOfChild(r4)
                r9.removeViewInLayout(r4)
                if (r4 == 0) goto L58
                android.view.ViewGroup$LayoutParams r6 = r4.getLayoutParams()
                r2.addView(r4, r5, r6)
                goto L58
            L78:
                r9.removeAllViews()
                r9.addView(r2, r10, r10)
                goto L4a
            L7f:
                int r1 = r8.mediaViewId
                android.view.View r1 = r9.findViewById(r1)
                r11 = r1
                com.bytedance.msdk.api.format.TTMediaView r11 = (com.bytedance.msdk.api.format.TTMediaView) r11
                com.qq.e.ads.nativ.NativeUnifiedADData r1 = r0.a
                r4 = 0
                r2 = r13
                r5 = r15
                r6 = r16
                r1.bindAdToView(r2, r3, r4, r5, r6)
                if (r11 == 0) goto Laf
                int r1 = r12.getImageMode()
                r2 = 5
                if (r1 != r2) goto Laf
                com.qq.e.ads.nativ.MediaView r1 = new com.qq.e.ads.nativ.MediaView
                r1.<init>(r13)
                r11.removeAllViews()
                r11.addView(r1, r10, r10)
                com.qq.e.ads.nativ.NativeUnifiedADData r2 = r0.a
                com.qq.e.ads.cfg.VideoOption r3 = r0.b
                com.qq.e.ads.nativ.NativeADMediaListener r4 = r0.f1781d
                r2.bindMediaView(r1, r3, r4)
            Laf:
                com.qq.e.ads.nativ.NativeUnifiedADData r1 = r0.a
                java.lang.String r1 = r1.getCTAText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto Lce
                int r1 = r8.callToActionId
                android.view.View r1 = r9.findViewById(r1)
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                r2.add(r1)
                com.qq.e.ads.nativ.NativeUnifiedADData r1 = r0.a
                r1.bindCTAViews(r2)
            Lce:
                com.qq.e.ads.nativ.NativeUnifiedADData r1 = r0.a
                com.bytedance.msdk.adapter.gdt.GdtDrawAdapter$GMGdtDrawAd$2 r2 = new com.bytedance.msdk.adapter.gdt.GdtDrawAdapter$GMGdtDrawAd$2
                r2.<init>()
                r1.setNativeAdEventListener(r2)
                goto Ldf
            Ld9:
                r1 = 12
            Ldb:
                switch(r1) {
                    case 12: goto Le2;
                    case 13: goto Le2;
                    case 14: goto Ldf;
                    default: goto Lde;
                }
            Lde:
                goto Ld9
            Ldf:
                r1 = 13
                goto Ldb
            Le2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.GMGdtDrawAd.b(android.content.Context, android.view.ViewGroup, java.util.List, java.util.List, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder):void");
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
        public boolean hasDestroyed() {
            return this.f1780c;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            NativeUnifiedADData nativeUnifiedADData = this.a;
            return (nativeUnifiedADData == null || !nativeUnifiedADData.isValid()) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.f1780c = true;
            NativeUnifiedADData nativeUnifiedADData = this.a;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.destroy();
            }
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
            b(activity, viewGroup, list, list4, gMViewBinder);
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
        @JProtect
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
            super.registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
            b(viewGroup.getContext(), viewGroup, list, list2, gMViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void unregisterView() {
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

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
        if (r0 != '\'') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
        switch(r4) {
            case 64: goto L33;
            case 65: goto L33;
            case 66: goto L33;
            default: goto L31;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0096 -> B:35:0x0091). Please submit an issue!!! */
    @Override // com.bytedance.msdk.adapter.ad.GMDrawBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r4, java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r3 = this;
            super.loadAd(r4, r5)
            com.bytedance.msdk.api.v2.slot.GMAdSlotDraw r5 = r3.mGMAdSlotDraw
            if (r5 == 0) goto L99
            java.lang.String r5 = r3.getAdSlotId()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L1d
            com.bytedance.msdk.api.AdError r4 = new com.bytedance.msdk.api.AdError
            java.lang.String r5 = "代码位ID不合法"
            r4.<init>(r5)
            r3.notifyAdFailed(r4)
            goto L9c
        L1d:
            com.qq.e.ads.nativ.NativeUnifiedAD r5 = new com.qq.e.ads.nativ.NativeUnifiedAD
            java.lang.String r0 = r3.getAdSlotId()
            com.bytedance.msdk.adapter.gdt.GdtDrawAdapter$1 r1 = new com.bytedance.msdk.adapter.gdt.GdtDrawAdapter$1
            r1.<init>()
            r5.<init>(r4, r0, r1)
            com.bytedance.msdk.api.v2.slot.GMAdSlotDraw r4 = r3.mGMAdSlotDraw
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption r4 = r4.getGMAdSlotGDTOption()
            r0 = 0
            if (r4 == 0) goto L5b
            int r0 = r4.getGDTMaxVideoDuration()
            int r1 = r4.getGDTMinVideoDuration()
            com.qq.e.ads.cfg.VideoOption r2 = com.bytedance.msdk.adapter.gdt.GDTAdapterUtils.getGMVideoOption(r4)
            r3.A = r2
            int r2 = r4.getDownAPPConfirmPolicy()
            if (r2 != 0) goto L4e
            com.qq.e.ads.cfg.DownAPPConfirmPolicy r4 = com.qq.e.ads.cfg.DownAPPConfirmPolicy.Default
        L4a:
            r5.setDownAPPConfirmPolicy(r4)
            goto L58
        L4e:
            int r4 = r4.getDownAPPConfirmPolicy()
            r2 = 1
            if (r4 != r2) goto L58
            com.qq.e.ads.cfg.DownAPPConfirmPolicy r4 = com.qq.e.ads.cfg.DownAPPConfirmPolicy.NOConfirm
            goto L4a
        L58:
            r4 = r0
            r0 = r1
            goto L5c
        L5b:
            r4 = 0
        L5c:
            if (r0 <= 0) goto L61
            r5.setMinVideoDuration(r0)
        L61:
            if (r4 <= 0) goto L66
            r5.setMaxVideoDuration(r4)
        L66:
            com.bytedance.msdk.api.v2.slot.GMAdSlotDraw r4 = r3.mGMAdSlotDraw
            int r4 = r4.getAdCount()
            r5.loadData(r4)
            r4 = 80
        L71:
            r5 = 76
        L73:
            r0 = 22
            if (r5 <= r0) goto L9c
        L77:
            r5 = 70
            r0 = 30
            r1 = 39
        L7d:
            switch(r5) {
                case 68: goto L8e;
                case 69: goto L8c;
                case 70: goto L81;
                default: goto L80;
            }
        L80:
            goto L77
        L81:
            switch(r0) {
                case 29: goto L9c;
                case 30: goto L85;
                case 31: goto L77;
                default: goto L84;
            }
        L84:
            goto L91
        L85:
            r5 = 68
            r4 = 66
            r0 = 39
            goto L7d
        L8c:
            r5 = r0
            goto L73
        L8e:
            if (r0 == r1) goto L91
            goto L94
        L91:
            switch(r4) {
                case 64: goto L9c;
                case 65: goto L9c;
                case 66: goto L9c;
                default: goto L94;
            }
        L94:
            r5 = 84
            if (r4 >= r5) goto L91
            goto L71
        L99:
            r3.notifyLoadFailBecauseGMAdSlotIsNull()
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.gdt.GdtDrawAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
