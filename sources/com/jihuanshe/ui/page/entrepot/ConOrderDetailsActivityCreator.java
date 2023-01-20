package com.jihuanshe.ui.page.entrepot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class ConOrderDetailsActivityCreator {
    private String from;
    private Integer orderId;
    private Integer typeOrder;

    private ConOrderDetailsActivityCreator() {
    }

    public static ConOrderDetailsActivityCreator create(@Nullable Integer num, @Nullable Integer num2) {
        ConOrderDetailsActivityCreator conOrderDetailsActivityCreator = new ConOrderDetailsActivityCreator();
        conOrderDetailsActivityCreator.orderId = num;
        conOrderDetailsActivityCreator.typeOrder = num2;
        return conOrderDetailsActivityCreator;
    }

    public static void inject(ConOrderDetailsActivity conOrderDetailsActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("orderId")) {
            conOrderDetailsActivity.k0((Integer) extras.get("orderId"));
        }
        if (extras.containsKey("typeOrder")) {
            conOrderDetailsActivity.l0((Integer) extras.get("typeOrder"));
        }
        if (extras.containsKey("from")) {
            conOrderDetailsActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable Integer num2, @Nullable String str) {
        Intent intent = new Intent(context, ConOrderDetailsActivity.class);
        if (num != null) {
            intent.putExtra("orderId", num);
        }
        if (num2 != null) {
            intent.putExtra("typeOrder", num2);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public ConOrderDetailsActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, ConOrderDetailsActivity.class);
        Integer num = this.orderId;
        if (num != null) {
            intent.putExtra("orderId", num);
        }
        Integer num2 = this.typeOrder;
        if (num2 != null) {
            intent.putExtra("typeOrder", num2);
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
        Intent intent = new Intent(context, ConOrderDetailsActivity.class);
        Integer num = this.orderId;
        if (num != null) {
            intent.putExtra("orderId", num);
        }
        Integer num2 = this.typeOrder;
        if (num2 != null) {
            intent.putExtra("typeOrder", num2);
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
