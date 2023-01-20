package com.jihuanshe.ui.page.photo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import e.l.r.r0;

/* loaded from: classes2.dex */
public final class RecentPhotoFragmentCreator {
    private String gameKey;
    private Integer versionId;

    private RecentPhotoFragmentCreator() {
    }

    public static RecentPhotoFragmentCreator create(@Nullable String str, @Nullable Integer num) {
        RecentPhotoFragmentCreator recentPhotoFragmentCreator = new RecentPhotoFragmentCreator();
        recentPhotoFragmentCreator.gameKey = str;
        recentPhotoFragmentCreator.versionId = num;
        return recentPhotoFragmentCreator;
    }

    public static void inject(RecentPhotoFragment recentPhotoFragment) {
        Bundle arguments = recentPhotoFragment.getArguments();
        if (arguments == null) {
            return;
        }
        if (arguments.containsKey(r0.f14314h)) {
            recentPhotoFragment.l0((String) arguments.get(r0.f14314h));
        }
        if (arguments.containsKey("versionId")) {
            recentPhotoFragment.m0((Integer) arguments.get("versionId"));
        }
    }

    public RecentPhotoFragment get() {
        Bundle bundle = new Bundle();
        String str = this.gameKey;
        if (str != null) {
            bundle.putString(r0.f14314h, str);
        }
        Integer num = this.versionId;
        if (num != null) {
            bundle.putInt("versionId", num.intValue());
        }
        RecentPhotoFragment recentPhotoFragment = new RecentPhotoFragment();
        recentPhotoFragment.setArguments(bundle);
        return recentPhotoFragment;
    }
}
