package com.jihuanshe.ui.page.search.fragments.sell;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class SearchSellingFragmentCreator {
    private SearchSellingFragmentCreator() {
    }

    public static SearchSellingFragmentCreator create() {
        return new SearchSellingFragmentCreator();
    }

    public static void inject(SearchSellingFragment searchSellingFragment) {
        if (searchSellingFragment.getArguments() == null) {
        }
    }

    public SearchSellingFragment get() {
        Bundle bundle = new Bundle();
        SearchSellingFragment searchSellingFragment = new SearchSellingFragment();
        searchSellingFragment.setArguments(bundle);
        return searchSellingFragment;
    }
}
