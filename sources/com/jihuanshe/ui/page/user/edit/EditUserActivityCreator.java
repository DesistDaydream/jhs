package com.jihuanshe.ui.page.user.edit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;

/* loaded from: classes2.dex */
public final class EditUserActivityCreator {
    private String from;
    private User user;

    private EditUserActivityCreator() {
    }

    public static EditUserActivityCreator create(@Nullable User user) {
        EditUserActivityCreator editUserActivityCreator = new EditUserActivityCreator();
        editUserActivityCreator.user = user;
        return editUserActivityCreator;
    }

    public static void inject(EditUserActivity editUserActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(UserKV.f3914d)) {
            try {
                editUserActivity.m0((User) extras.getParcelable(UserKV.f3914d));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (extras.containsKey("from")) {
            editUserActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable User user, @Nullable String str) {
        Intent intent = new Intent(context, EditUserActivity.class);
        if (user != null) {
            intent.putExtra(UserKV.f3914d, user);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public EditUserActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, EditUserActivity.class);
        User user = this.user;
        if (user != null) {
            intent.putExtra(UserKV.f3914d, user);
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
        Intent intent = new Intent(context, EditUserActivity.class);
        User user = this.user;
        if (user != null) {
            intent.putExtra(UserKV.f3914d, user);
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
