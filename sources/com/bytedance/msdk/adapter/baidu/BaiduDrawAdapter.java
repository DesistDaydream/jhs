package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMDrawBaseAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.BaiduRequestParameters;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class BaiduDrawAdapter extends GMDrawBaseAdapter {
    public static final String TAG = "BaiduDrawAdapter";
    private Context A;
    private BaiduDrawAd C;
    private Map<NativeResponse, BaiduDrawAd> B = new HashMap();
    private final BaiduNativeManager.PortraitVideoAdListener D = new BaiduNativeManager.PortraitVideoAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawAdapter.1
        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
        public void onAdClick() {
            Log.i(BaiduDrawAdapter.TAG, "onAdClick==");
            if (BaiduDrawAdapter.this.C == null || BaiduDrawAdapter.this.C.getGMDrawAdListener() == null) {
                return;
            }
            BaiduDrawAdapter.this.C.getGMDrawAdListener().onAdClick();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
            Log.i(BaiduDrawAdapter.TAG, "onLpClosed ");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i2, String str) {
            String str2 = BaiduDrawAdapter.TAG;
            Log.i(str2, "onNativeFail== i = " + i2 + " s = " + str);
            BaiduDrawAdapter.this.notifyAdFailed(new AdError(i2, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(List<NativeResponse> list) {
            if (list == null || list.size() <= 0) {
                BaiduDrawAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                return;
            }
            ArrayList arrayList = new ArrayList();
            BaiduDrawAdapter baiduDrawAdapter = BaiduDrawAdapter.this;
            baiduDrawAdapter.C = new BaiduDrawAd((XAdNativeResponse) list.get(0));
            arrayList.add(BaiduDrawAdapter.this.C);
            BaiduDrawAdapter.this.notifyAdLoaded(arrayList);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i2, String str) {
            String str2 = BaiduDrawAdapter.TAG;
            Log.i(str2, "onNoAd== i = " + i2 + " s = " + str);
            BaiduDrawAdapter.this.notifyAdFailed(new AdError(i2, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
            Log.i(BaiduDrawAdapter.TAG, "onVideoDownloadFailed ");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
            Log.i(BaiduDrawAdapter.TAG, "onVideoDownloadSuccess ");
        }
    };

    /* loaded from: classes.dex */
    public class BaiduDrawAd extends TTBaseAd {
        private XAdNativeResponse a;
        private FeedPortraitVideoView b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1769c = false;

        public BaiduDrawAd(XAdNativeResponse xAdNativeResponse) {
            StringBuilder sb;
            String str;
            setExpressAd(true);
            this.a = xAdNativeResponse;
            if (!BaiduDrawAdapter.this.isClientBidding()) {
                if (BaiduDrawAdapter.this.isMultiBidding()) {
                    setLevelTag(xAdNativeResponse.getECPMLevel());
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagThirdLevelById(BaiduDrawAdapter.this.getAdapterRit(), BaiduDrawAdapter.this.getAdSlotId()));
                    str = "Baidu_多阶底价 draw 返回的 价格标签：";
                }
                FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(BaiduDrawAdapter.this.A);
                this.b = feedPortraitVideoView;
                feedPortraitVideoView.setVideoMute(BaiduDrawAdapter.this.mGMAdSlotDraw.isMuted());
                this.a.setAdPrivacyListener(new NativeResponse.AdDownloadWindowListener(BaiduDrawAdapter.this) { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawAdapter.BaiduDrawAd.1
                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
                    public void adDownloadWindowClose() {
                        Log.i(BaiduDrawAdapter.TAG, "adDownloadWindowClose: ");
                        BaiduDrawAd.this.b.resume();
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
                    public void adDownloadWindowShow() {
                        Log.i(BaiduDrawAdapter.TAG, "adDownloadWindowShow: ");
                        BaiduDrawAd.this.b.pause();
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
                    public void onADPermissionClose() {
                        Log.i(BaiduDrawAdapter.TAG, "onADPermissionClose: ");
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
                    public void onADPermissionShow() {
                        Log.i(BaiduDrawAdapter.TAG, "onADPermissionShow: ");
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
                    public void onADPrivacyClick() {
                        Log.i(BaiduDrawAdapter.TAG, "onADPrivacyClick: ");
                    }
                });
                this.b.setFeedPortraitListener(new IFeedPortraitListener(this, BaiduDrawAdapter.this) { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawAdapter.BaiduDrawAd.2
                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public void pauseBtnClick() {
                        Log.i(BaiduDrawAdapter.TAG, "pauseBtnClick");
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public void playCompletion() {
                        Log.i(BaiduDrawAdapter.TAG, "playCompletion==");
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public void playError() {
                        Log.i(BaiduDrawAdapter.TAG, "playError==");
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public void playPause() {
                        Log.i(BaiduDrawAdapter.TAG, "playPause==");
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public void playRenderingStart() {
                        Log.i(BaiduDrawAdapter.TAG, "playRenderingStart==");
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public void playResume() {
                        Log.i(BaiduDrawAdapter.TAG, "playResume==");
                    }
                });
            }
            double d2 = 0.0d;
            try {
                d2 = Double.valueOf(xAdNativeResponse.getECPMLevel()).doubleValue();
            } catch (Exception unused) {
            }
            setCpm(d2);
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagThirdLevelById(BaiduDrawAdapter.this.getAdapterRit(), BaiduDrawAdapter.this.getAdSlotId()));
            str = "Baidu_cientBidding draw 返回的 cpm价格：";
            sb.append(str);
            sb.append(xAdNativeResponse.getECPMLevel());
            Logger.d("TTMediationSDK_ECMP", sb.toString());
            FeedPortraitVideoView feedPortraitVideoView2 = new FeedPortraitVideoView(BaiduDrawAdapter.this.A);
            this.b = feedPortraitVideoView2;
            feedPortraitVideoView2.setVideoMute(BaiduDrawAdapter.this.mGMAdSlotDraw.isMuted());
            this.a.setAdPrivacyListener(new NativeResponse.AdDownloadWindowListener(BaiduDrawAdapter.this) { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawAdapter.BaiduDrawAd.1
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
                public void adDownloadWindowClose() {
                    Log.i(BaiduDrawAdapter.TAG, "adDownloadWindowClose: ");
                    BaiduDrawAd.this.b.resume();
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
                public void adDownloadWindowShow() {
                    Log.i(BaiduDrawAdapter.TAG, "adDownloadWindowShow: ");
                    BaiduDrawAd.this.b.pause();
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
                public void onADPermissionClose() {
                    Log.i(BaiduDrawAdapter.TAG, "onADPermissionClose: ");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
                public void onADPermissionShow() {
                    Log.i(BaiduDrawAdapter.TAG, "onADPermissionShow: ");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
                public void onADPrivacyClick() {
                    Log.i(BaiduDrawAdapter.TAG, "onADPrivacyClick: ");
                }
            });
            this.b.setFeedPortraitListener(new IFeedPortraitListener(this, BaiduDrawAdapter.this) { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawAdapter.BaiduDrawAd.2
                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void pauseBtnClick() {
                    Log.i(BaiduDrawAdapter.TAG, "pauseBtnClick");
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playCompletion() {
                    Log.i(BaiduDrawAdapter.TAG, "playCompletion==");
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playError() {
                    Log.i(BaiduDrawAdapter.TAG, "playError==");
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playPause() {
                    Log.i(BaiduDrawAdapter.TAG, "playPause==");
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playRenderingStart() {
                    Log.i(BaiduDrawAdapter.TAG, "playRenderingStart==");
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playResume() {
                    Log.i(BaiduDrawAdapter.TAG, "playResume==");
                }
            });
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public View getAdView() {
            return this.b;
        }

        public GMDrawAdListener getGMDrawAdListener() {
            return this.mGMDrawAdListener;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f1769c;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            return (this.a == null || BaiduDrawAdapter.this.A == null || !this.a.isAdAvailable(BaiduDrawAdapter.this.A)) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            super.onDestroy();
            this.f1769c = true;
            if (BaiduDrawAdapter.this.B == null || this.a == null) {
                return;
            }
            BaiduDrawAdapter.this.B.remove(this.a);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void render() {
            super.render();
            if (this.a == null) {
                GMDrawAdListener gMDrawAdListener = this.mGMDrawAdListener;
                if (gMDrawAdListener instanceof GMDrawExpressAdListener) {
                    ((GMDrawExpressAdListener) gMDrawAdListener).onRenderFail(this.b, "物料错误", AdError.ERROR_ADN_NO_ERROR_CODE);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            FeedPortraitVideoView feedPortraitVideoView = this.b;
            if (feedPortraitVideoView != null) {
                arrayList.add(feedPortraitVideoView);
            }
            this.a.registerViewForInteraction(this.b, arrayList, arrayList2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawAdapter.BaiduDrawAd.3
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposed() {
                    if (BaiduDrawAd.this.mGMDrawAdListener != null) {
                        BaiduDrawAd.this.mGMDrawAdListener.onAdShow();
                    }
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduDrawAdapter.this.getAdapterRit(), BaiduDrawAdapter.this.getAdSlotId()) + "Baidu native ad express ....... onAdExposed");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposureFailed(int i2) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduDrawAdapter.this.getAdapterRit(), BaiduDrawAdapter.this.getAdSlotId()) + "Baidu native ad express ....... onAdExposeFailed: " + i2);
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADStatusChanged() {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduDrawAdapter.this.getAdapterRit(), BaiduDrawAdapter.this.getAdSlotId()) + "Baidu native ad express ....... onAdStatusChanged");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdClick() {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduDrawAdapter.this.getAdapterRit(), BaiduDrawAdapter.this.getAdSlotId()) + "Baidu native express ad ....... onAdClick");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdUnionClick() {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduDrawAdapter.this.getAdapterRit(), BaiduDrawAdapter.this.getAdSlotId()) + "Baidu native ad express ....... onAdUnionClick");
                }
            });
            this.b.setAdData(this.a);
            this.b.play();
            GMDrawAdListener gMDrawAdListener2 = this.mGMDrawAdListener;
            if (gMDrawAdListener2 instanceof GMDrawExpressAdListener) {
                ((GMDrawExpressAdListener) gMDrawAdListener2).onRenderSuccess(BaiduDrawAdapter.this.mGMAdSlotDraw.getWidth(), BaiduDrawAdapter.this.mGMAdSlotDraw.getHeight());
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "baidu";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return AdSettings.getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.ad.GMDrawBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        if (this.mGMAdSlotDraw == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        this.A = context;
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, getAdSlotId());
        GMAdSlotBaiduOption gMAdSlotBaiduOption = this.mGMAdSlotDraw.getGMAdSlotBaiduOption();
        RequestParameters.Builder height = new RequestParameters.Builder().setWidth(this.mGMAdSlotDraw.getWidth()).setHeight(this.mGMAdSlotDraw.getHeight());
        if (gMAdSlotBaiduOption != null) {
            BaiduRequestParameters baiduRequestParameters = gMAdSlotBaiduOption.getBaiduRequestParameters();
            if (baiduRequestParameters != null) {
                height.downloadAppConfirmPolicy(baiduRequestParameters.getAPPConfirmPolicy() != 0 ? baiduRequestParameters.getAPPConfirmPolicy() : 3);
                Map<String, String> extras = baiduRequestParameters.getExtras();
                if (extras != null) {
                    try {
                        for (Map.Entry<String, String> entry : extras.entrySet()) {
                            if (entry != null) {
                                height.addExtra(entry.getKey(), entry.getValue());
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } else {
            height.downloadAppConfirmPolicy(1);
        }
        baiduNativeManager.setCacheVideoOnlyWifi(gMAdSlotBaiduOption == null || gMAdSlotBaiduOption.isCacheVideoOnlyWifi());
        if (gMAdSlotBaiduOption == null || gMAdSlotBaiduOption.isCacheVideoOnlyWifi()) {
            baiduNativeManager.setCacheVideoOnlyWifi(true);
        }
        baiduNativeManager.loadPortraitVideoAd(height.build(), this.D);
    }
}
