package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    @RequiresApi(19)
    /* loaded from: classes.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static void showAsDropDown(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
            popupWindow.showAsDropDown(view, i2, i3, i4);
        }
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static boolean getOverlapAnchor(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @DoNotInline
        public static int getWindowLayoutType(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @DoNotInline
        public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        @DoNotInline
        public static void setWindowLayoutType(PopupWindow popupWindow, int i2) {
            popupWindow.setWindowLayoutType(i2);
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow popupWindow) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Api23Impl.getOverlapAnchor(popupWindow);
        }
        if (i2 >= 21) {
            if (!sOverlapAnchorFieldAttempted) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    sOverlapAnchorField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                sOverlapAnchorFieldAttempted = true;
            }
            Field field = sOverlapAnchorField;
            if (field != null) {
                try {
                    return ((Boolean) field.get(popupWindow)).booleanValue();
                } catch (IllegalAccessException e3) {
                    Log.i(TAG, "Could not get overlap anchor field in PopupWindow", e3);
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public static int getWindowLayoutType(@NonNull PopupWindow popupWindow) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getWindowLayoutType(popupWindow);
        }
        if (!sGetWindowLayoutTypeMethodAttempted) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                sGetWindowLayoutTypeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            sGetWindowLayoutTypeMethodAttempted = true;
        }
        Method method = sGetWindowLayoutTypeMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(popupWindow, new Object[0])).intValue();
            } catch (Exception unused2) {
            }
        }
        return 0;
    }

    public static void setOverlapAnchor(@NonNull PopupWindow popupWindow, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            Api23Impl.setOverlapAnchor(popupWindow, z);
        } else if (i2 >= 21) {
            if (!sOverlapAnchorFieldAttempted) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    sOverlapAnchorField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                sOverlapAnchorFieldAttempted = true;
            }
            Field field = sOverlapAnchorField;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e3) {
                    Log.i(TAG, "Could not set overlap anchor field in PopupWindow", e3);
                }
            }
        }
    }

    public static void setWindowLayoutType(@NonNull PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setWindowLayoutType(popupWindow, i2);
            return;
        }
        if (!sSetWindowLayoutTypeMethodAttempted) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                sSetWindowLayoutTypeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            sSetWindowLayoutTypeMethodAttempted = true;
        }
        Method method = sSetWindowLayoutTypeMethod;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception unused2) {
            }
        }
    }

    public static void showAsDropDown(@NonNull PopupWindow popupWindow, @NonNull View view, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            Api19Impl.showAsDropDown(popupWindow, view, i2, i3, i4);
            return;
        }
        if ((GravityCompat.getAbsoluteGravity(i4, ViewCompat.getLayoutDirection(view)) & 7) == 5) {
            i2 -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i2, i3);
    }
}
