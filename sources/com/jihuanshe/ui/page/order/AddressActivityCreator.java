package com.jihuanshe.ui.page.order;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class AddressActivityCreator {
    private String from;
    private Boolean manager;

    private AddressActivityCreator() {
    }

    public static AddressActivityCreator create() {
        return new AddressActivityCreator();
    }

    public static void inject(AddressActivity addressActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("manager")) {
            addressActivity.c0(((Boolean) extras.get("manager")).booleanValue());
        }
        if (extras.containsKey("from")) {
            addressActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Boolean bool, @Nullable String str) {
        Intent intent = new Intent(context, AddressActivity.class);
        if (bool != null) {
            intent.putExtra("manager", bool);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public AddressActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public AddressActivityCreator manager(Boolean bool) {
        this.manager = bool;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, AddressActivity.class);
        Boolean bool = this.manager;
        if (bool != null) {
            intent.putExtra("manager", bool);
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
        Intent intent = new Intent(context, AddressActivity.class);
        Boolean bool = this.manager;
        if (bool != null) {
            intent.putExtra("manager", bool);
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
