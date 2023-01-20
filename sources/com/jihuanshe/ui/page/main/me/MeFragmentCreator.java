package com.jihuanshe.ui.page.main.me;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class MeFragmentCreator {
    private MeFragmentCreator() {
    }

    public static MeFragmentCreator create() {
        return new MeFragmentCreator();
    }

    public static void inject(MeFragment meFragment) {
        if (meFragment.getArguments() == null) {
        }
    }

    public MeFragment get() {
        Bundle bundle = new Bundle();
        MeFragment meFragment = new MeFragment();
        meFragment.setArguments(bundle);
        return meFragment;
    }
}
