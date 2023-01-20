package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.effective.android.panel.Constants;

/* loaded from: classes.dex */
public class aq {
    private static DisplayMetrics a;
    private static float b;

    public static Rect a(Context context) {
        DisplayMetrics f2 = f(context);
        try {
            if (f2.widthPixels > f2.heightPixels) {
                return new Rect(0, 0, f2.heightPixels, f2.widthPixels);
            }
            return new Rect(0, 0, f2.widthPixels, f2.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(context).width();
    }

    public static int c(Context context) {
        return a(context).height();
    }

    public static Rect d(Context context) {
        DisplayMetrics f2 = f(context);
        return new Rect(0, 0, f2.widthPixels, f2.heightPixels);
    }

    public static float e(Context context) {
        if (b < 0.01d) {
            b = f(context).density;
        }
        return b;
    }

    public static DisplayMetrics f(Context context) {
        try {
            DisplayMetrics displayMetrics = a;
            if (displayMetrics != null && displayMetrics.widthPixels > 0) {
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (bc.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            }
            a = displayMetrics2;
        } catch (Throwable th) {
            a = new DisplayMetrics();
            bj.a().a(th);
        }
        return a;
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier(Constants.STATUS_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID));
    }

    public static int b(Context context, int i2) {
        try {
            return (int) (i2 * e(context));
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, int i2) {
        try {
            return (int) (i2 / e(context));
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
