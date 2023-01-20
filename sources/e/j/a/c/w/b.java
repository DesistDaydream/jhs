package e.j.a.c.w;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class b {
    @Nullable
    public static TypedValue a(@NonNull Context context, @AttrRes int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(@NonNull Context context, @AttrRes int i2, boolean z) {
        TypedValue a = a(context, i2);
        return (a == null || a.type != 18) ? z : a.data != 0;
    }

    public static boolean c(@NonNull Context context, @AttrRes int i2, @NonNull String str) {
        return g(context, i2, str) != 0;
    }

    @Px
    public static int d(@NonNull Context context, @AttrRes int i2, @DimenRes int i3) {
        float dimension;
        TypedValue a = a(context, i2);
        if (a != null && a.type == 5) {
            dimension = a.getDimension(context.getResources().getDisplayMetrics());
        } else {
            dimension = context.getResources().getDimension(i3);
        }
        return (int) dimension;
    }

    public static int e(@NonNull Context context, @AttrRes int i2, int i3) {
        TypedValue a = a(context, i2);
        return (a == null || a.type != 16) ? i3 : a.data;
    }

    @Px
    public static int f(@NonNull Context context) {
        return d(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int g(@NonNull Context context, @AttrRes int i2, @NonNull String str) {
        TypedValue a = a(context, i2);
        if (a != null) {
            return a.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    public static int h(@NonNull View view, @AttrRes int i2) {
        return g(view.getContext(), i2, view.getClass().getCanonicalName());
    }
}
