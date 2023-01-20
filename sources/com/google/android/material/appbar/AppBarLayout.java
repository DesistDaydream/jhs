package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import e.j.a.c.z.j;
import e.j.a.c.z.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 4;
    public static final int v = 8;
    private static final int w = R.style.Widget_Design_AppBarLayout;
    private static final int x = -1;
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f2677c;

    /* renamed from: d  reason: collision with root package name */
    private int f2678d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2679e;

    /* renamed from: f  reason: collision with root package name */
    private int f2680f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private WindowInsetsCompat f2681g;

    /* renamed from: h  reason: collision with root package name */
    private List<c> f2682h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2683i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2684j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2685k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2686l;
    @IdRes

    /* renamed from: m  reason: collision with root package name */
    private int f2687m;
    @Nullable
    private WeakReference<View> n;
    @Nullable
    private ValueAnimator o;
    private int[] p;
    @Nullable
    private Drawable q;

    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {

        /* loaded from: classes2.dex */
        public static abstract class a extends BaseBehavior.d<AppBarLayout> {
        }

        public Behavior() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean J(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i2) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean K(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void L(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void M(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void N(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable O(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean P(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i2, int i3) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void Q(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void R(@Nullable BaseBehavior.d dVar) {
            super.R(dVar);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int a() {
            return super.a();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean c() {
            return super.c();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean d() {
            return super.d();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void f(boolean z) {
            super.f(z);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean g(int i2) {
            return super.g(i2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean h(int i2) {
            return super.h(i2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void i(boolean z) {
            super.i(z);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes2.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int t(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).o();
            }
            return 0;
        }

        private void u(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f2688l) + o()) - k(view2));
            }
        }

        private void v(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.l()) {
                    appBarLayout.x(appBarLayout.z(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int a() {
            return super.a();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean c() {
            return super.c();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean d() {
            return super.d();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void f(boolean z) {
            super.f(z);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean g(int i2) {
            return super.g(i2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean h(int i2) {
            return super.h(i2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void i(boolean z) {
            super.i(z);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public float l(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int t = t(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + t > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (t / i2) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public int n(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.n(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            u(view, view2);
            v(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
            return super.onLayoutChild(coordinatorLayout, view, i2);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
            return super.onMeasureChild(coordinatorLayout, view, i2, i3, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z) {
            AppBarLayout j2 = j(coordinatorLayout.getDependencies(view));
            if (j2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f2729d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    j2.s(false, !z);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        /* renamed from: s */
        public AppBarLayout j(@NonNull List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            q(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return AppBarLayout.this.o(windowInsetsCompat);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ j a;

        public b(j jVar) {
            this.a = jVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            this.a.m0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes2.dex */
    public interface c<T extends AppBarLayout> {
        void a(T t, int i2);
    }

    /* loaded from: classes2.dex */
    public interface d extends c<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.c
        void a(AppBarLayout appBarLayout, int i2);
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean A() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
        }
        return false;
    }

    private void B(@NonNull j jVar, boolean z) {
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        float f2 = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
        this.o = ofFloat;
        ofFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.o.setInterpolator(e.j.a.c.a.a.a);
        this.o.addUpdateListener(new b(jVar));
        this.o.start();
    }

    private void C() {
        setWillNotDraw(!y());
    }

    private void c() {
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    @Nullable
    private View d(@Nullable View view) {
        int i2;
        if (this.n == null && (i2 = this.f2687m) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f2687m);
            }
            if (findViewById != null) {
                this.n = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean i() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void k() {
        this.b = -1;
        this.f2677c = -1;
        this.f2678d = -1;
    }

    private void t(boolean z, boolean z2, boolean z3) {
        this.f2680f = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    private boolean v(boolean z) {
        if (this.f2684j != z) {
            this.f2684j = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    private boolean y() {
        return this.q != null && getTopInset() > 0;
    }

    public void a(@Nullable c cVar) {
        if (this.f2682h == null) {
            this.f2682h = new ArrayList();
        }
        if (cVar == null || this.f2682h.contains(cVar)) {
            return;
        }
        this.f2682h.add(cVar);
    }

    public void b(d dVar) {
        a(dVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (y()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.a);
            this.q.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: f */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: g */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i2;
        int minimumHeight;
        int i3 = this.f2677c;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.a;
            if ((i5 & 5) == 5) {
                int i6 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i5 & 8) != 0) {
                    minimumHeight = ViewCompat.getMinimumHeight(childAt);
                } else if ((i5 & 2) != 0) {
                    minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    i2 = i6 + measuredHeight;
                    if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                    i4 += i2;
                }
                i2 = i6 + minimumHeight;
                if (childCount == 0) {
                    i2 = Math.min(i2, measuredHeight - getTopInset());
                }
                i4 += i2;
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f2677c = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i2 = this.f2678d;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i5 = layoutParams.a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f2678d = max;
        return max;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.f2687m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f2680f;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.q;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f2681g;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.b;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i3 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                i4 -= getTopInset();
            }
            if ((i5 & 2) != 0) {
                i4 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.b = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean h() {
        return this.f2679e;
    }

    public boolean j() {
        return getTotalScrollRange() != 0;
    }

    public boolean l() {
        return this.f2686l;
    }

    public boolean m() {
        return this.f2685k;
    }

    public void n(int i2) {
        this.a = i2;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<c> list = this.f2682h;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = this.f2682h.get(i3);
                if (cVar != null) {
                    cVar.a(this, i2);
                }
            }
        }
    }

    public WindowInsetsCompat o(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f2681g, windowInsetsCompat2)) {
            this.f2681g = windowInsetsCompat2;
            C();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        if (this.p == null) {
            this.p = new int[4];
        }
        int[] iArr = this.p;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z = this.f2684j;
        int i3 = R.attr.state_liftable;
        if (!z) {
            i3 = -i3;
        }
        iArr[0] = i3;
        iArr[1] = (z && this.f2685k) ? R.attr.state_lifted : -R.attr.state_lifted;
        int i4 = R.attr.state_collapsible;
        if (!z) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (z && this.f2685k) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        boolean z2 = true;
        if (ViewCompat.getFitsSystemWindows(this) && A()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        k();
        this.f2679e = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f2679e = true;
                break;
            } else {
                i6++;
            }
        }
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f2683i) {
            return;
        }
        if (!this.f2686l && !i()) {
            z2 = false;
        }
        v(z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && A()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        k();
    }

    public void p(@Nullable c cVar) {
        List<c> list = this.f2682h;
        if (list == null || cVar == null) {
            return;
        }
        list.remove(cVar);
    }

    public void q(d dVar) {
        p(dVar);
    }

    public void r() {
        this.f2680f = 0;
    }

    public void s(boolean z, boolean z2) {
        t(z, z2, true);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        k.d(this, f2);
    }

    public void setExpanded(boolean z) {
        s(z, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.f2686l = z;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i2) {
        this.f2687m = i2;
        c();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.q = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.q, ViewCompat.getLayoutDirection(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
            }
            C();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i2) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.j.a.c.b.b.b(this, f2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public boolean u(boolean z) {
        this.f2683i = true;
        return v(z);
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    public boolean w(boolean z) {
        return x(z);
    }

    public boolean x(boolean z) {
        if (this.f2685k != z) {
            this.f2685k = z;
            refreshDrawableState();
            if (this.f2686l && (getBackground() instanceof j)) {
                B((j) getBackground(), z);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean z(@Nullable View view) {
        View d2 = d(view);
        if (d2 != null) {
            view = d2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    /* loaded from: classes2.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int t = 600;
        private static final int u = -1;

        /* renamed from: l  reason: collision with root package name */
        private int f2688l;

        /* renamed from: m  reason: collision with root package name */
        private int f2689m;
        private ValueAnimator n;
        private int o;
        private boolean p;
        private float q;
        @Nullable
        private WeakReference<View> r;
        private d s;

        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ CoordinatorLayout a;
            public final /* synthetic */ AppBarLayout b;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseBehavior.this.r(this.a, this.b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes2.dex */
        public class b implements AccessibilityViewCommand {
            public final /* synthetic */ CoordinatorLayout a;
            public final /* synthetic */ AppBarLayout b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ View f2691c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ int f2692d;

            public b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
                this.f2691c = view;
                this.f2692d = i2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BaseBehavior.this.onNestedPreScroll(this.a, this.b, this.f2691c, 0, this.f2692d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* loaded from: classes2.dex */
        public class c implements AccessibilityViewCommand {
            public final /* synthetic */ AppBarLayout a;
            public final /* synthetic */ boolean b;

            public c(AppBarLayout appBarLayout, boolean z) {
                this.a = appBarLayout;
                this.b = z;
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                this.a.setExpanded(this.b);
                return true;
            }
        }

        /* loaded from: classes2.dex */
        public static abstract class d<T extends AppBarLayout> {
            public abstract boolean a(@NonNull T t);
        }

        public BaseBehavior() {
            this.o = -1;
        }

        private static boolean A(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        @Nullable
        private View B(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View C(@NonNull AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int D(@NonNull T t2, int i2) {
            int childCount = t2.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t2.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (A(layoutParams.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        private int G(@NonNull T t2, int i2) {
            int abs = Math.abs(i2);
            int childCount = t2.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t2.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator b2 = layoutParams.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = layoutParams.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        i3 -= t2.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation((abs - childAt.getTop()) / f2)));
                    }
                }
            }
            return i2;
        }

        private boolean T(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            List<View> dependents = coordinatorLayout.getDependents(t2);
            int size = dependents.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i2).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behavior).m() != 0;
                }
            }
            return false;
        }

        private void U(CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            int o = o();
            int D = D(t2, o);
            if (D >= 0) {
                View childAt = t2.getChildAt(D);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a2 = layoutParams.a();
                if ((a2 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (D == t2.getChildCount() - 1) {
                        i3 += t2.getTopInset();
                    }
                    if (A(a2, 2)) {
                        i3 += ViewCompat.getMinimumHeight(childAt);
                    } else if (A(a2, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i3;
                        if (o < minimumHeight) {
                            i2 = minimumHeight;
                        } else {
                            i3 = minimumHeight;
                        }
                    }
                    if (A(a2, 32)) {
                        i2 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i3 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (o < (i3 + i2) / 2) {
                        i2 = i3;
                    }
                    w(coordinatorLayout, t2, MathUtils.clamp(i2, -t2.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void V(CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View B = B(coordinatorLayout);
            if (B == null || t2.getTotalScrollRange() == 0 || !(((CoordinatorLayout.LayoutParams) B.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            u(coordinatorLayout, t2, B);
        }

        private void W(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2, int i3, boolean z) {
            View C = C(t2, i2);
            if (C != null) {
                int a2 = ((LayoutParams) C.getLayoutParams()).a();
                boolean z2 = false;
                if ((a2 & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(C);
                    if (i3 <= 0 || (a2 & 12) == 0 ? !((a2 & 2) == 0 || (-i2) < (C.getBottom() - minimumHeight) - t2.getTopInset()) : (-i2) >= (C.getBottom() - minimumHeight) - t2.getTopInset()) {
                        z2 = true;
                    }
                }
                if (t2.l()) {
                    z2 = t2.z(B(coordinatorLayout));
                }
                boolean x = t2.x(z2);
                if (z || (x && T(coordinatorLayout, t2))) {
                    t2.jumpDrawablesToCurrentState();
                }
            }
        }

        private void u(CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull View view) {
            if (o() != (-t2.getTotalScrollRange()) && view.canScrollVertically(1)) {
                v(coordinatorLayout, t2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            }
            if (o() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i2 = -t2.getDownNestedPreScrollRange();
                    if (i2 != 0) {
                        ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new b(coordinatorLayout, t2, view, i2));
                        return;
                    }
                    return;
                }
                v(coordinatorLayout, t2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            }
        }

        private void v(CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, boolean z) {
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new c(t2, z));
        }

        private void w(CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2, float f2) {
            int height;
            int abs = Math.abs(o() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t2.getHeight()) + 1.0f) * 150.0f);
            }
            x(coordinatorLayout, t2, i2, height);
        }

        private void x(CoordinatorLayout coordinatorLayout, T t2, int i2, int i3) {
            int o = o();
            if (o == i2) {
                ValueAnimator valueAnimator = this.n;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.n.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.n;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.n = valueAnimator3;
                valueAnimator3.setInterpolator(e.j.a.c.a.a.f10553e);
                this.n.addUpdateListener(new a(coordinatorLayout, t2));
            } else {
                valueAnimator2.cancel();
            }
            this.n.setDuration(Math.min(i3, 600));
            this.n.setIntValues(o, i2);
            this.n.start();
        }

        private boolean z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull View view) {
            return t2.j() && coordinatorLayout.getHeight() - view.getHeight() <= t2.getHeight();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: E */
        public int m(@NonNull T t2) {
            return -t2.getDownNestedScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: F */
        public int n(@NonNull T t2) {
            return t2.getTotalScrollRange();
        }

        @VisibleForTesting
        public boolean H() {
            ValueAnimator valueAnimator = this.n;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: I */
        public void p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            U(coordinatorLayout, t2);
            if (t2.l()) {
                t2.x(t2.z(B(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: J */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2) {
            int round;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, t2, i2);
            int pendingAction = t2.getPendingAction();
            int i3 = this.o;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t2.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.p) {
                    round = ViewCompat.getMinimumHeight(childAt) + t2.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.q);
                }
                r(coordinatorLayout, t2, i4 + round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -t2.getUpNestedPreScrollRange();
                    if (z) {
                        w(coordinatorLayout, t2, i5, 0.0f);
                    } else {
                        r(coordinatorLayout, t2, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        w(coordinatorLayout, t2, 0, 0.0f);
                    } else {
                        r(coordinatorLayout, t2, 0);
                    }
                }
            }
            t2.r();
            this.o = -1;
            h(MathUtils.clamp(b(), -t2.getTotalScrollRange(), 0));
            W(coordinatorLayout, t2, b(), 0, true);
            t2.n(b());
            V(coordinatorLayout, t2);
            return onLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: K */
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2, int i3, int i4, int i5) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t2.getLayoutParams())).height == -2) {
                coordinatorLayout.onMeasureChild(t2, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, t2, i2, i3, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: L */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t2, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t2.getTotalScrollRange();
                    i5 = i7;
                    i6 = t2.getDownNestedPreScrollRange() + i7;
                } else {
                    i5 = -t2.getUpNestedPreScrollRange();
                    i6 = 0;
                }
                if (i5 != i6) {
                    iArr[1] = q(coordinatorLayout, t2, i3, i5, i6);
                }
            }
            if (t2.l()) {
                t2.x(t2.z(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: M */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            if (i5 < 0) {
                iArr[1] = q(coordinatorLayout, t2, i5, -t2.getDownNestedScrollRange(), 0);
            }
            if (i5 == 0) {
                V(coordinatorLayout, t2);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: N */
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, t2, savedState.getSuperState());
                this.o = savedState.firstVisibleChildIndex;
                this.q = savedState.firstVisibleChildPercentageShown;
                this.p = savedState.firstVisibleChildAtMinimumHeight;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t2, parcelable);
            this.o = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: O */
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t2);
            int b2 = b();
            int childCount = t2.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t2.getChildAt(i2);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.firstVisibleChildIndex = i2;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == ViewCompat.getMinimumHeight(childAt) + t2.getTopInset();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: P */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z = (i2 & 2) != 0 && (t2.l() || z(coordinatorLayout, t2, view));
            if (z && (valueAnimator = this.n) != null) {
                valueAnimator.cancel();
            }
            this.r = null;
            this.f2689m = i3;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: Q */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t2, View view, int i2) {
            if (this.f2689m == 0 || i2 == 1) {
                U(coordinatorLayout, t2);
                if (t2.l()) {
                    t2.x(t2.z(view));
                }
            }
            this.r = new WeakReference<>(view);
        }

        public void R(@Nullable d dVar) {
            this.s = dVar;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: S */
        public int s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2, int i3, int i4) {
            int o = o();
            int i5 = 0;
            if (i3 != 0 && o >= i3 && o <= i4) {
                int clamp = MathUtils.clamp(i2, i3, i4);
                if (o != clamp) {
                    int G = t2.h() ? G(t2, clamp) : clamp;
                    boolean h2 = h(G);
                    i5 = o - clamp;
                    this.f2688l = clamp - G;
                    if (!h2 && t2.h()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t2);
                    }
                    t2.n(b());
                    W(coordinatorLayout, t2, clamp, clamp < o ? -1 : 1, false);
                }
            } else {
                this.f2688l = 0;
            }
            V(coordinatorLayout, t2);
            return i5;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int o() {
            return b() + this.f2688l;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: y */
        public boolean j(T t2) {
            d dVar = this.s;
            if (dVar != null) {
                return dVar.a(t2);
            }
            WeakReference<View> weakReference = this.r;
            if (weakReference != null) {
                View view = weakReference.get();
                return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
            }
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.o = -1;
        }

        /* loaded from: classes2.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            public boolean firstVisibleChildAtMinimumHeight;
            public int firstVisibleChildIndex;
            public float firstVisibleChildPercentageShown;

            /* loaded from: classes2.dex */
            public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                @Nullable
                /* renamed from: a */
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                /* renamed from: b */
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                /* renamed from: c */
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }
            }

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = com.google.android.material.appbar.AppBarLayout.w
            android.content.Context r11 = e.j.a.c.e0.a.a.c(r11, r12, r13, r4)
            r10.<init>(r11, r12, r13)
            r11 = -1
            r10.b = r11
            r10.f2677c = r11
            r10.f2678d = r11
            r6 = 0
            r10.f2680f = r6
            android.content.Context r7 = r10.getContext()
            r0 = 1
            r10.setOrientation(r0)
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 21
            if (r8 < r9) goto L27
            e.j.a.c.b.b.a(r10)
            e.j.a.c.b.b.c(r10, r12, r13, r4)
        L27:
            int[] r2 = com.google.android.material.R.styleable.AppBarLayout
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r12 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            int r13 = com.google.android.material.R.styleable.AppBarLayout_android_background
            android.graphics.drawable.Drawable r13 = r12.getDrawable(r13)
            androidx.core.view.ViewCompat.setBackground(r10, r13)
            android.graphics.drawable.Drawable r13 = r10.getBackground()
            boolean r13 = r13 instanceof android.graphics.drawable.ColorDrawable
            if (r13 == 0) goto L5f
            android.graphics.drawable.Drawable r13 = r10.getBackground()
            android.graphics.drawable.ColorDrawable r13 = (android.graphics.drawable.ColorDrawable) r13
            e.j.a.c.z.j r0 = new e.j.a.c.z.j
            r0.<init>()
            int r13 = r13.getColor()
            android.content.res.ColorStateList r13 = android.content.res.ColorStateList.valueOf(r13)
            r0.n0(r13)
            r0.Y(r7)
            androidx.core.view.ViewCompat.setBackground(r10, r0)
        L5f:
            int r13 = com.google.android.material.R.styleable.AppBarLayout_expanded
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L6e
            boolean r13 = r12.getBoolean(r13, r6)
            r10.t(r13, r6, r6)
        L6e:
            if (r8 < r9) goto L80
            int r13 = com.google.android.material.R.styleable.AppBarLayout_elevation
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L80
            int r13 = r12.getDimensionPixelSize(r13, r6)
            float r13 = (float) r13
            e.j.a.c.b.b.b(r10, r13)
        L80:
            r13 = 26
            if (r8 < r13) goto La2
            int r13 = com.google.android.material.R.styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L93
            boolean r13 = r12.getBoolean(r13, r6)
            r10.setKeyboardNavigationCluster(r13)
        L93:
            int r13 = com.google.android.material.R.styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto La2
            boolean r13 = r12.getBoolean(r13, r6)
            r10.setTouchscreenBlocksFocus(r13)
        La2:
            int r13 = com.google.android.material.R.styleable.AppBarLayout_liftOnScroll
            boolean r13 = r12.getBoolean(r13, r6)
            r10.f2686l = r13
            int r13 = com.google.android.material.R.styleable.AppBarLayout_liftOnScrollTargetViewId
            int r11 = r12.getResourceId(r13, r11)
            r10.f2687m = r11
            int r11 = com.google.android.material.R.styleable.AppBarLayout_statusBarForeground
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setStatusBarForeground(r11)
            r12.recycle()
            com.google.android.material.appbar.AppBarLayout$a r11 = new com.google.android.material.appbar.AppBarLayout$a
            r11.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: c  reason: collision with root package name */
        public static final int f2695c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static final int f2696d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static final int f2697e = 2;

        /* renamed from: f  reason: collision with root package name */
        public static final int f2698f = 4;

        /* renamed from: g  reason: collision with root package name */
        public static final int f2699g = 8;

        /* renamed from: h  reason: collision with root package name */
        public static final int f2700h = 16;

        /* renamed from: i  reason: collision with root package name */
        public static final int f2701i = 32;

        /* renamed from: j  reason: collision with root package name */
        public static final int f2702j = 5;

        /* renamed from: k  reason: collision with root package name */
        public static final int f2703k = 17;

        /* renamed from: l  reason: collision with root package name */
        public static final int f2704l = 10;
        public int a;
        public Interpolator b;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes2.dex */
        public @interface a {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            int i2 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i2, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.b;
        }

        public boolean c() {
            int i2 = this.a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public void d(int i2) {
            this.a = i2;
        }

        public void e(Interpolator interpolator) {
            this.b = interpolator;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.a = 1;
        }

        public LayoutParams(int i2, int i3, float f2) {
            super(i2, i3, f2);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.a = 1;
            this.a = layoutParams.a;
            this.b = layoutParams.b;
        }
    }
}
