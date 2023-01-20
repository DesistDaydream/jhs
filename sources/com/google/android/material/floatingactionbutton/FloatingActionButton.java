package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.stateful.ExtendableSavedState;
import e.j.a.c.a.h;
import e.j.a.c.a.k;
import e.j.a.c.r.d;
import e.j.a.c.z.o;
import e.j.a.c.z.s;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes2.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, e.j.a.c.q.a, s, CoordinatorLayout.AttachedBehavior {
    private static final String r = "FloatingActionButton";
    private static final String s = "expandableWidgetHelper";
    private static final int t = R.style.Widget_Design_FloatingActionButton;
    public static final int u = 1;
    public static final int v = 0;
    public static final int w = -1;
    public static final int x = 0;
    private static final int y = 470;
    @Nullable
    private ColorStateList b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f2902c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f2903d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f2904e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f2905f;

    /* renamed from: g  reason: collision with root package name */
    private int f2906g;

    /* renamed from: h  reason: collision with root package name */
    private int f2907h;

    /* renamed from: i  reason: collision with root package name */
    private int f2908i;

    /* renamed from: j  reason: collision with root package name */
    private int f2909j;

    /* renamed from: k  reason: collision with root package name */
    private int f2910k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2911l;

    /* renamed from: m  reason: collision with root package name */
    public final Rect f2912m;
    private final Rect n;
    @NonNull
    private final AppCompatImageHelper o;
    @NonNull
    private final e.j.a.c.q.c p;
    private e.j.a.c.r.d q;

    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean b() {
            return super.b();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean e(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i2) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i2);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void g(boolean z) {
            super.g(z);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @VisibleForTesting
        public /* bridge */ /* synthetic */ void h(b bVar) {
            super.h(bVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            super.onAttachedToLayoutParams(layoutParams);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes2.dex */
    public class a implements d.j {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // e.j.a.c.r.d.j
        public void a() {
            this.a.b(FloatingActionButton.this);
        }

        @Override // e.j.a.c.r.d.j
        public void b() {
            this.a.a(FloatingActionButton.this);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* loaded from: classes2.dex */
    public class c implements e.j.a.c.y.c {
        public c() {
        }

        @Override // e.j.a.c.y.c
        public boolean a() {
            return FloatingActionButton.this.f2911l;
        }

        @Override // e.j.a.c.y.c
        public float b() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // e.j.a.c.y.c
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // e.j.a.c.y.c
        public void setShadowPadding(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.f2912m.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.f2909j, i3 + FloatingActionButton.this.f2909j, i4 + FloatingActionButton.this.f2909j, i5 + FloatingActionButton.this.f2909j);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface d {
    }

    /* loaded from: classes2.dex */
    public class e<T extends FloatingActionButton> implements d.i {
        @NonNull
        private final k<T> a;

        public e(@NonNull k<T> kVar) {
            this.a = kVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.j.a.c.r.d.i
        public void a() {
            this.a.b(FloatingActionButton.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.j.a.c.r.d.i
        public void b() {
            this.a.a(FloatingActionButton.this);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof e) && ((e) obj).a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private d.j C(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    private e.j.a.c.r.d getImpl() {
        if (this.q == null) {
            this.q = j();
        }
        return this.q;
    }

    @NonNull
    private e.j.a.c.r.d j() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new e.j.a.c.r.e(this, new c());
        }
        return new e.j.a.c.r.d(this, new c());
    }

    private int m(int i2) {
        int i3 = this.f2908i;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < y) {
            return m(1);
        } else {
            return m(0);
        }
    }

    private void s(@NonNull Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.f2912m;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void t() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f2903d;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f2904e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    private static int x(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                throw new IllegalArgumentException();
            }
            return i2;
        }
        return Math.min(i2, size);
    }

    public void A(@Nullable b bVar) {
        B(bVar, true);
    }

    public void B(@Nullable b bVar, boolean z) {
        getImpl().f0(C(bVar), z);
    }

    @Override // e.j.a.c.q.b
    public boolean a(boolean z) {
        return this.p.f(z);
    }

    @Override // e.j.a.c.q.b
    public boolean b() {
        return this.p.c();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    public void g(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.b;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f2902c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().k();
    }

    @Px
    public int getCustomSize() {
        return this.f2908i;
    }

    @Override // e.j.a.c.q.a
    public int getExpandedComponentIdHint() {
        return this.p.b();
    }

    @Nullable
    public h getHideMotionSpec() {
        return getImpl().p();
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f2905f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.f2905f;
    }

    @Override // e.j.a.c.z.s
    @NonNull
    public o getShapeAppearanceModel() {
        return (o) Preconditions.checkNotNull(getImpl().u());
    }

    @Nullable
    public h getShowMotionSpec() {
        return getImpl().v();
    }

    public int getSize() {
        return this.f2907h;
    }

    public int getSizeDimension() {
        return m(this.f2907h);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f2903d;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f2904e;
    }

    public boolean getUseCompatPadding() {
        return this.f2911l;
    }

    public void h(@NonNull k<? extends FloatingActionButton> kVar) {
        getImpl().f(new e(kVar));
    }

    public void i() {
        setCustomSize(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    @Deprecated
    public boolean k(@NonNull Rect rect) {
        if (ViewCompat.isLaidOut(this)) {
            rect.set(0, 0, getWidth(), getHeight());
            s(rect);
            return true;
        }
        return false;
    }

    public void l(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        s(rect);
    }

    public void n() {
        o(null);
    }

    public void o(@Nullable b bVar) {
        p(bVar, true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.f2909j = (sizeDimension - this.f2910k) / 2;
        getImpl().i0();
        int min = Math.min(x(sizeDimension, i2), x(sizeDimension, i3));
        Rect rect = this.f2912m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.p.d((Bundle) Preconditions.checkNotNull(extendableSavedState.extendableStates.get(s)));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.extendableStates.put(s, this.p.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && k(this.n) && !this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(@Nullable b bVar, boolean z) {
        getImpl().w(C(bVar), z);
    }

    public boolean q() {
        return getImpl().y();
    }

    public boolean r() {
        return getImpl().z();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.i(r, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i(r, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        Log.i(r, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.b != colorStateList) {
            this.b = colorStateList;
            getImpl().O(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2902c != mode) {
            this.f2902c = mode;
            getImpl().P(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().Q(f2);
    }

    public void setCompatElevationResource(@DimenRes int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().T(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().X(f2);
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(@Px int i2) {
        if (i2 >= 0) {
            if (i2 != this.f2908i) {
                this.f2908i = i2;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().j0(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().o()) {
            getImpl().R(z);
            requestLayout();
        }
    }

    @Override // e.j.a.c.q.a
    public void setExpandedComponentIdHint(@IdRes int i2) {
        this.p.g(i2);
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        getImpl().S(hVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(h.d(getContext(), i2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().h0();
            if (this.f2903d != null) {
                t();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        this.o.setImageResource(i2);
        t();
    }

    public void setRippleColor(@ColorInt int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().I();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().I();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z) {
        getImpl().Z(z);
    }

    @Override // e.j.a.c.z.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        getImpl().a0(oVar);
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        getImpl().b0(hVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(h.d(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f2908i = 0;
        if (i2 != this.f2907h) {
            this.f2907h = i2;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2903d != colorStateList) {
            this.f2903d = colorStateList;
            t();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2904e != mode) {
            this.f2904e = mode;
            t();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().J();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f2911l != z) {
            this.f2911l = z;
            getImpl().C();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public void u(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().K(animatorListener);
    }

    public void v(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().L(animatorListener);
    }

    public void w(@NonNull k<? extends FloatingActionButton> kVar) {
        getImpl().M(new e(kVar));
    }

    public boolean y() {
        return getImpl().o();
    }

    public void z() {
        A(null);
    }

    /* loaded from: classes2.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: d  reason: collision with root package name */
        private static final boolean f2913d = true;
        private Rect a;
        private b b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2914c;

        public BaseBehavior() {
            this.f2914c = true;
        }

        private static boolean c(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            int i2;
            Rect rect = floatingActionButton.f2912m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i3 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) {
                i2 = rect.right;
            } else {
                i2 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i3);
            }
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(floatingActionButton, i2);
            }
        }

        private boolean i(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            return this.f2914c && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean j(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (i(appBarLayout, floatingActionButton)) {
                if (this.a == null) {
                    this.a = new Rect();
                }
                Rect rect = this.a;
                e.j.a.c.s.c.a(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                    floatingActionButton.p(this.b, false);
                    return true;
                }
                floatingActionButton.B(this.b, false);
                return true;
            }
            return false;
        }

        private boolean k(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (i(view, floatingActionButton)) {
                if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                    floatingActionButton.p(this.b, false);
                    return true;
                }
                floatingActionButton.B(this.b, false);
                return true;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: a */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.f2912m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public boolean b() {
            return this.f2914c;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: e */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                j(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (c(view)) {
                k(view, floatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: f */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i2) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = dependencies.get(i3);
                if (view instanceof AppBarLayout) {
                    if (j(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (c(view) && k(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i2);
            d(coordinatorLayout, floatingActionButton);
            return true;
        }

        public void g(boolean z) {
            this.f2914c = z;
        }

        @VisibleForTesting
        public void h(b bVar) {
            this.b = bVar;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f2914c = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f2905f != colorStateList) {
            this.f2905f = colorStateList;
            getImpl().Y(this.f2905f);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FloatingActionButton(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
