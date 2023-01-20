package com.jihuanshe.ui.page.entrepot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jihuanshe.model.ApplyForOrder;

/* loaded from: classes2.dex */
public final class SubmitOrderActivityCreator {
    private ApplyForOrder afOrder;
    private Boolean checked;
    private String from;

    private SubmitOrderActivityCreator() {
    }

    public static SubmitOrderActivityCreator create(@Nullable ApplyForOrder applyForOrder) {
        SubmitOrderActivityCreator submitOrderActivityCreator = new SubmitOrderActivityCreator();
        submitOrderActivityCreator.afOrder = applyForOrder;
        return submitOrderActivityCreator;
    }

    public static void inject(SubmitOrderActivity submitOrderActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("afOrder")) {
            try {
                submitOrderActivity.k0((ApplyForOrder) extras.getParcelable("afOrder"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (extras.containsKey("checked")) {
            submitOrderActivity.l0(((Boolean) extras.get("checked")).booleanValue());
        }
        if (extras.containsKey("from")) {
            submitOrderActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable ApplyForOrder applyForOrder, @Nullable Boolean bool, @Nullable String str) {
        Intent intent = new Intent(context, SubmitOrderActivity.class);
        if (applyForOrder != null) {
            intent.putExtra("afOrder", applyForOrder);
        }
        if (bool != null) {
            intent.putExtra("checked", bool);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public SubmitOrderActivityCreator checked(Boolean bool) {
        this.checked = bool;
        return this;
    }

    public SubmitOrderActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, SubmitOrderActivity.class);
        ApplyForOrder applyForOrder = this.afOrder;
        if (applyForOrder != null) {
            intent.putExtra("afOrder", applyForOrder);
        }
        Boolean bool = this.checked;
        if (bool != null) {
            intent.putExtra("checked", bool);
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
        Intent intent = new Intent(context, SubmitOrderActivity.class);
        ApplyForOrder applyForOrder = this.afOrder;
        if (applyForOrder != null) {
            intent.putExtra("afOrder", applyForOrder);
        }
        Boolean bool = this.checked;
        if (bool != null) {
            intent.putExtra("checked", bool);
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
