package com.jihuanshe.ui.page.user;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.adapter.BlackListAdapter;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.BanUser;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.user.BlackListViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import e.l.h.j.b.f.b;
import e.l.k.m;
import e.t.j.h.d;
import e.t.j.h.l;
import e.t.j.h.p;
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
public final class BlackListActivity extends BaseActivity<BlackListViewModel> {
    public static final /* synthetic */ n<Object>[] t;
    @d
    private final e n = BindViewKt.n(this, R.id.listView);
    @d
    private final w o = z.c(new BlackListActivity$adapter$2(this));
    @d
    private final w p = z.c(BlackListActivity$layoutManager$2.INSTANCE);
    @d
    private final w q = z.c(BlackListActivity$decoration$2.INSTANCE);
    @d
    private final p r = d.g.a.a(new BlackListActivity$onLoadMore$1(this));
    @k.e.a.d
    private final l s = d.e.a.a(new BlackListActivity$onItemClick$1(this));

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(BlackListActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        t = nVarArr;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(BinderKt.e(BlackListViewModel.s0((BlackListViewModel) L(), null, 1, null), this, Z(), false, 4, null), this, false, false, 6, null);
    }

    @k.e.a.d
    public final BlackListAdapter W() {
        return (BlackListAdapter) this.o.getValue();
    }

    @k.e.a.d
    public final b X() {
        return (b) this.q.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a Y() {
        return (LayoutManagers.a) this.p.getValue();
    }

    @k.e.a.d
    public final ListView Z() {
        return (ListView) this.n.a(this, t[0]);
    }

    @k.e.a.d
    public final l a0() {
        return this.s;
    }

    @k.e.a.d
    public final p b0() {
        return this.r;
    }

    public final void c0(@k.e.a.d BanUser banUser) {
        BinderKt.p(BinderKt.k(a.j(((BlackListViewModel) L()).t0(banUser), null, new BlackListActivity$remove$1(this, banUser), 1, null), this, false, 2, null));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        F();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(BlackListActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        m e2 = m.e(getLayoutInflater());
        e2.i(this);
        e2.j((BlackListViewModel) L());
        return e2;
    }
}
