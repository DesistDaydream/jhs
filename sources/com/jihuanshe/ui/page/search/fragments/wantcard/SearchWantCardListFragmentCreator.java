package com.jihuanshe.ui.page.search.fragments.wantcard;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SearchWantCardListFragmentCreator {
    private Integer id;

    private SearchWantCardListFragmentCreator() {
    }

    public static SearchWantCardListFragmentCreator create(@Nullable Integer num) {
        SearchWantCardListFragmentCreator searchWantCardListFragmentCreator = new SearchWantCardListFragmentCreator();
        searchWantCardListFragmentCreator.id = num;
        return searchWantCardListFragmentCreator;
    }

    public static void inject(SearchWantCardListFragment searchWantCardListFragment) {
        Bundle arguments = searchWantCardListFragment.getArguments();
        if (arguments != null && arguments.containsKey("id")) {
            searchWantCardListFragment.n0((Integer) arguments.get("id"));
        }
    }

    public SearchWantCardListFragment get() {
        Bundle bundle = new Bundle();
        Integer num = this.id;
        if (num != null) {
            bundle.putInt("id", num.intValue());
        }
        SearchWantCardListFragment searchWantCardListFragment = new SearchWantCardListFragment();
        searchWantCardListFragment.setArguments(bundle);
        return searchWantCardListFragment;
    }
}
