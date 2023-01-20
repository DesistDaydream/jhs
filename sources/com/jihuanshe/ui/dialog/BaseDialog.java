package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.core.view.ViewCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.jihuanshe.ui.dialog.BaseDialog;
import com.vector.fitter.Mode;
import com.vector.util.Screen;
import e.l.q.a.d0;
import e.l.q.a.e0;
import e.l.q.a.g0;
import e.l.q.a.k0.k;
import e.l.q.a.k0.l;
import e.l.q.a.k0.m;
import e.t.o.e;
import h.i;
import h.k2.v.f0;
import h.t1;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;
import kotlin.LazyThreadSafetyMode;

@e(Mode.DEFAULT)
@i(message = "请使用BaseDialogFragment")
/* loaded from: classes2.dex */
public abstract class BaseDialog extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, LifecycleOwner, LifecycleObserver {
    private g0 a;
    @k.e.a.e
    private View b;

    /* renamed from: c */
    private int f3930c;
    @k.e.a.e

    /* renamed from: d */
    private l f3931d;
    @k.e.a.e

    /* renamed from: e */
    private k f3932e;

    /* renamed from: f */
    private float f3933f;

    /* renamed from: g */
    private int f3934g;

    /* renamed from: h */
    private boolean f3935h;

    /* renamed from: i */
    private boolean f3936i;

    /* renamed from: j */
    private boolean f3937j;

    /* renamed from: k */
    private long f3938k;
    @k.e.a.e

    /* renamed from: l */
    private h.k2.u.a<t1> f3939l;

    /* renamed from: m */
    private boolean f3940m;
    @d
    private final w n;
    @d
    private final w o;
    @d
    private final w p;
    @d
    private final Runnable q;
    private float r;
    private float s;

    /* loaded from: classes2.dex */
    public static final class a implements View.OnLayoutChangeListener {
        public a() {
            BaseDialog.this = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@d View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            view.removeOnLayoutChangeListener(this);
            ViewDataBinding d2 = BaseDialog.this.d();
            d2.setLifecycleOwner(BaseDialog.this.getActivity());
            BaseDialog.this.b = d2.getRoot();
            BaseDialog baseDialog = BaseDialog.this;
            baseDialog.addView(baseDialog.b);
        }
    }

