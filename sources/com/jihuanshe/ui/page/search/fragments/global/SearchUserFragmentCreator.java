package com.jihuanshe.ui.page.search.fragments.global;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class SearchUserFragmentCreator {
    private SearchUserFragmentCreator() {
    }

    public static SearchUserFragmentCreator create() {
        return new SearchUserFragmentCreator();
    }

    public static void inject(SearchUserFragment searchUserFragment) {
        if (searchUserFragment.getArguments() == null) {
        }
    }

    public SearchUserFragment get() {
        Bundle bundle = new Bundle();
        SearchUserFragment searchUserFragment = new SearchUserFragment();
        searchUserFragment.setArguments(bundle);
        return searchUserFragment;
    }
}
