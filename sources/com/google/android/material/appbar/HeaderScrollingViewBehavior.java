package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: d */
    public final Rect f2729d;

    /* renamed from: e */
    public final Rect f2730e;

    /* renamed from: f */
    private int f2731f;

    /* renamed from: g */
    private int f2732g;

    public HeaderScrollingViewBehavior() {
        this.f2729d = new Rect();
        this.f2730e = new Rect();
        this.f2731f = 0;
    }

    private static int p(int i2) {
        return i2 == 0 ? BadgeDrawable.r : i2;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public void e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        View j2 = j(coordinatorLayout.getDependencies(view));
        if (j2 != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f2729d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, j2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + j2.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f2730e;
            GravityCompat.apply(p(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int k2 = k(j2);
            view.layout(rect2.left, rect2.top - k2, rect2.right, rect2.bottom - k2);
            this.f2731f = rect2.top - j2.getBottom();
            return;
        }
        super.e(coordinatorLayout, view, i2);
        this.f2731f = 0;
    }

    @Nullable
    public abstract View j(List<View> list);

    public final int k(View view) {
        if (this.f2732g == 0) {
            return 0;
        }
        float l2 = l(view);
        int i2 = this.f2732g;
        return MathUtils.clamp((int) (l2 * i2), 0, i2);
    }

    public float l(View view) {
        return 1.0f;
    }

    public final int m() {
        return this.f2732g;
    }

    public int n(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    public final int o() {
        return this.f2731f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
        View j2;
        WindowInsetsCompat lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 == -1 || i6 == -2) && (j2 = j(coordinatorLayout.getDependencies(view))) != null) {
            int size = View.MeasureSpec.getSize(i4);
            if (size > 0) {
                if (ViewCompat.getFitsSystemWindows(j2) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int n = size + n(j2);
            int measuredHeight = j2.getMeasuredHeight();
            if (r()) {
                view.setTranslationY(-measuredHeight);
            } else {
                n -= measuredHeight;
            }
            coordinatorLayout.onMeasureChild(view, i2, i3, View.MeasureSpec.makeMeasureSpec(n, i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
            return true;
        }
        return false;
    }

    public final void q(int i2) {
        this.f2732g = i2;
    }

    public boolean r() {
        return false;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2729d = new Rect();
        this.f2730e = new Rect();
        this.f2731f = 0;
    }
}
