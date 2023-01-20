package com.jihuanshe.ui.page.entrepot;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class SearchChildNoPassFragmentCreator {
    private SearchChildNoPassFragmentCreator() {
    }

    public static SearchChildNoPassFragmentCreator create() {
        return new SearchChildNoPassFragmentCreator();
    }

    public static void inject(SearchChildNoPassFragment searchChildNoPassFragment) {
        if (searchChildNoPassFragment.getArguments() == null) {
        }
    }

    public SearchChildNoPassFragment get() {
        Bundle bundle = new Bundle();
        SearchChildNoPassFragment searchChildNoPassFragment = new SearchChildNoPassFragment();
        searchChildNoPassFragment.setArguments(bundle);
        return searchChildNoPassFragment;
    }
}
