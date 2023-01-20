package e.l.f;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.baidu.BaiduNetworkRequestInfo;
import com.bytedance.msdk.adapter.gdt.GdtNetworkRequestInfo;
import com.bytedance.msdk.adapter.pangle.PangleNetworkRequestInfo;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.GMAdConfig;
import com.bytedance.msdk.api.v2.GMGdtOption;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import com.bytedance.msdk.api.v2.GMPangleOption;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import com.jihuanshe.R;
import com.jihuanshe.model.GlobalConfig;
import com.vector.util.Res;
import e.l.r.o0;
import e.t.u.f;

/* loaded from: classes2.dex */
public final class a {
    @k.e.a.d
    public static final a a = new a();
    @k.e.a.d
    public static final String b = "AdManager";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f12010c;

    /* renamed from: e.l.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0386a {
        void a(@k.e.a.d String str, @k.e.a.d String str2);

        void b(@k.e.a.d String str, @k.e.a.d String str2);

        void c(@k.e.a.d GMSplashAd gMSplashAd);

        void onAdClick();

        void onAdDismiss();

        void onAdShow();

        void onAdSkip();
    }

    /* loaded from: classes2.dex */
    public static final class b extends GMPrivacyConfig {
        @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
        public boolean appList() {
            return false;
        }

        @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
        public boolean isCanUseLocation() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements GMSplashAdListener {
        public final /* synthetic */ InterfaceC0386a a;

        public c(InterfaceC0386a interfaceC0386a) {
            this.a = interfaceC0386a;
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdClicked() {
            this.a.onAdClick();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdDismiss() {
            this.a.onAdDismiss();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShow() {
            this.a.onAdShow();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShowFail(@k.e.a.d AdError adError) {
            InterfaceC0386a interfaceC0386a = this.a;
            String valueOf = String.valueOf(adError.code);
            String str = adError.message;
            if (str == null) {
                str = "";
            }
            interfaceC0386a.a(valueOf, str);
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdSkip() {
            this.a.onAdSkip();
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements GMSplashAdLoadCallback {
        public final /* synthetic */ InterfaceC0386a a;
        public final /* synthetic */ GMSplashAd b;

        public d(InterfaceC0386a interfaceC0386a, GMSplashAd gMSplashAd) {
            this.a = interfaceC0386a;
            this.b = gMSplashAd;
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onAdLoadTimeout() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onSplashAdLoadFail(@k.e.a.d AdError adError) {
            InterfaceC0386a interfaceC0386a = this.a;
            String valueOf = String.valueOf(adError.code);
            String str = adError.message;
            if (str == null) {
                str = "";
            }
            interfaceC0386a.b(valueOf, str);
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onSplashAdLoadSuccess() {
            this.a.c(this.b);
        }
    }

    private a() {
    }

    private final GMNetworkRequestInfo a() {
        GMNetworkRequestInfo pangleNetworkRequestInfo;
        o0 o0Var = o0.f14291c;
        GlobalConfig u = o0Var.u();
        String gromoreBottomType = u == null ? null : u.getGromoreBottomType();
        if (gromoreBottomType != null) {
            int hashCode = gromoreBottomType.hashCode();
            if (hashCode != 98810) {
                if (hashCode != 102199) {
                    if (hashCode != 93498907 || !gromoreBottomType.equals("baidu")) {
                        return null;
                    }
                    GlobalConfig u2 = o0Var.u();
                    String adSdkAppId = u2 == null ? null : u2.getAdSdkAppId();
                    GlobalConfig u3 = o0Var.u();
                    pangleNetworkRequestInfo = new BaiduNetworkRequestInfo(adSdkAppId, u3 != null ? u3.getGromoreBottomAdId() : null);
                } else if (!gromoreBottomType.equals("gdt")) {
                    return null;
                } else {
                    GlobalConfig u4 = o0Var.u();
                    String adSdkAppId2 = u4 == null ? null : u4.getAdSdkAppId();
                    GlobalConfig u5 = o0Var.u();
                    pangleNetworkRequestInfo = new GdtNetworkRequestInfo(adSdkAppId2, u5 != null ? u5.getGromoreBottomAdId() : null);
                }
            } else if (!gromoreBottomType.equals(GlobalConfig.AD_TYPE_BYTEDANCE)) {
                return null;
            } else {
                GlobalConfig u6 = o0Var.u();
                String adSdkAppId3 = u6 == null ? null : u6.getAdSdkAppId();
                GlobalConfig u7 = o0Var.u();
                pangleNetworkRequestInfo = new PangleNetworkRequestInfo(adSdkAppId3, u7 != null ? u7.getGromoreBottomAdId() : null);
            }
            return pangleNetworkRequestInfo;
        }
        return null;
    }

    public final void b() {
        if (f12010c || !e.l.m.c.f14093c.s()) {
            return;
        }
        o0 o0Var = o0.f14291c;
        GlobalConfig u = o0Var.u();
        String adSdkAppId = u == null ? null : u.getAdSdkAppId();
        if (adSdkAppId == null || adSdkAppId.length() == 0) {
            return;
        }
        f12010c = true;
        Context b2 = e.t.a.b();
        GMAdConfig.Builder builder = new GMAdConfig.Builder();
        GlobalConfig u2 = o0Var.u();
        GMAdConfig.Builder appName = builder.setAppId(u2 == null ? null : u2.getAdSdkAppId()).setAppName(Res.w(Res.a, R.string.app_name, null, 2, null));
        String a2 = f.a.a();
        if (a2 == null) {
            a2 = "";
        }
        GMMediationAdSdk.initialize(b2, appName.setPublisherDid(a2).setDebug(false).setPangleOption(new GMPangleOption.Builder().setDirectDownloadNetworkType(4, 1).setAllowShowNotify(true).setIsUseTextureView(true).build()).setGdtOption(new GMGdtOption.Builder().setWxInstalled(false).setOpensdkVer(null).setSupportH265(false).setSupportSplashZoomout(false).build()).setPrivacyConfig(new b()).build());
    }

    public final void c(@k.e.a.d Activity activity, @k.e.a.d InterfaceC0386a interfaceC0386a) {
        if (!f12010c) {
            interfaceC0386a.b("-10086", "sdk is not initialized.");
            return;
        }
        GlobalConfig u = o0.f14291c.u();
        GMSplashAd gMSplashAd = new GMSplashAd(activity, String.valueOf(u == null ? null : u.getGromoreAdId()));
        gMSplashAd.setAdSplashListener(new c(interfaceC0386a));
        e.l.q.c.p0.d dVar = e.l.q.c.p0.d.a;
        gMSplashAd.loadAd(new GMAdSlotSplash.Builder().setImageAdSize(dVar.f(activity), (int) ((dVar.e(activity) * 664) / 844.0f)).setSplashPreLoad(true).setMuted(false).setVolume(1.0f).build(), a(), new d(interfaceC0386a, gMSplashAd));
    }
}
