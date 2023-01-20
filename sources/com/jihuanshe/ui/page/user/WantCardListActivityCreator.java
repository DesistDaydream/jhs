package com.jihuanshe.ui.page.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.model.WantBuyList;

/* loaded from: classes2.dex */
public final class WantCardListActivityCreator {
    private String from;
    private WantBuyList wantBuyList;

    private WantCardListActivityCreator() {
    }

    public static WantCardListActivityCreator create(@Nullable WantBuyList wantBuyList) {
        WantCardListActivityCreator wantCardListActivityCreator = new WantCardListActivityCreator();
        wantCardListActivityCreator.wantBuyList = wantBuyList;
        return wantCardListActivityCreator;
    }

    public static void inject(WantCardListActivity wantCardListActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("wantBuyList")) {
            try {
                wantCardListActivity.g0((WantBuyList) extras.getParcelable("wantBuyList"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (extras.containsKey("from")) {
            wantCardListActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable WantBuyList wantBuyList, @Nullable String str) {
        Intent intent = new Intent(context, WantCardListActivity.class);
        if (wantBuyList != null) {
            intent.putExtra("wantBuyList", wantBuyList);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public WantCardListActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, WantCardListActivity.class);
        WantBuyList wantBuyList = this.wantBuyList;
        if (wantBuyList != null) {
            intent.putExtra("wantBuyList", wantBuyList);
        }
        String str = this.from;
        if (str != null) {
            intent.putExtra("from", str);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void start(Object obj, int i2) {
        Context context;
        boolean z = obj instanceof Activity;
        if (z) {
            context = (Context) obj;
        } else if (obj instanceof Fragment) {
            context = ((Fragment) obj).getContext();
        } else {
            throw new IllegalStateException("objectHost must be one of activity or fragment");
        }
        Intent intent = new Intent(context, WantCardListActivity.class);
        WantBuyList wantBuyList = this.wantBuyList;
        if (wantBuyList != null) {
            intent.putExtra("wantBuyList", wantBuyList);
        }
        String str = this.from;
        if (str != null) {
            intent.putExtra("from", str);
        }
        if (z) {
            ((Activity) obj).startActivityForResult(intent, i2);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivityForResult(intent, i2);
        }
    }
}
