package e.j.a.c.y;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

@Deprecated
/* loaded from: classes2.dex */
public class a extends DrawableWrapper {
    public static final double q = Math.cos(Math.toRadians(45.0d));
    public static final float r = 1.5f;
    public static final float s = 0.25f;
    public static final float t = 0.5f;
    public static final float u = 1.0f;
    @NonNull
    public final Paint a;
    @NonNull
    public final Paint b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RectF f11084c;

    /* renamed from: d  reason: collision with root package name */
    public float f11085d;

    /* renamed from: e  reason: collision with root package name */
    public Path f11086e;

    /* renamed from: f  reason: collision with root package name */
    public float f11087f;

    /* renamed from: g  reason: collision with root package name */
    public float f11088g;

    /* renamed from: h  reason: collision with root package name */
    public float f11089h;

    /* renamed from: i  reason: collision with root package name */
    public float f11090i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11091j;

    /* renamed from: k  reason: collision with root package name */
    private final int f11092k;

    /* renamed from: l  reason: collision with root package name */
    private final int f11093l;

    /* renamed from: m  reason: collision with root package name */
    private final int f11094m;
    private boolean n;
    private float o;
    private boolean p;

    public a(Context context, Drawable drawable, float f2, float f3, float f4) {
        super(drawable);
        this.f11091j = true;
        this.n = true;
        this.p = false;
        this.f11092k = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.f11093l = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.f11094m = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f11085d = Math.round(f2);
        this.f11084c = new RectF();
        Paint paint2 = new Paint(paint);
        this.b = paint2;
        paint2.setAntiAlias(false);
        p(f3, f4);
    }

    private void a(@NonNull Rect rect) {
        float f2 = this.f11088g;
        float f3 = 1.5f * f2;
        this.f11084c.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        Drawable wrappedDrawable = getWrappedDrawable();
        RectF rectF = this.f11084c;
        wrappedDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        b();
    }

