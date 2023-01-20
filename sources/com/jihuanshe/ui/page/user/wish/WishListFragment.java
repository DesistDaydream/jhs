package com.jihuanshe.ui.page.user.wish;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.b1;
import e.l.h.j.b.f.b;
import e.l.k.m8;
import e.t.j.h.d;
import e.t.j.h.f0;
import e.t.j.h.g;
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
public class WishListFragment extends BaseFragment<WishListViewModel> {
    public static final /* synthetic */ n<Object>[] B;
    @d
    private final g A;
    @a
    @e
    private Integer index;
    @e
    private String r;
    @a
    @e
    private String type;
    @d
    private final f0 y;
    @d
    private final p z;
    @a(true)
    @e
    private Boolean search = Boolean.FALSE;
    @d
    private final w s = z.c(new WishListFragment$parentViewModel$2(this));
    @d
    private final h.m2.e t = BindViewKt.s(this, R.id.listView);
    @d
    private final w u = z.c(new WishListFragment$adapter$2(this));
    @d
    private final w v = z.c(WishListFragment$layoutManager$2.INSTANCE);
    @d
    private final w w = z.c(WishListFragment$decoration$2.INSTANCE);
    @d
    private final l x = d.e.a.a(new WishListFragment$onItemClick$1(this));

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(WishListFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        B = nVarArr;
    }

    public WishListFragment() {
        d.g gVar = d.g.a;
        this.y = gVar.b(new WishListFragment$onSwipe$1(this));
        this.z = gVar.a(new WishListFragment$onLoadMore$1(this));
        this.A = e.t.j.h.d.a.a(new WishListFragment$onClickOp$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.l.s.o.e.a q0() {
        return (e.l.s.o.e.a) this.s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        BinderKt.e(BinderKt.t(WishListViewModel.u0((WishListViewModel) T(), this.type, this.r, null, 4, null), this, false, 2, null), this, l0(), false, 4, null);
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        q0().p0().j(this, new WishListFragment$flowOfSetup$1(this));
        q0().q0().f(this, new WishListFragment$flowOfSetup$2(this));
        q0().r0().j(this, new WishListFragment$flowOfSetup$3(this));
        ((WishListViewModel) T()).w0(q0().p0().getValue());
        if (h.k2.v.f0.g(this.search, Boolean.FALSE)) {
            s0();
        }
    }

    @k.e.a.d
    public final b1 g0() {
        return (b1) this.u.getValue();
    }

    @e
    public final String getType() {
        return this.type;
    }

    @k.e.a.d
    public final b h0() {
        return (b) this.w.getValue();
    }

    @e
    public final Integer i0() {
        return this.index;
    }

    @e
    public final String j0() {
        return this.r;
    }

    @k.e.a.d
    public final LayoutManagers.a k0() {
        return (LayoutManagers.a) this.v.getValue();
    }

    @k.e.a.d
    public final ListView l0() {
        return (ListView) this.t.a(this, B[1]);
    }

    @k.e.a.d
    public final g m0() {
        return this.A;
    }

    @k.e.a.d
    public final l n0() {
        return this.x;
    }

    @k.e.a.d
    public final p o0() {
        return this.z;
    }

    @k.e.a.d
    public final f0 p0() {
        return this.y;
    }

    @e
    public final Boolean r0() {
        return this.search;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        m8 e2 = m8.e(getLayoutInflater());
        e2.i(this);
        e2.j((WishListViewModel) T());
        return e2;
    }

    public final void t0(@e Integer num) {
        this.index = num;
    }

    public final void u0(@e String str) {
        this.r = str;
    }

    public final void v0(@e Boolean bool) {
        this.search = bool;
    }

    public final void w0(@e String str) {
        this.type = str;
    }
}
