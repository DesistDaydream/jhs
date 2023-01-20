package com.jihuanshe.ui.page.user.wish;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class DesireFragmentCreator {
    private DesireFragmentCreator() {
    }

    public static DesireFragmentCreator create() {
        return new DesireFragmentCreator();
    }

    public static void inject(DesireFragment desireFragment) {
        if (desireFragment.getArguments() == null) {
        }
    }

    public DesireFragment get() {
        Bundle bundle = new Bundle();
        DesireFragment desireFragment = new DesireFragment();
        desireFragment.setArguments(bundle);
        return desireFragment;
    }
}
