package com.jihuanshe.ui.page.user;

import android.content.Intent;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.BankDetail;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.utils.ImagePicker;
import com.vector.ext.bind.BindViewKt;
import e.l.k.q2;
import e.l.s.o.b;
import e.t.j.h.g;
import e.t.k.a.f.h;
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

@Creator
/* loaded from: classes2.dex */
public final class ShopOwnerConfirmActivity extends BaseActivity<b> {
    @d
    public static final a H;
    public static final /* synthetic */ n<Object>[] I;
    private static final int J = 100;
    @d
    private static final String K = "ShopOwnerConfirmActivity";
    @d
    private final g A;
    @d
    private final g B;
    @d
    private final g C;
    @d
    private final g D;
    @e
    private String E;
    @d
    private final g F;
    @d
    private final g G;
    @e
    private h w;
    private int y;
    @d
    private final g z;
    @d
    private final w n = z.c(new ShopOwnerConfirmActivity$string2$2(this));
    @d
    private final w o = z.c(ShopOwnerConfirmActivity$movementMethod$2.INSTANCE);
    @d
    private final h.m2.e p = BindViewKt.n(this, R.id.tipsTv);
    @d
    private final h.m2.e q = BindViewKt.n(this, R.id.nameEt);
    @d
    private final h.m2.e r = BindViewKt.n(this, R.id.phoneEt);
    @d
    private final h.m2.e s = BindViewKt.n(this, R.id.mailEt);
    @d
    private final h.m2.e t = BindViewKt.n(this, R.id.useBankBranchTv);
    @d
    private final h.m2.e u = BindViewKt.n(this, R.id.useBankAccountEt);
    @d
    private final h.m2.e v = BindViewKt.n(this, R.id.cb);
    @d
    private final ImagePicker x = new ImagePicker(this, 0, 0.0f, new ShopOwnerConfirmActivity$imagePicker$1(this), 6, (u) null);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        n<Object>[] nVarArr = new n[9];
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(ShopOwnerConfirmActivity.class), "tipsTv", "getTipsTv()Landroid/widget/TextView;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(ShopOwnerConfirmActivity.class), "nameTv", "getNameTv()Landroid/widget/EditText;"));
        nVarArr[4] = n0.r(new PropertyReference1Impl(n0.d(ShopOwnerConfirmActivity.class), "phoneEt", "getPhoneEt()Landroid/widget/EditText;"));
        nVarArr[5] = n0.r(new PropertyReference1Impl(n0.d(ShopOwnerConfirmActivity.class), "emailEt", "getEmailEt()Landroid/widget/EditText;"));
        nVarArr[6] = n0.r(new PropertyReference1Impl(n0.d(ShopOwnerConfirmActivity.class), "branch", "getBranch()Landroid/widget/EditText;"));
        nVarArr[7] = n0.r(new PropertyReference1Impl(n0.d(ShopOwnerConfirmActivity.class), "accountEt", "getAccountEt()Landroid/widget/EditText;"));
        nVarArr[8] = n0.r(new PropertyReference1Impl(n0.d(ShopOwnerConfirmActivity.class), "cb", "getCb()Landroid/widget/CheckBox;"));
        I = nVarArr;
        H = new a(null);
    }

    public ShopOwnerConfirmActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.z = dVar.a(new ShopOwnerConfirmActivity$onClickUploadFore$1(this));
        this.A = dVar.a(new ShopOwnerConfirmActivity$onClickUploadBack$1(this));
        this.B = dVar.a(new ShopOwnerConfirmActivity$onClickUploadLicense$1(this));
        this.C = dVar.a(new ShopOwnerConfirmActivity$onClickBank$1(this));
        this.D = dVar.a(new ShopOwnerConfirmActivity$onClickBankDetail$1(this));
        this.F = dVar.a(new ShopOwnerConfirmActivity$onClickBankLoc$1(this));
        this.G = dVar.a(new ShopOwnerConfirmActivity$onCommit$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText j0() {
        return (EditText) this.u.a(this, I[7]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText k0() {
        return (EditText) this.t.a(this, I[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckBox l0() {
        return (CheckBox) this.v.a(this, I[8]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText m0() {
        return (EditText) this.s.a(this, I[5]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText o0() {
        return (EditText) this.q.a(this, I[3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText w0() {
        return (EditText) this.r.a(this, I[4]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView y0() {
        return (TextView) this.p.a(this, I[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(Uri uri) {
        if (uri == null) {
            return;
        }
        h hVar = this.w;
        if (hVar != null) {
            hVar.n();
        }
        h hVar2 = new h(this, false, 2, null);
        this.w = hVar2;
        if (hVar2 != null) {
            hVar2.W();
        }
        i.f(LifecycleOwnerKt.getLifecycleScope(this), b1.c(), null, new ShopOwnerConfirmActivity$handleUri$1(uri, this, null), 2, null);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(e.g.d.a.j(((b) L()).B0(this), null, new ShopOwnerConfirmActivity$onRetryClick$1(this), 1, null), this, false, false, 6, null);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        F();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(ShopOwnerConfirmActivity$flowOfAppBar$1.INSTANCE);
    }

    public final MovementMethod n0() {
        return (MovementMethod) this.o.getValue();
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1) {
            ((b) L()).E0().r(intent == null ? null : (BankDetail) intent.getParcelableExtra("bank"));
        }
    }

    @d
    public final g p0() {
        return this.C;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        q2 e2 = q2.e(getLayoutInflater());
        e2.i(this);
        e2.j((b) L());
        return e2;
    }

    @d
    public final g q0() {
        return this.D;
    }

    @d
    public final g r0() {
        return this.F;
    }

    @d
    public final g s0() {
        return this.A;
    }

    @d
    public final g t0() {
        return this.z;
    }

    @d
    public final g u0() {
        return this.B;
    }

    @d
    public final g v0() {
        return this.G;
    }

    @d
    public final SpannableStringBuilder x0() {
        return (SpannableStringBuilder) this.n.getValue();
    }
}
