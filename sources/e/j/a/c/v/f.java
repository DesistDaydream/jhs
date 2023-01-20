package e.j.a.c.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class f extends Drawable implements Animatable2Compat {
    private static final boolean o = false;
    private static final int p = 500;
    private static final Property<f, Float> q = new c(Float.class, "growFraction");
    public final Context a;
    public final e.j.a.c.v.b b;

    /* renamed from: d  reason: collision with root package name */
    private ValueAnimator f11027d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f11028e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11029f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11030g;

    /* renamed from: h  reason: collision with root package name */
    private float f11031h;

    /* renamed from: i  reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f11032i;

    /* renamed from: j  reason: collision with root package name */
    private Animatable2Compat.AnimationCallback f11033j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11034k;

    /* renamed from: l  reason: collision with root package name */
    private float f11035l;
    private int n;

    /* renamed from: m  reason: collision with root package name */
    public final Paint f11036m = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public e.j.a.c.v.a f11026c = new e.j.a.c.v.a();

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            f.this.e();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.super.setVisible(false, false);
            f.this.d();
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends Property<f, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.g());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(f fVar, Float f2) {
            fVar.m(f2.floatValue());
        }
    }

    public f(@NonNull Context context, @NonNull e.j.a.c.v.b bVar) {
        this.a = context;
        this.b = bVar;
        setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Animatable2Compat.AnimationCallback animationCallback = this.f11033j;
        if (animationCallback != null) {
            animationCallback.onAnimationEnd(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.f11032i;
        if (list == null || this.f11034k) {
            return;
        }
        for (Animatable2Compat.AnimationCallback animationCallback2 : list) {
            animationCallback2.onAnimationEnd(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Animatable2Compat.AnimationCallback animationCallback = this.f11033j;
        if (animationCallback != null) {
            animationCallback.onAnimationStart(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.f11032i;
        if (list == null || this.f11034k) {
            return;
        }
        for (Animatable2Compat.AnimationCallback animationCallback2 : list) {
            animationCallback2.onAnimationStart(this);
        }
    }

    private void f(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z = this.f11034k;
        this.f11034k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f11034k = z;
    }

    private void l() {
        if (this.f11027d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, q, 0.0f, 1.0f);
            this.f11027d = ofFloat;
            ofFloat.setDuration(500L);
            this.f11027d.setInterpolator(e.j.a.c.a.a.b);
            r(this.f11027d);
        }
        if (this.f11028e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, q, 1.0f, 0.0f);
            this.f11028e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f11028e.setInterpolator(e.j.a.c.a.a.b);
            n(this.f11028e);
        }
    }

    private void n(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f11028e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f11028e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    private void r(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f11027d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f11027d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    public void clearAnimationCallbacks() {
        this.f11032i.clear();
        this.f11032i = null;
    }

    public float g() {
        if (this.b.b() || this.b.a()) {
            if (!this.f11030g && !this.f11029f) {
                return this.f11035l;
            }
            return this.f11031h;
        }
        return 1.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @NonNull
    public ValueAnimator h() {
        return this.f11028e;
    }

    public boolean i() {
        return s(false, false, false);
    }

    public boolean isRunning() {
        return k() || j();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f11028e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f11030g;
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.f11027d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f11029f;
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f11035l != f2) {
            this.f11035l = f2;
            invalidateSelf();
        }
    }

    public void o(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f11033j = animationCallback;
    }

    @VisibleForTesting
    public void p(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f11030g = z;
        this.f11031h = f2;
    }

    @VisibleForTesting
    public void q(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f11029f = z;
        this.f11031h = f2;
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.f11032i == null) {
            this.f11032i = new ArrayList();
        }
        if (this.f11032i.contains(animationCallback)) {
            return;
        }
        this.f11032i.add(animationCallback);
    }

    public boolean s(boolean z, boolean z2, boolean z3) {
        return t(z, z2, z3 && this.f11026c.a(this.a.getContentResolver()) > 0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.n = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f11036m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return s(z, z2, true);
    }

    public void start() {
        t(true, true, false);
    }

    public void stop() {
        t(false, true, false);
    }

    public boolean t(boolean z, boolean z2, boolean z3) {
        l();
        if (isVisible() || z) {
            ValueAnimator valueAnimator = z ? this.f11027d : this.f11028e;
            if (!z3) {
                if (valueAnimator.isRunning()) {
                    valueAnimator.end();
                } else {
                    f(valueAnimator);
                }
                return super.setVisible(z, false);
            } else if (z3 && valueAnimator.isRunning()) {
                return false;
            } else {
                boolean z4 = !z || super.setVisible(z, false);
                if (!(z ? this.b.b() : this.b.a())) {
                    f(valueAnimator);
                    return z4;
                }
                if (!z2 && Build.VERSION.SDK_INT >= 19 && valueAnimator.isPaused()) {
                    valueAnimator.resume();
                } else {
                    valueAnimator.start();
                }
                return z4;
            }
        }
        return false;
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f11032i;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.f11032i.remove(animationCallback);
        if (this.f11032i.isEmpty()) {
            this.f11032i = null;
            return true;
        }
        return true;
    }
}
