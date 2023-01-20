package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
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
public class PangleDrawExpressLoader {

    /* loaded from: classes.dex */
    public static class PangleDrawExpressAd extends TTBaseAd {
        private TTNativeExpressAd a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        public TTNativeExpressAd.ExpressAdInteractionListener f1833c = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdClicked(View view, int i2) {
                if (PangleDrawExpressAd.this.mGMDrawAdListener != null) {
                    PangleDrawExpressAd.this.mGMDrawAdListener.onAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdShow(View view, int i2) {
                if (PangleDrawExpressAd.this.mGMDrawAdListener != null) {
                    PangleDrawExpressAd.this.mGMDrawAdListener.onAdShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onRenderFail(View view, String str, int i2) {
                if (PangleDrawExpressAd.this.mGMDrawAdListener instanceof GMDrawExpressAdListener) {
                    ((GMDrawExpressAdListener) PangleDrawExpressAd.this.mGMDrawAdListener).onRenderFail(view, str, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onRenderSuccess(View view, float f2, float f3) {
                if (PangleDrawExpressAd.this.mGMDrawAdListener instanceof GMDrawExpressAdListener) {
                    ((GMDrawExpressAdListener) PangleDrawExpressAd.this.mGMDrawAdListener).onRenderSuccess(f2, f3);
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public TTNativeExpressAd.ExpressVideoAdListener f1834d = new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.3
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
                if (PangleDrawExpressAd.this.mTTVideoListener != null) {
                    PangleDrawExpressAd.this.mTTVideoListener.onProgressUpdate(j2, j3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onVideoAdComplete() {
                if (PangleDrawExpressAd.this.mTTVideoListener != null) {
                    PangleDrawExpressAd.this.mTTVideoListener.onVideoCompleted();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onVideoAdContinuePlay() {
                if (PangleDrawExpressAd.this.mTTVideoListener != null) {
                    PangleDrawExpressAd.this.mTTVideoListener.onVideoResume();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onVideoAdPaused() {
                if (PangleDrawExpressAd.this.mTTVideoListener != null) {
                    PangleDrawExpressAd.this.mTTVideoListener.onVideoPause();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onVideoAdStartPlay() {
                if (PangleDrawExpressAd.this.mTTVideoListener != null) {
                    PangleDrawExpressAd.this.mTTVideoListener.onVideoStart();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            @JProtect
            public void onVideoError(int i2, int i3) {
                if (PangleDrawExpressAd.this.mTTVideoListener != null) {
                    GMVideoListener gMVideoListener = PangleDrawExpressAd.this.mTTVideoListener;
                    gMVideoListener.onVideoError(new AdError(i2, "MediaPlayer inter error code:" + i3));
                    for (char c2 = 'I'; c2 != 'H'; c2 = 'H') {
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
            }
        };

        public PangleDrawExpressAd(TTNativeExpressAd tTNativeExpressAd, boolean z) {
            Map<String, Object> mediaExtraInfo;
            this.a = tTNativeExpressAd;
            this.b = z;
            setImageMode(tTNativeExpressAd.getImageMode());
            setInteractionType(this.a.getInteractionType());
            setExpressAd(true);
            this.a.setExpressInteractionListener(this.f1833c);
            this.a.setVideoAdListener(this.f1834d);
            if (this.b && (mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo()) != null) {
                double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                Logger.d("TTMediationSDK_ECMP", "pangle 模板draw 返回的 cpm价格：" + value);
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
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
                this.a = null;
            }
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
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.1
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
    public void loadAd(Context context, final boolean z, TTAdNative tTAdNative, AdSlot adSlot, final TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter) {
        if (tTAdNative == null || tTAbsAdLoaderAdapter == null) {
            return;
        }
        tTAdNative.loadExpressDrawFeedAd(adSlot, new TTAdNative.NativeExpressAdListener(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.1
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
                        arrayList.add(new PangleDrawExpressAd(tTNativeExpressAd, z));
                    }
                }
                tTAbsAdLoaderAdapter.notifyAdLoaded(arrayList);
            }
        });
    }
}
