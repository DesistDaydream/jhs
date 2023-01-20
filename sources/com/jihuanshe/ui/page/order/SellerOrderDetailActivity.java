package com.jihuanshe.ui.page.order;

import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.adapter.OrderProductAdapter;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.dialog.ChooseDialogNew;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.util.Screen;
import e.l.g.s;
import e.l.h.j.b.f.b;
import e.l.k.k2;
import e.n.f;
import e.t.j.h.c0;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.o.d;
import f.a.a.a;
import h.k2.v.n0;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity extends BaseActivity<SellerOrderDetailViewModel> {
    public static final /* synthetic */ n<Object>[] N;
    @d
    private final g A;
    @d
    private final g B;
    @d
    private final c0 C;
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
    @d
    private final g I;
    @d
    private final g J;
    @d
    private final g K;
    @d
    private final g L;
    @d
    private final g M;
    @a
    private int id;
    private final int n;
    @e
    private k2 o;
    @d
    private final h.m2.e p;
    @d
    private final h.m2.e q;
    @d
    private final w r;
    @d
    private final w s;
    @d
    private final w t;
    @d
    private final w u;
    @d
    private final g v;
    @d
    private final g w;
    @d
    private final g x;
    @d
    private final g y;
    @d
    private final g z;

    static {
        n<Object>[] nVarArr = new n[6];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(SellerOrderDetailActivity.class), "tvPostage", "getTvPostage()Landroid/widget/TextView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SellerOrderDetailActivity.class), "tvProductPrice", "getTvProductPrice()Landroid/widget/TextView;"));
        N = nVarArr;
    }

    public SellerOrderDetailActivity() {
        int l2 = Screen.a.l();
        d.a aVar = e.t.o.d.a;
        this.n = Math.min(l2 - d.a.c(aVar, null, 1, null).d(32), d.a.c(aVar, null, 1, null).d(346));
        this.p = BindViewKt.n(this, R.id.tv_postage);
        this.q = BindViewKt.n(this, R.id.tv_product_price);
        this.r = z.c(new SellerOrderDetailActivity$adapter$2(this));
        this.s = z.c(SellerOrderDetailActivity$expressAdapter$2.INSTANCE);
        this.t = z.c(SellerOrderDetailActivity$layoutManager$2.INSTANCE);
        this.u = z.c(SellerOrderDetailActivity$decoration$2.INSTANCE);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.v = dVar.a(new SellerOrderDetailActivity$onCommunity$1(this));
        this.w = dVar.a(new SellerOrderDetailActivity$onClickCancel$1(this));
        this.x = dVar.a(new SellerOrderDetailActivity$onClickConfirm$1(this));
        this.y = dVar.a(new SellerOrderDetailActivity$onClickCost$1(this));
        this.z = dVar.a(new SellerOrderDetailActivity$onClickExpress$1(this));
        this.A = dVar.a(new SellerOrderDetailActivity$onClickCommit$1(this));
        this.B = dVar.a(new SellerOrderDetailActivity$onClickModifyExpress$1(this));
        this.C = d.f.a.a(new SellerOrderDetailActivity$onChecked$1(this));
        this.D = dVar.a(new SellerOrderDetailActivity$onClickChangePrice$1(this));
        this.E = dVar.a(new SellerOrderDetailActivity$onClickFold$1(this));
        this.F = dVar.a(new SellerOrderDetailActivity$onClickRefuseBackGood$1(this));
        this.G = dVar.a(new SellerOrderDetailActivity$stateNumMake$1(this));
        this.H = dVar.a(new SellerOrderDetailActivity$onClickAllowBackGood$1(this));
        this.I = dVar.a(new SellerOrderDetailActivity$onClickAllowBackMoney$1(this));
        this.J = dVar.a(new SellerOrderDetailActivity$onClickRefuseBackMoney$1(this));
        this.K = dVar.a(new SellerOrderDetailActivity$onClickCopy$1(this));
        this.L = dVar.a(new SellerOrderDetailActivity$onClickCopy2$1(this));
        this.M = dVar.a(new SellerOrderDetailActivity$onClickCopyAddress$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        new ChooseDialogNew(this, ((SellerOrderDetailViewModel) L()).x0(), new SellerOrderDetailActivity$showExpress$1(this)).y();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(((SellerOrderDetailViewModel) L()).v0(this.id), this, false, false, 6, null);
    }

    @k.e.a.d
    public final OrderProductAdapter X() {
        return (OrderProductAdapter) this.r.getValue();
    }

    @e
    public final k2 Y() {
        return this.o;
    }

    public final int Z() {
        return this.n;
    }

    @k.e.a.d
    public final b a0() {
        return (b) this.u.getValue();
    }

    @k.e.a.d
    public final s b0() {
        return (s) this.s.getValue();
    }

    public final int c0() {
        return this.id;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        w0().setPaintFlags(w0().getPaintFlags() | 16);
        x0().setPaintFlags(x0().getPaintFlags() | 16);
        f.g(((SellerOrderDetailViewModel) L()).C0(), null, new SellerOrderDetailActivity$flowOfSetup$1(this), 1, null);
        f.g(((SellerOrderDetailViewModel) L()).D0(), null, new SellerOrderDetailActivity$flowOfSetup$2(this), 1, null);
        F();
    }

    @k.e.a.d
    public final LayoutManagers.a d0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @k.e.a.d
    public final c0 e0() {
        return this.C;
    }

    @k.e.a.d
    public final g f0() {
        return this.H;
    }

    @k.e.a.d
    public final g g0() {
        return this.I;
    }

    @k.e.a.d
    public final g h0() {
        return this.w;
    }

    @k.e.a.d
    public final g i0() {
        return this.D;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(SellerOrderDetailActivity$flowOfAppBar$1.INSTANCE);
    }

    @k.e.a.d
    public final g j0() {
        return this.A;
    }

    @k.e.a.d
    public final g k0() {
        return this.x;
    }

    @k.e.a.d
    public final g l0() {
        return this.K;
    }

    @k.e.a.d
    public final g m0() {
        return this.L;
    }

    @k.e.a.d
    public final g n0() {
        return this.M;
    }

    @k.e.a.d
    public final g o0() {
        return this.y;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @k.e.a.d
    public final g p0() {
        return this.z;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        k2 e2 = k2.e(getLayoutInflater());
        this.o = e2;
        e2.i(this);
        this.o.j((SellerOrderDetailViewModel) L());
        return this.o;
    }

    @k.e.a.d
    public final g q0() {
        return this.E;
    }

    @k.e.a.d
    public final g r0() {
        return this.B;
    }

    @k.e.a.d
    public final g s0() {
        return this.F;
    }

    @k.e.a.d
    public final g t0() {
        return this.J;
    }

    @k.e.a.d
    public final g u0() {
        return this.v;
    }

    @k.e.a.d
    public final g v0() {
        return this.G;
    }

    @k.e.a.d
    public final TextView w0() {
        return (TextView) this.p.a(this, N[0]);
    }

    @k.e.a.d
    public final TextView x0() {
        return (TextView) this.q.a(this, N[1]);
    }

    public final void y0(@e k2 k2Var) {
        this.o = k2Var;
    }

    public final void z0(int i2) {
        this.id = i2;
    }
}
