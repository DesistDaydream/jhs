package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import e.j.a.c.s.m;
import e.j.a.c.v.b;
import e.j.a.c.v.g;
import e.j.a.c.v.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class BaseProgressIndicator<S extends e.j.a.c.v.b> extends ProgressBar {
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = R.style.Widget_MaterialComponents_ProgressIndicator;
    public static final float v = 0.2f;
    public static final int w = 255;
    public static final int x = 1000;
    public S a;
    private int b;

    /* renamed from: c */
    private boolean f3002c;

    /* renamed from: d */
    private boolean f3003d;

    /* renamed from: e */
    private final int f3004e;

    /* renamed from: f */
    private final int f3005f;

    /* renamed from: g */
    private long f3006g;

    /* renamed from: h */
    public e.j.a.c.v.a f3007h;

    /* renamed from: i */
    private boolean f3008i;

    /* renamed from: j */
    private int f3009j;

    /* renamed from: k */
    private final Runnable f3010k;

    /* renamed from: l */
    private final Runnable f3011l;

    /* renamed from: m */
    private final Animatable2Compat.AnimationCallback f3012m;
    private final Animatable2Compat.AnimationCallback n;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
            BaseProgressIndicator.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.l();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
            BaseProgressIndicator.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.k();
            BaseProgressIndicator.this.f3006g = -1L;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Animatable2Compat.AnimationCallback {
        public c() {
            BaseProgressIndicator.this = r1;
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator.this.p(0, false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.p(baseProgressIndicator.b, BaseProgressIndicator.this.f3002c);
        }
    }

    /* loaded from: classes2.dex */
    public class d extends Animatable2Compat.AnimationCallback {
        public d() {
            BaseProgressIndicator.this = r1;
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (BaseProgressIndicator.this.f3008i) {
                return;
            }
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setVisibility(baseProgressIndicator.f3009j);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface e {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface f {
    }

    public BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(e.j.a.c.e0.a.a.c(context, attributeSet, i2, u), attributeSet, i2);
        this.f3006g = -1L;
        this.f3008i = false;
        this.f3009j = 4;
        this.f3010k = new a();
        this.f3011l = new b();
        this.f3012m = new c();
        this.n = new d();
        Context context2 = getContext();
        this.a = i(context2, attributeSet);
        TypedArray j2 = m.j(context2, attributeSet, R.styleable.BaseProgressIndicator, i2, i3, new int[0]);
        this.f3004e = j2.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.f3005f = Math.min(j2.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        j2.recycle();
        this.f3007h = new e.j.a.c.v.a();
        this.f3003d = true;
    }

    @Nullable
    private g<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().x();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().y();
        }
    }

    public void k() {
        ((e.j.a.c.v.f) getCurrentDrawable()).s(false, false, true);
        if (n()) {
            setVisibility(4);
        }
    }

    public void l() {
        if (this.f3005f > 0) {
            this.f3006g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean n() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void o() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().w().d(this.f3012m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.n);
        }
    }

    private void r() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.n);
            getIndeterminateDrawable().w().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.n);
        }
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.a.f11011f;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.a.f11008c;
    }

    public int getShowAnimationBehavior() {
        return this.a.f11010e;
    }

    @ColorInt
    public int getTrackColor() {
        return this.a.f11009d;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.a.b;
    }

    @Px
    public int getTrackThickness() {
        return this.a.a;
    }

    public void h(boolean z) {
        if (this.f3003d) {
            ((e.j.a.c.v.f) getCurrentDrawable()).s(s(), false, z);
        }
    }

    public abstract S i(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public void j() {
        if (getVisibility() != 0) {
            removeCallbacks(this.f3010k);
            return;
        }
        removeCallbacks(this.f3011l);
        long uptimeMillis = SystemClock.uptimeMillis() - this.f3006g;
        int i2 = this.f3005f;
        if (uptimeMillis >= ((long) i2)) {
            this.f3011l.run();
        } else {
            postDelayed(this.f3011l, i2 - uptimeMillis);
        }
    }

    public boolean m() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        if (s()) {
            l();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f3011l);
        removeCallbacks(this.f3010k);
        ((e.j.a.c.v.f) getCurrentDrawable()).i();
        r();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        int paddingLeft;
        int paddingTop;
        super.onMeasure(i2, i3);
        g<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate == null) {
            return;
        }
        int e2 = currentDrawingDelegate.e();
        int d2 = currentDrawingDelegate.d();
        if (e2 < 0) {
            paddingLeft = getMeasuredWidth();
        } else {
            paddingLeft = e2 + getPaddingLeft() + getPaddingRight();
        }
        if (d2 < 0) {
            paddingTop = getMeasuredHeight();
        } else {
            paddingTop = d2 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        h(i2 == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        h(false);
    }

    public void p(int i2, boolean z) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.b = i2;
                this.f3002c = z;
                this.f3008i = true;
                if (getIndeterminateDrawable().isVisible() && this.f3007h.a(getContext().getContentResolver()) != 0.0f) {
                    getIndeterminateDrawable().w().f();
                    return;
                } else {
                    this.f3012m.onAnimationEnd(getIndeterminateDrawable());
                    return;
                }
            }
            return;
        }
        super.setProgress(i2);
        if (getProgressDrawable() == null || z) {
            return;
        }
        getProgressDrawable().jumpToCurrentState();
    }

    public void q() {
        if (this.f3004e > 0) {
            removeCallbacks(this.f3010k);
            postDelayed(this.f3010k, this.f3004e);
            return;
        }
        this.f3010k.run();
    }

    public boolean s() {
        return ViewCompat.isAttachedToWindow(this) && getWindowVisibility() == 0 && m();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull e.j.a.c.v.a aVar) {
        this.f3007h = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f11026c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f11026c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.a.f11011f = i2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        if (z == isIndeterminate()) {
            return;
        }
        if (s() && z) {
            throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
        }
        e.j.a.c.v.f fVar = (e.j.a.c.v.f) getCurrentDrawable();
        if (fVar != null) {
            fVar.i();
        }
        super.setIndeterminate(z);
        e.j.a.c.v.f fVar2 = (e.j.a.c.v.f) getCurrentDrawable();
        if (fVar2 != null) {
            fVar2.s(s(), false, false);
        }
        this.f3008i = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof i) {
            ((e.j.a.c.v.f) drawable).i();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{e.j.a.c.l.a.b(getContext(), R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.a.f11008c = iArr;
        getIndeterminateDrawable().w().c();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i2) {
        if (isIndeterminate()) {
            return;
        }
        p(i2, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof e.j.a.c.v.e) {
            e.j.a.c.v.e eVar = (e.j.a.c.v.e) drawable;
            eVar.i();
            super.setProgressDrawable(eVar);
            eVar.C(getProgress() / getMax());
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i2) {
        this.a.f11010e = i2;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i2) {
        S s2 = this.a;
        if (s2.f11009d != i2) {
            s2.f11009d = i2;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i2) {
        S s2 = this.a;
        if (s2.b != i2) {
            s2.b = Math.min(i2, s2.a / 2);
        }
    }

    public void setTrackThickness(@Px int i2) {
        S s2 = this.a;
        if (s2.a != i2) {
            s2.a = i2;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 != 0 && i2 != 4 && i2 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f3009j = i2;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public i<S> getIndeterminateDrawable() {
        return (i) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public e.j.a.c.v.e<S> getProgressDrawable() {
        return (e.j.a.c.v.e) super.getProgressDrawable();
    }
}
