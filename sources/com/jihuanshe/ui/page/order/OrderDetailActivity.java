package com.jihuanshe.ui.page.order;

import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.adapter.OrderProductAdapter;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.util.Screen;
import e.l.g.s;
import e.l.h.j.b.f.b;
import e.l.k.q1;
import e.n.f;
import e.t.j.h.g;
import e.t.o.d;
import f.a.a.a;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class OrderDetailActivity extends BaseActivity<OrderDetailViewModel> {
    public static final /* synthetic */ n<Object>[] G;
    @d
    private final g A;
    @d
    private final g B;
    @d
    private final g C;
    @d
    private final g D;
    @d
    private final g E;
    @d
    private final g F;
    @a
    private int id;
    @d
    private final e n = BindViewKt.n(this, R.id.tv_postage);
    @d
    private final e o = BindViewKt.n(this, R.id.tv_product_price);
    private final int p;
    @k.e.a.e
    private q1 q;
    @d
    private final w r;
    @d
    private final w s;
    @d
    private final w t;
    @d
    private final w u;
    @d
    private final w v;
    @d
    private final g w;
    @d
    private final g x;
    @d
    private final g y;
    @d
    private final g z;

    static {
        n<Object>[] nVarArr = new n[7];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(OrderDetailActivity.class), "tvPostage", "getTvPostage()Landroid/widget/TextView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(OrderDetailActivity.class), "tvProductPrice", "getTvProductPrice()Landroid/widget/TextView;"));
        G = nVarArr;
    }

    public OrderDetailActivity() {
        int l2 = Screen.a.l();
        d.a aVar = e.t.o.d.a;
        this.p = Math.min(l2 - d.a.c(aVar, null, 1, null).d(32), d.a.c(aVar, null, 1, null).d(346));
        this.r = z.c(new OrderDetailActivity$adapter$2(this));
        this.s = z.c(OrderDetailActivity$expressAdapter$2.INSTANCE);
        this.t = z.c(OrderDetailActivity$layoutManager$2.INSTANCE);
        this.u = z.c(OrderDetailActivity$decoration$2.INSTANCE);
        this.v = z.c(OrderDetailActivity$expressLayoutManager$2.INSTANCE);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.w = dVar.a(new OrderDetailActivity$onCommunity$1(this));
        this.x = dVar.a(new OrderDetailActivity$onClickCancel$1(this));
        this.y = dVar.a(new OrderDetailActivity$onClickPay$1(this));
        this.z = dVar.a(new OrderDetailActivity$onClickBackMoney$1(this));
        this.A = dVar.a(new OrderDetailActivity$onClickBackProduct$1(this));
        this.B = dVar.a(new OrderDetailActivity$onClickDelayReceive$1(this));
        this.C = dVar.a(new OrderDetailActivity$onClickConfirmReceive$1(this));
        this.D = dVar.a(new OrderDetailActivity$onClickFold$1(this));
        this.E = dVar.a(new OrderDetailActivity$onClickCopy$1(this));
        this.F = dVar.a(new OrderDetailActivity$onClickCopy2$1(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(((OrderDetailViewModel) L()).v0(this.id), this, false, false, 6, null);
    }

    @k.e.a.d
    public final OrderProductAdapter W() {
        return (OrderProductAdapter) this.r.getValue();
    }

    @k.e.a.e
    public final q1 X() {
        return this.q;
    }

    public final int Y() {
        return this.p;
    }

    @k.e.a.d
    public final b Z() {
        return (b) this.u.getValue();
    }

    @k.e.a.d
    public final s a0() {
        return (s) this.s.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a b0() {
        return (LayoutManagers.a) this.v.getValue();
    }

    public final int c0() {
        return this.id;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        o0().setPaintFlags(o0().getPaintFlags() | 16);
        p0().setPaintFlags(p0().getPaintFlags() | 16);
        f.g(((OrderDetailViewModel) L()).y0(), null, new OrderDetailActivity$flowOfSetup$1(this), 1, null);
        f.g(((OrderDetailViewModel) L()).A0(), null, new OrderDetailActivity$flowOfSetup$2(this), 1, null);
        e.l.h.d.f.b.e(this).g(e.l.j.a.r, new OrderDetailActivity$flowOfSetup$3(this));
        f.g(((OrderDetailViewModel) L()).z0(), null, new OrderDetailActivity$flowOfSetup$4(this), 1, null);
        F();
    }

    @k.e.a.d
    public final LayoutManagers.a d0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @k.e.a.d
    public final g e0() {
        return this.z;
    }

    @k.e.a.d
    public final g f0() {
        return this.A;
    }

    @k.e.a.d
    public final g g0() {
        return this.x;
    }

    @k.e.a.d
    public final g h0() {
        return this.C;
    }

    @k.e.a.d
    public final g i0() {
        return this.E;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(OrderDetailActivity$flowOfAppBar$1.INSTANCE);
    }

    @k.e.a.d
    public final g j0() {
        return this.F;
    }

    @k.e.a.d
    public final g k0() {
        return this.B;
    }

    @k.e.a.d
    public final g l0() {
        return this.D;
    }

    @k.e.a.d
    public final g m0() {
        return this.y;
    }

    @k.e.a.d
    public final g n0() {
        return this.w;
    }

    @k.e.a.d
    public final TextView o0() {
        return (TextView) this.n.a(this, G[0]);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @k.e.a.d
    public final TextView p0() {
        return (TextView) this.o.a(this, G[1]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        q1 e2 = q1.e(getLayoutInflater());
        this.q = e2;
        e2.i(this);
        this.q.j((OrderDetailViewModel) L());
        return this.q;
    }

    public final void q0(@k.e.a.e q1 q1Var) {
        this.q = q1Var;
    }

    public final void r0(int i2) {
        this.id = i2;
    }
}
