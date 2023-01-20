package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import e.j.a.c.s.n;
import e.j.a.c.z.j;
import e.j.a.c.z.k;

/* loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: d  reason: collision with root package name */
    private static final int f2733d = R.style.Widget_MaterialComponents_Toolbar;
    @Nullable
    private Integer a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2734c;

    public MaterialToolbar(@NonNull Context context) {
        this(context, null);
    }

    private Pair<Integer, Integer> a(@Nullable TextView textView, @Nullable TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i2 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i2 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i2 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void b(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            j jVar = new j();
            jVar.n0(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            jVar.Y(context);
            jVar.m0(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, jVar);
        }
    }

    private void e(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i2 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i3 = measuredWidth2 + i2;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i2, 0), Math.max(i3 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i2 += max;
            i3 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 - i2, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i2, view.getTop(), i3, view.getBottom());
    }

    private void f() {
        if (this.b || this.f2734c) {
            TextView g2 = n.g(this);
            TextView e2 = n.e(this);
            if (g2 == null && e2 == null) {
                return;
            }
            Pair<Integer, Integer> a = a(g2, e2);
            if (this.b && g2 != null) {
                e(g2, a);
            }
            if (!this.f2734c || e2 == null) {
                return;
            }
            e(e2, a);
        }
    }

    @Nullable
    private Drawable g(@Nullable Drawable drawable) {
        if (drawable == null || this.a == null) {
            return drawable;
        }
        Drawable wrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrap, this.a.intValue());
        return wrap;
    }

    public boolean c() {
        return this.f2734c;
    }

    public boolean d() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        f();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        k.d(this, f2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(g(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i2) {
        this.a = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.f2734c != z) {
            this.f2734c = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.b != z) {
            this.b = z;
            requestLayout();
        }
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialToolbar(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.appbar.MaterialToolbar.f2733d
            android.content.Context r8 = e.j.a.c.e0.a.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialToolbar
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialToolbar_navigationIconTint
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L29
            r0 = -1
            int r10 = r9.getColor(r10, r0)
            r7.setNavigationIconTint(r10)
        L29:
            int r10 = com.google.android.material.R.styleable.MaterialToolbar_titleCentered
            boolean r10 = r9.getBoolean(r10, r6)
            r7.b = r10
            int r10 = com.google.android.material.R.styleable.MaterialToolbar_subtitleCentered
            boolean r10 = r9.getBoolean(r10, r6)
            r7.f2734c = r10
            r9.recycle()
            r7.b(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
