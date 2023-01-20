package com.jihuanshe.ui.page.search.fragments.global;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.SearchUser;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.search.globals.SearchUserViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import e.l.g.c1.b;
import e.l.k.a8;
import e.l.s.m.c;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
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
public final class SearchUserFragment extends BaseFragment<SearchUserViewModel> {
    public static final /* synthetic */ n<Object>[] y;
    @d
    private final w r = z.c(new SearchUserFragment$parentViewModel$2(this));
    @d
    private final e s = BindViewKt.s(this, R.id.listView);
    @d
    private final w t = z.c(new SearchUserFragment$adapter$2(this));
    @d
    private final w u = z.c(SearchUserFragment$layoutManager$2.INSTANCE);
    @d
    private final w v = z.c(SearchUserFragment$decoration$2.INSTANCE);
    @d
    private final l w = d.e.a.a(new SearchUserFragment$onItemClick$1(this));
    @k.e.a.d
    private final p x = d.g.a.a(new SearchUserFragment$onLoadMore$1(this));

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SearchUserFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        y = nVarArr;
    }

    private final ListView j0() {
        return (ListView) this.s.a(this, y[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c m0() {
        return (c) this.r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(SearchUser searchUser) {
        BinderKt.p(BinderKt.j(a.j(((SearchUserViewModel) T()).r0(searchUser), null, new SearchUserFragment$requestFollow$1(this, searchUser), 1, null), this, false, 2, null));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        f.g(m0().s0(), null, new SearchUserFragment$flowOfSetup$1(this), 1, null);
    }

    @k.e.a.d
    public final b g0() {
        return (b) this.t.getValue();
    }

    @k.e.a.d
    public final e.l.h.j.b.f.b h0() {
        return (e.l.h.j.b.f.b) this.v.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a i0() {
        return (LayoutManagers.a) this.u.getValue();
    }

    @k.e.a.d
    public final l k0() {
        return this.w;
    }

    @k.e.a.d
    public final p l0() {
        return this.x;
    }

    @k.e.a.d
    public final g n0(@k.e.a.d SearchUser searchUser) {
        return e.t.j.h.d.a.a(new SearchUserFragment$onFollow$1(searchUser, this));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        a8 e2 = a8.e(getLayoutInflater());
        e2.i(this);
        e2.j((SearchUserViewModel) T());
        return e2;
    }
}
