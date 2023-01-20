package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.model.OrderInfo;
import com.jihuanshe.viewmodel.order.OrderListChildViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderListFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ OrderListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderListFragment$onItemClick$1(OrderListFragment orderListFragment) {
        super(2);
        this.this$0 = orderListFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<OrderInfo> value = ((OrderListChildViewModel) this.this$0.T()).r0().getValue();
        OrderInfo orderInfo = value == null ? null : (OrderInfo) CollectionsKt___CollectionsKt.J2(value, i2);
        if (orderInfo == null) {
            return;
        }
        OrderDetailActivityCreator.create(Integer.valueOf(orderInfo.getId())).start(this.this$0.getActivity());
    }
}
