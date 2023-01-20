package com.jihuanshe.ui.page.shop;

import android.content.Intent;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.BankDetail;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.utils.ImagePicker;
import com.jihuanshe.viewmodel.shop.SellerConfirmViewModel;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.l.k.g2;
import e.l.r.p;
import e.n.f;
import e.t.j.h.c0;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.k.a.f.h;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.w;
import h.z;
import i.b.b1;
import i.b.i;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.StringsKt__StringsKt;

@Creator
/* loaded from: classes2.dex */
public final class SellerConfirmActivity extends BaseActivity<SellerConfirmViewModel> {
    @d
    public static final a T;
    public static final /* synthetic */ n<Object>[] U;
    private static final int V = 100;
    @d
    private static final String W = "SellerConfirmActivity";
    @d
    private final g A;
    @d
    private final g B;
    private int C;
    @d
    private final g D;
    @d
    private final g E;
    @d
    private final g F;
    @d
    private final g G;
    @d
    private final g H;
    @e
    private String I;
    @d
    private String J;
    @d
    private String K;
    @d
    private String L;
    @d
    private final g M;
    @d
    private String N;
    @d
    private String O;
    @d
    private String P;
    @d
    private final g Q;
    @d
    private final ImagePicker R;
    @d
    private final w S;
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.tipsTv);
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.nameEt);
    @d
    private final h.m2.e p = BindViewKt.n(this, R.id.phoneEt);
    @d
    private final h.m2.e q = BindViewKt.n(this, R.id.codeEt);
    @d
    private final h.m2.e r = BindViewKt.n(this, R.id.datePick);
    @d
    private final h.m2.e s = BindViewKt.n(this, R.id.dateStartPick);
    @d
    private final h.m2.e t = BindViewKt.n(this, R.id.useBankAccountEt);
    @d
    private final h.m2.e u = BindViewKt.n(this, R.id.useBankAccountEt2);
    @d
    private final h.m2.e v = BindViewKt.n(this, R.id.cb);
    @d
    private final w w = z.c(SellerConfirmActivity$movementMethod$2.INSTANCE);
    @d
    private final w x = z.c(new SellerConfirmActivity$string2$2(this));
    @d
    private final c0 y = d.f.a.a(new SellerConfirmActivity$onChecked$1(this));
    @k.e.a.d
    private final g z;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        n<Object>[] nVarArr = new n[12];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(SellerConfirmActivity.class), "tipsTv", "getTipsTv()Landroid/widget/TextView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SellerConfirmActivity.class), "nameTv", "getNameTv()Landroid/widget/EditText;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(SellerConfirmActivity.class), "phoneEt", "getPhoneEt()Landroid/widget/EditText;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(SellerConfirmActivity.class), "codeEt", "getCodeEt()Landroid/widget/EditText;"));
        nVarArr[4] = n0.r(new PropertyReference1Impl(n0.d(SellerConfirmActivity.class), "dateTv", "getDateTv()Landroid/widget/TextView;"));
        nVarArr[5] = n0.r(new PropertyReference1Impl(n0.d(SellerConfirmActivity.class), "startDateTv", "getStartDateTv()Landroid/widget/TextView;"));
        nVarArr[6] = n0.r(new PropertyReference1Impl(n0.d(SellerConfirmActivity.class), "accountEt", "getAccountEt()Landroid/widget/EditText;"));
        nVarArr[7] = n0.r(new PropertyReference1Impl(n0.d(SellerConfirmActivity.class), "accountEt2", "getAccountEt2()Landroid/widget/EditText;"));
        nVarArr[8] = n0.r(new PropertyReference1Impl(n0.d(SellerConfirmActivity.class), "cb", "getCb()Landroid/widget/CheckBox;"));
        U = nVarArr;
        T = new a(null);
    }

    public SellerConfirmActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.z = dVar.a(new SellerConfirmActivity$onCommit$1(this));
        this.A = dVar.a(new SellerConfirmActivity$onChangeAccount$1(this));
        this.B = dVar.a(new SellerConfirmActivity$onCommitChangeAccount$1(this));
        this.D = dVar.a(new SellerConfirmActivity$onClickUploadFore$1(this));
        this.E = dVar.a(new SellerConfirmActivity$onClickUploadBack$1(this));
        this.F = dVar.a(new SellerConfirmActivity$onClickBank$1(this));
        this.G = dVar.a(new SellerConfirmActivity$onClickBankDetail$1(this));
        this.H = dVar.a(new SellerConfirmActivity$onClickBankLoc$1(this));
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = dVar.a(new SellerConfirmActivity$onChooseValidDate$1(this));
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = dVar.a(new SellerConfirmActivity$onChooseValidStartDate$1(this));
        this.R = new ImagePicker(this, 0, 0.0f, new SellerConfirmActivity$imagePicker$1(this), 6, (u) null);
        this.S = z.c(new SellerConfirmActivity$loadingDialog$2(this));
    }

    private final EditText B0() {
        return (EditText) this.o.a(this, U[1]);
    }

    private final EditText N0() {
        return (EditText) this.p.a(this, U[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView O0() {
        return (TextView) this.s.a(this, U[5]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Q0() {
        return (TextView) this.n.a(this, U[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(Uri uri) {
        if (uri == null) {
            return;
        }
        z0().W();
        i.f(LifecycleOwnerKt.getLifecycleScope(this), b1.c(), null, new SellerConfirmActivity$handleUri$1(uri, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0() {
        String str;
        String obj = B0().getText().toString();
        if (obj.length() == 0) {
            e.l.h.j.b.e.h(this, Res.w(Res.a, R.string.error_name_empty, null, 2, null), null, null, null, 0, null, 62, null);
            return;
        }
        String obj2 = N0().getText().toString();
        if (obj2.length() == 0) {
            e.l.h.j.b.e.h(this, Res.w(Res.a, R.string.error_phone_empty, null, 2, null), null, null, null, 0, null, 62, null);
            return;
        }
        String obj3 = x0().getText().toString();
        if (obj3.length() == 0) {
            e.l.h.j.b.e.h(this, "证件号码不能为空", null, null, null, 0, null, 62, null);
            return;
        }
        String obj4 = O0().getText().toString();
        if (obj4.length() == 0) {
            e.l.h.j.b.e.h(this, "证件起始日期不能为空", null, null, null, 0, null, 62, null);
            return;
        }
        if (f0.g(((SellerConfirmViewModel) L()).P0().getValue(), Boolean.TRUE)) {
            str = "长期";
        } else {
            str = y0().getText().toString();
            if (str.length() == 0) {
                e.l.h.j.b.e.h(this, "证件结束日期不能为空", null, null, null, 0, null, 62, null);
                return;
            }
        }
        String str2 = str;
        String value = ((SellerConfirmViewModel) L()).I0().getValue();
        String substring = value == null ? null : value.substring(StringsKt__StringsKt.r3(value, MqttTopic.TOPIC_LEVEL_SEPARATOR, 10, false, 4, null) + 1);
        if (substring == null) {
            e.l.h.j.b.e.h(this, "请先上传身份证正面照", null, null, null, 0, null, 62, null);
            return;
        }
        String value2 = ((SellerConfirmViewModel) L()).C0().getValue();
        String substring2 = value2 == null ? null : value2.substring(StringsKt__StringsKt.r3(value2, MqttTopic.TOPIC_LEVEL_SEPARATOR, 10, false, 4, null) + 1);
        if (substring2 == null) {
            e.l.h.j.b.e.h(this, "请先上传身份证背面照", null, null, null, 0, null, 62, null);
            return;
        }
        String value3 = ((SellerConfirmViewModel) L()).G0().getValue();
        if (value3 == null || value3.length() == 0) {
            e.l.h.j.b.e.h(this, "请先选择开户银行", null, null, null, 0, null, 62, null);
            return;
        }
        BankDetail value4 = ((SellerConfirmViewModel) L()).E0().getValue();
        if (f0.g(value3, "其他银行") && value4 == null) {
            e.l.h.j.b.e.h(this, "请输入开户行全称", null, null, null, 0, null, 62, null);
            return;
        }
        String str3 = this.I;
        if (str3 == null || str3.length() == 0) {
            e.l.h.j.b.e.h(this, "请先选择开户所在地", null, null, null, 0, null, 62, null);
            return;
        }
        String obj5 = u0().getText().toString();
        if (obj5.length() == 0) {
            e.l.h.j.b.e.h(this, "银行账号不能为空", null, null, null, 0, null, 62, null);
        } else if (!w0().isChecked()) {
            e.l.h.j.b.e.h(this, "请先阅读并同意卖家入驻协议", null, null, null, 0, null, 62, null);
        } else {
            BinderKt.p(BinderKt.k(e.g.d.a.j(((SellerConfirmViewModel) L()).S0(obj, obj2, obj3, obj4, str2, substring, substring2, value3, value4, this.I, h.t2.u.k2(obj5, ExpandableTextView.N, "", false, 4, null)), null, new SellerConfirmActivity$onCommit$2(this), 1, null), this, false, 2, null));
        }
    }

    private final EditText u0() {
        return (EditText) this.t.a(this, U[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText v0() {
        return (EditText) this.u.a(this, U[7]);
    }

    private final CheckBox w0() {
        return (CheckBox) this.v.a(this, U[8]);
    }

    private final EditText x0() {
        return (EditText) this.q.a(this, U[3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView y0() {
        return (TextView) this.r.a(this, U[4]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h z0() {
        return (h) this.S.getValue();
    }

    public final MovementMethod A0() {
        return (MovementMethod) this.w.getValue();
    }

    @k.e.a.d
    public final g C0() {
        return this.A;
    }

    @k.e.a.d
    public final c0 D0() {
        return this.y;
    }

    @k.e.a.d
    public final g E0() {
        return this.M;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(((SellerConfirmViewModel) L()).Q0(), this, false, false, 4, null);
    }

    @k.e.a.d
    public final g F0() {
        return this.Q;
    }

    @k.e.a.d
    public final g G0() {
        return this.F;
    }

    @k.e.a.d
    public final g H0() {
        return this.G;
    }

    @k.e.a.d
    public final g I0() {
        return this.H;
    }

    @k.e.a.d
    public final g J0() {
        return this.E;
    }

    @k.e.a.d
    public final g K0() {
        return this.D;
    }

    @k.e.a.d
    public final g L0() {
        return this.z;
    }

    @k.e.a.d
    public final g M0() {
        return this.B;
    }

    @k.e.a.d
    public final SpannableStringBuilder P0() {
        return (SpannableStringBuilder) this.x.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        ((SellerConfirmViewModel) L()).M0().f(this, new SellerConfirmActivity$flowOfSetup$1(this));
        ((SellerConfirmViewModel) L()).N0().f(this, new SellerConfirmActivity$flowOfSetup$2(this));
        ((SellerConfirmViewModel) L()).B0(this);
        e.g.d.a.o(((SellerConfirmViewModel) L()).A0(), null, new SellerConfirmActivity$flowOfSetup$3(this), 1, null);
        f.g(((SellerConfirmViewModel) L()).O0(), null, new SellerConfirmActivity$flowOfSetup$4(this), 1, null);
        u0().addTextChangedListener(new p(u0()));
        v0().addTextChangedListener(new p(v0()));
        F();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(SellerConfirmActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1) {
            ((SellerConfirmViewModel) L()).E0().r(intent == null ? null : (BankDetail) intent.getParcelableExtra("bank"));
        }
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        g2 e2 = g2.e(getLayoutInflater());
        e2.i(this);
        e2.j((SellerConfirmViewModel) L());
        return e2;
    }
}
