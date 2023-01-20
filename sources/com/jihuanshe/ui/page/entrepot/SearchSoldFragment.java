package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.entrepot.SearchSoldViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.h0;
import e.l.h.j.b.f.b;
import e.l.k.y7;
import e.l.s.m.c;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.f0;
import e.t.j.h.l;
import e.t.j.h.p;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SearchSoldFragment extends BaseFragment<SearchSoldViewModel> {
    public static final /* synthetic */ n<Object>[] A;
    public static final int B = 1;
    public static final int C = 0;
    @d
    public static final a z;
    @d
    private final f0 x;
    @d
    private final p y;
    @f.a.a.a
    private int type = 1;
    @d
    private final w r = z.c(new SearchSoldFragment$parentViewModel$2(this));
    @d
    private final e s = BindViewKt.s(this, R.id.listView);
    @d
    private final w t = z.c(SearchSoldFragment$layoutManager$2.INSTANCE);
    @d
    private final w u = z.c(SearchSoldFragment$decoration$2.INSTANCE);
    @d
    private final w v = z.c(SearchSoldFragment$adapter$2.INSTANCE);
    @d
    private final l w = d.e.a.a(SearchSoldFragment$onItemClick$1.INSTANCE);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SearchSoldFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        A = nVarArr;
        z = new a(null);
    }

    public SearchSoldFragment() {
        d.g gVar = d.g.a;
        this.x = gVar.b(new SearchSoldFragment$onSwipe$1(this));
        this.y = gVar.a(new SearchSoldFragment$onLoadMore$1(this));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        BinderKt.o(SearchSoldViewModel.s0((SearchSoldViewModel) T(), Integer.valueOf(this.type), l0().s0().getValue(), null, 4, null), this);
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        f.g(l0().s0(), null, new SearchSoldFragment$flowOfSetup$1(this), 1, null);
    }

    @k.e.a.d
    public final h0 e0() {
        return (h0) this.v.getValue();
    }

    @k.e.a.d
    public final b f0() {
        return (b) this.u.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a g0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    public final int getType() {
        return this.type;
    }

    @k.e.a.d
    public final ListView h0() {
        return (ListView) this.s.a(this, A[1]);
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

    public final void m0(int i2) {
        this.type = i2;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        y7 e2 = y7.e(getLayoutInflater());
        e2.i(this);
        e2.j((SearchSoldViewModel) T());
        return e2;
    }
}
