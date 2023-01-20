package com.jihuanshe.ui.page.entrepot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class SubmitOrderReturnActivityCreator {
    private String from;
    private Integer orderId;

    private SubmitOrderReturnActivityCreator() {
    }

    public static SubmitOrderReturnActivityCreator create(@Nullable Integer num) {
        SubmitOrderReturnActivityCreator submitOrderReturnActivityCreator = new SubmitOrderReturnActivityCreator();
        submitOrderReturnActivityCreator.orderId = num;
        return submitOrderReturnActivityCreator;
    }

    public static void inject(SubmitOrderReturnActivity submitOrderReturnActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("orderId")) {
            submitOrderReturnActivity.e0((Integer) extras.get("orderId"));
        }
        if (extras.containsKey("from")) {
            submitOrderReturnActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable String str) {
        Intent intent = new Intent(context, SubmitOrderReturnActivity.class);
        if (num != null) {
            intent.putExtra("orderId", num);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public SubmitOrderReturnActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, SubmitOrderReturnActivity.class);
        Integer num = this.orderId;
        if (num != null) {
            intent.putExtra("orderId", num);
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
        Intent intent = new Intent(context, SubmitOrderReturnActivity.class);
        Integer num = this.orderId;
        if (num != null) {
            intent.putExtra("orderId", num);
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
