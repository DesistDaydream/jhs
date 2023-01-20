package com.jihuanshe.ui.page.login;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.page.main.MainActivityCreator;
import com.jihuanshe.ui.page.user.edit.EditUserActivity;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import com.jihuanshe.utils.ImManager;
import com.jihuanshe.utils.ImagePicker;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import com.jihuanshe.wxapi.WXTool;
import com.jyn.vcview.VerificationCodeView;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import com.yalantis.ucrop.UCrop;
import e.g.d.a;
import e.l.k.g1;
import e.l.r.r;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.k;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.t1;
import i.b.b1;
import i.b.i;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class LoginActivity extends BaseActivity<LoginViewModel> {
    @d
    private static final String J = "LoginActivity";
    private static final int K = 0;
    @d
    private final g A;
    @d
    private final VerificationCodeView.b B;
    @d
    private final g C;
    @d
    private final ImagePicker D;
    @d
    private final g E;
    @d
    private final g F;
    @e
    private TextView G;
    @d
    private final SpannableStringBuilder n;
    @d
    private final LinkMovementMethod o;
    @d
    private final e.t.r.a.a p;
    @d
    private final h.m2.e q;
    @d
    private final h.m2.e r;
    @d
    private final h.m2.e s;
    @d
    private String t;
    @e
    private String u;
    @d
    private final g v;
    @d
    private final g w;
    @d
    private final g x;
    @e
    private User y;
    @d
    private final e.t.j.h.e z;
    public static final /* synthetic */ n<Object>[] I = {n0.r(new PropertyReference1Impl(n0.d(LoginActivity.class), "et", "getEt()Landroid/widget/EditText;")), n0.r(new PropertyReference1Impl(n0.d(LoginActivity.class), "bindEt", "getBindEt()Landroid/widget/EditText;")), n0.r(new PropertyReference1Impl(n0.d(LoginActivity.class), "nameEt", "getNameEt()Landroid/widget/EditText;"))};
    @d
    public static final a H = new a(null);
    private static final int L = 1;
    private static final int M = 2;
    private static final int N = 3;
    private static final int O = 4;
    private static final int P = 5;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public static /* synthetic */ void b() {
        }

        @k
        public static /* synthetic */ void d() {
        }

        @k
        public static /* synthetic */ void f() {
        }

        @k
        public static /* synthetic */ void h() {
        }

        @k
        public static /* synthetic */ void j() {
        }

        @k
        public static /* synthetic */ void l() {
        }

        public final int a() {
            return LoginActivity.N;
        }

        public final int c() {
            return LoginActivity.O;
        }

        public final int e() {
            return LoginActivity.P;
        }

        public final int g() {
            return LoginActivity.L;
        }

        public final int i() {
            return LoginActivity.M;
        }

        public final int k() {
            return LoginActivity.K;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@d View view) {
            CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=service_agreement").start(LoginActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@d TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends ClickableSpan {
        public c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@d View view) {
            CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=privacy_policy").start(LoginActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@d TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    public LoginActivity() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Res.w(Res.a, R.string.login_private_tips, null, 2, null));
        spannableStringBuilder.setSpan(new b(), 7, 15, 18);
        spannableStringBuilder.setSpan(new c(), 17, 23, 18);
        t1 t1Var = t1.a;
        this.n = spannableStringBuilder;
        this.o = new LinkMovementMethod();
        this.p = new e.t.r.a.a(0, 0, 3, null);
        this.q = BindViewKt.n(this, R.id.phoneLayout);
        this.r = BindViewKt.n(this, R.id.bindPhoneEt);
        this.s = BindViewKt.n(this, R.id.nameEt);
        this.t = "";
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.v = dVar.a(new LoginActivity$onLogin$1(this));
        this.w = dVar.a(new LoginActivity$onClickBindSuc$1(this));
        this.x = dVar.a(new LoginActivity$onSendCode$1(this));
        this.z = d.b.a.a(new LoginActivity$onChecked$1(this));
        this.A = dVar.a(new LoginActivity$checkedBtn$1(this));
        this.B = new VerificationCodeView.b() { // from class: com.jihuanshe.ui.page.login.LoginActivity$onVerify$1
            @Override // com.jyn.vcview.VerificationCodeView.b
            public void a(@e View view, @e String str) {
            }

            @Override // com.jyn.vcview.VerificationCodeView.b
            public void b(@e View view, @e String str) {
                String str2;
                a j2;
                a o;
                a k2;
                String str3;
                User user;
                Integer value = ((LoginViewModel) LoginActivity.this.L()).getType().getValue();
                int c2 = LoginActivity.H.c();
                if (value != null && value.intValue() == c2) {
                    LoginViewModel loginViewModel = (LoginViewModel) LoginActivity.this.L();
                    str3 = LoginActivity.this.t;
                    if (str == null) {
                        str = "";
                    }
                    user = LoginActivity.this.y;
                    BinderKt.p(BinderKt.k(a.j(loginViewModel.B0(str3, str, user == null ? null : user.getToken()), null, new LoginActivity$onVerify$1$onComplete$1(LoginActivity.this), 1, null), LoginActivity.this, false, 2, null));
                    return;
                }
                LoginViewModel loginViewModel2 = (LoginViewModel) LoginActivity.this.L();
                str2 = LoginActivity.this.t;
                if (str == null) {
                    str = "";
                }
                a<User> M0 = loginViewModel2.M0(str2, str);
                if (M0 == null || (j2 = a.j(M0, null, new LoginActivity$onVerify$1$onComplete$2(LoginActivity.this), 1, null)) == null || (o = a.o(j2, null, new LoginActivity$onVerify$1$onComplete$3(view), 1, null)) == null || (k2 = BinderKt.k(o, LoginActivity.this, false, 2, null)) == null) {
                    return;
                }
                BinderKt.p(k2);
            }
        };
        this.C = dVar.a(new LoginActivity$onClickResend$1(this));
        this.D = new ImagePicker(this, 0, 0.0f, new LoginActivity$imagePicker$1(this), 6, (u) null);
        this.E = dVar.a(new LoginActivity$onClickAvatar$1(this));
        this.F = dVar.a(new LoginActivity$onClickUpdate$1(this));
    }

    public static final int D0() {
        return H.a();
    }

    public static final int E0() {
        return H.c();
    }

    public static final int F0() {
        return H.e();
    }

    public static final int G0() {
        return H.g();
    }

    public static final int H0() {
        return H.i();
    }

    public static final int I0() {
        return H.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(User user) {
        UserKV userKV = UserKV.f3913c;
        userKV.C(user);
        String token = user.getToken();
        if (token == null) {
            token = "";
        }
        userKV.B(token);
        String sig = user.getSig();
        userKV.A(sig != null ? sig : "");
        ImManager.k(ImManager.a, false, 1, null);
        if (isTaskRoot()) {
            MainActivityCreator.create().start(this);
        }
        r.a.b();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText o0() {
        return (EditText) this.r.a(this, I[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText q0() {
        return (EditText) this.q.a(this, I[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText s0() {
        return (EditText) this.s.a(this, I[2]);
    }

    @k.e.a.d
    public final VerificationCodeView.b A0() {
        return this.B;
    }

    @k.e.a.d
    public final SpannableStringBuilder B0() {
        return this.n;
    }

    @k.e.a.d
    public final e.t.r.a.a C0() {
        return this.p;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        m(R.color.white);
        WXTool.a.d().f(this, new LoginActivity$flowOfSetup$1(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        this.G = w().getMid().g(LoginActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 69) {
            i.f(LifecycleOwnerKt.getLifecycleScope(this), b1.c(), null, new LoginActivity$onActivityResult$1(intent, this, null), 2, null);
        } else if (i3 == 96) {
            Throwable error = UCrop.getError(intent);
            e.l.h.k.b bVar = e.l.h.k.b.a;
            String simpleName = EditUserActivity.class.getSimpleName();
            String message = error != null ? error.getMessage() : null;
            if (message == null) {
                message = "";
            }
            bVar.b(simpleName, message);
            e.l.h.j.b.e.h(this, "裁剪失败", null, null, null, 0, null, 62, null);
        }
    }

    @k.e.a.d
    public final g p0() {
        return this.A;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        g1 e2 = g1.e(getLayoutInflater());
        e2.i(this);
        e2.j((LoginViewModel) L());
        return e2;
    }

    @k.e.a.d
    public final LinkMovementMethod r0() {
        return this.o;
    }

    @k.e.a.d
    public final e.t.j.h.e t0() {
        return this.z;
    }

    @k.e.a.d
    public final g u0() {
        return this.E;
    }

    @k.e.a.d
    public final g v0() {
        return this.w;
    }

    @k.e.a.d
    public final g w0() {
        return this.C;
    }

    @k.e.a.d
    public final g x0() {
        return this.F;
    }

    @k.e.a.d
    public final g y0() {
        return this.v;
    }

    @k.e.a.d
    public final g z0() {
        return this.x;
    }
}