    private void b() {
        float f2 = this.f11085d;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f11089h;
        rectF2.inset(-f3, -f3);
        Path path = this.f11086e;
        if (path == null) {
            this.f11086e = new Path();
        } else {
            path.reset();
        }
        this.f11086e.setFillType(Path.FillType.EVEN_ODD);
        this.f11086e.moveTo(-this.f11085d, 0.0f);
        this.f11086e.rLineTo(-this.f11089h, 0.0f);
        this.f11086e.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f11086e.arcTo(rectF, 270.0f, -90.0f, false);
        this.f11086e.close();
        float f4 = -rectF2.top;
        if (f4 > 0.0f) {
            float f5 = this.f11085d / f4;
            this.a.setShader(new RadialGradient(0.0f, 0.0f, f4, new int[]{0, this.f11092k, this.f11093l, this.f11094m}, new float[]{0.0f, f5, ((1.0f - f5) / 2.0f) + f5, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.b.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.f11092k, this.f11093l, this.f11094m}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.b.setAntiAlias(false);
    }

    public static float c(float f2, float f3, boolean z) {
        return z ? (float) (f2 + ((1.0d - q) * f3)) : f2;
    }

    public static float d(float f2, float f3, boolean z) {
        return z ? (float) ((f2 * 1.5f) + ((1.0d - q) * f3)) : f2 * 1.5f;
    }

    private void e(@NonNull Canvas canvas) {
        int i2;
        float f2;
        int i3;
        float f3;
        float f4;
        float f5;
        int save = canvas.save();
        canvas.rotate(this.o, this.f11084c.centerX(), this.f11084c.centerY());
        float f6 = this.f11085d;
        float f7 = (-f6) - this.f11089h;
        float f8 = f6 * 2.0f;
        boolean z = this.f11084c.width() - f8 > 0.0f;
        boolean z2 = this.f11084c.height() - f8 > 0.0f;
        float f9 = this.f11090i;
        float f10 = f6 / ((f9 - (0.5f * f9)) + f6);
        float f11 = f6 / ((f9 - (0.25f * f9)) + f6);
        float f12 = f6 / ((f9 - (f9 * 1.0f)) + f6);
        int save2 = canvas.save();
        RectF rectF = this.f11084c;
        canvas.translate(rectF.left + f6, rectF.top + f6);
        canvas.scale(f10, f11);
        canvas.drawPath(this.f11086e, this.a);
        if (z) {
            canvas.scale(1.0f / f10, 1.0f);
            i2 = save2;
            f2 = f12;
            i3 = save;
            f3 = f11;
            canvas.drawRect(0.0f, f7, this.f11084c.width() - f8, -this.f11085d, this.b);
        } else {
            i2 = save2;
            f2 = f12;
            i3 = save;
            f3 = f11;
        }
        canvas.restoreToCount(i2);
        int save3 = canvas.save();
        RectF rectF2 = this.f11084c;
        canvas.translate(rectF2.right - f6, rectF2.bottom - f6);
        float f13 = f2;
        canvas.scale(f10, f13);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f11086e, this.a);
        if (z) {
            canvas.scale(1.0f / f10, 1.0f);
            f4 = f3;
            f5 = f13;
            canvas.drawRect(0.0f, f7, this.f11084c.width() - f8, (-this.f11085d) + this.f11089h, this.b);
        } else {
            f4 = f3;
            f5 = f13;
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.f11084c;
        canvas.translate(rectF3.left + f6, rectF3.bottom - f6);
        canvas.scale(f10, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f11086e, this.a);
        if (z2) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f7, this.f11084c.height() - f8, -this.f11085d, this.b);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.f11084c;
        canvas.translate(rectF4.right - f6, rectF4.top + f6);
        float f14 = f4;
        canvas.scale(f10, f14);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f11086e, this.a);
        if (z2) {
            canvas.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f7, this.f11084c.height() - f8, -this.f11085d, this.b);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(i3);
    }

    private static int q(float f2) {
        int round = Math.round(f2);
        return round % 2 == 1 ? round - 1 : round;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f11091j) {
            a(getBounds());
            this.f11091j = false;
        }
        e(canvas);
        super.draw(canvas);
    }

    public float f() {
        return this.f11085d;
    }

    public float g() {
        return this.f11088g;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil(d(this.f11088g, this.f11085d, this.n));
        int ceil2 = (int) Math.ceil(c(this.f11088g, this.f11085d, this.n));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float h() {
        float f2 = this.f11088g;
        return (Math.max(f2, this.f11085d + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (this.f11088g * 1.5f * 2.0f);
    }

    public float i() {
        float f2 = this.f11088g;
        return (Math.max(f2, this.f11085d + (f2 / 2.0f)) * 2.0f) + (this.f11088g * 2.0f);
    }

    public float j() {
        return this.f11090i;
    }

    public void k(boolean z) {
        this.n = z;
        invalidateSelf();
    }

    public void l(float f2) {
        float round = Math.round(f2);
        if (this.f11085d == round) {
            return;
        }
        this.f11085d = round;
        this.f11091j = true;
        invalidateSelf();
    }

    public void m(float f2) {
        p(this.f11090i, f2);
    }

    public final void n(float f2) {
        if (this.o != f2) {
            this.o = f2;
            invalidateSelf();
        }
    }

    public void o(float f2) {
        p(f2, this.f11088g);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f11091j = true;
    }

    public void p(float f2, float f3) {
        if (f2 >= 0.0f && f3 >= 0.0f) {
            float q2 = q(f2);
            float q3 = q(f3);
            if (q2 > q3) {
                if (!this.p) {
                    this.p = true;
                }
                q2 = q3;
            }
            if (this.f11090i == q2 && this.f11088g == q3) {
                return;
            }
            this.f11090i = q2;
            this.f11088g = q3;
            this.f11089h = Math.round(q2 * 1.5f);
            this.f11087f = q3;
            this.f11091j = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("invalid shadow size");
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        super.setAlpha(i2);
        this.a.setAlpha(i2);
        this.b.setAlpha(i2);
    }
}
