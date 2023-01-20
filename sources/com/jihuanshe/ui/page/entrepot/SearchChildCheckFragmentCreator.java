package com.jihuanshe.ui.page.entrepot;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class SearchChildCheckFragmentCreator {
    private String cardStatus;

    private SearchChildCheckFragmentCreator() {
    }

    public static SearchChildCheckFragmentCreator create(@Nullable String str) {
        SearchChildCheckFragmentCreator searchChildCheckFragmentCreator = new SearchChildCheckFragmentCreator();
        searchChildCheckFragmentCreator.cardStatus = str;
        return searchChildCheckFragmentCreator;
    }

    public static void inject(SearchChildCheckFragment searchChildCheckFragment) {
        Bundle arguments = searchChildCheckFragment.getArguments();
        if (arguments != null && arguments.containsKey("cardStatus")) {
            searchChildCheckFragment.p0((String) arguments.get("cardStatus"));
        }
    }

    public SearchChildCheckFragment get() {
        Bundle bundle = new Bundle();
        String str = this.cardStatus;
        if (str != null) {
            bundle.putString("cardStatus", str);
        }
        SearchChildCheckFragment searchChildCheckFragment = new SearchChildCheckFragment();
        searchChildCheckFragment.setArguments(bundle);
        return searchChildCheckFragment;
    }
}
