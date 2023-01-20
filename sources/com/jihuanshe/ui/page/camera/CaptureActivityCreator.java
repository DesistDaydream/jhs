package com.jihuanshe.ui.page.camera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class CaptureActivityCreator {
    private String from;
    private Float ratio;

    private CaptureActivityCreator() {
    }

    public static CaptureActivityCreator create(@Nullable Float f2) {
        CaptureActivityCreator captureActivityCreator = new CaptureActivityCreator();
        captureActivityCreator.ratio = f2;
        return captureActivityCreator;
    }

    public static void inject(CaptureActivity captureActivity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey("ratio")) {
            captureActivity.e0((Float) extras.get("ratio"));
        }
        if (extras.containsKey("from")) {
            captureActivity.U((String) extras.get("from"));
        }
    }

    public static Intent newIntent(@NonNull Context context, @Nullable Float f2, @Nullable String str) {
        Intent intent = new Intent(context, CaptureActivity.class);
        if (f2 != null) {
            intent.putExtra("ratio", f2);
        }
        if (str != null) {
            intent.putExtra("from", str);
        }
        return intent;
    }

    public CaptureActivityCreator from(String str) {
        this.from = str;
        return this;
    }

    public void start(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, CaptureActivity.class);
        Float f2 = this.ratio;
        if (f2 != null) {
            intent.putExtra("ratio", f2);
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
        Intent intent = new Intent(context, CaptureActivity.class);
        Float f2 = this.ratio;
        if (f2 != null) {
            intent.putExtra("ratio", f2);
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
