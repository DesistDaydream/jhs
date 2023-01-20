package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeToBannerListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.views.RefreshableBannerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class i {
    private int a;
    private final Activity b;

    /* renamed from: c  reason: collision with root package name */
    private final String f708c;

    /* renamed from: d  reason: collision with root package name */
    private AdSlot f709d;

    /* renamed from: e  reason: collision with root package name */
    private GMAdSlotBase f710e;

    /* renamed from: f  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d f711f;

    /* renamed from: g  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d f712g;

    /* renamed from: h  reason: collision with root package name */
    private RefreshableBannerView f713h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f714i;

    /* renamed from: j  reason: collision with root package name */
    private final Handler f715j;

    /* renamed from: k  reason: collision with root package name */
    private GMBannerAdListener f716k;

    /* renamed from: l  reason: collision with root package name */
    private GMNativeToBannerListener f717l;

    /* renamed from: m  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f718m;
    private final GMBannerAdListener n;
    private final Runnable o;

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (i.this.a == 0) {
                return;
            }
            i.this.s();
            i.this.t();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            i.this.r();
        }
    }

    /* loaded from: classes.dex */
    public class b implements GMBannerAdListener {
        public b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClicked() {
            if (i.this.f716k != null) {
                i.this.f716k.onAdClicked();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClosed() {
            i.this.r();
            if (i.this.f716k != null) {
                i.this.f716k.onAdClosed();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdLeftApplication() {
            if (i.this.f716k != null) {
                i.this.f716k.onAdLeftApplication();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdOpened() {
            if (i.this.f716k != null) {
                i.this.f716k.onAdOpened();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShow() {
            if (i.this.f716k != null) {
                i.this.f716k.onAdShow();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShowFail(AdError adError) {
            if (i.this.f716k != null) {
                i.this.f716k.onAdShowFail(adError);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.i$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0031a implements Runnable {
                public RunnableC0031a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f711f != null) {
                        i.this.f711f.B();
                    }
                    i iVar = i.this;
                    iVar.f711f = iVar.f712g;
                    i.this.s();
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.a == 0 || i.this.f712g == null) {
                    return;
                }
                View e0 = i.this.f712g.e0();
                if (e0 != null) {
                    if (i.this.f713h != null) {
                        i.this.f713h.a(e0);
                    }
                    i.this.f715j.postDelayed(new RunnableC0031a(), 250L);
                } else {
                    if (i.this.f712g != null) {
                        i.this.f712g.B();
                    }
                    i.this.s();
                }
                i.this.t();
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f715j.post(new a());
        }
    }

    /* loaded from: classes.dex */
    public class d implements RefreshableBannerView.c {
        public d() {
        }

        @Override // com.bytedance.msdk.core.views.RefreshableBannerView.c
        public void a(boolean z) {
            if (!z) {
                i.this.r();
            } else if (i.this.a == 0) {
            } else {
                i.this.t();
            }
        }
    }

    public i(Activity activity, String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c2;
        String str2;
        this.a = 0;
        a aVar = new a();
        this.f718m = aVar;
        this.n = new b();
        this.o = new c();
        this.b = activity;
        this.f708c = str;
        this.f711f = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d(activity, str);
        if (activity != null) {
            RefreshableBannerView refreshableBannerView = new RefreshableBannerView(activity);
            this.f713h = refreshableBannerView;
            refreshableBannerView.addOnAttachStateChangeListener(aVar);
            this.f713h.setVisibilityChangeListener(new d());
        }
        this.f714i = new Handler(ThreadHelper.getMSDKThreadLooper());
        this.f715j = new Handler(Looper.getMainLooper());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d f2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f();
        if (f2 == null || (c2 = f2.c(str)) == null) {
            return;
        }
        int n = c2.n();
        if (n < 10000 || n > 180000) {
            str2 = "---==-----banner轮播时间下发不在10*1000～180*1000范围内：" + n + "，禁止banner轮播";
        } else {
            this.a = n;
            str2 = "---==-----banner轮播时间：" + this.a;
        }
        Logger.d("TMe", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f714i.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d(this.b, this.f708c);
        this.f712g = dVar;
        dVar.a(this.n);
        this.f712g.a(this.f717l);
        this.f712g.a(this.f709d, this.f710e, (GMBannerAdLoadCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f714i.removeCallbacksAndMessages(null);
        this.f714i.postDelayed(this.o, this.a);
    }

    public void a() {
        this.f715j.removeCallbacksAndMessages(null);
        r();
        RefreshableBannerView refreshableBannerView = this.f713h;
        if (refreshableBannerView != null) {
            refreshableBannerView.removeOnAttachStateChangeListener(this.f718m);
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            dVar.B();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar2 = this.f712g;
        if (dVar2 != null) {
            dVar2.B();
        }
    }

    public void a(AdSlot adSlot, GMAdSlotBase gMAdSlotBase, GMBannerAdLoadCallback gMBannerAdLoadCallback) {
        this.f709d = adSlot;
        this.f710e = gMAdSlotBase;
        this.f711f.a(adSlot, gMAdSlotBase, gMBannerAdLoadCallback);
    }

    public void a(GMBannerAdListener gMBannerAdListener) {
        this.f716k = gMBannerAdListener;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            dVar.a(this.n);
        }
    }

    public void a(GMNativeToBannerListener gMNativeToBannerListener) {
        this.f717l = gMNativeToBannerListener;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            dVar.a(gMNativeToBannerListener);
        }
    }

    public void a(boolean z) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    public List<AdLoadInfo> b() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        return dVar != null ? dVar.C() : new ArrayList();
    }

    public int c() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            return dVar.E();
        }
        return -2;
    }

    @NonNull
    public String d() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            return dVar.F();
        }
        return null;
    }

    @Nullable
    public View e() {
        RefreshableBannerView refreshableBannerView;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            dVar.b((TTBaseAd) null);
            View e0 = this.f711f.e0();
            if (e0 == null || (refreshableBannerView = this.f713h) == null) {
                return null;
            }
            refreshableBannerView.removeAllViews();
            ViewParent parent = e0.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(e0);
            }
            this.f713h.addView(e0);
            return this.f713h;
        }
        return null;
    }

    public GMAdEcpmInfo f() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public List<GMAdEcpmInfo> g() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public Map<String, Object> h() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        return dVar != null ? dVar.G() : new HashMap();
    }

    public List<GMAdEcpmInfo> i() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            return dVar.f();
        }
        return null;
    }

    @NonNull
    public String j() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            return dVar.H();
        }
        return null;
    }

    public int k() {
        return this.a;
    }

    public GMAdEcpmInfo l() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            return dVar.J();
        }
        return null;
    }

    public String m() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            return dVar.l();
        }
        return null;
    }

    @VisibleForTesting
    public boolean n() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            dVar.f0();
            return false;
        }
        return false;
    }

    public boolean o() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            return dVar.g0();
        }
        return false;
    }

    public void p() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            dVar.h0();
        }
    }

    public void q() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d dVar = this.f711f;
        if (dVar != null) {
            dVar.i0();
        }
    }
}
