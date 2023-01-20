package com.moor.imkf.lib.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.moor.imkf.lib.MoorBaseLibManager;

/* loaded from: classes2.dex */
public class MoorDensityUtil {
    private static float density = -1.0f;
    private static float mPixels;

    public static int dp2px(float f2) {
        return (int) TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    public static float dp2pxF(float f2) {
        return TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    public static float getDensity(Context context) {
        if (context == null) {
            context = MoorBaseLibManager.getInstance().getApplication();
        }
        if (density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static int getDisplayMetrics(Context context, float f2) {
        if (mPixels == 0.0f) {
            mPixels = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((f2 * mPixels) + 0.5f);
    }

    public static float getPhoneRatio(Context context) {
        return getScreenHeight(context) / getScreenWidth(context);
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenWidthOrHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
