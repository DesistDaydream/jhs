package com.jihuanshe.ui.page.entrepot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class ApplyForActivityCreator {
    private String from;

    private ApplyForActivityCreator() {
    }

    public static ApplyForActivityCreator create() {
        return new ApplyForActivityCreator();
    }

    public static void inject(ApplyForActivity applyForActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("from")) {
            applyForActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable String str) {
        Intent intent = new Intent(context, ApplyForActivity.class);
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public ApplyForActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, ApplyForActivity.class);
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
        Intent intent = new Intent(context, ApplyForActivity.class);
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
