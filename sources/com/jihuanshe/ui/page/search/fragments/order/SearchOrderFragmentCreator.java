package com.jihuanshe.ui.page.search.fragments.order;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SearchOrderFragmentCreator {
    private String type;

    private SearchOrderFragmentCreator() {
    }

    public static SearchOrderFragmentCreator create(@Nullable String str) {
        SearchOrderFragmentCreator searchOrderFragmentCreator = new SearchOrderFragmentCreator();
        searchOrderFragmentCreator.type = str;
        return searchOrderFragmentCreator;
    }

    public static void inject(SearchOrderFragment searchOrderFragment) {
        Bundle arguments = searchOrderFragment.getArguments();
        if (arguments != null && arguments.containsKey("type")) {
            searchOrderFragment.l0((String) arguments.get("type"));
        }
    }

    public SearchOrderFragment get() {
        Bundle bundle = new Bundle();
        String str = this.type;
        if (str != null) {
            bundle.putString("type", str);
        }
        SearchOrderFragment searchOrderFragment = new SearchOrderFragment();
        searchOrderFragment.setArguments(bundle);
        return searchOrderFragment;
    }
}
