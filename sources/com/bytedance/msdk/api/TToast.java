package com.bytedance.msdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/* loaded from: classes.dex */
public final class TToast {
    private static Toast a;

    @SuppressLint({"ShowToast"})
    private static Toast a(Context context) {
        if (context == null) {
            return a;
        }
        Toast makeText = Toast.makeText(context.getApplicationContext(), "", 0);
        a = makeText;
        return makeText;
    }

    public static void reset() {
        a = null;
    }

    public static void show(Context context, String str) {
        show(context, str, 0);
    }

    public static void show(Context context, String str, int i2) {
        Toast a2 = a(context);
        if (a2 != null) {
            a2.setDuration(i2);
            a2.setText(String.valueOf(str));
            a2.show();
            return;
        }
        Log.i("TToast", "toast msg: " + String.valueOf(str));
    }
}
