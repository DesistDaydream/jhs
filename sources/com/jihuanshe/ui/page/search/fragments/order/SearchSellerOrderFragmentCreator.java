package com.jihuanshe.ui.page.search.fragments.order;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SearchSellerOrderFragmentCreator {
    private String type;

    private SearchSellerOrderFragmentCreator() {
    }

    public static SearchSellerOrderFragmentCreator create(@Nullable String str) {
        SearchSellerOrderFragmentCreator searchSellerOrderFragmentCreator = new SearchSellerOrderFragmentCreator();
        searchSellerOrderFragmentCreator.type = str;
        return searchSellerOrderFragmentCreator;
    }

    public static void inject(SearchSellerOrderFragment searchSellerOrderFragment) {
        Bundle arguments = searchSellerOrderFragment.getArguments();
        if (arguments != null && arguments.containsKey("type")) {
            searchSellerOrderFragment.n0((String) arguments.get("type"));
        }
    }

    public SearchSellerOrderFragment get() {
        Bundle bundle = new Bundle();
        String str = this.type;
        if (str != null) {
            bundle.putString("type", str);
        }
        SearchSellerOrderFragment searchSellerOrderFragment = new SearchSellerOrderFragment();
        searchSellerOrderFragment.setArguments(bundle);
        return searchSellerOrderFragment;
    }
}
