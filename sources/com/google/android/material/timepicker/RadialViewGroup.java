package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import e.j.a.c.z.j;
import e.j.a.c.z.m;

/* loaded from: classes2.dex */
public class RadialViewGroup extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private static final String f3123d = "skip";
    private final Runnable a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private j f3124c;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RadialViewGroup.this.j();
        }
    }

    public RadialViewGroup(@NonNull Context context) {
        this(context, null);
    }

    private Drawable f() {
        j jVar = new j();
        this.f3124c = jVar;
        jVar.k0(new m(0.5f));
        this.f3124c.n0(ColorStateList.valueOf(-1));
        return this.f3124c;
    }

    private static boolean i(View view) {
        return f3123d.equals(view.getTag());
    }

    private void k() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.a);
            handler.post(this.a);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        k();
    }

    @Dimension
    public int g() {
        return this.b;
    }

    public void h(@Dimension int i2) {
        this.b = i2;
        j();
    }

    public void j() {
        int childCount = getChildCount();
        int i2 = 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            if (i(getChildAt(i3))) {
                i2++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        float f2 = 0.0f;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            int i5 = R.id.circle_center;
            if (id != i5 && !i(childAt)) {
                constraintSet.constrainCircle(childAt.getId(), i5, this.b, f2);
                f2 += 360.0f / (childCount - i2);
            }
        }
        constraintSet.applyTo(this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        j();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        k();
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        this.f3124c.n0(ColorStateList.valueOf(i2));
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, f());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i2, 0);
        this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.a = new a();
        obtainStyledAttributes.recycle();
    }
}
