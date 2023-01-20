package com.jihuanshe.ui.page.order;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.order.SellerOrderListViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.v0;
import e.l.h.j.b.f.b;
import e.l.k.e8;
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
public class SellerOrderListFragment extends BaseFragment<SellerOrderListViewModel> {
    public static final /* synthetic */ n<Object>[] z;
    @a
    @e
    private String type;
    @e
    private final f0 w;
    @d
    private final p x;
    private boolean y;
    @d
    private final h.m2.e r = BindViewKt.s(this, R.id.listView);
    @d
    private final w s = z.c(SellerOrderListFragment$adapter$2.INSTANCE);
    @d
    private final l t = d.e.a.a(new SellerOrderListFragment$onItemClick$1(this));
    @k.e.a.d
    private final w u = z.c(SellerOrderListFragment$decoration$2.INSTANCE);
    @k.e.a.d
    private final w v = z.c(SellerOrderListFragment$layoutManager$2.INSTANCE);

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(SellerOrderListFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        z = nVarArr;
    }

    public SellerOrderListFragment() {
        d.g gVar = d.g.a;
        this.w = gVar.b(new SellerOrderListFragment$onSwipe$1(this));
        this.x = gVar.a(new SellerOrderListFragment$onLoadMore$1(this));
        this.y = true;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        h0().h();
    }

    @k.e.a.d
    public final v0 e0() {
        return (v0) this.s.getValue();
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
        return (ListView) this.r.a(this, z[0]);
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

    public final boolean l0() {
        return this.y;
    }

    public final void m0(boolean z2) {
        this.y = z2;
    }

    public final void n0(@e String str) {
        this.type = str;
    }

    @Override // com.jihuanshe.ui.BaseFragment, e.l.h.j.a.a, com.vector.design.ui.frag.SimpleFragEx, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.y) {
            this.y = false;
        } else {
            h0().h();
        }
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        e8 e2 = e8.e(getLayoutInflater());
        e2.i(this);
        e2.j((SellerOrderListViewModel) T());
        return e2;
    }
}
