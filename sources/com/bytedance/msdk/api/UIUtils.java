package com.bytedance.msdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.effective.android.panel.Constants;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class UIUtils {
    public static final int VIVO_FILLET = 8;
    public static final int VIVO_NOTCH = 32;

    public static int dip2px(Context context, float f2) {
        return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
    }

    public static float getHeight(Activity activity) {
        hideBottomUIMenu(activity);
        float realHeight = getRealHeight(activity);
        if (hasNotchScreen(activity)) {
            realHeight -= getStatusBarHeight(activity);
        }
        return px2dip(activity, realHeight);
    }

    public static int getInt(String str, Activity activity) {
        if (isMiui()) {
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
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float getScreenWidthDp(Context context) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = context.getResources().getDisplayMetrics().widthPixels;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (f3 / f2) + 0.5f;
    }

    public static float getStatusBarHeight(Context context) {
        int identifier = context.getApplicationContext().getResources().getIdentifier(Constants.STATUS_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
        if (identifier > 0) {
            return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
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
        if (getInt("ro.miui.notch", activity) == 1 || hasNotchAtHuawei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVivo(activity)) {
            return false;
        }
        isAndroidPHasNotch(activity);
        return false;
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

    public static boolean isMiui() {
        return Class.forName("miui.os.Build") != null;
    }

    public static int px2dip(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static void removeFromParent(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
