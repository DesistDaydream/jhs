package e.j.a.c.v;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import e.j.a.c.v.b;

/* loaded from: classes2.dex */
public final class e<S extends b> extends f {
    private static final int w = 10000;
    private static final float x = 50.0f;
    private static final FloatPropertyCompat<e> y = new a("indicatorLevel");
    private g<S> r;
    private final SpringForce s;
    private final SpringAnimation t;
    private float u;
    private boolean v;

    /* loaded from: classes2.dex */
    public static class a extends FloatPropertyCompat<e> {
        public a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: a */
        public float getValue(e eVar) {
            return eVar.z() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: b */
        public void setValue(e eVar, float f2) {
            eVar.B(f2 / 10000.0f);
        }
    }

    public e(@NonNull Context context, @NonNull b bVar, @NonNull g<S> gVar) {
        super(context, bVar);
        this.v = false;
        A(gVar);
        SpringForce springForce = new SpringForce();
        this.s = springForce;
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, y);
        this.t = springAnimation;
        springAnimation.setSpring(springForce);
        m(1.0f);
    }

    public void B(float f2) {
        this.u = f2;
        invalidateSelf();
    }

    @NonNull
    public static e<CircularProgressIndicatorSpec> w(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new e<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec));
    }

    @NonNull
    public static e<LinearProgressIndicatorSpec> x(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new e<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec));
    }

    public float z() {
        return this.u;
    }

    public void A(@NonNull g<S> gVar) {
        this.r = gVar;
        gVar.f(this);
    }

    public void C(float f2) {
        setLevel((int) (f2 * 10000.0f));
    }

    @Override // e.j.a.c.v.f, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.r.g(canvas, g());
            this.r.c(canvas, this.f11036m);
            this.r.b(canvas, this.f11036m, 0.0f, z(), e.j.a.c.l.a.a(this.b.f11008c[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // e.j.a.c.v.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.r.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.r.e();
    }

    @Override // e.j.a.c.v.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // e.j.a.c.v.f
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // e.j.a.c.v.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // e.j.a.c.v.f
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.t.cancel();
        B(getLevel() / 10000.0f);
    }

    @Override // e.j.a.c.v.f
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        if (this.v) {
            this.t.cancel();
            B(i2 / 10000.0f);
            return true;
        }
        this.t.setStartValue(z() * 10000.0f);
        this.t.animateToFinalPosition(i2);
        return true;
    }

    @Override // e.j.a.c.v.f, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    @Override // e.j.a.c.v.f
    public /* bridge */ /* synthetic */ boolean s(boolean z, boolean z2, boolean z3) {
        return super.s(z, z2, z3);
    }

    @Override // e.j.a.c.v.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i2) {
        super.setAlpha(i2);
    }

    @Override // e.j.a.c.v.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // e.j.a.c.v.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // e.j.a.c.v.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // e.j.a.c.v.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // e.j.a.c.v.f
    public boolean t(boolean z, boolean z2, boolean z3) {
        boolean t = super.t(z, z2, z3);
        float a2 = this.f11026c.a(this.a.getContentResolver());
        if (a2 == 0.0f) {
            this.v = true;
        } else {
            this.v = false;
            this.s.setStiffness(50.0f / a2);
        }
        return t;
    }

    @Override // e.j.a.c.v.f, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    @NonNull
    public g<S> y() {
        return this.r;
    }
}
