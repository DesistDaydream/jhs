package com.jihuanshe.base.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class GlobalToastActivityCreator {
    private String content;

    private GlobalToastActivityCreator() {
    }

    public static GlobalToastActivityCreator create(@Nullable String str) {
        GlobalToastActivityCreator globalToastActivityCreator = new GlobalToastActivityCreator();
        globalToastActivityCreator.content = str;
        return globalToastActivityCreator;
    }

    public static void inject(GlobalToastActivity globalToastActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("content")) {
            globalToastActivity.O((String) extras.get("content"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable String str) {
        Intent intent = new Intent(context, GlobalToastActivity.class);
        if (str != null) {
            intent.putExtra("content", str);
        }
        return intent;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, GlobalToastActivity.class);
        String str = this.content;
        if (str != null) {
            intent.putExtra("content", str);
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
        Intent intent = new Intent(context, GlobalToastActivity.class);
        String str = this.content;
        if (str != null) {
            intent.putExtra("content", str);
        }
        if (z) {
            ((Activity) obj).startActivityForResult(intent, i2);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivityForResult(intent, i2);
        }
    }
}
