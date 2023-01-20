package com.jihuanshe.ui.page.shop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class AddCardActivityCreator {
    private String from;
    private Integer type;
    private Integer wid;

    private AddCardActivityCreator() {
    }

    public static AddCardActivityCreator create(@Nullable Integer num, @Nullable Integer num2) {
        AddCardActivityCreator addCardActivityCreator = new AddCardActivityCreator();
        addCardActivityCreator.type = num;
        addCardActivityCreator.wid = num2;
        return addCardActivityCreator;
    }

    public static void inject(AddCardActivity addCardActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("type")) {
            addCardActivity.e0(((Integer) extras.get("type")).intValue());
        }
        if (extras.containsKey("wid")) {
            addCardActivity.f0(((Integer) extras.get("wid")).intValue());
        }
        if (extras.containsKey("from")) {
            addCardActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable Integer num2, @Nullable String str) {
        Intent intent = new Intent(context, AddCardActivity.class);
        if (num != null) {
            intent.putExtra("type", num);
        }
        if (num2 != null) {
            intent.putExtra("wid", num2);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public AddCardActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, AddCardActivity.class);
        Integer num = this.type;
        if (num != null) {
            intent.putExtra("type", num);
        }
        Integer num2 = this.wid;
        if (num2 != null) {
            intent.putExtra("wid", num2);
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
        Intent intent = new Intent(context, AddCardActivity.class);
        Integer num = this.type;
        if (num != null) {
            intent.putExtra("type", num);
        }
        Integer num2 = this.wid;
        if (num2 != null) {
            intent.putExtra("wid", num2);
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
