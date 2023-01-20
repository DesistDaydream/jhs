package com.jihuanshe.ui.page.web;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.page.web.CommonWebViewActivity;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.vector.ext.bind.BindViewKt;
import com.vector.view.WebViewEx;
import e.l.k.e0;
import e.t.j.h.b0;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.i0;
import e.t.j.h.q;
import e.t.j.h.r;
import e.t.j.h.v;
import e.t.j.h.z;
import e.t.p.a;
import e.t.u.t;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import h.t1;
import inject.annotation.creator.Creator;
import java.util.HashMap;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class CommonWebViewActivity extends BaseActivity<e.l.s.p.a> {
    @d
    public static final String D = "CommonWebViewActivity";
    @d
    private static final String E = "setAppBar";
    @d
    private static final String F = "getParams";
    @d
    private static final String G = "getPhoto";
    @d
    private static final String H = "login";
    @d
    private static final String I = "uploadLog";
    public static final int J = 1;
    public static final int K = 2;
    @d
    private final q A;
    @d
    private final g p;
    @d
    private final l<Intent, t1> q;
    @d
    private final h.k2.u.a<t1> r;
    @d
    private final g s;
    @f.a.a.a(true)
    private boolean showHeard;
    @d
    private final g t;
    @d
    private final b0 u;
    @d
    private final i0 v;
    @d
    private final e.n.l w;
    @d
    private final z x;
    @d
    private final v y;
    @d
    private final r z;
    public static final /* synthetic */ n<Object>[] C = {n0.r(new PropertyReference1Impl(n0.d(CommonWebViewActivity.class), "webView", "getWebView()Lcom/vector/view/WebViewEx;"))};
    @d
    public static final a B = new a(null);
    @f.a.a.a(true)
    @d
    private String urlTitle = "";
    @f.a.a.a
    @d
    private String url = "";
    @d
    private final HashMap<String, e.l.q.b.m.b> n = new HashMap<>();
    @d
    private final e o = BindViewKt.n(this, R.id.web_view);

    @Keep
    /* loaded from: classes2.dex */
    public final class LaguJSInterface {
        public LaguJSInterface() {
            CommonWebViewActivity.this = r1;
        }

        /* renamed from: onShowContactUsDialog$lambda-0 */
        public static final void m32onShowContactUsDialog$lambda0(CommonWebViewActivity commonWebViewActivity) {
            commonWebViewActivity.h0().invoke();
        }

        @JavascriptInterface
        @Keep
        public final void callAppFunction(@d String str) {
            e.l.q.b.m.b bVar;
            try {
                e.l.h.k.b.a.a(CommonWebViewActivity.D, f0.C("callAppFuncation json: ", str));
                WebRequest webRequest = (WebRequest) a.C0416a.b(e.t.p.a.f14605d, null, false, 3, null).g(str, WebRequest.class);
                if (webRequest != null && (bVar = CommonWebViewActivity.this.a0().get(webRequest.getAction())) != null) {
                    CommonWebViewActivity commonWebViewActivity = CommonWebViewActivity.this;
                    bVar.a(commonWebViewActivity, commonWebViewActivity.p0(), webRequest);
                }
            } catch (Exception e2) {
                e.l.h.k.b.a.b(CommonWebViewActivity.D, String.valueOf(e2.getMessage()));
            }
        }

        @JavascriptInterface
        @Keep
        public final void onShowContactUsDialog() {
            final CommonWebViewActivity commonWebViewActivity = CommonWebViewActivity.this;
            commonWebViewActivity.runOnUiThread(new Runnable() { // from class: e.l.q.b.m.a
                @Override // java.lang.Runnable
                public final void run() {
                    CommonWebViewActivity.LaguJSInterface.m32onShowContactUsDialog$lambda0(commonWebViewActivity);
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements l<Intent, t1> {
        public b() {
            CommonWebViewActivity.this = r1;
        }

        public void a(@k.e.a.e Intent intent) {
            try {
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                intent2.addCategory("android.intent.category.OPENABLE");
                intent2.setType("image/*");
                CommonWebViewActivity.this.startActivityForResult(intent2, 2);
            } catch (Exception e2) {
                e.l.h.k.b.a.g(CommonWebViewActivity.D, Log.getStackTraceString(e2));
            }
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Intent intent) {
            a(intent);
            return t1.a;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements h.k2.u.a<t1> {
        public void a() {
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            a();
            return t1.a;
        }
    }

    public CommonWebViewActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.p = dVar.a(new CommonWebViewActivity$onClickFinish$1(this));
        this.q = new b();
        this.r = new c();
        this.s = dVar.a(new CommonWebViewActivity$onClickBack$1(this));
        this.t = dVar.a(CommonWebViewActivity$onRightClick$1.INSTANCE);
        d.k kVar = d.k.a;
        this.u = kVar.e(new CommonWebViewActivity$onProgressChange$1(this));
        this.v = kVar.f(new CommonWebViewActivity$onWebTitleChange$1(this));
        this.w = new e.n.l(0);
        this.x = new z(new CommonWebViewActivity$onPageStart$1(this));
        this.y = new v(new CommonWebViewActivity$onLoadEnd$1(this));
        this.z = kVar.b(new CommonWebViewActivity$onLoading$1(this));
        this.A = kVar.a(new CommonWebViewActivity$onLoadSchemeUri$1(this));
    }

    private final void Y() {
        p0().setOnClickChoosePhoto(this.q);
        p0().c(new LaguJSInterface(), "jihuanshe");
    }

    public final void q0(String str) {
        e.l.s.p.a aVar = (e.l.s.p.a) L();
        aVar.B0().setValue(Boolean.valueOf(!aVar.p0(str)));
    }

    public final void r0() {
        ((e.l.s.p.a) L()).r0().p();
        ((e.l.s.p.a) L()).s0().p();
        ((e.l.s.p.a) L()).D0().p();
    }

    private final void t0() {
        p0().setUserAgentString(Build.PRODUCT + Attributes.InternalPrefix + t.a.d() + ' ' + p0().getUserAgentString());
    }

    @k.e.a.d
    public final e.n.l Z() {
        return this.w;
    }

    @k.e.a.d
    public final HashMap<String, e.l.q.b.m.b> a0() {
        return this.n;
    }

    @k.e.a.d
    public final g b0() {
        return this.s;
    }

    @k.e.a.d
    public final l<Intent, t1> c0() {
        return this.q;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        t0();
        Y();
        p0().getWebView().setBackgroundColor(0);
        ((e.l.s.p.a) L()).F0().setValue(Boolean.valueOf(!this.showHeard));
        ((e.l.s.p.a) L()).C0().setValue(this.urlTitle);
    }

    @k.e.a.d
    public final g d0() {
        return this.p;
    }

    @k.e.a.d
    public final v e0() {
        return this.y;
    }

    @k.e.a.d
    public final q f0() {
        return this.A;
    }

    @k.e.a.d
    public final r g0() {
        return this.z;
    }

    @k.e.a.d
    public final h.k2.u.a<t1> h0() {
        return this.r;
    }

    @k.e.a.d
    public final z i0() {
        return this.x;
    }

    @k.e.a.d
    public final b0 j0() {
        return this.u;
    }

    @k.e.a.d
    public final g k0() {
        return this.t;
    }

    @k.e.a.d
    public final i0 l0() {
        return this.v;
    }

    public final boolean m0() {
        return this.showHeard;
    }

    @k.e.a.d
    public final String n0() {
        return this.url;
    }

    @k.e.a.d
    public final String o0() {
        return this.urlTitle;
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @k.e.a.e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2) {
            p0().p(i2, i3, intent);
            return;
        }
        e.l.q.b.m.b bVar = this.n.get(G);
        if (bVar == null) {
            return;
        }
        bVar.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (p0().d()) {
            p0().j();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        p0().i();
        super.onDestroy();
    }

    @k.e.a.d
    public final WebViewEx p0() {
        return (WebViewEx) this.o.a(this, C[0]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        e0 e2 = e0.e(getLayoutInflater());
        e2.i(this);
        e2.j((e.l.s.p.a) L());
        return e2;
    }

    public final void s0(boolean z) {
        this.showHeard = z;
    }

    public final void u0(@k.e.a.d String str) {
        this.url = str;
    }

    public final void v0(@k.e.a.d String str) {
        this.urlTitle = str;
    }
}
