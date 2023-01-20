package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMBannerBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.adapter.util.UIUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.format.TTMediaView;
import com.bytedance.msdk.api.format.TTNativeAdView;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PangleBannerAdapter extends GMBannerBaseAdapter {
    private Context z;

    /* loaded from: classes.dex */
    public class PangleNativeAd extends TTBaseAd {
        private TTFeedAd a;
        private volatile boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public TTNativeAd.AdInteractionListener f1820c = new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            @JProtect
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                if (PangleNativeAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    PangleNativeAd.this.f().onAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            @JProtect
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                if (PangleNativeAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    PangleNativeAd.this.f().onAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            @JProtect
            public void onAdShow(TTNativeAd tTNativeAd) {
                if (PangleNativeAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    PangleNativeAd.this.f().onAdShow();
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public TTFeedAd.VideoAdListener f1821d = new TTFeedAd.VideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.4
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long j2, long j3) {
                if (PangleNativeAd.this.mTTVideoListener != null) {
                    PangleNativeAd.this.mTTVideoListener.onProgressUpdate(j2, j3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @JProtect
            public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                if (PangleNativeAd.this.mTTVideoListener != null) {
                    PangleNativeAd.this.mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @JProtect
            public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                if (PangleNativeAd.this.mTTVideoListener != null) {
                    PangleNativeAd.this.mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @JProtect
            public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                if (PangleNativeAd.this.mTTVideoListener != null) {
                    PangleNativeAd.this.mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @JProtect
            public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                if (PangleNativeAd.this.mTTVideoListener != null) {
                    PangleNativeAd.this.mTTVideoListener.onVideoStart();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @JProtect
            public void onVideoError(int i2, int i3) {
                if (PangleNativeAd.this.mTTVideoListener != null) {
                    GMVideoListener gMVideoListener = PangleNativeAd.this.mTTVideoListener;
                    gMVideoListener.onVideoError(new AdError(i2, "Android MediaPlay Error Code :" + i3));
                    for (char c2 = 'I'; c2 != 'H'; c2 = 'H') {
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd tTFeedAd) {
            }
        };

        /* renamed from: e  reason: collision with root package name */
        public TTAppDownloadListener f1822e = new TTAppDownloadListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.5
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeAd.this.mTTAdAppDownloadListener.onDownloadProgress(j2, j3, -1, 1);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeAd.this.mTTAdAppDownloadListener.onDownloadFailed(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeAd.this.mTTAdAppDownloadListener.onDownloadFinished(j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeAd.this.mTTAdAppDownloadListener.onDownloadPaused(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeAd.this.mTTAdAppDownloadListener.onIdle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeAd.this.mTTAdAppDownloadListener.onInstalled(str, str2);
                }
            }
        };

        public PangleNativeAd(TTFeedAd tTFeedAd) {
            Map<String, Object> mediaExtraInfo;
            this.a = tTFeedAd;
            ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
            if (complianceInfo != null) {
                setAppName(complianceInfo.getAppName());
                setAuthorName(complianceInfo.getDeveloperName());
                setPrivacyAgreement(complianceInfo.getPrivacyUrl());
                setVersionName(complianceInfo.getAppVersion());
                HashMap hashMap = new HashMap();
                Map<String, String> permissionsMap = complianceInfo.getPermissionsMap();
                if (permissionsMap != null && permissionsMap.size() > 0) {
                    hashMap.putAll(permissionsMap);
                }
                setPermissionsMap(hashMap);
            }
            setTitle(tTFeedAd.getTitle());
            setAdDescription(tTFeedAd.getDescription());
            setActionText(tTFeedAd.getButtonText());
            setIconUrl(tTFeedAd.getIcon() != null ? tTFeedAd.getIcon().getImageUrl() : null);
            setImageMode(tTFeedAd.getImageMode());
            setInteractionType(tTFeedAd.getInteractionType());
            setSource(tTFeedAd.getSource());
            setRating(tTFeedAd.getAppScore());
            setIsAppDownload(tTFeedAd.getInteractionType() == 4);
            setExpressAd(false);
            this.a.getMediaExtraInfo();
            if (tTFeedAd.getImageMode() == 16 || tTFeedAd.getImageMode() == 3 || tTFeedAd.getImageMode() == 2) {
                if (tTFeedAd.getImageList() != null && !tTFeedAd.getImageList().isEmpty() && tTFeedAd.getImageList().get(0) != null) {
                    TTImage tTImage = tTFeedAd.getImageList().get(0);
                    setImageUrl(tTImage.getImageUrl());
                    setImageHeight(tTImage.getHeight());
                    setImageWidth(tTImage.getWidth());
                }
            } else if (tTFeedAd.getImageMode() == 4 && tTFeedAd.getImageList() != null && tTFeedAd.getImageList().size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (TTImage tTImage2 : tTFeedAd.getImageList()) {
                    arrayList.add(tTImage2.getImageUrl());
                }
                setImages(arrayList);
            }
            if (PangleBannerAdapter.this.isClientBidding() && (mediaExtraInfo = tTFeedAd.getMediaExtraInfo()) != null) {
                double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                Logger.d("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：" + value);
                setCpm(value <= 0.0d ? 0.0d : value);
            }
            this.a.setVideoAdListener(this.f1821d);
            this.a.setDownloadListener(this.f1822e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterBannerAdListener f() {
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTFeedAd tTFeedAd = this.a;
            return tTFeedAd != null ? PangleAdapterUtils.getAdId(tTFeedAd.getMediaExtraInfo()) : super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTFeedAd tTFeedAd = this.a;
            return tTFeedAd != null ? PangleAdapterUtils.getCreativeId(tTFeedAd.getMediaExtraInfo()) : super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd != null) {
                final TTAdDislike dislikeDialog = tTFeedAd.getDislikeDialog(activity);
                return new GMAdDislike() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.1
                    @Override // com.bytedance.msdk.api.v2.GMAdDislike
                    public void setDislikeCallback(final GMDislikeCallback gMDislikeCallback) {
                        if (gMDislikeCallback != null) {
                            dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.1.1
                                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                public void onCancel() {
                                    gMDislikeCallback.onCancel();
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                public void onSelected(int i2, String str, boolean z) {
                                    gMDislikeCallback.onSelected(i2, str);
                                    if (PangleNativeAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                                        PangleNativeAd.this.f().onAdClosed();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                public void onShow() {
                                    gMDislikeCallback.onShow();
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.GMAdDislike
                    public void showDislikeDialog() {
                        TTAdDislike tTAdDislike = dislikeDialog;
                        if (tTAdDislike != null) {
                            tTAdDislike.showDislikeDialog();
                        }
                    }
                };
            }
            return super.getDislikeDialog(activity, map);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd == null || (mediaExtraInfo = tTFeedAd.getMediaExtraInfo()) == null) {
                return super.getMediaExtraInfo();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            return hashMap;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTFeedAd tTFeedAd = this.a;
            return tTFeedAd != null ? PangleAdapterUtils.getReqId(tTFeedAd.getMediaExtraInfo()) : super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getVideoHeight() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd != null) {
                return tTFeedAd.getAdViewHeight();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getVideoWidth() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd != null) {
                return tTFeedAd.getAdViewWidth();
            }
            return 0;
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
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PangleNativeAd.this.a != null) {
                        PangleNativeAd.this.a.setVideoAdListener(null);
                    }
                }
            });
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
            TTFeedAd tTFeedAd;
            View adView;
            View findViewById;
            super.registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
            if (viewGroup instanceof TTNativeAdView) {
                TTFeedAd tTFeedAd2 = this.a;
                if (tTFeedAd2 != null) {
                    tTFeedAd2.registerViewForInteraction(viewGroup, list, list2, this.f1820c);
                }
                TTFeedAd tTFeedAd3 = this.a;
                if (tTFeedAd3 != null && tTFeedAd3.getAdLogo() != null && (findViewById = viewGroup.findViewById(gMViewBinder.logoLayoutId)) != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) findViewById;
                        viewGroup2.removeAllViews();
                        ImageView imageView = new ImageView(PangleBannerAdapter.this.z);
                        imageView.setImageBitmap(this.a.getAdLogo());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = UIUtils.dp2px(PangleBannerAdapter.this.z, 38.0f);
                        layoutParams.height = UIUtils.dp2px(PangleBannerAdapter.this.z, 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        viewGroup2.addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(this.a.getAdLogo());
                    }
                }
                TTMediaView tTMediaView = (TTMediaView) viewGroup.findViewById(gMViewBinder.mediaViewId);
                if (tTMediaView == null || (tTFeedAd = this.a) == null || (adView = tTFeedAd.getAdView()) == null) {
                    return;
                }
                removeSelfFromParent(adView);
                tTMediaView.removeAllViews();
                tTMediaView.addView(adView, -1, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public class PangleNativeExpressAd extends TTBaseAd {
        public TTNativeExpressAd a;
        private volatile boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public TTNativeExpressAd.ExpressAdInteractionListener f1824c = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdClicked(View view, int i2) {
                if (PangleNativeExpressAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    PangleNativeExpressAd.this.d().onAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdShow(View view, int i2) {
                if (PangleNativeExpressAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    PangleNativeExpressAd.this.d().onAdShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onRenderFail(View view, String str, int i2) {
                PangleBannerAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_RENDER_MSG));
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @com.bytedance.JProtect
            public void onRenderSuccess(android.view.View r1, float r2, float r3) {
                /*
                    r0 = this;
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r1 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                    r2.notifyAdLoaded(r1)
                    r1 = 92
                L9:
                    r2 = 14
                Lb:
                    switch(r2) {
                        case 13: goto L14;
                        case 14: goto L16;
                        case 15: goto Lf;
                        default: goto Le;
                    }
                Le:
                    goto L9
                Lf:
                    switch(r1) {
                        case 94: goto L16;
                        case 95: goto L13;
                        case 96: goto L16;
                        default: goto L12;
                    }
                L12:
                    goto L16
                L13:
                    return
                L14:
                    r2 = 72
                L16:
                    r2 = 15
                    r1 = 95
                    goto Lb
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass3.onRenderSuccess(android.view.View, float, float):void");
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public TTNativeExpressAd.ExpressVideoAdListener f1825d = new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.4
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onClickRetry() {
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
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.A(r0)
                    if (r0 == 0) goto L49
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.B(r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass4.onVideoError(int, int):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
            }
        };

        /* renamed from: e  reason: collision with root package name */
        public TTAppDownloadListener f1826e = new TTAppDownloadListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.5
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                if (PangleNativeExpressAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeExpressAd.this.mTTAdAppDownloadListener.onDownloadProgress(j2, j3, -1, 1);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                if (PangleNativeExpressAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeExpressAd.this.mTTAdAppDownloadListener.onDownloadFailed(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                if (PangleNativeExpressAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeExpressAd.this.mTTAdAppDownloadListener.onDownloadFinished(j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                if (PangleNativeExpressAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeExpressAd.this.mTTAdAppDownloadListener.onDownloadPaused(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                if (PangleNativeExpressAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeExpressAd.this.mTTAdAppDownloadListener.onIdle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                if (PangleNativeExpressAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeExpressAd.this.mTTAdAppDownloadListener.onInstalled(str, str2);
                }
            }
        };

        public PangleNativeExpressAd(TTNativeExpressAd tTNativeExpressAd) {
            Map<String, Object> mediaExtraInfo;
            this.a = tTNativeExpressAd;
            setImageMode(tTNativeExpressAd.getImageMode());
            setInteractionType(this.a.getInteractionType());
            setExpressAd(true);
            this.a.setExpressInteractionListener(this.f1824c);
            this.a.setDownloadListener(this.f1826e);
            if (tTNativeExpressAd.getImageMode() == 5) {
                this.a.setVideoAdListener(this.f1825d);
            }
            if (!PangleBannerAdapter.this.isClientBidding() || (mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo()) == null) {
                return;
            }
            double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
            Logger.d("TTMediationSDK_ECMP", "banner混存 pangle 模板native 返回的 cpm价格：" + value);
            setCpm(value <= 0.0d ? 0.0d : value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterBannerAdListener d() {
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
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
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.1
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

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void render() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd == null) {
                return;
            }
            tTNativeExpressAd.render();
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
        public void setDislikeCallback(Activity activity, final GMDislikeCallback gMDislikeCallback) {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        GMDislikeCallback gMDislikeCallback2 = gMDislikeCallback;
                        if (gMDislikeCallback2 != null) {
                            gMDislikeCallback2.onCancel();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i2, String str, boolean z) {
                        GMDislikeCallback gMDislikeCallback2 = gMDislikeCallback;
                        if (gMDislikeCallback2 != null) {
                            gMDislikeCallback2.onSelected(i2, str);
                            if (PangleNativeExpressAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                                PangleNativeExpressAd.this.d().onAdClosed();
                            }
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

    /* loaded from: classes.dex */
    public class TTBannerView extends TTBaseAd {
        public TTNativeExpressAd a;
        public View b;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1829d;

        /* renamed from: c  reason: collision with root package name */
        public final Object f1828c = new Object();

        /* renamed from: e  reason: collision with root package name */
        private volatile boolean f1830e = false;

        /* renamed from: f  reason: collision with root package name */
        public TTNativeExpressAd.ExpressAdInteractionListener f1831f = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.4
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdClicked(View view, int i2) {
                if (TTBannerView.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    TTBannerView.this.a().onAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdShow(View view, int i2) {
                if (TTBannerView.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                    TTBannerView.this.a().onAdShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onRenderFail(View view, String str, int i2) {
                TTBannerView.this.f1829d = false;
                Logger.e("TTMediationSDK_banner", TTLogUtil.getTagThirdLevelById(PangleBannerAdapter.this.getAdapterRit(), PangleBannerAdapter.this.getAdSlotId()) + "TTBannerView onRenderFail -> code=" + i2 + ",msg=" + str);
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onRenderSuccess(View view, float f2, float f3) {
                Logger.e("TTMediationSDK_banner", TTLogUtil.getTagThirdLevelById(PangleBannerAdapter.this.getAdapterRit(), PangleBannerAdapter.this.getAdSlotId()) + "TTBannerView onRenderSuccess 渲染成功！！");
                TTBannerView tTBannerView = TTBannerView.this;
                if (tTBannerView.b instanceof FrameLayout) {
                    PangleBannerAdapter.this.removeFromParent(view);
                    ((FrameLayout) TTBannerView.this.b).addView(view, new ViewGroup.LayoutParams(-1, -1));
                }
                TTBannerView.this.f1829d = true;
                char c2 = 18;
                while (true) {
                    char c3 = '\r';
                    while (true) {
                        switch (c3) {
                            case '\r':
                                c3 = 15;
                                c2 = '\r';
                            case 14:
                                while (true) {
                                    switch (c2) {
                                        case '\n':
                                        case 11:
                                            break;
                                        case '\f':
                                            break;
                                        default:
                                            c2 = '\f';
                                    }
                                }
                                c3 = 15;
                                c2 = '\r';
                                break;
                            case 15:
                                while (true) {
                                    switch (c2) {
                                        case '\r':
                                            return;
                                    }
                                }
                                break;
                        }
                    }
                }
                while (true) {
                }
            }
        };

        public TTBannerView() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterBannerAdListener a() {
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo()) : super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public synchronized View getAdView() {
            while (true) {
                char c2 = '^';
                char c3 = '}';
                while (true) {
                    switch (c2) {
                        case '^':
                            c2 = '_';
                            c3 = '_';
                        case '_':
                            switch (c3) {
                                case '_':
                                    synchronized (this.f1828c) {
                                        if (this.b == null) {
                                            try {
                                                long uptimeMillis = SystemClock.uptimeMillis();
                                                long j2 = 2000 + uptimeMillis;
                                                while (!this.f1829d && uptimeMillis < j2) {
                                                    this.f1828c.wait(j2 - uptimeMillis);
                                                    uptimeMillis = SystemClock.uptimeMillis();
                                                }
                                            } catch (InterruptedException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                    break;
                                case '^':
                                case '`':
                                    c2 = '_';
                                    c3 = '_';
                            }
                            break;
                    }
                    if (c3 != '8') {
                        c2 = '_';
                        c3 = '_';
                    }
                }
            }
            return this.b;
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
        public String getReqId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getReqId(tTNativeExpressAd.getMediaExtraInfo()) : super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f1830e;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x007d A[LOOP:3: B:12:0x0078->B:15:0x007d, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007c A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void loadAd() {
            /*
                r9 = this;
                com.bytedance.sdk.openadsdk.TTAdManager r0 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                android.content.Context r1 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.D(r1)
                com.bytedance.sdk.openadsdk.TTAdNative r0 = r0.createAdNative(r1)
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                com.bytedance.msdk.api.AdSlot r2 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.F(r1)
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotBanner r3 = r1.mGMAdSlotBanner
                java.lang.String r4 = r1.getAdSlotId()
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                java.lang.String r5 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.H(r1)
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                java.lang.String r6 = r1.getClientReqId()
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                java.lang.String r7 = r1.getAdm()
                r8 = 0
                com.bytedance.sdk.openadsdk.AdSlot$Builder r1 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.buildPangleAdSlot(r2, r3, r4, r5, r6, r7, r8)
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotBanner r3 = r2.mGMAdSlotBanner
                int r3 = r3.getBannerSize()
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r4 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotBanner r4 = r4.mGMAdSlotBanner
                int[] r2 = r2.getBannerSize(r3, r4)
                r3 = 0
                r3 = r2[r3]
                float r3 = (float) r3
                r4 = 1
                r2 = r2[r4]
                float r2 = (float) r2
                r1.setExpressViewAcceptedSize(r3, r2)
                com.bytedance.sdk.openadsdk.AdSlot r1 = r1.build()
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$TTBannerView$1 r2 = new com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$TTBannerView$1
                r2.<init>()
                r0.loadBannerExpressAd(r1, r2)
                r0 = 61
                r1 = 12
                r2 = 61
            L60:
                r3 = 8
                r4 = 9
                r5 = 9
            L66:
                r6 = 7
                r7 = 27
                if (r5 == r6) goto L76
                if (r5 == r3) goto L70
                if (r5 == r4) goto L84
                goto L60
            L70:
                switch(r2) {
                    case 37: goto L7c;
                    case 38: goto L78;
                    case 39: goto L84;
                    default: goto L73;
                }
            L73:
                r2 = 39
                goto L70
            L76:
                if (r2 >= r7) goto L80
            L78:
                switch(r1) {
                    case 25: goto L7c;
                    case 26: goto L84;
                    case 27: goto L60;
                    default: goto L7b;
                }
            L7b:
                goto L7d
            L7c:
                return
            L7d:
                r1 = 27
                goto L78
            L80:
                if (r1 <= r0) goto L84
            L82:
            L83:
                goto L82
            L84:
                r2 = 37
                r5 = 8
                goto L66
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.loadAd():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.f1830e = true;
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.3
                @Override // java.lang.Runnable
                public void run() {
                    TTNativeExpressAd tTNativeExpressAd = TTBannerView.this.a;
                    if (tTNativeExpressAd != null) {
                        tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
                        TTBannerView.this.a.destroy();
                    }
                }
            });
            super.onDestroy();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[PHI: r4 
          PHI: (r4v3 char) = (r4v2 char), (r4v4 char) binds: [B:6:0x0015, B:4:0x0004] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0011  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:5:0x0011 -> B:6:0x0015). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0015 -> B:12:0x0021). Please submit an issue!!! */
        @Override // com.bytedance.msdk.base.TTBaseAd
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void setDislikeCallback(android.app.Activity r3, final com.bytedance.msdk.api.v2.GMDislikeCallback r4) {
            /*
                r2 = this;
                com.bytedance.sdk.openadsdk.TTNativeExpressAd r0 = r2.a
                if (r0 == 0) goto L11
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$TTBannerView$2 r1 = new com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$TTBannerView$2
                r1.<init>()
                r0.setDislikeCallback(r3, r1)
                r3 = 92
                r4 = 92
                goto L21
            L11:
                r3 = 15
                r4 = 95
            L15:
                switch(r3) {
                    case 13: goto L1e;
                    case 14: goto L11;
                    case 15: goto L19;
                    default: goto L18;
                }
            L18:
                goto L21
            L19:
                switch(r4) {
                    case 94: goto L11;
                    case 95: goto L1d;
                    case 96: goto L11;
                    default: goto L1c;
                }
            L1c:
                goto L11
            L1d:
                return
            L1e:
                r3 = 72
                goto L11
            L21:
                r3 = 14
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.setDislikeCallback(android.app.Activity, com.bytedance.msdk.api.v2.GMDislikeCallback):void");
        }
    }

    private void E() {
        TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(this.z);
        AdSlot.Builder buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(this.mAdSlot, this.mGMAdSlotBanner, getAdSlotId(), this.mWaterfallAbTestParam, getClientReqId(), getAdm(), false);
        int[] bannerSize = getBannerSize(this.mGMAdSlotBanner.getBannerSize(), this.mGMAdSlotBanner);
        buildPangleAdSlot.setImageAcceptedSize(PangleAdapterUtils.dp2px(this.z, bannerSize[0]), PangleAdapterUtils.dp2px(this.z, bannerSize[1]));
        createAdNative.loadFeedAd(buildPangleAdSlot.build(), new TTAdNative.FeedAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i2, String str) {
                PangleBannerAdapter.this.notifyAdFailed(new AdError(i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    PangleBannerAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                pangleBannerAdapter.notifyAdLoaded(new PangleNativeAd(list.get(0)));
            }
        });
    }

    private void G() {
        TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(this.z);
        AdSlot.Builder buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(this.mAdSlot, this.mGMAdSlotBanner, getAdSlotId(), this.mWaterfallAbTestParam, getClientReqId(), getAdm(), false);
        int[] bannerSize = getBannerSize(this.mGMAdSlotBanner.getBannerSize(), this.mGMAdSlotBanner);
        int dp2px = PangleAdapterUtils.dp2px(this.z, bannerSize[0]);
        int dp2px2 = PangleAdapterUtils.dp2px(this.z, bannerSize[1]);
        buildPangleAdSlot.setImageAcceptedSize(dp2px, dp2px2);
        if (dp2px2 > 0) {
            buildPangleAdSlot.setExpressViewAcceptedSize(dp2px, dp2px2);
        } else {
            buildPangleAdSlot.setExpressViewAcceptedSize(dp2px, 0.0f);
        }
        createAdNative.loadNativeExpressAd(buildPangleAdSlot.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i2, String str) {
                PangleBannerAdapter.this.notifyAdFailed(new AdError(i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                if (list == null || list.size() == 0) {
                    PangleBannerAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    if (tTNativeExpressAd != null) {
                        new PangleNativeExpressAd(tTNativeExpressAd).render();
                        return;
                    }
                }
            }
        });
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0051 -> B:20:0x004f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0056 -> B:21:0x0051). Please submit an issue!!! */
    @Override // com.bytedance.msdk.adapter.ad.GMBannerBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r2, java.util.Map<java.lang.String, java.lang.Object> r3) {
        /*
            r1 = this;
            super.loadAd(r2, r3)
            r1.z = r2
            com.bytedance.msdk.api.v2.slot.GMAdSlotBanner r2 = r1.mGMAdSlotBanner
            if (r2 == 0) goto L4c
            if (r3 == 0) goto L4f
            java.lang.String r2 = "tt_ad_sub_type"
            java.lang.Object r2 = r3.get(r2)
            if (r2 == 0) goto L43
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0 = 4
            if (r2 != r0) goto L43
            java.lang.String r2 = "tt_ad_origin_type"
            java.lang.Object r2 = r3.get(r2)
            if (r2 == 0) goto L4f
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = 1
            if (r2 != r3) goto L31
            r1.G()
            goto L4f
        L31:
            r3 = 2
            if (r2 != r3) goto L38
            r1.E()
            goto L4f
        L38:
            com.bytedance.msdk.api.AdError r2 = new com.bytedance.msdk.api.AdError
            java.lang.String r3 = "渲染类型错误"
            r2.<init>(r3)
            r1.notifyAdFailed(r2)
            goto L4f
        L43:
            com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$TTBannerView r2 = new com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$TTBannerView
            r2.<init>()
            r2.loadAd()
            goto L56
        L4c:
            r1.notifyLoadFailBecauseGMAdSlotIsNull()
        L4f:
            r2 = 91
        L51:
            switch(r2) {
                case 90: goto L4f;
                case 91: goto L55;
                case 92: goto L4f;
                default: goto L54;
            }
        L54:
            goto L56
        L55:
            return
        L56:
            r2 = 90
            goto L51
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
