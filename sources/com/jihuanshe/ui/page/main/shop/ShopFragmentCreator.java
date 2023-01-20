package com.jihuanshe.ui.page.main.shop;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class ShopFragmentCreator {
    private ShopFragmentCreator() {
    }

    public static ShopFragmentCreator create() {
        return new ShopFragmentCreator();
    }

    public static void inject(ShopFragment shopFragment) {
        if (shopFragment.getArguments() == null) {
        }
    }

    public ShopFragment get() {
        Bundle bundle = new Bundle();
        ShopFragment shopFragment = new ShopFragment();
        shopFragment.setArguments(bundle);
        return shopFragment;
    }
}
