package com.jihuanshe.ui.page.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class MainActivityCreator {
    private String from;
    private String routeUrl;

    private MainActivityCreator() {
    }

    public static MainActivityCreator create() {
        return new MainActivityCreator();
    }

    public static void inject(MainActivity mainActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("routeUrl")) {
            mainActivity.n0((String) extras.get("routeUrl"));
        }
        if (extras.containsKey("from")) {
            mainActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable String str, @Nullable String str2) {
        Intent intent = new Intent(context, MainActivity.class);
        if (str != null) {
            intent.putExtra("routeUrl", str);
        }
        if (str2 != null) {
            intent.putExtra("from", str2);
        }
        return intent;
    }

    public MainActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public MainActivityCreator routeUrl(String str) {
        this.routeUrl = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, MainActivity.class);
        String str = this.routeUrl;
        if (str != null) {
            intent.putExtra("routeUrl", str);
        }
        String str2 = this.from;
        if (str2 != null) {
            intent.putExtra("from", str2);
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
        Intent intent = new Intent(context, MainActivity.class);
        String str = this.routeUrl;
        if (str != null) {
            intent.putExtra("routeUrl", str);
        }
        String str2 = this.from;
        if (str2 != null) {
            intent.putExtra("from", str2);
        }
        if (z) {
            ((Activity) obj).startActivityForResult(intent, i2);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivityForResult(intent, i2);
        }
    }
}
