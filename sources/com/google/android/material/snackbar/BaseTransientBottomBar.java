package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import e.j.a.c.b0.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int A = 180;
    private static final int B = 150;
    private static final int C = 75;
    private static final float D = 0.8f;
    @NonNull
    public static final Handler E;
    public static final int F = 0;
    public static final int G = 1;
    private static final boolean H;
    private static final int[] I;
    private static final String J;
    public static final int u = 0;
    public static final int v = 1;
    public static final int w = -2;
    public static final int x = -1;
    public static final int y = 0;
    public static final int z = 250;
    @NonNull
    private final ViewGroup a;
    private final Context b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SnackbarBaseLayout f3033c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final e.j.a.c.b0.a f3034d;

    /* renamed from: e  reason: collision with root package name */
    private int f3035e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3036f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private View f3037g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3038h;

    /* renamed from: i  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f3039i;
    @RequiresApi(29)

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f3040j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Rect f3041k;

    /* renamed from: l  reason: collision with root package name */
    private int f3042l;

    /* renamed from: m  reason: collision with root package name */
    private int f3043m;
    private int n;
    private int o;
    private int p;
    private List<t<B>> q;
    private Behavior r;
    @Nullable
    private final AccessibilityManager s;
    @NonNull
    public b.InterfaceC0350b t;

    /* loaded from: classes2.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull
        private final u t = new u(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void p(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.t.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return this.t.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.t.b(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: h  reason: collision with root package name */
        private static final View.OnTouchListener f3044h = new a();
        private y a;
        private x b;

        /* renamed from: c  reason: collision with root package name */
        private int f3045c;

        /* renamed from: d  reason: collision with root package name */
        private final float f3046d;

        /* renamed from: e  reason: collision with root package name */
        private final float f3047e;

        /* renamed from: f  reason: collision with root package name */
        private ColorStateList f3048f;

        /* renamed from: g  reason: collision with root package name */
        private PorterDuff.Mode f3049g;

        /* loaded from: classes2.dex */
        public static class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public SnackbarBaseLayout(@NonNull Context context) {
            this(context, null);
        }

        @NonNull
        private Drawable a() {
            float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(e.j.a.c.l.a.j(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f3048f != null) {
                Drawable wrap = DrawableCompat.wrap(gradientDrawable);
                DrawableCompat.setTintList(wrap, this.f3048f);
                return wrap;
            }
            return DrawableCompat.wrap(gradientDrawable);
        }

        public float getActionTextColorAlpha() {
            return this.f3047e;
        }

        public int getAnimationMode() {
            return this.f3045c;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f3046d;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            x xVar = this.b;
            if (xVar != null) {
                xVar.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            x xVar = this.b;
            if (xVar != null) {
                xVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            y yVar = this.a;
            if (yVar != null) {
                yVar.a(this, i2, i3, i4, i5);
            }
        }

        public void setAnimationMode(int i2) {
            this.f3045c = i2;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f3048f != null) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.f3048f);
                DrawableCompat.setTintMode(drawable, this.f3049g);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f3048f = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(wrap, colorStateList);
                DrawableCompat.setTintMode(wrap, this.f3049g);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f3049g = mode;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(wrap, mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        public void setOnAttachStateChangeListener(x xVar) {
            this.b = xVar;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f3044h);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(y yVar) {
            this.a = yVar;
        }

        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(e.j.a.c.e0.a.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            int i2 = R.styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i2)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            this.f3045c = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.f3046d = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(e.j.a.c.w.c.a(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(e.j.a.c.s.t.k(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f3047e = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f3044h);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f3033c;
            if (snackbarBaseLayout == null) {
                return;
            }
            if (snackbarBaseLayout.getParent() != null) {
                BaseTransientBottomBar.this.f3033c.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f3033c.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.h0();
            } else {
                BaseTransientBottomBar.this.j0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.S();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;

        public c(int i2) {
            this.a = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.R(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f3033c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f3033c.setScaleX(floatValue);
            BaseTransientBottomBar.this.f3033c.setScaleY(floatValue);
        }
    }

    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.S();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f3034d.a(70, 180);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        private int a;
        public final /* synthetic */ int b;

        public g(int i2) {
            this.b = i2;
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.H) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f3033c, intValue - this.a);
            } else {
                BaseTransientBottomBar.this.f3033c.setTranslationY(intValue);
            }
            this.a = intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class h extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;

        public h(int i2) {
            this.a = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.R(this.a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f3034d.b(0, 180);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        private int a = 0;

        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.H) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f3033c, intValue - this.a);
            } else {
                BaseTransientBottomBar.this.f3033c.setTranslationY(intValue);
            }
            this.a = intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class j implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).f0();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).L(message.arg1);
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements ViewTreeObserver.OnGlobalLayoutListener {
        public k() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (BaseTransientBottomBar.this.f3038h) {
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                baseTransientBottomBar.p = baseTransientBottomBar.v();
                BaseTransientBottomBar.this.l0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int F;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f3033c == null || baseTransientBottomBar.b == null || (F = (BaseTransientBottomBar.this.F() - BaseTransientBottomBar.this.J()) + ((int) BaseTransientBottomBar.this.f3033c.getTranslationY())) >= BaseTransientBottomBar.this.o) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f3033c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.J, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.o - F;
            BaseTransientBottomBar.this.f3033c.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public class m implements OnApplyWindowInsetsListener {
        public m() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.f3042l = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.f3043m = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.n = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.l0();
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes2.dex */
    public class n extends AccessibilityDelegateCompat {
        public n() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                BaseTransientBottomBar.this.w();
                return true;
            }
            return super.performAccessibilityAction(view, i2, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public class o implements b.InterfaceC0350b {
        public o() {
        }

        @Override // e.j.a.c.b0.b.InterfaceC0350b
        public void a(int i2) {
            Handler handler = BaseTransientBottomBar.E;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }

        @Override // e.j.a.c.b0.b.InterfaceC0350b
        public void show() {
            Handler handler = BaseTransientBottomBar.E;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    /* loaded from: classes2.dex */
    public class p implements x {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.R(3);
            }
        }

        public p() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.x
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = BaseTransientBottomBar.this.f3033c.getRootWindowInsets()) == null) {
                return;
            }
            BaseTransientBottomBar.this.o = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            BaseTransientBottomBar.this.l0();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.x
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.P()) {
                BaseTransientBottomBar.E.post(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class q implements y {
        public q() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.y
        public void a(View view, int i2, int i3, int i4, int i5) {
            BaseTransientBottomBar.this.f3033c.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.g0();
        }
    }

    /* loaded from: classes2.dex */
    public class r implements SwipeDismissBehavior.c {
        public r() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(@NonNull View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.x(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i2) {
            if (i2 == 0) {
                e.j.a.c.b0.b.c().l(BaseTransientBottomBar.this.t);
            } else if (i2 == 1 || i2 == 2) {
                e.j.a.c.b0.b.c().k(BaseTransientBottomBar.this.t);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface s {
    }

    /* loaded from: classes2.dex */
    public static abstract class t<B> {
        public static final int a = 0;
        public static final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3051c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f3052d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f3053e = 4;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes2.dex */
        public @interface a {
        }

        public void a(B b2, int i2) {
        }

        public void b(B b2) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static class u {
        private b.InterfaceC0350b a;

        public u(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.l(0.1f);
            swipeDismissBehavior.i(0.6f);
            swipeDismissBehavior.m(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    e.j.a.c.b0.b.c().k(this.a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                e.j.a.c.b0.b.c().l(this.a);
            }
        }

        public void c(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.t;
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface v extends e.j.a.c.b0.a {
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface w {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface x {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface y {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        H = i2 >= 16 && i2 <= 19;
        I = new int[]{R.attr.snackbarStyle};
        J = BaseTransientBottomBar.class.getSimpleName();
        E = new Handler(Looper.getMainLooper(), new j());
    }

    public BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull e.j.a.c.b0.a aVar) {
        this(viewGroup.getContext(), viewGroup, view, aVar);
    }

    private ValueAnimator E(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(e.j.a.c.a.a.f10552d);
        ofFloat.addUpdateListener(new e());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(17)
    public int F() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.b.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int H() {
        int height = this.f3033c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f3033c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int J() {
        int[] iArr = new int[2];
        this.f3033c.getLocationOnScreen(iArr);
        return iArr[1] + this.f3033c.getHeight();
    }

    private boolean Q() {
        ViewGroup.LayoutParams layoutParams = this.f3033c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior);
    }

    private void b0(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.r;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = D();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).p(this);
        }
        swipeDismissBehavior.j(new r());
        layoutParams.setBehavior(swipeDismissBehavior);
        if (this.f3037g == null) {
            layoutParams.insetEdge = 80;
        }
    }

    private boolean d0() {
        return this.o > 0 && !this.f3036f && Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        if (c0()) {
            t();
            return;
        }
        if (this.f3033c.getParent() != null) {
            this.f3033c.setVisibility(0);
        }
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        ValueAnimator y2 = y(0.0f, 1.0f);
        ValueAnimator E2 = E(D, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(y2, E2);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    private void i0(int i2) {
        ValueAnimator y2 = y(1.0f, 0.0f);
        y2.setDuration(75L);
        y2.addListener(new c(i2));
        y2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        int H2 = H();
        if (H) {
            ViewCompat.offsetTopAndBottom(this.f3033c, H2);
        } else {
            this.f3033c.setTranslationY(H2);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(H2, 0);
        valueAnimator.setInterpolator(e.j.a.c.a.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new f());
        valueAnimator.addUpdateListener(new g(H2));
        valueAnimator.start();
    }

    private void k0(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, H());
        valueAnimator.setInterpolator(e.j.a.c.a.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new h(i2));
        valueAnimator.addUpdateListener(new i());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.f3033c.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (rect = this.f3041k) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = rect.bottom + (this.f3037g != null ? this.p : this.f3042l);
            marginLayoutParams.leftMargin = rect.left + this.f3043m;
            marginLayoutParams.rightMargin = rect.right + this.n;
            this.f3033c.requestLayout();
            if (Build.VERSION.SDK_INT < 29 || !d0()) {
                return;
            }
            this.f3033c.removeCallbacks(this.f3040j);
            this.f3033c.post(this.f3040j);
            return;
        }
        Log.w(J, "Unable to update margins because layout params are not MarginLayoutParams");
    }

    private void u(int i2) {
        if (this.f3033c.getAnimationMode() == 1) {
            i0(i2);
        } else {
            k0(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v() {
        View view = this.f3037g;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.a.getHeight()) - i2;
    }

    private ValueAnimator y(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(e.j.a.c.a.a.a);
        ofFloat.addUpdateListener(new d());
        return ofFloat;
    }

    public int A() {
        return this.f3033c.getAnimationMode();
    }

    public Behavior B() {
        return this.r;
    }

    public int C() {
        return this.f3035e;
    }

    @NonNull
    public SwipeDismissBehavior<? extends View> D() {
        return new Behavior();
    }

    @LayoutRes
    public int G() {
        return K() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }

    @NonNull
    public View I() {
        return this.f3033c;
    }

    public boolean K() {
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(I);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public final void L(int i2) {
        if (c0() && this.f3033c.getVisibility() == 0) {
            u(i2);
        } else {
            R(i2);
        }
    }

    public boolean M() {
        return this.f3038h;
    }

    public boolean N() {
        return this.f3036f;
    }

    public boolean O() {
        return e.j.a.c.b0.b.c().e(this.t);
    }

    public boolean P() {
        return e.j.a.c.b0.b.c().f(this.t);
    }

    public void R(int i2) {
        e.j.a.c.b0.b.c().i(this.t);
        List<t<B>> list = this.q;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.q.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f3033c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f3033c);
        }
    }

    public void S() {
        e.j.a.c.b0.b.c().j(this.t);
        List<t<B>> list = this.q;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.q.get(size).b(this);
            }
        }
    }

    @NonNull
    public B T(@Nullable t<B> tVar) {
        List<t<B>> list;
        if (tVar == null || (list = this.q) == null) {
            return this;
        }
        list.remove(tVar);
        return this;
    }

    @NonNull
    public B U(@IdRes int i2) {
        View findViewById = this.a.findViewById(i2);
        if (findViewById != null) {
            return V(findViewById);
        }
        throw new IllegalArgumentException("Unable to find anchor view with id: " + i2);
    }

    @NonNull
    public B V(@Nullable View view) {
        e.j.a.c.s.t.l(this.f3037g, this.f3039i);
        this.f3037g = view;
        e.j.a.c.s.t.a(view, this.f3039i);
        return this;
    }

    public void W(boolean z2) {
        this.f3038h = z2;
    }

    @NonNull
    public B X(int i2) {
        this.f3033c.setAnimationMode(i2);
        return this;
    }

    @NonNull
    public B Y(Behavior behavior) {
        this.r = behavior;
        return this;
    }

    @NonNull
    public B Z(int i2) {
        this.f3035e = i2;
        return this;
    }

    @NonNull
    public B a0(boolean z2) {
        this.f3036f = z2;
        return this;
    }

    public boolean c0() {
        AccessibilityManager accessibilityManager = this.s;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void e0() {
        e.j.a.c.b0.b.c().n(C(), this.t);
    }

    public final void f0() {
        this.f3033c.setOnAttachStateChangeListener(new p());
        if (this.f3033c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f3033c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                b0((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.p = v();
            l0();
            this.f3033c.setVisibility(4);
            this.a.addView(this.f3033c);
        }
        if (ViewCompat.isLaidOut(this.f3033c)) {
            g0();
        } else {
            this.f3033c.setOnLayoutChangeListener(new q());
        }
    }

    @NonNull
    public Context getContext() {
        return this.b;
    }

    @NonNull
    public B s(@Nullable t<B> tVar) {
        if (tVar == null) {
            return this;
        }
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.add(tVar);
        return this;
    }

    public void t() {
        this.f3033c.post(new a());
    }

    public void w() {
        x(3);
    }

    public void x(int i2) {
        e.j.a.c.b0.b.c().b(this.t, i2);
    }

    @Nullable
    public View z() {
        return this.f3037g;
    }

    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull e.j.a.c.b0.a aVar) {
        this.f3038h = false;
        this.f3039i = new k();
        this.f3040j = new l();
        this.t = new o();
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar != null) {
            this.a = viewGroup;
            this.f3034d = aVar;
            this.b = context;
            e.j.a.c.s.m.a(context);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(G(), viewGroup, false);
            this.f3033c = snackbarBaseLayout;
            if (view instanceof SnackbarContentLayout) {
                ((SnackbarContentLayout) view).c(snackbarBaseLayout.getActionTextColorAlpha());
            }
            snackbarBaseLayout.addView(view);
            ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.f3041k = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
            ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
            ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
            ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new m());
            ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new n());
            this.s = (AccessibilityManager) context.getSystemService("accessibility");
            return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    }
}
