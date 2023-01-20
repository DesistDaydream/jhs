package com.jihuanshe.ui.page.search.fragments.global;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class GlobalSearchProductFragmentCreator {
    private GlobalSearchProductFragmentCreator() {
    }

    public static GlobalSearchProductFragmentCreator create() {
        return new GlobalSearchProductFragmentCreator();
    }

    public static void inject(GlobalSearchProductFragment globalSearchProductFragment) {
        if (globalSearchProductFragment.getArguments() == null) {
        }
    }

    public GlobalSearchProductFragment get() {
        Bundle bundle = new Bundle();
        GlobalSearchProductFragment globalSearchProductFragment = new GlobalSearchProductFragment();
        globalSearchProductFragment.setArguments(bundle);
        return globalSearchProductFragment;
    }
}
