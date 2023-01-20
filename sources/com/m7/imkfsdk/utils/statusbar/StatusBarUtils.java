package com.m7.imkfsdk.utils.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.ColorUtils;
import com.effective.android.panel.Constants;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.utils.statusbar.OSUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class StatusBarUtils {
    private static final int FAKE_STATUS_BAR_VIEW_ID = R.id.ykfsdk_fake_status_bar_view;

    /* renamed from: com.m7.imkfsdk.utils.statusbar.StatusBarUtils$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$m7$imkfsdk$utils$statusbar$OSUtils$ROM;

        static {
            int[] iArr = new int[OSUtils.ROM.values().length];
            $SwitchMap$com$m7$imkfsdk$utils$statusbar$OSUtils$ROM = iArr;
            try {
                iArr[OSUtils.ROM.MIUI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$m7$imkfsdk$utils$statusbar$OSUtils$ROM[OSUtils.ROM.Flyme.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static int getHeight(Context context) {
        try {
            int identifier = context.getResources().getIdentifier(Constants.STATUS_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean isDarkColor(@ColorInt int i2) {
        return ColorUtils.calculateLuminance(i2) < 0.5d;
    }

    public static void setColor(Context context, @ColorInt int i2) {
        if (context instanceof Activity) {
            setColor(((Activity) context).getWindow(), i2);
        }
    }

    private static void setFlymeDark(Window window, boolean z) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i3 | i2 : (~i2) & i3);
                window.setAttributes(attributes);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void setMIUIDark(Window window, boolean z) {
        try {
            Class<?> cls = window.getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setTextDark(Context context, boolean z) {
        if (context instanceof Activity) {
            setTextDark(((Activity) context).getWindow(), z);
        }
    }

    public static void setTransparent(Context context) {
        if (context instanceof Activity) {
            setTransparent(((Activity) context).getWindow());
        }
    }

    public static void setColor(@NonNull Window window, @ColorInt int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21) {
            if (i3 >= 19) {
                setColor(window, ColorUtils.blendARGB(0, i2, 0.5f), false);
                return;
            }
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.clearFlags(134217728);
        window.getDecorView().setSystemUiVisibility(256);
        window.setStatusBarColor(i2);
        setTextDark(window, !isDarkColor(i2));
    }

    private static void setTextDark(Window window, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                decorView.setSystemUiVisibility(systemUiVisibility | 8192);
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
            }
        } else if (i2 >= 21) {
            int i3 = AnonymousClass1.$SwitchMap$com$m7$imkfsdk$utils$statusbar$OSUtils$ROM[OSUtils.getRomType().ordinal()];
            if (i3 == 1) {
                setMIUIDark(window, z);
            } else if (i3 != 2) {
            } else {
                setFlymeDark(window, z);
            }
        }
    }

    public static void setTransparent(@NonNull Window window) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (i2 >= 19) {
                setColor(window, Integer.MIN_VALUE, true);
                return;
            }
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.clearFlags(134217728);
        window.getDecorView().setSystemUiVisibility(1280);
        window.setStatusBarColor(0);
    }

    @RequiresApi(api = 19)
    public static void setColor(@NonNull Window window, @ColorInt int i2, boolean z) {
        Context context = window.getContext();
        window.addFlags(67108864);
        window.clearFlags(134217728);
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        View findViewById = viewGroup.findViewById(16908290);
        if (findViewById != null) {
            findViewById.setPadding(0, z ? 0 : getHeight(context), 0, 0);
        }
        int i3 = FAKE_STATUS_BAR_VIEW_ID;
        View findViewById2 = viewGroup.findViewById(i3);
        if (findViewById2 != null) {
            findViewById2.setBackgroundColor(i2);
            if (findViewById2.getVisibility() == 8) {
                findViewById2.setVisibility(0);
                return;
            }
            return;
        }
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getHeight(context)));
        view.setBackgroundColor(i2);
        view.setId(i3);
        viewGroup.addView(view);
    }
}
