package com.jihuanshe.ui.page.im;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class LikeFragmentCreator {
    private LikeFragmentCreator() {
    }

    public static LikeFragmentCreator create() {
        return new LikeFragmentCreator();
    }

    public static void inject(LikeFragment likeFragment) {
        if (likeFragment.getArguments() == null) {
        }
    }

    public LikeFragment get() {
        Bundle bundle = new Bundle();
        LikeFragment likeFragment = new LikeFragment();
        likeFragment.setArguments(bundle);
        return likeFragment;
    }
}
