package com.jihuanshe.viewmodel.order;

import com.jihuanshe.ui.page.order.OrderListFragment;
import com.jihuanshe.ui.page.order.OrderListFragmentCreator;
import h.k2.u.l;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderListViewModel$pagers$1$1 extends Lambda implements l<Integer, OrderListFragment> {
    public final /* synthetic */ String $s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderListViewModel$pagers$1$1(String str) {
        super(1);
        this.$s = str;
    }

    public final OrderListFragment invoke(int i2) {
        return OrderListFragmentCreator.create(this.$s).get();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ OrderListFragment invoke(Integer num) {
        return invoke(num.intValue());
    }
}
