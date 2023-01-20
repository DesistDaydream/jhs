package com.jihuanshe.ui.page.entrepot;

import android.net.Uri;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.model.ApplyForOrder;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.utils.ImagePicker;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderViewModel;
import com.vector.ext.bind.BindViewKt;
import e.l.k.u2;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.k.a.f.h;
import f.a.a.a;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import i.b.b1;
import i.b.i;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SubmitOrderActivity extends BaseActivity<SubmitOrderViewModel> {
    public static final /* synthetic */ n<Object>[] w = {n0.r(new PropertyReference1Impl(n0.d(SubmitOrderActivity.class), "etExpress", "getEtExpress()Landroid/widget/EditText;"))};
    @a
    @e
    private ApplyForOrder afOrder;
    @a(true)
    private boolean checked;
    @e
    private h o;
    @d
    private final g q;
    @d
    private final g r;
    @d
    private final e.t.j.h.a s;
    @d
    private final g t;
    @d
    private final g u;
    @d
    private final g v;
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.et_express);
    @d
    private final ImagePicker p = new ImagePicker(this, 0, 0.0f, new SubmitOrderActivity$imagePicker$1(this), 6, (u) null);

    public SubmitOrderActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.q = dVar.a(new SubmitOrderActivity$onClickCheck$1(this));
        this.r = dVar.a(new SubmitOrderActivity$onClickSpinner$1(this));
        this.s = d.c.a.a(new SubmitOrderActivity$onTextChanged$1(this));
        this.t = dVar.a(new SubmitOrderActivity$onClickCopy$1(this));
        this.u = dVar.a(new SubmitOrderActivity$onClickAddPic$1(this));
        this.v = dVar.a(new SubmitOrderActivity$onClickSubmit$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText c0() {
        return (EditText) this.n.a(this, w[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(Uri uri) {
        if (uri == null) {
            return;
        }
        h hVar = this.o;
        if (hVar != null) {
            hVar.n();
        }
        h hVar2 = new h(this, false, 2, null);
        this.o = hVar2;
        if (hVar2 != null) {
            hVar2.W();
        }
        i.f(LifecycleOwnerKt.getLifecycleScope(this), b1.c(), null, new SubmitOrderActivity$handleUri$1(uri, this, null), 2, null);
    }

    @e
    public final ApplyForOrder a0() {
        return this.afOrder;
    }

    public final boolean b0() {
        return this.checked;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        ((SubmitOrderViewModel) L()).A0();
        f.g(((SubmitOrderViewModel) L()).B0(), null, SubmitOrderActivity$flowOfSetup$1.INSTANCE, 1, null);
    }

    @k.e.a.d
    public final g d0() {
        return this.u;
    }

    @k.e.a.d
    public final g e0() {
        return this.q;
    }

    @k.e.a.d
    public final g f0() {
        return this.t;
    }

    @k.e.a.d
    public final g g0() {
        return this.r;
    }

    @k.e.a.d
    public final g h0() {
        return this.v;
    }

    @k.e.a.d
    public final e.t.j.h.a i0() {
        return this.s;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(SubmitOrderActivity$flowOfAppBar$1.INSTANCE);
    }

    public final void k0(@e ApplyForOrder applyForOrder) {
        this.afOrder = applyForOrder;
    }

    public final void l0(boolean z) {
        this.checked = z;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        u2 e2 = u2.e(getLayoutInflater());
        e2.i(this);
        e2.j((SubmitOrderViewModel) L());
        return e2;
    }
}
