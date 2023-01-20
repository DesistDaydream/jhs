package com.jihuanshe.ui.page.rank;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.jihuanshe.model.RankTypeInfo;

/* loaded from: classes2.dex */
public final class RankListFragmentCreator {
    private RankTypeInfo rankTypeInfo;

    private RankListFragmentCreator() {
    }

    public static RankListFragmentCreator create(@Nullable RankTypeInfo rankTypeInfo) {
        RankListFragmentCreator rankListFragmentCreator = new RankListFragmentCreator();
        rankListFragmentCreator.rankTypeInfo = rankTypeInfo;
        return rankListFragmentCreator;
    }

    public static void inject(RankListFragment rankListFragment) {
        Bundle arguments = rankListFragment.getArguments();
        if (arguments != null && arguments.containsKey("rankTypeInfo")) {
            try {
                rankListFragment.E0((RankTypeInfo) arguments.getParcelable("rankTypeInfo"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public RankListFragment get() {
        Bundle bundle = new Bundle();
        RankTypeInfo rankTypeInfo = this.rankTypeInfo;
        if (rankTypeInfo != null) {
            bundle.putParcelable("rankTypeInfo", rankTypeInfo);
        }
        RankListFragment rankListFragment = new RankListFragment();
        rankListFragment.setArguments(bundle);
        return rankListFragment;
    }
}
