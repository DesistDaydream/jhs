package com.jihuanshe.ui.page.entrepot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class StorehouseActivityCreator {
    private String from;
    private Integer inType;

    private StorehouseActivityCreator() {
    }

    public static StorehouseActivityCreator create(@Nullable Integer num) {
        StorehouseActivityCreator storehouseActivityCreator = new StorehouseActivityCreator();
        storehouseActivityCreator.inType = num;
        return storehouseActivityCreator;
    }

    public static void inject(StorehouseActivity storehouseActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("inType")) {
            storehouseActivity.b0((Integer) extras.get("inType"));
        }
        if (extras.containsKey("from")) {
            storehouseActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Integer num, @Nullable String str) {
        Intent intent = new Intent(context, StorehouseActivity.class);
        if (num != null) {
            intent.putExtra("inType", num);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public StorehouseActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, StorehouseActivity.class);
        Integer num = this.inType;
        if (num != null) {
            intent.putExtra("inType", num);
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
        Intent intent = new Intent(context, StorehouseActivity.class);
        Integer num = this.inType;
        if (num != null) {
            intent.putExtra("inType", num);
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
