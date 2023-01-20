package com.jihuanshe.ui.page.search.fragments.global;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.search.globals.SearchProductViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.h.j.b.f.b;
import e.l.k.w7;
import e.l.s.m.c;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import e.t.j.h.p;
import f.a.a.a;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SearchProductFragment extends BaseFragment<SearchProductViewModel> {
    public static final /* synthetic */ n<Object>[] B;
    @a
    @e
    private Integer index;
    @a
    @e
    private String type;
    @d
    private final w r = z.c(new SearchProductFragment$parentViewModel$2(this));
    @d
    private final w s = z.c(new SearchProductFragment$parentFragmentViewModel$2(this));
    @d
    private final h.m2.e t = BindViewKt.s(this, R.id.listView);
    @d
    private final w u = z.c(SearchProductFragment$adapter$2.INSTANCE);
    @d
    private final w v = z.c(SearchProductFragment$layoutManager$2.INSTANCE);
    @d
    private final w w = z.c(SearchProductFragment$decoration$2.INSTANCE);
    @d
    private final w x = z.c(new SearchProductFragment$header$2(this));
    @d
    private final p y = d.g.a.a(new SearchProductFragment$onLoadMore$1(this));
    @k.e.a.d
    private final l z = d.e.a.a(new SearchProductFragment$onItemClick$1(this));
    @k.e.a.d
    private final g A = e.t.j.h.d.a.a(new SearchProductFragment$onClickMediation$1(this));

    static {
        n<Object>[] nVarArr = new n[7];
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(SearchProductFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        B = nVarArr;
    }

    private final ListView m0() {
        return (ListView) this.t.a(this, B[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.l.s.m.d.a q0() {
        return (e.l.s.m.d.a) this.s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c r0() {
        return (c) this.r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        ((SearchProductViewModel) T()).q0().r(CollectionsKt__CollectionsKt.E());
        SearchProductViewModel searchProductViewModel = (SearchProductViewModel) T();
        String str = this.type;
        Game value = q0().p0().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        Game value2 = q0().p0().getValue();
        BinderKt.e(BinderKt.t(SearchProductViewModel.v0(searchProductViewModel, str, gameKey, value2 == null ? null : value2.getGameSubKey(), q0().s0().getValue(), null, 16, null), this, false, 2, null), this, m0(), false, 4, null);
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        r0().s0().f(this, new SearchProductFragment$flowOfSetup$1(this));
        q0().r0().f(this, new SearchProductFragment$flowOfSetup$2(this));
        q0().q0().j(this, new SearchProductFragment$flowOfSetup$3(this));
        q0().t0().j(this, new SearchProductFragment$flowOfSetup$4(this));
        ((SearchProductViewModel) T()).s0().f(this, new SearchProductFragment$flowOfSetup$5(this));
        ((SearchProductViewModel) T()).t0().f(this, new SearchProductFragment$flowOfSetup$6(this));
        ((SearchProductViewModel) T()).t0().setValue(Integer.valueOf(f0.g(this.type, Constants.Companion.getTYPE_CARD()) ? 0 : 1));
    }

    @e
    public final String getType() {
        return this.type;
    }

    @k.e.a.d
    public final e.l.g.c1.a h0() {
        return (e.l.g.c1.a) this.u.getValue();
    }

    @k.e.a.d
    public final b i0() {
        return (b) this.w.getValue();
    }

    @e
    public final View j0() {
        return (View) this.x.getValue();
    }

    @e
    public final Integer k0() {
        return this.index;
    }

    @k.e.a.d
    public final LayoutManagers.a l0() {
        return (LayoutManagers.a) this.v.getValue();
    }

    @k.e.a.d
    public final g n0() {
        return this.A;
    }

    @k.e.a.d
    public final l o0() {
        return this.z;
    }

    @k.e.a.d
    public final p p0() {
        return this.y;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        w7 e2 = w7.e(getLayoutInflater());
        e2.i(this);
        e2.j((SearchProductViewModel) T());
        return e2;
    }

    public final void t0(@e Integer num) {
        this.index = num;
    }

    public final void u0(@e String str) {
        this.type = str;
    }
}
