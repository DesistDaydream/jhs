package e.b.a.p.m.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes.dex */
public final class a {
    private static volatile boolean a = true;

    private a() {
    }

    public static Drawable a(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return c(context, context, i2, theme);
    }

    public static Drawable b(Context context, Context context2, @DrawableRes int i2) {
        return c(context, context2, i2, null);
    }

    private static Drawable c(Context context, Context context2, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        try {
            if (a) {
                return e(context2, i2, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i2);
            }
            throw e2;
        } catch (NoClassDefFoundError unused2) {
            a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i2, theme);
    }

    private static Drawable d(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i2, theme);
    }

    private static Drawable e(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i2);
    }
}
