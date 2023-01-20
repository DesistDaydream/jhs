package com.effective.android.panel.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.effective.android.panel.Constants;
import com.effective.android.panel.R;
import h.k2.k;
import h.k2.v.f0;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0018\u0010\u000eJ\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001a\u0010\u0006J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b'\u0010&J\u001f\u0010*\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b,\u0010\u0006J\u001d\u0010.\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/effective/android/panel/utils/DisplayUtil;", "", "Landroid/view/Window;", "window", "", "getToolbarHeight", "(Landroid/view/Window;)I", "Landroid/view/View;", "view", "", "getLocationOnScreen", "(Landroid/view/View;)[I", "", "contentViewCanDrawStatusBarArea", "(Landroid/view/Window;)Z", "getContentViewHeight", "getScreenHeightWithSystemUI", "Landroid/content/Context;", "context", "getScreenHeightWithoutNavigationBar", "(Landroid/content/Context;)I", "getScreenHeightWithoutSystemUI", "Landroid/app/Activity;", "activity", "isFullScreen", "(Landroid/app/Activity;)Z", "getStatusBarHeight", "getNavigationBarHeight", "(Landroid/content/Context;Landroid/view/Window;)I", "Landroid/content/res/Resources;", "res", "", "key", "getInternalDimensionSize", "(Landroid/content/res/Resources;Ljava/lang/String;)I", "isPortrait", "(Landroid/content/Context;)Z", "isNavigationBarShow", "(Landroid/content/Context;Landroid/view/Window;)Z", "isNavBarVisible", "", "dipValue", "dip2px", "(Landroid/content/Context;F)I", "getScreenRealHeight", "flag", "hasSystemUIFlag", "(Landroid/view/Window;I)Z", "<init>", "()V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DisplayUtil {
    public static final DisplayUtil INSTANCE = new DisplayUtil();

    private DisplayUtil() {
    }

    @k
    public static final boolean contentViewCanDrawStatusBarArea(@d Window window) {
        return getLocationOnScreen(window.getDecorView().findViewById(16908290))[1] == 0;
    }

    @k
    public static final int dip2px(@d Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @k
    public static final int getContentViewHeight(@d Window window) {
        return window.getDecorView().findViewById(16908290).getHeight();
    }

    private final int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, Constants.DIMEN, Constants.ANDROID);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @k
    @d
    public static final int[] getLocationOnScreen(@d View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    @k
    public static final int getNavigationBarHeight(@d Context context, @d Window window) {
        String obj;
        int i2;
        int stableInsetBottom;
        int internalDimensionSize = INSTANCE.getInternalDimensionSize(context.getResources(), Constants.NAVIGATION_BAR_HEIGHT_RES_NAME);
        String str = Build.MANUFACTURER;
        if (str == null) {
            obj = "";
        } else {
            int length = str.length() - 1;
            int i3 = 0;
            boolean z = false;
            while (i3 <= length) {
                boolean z2 = str.charAt(!z ? i3 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i3++;
                } else {
                    z = true;
                }
            }
            obj = str.subSequence(i3, length + 1).toString();
        }
        if (obj != null) {
            return (!StringsKt__StringsKt.V2(obj.toLowerCase(), "samsung", false, 2, null) || (i2 = Build.VERSION.SDK_INT) < 28 || i2 >= 29 || (stableInsetBottom = window.getDecorView().getRootWindowInsets().getStableInsetBottom()) >= internalDimensionSize) ? internalDimensionSize : stableInsetBottom;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @k
    public static final int getScreenHeightWithSystemUI(@d Window window) {
        return window.getDecorView().getHeight();
    }

    @k
    public static final int getScreenHeightWithoutNavigationBar(@d Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    @k
    public static final int getScreenHeightWithoutSystemUI(@d Window window) {
        Rect rect = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    @k
    public static final int getStatusBarHeight(@d Window window) {
        Rect rect = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    @k
    public static final int getToolbarHeight(@d Window window) {
        return window.getDecorView().findViewById(16908290).getTop();
    }

    @k
    public static final boolean isFullScreen(@d Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    @k
    public static final boolean isNavBarVisible(@d Context context, @d Window window) {
        boolean z;
        String obj;
        int i2;
        View findViewById;
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                int id = viewGroup.getChildAt(i3).getId();
                if (id != -1 && f0.g("navigationBarBackground", context.getResources().getResourceEntryName(id)) && viewGroup.getChildAt(i3).getVisibility() == 0) {
                    z = true;
                }
            }
            if (!z && (findViewById = viewGroup.findViewById(R.id.immersion_navigation_bar_view)) != null && findViewById.getVisibility() == 0) {
                z = true;
            }
        } else {
            z = false;
        }
        if (z) {
            String str = Build.MANUFACTURER;
            if (str == null) {
                obj = "";
            } else {
                int length = str.length() - 1;
                int i4 = 0;
                boolean z2 = false;
                while (i4 <= length) {
                    boolean z3 = str.charAt(!z2 ? i4 : length) <= ' ';
                    if (z2) {
                        if (!z3) {
                            break;
                        }
                        length--;
                    } else if (z3) {
                        i4++;
                    } else {
                        z2 = true;
                    }
                }
                obj = str.subSequence(i4, length + 1).toString();
            }
            if (obj != null) {
                if (StringsKt__StringsKt.V2(obj.toLowerCase(), "samsung", false, 2, null) && (i2 = Build.VERSION.SDK_INT) >= 17 && i2 < 29) {
                    try {
                        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_hide_bar_enabled") == 0;
                    } catch (Exception unused) {
                    }
                }
                return !INSTANCE.hasSystemUIFlag(window, 2);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return z;
    }

    @k
    @TargetApi(14)
    public static final boolean isNavigationBarShow(@d Context context, @d Window window) {
        return isNavBarVisible(context, window);
    }

    @k
    public static final boolean isPortrait(@d Context context) {
        int i2 = context.getResources().getConfiguration().orientation;
        if (i2 != 1) {
            if (i2 == 2) {
                return false;
            }
            Object systemService = context.getSystemService("window");
            if (systemService != null) {
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                if (point.x > point.y) {
                    return false;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
            }
        }
        return true;
    }

    public final int getScreenRealHeight(@d Window window) {
        if (Build.VERSION.SDK_INT >= 17) {
            Object systemService = window.getContext().getSystemService("window");
            if (systemService != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        return getScreenHeightWithSystemUI(window);
    }

    public final boolean hasSystemUIFlag(@d Window window, int i2) {
        return (window.getDecorView().getSystemUiVisibility() & i2) == i2;
    }

    @k
    public static final boolean isFullScreen(@d Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }
}
