package com.jihuanshe.ui.page.search.fragments.global;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class GlobalSearchFragmentCreator {
    private GlobalSearchFragmentCreator() {
    }

    public static GlobalSearchFragmentCreator create() {
        return new GlobalSearchFragmentCreator();
    }

    public static void inject(GlobalSearchFragment globalSearchFragment) {
        if (globalSearchFragment.getArguments() == null) {
        }
    }

    public GlobalSearchFragment get() {
        Bundle bundle = new Bundle();
        GlobalSearchFragment globalSearchFragment = new GlobalSearchFragment();
        globalSearchFragment.setArguments(bundle);
        return globalSearchFragment;
    }
}
