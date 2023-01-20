package com.jihuanshe.ui.page.search.fragments.global;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SearchProductFragmentCreator {
    private Integer index;
    private String type;

    private SearchProductFragmentCreator() {
    }

    public static SearchProductFragmentCreator create(@Nullable String str, @Nullable Integer num) {
        SearchProductFragmentCreator searchProductFragmentCreator = new SearchProductFragmentCreator();
        searchProductFragmentCreator.type = str;
        searchProductFragmentCreator.index = num;
        return searchProductFragmentCreator;
    }

    public static void inject(SearchProductFragment searchProductFragment) {
        Bundle arguments = searchProductFragment.getArguments();
        if (arguments == null) {
            return;
        }
        if (arguments.containsKey("type")) {
            searchProductFragment.u0((String) arguments.get("type"));
        }
        if (arguments.containsKey("index")) {
            searchProductFragment.t0((Integer) arguments.get("index"));
        }
    }

    public SearchProductFragment get() {
        Bundle bundle = new Bundle();
        String str = this.type;
        if (str != null) {
            bundle.putString("type", str);
        }
        Integer num = this.index;
        if (num != null) {
            bundle.putInt("index", num.intValue());
        }
        SearchProductFragment searchProductFragment = new SearchProductFragment();
        searchProductFragment.setArguments(bundle);
        return searchProductFragment;
    }
}
