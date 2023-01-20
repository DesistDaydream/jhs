package com.jihuanshe.ui.widget;

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
import com.jihuanshe.ui.widget.FilterInfoPopupWindow;
import com.vector.ext.view.ViewKt;
import com.vector.util.LayoutManagers;
import e.l.g.v;
import e.l.k.ge;
import e.l.r.s;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.u.b;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class FilterInfoPopupWindow extends PopupWindow {
    @d
    private final Context a;
    @d
    private final View b;
    @e

    /* renamed from: c */
    private final List<e.l.s.a> f4071c;
    @e

    /* renamed from: d */
    private final l<Boolean, t1> f4072d;
    @e

    /* renamed from: e */
    private final l<e.l.s.a, t1> f4073e;

    /* renamed from: f */
    private boolean f4074f;

    /* renamed from: g */
    public ge f4075g;
    @d

    /* renamed from: h */
    private final w f4076h;
    @d

    /* renamed from: i */
    private final w f4077i;
    @d

    /* renamed from: j */
    private final e.t.j.h.l f4078j;
    @d

    /* renamed from: k */
    private final g f4079k;
    @e

    /* renamed from: l */
    private ValueAnimator f4080l;
    @e

    /* renamed from: m */
    private Animation f4081m;

    /* loaded from: classes2.dex */
    public static final class a implements Animation.AnimationListener {
        public final /* synthetic */ View a;

        public a(View view) {
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

    public /* synthetic */ FilterInfoPopupWindow(Context context, View view, List list, l lVar, l lVar2, int i2, u uVar) {
        this(context, view, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : lVar, (i2 & 16) != 0 ? null : lVar2);
    }

    public static final void a(FilterInfoPopupWindow filterInfoPopupWindow, ValueAnimator valueAnimator) {
        View view = filterInfoPopupWindow.h().f12743c;
        Object animatedValue = valueAnimator == null ? null : valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        view.setAlpha(((Integer) animatedValue).intValue() / 1000.0f);
    }

    public static final void b(FilterInfoPopupWindow filterInfoPopupWindow) {
        l<Boolean, t1> l2 = filterInfoPopupWindow.l();
        if (l2 != null) {
            l2.invoke(Boolean.FALSE);
        }
        super.dismiss();
    }

    private final ValueAnimator.AnimatorUpdateListener d() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.c.k
            {
                FilterInfoPopupWindow.this = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FilterInfoPopupWindow.a(FilterInfoPopupWindow.this, valueAnimator);
            }
        };
    }

    private final void n() {
        setContentView(h().getRoot());
        setWidth(-1);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        w(h().a);
    }

    private final void o() {
        s(ge.d(LayoutInflater.from(this.a)));
        h().h(this);
        h().setLifecycleOwner((LifecycleOwner) this.a);
    }

    private final void v(int i2, int i3, long j2) {
        ValueAnimator e2 = b.a.e(i2, i3, j2);
        this.f4080l = e2;
        if (e2 != null) {
            e2.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ValueAnimator valueAnimator = this.f4080l;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(d());
        }
        ValueAnimator valueAnimator2 = this.f4080l;
        if (valueAnimator2 == null) {
            return;
        }
        valueAnimator2.start();
    }

    private final void w(View view) {
        if (ViewKt.r(view)) {
            return;
        }
        v(0, 1000, 300L);
        ViewKt.I(view);
        TranslateAnimation h2 = s.a.h(300L);
        this.f4081m = h2;
        if (h2 != null) {
            h2.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        view.setAnimation(this.f4081m);
    }

    private final void x(View view) {
        if (ViewKt.q(view)) {
            return;
        }
        v(1000, 0, 300L);
        TranslateAnimation b = s.a.b(300L);
        this.f4081m = b;
        if (b != null) {
            b.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        view.setAnimation(this.f4081m);
        view.startAnimation(this.f4081m);
        Animation animation = this.f4081m;
        if (animation == null) {
            return;
        }
        animation.setAnimationListener(new a(view));
    }

    @d
    public final v c() {
        return (v) this.f4076h.getValue();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        x(h().a);
        h().a.postDelayed(new Runnable() { // from class: e.l.q.c.l
            {
                FilterInfoPopupWindow.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FilterInfoPopupWindow.b(FilterInfoPopupWindow.this);
            }
        }, 300L);
    }

    @e
    public final List<e.l.s.a> e() {
        return this.f4071c;
    }

    @d
    public final LayoutManagers.a f() {
        return (LayoutManagers.a) this.f4077i.getValue();
    }

    @e
    public final l<e.l.s.a, t1> g() {
        return this.f4073e;
    }

    @d
    public final Context getContext() {
        return this.a;
    }

    @d
    public final ge h() {
        ge geVar = this.f4075g;
        Objects.requireNonNull(geVar);
        return geVar;
    }

    @e
    public final Animation i() {
        return this.f4081m;
    }

    @d
    public final g j() {
        return this.f4079k;
    }

    @d
    public final e.t.j.h.l k() {
        return this.f4078j;
    }

    @e
    public final l<Boolean, t1> l() {
        return this.f4072d;
    }

    @d
    public final View m() {
        return this.b;
    }

    public final boolean p() {
        return this.f4074f;
    }

    public final void s(@d ge geVar) {
        this.f4075g = geVar;
    }

    public final void t(@e Animation animation) {
        this.f4081m = animation;
    }

    public final void u(boolean z) {
        this.f4074f = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilterInfoPopupWindow(@d Context context, @d View view, @e List<e.l.s.a> list, @e l<? super Boolean, t1> lVar, @e l<? super e.l.s.a, t1> lVar2) {
        super(context);
        this.a = context;
        this.b = view;
        this.f4071c = list;
        this.f4072d = lVar;
        this.f4073e = lVar2;
        this.f4076h = z.c(FilterInfoPopupWindow$adapterFilter$2.INSTANCE);
        this.f4077i = z.c(FilterInfoPopupWindow$layoutManagerFilter$2.INSTANCE);
        this.f4078j = d.e.a.a(new FilterInfoPopupWindow$onFilterItemClick$1(this));
        this.f4079k = e.t.j.h.d.a.a(new FilterInfoPopupWindow$onClickCancel$1(this));
        o();
        n();
    }
}
