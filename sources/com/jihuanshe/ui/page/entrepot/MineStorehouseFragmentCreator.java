package com.jihuanshe.ui.page.entrepot;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class MineStorehouseFragmentCreator {
    private String inType;

    private MineStorehouseFragmentCreator() {
    }

    public static MineStorehouseFragmentCreator create(@Nullable String str) {
        MineStorehouseFragmentCreator mineStorehouseFragmentCreator = new MineStorehouseFragmentCreator();
        mineStorehouseFragmentCreator.inType = str;
        return mineStorehouseFragmentCreator;
    }

    public static void inject(MineStorehouseFragment mineStorehouseFragment) {
        Bundle arguments = mineStorehouseFragment.getArguments();
        if (arguments != null && arguments.containsKey("inType")) {
            mineStorehouseFragment.x0((String) arguments.get("inType"));
        }
    }

    public MineStorehouseFragment get() {
        Bundle bundle = new Bundle();
        String str = this.inType;
        if (str != null) {
            bundle.putString("inType", str);
        }
        MineStorehouseFragment mineStorehouseFragment = new MineStorehouseFragment();
        mineStorehouseFragment.setArguments(bundle);
        return mineStorehouseFragment;
    }
}
