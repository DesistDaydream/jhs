package com.m7.imkfsdk.utils;

import android.content.Context;
import com.moor.imkf.lib.utils.toast.MoorToastCompat;

/* loaded from: classes2.dex */
public final class ToastUtils {
    private ToastUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void showLong(Context context, CharSequence charSequence) {
        MoorToastCompat.makeText(context.getApplicationContext(), charSequence, 1).show();
    }

    public static void showShort(Context context, CharSequence charSequence) {
        MoorToastCompat.makeText(context.getApplicationContext(), charSequence, 0).show();
    }

    public static void showShort(Context context, int i2) {
        MoorToastCompat.makeText(context.getApplicationContext(), (CharSequence) context.getString(i2), 0).show();
    }
}
