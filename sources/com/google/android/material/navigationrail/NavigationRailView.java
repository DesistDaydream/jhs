package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarView;
import e.j.a.c.s.m;

/* loaded from: classes2.dex */
public class NavigationRailView extends NavigationBarView {
    public static final int o = 49;
    public static final int p = 7;
    private static final int q = 49;

    /* renamed from: m  reason: collision with root package name */
    private final int f3001m;
    @Nullable
    private View n;

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private boolean n() {
        View view = this.n;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int o(int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i2) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i2;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    @Nullable
    public View getHeaderView() {
        return this.n;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public void k(@LayoutRes int i2) {
        l(LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) this, false));
    }

    public void l(@NonNull View view) {
        p();
        this.n = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f3001m;
        addView(view, 0, layoutParams);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: m */
    public NavigationRailMenuView e(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i6 = 0;
        if (n()) {
            int bottom = this.n.getBottom() + this.f3001m;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i6 = bottom - top;
            }
        } else if (navigationRailMenuView.q()) {
            i6 = this.f3001m;
        }
        if (i6 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i6, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i6);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int o2 = o(i2);
        super.onMeasure(o2, i3);
        if (n()) {
            measureChild(getNavigationRailMenuView(), o2, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.n.getMeasuredHeight()) - this.f3001m, Integer.MIN_VALUE));
        }
    }

    public void p() {
        View view = this.n;
        if (view != null) {
            removeView(view);
            this.n = null;
        }
    }

    public void setMenuGravity(int i2) {
        getNavigationRailMenuView().setMenuGravity(i2);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f3001m = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        TintTypedArray k2 = m.k(getContext(), attributeSet, R.styleable.NavigationRailView, i2, i3, new int[0]);
        int resourceId = k2.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            k(resourceId);
        }
        setMenuGravity(k2.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        k2.recycle();
    }
}
