package com.jihuanshe.ui.page.order;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.order.SellerOrderListViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderListFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ SellerOrderListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderListFragment$onLoadMore$1(SellerOrderListFragment sellerOrderListFragment) {
        super(2);
        this.this$0 = sellerOrderListFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        SellerOrderListViewModel sellerOrderListViewModel = (SellerOrderListViewModel) this.this$0.T();
        String type = this.this$0.getType();
        if (type == null) {
            type = "";
        }
        BinderKt.d(sellerOrderListViewModel.q0(type, null, state), this.this$0, gVar, true);
    }
}
