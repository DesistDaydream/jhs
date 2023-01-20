package com.jihuanshe.ui.page.entrepot;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SearchMyStorehouseFragmentCreator {
    private Integer typeFrom;

    private SearchMyStorehouseFragmentCreator() {
    }

    public static SearchMyStorehouseFragmentCreator create(@Nullable Integer num) {
        SearchMyStorehouseFragmentCreator searchMyStorehouseFragmentCreator = new SearchMyStorehouseFragmentCreator();
        searchMyStorehouseFragmentCreator.typeFrom = num;
        return searchMyStorehouseFragmentCreator;
    }

    public static void inject(SearchMyStorehouseFragment searchMyStorehouseFragment) {
        Bundle arguments = searchMyStorehouseFragment.getArguments();
        if (arguments != null && arguments.containsKey("typeFrom")) {
            searchMyStorehouseFragment.i0((Integer) arguments.get("typeFrom"));
        }
    }

    public SearchMyStorehouseFragment get() {
        Bundle bundle = new Bundle();
        Integer num = this.typeFrom;
        if (num != null) {
            bundle.putInt("typeFrom", num.intValue());
        }
        SearchMyStorehouseFragment searchMyStorehouseFragment = new SearchMyStorehouseFragment();
        searchMyStorehouseFragment.setArguments(bundle);
        return searchMyStorehouseFragment;
    }
}
