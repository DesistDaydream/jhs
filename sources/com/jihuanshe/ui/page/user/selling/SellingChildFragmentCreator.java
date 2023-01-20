package com.jihuanshe.ui.page.user.selling;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SellingChildFragmentCreator {
    private Boolean search;
    private Integer type;

    private SellingChildFragmentCreator() {
    }

    public static SellingChildFragmentCreator create(@Nullable Integer num) {
        SellingChildFragmentCreator sellingChildFragmentCreator = new SellingChildFragmentCreator();
        sellingChildFragmentCreator.type = num;
        return sellingChildFragmentCreator;
    }

    public static void inject(SellingChildFragment sellingChildFragment) {
        Bundle arguments = sellingChildFragment.getArguments();
        if (arguments == null) {
            return;
        }
        if (arguments.containsKey("type")) {
            sellingChildFragment.s0((Integer) arguments.get("type"));
        }
        if (arguments.containsKey("search")) {
            sellingChildFragment.r0(((Boolean) arguments.get("search")).booleanValue());
        }
    }

    public SellingChildFragment get() {
        Bundle bundle = new Bundle();
        Integer num = this.type;
        if (num != null) {
            bundle.putInt("type", num.intValue());
        }
        Boolean bool = this.search;
        if (bool != null) {
            bundle.putBoolean("search", bool.booleanValue());
        }
        SellingChildFragment sellingChildFragment = new SellingChildFragment();
        sellingChildFragment.setArguments(bundle);
        return sellingChildFragment;
    }

    public SellingChildFragmentCreator search(Boolean bool) {
        this.search = bool;
        return this;
    }
}
