package com.jihuanshe.ui.page.im;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class AtMeFragmentCreator {
    private AtMeFragmentCreator() {
    }

    public static AtMeFragmentCreator create() {
        return new AtMeFragmentCreator();
    }

    public static void inject(AtMeFragment atMeFragment) {
        if (atMeFragment.getArguments() == null) {
        }
    }

    public AtMeFragment get() {
        Bundle bundle = new Bundle();
        AtMeFragment atMeFragment = new AtMeFragment();
        atMeFragment.setArguments(bundle);
        return atMeFragment;
    }
}
