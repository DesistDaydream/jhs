package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;

/* loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int M = 0;
    private static final int N = 1;
    private static final int O = 2;
    @NonNull
    private final e.j.a.c.r.f A;
    private final e.j.a.c.r.f B;
    private final e.j.a.c.r.f C;
    private final int D;
    private int E;
    private int F;
    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> G;
    private boolean H;
    private boolean I;
    private boolean J;
    @NonNull
    public ColorStateList K;
    private int x;
    private final e.j.a.c.r.a y;
    @NonNull
    private final e.j.a.c.r.f z;
    private static final int L = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property<View, Float> P = new d(Float.class, "width");
    public static final Property<View, Float> Q = new e(Float.class, "height");
    public static final Property<View, Float> R = new f(Float.class, "paddingStart");
    public static final Property<View, Float> S = new g(Float.class, "paddingEnd");

    /* loaded from: classes2.dex */
    public class a implements l {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.F;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.E;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.E + ExtendedFloatingActionButton.this.F;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements l {
        public b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        private boolean a;
        public final /* synthetic */ e.j.a.c.r.f b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f2894c;

        public c(e.j.a.c.r.f fVar, j jVar) {
            this.b = fVar;
            this.f2894c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
            this.b.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.i();
            if (this.a) {
                return;
            }
            this.b.m(this.f2894c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.b.onAnimationStart(animator);
            this.a = false;
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends Property<View, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            view.getLayoutParams().width = f2.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends Property<View, Float> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            view.getLayoutParams().height = f2.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends Property<View, Float> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            ViewCompat.setPaddingRelative(view, f2.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }
    }

    /* loaded from: classes2.dex */
    public static class g extends Property<View, Float> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f2.intValue(), view.getPaddingBottom());
        }
    }

    /* loaded from: classes2.dex */
    public class h extends e.j.a.c.r.b {

        /* renamed from: g  reason: collision with root package name */
        private final l f2896g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f2897h;

        public h(e.j.a.c.r.a aVar, l lVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f2896g = lVar;
            this.f2897h = z;
        }

        @Override // e.j.a.c.r.f
        public void b() {
            ExtendedFloatingActionButton.this.H = this.f2897h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f2896g.a().width;
            layoutParams.height = this.f2896g.a().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f2896g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f2896g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // e.j.a.c.r.f
        public boolean d() {
            return this.f2897h == ExtendedFloatingActionButton.this.H || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // e.j.a.c.r.f
        public int g() {
            return this.f2897h ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // e.j.a.c.r.b, e.j.a.c.r.f
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.I = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f2896g.a().width;
            layoutParams.height = this.f2896g.a().height;
        }

        @Override // e.j.a.c.r.b, e.j.a.c.r.f
        @NonNull
        public AnimatorSet k() {
            e.j.a.c.a.h a = a();
            if (a.j("width")) {
                PropertyValuesHolder[] g2 = a.g("width");
                g2[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f2896g.getWidth());
                a.l("width", g2);
            }
            if (a.j("height")) {
                PropertyValuesHolder[] g3 = a.g("height");
                g3[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f2896g.getHeight());
                a.l("height", g3);
            }
            if (a.j("paddingStart")) {
                PropertyValuesHolder[] g4 = a.g("paddingStart");
                g4[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.f2896g.getPaddingStart());
                a.l("paddingStart", g4);
            }
            if (a.j("paddingEnd")) {
                PropertyValuesHolder[] g5 = a.g("paddingEnd");
                g5[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.f2896g.getPaddingEnd());
                a.l("paddingEnd", g5);
            }
            if (a.j("labelOpacity")) {
                PropertyValuesHolder[] g6 = a.g("labelOpacity");
                boolean z = this.f2897h;
                g6[0].setFloatValues(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
                a.l("labelOpacity", g6);
            }
            return super.o(a);
        }

        @Override // e.j.a.c.r.f
        public void m(@Nullable j jVar) {
            if (jVar == null) {
                return;
            }
            if (this.f2897h) {
                jVar.a(ExtendedFloatingActionButton.this);
            } else {
                jVar.d(ExtendedFloatingActionButton.this);
            }
        }

        @Override // e.j.a.c.r.b, e.j.a.c.r.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.H = this.f2897h;
            ExtendedFloatingActionButton.this.I = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    /* loaded from: classes2.dex */
    public class i extends e.j.a.c.r.b {

        /* renamed from: g  reason: collision with root package name */
        private boolean f2899g;

        public i(e.j.a.c.r.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // e.j.a.c.r.f
        public void b() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // e.j.a.c.r.f
        public boolean d() {
            return ExtendedFloatingActionButton.this.I();
        }

        @Override // e.j.a.c.r.b, e.j.a.c.r.f
        public void f() {
            super.f();
            this.f2899g = true;
        }

        @Override // e.j.a.c.r.f
        public int g() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // e.j.a.c.r.b, e.j.a.c.r.f
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.x = 0;
            if (this.f2899g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // e.j.a.c.r.f
        public void m(@Nullable j jVar) {
            if (jVar != null) {
                jVar.b(ExtendedFloatingActionButton.this);
            }
        }

        @Override // e.j.a.c.r.b, e.j.a.c.r.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f2899g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.x = 1;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class j {
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void d(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    /* loaded from: classes2.dex */
    public class k extends e.j.a.c.r.b {
        public k(e.j.a.c.r.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // e.j.a.c.r.f
        public void b() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // e.j.a.c.r.f
        public boolean d() {
            return ExtendedFloatingActionButton.this.J();
        }

        @Override // e.j.a.c.r.f
        public int g() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // e.j.a.c.r.b, e.j.a.c.r.f
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.x = 0;
        }

        @Override // e.j.a.c.r.f
        public void m(@Nullable j jVar) {
            if (jVar != null) {
                jVar.c(ExtendedFloatingActionButton.this);
            }
        }

        @Override // e.j.a.c.r.b, e.j.a.c.r.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.x = 2;
        }
    }

    /* loaded from: classes2.dex */
    public interface l {
        ViewGroup.LayoutParams a();

        int getHeight();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I() {
        return getVisibility() == 0 ? this.x == 1 : this.x != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        return getVisibility() != 0 ? this.x == 2 : this.x != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(@NonNull e.j.a.c.r.f fVar, @Nullable j jVar) {
        if (fVar.d()) {
            return;
        }
        if (!Q()) {
            fVar.b();
            fVar.m(jVar);
            return;
        }
        measure(0, 0);
        AnimatorSet k2 = fVar.k();
        k2.addListener(new c(fVar, jVar));
        for (Animator.AnimatorListener animatorListener : fVar.l()) {
            k2.addListener(animatorListener);
        }
        k2.start();
    }

    private void P() {
        this.K = getTextColors();
    }

    private boolean Q() {
        return (ViewCompat.isLaidOut(this) || (!J() && this.J)) && !isInEditMode();
    }

    public void A(@NonNull Animator.AnimatorListener animatorListener) {
        this.C.h(animatorListener);
    }

    public void B(@NonNull Animator.AnimatorListener animatorListener) {
        this.B.h(animatorListener);
    }

    public void C(@NonNull Animator.AnimatorListener animatorListener) {
        this.z.h(animatorListener);
    }

    public void D() {
        K(this.A, null);
    }

    public void E(@NonNull j jVar) {
        K(this.A, jVar);
    }

    public void F() {
        K(this.C, null);
    }

    public void G(@NonNull j jVar) {
        K(this.C, jVar);
    }

    public final boolean H() {
        return this.H;
    }

    public void L(@NonNull Animator.AnimatorListener animatorListener) {
        this.A.e(animatorListener);
    }

    public void M(@NonNull Animator.AnimatorListener animatorListener) {
        this.C.e(animatorListener);
    }

    public void N(@NonNull Animator.AnimatorListener animatorListener) {
        this.B.e(animatorListener);
    }

    public void O(@NonNull Animator.AnimatorListener animatorListener) {
        this.z.e(animatorListener);
    }

    public void R() {
        K(this.B, null);
    }

    public void S(@NonNull j jVar) {
        K(this.B, jVar);
    }

    public void T() {
        K(this.z, null);
    }

    public void U(@NonNull j jVar) {
        K(this.z, jVar);
    }

    public void V(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.G;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        int i2 = this.D;
        return i2 < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i2;
    }

    @Nullable
    public e.j.a.c.a.h getExtendMotionSpec() {
        return this.A.c();
    }

    @Nullable
    public e.j.a.c.a.h getHideMotionSpec() {
        return this.C.c();
    }

    @Nullable
    public e.j.a.c.a.h getShowMotionSpec() {
        return this.B.c();
    }

    @Nullable
    public e.j.a.c.a.h getShrinkMotionSpec() {
        return this.z.c();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.H && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.H = false;
            this.z.b();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.J = z;
    }

    public void setExtendMotionSpec(@Nullable e.j.a.c.a.h hVar) {
        this.A.j(hVar);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i2) {
        setExtendMotionSpec(e.j.a.c.a.h.d(getContext(), i2));
    }

    public void setExtended(boolean z) {
        if (this.H == z) {
            return;
        }
        e.j.a.c.r.f fVar = z ? this.A : this.z;
        if (fVar.d()) {
            return;
        }
        fVar.b();
    }

    public void setHideMotionSpec(@Nullable e.j.a.c.a.h hVar) {
        this.C.j(hVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(e.j.a.c.a.h.d(getContext(), i2));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (!this.H || this.I) {
            return;
        }
        this.E = ViewCompat.getPaddingStart(this);
        this.F = ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (!this.H || this.I) {
            return;
        }
        this.E = i2;
        this.F = i4;
    }

    public void setShowMotionSpec(@Nullable e.j.a.c.a.h hVar) {
        this.B.j(hVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(e.j.a.c.a.h.d(getContext(), i2));
    }

    public void setShrinkMotionSpec(@Nullable e.j.a.c.a.h hVar) {
        this.z.j(hVar);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i2) {
        setShrinkMotionSpec(e.j.a.c.a.h.d(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        P();
    }

    public void z(@NonNull Animator.AnimatorListener animatorListener) {
        this.A.h(animatorListener);
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    /* loaded from: classes2.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: f  reason: collision with root package name */
        private static final boolean f2889f = false;

        /* renamed from: g  reason: collision with root package name */
        private static final boolean f2890g = true;
        private Rect a;
        @Nullable
        private j b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private j f2891c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2892d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2893e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f2892d = false;
            this.f2893e = true;
        }

        private static boolean e(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean l(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f2892d || this.f2893e) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        private boolean n(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (l(appBarLayout, extendedFloatingActionButton)) {
                if (this.a == null) {
                    this.a = new Rect();
                }
                Rect rect = this.a;
                e.j.a.c.s.c.a(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                    m(extendedFloatingActionButton);
                    return true;
                }
                a(extendedFloatingActionButton);
                return true;
            }
            return false;
        }

        private boolean o(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (l(view, extendedFloatingActionButton)) {
                if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                    m(extendedFloatingActionButton);
                    return true;
                }
                a(extendedFloatingActionButton);
                return true;
            }
            return false;
        }

        public void a(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.f2893e;
            extendedFloatingActionButton.K(z ? extendedFloatingActionButton.A : extendedFloatingActionButton.B, z ? this.f2891c : this.b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: b */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean c() {
            return this.f2892d;
        }

        public boolean d() {
            return this.f2893e;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: f */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                n(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (e(view)) {
                o(view, extendedFloatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: g */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = dependencies.get(i3);
                if (view instanceof AppBarLayout) {
                    if (n(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (e(view) && o(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i2);
            return true;
        }

        public void h(boolean z) {
            this.f2892d = z;
        }

        public void i(boolean z) {
            this.f2893e = z;
        }

        @VisibleForTesting
        public void j(@Nullable j jVar) {
            this.b = jVar;
        }

        @VisibleForTesting
        public void k(@Nullable j jVar) {
            this.f2891c = jVar;
        }

        public void m(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.f2893e;
            extendedFloatingActionButton.K(z ? extendedFloatingActionButton.z : extendedFloatingActionButton.C, z ? this.f2891c : this.b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f2892d = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f2893e = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.L
            r1 = r17
            android.content.Context r1 = e.j.a.c.e0.a.a.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.x = r10
            e.j.a.c.r.a r1 = new e.j.a.c.r.a
            r1.<init>()
            r0.y = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
            r11.<init>(r1)
            r0.B = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i
            r12.<init>(r1)
            r0.C = r12
            r13 = 1
            r0.H = r13
            r0.I = r10
            r0.J = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.G = r1
            int[] r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = e.j.a.c.s.m.j(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_showMotionSpec
            e.j.a.c.a.h r2 = e.j.a.c.a.h.c(r14, r1, r2)
            int r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_hideMotionSpec
            e.j.a.c.a.h r3 = e.j.a.c.a.h.c(r14, r1, r3)
            int r4 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_extendMotionSpec
            e.j.a.c.a.h r4 = e.j.a.c.a.h.c(r14, r1, r4)
            int r5 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            e.j.a.c.a.h r5 = e.j.a.c.a.h.c(r14, r1, r5)
            int r6 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_collapsedSize
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.D = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingStart(r16)
            r0.E = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingEnd(r16)
            r0.F = r6
            e.j.a.c.r.a r6 = new e.j.a.c.r.a
            r6.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h r15 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a
            r10.<init>()
            r15.<init>(r6, r10, r13)
            r0.A = r15
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b
            r13.<init>()
            r7 = 0
            r10.<init>(r6, r13, r7)
            r0.z = r10
            r11.j(r2)
            r12.j(r3)
            r15.j(r4)
            r10.j(r5)
            r1.recycle()
            e.j.a.c.z.d r1 = e.j.a.c.z.o.f11132m
            r2 = r18
            e.j.a.c.z.o$b r1 = e.j.a.c.z.o.g(r14, r2, r8, r9, r1)
            e.j.a.c.z.o r1 = r1.m()
            r0.setShapeAppearanceModel(r1)
            r16.P()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        P();
    }
}
