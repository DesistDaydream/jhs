package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.DislikeEvent;
import com.baidu.mobads.sdk.api.FeedNativeView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMNativeBaseAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.BaiduNativeSmartOptStyleParams;
import com.bytedance.msdk.api.BaiduRequestParameters;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class BaiduNativeAdapter extends GMNativeBaseAdapter {
    private boolean A;
    private GMAdSlotBaiduOption B;
    private BaiduNativeSmartOptStyleParams C;
    private BaiduNativeManager E;
    private Context z;
    private Map<NativeResponse, BaiduNativeAd> D = new HashMap();
    private final BaiduNativeManager.FeedAdListener F = new BaiduNativeManager.FeedAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAdapter.1
        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduNativeAdapter.this.getAdapterRit(), BaiduNativeAdapter.this.getAdSlotId()) + "Baidu native ad  ....... onLpClosed:落地页关闭");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        @JProtect
        public void onNativeFail(int i2, String str) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduNativeAdapter.this.getAdapterRit(), BaiduNativeAdapter.this.getAdSlotId()) + "Baidu onLoadFail native message=" + str + "，errorCode=" + i2);
            BaiduNativeAdapter.this.notifyAdFailed(new AdError(i2, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        @JProtect
        public void onNativeLoad(List<NativeResponse> list) {
            if (list == null || list.size() <= 0) {
                BaiduNativeAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (NativeResponse nativeResponse : list) {
                if (nativeResponse != null) {
                    BaiduNativeAd baiduNativeAd = new BaiduNativeAd((XAdNativeResponse) nativeResponse);
                    BaiduNativeAdapter.this.D.put(nativeResponse, baiduNativeAd);
                    arrayList.add(baiduNativeAd);
                }
            }
            BaiduNativeAdapter.this.notifyAdLoaded(arrayList);
            for (char c2 = '\''; c2 == '\''; c2 = 'R') {
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        @JProtect
        public void onNoAd(int i2, String str) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduNativeAdapter.this.getAdapterRit(), BaiduNativeAdapter.this.getAdSlotId()) + "Baidu onNoAd native message=" + str + "，errorCode=" + i2);
            BaiduNativeAdapter.this.notifyAdFailed(new AdError(i2, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduNativeAdapter.this.getAdapterRit(), BaiduNativeAdapter.this.getAdSlotId()) + "Baidu native ad  ....... onVideoDownloadFailed:");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduNativeAdapter.this.getAdapterRit(), BaiduNativeAdapter.this.getAdSlotId()) + "Baidu native ad  ....... onVideoDownloadSuccess:");
        }
    };

    /* loaded from: classes.dex */
    public class BaiduNativeAd extends TTBaseAd {
        private XAdNativeResponse a;
        private FeedNativeView b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1771c = false;

        /* JADX WARN: Removed duplicated region for block: B:18:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01ce  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public BaiduNativeAd(com.baidu.mobads.sdk.api.XAdNativeResponse r7) {
            /*
                Method dump skipped, instructions count: 512
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduNativeAdapter.BaiduNativeAd.<init>(com.bytedance.msdk.adapter.baidu.BaiduNativeAdapter, com.baidu.mobads.sdk.api.XAdNativeResponse):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            GMNativeAdListener gMNativeAdListener = this.mTTNativeAdListener;
            if (gMNativeAdListener != null) {
                gMNativeAdListener.onAdShow();
            }
        }

        private boolean d(NativeResponse nativeResponse) {
            return (TextUtils.isEmpty(nativeResponse.getAppVersion()) || TextUtils.isEmpty(nativeResponse.getPublisher()) || TextUtils.isEmpty(nativeResponse.getAppPrivacyLink()) || TextUtils.isEmpty(nativeResponse.getAppPermissionLink())) ? false : true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void dislikeClick(String str, Map<String, Object> map) {
            super.dislikeClick(str, map);
            if (map == null || !(map.get(GMAdConstant.BAIDU_DISLIKE_CLICK_ITEM) instanceof DislikeEvent)) {
                Log.e("TTMediationSDK", "__baidu_dislikeClick_回传dislike信息参数不全，没有带BAIDU_DISLIKE_CLICK_ITEM相关信息 disLikeInfo:" + str);
                return;
            }
            DislikeEvent dislikeEvent = (DislikeEvent) map.get(GMAdConstant.BAIDU_DISLIKE_CLICK_ITEM);
            if (this.a != null) {
                Log.e("TTMediationSDK", "__baidu_dislikeClick_回传dislike信息to Adn getDislikeType:" + dislikeEvent.getDislikeType() + "  getDislikeName:" + dislikeEvent.getDislikeName() + "   disLikeInfo:" + str);
                this.a.dislikeClick(dislikeEvent);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public View getAdView() {
            return this.b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getDownloadStatus() {
            XAdNativeResponse xAdNativeResponse = this.a;
            if (xAdNativeResponse != null) {
                int downloadStatus = xAdNativeResponse.getDownloadStatus();
                if (downloadStatus < 0 || downloadStatus > 100) {
                    if (downloadStatus == 101) {
                        return 9;
                    }
                    if (downloadStatus == 102) {
                        return 12;
                    }
                    if (downloadStatus == 103) {
                        return 10;
                    }
                    return downloadStatus == 104 ? 11 : 1;
                }
                return 2;
            }
            return -1;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getVideoUrl() {
            XAdNativeResponse xAdNativeResponse;
            if (!isUseCustomVideo() || (xAdNativeResponse = this.a) == null) {
                return null;
            }
            return xAdNativeResponse.getVideoUrl();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f1771c;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return isExpressAd();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            return (this.a == null || BaiduNativeAdapter.this.z == null || !this.a.isAdAvailable(BaiduNativeAdapter.this.z)) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            super.onDestroy();
            this.f1771c = true;
            if (BaiduNativeAdapter.this.D == null || this.a == null) {
                return;
            }
            BaiduNativeAdapter.this.D.remove(this.a);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onPause() {
            super.onPause();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onResume() {
            super.onResume();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void pauseAppDownload() {
            XAdNativeResponse xAdNativeResponse = this.a;
            if (xAdNativeResponse != null) {
                xAdNativeResponse.pauseAppDownload();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x014b -> B:25:0x0150). Please submit an issue!!! */
        @Override // com.bytedance.msdk.base.TTBaseAd
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void registerViewForInteraction(@androidx.annotation.NonNull android.view.ViewGroup r11, java.util.List<android.view.View> r12, java.util.List<android.view.View> r13, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder r14) {
            /*
                Method dump skipped, instructions count: 350
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduNativeAdapter.BaiduNativeAd.registerViewForInteraction(android.view.ViewGroup, java.util.List, java.util.List, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder):void");
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0042 -> B:13:0x0044). Please submit an issue!!! */
        @Override // com.bytedance.msdk.base.TTBaseAd
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void render() {
            /*
                r5 = this;
                super.render()
                com.baidu.mobads.sdk.api.XAdNativeResponse r0 = r5.a
                if (r0 == 0) goto L47
                int r0 = r0.getStyleType()
                boolean r0 = com.bytedance.msdk.adapter.baidu.BaiduAdapterUtil.isNativeSmartOpt(r0)
                if (r0 == 0) goto L47
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                com.baidu.mobads.sdk.api.FeedNativeView r2 = r5.b
                if (r2 == 0) goto L22
                r0.add(r2)
            L22:
                com.baidu.mobads.sdk.api.XAdNativeResponse r2 = r5.a
                com.baidu.mobads.sdk.api.FeedNativeView r3 = r5.b
                com.bytedance.msdk.adapter.baidu.BaiduNativeAdapter$BaiduNativeAd$4 r4 = new com.bytedance.msdk.adapter.baidu.BaiduNativeAdapter$BaiduNativeAd$4
                r4.<init>()
                r2.registerViewForInteraction(r3, r0, r1, r4)
                com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r0 = r5.mTTNativeAdListener
                boolean r1 = r0 instanceof com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
                r2 = 39
                if (r1 == 0) goto L42
                com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener r0 = (com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener) r0
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r3 = -1073741824(0xffffffffc0000000, float:-2.0)
                r0.onRenderSuccess(r1, r3)
                r0 = 39
                goto L44
            L42:
                r0 = 82
            L44:
                if (r0 == r2) goto L42
                goto L59
            L47:
                com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r0 = r5.mTTNativeAdListener
                boolean r1 = r0 instanceof com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
                if (r1 == 0) goto L59
                com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener r0 = (com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener) r0
                com.baidu.mobads.sdk.api.FeedNativeView r1 = r5.b
                r2 = -99999(0xfffffffffffe7961, float:NaN)
                java.lang.String r3 = "物料错误"
                r0.onRenderFail(r1, r3, r2)
            L59:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduNativeAdapter.BaiduNativeAd.render():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void resumeAppDownload() {
            XAdNativeResponse xAdNativeResponse = this.a;
            if (xAdNativeResponse != null) {
                xAdNativeResponse.resumeAppDownload();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, final GMDislikeCallback gMDislikeCallback) {
            this.a.setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAdapter.BaiduNativeAd.5
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                public void onDislikeClick() {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduNativeAdapter.this.getAdapterRit(), BaiduNativeAdapter.this.getAdSlotId()) + "Baidu native ad express ....... onDislikeClick");
                    if (gMDislikeCallback != null) {
                        BaiduNativeAd baiduNativeAd = BaiduNativeAd.this;
                        BaiduNativeAdapter.this.nativeDislikeClick(baiduNativeAd, "百度智能优选dislike接口无关闭原因", null);
                        gMDislikeCallback.onSelected(0, "百度智能优选dislike接口无关闭原因");
                    }
                }
            });
        }
    }

    private RequestParameters D(GMAdSlotBase gMAdSlotBase) {
        if (!(gMAdSlotBase instanceof GMAdSlotNative)) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return null;
        }
        GMAdSlotNative gMAdSlotNative = (GMAdSlotNative) gMAdSlotBase;
        this.mGMAdSlotNative = gMAdSlotNative;
        if (gMAdSlotNative != null) {
            RequestParameters.Builder builder = new RequestParameters.Builder();
            GMAdSlotBaiduOption gMAdSlotBaiduOption = this.mGMAdSlotNative.getGMAdSlotBaiduOption();
            this.B = gMAdSlotBaiduOption;
            if (gMAdSlotBaiduOption != null) {
                BaiduRequestParameters baiduRequestParameters = gMAdSlotBaiduOption.getBaiduRequestParameters();
                if (baiduRequestParameters != null) {
                    builder.downloadAppConfirmPolicy(baiduRequestParameters.getAPPConfirmPolicy() != 0 ? baiduRequestParameters.getAPPConfirmPolicy() : 3);
                    Map<String, String> extras = baiduRequestParameters.getExtras();
                    if (extras != null) {
                        try {
                            for (Map.Entry<String, String> entry : extras.entrySet()) {
                                if (entry != null) {
                                    builder.addExtra(entry.getKey(), entry.getValue());
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            } else {
                builder.downloadAppConfirmPolicy(1);
            }
            int width = this.mGMAdSlotNative.getWidth() > 0 ? this.mGMAdSlotNative.getWidth() : 0;
            int height = this.mGMAdSlotNative.getHeight() > 0 ? this.mGMAdSlotNative.getHeight() : 0;
            if (width > 0 && height > 0) {
                builder.setWidth(width).setHeight(height);
            }
            return builder.build();
        }
        return null;
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "baidu";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getBiddingToken(Context context, String str, GMAdSlotBase gMAdSlotBase) {
        this.z = context;
        if (this.E == null) {
            this.E = new BaiduNativeManager(this.z, str);
        }
        RequestParameters D = D(gMAdSlotBase);
        if (D != null) {
            return this.E.getFeedBiddingToken(D);
        }
        Logger.e("TTMediationSDK", "Baidu native getBiddingToken RequestParameters is null");
        return null;
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return AdSettings.getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.ad.GMNativeBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        this.z = context;
        if (this.mGMAdSlotNative == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        if (this.E == null) {
            this.E = new BaiduNativeManager(this.z, getAdSlotId());
        }
        GMAdSlotBaiduOption gMAdSlotBaiduOption = this.mGMAdSlotNative.getGMAdSlotBaiduOption();
        this.B = gMAdSlotBaiduOption;
        if (gMAdSlotBaiduOption != null) {
            this.C = gMAdSlotBaiduOption.getBaiduNativeSmartOptStyleParams();
            String appSid = this.B.getAppSid();
            if (!TextUtils.isEmpty(appSid)) {
                this.E.setAppSid(appSid);
            }
        }
        this.A = this.mGMAdSlotNative.isMuted();
        BaiduNativeManager baiduNativeManager = this.E;
        GMAdSlotBaiduOption gMAdSlotBaiduOption2 = this.B;
        baiduNativeManager.setCacheVideoOnlyWifi(gMAdSlotBaiduOption2 == null || gMAdSlotBaiduOption2.isCacheVideoOnlyWifi());
        GMAdSlotBaiduOption gMAdSlotBaiduOption3 = this.B;
        if (gMAdSlotBaiduOption3 == null || gMAdSlotBaiduOption3.isCacheVideoOnlyWifi()) {
            this.E.setCacheVideoOnlyWifi(true);
        }
        if (isServerBidding()) {
            this.E.loadBidAdForFeed(getAdm(), this.F);
        } else {
            this.E.loadFeedAd(D(this.mGMAdSlotBase), this.F);
        }
    }
}
