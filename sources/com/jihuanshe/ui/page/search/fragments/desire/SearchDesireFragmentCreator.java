package com.jihuanshe.ui.page.search.fragments.desire;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class SearchDesireFragmentCreator {
    private SearchDesireFragmentCreator() {
    }

    public static SearchDesireFragmentCreator create() {
        return new SearchDesireFragmentCreator();
    }

    public static void inject(SearchDesireFragment searchDesireFragment) {
        if (searchDesireFragment.getArguments() == null) {
        }
    }

    public SearchDesireFragment get() {
        Bundle bundle = new Bundle();
        SearchDesireFragment searchDesireFragment = new SearchDesireFragment();
        searchDesireFragment.setArguments(bundle);
        return searchDesireFragment;
    }
}
