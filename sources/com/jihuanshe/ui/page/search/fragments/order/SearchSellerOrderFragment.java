package com.jihuanshe.ui.page.search.fragments.order;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.page.order.SellerOrderListFragment;
import com.jihuanshe.viewmodel.order.SellerOrderListViewModel;
import e.l.s.m.c;
import e.t.j.h.f0;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class SearchSellerOrderFragment extends SellerOrderListFragment {
    @d
    private final w A = z.c(new SearchSellerOrderFragment$parentViewModel$2(this));
    @e
    private String B;

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        SellerOrderListViewModel sellerOrderListViewModel = (SellerOrderListViewModel) T();
        String type = getType();
        if (type == null) {
            type = "";
        }
        BinderKt.t(SellerOrderListViewModel.s0(sellerOrderListViewModel, type, this.B, null, 4, null), this, false, 2, null);
    }

    @Override // com.jihuanshe.ui.page.order.SellerOrderListFragment, com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        p0().s0().j(this, new SearchSellerOrderFragment$flowOfSetup$1(this));
    }

    @Override // com.jihuanshe.ui.page.order.SellerOrderListFragment
    @e
    public f0 k0() {
        return null;
    }

    @d
    public final c p0() {
        return (c) this.A.getValue();
    }
}