    public BaseDialog(@d Context context) {
        super(context);
        Lifecycle lifecycle;
        this.f3933f = 0.6f;
        this.f3934g = 17;
        this.f3935h = true;
        this.f3936i = true;
        this.f3938k = 200L;
        this.n = z.c(new BaseDialog$layoutInflater$2(context));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.o = z.b(lazyThreadSafetyMode, new BaseDialog$dispatcher$2(this));
        this.p = z.b(lazyThreadSafetyMode, new BaseDialog$eventObserver$2(this));
        this.f3930c = ViewConfiguration.get(context).getScaledTouchSlop();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        FragmentActivity activity = getActivity();
        if (activity != null && (lifecycle = activity.getLifecycle()) != null) {
            lifecycle.addObserver(this);
        }
        if (ViewCompat.isLaidOut(this) && !isLayoutRequested()) {
            ViewDataBinding d2 = d();
            d2.setLifecycleOwner(getActivity());
            this.b = d2.getRoot();
            addView(this.b);
        } else {
            addOnLayoutChangeListener(new a());
        }
        getDispatcher().a(getEventObserver());
        getDispatcher().d();
        this.q = new Runnable() { // from class: e.l.q.a.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseDialog.q(BaseDialog.this);
            }
        };
    }

    public static final void A(BaseDialog baseDialog) {
        ViewGroup.LayoutParams layoutParams = baseDialog.b.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Screen screen = Screen.a;
        layoutParams2.width = (screen.l() <= 0 || baseDialog.getContentView().getMeasuredWidth() <= screen.l()) ? baseDialog.getContentView().getMeasuredWidth() : screen.l();
        layoutParams2.height = (screen.h() <= 0 || baseDialog.getContentView().getMeasuredHeight() <= screen.h()) ? baseDialog.getContentView().getMeasuredHeight() : screen.h();
        layoutParams2.gravity = baseDialog.f3934g;
        baseDialog.b.setLayoutParams(layoutParams2);
        baseDialog.getDispatcher().f();
    }

    private final void B() {
        if (this.b == null) {
            return;
        }
        if (this.f3931d == null) {
            this.f3931d = new l(this.f3933f, this);
        }
        l lVar = this.f3931d;
        if (lVar != null) {
            lVar.f(this.f3938k);
        }
        l lVar2 = this.f3931d;
        if (lVar2 != null) {
            lVar2.e();
        }
        l lVar3 = this.f3931d;
        if (lVar3 != null) {
            lVar3.b();
        }
        k l2 = l(this.b);
        this.f3932e = l2;
        if (l2 == null) {
            this.f3932e = new m(this.b);
        }
        k kVar = this.f3932e;
        if (kVar != null) {
            kVar.f(this.f3938k);
        }
        k kVar2 = this.f3932e;
        if (kVar2 != null) {
            kVar2.e();
        }
        k kVar3 = this.f3932e;
        if (kVar3 == null) {
            return;
        }
        kVar3.b();
    }

    private final void c() {
        View d2;
        ViewPropertyAnimator animate;
        View d3;
        ViewPropertyAnimator animate2;
        l lVar = this.f3931d;
        if (lVar != null && (d3 = lVar.d()) != null && (animate2 = d3.animate()) != null) {
            animate2.cancel();
        }
        k kVar = this.f3932e;
        if (kVar == null || (d2 = kVar.d()) == null || (animate = d2.animate()) == null) {
            return;
        }
        animate.cancel();
    }

    private final void e() {
        try {
            if (this.a == null) {
                g0 g0Var = new g0(getContext());
                g0Var.a(this);
                t1 t1Var = t1.a;
                this.a = g0Var;
            }
            g0 g0Var2 = this.a;
            if (g0Var2 != null) {
                g0Var2.setCancelable(this.f3935h);
                g0 g0Var3 = this.a;
                if (g0Var3 != null) {
                    g0Var3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: e.l.q.a.b
                        @Override // android.content.DialogInterface.OnKeyListener
                        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                            return BaseDialog.p(BaseDialog.this, dialogInterface, i2, keyEvent);
                        }
                    });
                    g0 g0Var4 = this.a;
                    if (g0Var4 != null) {
                        g0Var4.show();
                        this.f3940m = false;
                        k();
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        } catch (Exception e2) {
            Log.e("BaseDialog", f0.C("show exception: ", e2.getMessage()));
        }
    }

    public static final boolean f(BaseDialog baseDialog, DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            return baseDialog.s();
        }
        return false;
    }

    public static final void g(BaseDialog baseDialog) {
        FragmentActivity activity = baseDialog.getActivity();
        if (activity == null) {
            return;
        }
        if (!activity.isDestroyed() && !activity.isFinishing()) {
            baseDialog.j();
        }
        baseDialog.getDispatcher().e();
    }

    private final d0 getDispatcher() {
        return (d0) this.o.getValue();
    }

    private final LifecycleEventObserver getEventObserver() {
        return (LifecycleEventObserver) this.p.getValue();
    }

    private final void j() {
        g0 g0Var = this.a;
        if (g0Var != null) {
            Objects.requireNonNull(g0Var);
            if (!g0Var.isShowing() || this.f3940m) {
                return;
            }
            this.f3940m = true;
            g0 g0Var2 = this.a;
            Objects.requireNonNull(g0Var2);
            g0Var2.dismiss();
            h.k2.u.a<t1> aVar = this.f3939l;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }
    }

    private final boolean m(float f2, float f3, Rect rect) {
        return f2 >= ((float) rect.left) && f2 <= ((float) rect.right) && f3 >= ((float) rect.top) && f3 <= ((float) rect.bottom);
    }

    public static /* synthetic */ void o(BaseDialog baseDialog) {
        A(baseDialog);
    }

    public static /* synthetic */ boolean p(BaseDialog baseDialog, DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        return f(baseDialog, dialogInterface, i2, keyEvent);
    }

    public static /* synthetic */ void q(BaseDialog baseDialog) {
        g(baseDialog);
    }

    public static /* synthetic */ void r(BaseDialog baseDialog) {
        z(baseDialog);
    }

    public static final void z(BaseDialog baseDialog) {
        baseDialog.B();
        View view = baseDialog.b;
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: e.l.q.a.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseDialog.o(BaseDialog.this);
            }
        });
    }

    @d
    public abstract ViewDataBinding d();

    @k.e.a.e
    public final FragmentActivity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof FragmentActivity) {
                return (FragmentActivity) context;
            }
        }
        return null;
    }

    @k.e.a.e
    public final View getContentView() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    @d
    public final Runnable getDelayDismiss() {
        return this.q;
    }

    public final int getGravity() {
        return this.f3934g;
    }

    @d
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.n.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @d
    public Lifecycle getLifecycle() {
        return getDispatcher().b();
    }

    public final void h() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        clearFocus();
        e0.a.a(this);
        k kVar = this.f3932e;
        if (kVar != null) {
            kVar.a();
        }
        l lVar = this.f3931d;
        if (lVar != null) {
            lVar.a();
        }
        postDelayed(this.q, this.f3938k);
    }

    public void k() {
    }

    @k.e.a.e
    public k l(@d View view) {
        return null;
    }

    public final boolean n() {
        g0 g0Var = this.a;
        if (g0Var != null) {
            Objects.requireNonNull(g0Var);
            return g0Var.isShowing();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Lifecycle lifecycle;
        FragmentActivity activity = getActivity();
        if (activity != null && (lifecycle = activity.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        h();
        j();
        c();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f3937j) {
            g0 g0Var = this.a;
            Objects.requireNonNull(g0Var);
            if (g0Var.getWindow() == null) {
                return;
            }
            e0 e0Var = e0.a;
            g0 g0Var2 = this.a;
            Objects.requireNonNull(g0Var2);
            if (e0Var.d(g0Var2.getWindow()) > 0) {
                g0 g0Var3 = this.a;
                Objects.requireNonNull(g0Var3);
                e0Var.h(e0Var.d(g0Var3.getWindow()), this);
                return;
            }
            e0Var.g(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onLifecycleDestroy() {
        onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@d MotionEvent motionEvent) {
        Rect rect = new Rect();
        View contentView = getContentView();
        if (contentView != null) {
            contentView.getGlobalVisibleRect(rect);
        }
        if (!m(motionEvent.getX(), motionEvent.getY(), rect)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.r = motionEvent.getX();
                this.s = motionEvent.getY();
            } else if (action == 1 || action == 3) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.r, 2.0d) + Math.pow(motionEvent.getY() - this.s, 2.0d))) < this.f3930c && this.f3936i) {
                    h();
                }
            }
        }
        return true;
    }

    public boolean s() {
        return false;
    }

    public final void setCancelable(boolean z) {
        this.f3935h = z;
    }

    public final void setDimAmount(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f3933f = f2;
    }

    public final void setDismissOnTouchOutside(boolean z) {
        this.f3936i = z;
    }

    public final void setGravity(int i2) {
        this.f3934g = i2;
    }

    public final void setMoveWithKeyboard(boolean z) {
        this.f3937j = z;
    }

    public void t() {
    }

    @CallSuper
    public void u() {
        getDispatcher().h(getEventObserver());
    }

    public void v(@d h.k2.u.a<t1> aVar) {
        this.f3939l = aVar;
    }

    public void w() {
    }

    public void x() {
    }

    public final void y() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        g0 g0Var = this.a;
        if (g0Var != null) {
            Objects.requireNonNull(g0Var);
            if (g0Var.isShowing()) {
                return;
            }
        }
        removeCallbacks(this.q);
        getDispatcher().d();
        e();
        post(new Runnable() { // from class: e.l.q.a.d
            @Override // java.lang.Runnable
            public final void run() {
                BaseDialog.r(BaseDialog.this);
            }
        });
    }
}
