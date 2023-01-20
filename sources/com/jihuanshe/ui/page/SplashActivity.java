package com.jihuanshe.ui.page;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jihuanshe.R;
import com.jihuanshe.model.GlobalConfig;
import com.jihuanshe.model.GlobalConfigKt;
import com.jihuanshe.ui.dialog.PrivateDialog;
import com.jihuanshe.ui.page.main.MainActivity;
import com.jihuanshe.ui.page.main.MainActivityCreator;
import com.jihuanshe.ui.widget.CountDownTextView;
import com.jihuanshe.viewmodel.SplashViewModel;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageBean;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.network.image.NImageView;
import com.vector.util.UIUtil;
import e.l.f.a;
import e.l.m.c;
import e.l.q.b.f.g;
import e.l.r.o0;
import e.l.r.q0;
import e.n.f;
import e.t.j.g.e0;
import e.t.j.g.y;
import e.t.o.d;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.r0;
import h.t1;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class SplashActivity extends AppCompatActivity {
    @d
    public static final a o;
    public static final /* synthetic */ n<Object>[] p;
    @d
    private static final String q = "SplashActivity";
    @e
    private OfflineMessageBean b;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4002h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4003i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4004j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4005k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4006l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4007m;
    @e
    private String n;
    @d
    private final w a = z.c(new SplashActivity$viewModel$2(this));
    @d

    /* renamed from: c  reason: collision with root package name */
    private final h.m2.e f3997c = BindViewKt.n(this, R.id.root);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final h.m2.e f3998d = BindViewKt.n(this, R.id.adContainer);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final h.m2.e f3999e = BindViewKt.n(this, R.id.posterView);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final h.m2.e f4000f = BindViewKt.n(this, R.id.posterIv);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final h.m2.e f4001g = BindViewKt.n(this, R.id.countDownTv);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements a.InterfaceC0386a {
        public b() {
        }

        @Override // e.l.f.a.InterfaceC0386a
        public void a(@d String str, @d String str2) {
            e.l.h.k.b.a.d(SplashActivity.q, f0.C("splash ad show fail. ", str2));
            SplashActivity.this.B();
        }

        @Override // e.l.f.a.InterfaceC0386a
        public void b(@d String str, @d String str2) {
            e.l.h.k.b.a.b(SplashActivity.q, f0.C("onAdLoadFail. msg = ", str2));
            SplashActivity.this.B();
        }

        @Override // e.l.f.a.InterfaceC0386a
        public void c(@d GMSplashAd gMSplashAd) {
            ViewKt.I(SplashActivity.this.z());
            gMSplashAd.showAd(SplashActivity.this.u());
            SplashActivity.this.F(gMSplashAd.getAdNetworkPlatformId() == 6);
        }

        @Override // e.l.f.a.InterfaceC0386a
        public void onAdClick() {
            SplashActivity.this.G(true);
        }

        @Override // e.l.f.a.InterfaceC0386a
        public void onAdDismiss() {
            if (SplashActivity.this.D() && SplashActivity.this.f4007m && SplashActivity.this.v()) {
                return;
            }
            SplashActivity.this.B();
        }

        @Override // e.l.f.a.InterfaceC0386a
        public void onAdShow() {
            e.l.h.k.b.a.d(SplashActivity.q, "splash ad showed.");
            c.f14093c.y(System.currentTimeMillis());
        }

        @Override // e.l.f.a.InterfaceC0386a
        public void onAdSkip() {
            e.l.h.k.b.a.d(SplashActivity.q, "onAdSkip");
            SplashActivity.this.B();
        }
    }

    static {
        n<Object>[] nVarArr = new n[6];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SplashActivity.class), "rootView", "getRootView()Landroid/view/View;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(SplashActivity.class), "adContainer", "getAdContainer()Landroid/widget/FrameLayout;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(SplashActivity.class), "posterContainer", "getPosterContainer()Landroid/widget/FrameLayout;"));
        nVarArr[4] = n0.r(new PropertyReference1Impl(n0.d(SplashActivity.class), "posterIv", "getPosterIv()Lcom/vector/network/image/NImageView;"));
        nVarArr[5] = n0.r(new PropertyReference1Impl(n0.d(SplashActivity.class), "countDownTv", "getCountDownTv()Lcom/jihuanshe/ui/widget/CountDownTextView;"));
        p = nVarArr;
        o = new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B() {
        /*
            r2 = this;
            com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageBean r0 = r2.b
            if (r0 == 0) goto L8
            r2.C()
            goto L2e
        L8:
            boolean r0 = r2.isTaskRoot()
            if (r0 != 0) goto L1e
            java.lang.String r0 = r2.n
            if (r0 == 0) goto L1b
            int r0 = r0.length()
            if (r0 != 0) goto L19
            goto L1b
        L19:
            r0 = 0
            goto L1c
        L1b:
            r0 = 1
        L1c:
            if (r0 != 0) goto L2b
        L1e:
            com.jihuanshe.ui.page.main.MainActivityCreator r0 = com.jihuanshe.ui.page.main.MainActivityCreator.create()
            java.lang.String r1 = r2.n
            com.jihuanshe.ui.page.main.MainActivityCreator r0 = r0.routeUrl(r1)
            r0.start(r2)
        L2b:
            r2.finish()
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.page.SplashActivity.B():void");
    }

    private final void C() {
        if (V2TIMManager.getInstance().getLoginStatus() == 3) {
            Intent intent = new Intent(this, MainActivity.class);
            if (getIntent() != null) {
                intent.putExtras(getIntent());
            }
            startActivity(intent);
            finish();
            return;
        }
        setIntent(null);
        NotificationManager notificationManager = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        if (this.b.action == 1) {
            if (TextUtils.isEmpty(this.b.sender)) {
                return;
            }
            g.a(this, this.b.sender, this.b.nickname);
            finish();
            return;
        }
        if (isTaskRoot()) {
            MainActivityCreator.create().start(this);
        }
        finish();
    }

    private final void E() {
        String stringExtra = getIntent().getStringExtra("route");
        this.n = stringExtra;
        boolean z = false;
        if (stringExtra == null || stringExtra.length() == 0) {
            this.n = getIntent().getDataString();
        }
        String str = this.n;
        if (str == null || str.length() == 0) {
            String stringExtra2 = getIntent().getStringExtra("custom_content");
            if ((stringExtra2 == null || stringExtra2.length() == 0) ? true : true) {
                return;
            }
            try {
                Result.a aVar = Result.Companion;
                this.n = new JSONObject(stringExtra2).optString("route");
                Result.m106constructorimpl(t1.a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                Result.m106constructorimpl(r0.a(th));
            }
        }
    }

    private final void H() {
        if (GlobalConfigKt.isPoster(o0.f14291c.u())) {
            J();
            c.f14093c.y(System.currentTimeMillis());
            return;
        }
        I();
    }

    private final void I() {
        e.l.f.a.a.c(this, new b());
    }

    private final void J() {
        ViewKt.I(x());
        ViewKt.B(y(), new SplashActivity$tryShowPoster$1(this));
        NImageView y = y();
        GlobalConfig u = o0.f14291c.u();
        y.a(y, u == null ? null : u.getPosterUrl(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        e0.u(w(), UIUtil.c() + d.a.c(e.t.o.d.a, null, 1, null).d(26));
        ViewKt.B(w(), new SplashActivity$tryShowPoster$2(this));
        w().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout u() {
        return (FrameLayout) this.f3998d.a(this, p[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CountDownTextView w() {
        return (CountDownTextView) this.f4001g.a(this, p[5]);
    }

    private final FrameLayout x() {
        return (FrameLayout) this.f3999e.a(this, p[3]);
    }

    private final NImageView y() {
        return (NImageView) this.f4000f.a(this, p[4]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View z() {
        return (View) this.f3997c.a(this, p[1]);
    }

    @k.e.a.d
    public final SplashViewModel A() {
        return (SplashViewModel) this.a.getValue();
    }

    public final boolean D() {
        return this.f4004j;
    }

    public final void F(boolean z) {
        this.f4004j = z;
    }

    public final void G(boolean z) {
        this.f4005k = z;
    }

    public final void d() {
        if (this.f4002h) {
            H();
            return;
        }
        c cVar = c.f14093c;
        boolean z = false;
        if (!cVar.s()) {
            this.f4003i = true;
            PrivateDialog privateDialog = new PrivateDialog(this, new SplashActivity$flowOfSetup$1(this), new SplashActivity$flowOfSetup$2(this));
            privateDialog.setDismissOnTouchOutside(false);
            privateDialog.setCancelable(false);
            privateDialog.y();
        } else {
            if (this.b == null) {
                String str = this.n;
                if (((str == null || str.length() == 0) ? true : true) && cVar.u()) {
                    H();
                }
            }
            this.f4003i = true;
        }
        A().u0().f(this, new SplashActivity$flowOfSetup$4(this));
        A().r0().f(this, new SplashActivity$flowOfSetup$5(this));
        f.g(A().t0(), null, new SplashActivity$flowOfSetup$6(this), 1, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@e Bundle bundle) {
        super.onCreate(bundle);
        this.f4002h = getIntent().getBooleanExtra("forceShowAd", false);
        this.b = m.a.d(getIntent());
        E();
        if (!isTaskRoot() && !this.f4002h) {
            B();
            return;
        }
        setContentView(R.layout.activity_splash);
        d();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f4007m = true;
        q0.a.b(SplashActivity.class.getSimpleName());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q0.a.c(SplashActivity.class.getSimpleName());
        if (this.f4006l && c.f14093c.s()) {
            B();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        w().e();
        this.f4006l = c.f14093c.s();
    }

    public final boolean v() {
        return this.f4005k;
    }
}
