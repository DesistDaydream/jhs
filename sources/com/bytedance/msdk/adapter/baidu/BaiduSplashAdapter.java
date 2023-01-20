package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.SplashDismissController;
import com.bytedance.msdk.adapter.ad.GMSplashBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.BaiduRequestParameters;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BaiduSplashAdapter extends GMSplashBaseAdapter {
    private BaiduRequestParameters A;
    private GMAdSlotBaiduOption B;
    private int C = 3000;
    private SplashDismissController D;
    private boolean E;
    private BaiduSplashAd F;
    private SplashAd G;
    private Context z;

    /* loaded from: classes.dex */
    public class BaiduSplashAd extends TTBaseAd implements SplashInteractionListener {
        private SplashAd a;
        public FrameLayout b;

        public BaiduSplashAd() {
            this.b = new FrameLayout(BaiduSplashAdapter.this.z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JProtect
        public ITTAdapterSplashAdListener a() {
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
            return (ITTAdapterSplashAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        @JProtect
        public void onADLoaded() {
            StringBuilder sb;
            String str;
            for (char c2 = 16; c2 != 14; c2 = 14) {
            }
            if (this.a != null) {
                if (BaiduSplashAdapter.this.isClientBidding()) {
                    double d2 = 0.0d;
                    try {
                        d2 = Double.valueOf(this.a.getECPMLevel()).doubleValue();
                    } catch (Exception unused) {
                    }
                    setCpm(d2);
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagThirdLevelById(BaiduSplashAdapter.this.getAdapterRit(), BaiduSplashAdapter.this.getAdSlotId()));
                    str = "Baidu_cientBidding splash 返回的 cpm价格：";
                } else if (BaiduSplashAdapter.this.isMultiBidding()) {
                    setLevelTag(this.a.getECPMLevel());
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagThirdLevelById(BaiduSplashAdapter.this.getAdapterRit(), BaiduSplashAdapter.this.getAdSlotId()));
                    str = "Baidu_多阶底价 splash 返回的 价格标签：";
                }
                sb.append(str);
                sb.append(this.a.getECPMLevel());
                Logger.d("TTMediationSDK_ECMP", sb.toString());
            }
            BaiduSplashAdapter.this.notifyAdLoaded(this);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
            BaiduSplashAdapter.this.E = false;
            Logger.e("TTMediationSDK", "baidu_splash_onAdCacheFailed");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
            BaiduSplashAdapter.this.E = true;
            Logger.e("TTMediationSDK", "baidu_splash_onAdCacheSuccess");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        @JProtect
        public void onAdClick() {
            if (this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                if (BaiduSplashAdapter.this.D != null) {
                    BaiduSplashAdapter.this.D.setClick(true);
                    BaiduSplashAdapter.this.D.setCallBack(new SplashDismissController.CallBack() { // from class: com.bytedance.msdk.adapter.baidu.BaiduSplashAdapter.BaiduSplashAd.1
                        @Override // com.bytedance.msdk.adapter.SplashDismissController.CallBack
                        public void onResume() {
                            if (BaiduSplashAdapter.this.D == null || !BaiduSplashAdapter.this.D.jumpToAdPage() || BaiduSplashAdapter.this.D.isCallDismiss() || !(BaiduSplashAd.this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener)) {
                                return;
                            }
                            BaiduSplashAd.this.a().onAdDismiss();
                        }
                    });
                }
                a().onAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        @JProtect
        public void onAdDismissed() {
            if (!(this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener)) {
                return;
            }
            if (BaiduSplashAdapter.this.D != null && BaiduSplashAdapter.this.D.jumpToAdPage()) {
                return;
            }
            if (BaiduSplashAdapter.this.D != null) {
                BaiduSplashAdapter.this.D.setCallDismiss(true);
            }
            a().onAdDismiss();
            char c2 = '_';
            while (true) {
                char c3 = '^';
                while (true) {
                    if (c3 == '`') {
                        if (c2 != ')') {
                            if (c2 != '*') {
                                return;
                            }
                        }
                    }
                    c2 = '(';
                    c3 = '`';
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        @JProtect
        public void onAdFailed(String str) {
            BaiduSplashAdapter.this.notifyAdFailed(new AdError(str));
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
            if (r2 != '8') goto L11;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x001f -> B:14:0x0022). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:5:0x0010 -> B:6:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0014 -> B:14:0x0022). Please submit an issue!!! */
        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onAdPresent() {
            /*
                r3 = this;
                com.bytedance.msdk.adapter.listener.ITTAdatperCallback r0 = r3.mTTAdatperCallback
                boolean r0 = r0 instanceof com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
                r1 = 95
                if (r0 == 0) goto L10
                com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener r0 = r3.a()
                r0.onAdShow()
                goto L22
            L10:
                r0 = 95
                r2 = 95
            L14:
                switch(r0) {
                    case 94: goto L10;
                    case 95: goto L18;
                    case 96: goto L1d;
                    default: goto L17;
                }
            L17:
                goto L22
            L18:
                switch(r2) {
                    case 94: goto L10;
                    case 95: goto L1c;
                    case 96: goto L10;
                    default: goto L1b;
                }
            L1b:
                goto L1d
            L1c:
                return
            L1d:
                r0 = 56
                if (r2 == r0) goto L22
                goto L10
            L22:
                r0 = 94
                r2 = 125(0x7d, float:1.75E-43)
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduSplashAdapter.BaiduSplashAd.onAdPresent():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            SplashAd splashAd = this.a;
            if (splashAd != null) {
                splashAd.destroy();
                this.a = null;
            }
            FrameLayout frameLayout = this.b;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            BaiduSplashAdapter.this.D = null;
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        @JProtect
        public void onLpClosed() {
            if (this.mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                if (BaiduSplashAdapter.this.D == null || !BaiduSplashAdapter.this.D.jumpToAdPage()) {
                    if (BaiduSplashAdapter.this.D != null) {
                        BaiduSplashAdapter.this.D.setCallDismiss(true);
                    }
                    a().onAdDismiss();
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
        }

        public void setSplashAd(SplashAd splashAd) {
            this.a = splashAd;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        @JProtect
        public void showSplashAd(ViewGroup viewGroup) {
            if (this.a == null || viewGroup == null) {
                return;
            }
            viewGroup.removeAllViews();
            this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.b.setVisibility(0);
            viewGroup.addView(this.b);
            this.a.show(this.b);
        }
    }

    private RequestParameters E(GMAdSlotBase gMAdSlotBase) {
        if (!(gMAdSlotBase instanceof GMAdSlotSplash)) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return null;
        }
        RequestParameters build = new RequestParameters.Builder().addExtra("timeout", String.valueOf(this.C)).build();
        if (this.A != null) {
            RequestParameters.Builder downloadAppConfirmPolicy = new RequestParameters.Builder().setHeight(this.A.getHeight()).setWidth(this.A.getWidth()).downloadAppConfirmPolicy(this.A.getAPPConfirmPolicy());
            HashMap<String, Object> hashMap = this.A.toHashMap();
            if (!hashMap.containsKey("timeout")) {
                hashMap.put("timeout", String.valueOf(this.C));
            }
            if (hashMap != null) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    try {
                        downloadAppConfirmPolicy.addExtra(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                    } catch (Throwable unused) {
                    }
                }
            }
            return downloadAppConfirmPolicy.build();
        }
        return build;
    }

    private void G(Context context, String str, RequestParameters requestParameters) {
        if (this.F == null) {
            this.F = new BaiduSplashAd();
        }
        if (this.G == null) {
            this.G = new SplashAd(context, str, requestParameters, this.F);
        }
        this.F.setSplashAd(this.G);
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
        RequestParameters E = E(gMAdSlotBase);
        if (E != null) {
            G(context, str, E);
            return this.G.getBiddingToken();
        }
        Logger.e("TTMediationSDK", "Baidu splash getBiddingToken RequestParameters is null");
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

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd A[LOOP:0: B:39:0x00ad->B:46:0x00bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0098 -> B:32:0x009a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x009b -> B:38:0x00a9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a2 -> B:39:0x00ad). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ad -> B:38:0x00a9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00b1 -> B:38:0x00a9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00b6 -> B:39:0x00ad). Please submit an issue!!! */
    @Override // com.bytedance.msdk.adapter.ad.GMSplashBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r6, java.util.Map<java.lang.String, java.lang.Object> r7) {
        /*
            r5 = this;
            super.loadAd(r6, r7)
            r5.z = r6
            com.bytedance.msdk.api.v2.slot.GMAdSlotSplash r0 = r5.mGMAdSlotSplash
            r1 = 80
            r2 = 8
            r3 = 9
            if (r0 == 0) goto L95
            if (r7 == 0) goto Lb5
            boolean r0 = r6 instanceof android.app.Activity
            if (r0 == 0) goto L1f
            com.bytedance.msdk.adapter.SplashDismissController r0 = new com.bytedance.msdk.adapter.SplashDismissController
            r4 = r6
            android.app.Activity r4 = (android.app.Activity) r4
            r0.<init>(r4)
            r5.D = r0
        L1f:
            com.bytedance.msdk.api.v2.slot.GMAdSlotSplash r0 = r5.mGMAdSlotSplash
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption r0 = r0.getGMAdSlotBaiduOption()
            r5.B = r0
            if (r0 == 0) goto L36
            com.bytedance.msdk.api.BaiduExtraOptions r0 = r0.getBaiduExtra()
            com.bytedance.msdk.api.BaiduRequestParameters r4 = r0.getBaiduRequestParameters()
            r5.A = r4
            r0.getBaiduSplashParams()
        L36:
            java.lang.String r0 = "ad_load_timeout"
            boolean r4 = r7.containsKey(r0)
            if (r4 == 0) goto L4f
            java.lang.Object r4 = r7.get(r0)
            if (r4 == 0) goto L4f
            java.lang.Object r7 = r7.get(r0)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            goto L51
        L4f:
            int r7 = r5.C
        L51:
            r5.C = r7
            java.lang.String r7 = r5.getAdSlotId()
            com.bytedance.msdk.api.v2.slot.GMAdSlotBase r0 = r5.mGMAdSlotBase
            com.baidu.mobads.sdk.api.RequestParameters r0 = r5.E(r0)
            r5.G(r6, r7, r0)
            com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption r6 = r5.B
            if (r6 == 0) goto L7b
            com.bytedance.msdk.api.BaiduExtraOptions r6 = r6.getBaiduExtra()
            if (r6 == 0) goto L6f
            java.lang.String r6 = r6.getAppSid()
            goto L70
        L6f:
            r6 = 0
        L70:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L7b
            com.baidu.mobads.sdk.api.SplashAd r7 = r5.G
            r7.setAppSid(r6)
        L7b:
            java.lang.String r6 = r5.getAdm()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L8b
            com.baidu.mobads.sdk.api.SplashAd r6 = r5.G
            r6.load()
            goto La9
        L8b:
            com.baidu.mobads.sdk.api.SplashAd r6 = r5.G
            java.lang.String r7 = r5.getAdm()
            r6.loadBiddingAd(r7)
            goto Lb6
        L95:
            r5.notifyLoadFailBecauseGMAdSlotIsNull()
        L98:
            r6 = 9
        L9a:
            r7 = 7
            if (r6 == r7) goto La9
            if (r6 == r2) goto La2
            if (r6 == r3) goto Lb5
            goto L98
        La2:
            r6 = 61
            r6 = 80
            r7 = 61
            goto Lad
        La9:
            r6 = 79
            r7 = 8
        Lad:
            switch(r6) {
                case 79: goto Lbb;
                case 80: goto Lb1;
                case 81: goto La9;
                default: goto Lb0;
            }
        Lb0:
            goto Lbd
        Lb1:
            switch(r7) {
                case 59: goto Lb6;
                case 60: goto Lb5;
                case 61: goto Lb5;
                default: goto Lb4;
            }
        Lb4:
            goto La9
        Lb5:
            return
        Lb6:
            r7 = 60
            r6 = 80
            goto Lad
        Lbb:
            r6 = r7
            goto L9a
        Lbd:
            r6 = 81
            goto Lad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduSplashAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
