package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMInterstitialBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PangleInterstitialAdapter extends GMInterstitialBaseAdapter {
    public static final String TAG = "PangleInterstitialAdapter";
    private Context A;
    private PangleExpressInterstitialAd z;

    /* loaded from: classes.dex */
    public class PangleExpressInterstitialAd extends TTBaseAd {
        private TTNativeExpressAd a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        public TTNativeExpressAd.AdInteractionListener f1840c = new TTNativeExpressAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdClicked(View view, int i2) {
                if (PangleExpressInterstitialAd.this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    PangleExpressInterstitialAd.this.a().onInterstitialAdClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
            @JProtect
            public void onAdDismiss() {
                if (PangleExpressInterstitialAd.this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    PangleExpressInterstitialAd.this.a().onInterstitialClosed();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onAdShow(View view, int i2) {
                if (PangleExpressInterstitialAd.this.mTTAdatperCallback instanceof ITTAdapterInterstitialListener) {
                    PangleExpressInterstitialAd.this.a().onInterstitialShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onRenderFail(View view, String str, int i2) {
                Logger.e("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "PangleExpressInterstitialAd onRenderFail -> code=" + i2 + ",msg=" + str);
                PangleInterstitialAdapter.this.notifyAdFailed(new AdError(i2, str));
                while (true) {
                    char c2 = '(';
                    while (true) {
                        switch (c2) {
                            case '(':
                            default:
                                c2 = '*';
                            case ')':
                                break;
                            case '*':
                                return;
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            @JProtect
            public void onRenderSuccess(View view, float f2, float f3) {
                char c2;
                PangleExpressInterstitialAd.this.b = true;
                Logger.d("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "穿山甲SDK--插屏-onRenderSucces");
                PangleExpressInterstitialAd pangleExpressInterstitialAd = PangleExpressInterstitialAd.this;
                PangleInterstitialAdapter.this.notifyAdLoaded(pangleExpressInterstitialAd);
                do {
                    c2 = 'P';
                    while (c2 == 'P') {
                        c2 = 'R';
                    }
                } while (c2 != 'R');
            }
        };

        public PangleExpressInterstitialAd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JProtect
        public ITTAdapterInterstitialListener a() {
            while (true) {
                char c2 = ']';
                char c3 = ']';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                            }
                            c2 = '^';
                            c3 = 'K';
                            break;
                        case ']':
                            while (true) {
                                switch (c3) {
                                    default:
                                        c3 = '[';
                                    case '[':
                                    case '\\':
                                    case ']':
                                        break;
                                }
                            }
                            c2 = '^';
                            c3 = 'K';
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            return (ITTAdapterInterstitialListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo()) : super.getAdId();
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
            return this.a == null;
        }

        @JProtect
        public void loadAd() {
            TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(PangleInterstitialAdapter.this.A);
            AdSlot.Builder buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(PangleInterstitialAdapter.this.mAdSlot, PangleInterstitialAdapter.this.mGMAdSlotBase, PangleInterstitialAdapter.this.getAdSlotId(), PangleInterstitialAdapter.this.mWaterfallAbTestParam, PangleInterstitialAdapter.this.getClientReqId(), PangleInterstitialAdapter.this.getAdm(), false);
            buildPangleAdSlot.setExpressViewAcceptedSize(PangleInterstitialAdapter.this.mGMAdSlotInterstitial.getWidth(), PangleInterstitialAdapter.this.mGMAdSlotInterstitial.getHeight());
            createAdNative.loadInteractionExpressAd(buildPangleAdSlot.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                public void onError(int i2, String str) {
                    PangleInterstitialAdapter.this.notifyAdFailed(new AdError(i2, str));
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                    Map<String, Object> mediaExtraInfo;
                    if (list == null || list.size() == 0) {
                        PangleInterstitialAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                        return;
                    }
                    Logger.d("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "穿山甲SDK--插屏-onNativeExpressAdLoad");
                    PangleExpressInterstitialAd.this.a = list.get(0);
                    PangleExpressInterstitialAd.this.setExpressAd(true);
                    PangleExpressInterstitialAd pangleExpressInterstitialAd = PangleExpressInterstitialAd.this;
                    pangleExpressInterstitialAd.setInteractionType(pangleExpressInterstitialAd.a.getInteractionType());
                    if (PangleInterstitialAdapter.this.isClientBidding() && (mediaExtraInfo = PangleExpressInterstitialAd.this.a.getMediaExtraInfo()) != null) {
                        double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                        Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "pangle 插屏 返回的 cpm价格：" + value);
                        PangleExpressInterstitialAd pangleExpressInterstitialAd2 = PangleExpressInterstitialAd.this;
                        if (value <= 0.0d) {
                            value = 0.0d;
                        }
                        pangleExpressInterstitialAd2.setCpm(value);
                    }
                    PangleExpressInterstitialAd.this.a.setExpressInteractionListener(PangleExpressInterstitialAd.this.f1840c);
                    PangleExpressInterstitialAd.this.a.render();
                }
            });
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
                this.a.setDownloadListener(null);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.showInteractionExpressAd(activity);
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

    @Override // com.bytedance.msdk.adapter.ad.GMInterstitialBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        if (this.mGMAdSlotInterstitial == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        this.A = context;
        if (map != null) {
            PangleExpressInterstitialAd pangleExpressInterstitialAd = new PangleExpressInterstitialAd();
            this.z = pangleExpressInterstitialAd;
            pangleExpressInterstitialAd.loadAd();
        }
    }
}
