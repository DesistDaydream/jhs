package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.n;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.i0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.v;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.a;
import com.baidu.mobads.sdk.internal.bc;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConfig;
import com.bytedance.msdk.api.v2.GMAdConfig;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import com.bytedance.msdk.api.v2.IGMLiveTokenInjectionAuth;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class d {
    private static long a;
    private static boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static Runnable f984c = new c();

    /* renamed from: d  reason: collision with root package name */
    private static long f985d;

    /* renamed from: e  reason: collision with root package name */
    private static j f986e;

    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean unused = d.b = true;
            long unused2 = d.a = SystemClock.elapsedRealtime();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a(this.a.getApplicationContext());
            e0.a(this.a);
            h0.c();
            d.j();
            p.a(this.a);
            r.a(this.a);
            v.m(this.a);
            g.c().b();
            d.i();
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a()) {
                d.e(this.a);
            } else {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a().b();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c().b();
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().b(true);
            d.g();
            d.l();
            d.g(this.a);
            d.m();
            if (Logger.isDebug()) {
                ThreadHelper.runOnMSDKThread(d.f984c);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.a(this.a);
            r.a(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Logger.d("TMe", "--==-- queueSize: " + ((ThreadPoolExecutor) ThreadHelper.getMSDKExecutor()).getQueue().size());
            ThreadHelper.postDelayOnMSDKThread(d.f984c, 5000L);
        }
    }

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0046d implements j.b {
        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.j.b
        public void a() {
            Logger.d("TTMediationSDK", "--==-- AppStateListener on foreground");
            long unused = d.f985d = SystemClock.elapsedRealtime();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.j.b
        public void b() {
            Logger.d("TTMediationSDK", "--==-- AppStateListener on background");
            h.a(SystemClock.elapsedRealtime() - d.f985d);
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a()) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.a();
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a().a();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c().a();
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements Runnable {
        public final /* synthetic */ StackTraceElement[] a;

        public e(StackTraceElement[] stackTraceElementArr) {
            this.a = stackTraceElementArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b(this.a);
        }
    }

    @Deprecated
    private static void a(TTAdConfig tTAdConfig) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(System.currentTimeMillis());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(tTAdConfig.getAppId());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b(tTAdConfig.getAppName());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().d(tTAdConfig.isPangleAllowShowNotify());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().e(tTAdConfig.isPangleAllowShowPageWhenScreenLock());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b(tTAdConfig.getPangleTitleBarTheme());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(tTAdConfig.getPangleDirectDownloadNetworkType());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(tTAdConfig.getPangleNeedClearTaskReset());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().g(tTAdConfig.isPangleUseTextureView());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().f(tTAdConfig.isPanglePaid());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().f(tTAdConfig.getPublisherDid());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().c(tTAdConfig.isOpenAdnTest());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().d(tTAdConfig.getPangleData());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(tTAdConfig.getExtraData());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(tTAdConfig.getPrivacyConfig());
        n();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(tTAdConfig.getAdapterConfigurationClasses());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().c(tTAdConfig.getMediatedNetworkConfigurations());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().d(tTAdConfig.getRequestOptions());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(tTAdConfig.getUserInfoForSegment(), true);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(tTAdConfig.getPanglePluginUpdateConfig());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().e(tTAdConfig.getPangleKeywords());
    }

    @Deprecated
    public static void a(@NonNull TTAdConfig tTAdConfig, Context context) {
        a(null, tTAdConfig, context);
    }

    private static void a(GMAdConfig gMAdConfig) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(System.currentTimeMillis());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMAdConfig.getAppId());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b(gMAdConfig.getAppName());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().d(gMAdConfig.getGMPangleOption().isAllowShowNotify());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().e(gMAdConfig.getGMPangleOption().isAllowShowPageWhenScreenLock());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b(gMAdConfig.getGMPangleOption().getTitleBarTheme());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMAdConfig.getGMPangleOption().getDirectDownloadNetworkType());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMAdConfig.getGMPangleOption().getNeedClearTaskReset());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().g(gMAdConfig.getGMPangleOption().isIsUseTextureView());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().f(gMAdConfig.getGMPangleOption().isPaid());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().f(gMAdConfig.getPublisherDid());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().c(gMAdConfig.isOpenAdnTest());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().d(gMAdConfig.getGMPangleOption().getData());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMAdConfig.getGMPangleOption().getExtraData());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMAdConfig.getPrivacyConfig());
        n();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMAdConfig.getGMConfigUserInfoForSegment(), true);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMAdConfig.getGMPangleOption().getPluginUpdateConfig());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().e(gMAdConfig.getGMPangleOption().getKeywords());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b(gMAdConfig.getLocalExtra());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMAdConfig.isHttps());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b(gMAdConfig.isOpenPangleCustom());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMAdConfig.getCutstomLocalConfig());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().j(gMAdConfig.getGMGdtOption().isWxInstalled());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().c(gMAdConfig.getGMGdtOption().getOpensdkVer());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().h(gMAdConfig.getGMGdtOption().isSupportH265());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().i(gMAdConfig.getGMGdtOption().isSupportSplashZoomout());
        if (gMAdConfig.getGromoreExtra() != null) {
            try {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a((List) gMAdConfig.getGromoreExtra().get(GMAdConstant.GM_EXTRA_KEY_PRIME_RIT_LIST));
            } catch (Throwable unused) {
            }
        }
        a(gMAdConfig.getGmLiveTokenInjectionAuth());
    }

    public static void a(@NonNull GMAdConfig gMAdConfig, Context context) {
        a(gMAdConfig, null, context);
    }

    private static void a(GMAdConfig gMAdConfig, TTAdConfig tTAdConfig, Context context) {
        d(context);
        if (gMAdConfig != null) {
            a(gMAdConfig);
        } else if (tTAdConfig != null) {
            a(tTAdConfig);
        }
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().q()) {
            f(context);
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().p();
        c(context);
    }

    public static void a(GMPrivacyConfig gMPrivacyConfig) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(gMPrivacyConfig);
        n();
    }

    private static void a(IGMLiveTokenInjectionAuth iGMLiveTokenInjectionAuth) {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        try {
            Map<String, ITTAdapterConfiguration> e2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
            if (e2 == null || e2.size() <= 0 || (iTTAdapterConfiguration = e2.get(DefaultAdapterClasses.getClassNameByAdnName("pangle"))) == null) {
                return;
            }
            iTTAdapterConfiguration.setInjectionAuth(iGMLiveTokenInjectionAuth);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StackTraceElement[] stackTraceElementArr) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().t()) {
            Map<String, String> e2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().e();
            h.a((TTBaseAd) null, (AdSlot) null, t.a(stackTraceElementArr), 1);
            h.b(t.a(e2));
        }
    }

    private static void c(Context context) {
        Logger.e("TTMediationSDK_SDK_Init", "msdk_init v2.............");
        ThreadHelper.runOnThreadPool(new a(context));
    }

    public static void d(Context context) {
        if (context != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context) {
        int i2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().i();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.a(new a.b().a(new l()).a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a.a(i2, i2, bc.f1470e)).a(false).a(new m()).a(n.b).a(), context);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.c();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.b();
    }

    private static void f(Context context) {
        Logger.e("TTMediationSDK_SDK_Init", "msdk_init v1.............");
        b = true;
        a = SystemClock.elapsedRealtime();
        e0.a(context);
        h0.c();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a(context.getApplicationContext());
        j();
        ThreadHelper.runOnThreadPool(new b(context));
        v.m(context);
        g.c().b();
        i();
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a()) {
            e(context);
        } else {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a().b();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c().b();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().b(true);
        g();
        l();
        g(context);
        m();
        if (Logger.isDebug()) {
            ThreadHelper.runOnMSDKThread(f984c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.d()) {
            Logger.d("TMe", "-----==---- 正常上报sdk_init");
            h.b(-1L);
        } else {
            Logger.d("TMe", "-----==---- 延时上报sdk_init");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.e();
        }
        if (i0.b(context)) {
            h.a();
        }
    }

    public static long h() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        try {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(true);
        } catch (Throwable th) {
            Logger.e("TTMediationSDK", "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        Context d2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        if (d2 != null) {
            try {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b().a().a(d2, false, true, new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a(d2));
            } catch (Exception unused) {
            }
        }
    }

    public static boolean k() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        Application a2 = a.b.a();
        if (a2 == null) {
            Logger.d("TTMediationSDK", "AppStateListener注册失败, app = null");
            return;
        }
        Logger.d("TTMediationSDK", "AppStateListener注册成功");
        j jVar = f986e;
        if (jVar != null) {
            jVar.a(a2);
        }
        j jVar2 = new j();
        f986e = jVar2;
        jVar2.a(a2, new C0046d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().x()) {
            b(stackTrace);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new e(stackTrace), 2000L);
        }
    }

    private static void n() {
        ITTAdapterConfiguration value;
        try {
            Map<String, ITTAdapterConfiguration> e2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
            if (e2 == null || e2.size() <= 0) {
                return;
            }
            for (Map.Entry<String, ITTAdapterConfiguration> entry : e2.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.setPrivacyConfig(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s());
                }
            }
        } catch (Throwable unused) {
        }
    }
}
