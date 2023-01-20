package com.jihuanshe.ui.page.search.fragments.order;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.page.order.OrderListFragment;
import com.jihuanshe.viewmodel.order.OrderListChildViewModel;
import e.l.s.m.c;
import e.t.j.h.f0;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class SearchOrderFragment extends OrderListFragment {
    @e
    private String A;
    @d
    private final w z = z.c(new SearchOrderFragment$parentViewModel$2(this));

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        OrderListChildViewModel orderListChildViewModel = (OrderListChildViewModel) T();
        String type = getType();
        if (type == null) {
            type = "";
        }
        BinderKt.t(OrderListChildViewModel.s0(orderListChildViewModel, type, this.A, null, 4, null), this, false, 2, null);
    }

    @Override // com.jihuanshe.ui.page.order.OrderListFragment, com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        n0().s0().j(this, new SearchOrderFragment$flowOfSetup$1(this));
    }

    @Override // com.jihuanshe.ui.page.order.OrderListFragment
    @e
    public f0 k0() {
        return null;
    }

    @d
    public final c n0() {
        return (c) this.z.getValue();
    }
}
