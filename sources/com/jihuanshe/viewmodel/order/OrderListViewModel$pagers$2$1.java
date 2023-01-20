package com.jihuanshe.viewmodel.order;

import com.jihuanshe.ui.page.order.SellerOrderListFragment;
import com.jihuanshe.ui.page.order.SellerOrderListFragmentCreator;
import h.k2.u.l;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderListViewModel$pagers$2$1 extends Lambda implements l<Integer, SellerOrderListFragment> {
    public final /* synthetic */ String $s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderListViewModel$pagers$2$1(String str) {
        super(1);
        this.$s = str;
    }

    public final SellerOrderListFragment invoke(int i2) {
        return SellerOrderListFragmentCreator.create(this.$s).get();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ SellerOrderListFragment invoke(Integer num) {
        return invoke(num.intValue());
    }
}
