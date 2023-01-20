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
import com.bytedance.msdk.adapter.util.UIUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.format.TTMediaView;
import com.bytedance.msdk.api.format.TTNativeAdView;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PangleDrawLoader {

    /* loaded from: classes.dex */
    public static class PangleDrawAd extends TTBaseAd {
        private TTFeedAd a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        public TTNativeAd.AdInteractionListener f1835c = new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            @JProtect
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                if (PangleDrawAd.this.mGMDrawAdListener != null) {
                    PangleDrawAd.this.mGMDrawAdListener.onAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            @JProtect
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                if (PangleDrawAd.this.mGMDrawAdListener != null) {
                    PangleDrawAd.this.mGMDrawAdListener.onAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            @JProtect
            public void onAdShow(TTNativeAd tTNativeAd) {
                if (PangleDrawAd.this.mGMDrawAdListener != null) {
                    PangleDrawAd.this.mGMDrawAdListener.onAdShow();
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public TTFeedAd.VideoAdListener f1836d = new TTFeedAd.VideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.4
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long j2, long j3) {
                if (PangleDrawAd.this.mTTVideoListener != null) {
                    PangleDrawAd.this.mTTVideoListener.onProgressUpdate(j2, j3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @JProtect
            public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                if (PangleDrawAd.this.mTTVideoListener != null) {
                    PangleDrawAd.this.mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @JProtect
            public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                if (PangleDrawAd.this.mTTVideoListener != null) {
                    PangleDrawAd.this.mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @JProtect
            public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                if (PangleDrawAd.this.mTTVideoListener != null) {
                    PangleDrawAd.this.mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @JProtect
            public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                if (PangleDrawAd.this.mTTVideoListener != null) {
                    PangleDrawAd.this.mTTVideoListener.onVideoStart();
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:
                continue;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
                continue;
             */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            @com.bytedance.JProtect
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoError(int r5, int r6) {
                /*
                    r4 = this;
                    com.bytedance.msdk.adapter.pangle.PangleDrawLoader$PangleDrawAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.r(r0)
                    if (r0 == 0) goto L49
                    com.bytedance.msdk.adapter.pangle.PangleDrawLoader$PangleDrawAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.s(r0)
                    com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Android MediaPlay Error Code :"
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.AnonymousClass4.onVideoError(int, int):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd tTFeedAd) {
            }
        };

        /* JADX WARN: Code restructure failed: missing block: B:49:0x0136, code lost:
            if (r5 != null) goto L61;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public PangleDrawAd(com.bytedance.sdk.openadsdk.TTFeedAd r4, boolean r5) {
            /*
                Method dump skipped, instructions count: 489
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.<init>(com.bytedance.sdk.openadsdk.TTFeedAd, boolean):void");
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
                return new GMAdDislike(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.2
                    @Override // com.bytedance.msdk.api.v2.GMAdDislike
                    public void setDislikeCallback(final GMDislikeCallback gMDislikeCallback) {
                        if (gMDislikeCallback != null) {
                            dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.2.1
                                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                public void onCancel() {
                                    gMDislikeCallback.onCancel();
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                public void onSelected(int i2, String str, boolean z) {
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
            return super.getDislikeDialog(activity, map);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
            if (isUseCustomVideo()) {
                return new GMNativeCustomVideoReporter() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.1
                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoAutoStart() {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoAutoStart();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoBreak(long j2) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoBreak(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoContinue(long j2) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoContinue(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoError(long j2, int i2, int i3) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoError(j2, i2, i3);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoFinish() {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoFinish();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoPause(long j2) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoPause(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoStart() {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoStart();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoStartError(int i2, int i3) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoStartError(i2, i3);
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
        @JProtect
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
            TTMediaView tTMediaView;
            TTFeedAd tTFeedAd;
            View adView;
            TTFeedAd tTFeedAd2;
            View findViewById;
            super.registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
            if (viewGroup instanceof TTNativeAdView) {
                TTFeedAd tTFeedAd3 = this.a;
                if (tTFeedAd3 != null) {
                    tTFeedAd3.registerViewForInteraction(viewGroup, list, list2, this.f1835c);
                }
                TTFeedAd tTFeedAd4 = this.a;
                if (tTFeedAd4 != null && tTFeedAd4.getAdLogo() != null && (findViewById = viewGroup.findViewById(gMViewBinder.logoLayoutId)) != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) findViewById;
                        viewGroup2.removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(this.a.getAdLogo());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = UIUtils.dp2px(viewGroup.getContext(), 38.0f);
                        layoutParams.height = UIUtils.dp2px(viewGroup.getContext(), 38.0f);
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
    }

    @JProtect
    public void loadAd(Context context, final boolean z, TTAdNative tTAdNative, AdSlot adSlot, final TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        if (tTAdNative == null || tTAbsAdLoaderAdapter == null) {
            return;
        }
        tTAdNative.loadDrawFeedAd(adSlot, new TTAdNative.DrawFeedAdListener(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (TTDrawFeedAd tTDrawFeedAd : list) {
                    arrayList.add(new PangleDrawAd(tTDrawFeedAd, z));
                }
                tTAbsAdLoaderAdapter.notifyAdLoaded(arrayList);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i2, String str) {
                tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(i2, str));
            }
        });
    }
}
