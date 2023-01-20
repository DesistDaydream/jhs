package com.jihuanshe.ui.page.order;

import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.jihuanshe.R;
import com.jihuanshe.adapter.OrderProductAdapter;
import com.jihuanshe.base.bus.Bus;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ShopCarInfo;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.widget.NoScrollListView;
import com.jihuanshe.viewmodel.order.OrderConfirmViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.util.Res;
import e.l.h.d.f;
import e.l.h.d.h;
import e.l.k.o1;
import e.t.j.h.g;
import h.k2.v.f0;
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
public final class OrderConfirmActivity extends BaseActivity<OrderConfirmViewModel> {
    public static final /* synthetic */ n<Object>[] t;
    @d
    private final e n = BindViewKt.n(this, R.id.et);
    @d
    private final w o = z.c(new OrderConfirmActivity$adapter$2(this));
    @d
    private final w p = z.c(OrderConfirmActivity$layoutManager$2.INSTANCE);
    @d
    private final g q;
    @d
    private final g r;
    @d
    private final e s;
    @f.a.a.a
    @k.e.a.e
    private ShopCarInfo shopCardInfo;
    @f.a.a.a
    private int uid;

    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OrderConfirmActivity f4031c;

        public a(Bus bus, String str, OrderConfirmActivity orderConfirmActivity) {
            this.a = bus;
            this.b = str;
            this.f4031c = orderConfirmActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (this.a.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            if (f2 != null && (f2 instanceof UserAddress)) {
                ((OrderConfirmViewModel) this.f4031c.L()).q0().setValue((UserAddress) f2);
            }
            new e.t.l.h();
        }
    }

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(OrderConfirmActivity.class), "et", "getEt()Landroid/widget/EditText;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(OrderConfirmActivity.class), "rv", "getRv()Lcom/jihuanshe/ui/widget/NoScrollListView;"));
        t = nVarArr;
    }

    public OrderConfirmActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.q = dVar.a(new OrderConfirmActivity$onClickAddress$1(this));
        this.r = dVar.a(new OrderConfirmActivity$onClickConfirm$1(this));
        this.s = BindViewKt.n(this, R.id.recyclerView);
    }

    private final void e0() {
        Bus e2 = f.b.e(this);
        e2.l(e2.e(), e2.d(), new a(e2, e.l.j.a.f12235e, this));
        e.n.f.g(((OrderConfirmViewModel) L()).s0(), null, new OrderConfirmActivity$initObserver$2(this), 1, null);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(((OrderConfirmViewModel) L()).t0(this.uid), this, false, false, 6, null);
    }

    @d
    public final OrderProductAdapter W() {
        return (OrderProductAdapter) this.o.getValue();
    }

    @d
    public final EditText X() {
        return (EditText) this.n.a(this, t[0]);
    }

    @d
    public final LayoutManagers.a Y() {
        return (LayoutManagers.a) this.p.getValue();
    }

    @d
    public final g Z() {
        return this.q;
    }

    @d
    public final g a0() {
        return this.r;
    }

    @d
    public final NoScrollListView b0() {
        return (NoScrollListView) this.s.a(this, t[3]);
    }

    @k.e.a.e
    public final ShopCarInfo c0() {
        return this.shopCardInfo;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        e0();
        b0().setNestedScrollingEnabled(false);
        F();
    }

    public final int d0() {
        return this.uid;
    }

    public final void f0(@k.e.a.e ShopCarInfo shopCarInfo) {
        this.shopCardInfo = shopCarInfo;
    }

    public final void g0(int i2) {
        this.uid = i2;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundColor(Res.k(R.color.white));
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(OrderConfirmActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        o1 e2 = o1.e(getLayoutInflater());
        e2.i(this);
        e2.j((OrderConfirmViewModel) L());
        return e2;
    }
}
