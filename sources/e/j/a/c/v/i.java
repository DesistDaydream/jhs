package e.j.a.c.v;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import e.j.a.c.v.b;

/* loaded from: classes2.dex */
public final class i<S extends b> extends f {
    private g<S> r;
    private h<ObjectAnimator> s;

    public i(@NonNull Context context, @NonNull b bVar, @NonNull g<S> gVar, @NonNull h<ObjectAnimator> hVar) {
        super(context, bVar);
        z(gVar);
        y(hVar);
    }

    @NonNull
    public static i<CircularProgressIndicatorSpec> u(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new i<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec), new d(circularProgressIndicatorSpec));
    }

    @NonNull
    public static i<LinearProgressIndicatorSpec> v(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new i<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec), linearProgressIndicatorSpec.f3016g == 0 ? new k(linearProgressIndicatorSpec) : new l(context, linearProgressIndicatorSpec));
    }

    @Override // e.j.a.c.v.f, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        this.r.g(canvas, g());
        this.r.c(canvas, this.f11036m);
        int i2 = 0;
        while (true) {
            h<ObjectAnimator> hVar = this.s;
            int[] iArr = hVar.f11037c;
            if (i2 < iArr.length) {
                g<S> gVar = this.r;
                Paint paint = this.f11036m;
                float[] fArr = hVar.b;
                int i3 = i2 * 2;
                gVar.b(canvas, paint, fArr[i3], fArr[i3 + 1], iArr[i2]);
                i2++;
            } else {
                canvas.restore();
                return;
            }
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

    @Override // e.j.a.c.v.f
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
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
        if (!isRunning()) {
            this.s.a();
        }
        float a = this.f11026c.a(this.a.getContentResolver());
        if (z && (z3 || (Build.VERSION.SDK_INT <= 21 && a > 0.0f))) {
            this.s.g();
        }
        return t;
    }

    @Override // e.j.a.c.v.f, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    @NonNull
    public h<ObjectAnimator> w() {
        return this.s;
    }

    @NonNull
    public g<S> x() {
        return this.r;
    }

    public void y(@NonNull h<ObjectAnimator> hVar) {
        this.s = hVar;
        hVar.e(this);
    }

    public void z(@NonNull g<S> gVar) {
        this.r = gVar;
        gVar.f(this);
    }
}
