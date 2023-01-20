package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.UIUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.format.TTMediaView;
import com.bytedance.msdk.api.format.TTNativeAdView;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PangleNativeLoader {
    private boolean a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private TTAbsAdLoaderAdapter f1845c;

    /* renamed from: d  reason: collision with root package name */
    private int f1846d;

    /* loaded from: classes.dex */
    public class PangleNativeAd extends TTBaseAd {
        private TTFeedAd a;
        public TTNativeAd.AdInteractionListener b = new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.4
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            @JProtect
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                if (PangleNativeAd.this.mTTNativeAdListener != null) {
                    PangleNativeAd.this.mTTNativeAdListener.onAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            @JProtect
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                if (PangleNativeAd.this.mTTNativeAdListener != null) {
                    PangleNativeAd.this.mTTNativeAdListener.onAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            @JProtect
            public void onAdShow(TTNativeAd tTNativeAd) {
                if (PangleNativeAd.this.mTTNativeAdListener != null) {
                    PangleNativeAd.this.mTTNativeAdListener.onAdShow();
                }
            }
        };

        /* renamed from: c  reason: collision with root package name */
        public TTFeedAd.VideoAdListener f1847c = new TTFeedAd.VideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.5
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

        /* renamed from: d  reason: collision with root package name */
        public TTAppDownloadListener f1848d = new TTAppDownloadListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.6
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f1846d = 2;
                    PangleNativeAd.this.mTTAdAppDownloadListener.onDownloadProgress(j2, j3, -1, 1);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f1846d = 4;
                    PangleNativeAd.this.mTTAdAppDownloadListener.onDownloadFailed(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f1846d = 5;
                    PangleNativeAd.this.mTTAdAppDownloadListener.onDownloadFinished(j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f1846d = 3;
                    PangleNativeAd.this.mTTAdAppDownloadListener.onDownloadPaused(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f1846d = 0;
                    PangleNativeAd.this.mTTAdAppDownloadListener.onIdle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                if (PangleNativeAd.this.mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f1846d = 6;
                    PangleNativeAd.this.mTTAdAppDownloadListener.onInstalled(str, str2);
                }
            }
        };

        /* JADX WARN: Code restructure failed: missing block: B:52:0x0148, code lost:
            if (r0 != null) goto L64;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public PangleNativeAd(com.bytedance.sdk.openadsdk.TTFeedAd r6) {
            /*
                Method dump skipped, instructions count: 501
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.<init>(com.bytedance.msdk.adapter.pangle.PangleNativeLoader, com.bytedance.sdk.openadsdk.TTFeedAd):void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void cancelDownload() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd == null || tTFeedAd.getDownloadStatusController() == null) {
                return;
            }
            this.a.getDownloadStatusController().cancelDownload();
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
            if (this.a != null) {
                final TTDislikeDialogAbstract tTDislikeDialogAbstract = null;
                if (map != null && (map.get(GMAdConstant.PANGLE_CUSTOM_DIALOG) instanceof TTDislikeDialogAbstract)) {
                    tTDislikeDialogAbstract = (TTDislikeDialogAbstract) map.get(GMAdConstant.PANGLE_CUSTOM_DIALOG);
                }
                if (tTDislikeDialogAbstract == null) {
                    final TTAdDislike dislikeDialog = this.a.getDislikeDialog(activity);
                    return new GMAdDislike() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.3
                        @Override // com.bytedance.msdk.api.v2.GMAdDislike
                        public void setDislikeCallback(final GMDislikeCallback gMDislikeCallback) {
                            if (gMDislikeCallback != null) {
                                dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.3.1
                                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                    public void onCancel() {
                                        gMDislikeCallback.onCancel();
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                    public void onSelected(int i2, String str, boolean z) {
                                        try {
                                            if (PangleNativeLoader.this.f1845c != null) {
                                                PangleNativeLoader.this.f1845c.nativeDislikeClick(PangleNativeAd.this, str, null);
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                        gMDislikeCallback.onSelected(i2, str);
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

                        @Override // com.bytedance.msdk.api.v2.GMAdDislike
                        public void showDislikeDialog() {
                            TTAdDislike tTAdDislike = dislikeDialog;
                            if (tTAdDislike != null) {
                                tTAdDislike.showDislikeDialog();
                            }
                        }
                    };
                }
                Logger.e("TTMediationSDK", "---pangle_getDislikeDialog_custom_dialog---");
                this.a.setDislikeDialog(tTDislikeDialogAbstract);
                return new GMAdDislike(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.2
                    @Override // com.bytedance.msdk.api.v2.GMAdDislike
                    public void setDislikeCallback(GMDislikeCallback gMDislikeCallback) {
                    }

                    @Override // com.bytedance.msdk.api.v2.GMAdDislike
                    public void showDislikeDialog() {
                        TTDislikeDialogAbstract tTDislikeDialogAbstract2 = tTDislikeDialogAbstract;
                        if (tTDislikeDialogAbstract2 != null) {
                            tTDislikeDialogAbstract2.show();
                        }
                    }
                };
            }
            return super.getDislikeDialog(activity, map);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getDownloadStatus() {
            return PangleNativeLoader.this.f1846d;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
            if (isUseCustomVideo()) {
                return new GMNativeCustomVideoReporter() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.1
                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoAutoStart() {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoAutoStart();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoBreak(long j2) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoBreak(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoContinue(long j2) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoContinue(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoError(long j2, int i2, int i3) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoError(j2, i2, i3);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoFinish() {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoFinish();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoPause(long j2) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoPause(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoStart() {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoStart();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoStartError(int i2, int i3) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoStartError(i2, i3);
                    }
                };
            }
            return null;
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
        public String getVideoUrl() {
            TTFeedAd tTFeedAd;
            if (!isUseCustomVideo() || (tTFeedAd = this.a) == null || tTFeedAd.getCustomVideo() == null) {
                return null;
            }
            return this.a.getCustomVideo().getVideoUrl();
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
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd != null) {
                tTFeedAd.setVideoAdListener(null);
                this.a = null;
            }
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void pauseAppDownload() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd == null || tTFeedAd.getDownloadStatusController() == null || PangleNativeLoader.this.f1846d != 2) {
                return;
            }
            this.a.getDownloadStatusController().changeDownloadStatus();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, GMViewBinder gMViewBinder) {
            TTMediaView tTMediaView;
            TTFeedAd tTFeedAd;
            View adView;
            TTFeedAd tTFeedAd2;
            View findViewById;
            super.registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
            if (viewGroup instanceof TTNativeAdView) {
                TTFeedAd tTFeedAd3 = this.a;
                if (tTFeedAd3 != null) {
                    tTFeedAd3.setDownloadListener(this.f1848d);
                    this.a.registerViewForInteraction(viewGroup, null, list, list2, list3, null, this.b);
                }
                TTFeedAd tTFeedAd4 = this.a;
                if (tTFeedAd4 != null && tTFeedAd4.getAdLogo() != null && (findViewById = viewGroup.findViewById(gMViewBinder.logoLayoutId)) != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) findViewById;
                        viewGroup2.removeAllViews();
                        ImageView imageView = new ImageView(PangleNativeLoader.this.b);
                        imageView.setImageBitmap(this.a.getAdLogo());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = UIUtils.dp2px(PangleNativeLoader.this.b, 38.0f);
                        layoutParams.height = UIUtils.dp2px(PangleNativeLoader.this.b, 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        viewGroup2.addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(this.a.getAdLogo());
                    }
                }
                if ((isUseCustomVideo() && (tTFeedAd2 = this.a) != null && tTFeedAd2.getCustomVideo() != null && !TextUtils.isEmpty(this.a.getCustomVideo().getVideoUrl())) || (tTMediaView = (TTMediaView) viewGroup.findViewById(gMViewBinder.mediaViewId)) == null || (tTFeedAd = this.a) == null || (adView = tTFeedAd.getAdView()) == null) {
                    return;
                }
                removeSelfFromParent(adView);
                tTMediaView.removeAllViews();
                tTMediaView.addView(adView, -1, -1);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
            registerViewForInteraction(null, viewGroup, list, list2, null, gMViewBinder);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void resumeAppDownload() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd == null || tTFeedAd.getDownloadStatusController() == null || PangleNativeLoader.this.f1846d != 3) {
                return;
            }
            this.a.getDownloadStatusController().changeDownloadStatus();
        }
    }

    @JProtect
    public void loadAd(Context context, boolean z, TTAdNative tTAdNative, AdSlot adSlot, final TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        if (tTAdNative == null || tTAbsAdLoaderAdapter == null) {
            return;
        }
        this.f1845c = tTAbsAdLoaderAdapter;
        this.b = context;
        this.a = z;
        tTAdNative.loadFeedAd(adSlot, new TTAdNative.FeedAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i2, String str) {
                tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (TTFeedAd tTFeedAd : list) {
                    arrayList.add(new PangleNativeAd(tTFeedAd));
                }
                tTAbsAdLoaderAdapter.notifyAdLoaded(arrayList);
            }
        });
    }
}
