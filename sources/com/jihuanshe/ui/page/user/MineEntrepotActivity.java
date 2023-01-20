package com.jihuanshe.ui.page.user;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.user.MineEntrepotViewModel;
import com.vector.ext.bind.BindViewKt;
import e.g.d.a;
import e.l.k.k1;
import e.n.f;
import e.t.j.h.g;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import inject.annotation.creator.Creator;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class MineEntrepotActivity extends BaseActivity<MineEntrepotViewModel> {
    public static final /* synthetic */ n<Object>[] w = {n0.r(new PropertyReference1Impl(n0.d(MineEntrepotActivity.class), "clNotice", "getClNotice()Landroidx/constraintlayout/widget/ConstraintLayout;"))};
    @d
    private final e n = BindViewKt.n(this, R.id.clNotice);
    @d
    private final g o;
    @d
    private final g p;
    @d
    private final g q;
    @d
    private final g r;
    @d
    private final g s;
    @d
    private final g t;
    @d
    private final g u;
    @d
    private final g v;

    public MineEntrepotActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.o = dVar.a(new MineEntrepotActivity$onClickApplyFor$1(this));
        this.p = dVar.a(new MineEntrepotActivity$onClickWaiting$1(this));
        this.q = dVar.a(new MineEntrepotActivity$onClickExisting$1(this));
        this.r = dVar.a(new MineEntrepotActivity$onClickConsignmentOrders$1(this));
        this.s = dVar.a(new MineEntrepotActivity$onClickMailOrder$1(this));
        this.t = dVar.a(new MineEntrepotActivity$onClickApplyForReturn$1(this));
        this.u = dVar.a(new MineEntrepotActivity$onClickGoodsSold$1(this));
        this.v = dVar.a(new MineEntrepotActivity$onClickDesc$1(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.p(a.j(((MineEntrepotViewModel) L()).u0(), null, new MineEntrepotActivity$onRetryClick$1(this), 1, null));
    }

    @d
    public final ConstraintLayout W() {
        return (ConstraintLayout) this.n.a(this, w[0]);
    }

    @d
    public final g X() {
        return this.o;
    }

    @d
    public final g Y() {
        return this.t;
    }

    @d
    public final g Z() {
        return this.r;
    }

    @d
    public final g a0() {
        return this.v;
    }

    @d
    public final g b0() {
        return this.q;
    }

    @d
    public final g c0() {
        return this.u;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        f.g(GameBar.b.a(), null, new MineEntrepotActivity$flowOfSetup$1(this), 1, null);
    }

    @d
    public final g d0() {
        return this.s;
    }

    @d
    public final g e0() {
        return this.p;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void f() {
        super.f();
        ((MineEntrepotViewModel) L()).v0(e.l.o.a.a.a.a.e());
    }

    @d
    public final g f0(@d ConstraintLayout constraintLayout) {
        return e.t.j.h.d.a.a(new MineEntrepotActivity$onClickClose$1(constraintLayout, this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().b(new MineEntrepotActivity$flowOfAppBar$1(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        k1 e2 = k1.e(getLayoutInflater());
        e2.i(this);
        e2.j((MineEntrepotViewModel) L());
        return e2;
    }
}
