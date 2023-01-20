package com.jihuanshe.ui.page.order;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class OrderListFragmentCreator {
    private String type;

    private OrderListFragmentCreator() {
    }

    public static OrderListFragmentCreator create(@Nullable String str) {
        OrderListFragmentCreator orderListFragmentCreator = new OrderListFragmentCreator();
        orderListFragmentCreator.type = str;
        return orderListFragmentCreator;
    }

    public static void inject(OrderListFragment orderListFragment) {
        Bundle arguments = orderListFragment.getArguments();
        if (arguments != null && arguments.containsKey("type")) {
            orderListFragment.l0((String) arguments.get("type"));
        }
    }

    public OrderListFragment get() {
        Bundle bundle = new Bundle();
        String str = this.type;
        if (str != null) {
            bundle.putString("type", str);
        }
        OrderListFragment orderListFragment = new OrderListFragment();
        orderListFragment.setArguments(bundle);
        return orderListFragment;
    }
}
