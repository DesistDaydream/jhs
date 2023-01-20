package com.jihuanshe.ui.page.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class CommonWebViewActivityCreator {
    private String from;
    private Boolean showHeard;
    private String url;
    private String urlTitle;

    private CommonWebViewActivityCreator() {
    }

    public static CommonWebViewActivityCreator create(@Nullable String str) {
        CommonWebViewActivityCreator commonWebViewActivityCreator = new CommonWebViewActivityCreator();
        commonWebViewActivityCreator.url = str;
        return commonWebViewActivityCreator;
    }

    public static void inject(CommonWebViewActivity commonWebViewActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("url")) {
            commonWebViewActivity.u0((String) extras.get("url"));
        }
        if (extras.containsKey("showHeard")) {
            commonWebViewActivity.s0(((Boolean) extras.get("showHeard")).booleanValue());
        }
        if (extras.containsKey("urlTitle")) {
            commonWebViewActivity.v0((String) extras.get("urlTitle"));
        }
        if (extras.containsKey("from")) {
            commonWebViewActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3) {
        Intent intent = new Intent(context, CommonWebViewActivity.class);
        if (str != null) {
            intent.putExtra("url", str);
        }
        if (bool != null) {
            intent.putExtra("showHeard", bool);
        }
        if (str2 != null) {
            intent.putExtra("urlTitle", str2);
        }
        if (str3 != null) {
            intent.putExtra("from", str3);
        }
        return intent;
    }

    public CommonWebViewActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public CommonWebViewActivityCreator showHeard(Boolean bool) {
        this.showHeard = bool;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, CommonWebViewActivity.class);
        String str = this.url;
        if (str != null) {
            intent.putExtra("url", str);
        }
        Boolean bool = this.showHeard;
        if (bool != null) {
            intent.putExtra("showHeard", bool);
        }
        String str2 = this.urlTitle;
        if (str2 != null) {
            intent.putExtra("urlTitle", str2);
        }
        String str3 = this.from;
        if (str3 != null) {
            intent.putExtra("from", str3);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public CommonWebViewActivityCreator urlTitle(String str) {
        this.urlTitle = str;
        return this;
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
        Intent intent = new Intent(context, CommonWebViewActivity.class);
        String str = this.url;
        if (str != null) {
            intent.putExtra("url", str);
        }
        Boolean bool = this.showHeard;
        if (bool != null) {
            intent.putExtra("showHeard", bool);
        }
        String str2 = this.urlTitle;
        if (str2 != null) {
            intent.putExtra("urlTitle", str2);
        }
        String str3 = this.from;
        if (str3 != null) {
            intent.putExtra("from", str3);
        }
        if (z) {
            ((Activity) obj).startActivityForResult(intent, i2);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivityForResult(intent, i2);
        }
    }
}
