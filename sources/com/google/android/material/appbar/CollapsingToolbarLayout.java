package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int D = R.style.Widget_Design_CollapsingToolbar;
    private static final int E = 600;
    public static final int F = 0;
    public static final int G = 1;
    private boolean A;
    private int B;
    private boolean C;
    private boolean a;
    private int b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f2705c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private View f2706d;

    /* renamed from: e  reason: collision with root package name */
    private View f2707e;

    /* renamed from: f  reason: collision with root package name */
    private int f2708f;

    /* renamed from: g  reason: collision with root package name */
    private int f2709g;

    /* renamed from: h  reason: collision with root package name */
    private int f2710h;

    /* renamed from: i  reason: collision with root package name */
    private int f2711i;

    /* renamed from: j  reason: collision with root package name */
    private final Rect f2712j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final e.j.a.c.s.a f2713k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final e.j.a.c.p.a f2714l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2715m;
    private boolean n;
    @Nullable
    private Drawable o;
    @Nullable
    public Drawable p;
    private int q;
    private boolean r;
    private ValueAnimator s;
    private long t;
    private int u;
    private AppBarLayout.d v;
    public int w;
    private int x;
    @Nullable
    public WindowInsetsCompat y;
    private int z;

    /* loaded from: classes2.dex */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return CollapsingToolbarLayout.this.r(windowInsetsCompat);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes2.dex */
    public class c implements AppBarLayout.d {
        public c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.d, com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i2) {
            int height;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.w = i2;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.y;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                e.j.a.c.b.a j2 = CollapsingToolbarLayout.j(childAt);
                int i4 = layoutParams.a;
                if (i4 == 1) {
                    j2.k(MathUtils.clamp(-i2, 0, CollapsingToolbarLayout.this.h(childAt)));
                } else if (i4 == 2) {
                    j2.k(Math.round((-i2) * layoutParams.b));
                }
            }
            CollapsingToolbarLayout.this.z();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.p != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height2 = (CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop;
            float f2 = height2;
            CollapsingToolbarLayout.this.f2713k.w0(Math.min(1.0f, (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f2));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f2713k.k0(collapsingToolbarLayout3.w + height2);
            CollapsingToolbarLayout.this.f2713k.u0(Math.abs(i2) / f2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface d {
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void A(int i2, int i3, int i4, int i5, boolean z) {
        View view;
        if (!this.f2715m || (view = this.f2707e) == null) {
            return;
        }
        boolean z2 = ViewCompat.isAttachedToWindow(view) && this.f2707e.getVisibility() == 0;
        this.n = z2;
        if (z2 || z) {
            boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
            u(z3);
            this.f2713k.l0(z3 ? this.f2710h : this.f2708f, this.f2712j.top + this.f2709g, (i4 - i2) - (z3 ? this.f2708f : this.f2710h), (i5 - i3) - this.f2711i);
            this.f2713k.Z(z);
        }
    }

    private void B() {
        if (this.f2705c != null && this.f2715m && TextUtils.isEmpty(this.f2713k.N())) {
            setTitle(i(this.f2705c));
        }
    }

    private void a(int i2) {
        c();
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.s = valueAnimator2;
            valueAnimator2.setDuration(this.t);
            this.s.setInterpolator(i2 > this.q ? e.j.a.c.a.a.f10551c : e.j.a.c.a.a.f10552d);
            this.s.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.s.cancel();
        }
        this.s.setIntValues(this.q, i2);
        this.s.start();
    }

    private void b(AppBarLayout appBarLayout) {
        if (n()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void c() {
        if (this.a) {
            ViewGroup viewGroup = null;
            this.f2705c = null;
            this.f2706d = null;
            int i2 = this.b;
            if (i2 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i2);
                this.f2705c = viewGroup2;
                if (viewGroup2 != null) {
                    this.f2706d = d(viewGroup2);
                }
            }
            if (this.f2705c == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if (p(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i3++;
                }
                this.f2705c = viewGroup;
            }
            y();
            this.a = false;
        }
    }

    @NonNull
    private View d(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return view;
    }

    private static int g(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getMeasuredHeight();
    }

    private static CharSequence i(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (Build.VERSION.SDK_INT < 21 || !(view instanceof android.widget.Toolbar)) {
            return null;
        }
        return ((android.widget.Toolbar) view).getTitle();
    }

    @NonNull
    public static e.j.a.c.b.a j(@NonNull View view) {
        int i2 = R.id.view_offset_helper;
        e.j.a.c.b.a aVar = (e.j.a.c.b.a) view.getTag(i2);
        if (aVar == null) {
            e.j.a.c.b.a aVar2 = new e.j.a.c.b.a(view);
            view.setTag(i2, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private boolean n() {
        return this.x == 1;
    }

    private static boolean p(View view) {
        return (view instanceof Toolbar) || (Build.VERSION.SDK_INT >= 21 && (view instanceof android.widget.Toolbar));
    }

    private boolean q(View view) {
        View view2 = this.f2706d;
        if (view2 == null || view2 == this) {
            if (view == this.f2705c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private void u(boolean z) {
        int i2;
        int i3;
        int i4;
        View view = this.f2706d;
        if (view == null) {
            view = this.f2705c;
        }
        int h2 = h(view);
        e.j.a.c.s.c.a(this, this.f2707e, this.f2712j);
        ViewGroup viewGroup = this.f2705c;
        int i5 = 0;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i5 = toolbar.getTitleMarginStart();
            i3 = toolbar.getTitleMarginEnd();
            i4 = toolbar.getTitleMarginTop();
            i2 = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i5 = toolbar2.getTitleMarginStart();
            i3 = toolbar2.getTitleMarginEnd();
            i4 = toolbar2.getTitleMarginTop();
            i2 = toolbar2.getTitleMarginBottom();
        }
        e.j.a.c.s.a aVar = this.f2713k;
        Rect rect = this.f2712j;
        int i6 = rect.left + (z ? i3 : i5);
        int i7 = rect.top + h2 + i4;
        int i8 = rect.right;
        if (!z) {
            i5 = i3;
        }
        aVar.b0(i6, i7, i8 - i5, (rect.bottom + h2) - i2);
    }

    private void v() {
        setContentDescription(getTitle());
    }

    private void w(@NonNull Drawable drawable, int i2, int i3) {
        x(drawable, this.f2705c, i2, i3);
    }

    private void x(@NonNull Drawable drawable, @Nullable View view, int i2, int i3) {
        if (n() && view != null && this.f2715m) {
            i3 = view.getBottom();
        }
        drawable.setBounds(0, 0, i2, i3);
    }

    private void y() {
        View view;
        if (!this.f2715m && (view = this.f2707e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2707e);
            }
        }
        if (!this.f2715m || this.f2705c == null) {
            return;
        }
        if (this.f2707e == null) {
            this.f2707e = new View(getContext());
        }
        if (this.f2707e.getParent() == null) {
            this.f2705c.addView(this.f2707e, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        c();
        if (this.f2705c == null && (drawable = this.o) != null && this.q > 0) {
            drawable.mutate().setAlpha(this.q);
            this.o.draw(canvas);
        }
        if (this.f2715m && this.n) {
            if (this.f2705c != null && this.o != null && this.q > 0 && n() && this.f2713k.G() < this.f2713k.H()) {
                int save = canvas.save();
                canvas.clipRect(this.o.getBounds(), Region.Op.DIFFERENCE);
                this.f2713k.m(canvas);
                canvas.restoreToCount(save);
            } else {
                this.f2713k.m(canvas);
            }
        }
        if (this.p == null || this.q <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.y;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.p.setBounds(0, -this.w, getWidth(), systemWindowInsetTop - this.w);
            this.p.mutate().setAlpha(this.q);
            this.p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        if (this.o == null || this.q <= 0 || !q(view)) {
            z = false;
        } else {
            x(this.o, view, getWidth(), getHeight());
            this.o.mutate().setAlpha(this.q);
            this.o.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j2) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        e.j.a.c.s.a aVar = this.f2713k;
        if (aVar != null) {
            z |= aVar.E0(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f2713k.r();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.f2713k.w();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.o;
    }

    public int getExpandedTitleGravity() {
        return this.f2713k.C();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f2711i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f2710h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f2708f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f2709g;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.f2713k.F();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.f2713k.I();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.f2713k.J();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.f2713k.K();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.f2713k.L();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.f2713k.M();
    }

    public int getScrimAlpha() {
        return this.q;
    }

    public long getScrimAnimationDuration() {
        return this.t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.u;
        if (i2 >= 0) {
            return i2 + this.z + this.B;
        }
        WindowInsetsCompat windowInsetsCompat = this.y;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.p;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.f2715m) {
            return this.f2713k.N();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.x;
    }

    public final int h(@NonNull View view) {
        return ((getHeight() - j(view).c()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean k() {
        return this.C;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean l() {
        return this.A;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean m() {
        return this.f2713k.T();
    }

    public boolean o() {
        return this.f2715m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            b(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.v == null) {
                this.v = new c();
            }
            appBarLayout.b(this.v);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.d dVar = this.v;
        if (dVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).q(dVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.y;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            j(getChildAt(i7)).h();
        }
        A(i2, i3, i4, i5, false);
        B();
        z();
        int childCount3 = getChildCount();
        for (int i8 = 0; i8 < childCount3; i8++) {
            j(getChildAt(i8)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        c();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        WindowInsetsCompat windowInsetsCompat = this.y;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.A) && systemWindowInsetTop > 0) {
            this.z = systemWindowInsetTop;
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.C && this.f2713k.M() > 1) {
            B();
            A(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int J = this.f2713k.J();
            if (J > 1) {
                this.B = Math.round(this.f2713k.B()) * (J - 1);
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.B, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f2705c;
        if (viewGroup != null) {
            View view = this.f2706d;
            if (view != null && view != this) {
                setMinimumHeight(g(view));
            } else {
                setMinimumHeight(g(viewGroup));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.o;
        if (drawable != null) {
            w(drawable, i2, i3);
        }
    }

    public WindowInsetsCompat r(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.y, windowInsetsCompat2)) {
            this.y = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void s(int i2, int i3, int i4, int i5) {
        this.f2708f = i2;
        this.f2709g = i3;
        this.f2710h = i4;
        this.f2711i = i5;
        requestLayout();
    }

    public void setCollapsedTitleGravity(int i2) {
        this.f2713k.g0(i2);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.f2713k.d0(i2);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.f2713k.i0(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.o = mutate;
            if (mutate != null) {
                w(mutate, getWidth(), getHeight());
                this.o.setCallback(this);
                this.o.setAlpha(this.q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(@DrawableRes int i2) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setExpandedTitleColor(@ColorInt int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.f2713k.q0(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f2711i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f2710h = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f2708f = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f2709g = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.f2713k.n0(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f2713k.p0(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.f2713k.s0(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z) {
        this.C = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.A = z;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i2) {
        this.f2713k.x0(i2);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f2) {
        this.f2713k.z0(f2);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f2) {
        this.f2713k.A0(f2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i2) {
        this.f2713k.B0(i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.f2713k.D0(z);
    }

    public void setScrimAlpha(int i2) {
        ViewGroup viewGroup;
        if (i2 != this.q) {
            if (this.o != null && (viewGroup = this.f2705c) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.q = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j2) {
        this.t = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        if (this.u != i2) {
            this.u = i2;
            z();
        }
    }

    public void setScrimsShown(boolean z) {
        t(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.p = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.p, ViewCompat.getLayoutDirection(this));
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
                this.p.setAlpha(this.q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(@DrawableRes int i2) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f2713k.F0(charSequence);
        v();
    }

    public void setTitleCollapseMode(int i2) {
        this.x = i2;
        boolean n = n();
        this.f2713k.v0(n);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            b((AppBarLayout) parent);
        }
        if (n && this.o == null) {
            setContentScrimColor(this.f2714l.g(getResources().getDimension(R.dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f2715m) {
            this.f2715m = z;
            v();
            y();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.p;
        if (drawable != null && drawable.isVisible() != z) {
            this.p.setVisible(z, false);
        }
        Drawable drawable2 = this.o;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.o.setVisible(z, false);
    }

    public void t(boolean z, boolean z2) {
        if (this.r != z) {
            if (z2) {
                a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.r = z;
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o || drawable == this.p;
    }

    public final void z() {
        if (this.o == null && this.p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.w < getScrimVisibleHeightTrigger());
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f2713k.f0(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: c  reason: collision with root package name */
        private static final float f2716c = 0.5f;

        /* renamed from: d  reason: collision with root package name */
        public static final int f2717d = 0;

        /* renamed from: e  reason: collision with root package name */
        public static final int f2718e = 1;

        /* renamed from: f  reason: collision with root package name */
        public static final int f2719f = 2;
        public int a;
        public float b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            d(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.a;
        }

        public float b() {
            return this.b;
        }

        public void c(int i2) {
            this.a = i2;
        }

        public void d(float f2) {
            this.b = f2;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.a = 0;
            this.b = 0.5f;
        }

        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3, i4);
            this.a = 0;
            this.b = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.b = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
            this.b = 0.5f;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.b = 0.5f;
        }
    }
}
