package com.jihuanshe.ui.page.search.fragments.wantcard;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import com.vector.util.LayoutManagers;
import e.l.g.a1;
import e.l.k.c8;
import e.l.s.m.c;
import e.t.j.h.d;
import e.t.j.h.l;
import e.t.j.h.p;
import f.a.a.a;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class SearchWantCardListFragment extends BaseFragment<WantCardListViewModel> {
    @a
    @e
    private Integer id;
    @d
    private final w r = z.c(new SearchWantCardListFragment$parentViewModel$2(this));
    @d
    private final w s = z.c(SearchWantCardListFragment$adapter$2.INSTANCE);
    @d
    private final w t = z.c(SearchWantCardListFragment$layoutManager$2.INSTANCE);
    @d
    private final w u = z.c(SearchWantCardListFragment$decoration$2.INSTANCE);
    @d
    private final l v = d.e.a.a(new SearchWantCardListFragment$onItemClick$1(this));
    @k.e.a.d
    private final p w = d.g.a.a(new SearchWantCardListFragment$onLoadMore$1(this));
    @e
    private String x;

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        super.d();
        m0().s0().j(this, new SearchWantCardListFragment$flowOfSetup$1(this));
    }

    @k.e.a.d
    public final a1 g0() {
        return (a1) this.s.getValue();
    }

    @k.e.a.d
    public final e.l.h.j.b.f.a h0() {
        return (e.l.h.j.b.f.a) this.u.getValue();
    }

    @e
    public final Integer i0() {
        return this.id;
    }

    @k.e.a.d
    public final LayoutManagers.a j0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @k.e.a.d
    public final l k0() {
        return this.v;
    }

    @k.e.a.d
    public final p l0() {
        return this.w;
    }

    @k.e.a.d
    public final c m0() {
        return (c) this.r.getValue();
    }

    public final void n0(@e Integer num) {
        this.id = num;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        c8 e2 = c8.e(getLayoutInflater());
        e2.i(this);
        e2.j((WantCardListViewModel) T());
        return e2;
    }
}
