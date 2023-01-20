package com.jihuanshe.ui.page.entrepot;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.jihuanshe.model.Constants;

/* loaded from: classes2.dex */
public final class SearchHouseProductFragmentCreator {
    private Integer uid;

    private SearchHouseProductFragmentCreator() {
    }

    public static SearchHouseProductFragmentCreator create(@Nullable Integer num) {
        SearchHouseProductFragmentCreator searchHouseProductFragmentCreator = new SearchHouseProductFragmentCreator();
        searchHouseProductFragmentCreator.uid = num;
        return searchHouseProductFragmentCreator;
    }

    public static void inject(SearchHouseProductFragment searchHouseProductFragment) {
        Bundle arguments = searchHouseProductFragment.getArguments();
        if (arguments != null && arguments.containsKey(Constants.KEY_PARAM_USER_ID)) {
            searchHouseProductFragment.m0(((Integer) arguments.get(Constants.KEY_PARAM_USER_ID)).intValue());
        }
    }

    public SearchHouseProductFragment get() {
        Bundle bundle = new Bundle();
        Integer num = this.uid;
        if (num != null) {
            bundle.putInt(Constants.KEY_PARAM_USER_ID, num.intValue());
        }
        SearchHouseProductFragment searchHouseProductFragment = new SearchHouseProductFragment();
        searchHouseProductFragment.setArguments(bundle);
        return searchHouseProductFragment;
    }
}
