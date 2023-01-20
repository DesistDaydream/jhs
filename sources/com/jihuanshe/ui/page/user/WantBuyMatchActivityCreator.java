package com.jihuanshe.ui.page.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class WantBuyMatchActivityCreator {
    private String from;
    private Integer wid;

    private WantBuyMatchActivityCreator() {
    }

    public static WantBuyMatchActivityCreator create(@Nullable Integer num) {
        WantBuyMatchActivityCreator wantBuyMatchActivityCreator = new WantBuyMatchActivityCreator();
        wantBuyMatchActivityCreator.wid = num;
        return wantBuyMatchActivityCreator;
    }

    public static void inject(WantBuyMatchActivity wantBuyMatchActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("wid")) {
            wantBuyMatchActivity.e0((Integer) extras.get("wid"));
        }
        if (extras.containsKey("from")) {
            wantBuyMatchActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable String str) {
        Intent intent = new Intent(context, WantBuyMatchActivity.class);
        if (num != null) {
            intent.putExtra("wid", num);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public WantBuyMatchActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, WantBuyMatchActivity.class);
        Integer num = this.wid;
        if (num != null) {
            intent.putExtra("wid", num);
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
        Intent intent = new Intent(context, WantBuyMatchActivity.class);
        Integer num = this.wid;
        if (num != null) {
            intent.putExtra("wid", num);
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
