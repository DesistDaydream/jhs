package com.jihuanshe.ui.page.user.selling;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class SellingFragmentCreator {
    private Boolean search;

    private SellingFragmentCreator() {
    }

    public static SellingFragmentCreator create() {
        return new SellingFragmentCreator();
    }

    public static void inject(SellingFragment sellingFragment) {
        Bundle arguments = sellingFragment.getArguments();
        if (arguments != null && arguments.containsKey("search")) {
            sellingFragment.v0(((Boolean) arguments.get("search")).booleanValue());
        }
    }

    public SellingFragment get() {
        Bundle bundle = new Bundle();
        Boolean bool = this.search;
        if (bool != null) {
            bundle.putBoolean("search", bool.booleanValue());
        }
        SellingFragment sellingFragment = new SellingFragment();
        sellingFragment.setArguments(bundle);
        return sellingFragment;
    }

    public SellingFragmentCreator search(Boolean bool) {
        this.search = bool;
        return this;
    }
}
