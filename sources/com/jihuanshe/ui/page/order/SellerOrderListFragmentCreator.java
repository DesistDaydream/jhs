package com.jihuanshe.ui.page.order;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SellerOrderListFragmentCreator {
    private String type;

    private SellerOrderListFragmentCreator() {
    }

    public static SellerOrderListFragmentCreator create(@Nullable String str) {
        SellerOrderListFragmentCreator sellerOrderListFragmentCreator = new SellerOrderListFragmentCreator();
        sellerOrderListFragmentCreator.type = str;
        return sellerOrderListFragmentCreator;
    }

    public static void inject(SellerOrderListFragment sellerOrderListFragment) {
        Bundle arguments = sellerOrderListFragment.getArguments();
        if (arguments != null && arguments.containsKey("type")) {
            sellerOrderListFragment.n0((String) arguments.get("type"));
        }
    }

    public SellerOrderListFragment get() {
        Bundle bundle = new Bundle();
        String str = this.type;
        if (str != null) {
            bundle.putString("type", str);
        }
        SellerOrderListFragment sellerOrderListFragment = new SellerOrderListFragment();
        sellerOrderListFragment.setArguments(bundle);
        return sellerOrderListFragment;
    }
}
