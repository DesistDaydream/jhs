package com.jihuanshe.ui.page.user.wish;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class WishListFragmentCreator {
    private Integer index;
    private Boolean search;
    private String type;

    private WishListFragmentCreator() {
    }

    public static WishListFragmentCreator create(@Nullable String str, @Nullable Integer num) {
        WishListFragmentCreator wishListFragmentCreator = new WishListFragmentCreator();
        wishListFragmentCreator.type = str;
        wishListFragmentCreator.index = num;
        return wishListFragmentCreator;
    }

    public static void inject(WishListFragment wishListFragment) {
        Bundle arguments = wishListFragment.getArguments();
        if (arguments == null) {
            return;
        }
        if (arguments.containsKey("type")) {
            wishListFragment.w0((String) arguments.get("type"));
        }
        if (arguments.containsKey("index")) {
            wishListFragment.t0((Integer) arguments.get("index"));
        }
        if (arguments.containsKey("search")) {
            wishListFragment.v0((Boolean) arguments.get("search"));
        }
    }

    public WishListFragment get() {
        Bundle bundle = new Bundle();
        String str = this.type;
        if (str != null) {
            bundle.putString("type", str);
        }
        Integer num = this.index;
        if (num != null) {
            bundle.putInt("index", num.intValue());
        }
        Boolean bool = this.search;
        if (bool != null) {
            bundle.putBoolean("search", bool.booleanValue());
        }
        WishListFragment wishListFragment = new WishListFragment();
        wishListFragment.setArguments(bundle);
        return wishListFragment;
    }

    public WishListFragmentCreator search(Boolean bool) {
        this.search = bool;
        return this;
    }
}
