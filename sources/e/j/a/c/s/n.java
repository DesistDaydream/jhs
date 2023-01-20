package e.j.a.c.s;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class n {
    private n() {
    }

    @Nullable
    public static ActionMenuItemView a(@NonNull Toolbar toolbar, @IdRes int i2) {
        ActionMenuView b = b(toolbar);
        if (b != null) {
            for (int i3 = 0; i3 < b.getChildCount(); i3++) {
                View childAt = b.getChildAt(i3);
                if (childAt instanceof ActionMenuItemView) {
                    ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                    if (actionMenuItemView.getItemData().getItemId() == i2) {
                        return actionMenuItemView;
                    }
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    public static ActionMenuView b(@NonNull Toolbar toolbar) {
        for (int i2 = 0; i2 < toolbar.getChildCount(); i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    @Nullable
    public static ImageButton c(@NonNull Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i2 = 0; i2 < toolbar.getChildCount(); i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    @Nullable
    public static View d(@NonNull Toolbar toolbar) {
        ActionMenuView b = b(toolbar);
        if (b == null || b.getChildCount() <= 1) {
            return null;
        }
        return b.getChildAt(0);
    }

    @Nullable
    public static TextView e(@NonNull Toolbar toolbar) {
        return f(toolbar, toolbar.getSubtitle());
    }

    @Nullable
    private static TextView f(@NonNull Toolbar toolbar, CharSequence charSequence) {
        for (int i2 = 0; i2 < toolbar.getChildCount(); i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }

    @Nullable
    public static TextView g(@NonNull Toolbar toolbar) {
        return f(toolbar, toolbar.getTitle());
    }
}
