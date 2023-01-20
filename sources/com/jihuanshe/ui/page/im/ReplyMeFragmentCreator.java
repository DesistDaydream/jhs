package com.jihuanshe.ui.page.im;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class ReplyMeFragmentCreator {
    private ReplyMeFragmentCreator() {
    }

    public static ReplyMeFragmentCreator create() {
        return new ReplyMeFragmentCreator();
    }

    public static void inject(ReplyMeFragment replyMeFragment) {
        if (replyMeFragment.getArguments() == null) {
        }
    }

    public ReplyMeFragment get() {
        Bundle bundle = new Bundle();
        ReplyMeFragment replyMeFragment = new ReplyMeFragment();
        replyMeFragment.setArguments(bundle);
        return replyMeFragment;
    }
}
