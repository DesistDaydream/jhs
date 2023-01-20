package com.jihuanshe.ui.page.entrepot;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SearchSoldFragmentCreator {
    private Integer type;

    private SearchSoldFragmentCreator() {
    }

    public static SearchSoldFragmentCreator create(@Nullable Integer num) {
        SearchSoldFragmentCreator searchSoldFragmentCreator = new SearchSoldFragmentCreator();
        searchSoldFragmentCreator.type = num;
        return searchSoldFragmentCreator;
    }

    public static void inject(SearchSoldFragment searchSoldFragment) {
        Bundle arguments = searchSoldFragment.getArguments();
        if (arguments != null && arguments.containsKey("type")) {
            searchSoldFragment.m0(((Integer) arguments.get("type")).intValue());
        }
    }

    public SearchSoldFragment get() {
        Bundle bundle = new Bundle();
        Integer num = this.type;
        if (num != null) {
            bundle.putInt("type", num.intValue());
        }
        SearchSoldFragment searchSoldFragment = new SearchSoldFragment();
        searchSoldFragment.setArguments(bundle);
        return searchSoldFragment;
    }
}
