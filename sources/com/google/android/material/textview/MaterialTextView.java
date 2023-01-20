package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import e.j.a.c.e0.a.a;
import e.j.a.c.w.b;
import e.j.a.c.w.c;

/* loaded from: classes2.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    private void e(@NonNull Resources.Theme theme, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i2, R.styleable.MaterialTextAppearance);
        int h2 = h(getContext(), obtainStyledAttributes, R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight);
        obtainStyledAttributes.recycle();
        if (h2 >= 0) {
            setLineHeight(h2);
        }
    }

    private static boolean f(Context context) {
        return b.b(context, R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int g(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int h(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull @StyleableRes int... iArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < iArr.length && i2 < 0; i3++) {
            i2 = c.c(context, typedArray, iArr[i3], -1);
        }
        return i2;
    }

    private static boolean i(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i2, i3);
        int h2 = h(context, obtainStyledAttributes, R.styleable.MaterialTextView_android_lineHeight, R.styleable.MaterialTextView_lineHeight);
        obtainStyledAttributes.recycle();
        return h2 != -1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (f(context)) {
            e(context.getTheme(), i2);
        }
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(a.c(context, attributeSet, i2, i3), attributeSet, i2);
        int g2;
        Context context2 = getContext();
        if (f(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (i(context2, theme, attributeSet, i2, i3) || (g2 = g(theme, attributeSet, i2, i3)) == -1) {
                return;
            }
            e(theme, g2);
        }
    }
}
