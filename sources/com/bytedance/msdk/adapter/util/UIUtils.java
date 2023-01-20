package com.bytedance.msdk.adapter.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b0;
import com.effective.android.panel.Constants;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class UIUtils {
    public static final int VIVO_FILLET = 8;
    public static final int VIVO_NOTCH = 32;
    private static float a = -1.0f;
    private static int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static float f1877c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private static int f1878d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static int f1879e = -1;

    static {
        init(a.d());
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i2 && marginLayoutParams.topMargin == i3 && marginLayoutParams.rightMargin == i4 && marginLayoutParams.bottomMargin == i5) {
            return;
        }
        if (i2 != -3) {
            marginLayoutParams.leftMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.topMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.rightMargin = i4;
        }
        if (i5 != -3) {
            marginLayoutParams.bottomMargin = i5;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    private static boolean b(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 4;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean canShow(Context context, View view, int i2) {
        String str;
        if (view == null) {
            str = "adView is null.";
        } else if (view.getParent() == null) {
            str = "adView has no parent.";
        } else if (view.getWindowVisibility() != 0) {
            str = "adView window is not set to VISIBLE.";
        } else if (view.getVisibility() != 0) {
            str = "adView is not set to VISIBLE.";
        } else if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            str = "adView has invisible dimensions (w=" + view.getMeasuredWidth() + ", h=" + view.getMeasuredHeight();
        } else if (Build.VERSION.SDK_INT < 11 || view.getAlpha() >= 0.9f) {
            int width = view.getWidth();
            int height = view.getHeight();
            int[] iArr = new int[2];
            try {
                view.getLocationOnScreen(iArr);
                int screenWidth = getScreenWidth(context);
                int screenHeight = getScreenHeight(context);
                if (iArr[0] < 0 || screenWidth - iArr[0] < width) {
                    str = "adView is not fully on screen horizontally.";
                } else {
                    int i3 = (int) ((height * (100.0d - i2)) / 100.0d);
                    if (iArr[1] < 0 && Math.abs(iArr[1]) > i3) {
                        str = "adView is not visible from the top.";
                    } else if ((height + iArr[1]) - screenHeight <= i3) {
                        Logger.d("adView is visible.");
                        return isScreenOnAndNotInKeygaurdInputMode(context);
                    } else {
                        str = "adView is not visible from the bottom.";
                    }
                }
            } catch (Exception unused) {
                str = "Cannot get location on screen.";
            }
        } else {
            str = "adView is transparent.";
        }
        Logger.d(str);
        return false;
    }

    public static float dip2Px(Context context, float f2) {
        init(context);
        return (getDensity(context) * f2) + 0.5f;
    }

    public static int dp2px(Context context, float f2) {
        return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
    }

    @Nullable
    public static int[] getCoordinate(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static float getDensity(Context context) {
        init(context);
        return a;
    }

    public static int getDensityDpi(Context context) {
        init(context);
        return b;
    }

    public static int getInt(String str, Activity activity) {
        if (b0.t()) {
            try {
                Class<?> loadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(0))).intValue();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return 0;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return 0;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                return 0;
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
                return 0;
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static int getRealHeight(Context context) {
        if (context == null) {
            context = a.d();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int getRealWidth(Context context) {
        if (context == null) {
            context = a.d();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float getScaledDensity(Context context) {
        init(context);
        return f1877c;
    }

    public static int getScreenHeight(Context context) {
        init(context);
        return f1879e;
    }

    public static Bitmap getScreenShot(View view) {
        if (view == null) {
            return null;
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static int getScreenWidth(Context context) {
        init(context);
        return f1878d;
    }

    public static float getStatusBarHeight(Context context) {
        if (context == null) {
            context = a.d();
        }
        int identifier = context.getApplicationContext().getResources().getIdentifier(Constants.STATUS_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
        if (identifier > 0) {
            return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
    }

    @Nullable
    public static int[] getViewSize(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static boolean hasNotchAtHuawei(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNotchAtOPPO(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchAtVivo(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNotchScreen(Activity activity) {
        return getInt("ro.miui.notch", activity) == 1 || hasNotchAtHuawei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVivo(activity) || isAndroidPHasNotch(activity);
    }

    public static void hideBottomUIMenu(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 11 && i2 < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (i2 >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3842);
                activity.getWindow().addFlags(134217728);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void init(Context context) {
        int i2;
        int i3;
        Context d2 = context == null ? a.d() : context;
        if (d2 == null) {
            return;
        }
        DisplayMetrics displayMetrics = d2.getResources().getDisplayMetrics();
        a = displayMetrics.density;
        b = displayMetrics.densityDpi;
        f1877c = displayMetrics.scaledDensity;
        f1878d = displayMetrics.widthPixels;
        f1879e = displayMetrics.heightPixels;
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            i2 = f1878d;
            i3 = f1879e;
            if (i2 <= i3) {
                return;
            }
        } else {
            i2 = f1878d;
            i3 = f1879e;
            if (i2 >= i3) {
                return;
            }
        }
        f1878d = i3;
        f1879e = i2;
    }

    public static boolean isAndroidPHasNotch(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class<?> cls = Class.forName("android.view.WindowInsets");
                return cls.getMethod("getDisplayCutout", new Class[0]).invoke(cls, new Object[0]) != null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean isScreenOnAndNotInKeygaurdInputMode(Context context) {
        KeyguardManager keyguardManager;
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null && powerManager.isScreenOn() && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null) {
                return !keyguardManager.inKeyguardRestrictedInputMode();
            }
            return false;
        } catch (Exception e2) {
            Logger.d("adView exception:" + e2.getMessage());
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isViewVisible(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static int px2dip(Context context, float f2) {
        init(context);
        float density = getDensity(context);
        if (density <= 0.0f) {
            density = 1.0f;
        }
        return (int) ((f2 / density) + 0.5f);
    }

    public static int px2sp(Context context, float f2) {
        init(context);
        float scaledDensity = getScaledDensity(context);
        if (scaledDensity <= 0.0f) {
            scaledDensity = 1.0f;
        }
        return (int) ((f2 / scaledDensity) + 0.5f);
    }

    public static void setClickListener(boolean z, View view, View.OnClickListener onClickListener) {
        boolean z2;
        if (view == null) {
            return;
        }
        if (z) {
            view.setOnClickListener(onClickListener);
            z2 = true;
        } else {
            view.setOnClickListener(null);
            z2 = false;
        }
        view.setClickable(z2);
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener, String str) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        Logger.e("OnclickListener ", str + " is null , can not set OnClickListener !!!");
    }

    public static void setOnTouchListener(View view, View.OnTouchListener onTouchListener, String str) {
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
            return;
        }
        Logger.e("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
    }

    public static void setText(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void setViewVisibility(View view, int i2) {
        if (view == null || view.getVisibility() == i2 || !b(i2)) {
            return;
        }
        view.setVisibility(i2);
    }

    public static float sp2px(Context context, float f2) {
        init(context);
        return TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics());
    }

    public static void updateLayoutMargin(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        a(view, (ViewGroup.MarginLayoutParams) layoutParams, i2, i3, i4, i5);
    }

    public int getVirtualBarHeight(Context context) {
        if (context == null) {
            context = a.d();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels - defaultDisplay.getHeight();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
