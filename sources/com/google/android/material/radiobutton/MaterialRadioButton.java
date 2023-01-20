package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R;
import e.j.a.c.l.a;

/* loaded from: classes2.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: c  reason: collision with root package name */
    private static final int f3019c = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f3020d = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    @Nullable
    private ColorStateList a;
    private boolean b;

    public MaterialRadioButton(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.a == null) {
            int d2 = a.d(this, R.attr.colorControlActivated);
            int d3 = a.d(this, R.attr.colorOnSurface);
            int d4 = a.d(this, R.attr.colorSurface);
            int[][] iArr = f3020d;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = a.h(d4, d2, 1.0f);
            iArr2[1] = a.h(d4, d3, 0.54f);
            iArr2[2] = a.h(d4, d3, 0.38f);
            iArr2[3] = a.h(d4, d3, 0.38f);
            this.a = new ColorStateList(iArr, iArr2);
        }
        return this.a;
    }

    public boolean a() {
        return this.b;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.b = z;
        if (z) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialRadioButton(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.radiobutton.MaterialRadioButton.f3019c
            android.content.Context r8 = e.j.a.c.e0.a.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialRadioButton
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialRadioButton_buttonTint
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L28
            android.content.res.ColorStateList r8 = e.j.a.c.w.c.a(r8, r9, r10)
            androidx.core.widget.CompoundButtonCompat.setButtonTintList(r7, r8)
        L28:
            int r8 = com.google.android.material.R.styleable.MaterialRadioButton_useMaterialThemeColors
            boolean r8 = r9.getBoolean(r8, r6)
            r7.b = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.radiobutton.MaterialRadioButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
