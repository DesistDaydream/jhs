package androidx.databinding.adapters;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import androidx.databinding.BindingConversion;

/* loaded from: classes.dex */
public class Converters {
    @BindingConversion
    public static ColorStateList convertColorToColorStateList(int i2) {
        return ColorStateList.valueOf(i2);
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int i2) {
        return new ColorDrawable(i2);
    }
}
