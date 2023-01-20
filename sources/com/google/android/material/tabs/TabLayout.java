package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import e.j.a.c.s.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
/* loaded from: classes2.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int G0 = 2;
    public static final int H0 = 3;
    public static final int I0 = 0;
    public static final int J0 = 1;
    @Dimension(unit = 0)
    private static final int R = 72;
    @Dimension(unit = 0)
    public static final int S = 8;
    @Dimension(unit = 0)
    private static final int T = 48;
    @Dimension(unit = 0)
    private static final int U = 56;
    @Dimension(unit = 0)
    public static final int V = 16;
    private static final int W = -1;
    private static final int a0 = 300;
    private static final String c0 = "TabLayout";
    public static final int d0 = 0;
    public static final int e0 = 1;
    public static final int f0 = 2;
    public static final int g0 = 0;
    public static final int h0 = 1;
    public static final int i0 = 0;
    public static final int j0 = 1;
    public static final int k0 = 2;
    public static final int l0 = 0;
    public static final int m0 = 1;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    private e.j.a.c.c0.b E;
    @Nullable
    private c F;
    private final ArrayList<c> G;
    @Nullable
    private c H;
    private ValueAnimator I;
    @Nullable
    public ViewPager J;
    @Nullable
    private PagerAdapter K;
    private DataSetObserver L;
    private k M;
    private b N;
    private boolean O;
    private final Pools.Pool<TabView> P;
    private final ArrayList<Tab> a;
    @Nullable
    private Tab b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SlidingTabIndicator f3062c;

    /* renamed from: d  reason: collision with root package name */
    public int f3063d;

    /* renamed from: e  reason: collision with root package name */
    public int f3064e;

    /* renamed from: f  reason: collision with root package name */
    public int f3065f;

    /* renamed from: g  reason: collision with root package name */
    public int f3066g;

    /* renamed from: h  reason: collision with root package name */
    public int f3067h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f3068i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f3069j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f3070k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public Drawable f3071l;

    /* renamed from: m  reason: collision with root package name */
    private int f3072m;
    public PorterDuff.Mode n;
    public float o;
    public float p;
    public final int q;
    public int r;
    private final int s;
    private final int t;
    private final int u;
    private int v;
    public int w;
    public int x;
    public int y;
    public int z;
    private static final int Q = R.style.Widget_Design_TabLayout;
    private static final Pools.Pool<Tab> b0 = new Pools.SynchronizedPool(16);

    /* loaded from: classes2.dex */
    public class SlidingTabIndicator extends LinearLayout {
        public ValueAnimator a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public float f3073c;

        /* renamed from: d  reason: collision with root package name */
        private int f3074d;

        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ View b;

            public a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                SlidingTabIndicator.this.h(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        /* loaded from: classes2.dex */
        public class b extends AnimatorListenerAdapter {
            public final /* synthetic */ int a;

            public b(int i2) {
                this.a = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SlidingTabIndicator.this.b = this.a;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SlidingTabIndicator.this.b = this.a;
            }
        }

        public SlidingTabIndicator(Context context) {
            super(context);
            this.b = -1;
            this.f3074d = -1;
            setWillNotDraw(false);
        }

        private void e() {
            View childAt = getChildAt(this.b);
            e.j.a.c.c0.b bVar = TabLayout.this.E;
            TabLayout tabLayout = TabLayout.this;
            bVar.d(tabLayout, childAt, tabLayout.f3071l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(View view, View view2, float f2) {
            if (view != null && view.getWidth() > 0) {
                e.j.a.c.c0.b bVar = TabLayout.this.E;
                TabLayout tabLayout = TabLayout.this;
                bVar.c(tabLayout, view, view2, f2, tabLayout.f3071l);
            } else {
                Drawable drawable = TabLayout.this.f3071l;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f3071l.getBounds().bottom);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        private void i(boolean z, int i2, int i3) {
            View childAt = getChildAt(this.b);
            View childAt2 = getChildAt(i2);
            if (childAt2 == null) {
                e();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.a = valueAnimator;
                valueAnimator.setInterpolator(e.j.a.c.a.a.b);
                valueAnimator.setDuration(i3);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i2));
                valueAnimator.start();
                return;
            }
            this.a.removeAllUpdateListeners();
            this.a.addUpdateListener(aVar);
        }

        public void b(int i2, int i3) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.a.cancel();
            }
            i(true, i2, i3);
        }

        public boolean c() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public float d() {
            return this.b + this.f3073c;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int height = TabLayout.this.f3071l.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.f3071l.getIntrinsicHeight();
            }
            int i2 = TabLayout.this.y;
            int i3 = 0;
            if (i2 == 0) {
                i3 = getHeight() - height;
                height = getHeight();
            } else if (i2 == 1) {
                i3 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            } else if (i2 != 2) {
                height = i2 != 3 ? 0 : getHeight();
            }
            if (TabLayout.this.f3071l.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f3071l.getBounds();
                TabLayout.this.f3071l.setBounds(bounds.left, i3, bounds.right, height);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.f3071l;
                if (tabLayout.f3072m != 0) {
                    drawable = DrawableCompat.wrap(drawable);
                    if (Build.VERSION.SDK_INT == 21) {
                        drawable.setColorFilter(TabLayout.this.f3072m, PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(drawable, TabLayout.this.f3072m);
                    }
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        public void f(int i2, float f2) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.a.cancel();
            }
            this.b = i2;
            this.f3073c = f2;
            h(getChildAt(i2), getChildAt(this.b + 1), this.f3073c);
        }

        public void g(int i2) {
            Rect bounds = TabLayout.this.f3071l.getBounds();
            TabLayout.this.f3071l.setBounds(bounds.left, 0, bounds.right, i2);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                i(false, this.b, -1);
            } else {
                e();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.w == 1 || tabLayout.z == 2) {
                int childCount = getChildCount();
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        i4 = Math.max(i4, childAt.getMeasuredWidth());
                    }
                }
                if (i4 <= 0) {
                    return;
                }
                if (i4 * childCount <= getMeasuredWidth() - (((int) t.e(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i6 = 0; i6 < childCount; i6++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                        if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.w = 0;
                    tabLayout2.W(false);
                }
                if (z) {
                    super.onMeasure(i2, i3);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT >= 23 || this.f3074d == i2) {
                return;
            }
            requestLayout();
            this.f3074d = i2;
        }
    }

    /* loaded from: classes2.dex */
    public final class TabView extends LinearLayout {
        private Tab a;
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f3077c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private View f3078d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private BadgeDrawable f3079e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private View f3080f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private TextView f3081g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private ImageView f3082h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private Drawable f3083i;

        /* renamed from: j  reason: collision with root package name */
        private int f3084j;

        /* loaded from: classes2.dex */
        public class a implements View.OnLayoutChangeListener {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (this.a.getVisibility() == 0) {
                    TabView.this.w(this.a);
                }
            }
        }

        public TabView(@NonNull Context context) {
            super(context);
            this.f3084j = 2;
            x(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f3063d, TabLayout.this.f3064e, TabLayout.this.f3065f, TabLayout.this.f3066g);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.f3079e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.f3079e == null) {
                this.f3079e = BadgeDrawable.d(getContext());
            }
            v();
            BadgeDrawable badgeDrawable = this.f3079e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void i(@Nullable View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private float j(@NonNull Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }

        private void k(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        @NonNull
        private FrameLayout l() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(@NonNull Canvas canvas) {
            Drawable drawable = this.f3083i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f3083i.draw(canvas);
            }
        }

        @Nullable
        private FrameLayout n(@NonNull View view) {
            if ((view == this.f3077c || view == this.b) && e.j.a.c.c.a.a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o() {
            return this.f3079e != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void p() {
            FrameLayout frameLayout;
            if (e.j.a.c.c.a.a) {
                frameLayout = l();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) frameLayout, false);
            this.f3077c = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void q() {
            FrameLayout frameLayout;
            if (e.j.a.c.c.a.a) {
                frameLayout = l();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) frameLayout, false);
            this.b = textView;
            frameLayout.addView(textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            if (this.f3078d != null) {
                u();
            }
            this.f3079e = null;
        }

        private void t(@Nullable View view) {
            if (o() && view != null) {
                k(false);
                e.j.a.c.c.a.b(this.f3079e, view, n(view));
                this.f3078d = view;
            }
        }

        private void u() {
            if (o()) {
                k(true);
                View view = this.f3078d;
                if (view != null) {
                    e.j.a.c.c.a.g(this.f3079e, view);
                    this.f3078d = null;
                }
            }
        }

        private void v() {
            Tab tab;
            Tab tab2;
            if (o()) {
                if (this.f3080f != null) {
                    u();
                } else if (this.f3077c != null && (tab2 = this.a) != null && tab2.getIcon() != null) {
                    View view = this.f3078d;
                    ImageView imageView = this.f3077c;
                    if (view != imageView) {
                        u();
                        t(this.f3077c);
                        return;
                    }
                    w(imageView);
                } else if (this.b != null && (tab = this.a) != null && tab.getTabLabelVisibility() == 1) {
                    View view2 = this.f3078d;
                    TextView textView = this.b;
                    if (view2 != textView) {
                        u();
                        t(this.b);
                        return;
                    }
                    w(textView);
                } else {
                    u();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(@NonNull View view) {
            if (o() && view == this.f3078d) {
                e.j.a.c.c.a.j(this.f3079e, view, n(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public void x(Context context) {
            int i2 = TabLayout.this.q;
            if (i2 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i2);
                this.f3083i = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f3083i.setState(getDrawableState());
                }
            } else {
                this.f3083i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.f3070k != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a2 = e.j.a.c.x.b.a(TabLayout.this.f3070k);
                if (Build.VERSION.SDK_INT >= 21) {
                    boolean z = TabLayout.this.D;
                    if (z) {
                        gradientDrawable = null;
                    }
                    gradientDrawable = new RippleDrawable(a2, gradientDrawable, z ? null : gradientDrawable2);
                } else {
                    Drawable wrap = DrawableCompat.wrap(gradientDrawable2);
                    DrawableCompat.setTintList(wrap, a2);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, wrap});
                }
            }
            ViewCompat.setBackground(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        private void z(@Nullable TextView textView, @Nullable ImageView imageView) {
            Tab tab = this.a;
            Drawable mutate = (tab == null || tab.getIcon() == null) ? null : DrawableCompat.wrap(this.a.getIcon()).mutate();
            Tab tab2 = this.a;
            CharSequence text = tab2 != null ? tab2.getText() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(text);
            if (textView != null) {
                if (z) {
                    textView.setText(text);
                    if (this.a.labelVisibilityMode == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int e2 = (z && imageView.getVisibility() == 0) ? (int) t.e(getContext(), 8) : 0;
                if (TabLayout.this.A) {
                    if (e2 != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, e2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (e2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = e2;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Tab tab3 = this.a;
            CharSequence charSequence = tab3 != null ? tab3.contentDesc : null;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21 || i2 > 23) {
                if (!z) {
                    text = charSequence;
                }
                TooltipCompat.setTooltipText(this, text);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f3083i;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.f3083i.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.b, this.f3077c, this.f3080f};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getTop()) : view.getTop();
                    i2 = z ? Math.max(i2, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i2 - i3;
        }

        public int getContentWidth() {
            View[] viewArr = {this.b, this.f3077c, this.f3080f};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        @Nullable
        public Tab getTab() {
            return this.a;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f3079e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.f3079e.o()));
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.a.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.r, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.b != null) {
                float f2 = TabLayout.this.o;
                int i4 = this.f3084j;
                ImageView imageView = this.f3077c;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.p;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.b.getTextSize();
                int lineCount = this.b.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.b);
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (maxLines >= 0 && i4 != maxLines)) {
                    if (TabLayout.this.z == 1 && i5 > 0 && lineCount == 1 && ((layout = this.b.getLayout()) == null || j(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.b.setTextSize(0, f2);
                        this.b.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.a != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.a.select();
                return true;
            }
            return performClick;
        }

        public void s() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f3077c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f3080f;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(@Nullable Tab tab) {
            if (tab != this.a) {
                this.a = tab;
                update();
            }
        }

        public final void update() {
            Tab tab = this.a;
            Drawable drawable = null;
            View customView = tab != null ? tab.getCustomView() : null;
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.f3080f = customView;
                TextView textView = this.b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f3077c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f3077c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) customView.findViewById(16908308);
                this.f3081g = textView2;
                if (textView2 != null) {
                    this.f3084j = TextViewCompat.getMaxLines(textView2);
                }
                this.f3082h = (ImageView) customView.findViewById(16908294);
            } else {
                View view = this.f3080f;
                if (view != null) {
                    removeView(view);
                    this.f3080f = null;
                }
                this.f3081g = null;
                this.f3082h = null;
            }
            if (this.f3080f == null) {
                if (this.f3077c == null) {
                    p();
                }
                if (tab != null && tab.getIcon() != null) {
                    drawable = DrawableCompat.wrap(tab.getIcon()).mutate();
                }
                if (drawable != null) {
                    DrawableCompat.setTintList(drawable, TabLayout.this.f3069j);
                    PorterDuff.Mode mode = TabLayout.this.n;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawable, mode);
                    }
                }
                if (this.b == null) {
                    q();
                    this.f3084j = TextViewCompat.getMaxLines(this.b);
                }
                TextViewCompat.setTextAppearance(this.b, TabLayout.this.f3067h);
                ColorStateList colorStateList = TabLayout.this.f3068i;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
                z(this.b, this.f3077c);
                v();
                i(this.f3077c);
                i(this.b);
            } else {
                TextView textView3 = this.f3081g;
                if (textView3 != null || this.f3082h != null) {
                    z(textView3, this.f3082h);
                }
            }
            if (tab != null && !TextUtils.isEmpty(tab.contentDesc)) {
                setContentDescription(tab.contentDesc);
            }
            setSelected(tab != null && tab.isSelected());
        }

        public final void y() {
            setOrientation(!TabLayout.this.A ? 1 : 0);
            TextView textView = this.f3081g;
            if (textView == null && this.f3082h == null) {
                z(this.b, this.f3077c);
            } else {
                z(textView, this.f3082h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewPager.OnAdapterChangeListener {
        private boolean a;

        public b() {
        }

        public void a(boolean z) {
            this.a = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.J == viewPager) {
                tabLayout.O(pagerAdapter2, this.a);
            }
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface c<T extends Tab> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    /* loaded from: classes2.dex */
    public @interface d {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface e {
    }

    /* loaded from: classes2.dex */
    public interface f extends c<Tab> {
    }

    /* loaded from: classes2.dex */
    public class g extends DataSetObserver {
        public g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.E();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.E();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface h {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface i {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface j {
    }

    /* loaded from: classes2.dex */
    public static class k implements ViewPager.OnPageChangeListener {
        @NonNull
        private final WeakReference<TabLayout> a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f3086c;

        public k(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        public void c() {
            this.f3086c = 0;
            this.b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.b = this.f3086c;
            this.f3086c = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i4 = this.f3086c;
                boolean z = false;
                tabLayout.Q(i2, f2, i4 != 2 || this.b == 1, (i4 == 2 && this.b == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f3086c;
            tabLayout.N(tabLayout.z(i2), i3 == 0 || (i3 == 2 && this.b == 0));
        }
    }

    /* loaded from: classes2.dex */
    public static class l implements f {
        private final ViewPager a;

        public l(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(@NonNull Tab tab) {
            this.a.setCurrentItem(tab.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(Tab tab) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    private void L(int i2) {
        TabView tabView = (TabView) this.f3062c.getChildAt(i2);
        this.f3062c.removeViewAt(i2);
        if (tabView != null) {
            tabView.s();
            this.P.release(tabView);
        }
        requestLayout();
    }

    private void T(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.J;
        if (viewPager2 != null) {
            k kVar = this.M;
            if (kVar != null) {
                viewPager2.removeOnPageChangeListener(kVar);
            }
            b bVar = this.N;
            if (bVar != null) {
                this.J.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.H;
        if (cVar != null) {
            H(cVar);
            this.H = null;
        }
        if (viewPager != null) {
            this.J = viewPager;
            if (this.M == null) {
                this.M = new k(this);
            }
            this.M.c();
            viewPager.addOnPageChangeListener(this.M);
            l lVar = new l(viewPager);
            this.H = lVar;
            c(lVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                O(adapter, z);
            }
            if (this.N == null) {
                this.N = new b();
            }
            this.N.a(z);
            viewPager.addOnAdapterChangeListener(this.N);
            P(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.J = null;
            O(null, false);
        }
        this.O = z2;
    }

    private void U() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).updateView();
        }
    }

    private void V(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.z == 1 && this.w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.a.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Tab tab = this.a.get(i2);
                if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.A) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.s;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.z;
        if (i3 == 0 || i3 == 2) {
            return this.u;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f3062c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void i(@NonNull TabItem tabItem) {
        Tab D = D();
        CharSequence charSequence = tabItem.a;
        if (charSequence != null) {
            D.setText(charSequence);
        }
        Drawable drawable = tabItem.b;
        if (drawable != null) {
            D.setIcon(drawable);
        }
        int i2 = tabItem.f3061c;
        if (i2 != 0) {
            D.setCustomView(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            D.setContentDescription(tabItem.getContentDescription());
        }
        e(D);
    }

    private void j(@NonNull Tab tab) {
        TabView tabView = tab.view;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f3062c.addView(tabView, tab.getPosition(), s());
    }

    private void k(View view) {
        if (view instanceof TabItem) {
            i((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void l(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f3062c.c()) {
            int scrollX = getScrollX();
            int o = o(i2, 0.0f);
            if (scrollX != o) {
                y();
                this.I.setIntValues(scrollX, o);
                this.I.start();
            }
            this.f3062c.b(i2, this.x);
            return;
        }
        P(i2, 0.0f, true);
    }

    private void m(int i2) {
        if (i2 == 0) {
            Log.w(c0, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i2 == 1) {
            this.f3062c.setGravity(1);
            return;
        } else if (i2 != 2) {
            return;
        }
        this.f3062c.setGravity(GravityCompat.START);
    }

    private void n() {
        int i2 = this.z;
        ViewCompat.setPaddingRelative(this.f3062c, (i2 == 0 || i2 == 2) ? Math.max(0, this.v - this.f3063d) : 0, 0, 0, 0);
        int i3 = this.z;
        if (i3 == 0) {
            m(this.w);
        } else if (i3 == 1 || i3 == 2) {
            if (this.w == 2) {
                Log.w(c0, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f3062c.setGravity(1);
        }
        W(true);
    }

    private int o(int i2, float f2) {
        int i3 = this.z;
        if (i3 == 0 || i3 == 2) {
            View childAt = this.f3062c.getChildAt(i2);
            int i4 = i2 + 1;
            View childAt2 = i4 < this.f3062c.getChildCount() ? this.f3062c.getChildAt(i4) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i5 = (int) ((width + width2) * 0.5f * f2);
            return ViewCompat.getLayoutDirection(this) == 0 ? left + i5 : left - i5;
        }
        return 0;
    }

    private void q(@NonNull Tab tab, int i2) {
        tab.setPosition(i2);
        this.a.add(i2, tab);
        int size = this.a.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            }
            this.a.get(i2).setPosition(i2);
        }
    }

    @NonNull
    private static ColorStateList r(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    @NonNull
    private LinearLayout.LayoutParams s() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        V(layoutParams);
        return layoutParams;
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f3062c.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f3062c.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    @NonNull
    private TabView u(@NonNull Tab tab) {
        Pools.Pool<TabView> pool = this.P;
        TabView acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new TabView(getContext());
        }
        acquire.setTab(tab);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.contentDesc)) {
            acquire.setContentDescription(tab.text);
        } else {
            acquire.setContentDescription(tab.contentDesc);
        }
        return acquire;
    }

    private void v(@NonNull Tab tab) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).c(tab);
        }
    }

    private void w(@NonNull Tab tab) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).a(tab);
        }
    }

    private void x(@NonNull Tab tab) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).b(tab);
        }
    }

    private void y() {
        if (this.I == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.I = valueAnimator;
            valueAnimator.setInterpolator(e.j.a.c.a.a.b);
            this.I.setDuration(this.x);
            this.I.addUpdateListener(new a());
        }
    }

    public boolean A() {
        return this.D;
    }

    public boolean B() {
        return this.A;
    }

    public boolean C() {
        return this.B;
    }

    @NonNull
    public Tab D() {
        Tab t = t();
        t.parent = this;
        t.view = u(t);
        if (t.id != -1) {
            t.view.setId(t.id);
        }
        return t;
    }

    public void E() {
        int currentItem;
        G();
        PagerAdapter pagerAdapter = this.K;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                h(D().setText(this.K.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.J;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            M(z(currentItem));
        }
    }

    public boolean F(Tab tab) {
        return b0.release(tab);
    }

    public void G() {
        for (int childCount = this.f3062c.getChildCount() - 1; childCount >= 0; childCount--) {
            L(childCount);
        }
        Iterator<Tab> it = this.a.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.reset();
            F(next);
        }
        this.b = null;
    }

    @Deprecated
    public void H(@Nullable c cVar) {
        this.G.remove(cVar);
    }

    public void I(@NonNull f fVar) {
        H(fVar);
    }

    public void J(@NonNull Tab tab) {
        if (tab.parent == this) {
            K(tab.getPosition());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void K(int i2) {
        Tab tab = this.b;
        int position = tab != null ? tab.getPosition() : 0;
        L(i2);
        Tab remove = this.a.remove(i2);
        if (remove != null) {
            remove.reset();
            F(remove);
        }
        int size = this.a.size();
        for (int i3 = i2; i3 < size; i3++) {
            this.a.get(i3).setPosition(i3);
        }
        if (position == i2) {
            M(this.a.isEmpty() ? null : this.a.get(Math.max(0, i2 - 1)));
        }
    }

    public void M(@Nullable Tab tab) {
        N(tab, true);
    }

    public void N(@Nullable Tab tab, boolean z) {
        Tab tab2 = this.b;
        if (tab2 == tab) {
            if (tab2 != null) {
                v(tab);
                l(tab.getPosition());
                return;
            }
            return;
        }
        int position = tab != null ? tab.getPosition() : -1;
        if (z) {
            if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                P(position, 0.0f, true);
            } else {
                l(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        this.b = tab;
        if (tab2 != null) {
            x(tab2);
        }
        if (tab != null) {
            w(tab);
        }
    }

    public void O(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.K;
        if (pagerAdapter2 != null && (dataSetObserver = this.L) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.K = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.L == null) {
                this.L = new g();
            }
            pagerAdapter.registerDataSetObserver(this.L);
        }
        E();
    }

    public void P(int i2, float f2, boolean z) {
        Q(i2, f2, z, true);
    }

    public void Q(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.f3062c.getChildCount()) {
            return;
        }
        if (z2) {
            this.f3062c.f(i2, f2);
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.I.cancel();
        }
        scrollTo(o(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void R(int i2, int i3) {
        setTabTextColors(r(i2, i3));
    }

    public void S(@Nullable ViewPager viewPager, boolean z) {
        T(viewPager, z, false);
    }

    public void W(boolean z) {
        for (int i2 = 0; i2 < this.f3062c.getChildCount(); i2++) {
            View childAt = this.f3062c.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            V((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        k(view);
    }

    @Deprecated
    public void c(@Nullable c cVar) {
        if (this.G.contains(cVar)) {
            return;
        }
        this.G.add(cVar);
    }

    public void d(@NonNull f fVar) {
        c(fVar);
    }

    public void e(@NonNull Tab tab) {
        h(tab, this.a.isEmpty());
    }

    public void f(@NonNull Tab tab, int i2) {
        g(tab, i2, this.a.isEmpty());
    }

    public void g(@NonNull Tab tab, int i2, boolean z) {
        if (tab.parent == this) {
            q(tab, i2);
            j(tab);
            if (z) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public int getSelectedTabPosition() {
        Tab tab = this.b;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    public int getTabCount() {
        return this.a.size();
    }

    public int getTabGravity() {
        return this.w;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.f3069j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.C;
    }

    public int getTabIndicatorGravity() {
        return this.y;
    }

    public int getTabMaxWidth() {
        return this.r;
    }

    public int getTabMode() {
        return this.z;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.f3070k;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.f3071l;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f3068i;
    }

    public void h(@NonNull Tab tab, boolean z) {
        g(tab, this.a.size(), z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.j.a.c.z.k.e(this);
        if (this.J == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                T((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.O) {
            setupWithViewPager(null);
            this.O = false;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        for (int i2 = 0; i2 < this.f3062c.getChildCount(); i2++) {
            View childAt = this.f3062c.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).m(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r0 != 2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L25;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = e.j.a.c.s.t.e(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.t
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = e.j.a.c.s.t.e(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.r = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.z
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.widget.HorizontalScrollView.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public void p() {
        this.G.clear();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        e.j.a.c.z.k.d(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.A != z) {
            this.A = z;
            for (int i2 = 0; i2 < this.f3062c.getChildCount(); i2++) {
                View childAt = this.f3062c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).y();
                }
            }
            n();
        }
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable f fVar) {
        setOnTabSelectedListener((c) fVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        y();
        this.I.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.f3071l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f3071l = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.f3072m = i2;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.y != i2) {
            this.y = i2;
            ViewCompat.postInvalidateOnAnimation(this.f3062c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f3062c.g(i2);
    }

    public void setTabGravity(int i2) {
        if (this.w != i2) {
            this.w = i2;
            n();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f3069j != colorStateList) {
            this.f3069j = colorStateList;
            U();
        }
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.C = i2;
        if (i2 == 0) {
            this.E = new e.j.a.c.c0.b();
        } else if (i2 == 1) {
            this.E = new e.j.a.c.c0.a();
        } else {
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.B = z;
        ViewCompat.postInvalidateOnAnimation(this.f3062c);
    }

    public void setTabMode(int i2) {
        if (i2 != this.z) {
            this.z = i2;
            n();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f3070k != colorStateList) {
            this.f3070k = colorStateList;
            for (int i2 = 0; i2 < this.f3062c.getChildCount(); i2++) {
                View childAt = this.f3062c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).x(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f3068i != colorStateList) {
            this.f3068i = colorStateList;
            U();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        O(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.D != z) {
            this.D = z;
            for (int i2 = 0; i2 < this.f3062c.getChildCount(); i2++) {
                View childAt = this.f3062c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).x(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        S(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public Tab t() {
        Tab acquire = b0.acquire();
        return acquire == null ? new Tab() : acquire;
    }

    @Nullable
    public Tab z(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.a.get(i2);
    }

    /* loaded from: classes2.dex */
    public static class Tab {
        public static final int INVALID_POSITION = -1;
        @Nullable
        private CharSequence contentDesc;
        @Nullable
        private View customView;
        @Nullable
        private Drawable icon;
        @Nullable
        public TabLayout parent;
        @Nullable
        private Object tag;
        @Nullable
        private CharSequence text;
        @NonNull
        public TabView view;
        private int position = -1;
        @d
        private int labelVisibilityMode = 1;
        private int id = -1;

        @Nullable
        public BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.customView;
        }

        @Nullable
        public Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.id;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public int getPosition() {
            return this.position;
        }

        @d
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @Nullable
        public Object getTag() {
            return this.tag;
        }

        @Nullable
        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.position;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            this.view.r();
        }

        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                tabLayout.M(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setContentDescription(@StringRes int i2) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setContentDescription(tabLayout.getResources().getText(i2));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setCustomView(@Nullable View view) {
            this.customView = view;
            updateView();
            return this;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable drawable) {
            this.icon = drawable;
            TabLayout tabLayout = this.parent;
            if (tabLayout.w == 1 || tabLayout.z == 2) {
                tabLayout.W(true);
            }
            updateView();
            if (e.j.a.c.c.a.a && this.view.o() && this.view.f3079e.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        public Tab setId(int i2) {
            this.id = i2;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.setId(i2);
            }
            return this;
        }

        public void setPosition(int i2) {
            this.position = i2;
        }

        @NonNull
        public Tab setTabLabelVisibility(@d int i2) {
            this.labelVisibilityMode = i2;
            TabLayout tabLayout = this.parent;
            if (tabLayout.w == 1 || tabLayout.z == 2) {
                tabLayout.W(true);
            }
            updateView();
            if (e.j.a.c.c.a.a && this.view.o() && this.view.f3079e.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        public Tab setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        public void updateView() {
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int i2) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i2, (ViewGroup) this.view, false));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence charSequence) {
            this.contentDesc = charSequence;
            updateView();
            return this;
        }

        @NonNull
        public Tab setText(@StringRes int i2) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setText(tabLayout.getResources().getText(i2));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setIcon(@DrawableRes int i2) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i2));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        k(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.F;
        if (cVar2 != null) {
            H(cVar2);
        }
        this.F = cVar;
        if (cVar != null) {
            c(cVar);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r12, @androidx.annotation.Nullable android.util.AttributeSet r13, int r14) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        k(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        k(view);
    }
}
