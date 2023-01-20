package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: e  reason: collision with root package name */
    public static final int f2748e = 225;

    /* renamed from: f  reason: collision with root package name */
    public static final int f2749f = 175;

    /* renamed from: g  reason: collision with root package name */
    private static final int f2750g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f2751h = 2;
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f2752c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ViewPropertyAnimator f2753d;

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f2753d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.a = 0;
        this.b = 2;
        this.f2752c = 0;
    }

    private void b(@NonNull V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f2753d = v.animate().translationY(i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }

    public void c(@NonNull V v, @Dimension int i2) {
        this.f2752c = i2;
        if (this.b == 1) {
            v.setTranslationY(this.a + i2);
        }
    }

    public void d(@NonNull V v) {
        if (this.b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2753d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.b = 1;
        b(v, this.a + this.f2752c, 175L, e.j.a.c.a.a.f10551c);
    }

    public void e(@NonNull V v) {
        if (this.b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2753d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.b = 2;
        b(v, 0, 225L, e.j.a.c.a.a.f10552d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        this.a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        if (i3 > 0) {
            d(v);
        } else if (i3 < 0) {
            e(v);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 2;
        this.f2752c = 0;
    }
}
