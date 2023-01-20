package com.tencent.qcloud.tuicore.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.tencent.qcloud.tuicore.TUIConfig;

/* loaded from: classes3.dex */
public class ScreenUtil {
    private static final String TAG = "ScreenUtil";

    public static int dip2px(float f2) {
        return (int) ((f2 * TUIConfig.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getPxByDp(float f2) {
        return (int) ((f2 * TUIConfig.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
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

    public static int[] scaledSize(int i2, int i3, int i4, int i5) {
        String str = TAG;
        Log.i(str, "scaledSize  containerWidth: " + i2 + " containerHeight: " + i3 + " realWidth: " + i4 + " realHeight: " + i5);
        float f2 = (float) i2;
        float f3 = (float) i3;
        float f4 = ((float) i4) / ((float) i5);
        if (f4 < f2 / f3) {
            i2 = (int) (f3 * f4);
        } else {
            i3 = (int) (f2 / f4);
        }
        return new int[]{i2, i3};
    }
}
