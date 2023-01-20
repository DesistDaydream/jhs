package com.jihuanshe.ui.page;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class EmptyFragmentCreator {
    private EmptyFragmentCreator() {
    }

    public static EmptyFragmentCreator create() {
        return new EmptyFragmentCreator();
    }

    public static void inject(EmptyFragment emptyFragment) {
        if (emptyFragment.getArguments() == null) {
        }
    }

    public EmptyFragment get() {
        Bundle bundle = new Bundle();
        EmptyFragment emptyFragment = new EmptyFragment();
        emptyFragment.setArguments(bundle);
        return emptyFragment;
    }
}
