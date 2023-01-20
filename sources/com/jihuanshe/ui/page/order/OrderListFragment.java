package com.jihuanshe.ui.page.order;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.order.OrderListChildViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.k0;
import e.l.h.j.b.f.b;
import e.l.k.e7;
import e.t.j.h.d;
import e.t.j.h.f0;
import e.t.j.h.l;
import e.t.j.h.p;
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
public class OrderListFragment extends BaseFragment<OrderListChildViewModel> {
    public static final /* synthetic */ n<Object>[] y;
    @a
    @e
    private String type;
    @e
    private final f0 w;
    @d
    private final p x;
    @d
    private final h.m2.e r = BindViewKt.s(this, R.id.listView);
    @d
    private final w s = z.c(OrderListFragment$adapter$2.INSTANCE);
    @d
    private final l t = d.e.a.a(new OrderListFragment$onItemClick$1(this));
    @k.e.a.d
    private final w u = z.c(OrderListFragment$decoration$2.INSTANCE);
    @k.e.a.d
    private final w v = z.c(OrderListFragment$layoutManager$2.INSTANCE);

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(OrderListFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        y = nVarArr;
    }

    public OrderListFragment() {
        d.g gVar = d.g.a;
        this.w = gVar.b(new OrderListFragment$onSwipe$1(this));
        this.x = gVar.a(new OrderListFragment$onLoadMore$1(this));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        h0().h();
    }

    @k.e.a.d
    public final k0 e0() {
        return (k0) this.s.getValue();
    }

    @k.e.a.d
    public final b f0() {
        return (b) this.u.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a g0() {
        return (LayoutManagers.a) this.v.getValue();
    }

    @e
    public final String getType() {
        return this.type;
    }

    @k.e.a.d
    public final ListView h0() {
        return (ListView) this.r.a(this, y[0]);
    }

    @k.e.a.d
    public final l i0() {
        return this.t;
    }

    @k.e.a.d
    public final p j0() {
        return this.x;
    }

    @e
    public f0 k0() {
        return this.w;
    }

    public final void l0(@e String str) {
        this.type = str;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        e7 e2 = e7.e(getLayoutInflater());
        e2.i(this);
        e2.j((OrderListChildViewModel) T());
        return e2;
    }
}
