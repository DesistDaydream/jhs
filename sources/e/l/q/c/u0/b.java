package e.l.q.c.u0;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class b extends Drawable {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static ValueAnimator f14259h;
    private final ValueAnimator.AnimatorUpdateListener a = new a();
    private final Paint b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f14260c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f14261d;

    /* renamed from: e  reason: collision with root package name */
    private float f14262e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private e.l.q.c.u0.a f14263f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14264g;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.invalidateSelf();
        }
    }

    public b() {
        Paint paint = new Paint();
        this.b = paint;
        this.f14260c = new Rect();
        this.f14261d = new Matrix();
        this.f14262e = -1.0f;
        this.f14264g = false;
        paint.setAntiAlias(true);
    }

    public static ValueAnimator b() {
        if (f14259h == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            f14259h = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            f14259h.setRepeatMode(1);
            f14259h.setStartDelay(0L);
            f14259h.setRepeatCount(-1);
            f14259h.setDuration(1000L);
        }
        return f14259h;
    }

    private float g(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public static void j() {
        if (b().isStarted()) {
            return;
        }
        b().start();
    }

    public static void l() {
        if (b().isStarted()) {
            b().cancel();
        }
    }

    private void n() {
        e.l.q.c.u0.a aVar;
        Shader radialGradient;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width == 0 || height == 0 || (aVar = this.f14263f) == null) {
            return;
        }
        int e2 = aVar.e(width);
        int a2 = this.f14263f.a(height);
        e.l.q.c.u0.a aVar2 = this.f14263f;
        boolean z = true;
        if (aVar2.f14252g != 1) {
            int i2 = aVar2.f14249d;
            if (i2 != 1 && i2 != 3) {
                z = false;
            }
            if (z) {
                e2 = 0;
            }
            if (!z) {
                a2 = 0;
            }
            float f2 = a2;
            e.l.q.c.u0.a aVar3 = this.f14263f;
            radialGradient = new LinearGradient(0.0f, 0.0f, e2, f2, aVar3.b, aVar3.a, Shader.TileMode.CLAMP);
        } else {
            float f3 = a2 / 2.0f;
            float max = (float) (Math.max(e2, a2) / Math.sqrt(2.0d));
            e.l.q.c.u0.a aVar4 = this.f14263f;
            radialGradient = new RadialGradient(e2 / 2.0f, f3, max, aVar4.b, aVar4.a, Shader.TileMode.CLAMP);
        }
        this.b.setShader(radialGradient);
    }

    private void o() {
        if (this.f14263f == null) {
        }
    }

    public void a() {
        i(-1.0f);
    }

    @Nullable
    public e.l.q.c.u0.a c() {
        return this.f14263f;
    }

    public boolean d() {
        return b() != null && b().isRunning() && this.f14264g;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float g2;
        float g3;
        if (this.f14263f == null || this.b.getShader() == null) {
            return;
        }
        float tan = (float) Math.tan(Math.toRadians(this.f14263f.n));
        float height = this.f14260c.height() + (this.f14260c.width() * tan);
        float width = this.f14260c.width() + (tan * this.f14260c.height());
        float f2 = this.f14262e;
        float f3 = 0.0f;
        if (f2 < 0.0f) {
            f2 = b() != null ? ((Float) b().getAnimatedValue()).floatValue() : 0.0f;
        }
        int i2 = this.f14263f.f14249d;
        if (i2 != 1) {
            if (i2 == 2) {
                g3 = g(width, -width, f2);
            } else if (i2 != 3) {
                g3 = g(-width, width, f2);
            } else {
                g2 = g(height, -height, f2);
            }
            f3 = g3;
            g2 = 0.0f;
        } else {
            g2 = g(-height, height, f2);
        }
        this.f14261d.reset();
        this.f14261d.setRotate(this.f14263f.n, this.f14260c.width() / 2.0f, this.f14260c.height() / 2.0f);
        this.f14261d.preTranslate(f3, g2);
        this.b.getShader().setLocalMatrix(this.f14261d);
        canvas.drawRect(this.f14260c, this.b);
    }

    public boolean e() {
        return b() != null && b().isStarted() && this.f14264g;
    }

    public void f() {
        e.l.q.c.u0.a aVar;
        if (b() == null || b().isStarted() || (aVar = this.f14263f) == null || !aVar.p || getCallback() == null || this.f14264g) {
            return;
        }
        k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        e.l.q.c.u0.a aVar = this.f14263f;
        return (aVar == null || !(aVar.o || aVar.q)) ? -1 : -3;
    }

    public void h(@Nullable e.l.q.c.u0.a aVar) {
        this.f14263f = aVar;
        if (aVar != null) {
            this.b.setXfermode(new PorterDuffXfermode(this.f14263f.q ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        n();
        o();
        invalidateSelf();
    }

    public void i(float f2) {
        if (Float.compare(f2, this.f14262e) != 0) {
            if (f2 >= 0.0f || this.f14262e >= 0.0f) {
                this.f14262e = Math.min(f2, 1.0f);
                invalidateSelf();
            }
        }
    }

    public void k() {
        if (b() == null || e() || getCallback() == null || this.f14264g) {
            return;
        }
        this.f14264g = true;
        b().addUpdateListener(this.a);
    }

    public void m() {
        if (b() != null && e() && this.f14264g) {
            this.f14264g = false;
            b().removeUpdateListener(this.a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f14260c.set(rect);
        n();
        f();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
