package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMFullVideoBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import e.l.r.g0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PangleFullVideoAdapter extends GMFullVideoBaseAdapter {
    public static final String TAG = "PangleFullVideoAdapter";
    private Context z;

    /* loaded from: classes.dex */
    public class PangleFullVideoAd extends TTBaseAd {
        private TTFullScreenVideoAd a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1837c;

        /* renamed from: d  reason: collision with root package name */
        public TTAdNative.FullScreenVideoAdListener f1838d = new TTAdNative.FullScreenVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            @JProtect
            public void onError(int i2, String str) {
                PangleFullVideoAd.this.b = false;
                PangleFullVideoAdapter.this.notifyAdFailed(new AdError(i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            @JProtect
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                if (tTFullScreenVideoAd == null) {
                    PangleFullVideoAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                PangleFullVideoAd.this.a = tTFullScreenVideoAd;
                PangleFullVideoAd.this.setExpressAd(true);
                PangleFullVideoAd pangleFullVideoAd = PangleFullVideoAd.this;
                pangleFullVideoAd.setInteractionType(pangleFullVideoAd.a.getInteractionType());
                Map<String, Object> mediaExtraInfo = PangleFullVideoAd.this.a.getMediaExtraInfo();
                if (PangleFullVideoAdapter.this.isClientBidding() && mediaExtraInfo != null) {
                    double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                    Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleFullVideoAdapter.this.getAdapterRit(), PangleFullVideoAdapter.this.getAdSlotId()) + "pangle 全屏 返回的 cpm价格：" + value);
                    PangleFullVideoAd pangleFullVideoAd2 = PangleFullVideoAd.this;
                    if (value <= 0.0d) {
                        value = 0.0d;
                    }
                    pangleFullVideoAd2.setCpm(value);
                }
                if (mediaExtraInfo != null) {
                    Object obj = mediaExtraInfo.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        PangleFullVideoAd.this.f1837c = ((Boolean) obj).booleanValue();
                        Logger.d("TTMediationSDK", "pangle 全屏 返回的adnPreload：" + PangleFullVideoAd.this.f1837c);
                    }
                }
                PangleFullVideoAd.this.a.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdClose() {
                        if (PangleFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onFullVideoAdClosed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdShow() {
                        if (PangleFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onFullVideoAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdVideoBarClick() {
                        if (PangleFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onFullVideoAdClick();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onSkippedVideo() {
                        if (PangleFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onSkippedVideo();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onVideoComplete() {
                        if (PangleFullVideoAd.this.mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                            PangleFullVideoAd.this.a().onVideoComplete();
                        }
                    }
                });
                PangleFullVideoAd.this.b = true;
                PangleFullVideoAd pangleFullVideoAd3 = PangleFullVideoAd.this;
                PangleFullVideoAdapter.this.notifyAdLoaded(pangleFullVideoAd3);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            @JProtect
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
                PangleFullVideoAd.this.b = true;
                PangleFullVideoAd pangleFullVideoAd = PangleFullVideoAd.this;
                PangleFullVideoAdapter.this.notifyAdVideoCache(pangleFullVideoAd, (AdError) null);
                while (true) {
                    char c2 = 'J';
                    char c3 = '7';
                    while (true) {
                        switch (c2) {
                            case 'H':
                                break;
                            case 'I':
                                switch (c3) {
                                    case '^':
                                        break;
                                    case '_':
                                    case '`':
                                        return;
                                    default:
                                        if (c3 != '8' || c3 == '9') {
                                            return;
                                        }
                                        break;
                                }
                                c2 = 'I';
                                c3 = '`';
                                break;
                            case 'J':
                                if (c3 != '8') {
                                    return;
                                }
                                return;
                            default:
                                c2 = 'H';
                        }
                    }
                }
            }
        };

        public PangleFullVideoAd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener a() {
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
                com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener) r0
                return r0
            L19:
                r0 = 93
                r1 = 93
                goto L6
            L1e:
                r1 = 91
                goto L10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.a():com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            return tTFullScreenVideoAd != null ? PangleAdapterUtils.getAdId(tTFullScreenVideoAd.getMediaExtraInfo()) : super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            return tTFullScreenVideoAd != null ? PangleAdapterUtils.getCreativeId(tTFullScreenVideoAd.getMediaExtraInfo()) : super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            if (tTFullScreenVideoAd == null || (mediaExtraInfo = tTFullScreenVideoAd.getMediaExtraInfo()) == null) {
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
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            return tTFullScreenVideoAd != null ? PangleAdapterUtils.getReqId(tTFullScreenVideoAd.getMediaExtraInfo()) : super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdnPreload() {
            return this.f1837c;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            return (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getExpirationTimestamp() <= System.currentTimeMillis()) ? GMAdConstant.AdIsReadyStatus.AD_IS_EXPIRED : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @JProtect
        public void loadAd() {
            TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(PangleFullVideoAdapter.this.z);
            AdSlot adSlot = PangleFullVideoAdapter.this.mAdSlot;
            PangleFullVideoAdapter pangleFullVideoAdapter = PangleFullVideoAdapter.this;
            AdSlot.Builder buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(adSlot, pangleFullVideoAdapter.mGMAdSlotFullVideo, pangleFullVideoAdapter.getAdSlotId(), PangleFullVideoAdapter.this.mWaterfallAbTestParam, PangleFullVideoAdapter.this.getClientReqId(), PangleFullVideoAdapter.this.getAdm(), false);
            buildPangleAdSlot.setImageAcceptedSize(g0.b.f14277h, g0.b.f14278i).setOrientation(PangleFullVideoAdapter.this.mGMAdSlotFullVideo.getOrientation());
            createAdNative.loadFullScreenVideoAd(buildPangleAdSlot.build(), this.f1838d);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            if (tTFullScreenVideoAd != null) {
                tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.a.setDownloadListener(null);
                this.a = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (this.a != null) {
                TTAdConstant.RitScenes ritScenes = PangleAdapterUtils.getRitScenes(map);
                String customRitScenes = PangleAdapterUtils.getCustomRitScenes(map);
                if (ritScenes != null) {
                    this.a.showFullScreenVideoAd(activity, ritScenes, customRitScenes);
                } else {
                    this.a.showFullScreenVideoAd(activity);
                }
            }
        }
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

    @Override // com.bytedance.msdk.adapter.ad.GMFullVideoBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        if (this.mGMAdSlotFullVideo == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        this.z = context;
        if (map != null) {
            new PangleFullVideoAd().loadAd();
        }
    }
}
