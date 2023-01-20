package com.jihuanshe.ui.page.user;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.model.ShopCartItem;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.user.ShopCarViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.h.j.b.f.b;
import e.l.k.o2;
import e.t.j.h.d;
import e.t.j.h.f0;
import e.t.j.h.g;
import e.t.j.h.l;
import e.t.j.h.p;
import e.t.r.a.a;
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
public final class ShopCarActivity extends BaseActivity<ShopCarViewModel> {
    public static final /* synthetic */ n<Object>[] v;
    @d
    private final e n = BindViewKt.n(this, R.id.listView);
    @d
    private final w o = z.c(new ShopCarActivity$adapter$2(this));
    @d
    private final a p = new a(0, 0, 3, null);
    @d
    private final w q = z.c(ShopCarActivity$layoutManager$2.INSTANCE);
    @d
    private final w r = z.c(ShopCarActivity$decoration$2.INSTANCE);
    @d
    private final f0 s;
    @d
    private final p t;
    @d
    private final l u;

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(ShopCarActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        v = nVarArr;
    }

    public ShopCarActivity() {
        d.g gVar = d.g.a;
        this.s = gVar.b(new ShopCarActivity$onSwipe$1(this));
        this.t = gVar.a(new ShopCarActivity$onLoadMore$1(this));
        this.u = d.e.a.a(new ShopCarActivity$onItemClick$1(this));
    }

    @k.e.a.d
    public final g W(@k.e.a.d ShopCartItem shopCartItem) {
        return e.t.j.h.d.a.a(new ShopCarActivity$deleteShopCar$1(shopCartItem, this));
    }

    @k.e.a.d
    public final e.l.g.f0 X() {
        return (e.l.g.f0) this.o.getValue();
    }

    @k.e.a.d
    public final b Y() {
        return (b) this.r.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a Z() {
        return (LayoutManagers.a) this.q.getValue();
    }

    @k.e.a.d
    public final ListView a0() {
        return (ListView) this.n.a(this, v[0]);
    }

    @k.e.a.d
    public final l b0() {
        return this.u;
    }

    @k.e.a.d
    public final p c0() {
        return this.t;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        a0().h();
    }

    @k.e.a.d
    public final f0 d0() {
        return this.s;
    }

    @k.e.a.d
    public final a e0() {
        return this.p;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(ShopCarActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        o2 e2 = o2.e(getLayoutInflater());
        e2.i(this);
        e2.j((ShopCarViewModel) L());
        return e2;
    }
}
