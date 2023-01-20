package com.jihuanshe.ui.page.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.model.Constants;

/* loaded from: classes2.dex */
public final class FansActivityCreator {
    private String from;
    private Integer uid;

    private FansActivityCreator() {
    }

    public static FansActivityCreator create(@Nullable Integer num) {
        FansActivityCreator fansActivityCreator = new FansActivityCreator();
        fansActivityCreator.uid = num;
        return fansActivityCreator;
    }

    public static void inject(FansActivity fansActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(Constants.KEY_PARAM_USER_ID)) {
            fansActivity.e0((Integer) extras.get(Constants.KEY_PARAM_USER_ID));
        }
        if (extras.containsKey("from")) {
            fansActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable String str) {
        Intent intent = new Intent(context, FansActivity.class);
        if (num != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public FansActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, FansActivity.class);
        Integer num = this.uid;
        if (num != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num);
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
        Intent intent = new Intent(context, FansActivity.class);
        Integer num = this.uid;
        if (num != null) {
            intent.putExtra(Constants.KEY_PARAM_USER_ID, num);
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
