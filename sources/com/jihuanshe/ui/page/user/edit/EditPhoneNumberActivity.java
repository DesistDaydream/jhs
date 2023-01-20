package com.jihuanshe.ui.page.user.edit;

import android.view.View;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.user.edit.EditPhoneNumberViewModel;
import com.jyn.vcview.VerificationCodeView;
import com.vector.ext.bind.BindViewKt;
import e.g.d.a;
import e.l.k.k0;
import e.n.f;
import e.t.j.h.g;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import inject.annotation.creator.Creator;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class EditPhoneNumberActivity extends BaseActivity<EditPhoneNumberViewModel> {
    @d
    private static final String A = "EditPhoneNumberActivity";
    private final int n;
    private final int o = 1;
    private final int p = 2;
    private final int q = 3;
    private final int r = 4;
    @d
    private final e s = BindViewKt.n(this, R.id.bindPhoneEt);
    @k.e.a.e
    private String t;
    @d
    private final g u;
    @d
    private final g v;
    @d
    private final g w;
    @d
    private final VerificationCodeView.b x;
    public static final /* synthetic */ n<Object>[] z = {n0.r(new PropertyReference1Impl(n0.d(EditPhoneNumberActivity.class), "et", "getEt()Landroid/widget/EditText;"))};
    @d
    public static final a y = new a(null);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public EditPhoneNumberActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.u = dVar.a(new EditPhoneNumberActivity$onClickBindSuc$1(this));
        this.v = dVar.a(new EditPhoneNumberActivity$onSendCode$1(this));
        this.w = dVar.a(new EditPhoneNumberActivity$onClickResend$1(this));
        this.x = new VerificationCodeView.b() { // from class: com.jihuanshe.ui.page.user.edit.EditPhoneNumberActivity$onVerify$1
            @Override // com.jyn.vcview.VerificationCodeView.b
            public void a(@k.e.a.e View view, @k.e.a.e String str) {
            }

            @Override // com.jyn.vcview.VerificationCodeView.b
            public void b(@k.e.a.e View view, @k.e.a.e String str) {
                String str2;
                String str3;
                Integer value = ((EditPhoneNumberViewModel) EditPhoneNumberActivity.this.L()).getType().getValue();
                int f0 = EditPhoneNumberActivity.this.f0();
                if (value != null && value.intValue() == f0) {
                    EditPhoneNumberViewModel editPhoneNumberViewModel = (EditPhoneNumberViewModel) EditPhoneNumberActivity.this.L();
                    str3 = EditPhoneNumberActivity.this.t;
                    if (str3 == null) {
                        str3 = "";
                    }
                    if (str == null) {
                        str = "";
                    }
                    BinderKt.p(BinderKt.k(a.j(editPhoneNumberViewModel.S0(str3, str), null, new EditPhoneNumberActivity$onVerify$1$onComplete$1(EditPhoneNumberActivity.this), 1, null), EditPhoneNumberActivity.this, false, 2, null));
                    return;
                }
                EditPhoneNumberViewModel editPhoneNumberViewModel2 = (EditPhoneNumberViewModel) EditPhoneNumberActivity.this.L();
                str2 = EditPhoneNumberActivity.this.t;
                if (str2 == null) {
                    str2 = "";
                }
                if (str == null) {
                    str = "";
                }
                BinderKt.p(BinderKt.k(a.o(a.j(editPhoneNumberViewModel2.T0(str2, str), null, new EditPhoneNumberActivity$onVerify$1$onComplete$2(EditPhoneNumberActivity.this, view), 1, null), null, new EditPhoneNumberActivity$onVerify$1$onComplete$3(view), 1, null), EditPhoneNumberActivity.this, false, 2, null));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText Z() {
        return (EditText) this.s.a(this, z[0]);
    }

    @d
    public final g a0() {
        return this.u;
    }

    @d
    public final g b0() {
        return this.w;
    }

    @d
    public final g c0() {
        return this.v;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        m(R.color.white);
        ((EditPhoneNumberViewModel) L()).getType().setValue(Integer.valueOf(this.n));
        f.g(((EditPhoneNumberViewModel) L()).getType(), null, new EditPhoneNumberActivity$flowOfSetup$1(this), 1, null);
    }

    @d
    public final VerificationCodeView.b d0() {
        return this.x;
    }

    public final int e0() {
        return this.p;
    }

    public final int f0() {
        return this.q;
    }

    public final int g0() {
        return this.r;
    }

    public final int h0() {
        return this.o;
    }

    public final int i0() {
        return this.n;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(EditPhoneNumberActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        k0 e2 = k0.e(getLayoutInflater());
        e2.i(this);
        e2.j((EditPhoneNumberViewModel) L());
        return e2;
    }
}
