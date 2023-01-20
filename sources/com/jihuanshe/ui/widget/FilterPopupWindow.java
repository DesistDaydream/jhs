package com.jihuanshe.ui.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.ui.widget.FilterPopupWindow;
import com.vector.ext.view.ViewKt;
import com.vector.util.LayoutManagers;
import e.l.k.ee;
import e.l.r.s;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;

/* loaded from: classes2.dex */
public final class FilterPopupWindow extends PopupWindow {
    @d
    private final Context a;
    @d
    private final View b;
    @e

    /* renamed from: c */
    private final List<Pair<String, String>> f4082c;
    @e

    /* renamed from: d */
    private final l<Boolean, t1> f4083d;
    @e

    /* renamed from: e */
    private final l<Pair<String, String>, t1> f4084e;

    /* renamed from: f */
    private boolean f4085f;

    /* renamed from: g */
    public ee f4086g;
    @d

    /* renamed from: h */
    private final w f4087h;
    @d

    /* renamed from: i */
    private final w f4088i;
    @d

    /* renamed from: j */
    private final e.t.j.h.l f4089j;
    @d

    /* renamed from: k */
    private final g f4090k;
    @e

    /* renamed from: l */
    private ValueAnimator f4091l;
    @e

    /* renamed from: m */
    private Animation f4092m;

    /* loaded from: classes2.dex */
    public static final class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@d Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@d Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@d Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@d Animator animator) {
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ View a;

        public b(View view) {
            this.a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@e Animation animation) {
            ViewKt.n(this.a);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@e Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@e Animation animation) {
        }
    }

    public /* synthetic */ FilterPopupWindow(Context context, View view, List list, l lVar, l lVar2, int i2, u uVar) {
        this(context, view, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : lVar, (i2 & 16) != 0 ? null : lVar2);
    }

    public static final void a(FilterPopupWindow filterPopupWindow, ValueAnimator valueAnimator) {
        View view = filterPopupWindow.i().f12594c;
        Object animatedValue = valueAnimator == null ? null : valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        view.setAlpha(((Integer) animatedValue).intValue() / 1000.0f);
    }

    public static final void b(FilterPopupWindow filterPopupWindow) {
        l<Boolean, t1> m2 = filterPopupWindow.m();
        if (m2 != null) {
            m2.invoke(Boolean.FALSE);
        }
        super.dismiss();
    }

    private final ValueAnimator.AnimatorUpdateListener d() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.c.n
            {
                FilterPopupWindow.this = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FilterPopupWindow.a(FilterPopupWindow.this, valueAnimator);
            }
        };
    }

    private final Animator.AnimatorListener f() {
        return new a();
    }

    private final void o() {
        setContentView(i().getRoot());
        setWidth(-1);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        x(i().a);
    }

    private final void p() {
        t(ee.d(LayoutInflater.from(this.a)));
        i().h(this);
        i().setLifecycleOwner((LifecycleOwner) this.a);
    }

    private final void w(int i2, int i3, long j2) {
        ValueAnimator e2 = e.t.u.b.a.e(i2, i3, j2);
        this.f4091l = e2;
        if (e2 != null) {
            e2.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ValueAnimator valueAnimator = this.f4091l;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(d());
        }
        ValueAnimator valueAnimator2 = this.f4091l;
        if (valueAnimator2 != null) {
            valueAnimator2.addListener(f());
        }
        ValueAnimator valueAnimator3 = this.f4091l;
        if (valueAnimator3 == null) {
            return;
        }
        valueAnimator3.start();
    }

    private final void x(View view) {
        if (ViewKt.r(view)) {
            return;
        }
        w(0, 1000, 300L);
        ViewKt.I(view);
        TranslateAnimation h2 = s.a.h(300L);
        this.f4092m = h2;
        if (h2 != null) {
            h2.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        view.setAnimation(this.f4092m);
    }

    private final void y(View view) {
        if (ViewKt.q(view)) {
            return;
        }
        w(1000, 0, 300L);
        TranslateAnimation b2 = s.a.b(300L);
        this.f4092m = b2;
        if (b2 != null) {
            b2.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        view.setAnimation(this.f4092m);
        view.startAnimation(this.f4092m);
        Animation animation = this.f4092m;
        if (animation == null) {
            return;
        }
        animation.setAnimationListener(new b(view));
    }

    @d
    public final e.l.g.u c() {
        return (e.l.g.u) this.f4087h.getValue();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        y(i().a);
        i().a.postDelayed(new Runnable() { // from class: e.l.q.c.m
            {
                FilterPopupWindow.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FilterPopupWindow.b(FilterPopupWindow.this);
            }
        }, 300L);
    }

    @e
    public final List<Pair<String, String>> e() {
        return this.f4082c;
    }

    @d
    public final LayoutManagers.a g() {
        return (LayoutManagers.a) this.f4088i.getValue();
    }

    @d
    public final Context getContext() {
        return this.a;
    }

    @e
    public final l<Pair<String, String>, t1> h() {
        return this.f4084e;
    }

    @d
    public final ee i() {
        ee eeVar = this.f4086g;
        Objects.requireNonNull(eeVar);
        return eeVar;
    }

    @e
    public final Animation j() {
        return this.f4092m;
    }

    @d
    public final g k() {
        return this.f4090k;
    }

    @d
    public final e.t.j.h.l l() {
        return this.f4089j;
    }

    @e
    public final l<Boolean, t1> m() {
        return this.f4083d;
    }

    @d
    public final View n() {
        return this.b;
    }

    public final boolean q() {
        return this.f4085f;
    }

    public final void t(@d ee eeVar) {
        this.f4086g = eeVar;
    }

    public final void u(@e Animation animation) {
        this.f4092m = animation;
    }

    public final void v(boolean z) {
        this.f4085f = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilterPopupWindow(@d Context context, @d View view, @e List<Pair<String, String>> list, @e l<? super Boolean, t1> lVar, @e l<? super Pair<String, String>, t1> lVar2) {
        super(context);
        this.a = context;
        this.b = view;
        this.f4082c = list;
        this.f4083d = lVar;
        this.f4084e = lVar2;
        this.f4087h = z.c(FilterPopupWindow$adapterFilter$2.INSTANCE);
        this.f4088i = z.c(FilterPopupWindow$layoutManagerFilter$2.INSTANCE);
        this.f4089j = d.e.a.a(new FilterPopupWindow$onFilterItemClick$1(this));
        this.f4090k = e.t.j.h.d.a.a(new FilterPopupWindow$onClickCancel$1(this));
        p();
        o();
    }
}
