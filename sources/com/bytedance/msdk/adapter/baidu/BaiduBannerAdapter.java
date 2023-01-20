package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.FeedNativeView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMBannerBaseAdapter;
import com.bytedance.msdk.adapter.baidu.VisibleStateFrameLayout;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.BaiduNativeSmartOptStyleParams;
import com.bytedance.msdk.api.BaiduRequestParameters;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BaiduBannerAdapter extends GMBannerBaseAdapter {
    private boolean A;
    private boolean B;
    private BaiduNativeSmartOptStyleParams C;
    private final BaiduNativeManager.FeedAdListener D = new BaiduNativeManager.FeedAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.1
        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu native ad  ....... onLpClosed:落地页关闭");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        @JProtect
        public void onNativeFail(int i2, String str) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu onLoadFail native message=" + str + "，errorCode=" + i2);
            BaiduBannerAdapter.this.notifyAdFailed(new AdError(i2, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        @JProtect
        public void onNativeLoad(List<NativeResponse> list) {
            if (list == null || list.size() <= 0) {
                BaiduBannerAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                return;
            }
            BaiduNativeAd baiduNativeAd = new BaiduNativeAd((XAdNativeResponse) list.get(0));
            if (BaiduBannerAdapter.this.B) {
                baiduNativeAd.render();
            } else {
                BaiduBannerAdapter.this.notifyAdLoaded(baiduNativeAd);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        @JProtect
        public void onNoAd(int i2, String str) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu onNoAd native message=" + str + "，errorCode=" + i2);
            BaiduBannerAdapter.this.notifyAdFailed(new AdError(i2, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu native ad  ....... onVideoDownloadFailed:");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
            Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu native ad  ....... onVideoDownloadSuccess:");
        }
    };
    private Context z;

    /* loaded from: classes.dex */
    public class BaiduBannerAd extends TTBaseAd implements AdViewListener {
        private AdView a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1762c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1763d;

        /* renamed from: e  reason: collision with root package name */
        private VisibleStateFrameLayout f1764e;

        /* renamed from: f  reason: collision with root package name */
        private volatile boolean f1765f = false;

        public BaiduBannerAd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener e() {
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
                com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener) r0
                return r0
            L19:
                r0 = 93
                r1 = 93
                goto L6
            L1e:
                r1 = 91
                goto L10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.BaiduBannerAd.e():com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00c1 A[PHI: r1 
          PHI: (r1v9 char) = (r1v6 char), (r1v19 char) binds: [B:18:0x00b3, B:15:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00af -> B:18:0x00b3). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00b3 -> B:25:0x00c1). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00bd -> B:22:0x00bb). Please submit an issue!!! */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b() {
            /*
                r7 = this;
                com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.this
                android.content.Context r0 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.G(r0)
                boolean r0 = r0 instanceof android.app.Activity
                if (r0 == 0) goto Lc4
                com.baidu.mobads.sdk.api.AdView r0 = new com.baidu.mobads.sdk.api.AdView
                com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter r1 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.this
                android.content.Context r2 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.G(r1)
                com.baidu.mobads.sdk.api.AdSize r5 = com.baidu.mobads.sdk.api.AdSize.Banner
                com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter r1 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.this
                java.lang.String r6 = r1.getAdSlotId()
                r3 = 0
                r4 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6)
                r7.a = r0
                com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotBanner r0 = r0.mGMAdSlotBanner
                com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption r0 = r0.getGMAdSlotBaiduOption()
                if (r0 == 0) goto L3b
                java.lang.String r0 = r0.getAppSid()
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L3b
                com.baidu.mobads.sdk.api.AdView r1 = r7.a
                r1.setAppSid(r0)
            L3b:
                com.baidu.mobads.sdk.api.AdView r0 = r7.a
                r0.setListener(r7)
                com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.this
                android.content.Context r0 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.G(r0)
                android.app.Activity r0 = (android.app.Activity) r0
                if (r0 == 0) goto La3
                android.view.Window r1 = r0.getWindow()
                if (r1 == 0) goto La3
                android.view.Window r1 = r0.getWindow()
                android.view.View r1 = r1.getDecorView()
                boolean r1 = r1 instanceof android.view.ViewGroup
                if (r1 == 0) goto La3
                com.bytedance.msdk.adapter.baidu.VisibleStateFrameLayout r1 = new com.bytedance.msdk.adapter.baidu.VisibleStateFrameLayout
                com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter r2 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.this
                android.content.Context r2 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.G(r2)
                r1.<init>(r2)
                r7.f1764e = r1
                android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
                r2 = -1
                r1.<init>(r2, r2)
                com.bytedance.msdk.adapter.baidu.VisibleStateFrameLayout r2 = r7.f1764e
                com.baidu.mobads.sdk.api.AdView r3 = r7.a
                r2.addView(r3, r1)
                com.bytedance.msdk.adapter.baidu.VisibleStateFrameLayout r1 = r7.f1764e
                r2 = 4
                r1.setVisibility(r2)
                android.view.Window r0 = r0.getWindow()
                android.view.View r0 = r0.getDecorView()
                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
                com.bytedance.msdk.adapter.baidu.VisibleStateFrameLayout r1 = r7.f1764e
                r0.addView(r1)
                android.os.Handler r1 = new android.os.Handler
                android.os.Looper r2 = android.os.Looper.getMainLooper()
                r1.<init>(r2)
                com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter$BaiduBannerAd$1 r2 = new com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter$BaiduBannerAd$1
                r2.<init>()
                r3 = 100
                r1.postDelayed(r2, r3)
                r0 = 79
                r1 = 79
                goto Lc1
            La3:
                com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.this
                com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                java.lang.String r2 = "上下文为null，无法加载百度Banner"
                r1.<init>(r2)
                r0.notifyAdFailed(r1)
            Laf:
                r0 = 72
                r1 = 85
            Lb3:
                switch(r0) {
                    case 70: goto Lbb;
                    case 71: goto Lb7;
                    case 72: goto Lbd;
                    default: goto Lb6;
                }
            Lb6:
                goto Lc1
            Lb7:
                switch(r1) {
                    case 32: goto Lbb;
                    case 33: goto Lbb;
                    case 34: goto Laf;
                    default: goto Lba;
                }
            Lba:
                goto Lbd
            Lbb:
                r1 = 86
            Lbd:
                switch(r1) {
                    case 85: goto Ld0;
                    case 86: goto Ld0;
                    case 87: goto Ld0;
                    default: goto Lc0;
                }
            Lc0:
                goto Lbb
            Lc1:
                r0 = 70
                goto Lb3
            Lc4:
                com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter r0 = com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.this
                com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                java.lang.String r2 = "Context必须为Activity，其他类型不支持百度Banner广告"
                r1.<init>(r2)
                r0.notifyAdFailed(r1)
            Ld0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.BaiduBannerAd.b():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public View getAdView() {
            if (this.f1763d) {
                return null;
            }
            if (this.b) {
                this.f1764e.setVisibility(0);
                BaiduBannerAdapter.this.removeFromParent(this.f1764e);
                this.f1764e.setVisibilityChanged(new VisibleStateFrameLayout.VisibilityChanged() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.BaiduBannerAd.3
                    @Override // com.bytedance.msdk.adapter.baidu.VisibleStateFrameLayout.VisibilityChanged
                    public void callback(boolean z) {
                        if (z) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "Baidu banner ad real show .......");
                            if (BaiduBannerAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                                BaiduBannerAd.this.e().onAdShow();
                            }
                        }
                    }
                });
                return this.f1764e;
            }
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "Baidu banner ad getView is null!! ...");
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f1765f;
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        @JProtect
        public void onAdClick(JSONObject jSONObject) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "Baidu banner ad click .......");
            if (this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                e().onAdClicked();
                while (true) {
                    for (char c2 = '`'; c2 != '^'; c2 = '^') {
                        if (c2 != '`') {
                            break;
                        }
                    }
                    return;
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        @JProtect
        public void onAdClose(JSONObject jSONObject) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "Baidu banner ad close .......");
            if (!(this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener)) {
                return;
            }
            e().onAdClosed();
            char c2 = '_';
            char c3 = '^';
            while (true) {
                if (c3 == '`' && c2 != '*') {
                    return;
                }
                c2 = '(';
                c3 = '`';
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        @JProtect
        public void onAdFailed(String str) {
            Logger.d("TTMediationSDK", "Baidu banner onAdFailed " + str);
            this.f1763d = true;
            if (this.f1762c) {
                return;
            }
            this.f1762c = true;
            BaiduBannerAdapter.this.notifyAdFailed(new AdError(str));
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdReady(AdView adView) {
            Logger.d("TTMediationSDK", "Baidu banner onAdReady ......");
            this.b = true;
            if (this.f1762c) {
                return;
            }
            this.f1762c = true;
            BaiduBannerAdapter.this.notifyAdLoaded(this);
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        @JProtect
        public void onAdShow(JSONObject jSONObject) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "Baidu banner ad show .......");
            for (char c2 = 'I'; c2 != 'H'; c2 = 'H') {
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdSwitch() {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "Baidu banner ad switch .......");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.f1765f = true;
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.BaiduBannerAd.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BaiduBannerAd.this.a != null) {
                        BaiduBannerAd.this.a.destroy();
                    }
                }
            });
            BaiduBannerAdapter.this.z = null;
        }
    }

    /* loaded from: classes.dex */
    public class BaiduNativeAd extends TTBaseAd {
        private XAdNativeResponse a;
        private FeedNativeView b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1767c = false;

        /* JADX WARN: Removed duplicated region for block: B:13:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01af  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public BaiduNativeAd(com.baidu.mobads.sdk.api.XAdNativeResponse r7) {
            /*
                Method dump skipped, instructions count: 481
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.BaiduNativeAd.<init>(com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter, com.baidu.mobads.sdk.api.XAdNativeResponse):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener a() {
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
                com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener) r0
                return r0
            L19:
                r0 = 93
                r1 = 93
                goto L6
            L1e:
                r1 = 91
                goto L10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.BaiduNativeAd.a():com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener");
        }

        private boolean d(NativeResponse nativeResponse) {
            return (TextUtils.isEmpty(nativeResponse.getAppVersion()) || TextUtils.isEmpty(nativeResponse.getPublisher()) || TextUtils.isEmpty(nativeResponse.getAppPrivacyLink()) || TextUtils.isEmpty(nativeResponse.getAppPermissionLink())) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            if (this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                a().onAdShow();
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public View getAdView() {
            return this.b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.f1767c;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            return (this.a == null || BaiduBannerAdapter.this.z == null || !this.a.isAdAvailable(BaiduBannerAdapter.this.z)) ? GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            super.onDestroy();
            this.f1767c = true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onPause() {
            super.onPause();
            XAdNativeResponse xAdNativeResponse = this.a;
            if (xAdNativeResponse == null || xAdNativeResponse.getDownloadStatus() < 0 || this.a.getDownloadStatus() > 100 || !d(this.a)) {
                return;
            }
            this.a.pauseAppDownload();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onResume() {
            super.onResume();
            XAdNativeResponse xAdNativeResponse = this.a;
            if (xAdNativeResponse != null && xAdNativeResponse.getDownloadStatus() == 102 && d(this.a)) {
                this.a.resumeAppDownload();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0154 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0173 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0170 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0150 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0154 -> B:21:0x0159). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x015b -> B:30:0x0167). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0164 -> B:30:0x0167). Please submit an issue!!! */
        @Override // com.bytedance.msdk.base.TTBaseAd
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void registerViewForInteraction(@androidx.annotation.NonNull android.view.ViewGroup r18, java.util.List<android.view.View> r19, java.util.List<android.view.View> r20, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder r21) {
            /*
                Method dump skipped, instructions count: 382
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.BaiduNativeAd.registerViewForInteraction(android.view.ViewGroup, java.util.List, java.util.List, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder):void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void render() {
            super.render();
            XAdNativeResponse xAdNativeResponse = this.a;
            if (xAdNativeResponse == null || !BaiduAdapterUtil.isNativeSmartOpt(xAdNativeResponse.getStyleType())) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu native render失败，代码位不是模版类型的");
                BaiduBannerAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_CODE_RENDER_TYPE_MISMATCH_MSG));
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            FeedNativeView feedNativeView = this.b;
            if (feedNativeView != null) {
                arrayList.add(feedNativeView);
            }
            this.a.registerViewForInteraction(this.b, arrayList, arrayList2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.BaiduNativeAd.4
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposed() {
                    BaiduNativeAd.this.f();
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu native ad express ....... onAdExposed");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposureFailed(int i2) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu native ad express ....... onAdExposeFailed: " + i2);
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADStatusChanged() {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu native ad express ....... onAdStatusChanged");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdClick() {
                    if (BaiduNativeAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                        BaiduNativeAd.this.a().onAdClicked();
                    }
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu native express ad ....... onAdClick");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdUnionClick() {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "banner混出 Baidu native ad express ....... onAdUnionClick");
                }
            });
            BaiduBannerAdapter.this.notifyAdLoaded(this);
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, final GMDislikeCallback gMDislikeCallback) {
            this.a.setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerAdapter.BaiduNativeAd.5
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                public void onDislikeClick() {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelById(BaiduBannerAdapter.this.getAdapterRit(), BaiduBannerAdapter.this.getAdSlotId()) + "Baidu native ad express ....... onDislikeClick");
                    GMDislikeCallback gMDislikeCallback2 = gMDislikeCallback;
                    if (gMDislikeCallback2 != null) {
                        gMDislikeCallback2.onSelected(0, "百度智能优选dislike接口无关闭原因");
                    }
                    if (BaiduNativeAd.this.mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                        BaiduNativeAd.this.a().onAdClosed();
                    }
                }
            });
        }
    }

    private void E() {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(this.z, getAdSlotId());
        GMAdSlotBaiduOption gMAdSlotBaiduOption = this.mGMAdSlotBanner.getGMAdSlotBaiduOption();
        if (gMAdSlotBaiduOption != null) {
            this.C = gMAdSlotBaiduOption.getBaiduNativeSmartOptStyleParams();
            String appSid = gMAdSlotBaiduOption.getAppSid();
            if (!TextUtils.isEmpty(appSid)) {
                baiduNativeManager.setAppSid(appSid);
            }
        }
        this.A = this.mGMAdSlotBanner.isMuted();
        int[] bannerSize = getBannerSize(this.mGMAdSlotBanner.getBannerSize(), this.mGMAdSlotBanner);
        boolean z = false;
        int i2 = bannerSize[0];
        int i3 = bannerSize[1];
        RequestParameters.Builder builder = new RequestParameters.Builder();
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
        if (i2 > 0 && i3 > 0) {
            builder.setWidth(i2).setHeight(i3);
        }
        baiduNativeManager.setCacheVideoOnlyWifi((gMAdSlotBaiduOption == null || gMAdSlotBaiduOption.isCacheVideoOnlyWifi()) ? true : true);
        if (gMAdSlotBaiduOption == null || gMAdSlotBaiduOption.isCacheVideoOnlyWifi()) {
            baiduNativeManager.setCacheVideoOnlyWifi(true);
        }
        baiduNativeManager.loadFeedAd(builder.build(), this.D);
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

    @Override // com.bytedance.msdk.adapter.ad.GMBannerBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        this.z = context;
        if (this.mGMAdSlotBanner == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
        } else if (map != null) {
            Object obj = map.get("tt_ad_sub_type");
            if (obj == null || ((Integer) obj).intValue() != 4) {
                new BaiduBannerAd().b();
                return;
            }
            Object obj2 = map.get("tt_ad_origin_type");
            if (obj2 != null) {
                int intValue = ((Integer) obj2).intValue();
                if (intValue == 1) {
                    this.B = true;
                } else if (intValue != 2) {
                    notifyAdFailed(new AdError(AdError.ERROR_MEDIA_CODE_RENDER_TYPE_MISMATCH_MSG));
                    return;
                } else {
                    this.B = false;
                }
                E();
            }
        }
    }
}
