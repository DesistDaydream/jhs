package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import e.j.a.c.p.a;
import e.j.a.c.s.t;

/* loaded from: classes2.dex */
public class SwitchMaterial extends SwitchCompat {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_Switch;
    private static final int[][] ENABLED_CHECKED_STATES = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    @NonNull
    private final a elevationOverlayProvider;
    @Nullable
    private ColorStateList materialThemeColorsThumbTintList;
    @Nullable
    private ColorStateList materialThemeColorsTrackTintList;
    private boolean useMaterialThemeColors;

    public SwitchMaterial(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.materialThemeColorsThumbTintList == null) {
            int d2 = e.j.a.c.l.a.d(this, R.attr.colorSurface);
            int d3 = e.j.a.c.l.a.d(this, R.attr.colorControlActivated);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            if (this.elevationOverlayProvider.l()) {
                dimension += t.i(this);
            }
            int e2 = this.elevationOverlayProvider.e(d2, dimension);
            int[][] iArr = ENABLED_CHECKED_STATES;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = e.j.a.c.l.a.h(d2, d3, 1.0f);
            iArr2[1] = e2;
            iArr2[2] = e.j.a.c.l.a.h(d2, d3, 0.38f);
            iArr2[3] = e2;
            this.materialThemeColorsThumbTintList = new ColorStateList(iArr, iArr2);
        }
        return this.materialThemeColorsThumbTintList;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.materialThemeColorsTrackTintList == null) {
            int[][] iArr = ENABLED_CHECKED_STATES;
            int[] iArr2 = new int[iArr.length];
            int d2 = e.j.a.c.l.a.d(this, R.attr.colorSurface);
            int d3 = e.j.a.c.l.a.d(this, R.attr.colorControlActivated);
            int d4 = e.j.a.c.l.a.d(this, R.attr.colorOnSurface);
            iArr2[0] = e.j.a.c.l.a.h(d2, d3, 0.54f);
            iArr2[1] = e.j.a.c.l.a.h(d2, d4, 0.32f);
            iArr2[2] = e.j.a.c.l.a.h(d2, d3, 0.12f);
            iArr2[3] = e.j.a.c.l.a.h(d2, d4, 0.12f);
            this.materialThemeColorsTrackTintList = new ColorStateList(iArr, iArr2);
        }
        return this.materialThemeColorsTrackTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.useMaterialThemeColors && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
            return;
        }
        setThumbTintList(null);
        setTrackTintList(null);
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SwitchMaterial(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.switchmaterial.SwitchMaterial.DEF_STYLE_RES
            android.content.Context r7 = e.j.a.c.e0.a.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            e.j.a.c.p.a r7 = new e.j.a.c.p.a
            r7.<init>(r0)
            r6.elevationOverlayProvider = r7
            int[] r2 = com.google.android.material.R.styleable.SwitchMaterial
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.SwitchMaterial_useMaterialThemeColors
            boolean r7 = r8.getBoolean(r9, r7)
            r6.useMaterialThemeColors = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.switchmaterial.SwitchMaterial.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
