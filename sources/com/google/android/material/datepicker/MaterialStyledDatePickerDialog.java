package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import e.j.a.c.n.a;
import e.j.a.c.n.c;
import e.j.a.c.w.b;
import e.j.a.c.z.j;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
/* loaded from: classes2.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    @AttrRes
    private static final int DEF_STYLE_ATTR = 16843612;
    @StyleRes
    private static final int DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    @NonNull
    private final Drawable background;
    @NonNull
    private final Rect backgroundInsets;

    public MaterialStyledDatePickerDialog(@NonNull Context context) {
        this(context, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new a(this, this.backgroundInsets));
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i2) {
        this(context, i2, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        this(context, 0, onDateSetListener, i2, i3, i4);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i2, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i3, int i4, int i5) {
        super(context, i2, onDateSetListener, i3, i4, i5);
        Context context2 = getContext();
        int g2 = b.g(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int i6 = DEF_STYLE_RES;
        j jVar = new j(context2, null, DEF_STYLE_ATTR, i6);
        if (Build.VERSION.SDK_INT >= 21) {
            jVar.n0(ColorStateList.valueOf(g2));
        } else {
            jVar.n0(ColorStateList.valueOf(0));
        }
        Rect a = c.a(context2, DEF_STYLE_ATTR, i6);
        this.backgroundInsets = a;
        this.background = c.b(jVar, a);
    }
}
