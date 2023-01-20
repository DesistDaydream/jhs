package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.entrepot.SearchChildNoPassViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.g0;
import e.l.h.j.b.f.b;
import e.l.k.q7;
import e.l.s.m.c;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.f0;
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
public final class SearchChildNoPassFragment extends BaseFragment<SearchChildNoPassViewModel> {
    public static final /* synthetic */ n<Object>[] z;
    @d
    private final w r = z.c(new SearchChildNoPassFragment$parentViewModel$2(this));
    @d
    private final e s = BindViewKt.s(this, R.id.listView);
    @d
    private final w t = z.c(SearchChildNoPassFragment$layoutManager$2.INSTANCE);
    @d
    private final w u = z.c(SearchChildNoPassFragment$decoration$2.INSTANCE);
    @d
    private final w v = z.c(SearchChildNoPassFragment$adapter$2.INSTANCE);
    @d
    private final l w = d.e.a.a(SearchChildNoPassFragment$onItemClick$1.INSTANCE);
    @k.e.a.d
    private final f0 x;
    @k.e.a.d
    private final p y;

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SearchChildNoPassFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        z = nVarArr;
    }

    public SearchChildNoPassFragment() {
        d.g gVar = d.g.a;
        this.x = gVar.b(new SearchChildNoPassFragment$onSwipe$1(this));
        this.y = gVar.a(new SearchChildNoPassFragment$onLoadMore$1(this));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        BinderKt.o(SearchChildNoPassViewModel.s0((SearchChildNoPassViewModel) T(), l0().s0().getValue(), null, null, null, 14, null), this);
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        f.g(l0().s0(), null, new SearchChildNoPassFragment$flowOfSetup$1(this), 1, null);
    }

    @k.e.a.d
    public final g0 e0() {
        return (g0) this.v.getValue();
    }

    @k.e.a.d
    public final b f0() {
        return (b) this.u.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a g0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @k.e.a.d
    public final ListView h0() {
        return (ListView) this.s.a(this, z[1]);
    }

    @k.e.a.d
    public final l i0() {
        return this.w;
    }

    @k.e.a.d
    public final p j0() {
        return this.y;
    }

    @k.e.a.d
    public final f0 k0() {
        return this.x;
    }

    @k.e.a.d
    public final c l0() {
        return (c) this.r.getValue();
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        q7 e2 = q7.e(getLayoutInflater());
        e2.i(this);
        e2.j((SearchChildNoPassViewModel) T());
        return e2;
    }
}
